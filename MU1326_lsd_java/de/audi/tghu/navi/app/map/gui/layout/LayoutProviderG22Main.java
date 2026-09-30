/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.gui.layout;

import de.audi.atip.hmi.model.BaseListRow;
import de.audi.atip.hmi.modelaccess.ListModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.context.CtxPicNavCarouselMap;
import de.audi.tghu.navi.app.map.gui.layout.AbstractLayoutProvider;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.map.Rect;

public class LayoutProviderG22Main
extends AbstractLayoutProvider {
    private LogChannel logger;
    private BaseListRow mScreenLayout;

    public LayoutProviderG22Main(NavigationEnv navigationEnv) {
        super(navigationEnv);
        ListModelApp listModelApp = navigationEnv.getListModel(176);
        this.mScreenLayout = listModelApp != null && listModelApp.getLength() > 0 ? listModelApp.getRow(0) : null;
        this.logger = navigationEnv.getLogChannel("App.Map.GUI.Main");
    }

    private LogChannel getLogger() {
        return this.logger;
    }

    protected BaseListRow getListRow() {
        return this.mScreenLayout;
    }

    public Rect getVisibleArea(int n, boolean bl, boolean bl2, boolean bl3) {
        return this.getVisibleArea(n, bl, bl2);
    }

    public Rect getVisibleArea(int n, boolean bl, boolean bl2) {
        Rect rect = new Rect();
        int n2 = bl ? this.getDistanceRouteInfoLeft() : 0;
        int n3 = bl2 ? this.getDistanceSidebarRight() : 0;
        int n4 = this.getDistanceStatusbarBottom();
        int n5 = this.getDistanceReiterlineTop() + 10;
        int n6 = this.getScreenWidth();
        int n7 = this.getScreenHeight();
        switch (n) {
            case 33: {
                n2 = this.getDistanceLeftDrawerIcon();
                if (Util.isHURegionJP()) {
                    n2 += 178;
                }
                n3 = this.getDistanceSidebarRight();
                n5 = this.getDistanceRoutecriteriaboxTop() + 10;
                break;
            }
            case 5: {
                n2 = this.getDistanceLeftDrawerIcon();
                if (Util.isHURegionJP()) {
                    n2 += 178;
                }
                n3 = this.getDistanceSidebarArRight();
                n5 = this.getDistanceRoutecriteriaboxTop() + 10;
                break;
            }
            case 34: {
                n5 = this.getDistanceRubberbandInfoBarTop();
                n3 = this.getDistanceSidebarArRight();
                break;
            }
            case 20: {
                n2 = this.getDistanceLeftDrawerIcon();
                n3 = this.getDistanceSidebarArRight();
                n5 = this.getDistanceRoutecriteriaboxTop() + 10;
                break;
            }
            case 15: 
            case 28: 
            case 37: {
                n2 = 0;
                break;
            }
            case 18: {
                n5 = this.getDistanceMaptooltipUp();
                n4 = 0;
                n3 = 0;
                n2 = 0;
                break;
            }
            case 10: {
                n3 = this.getDistanceSidebarRight();
                break;
            }
            case 26: {
                n4 = 0;
                break;
            }
            case 27: {
                n6 = CtxPicNavCarouselMap.CAROUSEL_MAP_WIDTH;
                n7 = CtxPicNavCarouselMap.CAROUSEL_MAP_HEIGHT;
                n2 = 0;
                n4 = 0;
                break;
            }
            default: {
                if (bl) break;
                n3 = 0;
            }
        }
        rect.kordX = this.env.getFramework().getLanguageMgr().isLeftToRightOrientation() ? n2 : n3;
        rect.kordY = n5;
        rect.diffX = n6 - n2 - n3;
        rect.diffY = n7 - n5 - n4;
        this.getLogger().log(10000000, "LayoutProviderG22Main#getVisibleArea() - contextId = %3, isRouteInfoBoxVisible = %2 -> %1", (Object)rect, (Object)Boolean.toString(bl), (long)n);
        return rect;
    }
}

