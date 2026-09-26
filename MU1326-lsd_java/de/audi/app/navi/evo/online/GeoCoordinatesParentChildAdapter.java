/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.online;

import de.audi.app.navi.evo.addressinput.poi.listbuilders.PoiIconedParentCategoriesParentListRow;
import de.audi.app.navi.evo.online.GeoCoordinatesAdapter;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.navlocationextractor.NavLocationExctractor;
import org.dsi.ifc.global.NavLocation;

public class GeoCoordinatesParentChildAdapter
extends GeoCoordinatesAdapter {
    public GeoCoordinatesParentChildAdapter(NavLocationExctractor navLocationExctractor, NavigationEnv navigationEnv) {
        super(navLocationExctractor, navigationEnv);
    }

    @Override
    public NavLocation extractGeoCoordinates(int n, int n2, NavigationEnv navigationEnv) {
        EvoListRow evoListRow = this.env.getBaseListModel(n).getRow(n2);
        if (evoListRow instanceof PoiIconedParentCategoriesParentListRow) {
            return this.env.getContainer().getLiCurrentLD();
        }
        return super.extractGeoCoordinates(n, n2, navigationEnv);
    }
}

