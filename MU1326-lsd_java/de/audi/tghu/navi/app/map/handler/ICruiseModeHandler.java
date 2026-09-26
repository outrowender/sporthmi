/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.handler;

import de.audi.atip.interapp.NaviCruiseModeServiceListener;
import de.audi.tghu.navi.app.map.event.MapEventListener;
import de.audi.tghu.navi.app.map.handler.ICruiseModeHandler$1;

public interface ICruiseModeHandler
extends MapEventListener {
    public static final ICruiseModeHandler NULL_CRUISE_MODE_HANDLER = new ICruiseModeHandler$1();

    default public boolean isInCruiseMode() {
    }

    default public boolean isCenterToCar() {
    }

    default public void setNaviCruiseModeNotificationService(NaviCruiseModeServiceListener naviCruiseModeServiceListener) {
    }

    default public void cleanup() {
    }
}

