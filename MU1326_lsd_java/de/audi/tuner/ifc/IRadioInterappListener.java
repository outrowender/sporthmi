/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.ifc;

import org.dsi.ifc.radio.WavebandInfo;

public interface IRadioInterappListener {
    public static final int AUDIOSTATUS_ANALOG = 1;
    public static final int AUDIOSTATUS_DIGITAL = 2;
    public static final int AUDIOSTATUS_MUTE = 3;
    public static final int AUDIOSTATUS_BALLGAME = 4;

    public void updateBandList(int[] var1);

    public void updateWavebandInfoList(WavebandInfo[] var1);

    public void updateActiveBand(int var1);

    public void updateRadioStationList(RadioStation[] var1);

    public void updateActiveStation(RadioStation var1);

    public void enforceRadio();

    public static class RadioStation {
        public long id;
        public String name;
        public String fullName;
        public String artist;
        public int artistType;
        public String title;
        public int titleType;
        public String image;
        public int audioStatus;
        public int layer;
        public String album;
        public String radioText;
        public int frequency;
        public String stationLogoUri;

        public RadioStation() {
        }

        public RadioStation(long l, String string, String string2, String string3, int n, String string4, int n2, String string5, int n3, int n4, String string6, String string7, int n5, String string8) {
            this.id = l;
            this.name = string;
            this.fullName = string2;
            this.artist = string3;
            this.artistType = n;
            this.title = string4;
            this.titleType = n2;
            this.image = string5;
            this.audioStatus = n3;
            this.layer = n4;
            this.album = string6;
            this.radioText = string7;
            this.frequency = n5;
            this.stationLogoUri = string8;
        }

        public RadioStation(long l, String string, String string2) {
            this.id = l;
            this.name = string;
            this.fullName = string2;
        }
    }
}

