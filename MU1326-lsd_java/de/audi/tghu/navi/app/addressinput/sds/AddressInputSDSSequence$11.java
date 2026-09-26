/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.sds;

import de.audi.atip.interapp.NaviServiceListener;
import de.audi.tghu.navi.app.addressinput.sds.AddressInputSDSSequence;
import de.audi.tghu.navi.app.sds.NotifyNaviServiceListenerCommand;

class AddressInputSDSSequence$11
extends NotifyNaviServiceListenerCommand {
    private final /* synthetic */ AddressInputSDSSequence this$0;

    AddressInputSDSSequence$11(AddressInputSDSSequence addressInputSDSSequence, NaviServiceListener naviServiceListener) {
        this.this$0 = addressInputSDSSequence;
        super(naviServiceListener);
    }

    @Override
    protected void call(NaviServiceListener naviServiceListener) {
        boolean bl = this.dsiResponseContainer.getLiCurrentLD().isPositionValid();
        naviServiceListener.responseSetOneShotData(bl ? (byte)0 : 1);
    }
}

