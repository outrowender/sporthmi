/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.guidance;

import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.adb.NaviADBHandler;
import de.audi.tghu.navi.app.favorite.INaviFavoriteHandler;
import de.audi.tghu.navi.app.guidance.IVehicle;
import org.dsi.ifc.global.NavLocation;

public class FavLocationVehicleHandler {
    protected final NavigationEnv env;
    protected final INaviFavoriteHandler favHandler;
    protected final IVehicle vehicle;
    protected final NaviADBHandler naviADBHandler;

    public FavLocationVehicleHandler(NavigationEnv navigationEnv, INaviFavoriteHandler iNaviFavoriteHandler, IVehicle iVehicle, NaviADBHandler naviADBHandler) {
        this.env = navigationEnv;
        this.favHandler = iNaviFavoriteHandler;
        this.vehicle = iVehicle;
        this.naviADBHandler = naviADBHandler;
    }

    public void addToContact(int n, int n2) {
        this.naviADBHandler.startStoringAddress(this.vehicle.getVehicleLocationDescription());
    }

    public void saveAsFavorite(int n, int n2) {
        NavLocation navLocation = this.vehicle.getVehicleLocationDescription();
        this.favHandler.addToFavorites(navLocation);
    }
}

