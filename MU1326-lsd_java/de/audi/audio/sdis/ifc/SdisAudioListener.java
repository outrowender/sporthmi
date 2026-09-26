/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio.sdis.ifc;

import de.esolutions.fw.comm.asi.hmisync.audio.A2LSState;
import de.esolutions.fw.comm.asi.hmisync.audio.AudioState;
import de.esolutions.fw.comm.asi.hmisync.audio.VolumeLockState;
import de.esolutions.fw.comm.asi.hmisync.audio.VolumeRange;

public interface SdisAudioListener {
    default public void updateAudioContext(AudioState audioState) {
    }

    default public void updateVolumeRange(VolumeRange volumeRange) {
    }

    default public void updateVolume(int n) {
    }

    default public void updateFrontAudioContext(AudioState audioState) {
    }

    default public void updateAudibleState(int n) {
    }

    default public void updateA2LSState(A2LSState a2LSState) {
    }

    default public void updateVolumeLockState(VolumeLockState volumeLockState) {
    }
}

