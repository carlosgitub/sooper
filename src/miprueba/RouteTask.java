package miprueba;

import static miprueba.Route.OPTIONAL;

public class RouteTask {
    protected int[][] circuit;

    public RouteTask(int[][] circuit) {
        this.circuit = circuit;
    }

    public int routeDistance(Route[] route) throws Exception {
        int distance = 0;

        int idx1 = route[0].getIndex();
        int idx2;
        for (int i = 1; i < route.length; i++) {
            idx2 = route[i].getIndex();
            if (circuit[idx1][idx2] == 0) {
                throw new Exception();
            }
            distance += circuit[idx1][idx2];
            idx1 = idx2;
        }
        return distance;
    }



    public int numberOfTrips(Route[] route) {
        return numberOfTrips(route, 0);
    }

    public int shortDistance(Route origin, Route dest) {
        boolean[][] flags = new boolean[circuit.length][circuit.length];
        int shortest = shortDistance(origin.getIndex(), dest.getIndex(), flags, 0, 0, origin == dest);
        return shortest;
    }

    public int numberOfRoutes(Route origin, Route dest, int maxDistance) {
        int number = numberOfRoutes(origin.getIndex(), dest.getIndex(), maxDistance, 0, origin == dest);
        return number;
    }

    private int numberOfTrips(Route[] route, int offset) {
        // we are at the last city on the route.
        if (offset == route.length - 1) return 1;
        // try to go forward to next city.
        Route start = route[offset];
        Route next = route[offset + 1];
        int number = 0;
        int idx1, idx2;
        if (start.getIndex() < 0) {
            for (Route city : Route.values()) {
                number = getNumber(route, offset, number, city);
            }
            if (start == OPTIONAL) {
                number += numberOfTrips(route, offset + 1);
            }
            route[offset] = start;

        } else {
            idx1 = start.getIndex();
            if (next.getIndex() < 0) {
                for (Route city : Route.values()) {
                    if (city.getIndex() >= 0) {
                        route[offset + 1] = city;
                        number += numberOfTrips(route, offset);
                    }
                }

                if (next == OPTIONAL) {
                    route[offset + 1] = start;
                    number += numberOfTrips(route, offset + 1);
                }
                route[offset + 1] = next;
            } else {
                idx2 = next.getIndex();
                number = circuit[idx1][idx2] == 0 ? 0 : numberOfTrips(route, offset + 1);
            }

        }
        return number;
    }

    private int getNumber(Route[] route, int offset, int number, Route city) {
        if (city.getIndex() >= 0) {
            route[offset] = city;
            number += numberOfTrips(route, offset);
        }
        return number;
    }

    private int shortDistance(int origin, int dest, boolean[][] flags, int shortest, int distance, boolean sameCity) {
        if (!sameCity && origin == dest) return distance;
        int currentDistance;
        for (int next = 0; next < circuit.length; next++) {
            if (!flags[origin][next] && circuit[origin][next] != 0) {
                flags[origin][next] = true;
                currentDistance = shortDistance(next, dest, flags, 0, distance + circuit[origin][next], false);
                if (currentDistance != 0 && (shortest == 0 || currentDistance < shortest)) {
                    shortest = currentDistance;
                }
                flags[origin][next] = false;
            }
        }
        return shortest;
    }

    private int numberOfRoutes(int origin, int dest, final int maxDistance, int distance, boolean sameCity) {
        if (distance >= maxDistance) return 0;
        int number = 0;
        if (!sameCity && origin == dest && distance < maxDistance) {
            number++;
        }
        for (int next = 0; next < circuit.length; next++) {
            if (circuit[origin][next] != 0) {
                number += numberOfRoutes(next, dest, maxDistance, distance + circuit[origin][next], false);
            }
        }
        return number;
    }
}
