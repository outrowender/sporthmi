/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.sds;

import de.audi.atip.interapp.NaviServiceListener;
import de.audi.tghu.navi.app.addressinput.sds.AddressInputSDSSequence;
import de.audi.tghu.navi.app.sds.NotifyNaviServiceListenerCommand;

class AddressInputSDSSequence$21
extends NotifyNaviServiceListenerCommand {
    private final /* synthetic */ boolean val$isCountryOrStateSpeller;
    private final /* synthetic */ AddressInputSDSSequence this$0;

    AddressInputSDSSequence$21(AddressInputSDSSequence addressInputSDSSequence, NaviServiceListener naviServiceListener, boolean bl) {
        this.this$0 = addressInputSDSSequence;
        this.val$isCountryOrStateSpeller = bl;
        super(naviServiceListener);
    }

    @Override
    protected void call(NaviServiceListener naviServiceListener) {
        boolean bl;
        boolean bl2 = bl = this.dsiResponseContainer.getLiCurrentLD() != null && this.dsiResponseContainer.getLiCurrentLD().isPositionValid();
        if (this.this$0.logChannel.isDebug2()) {
            this.logger.log(14808325, "AddressInputSDSSequence#getSetInputSDSCommandList#NotifyNaviServiceListenerCommand liCurrentLD valid = %1, isCountryOrStateSpeller = %2", bl, this.val$isCountryOrStateSpeller);
        }
        boolean bl3 = bl || this.val$isCountryOrStateSpeller;
        naviServiceListener.responseSetLocationPart(bl3 ? (byte)0 : 1);
    }
}

