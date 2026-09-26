/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.interapp;

import de.audi.tv.app.interapp.ITVInterappListener$AudioChannel;
import de.audi.tv.app.interapp.ITVInterappListener$ProgramInfo;

public class ITVInterappListener$ActiveStationInfo {
    public long id;
    public String stationName;
    public String channelName;
    public int normArea;
    public int videoFormat;
    public int selectedAudioChannel;
    public int caDescriptor;
    public int casStatus;
    public int parentalRating;
    public int epgFlag;
    public int teletextFlag;
    public int dataBroadcastFlag;
    public int dataBroadcast1Flag;
    public int dataBroadcast2Flag;
    public int bwsFlag;
    public int slsFlag;
    public int txtFlag;
    public int casFlag;
    public int visualAudioFlag;
    public int ewsFlag;
    public int subtitleFlag;
    public ITVInterappListener$ProgramInfo currentProgram;
    public ITVInterappListener$ProgramInfo nextProgram;
    public ITVInterappListener$AudioChannel[] audioChannels;

    public ITVInterappListener$ActiveStationInfo(long l, String string, String string2, int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10, int n11, int n12, int n13, int n14, int n15, int n16, int n17, int n18, ITVInterappListener$ProgramInfo iTVInterappListener$ProgramInfo, ITVInterappListener$ProgramInfo iTVInterappListener$ProgramInfo2, ITVInterappListener$AudioChannel[] iTVInterappListener$AudioChannelArray) {
        this.id = l;
        this.stationName = string;
        this.channelName = string2;
        this.normArea = n;
        this.videoFormat = n2;
        this.selectedAudioChannel = n3;
        this.caDescriptor = n4;
        this.casStatus = n5;
        this.parentalRating = n6;
        this.epgFlag = n7;
        this.teletextFlag = n8;
        this.dataBroadcastFlag = n9;
        this.dataBroadcast1Flag = n10;
        this.dataBroadcast2Flag = n11;
        this.bwsFlag = n12;
        this.slsFlag = n13;
        this.txtFlag = n14;
        this.casFlag = n15;
        this.visualAudioFlag = n16;
        this.ewsFlag = n17;
        this.subtitleFlag = n18;
        this.currentProgram = iTVInterappListener$ProgramInfo;
        this.nextProgram = iTVInterappListener$ProgramInfo2;
        this.audioChannels = iTVInterappListener$AudioChannelArray;
    }
}

