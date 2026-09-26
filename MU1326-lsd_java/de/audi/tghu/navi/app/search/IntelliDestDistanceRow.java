/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.search;

import de.audi.atip.metrics.Distance;

public interface IntelliDestDistanceRow {
    default public boolean hasGeoCoordinates() {
    }

    default public void setHasGeoCoordinates(boolean bl) {
    }

    default public boolean hasRRD() {
    }

    default public void setHasRRD(boolean bl) {
    }

    default public int getLongitude() {
    }

    default public int getLatitude() {
    }

    default public void setLongitude(int n) {
    }

    default public void setLatitude(int n) {
    }

    default public void setArrowColumn(int n) {
    }

    default public void setDistanceColumn(Distance distance) {
    }

    default public void setLayoutWithDirection() {
    }
}

