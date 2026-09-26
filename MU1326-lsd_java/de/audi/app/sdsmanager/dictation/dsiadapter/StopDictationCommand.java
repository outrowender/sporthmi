/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.dsiadapter;

import de.audi.app.sdsmanager.dictation.DictationComponentManager;
import de.audi.app.sdsmanager.dictation.dsi.AbstractDsiOnlineDictationCommand;
import de.audi.app.sdsmanager.dictation.dsiadapter.StopDictationCommand$1;
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

    @Override
    public void execute() {
        try {
            this.logger.log(-2137614336, "[StopDictationCommand#execute]");
            this.dsiOnlineDictationAccess.stopDictation();
        }
        catch (Exception exception) {
            this.logException("[StopDictationCommand#execute]", exception);
            this.signalResult(1);
        }
    }

    @Override
    public long getTimeout() {
        return 0;
    }

    @Override
    public void dictationResult(int n) {
        this.logger.log(-2137614336, "[StopDictationCommand#dictationResult] returnCode = %1", (long)n);
        if (n != 12) {
            this.logger.log(-2137614336, "[StopDictationCommand#dictationResult] Ignoring obsolete dictation response.");
        } else {
            this.signalResult(0);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void signalResult(int n) {
        try {
            this.logger.log(-2137614336, "[StopDictationCommand#signalResult] result = %1", (long)n);
            this.dictationComponentManager.getDsiDictationAdapter().handleStopDictationResult(n);
        }
        catch (Exception exception) {
            this.logException("[StopDictationCommand#signalResult]", exception);
        }
        finally {
            this.commandList.commandFinished();
        }
    }

    @Override
    protected Command getErrorCommand() {
        return new StopDictationCommand$1(this, this.dictationComponentManager);
    }

    static /* synthetic */ void access$000(StopDictationCommand stopDictationCommand, int n) {
        stopDictationCommand.signalResult(n);
    }
}

