/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.interapp;

import de.audi.atip.interapp.NaviServiceListener;
import de.audi.tghu.navi.app.details.IDestinationHandler;

public interface IRouteGuidanceInterAppService {
    default public IDestinationHandler getDestinationHandler() {
    }

    default public boolean getRgActiveStatus() {
    }

    default public boolean isEtcDemoMode() {
    }

    default public void stopRouteGuidance(NaviServiceListener naviServiceListener) {
    }

    default public void restartRouteGuidance(NaviServiceListener naviServiceListener) {
    }

    default public void startRouteGuidance(NaviServiceListener naviServiceListener, boolean bl) {
    }

    default public void addSelectedDestinationAtIndex(int n, boolean bl, NaviServiceListener naviServiceListener) {
    }
}

