/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.models;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchArea;
import de.audi.tghu.navi.app.guidance.IVehicle;
import de.audi.tghu.navi.app.routeguidance.IRouteManager;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.navigation.LIValueList;

public abstract class AbstractPoiScreenModelAccess {
    protected final NavigationEnv env;
    protected final LogChannel logChannel;
    public final int NAV_POI_CLASS_COUNT_CHOICE;
    public final int NAV_DEST_POI_CHILD_CATEGORY_NAME_LABEL;
    protected IconHandler iconHandler;
    protected IRouteManager routeManager;
    protected IVehicle vehicle;
    protected PoiSearchArea poiSearchArea;
    protected final String CLASS_NAME = Util.getClassNameFromPackageName(this.getClass());

    public AbstractPoiScreenModelAccess(NavigationEnv navigationEnv) {
        this.NAV_POI_CLASS_COUNT_CHOICE = 400641;
        this.NAV_DEST_POI_CHILD_CATEGORY_NAME_LABEL = 400253;
        this.env = navigationEnv;
        this.logChannel = navigationEnv.getPOILogChannel();
    }

    public AbstractPoiScreenModelAccess(NavigationEnv navigationEnv, IconHandler iconHandler, IRouteManager iRouteManager, IVehicle iVehicle, PoiSearchArea poiSearchArea) {
        this.NAV_POI_CLASS_COUNT_CHOICE = 400641;
        this.NAV_DEST_POI_CHILD_CATEGORY_NAME_LABEL = 400253;
        this.env = navigationEnv;
        this.iconHandler = iconHandler;
        this.routeManager = iRouteManager;
        this.vehicle = iVehicle;
        this.poiSearchArea = poiSearchArea;
        this.logChannel = navigationEnv.getPOILogChannel();
    }

    public void onUpdateResultList(LIValueList lIValueList, long l, String string, boolean bl) {
        this.env.getChoiceModel(400642).setValue((int)l);
    }

    public void onUpdateSearchStatus(int n, int n2) {
        this.env.getChoiceModel(400642).setValue(n);
    }
}

