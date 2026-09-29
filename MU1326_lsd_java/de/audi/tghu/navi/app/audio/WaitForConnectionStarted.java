/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.audio;

import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.SpeechManager;
import de.audi.tghu.navi.app.audio.AudioState;
import de.audi.tghu.navi.app.audio.AudioStateMachine;

public class WaitForConnectionStarted
extends AudioState {
    public WaitForConnectionStarted(NavigationEnv navigationEnv, AudioStateMachine audioStateMachine, SpeechManager speechManager) {
        super(navigationEnv, audioStateMachine, speechManager);
    }

    @Override
    public void startConnection(int n, int n2) {
        if (AudioStateMachine.isNaviAudioConnection(n)) {
            this.logChannel.log(-2137614336, "WaitForConnectionStarted#startConnection( %1 ) ", (long)n);
            int n3 = this.stateMachine.getAudioState();
            if (n3 == 3 || n3 == 1) {
                this.fadeToConnection(n);
            } else {
                this.releaseConnection(n);
            }
        }
    }

    public String toString() {
        return "WAIT_FOR_CONNECTION_STARTED";
    }
}

