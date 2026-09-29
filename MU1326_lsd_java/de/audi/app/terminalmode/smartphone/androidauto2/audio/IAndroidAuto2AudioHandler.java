/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.app.terminalmode.statemachine.TMState
 */
package de.audi.app.terminalmode.smartphone.androidauto2.audio;

import de.audi.app.terminalmode.statemachine.TMState;

public interface IAndroidAuto2AudioHandler {
    default public void responseUpdateMode(TMState tMState) {
    }

    default public void responseUpdateMode() {
    }

    default public void updateEntertainmentAudioState(boolean bl) {
    }
}

