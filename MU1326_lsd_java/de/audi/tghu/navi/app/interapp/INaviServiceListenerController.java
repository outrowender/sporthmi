/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.interapp;

import de.audi.atip.interapp.NaviServiceListener;
import de.audi.tghu.navi.app.INaviComponent;
import de.audi.tghu.navi.app.interapp.INaviServiceListenerObserver;

public interface INaviServiceListenerController
extends INaviComponent {
    default public NaviServiceListener getNaviServiceListener() {
    }

    default public void setTrackerUpdatesObserver(INaviServiceListenerObserver iNaviServiceListenerObserver) {
    }
}

