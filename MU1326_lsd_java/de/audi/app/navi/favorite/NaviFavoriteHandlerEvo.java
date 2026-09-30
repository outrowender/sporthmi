/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.favorite;

import de.audi.app.navi.favorite.DefaultFavoriteLocationFormat;
import de.audi.app.navi.favorite.FavoriteLocationFormatAsia;
import de.audi.app.navi.favorite.FavoriteLocationFormatEU;
import de.audi.app.navi.favorite.FavoriteLocationFormatNAR;
import de.audi.app.navi.favorite.NaviFavoriteEvoRow;
import de.audi.app.navi.favorite.NaviFavoriteSearchDataProvider;
import de.audi.atip.favorite.FavoriteListRow;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.interapp.NaviADBService;
import de.audi.atip.interapp.NaviServiceListener;
import de.audi.atip.interapp.SDSListEntry;
import de.audi.atip.interapp.combi.bap.navi.data.CombiBAPNaviDestination;
import de.audi.atip.interapp.combi.bap.navi.data.FormattedDestination;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.ADBInterAppService;
import de.audi.tghu.navi.app.HomeAddressHandler;
import de.audi.tghu.navi.app.LocationSerializer;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.poi.IPoiService;
import de.audi.tghu.navi.app.cluster.ClusterService;
import de.audi.tghu.navi.app.cluster.CombiBAPListener;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.favorite.IFavorite;
import de.audi.tghu.navi.app.favorite.IFavoriteLocationFormat;
import de.audi.tghu.navi.app.favorite.NaviFavoriteHandler;
import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Util;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import org.dsi.ifc.global.NavLocation;
import org.osgi.framework.BundleContext;

public class NaviFavoriteHandlerEvo
extends NaviFavoriteHandler {
    private static final String LOGCLASS = "NaviFavoriteHandlerEvo";
    private NavLocation navLocationNewFavorite;
    private int favoriteForEditing;
    private final HomeAddressHandler homeAddressHandler;
    private IPoiService poiService;
    private final NaviServiceListener naviServiceListener;
    private ADBInterAppService adbInterAppService;
    private final CombiBAPListener combiBAPListener;
    private final DispatcherBase dispatcher;

    public NaviFavoriteHandlerEvo(NavigationEnv navigationEnv, LocationSerializer locationSerializer, ICommandListFactory iCommandListFactory, IPreviewMap iPreviewMap, HomeAddressHandler homeAddressHandler, ADBInterAppService aDBInterAppService, BundleContext bundleContext, NaviServiceListener naviServiceListener, DispatcherBase dispatcherBase, CombiBAPListener combiBAPListener) {
        super(navigationEnv, navigationEnv.getBaseListModel(401334), navigationEnv.getHMIService().getOptionModel(401468), locationSerializer, iCommandListFactory, iPreviewMap);
        this.homeAddressHandler = homeAddressHandler;
        this.naviServiceListener = naviServiceListener;
        this.adbInterAppService = aDBInterAppService;
        this.dispatcher = dispatcherBase;
        this.combiBAPListener = combiBAPListener;
        this.favoriteDataProvider = new NaviFavoriteSearchDataProvider(this.log, navigationEnv.getFramework(), bundleContext, 5, this.favoriteListModel);
        this.favoriteDataProvider.start();
        this.setMoreThanOneFavoriteChoiceModel();
        this.notifyObservers();
    }

    protected IFavoriteLocationFormat initLocationFormatForRegion() {
        if (Util.isHURegionEU() || Util.isHURegionRdW()) {
            return new FavoriteLocationFormatEU(this.env);
        }
        if (Util.isHURegionNAR()) {
            return new FavoriteLocationFormatNAR(this.env);
        }
        if (Util.isHURegionAsia()) {
            return new FavoriteLocationFormatAsia(this.env);
        }
        return new DefaultFavoriteLocationFormat(this.env);
    }

    public void setPoiService(IPoiService iPoiService) {
        this.poiService = iPoiService;
    }

    private void startRouteGuidance(final NavLocation navLocation) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new NavCommand("StartRouteGuidance"){

            public void execute() {
                NaviFavoriteHandlerEvo.this.log.log(10000000, "%1#startRouteGuidance - Starting route guidance to: %2", (Object)NaviFavoriteHandlerEvo.LOGCLASS, (Object)LocationFormatter.formatLocationShort(navLocation));
                if (navLocation != null) {
                    this.getCommandList().commandFinishedWithPostSequence(this.navigation.getStartGuidanceDependantSequence().getStartSequence(navLocation));
                }
                this.getCommandList().commandFinished();
            }
        });
        commandList.execute("StartRouteGuidanceWithFavorite");
    }

    private final void notifyObservers() {
        this.favoriteDataProvider.invalidateData();
        if (this.naviServiceListener != null) {
            this.naviServiceListener.updateFavoriteDestinations(this.getFavoriteSDSEntries());
        }
        if (this.combiBAPListener != null) {
            this.combiBAPListener.setFavoritesDestinationsList(this.getFavoritesBapEntries(), this.getDescriptionsForBap(), this.getFormattedDestinationsForFastLists());
        }
    }

    protected void addToFavorites(FavoriteListRow favoriteListRow, boolean bl) {
        super.addToFavorites(favoriteListRow, bl);
        this.setMoreThanOneFavoriteChoiceModel();
    }

    protected void removeFavorite(FavoriteListRow favoriteListRow, boolean bl) {
        super.removeFavorite(favoriteListRow, bl);
        this.setMoreThanOneFavoriteChoiceModel();
    }

    protected void removeAllFavorites(boolean bl) {
        super.removeAllFavorites(bl);
        this.setMoreThanOneFavoriteChoiceModel();
    }

    private void setMoreThanOneFavoriteChoiceModel() {
        if (this.getNrFavorites() > 1) {
            this.env.getChoiceModel(401574).setValue(1);
        } else {
            this.env.getChoiceModel(401574).setValue(0);
        }
    }

    protected void refreshFavoritesInKombiMap(AbstractMap abstractMap) {
        if (abstractMap != null) {
            abstractMap.getMapFlagHandler().refresh(true);
        }
    }

    public void updateNaviPersistence() {
        this.log.log(1000000, "%1#updateNaviPersistence", (Object)LOGCLASS);
        this.updatePersistence();
    }

    protected void updatePersistence() {
        super.updatePersistence();
        this.notifyObservers();
    }

    protected void capacityReached(boolean bl) {
        this.log.log(1000000, "NaviFavoriteHandlerEvo#capacityReached: %1", bl);
        if (bl) {
            this.env.getChoiceModel(401360).setValue(1);
        } else {
            this.env.getChoiceModel(401360).setValue(0);
        }
    }

    public void favoriteSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        NaviADBService.LocationInputHandler locationInputHandler;
        this.log.log(1000000, "%1#favoriteSelected model=%2, index=%3, inputMode=%4", (Object)LOGCLASS, (long)n, (long)n2);
        this.log.log(10000000, "%1#favoriteSelected, inputMode=%2", (Object)LOGCLASS, (long)this.inputManager.getInputMode());
        byte[] byArray = ((NaviFavoriteEvoRow)evoListRow).getFavoriteLocation();
        if (this.inputManager.getInputMode() == 0) {
            NavLocation navLocation = this.locationSerializer.streamToLocation(byArray);
            this.startRouteGuidance(navLocation);
        } else if (this.inputManager.getInputMode() == 2) {
            NavLocation navLocation = this.locationSerializer.streamToLocation(byArray);
            this.homeAddressHandler.onCreateEditHomeAddress(navLocation);
        } else if (this.inputManager.getInputMode() == 1 && (locationInputHandler = this.adbInterAppService.getCurrentLocationInputHandler()) != null) {
            locationInputHandler.updateLocation(byArray);
        }
        this.favoriteListModel.fireEvent(n4);
    }

    public void moveModeActivated() {
        super.moveModeActivated();
        this.env.getChoiceModel(401484).setValue(1);
    }

    public void moveModeDeactivated() {
        super.moveModeDeactivated();
        this.env.getChoiceModel(401484).setValue(0);
    }

    public NavLocation getFavoriteNavLocationByUniqueId(long l) {
        NaviFavoriteEvoRow naviFavoriteEvoRow = (NaviFavoriteEvoRow)this.favoriteListModel.getRowByUniqueID(l);
        return this.locationSerializer.streamToLocation(naviFavoriteEvoRow.getFavoriteLocation());
    }

    public byte[] getFavoriteNavLocationStreamByUniqueId(long l) {
        NaviFavoriteEvoRow naviFavoriteEvoRow = (NaviFavoriteEvoRow)this.favoriteListModel.getRowByUniqueID(l);
        return naviFavoriteEvoRow.getFavoriteLocation();
    }

    public NavLocation getFavoriteNavLocationByListIndex(int n) {
        NaviFavoriteEvoRow naviFavoriteEvoRow = (NaviFavoriteEvoRow)this.favoriteListModel.getRow(n);
        return this.locationSerializer.streamToLocation(naviFavoriteEvoRow.getFavoriteLocation());
    }

    public final SDSListEntry[] getFavoriteSDSEntries() {
        SDSListEntry[] sDSListEntryArray = new SDSListEntry[this.favoriteListModel.getLength()];
        for (int i2 = 0; i2 < this.favoriteListModel.getLength(); ++i2) {
            NaviFavoriteEvoRow naviFavoriteEvoRow = (NaviFavoriteEvoRow)this.favoriteListModel.getRow(i2);
            sDSListEntryArray[i2] = new SDSListEntry(naviFavoriteEvoRow.getFavoriteName(), naviFavoriteEvoRow.getUniqueID());
        }
        return sDSListEntryArray;
    }

    private String[] getDescriptionsForBap() {
        String[] stringArray = new String[this.favoriteListModel.getLength()];
        for (int i2 = 0; i2 < this.favoriteListModel.getLength(); ++i2) {
            NaviFavoriteEvoRow naviFavoriteEvoRow = (NaviFavoriteEvoRow)this.favoriteListModel.getRow(i2);
            stringArray[i2] = Util.concat2StringsWithComma(naviFavoriteEvoRow.getFavoriteName(), naviFavoriteEvoRow.getFormattedAddressLine());
        }
        return stringArray;
    }

    private FormattedDestination[] getFormattedDestinationsForFastLists() {
        FormattedDestination[] formattedDestinationArray = new FormattedDestination[this.favoriteListModel.getLength()];
        for (int i2 = 0; i2 < this.favoriteListModel.getLength(); ++i2) {
            FormattedDestination formattedDestination;
            NaviFavoriteEvoRow naviFavoriteEvoRow = (NaviFavoriteEvoRow)this.favoriteListModel.getRow(i2);
            if (naviFavoriteEvoRow == null) continue;
            formattedDestinationArray[i2] = formattedDestination = new FormattedDestination(naviFavoriteEvoRow.getFavoriteName(), naviFavoriteEvoRow.getFormattedAddressLine());
        }
        return formattedDestinationArray;
    }

    private CombiBAPNaviDestination[] getFavoritesBapEntries() {
        CombiBAPNaviDestination[] combiBAPNaviDestinationArray = new CombiBAPNaviDestination[this.favoriteListModel.getLength()];
        for (int i2 = 0; i2 < this.favoriteListModel.getLength(); ++i2) {
            NaviFavoriteEvoRow naviFavoriteEvoRow = (NaviFavoriteEvoRow)this.favoriteListModel.getRow(i2);
            String string = naviFavoriteEvoRow.getStreet() != null ? naviFavoriteEvoRow.getStreet() : "";
            String string2 = naviFavoriteEvoRow.getHouseNumber() != null ? naviFavoriteEvoRow.getHouseNumber() : "";
            string = Util.appendHouseNumberForFPK(string, string2, this.env.getFramework());
            CombiBAPNaviDestination combiBAPNaviDestination = new CombiBAPNaviDestination("", "", string, string2, naviFavoriteEvoRow.getCity() != null ? naviFavoriteEvoRow.getCity() : "", "", "", "", "", Util.isHURegionAsia() ? Float.NaN : ClusterService.wgs84ToDeg(naviFavoriteEvoRow.getLatitude()), Util.isHURegionAsia() ? Float.NaN : ClusterService.wgs84ToDeg(naviFavoriteEvoRow.getLongitude()), naviFavoriteEvoRow.getType() == 1 ? 255 : 0, naviFavoriteEvoRow.getFavoriteName(), "", -1);
            combiBAPNaviDestination.setNaviType(2);
            combiBAPNaviDestination.setNaviID(naviFavoriteEvoRow.getUniqueID());
            combiBAPNaviDestinationArray[i2] = combiBAPNaviDestination;
        }
        return combiBAPNaviDestinationArray;
    }

    public void enterDestOptSaveAsFavorite() {
        this.log.log(10000000, "%1#enterDestOptSaveAsFavorite navLocationNewFavorite=%2", (Object)LOGCLASS, (Object)this.navLocationNewFavorite);
        this.previewMap.setPreviewLocation(this.navLocationNewFavorite, 1, null, null);
    }

    public void addToFavorites(NavLocation navLocation, String string) {
        this.log.log(1000000, "%1#addToFavorites favoriteLocation=%2", (Object)LOGCLASS, (Object)LocationFormatter.formatLocationShort(navLocation));
        if (navLocation == null) {
            this.log.log(10000, "%1#addToFavorites favorite has no NavLocation and will not be added to favorites", (Object)LOGCLASS);
            return;
        }
        this.env.getSpellerModel(402768).setText(string);
        this.navLocationNewFavorite = navLocation;
    }

    public void addToFavorites(NavLocation navLocation) {
        this.log.log(1000000, "%1#addToFavorites using favoriteLocationFormat favoriteLocation=%2", (Object)LOGCLASS, (Object)LocationFormatter.formatLocationShort(navLocation));
        String string = this.favoriteLocationFormat.getDefaultName(navLocation);
        if (navLocation == null) {
            this.log.log(10000, "%1#addToFavorites favorite has no NavLocation and will not be added to favorites", (Object)LOGCLASS);
            return;
        }
        this.env.getSpellerModel(402768).setText(string);
        this.navLocationNewFavorite = navLocation;
    }

    public EvoListRow getFavoriteRow(long l) {
        return this.favoriteListModel.getRowByUniqueID(l);
    }

    public String getFavoriteAddress(long l) {
        return this.favoriteListModel.getRowByUniqueID(l).getText(3);
    }

    public IFavorite[] getFavorites() {
        IFavorite[] iFavoriteArray = new IFavorite[this.favoriteListModel.getLength()];
        for (int i2 = 0; i2 < this.favoriteListModel.getLength(); ++i2) {
            iFavoriteArray[i2] = (NaviFavoriteEvoRow)this.favoriteListModel.getRow(i2);
        }
        return iFavoriteArray;
    }

    protected void saveNewFavorite(String string) {
        if (this.log.isDebug2()) {
            this.log.log(100000000, "%1#saveNewFavorite favorite=%2", (Object)LOGCLASS, (Object)string);
        }
        if (this.navLocationNewFavorite == null) {
            this.log.log(10000, "%1#saveNewFavorite no valid NavLocation for favorite=%2", (Object)LOGCLASS, (Object)string);
            return;
        }
        Util.setDescriptionOnLocation(this.navLocationNewFavorite, string);
        NaviFavoriteEvoRow naviFavoriteEvoRow = new NaviFavoriteEvoRow(NaviFavoriteHandlerEvo.generateUniqueID(), this.locationSerializer.locationToStream(this.navLocationNewFavorite), string, this.navLocationNewFavorite, this.env);
        this.addToFavorites(naviFavoriteEvoRow, false);
        this.navLocationNewFavorite = null;
        this.updateNaviPersistence();
    }

    protected void renameFavorite(int n) {
        this.favoriteForEditing = n;
        String string = ((NaviFavoriteEvoRow)this.favoriteListModel.getRow(n)).getFavoriteName();
        this.env.getSpellerModel(402768).setText(string);
    }

    protected void saveEditedFavorite(final String string) {
        final NaviFavoriteEvoRow naviFavoriteEvoRow = (NaviFavoriteEvoRow)this.favoriteListModel.getRow(this.favoriteForEditing);
        this.dispatcher.execute(new Runnable(){

            public void run() {
                NavLocation navLocation = NaviFavoriteHandlerEvo.this.locationSerializer.streamToLocation(naviFavoriteEvoRow.getFavoriteLocation());
                Util.setDescriptionOnLocation(navLocation, string);
                naviFavoriteEvoRow.setFavoriteLocation(NaviFavoriteHandlerEvo.this.locationSerializer.locationToStream(navLocation));
                naviFavoriteEvoRow.setFavoriteName(string);
                NaviFavoriteHandlerEvo.this.favoriteListModel.setRow(NaviFavoriteHandlerEvo.this.favoriteForEditing, naviFavoriteEvoRow);
                NaviFavoriteHandlerEvo.this.notifyObservers();
            }
        });
    }

    protected void removeFavorite(int n) {
        if (this.log.isDebug2()) {
            this.log.log(100000000, "%1#removeFavorite index=%2", (Object)LOGCLASS, (long)n);
        }
        FavoriteListRow favoriteListRow = (FavoriteListRow)this.favoriteListModel.getRow(n);
        this.removeFavorite(favoriteListRow, false);
        this.notifyObservers();
    }

    protected void removeAll() {
        if (this.log.isDebug2()) {
            this.log.log(100000000, "%1#removeAll", (Object)LOGCLASS);
        }
        this.removeAllFavorites(false);
        this.notifyObservers();
    }

    protected void parkingAtDestination(NavLocation navLocation) {
        if (this.poiService != null) {
            this.poiService.getParkingNearDestinationSequenceWithDistanceFromDestination(navLocation).execute("NaviFavoriteHandlerEvo#ParkingNearDestination");
        } else {
            this.log.log(10000, "%1#parkingAtDestination poiService is null", (Object)LOGCLASS);
        }
    }

    protected void poiAtDestination(NavLocation navLocation) {
        if (this.poiService != null) {
            this.poiService.startPoiWithSearchContext(4, navLocation, true, true);
        } else {
            this.log.log(10000, "%1#poiAtDestination poiService is null", (Object)LOGCLASS);
        }
    }

    public void resetMemorySettings() {
        if (this.log.isDebug2()) {
            this.log.log(100000000, "%1#resetMemorySettings", (Object)LOGCLASS);
        }
        this.removeAllFavorites(true);
        this.notifyObservers();
    }

    public IPoiService getPoiService() {
        return this.poiService;
    }

    public void setLocationFromADB(NavLocation navLocation) {
    }

    public void setFavoritesContext(int n) {
    }
}

