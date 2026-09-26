/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm.stationlist;

import de.audi.tuner.app.RadioMenuModelListener;
import de.audi.tuner.app.amfm.stationlist.AbstractAmFmStationlistNar;

public class AbstractAmFmStationlistNar$MenuModelListener
extends RadioMenuModelListener {
    private final /* synthetic */ AbstractAmFmStationlistNar this$0;

    protected AbstractAmFmStationlistNar$MenuModelListener(AbstractAmFmStationlistNar abstractAmFmStationlistNar) {
        this.this$0 = abstractAmFmStationlistNar;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void itemFocused(int n, int n2, long l, int n3) {
        super.itemFocused(n, n2, l, n3);
        Object object = this.this$0.mutex;
        synchronized (object) {
            AbstractAmFmStationlistNar.access$902(this.this$0, n == -1);
            if (AbstractAmFmStationlistNar.access$800(this.this$0)) {
                if (AbstractAmFmStationlistNar.access$900(this.this$0)) {
                    AbstractAmFmStationlistNar.access$700(this.this$0).cancel();
                } else {
                    AbstractAmFmStationlistNar.access$700(this.this$0).restart();
                }
            }
        }
    }
}

