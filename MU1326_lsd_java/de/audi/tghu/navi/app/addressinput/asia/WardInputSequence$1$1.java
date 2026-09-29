/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.asia;

import de.audi.atip.interapp.NaviServiceListener;
import de.audi.tghu.navi.app.addressinput.asia.WardInputSequence$1;
import de.audi.tghu.navi.app.sds.NotifySDSCommand;

class WardInputSequence$1$1
extends NotifySDSCommand {
    private final /* synthetic */ WardInputSequence$1 this$1;

    WardInputSequence$1$1(WardInputSequence$1 wardInputSequence$1, NaviServiceListener naviServiceListener) {
        this.this$1 = wardInputSequence$1;
        super(naviServiceListener);
    }

    @Override
    public void call() {
        this.getCommandList().put("[SDS_Command_List_Invalid]", new Boolean(true));
        this.getCommandList().commandFinished();
    }
}

