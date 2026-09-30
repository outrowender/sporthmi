/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.statemachine;

import de.audi.app.terminalmode.util.Enum;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public final class SpeechMode
extends Enum<SpeechMode> {
    public static final SpeechMode NONE = new SpeechMode(0, "NONE");
    public static final SpeechMode SPEEKING = new SpeechMode(1, "SPEEKING");
    public static final SpeechMode RECOGNIZING = new SpeechMode(2, "RECOGNIZING");

    protected SpeechMode(int n, String string) {
        super(n, string);
    }
}

