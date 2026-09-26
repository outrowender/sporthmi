/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.wlan.core;

import de.audi.app.wlan.core.WLANDSIListener;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.networking.DSIWLANListener;
import org.dsi.ifc.networking.DiscoveredNetwork;

class WLANDSIListener$12
extends CommandResponse {
    private final /* synthetic */ DiscoveredNetwork val$discoveredNetwork;
    private final /* synthetic */ int val$validFlag;
    private final /* synthetic */ WLANDSIListener this$0;

    WLANDSIListener$12(WLANDSIListener wLANDSIListener, DiscoveredNetwork discoveredNetwork, int n) {
        this.this$0 = wLANDSIListener;
        this.val$discoveredNetwork = discoveredNetwork;
        this.val$validFlag = n;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSIWLANListener)dSIListener).updateDiscoveredNetwork(this.val$discoveredNetwork, this.val$validFlag);
    }
}

