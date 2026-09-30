/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.handler;

import de.audi.atip.interapp.NaviCruiseModeServiceListener;
import de.audi.tghu.navi.app.map.event.MapEventListener;

public interface ICruiseModeHandler
extends MapEventListener {
    public static final ICruiseModeHandler NULL_CRUISE_MODE_HANDLER = new ICruiseModeHandler(){

        public void onEvent(int n, int n2) {
        }

        public void setNaviCruiseModeNotificationService(NaviCruiseModeServiceListener naviCruiseModeServiceListener) {
        }

        public boolean isCenterToCar() {
            return true;
        }

        public boolean isInCruiseMode() {
            return true;
        }

        public void cleanup() {
        }
    };

    public boolean isInCruiseMode();

    public boolean isCenterToCar();

    public void setNaviCruiseModeNotificationService(NaviCruiseModeServiceListener var1);

    public void cleanup();
}

