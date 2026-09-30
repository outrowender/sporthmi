/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.dsiadapter;

import de.audi.app.sdsmanager.dictation.DictationComponentManager;
import de.audi.app.sdsmanager.dictation.command.AbstractCommand;
import de.audi.app.sdsmanager.dictation.dsi.AbstractDsiOnlineDictationCommand;
import de.audi.tghu.command.Command;
import de.audi.tghu.command.Monitor;

final class StopDictationCommand
extends AbstractDsiOnlineDictationCommand {
    private StopDictationCommand(DictationComponentManager dictationComponentManager) {
        super(dictationComponentManager);
    }

    static void schedule(DictationComponentManager dictationComponentManager, Monitor monitor) {
        StopDictationCommand stopDictationCommand = new StopDictationCommand(dictationComponentManager);
        stopDictationCommand.schedule(monitor);
    }

    public void execute() {
        try {
            this.logger.log(10000000, "[StopDictationCommand#execute]");
            this.dsiOnlineDictationAccess.stopDictation();
        }
        catch (Exception exception) {
            this.logException("[StopDictationCommand#execute]", exception);
            this.signalResult(1);
        }
    }

    public long getTimeout() {
        return 300000L;
    }

    public void dictationResult(int n) {
        this.logger.log(10000000, "[StopDictationCommand#dictationResult] returnCode = %1", (long)n);
        if (n != 12) {
            this.logger.log(10000000, "[StopDictationCommand#dictationResult] Ignoring obsolete dictation response.");
        } else {
            this.signalResult(0);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void signalResult(int n) {
        try {
            this.logger.log(10000000, "[StopDictationCommand#signalResult] result = %1", (long)n);
            this.dictationComponentManager.getDsiDictationAdapter().handleStopDictationResult(n);
        }
        catch (Exception exception) {
            this.logException("[StopDictationCommand#signalResult]", exception);
        }
        finally {
            this.commandList.commandFinished();
        }
    }

    protected Command getErrorCommand() {
        return new AbstractCommand(this.dictationComponentManager){

            public void execute() {
                this.logger.log(10000000, "[StopDictationErrorCommand#execute]");
                StopDictationCommand.this.signalResult(1);
            }
        };
    }
}

