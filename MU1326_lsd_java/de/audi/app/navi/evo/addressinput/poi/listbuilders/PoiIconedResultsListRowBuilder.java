/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi.listbuilders;

import de.audi.app.navi.evo.addressinput.poi.listbuilders.EvoRRDInitialPositionHandler;
import de.audi.app.navi.evo.addressinput.poi.listbuilders.PoiIconedResultsListRow;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.listbuilders.IEvoListRowBuilder;
import de.audi.tghu.navi.app.guidance.IVehicle;
import de.audi.tghu.navi.app.routeguidance.IRouteManager;
import de.audi.tghu.navi.app.slidinglist.poi.FixedPosRRDInitialPositionHandler;
import de.audi.tghu.navi.app.slidinglist.poi.RRDInitialPositionHandler;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LIValueListElement;
import org.dsi.ifc.navigation.PosPosition;

public class PoiIconedResultsListRowBuilder
implements IEvoListRowBuilder {
    private final IconHandler iconHandler;
    private RRDInitialPositionHandler rrdInitialPoisitionHandler;
    private final NavigationEnv env;

    private PoiIconedResultsListRowBuilder(IconHandler iconHandler, IRouteManager iRouteManager, NavigationEnv navigationEnv, IVehicle iVehicle) {
        this.rrdInitialPoisitionHandler = new EvoRRDInitialPositionHandler(iRouteManager, navigationEnv, iVehicle);
        this.iconHandler = iconHandler;
        this.env = navigationEnv;
    }

    private PoiIconedResultsListRowBuilder(IconHandler iconHandler, NavigationEnv navigationEnv, NavLocation navLocation) {
        this.rrdInitialPoisitionHandler = new FixedPosRRDInitialPositionHandler(this.getPosPositionFromNavLocation(navLocation));
        this.iconHandler = iconHandler;
        this.env = navigationEnv;
    }

    private PoiIconedResultsListRowBuilder(IconHandler iconHandler, NavigationEnv navigationEnv) {
        this.iconHandler = iconHandler;
        this.env = navigationEnv;
    }

    public static PoiIconedResultsListRowBuilder createPoiIconedResultsListRowBuilderDistanceFromNavLocation(IconHandler iconHandler, NavigationEnv navigationEnv, NavLocation navLocation) {
        return new PoiIconedResultsListRowBuilder(iconHandler, navigationEnv, navLocation);
    }

    public static PoiIconedResultsListRowBuilder createPoiIconedResultsListRowBuilderDistanceFromNavLocation(IconHandler iconHandler, NavigationEnv navigationEnv) {
        return new PoiIconedResultsListRowBuilder(iconHandler, navigationEnv);
    }

    public static PoiIconedResultsListRowBuilder createPoiIconedResultsListRowBuilderDistanceFromCCP(IconHandler iconHandler, IRouteManager iRouteManager, NavigationEnv navigationEnv, IVehicle iVehicle) {
        return new PoiIconedResultsListRowBuilder(iconHandler, iRouteManager, navigationEnv, iVehicle);
    }

    private PosPosition getPosPositionFromNavLocation(NavLocation navLocation) {
        PosPosition posPosition = new PosPosition();
        posPosition.latitude = navLocation.latitude;
        posPosition.longitude = navLocation.longitude;
        return posPosition;
    }

    public EvoListRow buildListRow(LIValueListElement lIValueListElement, int n) {
        return new PoiIconedResultsListRow(this.iconHandler, lIValueListElement, n, this.rrdInitialPoisitionHandler.getInitialPosition(), this.env);
    }

    public EvoListRow buildListRow(LIValueListElement lIValueListElement, int n, NavLocation navLocation) {
        return new PoiIconedResultsListRow(this.iconHandler, lIValueListElement, n, this.getPosPositionFromNavLocation(navLocation), this.env);
    }
}

