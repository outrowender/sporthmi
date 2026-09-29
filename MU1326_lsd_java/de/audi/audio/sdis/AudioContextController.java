/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio.sdis;

import de.audi.audio.sdis.AudioContextListener;
import de.esolutions.fw.comm.asi.hmisync.audio.ASIHMISyncAudioReply;

public interface AudioContextController {
    public static final Integer AUDIO_CONTEXT_NONE = new Integer(0);
    public static final Integer AUDIO_CONTEXT_MEDIA = new Integer(3);
    public static final Integer AUDIO_CONTEXT_TV = new Integer(4);
    public static final Integer AUDIO_CONTEXT_RADIO = new Integer(2);
    public static final Integer AUDIO_CONTEXT_A2LS = new Integer(1);

    default public void addAudioContextListener(AudioContextListener audioContextListener) {
    }

    default public void setAudioContext(int n, ASIHMISyncAudioReply aSIHMISyncAudioReply) {
    }

    default public void enableA2LS(String string, ASIHMISyncAudioReply aSIHMISyncAudioReply) {
    }

    default public void enableA2LSPending(String string, ASIHMISyncAudioReply aSIHMISyncAudioReply) {
    }

    default public void enableA2LSAccept() {
    }

    default public void enableA2LSDecline() {
    }

    default public void disableA2LS(ASIHMISyncAudioReply aSIHMISyncAudioReply) {
    }

    default public void disableA2LS() {
    }

    default public void joinActiveAudioContext(ASIHMISyncAudioReply aSIHMISyncAudioReply) {
    }

    default public void unjoinActiveAudioContext(ASIHMISyncAudioReply aSIHMISyncAudioReply) {
    }

    default public int getAudioContext() {
    }

    default public void removeReplyProxy(ASIHMISyncAudioReply aSIHMISyncAudioReply) {
    }
}

