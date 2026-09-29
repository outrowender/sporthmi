/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.eu.listeners;

import de.audi.app.navi.evo.di.eu.listeners.AddressInputRightDrawerListenerEU;
import de.audi.tghu.command.ICommandList;
import de.audi.tghu.navi.app.navlocationextractor.NavLocationCallback;
import org.dsi.ifc.global.NavLocation;

class AddressInputRightDrawerListenerEU$8
implements NavLocationCallback {
    private final /* synthetic */ AddressInputRightDrawerListenerEU this$0;

    AddressInputRightDrawerListenerEU$8(AddressInputRightDrawerListenerEU addressInputRightDrawerListenerEU) {
        this.this$0 = addressInputRightDrawerListenerEU;
    }

    @Override
    public void callBack(NavLocation navLocation, ICommandList iCommandList) {
        AddressInputRightDrawerListenerEU.access$2100(this.this$0).log(-2137614336, "%1#handleKeyPressedForList navlocation is %2", (Object)AddressInputRightDrawerListenerEU.access$2000(this.this$0), (Object)navLocation);
        AddressInputRightDrawerListenerEU.access$2200(this.this$0).startStoringNavLocationOnAdbEntry(navLocation);
    }
}

