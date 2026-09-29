/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.wlan.core;

import de.audi.app.wlan.core.WLANDSIListener;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.networking.DSIWLANListener;
import org.dsi.ifc.networking.Profile;

class WLANDSIListener$14
extends CommandResponse {
    private final /* synthetic */ Profile val$profile;
    private final /* synthetic */ int val$validFlag;
    private final /* synthetic */ WLANDSIListener this$0;

    WLANDSIListener$14(WLANDSIListener wLANDSIListener, Profile profile, int n) {
        this.this$0 = wLANDSIListener;
        this.val$profile = profile;
        this.val$validFlag = n;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSIWLANListener)dSIListener).updateProfile(this.val$profile, this.val$validFlag);
    }
}

