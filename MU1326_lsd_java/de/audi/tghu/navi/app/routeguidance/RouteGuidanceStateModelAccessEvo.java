/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.routeguidance;

import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.routeguidance.RouteGuidanceStateModelAccess;
import org.dsi.ifc.navigation.Route;

public class RouteGuidanceStateModelAccessEvo
extends RouteGuidanceStateModelAccess {
    public RouteGuidanceStateModelAccessEvo(NavigationEnv navigationEnv) {
        super(navigationEnv);
    }

    @Override
    public void updateRgActive(boolean bl, Route route) {
        super.updateRgActive(bl, route);
        if (!bl) {
            this.env.getChoiceModel(136578560).setValue(0);
        }
    }
}

