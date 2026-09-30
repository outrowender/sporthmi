/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.sdis;

public interface IHMISyncRadioReplies {
    public void updateBandList(RadioNameIdPair[] var1);

    public void updateActiveBand(int var1);

    public void updateRadioStationList(RadioStationInfo[] var1);

    public void updateActiveStation(int var1);

    public void updateActiveStationInfo(String[] var1);

    public void updateSlideshowInfo(String var1);

    public static class RadioNameIdPair {
        public int id;
        public String name;
    }

    public static class RadioStationInfo {
        public int id;
        public String name;
        public String info;
    }
}

