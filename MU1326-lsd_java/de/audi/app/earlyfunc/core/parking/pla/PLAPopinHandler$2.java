/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.parking.pla;

import de.audi.app.earlyfunc.core.parking.pla.PLAPopinHandler;
import de.audi.app.earlyfunc.core.parking.pla.PLAPopinHandler$AbstractPlaSMState;
import org.dsi.ifc.carparkingsystem.DisplayContent;

class PLAPopinHandler$2
extends PLAPopinHandler$AbstractPlaSMState {
    private final /* synthetic */ PLAPopinHandler this$0;

    PLAPopinHandler$2(PLAPopinHandler pLAPopinHandler, int n, int n2, boolean bl, String string) {
        this.this$0 = pLAPopinHandler;
        super(pLAPopinHandler, n, n2, bl, string);
    }

    @Override
    protected void processVpsOpsPopupUpdate(DisplayContent displayContent, boolean bl) {
        if (PLAPopinHandler.access$500(this.this$0).hasVPSContent(displayContent)) {
            PLAPopinHandler.access$200(this.this$0, displayContent);
            int n = this.getPLAReplacementPopupID(displayContent);
            if (bl) {
                DisplayContent displayContent2 = new DisplayContent();
                displayContent2.popup = n;
                displayContent2.view = displayContent.view;
                displayContent2.screen = displayContent.screen;
                displayContent2.mode = displayContent.mode;
                PLAPopinHandler.access$600(this.this$0).log(1078071040, "[AbstractPlaSMState('%1')#processVpsOpsPopupUpdate] controller.changeDisplayContent('%2')", (Object)this, (Object)displayContent2);
                PLAPopinHandler.access$500(this.this$0).changeDisplayContent(displayContent2, false);
            } else {
                displayContent.popup = n;
                PLAPopinHandler.access$600(this.this$0).log(1078071040, "[AbstractPlaSMState('%1')#processVpsOpsPopupUpdate] changed DisplayContent for dsi.showParkingPopup() to '%2'", (Object)this, (Object)displayContent);
            }
        } else if (displayContent.popup == 0 || !bl && !PLAPopinHandler.access$500(this.this$0).hasOPSContent(displayContent)) {
            PLAPopinHandler.access$200(this.this$0, null);
        }
    }

    @Override
    protected void hijackParkingController() {
        PLAPopinHandler.access$000(this.this$0, this, 1);
        PLAPopinHandler.access$700(this.this$0, this, true);
        PLAPopinHandler.access$800(this.this$0).getFrameworkAccess().getPowerMgr().setExtendedPowerState(140, 0);
        PLAPopinHandler.access$900(this.this$0, this);
        PLAPopinHandler.access$1000(this.this$0, this);
    }

    @Override
    protected void releaseParkingController() {
        PLAPopinHandler.access$700(this.this$0, this, false);
        if (PLAPopinHandler.access$100(this.this$0)) {
            PLAPopinHandler.access$102(this.this$0, false);
            if (PLAPopinHandler.access$1100(this.this$0)) {
                return;
            }
        }
        if (PLAPopinHandler.access$1200(this.this$0) != null) {
            DisplayContent displayContent = PLAPopinHandler.access$1200(this.this$0);
            PLAPopinHandler.access$1300(this.this$0, displayContent);
            PLAPopinHandler.access$600(this.this$0).log(1078071040, "[AbstractPlaSMState('%1')#releaseParkingController] controller.changeDisplayContent('%2','true')", (Object)this, (Object)displayContent);
            PLAPopinHandler.access$500(this.this$0).changeDisplayContent(displayContent, true);
            PLAPopinHandler.access$200(this.this$0, null);
        } else {
            PLAPopinHandler.access$300(this.this$0, this);
            PLAPopinHandler.access$400(this.this$0, this);
            if (!PLAPopinHandler.access$1100(this.this$0)) {
                PLAPopinHandler.access$800(this.this$0).getFrameworkAccess().getPowerMgr().setExtendedPowerState(142, 0);
            }
        }
    }
}

