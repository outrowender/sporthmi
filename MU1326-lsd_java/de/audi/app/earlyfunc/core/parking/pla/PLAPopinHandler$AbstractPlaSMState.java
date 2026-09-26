/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.parking.pla;

import de.audi.app.earlyfunc.core.parking.pla.PLAPopinHandler;
import org.dsi.ifc.carparkingsystem.DisplayContent;

abstract class PLAPopinHandler$AbstractPlaSMState {
    private final int id;
    private final String stateName;
    private final int screen;
    private final boolean plaActive;
    private final /* synthetic */ PLAPopinHandler this$0;

    PLAPopinHandler$AbstractPlaSMState(PLAPopinHandler pLAPopinHandler, int n, int n2, boolean bl, String string) {
        this.this$0 = pLAPopinHandler;
        this.id = n;
        this.screen = n2;
        this.plaActive = bl;
        this.stateName = string;
    }

    int getId() {
        return this.id;
    }

    private int getScreen() {
        return this.screen;
    }

    private boolean isPlaActive() {
        return this.plaActive;
    }

    private String getStateName() {
        return this.stateName;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(30);
        stringBuffer.append(this.getStateName()).append('(').append(this.getId()).append(')');
        return stringBuffer.toString();
    }

    public int getPLAReplacementPopupID(DisplayContent displayContent) {
        return 15;
    }

    public void updateVpsOpsPopup(DisplayContent displayContent, boolean bl) {
        PLAPopinHandler.access$600(this.this$0).log(1078071040, "[AbstractPlaSMState('%1')#updateVpsOpsPopup] content='%2' , displayed='%3'", (Object)this, (Object)displayContent, (Object)bl);
        this.processVpsOpsPopupUpdate(displayContent, bl);
    }

    protected abstract void processVpsOpsPopupUpdate(DisplayContent displayContent, boolean bl) {
    }

    protected abstract void hijackParkingController() {
    }

    protected abstract void releaseParkingController() {
    }

    static /* synthetic */ int access$1400(PLAPopinHandler$AbstractPlaSMState pLAPopinHandler$AbstractPlaSMState) {
        return pLAPopinHandler$AbstractPlaSMState.getScreen();
    }
}

