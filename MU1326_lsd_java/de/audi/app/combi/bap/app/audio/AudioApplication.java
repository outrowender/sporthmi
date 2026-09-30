/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.audio;

public final class AudioApplication {
    public static final int AUDIO_APPLICATION_NOT_SET = -2;
    public static final int AUDIO_APPLICATION_UNKNOWN = -1;
    public static final int AUDIO_APPLICATION_TUNER = 0;
    public static final int AUDIO_APPLICATION_MEDIA = 1;
    public static final int AUDIO_APPLICATION_TV = 2;
    public static final int AUDIO_APPLICATION_TERMINALMODE = 3;

    private AudioApplication() {
        throw new AssertionError((Object)"AudioApplication is not intended to be instantiated.");
    }
}

