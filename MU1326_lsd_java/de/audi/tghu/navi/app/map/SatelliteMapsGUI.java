/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.ResourceLocatorModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.ISatelliteMapsGUI;
import de.audi.tghu.navi.app.map.IVisibleContext;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavRectangle;
import org.dsi.ifc.map.Rect;

public abstract class SatelliteMapsGUI
implements ISatelliteMapsGUI {
    private int MAIN_SCREEN_WIDTH = 1024;
    private static final int STD_MAP_OFFSET_Y = 20;
    private static final int STD_MAP_LOGO_LENGTH = 420;
    private static final int STD_MAP_LOGO_HEIGHT = 200;
    private static final int MMI_CLUSTER_MAP_OFFSET_Y = 20;
    private static final int MMI_CLUSTER_MAP_LOGO_LENGTH = 380;
    private static final int MMI_CLUSTER_MAP_LOGO_HEIGHT = 200;
    private static final int KMOBI_MAP_OFFSET_Y = 20;
    private static final int KOMBI_MAP_LOGO_LENGTH = 380;
    private static final int KOMBI_MAP_LOGO_HEIGHT = 200;
    protected final NavigationEnv env;
    protected final LogChannel logger;
    private static final int SATMAPS_NOT_ACTIVE = 0;
    private static final int SATMAPS_ACTIVE = 100;

    public SatelliteMapsGUI(NavigationEnv navigationEnv) {
        this.env = navigationEnv;
        this.logger = navigationEnv.getMapMainLogChannel();
        this.MAIN_SCREEN_WIDTH = this.retrieveScreenWidth();
        this.setDynamicProviderIconConcept();
        this.getSatelliteMapResourceLocator(402788).setResourceLocator(-1, ResourceLocatorModelApp.UNDEFINED_URI);
    }

    protected abstract void setDynamicProviderIconConcept();

    private int getScreenResolution() {
        return this.env.getFramework().getScreenRes();
    }

    private int retrieveScreenWidth() {
        int n = 0;
        int n2 = this.getScreenResolution();
        switch (n2) {
            case 1: {
                n = 800;
                break;
            }
            case 2: {
                n = 1024;
                break;
            }
            case 4: {
                n = 1440;
                break;
            }
            default: {
                this.logger.log(10000, "SatelliteMapsGUI#screen resolution is wrong");
            }
        }
        return n;
    }

    public NavRectangle getCopyRightLogoPosition(IVisibleContext iVisibleContext, int n) {
        if (n == 0) {
            if (Util.isClusterMMI(this.env.getFramework())) {
                return this.mmiClusterMapCopyRightLogoPosition(iVisibleContext);
            }
            return this.stdMapCopyRightLogoPosition(iVisibleContext);
        }
        return this.kombiMapCopyRightLogoPosition(iVisibleContext);
    }

    private NavRectangle stdMapCopyRightLogoPosition(IVisibleContext iVisibleContext) {
        int n = (this.MAIN_SCREEN_WIDTH - 420) / 2;
        int n2 = 20;
        int n3 = n + 420;
        int n4 = n2 + 200;
        NavRectangle navRectangle = new NavRectangle(n, n3, n2, n4, false);
        return navRectangle;
    }

    private NavRectangle mmiClusterMapCopyRightLogoPosition(IVisibleContext iVisibleContext) {
        Rect rect = iVisibleContext.getVisibleArea();
        int n = rect.getKordX() + (rect.getDiffX() - 380) / 2;
        int n2 = rect.getKordY() + 20;
        int n3 = n + 380;
        int n4 = n2 + 200;
        NavRectangle navRectangle = new NavRectangle(n, n3, n2, n4, false);
        return navRectangle;
    }

    private NavRectangle kombiMapCopyRightLogoPosition(IVisibleContext iVisibleContext) {
        Rect rect = iVisibleContext.getVisibleArea();
        int n = rect.getKordX() + (rect.getDiffX() - 380) / 2;
        int n2 = rect.getKordY() + 20;
        int n3 = n + 380;
        int n4 = n2 + 200;
        NavRectangle navRectangle = new NavRectangle(n, n3, n2, n4, false);
        return navRectangle;
    }

    public void setSatelliteMapsProviderLogo(boolean bl) {
        this.logger.log(10000000, "SatelliteMapsGUI#setSatelliteMapsProviderLogo() show %1", bl);
        if (bl) {
            this.env.getChoiceModel(162).setValue(100);
        } else {
            this.env.getChoiceModel(162).setValue(0);
        }
    }

    public abstract void showFunctionCurrentlyNotAvailableHelpTextWithTimeout();

    public abstract void redrawFunctionCurrentlyNotAvailableHelpTextWithTimeout();

    public ResourceLocatorModelApp getSatelliteMapResourceLocator(int n) {
        return this.env.getFramework().getHmiServiceApp().getResourceLocatorModel(n);
    }

    public ChoiceModelApp getSatelliteMapChoiceModel(int n) {
        return this.env.getFramework().getHmiServiceApp().getChoiceModel(n);
    }
}

