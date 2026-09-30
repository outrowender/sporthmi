/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.sysapp;

public interface SpeedThresholdListener {
    public static final int CARVELOCITYTHRESHOLD = 1;
    public static final int TVVELOCITYTHRESHOLD = 2;
    public static final int HDDVELOCITYTHRESHOLD = 3;
    public static final int BROWSERSLIDESHOWVELOCITYTHRESHOLD = 4;
    public static final int BROWSERBORDBOOKVELOCITYTHRESHOLD = 5;
    public static final int BROWSERTRAVELAGENTVELOCITYTHRESHOLD = 6;
    public static final int BROWSERWEBVELOCITYTHRESHOLD = 7;
    public static final int BWSVELOCITYTHRESHOLD = 8;
    public static final int RADIOTEXTVELOCITYTHRESHOLD = 9;
    public static final int BTBONDINGVELOCITYTHRESHOLD = 10;
    public static final int MESSAGINGVELOCITYTHRESHOLD = 11;
    public static final int DESTINATIONINPUTVELOCITYTHRESHOLD = 12;

    public void exceedsUpperThreshold(int var1);

    public void belowLowerThreshold(int var1);
}

