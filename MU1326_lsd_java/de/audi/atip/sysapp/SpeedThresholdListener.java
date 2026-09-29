/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.sysapp;

public interface SpeedThresholdListener {
    public static final int CARVELOCITYTHRESHOLD;
    public static final int TVVELOCITYTHRESHOLD;
    public static final int HDDVELOCITYTHRESHOLD;
    public static final int BROWSERSLIDESHOWVELOCITYTHRESHOLD;
    public static final int BROWSERBORDBOOKVELOCITYTHRESHOLD;
    public static final int BROWSERTRAVELAGENTVELOCITYTHRESHOLD;
    public static final int BROWSERWEBVELOCITYTHRESHOLD;
    public static final int BWSVELOCITYTHRESHOLD;
    public static final int RADIOTEXTVELOCITYTHRESHOLD;
    public static final int BTBONDINGVELOCITYTHRESHOLD;
    public static final int MESSAGINGVELOCITYTHRESHOLD;
    public static final int DESTINATIONINPUTVELOCITYTHRESHOLD;

    default public void exceedsUpperThreshold(int n) {
    }

    default public void belowLowerThreshold(int n) {
    }
}

