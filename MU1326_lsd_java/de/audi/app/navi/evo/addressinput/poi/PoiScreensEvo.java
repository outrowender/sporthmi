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
    private static final int ACTIVE_POI_CONTEXT_DESTINATION = 0;
    private static final int ACTIVE_POI_CONTEXT_MAP = 1;
    private static final int ACTIVE_POI_CONTEXT_TPEG = 2;

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
        return 400200;
    }

    public static int getPoiMainScreenAllClassesButtonModel() {
        return 400184;
    }

    public static int getPoiMainScreenPersonalPoiButtonModel() {
        return 402561;
    }

    public static int getPoiMainScreenListModel() {
        return 401291;
    }

    public static int getPoiMainScreenMenuModel() {
        return 401290;
    }

    public static PoiResultScreenWithSpellerModelAccess getPoiResultScreenWithSpellerModelAccess(NavigationEnv navigationEnv, IconHandler iconHandler, IRouteManager iRouteManager, IVehicle iVehicle, PoiSearchArea poiSearchArea, IPreviewMap iPreviewMap) {
        return new PoiResultScreenWithSpellerModelAccess(navigationEnv, iconHandler, iRouteManager, iVehicle, poiSearchArea, PoiScreensEvo.getPoiResultScreenWithSpellerListModel(), PoiScreensEvo.getPoiResultScreenWithSpellerSpellerModel(), iPreviewMap);
    }

    public static int getPoiResultScreenWithSpellerSpellerModel() {
        return 400635;
    }

    public static int getPoiResultScreenWithSpellerListModel() {
        return 402581;
    }

    public static int getPoiResultScreenWithSpellerMenuModel() {
        return 401288;
    }

    public static PoiResultScreenNoSpellerModelAccess getPoiResultScreenNoSpellerModelAccess(NavigationEnv navigationEnv, IconHandler iconHandler, IRouteManager iRouteManager, IVehicle iVehicle, PoiSearchArea poiSearchArea) {
        return new PoiResultScreenNoSpellerModelAccess(navigationEnv, iconHandler, iRouteManager, iVehicle, poiSearchArea, PoiScreensEvo.getPoiResultScreeNoSpellerListModel());
    }

    public static int getPoiResultScreenNoSpellerSearchByNameButtonModel() {
        return 401587;
    }

    public static int getPoiResultScreenNoSpellerBrandsButtonModel() {
        return 400288;
    }

    public static int getPoiResultScreeNoSpellerListModel() {
        return 402576;
    }

    public static int getPoiResultScreenNoSpellerMenuModel() {
        return 401286;
    }

    public static PoiResultScreenWithMatchSpellerModelAccess getPoiResultScreenWithMatchSpellerModelAccess(NavigationEnv navigationEnv, IconHandler iconHandler, IRouteManager iRouteManager, IVehicle iVehicle, PoiSearchArea poiSearchArea) {
        return new PoiResultScreenWithMatchSpellerModelAccess(navigationEnv, PoiScreensEvo.getPoiResultScreenWithMatchSpellerTiledListModel(), PoiScreensEvo.getPoiResultScreenWithMatchSpellerSpellerModel(), iconHandler, iRouteManager, iVehicle, poiSearchArea);
    }

    public static int getPoiResultScreenWithMatchSpellerSpellerModel() {
        return 400975;
    }

    public static int getPoiResultScreenWithMatchSpellerTiledListModel() {
        return 401652;
    }

    public static int getPoiResultScreenWithMatchSpellerMenuModel() {
        return 401651;
    }

    public static PoiClassScreenModelAccess getPoiClassScreenModelAccess(NavigationEnv navigationEnv) {
        return new PoiClassScreenModelAccess(navigationEnv, new PoiNameListRowBuilder(), PoiScreensEvo.getPoiClassScreenBaseListModel());
    }

    public static int getPoiClassScreenBaseListModel() {
        return 402558;
    }

    public static int getPoiClassScreenSearchByNameButtonModel() {
        return 401586;
    }

    public static int getPoiClassScreenMenuModel() {
        return 401273;
    }

    public static PoiCategoryScreenModelAccess getPoiCategoryScreenModelAccess(NavigationEnv navigationEnv, IconHandler iconHandler) {
        return new PoiCategoryScreenModelAccess(navigationEnv, PoiScreensEvo.getPoiCategoryScreenBaseListModel(), new POIIconedListRowBuilder(iconHandler));
    }

    public static int getPoiCategoryScreenSearchByNameButtonModel() {
        return 402557;
    }

    public static int getPoiCategoryScreenAllCategoriesButtonModel() {
        return 400207;
    }

    public static int getPoiCategoryScreenBaseListModel() {
        return 401272;
    }

    public static int getPoiCategoryScreenMenuModel() {
        return 401271;
    }

    public static PoiBrandScreenModelAccess getPoiBrandScreenModelAccess(NavigationEnv navigationEnv, IconHandler iconHandler) {
        return new PoiBrandScreenModelAccess(navigationEnv, PoiScreensEvo.getPoiBrandScreenBaseListModel(), new POIIconedListRowBuilder(iconHandler));
    }

    public static int getPoiBrandScreenBaseListModel() {
        return 402570;
    }

    public static int getPoiBrandScreenMenuModel() {
        return 401297;
    }

    public static PoiBrandResultScreenNoSpellerModelAccess getPoiBrandResultScreenNoSpellerModelAccess(NavigationEnv navigationEnv, IconHandler iconHandler, IRouteManager iRouteManager, IVehicle iVehicle, PoiSearchArea poiSearchArea) {
        return new PoiBrandResultScreenNoSpellerModelAccess(navigationEnv, PoiScreensEvo.getPoiBrandResultScreenNoSpellerListModel(), iconHandler, iRouteManager, navigationEnv, iVehicle, poiSearchArea);
    }

    public static int getPoiBrandResultScreenNoSpellerListModel() {
        return 402586;
    }

    public static int getPoiBrandResultScreenNoSpellerSearchByNameButtonModel() {
        return 401615;
    }

    public static int getPoiBrandResultScreenNoSpellerMenuModel() {
        return 401265;
    }

    public static PoiParentChildCategoryScreenModelAccess getPoiParentChildCategoryScreenModelAccess(NavigationEnv navigationEnv, IconHandler iconHandler, IRouteManager iRouteManager, IVehicle iVehicle) {
        EvoRRDInitialPositionHandler evoRRDInitialPositionHandler = new EvoRRDInitialPositionHandler(iRouteManager, navigationEnv, iVehicle);
        return new PoiParentChildCategoryScreenModelAccess(navigationEnv, new PoiIconedParentCategoriesListRowBuilder(iconHandler, evoRRDInitialPositionHandler, navigationEnv), PoiScreensEvo.getPoiParentChildCategoryScreenBaseListModel());
    }

    public static int getPoiParentChildCategoryScreenBaseListModel() {
        return 401268;
    }

    public static int getPoiParentChildCategoryScreenMenuModel() {
        return 401267;
    }

    public static PoiParentChildResultScreenModelAccess getPoiParentChildResultScreenModelAccess(NavigationEnv navigationEnv, IconHandler iconHandler, IRouteManager iRouteManager, IVehicle iVehicle) {
        return new PoiParentChildResultScreenModelAccess(navigationEnv, PoiIconedResultsListRowBuilder.createPoiIconedResultsListRowBuilderDistanceFromCCP(iconHandler, iRouteManager, navigationEnv, iVehicle), PoiScreensEvo.getPoiParentChildResultScreenListModel());
    }

    public static int getPoiParentChildResultScreenListModel() {
        return 401270;
    }

    public static int getPoiParentChildResultScreenMenuModel() {
        return 401269;
    }

    public static PoiParkingNearDestinationScreenModelAccess getPoiParkingNearDestinationModelAccess(NavigationEnv navigationEnv, IconHandler iconHandler, IRouteManager iRouteManager) {
        return new PoiParkingNearDestinationScreenModelAccess(navigationEnv, PoiScreensEvo.getPoiParkingNearDestinationScreenListModel(), PoiIconedResultsListRowBuilder.createPoiIconedResultsListRowBuilderDistanceFromCCP(iconHandler, iRouteManager, navigationEnv, Vehicle.getInstance()), PoiScreensEvo.getPoiParkingNearDestinationScreenSpellerModel());
    }

    public static int getPoiParkingNearDestinationScreenListModel() {
        return 401311;
    }

    public static int getPoiParkingNearDestinationScreenSpellerModel() {
        return 401571;
    }

    public static int getPoiParkingNearDestinationScreenMenuModel() {
        return 401312;
    }

    public static int getDiAsiaTelephoneNumberScreenMatchSpellerModel() {
        return 401789;
    }

    public static int getDiAsiaTelephoneNumberScreenTiledListModel() {
        return 401787;
    }

    public static int getDiAsiaTelephoneNumberScreenMenuModel() {
        return 401931;
    }

    public static int getMapViewStackMenuModel() {
        return 401114;
    }

    public static PoiIconedResultsListRowBuilder createPoiIconedResultsListRowBuilder(PoiSearchArea poiSearchArea, NavigationEnv navigationEnv, IconHandler iconHandler, IVehicle iVehicle, IRouteManager iRouteManager) {
        if (poiSearchArea == null) {
            navigationEnv.getPOILogChannel().log(100000, "PoiScreensEvo#createPoiIconedResultsListRowBuilder poiSearchArea is null");
            return null;
        }
        int n = poiSearchArea.getSearchContext();
        switch (n) {
            case 2: 
            case 3: 
            case 4: {
                if (navigationEnv.getPOILogChannel().isDebug2()) {
                    navigationEnv.getPOILogChannel().log(100000000, "PoiScreensEvo#createPoiIconedResultsListRowBuilder return RowBuilder createPoiIconedResultsListRowBuilderDistanceFromNavLocation SearchContext: %1", (long)n);
                }
                return PoiIconedResultsListRowBuilder.createPoiIconedResultsListRowBuilderDistanceFromNavLocation(iconHandler, navigationEnv, poiSearchArea.getLocation());
            }
            case 0: 
            case 1: 
            case 5: {
                if (navigationEnv.getPOILogChannel().isDebug2()) {
                    navigationEnv.getPOILogChannel().log(100000000, "PoiScreensEvo#createPoiIconedResultsListRowBuilder return RowBuilder createPoiIconedResultsListRowBuilderDistanceFromCCP SearchContext: %1", (long)n);
                }
                return PoiIconedResultsListRowBuilder.createPoiIconedResultsListRowBuilderDistanceFromCCP(iconHandler, iRouteManager, navigationEnv, iVehicle);
            }
        }
        navigationEnv.getPOILogChannel().log(1000000, "PoiScreensEvo#createPoiIconedResultsListRowBuilder no valid searchContext : %1", (long)n);
        return null;
    }

    public static int getCategoryPropertyForActivePoiContext(NavigationEnv navigationEnv) {
        int n = navigationEnv.getChoiceModel(401894).getValue();
        if (n == 0) {
            return 1055316784;
        }
        if (n == 1) {
            return 1249247373;
        }
        if (n == 2) {
            return 737227883;
        }
        navigationEnv.getPOILogChannel().log(100000, "PoiScreensEvo#getCategoryPropertyForActivePoiContext - choice model has an unknown value! value=%1", (long)n);
        return -1;
    }
}

