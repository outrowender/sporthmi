/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi.sds;

import de.audi.app.navi.evo.addressinput.poi.sds.PoiSDSPickListModelAccess;
import de.audi.app.navi.evo.addressinput.poi.sds.PoiSDSUidResultsModelAccess;
import de.audi.app.navi.evo.addressinput.poi.sds.SDSPoiPickListRowBuilder;
import de.audi.app.navi.evo.sds.SUIListRowBuilder;
import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.poi.sds.IPickListModelAccess;
import de.audi.tghu.navi.app.addressinput.sds.SDSPoiScreens;
import de.audi.tghu.navi.app.guidance.IVehicle;
import de.audi.tghu.navi.app.routeguidance.IRouteManager;
import org.dsi.ifc.navigation.LIValueListElement;

public class SDSPoiScreensEvo
extends SDSPoiScreens {
    public static IPickListModelAccess getPickListScreenModelAccess(NavigationEnv navigationEnv) {
        return new PoiSDSPickListModelAccess(navigationEnv, new SDSPoiPickListRowBuilder(), SDSPoiScreensEvo.getPickListScreenListModel());
    }

    public static String getPoiPickListCategoryName(ListCell[] listCellArray) {
        return SDSPoiPickListRowBuilder.getPoiCategoryName(listCellArray);
    }

    public static String getPoiPickListCategoryName(EvoListRow evoListRow) {
        return SDSPoiPickListRowBuilder.getPoiCategoryName(evoListRow);
    }

    public static int getPoiPickListCategoryId(ListCell[] listCellArray) {
        return SDSPoiPickListRowBuilder.getPoiId(listCellArray);
    }

    public static long getPoiPickListCategoryId(EvoListRow evoListRow) {
        return SDSPoiPickListRowBuilder.getPoiId(evoListRow);
    }

    public static PoiSDSUidResultsModelAccess getResultsScreenModelAccess(NavigationEnv navigationEnv, IconHandler iconHandler, IRouteManager iRouteManager, IVehicle iVehicle) {
        SUIListRowBuilder sUIListRowBuilder = SUIListRowBuilder.createSUIListRowBuilderDistanceFromCCP(navigationEnv.getSDSLogChannel(), iconHandler, iRouteManager, navigationEnv, iVehicle);
        return new PoiSDSUidResultsModelAccess(navigationEnv, sUIListRowBuilder, SDSPoiScreensEvo.getPOIResultScreenListModel());
    }

    public static LIValueListElement getResultsScreenListElement(EvoListRow evoListRow) {
        return SUIListRowBuilder.getLiValueListElement(evoListRow);
    }
}

