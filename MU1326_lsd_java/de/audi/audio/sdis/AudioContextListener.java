/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio.sdis;

import de.esolutions.fw.comm.asi.hmisync.audio.A2LSState;
import de.esolutions.fw.comm.asi.hmisync.audio.ASIHMISyncAudioReply;

public interface AudioContextListener {
    public void updateAudioContext(int var1);

    public void updateA2LSStateDeclined(A2LSState var1);

    public void updateA2LSStateAccepted(A2LSState var1);

    public void updateA2LSStatePending(A2LSState var1);

    public void updateA2LSStateDisabled(A2LSState var1);

    public void triggerA2LSStealing(ASIHMISyncAudioReply var1);
}

