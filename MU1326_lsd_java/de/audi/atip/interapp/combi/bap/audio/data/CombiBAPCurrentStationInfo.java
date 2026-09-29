/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.combi.bap.audio.data;

import de.esolutions.fw.util.commons.Buffer;

public final class CombiBAPCurrentStationInfo {
    private static final String EMPTY_STRING;
    private String primaryInformation;
    private int primaryInformationType;
    private int primaryInformationID;
    private String secondaryInformation;
    private int secondaryInformationType;
    private String tertiaryInformation;
    private int tertiaryInformationType;
    private String quaternaryInformation;
    private int quaternaryInformationType;
    private int channelID = 0;
    public static final int ATTRIBUTE_IBOC_HD_RADIO_AVAILABLE;
    public static final int ATTRIBUTE_VICS_AVAILABLE;
    public static final int ATTRIBUTE_TMC_AVAILABLE;
    public static final int ATTRIBUTE_TA_TP_AVAILABLE;
    public static final int ATTRIBUTE_DAB_SERVICE_LINKED_TO_FM;
    public static final int ATTRIBUTE_IBOC_LIVE_TRANSMISSION_ACTIVE_HD_LIVE_MODE;
    public static final int ATTRIBUTE_DAB_SERVICE_DOES_NOT_CONTAIN_ANY_AUDIO_SIGNAL;
    public static final int ATTRIBUTE_STATION_LINKED_TO_ONLINE_RADIO;
    private int attributes;
    private int listRef = -65536;
    private int listAbsolutePosition = 0;
    private int presetListRef = 0;
    private int presetListAbsolutePosition = 0;
    private int dabEnsembleHandle = 0;
    private int dabEnsembleAbsolutePosition = 0;
    private int commonListRef = -65536;
    private int commonListAbsolutePosition = 0;
    private String pictureURL;
    private int pictureID = -1;

    public CombiBAPCurrentStationInfo() {
        this("", 0);
    }

    public CombiBAPCurrentStationInfo(String string, int n) {
        this(string, n, 0);
    }

    public CombiBAPCurrentStationInfo(String string, int n, int n2) {
        this.primaryInformation = string;
        this.primaryInformationType = n;
        this.primaryInformationID = n2;
        this.secondaryInformation = "";
        this.secondaryInformationType = 0;
        this.tertiaryInformation = "";
        this.tertiaryInformationType = 0;
        this.quaternaryInformation = "";
        this.quaternaryInformationType = 0;
    }

    public CombiBAPCurrentStationInfo(String string, int n, int n2, int n3, int n4) {
        this(string, n, n2);
        this.listRef = n3;
        this.listAbsolutePosition = n4;
    }

    public CombiBAPCurrentStationInfo(String string, int n, String string2, int n2, String string3, int n3, String string4, int n4) {
        this(string, n, string2, n2, string3, n3, string4, n4, -1, -1);
    }

    public CombiBAPCurrentStationInfo(String string, int n, String string2, int n2, String string3, int n3, String string4, int n4, int n5, int n6) {
        this.primaryInformation = string;
        this.primaryInformationType = n;
        this.secondaryInformation = string2;
        this.secondaryInformationType = n2;
        this.tertiaryInformation = string3;
        this.tertiaryInformationType = n3;
        this.quaternaryInformation = string4;
        this.quaternaryInformationType = n4;
        this.listRef = n5;
        this.listAbsolutePosition = n6;
    }

    public void setPrimaryInformation(String string, int n, int n2) {
        this.primaryInformation = string != null ? string : "";
        this.primaryInformationType = n;
        this.primaryInformationID = n2;
    }

    public String getPrimaryInformation() {
        return this.primaryInformation;
    }

    public int getPrimaryInformationType() {
        return this.primaryInformationType;
    }

    public int getPrimaryInformationID() {
        return this.primaryInformationID;
    }

    public void setSecondaryInformation(String string, int n) {
        this.secondaryInformation = string != null ? string : "";
        this.secondaryInformationType = n;
    }

    public String getSecondaryInformation() {
        return this.secondaryInformation;
    }

    public int getSecondaryInformationType() {
        return this.secondaryInformationType;
    }

    public void setTertiaryInformation(String string, int n) {
        this.tertiaryInformation = string != null ? string : "";
        this.tertiaryInformationType = n;
    }

    public String getTertiaryInformation() {
        return this.tertiaryInformation;
    }

    public int getTertiaryInformationType() {
        return this.tertiaryInformationType;
    }

    public void setQuaternaryInformation(String string, int n) {
        this.quaternaryInformation = string != null ? string : "";
        this.quaternaryInformationType = n;
    }

    public String getQuaternaryInformation() {
        return this.quaternaryInformation;
    }

    public int getQuaternaryInformationType() {
        return this.quaternaryInformationType;
    }

    public int getChannelID() {
        return this.channelID;
    }

    public void setChannelID(int n) {
        this.channelID = n;
    }

    public boolean hasAttribute(int n) {
        return (this.attributes & n) == n;
    }

    public void setAttributes(int n) {
        this.attributes = n;
    }

    public int getAttributes() {
        return this.attributes;
    }

    public void addAttribute(int n) {
        this.attributes |= n;
    }

    public int getListRef() {
        return this.listRef;
    }

    public void setListRef(int n) {
        this.listRef = n;
    }

    public int getListAbsolutePosition() {
        return this.listAbsolutePosition;
    }

    public void setListAbsolutePosition(int n) {
        this.listAbsolutePosition = n;
    }

    public int getPresetListRef() {
        return this.presetListRef;
    }

    public void setPresetListRef(int n) {
        this.presetListRef = n;
    }

    public int getPresetListAbsolutePosition() {
        return this.presetListAbsolutePosition;
    }

    public void setPresetListAbsolutePosition(int n) {
        this.presetListAbsolutePosition = n;
    }

    public int getDabEnsembleHandle() {
        return this.dabEnsembleHandle;
    }

    public void setDabEnsembleHandle(int n) {
        this.dabEnsembleHandle = n;
    }

    public int getDabEnsembleAbsolutePosition() {
        return this.dabEnsembleAbsolutePosition;
    }

    public void setDabEnsembleAbsolutePosition(int n) {
        this.dabEnsembleAbsolutePosition = n;
    }

    public int getCommonListRef() {
        return this.commonListRef;
    }

    public void setCommonListRef(int n) {
        this.commonListRef = n;
    }

    public int getCommonListAbsolutePosition() {
        return this.commonListAbsolutePosition;
    }

    public void setCommonListAbsolutePosition(int n) {
        this.commonListAbsolutePosition = n;
    }

    public String getPictureURL() {
        return this.pictureURL;
    }

    public void setPictureURL(String string) {
        this.pictureURL = string;
    }

    public int getPictureID() {
        return this.pictureID;
    }

    public void setPictureID(int n) {
        this.pictureID = n;
    }

    public void setPicture(int n, String string) {
        this.pictureID = n;
        this.pictureURL = string;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append(this.primaryInformation);
        buffer.append(" - type=").append(this.primaryInformationType);
        if (this.secondaryInformation != null) {
            buffer.append(", si=").append(this.secondaryInformation);
            buffer.append(" - type=").append(this.secondaryInformationType);
        }
        if (this.tertiaryInformation != null) {
            buffer.append(", ti=").append(this.tertiaryInformation);
            buffer.append(" - type=").append(this.tertiaryInformationType);
        }
        if (this.quaternaryInformation != null) {
            buffer.append(", qi=").append(this.quaternaryInformation);
            buffer.append(" - type=").append(this.quaternaryInformationType);
        }
        buffer.append(", id=").append(this.primaryInformationID);
        buffer.append(", listRef=").append(this.listRef);
        buffer.append(", listAbsPos=").append(this.listAbsolutePosition);
        if (this.presetListRef > -1) {
            buffer.append(", presetListRef=").append(this.presetListRef);
            buffer.append(", presetListAbsPos=").append(this.presetListAbsolutePosition);
        }
        if (this.dabEnsembleHandle > -1) {
            buffer.append(", dabEnsembleHandle=").append(this.dabEnsembleHandle);
            buffer.append(", dabEnsembleHandleAbsPos=").append(this.dabEnsembleAbsolutePosition);
        }
        buffer.append(", pictureURL=").append(this.pictureURL);
        buffer.append(", pictureID=").append(this.pictureID);
        buffer.append(", attributes=").append(this.attributes);
        return buffer.toString();
    }
}

