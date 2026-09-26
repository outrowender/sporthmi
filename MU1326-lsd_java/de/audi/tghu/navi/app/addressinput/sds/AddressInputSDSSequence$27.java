/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.sds;

import de.audi.atip.interapp.NaviServiceListener;
import de.audi.tghu.navi.app.addressinput.sds.AddressInputSDSSequence;
import de.audi.tghu.navi.app.sds.NotifyNaviServiceListenerCommand;

class AddressInputSDSSequence$27
extends NotifyNaviServiceListenerCommand {
    private final /* synthetic */ AddressInputSDSSequence this$0;

    AddressInputSDSSequence$27(AddressInputSDSSequence addressInputSDSSequence, NaviServiceListener naviServiceListener) {
        this.this$0 = addressInputSDSSequence;
        super(naviServiceListener);
    }

    @Override
    protected void call(NaviServiceListener naviServiceListener) {
        String[] stringArray = (String[])this.getCommandList().get("SPELLING_ENTRIES");
        Object[] objectArray = (Object[])this.getCommandList().get("SPELLING_INDICES");
        boolean bl = stringArray != null && objectArray != null;
        naviServiceListener.responseQuerySpelledLocationPartResultList(bl ? (byte)0 : 3, stringArray, objectArray);
    }
}

