/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.connectivity.IDiagComponent
 */
package de.audi.app.connectivity.manager;

import de.audi.app.connectivity.manager.CoMaSelectionHandler;
import de.mib.swdiagnosis.connectivity.IDiagComponent;

class CoMaSelectionHandler$1
implements IDiagComponent {
    private final /* synthetic */ CoMaSelectionHandler this$0;

    CoMaSelectionHandler$1(CoMaSelectionHandler coMaSelectionHandler) {
        this.this$0 = coMaSelectionHandler;
    }

    public void cmdComaSelectionHandlerEnableSDISConnection() {
        this.this$0.updateSdisConnected(true);
    }

    public void cmdComaSelectionHandlerDisableSDISConnection() {
        this.this$0.updateSdisConnected(false);
    }
}

