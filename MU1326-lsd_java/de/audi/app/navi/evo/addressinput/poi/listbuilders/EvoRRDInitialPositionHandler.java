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

    @Override
    protected boolean isStopOverVicinity() {
        return this.env.getChoiceModel(-1859910144).getValue() == 3;
    }

    @Override
    protected boolean isDestinationVicinity() {
        return this.env.getChoiceModel(-1859910144).getValue() == 2;
    }

    @Override
    protected boolean isInNewCity() {
        return this.env.getChoiceModel(-1859910144).getValue() == 4;
    }
}

