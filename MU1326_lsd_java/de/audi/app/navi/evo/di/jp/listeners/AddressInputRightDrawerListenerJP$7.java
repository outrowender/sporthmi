/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.jp.listeners;

import de.audi.app.navi.evo.di.jp.listeners.AddressInputRightDrawerListenerJP;
import de.audi.tghu.command.ICommandList;
import de.audi.tghu.navi.app.navlocationextractor.NavLocationCallback;
import org.dsi.ifc.global.NavLocation;

class AddressInputRightDrawerListenerJP$7
implements NavLocationCallback {
    private final /* synthetic */ AddressInputRightDrawerListenerJP this$0;

    AddressInputRightDrawerListenerJP$7(AddressInputRightDrawerListenerJP addressInputRightDrawerListenerJP) {
        this.this$0 = addressInputRightDrawerListenerJP;
    }

    @Override
    public void callBack(NavLocation navLocation, ICommandList iCommandList) {
        AddressInputRightDrawerListenerJP.access$1800(this.this$0).log(-2137614336, "%1#handleKeyPressedForList navlocation is %2", (Object)AddressInputRightDrawerListenerJP.access$1700(this.this$0), (Object)navLocation);
        AddressInputRightDrawerListenerJP.access$1900(this.this$0).startStoringNavLocationOnAdbEntry(navLocation);
    }
}

