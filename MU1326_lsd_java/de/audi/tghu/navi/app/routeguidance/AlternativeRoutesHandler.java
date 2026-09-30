/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.routeguidance;

public class AlternativeRoutesHandler {
    public static final int OPTIONS_INDEX_ALTERNATIVE_ROUTE_1 = 0;
    public static final int OPTIONS_INDEX_ALTERNATIVE_ROUTE_2 = 1;
    public static final int OPTIONS_INDEX_ALTERNATIVE_ROUTE_3 = 2;
    private int lastSelectedRouteIndex = 0;
    private boolean expectsAlternativeRoutesCalculation = false;

    public synchronized boolean isExpectsAlternativeRoutesCalculation() {
        return this.expectsAlternativeRoutesCalculation;
    }

    public synchronized void setExpectsAlternativeRoutesCalculation(boolean bl) {
        this.expectsAlternativeRoutesCalculation = bl;
    }

    public synchronized int getLastSelectedRouteIndex() {
        return this.lastSelectedRouteIndex;
    }

    public synchronized void setLastSelectedRouteIndex(int n) {
        this.lastSelectedRouteIndex = n;
    }
}

