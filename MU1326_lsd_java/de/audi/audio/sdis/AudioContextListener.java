/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio.sdis;

import de.esolutions.fw.comm.asi.hmisync.audio.A2LSState;
import de.esolutions.fw.comm.asi.hmisync.audio.ASIHMISyncAudioReply;

public interface AudioContextListener {
    default public void updateAudioContext(int n) {
    }

    default public void updateA2LSStateDeclined(A2LSState a2LSState) {
    }

    default public void updateA2LSStateAccepted(A2LSState a2LSState) {
    }

    default public void updateA2LSStatePending(A2LSState a2LSState) {
    }

    default public void updateA2LSStateDisabled(A2LSState a2LSState) {
    }

    default public void triggerA2LSStealing(ASIHMISyncAudioReply aSIHMISyncAudioReply) {
    }
}

