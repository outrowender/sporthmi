/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.audio;

import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.SpeechManager;
import de.audi.tghu.navi.app.audio.AudioState;
import de.audi.tghu.navi.app.audio.AudioStateMachine;

public class WaitForConnectionStopped
extends AudioState {
    public WaitForConnectionStopped(NavigationEnv navigationEnv, AudioStateMachine audioStateMachine, SpeechManager speechManager) {
        super(navigationEnv, audioStateMachine, speechManager);
    }

    @Override
    public void stopConnection(int n, int n2) {
        if (AudioStateMachine.isNaviAudioConnection(n)) {
            this.logChannel.log(-2137614336, "WaitForConnectionStopped#stopConnection( %1 ) - going to CONNECTION_STOPPED ", (long)n);
            this.acknowledgeStopAudio(n);
            int n3 = this.stateMachine.getAudioState();
            if (n3 == 3 || n3 == 1) {
                this.logChannel.log(-1601830656, "WaitForConnectionStopped#stopConnection() - another connection requested! ");
                this.requestConnection();
            }
        }
    }

    public String toString() {
        return "WAIT_FOR_CONNECTION_STOPPED";
    }
}

