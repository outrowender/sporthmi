/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.gui.layout;

import de.audi.atip.hmi.model.BaseListRow;
import de.audi.atip.hmi.modelaccess.ListModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.gui.layout.AbstractLayoutProvider;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.map.Rect;

public class LayoutProviderG24
extends AbstractLayoutProvider {
    private LogChannel logger;
    private BaseListRow mScreenLayout;

    public LayoutProviderG24(NavigationEnv navigationEnv) {
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
        Rect rect = new Rect();
        int n2 = bl3 ? this.getDistanceTubeLeftKb() : this.getDistanceTubeLeft();
        int n3 = bl3 ? this.getDistanceTubeRightKb() : this.getDistanceTubeRight();
        int n4 = this.getDistanceInfolineBottom();
        int n5 = this.getDistanceReiterlineTop() + 10;
        int n6 = this.getScreenWidth();
        int n7 = this.getScreenHeight();
        switch (n) {
            case 33: {
                n2 = Util.isHURegionJP() ? (n2 += 178) : this.getDistanceRoutecriteriaboxLeft() + 10;
                n4 = this.getDistanceStatusbarBottom();
                break;
            }
            case 5: {
                n2 = Util.isHURegionJP() ? (n2 += 178) : this.getDistanceRoutecriteriaboxLeft() + 10;
                n3 = this.getDistanceSidebarArRight();
                n4 = this.getDistanceStatusbarBottom();
                if (this.env.getFramework().getLanguageMgr().isLeftToRightOrientation()) break;
                int n8 = n3;
                n3 = n2;
                n2 = n8;
                break;
            }
            case 34: {
                n3 = this.getDistanceSidebarArRight();
                n4 = this.getDistanceInfolineBottom();
                break;
            }
            case 20: {
                n2 = this.getDistanceRoutecriteriaboxLeft() + 10;
                n3 = this.getDistanceSidebarArRight();
                n4 = this.getDistanceStatusbarBottom();
                break;
            }
            case 12: 
            case 13: {
                if (Util.isHURegionAsia()) break;
                n4 = this.getDistanceMaptooltipBottom();
                break;
            }
        }
        rect.kordX = n2;
        rect.kordY = n5;
        rect.diffX = n6 - n2 - n3;
        rect.diffY = n7 - n5 - n4;
        this.getLogger().log(10000000, "LayoutProviderG24#getVisibleArea() - contextId = %3, isSmallState = %2 -> %1", (Object)rect, (Object)Boolean.toString(bl3), (long)n);
        return rect;
    }

    public Rect getVisibleArea(int n, boolean bl, boolean bl2) {
        return this.getVisibleArea(n, false, bl2, true);
    }
}

