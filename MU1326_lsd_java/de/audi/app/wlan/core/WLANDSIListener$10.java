/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.wlan.core;

import de.audi.app.wlan.core.WLANDSIListener;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;

class WLANDSIListener$10
extends CommandResponse {
    private final /* synthetic */ WLANDSIListener this$0;

    WLANDSIListener$10(WLANDSIListener wLANDSIListener) {
        this.this$0 = wLANDSIListener;
    }

    @Override
    public void call(DSIListener dSIListener) {
        WLANDSIListener.access$000(this.this$0).log(-1601830656, "WLANDSIListener#responseActivateWps not implemented");
    }
}

