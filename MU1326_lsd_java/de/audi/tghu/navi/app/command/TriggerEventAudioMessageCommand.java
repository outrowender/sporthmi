/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command;

import de.audi.tghu.navi.app.command.NavCommand;

public class TriggerEventAudioMessageCommand
extends NavCommand {
    private int soundID;
    private TriggerEventAudioResultHandleStrategy processResultStrategy = null;

    public TriggerEventAudioMessageCommand(int n) {
        this("TriggerEventAudioMessageCommand");
        this.soundID = n;
    }

    public TriggerEventAudioMessageCommand(String string) {
        super(string);
    }

    public void execute() {
        this.logger.log(10000000, "TriggerEventAudioMessageCommand#execute(), soundID is(%1)", (long)this.soundID);
        this.getDSINavigation().triggerEventAudioMessage(this.soundID);
    }

    public void triggerEventAudioMessageResult(int n) {
        this.logger.log(10000000, "TriggerEventAudioMessageCommand#triggerEventAudioMessageResult(), resultCode is(%1)", (long)n);
        if (this.processResultStrategy != null) {
            this.processResultStrategy.processTriggerResult(n);
        } else {
            this.logger.log(10000000, "TriggerEventAudioMessageCommand#triggerEventAudioMessageResult(), TriggerEventAudioResultHandleStrategy is null!");
        }
        if (n == 0) {
            this.getCommandList().commandFinished();
        } else {
            this.getCommandList().commandAborted(n);
        }
    }

    public TriggerEventAudioMessageCommand setProcessResultStrategy(TriggerEventAudioResultHandleStrategy triggerEventAudioResultHandleStrategy) {
        this.processResultStrategy = triggerEventAudioResultHandleStrategy;
        return this;
    }

    public static interface TriggerEventAudioResultHandleStrategy {
        public void processTriggerResult(int var1);
    }
}

