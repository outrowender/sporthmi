/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.ResourceLocatorModelApp;
import de.audi.tghu.navi.app.map.ISatelliteMapsGUI$1;
import de.audi.tghu.navi.app.map.IVisibleContext;
import org.dsi.ifc.global.NavRectangle;

public interface ISatelliteMapsGUI {
    public static final ISatelliteMapsGUI NULL_GUI = new ISatelliteMapsGUI$1();

    default public void setSatelliteMapsProviderLogo(boolean bl) {
    }

    default public NavRectangle getCopyRightLogoPosition(IVisibleContext iVisibleContext, int n) {
    }

    default public void showFunctionCurrentlyNotAvailableHelpTextWithTimeout() {
    }

    default public void showFunctionCurrentlyNotAvailableHelpText() {
    }

    default public void redrawFunctionCurrentlyNotAvailableHelpTextWithTimeout() {
    }

    default public void cleanUp() {
    }

    default public ResourceLocatorModelApp getSatelliteMapResourceLocator(int n) {
    }

    default public ChoiceModelApp getSatelliteMapChoiceModel(int n) {
    }
}

