/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.wlan.core;

import de.audi.app.wlan.core.WLANDSIListener;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.networking.DSIWLANListener;

class WLANDSIListener$11
extends CommandResponse {
    private final /* synthetic */ String val$networkName;
    private final /* synthetic */ String val$bssidAddress;
    private final /* synthetic */ int val$signalStrength;
    private final /* synthetic */ int val$validFlag;
    private final /* synthetic */ WLANDSIListener this$0;

    WLANDSIListener$11(WLANDSIListener wLANDSIListener, String string, String string2, int n, int n2) {
        this.this$0 = wLANDSIListener;
        this.val$networkName = string;
        this.val$bssidAddress = string2;
        this.val$signalStrength = n;
        this.val$validFlag = n2;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSIWLANListener)dSIListener).updateConnectedNetwork(this.val$networkName, this.val$bssidAddress, this.val$signalStrength, this.val$validFlag);
    }
}

