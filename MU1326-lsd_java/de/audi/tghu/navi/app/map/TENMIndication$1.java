/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map;

import de.audi.atip.timer.DefaultTimerListener;
import de.audi.atip.timer.Timer;
import de.audi.tghu.navi.app.map.TENMIndication;

class TENMIndication$1
extends DefaultTimerListener {
    private final /* synthetic */ TENMIndication this$0;

    TENMIndication$1(TENMIndication tENMIndication) {
        this.this$0 = tENMIndication;
    }

    @Override
    public synchronized void fireTimer(Timer timer) {
        TENMIndication.access$000(this.this$0);
    }
}

