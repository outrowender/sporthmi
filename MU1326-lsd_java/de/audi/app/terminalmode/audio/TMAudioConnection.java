/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.audio;

import de.audi.app.terminalmode.util.Enum;

public class TMAudioConnection
extends Enum {
    public static final TMAudioConnection INVALID = new TMAudioConnection(0, "INVALID");
    public static final TMAudioConnection MEDIA = new TMAudioConnection(1, "MEDIA");
    public static final TMAudioConnection PHONE = new TMAudioConnection(2, "PHONE");
    public static final TMAudioConnection PHONE_INPUT = new TMAudioConnection(3, "PHONE_INPUT");
    public static final TMAudioConnection SPEECH = new TMAudioConnection(4, "SPEECH");
    public static final TMAudioConnection SPEECH_INPUT = new TMAudioConnection(5, "SPEECH_INPUT");
    public static final TMAudioConnection ANNOUNCEMENT = new TMAudioConnection(6, "ANNOUNCEMENT");
    public static final TMAudioConnection LOWERING = new TMAudioConnection(7, "LOWERING");
    public static final TMAudioConnection SPEECH_GUIDANCE = new TMAudioConnection(8, "SPEECH_GUIDANCE");
    public static final TMAudioConnection RINGTONE = new TMAudioConnection(9, "RINGTONE");

    private TMAudioConnection(int n, String string) {
        super(n, string);
    }
}

