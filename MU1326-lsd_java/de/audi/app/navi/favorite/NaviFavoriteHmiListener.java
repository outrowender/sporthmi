/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.favorite;

import de.audi.app.navi.evo.search.NaviSearchResultListRow;
import de.audi.app.navi.favorite.NaviFavoriteHandlerEvo;
import de.audi.app.navi.favorite.NaviFavoriteHmiListener$1;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.model.OptionModelListener;
import de.audi.atip.hmi.model.SpellerListener;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.menu.MenuModelListener;
import de.audi.atip.hmi.modelaccess.SpellerModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.phone.ITelService;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.HomeAddressHandler;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.adb.NaviADBHandler;
import de.audi.tghu.navi.app.addressinput.commands.HidePreviewMapCommand;
import de.audi.tghu.navi.app.addressinput.poi.PoiUtil;
import de.audi.tghu.navi.app.favorite.IFavorite;
import de.audi.tghu.navi.app.map.MapInterface;
import org.dsi.ifc.global.NavLocation;

public class NaviFavoriteHmiListener
implements ButtonListener,
OptionModelListener,
MenuModelListener,
SpellerListener {
    private final LogChannel lc;
    private final NavigationEnv env;
    private static final String LOGCLASS;
    private final NaviFavoriteHandlerEvo favoriteListHandler;
    private SpellerModelApp favoriteSpeller;
    private final MapInterface mapInterface;
    private final HomeAddressHandler homeAddressHandler;
    private final BaseListModelApp completeFavoritesListModel;
    private final BaseListModelApp searchResultListModel;
    private NaviADBHandler naviAdbHandler;
    private final ICommandListFactory commandListFactory;
    private final ITelService telService;
    private int maxInputLength = 256;

    public NaviFavoriteHmiListener(NavigationEnv navigationEnv, NaviFavoriteHandlerEvo naviFavoriteHandlerEvo, MapInterface mapInterface, HomeAddressHandler homeAddressHandler, NaviADBHandler naviADBHandler, ICommandListFactory iCommandListFactory, ITelService iTelService) {
        this.env = navigationEnv;
        this.mapInterface = mapInterface;
        this.homeAddressHandler = homeAddressHandler;
        this.lc = navigationEnv.getLogChannel();
        this.favoriteListHandler = naviFavoriteHandlerEvo;
        this.naviAdbHandler = naviADBHandler;
        this.commandListFactory = iCommandListFactory;
        this.telService = iTelService;
        this.completeFavoritesListModel = navigationEnv.getBaseListModel(-1239480832);
        this.searchResultListModel = navigationEnv.getBaseListModel(220202496);
        this.init();
    }

    public final void init() {
        this.env.getButtonModel(-786496000).setButtonListener(this);
        this.env.getButtonModel(-769718784).setButtonListener(this);
        this.env.getButtonModel(-2010905088).setButtonListener(this);
        this.env.getHMIService().getOptionModel(-1138817536).setListener(this, this.completeFavoritesListModel.getID());
        this.env.getHMIService().getOptionModel(-1205926400).setListener(this, this.completeFavoritesListModel.getID());
        this.env.getHMIService().getOptionModel(1293944320).setListener(this, this.completeFavoritesListModel.getID());
        this.env.getHMIService().getOptionModel(-467728896).setListener(this, this.completeFavoritesListModel.getID());
        this.env.getHMIService().getOptionModel(1176634880).setListener(this, this.completeFavoritesListModel.getID());
        this.env.getHMIService().getOptionModel(1948124672).setListener(this, this.completeFavoritesListModel.getID());
        this.env.getHMIService().getOptionModel(1830684160).setListener(this, this.completeFavoritesListModel.getID());
        this.env.getHMIService().getOptionModel(-1138817536).setListener(this, this.searchResultListModel.getID());
        this.env.getHMIService().getOptionModel(-1205926400).setListener(this, this.searchResultListModel.getID());
        this.env.getHMIService().getOptionModel(1293944320).setListener(this, this.searchResultListModel.getID());
        this.env.getHMIService().getOptionModel(-467728896).setListener(this, this.searchResultListModel.getID());
        this.env.getHMIService().getOptionModel(1176634880).setListener(this, this.searchResultListModel.getID());
        this.env.getHMIService().getOptionModel(1948124672).setListener(this, this.searchResultListModel.getID());
        this.env.getHMIService().getOptionModel(1830684160).setListener(this, this.searchResultListModel.getID());
        this.env.getMenuModel(-534837760).setListener(this);
        this.favoriteSpeller = this.env.getSpellerModel(1344603648);
        this.favoriteSpeller.setSpellerListener(this);
        this.favoriteSpeller.setMaxLength(this.maxInputLength);
    }

    public void deinit() {
        this.env.getButtonModel(-786496000).resetListener();
        this.env.getButtonModel(-769718784).resetListener();
        this.env.getButtonModel(-2010905088).resetListener();
        this.env.getHMIService().getOptionModel(-1138817536).resetListener();
        this.env.getHMIService().getOptionModel(-1205926400).resetListener();
        this.env.getHMIService().getOptionModel(-467728896).resetListener();
        this.env.getHMIService().getOptionModel(1176634880).resetListener();
        this.env.getHMIService().getOptionModel(1293944320).resetListener();
        this.env.getHMIService().getOptionModel(1948124672).resetListener();
        this.env.getHMIService().getOptionModel(1830684160).resetListener();
        this.env.getMenuModel(-534837760).resetListener();
        this.env.getSpellerModel(1344603648).resetListener();
    }

    @Override
    public void keyPressed(int n, int n2, int n3, int n4, int n5) {
        this.lc.log(1078071040, "%1#OptionModelListener.keyPressed targetRow=%2 modelID=%3", (Object)"NaviFavoriteHmiListener", (long)n3, (long)n);
        long l = -1L;
        if (n2 == this.completeFavoritesListModel.getID()) {
            l = this.env.getBaseListModel(n2).getRow(n3).getUniqueID();
        } else if (n2 == this.searchResultListModel.getID()) {
            l = ((NaviSearchResultListRow)this.env.getBaseListModel(n2).getRow(n3)).getSearchResult().getDataId();
            n3 = this.env.getBaseListModel(this.completeFavoritesListModel.getID()).getIndexForUniqueID(l);
        } else {
            this.lc.log(-1601830656, "%1#OptionModelListener.keyPressed targetRow=%2 modelID=%3 - UNKNOWN MODELID", (Object)"NaviFavoriteHmiListener", (long)n3, (long)n);
        }
        if (n == -1205926400) {
            this.favoriteListHandler.removeFavorite(n3);
            this.favoriteListHandler.refreshFavoritesInKombiMap(this.mapInterface.getKombiMap());
        } else if (n == -1138817536) {
            this.favoriteListHandler.renameFavorite(n3);
        } else if (n == -467728896) {
            NavLocation navLocation = this.favoriteListHandler.getFavoriteNavLocationByUniqueId(l);
            this.favoriteListHandler.parkingAtDestination(navLocation);
        } else if (n == 1176634880) {
            NavLocation navLocation = this.favoriteListHandler.getFavoriteNavLocationByUniqueId(l);
            this.favoriteListHandler.poiAtDestination(navLocation);
        } else if (n == 1293944320) {
            NavLocation navLocation = this.favoriteListHandler.getFavoriteNavLocationByUniqueId(l);
            this.naviAdbHandler.startStoringAddress(navLocation);
        } else if (n == 1830684160) {
            NavLocation navLocation = this.favoriteListHandler.getFavoriteNavLocationByUniqueId(l);
            PoiUtil.callPoi(navLocation, this.env, this.commandListFactory, this.telService);
        } else if (n == 1948124672) {
            NavLocation navLocation = this.favoriteListHandler.getFavoriteNavLocationByUniqueId(l);
            EvoListRow evoListRow = this.favoriteListHandler.getFavoriteRow(l);
            IFavorite iFavorite = null;
            if (evoListRow instanceof IFavorite) {
                iFavorite = (IFavorite)((Object)evoListRow);
            }
            this.mapInterface.destOptShowInMap(navLocation, false, iFavorite, false);
        } else {
            this.lc.log(-1601830656, "%1#OptionModelListener.keyPressed no handling for modelID: %2", (Object)"NaviFavoriteHmiListener", (long)n);
        }
        this.env.getHMIService().getOptionModel(n).fireEvent(n5);
    }

    @Override
    public void keyReleased(int n, int n2, int n3, int n4, int n5) {
        if (this.lc.isDebug2()) {
            this.lc.log(14808325, "%1#keyReleased targetRow=%2 modelID=%3", (Object)"NaviFavoriteHmiListener", (long)n3, (long)n);
        }
    }

    @Override
    public void keyTyped(int n, int n2, int n3, int n4, int n5) {
        if (this.lc.isDebug2()) {
            this.lc.log(14808325, "%1#keyTyped targetRow=%2 modelID=%3", (Object)"NaviFavoriteHmiListener", (long)n3, (long)n);
        }
    }

    @Override
    public void customAction(int n, int n2, int n3, int n4, int n5) {
        if (this.lc.isDebug2()) {
            this.lc.log(14808325, "%1#customAction actionID=%2 modelID=%3", (Object)"NaviFavoriteHmiListener", (long)n3, (long)n);
        }
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        this.lc.log(1078071040, "%1#ButtonListener.keyPressed modelID=%2", (Object)"NaviFavoriteHmiListener", (long)n);
        switch (n) {
            case 401361: {
                this.favoriteListHandler.saveNewFavorite(this.favoriteSpeller.getText());
                break;
            }
            case 401362: {
                this.favoriteListHandler.saveEditedFavorite(this.favoriteSpeller.getText());
                break;
            }
            case 402568: {
                this.favoriteListHandler.removeAll();
                break;
            }
            default: {
                this.lc.log(-1601830656, "%1#ButtonListener.keyPressed no handling for modelID: %2", (Object)"NaviFavoriteHmiListener", (long)n);
            }
        }
        this.favoriteListHandler.refreshFavoritesInKombiMap(this.mapInterface.getKombiMap());
        this.env.getButtonModel(n).fireEvent(n3);
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
        if (this.lc.isDebug2()) {
            this.lc.log(14808325, "%1#keyReleased targetRow=%2", (Object)"NaviFavoriteHmiListener", (long)n);
        }
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        if (this.lc.isDebug2()) {
            this.lc.log(14808325, "%1#keyTyped targetRow=%2", (Object)"NaviFavoriteHmiListener", (long)n);
        }
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
        if (this.lc.isDebug2()) {
            this.lc.log(14808325, "%1#keyLongTyped targetRow=%2", (Object)"NaviFavoriteHmiListener", (long)n);
        }
    }

    @Override
    public void itemFocused(int n, int n2, long l, int n3) {
        if (this.lc.isDebug2()) {
            this.lc.log(14808325, "NaviFavoriteHmiListener#itemFocused - %1 # %2 # %3", (long)n, (long)n2, (long)n3);
        }
        if (this.homeAddressHandler.isHomeAddressMenuItem(n)) {
            this.homeAddressHandler.handleHomeAddressFocus();
        } else if (n == -1222703616) {
            try {
                CommandList commandList = this.commandListFactory.createCommandList();
                if (this.env.getFramework().isAsia()) {
                    commandList.add(new NaviFavoriteHmiListener$1(this, "PoiSearchAreaHmiListener itemFocused"));
                    commandList.execute("NaviFavoriteHmiListener#previewAreaAroundCCP");
                } else {
                    commandList.add(new HidePreviewMapCommand(this.mapInterface.getPreviewMap()));
                    commandList.execute("NaviFavoriteHmiListener#hidePreviewMap");
                }
            }
            catch (Exception exception) {
                this.lc.log(10000, "NaviFavoriteHmiListener#itemFocused() - ERROR=%1", (Throwable)exception);
            }
        }
    }

    @Override
    public void textChanged(int n, String string, char c2, int n2) {
        this.favoriteSpeller.setText(this.favoriteSpeller.getText());
    }

    @Override
    public void focusedCharacter(int n, char c2, int n2) {
    }

    @Override
    public void commandPressed(int n, int n2, int n3) {
    }

    public void enterDestOptSaveAsFavorite() {
        this.lc.log(-2137614336, "%1#enterDestOptSaveAsFavorite", (Object)"NaviFavoriteHmiListener");
        this.favoriteListHandler.enterDestOptSaveAsFavorite();
    }

    static /* synthetic */ MapInterface access$000(NaviFavoriteHmiListener naviFavoriteHmiListener) {
        return naviFavoriteHmiListener.mapInterface;
    }
}

