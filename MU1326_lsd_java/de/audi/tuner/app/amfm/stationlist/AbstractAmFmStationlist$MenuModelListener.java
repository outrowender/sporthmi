/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm.stationlist;

import de.audi.tuner.app.RadioMenuModelListener;
import de.audi.tuner.app.amfm.stationlist.AbstractAmFmStationlist;

public class AbstractAmFmStationlist$MenuModelListener
extends RadioMenuModelListener {
    private final /* synthetic */ AbstractAmFmStationlist this$0;

    protected AbstractAmFmStationlist$MenuModelListener(AbstractAmFmStationlist abstractAmFmStationlist) {
        this.this$0 = abstractAmFmStationlist;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void itemFocused(int n, int n2, long l, int n3) {
        super.itemFocused(n, n2, l, n3);
        Object object = this.this$0.mutex;
        synchronized (object) {
            AbstractAmFmStationlist.access$1102(this.this$0, n == -1);
            if (AbstractAmFmStationlist.access$1000(this.this$0)) {
                if (AbstractAmFmStationlist.access$1100(this.this$0)) {
                    AbstractAmFmStationlist.access$900(this.this$0).cancel();
                } else {
                    AbstractAmFmStationlist.access$900(this.this$0).restart();
                }
            }
        }
    }
}

