/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.tts;

import de.audi.atip.interapp.tts.TTSListener;

public interface TTSToneListener
extends TTSListener {
    default public void toneStarted() {
    }

    default public void toneFinished() {
    }
}

