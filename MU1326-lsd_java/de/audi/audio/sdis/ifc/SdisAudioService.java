/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio.sdis.ifc;

import de.audi.atip.interapp.IBluetoothA2LSService;
import de.esolutions.fw.comm.asi.hmisync.audio.ASIHMISyncAudioReply;

public interface SdisAudioService {
    default public void setAudioContext(int n, ASIHMISyncAudioReply aSIHMISyncAudioReply) {
    }

    default public void setAudioContext(int n) {
    }

    default public void setBluetoothService(IBluetoothA2LSService iBluetoothA2LSService) {
    }

    default public void unjoinActiveAudioContext(ASIHMISyncAudioReply aSIHMISyncAudioReply) {
    }

    default public void joinActiveAudioContext(ASIHMISyncAudioReply aSIHMISyncAudioReply) {
    }

    default public void enableA2LS(String string, ASIHMISyncAudioReply aSIHMISyncAudioReply) {
    }

    default public void disableA2LSFromSDIS(ASIHMISyncAudioReply aSIHMISyncAudioReply) {
    }

    default public void disableA2LSFromHU() {
    }

    default public void setVolume(int n) {
    }

    default public void increaseVolume(int n) {
    }

    default public void decreaseVolume(int n) {
    }

    default public void forceFrontAudioContext(int n, ASIHMISyncAudioReply aSIHMISyncAudioReply) {
    }

    default public void registerReplyProxy(ASIHMISyncAudioReply aSIHMISyncAudioReply) {
    }

    default public void removeReplyProxy(ASIHMISyncAudioReply aSIHMISyncAudioReply) {
    }
}

