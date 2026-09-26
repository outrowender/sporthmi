/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.dsiadapter;

import de.audi.app.sdsmanager.dictation.DictationComponentManager;
import de.audi.app.sdsmanager.dictation.command.AbstractCommand;
import de.audi.app.sdsmanager.dictation.dsiadapter.SetLanguageCommand;

class SetLanguageCommand$1
extends AbstractCommand {
    private final /* synthetic */ SetLanguageCommand this$0;

    SetLanguageCommand$1(SetLanguageCommand setLanguageCommand, DictationComponentManager dictationComponentManager) {
        this.this$0 = setLanguageCommand;
        super(dictationComponentManager);
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "[SetLanguageErrorCommand#execute]");
        SetLanguageCommand.access$000(this.this$0, 1);
    }
}

