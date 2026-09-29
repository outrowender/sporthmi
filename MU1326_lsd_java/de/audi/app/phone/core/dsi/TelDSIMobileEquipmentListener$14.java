/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi;

import de.audi.app.phone.core.dsi.ITelDSIMobileEquipementResponseListener;
import de.audi.app.phone.core.dsi.TelDSIMobileEquipmentListener;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.telephoneng.NetworkProvider;

class TelDSIMobileEquipmentListener$14
extends CommandResponse {
    private final /* synthetic */ NetworkProvider[] val$telNetworkProviders;
    private final /* synthetic */ int val$result;
    private final /* synthetic */ TelDSIMobileEquipmentListener this$0;

    TelDSIMobileEquipmentListener$14(TelDSIMobileEquipmentListener telDSIMobileEquipmentListener, NetworkProvider[] networkProviderArray, int n) {
        this.this$0 = telDSIMobileEquipmentListener;
        this.val$telNetworkProviders = networkProviderArray;
        this.val$result = n;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((ITelDSIMobileEquipementResponseListener)dSIListener).responseNetworkSearch(this.val$telNetworkProviders, this.val$result);
    }
}

