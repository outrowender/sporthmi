/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.wlan.core;

import de.audi.app.wlan.core.WLANDSIListener;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.networking.DSIWLANListener;

class WLANDSIListener$15
extends CommandResponse {
    private final /* synthetic */ int val$rfActive;
    private final /* synthetic */ int val$validFlag;
    private final /* synthetic */ WLANDSIListener this$0;

    WLANDSIListener$15(WLANDSIListener wLANDSIListener, int n, int n2) {
        this.this$0 = wLANDSIListener;
        this.val$rfActive = n;
        this.val$validFlag = n2;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSIWLANListener)dSIListener).updateRFActive(this.val$rfActive, this.val$validFlag);
    }
}

