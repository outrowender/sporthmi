/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.dsiadapter;

import de.audi.app.sdsmanager.dictation.DictationComponentManager;
import de.audi.app.sdsmanager.dictation.command.AbstractCommand;
import de.audi.app.sdsmanager.dictation.dsiadapter.ActivateDictationCommand;

class ActivateDictationCommand$1
extends AbstractCommand {
    private final /* synthetic */ ActivateDictationCommand this$0;

    ActivateDictationCommand$1(ActivateDictationCommand activateDictationCommand, DictationComponentManager dictationComponentManager) {
        this.this$0 = activateDictationCommand;
        super(dictationComponentManager);
    }

    @Override
    public void execute() {
        ActivateDictationCommand.access$001(this.this$0).log(-2137614336, "[ActivateDictationErrorCommand#execute]");
        ActivateDictationCommand.access$100(this.this$0, 1);
    }
}

