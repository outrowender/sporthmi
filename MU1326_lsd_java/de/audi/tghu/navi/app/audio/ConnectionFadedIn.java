/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.audio;

import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.SpeechManager;
import de.audi.tghu.navi.app.audio.AudioState;
import de.audi.tghu.navi.app.audio.AudioStateMachine;

public class ConnectionFadedIn
extends AudioState {
    public ConnectionFadedIn(NavigationEnv navigationEnv, AudioStateMachine audioStateMachine, SpeechManager speechManager) {
        super(navigationEnv, audioStateMachine, speechManager);
    }

    public void updateAudioRequest(int n) {
        this.logChannel.log(10000000, "ConnectionFadedIn#updateAudioRequest( %1 ) ", (long)n);
        super.updateAudioRequest(n);
        if (n == 3) {
            this.stateMachine.audioTrigger(true);
        } else if (n == 1) {
            this.logChannel.log(10000000, "ConnectionFadedIn#updateAudioRequest( %1 ) - audio active ", (long)n);
        } else if (n == 2 && this.stateMachine.isAutoRepeatMode()) {
            this.stateMachine.getLastAnnouncementHandler().repeatLastAnnouncementSimple(0);
        } else {
            this.releaseConnection(this.stateMachine.getCurrentConnection());
        }
    }

    public String toString() {
        return "CONNECTION_FADEDIN";
    }
}

