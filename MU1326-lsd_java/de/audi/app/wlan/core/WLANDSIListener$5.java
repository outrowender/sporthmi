/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.wlan.core;

import de.audi.app.wlan.core.WLANDSIListener;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.networking.DSIWLANListener;

class WLANDSIListener$5
extends CommandResponse {
    private final /* synthetic */ int val$result;
    private final /* synthetic */ WLANDSIListener this$0;

    WLANDSIListener$5(WLANDSIListener wLANDSIListener, int n) {
        this.this$0 = wLANDSIListener;
        this.val$result = n;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSIWLANListener)dSIListener).responseFactoryReset(this.val$result);
    }
}

