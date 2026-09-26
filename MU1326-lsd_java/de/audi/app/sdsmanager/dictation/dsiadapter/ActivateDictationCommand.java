/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.dsiadapter;

import de.audi.app.sdsmanager.dictation.DictationComponentManager;
import de.audi.app.sdsmanager.dictation.dsi.AbstractDsiOnlineDictationCommand;
import de.audi.app.sdsmanager.dictation.dsiadapter.ActivateDictationCommand$1;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Command;
import de.audi.tghu.command.Monitor;

final class ActivateDictationCommand
extends AbstractDsiOnlineDictationCommand {
    private ActivateDictationCommand(DictationComponentManager dictationComponentManager) {
        super(dictationComponentManager);
    }

    static void schedule(DictationComponentManager dictationComponentManager, Monitor monitor) {
        ActivateDictationCommand activateDictationCommand = new ActivateDictationCommand(dictationComponentManager);
        activateDictationCommand.schedule(monitor);
    }

    @Override
    public void execute() {
        try {
            this.logger.log(-2137614336, "[ActivateDictationCommand#execute]");
            this.dsiOnlineDictationAccess.activateDictation();
        }
        catch (Exception exception) {
            this.logException("[ActivateDictationCommand#execute]", exception);
            this.signalResult(1);
        }
    }

    @Override
    public long getTimeout() {
        return 0;
    }

    @Override
    public void dictationResult(int n) {
        this.logger.log(-2137614336, "[ActivateDictationCommand#dictationResult] returnCode = %1", (long)n);
        boolean bl = n == 10;
        int n2 = bl ? 0 : AbstractDsiOnlineDictationCommand.mapDsiErrorCode(n);
        this.signalResult(n2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void signalResult(int n) {
        try {
            this.logger.log(-2137614336, "[ActivateDictationCommand#signalResult] result = %1", (long)n);
            this.dictationComponentManager.getDsiDictationAdapter().handleActivateDictationResult(n);
        }
        catch (Exception exception) {
            this.logException("[ActivateDictationCommand#signalResult]", exception);
        }
        finally {
            this.commandList.commandFinished();
        }
    }

    @Override
    protected Command getErrorCommand() {
        return new ActivateDictationCommand$1(this, this.dictationComponentManager);
    }

    static /* synthetic */ LogChannel access$001(ActivateDictationCommand activateDictationCommand) {
        return activateDictationCommand.logger;
    }

    static /* synthetic */ void access$100(ActivateDictationCommand activateDictationCommand, int n) {
        activateDictationCommand.signalResult(n);
    }
}

