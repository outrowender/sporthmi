/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.parking.pla;

import de.audi.app.earlyfunc.core.parking.pla.PLAPopinHandler;
import de.audi.app.earlyfunc.core.parking.pla.PLAPopinHandler$AbstractPlaSMState;
import org.dsi.ifc.carparkingsystem.DisplayContent;

class PLAPopinHandler$3
extends PLAPopinHandler$AbstractPlaSMState {
    private final /* synthetic */ PLAPopinHandler this$0;

    PLAPopinHandler$3(PLAPopinHandler pLAPopinHandler, int n, int n2, boolean bl, String string) {
        this.this$0 = pLAPopinHandler;
        super(pLAPopinHandler, n, n2, bl, string);
    }

    @Override
    protected void processVpsOpsPopupUpdate(DisplayContent displayContent, boolean bl) {
    }

    @Override
    protected void hijackParkingController() {
        PLAPopinHandler.access$700(this.this$0, this, true);
    }

    @Override
    protected void releaseParkingController() {
        PLAPopinHandler.access$700(this.this$0, this, false);
    }
}

