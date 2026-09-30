/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.sdis;

public interface IHMISyncNaviReplies {
    public void updateCarPosition(CarPosition var1);

    public void replyLastDestinationList(LastDestination[] var1);

    public void replyStartRouteGuidance(int var1);

    public static class CarPosition {
        public double longitude;
        public double latitude;
        public int angle;
        public int speed;
        public int height;
    }

    public static class LastDestination {
        public int queryId;
        public int listPosition;
        public String name;
        public double longitude;
        public double latitude;
    }
}

