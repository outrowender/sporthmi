/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.jp.listeners;

import de.audi.app.navi.evo.di.jp.listeners.AddressInputMainScreenListenerJP;
import de.audi.tghu.navi.app.command.NavCommand;

class AddressInputMainScreenListenerJP$1
extends NavCommand {
    private final /* synthetic */ AddressInputMainScreenListenerJP this$0;

    AddressInputMainScreenListenerJP$1(AddressInputMainScreenListenerJP addressInputMainScreenListenerJP, String string) {
        this.this$0 = addressInputMainScreenListenerJP;
        super(string);
    }

    @Override
    public void execute() {
        AddressInputMainScreenListenerJP.access$000(this.this$0).setPreviewAreaAroundCCP(1);
        this.getCommandList().commandFinished();
    }
}

