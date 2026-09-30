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
import de.esolutions.fw.comm.core.method.MethodException;

public class NullASIHMISyncAudioReply
extends NullService
implements ASIHMISyncAudioReply {
    public NullASIHMISyncAudioReply() {
        super(NullLogChannel.getInstance(), "NullASIHMISyncAudioReply");
    }

    public NullASIHMISyncAudioReply(LogChannel logChannel) {
        super(logChannel, "NullASIHMISyncAudioReply");
    }

    public void responseEnableA2LS(int n) throws MethodException {
        this.log("responseEnableA2LS");
    }

    public void updateASIVersion(String string, boolean bl) throws MethodException {
        this.log("updateASIVersion");
    }

    public void updateAudioContext(AudioState audioState, boolean bl) throws MethodException {
        this.log("updateAudioContext");
    }

    public void updateVolumeLockState(VolumeLockState volumeLockState, boolean bl) throws MethodException {
        this.log("updateVolumeLockState");
    }

    public void updateA2LSState(A2LSState a2LSState, boolean bl) throws MethodException {
        this.log("updateA2LSState");
    }

    public void updateAudibleState(int n, boolean bl) throws MethodException {
        this.log("updateAudibleState");
    }

    public void updateFrontAudioContext(AudioState audioState, boolean bl) throws MethodException {
        this.log("updateFrontAudioContext");
    }

    public void updateVolumeRange(VolumeRange volumeRange, boolean bl) throws MethodException {
        this.log("updateVolumeRange");
    }

    public void updateVolume(int n, boolean bl) throws MethodException {
        this.log("updateVolume");
    }

    public void updateIsAudible(boolean bl, boolean bl2) throws MethodException {
        this.log("updateIsAudible");
    }

    public void updateRequestIDs(short[] sArray, boolean bl) throws MethodException {
        this.log("updateRequestIDs");
    }

    public void updateReplyIDs(short[] sArray, boolean bl) throws MethodException {
        this.log("updateReplyIDs");
    }
}

