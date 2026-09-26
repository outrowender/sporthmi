/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.dsiadapter;

import de.audi.app.sdsmanager.dictation.DictationComponentManager;
import de.audi.app.sdsmanager.dictation.dsi.AbstractDsiOnlineDictationCommand;
import de.audi.app.sdsmanager.dictation.dsiadapter.SetLanguageCommand$1;
import de.audi.tghu.command.Command;
import de.audi.tghu.command.Monitor;

final class SetLanguageCommand
extends AbstractDsiOnlineDictationCommand {
    private final String languageCode;
    private final boolean isFallbackLanguage;

    private SetLanguageCommand(DictationComponentManager dictationComponentManager, String string, boolean bl) {
        super(dictationComponentManager);
        this.languageCode = string;
        this.isFallbackLanguage = bl;
    }

    static void schedule(DictationComponentManager dictationComponentManager, Monitor monitor, String string, boolean bl) {
        SetLanguageCommand setLanguageCommand = new SetLanguageCommand(dictationComponentManager, string, bl);
        setLanguageCommand.schedule(monitor);
    }

    @Override
    public void execute() {
        try {
            this.logger.log(-2137614336, "[SetLanguageCommand#execute]");
            if (!this.isFallbackLanguage) {
                this.dsiOnlineDictationAccess.setLanguage(this.languageCode);
            } else {
                this.dsiOnlineDictationAccess.setFallbackLanguage(this.languageCode);
            }
            this.signalResult(0);
        }
        catch (Exception exception) {
            this.logException("[SetLanguageCommand#execute]", exception);
            this.signalResult(1);
        }
    }

    @Override
    public long getTimeout() {
        return 0;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void signalResult(int n) {
        try {
            this.logger.log(-2137614336, "[SetLanguageCommand#signalResult] result = %1", (long)n);
            this.dictationComponentManager.getDsiDictationAdapter().handleSetLanguageResult(n, this.languageCode, this.isFallbackLanguage);
        }
        catch (Exception exception) {
            this.logException("[SetLanguageCommand#signalResult]", exception);
        }
        finally {
            this.commandList.commandFinished();
        }
    }

    @Override
    protected Command getErrorCommand() {
        return new SetLanguageCommand$1(this, this.dictationComponentManager);
    }

    static /* synthetic */ void access$000(SetLanguageCommand setLanguageCommand, int n) {
        setLanguageCommand.signalResult(n);
    }
}

