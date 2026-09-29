/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.dsiadapter;

import de.audi.app.sdsmanager.dictation.DictationComponentManager;
import de.audi.app.sdsmanager.dictation.command.AbstractCommand;
import de.audi.app.sdsmanager.dictation.dsiadapter.StopDictationCommand;

class StopDictationCommand$1
extends AbstractCommand {
    private final /* synthetic */ StopDictationCommand this$0;

    StopDictationCommand$1(StopDictationCommand stopDictationCommand, DictationComponentManager dictationComponentManager) {
        this.this$0 = stopDictationCommand;
        super(dictationComponentManager);
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "[StopDictationErrorCommand#execute]");
        StopDictationCommand.access$000(this.this$0, 1);
    }
}

