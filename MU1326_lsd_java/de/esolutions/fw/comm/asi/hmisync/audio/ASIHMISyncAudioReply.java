/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.audio;

import de.esolutions.fw.comm.asi.hmisync.audio.A2LSState;
import de.esolutions.fw.comm.asi.hmisync.audio.AudioState;
import de.esolutions.fw.comm.asi.hmisync.audio.VolumeLockState;
import de.esolutions.fw.comm.asi.hmisync.audio.VolumeRange;
import de.esolutions.fw.comm.core.method.MethodException;

public interface ASIHMISyncAudioReply {
    public static final String IPL_COMM_UUID = "cd52f5cc-371d-43de-8bc4-c3df1c55f44a";
    public static final String IPL_COMM_INTERFACE_KEY = "0c5e00e4-2cbf-5dfc-acd3-5499fe013c7f";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.3.00";
    public static final String IPL_COMM_MODULE_VERSION = "1.0.00";

    public void responseEnableA2LS(int var1) throws MethodException;

    public void updateASIVersion(String var1, boolean var2) throws MethodException;

    public void updateRequestIDs(short[] var1, boolean var2) throws MethodException;

    public void updateReplyIDs(short[] var1, boolean var2) throws MethodException;

    public void updateAudioContext(AudioState var1, boolean var2) throws MethodException;

    public void updateFrontAudioContext(AudioState var1, boolean var2) throws MethodException;

    public void updateVolumeLockState(VolumeLockState var1, boolean var2) throws MethodException;

    public void updateA2LSState(A2LSState var1, boolean var2) throws MethodException;

    public void updateVolumeRange(VolumeRange var1, boolean var2) throws MethodException;

    public void updateVolume(int var1, boolean var2) throws MethodException;

    public void updateAudibleState(int var1, boolean var2) throws MethodException;
}

