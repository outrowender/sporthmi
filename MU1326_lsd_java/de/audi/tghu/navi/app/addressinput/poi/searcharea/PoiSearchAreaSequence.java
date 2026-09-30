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
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.guidance.IVehicle;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.routeguidance.IRouteManager;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.RouteUtil;
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

    public void start(boolean bl) {
    }

    public void start(boolean bl, int n) {
        this.logChannel.log(10000000, "[PoiSearchArea] PoiSearchAreaSequence#start() - isRgActive=%1, numberOfDestinations=%2", bl, (long)n);
        this.modelAccess.onUpdateSearchArea(this.poiSearchArea, bl, n);
    }

    public void startCountryCity(boolean bl) {
        this.logChannel.log(10000000, "[PoiSearchArea] PoiSearchAreaSequence#startCountryCity()");
        this.cleanUp();
        CommandList commandList = this.commandListFactory.createCommandList();
        if (bl) {
            commandList.add(new LiGetStateCommand());
            commandList.add(new NavCommand("PoiSearchAreaSequence#startCountryCity - save tempSpellerState"){

                public void execute() {
                    PoiSearchAreaSequence.this.initialSpellerState = this.dsiResponseContainer.getSpellerState();
                    PoiSearchAreaSequence.this.spellerStack.reset();
                    this.getCommandList().commandFinished();
                }
            });
        }
        commandList.add(new LISetCurrentLDCommand(this.getInitialCountryLocation()));
        commandList.add(new NavCommand("PoiSearchAreaSequence#startCountryCity - set SearchContext for tempSearchArea"){

            public void execute() {
                PoiSearchAreaSequence.this.tempSearchArea.setLocation(this.dsiResponseContainer.getLiCurrentLD());
                this.getCommandList().commandFinished();
            }
        });
        commandList.add(new SetHistoryContextWithCurrentLDCommand());
        commandList.add(new NavCommand("PoiSearchAreaSequence#startCountryCity - ModelAccess#OnStart"){

            public void execute() {
                PoiSearchAreaSequence.this.modelAccess.onStart(this.dsiResponseContainer.getLiCurrentLD());
                this.getCommandList().commandFinished();
            }
        });
        commandList.execute("PoiSearchAreaSequence#startCountryCity");
    }

    private NavLocation getInitialCountryLocation() {
        this.logChannel.log(10000000, "PoiSearchAreaSequence#getInitialCountryLocation");
        if (this.poiSearchArea.getLocation() != null) {
            this.logChannel.log(10000000, "PoiSearchAreaSequence#getInitialCountryLocation - POISearchArea country: %1", (Object)this.poiSearchArea.getLocation().getCountry());
            return this.poiSearchArea.getLocation();
        }
        this.logChannel.log(10000000, "PoiSearchAreaSequence#getInitialCountryLocation. vehicle possition: %1", (Object)this.vehicle.getVehicleCountryLocation().getCountry());
        return this.vehicle.getVehicleCountryLocation();
    }

    public void updateSearchArea(int n, NavLocation navLocation) {
        this.logChannel.log(10000000, "PoiSearchAreaSequence#updateSearchArea. searchContextId: %2 , location: %1", (Object)LocationFormatter.formatLocationShort(navLocation), (long)n);
        this.poiSearchArea.setLocation(navLocation);
        this.poiSearchArea.setSearchContext(n);
        this.modelAccess.onUpdateSearchArea(this.poiSearchArea);
    }

    public void startCountryInputSequence(IMatchspellerModelAccess iMatchspellerModelAccess, boolean bl) {
        this.logChannel.log(10000000, "PoiSearchAreaSequence#startCountryInputSequence()");
        this.currentInputSequence = new PoiCountryInputSequence(iMatchspellerModelAccess, this.modelAccess, this.spellerStack, this.commandListFactory, this.tempSearchArea, this.addressInputForm, this.previewMap, this.env);
        this.currentInputSequence.start(bl);
    }

    public void startCountryInputSequence(char c2, IMatchspellerModelAccess iMatchspellerModelAccess, boolean bl) {
        this.logChannel.log(10000000, "[PoiSearchArea] PoiSearchAreaSequence#startCountryInputSequence(latestChar=%1)", c2);
        PoiCountryInputSequence poiCountryInputSequence = new PoiCountryInputSequence(iMatchspellerModelAccess, this.modelAccess, this.spellerStack, this.commandListFactory, this.tempSearchArea, this.addressInputForm, this.previewMap, this.env);
        this.currentInputSequence = poiCountryInputSequence;
        poiCountryInputSequence.start(c2, bl);
    }

    public void startPoiAreaCityZipInputSequence(IMatchspellerModelAccess iMatchspellerModelAccess, boolean bl) {
        this.logChannel.log(10000000, "[PoiSearchArea] PoiSearchAreaSequence#startPoiAreaCityZipInputSequence( no cl )");
        this.startPoiAreaCityZipInputSequence(iMatchspellerModelAccess, null, bl);
    }

    public void startPoiAreaCityZipInputSequence(IMatchspellerModelAccess iMatchspellerModelAccess, CommandList commandList, boolean bl) {
        this.logChannel.log(10000000, "[PoiSearchArea] PoiSearchAreaSequence#startPoiAreaCityZipInputSequence( )");
        this.currentInputSequence = new PoiCityZipInputSequence(iMatchspellerModelAccess, this.modelAccess, this.spellerStack, this.commandListFactory, this.poiSearchArea, this.cityHistory, commandList, this.previewMap, this.addressInputForm);
        this.currentInputSequence.start(bl);
    }

    public void addCharacter(String string) {
        if (this.currentInputSequence != null) {
            this.currentInputSequence.addCharacter(string);
        }
    }

    public void deleteAllCharacters() {
        if (this.currentInputSequence != null) {
            this.currentInputSequence.deleteAllCharacters();
        }
    }

    public void requestNextResultListWindow(int n, int n2) {
        if (this.currentInputSequence != null) {
            this.currentInputSequence.requestNextResultListWindow(n, n2);
        }
    }

    public void requestPreviousResultListWindow(int n) {
        if (this.currentInputSequence != null) {
            this.currentInputSequence.requestPreviousResultListWindow(n);
        }
    }

    public void selectListElement(LIValueListElement lIValueListElement, boolean bl) {
        if (this.currentInputSequence != null) {
            this.currentInputSequence.selectListElement(lIValueListElement, bl);
        }
    }

    public CommandList getSelectListElementCommandList(LIValueListElement lIValueListElement, boolean bl) {
        if (this.currentInputSequence != null) {
            return this.currentInputSequence.getSelectListElementCommandList(lIValueListElement, bl);
        }
        return null;
    }

    public void selectElementByIdentifier(String string) {
        if (this.currentInputSequence != null) {
            this.currentInputSequence.selectElementByIdentifier(string);
        }
    }

    public void selectListElement(LICityHistoryEntry lICityHistoryEntry, CommandList commandList, boolean bl) {
        this.logChannel.log(10000000, "[PoiSearchArea] PoiSearchAreaSequence#selectListElement( %1 )", (Object)lICityHistoryEntry);
        CommandList commandList2 = this.commandListFactory.createCommandList();
        commandList2.add(new GetLastCityHistoryEntryCommand(lICityHistoryEntry));
        commandList2.add(new NavCommand(){

            public void execute() {
                Object object = this.getCommandList().get("NavLocation from History");
                if (object instanceof NavLocation) {
                    this.getCommandList().commandFinishedWithPostCommand(new LISetCurrentLDCommand((NavLocation)object));
                } else {
                    this.getCommandList().commandAborted("unexpected Object");
                }
            }
        });
        commandList2.add(new NavCommand(){

            public void execute() {
                PoiSearchAreaSequence.this.modelAccess.onElementSelected(this.dsiResponseContainer.getLiCurrentLD());
                PoiSearchAreaSequence.this.updateSearchArea(4, this.dsiResponseContainer.getLiCurrentLD());
                this.getCommandList().commandFinished();
            }
        });
        commandList2.add(commandList);
        commandList2.execute("PoiSearchAreaSequence#selectListElement");
    }

    public void undoCharacter() {
        if (this.currentInputSequence != null) {
            this.currentInputSequence.undoCharacter();
        }
    }

    public void restore() {
        if (this.currentInputSequence != null) {
            boolean bl = this.currentInputSequence.hasActiveSubSequence();
            this.currentInputSequence.restore();
            if (!bl) {
                this.currentInputSequence = null;
            }
            return;
        }
        this.logChannel.log(10000000, "[PoiSearchArea] PoiSearchAreaSequence#restore()");
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LIRestoreStateCommand(this.initialSpellerState));
        commandList.execute("PoiSearchAreaSequence#restore()");
        this.cleanUp();
    }

    public CommandList createRestoreCommandList() {
        return null;
    }

    public boolean hasActiveSubSequence() {
        return this.currentInputSequence != null;
    }

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

    public void showCityInPreviewMap(LIValueListElement lIValueListElement) {
        this.logChannel.log(10000000, "PoiSearchAreaSequence#showCityInPreviewMap - LIValueListElement cityToDisplay=%1", (Object)lIValueListElement);
        CommandList commandList = this.commandListFactory.createCommandList(1);
        commandList.add(new SetCityAsLocationForPreviewMapCommand(this.previewMap, lIValueListElement));
        commandList.execute("PoiSearchAreaSequence#showCityInPreviewMap with LIValueListElement");
    }

    public void showCityInPreviewMap(LICityHistoryEntry lICityHistoryEntry) {
        this.logChannel.log(10000000, "PoiSearchAreaSequence#showCityInPreviewMap - LICityHistoryEntry cityToDisplay", (Object)lICityHistoryEntry);
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new GetLastCityHistoryEntryCommand(lICityHistoryEntry));
        commandList.add(new NavCommand(){

            public void execute() {
                Object object = this.getCommandList().get("NavLocation from History");
                if (object != null && object instanceof NavLocation) {
                    NavLocation navLocation = (NavLocation)object;
                    PoiSearchAreaSequence.this.previewMap.setPreviewLocationCity(navLocation, 1, null, null);
                }
                this.getCommandList().commandFinished();
            }
        });
        commandList.execute("PoiSearchAreaSequence#showCityInPreviewMap with LICityHistoryEntry");
    }

    public void showLocationInPreviewMap(IPreviewMap iPreviewMap, LIValueListElement lIValueListElement) {
        this.logChannel.log(10000000, "PoiSearchAreaSequence#showLocationInPreviewMap - element=%1", (Object)lIValueListElement);
        CommandList commandList = this.commandListFactory.createCommandList(1);
        commandList.add(new CmdNaviPreviewMapNavLocationSet(lIValueListElement, iPreviewMap));
        commandList.execute("PoiSearchAreaSequence#showLocationInPreviewMap");
    }

    public void showCCPInPreviewMap() {
        this.previewMap.setPreviewAreaAroundCCP(1);
    }

    public void showRouteInPreviewMap() {
        this.previewMap.setPreviewRoute(true, 6, null, null);
    }

    public void showDestinationAreaInPreviewMap(NavLocation navLocation) {
        this.previewMap.setPreviewDestination(navLocation, 1, null, null);
    }

    public void hidePreviewMap() {
        this.logChannel.log(10000000, "PoiSearchAreaSequence#hidePreviewMap()");
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new HidePreviewMapCommand(this.previewMap));
        commandList.execute("PoiSearchAreaSequence#hidePreviewMap");
    }

    public void updateRgActive(final boolean bl) {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(100000000, "PoiSearchAreaSequence#updateRgActive active=%1", bl);
        }
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new NavCommand("PoiSearchAreaSequence#updateRgActive"){

            public void execute() {
                if (!(bl || PoiSearchAreaSequence.this.poiSearchArea.getSearchContext() != 1 && PoiSearchAreaSequence.this.poiSearchArea.getSearchContext() != 2 && PoiSearchAreaSequence.this.poiSearchArea.getSearchContext() != 3)) {
                    PoiSearchAreaSequence.this.updateSearchArea(0, null);
                }
                PoiSearchAreaSequence.this.modelAccess.onUpdateSearchArea(PoiSearchAreaSequence.this.poiSearchArea, bl, RouteUtil.getNumberOfDestinations(PoiSearchAreaSequence.this.routeManager.getRoute(), 1));
                this.getCommandList().commandFinished();
            }
        });
        commandList.execute("PoiSearchAreaSequence#updateRgActive");
    }

    public void unrequestItems(int n, int n2) {
        this.currentInputSequence.unrequestItems(n, n2);
    }

    public void addCharacter(String string, int n, boolean bl) {
    }
}

