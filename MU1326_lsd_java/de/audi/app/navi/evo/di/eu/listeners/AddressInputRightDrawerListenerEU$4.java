/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.eu.listeners;

import de.audi.app.navi.evo.di.eu.listeners.AddressInputRightDrawerListenerEU;
import de.audi.tghu.command.ICommandList;
import de.audi.tghu.navi.app.navlocationextractor.NavLocationCallback;
import org.dsi.ifc.global.NavLocation;

class AddressInputRightDrawerListenerEU$4
implements NavLocationCallback {
    private final /* synthetic */ AddressInputRightDrawerListenerEU this$0;

    AddressInputRightDrawerListenerEU$4(AddressInputRightDrawerListenerEU addressInputRightDrawerListenerEU) {
        this.this$0 = addressInputRightDrawerListenerEU;
    }

    @Override
    public void callBack(NavLocation navLocation, ICommandList iCommandList) {
        AddressInputRightDrawerListenerEU.access$1000(this.this$0).log(-2137614336, "%1#handleKeyPressedForList navlocation is %2", (Object)AddressInputRightDrawerListenerEU.access$900(this.this$0), (Object)navLocation);
        iCommandList.commandFinishedWithPostSequence(AddressInputRightDrawerListenerEU.access$1100(this.this$0).getStartParkingNearDestination(navLocation));
    }
}

