/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.handler;

import de.audi.tghu.navi.app.map.GUIInterface;
import de.audi.tghu.navi.app.map.INaviInterface;

public interface IRouteInfo$IRouteInfoHandlerEnv {
    default public void updateDestDistance(int n) {
    }

    default public boolean showETAandDistanceToNextStopover() {
    }

    default public boolean isInMap() {
    }

    default public boolean isRouteInfoEnabled() {
    }

    default public boolean supportsAdditionalInfo() {
    }

    default public boolean isRouteInfoAllowedToFadeIn() {
    }

    default public void automaticOrientateMap() {
    }

    default public INaviInterface getNaviInterface() {
    }

    default public GUIInterface getGuiInterface() {
    }
}

