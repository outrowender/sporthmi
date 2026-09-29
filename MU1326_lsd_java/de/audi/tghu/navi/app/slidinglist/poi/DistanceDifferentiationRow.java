/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.slidinglist.poi;

import org.dsi.ifc.navigation.PosPosition;

public interface DistanceDifferentiationRow {
    public static final int RRDICON_OFFSET;

    default public void setAirDistance(int n) {
    }

    default public void setRRDDistance(int n) {
    }

    default public void reformatDistance() {
    }

    default public int getDistance() {
    }

    default public boolean isMarkedAsRRD() {
    }

    default public void setDirection(int n) {
    }

    default public int getDirection() {
    }

    default public int getLongitude() {
    }

    default public int getLatitude() {
    }

    default public void updateDirection(PosPosition posPosition) {
    }

    default public void updateAirDistance(PosPosition posPosition) {
    }
}

