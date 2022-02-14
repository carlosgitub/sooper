package miprueba;


public enum Route {
//
    A("A", 0),
    B("B", 1),
    C("C", 2),
    D("D", 3),
    E("E", 4),

    ANY("", -1),
    OPTIONAL("", -2);

    private int index;
    private String name;

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

    public int getIndex() {
        return index;
    }

}