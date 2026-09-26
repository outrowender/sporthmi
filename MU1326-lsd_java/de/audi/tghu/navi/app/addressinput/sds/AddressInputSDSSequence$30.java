/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.sds;

import de.audi.atip.interapp.NaviServiceListener;
import de.audi.tghu.navi.app.addressinput.sds.AddressInputSDSSequence;
import de.audi.tghu.navi.app.sds.NotifyNaviServiceListenerCommand;
import org.dsi.ifc.global.NavLocation;

class AddressInputSDSSequence$30
extends NotifyNaviServiceListenerCommand {
    private final /* synthetic */ AddressInputSDSSequence this$0;

    AddressInputSDSSequence$30(AddressInputSDSSequence addressInputSDSSequence, NaviServiceListener naviServiceListener) {
        this.this$0 = addressInputSDSSequence;
        super(naviServiceListener);
    }

    @Override
    protected void call(NaviServiceListener naviServiceListener) {
        NavLocation navLocation = this.dsiResponseContainer.getLiCurrentLD();
        naviServiceListener.responseSetSpelledLocationPart(navLocation.isPositionValid() ? (byte)0 : 2);
    }
}

