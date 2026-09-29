/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.wlan.core;

import de.audi.app.wlan.core.WLANDSIListener;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.networking.DSIWLANListener;

class WLANDSIListener$6
extends CommandResponse {
    private final /* synthetic */ int val$numNetworks;
    private final /* synthetic */ int val$result;
    private final /* synthetic */ WLANDSIListener this$0;

    WLANDSIListener$6(WLANDSIListener wLANDSIListener, int n, int n2) {
        this.this$0 = wLANDSIListener;
        this.val$numNetworks = n;
        this.val$result = n2;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSIWLANListener)dSIListener).responseNetworkSearch(this.val$numNetworks, this.val$result);
    }
}

