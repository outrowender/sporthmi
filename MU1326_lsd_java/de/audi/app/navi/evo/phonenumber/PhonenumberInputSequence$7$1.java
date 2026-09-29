/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.phonenumber;

import de.audi.app.navi.evo.phonenumber.PhonenumberInputSequence$7;
import de.audi.atip.interapp.NaviServiceListener;
import de.audi.tghu.navi.app.sds.NotifyNaviServiceListenerCommand;

class PhonenumberInputSequence$7$1
extends NotifyNaviServiceListenerCommand {
    private final /* synthetic */ PhonenumberInputSequence$7 this$1;

    PhonenumberInputSequence$7$1(PhonenumberInputSequence$7 phonenumberInputSequence$7, NaviServiceListener naviServiceListener) {
        this.this$1 = phonenumberInputSequence$7;
        super(naviServiceListener);
    }

    @Override
    protected void call(NaviServiceListener naviServiceListener) {
        naviServiceListener.responseTelephoneNumberResult((byte)3);
    }
}

