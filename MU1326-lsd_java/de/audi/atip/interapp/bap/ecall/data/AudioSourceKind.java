/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.bap.ecall.data;

public final class AudioSourceKind {
    public static final int UNKNOWN;
    public static final int VOICE_PROMPT_HIGH_PRIORITY;
    public static final int VOICE_PROMPT;
    public static final int ECALL_BOX_CALL_HIGH_PRIORITY;
    public static final int ECALL_BOX_CALL;
    public static final int MAIN_UNIT_INTERNAL;
    public static final int MAIN_UNIT_PHONE;
    public static final int TOTAL_MUTE;

    private AudioSourceKind() {
        throw new AssertionError((Object)"AudioSourceKind is not intended to be instantiated.");
    }
}

