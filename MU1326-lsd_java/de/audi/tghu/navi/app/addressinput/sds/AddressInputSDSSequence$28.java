/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.sds;

import de.audi.atip.interapp.NaviServiceListener;
import de.audi.tghu.navi.app.addressinput.sds.AddressInputSDSSequence;
import de.audi.tghu.navi.app.sds.NotifyNaviServiceListenerCommand;

class AddressInputSDSSequence$28
extends NotifyNaviServiceListenerCommand {
    private final /* synthetic */ AddressInputSDSSequence this$0;

    AddressInputSDSSequence$28(AddressInputSDSSequence addressInputSDSSequence, NaviServiceListener naviServiceListener) {
        this.this$0 = addressInputSDSSequence;
        super(naviServiceListener);
    }

    @Override
    protected void call(NaviServiceListener naviServiceListener) {
        naviServiceListener.responseQuerySpelledLocationPartResultList((byte)1, null, null);
    }
}

