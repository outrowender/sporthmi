/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi;

import de.audi.atip.interapp.tts.TTSSessionBasedService;

public interface ITTSHandler {
    public static final int TAG_NONE = 0;
    public static final int TAG_SAY_AS = 1;
    public static final int TAG_PHONEME = 2;

    public void setTTSService(TTSSessionBasedService var1);

    public void speak(int var1, String var2, String var3, String var4, boolean var5, int var6);

    public void speak(int var1, String var2, String var3, String var4, String var5, boolean var6, int var7);

    public void startSession(int var1);

    public void stopSession(int var1, boolean var2);

    public void reset();
}

