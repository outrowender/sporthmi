/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.slidinglist.poi;

import org.dsi.ifc.navigation.PosPosition;

public interface DistanceDifferentiationRow {
    public static final int RRDICON_OFFSET = 8;

    public void setAirDistance(int var1);

    public void setRRDDistance(int var1);

    public void reformatDistance();

    public int getDistance();

    public boolean isMarkedAsRRD();

    public void setDirection(int var1);

    public int getDirection();

    public int getLongitude();

    public int getLatitude();

    public void updateDirection(PosPosition var1);

    public void updateAirDistance(PosPosition var1);
}

