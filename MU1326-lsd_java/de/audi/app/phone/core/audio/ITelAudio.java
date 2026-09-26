/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.audio;

import de.audi.app.phone.core.ITelComponent;

public interface ITelAudio
extends ITelComponent {
    default public void muteRingtone(boolean bl) {
    }

    default public void switchMicMuteOn(int n) {
    }

    default public void switchMicMuteOff(int n) {
    }

    default public void toggelMicMuteState(int n) {
    }
}

