/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.routeguidance;

public interface IAlternativeRouteStateManager {
    public static final int ALTERNATIVE_ROUTE_CALCULATION_ON = 1;
    public static final int ALTERNATIVE_ROUTE_CALCULATION_OFF = 0;
    public static final IAlternativeRouteStateManager NULL_ALTERNATIVE_ROUTE_STATE_MANAGER = new IAlternativeRouteStateManager(){

        public void setAlternativeRouteState(int n) {
        }

        public void resetSettings() {
        }

        public int getAlternativeRouteState() {
            return 0;
        }
    };

    public int getAlternativeRouteState();

    public void setAlternativeRouteState(int var1);

    public void resetSettings();
}

