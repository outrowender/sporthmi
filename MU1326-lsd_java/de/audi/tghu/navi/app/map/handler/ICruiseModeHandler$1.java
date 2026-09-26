/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.handler;

import de.audi.atip.interapp.NaviCruiseModeServiceListener;
import de.audi.tghu.navi.app.map.handler.ICruiseModeHandler;

final class ICruiseModeHandler$1
implements ICruiseModeHandler {
    ICruiseModeHandler$1() {
    }

    @Override
    public void onEvent(int n, int n2) {
    }

    @Override
    public void setNaviCruiseModeNotificationService(NaviCruiseModeServiceListener naviCruiseModeServiceListener) {
    }

    @Override
    public boolean isCenterToCar() {
        return true;
    }

    @Override
    public boolean isInCruiseMode() {
        return true;
    }

    @Override
    public void cleanup() {
    }
}

