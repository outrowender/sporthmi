/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.dsiadapter;

import de.audi.app.sdsmanager.dictation.DictationComponentManager;
import de.audi.app.sdsmanager.dictation.command.AbstractCommand;
import de.audi.app.sdsmanager.dictation.dsi.AbstractDsiOnlineDictationCommand;
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

    public void execute() {
        try {
            this.logger.log(10000000, "[ActivateDictationCommand#execute]");
            this.dsiOnlineDictationAccess.activateDictation();
        }
        catch (Exception exception) {
            this.logException("[ActivateDictationCommand#execute]", exception);
            this.signalResult(1);
        }
    }

    public long getTimeout() {
        return 300000L;
    }

    public void dictationResult(int n) {
        this.logger.log(10000000, "[ActivateDictationCommand#dictationResult] returnCode = %1", (long)n);
        boolean bl = n == 10;
        int n2 = bl ? 0 : AbstractDsiOnlineDictationCommand.mapDsiErrorCode(n);
        this.signalResult(n2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void signalResult(int n) {
        try {
            this.logger.log(10000000, "[ActivateDictationCommand#signalResult] result = %1", (long)n);
            this.dictationComponentManager.getDsiDictationAdapter().handleActivateDictationResult(n);
        }
        catch (Exception exception) {
            this.logException("[ActivateDictationCommand#signalResult]", exception);
        }
        finally {
            this.commandList.commandFinished();
        }
    }

    protected Command getErrorCommand() {
        return new AbstractCommand(this.dictationComponentManager){

            public void execute() {
                ActivateDictationCommand.this.logger.log(10000000, "[ActivateDictationErrorCommand#execute]");
                ActivateDictationCommand.this.signalResult(1);
            }
        };
    }
}

