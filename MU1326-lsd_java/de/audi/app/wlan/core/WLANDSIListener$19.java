/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.wlan.core;

import de.audi.app.wlan.core.WLANDSIListener;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.networking.DSIWLANListener;

class WLANDSIListener$19
extends CommandResponse {
    private final /* synthetic */ boolean val$wlanEnabled;
    private final /* synthetic */ int val$validFlag;
    private final /* synthetic */ WLANDSIListener this$0;

    WLANDSIListener$19(WLANDSIListener wLANDSIListener, boolean bl, int n) {
        this.this$0 = wLANDSIListener;
        this.val$wlanEnabled = bl;
        this.val$validFlag = n;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSIWLANListener)dSIListener).updateWlanEnabled(this.val$wlanEnabled, this.val$validFlag);
    }
}

