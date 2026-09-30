/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio.sdis.ifc;

import de.esolutions.fw.comm.asi.hmisync.audio.A2LSState;
import de.esolutions.fw.comm.asi.hmisync.audio.AudioState;
import de.esolutions.fw.comm.asi.hmisync.audio.VolumeLockState;
import de.esolutions.fw.comm.asi.hmisync.audio.VolumeRange;

public interface SdisAudioListener {
    public void updateAudioContext(AudioState var1);

    public void updateVolumeRange(VolumeRange var1);

    public void updateVolume(int var1);

    public void updateFrontAudioContext(AudioState var1);

    public void updateAudibleState(int var1);

    public void updateA2LSState(A2LSState var1);

    public void updateVolumeLockState(VolumeLockState var1);
}

