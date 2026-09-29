/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di;

import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Command;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.ADBInterAppService;
import de.audi.tghu.navi.app.CityHistory;
import de.audi.tghu.navi.app.HomeAddressHandler;
import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.LocationSerializer;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.adb.NaviADBHandler;
import de.audi.tghu.navi.app.addressinput.IAddressInputFormModelAccessHelper;
import de.audi.tghu.navi.app.addressinput.poi.IPoiService;
import de.audi.tghu.navi.app.addressinput.sds.IAddressInputSDSForm;
import de.audi.tghu.navi.app.details.IDetailsHMIListener;
import de.audi.tghu.navi.app.di.IAddressInputManager;
import de.audi.tghu.navi.app.di.IAddressInputService;
import de.audi.tghu.navi.app.di.IAddressInputWorkFlowManager;
import de.audi.tghu.navi.app.di.sequences.disambiguation.ILocationDisambiguatorPopupHandler;
import de.audi.tghu.navi.app.di.sequences.disambiguation.ILocationDisambiguatorSequence;
import de.audi.tghu.navi.app.favorite.INaviFavoriteHandler;
import de.audi.tghu.navi.app.guidance.IVehicle;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.li.aih.AddressInputHandler;
import de.audi.tghu.navi.app.map.MapInterface;
import de.audi.tghu.navi.app.navlocationextractor.AsyncNavLocationExtractor;
import de.audi.tghu.navi.app.navobserver.INavObserverRegistry;
import de.audi.tghu.navi.app.routeguidance.IRouteManager;
import de.audi.tghu.navi.app.routeguidance.IStartGuidanceToDestinationSequence;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;

public abstract class AbstractAddressInputService
implements IAddressInputService {
    protected final NavigationEnv env;
    protected final ICommandListFactory commandListFactory;
    protected IAddressInputManager inputManager = null;
    protected IAddressInputWorkFlowManager workFlowManager = null;
    protected final SpellerStack spellerStack;
    protected final IPreviewMap previewMap;
    protected final IStartGuidanceToDestinationSequence startRouteGuidanceSequence;
    protected final IVehicle vehicle;
    protected final LocationSerializer locationSerializer;
    protected final IRouteManager routeManager;
    protected final LogChannel logChannel;
    protected final CityHistory cityHistory;
    protected final String CLASS_NAME = Util.getClassNameFromPackageName(super.getClass());
    protected final NaviADBHandler adbHandler;
    protected final INaviFavoriteHandler naviFavoriteHandler;
    protected final AsyncNavLocationExtractor asyncLiValueListNavLocationExctractor;
    protected final AsyncNavLocationExtractor asyncLiCityHistoryListNavLocationExtractor;
    protected final ADBInterAppService adbInterAppService;
    protected final HomeAddressHandler homeAddressHandler;
    protected final MapInterface mapInterface;
    protected IAddressInputFormModelAccessHelper modelAccessHelper;
    protected int startAddressInputWFMId;
    protected IAddressInputSDSForm addressInputSDSForm;
    protected final IconHandler iconHandler;
    protected final IDetailsHMIListener detailsHMIListener;
    protected final HomeAddressHandler officeAddressHandler;
    protected final ILocationDisambiguatorSequence disambiguationSequence;
    protected final ILocationDisambiguatorPopupHandler popupHandler;
    protected final INavObserverRegistry navObserverRegistry;

    public AbstractAddressInputService(NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory, SpellerStack spellerStack, IPreviewMap iPreviewMap, IStartGuidanceToDestinationSequence iStartGuidanceToDestinationSequence, IVehicle iVehicle, LocationSerializer locationSerializer, IRouteManager iRouteManager, CityHistory cityHistory, NaviADBHandler naviADBHandler, INaviFavoriteHandler iNaviFavoriteHandler, AsyncNavLocationExtractor asyncNavLocationExtractor, ADBInterAppService aDBInterAppService, HomeAddressHandler homeAddressHandler, MapInterface mapInterface, AsyncNavLocationExtractor asyncNavLocationExtractor2, IconHandler iconHandler, IDetailsHMIListener iDetailsHMIListener, HomeAddressHandler homeAddressHandler2, ILocationDisambiguatorSequence iLocationDisambiguatorSequence, ILocationDisambiguatorPopupHandler iLocationDisambiguatorPopupHandler, INavObserverRegistry iNavObserverRegistry) {
        this.env = navigationEnv;
        this.commandListFactory = iCommandListFactory;
        this.spellerStack = spellerStack;
        this.previewMap = iPreviewMap;
        this.startRouteGuidanceSequence = iStartGuidanceToDestinationSequence;
        this.vehicle = iVehicle;
        this.locationSerializer = locationSerializer;
        this.routeManager = iRouteManager;
        this.cityHistory = cityHistory;
        this.adbHandler = naviADBHandler;
        this.naviFavoriteHandler = iNaviFavoriteHandler;
        this.asyncLiValueListNavLocationExctractor = asyncNavLocationExtractor;
        this.asyncLiCityHistoryListNavLocationExtractor = asyncNavLocationExtractor2;
        this.adbInterAppService = aDBInterAppService;
        this.homeAddressHandler = homeAddressHandler;
        this.mapInterface = mapInterface;
        this.iconHandler = iconHandler;
        this.detailsHMIListener = iDetailsHMIListener;
        this.officeAddressHandler = homeAddressHandler2;
        this.disambiguationSequence = iLocationDisambiguatorSequence;
        this.popupHandler = iLocationDisambiguatorPopupHandler;
        this.logChannel = navigationEnv.getAddressInputLogChannel();
        this.navObserverRegistry = iNavObserverRegistry;
        this.initAddressInput();
        if (!this.isInputManagerReady()) {
            this.logChannel.log(10000, "**************************************************************************************************************");
            this.logChannel.log(10000, "***** %1 WASN'T ABLE TO CREATE THE INPUT MANAGER. DESTINATION INPUT WILL NOT BE WORKING *****", (Object)this.CLASS_NAME);
            this.logChannel.log(10000, "**************************************************************************************************************");
        } else if (!this.isWorkFlowManagerReady()) {
            this.logChannel.log(10000, "******************************************************************************************************************");
            this.logChannel.log(10000, "***** %1 WASN'T ABLE TO CREATE THE WORK FLOW MANAGER. DESTINATION INPUT WILL NOT BE WORKING *****", (Object)this.CLASS_NAME);
            this.logChannel.log(10000, "******************************************************************************************************************");
        }
    }

    protected abstract void initAddressInput() {
    }

    @Override
    public void start() {
        this.inputManager.start();
    }

    @Override
    public void start(NavLocation navLocation) {
        this.inputManager.start(navLocation);
    }

    @Override
    public void startWithoutStrip(NavLocation navLocation) {
        this.inputManager.startWithoutStrip(navLocation);
    }

    @Override
    public void startForOnline() {
        this.inputManager.startForOnline();
    }

    @Override
    public void startForRemoteHMI() {
        this.inputManager.startForRemoteHMI();
    }

    private boolean isWorkFlowManagerReady() {
        return this.workFlowManager != null;
    }

    private boolean isInputManagerReady() {
        return this.inputManager != null;
    }

    @Override
    public NavLocation getBackupLocation() {
        return this.inputManager.getBackupLocation();
    }

    @Override
    public void setBackupLocation(NavLocation navLocation) {
        this.inputManager.setBackupLocation(navLocation);
    }

    @Override
    public void invalidateBackupLocation() {
        this.inputManager.invalidateBackupLocation();
    }

    @Override
    public NavLocation getInitialLocation() {
        return this.inputManager.getInitialLocation();
    }

    @Override
    public CommandList acceptGivenInput(AddressInputHandler addressInputHandler, NavLocation navLocation) {
        return this.inputManager.acceptGivenInput(addressInputHandler, navLocation);
    }

    @Override
    public void persistBackupLocation(NavLocation navLocation) {
        this.inputManager.persistBackupLocation(navLocation);
    }

    @Override
    public void onNewNaviServiceListener() {
        this.inputManager.onNewNaviServiceListener();
    }

    @Override
    public void setPoiService(IPoiService iPoiService) {
        this.inputManager.setPoiService(iPoiService);
    }

    @Override
    public void resetMemorySettings() {
        this.inputManager.resetMemorySettings();
    }

    @Override
    public NavLocation getPersistedBackupLocation() {
        return this.inputManager.getPersistedBackupLocation();
    }

    @Override
    public CommandList getStartAddressInputCommandList(NavLocation navLocation) {
        return this.getStartAddressInputCommandList(navLocation, this.startAddressInputWFMId);
    }

    @Override
    public CommandList getStartAddressInputCommandList(NavLocation navLocation, int n) {
        CommandList commandList = this.commandListFactory.createCommandList();
        if (navLocation != null) {
            commandList.put("startMainScreenNavLocation", navLocation);
        }
        return this.inputManager.handleAddressInputEvent(commandList, n);
    }

    @Override
    public IAddressInputFormModelAccessHelper getModelAccessHelper() {
        return this.modelAccessHelper;
    }

    @Override
    public void startCityZipInputSequence() {
        this.inputManager.executeAddressInputEvent(this.commandListFactory.createCommandList(), this.inputManager.getStartCityInputFromMainScreenEventId());
    }

    @Override
    public void destAddressInputHKReturn(int n, int n2, Command command, Command command2) {
        this.inputManager.destAddressInputHKReturn(n, n2, command, command2);
    }

    @Override
    public IAddressInputSDSForm getSDSAddressInputForm() {
        return this.addressInputSDSForm;
    }
}

