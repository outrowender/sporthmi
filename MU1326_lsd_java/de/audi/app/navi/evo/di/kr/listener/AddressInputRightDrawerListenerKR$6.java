/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.kr.listener;

import de.audi.app.navi.evo.di.kr.listener.AddressInputRightDrawerListenerKR;
import de.audi.tghu.command.ICommandList;
import de.audi.tghu.navi.app.navlocationextractor.NavLocationCallback;
import org.dsi.ifc.global.NavLocation;

class AddressInputRightDrawerListenerKR$6
implements NavLocationCallback {
    private final /* synthetic */ AddressInputRightDrawerListenerKR this$0;

    AddressInputRightDrawerListenerKR$6(AddressInputRightDrawerListenerKR addressInputRightDrawerListenerKR) {
        this.this$0 = addressInputRightDrawerListenerKR;
    }

    @Override
    public void callBack(NavLocation navLocation, ICommandList iCommandList) {
        AddressInputRightDrawerListenerKR.access$1600(this.this$0).log(-2137614336, "%1#handleKeyPressedForList navlocation is %2", (Object)AddressInputRightDrawerListenerKR.access$1500(this.this$0), (Object)navLocation);
        AddressInputRightDrawerListenerKR.access$1400(this.this$0).destOptShowInMap(navLocation);
    }
}

