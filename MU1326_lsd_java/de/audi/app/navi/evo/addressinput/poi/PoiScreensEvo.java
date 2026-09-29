/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi;

import de.audi.app.navi.evo.addressinput.poi.listbuilders.EvoRRDInitialPositionHandler;
import de.audi.app.navi.evo.addressinput.poi.listbuilders.PoiIconedParentCategoriesListRowBuilder;
import de.audi.app.navi.evo.addressinput.poi.listbuilders.PoiIconedResultsListRowBuilder;
import de.audi.app.navi.evo.addressinput.poi.listbuilders.PoiNameListRowBuilder;
import de.audi.app.navi.evo.addressinput.poi.listbuilders.evo.POIIconedListRowBuilder;
import de.audi.app.navi.evo.addressinput.poi.models.PoiBrandResultScreenNoSpellerModelAccess;
import de.audi.app.navi.evo.addressinput.poi.models.PoiBrandScreenModelAccess;
import de.audi.app.navi.evo.addressinput.poi.models.PoiCategoryScreenModelAccess;
import de.audi.app.navi.evo.addressinput.poi.models.PoiClassScreenModelAccess;
import de.audi.app.navi.evo.addressinput.poi.models.PoiMainScreenModelAccess;
import de.audi.app.navi.evo.addressinput.poi.models.PoiParentChildCategoryScreenModelAccess;
import de.audi.app.navi.evo.addressinput.poi.models.PoiParentChildResultScreenModelAccess;
import de.audi.app.navi.evo.addressinput.poi.models.PoiParkingNearDestinationScreenModelAccess;
import de.audi.app.navi.evo.addressinput.poi.models.PoiResultScreenNoSpellerModelAccess;
import de.audi.app.navi.evo.addressinput.poi.models.PoiResultScreenWithMatchSpellerModelAccess;
import de.audi.app.navi.evo.addressinput.poi.models.PoiResultScreenWithSpellerModelAccess;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchArea;
import de.audi.tghu.navi.app.guidance.IVehicle;
import de.audi.tghu.navi.app.guidance.Vehicle;
import de.audi.tghu.navi.app.routeguidance.IRouteManager;
import de.audi.tghu.navi.app.rows.LiValueListRow;
import org.dsi.ifc.navigation.LIValueListElement;

public class PoiScreensEvo {
    private static final int ACTIVE_POI_CONTEXT_DESTINATION;
    private static final int ACTIVE_POI_CONTEXT_MAP;
    private static final int ACTIVE_POI_CONTEXT_TPEG;

    public static LIValueListElement getLiValueListElementFromRow(EvoListRow evoListRow, int n) {
        if (evoListRow instanceof LiValueListRow) {
            return ((LiValueListRow)evoListRow).getElement();
        }
        return null;
    }

    public static PoiMainScreenModelAccess getPoiMainScreenModelAccess(NavigationEnv navigationEnv, IconHandler iconHandler) {
        return new PoiMainScreenModelAccess(navigationEnv, new POIIconedListRowBuilder(iconHandler), PoiScreensEvo.getPoiMainScreenListModel());
    }

    public static int getPoiMainScreenSearchByNameButtonModel() {
        return 1209730560;
    }

    public static int getPoiMainScreenAllClassesButtonModel() {
        return 941295104;
    }

    public static int getPoiMainScreenPersonalPoiButtonModel() {
        return -2128345600;
    }

    public static int getPoiMainScreenListModel() {
        return -1960901120;
    }

    public static int getPoiMainScreenMenuModel() {
        return -1977678336;
    }

    public static PoiResultScreenWithSpellerModelAccess getPoiResultScreenWithSpellerModelAccess(NavigationEnv navigationEnv, IconHandler iconHandler, IRouteManager iRouteManager, IVehicle iVehicle, PoiSearchArea poiSearchArea, IPreviewMap iPreviewMap) {
        return new PoiResultScreenWithSpellerModelAccess(navigationEnv, iconHandler, iRouteManager, iVehicle, poiSearchArea, PoiScreensEvo.getPoiResultScreenWithSpellerListModel(), PoiScreensEvo.getPoiResultScreenWithSpellerSpellerModel(), iPreviewMap);
    }

    public static int getPoiResultScreenWithSpellerSpellerModel() {
        return -82049536;
    }

    public static int getPoiResultScreenWithSpellerListModel() {
        return -1792801280;
    }

    public static int getPoiResultScreenWithSpellerMenuModel() {
        return -2011232768;
    }

    public static PoiResultScreenNoSpellerModelAccess getPoiResultScreenNoSpellerModelAccess(NavigationEnv navigationEnv, IconHandler iconHandler, IRouteManager iRouteManager, IVehicle iVehicle, PoiSearchArea poiSearchArea) {
        return new PoiResultScreenNoSpellerModelAccess(navigationEnv, iconHandler, iRouteManager, iVehicle, poiSearchArea, PoiScreensEvo.getPoiResultScreeNoSpellerListModel());
    }

    public static int getPoiResultScreenNoSpellerSearchByNameButtonModel() {
        return -1289746944;
    }

    public static int getPoiResultScreenNoSpellerBrandsButtonModel() {
        return -1608841728;
    }

    public static int getPoiResultScreeNoSpellerListModel() {
        return -1876687360;
    }

    public static int getPoiResultScreenNoSpellerMenuModel() {
        return -2044787200;
    }

    public static PoiResultScreenWithMatchSpellerModelAccess getPoiResultScreenWithMatchSpellerModelAccess(NavigationEnv navigationEnv, IconHandler iconHandler, IRouteManager iRouteManager, IVehicle iVehicle, PoiSearchArea poiSearchArea) {
        return new PoiResultScreenWithMatchSpellerModelAccess(navigationEnv, PoiScreensEvo.getPoiResultScreenWithMatchSpellerTiledListModel(), PoiScreensEvo.getPoiResultScreenWithMatchSpellerSpellerModel(), iconHandler, iRouteManager, iVehicle, poiSearchArea);
    }

    public static int getPoiResultScreenWithMatchSpellerSpellerModel() {
        return 1327367680;
    }

    public static int getPoiResultScreenWithMatchSpellerTiledListModel() {
        return -199227904;
    }

    public static int getPoiResultScreenWithMatchSpellerMenuModel() {
        return -216005120;
    }

    public static PoiClassScreenModelAccess getPoiClassScreenModelAccess(NavigationEnv navigationEnv) {
        return new PoiClassScreenModelAccess(navigationEnv, new PoiNameListRowBuilder(), PoiScreensEvo.getPoiClassScreenBaseListModel());
    }

    public static int getPoiClassScreenBaseListModel() {
        return 2116290048;
    }

    public static int getPoiClassScreenSearchByNameButtonModel() {
        return -1306524160;
    }

    public static int getPoiClassScreenMenuModel() {
        return 2032076288;
    }

    public static PoiCategoryScreenModelAccess getPoiCategoryScreenModelAccess(NavigationEnv navigationEnv, IconHandler iconHandler) {
        return new PoiCategoryScreenModelAccess(navigationEnv, PoiScreensEvo.getPoiCategoryScreenBaseListModel(), new POIIconedListRowBuilder(iconHandler));
    }

    public static int getPoiCategoryScreenSearchByNameButtonModel() {
        return 2099512832;
    }

    public static int getPoiCategoryScreenAllCategoriesButtonModel() {
        return 1327171072;
    }

    public static int getPoiCategoryScreenBaseListModel() {
        return 2015299072;
    }

    public static int getPoiCategoryScreenMenuModel() {
        return 1998521856;
    }

    public static PoiBrandScreenModelAccess getPoiBrandScreenModelAccess(NavigationEnv navigationEnv, IconHandler iconHandler) {
        return new PoiBrandScreenModelAccess(navigationEnv, PoiScreensEvo.getPoiBrandScreenBaseListModel(), new POIIconedListRowBuilder(iconHandler));
    }

    public static int getPoiBrandScreenBaseListModel() {
        return -1977350656;
    }

    public static int getPoiBrandScreenMenuModel() {
        return -1860237824;
    }

    public static PoiBrandResultScreenNoSpellerModelAccess getPoiBrandResultScreenNoSpellerModelAccess(NavigationEnv navigationEnv, IconHandler iconHandler, IRouteManager iRouteManager, IVehicle iVehicle, PoiSearchArea poiSearchArea) {
        return new PoiBrandResultScreenNoSpellerModelAccess(navigationEnv, PoiScreensEvo.getPoiBrandResultScreenNoSpellerListModel(), iconHandler, iRouteManager, navigationEnv, iVehicle, poiSearchArea);
    }

    public static int getPoiBrandResultScreenNoSpellerListModel() {
        return -1708915200;
    }

    public static int getPoiBrandResultScreenNoSpellerSearchByNameButtonModel() {
        return -819984896;
    }

    public static int getPoiBrandResultScreenNoSpellerMenuModel() {
        return 1897858560;
    }

    public static PoiParentChildCategoryScreenModelAccess getPoiParentChildCategoryScreenModelAccess(NavigationEnv navigationEnv, IconHandler iconHandler, IRouteManager iRouteManager, IVehicle iVehicle) {
        EvoRRDInitialPositionHandler evoRRDInitialPositionHandler = new EvoRRDInitialPositionHandler(iRouteManager, navigationEnv, iVehicle);
        return new PoiParentChildCategoryScreenModelAccess(navigationEnv, new PoiIconedParentCategoriesListRowBuilder(iconHandler, evoRRDInitialPositionHandler, navigationEnv), PoiScreensEvo.getPoiParentChildCategoryScreenBaseListModel());
    }

    public static int getPoiParentChildCategoryScreenBaseListModel() {
        return 1948190208;
    }

    public static int getPoiParentChildCategoryScreenMenuModel() {
        return 1931412992;
    }

    public static PoiParentChildResultScreenModelAccess getPoiParentChildResultScreenModelAccess(NavigationEnv navigationEnv, IconHandler iconHandler, IRouteManager iRouteManager, IVehicle iVehicle) {
        return new PoiParentChildResultScreenModelAccess(navigationEnv, PoiIconedResultsListRowBuilder.createPoiIconedResultsListRowBuilderDistanceFromCCP(iconHandler, iRouteManager, navigationEnv, iVehicle), PoiScreensEvo.getPoiParentChildResultScreenListModel());
    }

    public static int getPoiParentChildResultScreenListModel() {
        return 1981744640;
    }

    public static int getPoiParentChildResultScreenMenuModel() {
        return 1964967424;
    }

    public static PoiParkingNearDestinationScreenModelAccess getPoiParkingNearDestinationModelAccess(NavigationEnv navigationEnv, IconHandler iconHandler, IRouteManager iRouteManager) {
        return new PoiParkingNearDestinationScreenModelAccess(navigationEnv, PoiScreensEvo.getPoiParkingNearDestinationScreenListModel(), PoiIconedResultsListRowBuilder.createPoiIconedResultsListRowBuilderDistanceFromCCP(iconHandler, iRouteManager, navigationEnv, Vehicle.getInstance()), PoiScreensEvo.getPoiParkingNearDestinationScreenSpellerModel());
    }

    public static int getPoiParkingNearDestinationScreenListModel() {
        return -1625356800;
    }

    public static int getPoiParkingNearDestinationScreenSpellerModel() {
        return -1558182400;
    }

    public static int getPoiParkingNearDestinationScreenMenuModel() {
        return -1608579584;
    }

    public static int getDiAsiaTelephoneNumberScreenMatchSpellerModel() {
        return 2099316224;
    }

    public static int getDiAsiaTelephoneNumberScreenTiledListModel() {
        return 2065761792;
    }

    public static int getDiAsiaTelephoneNumberScreenMenuModel() {
        return 186779136;
    }

    public static int getMapViewStackMenuModel() {
        return -635566592;
    }

    public static PoiIconedResultsListRowBuilder createPoiIconedResultsListRowBuilder(PoiSearchArea poiSearchArea, NavigationEnv navigationEnv, IconHandler iconHandler, IVehicle iVehicle, IRouteManager iRouteManager) {
        if (poiSearchArea == null) {
            navigationEnv.getPOILogChannel().log(-1601830656, "PoiScreensEvo#createPoiIconedResultsListRowBuilder poiSearchArea is null");
            return null;
        }
        int n = poiSearchArea.getSearchContext();
        switch (n) {
            case 2: 
            case 3: 
            case 4: {
                if (navigationEnv.getPOILogChannel().isDebug2()) {
                    navigationEnv.getPOILogChannel().log(14808325, "PoiScreensEvo#createPoiIconedResultsListRowBuilder return RowBuilder createPoiIconedResultsListRowBuilderDistanceFromNavLocation SearchContext: %1", (long)n);
                }
                return PoiIconedResultsListRowBuilder.createPoiIconedResultsListRowBuilderDistanceFromNavLocation(iconHandler, navigationEnv, poiSearchArea.getLocation());
            }
            case 0: 
            case 1: 
            case 5: {
                if (navigationEnv.getPOILogChannel().isDebug2()) {
                    navigationEnv.getPOILogChannel().log(14808325, "PoiScreensEvo#createPoiIconedResultsListRowBuilder return RowBuilder createPoiIconedResultsListRowBuilderDistanceFromCCP SearchContext: %1", (long)n);
                }
                return PoiIconedResultsListRowBuilder.createPoiIconedResultsListRowBuilderDistanceFromCCP(iconHandler, iRouteManager, navigationEnv, iVehicle);
            }
        }
        navigationEnv.getPOILogChannel().log(1078071040, "PoiScreensEvo#createPoiIconedResultsListRowBuilder no valid searchContext : %1", (long)n);
        return null;
    }

    public static int getCategoryPropertyForActivePoiContext(NavigationEnv navigationEnv) {
        int n = navigationEnv.getChoiceModel(-434043392).getValue();
        if (n == 0) {
            return 819717694;
        }
        if (n == 1) {
            return -1929349558;
        }
        if (n == 2) {
            return 1798631723;
        }
        navigationEnv.getPOILogChannel().log(-1601830656, "PoiScreensEvo#getCategoryPropertyForActivePoiContext - choice model has an unknown value! value=%1", (long)n);
        return -1;
    }
}

