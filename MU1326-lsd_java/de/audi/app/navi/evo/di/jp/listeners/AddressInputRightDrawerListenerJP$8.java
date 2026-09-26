/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.jp.listeners;

import de.audi.app.navi.evo.di.jp.listeners.AddressInputRightDrawerListenerJP;
import de.audi.tghu.command.ICommandList;
import de.audi.tghu.navi.app.navlocationextractor.NavLocationCallback;
import org.dsi.ifc.global.NavLocation;

class AddressInputRightDrawerListenerJP$8
implements NavLocationCallback {
    private final /* synthetic */ AddressInputRightDrawerListenerJP this$0;

    AddressInputRightDrawerListenerJP$8(AddressInputRightDrawerListenerJP addressInputRightDrawerListenerJP) {
        this.this$0 = addressInputRightDrawerListenerJP;
    }

    @Override
    public void callBack(NavLocation navLocation, ICommandList iCommandList) {
        AddressInputRightDrawerListenerJP.access$2100(this.this$0).log(-2137614336, "%1#handleKeyPressedForList navlocation is %2", (Object)AddressInputRightDrawerListenerJP.access$2000(this.this$0), (Object)navLocation);
        AddressInputRightDrawerListenerJP.access$2200(this.this$0).startStoringNavLocationOnAdbEntry(navLocation);
    }
}

