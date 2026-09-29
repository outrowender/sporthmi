/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.searcharea;

import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.CityHistory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.IAddressInputForm;
import de.audi.tghu.navi.app.addressinput.IMatchspellerInputSequence;
import de.audi.tghu.navi.app.addressinput.IMatchspellerModelAccess;
import de.audi.tghu.navi.app.addressinput.commands.CmdNaviPreviewMapNavLocationSet;
import de.audi.tghu.navi.app.addressinput.commands.GetLastCityHistoryEntryCommand;
import de.audi.tghu.navi.app.addressinput.commands.HidePreviewMapCommand;
import de.audi.tghu.navi.app.addressinput.commands.LISetCurrentLDCommand;
import de.audi.tghu.navi.app.addressinput.commands.SetHistoryContextWithCurrentLDCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.LIRestoreStateCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.LiGetStateCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.SetCityAsLocationForPreviewMapCommand;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.IPoiSearchAreaHandler;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.IPoiSearchAreaModelAccess;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiCityZipInputSequence;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiCountryInputSequence;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchArea;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchAreaSequence$1;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchAreaSequence$2;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchAreaSequence$3;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchAreaSequence$4;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchAreaSequence$5;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchAreaSequence$6;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchAreaSequence$7;
import de.audi.tghu.navi.app.guidance.IVehicle;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.routeguidance.IRouteManager;
import de.audi.tghu.navi.app.util.LocationFormatter;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LICityHistoryEntry;
import org.dsi.ifc.navigation.LISpellerData;
import org.dsi.ifc.navigation.LIValueListElement;

public class PoiSearchAreaSequence
implements IPoiSearchAreaHandler {
    protected final SpellerStack spellerStack;
    protected final ICommandListFactory commandListFactory;
    protected final PoiSearchArea poiSearchArea;
    protected final IPoiSearchAreaModelAccess modelAccess;
    protected final PoiSearchArea tempSearchArea;
    protected final IVehicle vehicle;
    protected final CityHistory cityHistory;
    protected final NavigationEnv env;
    protected final IRouteManager routeManager;
    protected LISpellerData initialSpellerState;
    protected IMatchspellerInputSequence currentInputSequence = null;
    protected final IAddressInputForm addressInputForm;
    protected final IPreviewMap previewMap;
    protected final LogChannel logChannel;

    public PoiSearchAreaSequence(IPoiSearchAreaModelAccess iPoiSearchAreaModelAccess, SpellerStack spellerStack, PoiSearchArea poiSearchArea, ICommandListFactory iCommandListFactory, IVehicle iVehicle, NavigationEnv navigationEnv, CityHistory cityHistory, IRouteManager iRouteManager, IAddressInputForm iAddressInputForm, IPreviewMap iPreviewMap) {
        this.modelAccess = iPoiSearchAreaModelAccess;
        this.spellerStack = spellerStack;
        this.commandListFactory = iCommandListFactory;
        this.vehicle = iVehicle;
        this.env = navigationEnv;
        this.routeManager = iRouteManager;
        this.cityHistory = cityHistory;
        this.poiSearchArea = poiSearchArea;
        this.addressInputForm = iAddressInputForm;
        this.previewMap = iPreviewMap;
        this.tempSearchArea = new PoiSearchArea(navigationEnv.getPOILogChannel());
        this.logChannel = navigationEnv.getPOILogChannel();
    }

    @Override
    public void start(boolean bl) {
    }

    @Override
    public void start(boolean bl, int n) {
        this.logChannel.log(-2137614336, "[PoiSearchArea] PoiSearchAreaSequence#start() - isRgActive=%1, numberOfDestinations=%2", bl, (long)n);
        this.modelAccess.onUpdateSearchArea(this.poiSearchArea, bl, n);
    }

    @Override
    public void startCountryCity(boolean bl) {
        this.logChannel.log(-2137614336, "[PoiSearchArea] PoiSearchAreaSequence#startCountryCity()");
        this.cleanUp();
        CommandList commandList = this.commandListFactory.createCommandList();
        if (bl) {
            commandList.add(new LiGetStateCommand());
            commandList.add(new PoiSearchAreaSequence$1(this, "PoiSearchAreaSequence#startCountryCity - save tempSpellerState"));
        }
        commandList.add(new LISetCurrentLDCommand(this.getInitialCountryLocation()));
        commandList.add(new PoiSearchAreaSequence$2(this, "PoiSearchAreaSequence#startCountryCity - set SearchContext for tempSearchArea"));
        commandList.add(new SetHistoryContextWithCurrentLDCommand());
        commandList.add(new PoiSearchAreaSequence$3(this, "PoiSearchAreaSequence#startCountryCity - ModelAccess#OnStart"));
        commandList.execute("PoiSearchAreaSequence#startCountryCity");
    }

    private NavLocation getInitialCountryLocation() {
        this.logChannel.log(-2137614336, "PoiSearchAreaSequence#getInitialCountryLocation");
        if (this.poiSearchArea.getLocation() != null) {
            this.logChannel.log(-2137614336, "PoiSearchAreaSequence#getInitialCountryLocation - POISearchArea country: %1", (Object)this.poiSearchArea.getLocation().getCountry());
            return this.poiSearchArea.getLocation();
        }
        this.logChannel.log(-2137614336, "PoiSearchAreaSequence#getInitialCountryLocation. vehicle possition: %1", (Object)this.vehicle.getVehicleCountryLocation().getCountry());
        return this.vehicle.getVehicleCountryLocation();
    }

    @Override
    public void updateSearchArea(int n, NavLocation navLocation) {
        this.logChannel.log(-2137614336, "PoiSearchAreaSequence#updateSearchArea. searchContextId: %2 , location: %1", (Object)LocationFormatter.formatLocationShort(navLocation), (long)n);
        this.poiSearchArea.setLocation(navLocation);
        this.poiSearchArea.setSearchContext(n);
        this.modelAccess.onUpdateSearchArea(this.poiSearchArea);
    }

    @Override
    public void startCountryInputSequence(IMatchspellerModelAccess iMatchspellerModelAccess, boolean bl) {
        this.logChannel.log(-2137614336, "PoiSearchAreaSequence#startCountryInputSequence()");
        this.currentInputSequence = new PoiCountryInputSequence(iMatchspellerModelAccess, this.modelAccess, this.spellerStack, this.commandListFactory, this.tempSearchArea, this.addressInputForm, this.previewMap, this.env);
        this.currentInputSequence.start(bl);
    }

    @Override
    public void startCountryInputSequence(char c2, IMatchspellerModelAccess iMatchspellerModelAccess, boolean bl) {
        this.logChannel.log(-2137614336, "[PoiSearchArea] PoiSearchAreaSequence#startCountryInputSequence(latestChar=%1)", c2);
        PoiCountryInputSequence poiCountryInputSequence = new PoiCountryInputSequence(iMatchspellerModelAccess, this.modelAccess, this.spellerStack, this.commandListFactory, this.tempSearchArea, this.addressInputForm, this.previewMap, this.env);
        this.currentInputSequence = poiCountryInputSequence;
        poiCountryInputSequence.start(c2, bl);
    }

    @Override
    public void startPoiAreaCityZipInputSequence(IMatchspellerModelAccess iMatchspellerModelAccess, boolean bl) {
        this.logChannel.log(-2137614336, "[PoiSearchArea] PoiSearchAreaSequence#startPoiAreaCityZipInputSequence( no cl )");
        this.startPoiAreaCityZipInputSequence(iMatchspellerModelAccess, null, bl);
    }

    @Override
    public void startPoiAreaCityZipInputSequence(IMatchspellerModelAccess iMatchspellerModelAccess, CommandList commandList, boolean bl) {
        this.logChannel.log(-2137614336, "[PoiSearchArea] PoiSearchAreaSequence#startPoiAreaCityZipInputSequence( )");
        this.currentInputSequence = new PoiCityZipInputSequence(iMatchspellerModelAccess, this.modelAccess, this.spellerStack, this.commandListFactory, this.poiSearchArea, this.cityHistory, commandList, this.previewMap, this.addressInputForm);
        this.currentInputSequence.start(bl);
    }

    @Override
    public void addCharacter(String string) {
        if (this.currentInputSequence != null) {
            this.currentInputSequence.addCharacter(string);
        }
    }

    @Override
    public void deleteAllCharacters() {
        if (this.currentInputSequence != null) {
            this.currentInputSequence.deleteAllCharacters();
        }
    }

    @Override
    public void requestNextResultListWindow(int n, int n2) {
        if (this.currentInputSequence != null) {
            this.currentInputSequence.requestNextResultListWindow(n, n2);
        }
    }

    @Override
    public void requestPreviousResultListWindow(int n) {
        if (this.currentInputSequence != null) {
            this.currentInputSequence.requestPreviousResultListWindow(n);
        }
    }

    @Override
    public void selectListElement(LIValueListElement lIValueListElement, boolean bl) {
        if (this.currentInputSequence != null) {
            this.currentInputSequence.selectListElement(lIValueListElement, bl);
        }
    }

    @Override
    public CommandList getSelectListElementCommandList(LIValueListElement lIValueListElement, boolean bl) {
        if (this.currentInputSequence != null) {
            return this.currentInputSequence.getSelectListElementCommandList(lIValueListElement, bl);
        }
        return null;
    }

    @Override
    public void selectElementByIdentifier(String string) {
        if (this.currentInputSequence != null) {
            this.currentInputSequence.selectElementByIdentifier(string);
        }
    }

    @Override
    public void selectListElement(LICityHistoryEntry lICityHistoryEntry, CommandList commandList, boolean bl) {
        this.logChannel.log(-2137614336, "[PoiSearchArea] PoiSearchAreaSequence#selectListElement( %1 )", (Object)lICityHistoryEntry);
        CommandList commandList2 = this.commandListFactory.createCommandList();
        commandList2.add(new GetLastCityHistoryEntryCommand(lICityHistoryEntry));
        commandList2.add(new PoiSearchAreaSequence$4(this));
        commandList2.add(new PoiSearchAreaSequence$5(this));
        commandList2.add(commandList);
        commandList2.execute("PoiSearchAreaSequence#selectListElement");
    }

    @Override
    public void undoCharacter() {
        if (this.currentInputSequence != null) {
            this.currentInputSequence.undoCharacter();
        }
    }

    @Override
    public void restore() {
        if (this.currentInputSequence != null) {
            boolean bl = this.currentInputSequence.hasActiveSubSequence();
            this.currentInputSequence.restore();
            if (!bl) {
                this.currentInputSequence = null;
            }
            return;
        }
        this.logChannel.log(-2137614336, "[PoiSearchArea] PoiSearchAreaSequence#restore()");
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LIRestoreStateCommand(this.initialSpellerState));
        commandList.execute("PoiSearchAreaSequence#restore()");
        this.cleanUp();
    }

    @Override
    public CommandList createRestoreCommandList() {
        return null;
    }

    @Override
    public boolean hasActiveSubSequence() {
        return this.currentInputSequence != null;
    }

    @Override
    public NavLocation getCountryLocation() {
        return this.tempSearchArea.getLocation();
    }

    private void clearTempSearchArea() {
        this.tempSearchArea.setLocation(null);
        this.tempSearchArea.setSearchContext(2);
    }

    private void cleanUp() {
        this.clearTempSearchArea();
        this.initialSpellerState = null;
        this.currentInputSequence = null;
    }

    @Override
    public void showCityInPreviewMap(LIValueListElement lIValueListElement) {
        this.logChannel.log(-2137614336, "PoiSearchAreaSequence#showCityInPreviewMap - LIValueListElement cityToDisplay=%1", (Object)lIValueListElement);
        CommandList commandList = this.commandListFactory.createCommandList(1);
        commandList.add(new SetCityAsLocationForPreviewMapCommand(this.previewMap, lIValueListElement));
        commandList.execute("PoiSearchAreaSequence#showCityInPreviewMap with LIValueListElement");
    }

    @Override
    public void showCityInPreviewMap(LICityHistoryEntry lICityHistoryEntry) {
        this.logChannel.log(-2137614336, "PoiSearchAreaSequence#showCityInPreviewMap - LICityHistoryEntry cityToDisplay", (Object)lICityHistoryEntry);
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new GetLastCityHistoryEntryCommand(lICityHistoryEntry));
        commandList.add(new PoiSearchAreaSequence$6(this));
        commandList.execute("PoiSearchAreaSequence#showCityInPreviewMap with LICityHistoryEntry");
    }

    @Override
    public void showLocationInPreviewMap(IPreviewMap iPreviewMap, LIValueListElement lIValueListElement) {
        this.logChannel.log(-2137614336, "PoiSearchAreaSequence#showLocationInPreviewMap - element=%1", (Object)lIValueListElement);
        CommandList commandList = this.commandListFactory.createCommandList(1);
        commandList.add(new CmdNaviPreviewMapNavLocationSet(lIValueListElement, iPreviewMap));
        commandList.execute("PoiSearchAreaSequence#showLocationInPreviewMap");
    }

    @Override
    public void showCCPInPreviewMap() {
        this.previewMap.setPreviewAreaAroundCCP(1);
    }

    @Override
    public void showRouteInPreviewMap() {
        this.previewMap.setPreviewRoute(true, 6, null, null);
    }

    @Override
    public void showDestinationAreaInPreviewMap(NavLocation navLocation) {
        this.previewMap.setPreviewDestination(navLocation, 1, null, null);
    }

    @Override
    public void hidePreviewMap() {
        this.logChannel.log(-2137614336, "PoiSearchAreaSequence#hidePreviewMap()");
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new HidePreviewMapCommand(this.previewMap));
        commandList.execute("PoiSearchAreaSequence#hidePreviewMap");
    }

    public void updateRgActive(boolean bl) {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(14808325, "PoiSearchAreaSequence#updateRgActive active=%1", bl);
        }
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new PoiSearchAreaSequence$7(this, "PoiSearchAreaSequence#updateRgActive", bl));
        commandList.execute("PoiSearchAreaSequence#updateRgActive");
    }

    @Override
    public void unrequestItems(int n, int n2) {
        this.currentInputSequence.unrequestItems(n, n2);
    }

    @Override
    public void addCharacter(String string, int n, boolean bl) {
    }
}

