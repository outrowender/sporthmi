/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.sds;

import de.audi.app.navi.evo.addressinput.sds.AbstractAddressInputSDSFormJpKr;
import de.audi.atip.interapp.NaviServiceListener;
import de.audi.tghu.navi.app.sds.NotifyNaviServiceListenerCommand;

class AbstractAddressInputSDSFormJpKr$2
extends NotifyNaviServiceListenerCommand {
    private final /* synthetic */ AbstractAddressInputSDSFormJpKr this$0;

    AbstractAddressInputSDSFormJpKr$2(AbstractAddressInputSDSFormJpKr abstractAddressInputSDSFormJpKr, NaviServiceListener naviServiceListener) {
        this.this$0 = abstractAddressInputSDSFormJpKr;
        super(naviServiceListener);
    }

    @Override
    protected void call(NaviServiceListener naviServiceListener) {
        naviServiceListener.responseTelephoneNumberResult((byte)1);
    }
}

