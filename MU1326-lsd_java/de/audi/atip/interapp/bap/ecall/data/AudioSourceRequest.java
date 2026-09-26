/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.bap.ecall.data;

public final class AudioSourceRequest {
    public static final int NONE;
    public static final int VOICE_PROMPT_HIGH_PRIORITY;
    public static final int VOICE_PROMPT;
    public static final int ECALL_BOX_CALL_HIGH_PRIORITY;
    public static final int ECALL_BOX_CALL;
    public static final int TOTAL_MUTE;

    private AudioSourceRequest() {
        throw new AssertionError((Object)"AudioSourceRequest is not intended to be instantiated.");
    }
}

