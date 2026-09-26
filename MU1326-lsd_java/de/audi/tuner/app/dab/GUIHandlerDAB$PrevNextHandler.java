/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.dab;

import de.audi.atip.hmi.model.update.ModelTrigger;
import de.audi.tuner.app.dab.GUIHandlerDAB;
import de.audi.tuner.app.dab.GUIHandlerDAB$1;
import de.audi.tuner.app.dab.stationlist.DabListRow;
import de.audi.tuner.ifc.IPrevNext;

class GUIHandlerDAB$PrevNextHandler
implements IPrevNext {
    private final /* synthetic */ GUIHandlerDAB this$0;

    private GUIHandlerDAB$PrevNextHandler(GUIHandlerDAB gUIHandlerDAB) {
        this.this$0 = gUIHandlerDAB;
    }

    @Override
    public void handlePrevNext(boolean bl) {
        GUIHandlerDAB.access$400((GUIHandlerDAB)this.this$0).dabDSI.log(1078071040, "[GUIHandlerDAB.PrevNextHandler.handlePrevNext]SelectNextSevice, direction is up: %1 ", bl);
        DabListRow dabListRow = this.this$0.isSortModeAlphabetically() ? GUIHandlerDAB.access$500(this.this$0).getNextObjectIndexFromList(bl) : GUIHandlerDAB.access$600(this.this$0).getNextObjectIndexFromList(bl);
        if (dabListRow != null) {
            GUIHandlerDAB.access$700(this.this$0).selectStation(dabListRow.getDabStation(), 0, 0);
        }
        if (!GUIHandlerDAB.access$800(this.this$0).isDrawerOpen()) {
            GUIHandlerDAB.access$900(this.this$0).getMenuModel(310903040).trigger(ModelTrigger.JOIN_CURSOR);
        }
    }

    /* synthetic */ GUIHandlerDAB$PrevNextHandler(GUIHandlerDAB gUIHandlerDAB, GUIHandlerDAB$1 gUIHandlerDAB$1) {
        this(gUIHandlerDAB);
    }
}

