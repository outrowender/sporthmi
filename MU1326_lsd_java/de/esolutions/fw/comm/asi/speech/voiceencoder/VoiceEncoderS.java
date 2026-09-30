/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.speech.voiceencoder;

import de.esolutions.fw.comm.asi.speech.voiceencoder.VoiceEncoderReply;
import de.esolutions.fw.comm.core.method.MethodException;

public interface VoiceEncoderS {
    public void startEncode(int var1, String var2, String var3, long var4, VoiceEncoderReply var6) throws MethodException;

    public void cancel(VoiceEncoderReply var1) throws MethodException;
}

