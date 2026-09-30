/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio.sdis.ifc;

import de.audi.atip.interapp.IBluetoothA2LSService;
import de.audi.atip.interapp.def.NullService;
import de.audi.atip.log.LogChannel;
import de.audi.audio.sdis.ifc.SdisAudioService;
import de.esolutions.fw.comm.asi.hmisync.audio.ASIHMISyncAudioReply;

public class NullSdisAudioService
extends NullService
implements SdisAudioService {
    public NullSdisAudioService(LogChannel logChannel) {
        super(logChannel, "SDISAudioService");
    }

    public void setAudioContext(int n, ASIHMISyncAudioReply aSIHMISyncAudioReply) {
        this.log("setAudioContext");
    }

    public void setAudioContext(int n) {
        this.log("setAudioContext");
    }

    public void setBluetoothService(IBluetoothA2LSService iBluetoothA2LSService) {
        this.log("setBluetoothService");
    }

    public void unjoinActiveAudioContext(ASIHMISyncAudioReply aSIHMISyncAudioReply) {
        this.log("unjoinActiveAudioContext");
    }

    public void joinActiveAudioContext(ASIHMISyncAudioReply aSIHMISyncAudioReply) {
        this.log("joinActiveAudioContext");
    }

    public void enableA2LS(String string, ASIHMISyncAudioReply aSIHMISyncAudioReply) {
        this.log("enableA2LS");
    }

    public void disableA2LSFromHU() {
        this.log("disableA2LSFromHU");
    }

    public void setVolume(int n) {
        this.log("setVolume");
    }

    public void increaseVolume(int n) {
        this.log("increaseVolume");
    }

    public void decreaseVolume(int n) {
        this.log("decreaseVolume");
    }

    public void forceFrontAudioContext(int n, ASIHMISyncAudioReply aSIHMISyncAudioReply) {
        this.log("decreaseVolume");
    }

    public void registerReplyProxy(ASIHMISyncAudioReply aSIHMISyncAudioReply) {
        this.log("registerReplyProxy");
    }

    public void removeReplyProxy(ASIHMISyncAudioReply aSIHMISyncAudioReply) {
        this.log("removeReplyProxy");
    }

    public void disableA2LSFromSDIS(ASIHMISyncAudioReply aSIHMISyncAudioReply) {
        this.log("removeReplyProxy");
    }
}

