/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.map.handler;

import de.audi.app.navi.evo.map.handler.DrawerStateHandlerEvo;
import de.audi.app.navi.evo.map.handler.DrawerStateHandlerEvo$1;
import de.audi.atip.hmi.drawerfocus.DrawerFocusUtil;
import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.hmi.model.listener.DefaultChoiceListener;

class DrawerStateHandlerEvo$DrawerStateModelListener
extends DefaultChoiceListener
implements ChoiceListener {
    private final /* synthetic */ DrawerStateHandlerEvo this$0;

    private DrawerStateHandlerEvo$DrawerStateModelListener(DrawerStateHandlerEvo drawerStateHandlerEvo) {
        this.this$0 = drawerStateHandlerEvo;
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        DrawerStateHandlerEvo.access$100(this.this$0).getMapMainLogChannel().log(1078071040, "DrawerStateHandlerEvo#DrawerStateModelListener#itemSelected modelID=%1 itemID=%2", (long)n, (long)n2);
        if (n != -182385152) {
            DrawerStateHandlerEvo.access$100(this.this$0).getMapMainLogChannel().log(-1601830656, "DrawerStateHandlerEvo#DrawerStateModelListener#itemSelected unexpected model ID: %1", (long)n);
            return;
        }
        DrawerStateHandlerEvo.access$200(this.this$0).setValue(n2);
        if (DrawerFocusUtil.isFocusGained(n2)) {
            DrawerStateHandlerEvo.access$300(this.this$0);
        } else if (DrawerFocusUtil.isFocusLost(n2)) {
            DrawerStateHandlerEvo.access$400(this.this$0);
        }
    }

    /* synthetic */ DrawerStateHandlerEvo$DrawerStateModelListener(DrawerStateHandlerEvo drawerStateHandlerEvo, DrawerStateHandlerEvo$1 drawerStateHandlerEvo$1) {
        this(drawerStateHandlerEvo);
    }
}

