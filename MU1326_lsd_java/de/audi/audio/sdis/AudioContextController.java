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

    public void addAudioContextListener(AudioContextListener var1);

    public void setAudioContext(int var1, ASIHMISyncAudioReply var2);

    public void enableA2LS(String var1, ASIHMISyncAudioReply var2);

    public void enableA2LSPending(String var1, ASIHMISyncAudioReply var2);

    public void enableA2LSAccept();

    public void enableA2LSDecline();

    public void disableA2LS(ASIHMISyncAudioReply var1);

    public void disableA2LS();

    public void joinActiveAudioContext(ASIHMISyncAudioReply var1);

    public void unjoinActiveAudioContext(ASIHMISyncAudioReply var1);

    public int getAudioContext();

    public void removeReplyProxy(ASIHMISyncAudioReply var1);
}

