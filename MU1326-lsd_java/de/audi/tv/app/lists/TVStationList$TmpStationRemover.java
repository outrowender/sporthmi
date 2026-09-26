/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.lists;

import de.audi.atip.hmi.model.list.SelectedItem;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.audi.tv.app.lists.AbstractTVStationRow;
import de.audi.tv.app.lists.TVStationList;
import de.audi.tv.app.lists.TVStationList$1;

class TVStationList$TmpStationRemover
implements TimerListener {
    private final Timer timer = new Timer("tmpStationRemoveDelay", 0, true, this);
    private boolean canceled = false;
    private final /* synthetic */ TVStationList this$0;

    private TVStationList$TmpStationRemover(TVStationList tVStationList) {
        this.this$0 = tVStationList;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void fireTimer(Timer timer) {
        Object object = TVStationList.access$400(this.this$0);
        synchronized (object) {
            if (!this.canceled) {
                AbstractTVStationRow abstractTVStationRow = TVStationList.access$500(this.this$0);
                if (abstractTVStationRow != null) {
                    SelectedItem selectedItem = this.this$0.stationList.getSelected();
                    this.this$0.stationList.remove(abstractTVStationRow);
                    if (selectedItem != null) {
                        this.this$0.stationList.setSelectedUniqueID(selectedItem.getUniqueID());
                    }
                    TVStationList.access$600(this.this$0);
                }
                TVStationList.access$702(this.this$0, null);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void cancelTimer(Timer timer) {
        Object object = TVStationList.access$400(this.this$0);
        synchronized (object) {
            this.canceled = true;
        }
    }

    public void activate() {
        this.timer.start();
    }

    public void cancel() {
        this.timer.cancel();
    }

    /* synthetic */ TVStationList$TmpStationRemover(TVStationList tVStationList, TVStationList$1 tVStationList$1) {
        this(tVStationList);
    }
}

