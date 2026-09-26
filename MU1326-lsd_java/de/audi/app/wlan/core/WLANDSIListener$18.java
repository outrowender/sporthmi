/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.wlan.core;

import de.audi.app.wlan.core.WLANDSIListener;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.networking.DSIWLANListener;

class WLANDSIListener$18
extends CommandResponse {
    private final /* synthetic */ String[] val$networkNames;
    private final /* synthetic */ String[] val$bssidAddresses;
    private final /* synthetic */ int[] val$encryptionTypes;
    private final /* synthetic */ int val$validFlag;
    private final /* synthetic */ WLANDSIListener this$0;

    WLANDSIListener$18(WLANDSIListener wLANDSIListener, String[] stringArray, String[] stringArray2, int[] nArray, int n) {
        this.this$0 = wLANDSIListener;
        this.val$networkNames = stringArray;
        this.val$bssidAddresses = stringArray2;
        this.val$encryptionTypes = nArray;
        this.val$validFlag = n;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSIWLANListener)dSIListener).updateTrustedNetworks(this.val$networkNames, this.val$bssidAddresses, this.val$encryptionTypes, this.val$validFlag);
    }
}

