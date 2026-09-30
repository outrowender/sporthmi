/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.tv;

import de.esolutions.fw.comm.asi.hmisync.tv.AudioChannel;
import de.esolutions.fw.comm.asi.hmisync.tv.ProgramInfo;
import java.util.Arrays;

public class ActiveStationInfo {
    public long id;
    public String stationName;
    public String channelName;
    public int[] stationConfig;
    public int[] stationFlags;
    public ProgramInfo currentProgram;
    public ProgramInfo nextProgram;
    public AudioChannel[] audioChannels;

    public long getId() {
        return this.id;
    }

    public void setId(long l) {
        this.id = l;
    }

    public String getStationName() {
        return this.stationName;
    }

    public void setStationName(String string) {
        this.stationName = string;
    }

    public String getChannelName() {
        return this.channelName;
    }

    public void setChannelName(String string) {
        this.channelName = string;
    }

    public int[] getStationConfig() {
        return this.stationConfig;
    }

    public void setStationConfig(int[] nArray) {
        this.stationConfig = nArray;
    }

    public int[] getStationFlags() {
        return this.stationFlags;
    }

    public void setStationFlags(int[] nArray) {
        this.stationFlags = nArray;
    }

    public ProgramInfo getCurrentProgram() {
        return this.currentProgram;
    }

    public void setCurrentProgram(ProgramInfo programInfo) {
        this.currentProgram = programInfo;
    }

    public ProgramInfo getNextProgram() {
        return this.nextProgram;
    }

    public void setNextProgram(ProgramInfo programInfo) {
        this.nextProgram = programInfo;
    }

    public AudioChannel[] getAudioChannels() {
        return this.audioChannels;
    }

    public void setAudioChannels(AudioChannel[] audioChannelArray) {
        this.audioChannels = audioChannelArray;
    }

    public ActiveStationInfo() {
        this.currentProgram = null;
        this.nextProgram = null;
        this.audioChannels = null;
    }

    public ActiveStationInfo(long l, String string, String string2, int[] nArray, int[] nArray2, ProgramInfo programInfo, ProgramInfo programInfo2, AudioChannel[] audioChannelArray) {
        this.id = l;
        this.stationName = string;
        this.channelName = string2;
        this.stationConfig = nArray;
        this.stationFlags = nArray2;
        this.currentProgram = programInfo;
        this.nextProgram = programInfo2;
        this.audioChannels = audioChannelArray;
    }

    public String toString() {
        return "ActiveStationInfo{" + "id=" + this.id + ", stationName=" + this.stationName + ", channelName=" + this.channelName + ", stationConfig=" + "[" + (this.stationConfig == null ? "null" : "size=" + this.stationConfig.length) + "]" + ", stationFlags=" + "[" + (this.stationFlags == null ? "null" : "size=" + this.stationFlags.length) + "]" + ", currentProgram=" + this.currentProgram + ", nextProgram=" + this.nextProgram + ", audioChannels=" + "[" + (this.audioChannels == null ? "null" : Arrays.asList(this.audioChannels).toString()) + "]" + "}";
    }
}

