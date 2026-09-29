/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi.fuelwarning;

import de.audi.app.navi.evo.addressinput.poi.fuelwarning.FuelWarningSequenceModelAccess;
import de.audi.app.navi.evo.addressinput.poi.listbuilders.PoiIconedResultsListRow;
import de.audi.app.navi.evo.addressinput.poi.listbuilders.PoiIconedResultsListRowBuilder;
import de.audi.atip.hmi.model.list.BaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.guidance.IVehicle;
import de.audi.tghu.navi.app.routeguidance.IRouteManager;
import org.dsi.ifc.navigation.LIValueListElement;

public class FuelWarningScreens {
    public static int getVicinityListModel() {
        return -2061564416;
    }

    public static int getAlongRouteListModel() {
        return -2095118848;
    }

    public static FuelWarningSequenceModelAccess createFuelWarningModelAccess(NavigationEnv navigationEnv, BaseListModelListener baseListModelListener, IconHandler iconHandler, int n, int n2, IRouteManager iRouteManager, IVehicle iVehicle) {
        return new FuelWarningSequenceModelAccess(navigationEnv, baseListModelListener, PoiIconedResultsListRowBuilder.createPoiIconedResultsListRowBuilderDistanceFromCCP(iconHandler, iRouteManager, navigationEnv, iVehicle), n, n2);
    }

    public static LIValueListElement getFuelWarningListSelectedElement(EvoListRow evoListRow) {
        if (!(evoListRow instanceof PoiIconedResultsListRow)) {
            return null;
        }
        return ((PoiIconedResultsListRow)evoListRow).getElement();
    }
}

