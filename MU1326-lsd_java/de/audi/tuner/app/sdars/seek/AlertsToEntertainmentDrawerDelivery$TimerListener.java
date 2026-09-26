/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars.seek;

import de.audi.atip.timer.DefaultTimerListener;
import de.audi.atip.timer.Timer;
import de.audi.tuner.app.sdars.seek.AlertsToEntertainmentDrawerDelivery;
import de.audi.tuner.app.sdars.seek.AlertsToEntertainmentDrawerDelivery$1;

class AlertsToEntertainmentDrawerDelivery$TimerListener
extends DefaultTimerListener {
    private final /* synthetic */ AlertsToEntertainmentDrawerDelivery this$0;

    private AlertsToEntertainmentDrawerDelivery$TimerListener(AlertsToEntertainmentDrawerDelivery alertsToEntertainmentDrawerDelivery) {
        this.this$0 = alertsToEntertainmentDrawerDelivery;
    }

    @Override
    public void fireTimer(Timer timer) {
        AlertsToEntertainmentDrawerDelivery.access$400(this.this$0).log(-2137614336, "[AlertsToEntertainmentDrawerDelivery.TimerListener.fireTimer] Clearing alert, was shown long enough =)");
        AlertsToEntertainmentDrawerDelivery.access$500(this.this$0);
    }

    /* synthetic */ AlertsToEntertainmentDrawerDelivery$TimerListener(AlertsToEntertainmentDrawerDelivery alertsToEntertainmentDrawerDelivery, AlertsToEntertainmentDrawerDelivery$1 alertsToEntertainmentDrawerDelivery$1) {
        this(alertsToEntertainmentDrawerDelivery);
    }
}

