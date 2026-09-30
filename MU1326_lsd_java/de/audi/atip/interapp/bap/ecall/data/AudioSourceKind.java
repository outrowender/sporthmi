/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.bap.ecall.data;

public final class AudioSourceKind {
    public static final int UNKNOWN = 0;
    public static final int VOICE_PROMPT_HIGH_PRIORITY = 1;
    public static final int VOICE_PROMPT = 2;
    public static final int ECALL_BOX_CALL_HIGH_PRIORITY = 3;
    public static final int ECALL_BOX_CALL = 4;
    public static final int MAIN_UNIT_INTERNAL = 5;
    public static final int MAIN_UNIT_PHONE = 6;
    public static final int TOTAL_MUTE = 7;

    private AudioSourceKind() {
        throw new AssertionError((Object)"AudioSourceKind is not intended to be instantiated.");
    }
}

