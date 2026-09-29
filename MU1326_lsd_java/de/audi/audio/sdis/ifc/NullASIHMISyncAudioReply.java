/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio.sdis.ifc;

import de.audi.atip.interapp.def.NullService;
import de.audi.atip.log.LogChannel;
import de.audi.atip.log.NullLogChannel;
import de.esolutions.fw.comm.asi.hmisync.audio.A2LSState;
import de.esolutions.fw.comm.asi.hmisync.audio.ASIHMISyncAudioReply;
import de.esolutions.fw.comm.asi.hmisync.audio.AudioState;
import de.esolutions.fw.comm.asi.hmisync.audio.VolumeLockState;
import de.esolutions.fw.comm.asi.hmisync.audio.VolumeRange;

public class NullASIHMISyncAudioReply
extends NullService
implements ASIHMISyncAudioReply {
    public NullASIHMISyncAudioReply() {
        super(NullLogChannel.getInstance(), "NullASIHMISyncAudioReply");
    }

    public NullASIHMISyncAudioReply(LogChannel logChannel) {
        super(logChannel, "NullASIHMISyncAudioReply");
    }

    @Override
    public void responseEnableA2LS(int n) {
        this.log("responseEnableA2LS");
    }

    @Override
    public void updateASIVersion(String string, boolean bl) {
        this.log("updateASIVersion");
    }

    @Override
    public void updateAudioContext(AudioState audioState, boolean bl) {
        this.log("updateAudioContext");
    }

    @Override
    public void updateVolumeLockState(VolumeLockState volumeLockState, boolean bl) {
        this.log("updateVolumeLockState");
    }

    @Override
    public void updateA2LSState(A2LSState a2LSState, boolean bl) {
        this.log("updateA2LSState");
    }

    @Override
    public void updateAudibleState(int n, boolean bl) {
        this.log("updateAudibleState");
    }

    @Override
    public void updateFrontAudioContext(AudioState audioState, boolean bl) {
        this.log("updateFrontAudioContext");
    }

    @Override
    public void updateVolumeRange(VolumeRange volumeRange, boolean bl) {
        this.log("updateVolumeRange");
    }

    @Override
    public void updateVolume(int n, boolean bl) {
        this.log("updateVolume");
    }

    public void updateIsAudible(boolean bl, boolean bl2) {
        this.log("updateIsAudible");
    }

    @Override
    public void updateRequestIDs(short[] sArray, boolean bl) {
        this.log("updateRequestIDs");
    }

    @Override
    public void updateReplyIDs(short[] sArray, boolean bl) {
        this.log("updateReplyIDs");
    }
}

