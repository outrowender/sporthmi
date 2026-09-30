/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.bap.ecall.data;

public final class AudioSourceRequest {
    public static final int NONE = 0;
    public static final int VOICE_PROMPT_HIGH_PRIORITY = 1;
    public static final int VOICE_PROMPT = 2;
    public static final int ECALL_BOX_CALL_HIGH_PRIORITY = 3;
    public static final int ECALL_BOX_CALL = 4;
    public static final int TOTAL_MUTE = 7;

    private AudioSourceRequest() {
        throw new AssertionError((Object)"AudioSourceRequest is not intended to be instantiated.");
    }
}

