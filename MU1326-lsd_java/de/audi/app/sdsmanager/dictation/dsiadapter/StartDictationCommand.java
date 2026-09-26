/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.dsiadapter;

import de.audi.app.sdsmanager.dictation.DictationComponentManager;
import de.audi.app.sdsmanager.dictation.dsi.AbstractDsiOnlineDictationCommand;
import de.audi.app.sdsmanager.dictation.dsiadapter.StartDictationCommand$1;
import de.audi.tghu.command.Command;
import de.audi.tghu.command.Monitor;

final class StartDictationCommand
extends AbstractDsiOnlineDictationCommand {
    private static final String DICT_TYPE = StartDictationCommand.getDictType();
    private static final String SERVICE_NAME;
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

    @Override
    public void execute() {
        try {
            this.logger.log(-2137614336, "[StartDictationCommand#execute]");
            this.dsiOnlineDictationAccess.startDictation(DICT_TYPE, "", this.customGrammar, this.userID);
        }
        catch (Exception exception) {
            this.logException("[StartDictationCommand#execute]", exception);
            this.signalResult(1);
        }
    }

    @Override
    public long getTimeout() {
        return 0;
    }

    @Override
    public void dictationResult(int n) {
        this.logger.log(-2137614336, "[StartDictationCommand#dictationResult] returnCode = %1", (long)n);
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
            this.logger.log(-2137614336, "[StartDictationCommand#signalResult] result = %1", (long)n);
            this.dictationComponentManager.getDsiDictationAdapter().handleStartDictationResult(n);
        }
        catch (Exception exception) {
            this.logException("[StartDictationCommand#signalResult]", exception);
        }
        finally {
            this.commandList.commandFinished();
        }
    }

    @Override
    protected Command getErrorCommand() {
        return new StartDictationCommand$1(this, this.dictationComponentManager);
    }

    static /* synthetic */ void access$000(StartDictationCommand startDictationCommand, int n) {
        startDictationCommand.signalResult(n);
    }
}

