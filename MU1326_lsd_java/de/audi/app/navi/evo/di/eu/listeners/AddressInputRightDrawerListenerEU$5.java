/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.eu.listeners;

import de.audi.app.navi.evo.di.eu.listeners.AddressInputRightDrawerListenerEU;
import de.audi.tghu.command.ICommandList;
import de.audi.tghu.navi.app.navlocationextractor.NavLocationCallback;
import org.dsi.ifc.global.NavLocation;

class AddressInputRightDrawerListenerEU$5
implements NavLocationCallback {
    private final /* synthetic */ AddressInputRightDrawerListenerEU this$0;

    AddressInputRightDrawerListenerEU$5(AddressInputRightDrawerListenerEU addressInputRightDrawerListenerEU) {
        this.this$0 = addressInputRightDrawerListenerEU;
    }

    @Override
    public void callBack(NavLocation navLocation, ICommandList iCommandList) {
        AddressInputRightDrawerListenerEU.access$1300(this.this$0).log(-2137614336, "%1#handleKeyPressedForList navlocation is %2", (Object)AddressInputRightDrawerListenerEU.access$1200(this.this$0), (Object)navLocation);
        AddressInputRightDrawerListenerEU.access$1400(this.this$0).destOptShowInMap(navLocation);
    }
}

