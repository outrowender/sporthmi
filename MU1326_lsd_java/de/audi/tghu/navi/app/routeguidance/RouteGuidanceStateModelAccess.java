/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.routeguidance;

import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.routeguidance.IRouteGuidanceStateModelAccess;
import de.audi.tghu.navi.app.util.RouteUtil;
import org.dsi.ifc.navigation.Route;

public class RouteGuidanceStateModelAccess
implements IRouteGuidanceStateModelAccess {
    private static final int RG_STATE_INACTIVE = 1;
    private static final int RG_STATE_ACTIVE = 2;
    protected final NavigationEnv env;

    public RouteGuidanceStateModelAccess(NavigationEnv navigationEnv) {
        this.env = navigationEnv;
    }

    public void updateRgActive(boolean bl, Route route) {
        if (this.env.getLogChannel().isDebug2()) {
            this.env.getLogChannel().log(100000000, "[RouteGuidanceModel] RouteGuidanceStateModelAccess#updateRgActive - currentRoute: %1, isRgActive: %2 ", (Object)RouteUtil.formatRouteShort(route), (Object)Boolean.toString(bl));
        }
        int n = 0;
        if (bl && route != null) {
            n = RouteUtil.getNumberOfRemainingDestinations(route, 1);
        }
        this.env.getChoiceModel(400721).setValue(n);
        int n2 = bl ? 2 : 1;
        this.env.getChoiceModel(400871).setValue(n2);
    }

    public void updateActiveDestinations(int n) {
        this.env.getChoiceModel(400721).setValue(n);
    }

    public void setPredictiveRgRunning(boolean bl) {
        this.env.getChoiceModel(402312).setValue(bl ? 1 : 0);
    }
}

