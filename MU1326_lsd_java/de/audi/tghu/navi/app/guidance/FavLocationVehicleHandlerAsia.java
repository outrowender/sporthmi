/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.guidance;

import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.adb.NaviADBHandler;
import de.audi.tghu.navi.app.di.sequences.disambiguation.ILocationDisambiguationCallback;
import de.audi.tghu.navi.app.di.sequences.disambiguation.ILocationDisambiguatorPopupHandler;
import de.audi.tghu.navi.app.di.sequences.disambiguation.ILocationDisambiguatorSequence;
import de.audi.tghu.navi.app.di.sequences.disambiguation.LocationDisambiguationWrapper;
import de.audi.tghu.navi.app.favorite.INaviFavoriteHandler;
import de.audi.tghu.navi.app.guidance.FavLocationVehicleHandler;
import de.audi.tghu.navi.app.guidance.IVehicle;

public class FavLocationVehicleHandlerAsia
extends FavLocationVehicleHandler
implements ILocationDisambiguationCallback {
    private final ILocationDisambiguatorSequence locationDisambiguator;
    private final ILocationDisambiguatorPopupHandler popupHandler;

    public FavLocationVehicleHandlerAsia(NavigationEnv navigationEnv, INaviFavoriteHandler iNaviFavoriteHandler, IVehicle iVehicle, NaviADBHandler naviADBHandler, ILocationDisambiguatorSequence iLocationDisambiguatorSequence, ILocationDisambiguatorPopupHandler iLocationDisambiguatorPopupHandler) {
        super(navigationEnv, iNaviFavoriteHandler, iVehicle, naviADBHandler);
        this.locationDisambiguator = iLocationDisambiguatorSequence;
        this.popupHandler = iLocationDisambiguatorPopupHandler;
    }

    public void addToContact(int n, int n2) {
        this.locationDisambiguator.startDisambiguationForNavLocation(this.vehicle.getVehicleLocationDescription(), this, 2, n, n2);
    }

    public void saveAsFavorite(int n, int n2) {
        this.locationDisambiguator.startDisambiguationForNavLocation(this.vehicle.getVehicleLocationDescription(), this, 1, n, n2);
    }

    public void locationDisambiguationCallback(LocationDisambiguationWrapper locationDisambiguationWrapper) {
        this.popupHandler.startPopupHandling(locationDisambiguationWrapper);
    }
}

