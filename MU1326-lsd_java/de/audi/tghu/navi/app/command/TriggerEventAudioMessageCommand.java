/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.command.TriggerEventAudioMessageCommand$TriggerEventAudioResultHandleStrategy;

public class TriggerEventAudioMessageCommand
extends NavCommand {
    private int soundID;
    private TriggerEventAudioMessageCommand$TriggerEventAudioResultHandleStrategy processResultStrategy = null;

    public TriggerEventAudioMessageCommand(int n) {
        this("TriggerEventAudioMessageCommand");
        this.soundID = n;
    }

    public TriggerEventAudioMessageCommand(String string) {
        super(string);
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "TriggerEventAudioMessageCommand#execute(), soundID is(%1)", (long)this.soundID);
        this.getDSINavigation().triggerEventAudioMessage(this.soundID);
    }

    @Override
    public void triggerEventAudioMessageResult(int n) {
        this.logger.log(-2137614336, "TriggerEventAudioMessageCommand#triggerEventAudioMessageResult(), resultCode is(%1)", (long)n);
        if (this.processResultStrategy != null) {
            this.processResultStrategy.processTriggerResult(n);
        } else {
            this.logger.log(-2137614336, "TriggerEventAudioMessageCommand#triggerEventAudioMessageResult(), TriggerEventAudioResultHandleStrategy is null!");
        }
        if (n == 0) {
            this.getCommandList().commandFinished();
        } else {
            this.getCommandList().commandAborted(n);
        }
    }

    public TriggerEventAudioMessageCommand setProcessResultStrategy(TriggerEventAudioMessageCommand$TriggerEventAudioResultHandleStrategy triggerEventAudioMessageCommand$TriggerEventAudioResultHandleStrategy) {
        this.processResultStrategy = triggerEventAudioMessageCommand$TriggerEventAudioResultHandleStrategy;
        return this;
    }
}

