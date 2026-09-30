/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.dsiadapter;

import de.audi.app.sdsmanager.dictation.DictationComponentManager;
import de.audi.app.sdsmanager.dictation.command.AbstractCommand;
import de.audi.app.sdsmanager.dictation.dsi.AbstractDsiOnlineDictationCommand;
import de.audi.tghu.command.Command;
import de.audi.tghu.command.Monitor;

final class StartDictationCommand
extends AbstractDsiOnlineDictationCommand {
    private static final String DICT_TYPE = StartDictationCommand.getDictType();
    private static final String SERVICE_NAME = "";
    private final String customGrammar;
    private final String userID;

    private StartDictationCommand(DictationComponentManager dictationComponentManager, String string, String string2) {
        super(dictationComponentManager);
        this.customGrammar = string;
        this.userID = string2;
    }

    static void schedule(DictationComponentManager dictationComponentManager, Monitor monitor, String string, String string2) {
        StartDictationCommand startDictationCommand = new StartDictationCommand(dictationComponentManager, string, string2);
        startDictationCommand.schedule(monitor);
    }

    public void execute() {
        try {
            this.logger.log(10000000, "[StartDictationCommand#execute]");
            this.dsiOnlineDictationAccess.startDictation(DICT_TYPE, SERVICE_NAME, this.customGrammar, this.userID);
        }
        catch (Exception exception) {
            this.logException("[StartDictationCommand#execute]", exception);
            this.signalResult(1);
        }
    }

    public long getTimeout() {
        return 300000L;
    }

    public void dictationResult(int n) {
        this.logger.log(10000000, "[StartDictationCommand#dictationResult] returnCode = %1", (long)n);
        boolean bl = n == 10;
        int n2 = bl ? 0 : AbstractDsiOnlineDictationCommand.mapDsiErrorCode(n);
        this.signalResult(n2);
    }

    private static String getDictType() {
        return System.getProperty("dictation.dictType", "Automotive_Dictation");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void signalResult(int n) {
        try {
            this.logger.log(10000000, "[StartDictationCommand#signalResult] result = %1", (long)n);
            this.dictationComponentManager.getDsiDictationAdapter().handleStartDictationResult(n);
        }
        catch (Exception exception) {
            this.logException("[StartDictationCommand#signalResult]", exception);
        }
        finally {
            this.commandList.commandFinished();
        }
    }

    protected Command getErrorCommand() {
        return new AbstractCommand(this.dictationComponentManager){

            public void execute() {
                this.logger.log(10000000, "[StartDictationErrorCommand#execute]");
                StartDictationCommand.this.signalResult(1);
            }
        };
    }
}

