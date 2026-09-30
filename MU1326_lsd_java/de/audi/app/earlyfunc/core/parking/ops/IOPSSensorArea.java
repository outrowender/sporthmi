/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.parking.ops;

public interface IOPSSensorArea {
    public void updateDistanceValues(int[] var1);

    public void applyStatusLvls(int[] var1);

    public void disableAllSectors();

    public void enableAllSectors();

    public void hideAllSectors();

    public int getLeftOuterSectorIndex();

    public int getLeftInnerSectorIndex();

    public int getRightInnerSectorIndex();

    public int getRightOuterSectorIndex();

    public boolean isRear();

    public void setRear(boolean var1);

    public void setTrailerHitched(boolean var1);

    public void setWallFlags(boolean[] var1);
}

