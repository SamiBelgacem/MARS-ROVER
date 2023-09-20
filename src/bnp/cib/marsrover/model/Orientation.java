package bnp.cib.marsrover.model;

/*
/* Model class used to represent the Orientation 
 */
public enum Orientation {

    EAST("E") {
        @Override
        public Orientation left(){
            return NORTH;
        }

        @Override
        public Orientation right(){
            return SOUTH;
        }
    },

    WEST("W") {
        @Override
        public Orientation left(){
            return SOUTH;
        }

        @Override
        public Orientation right(){
            return NORTH;
        }
    },

    NORTH("N") {
        @Override
        public Orientation left(){
            return WEST;
        }

        @Override
        public Orientation right(){
            return EAST;
        }
    },

    SOUTH("S") {
        @Override
        public Orientation left(){
            return EAST;
        }

        @Override
        public Orientation right(){
            return WEST;
        }
    };

    private String orientation;

    private Orientation(String orientation) {
        this.orientation = orientation;
    }

    public abstract Orientation left();
    public abstract Orientation right();

    /* Get method used to find the Orientation using orientation sign */
    public static Orientation get(String orientationSign) {
        switch (orientationSign) {
            case "E":
                return EAST;
            case "W":
                return WEST;
            case "N":
                return NORTH;
            case "S":
                return SOUTH;
            default:
                throw new IllegalStateException("Unknown Orientation Sign");
        }
    }

    @Override
    public String toString() {
        return orientation;
    }
}
