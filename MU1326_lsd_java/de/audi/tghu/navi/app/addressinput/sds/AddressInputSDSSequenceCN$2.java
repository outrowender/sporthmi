/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.sds;

import de.audi.atip.interapp.NaviServiceListener;
import de.audi.tghu.navi.app.addressinput.sds.AddressInputSDSSequenceCN;
import de.audi.tghu.navi.app.sds.NotifyNaviServiceListenerCommand;

class AddressInputSDSSequenceCN$2
extends NotifyNaviServiceListenerCommand {
    private final /* synthetic */ AddressInputSDSSequenceCN this$0;

    AddressInputSDSSequenceCN$2(AddressInputSDSSequenceCN addressInputSDSSequenceCN, NaviServiceListener naviServiceListener) {
        this.this$0 = addressInputSDSSequenceCN;
        super(naviServiceListener);
    }

    @Override
    protected void call(NaviServiceListener naviServiceListener) {
        naviServiceListener.responseSetLocationPart((byte)0);
    }
}

