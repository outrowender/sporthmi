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

    @Override
    public void setAudioContext(int n, ASIHMISyncAudioReply aSIHMISyncAudioReply) {
        this.log("setAudioContext");
    }

    @Override
    public void setAudioContext(int n) {
        this.log("setAudioContext");
    }

    @Override
    public void setBluetoothService(IBluetoothA2LSService iBluetoothA2LSService) {
        this.log("setBluetoothService");
    }

    @Override
    public void unjoinActiveAudioContext(ASIHMISyncAudioReply aSIHMISyncAudioReply) {
        this.log("unjoinActiveAudioContext");
    }

    @Override
    public void joinActiveAudioContext(ASIHMISyncAudioReply aSIHMISyncAudioReply) {
        this.log("joinActiveAudioContext");
    }

    @Override
    public void enableA2LS(String string, ASIHMISyncAudioReply aSIHMISyncAudioReply) {
        this.log("enableA2LS");
    }

    @Override
    public void disableA2LSFromHU() {
        this.log("disableA2LSFromHU");
    }

    @Override
    public void setVolume(int n) {
        this.log("setVolume");
    }

    @Override
    public void increaseVolume(int n) {
        this.log("increaseVolume");
    }

    @Override
    public void decreaseVolume(int n) {
        this.log("decreaseVolume");
    }

    @Override
    public void forceFrontAudioContext(int n, ASIHMISyncAudioReply aSIHMISyncAudioReply) {
        this.log("decreaseVolume");
    }

    @Override
    public void registerReplyProxy(ASIHMISyncAudioReply aSIHMISyncAudioReply) {
        this.log("registerReplyProxy");
    }

    @Override
    public void removeReplyProxy(ASIHMISyncAudioReply aSIHMISyncAudioReply) {
        this.log("removeReplyProxy");
    }

    @Override
    public void disableA2LSFromSDIS(ASIHMISyncAudioReply aSIHMISyncAudioReply) {
        this.log("removeReplyProxy");
    }
}

