/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.dsi;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.map.dsi.AbstractResponser;
import de.audi.tghu.navi.app.map.utils.MapUtils;
import org.dsi.ifc.map.DSIMapViewerManeuverViewListener;

public final class MVResponseManeuverView
extends AbstractResponser
implements DSIMapViewerManeuverViewListener {
    private short[] mManoeuvreViewsAvailable = null;
    private int mManoeuvreViewActive = 255;
    private int iExitViewId = -1;

    public MVResponseManeuverView(AbstractMap abstractMap) {
        super(abstractMap.getMapDSILogChannel());
        this.bind(abstractMap);
    }

    public MVResponseManeuverView(LogChannel logChannel) {
        super(logChannel);
    }

    public String getName() {
        return "MVResponseManeuverView";
    }

    public void updateManoeuvreViewsAvailable(short[] sArray, int n) {
        if (n == 1) {
            this.getLogger().log(10000000, "MVResponseManeuverView#updateManoeuvreViewsAvailable() - [%1]", (Object)MapUtils.toString(sArray));
            this.mManoeuvreViewsAvailable = sArray;
            this.getActiveContext().updateManoeuvreViewsAvailable(sArray);
        }
        this.naviMap.getActiveContext().adjustCarPosition();
    }

    public short[] getManoeuvreViewsAvailable() {
        return this.mManoeuvreViewsAvailable;
    }

    public void updateManoeuvreViewActive(int n, int n2) {
        if (n2 == 1) {
            this.getLogger().log(10000000, "MVResponseManeuverView#updateManoeuvreViewActive() - View = %1", (long)n);
            this.mManoeuvreViewActive = n;
            this.naviMap.getActiveContext().updateManoeuvreViewActive(n);
            this.getMap().getNaviInterface().getClusterService().updateManoeuvreViewActive(n);
        }
        this.naviMap.getActiveContext().adjustCarPosition();
    }

    public int getManoeuvreViewActive() {
        return this.mManoeuvreViewActive;
    }

    public void asyncException(int n, String string, int n2) {
        this.getLogger().log(10000, "MVResponseManeuverView#asyncException(): code = %2, msg = %1, type = %3", (Object)string, (long)n, (long)n2);
    }

    public void resetMemberVariables() {
        this.mManoeuvreViewsAvailable = null;
        this.mManoeuvreViewActive = 255;
    }

    public void updateBapExitViewId(int n, int n2) {
        if (n2 == 1) {
            this.getLogger().log(10000000, "MVResponseManeuverView#updateBapExitViewId() - exitViewId = %1", (long)n);
            this.iExitViewId = n;
            this.naviMap.getNaviInterface().getClusterService().updateExitView(n);
        }
        this.naviMap.getActiveContext().adjustCarPosition();
    }

    public int getBapExitViewId() {
        return this.iExitViewId;
    }
}

