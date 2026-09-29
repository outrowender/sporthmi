/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.nar.listeners;

import de.audi.app.navi.evo.di.nar.listeners.AddressInputRightDrawerListenerNAR;
import de.audi.tghu.command.ICommandList;
import de.audi.tghu.navi.app.navlocationextractor.NavLocationCallback;
import org.dsi.ifc.global.NavLocation;

class AddressInputRightDrawerListenerNAR$5
implements NavLocationCallback {
    private final /* synthetic */ AddressInputRightDrawerListenerNAR this$0;

    AddressInputRightDrawerListenerNAR$5(AddressInputRightDrawerListenerNAR addressInputRightDrawerListenerNAR) {
        this.this$0 = addressInputRightDrawerListenerNAR;
    }

    @Override
    public void callBack(NavLocation navLocation, ICommandList iCommandList) {
        AddressInputRightDrawerListenerNAR.access$1300(this.this$0).log(-2137614336, "%1#handleKeyPressedForList navlocation is %2", (Object)AddressInputRightDrawerListenerNAR.access$1200(this.this$0), (Object)navLocation);
        AddressInputRightDrawerListenerNAR.access$1400(this.this$0).destOptShowInMap(navLocation);
    }
}

