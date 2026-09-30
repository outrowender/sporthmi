/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.favorite;

import de.audi.app.navi.evo.search.NaviSearchResultListRow;
import de.audi.app.navi.favorite.NaviFavoriteHandlerEvo;
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
import de.audi.tghu.navi.app.command.NavCommand;
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
    private static final String LOGCLASS = "NaviFavoriteHmiListener";
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
        this.completeFavoritesListModel = navigationEnv.getBaseListModel(401334);
        this.searchResultListModel = navigationEnv.getBaseListModel(401421);
        this.init();
    }

    public final void init() {
        this.env.getButtonModel(401361).setButtonListener(this);
        this.env.getButtonModel(401362).setButtonListener(this);
        this.env.getButtonModel(402568).setButtonListener(this);
        this.env.getHMIService().getOptionModel(401340).setListener(this, this.completeFavoritesListModel.getID());
        this.env.getHMIService().getOptionModel(401336).setListener(this, this.completeFavoritesListModel.getID());
        this.env.getHMIService().getOptionModel(401485).setListener(this, this.completeFavoritesListModel.getID());
        this.env.getHMIService().getOptionModel(401380).setListener(this, this.completeFavoritesListModel.getID());
        this.env.getHMIService().getOptionModel(401990).setListener(this, this.completeFavoritesListModel.getID());
        this.env.getHMIService().getOptionModel(401012).setListener(this, this.completeFavoritesListModel.getID());
        this.env.getHMIService().getOptionModel(401005).setListener(this, this.completeFavoritesListModel.getID());
        this.env.getHMIService().getOptionModel(401340).setListener(this, this.searchResultListModel.getID());
        this.env.getHMIService().getOptionModel(401336).setListener(this, this.searchResultListModel.getID());
        this.env.getHMIService().getOptionModel(401485).setListener(this, this.searchResultListModel.getID());
        this.env.getHMIService().getOptionModel(401380).setListener(this, this.searchResultListModel.getID());
        this.env.getHMIService().getOptionModel(401990).setListener(this, this.searchResultListModel.getID());
        this.env.getHMIService().getOptionModel(401012).setListener(this, this.searchResultListModel.getID());
        this.env.getHMIService().getOptionModel(401005).setListener(this, this.searchResultListModel.getID());
        this.env.getMenuModel(401376).setListener(this);
        this.favoriteSpeller = this.env.getSpellerModel(402768);
        this.favoriteSpeller.setSpellerListener(this);
        this.favoriteSpeller.setMaxLength(this.maxInputLength);
    }

    public void deinit() {
        this.env.getButtonModel(401361).resetListener();
        this.env.getButtonModel(401362).resetListener();
        this.env.getButtonModel(402568).resetListener();
        this.env.getHMIService().getOptionModel(401340).resetListener();
        this.env.getHMIService().getOptionModel(401336).resetListener();
        this.env.getHMIService().getOptionModel(401380).resetListener();
        this.env.getHMIService().getOptionModel(401990).resetListener();
        this.env.getHMIService().getOptionModel(401485).resetListener();
        this.env.getHMIService().getOptionModel(401012).resetListener();
        this.env.getHMIService().getOptionModel(401005).resetListener();
        this.env.getMenuModel(401376).resetListener();
        this.env.getSpellerModel(402768).resetListener();
    }

    public void keyPressed(int n, int n2, int n3, int n4, int n5) {
        this.lc.log(1000000, "%1#OptionModelListener.keyPressed targetRow=%2 modelID=%3", (Object)LOGCLASS, (long)n3, (long)n);
        long l = -1L;
        if (n2 == this.completeFavoritesListModel.getID()) {
            l = this.env.getBaseListModel(n2).getRow(n3).getUniqueID();
        } else if (n2 == this.searchResultListModel.getID()) {
            l = ((NaviSearchResultListRow)this.env.getBaseListModel(n2).getRow(n3)).getSearchResult().getDataId();
            n3 = this.env.getBaseListModel(this.completeFavoritesListModel.getID()).getIndexForUniqueID(l);
        } else {
            this.lc.log(100000, "%1#OptionModelListener.keyPressed targetRow=%2 modelID=%3 - UNKNOWN MODELID", (Object)LOGCLASS, (long)n3, (long)n);
        }
        if (n == 401336) {
            this.favoriteListHandler.removeFavorite(n3);
            this.favoriteListHandler.refreshFavoritesInKombiMap(this.mapInterface.getKombiMap());
        } else if (n == 401340) {
            this.favoriteListHandler.renameFavorite(n3);
        } else if (n == 401380) {
            NavLocation navLocation = this.favoriteListHandler.getFavoriteNavLocationByUniqueId(l);
            this.favoriteListHandler.parkingAtDestination(navLocation);
        } else if (n == 401990) {
            NavLocation navLocation = this.favoriteListHandler.getFavoriteNavLocationByUniqueId(l);
            this.favoriteListHandler.poiAtDestination(navLocation);
        } else if (n == 401485) {
            NavLocation navLocation = this.favoriteListHandler.getFavoriteNavLocationByUniqueId(l);
            this.naviAdbHandler.startStoringAddress(navLocation);
        } else if (n == 401005) {
            NavLocation navLocation = this.favoriteListHandler.getFavoriteNavLocationByUniqueId(l);
            PoiUtil.callPoi(navLocation, this.env, this.commandListFactory, this.telService);
        } else if (n == 401012) {
            NavLocation navLocation = this.favoriteListHandler.getFavoriteNavLocationByUniqueId(l);
            EvoListRow evoListRow = this.favoriteListHandler.getFavoriteRow(l);
            IFavorite iFavorite = null;
            if (evoListRow instanceof IFavorite) {
                iFavorite = (IFavorite)((Object)evoListRow);
            }
            this.mapInterface.destOptShowInMap(navLocation, false, iFavorite, false);
        } else {
            this.lc.log(100000, "%1#OptionModelListener.keyPressed no handling for modelID: %2", (Object)LOGCLASS, (long)n);
        }
        this.env.getHMIService().getOptionModel(n).fireEvent(n5);
    }

    public void keyReleased(int n, int n2, int n3, int n4, int n5) {
        if (this.lc.isDebug2()) {
            this.lc.log(100000000, "%1#keyReleased targetRow=%2 modelID=%3", (Object)LOGCLASS, (long)n3, (long)n);
        }
    }

    public void keyTyped(int n, int n2, int n3, int n4, int n5) {
        if (this.lc.isDebug2()) {
            this.lc.log(100000000, "%1#keyTyped targetRow=%2 modelID=%3", (Object)LOGCLASS, (long)n3, (long)n);
        }
    }

    public void customAction(int n, int n2, int n3, int n4, int n5) {
        if (this.lc.isDebug2()) {
            this.lc.log(100000000, "%1#customAction actionID=%2 modelID=%3", (Object)LOGCLASS, (long)n3, (long)n);
        }
    }

    public void keyPressed(int n, int n2, int n3) {
        this.lc.log(1000000, "%1#ButtonListener.keyPressed modelID=%2", (Object)LOGCLASS, (long)n);
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
                this.lc.log(100000, "%1#ButtonListener.keyPressed no handling for modelID: %2", (Object)LOGCLASS, (long)n);
            }
        }
        this.favoriteListHandler.refreshFavoritesInKombiMap(this.mapInterface.getKombiMap());
        this.env.getButtonModel(n).fireEvent(n3);
    }

    public void keyReleased(int n, int n2, int n3) {
        if (this.lc.isDebug2()) {
            this.lc.log(100000000, "%1#keyReleased targetRow=%2", (Object)LOGCLASS, (long)n);
        }
    }

    public void keyTyped(int n, int n2, int n3) {
        if (this.lc.isDebug2()) {
            this.lc.log(100000000, "%1#keyTyped targetRow=%2", (Object)LOGCLASS, (long)n);
        }
    }

    public void keyLongTyped(int n, int n2, int n3) {
        if (this.lc.isDebug2()) {
            this.lc.log(100000000, "%1#keyLongTyped targetRow=%2", (Object)LOGCLASS, (long)n);
        }
    }

    public void itemFocused(int n, int n2, long l, int n3) {
        if (this.lc.isDebug2()) {
            this.lc.log(100000000, "NaviFavoriteHmiListener#itemFocused - %1 # %2 # %3", (long)n, (long)n2, (long)n3);
        }
        if (this.homeAddressHandler.isHomeAddressMenuItem(n)) {
            this.homeAddressHandler.handleHomeAddressFocus();
        } else if (n == 401335) {
            try {
                CommandList commandList = this.commandListFactory.createCommandList();
                if (this.env.getFramework().isAsia()) {
                    commandList.add(new NavCommand("PoiSearchAreaHmiListener itemFocused"){

                        public void execute() {
                            NaviFavoriteHmiListener.this.mapInterface.getPreviewMap().setPreviewAreaAroundCCP(1);
                            this.getCommandList().commandFinished();
                        }
                    });
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

    public void textChanged(int n, String string, char c2, int n2) {
        this.favoriteSpeller.setText(this.favoriteSpeller.getText());
    }

    public void focusedCharacter(int n, char c2, int n2) {
    }

    public void commandPressed(int n, int n2, int n3) {
    }

    public void enterDestOptSaveAsFavorite() {
        this.lc.log(10000000, "%1#enterDestOptSaveAsFavorite", (Object)LOGCLASS);
        this.favoriteListHandler.enterDestOptSaveAsFavorite();
    }
}

