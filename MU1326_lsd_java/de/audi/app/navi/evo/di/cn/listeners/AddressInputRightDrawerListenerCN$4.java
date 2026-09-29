/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.cn.listeners;

import de.audi.app.navi.evo.di.cn.listeners.AddressInputRightDrawerListenerCN;
import de.audi.tghu.command.ICommandList;
import de.audi.tghu.navi.app.navlocationextractor.NavLocationCallback;
import org.dsi.ifc.global.NavLocation;

class AddressInputRightDrawerListenerCN$4
implements NavLocationCallback {
    private final /* synthetic */ AddressInputRightDrawerListenerCN this$0;

    AddressInputRightDrawerListenerCN$4(AddressInputRightDrawerListenerCN addressInputRightDrawerListenerCN) {
        this.this$0 = addressInputRightDrawerListenerCN;
    }

    @Override
    public void callBack(NavLocation navLocation, ICommandList iCommandList) {
        AddressInputRightDrawerListenerCN.access$1000(this.this$0).log(-2137614336, "%1#handleKeyPressedForList navlocation is %2", (Object)AddressInputRightDrawerListenerCN.access$900(this.this$0), (Object)navLocation);
        AddressInputRightDrawerListenerCN.access$1100(this.this$0).startPoiNearDestination(navLocation);
        iCommandList.commandFinished();
    }
}

