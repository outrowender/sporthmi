/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.dab;

import de.audi.tuner.app.IDrawerFocusManager;
import de.audi.tuner.app.dab.GUIHandlerDAB;
import de.audi.tuner.app.dab.GUIHandlerDAB$1;
import de.audi.tuner.app.dab.stationlist.DabListRow;
import de.audi.tuner.ifc.ISearchBreak;
import de.audi.tuner.ifc.IStationListHandler;
import de.audi.tuner.ifc.listener.IUpdateListener;

class GUIHandlerDAB$StationListHandler
implements IStationListHandler {
    private final /* synthetic */ GUIHandlerDAB this$0;

    private GUIHandlerDAB$StationListHandler(GUIHandlerDAB gUIHandlerDAB) {
        this.this$0 = gUIHandlerDAB;
    }

    @Override
    public void register(ISearchBreak iSearchBreak, int n) {
        throw new IllegalArgumentException();
    }

    @Override
    public void register(IDrawerFocusManager iDrawerFocusManager) {
        GUIHandlerDAB.access$802(this.this$0, iDrawerFocusManager);
    }

    @Override
    public boolean tuneById(long l, int n) {
        return GUIHandlerDAB.access$600(this.this$0).tuneById(l, n);
    }

    @Override
    public void addUpdateListener(IUpdateListener iUpdateListener) {
        GUIHandlerDAB.access$600(this.this$0).addUpdateListener(iUpdateListener);
    }

    @Override
    public void setPrefImgType(int n) {
        GUIHandlerDAB.access$500(this.this$0).setPrefImgType(n);
        GUIHandlerDAB.access$600(this.this$0).setPrefImgType(n);
        GUIHandlerDAB.access$1000(this.this$0).setPrefImgType(n);
        this.this$0.labels.setPrefImgType(n);
    }

    @Override
    public boolean isEnsemble(int n) {
        DabListRow dabListRow;
        if (this.this$0.isSortModeAlphabetically()) {
            return false;
        }
        return n < GUIHandlerDAB.access$900(this.this$0).getBaseListModel(-1954021120).getLength() && (dabListRow = (DabListRow)GUIHandlerDAB.access$900(this.this$0).getBaseListModel(-1954021120).getRow(n)).isEnsemble();
    }

    /* synthetic */ GUIHandlerDAB$StationListHandler(GUIHandlerDAB gUIHandlerDAB, GUIHandlerDAB$1 gUIHandlerDAB$1) {
        this(gUIHandlerDAB);
    }
}

