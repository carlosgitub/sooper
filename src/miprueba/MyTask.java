package miprueba;

import static miprueba.Route.ROUTE_TASK;
import static miprueba.Route.TRAINS;

public class MyTask {


    public static void main(String[] args) {
        RouteTask routeTask = new RouteTask(ROUTE_TASK);
        int i = 0;
        for (; i < 5; i++) {
            try {
                int distance = routeTask.routeDistance(TRAINS[i]);
                System.out.printf("Output #%d: %d\n", i + 1, distance);
            } catch (Exception e) {
                System.out.printf("Output #%d: NO SUCH ROUTE\n", i + 1);
            }
        }
        for (; i < 7; i++) {
            try {
                int number = routeTask.numberOfTrips(TRAINS[i]);
                System.out.printf("Output #%d: %d\n", i + 1, number);
            } catch (Exception e) {
                System.out.printf("Output #%d: NO DATA\n", i + 1);
            }
        }
        for (; i < 9; i++) {
            try {
                int distance = routeTask.shortDistance(TRAINS[i][0], TRAINS[i][1]);
                System.out.printf("Output #%d: %d\n", i + 1, distance);
            } catch (Exception e) {
                System.out.printf("Output #%d: NO DATA\n", i + 1);
            }
        }

        try {
            int number = routeTask.numberOfRoutes(TRAINS[i][0], TRAINS[i][1], 30);
            System.out.printf("Output #%d: %d\n", ++i, number);
        } catch (Exception e) {
            System.out.printf("Output #%d: NO DATA\n", i + 1);
        }
    } private static int getI(RouteTask routeTask, int i) {
    for (; i < 5; i++) {
            try {
                int distance = routeTask.routeDistance(TRAINS[i]);
                System.out.printf("Output #%d: %d\n", i + 1, distance);
            } catch (Exception e) {
                System.out.printf("Output #%d: NO SUCH ROUTE\n", i + 1);
            }
        }
        for (; i < 7; i++) {
            try {
                int number = routeTask.numberOfTrips(TRAINS[i]);
                System.out.printf("Output #%d: %d\n", i + 1, number);
            } catch (Exception e) {
                System.out.printf("Output #%d: NO DATA\n", i + 1);
            }
        }return i;}
}
