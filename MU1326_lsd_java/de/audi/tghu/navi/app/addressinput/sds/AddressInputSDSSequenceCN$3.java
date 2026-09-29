/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.sds;

import de.audi.atip.interapp.NaviServiceListener;
import de.audi.tghu.navi.app.addressinput.sds.AddressInputSDSSequenceCN;
import de.audi.tghu.navi.app.sds.NotifyNaviServiceListenerCommand;

class AddressInputSDSSequenceCN$3
extends NotifyNaviServiceListenerCommand {
    private final /* synthetic */ boolean val$isCommandOK;
    private final /* synthetic */ AddressInputSDSSequenceCN this$0;

    AddressInputSDSSequenceCN$3(AddressInputSDSSequenceCN addressInputSDSSequenceCN, NaviServiceListener naviServiceListener, boolean bl) {
        this.this$0 = addressInputSDSSequenceCN;
        this.val$isCommandOK = bl;
        super(naviServiceListener);
    }

    @Override
    protected void call(NaviServiceListener naviServiceListener) {
        naviServiceListener.responseSetLocationPart(this.val$isCommandOK ? (byte)0 : 1);
    }
}

