/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.dsiadapter;

import de.audi.app.sdsmanager.dictation.DictationComponentManager;
import de.audi.app.sdsmanager.dictation.command.AbstractCommand;
import de.audi.app.sdsmanager.dictation.dsiadapter.ProcessVoiceDataCommand;

class ProcessVoiceDataCommand$1
extends AbstractCommand {
    private final /* synthetic */ ProcessVoiceDataCommand this$0;

    ProcessVoiceDataCommand$1(ProcessVoiceDataCommand processVoiceDataCommand, DictationComponentManager dictationComponentManager) {
        this.this$0 = processVoiceDataCommand;
        super(dictationComponentManager);
    }

    @Override
    public void execute() {
        ProcessVoiceDataCommand.access$001(this.this$0).log(-2137614336, "[ProcessVoiceDataErrorCommand#execute]");
        ProcessVoiceDataCommand.access$100(this.this$0, 1, null);
    }
}

