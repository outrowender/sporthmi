/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.interapp;

import de.audi.atip.interapp.NaviServiceListener;
import de.audi.tghu.navi.app.details.IDestinationHandler;

public interface IRouteGuidanceInterAppService {
    public IDestinationHandler getDestinationHandler();

    public boolean getRgActiveStatus();

    public boolean isEtcDemoMode();

    public void stopRouteGuidance(NaviServiceListener var1);

    public void restartRouteGuidance(NaviServiceListener var1);

    public void startRouteGuidance(NaviServiceListener var1, boolean var2);

    public void addSelectedDestinationAtIndex(int var1, boolean var2, NaviServiceListener var3);
}

