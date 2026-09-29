/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.sds;

import de.audi.app.navi.evo.addressinput.sds.AddressInputSDSFormKR;
import de.audi.atip.interapp.NaviServiceListener;
import de.audi.tghu.navi.app.sds.NotifyNaviServiceListenerCommand;

class AddressInputSDSFormKR$7
extends NotifyNaviServiceListenerCommand {
    private final /* synthetic */ AddressInputSDSFormKR this$0;

    AddressInputSDSFormKR$7(AddressInputSDSFormKR addressInputSDSFormKR, NaviServiceListener naviServiceListener) {
        this.this$0 = addressInputSDSFormKR;
        super(naviServiceListener);
    }

    @Override
    protected void call(NaviServiceListener naviServiceListener) {
        naviServiceListener.responseSelectPOIbyListIndex((byte)1);
    }
}

