/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command;

import de.audi.tghu.navi.app.audio.AudioStateMachine;
import de.audi.tghu.navi.app.command.NavCommand;

public class RequestAudioTriggerAbortCommand
extends NavCommand {
    private final AudioStateMachine audioStateMachine;
    private final boolean doAudioStatemachineTransition;

    public RequestAudioTriggerAbortCommand(AudioStateMachine audioStateMachine, boolean bl) {
        this.audioStateMachine = audioStateMachine;
        this.doAudioStatemachineTransition = bl;
    }

    public void execute() {
        int n = this.navigation.getAudioStateMachine().getAudioState();
        if (n == 1) {
            this.logger.log(10000000, "RequestAudioTriggerAbortCommand#execute() - calling requestAudioTrigger(AUDIOMODE_ABORT) ");
            this.getDSINavigation().requestAudioTrigger(2);
        } else {
            this.logger.log(10000000, "RequestAudioTriggerAbortCommand#execute() - audioState = %1 != ACTIVE", (long)n);
            this.getCommandList().commandFinished();
        }
    }

    public void updateAudioRequest(int n) {
        this.logger.log(10000000, "RequestAudioTriggerAbortCommand#updateAudioRequest( %2 ), doAudioStatemachineTransition = %1", this.doAudioStatemachineTransition, (long)n);
        if (this.doAudioStatemachineTransition) {
            super.updateAudioRequest(n);
        } else {
            this.audioStateMachine.storeAudioStateWithoutTransition(n);
        }
        if (n == 2) {
            this.getCommandList().commandFinished();
        }
    }
}

