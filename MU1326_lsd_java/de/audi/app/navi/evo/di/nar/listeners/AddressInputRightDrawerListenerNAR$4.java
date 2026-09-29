/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.nar.listeners;

import de.audi.app.navi.evo.di.nar.listeners.AddressInputRightDrawerListenerNAR;
import de.audi.tghu.command.ICommandList;
import de.audi.tghu.navi.app.navlocationextractor.NavLocationCallback;
import org.dsi.ifc.global.NavLocation;

class AddressInputRightDrawerListenerNAR$4
implements NavLocationCallback {
    private final /* synthetic */ AddressInputRightDrawerListenerNAR this$0;

    AddressInputRightDrawerListenerNAR$4(AddressInputRightDrawerListenerNAR addressInputRightDrawerListenerNAR) {
        this.this$0 = addressInputRightDrawerListenerNAR;
    }

    @Override
    public void callBack(NavLocation navLocation, ICommandList iCommandList) {
        AddressInputRightDrawerListenerNAR.access$1000(this.this$0).log(-2137614336, "%1#handleKeyPressedForList navlocation is %2", (Object)AddressInputRightDrawerListenerNAR.access$900(this.this$0), (Object)navLocation);
        iCommandList.commandFinishedWithPostSequence(AddressInputRightDrawerListenerNAR.access$1100(this.this$0).getStartParkingNearDestination(navLocation));
    }
}

