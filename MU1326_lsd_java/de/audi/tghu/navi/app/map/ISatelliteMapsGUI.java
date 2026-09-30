/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.ResourceLocatorModelApp;
import de.audi.tghu.navi.app.map.IVisibleContext;
import org.dsi.ifc.global.NavRectangle;

public interface ISatelliteMapsGUI {
    public static final ISatelliteMapsGUI NULL_GUI = new ISatelliteMapsGUI(){

        public void setSatelliteMapsProviderLogo(boolean bl) {
        }

        public NavRectangle getCopyRightLogoPosition(IVisibleContext iVisibleContext, int n) {
            return new NavRectangle();
        }

        public void showFunctionCurrentlyNotAvailableHelpTextWithTimeout() {
        }

        public void showFunctionCurrentlyNotAvailableHelpText() {
        }

        public void redrawFunctionCurrentlyNotAvailableHelpTextWithTimeout() {
        }

        public void cleanUp() {
        }

        public ResourceLocatorModelApp getSatelliteMapResourceLocator(int n) {
            return null;
        }

        public ChoiceModelApp getSatelliteMapChoiceModel(int n) {
            return null;
        }
    };

    public void setSatelliteMapsProviderLogo(boolean var1);

    public NavRectangle getCopyRightLogoPosition(IVisibleContext var1, int var2);

    public void showFunctionCurrentlyNotAvailableHelpTextWithTimeout();

    public void showFunctionCurrentlyNotAvailableHelpText();

    public void redrawFunctionCurrentlyNotAvailableHelpTextWithTimeout();

    public void cleanUp();

    public ResourceLocatorModelApp getSatelliteMapResourceLocator(int var1);

    public ChoiceModelApp getSatelliteMapChoiceModel(int var1);
}

