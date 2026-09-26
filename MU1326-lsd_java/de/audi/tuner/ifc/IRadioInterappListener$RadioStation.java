/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.ifc;

public class IRadioInterappListener$RadioStation {
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

    public IRadioInterappListener$RadioStation() {
    }

    public IRadioInterappListener$RadioStation(long l, String string, String string2, String string3, int n, String string4, int n2, String string5, int n3, int n4, String string6, String string7, int n5, String string8) {
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

    public IRadioInterappListener$RadioStation(long l, String string, String string2) {
        this.id = l;
        this.name = string;
        this.fullName = string2;
    }
}

