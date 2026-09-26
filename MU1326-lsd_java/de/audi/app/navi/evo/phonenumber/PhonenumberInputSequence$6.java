/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.phonenumber;

import de.audi.app.navi.evo.phonenumber.PhonenumberInputSequence;
import de.audi.atip.interapp.NaviServiceListener;
import de.audi.tghu.navi.app.sds.NotifyNaviServiceListenerCommand;

class PhonenumberInputSequence$6
extends NotifyNaviServiceListenerCommand {
    private final /* synthetic */ PhonenumberInputSequence this$0;

    PhonenumberInputSequence$6(PhonenumberInputSequence phonenumberInputSequence, NaviServiceListener naviServiceListener) {
        this.this$0 = phonenumberInputSequence;
        super(naviServiceListener);
    }

    @Override
    protected void call(NaviServiceListener naviServiceListener) {
        naviServiceListener.responseTelephoneNumberResult((byte)3);
    }
}

