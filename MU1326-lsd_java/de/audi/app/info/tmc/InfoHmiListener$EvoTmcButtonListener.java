/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.info.tmc;

import de.audi.app.info.tmc.InfoHmiListener;
import de.audi.app.info.tmc.InfoHmiListener$1;
import de.audi.atip.hmi.model.DefaultButtonListener;

class InfoHmiListener$EvoTmcButtonListener
extends DefaultButtonListener {
    private final /* synthetic */ InfoHmiListener this$0;

    private InfoHmiListener$EvoTmcButtonListener(InfoHmiListener infoHmiListener) {
        this.this$0 = infoHmiListener;
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        InfoHmiListener.access$500(this.this$0).log(1078071040, "InfoHmiListener#keyPressed() modelID=%1, TMC_REROUTING_CHOICE=%2, focusedRowIndex=%3", (long)n, (long)InfoHmiListener.access$400(this.this$0).getChoiceModel(-1331624192).getValue(), (long)InfoHmiListener.access$300(this.this$0).getFocusedRowIndex());
        if (n == InfoHmiListener.access$600(this.this$0).getID()) {
            if (InfoHmiListener.access$600(this.this$0).getStatus() == 1) {
                InfoHmiListener.access$300(this.this$0).loadNextDetailsScreen();
                InfoHmiListener.access$400(this.this$0).getButtonModel(n).fireEvent(n3);
            }
        } else if (n == InfoHmiListener.access$700(this.this$0).getID()) {
            if (InfoHmiListener.access$400(this.this$0).getChoiceModel(-1331624192).getValue() != 2) {
                return;
            }
            if (InfoHmiListener.access$200(this.this$0).getNaviService() != null) {
                InfoHmiListener.access$200(this.this$0).getNaviService().switchToSemidynamicRouteGuidance();
                InfoHmiListener.access$400(this.this$0).getButtonModel(n).fireEvent(n3);
            } else {
                InfoHmiListener.access$500(this.this$0).log(-1601830656, "InfoHmiListener#keyPressed() modelID=%1, NaviService is null", (long)n);
            }
        } else if (n == InfoHmiListener.access$800(this.this$0).getID()) {
            if (InfoHmiListener.access$300(this.this$0).getFocusedRowIndex() != 0) {
                InfoHmiListener.access$300(this.this$0).requestFirstWindowAndFocus();
            }
        } else {
            InfoHmiListener.access$500(this.this$0).log(-1601830656, "InfoHmiListener#keyPressed() no listener action defined for modelID=%1", (long)n);
        }
    }

    /* synthetic */ InfoHmiListener$EvoTmcButtonListener(InfoHmiListener infoHmiListener, InfoHmiListener$1 infoHmiListener$1) {
        this(infoHmiListener);
    }
}

