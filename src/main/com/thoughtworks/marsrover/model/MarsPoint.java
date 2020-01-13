package com.thoughtworks.marsrover.model;

public class MarsPoint {
    public int marsX = 0;
    public int marsY = 0;

    public MarsPoint(int x, int y) {
        marsX = x; marsY = y;
    }

    @Override
    public boolean equals(Object obj){
        if (obj == null || obj.getClass() != this.getClass()){
            return false;
        }

        MarsPoint newOne = (MarsPoint)obj;
        return this.marsY == newOne.marsY && this.marsX == newOne.marsX;
    }

    @Override
    public int hashCode(){
        return 0;
    }
}
