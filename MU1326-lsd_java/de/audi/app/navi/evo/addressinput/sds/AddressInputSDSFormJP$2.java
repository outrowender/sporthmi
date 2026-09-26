/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.sds;

import de.audi.app.navi.evo.addressinput.sds.AddressInputSDSFormJP;
import de.audi.atip.interapp.NaviServiceListener;
import de.audi.tghu.navi.app.sds.NotifyNaviServiceListenerCommand;

class AddressInputSDSFormJP$2
extends NotifyNaviServiceListenerCommand {
    private final /* synthetic */ AddressInputSDSFormJP this$0;

    AddressInputSDSFormJP$2(AddressInputSDSFormJP addressInputSDSFormJP, NaviServiceListener naviServiceListener) {
        this.this$0 = addressInputSDSFormJP;
        super(naviServiceListener);
    }

    @Override
    protected void call(NaviServiceListener naviServiceListener) {
        naviServiceListener.responseMapCodeResult((byte)1);
    }
}

