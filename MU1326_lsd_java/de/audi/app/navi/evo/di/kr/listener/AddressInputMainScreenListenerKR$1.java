/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.kr.listener;

import de.audi.app.navi.evo.di.kr.listener.AddressInputMainScreenListenerKR;
import de.audi.tghu.navi.app.command.NavCommand;

class AddressInputMainScreenListenerKR$1
extends NavCommand {
    private final /* synthetic */ AddressInputMainScreenListenerKR this$0;

    AddressInputMainScreenListenerKR$1(AddressInputMainScreenListenerKR addressInputMainScreenListenerKR, String string) {
        this.this$0 = addressInputMainScreenListenerKR;
        super(string);
    }

    @Override
    public void execute() {
        AddressInputMainScreenListenerKR.access$000(this.this$0).setPreviewAreaAroundCCP(1);
        this.getCommandList().commandFinished();
    }
}

