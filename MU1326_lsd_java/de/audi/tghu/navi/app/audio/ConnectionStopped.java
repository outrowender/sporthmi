/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.audio;

import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.SpeechManager;
import de.audi.tghu.navi.app.audio.AudioState;
import de.audi.tghu.navi.app.audio.AudioStateMachine;

public class ConnectionStopped
extends AudioState {
    public ConnectionStopped(NavigationEnv navigationEnv, AudioStateMachine audioStateMachine, SpeechManager speechManager) {
        super(navigationEnv, audioStateMachine, speechManager);
    }

    public void updateAudioRequest(int n) {
        this.logChannel.log(10000000, "ConnectionStopped#updateAudioRequest( %1 ) ", (long)n);
        super.updateAudioRequest(n);
        if (n == 3 || n == 1) {
            this.requestConnection();
        }
    }

    public String toString() {
        return "CONNECTION_STOPPED";
    }
}

