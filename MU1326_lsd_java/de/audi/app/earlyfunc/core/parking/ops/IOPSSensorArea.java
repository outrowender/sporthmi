/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.parking.ops;

public interface IOPSSensorArea {
    default public void updateDistanceValues(int[] nArray) {
    }

    default public void applyStatusLvls(int[] nArray) {
    }

    default public void disableAllSectors() {
    }

    default public void enableAllSectors() {
    }

    default public void hideAllSectors() {
    }

    default public int getLeftOuterSectorIndex() {
    }

    default public int getLeftInnerSectorIndex() {
    }

    default public int getRightInnerSectorIndex() {
    }

    default public int getRightOuterSectorIndex() {
    }

    default public boolean isRear() {
    }

    default public void setRear(boolean bl) {
    }

    default public void setTrailerHitched(boolean bl) {
    }

    default public void setWallFlags(boolean[] blArray) {
    }
}

