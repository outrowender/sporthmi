/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.navcar;

public interface CarNavListener {
    public static final int HEADING_NORTH = 0;
    public static final int HEADING_SOUTH = 1;
    public static final int HEADING_EAST = 2;
    public static final int HEADING_WEST = 3;
    public static final int HEADING_NORTH_EAST = 4;
    public static final int HEADING_NORTH_WEST = 5;
    public static final int HEADING_SOUTH_EAST = 6;
    public static final int HEADING_SOUTH_WEST = 7;

    public void updateVehicleHeading(int var1, int var2, boolean var3);

    public void updateVehicleHeight(int var1, boolean var2);

    public void updateVehiclePosition(int var1, int var2, boolean var3);

    public void updateVehiclePositionDescription(String var1, String var2, String var3, String var4, String var5, boolean var6);
}

