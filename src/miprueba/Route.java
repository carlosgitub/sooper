package miprueba;


public enum Route {

    // main use of overriding enumerations
    A("A", 0),
    B("B", 1),
    C("C", 2),
    D("D", 3),
    E("E", 4),

    // represents any of a city
    ANY("", -1),
    OPTIONAL("", -2);

    // represents a city or no city
    private int index;
    private String name;

    // all case routes
    protected static final Route[][] TRAINS = {
            {A, B, C},
            {A, D},
            {A, D, C},
            {A, E, B, C, D},
            {A, E, D},
            {C, OPTIONAL, ANY, C},
            {A, ANY, ANY, ANY, C},
            {A, C},
            {B, B},
            {C, C}
    };

    // use to constructors, (graph matrix)
    static final int[][] ROUTE_TASK = {
            {0, 5, 0, 5, 7},
            {0, 0, 4, 0, 0},
            {0, 0, 0, 8, 2},
            {0, 0, 8, 0, 6},
            {0, 3, 0, 0, 0}
    };


    private Route(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public String getName() {
        return name;
    }

    /* *
     *	>= 0: normal cities.
     *	< 0: else status.
     */
    public int getIndex() {
        return index;
    }

}