/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.media;

public class sActiveMediaSourceState {
    public long msg_id;
    public int terminalNumber;
    public int activeSource;
    public String videoCodec;
    public int videoResolutionVertical;
    public int videoResolutionHorizontal;
    public int videoBitrate;
    public String audioCodec;
    public int audioBitrate;
    public String pictureFormat;
    public int pictureResolutionVertical;
    public int pictureResolutionHorizontal;
    public int pictureTone;
    public int drmState;

    public long getMsg_id() {
        return this.msg_id;
    }

    public void setMsg_id(long l) {
        this.msg_id = l;
    }

    public int getTerminalNumber() {
        return this.terminalNumber;
    }

    public void setTerminalNumber(int n) {
        this.terminalNumber = n;
    }

    public int getActiveSource() {
        return this.activeSource;
    }

    public void setActiveSource(int n) {
        this.activeSource = n;
    }

    public String getVideoCodec() {
        return this.videoCodec;
    }

    public void setVideoCodec(String string) {
        this.videoCodec = string;
    }

    public int getVideoResolutionVertical() {
        return this.videoResolutionVertical;
    }

    public void setVideoResolutionVertical(int n) {
        this.videoResolutionVertical = n;
    }

    public int getVideoResolutionHorizontal() {
        return this.videoResolutionHorizontal;
    }

    public void setVideoResolutionHorizontal(int n) {
        this.videoResolutionHorizontal = n;
    }

    public int getVideoBitrate() {
        return this.videoBitrate;
    }

    public void setVideoBitrate(int n) {
        this.videoBitrate = n;
    }

    public String getAudioCodec() {
        return this.audioCodec;
    }

    public void setAudioCodec(String string) {
        this.audioCodec = string;
    }

    public int getAudioBitrate() {
        return this.audioBitrate;
    }

    public void setAudioBitrate(int n) {
        this.audioBitrate = n;
    }

    public String getPictureFormat() {
        return this.pictureFormat;
    }

    public void setPictureFormat(String string) {
        this.pictureFormat = string;
    }

    public int getPictureResolutionVertical() {
        return this.pictureResolutionVertical;
    }

    public void setPictureResolutionVertical(int n) {
        this.pictureResolutionVertical = n;
    }

    public int getPictureResolutionHorizontal() {
        return this.pictureResolutionHorizontal;
    }

    public void setPictureResolutionHorizontal(int n) {
        this.pictureResolutionHorizontal = n;
    }

    public int getPictureTone() {
        return this.pictureTone;
    }

    public void setPictureTone(int n) {
        this.pictureTone = n;
    }

    public int getDrmState() {
        return this.drmState;
    }

    public void setDrmState(int n) {
        this.drmState = n;
    }

    public sActiveMediaSourceState() {
    }

    public sActiveMediaSourceState(long l, int n, int n2, String string, int n3, int n4, int n5, String string2, int n6, String string3, int n7, int n8, int n9, int n10) {
        this.msg_id = l;
        this.terminalNumber = n;
        this.activeSource = n2;
        this.videoCodec = string;
        this.videoResolutionVertical = n3;
        this.videoResolutionHorizontal = n4;
        this.videoBitrate = n5;
        this.audioCodec = string2;
        this.audioBitrate = n6;
        this.pictureFormat = string3;
        this.pictureResolutionVertical = n7;
        this.pictureResolutionHorizontal = n8;
        this.pictureTone = n9;
        this.drmState = n10;
    }

    public String toString() {
        return "sActiveMediaSourceState{" + "msg_id=" + this.msg_id + ", terminalNumber=" + this.terminalNumber + ", activeSource=" + this.activeSource + ", videoCodec=" + this.videoCodec + ", videoResolutionVertical=" + this.videoResolutionVertical + ", videoResolutionHorizontal=" + this.videoResolutionHorizontal + ", videoBitrate=" + this.videoBitrate + ", audioCodec=" + this.audioCodec + ", audioBitrate=" + this.audioBitrate + ", pictureFormat=" + this.pictureFormat + ", pictureResolutionVertical=" + this.pictureResolutionVertical + ", pictureResolutionHorizontal=" + this.pictureResolutionHorizontal + ", pictureTone=" + this.pictureTone + ", drmState=" + this.drmState + "}";
    }
}

