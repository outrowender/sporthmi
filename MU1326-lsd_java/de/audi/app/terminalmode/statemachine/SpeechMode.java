/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.statemachine;

import de.audi.app.terminalmode.util.Enum;

public final class SpeechMode
extends Enum {
    public static final SpeechMode NONE = new SpeechMode(0, "NONE");
    public static final SpeechMode SPEEKING = new SpeechMode(1, "SPEEKING");
    public static final SpeechMode RECOGNIZING = new SpeechMode(2, "RECOGNIZING");

    protected SpeechMode(int n, String string) {
        super(n, string);
    }
}

