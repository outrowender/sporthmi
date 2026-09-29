/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.parking.pla;

import de.audi.app.earlyfunc.core.parking.pla.PLAPopinHandler;
import de.audi.app.earlyfunc.core.parking.pla.PLAPopinHandler$AbstractPlaSMState;
import org.dsi.ifc.carparkingsystem.DisplayContent;

class PLAPopinHandler$4
extends PLAPopinHandler$AbstractPlaSMState {
    private final /* synthetic */ PLAPopinHandler this$0;

    PLAPopinHandler$4(PLAPopinHandler pLAPopinHandler, int n, int n2, boolean bl, String string) {
        this.this$0 = pLAPopinHandler;
        super(pLAPopinHandler, n, n2, bl, string);
    }

    @Override
    protected void processVpsOpsPopupUpdate(DisplayContent displayContent, boolean bl) {
        if (bl) {
            if (PLAPopinHandler.access$500(this.this$0).hasVPSContent(displayContent)) {
                PLAPopinHandler.access$000(this.this$0, this, 0);
                PLAPopinHandler.access$400(this.this$0, this);
                PLAPopinHandler.access$300(this.this$0, this);
            }
        } else {
            PLAPopinHandler.access$700(this.this$0, this, false);
        }
    }

    @Override
    protected void hijackParkingController() {
    }

    @Override
    protected void releaseParkingController() {
        PLAPopinHandler.access$700(this.this$0, this, false);
    }
}

