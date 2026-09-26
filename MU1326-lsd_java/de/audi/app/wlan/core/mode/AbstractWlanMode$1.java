/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.connectivity.IDiagComponent
 */
package de.audi.app.wlan.core.mode;

import de.audi.app.wlan.core.mode.AbstractWlanMode;
import de.mib.swdiagnosis.connectivity.IDiagComponent;

class AbstractWlanMode$1
implements IDiagComponent {
    private final /* synthetic */ AbstractWlanMode this$0;

    AbstractWlanMode$1(AbstractWlanMode abstractWlanMode) {
        this.this$0 = abstractWlanMode;
    }

    public void cmdEnableSDISConnection() {
        this.this$0.updateSdisConnected(true);
    }

    public void cmdDisableSDISConnection() {
        this.this$0.updateSdisConnected(false);
    }
}

