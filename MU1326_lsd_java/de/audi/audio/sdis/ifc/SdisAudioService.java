/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio.sdis.ifc;

import de.audi.atip.interapp.IBluetoothA2LSService;
import de.esolutions.fw.comm.asi.hmisync.audio.ASIHMISyncAudioReply;

public interface SdisAudioService {
    public void setAudioContext(int var1, ASIHMISyncAudioReply var2);

    public void setAudioContext(int var1);

    public void setBluetoothService(IBluetoothA2LSService var1);

    public void unjoinActiveAudioContext(ASIHMISyncAudioReply var1);

    public void joinActiveAudioContext(ASIHMISyncAudioReply var1);

    public void enableA2LS(String var1, ASIHMISyncAudioReply var2);

    public void disableA2LSFromSDIS(ASIHMISyncAudioReply var1);

    public void disableA2LSFromHU();

    public void setVolume(int var1);

    public void increaseVolume(int var1);

    public void decreaseVolume(int var1);

    public void forceFrontAudioContext(int var1, ASIHMISyncAudioReply var2);

    public void registerReplyProxy(ASIHMISyncAudioReply var1);

    public void removeReplyProxy(ASIHMISyncAudioReply var1);
}

