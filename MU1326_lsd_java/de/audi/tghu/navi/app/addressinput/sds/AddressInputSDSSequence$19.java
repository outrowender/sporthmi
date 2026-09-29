/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.sds;

import de.audi.atip.interapp.NaviServiceListener;
import de.audi.tghu.navi.app.addressinput.sds.AddressInputSDSSequence;
import de.audi.tghu.navi.app.sds.NotifyNaviServiceListenerCommand;

class AddressInputSDSSequence$19
extends NotifyNaviServiceListenerCommand {
    private final /* synthetic */ AddressInputSDSSequence this$0;

    AddressInputSDSSequence$19(AddressInputSDSSequence addressInputSDSSequence, NaviServiceListener naviServiceListener) {
        this.this$0 = addressInputSDSSequence;
        super(naviServiceListener);
    }

    @Override
    protected void call(NaviServiceListener naviServiceListener) {
        boolean bl = this.dsiResponseContainer.getLiCurrentLD().isPositionValid();
        boolean bl2 = this.dsiResponseContainer.selectionCriterionAvailable(127);
        if (bl || bl2) {
            if (bl2) {
                naviServiceListener.responseValidateSpelledStreetName((byte)2);
            } else {
                naviServiceListener.responseValidateSpelledStreetName((byte)0);
            }
        } else {
            naviServiceListener.responseValidateSpelledStreetName((byte)1);
        }
    }
}

