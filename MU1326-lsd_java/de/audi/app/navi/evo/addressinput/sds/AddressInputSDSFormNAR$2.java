/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.sds;

import de.audi.app.navi.evo.addressinput.sds.AddressInputSDSFormNAR;
import de.audi.atip.interapp.NaviServiceListener;
import de.audi.tghu.navi.app.sds.NotifyNaviServiceListenerCommand;

class AddressInputSDSFormNAR$2
extends NotifyNaviServiceListenerCommand {
    private final /* synthetic */ AddressInputSDSFormNAR this$0;

    AddressInputSDSFormNAR$2(AddressInputSDSFormNAR addressInputSDSFormNAR, NaviServiceListener naviServiceListener) {
        this.this$0 = addressInputSDSFormNAR;
        super(naviServiceListener);
    }

    @Override
    protected void call(NaviServiceListener naviServiceListener) {
        naviServiceListener.responseStartDestinationInput((byte)0);
    }
}

