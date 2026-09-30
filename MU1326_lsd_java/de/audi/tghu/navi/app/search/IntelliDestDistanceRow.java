/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.search;

import de.audi.atip.metrics.Distance;

public interface IntelliDestDistanceRow {
    public boolean hasGeoCoordinates();

    public void setHasGeoCoordinates(boolean var1);

    public boolean hasRRD();

    public void setHasRRD(boolean var1);

    public int getLongitude();

    public int getLatitude();

    public void setLongitude(int var1);

    public void setLatitude(int var1);

    public void setArrowColumn(int var1);

    public void setDistanceColumn(Distance var1);

    public void setLayoutWithDirection();
}

