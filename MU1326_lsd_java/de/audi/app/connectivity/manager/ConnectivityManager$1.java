/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.connectivity.manager;

import de.audi.app.connectivity.manager.ConnectivityManager;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;

class ConnectivityManager$1
implements TimerListener {
    private final /* synthetic */ ConnectivityManager this$0;

    ConnectivityManager$1(ConnectivityManager connectivityManager) {
        this.this$0 = connectivityManager;
    }

    @Override
    public void cancelTimer(Timer timer) {
        ConnectivityManager.access$000(this.this$0).log(-2137614336, "ConnectivityManager.updateSimTimer.new TimerListener() {...}#cancelTimer(): ");
    }

    @Override
    public void fireTimer(Timer timer) {
        ConnectivityManager.access$100(this.this$0).log(-2137614336, "ConnectivityManager.updateSimTimer.new TimerListener() {...}#fireTimer(): ");
        ConnectivityManager.access$202(this.this$0, false);
        ConnectivityManager.access$302(this.this$0, ConnectivityManager.access$400(this.this$0));
        ConnectivityManager.access$500(this.this$0);
        ConnectivityManager.access$600(this.this$0);
    }
}

