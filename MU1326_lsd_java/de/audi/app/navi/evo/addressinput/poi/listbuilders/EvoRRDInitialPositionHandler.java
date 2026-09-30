/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi.listbuilders;

import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.guidance.IVehicle;
import de.audi.tghu.navi.app.routeguidance.IRouteManager;
import de.audi.tghu.navi.app.slidinglist.poi.AbstractRRDInitialPositionHandler;

public class EvoRRDInitialPositionHandler
extends AbstractRRDInitialPositionHandler {
    public EvoRRDInitialPositionHandler(IRouteManager iRouteManager, NavigationEnv navigationEnv, IVehicle iVehicle) {
        super(iRouteManager, navigationEnv, iVehicle);
    }

    protected boolean isStopOverVicinity() {
        return this.env.getChoiceModel(402577).getValue() == 3;
    }

    protected boolean isDestinationVicinity() {
        return this.env.getChoiceModel(402577).getValue() == 2;
    }

    protected boolean isInNewCity() {
        return this.env.getChoiceModel(402577).getValue() == 4;
    }
}

