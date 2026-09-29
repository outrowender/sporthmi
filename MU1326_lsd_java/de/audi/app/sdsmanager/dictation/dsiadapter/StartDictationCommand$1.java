/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.dsiadapter;

import de.audi.app.sdsmanager.dictation.DictationComponentManager;
import de.audi.app.sdsmanager.dictation.command.AbstractCommand;
import de.audi.app.sdsmanager.dictation.dsiadapter.StartDictationCommand;

class StartDictationCommand$1
extends AbstractCommand {
    private final /* synthetic */ StartDictationCommand this$0;

    StartDictationCommand$1(StartDictationCommand startDictationCommand, DictationComponentManager dictationComponentManager) {
        this.this$0 = startDictationCommand;
        super(dictationComponentManager);
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "[StartDictationErrorCommand#execute]");
        StartDictationCommand.access$000(this.this$0, 1);
    }
}

