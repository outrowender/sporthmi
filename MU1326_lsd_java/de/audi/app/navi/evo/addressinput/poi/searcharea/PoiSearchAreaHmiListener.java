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
    private final String CLASS_NAME = Util.getClassNameFromPackageName(super.getClass());

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
        this.env.getChoiceModel(-1859910144).setChoiceListener(this);
        this.env.getButtonModel(1142621696).setButtonListener(this);
        this.env.getButtonModel(1192953344).setButtonListener(this);
        this.env.getButtonModel(1109067264).setButtonListener(this);
        this.env.getButtonModel(1041958400).setButtonListener(this);
        this.env.getButtonModel(958072320).setButtonListener(this);
        this.env.getButtonModel(1159398912).setButtonListener(this);
        this.env.getButtonModel(270403072).setButtonListener(this);
        this.env.getButtonModel(-1943992832).setButtonListener(this);
        this.env.getButtonModel(-1977547264).setButtonListener(this);
        this.env.getButtonModel(-1960770048).setButtonListener(this);
        this.env.getTextfieldModel(-1776613888).setButtonListener(this);
        this.env.getListModel(-2028272128).setListListener(this);
        this.env.getTiledListModel(1847526912).setListener(this);
        this.env.getMenuModel(1830749696).setListener(this);
        this.env.getMenuModel(-450886144).setListener(this);
        this.env.getMenuModel(1461847552).setListener(this);
        this.env.getSpellerModel(-1138686464).setSpellerListener(this);
    }

    public void restoreToPreviousState() {
        this.searchAreaHandler.restore();
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        this.logChannel.log(-2137614336, "%1#keyTyped. modelId: %2, keyId: %3", (Object)this.CLASS_NAME, (long)n, (long)n2);
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
                this.logChannel.log(-2137614336, "%1#keyTyped - destination: %2", (Object)this.CLASS_NAME, (Object)navLocation);
                this.searchAreaHandler.updateSearchArea(2, navLocation);
                this.poiManager.startPoiMainScreen(true, false);
                break;
            }
            case 400194: {
                Route route = this.routeManager.getFilteredRoute();
                NavLocation navLocation = RouteUtil.getFirstDestination(route);
                this.logChannel.log(-2137614336, "%1#keyTyped - stopover: %2", (Object)this.CLASS_NAME, (Object)navLocation);
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
                this.env.getChoiceModel(-1608448512).setValue(1);
                this.addressInputService.startCityZipInputSequence();
                break;
            }
            case 401802: 
            case 401803: {
                this.env.getChoiceModel(-1608448512).setValue(1);
                this.addressInputService.start();
                break;
            }
            default: {
                this.logChannel.log(-1601830656, "%1#keyTyped() - unsupported modelID: %2", (Object)this.CLASS_NAME, (long)n);
            }
        }
        this.env.fireModelEvent(n, n3);
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    @Override
    public void textChanged(int n, String string, char c2, int n2) {
        this.logChannel.log(-2137614336, "%1#textChanged. modelId: %2, text: %3", (Object)this.CLASS_NAME, (Object)string, (long)n);
        if (n == -1138686464) {
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

    @Override
    public void commandPressed(int n, int n2, int n3) {
    }

    @Override
    public void itemReleased(int n, int n2, int n3, int n4) {
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#itemSelected. modelId: %1, col: %2, row: %3").toString(), (long)n, (long)n3, (long)n2);
        ListModelApp listModelApp = this.env.getListModel(n);
        BaseListRow baseListRow = listModelApp.getRow(n2);
        ListCell[] listCellArray = baseListRow.getCells();
        if (n == -2028272128) {
            LICityHistoryEntry lICityHistoryEntry = POIHistoryRowBuilder.getLiCityHistoryEntry(listCellArray);
            this.searchAreaHandler.selectListElement(lICityHistoryEntry, this.poiManager.getPoiMainScreenHmiListener().getStartCommandList(), true);
        } else {
            this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#itemSelected. modelId: %1, col: %2, row: %3 - Model not recognised").toString(), (long)n, (long)n3, (long)n2);
        }
        this.env.fireModelEvent(n, n4);
    }

    @Override
    public void itemFocused(int n, int n2, long l, int n3) {
        this.logChannel.log(-2137614336, "%1#itemFocused MenuModel menuItemID=%2, model=%3", (Object)this.CLASS_NAME, (long)n, (long)n2);
        if (n == -1843722752) {
            this.searchAreaHandler.hidePreviewMap();
        } else if (n2 == -450886144 || n2 == 1461847552) {
            if (n == 1142621696 || n == 1125844480) {
                this.searchAreaHandler.showCCPInPreviewMap();
            } else if (n == 1192953344) {
                this.searchAreaHandler.showRouteInPreviewMap();
            } else if (n == 1041958400 || n == 1058735616) {
                NavLocation navLocation = RouteUtil.getFinalDestination(this.routeManager.getFilteredRoute());
                this.searchAreaHandler.showDestinationAreaInPreviewMap(navLocation);
            } else if (n == 1109067264 || n == 1243481600) {
                NavLocation navLocation = RouteUtil.getFirstDestination(this.routeManager.getFilteredRoute());
                this.searchAreaHandler.showDestinationAreaInPreviewMap(navLocation);
            } else if (n == 270403072 || n == -1943992832 || n == -1390475776 || n == -1977547264 || n == -1960770048) {
                this.searchAreaHandler.showCCPInPreviewMap();
            }
        }
    }

    @Override
    public void itemFocused(int n, int n2, int n3, int n4) {
        this.logChannel.log(-2137614336, "%1#itemFocused ListListener model=%2", (Object)this.CLASS_NAME, (long)n);
        if (n == -2028272128 && n2 > -1) {
            ListModelApp listModelApp = this.env.getListModel(n);
            BaseListRow baseListRow = listModelApp.getRow(n2);
            ListCell[] listCellArray = baseListRow.getCells();
            LICityHistoryEntry lICityHistoryEntry = POIHistoryRowBuilder.getLiCityHistoryEntry(listCellArray);
            this.searchAreaHandler.showCityInPreviewMap(lICityHistoryEntry);
        } else if (n == -2028272128 && n2 == -1) {
            this.searchAreaHandler.showCCPInPreviewMap();
        }
    }

    @Override
    public void focusedCharacter(int n, char c2, int n2) {
    }

    @Override
    public void itemReleased(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    @Override
    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.logChannel.log(-2137614336, "%1#itemSelected - item selected was called with model = %2, index = %3", (Object)this.CLASS_NAME, (long)n, (long)n2);
        if (evoListRow instanceof AddressInputLIValueListElementListRow) {
            this.logChannel.log(-2137614336, "%1#itemSelected row is instanceOf AILIVLELR", (Object)this.CLASS_NAME);
            AddressInputLIValueListElementListRow addressInputLIValueListElementListRow = (AddressInputLIValueListElementListRow)evoListRow;
            this.searchAreaHandler.selectListElement(addressInputLIValueListElementListRow.getElement(), false);
            this.env.fireModelEvent(n, n4);
        }
    }

    @Override
    public void itemLongSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    @Override
    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.logChannel.log(-2137614336, "%1#itemFocused ListListener modelID=%2, row=%3", (Object)this.CLASS_NAME, (Object)evoListRow, (long)n);
        LIValueListElement lIValueListElement = PoiScreensEvo.getLiValueListElementFromRow(evoListRow, n);
        this.searchAreaHandler.showCityInPreviewMap(lIValueListElement);
    }

    @Override
    public void requestItems(int n, int n2, int n3, int n4, int n5) {
        this.searchAreaHandler.requestNextResultListWindow(n, n3);
    }

    @Override
    public void unrequestItems(int n, int n2, int n3, int n4) {
    }
}

