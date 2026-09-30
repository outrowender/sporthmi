/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi.searcharea;

import de.audi.app.navi.evo.addressinput.AddressInputLIValueListElementListRow;
import de.audi.app.navi.evo.addressinput.poi.PoiManager;
import de.audi.app.navi.evo.addressinput.poi.PoiScreensEvo;
import de.audi.app.navi.evo.addressinput.poi.listbuilders.POIHistoryRowBuilder;
import de.audi.app.navi.evo.addressinput.poi.searcharea.evo.PoiAreaCityZipInputModelAccess;
import de.audi.app.navi.evo.addressinput.poi.searcharea.evo.PoiCountryInputModelAccess;
import de.audi.atip.hmi.model.BaseListRow;
import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.model.ListListener;
import de.audi.atip.hmi.model.MatchSpellerListener;
import de.audi.atip.hmi.model.SpellerListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.list.TiledListModelListener;
import de.audi.atip.hmi.model.menu.MenuModelListener;
import de.audi.atip.hmi.modelaccess.ListModelApp;
import de.audi.atip.hmi.modelaccess.MatchspellerModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.IAddressInputForm;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.IPoiSearchAreaHandler;
import de.audi.tghu.navi.app.routeguidance.IRouteManager;
import de.audi.tghu.navi.app.util.RouteUtil;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LICityHistoryEntry;
import org.dsi.ifc.navigation.LIValueListElement;
import org.dsi.ifc.navigation.Route;

public class PoiSearchAreaHmiListener
implements MatchSpellerListener,
ListListener,
TiledListModelListener,
ChoiceListener,
MenuModelListener,
SpellerListener {
    private final NavigationEnv env;
    private final IPoiSearchAreaHandler searchAreaHandler;
    private final IRouteManager routeManager;
    private final PoiManager poiManager;
    private final IAddressInputForm addressInputService;
    private final LogChannel logChannel;
    private final String CLASS_NAME = Util.getClassNameFromPackageName(this.getClass());

    public PoiSearchAreaHmiListener(NavigationEnv navigationEnv, IPoiSearchAreaHandler iPoiSearchAreaHandler, IRouteManager iRouteManager, PoiManager poiManager, IAddressInputForm iAddressInputForm) {
        this.env = navigationEnv;
        this.searchAreaHandler = iPoiSearchAreaHandler;
        this.routeManager = iRouteManager;
        this.poiManager = poiManager;
        this.addressInputService = iAddressInputForm;
        this.logChannel = navigationEnv.getPOILogChannel();
        this.initListeners();
    }

    private void initListeners() {
        this.env.getChoiceModel(402577).setChoiceListener(this);
        this.env.getButtonModel(400196).setButtonListener(this);
        this.env.getButtonModel(400199).setButtonListener(this);
        this.env.getButtonModel(400194).setButtonListener(this);
        this.env.getButtonModel(400190).setButtonListener(this);
        this.env.getButtonModel(400185).setButtonListener(this);
        this.env.getButtonModel(400197).setButtonListener(this);
        this.env.getButtonModel(400912).setButtonListener(this);
        this.env.getButtonModel(401804).setButtonListener(this);
        this.env.getButtonModel(401802).setButtonListener(this);
        this.env.getButtonModel(401803).setButtonListener(this);
        this.env.getTextfieldModel(400278).setButtonListener(this);
        this.env.getListModel(400263).setListListener(this);
        this.env.getTiledListModel(401262).setListener(this);
        this.env.getMenuModel(401261).setListener(this);
        this.env.getMenuModel(401637).setListener(this);
        this.env.getMenuModel(402007).setListener(this);
        this.env.getSpellerModel(401852).setSpellerListener(this);
    }

    public void restoreToPreviousState() {
        this.searchAreaHandler.restore();
    }

    public void keyPressed(int n, int n2, int n3) {
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void keyTyped(int n, int n2, int n3) {
        this.logChannel.log(10000000, "%1#keyTyped. modelId: %2, keyId: %3", (Object)this.CLASS_NAME, (long)n, (long)n2);
        switch (n) {
            case 402577: {
                this.searchAreaHandler.start(this.env.getContainer().isRgActive(), RouteUtil.getNumberOfDestinations(this.routeManager.getRoute(), 1));
                break;
            }
            case 400196: {
                this.searchAreaHandler.updateSearchArea(0, null);
                this.poiManager.startPoiMainScreen(true, false);
                break;
            }
            case 400199: {
                this.searchAreaHandler.updateSearchArea(1, null);
                this.poiManager.startPoiMainScreen(true, false);
                break;
            }
            case 400190: {
                Route route = this.routeManager.getFilteredRoute();
                NavLocation navLocation = RouteUtil.getFinalDestination(route);
                this.logChannel.log(10000000, "%1#keyTyped - destination: %2", (Object)this.CLASS_NAME, (Object)navLocation);
                this.searchAreaHandler.updateSearchArea(2, navLocation);
                this.poiManager.startPoiMainScreen(true, false);
                break;
            }
            case 400194: {
                Route route = this.routeManager.getFilteredRoute();
                NavLocation navLocation = RouteUtil.getFirstDestination(route);
                this.logChannel.log(10000000, "%1#keyTyped - stopover: %2", (Object)this.CLASS_NAME, (Object)navLocation);
                this.searchAreaHandler.updateSearchArea(3, navLocation);
                this.poiManager.startPoiMainScreen(true, false);
                break;
            }
            case 400912: {
                this.searchAreaHandler.startCountryCity(true);
                break;
            }
            case 400278: {
                this.searchAreaHandler.startCountryInputSequence(new PoiCountryInputModelAccess(this.env, this, this), true);
                break;
            }
            case 400185: {
                PoiAreaCityZipInputModelAccess poiAreaCityZipInputModelAccess = new PoiAreaCityZipInputModelAccess(this.env, this, this);
                this.poiManager.startPoiAreaCityInputSequence(this.searchAreaHandler, poiAreaCityZipInputModelAccess);
                break;
            }
            case 400197: {
                this.poiManager.startPoiMainScreen(true, false);
                break;
            }
            case 401804: {
                this.env.getChoiceModel(401824).setValue(1);
                this.addressInputService.startCityZipInputSequence();
                break;
            }
            case 401802: 
            case 401803: {
                this.env.getChoiceModel(401824).setValue(1);
                this.addressInputService.start();
                break;
            }
            default: {
                this.logChannel.log(100000, "%1#keyTyped() - unsupported modelID: %2", (Object)this.CLASS_NAME, (long)n);
            }
        }
        this.env.fireModelEvent(n, n3);
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }

    public void textChanged(int n, String string, char c2, int n2) {
        this.logChannel.log(10000000, "%1#textChanged. modelId: %2, text: %3", (Object)this.CLASS_NAME, (Object)string, (long)n);
        if (n == 401852) {
            this.searchAreaHandler.startCountryInputSequence(c2, new PoiCountryInputModelAccess(this.env, this, this), true);
            this.env.fireModelEvent(n, n2);
        } else {
            MatchspellerModelApp matchspellerModelApp = this.env.getMatchSpellerModel(n);
            Util.setModelStatus(matchspellerModelApp, 0);
            if ("".equals(string)) {
                this.searchAreaHandler.deleteAllCharacters();
            } else if (c2 == '\b') {
                this.searchAreaHandler.undoCharacter();
            } else {
                this.searchAreaHandler.addCharacter(Character.toString(c2));
            }
        }
    }

    public void commandPressed(int n, int n2, int n3) {
    }

    public void itemReleased(int n, int n2, int n3, int n4) {
    }

    public void itemSelected(int n, int n2, int n3, int n4) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#itemSelected. modelId: %1, col: %2, row: %3", (long)n, (long)n3, (long)n2);
        ListModelApp listModelApp = this.env.getListModel(n);
        BaseListRow baseListRow = listModelApp.getRow(n2);
        ListCell[] listCellArray = baseListRow.getCells();
        if (n == 400263) {
            LICityHistoryEntry lICityHistoryEntry = POIHistoryRowBuilder.getLiCityHistoryEntry(listCellArray);
            this.searchAreaHandler.selectListElement(lICityHistoryEntry, this.poiManager.getPoiMainScreenHmiListener().getStartCommandList(), true);
        } else {
            this.logChannel.log(10000000, this.CLASS_NAME + "#itemSelected. modelId: %1, col: %2, row: %3 - Model not recognised", (long)n, (long)n3, (long)n2);
        }
        this.env.fireModelEvent(n, n4);
    }

    public void itemFocused(int n, int n2, long l, int n3) {
        this.logChannel.log(10000000, "%1#itemFocused MenuModel menuItemID=%2, model=%3", (Object)this.CLASS_NAME, (long)n, (long)n2);
        if (n == 400274) {
            this.searchAreaHandler.hidePreviewMap();
        } else if (n2 == 401637 || n2 == 402007) {
            if (n == 400196 || n == 400195) {
                this.searchAreaHandler.showCCPInPreviewMap();
            } else if (n == 400199) {
                this.searchAreaHandler.showRouteInPreviewMap();
            } else if (n == 400190 || n == 400191) {
                NavLocation navLocation = RouteUtil.getFinalDestination(this.routeManager.getFilteredRoute());
                this.searchAreaHandler.showDestinationAreaInPreviewMap(navLocation);
            } else if (n == 400194 || n == 400970) {
                NavLocation navLocation = RouteUtil.getFirstDestination(this.routeManager.getFilteredRoute());
                this.searchAreaHandler.showDestinationAreaInPreviewMap(navLocation);
            } else if (n == 400912 || n == 401804 || n == 401325 || n == 401802 || n == 401803) {
                this.searchAreaHandler.showCCPInPreviewMap();
            }
        }
    }

    public void itemFocused(int n, int n2, int n3, int n4) {
        this.logChannel.log(10000000, "%1#itemFocused ListListener model=%2", (Object)this.CLASS_NAME, (long)n);
        if (n == 400263 && n2 > -1) {
            ListModelApp listModelApp = this.env.getListModel(n);
            BaseListRow baseListRow = listModelApp.getRow(n2);
            ListCell[] listCellArray = baseListRow.getCells();
            LICityHistoryEntry lICityHistoryEntry = POIHistoryRowBuilder.getLiCityHistoryEntry(listCellArray);
            this.searchAreaHandler.showCityInPreviewMap(lICityHistoryEntry);
        } else if (n == 400263 && n2 == -1) {
            this.searchAreaHandler.showCCPInPreviewMap();
        }
    }

    public void focusedCharacter(int n, char c2, int n2) {
    }

    public void itemReleased(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.logChannel.log(10000000, "%1#itemSelected - item selected was called with model = %2, index = %3", (Object)this.CLASS_NAME, (long)n, (long)n2);
        if (evoListRow instanceof AddressInputLIValueListElementListRow) {
            this.logChannel.log(10000000, "%1#itemSelected row is instanceOf AILIVLELR", (Object)this.CLASS_NAME);
            AddressInputLIValueListElementListRow addressInputLIValueListElementListRow = (AddressInputLIValueListElementListRow)evoListRow;
            this.searchAreaHandler.selectListElement(addressInputLIValueListElementListRow.getElement(), false);
            this.env.fireModelEvent(n, n4);
        }
    }

    public void itemLongSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.logChannel.log(10000000, "%1#itemFocused ListListener modelID=%2, row=%3", (Object)this.CLASS_NAME, (Object)evoListRow, (long)n);
        LIValueListElement lIValueListElement = PoiScreensEvo.getLiValueListElementFromRow(evoListRow, n);
        this.searchAreaHandler.showCityInPreviewMap(lIValueListElement);
    }

    public void requestItems(int n, int n2, int n3, int n4, int n5) {
        this.searchAreaHandler.requestNextResultListWindow(n, n3);
    }

    public void unrequestItems(int n, int n2, int n3, int n4) {
    }
}

