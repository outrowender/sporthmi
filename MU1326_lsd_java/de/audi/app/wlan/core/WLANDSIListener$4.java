/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.wlan.core;

import de.audi.app.wlan.core.WLANDSIListener;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.networking.DSIWLANListener;

class WLANDSIListener$4
extends CommandResponse {
    private final /* synthetic */ String val$networkName;
    private final /* synthetic */ String val$bssidAddress;
    private final /* synthetic */ int val$result;
    private final /* synthetic */ WLANDSIListener this$0;

    WLANDSIListener$4(WLANDSIListener wLANDSIListener, String string, String string2, int n) {
        this.this$0 = wLANDSIListener;
        this.val$networkName = string;
        this.val$bssidAddress = string2;
        this.val$result = n;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSIWLANListener)dSIListener).responseDisconnectNetwork(this.val$networkName, this.val$bssidAddress, this.val$result);
    }
}

