package miprueba;

import static miprueba.Route.ROUTE_TASK;
import static miprueba.Route.TRAINS;

public class MyTask {


    public static void main(String[] args) {

        RouteTask routeTask = new RouteTask(ROUTE_TASK);
        int i = 0;

        // case 1..5. The distance of route
        for (; i < 5; i++) {
            try {
                int distance = routeTask.routeDistance(TRAINS[i]);
                System.out.printf("Output #%d: %d\n", i + 1, distance);
            } catch (Exception e) {
                System.out.printf("Output #%d: NO SUCH ROUTE\n", i + 1);
            }
        }

        // case 6..7. The number of trips
        for (; i < 7; i++) {
            try {
                int number = routeTask.numberOfTrips(TRAINS[i]);
                System.out.printf("Output #%d: %d\n", i + 1, number);
            } catch (Exception e) {
                System.out.printf("Output #%d: NO DATA\n", i + 1);
            }
        }

        // case 8..9. The length of the shortest route
        for (; i < 9; i++) {
            try {
                int distance = routeTask.shortDistance(TRAINS[i][0], TRAINS[i][1]);
                System.out.printf("Output #%d: %d\n", i + 1, distance);
            } catch (Exception e) {
                System.out.printf("Output #%d: NO DATA\n", i + 1);
            }
        }

        //case l0. The number of different routes with a distance of less than 30
        try {
            int number = routeTask.numberOfRoutes(TRAINS[i][0], TRAINS[i][1], 30);
            System.out.printf("Output #%d: %d\n", ++i, number);
        } catch (Exception e) {
            System.out.printf("Output #%d: NO DATA\n", i + 1);
        }
    }
}
