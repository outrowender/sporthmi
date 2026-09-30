/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.audio;

import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.SpeechManager;
import de.audi.tghu.navi.app.audio.AudioState;
import de.audi.tghu.navi.app.audio.AudioStateMachine;

public class WaitForConnectionFadedIn
extends AudioState {
    public WaitForConnectionFadedIn(NavigationEnv navigationEnv, AudioStateMachine audioStateMachine, SpeechManager speechManager) {
        super(navigationEnv, audioStateMachine, speechManager);
    }

    public void fadedIn(int n, int n2) {
        if (AudioStateMachine.isNaviAudioConnection(n)) {
            this.logChannel.log(10000000, "WaitForConnectionFadedIn#fadedIn( %1 )", (long)n);
            this.stateMachine.goTo(3);
            int n3 = this.stateMachine.getAudioState();
            if (n3 == 3) {
                this.stateMachine.audioTrigger(true);
            } else if (n3 == 1) {
                this.logChannel.log(100000, "WaitForConnectionFadedIn#fadedIn( %1 ) - audioRequest already active!", (long)n);
            } else {
                this.releaseConnection(n);
            }
        }
    }

    public String toString() {
        return "WAIT_FOR_CONNECTION_FADEDIN";
    }
}

