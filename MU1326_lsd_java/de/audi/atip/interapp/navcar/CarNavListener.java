/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.navcar;

public interface CarNavListener {
    public static final int HEADING_NORTH;
    public static final int HEADING_SOUTH;
    public static final int HEADING_EAST;
    public static final int HEADING_WEST;
    public static final int HEADING_NORTH_EAST;
    public static final int HEADING_NORTH_WEST;
    public static final int HEADING_SOUTH_EAST;
    public static final int HEADING_SOUTH_WEST;

    default public void updateVehicleHeading(int n, int n2, boolean bl) {
    }

    default public void updateVehicleHeight(int n, boolean bl) {
    }

    default public void updateVehiclePosition(int n, int n2, boolean bl) {
    }

    default public void updateVehiclePositionDescription(String string, String string2, String string3, String string4, String string5, boolean bl) {
    }
}

