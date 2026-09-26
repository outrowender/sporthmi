/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars.seek;

class AlertsToEntertainmentDrawerDelivery$AlertData {
    private static final AlertsToEntertainmentDrawerDelivery$AlertData NULL_ALERT_DATA = new AlertsToEntertainmentDrawerDelivery$AlertData(-1, -1);
    private final int seekID;
    private final int sID;

    public AlertsToEntertainmentDrawerDelivery$AlertData(int n, int n2) {
        this.seekID = n;
        this.sID = n2;
    }

    static /* synthetic */ AlertsToEntertainmentDrawerDelivery$AlertData access$000() {
        return NULL_ALERT_DATA;
    }

    static /* synthetic */ int access$200(AlertsToEntertainmentDrawerDelivery$AlertData alertsToEntertainmentDrawerDelivery$AlertData) {
        return alertsToEntertainmentDrawerDelivery$AlertData.seekID;
    }

    static /* synthetic */ int access$300(AlertsToEntertainmentDrawerDelivery$AlertData alertsToEntertainmentDrawerDelivery$AlertData) {
        return alertsToEntertainmentDrawerDelivery$AlertData.sID;
    }
}

