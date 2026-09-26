/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.routeguidance;

import de.audi.tghu.navi.app.routeguidance.IAlternativeRouteStateManager$1;

public interface IAlternativeRouteStateManager {
    public static final int ALTERNATIVE_ROUTE_CALCULATION_ON;
    public static final int ALTERNATIVE_ROUTE_CALCULATION_OFF;
    public static final IAlternativeRouteStateManager NULL_ALTERNATIVE_ROUTE_STATE_MANAGER;

    default public int getAlternativeRouteState() {
    }

    default public void setAlternativeRouteState(int n) {
    }

    default public void resetSettings() {
    }

    static {
        NULL_ALTERNATIVE_ROUTE_STATE_MANAGER = new IAlternativeRouteStateManager$1();
    }
}

