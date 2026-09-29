/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.sds;

import de.audi.app.navi.evo.addressinput.sds.AbstractAddressInputSDSFormEvo;
import de.audi.atip.interapp.NaviServiceListener;
import de.audi.tghu.navi.app.sds.NotifyNaviServiceListenerCommand;

class AbstractAddressInputSDSFormEvo$4
extends NotifyNaviServiceListenerCommand {
    private final /* synthetic */ AbstractAddressInputSDSFormEvo this$0;

    AbstractAddressInputSDSFormEvo$4(AbstractAddressInputSDSFormEvo abstractAddressInputSDSFormEvo, NaviServiceListener naviServiceListener) {
        this.this$0 = abstractAddressInputSDSFormEvo;
        super(naviServiceListener);
    }

    @Override
    protected void call(NaviServiceListener naviServiceListener) {
        naviServiceListener.responseStartDestinationInput((byte)1);
    }
}

