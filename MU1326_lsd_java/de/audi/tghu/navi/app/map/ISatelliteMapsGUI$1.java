/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.ResourceLocatorModelApp;
import de.audi.tghu.navi.app.map.ISatelliteMapsGUI;
import de.audi.tghu.navi.app.map.IVisibleContext;
import org.dsi.ifc.global.NavRectangle;

final class ISatelliteMapsGUI$1
implements ISatelliteMapsGUI {
    ISatelliteMapsGUI$1() {
    }

    @Override
    public void setSatelliteMapsProviderLogo(boolean bl) {
    }

    @Override
    public NavRectangle getCopyRightLogoPosition(IVisibleContext iVisibleContext, int n) {
        return new NavRectangle();
    }

    @Override
    public void showFunctionCurrentlyNotAvailableHelpTextWithTimeout() {
    }

    @Override
    public void showFunctionCurrentlyNotAvailableHelpText() {
    }

    @Override
    public void redrawFunctionCurrentlyNotAvailableHelpTextWithTimeout() {
    }

    @Override
    public void cleanUp() {
    }

    @Override
    public ResourceLocatorModelApp getSatelliteMapResourceLocator(int n) {
        return null;
    }

    @Override
    public ChoiceModelApp getSatelliteMapChoiceModel(int n) {
        return null;
    }
}

