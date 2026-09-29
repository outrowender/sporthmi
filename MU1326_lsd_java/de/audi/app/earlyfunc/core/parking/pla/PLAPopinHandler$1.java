/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.parking.pla;

import de.audi.app.earlyfunc.core.parking.pla.PLAPopinHandler;
import de.audi.app.earlyfunc.core.parking.pla.PLAPopinHandler$AbstractPlaSMState;
import org.dsi.ifc.carparkingsystem.DisplayContent;

class PLAPopinHandler$1
extends PLAPopinHandler$AbstractPlaSMState {
    private final /* synthetic */ PLAPopinHandler this$0;

    PLAPopinHandler$1(PLAPopinHandler pLAPopinHandler, int n, int n2, boolean bl, String string) {
        this.this$0 = pLAPopinHandler;
        super(pLAPopinHandler, n, n2, bl, string);
    }

    @Override
    protected void processVpsOpsPopupUpdate(DisplayContent displayContent, boolean bl) {
        PLAPopinHandler.access$000(this.this$0, this, 0);
        PLAPopinHandler.access$102(this.this$0, false);
        PLAPopinHandler.access$200(this.this$0, null);
        PLAPopinHandler.access$300(this.this$0, this);
        PLAPopinHandler.access$400(this.this$0, this);
    }

    @Override
    protected void hijackParkingController() {
    }

    @Override
    protected void releaseParkingController() {
    }
}

