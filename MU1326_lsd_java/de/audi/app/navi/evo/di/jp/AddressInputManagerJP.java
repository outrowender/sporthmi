/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.jp;

import de.audi.app.navi.evo.addressinput.AddressInputFormOnlineModelAccess;
import de.audi.app.navi.evo.di.AbstractAddressInputManagerEvo;
import de.audi.app.navi.evo.di.DIScreensEvo;
import de.audi.app.navi.evo.di.jp.AddressInputManagerJP$1;
import de.audi.app.navi.evo.di.jp.listeners.AddressInputChomeScreenListenerJP;
import de.audi.app.navi.evo.di.jp.listeners.AddressInputCityScreenListenerJP;
import de.audi.app.navi.evo.di.jp.listeners.AddressInputHouseNumberListenerJP;
import de.audi.app.navi.evo.di.jp.listeners.AddressInputMainScreenListenerJP;
import de.audi.app.navi.evo.di.jp.listeners.AddressInputPlacenameScreenListenerJP;
import de.audi.app.navi.evo.di.jp.listeners.AddressInputPrefectureScreenListenerJP;
import de.audi.app.navi.evo.di.jp.listeners.AddressInputRightDrawerListenerJP;
import de.audi.app.navi.evo.di.jp.listeners.AddressInputWardScreenListenerJP;
import de.audi.app.navi.evo.di.jp.models.AddressInputChomeInputModelAccessJP;
import de.audi.app.navi.evo.di.jp.models.AddressInputCityScreenModelAccessJP;
import de.audi.app.navi.evo.di.jp.models.AddressInputHouseNumberModelAccessJP;
import de.audi.app.navi.evo.di.jp.models.AddressInputMainScreenModelAccessJP;
import de.audi.app.navi.evo.di.jp.models.AddressInputPlacenameInputModelAccessJP;
import de.audi.app.navi.evo.di.jp.models.AddressInputPrefectureInputModelAccessJP;
import de.audi.app.navi.evo.di.jp.models.AddressInputWardInputModelAccessJP;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.command.Command;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.ADBInterAppService;
import de.audi.tghu.navi.app.CityHistory;
import de.audi.tghu.navi.app.HomeAddressHandler;
import de.audi.tghu.navi.app.LocationSerializer;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.adb.NaviADBHandler;
import de.audi.tghu.navi.app.addressinput.IAddressInputFormModelAccessHelper;
import de.audi.tghu.navi.app.addressinput.commands.UpdateAddressInputFormScreenModelsCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.LIRestoreStateCommand;
import de.audi.tghu.navi.app.di.IAddressInputMainScreenListener;
import de.audi.tghu.navi.app.di.IAddressInputManager;
import de.audi.tghu.navi.app.di.IAddressInputWorkFlowManager;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputChomeSequence;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputCitySequenceJP;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputHouseNumberSequenceAsia;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputPlacenameSequence;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputProvinceSequenceAsia;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputWardSequence;
import de.audi.tghu.navi.app.di.sequences.nospeller.AddressInputMainScreenSequence;
import de.audi.tghu.navi.app.favorite.INaviFavoriteHandler;
import de.audi.tghu.navi.app.guidance.IVehicle;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.li.SpellerStack$StackElement;
import de.audi.tghu.navi.app.map.MapInterface;
import de.audi.tghu.navi.app.navlocationextractor.AsyncNavLocationExtractor;
import de.audi.tghu.navi.app.routeguidance.IRouteManager;
import de.audi.tghu.navi.app.routeguidance.IStartGuidanceToDestinationSequence;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;

public class AddressInputManagerJP
extends AbstractAddressInputManagerEvo {
    private static final int DESTINATION_TYPE_FOR_CCP_LOCATION_STRIPPING;
    private AddressInputMainScreenListenerJP mainScreenListener;
    private AddressInputRightDrawerListenerJP rightDrawerListener;
    private AddressInputPrefectureScreenListenerJP prefectureScreenListener;
    private AddressInputCityScreenListenerJP cityScreenListener;
    private AddressInputWardScreenListenerJP wardScreenListener;
    private AddressInputPlacenameScreenListenerJP placeScreenListener;
    private AddressInputChomeScreenListenerJP chomeScreenListener;
    private AddressInputHouseNumberListenerJP houseNumberScreenListener;
    private final ChoiceModelApp prefectureNationwideSelectedChoice;

    public AddressInputManagerJP(NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory, IAddressInputWorkFlowManager iAddressInputWorkFlowManager, SpellerStack spellerStack, IPreviewMap iPreviewMap, IStartGuidanceToDestinationSequence iStartGuidanceToDestinationSequence, IVehicle iVehicle, LocationSerializer locationSerializer, IRouteManager iRouteManager, CityHistory cityHistory, NaviADBHandler naviADBHandler, INaviFavoriteHandler iNaviFavoriteHandler, AsyncNavLocationExtractor asyncNavLocationExtractor, ADBInterAppService aDBInterAppService, HomeAddressHandler homeAddressHandler, MapInterface mapInterface, AsyncNavLocationExtractor asyncNavLocationExtractor2, IAddressInputFormModelAccessHelper iAddressInputFormModelAccessHelper, HomeAddressHandler homeAddressHandler2) {
        super(navigationEnv, iCommandListFactory, iAddressInputWorkFlowManager, spellerStack, iPreviewMap, iStartGuidanceToDestinationSequence, iVehicle, locationSerializer, iRouteManager, cityHistory, naviADBHandler, iNaviFavoriteHandler, asyncNavLocationExtractor, aDBInterAppService, homeAddressHandler, mapInterface, asyncNavLocationExtractor2, iAddressInputFormModelAccessHelper, homeAddressHandler2);
        this.prefectureNationwideSelectedChoice = navigationEnv.getChoiceModel(DIScreensEvo.getDiJpPrefectureNationwideButtonSelectedChoiceModel());
    }

    @Override
    protected void initListeners() {
        this.mainScreenListener = this.initMainScreenListener();
        this.rightDrawerListener = this.initRightDrawerListener();
        this.prefectureScreenListener = this.initPrefectureScreenListener();
        this.cityScreenListener = this.initCityScreenListener();
        this.wardScreenListener = this.initWardScreenListener();
        this.placeScreenListener = this.initPlaceNameScreenListener();
        this.chomeScreenListener = this.initChomeScreenListener();
        this.houseNumberScreenListener = this.intiHouseNumberScreenListener();
    }

    @Override
    public void start(NavLocation navLocation) {
        if (!this.addressInputCommandListMonitor.isActive()) {
            this.logChannel.log(-2137614336, "%1#start with navLocation=%2", (Object)this.CLASS_NAME, (Object)LocationFormatter.formatLocationShort(navLocation));
            CommandList commandList = this.commandListFactory.createCommandList();
            commandList.addMonitor(this.addressInputCommandListMonitor);
            this.mainScreenListener.resetPreviousLocation();
            if (navLocation != null) {
                this.logChannel.log(-2137614336, "%1#start() with navLocation: %2", (Object)this.CLASS_NAME, (Object)LocationFormatter.formatLocationShort(navLocation));
                commandList.put("startMainScreenNavLocation", navLocation);
            } else {
                this.logChannel.log(-2137614336, "%1#start() with CCP", (Object)this.CLASS_NAME);
                this.addStripLocationForCcpCommands(commandList, 25);
            }
            this.enterSearchAreaFromPoiContext();
            this.executeAddressInputEvent(commandList, 20012);
        } else {
            this.logChannel.log(-2137614336, "%1#start - the command list to start address input is still running - ignoring further calls.", (Object)this.CLASS_NAME);
        }
    }

    @Override
    public void startWithoutStrip(NavLocation navLocation) {
        this.start(navLocation);
    }

    @Override
    public void startForOnline() {
        this.logChannel.log(-2137614336, "%1#startForOnline", (Object)this.CLASS_NAME);
        this.enterSearchAreaFromOnlinePoiContext();
        CommandList commandList = this.commandListFactory.createCommandList();
        this.addStripLocationForCcpCommands(commandList, 25);
        this.startForOnline(commandList);
    }

    @Override
    public void startForRemoteHMI() {
        this.logChannel.log(-2137614336, "%1#startForRemoteHMI", (Object)this.CLASS_NAME);
        this.enterSearchAreaFromRemoteHmi();
        CommandList commandList = this.commandListFactory.createCommandList();
        this.addStripLocationForCcpCommands(commandList, 25);
        super.startForRemoteHMI(commandList);
    }

    @Override
    public void addAddressToFavorites(NavLocation navLocation) {
        this.naviFavoriteHandler.addToFavorites(navLocation);
    }

    @Override
    public void destAddressInputHKReturn(int n, int n2, Command command, Command command2) {
        this.logChannel.log(-2137614336, "%1#destAddressInputHKReturn called with removeHandler=%2", (Object)this.CLASS_NAME, (long)n2);
        SpellerStack$StackElement spellerStack$StackElement = null;
        switch (n2) {
            default: 
        }
        spellerStack$StackElement = this.spellerStack.pop();
        if (spellerStack$StackElement != null) {
            this.logChannel.log(-2137614336, "%1#destAddressInputHKReturn element popped from speller stack=%2", (Object)this.CLASS_NAME, (Object)spellerStack$StackElement);
            CommandList commandList = this.commandListFactory.createCommandList();
            commandList.add(new LIRestoreStateCommand(spellerStack$StackElement));
            NavLocation navLocation = this.env.getContainer().getLiCurrentLD();
            String string = Util.getLocationAccessor(navLocation).getState();
            String string2 = Util.getLocationAccessor(navLocation).getTown();
            String string3 = Util.getLocationAccessor(navLocation).getPlaceName();
            this.logChannel.log(-2137614336, "%1#destAddressInputHKReturn with liCurrentLD = %2", (Object)this.CLASS_NAME, (Object)LocationFormatter.formatLocationShort(navLocation));
            commandList.add(new AddressInputManagerJP$1(this, new StringBuffer().append(this.CLASS_NAME).append("#destAddressInputHKReturn - Show or Hide Preview Map").toString(), string, string2, string3));
            if (this.env.getInputModeManager().isSdsActive()) {
                commandList.add(new UpdateAddressInputFormScreenModelsCommand(this.modelAccessHelper));
            }
            if (command != null) {
                commandList.add(command);
            }
            if (command != null) {
                commandList.setErrorCommand(command2);
            }
            commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#destAddressInputHKReturn").toString());
        } else {
            this.logChannel.log(-1601830656, "%1#destAddressInputHKReturn - popped element from SpellerStack but element is null!", (Object)this.CLASS_NAME);
        }
    }

    private AddressInputMainScreenListenerJP initMainScreenListener() {
        AddressInputMainScreenModelAccessJP addressInputMainScreenModelAccessJP = new AddressInputMainScreenModelAccessJP(this.env, this.modelAccessHelper);
        AddressInputFormOnlineModelAccess addressInputFormOnlineModelAccess = new AddressInputFormOnlineModelAccess(this.env, this.cityHistory, DIScreensEvo.getDiJpOnlineSearchAreaBaseListModel(), this.modelAccessHelper);
        AddressInputMainScreenSequence addressInputMainScreenSequence = new AddressInputMainScreenSequence(this.commandListFactory, this.env, this.startRouteGuidanceSequence, addressInputMainScreenModelAccessJP, this.previewMap, this.spellerStack, this, addressInputFormOnlineModelAccess);
        AddressInputMainScreenListenerJP addressInputMainScreenListenerJP = new AddressInputMainScreenListenerJP(this.env, this.previewMap, this.commandListFactory, this, addressInputMainScreenSequence, this.adbInterAppService, this.homeAddressHandler);
        return addressInputMainScreenListenerJP;
    }

    private AddressInputRightDrawerListenerJP initRightDrawerListener() {
        AddressInputRightDrawerListenerJP addressInputRightDrawerListenerJP = new AddressInputRightDrawerListenerJP(this.env, this.previewMap, this.commandListFactory, this, this.mapInterface, this.asyncLiValueListNavLocationExctractor, this.asyncLiCityStateStreetHistoryListNavLocationExtractor, this.mainScreenListener);
        return addressInputRightDrawerListenerJP;
    }

    private AddressInputPrefectureScreenListenerJP initPrefectureScreenListener() {
        int n = DIScreensEvo.getDiJpPrefectureScreenMenuModel();
        int n2 = DIScreensEvo.getDiJpPrefectureScreenMatchSpellerModel();
        int n3 = DIScreensEvo.getDiJpPrefectureScreenTiledListModel();
        AddressInputPrefectureInputModelAccessJP addressInputPrefectureInputModelAccessJP = new AddressInputPrefectureInputModelAccessJP(this.env, n2, n3, this.cityHistory, this.modelAccessHelper);
        AddressInputProvinceSequenceAsia addressInputProvinceSequenceAsia = new AddressInputProvinceSequenceAsia(this.commandListFactory, this.env, addressInputPrefectureInputModelAccessJP, this.previewMap, this.spellerStack, this, this.cityHistory);
        AddressInputPrefectureScreenListenerJP addressInputPrefectureScreenListenerJP = new AddressInputPrefectureScreenListenerJP(this.env, this.previewMap, this.commandListFactory, (IAddressInputManager)this, addressInputProvinceSequenceAsia, n, n2, n3);
        return addressInputPrefectureScreenListenerJP;
    }

    private AddressInputCityScreenListenerJP initCityScreenListener() {
        int n = DIScreensEvo.getDiJpCityScreenMenuModel();
        int n2 = DIScreensEvo.getDiJpCityScreenMatchSpellerModel();
        int n3 = DIScreensEvo.getDiJpCityScreenTiledListModel();
        AddressInputCityScreenModelAccessJP addressInputCityScreenModelAccessJP = new AddressInputCityScreenModelAccessJP(this.env, n2, n3, this.cityHistory, this.modelAccessHelper);
        AddressInputCitySequenceJP addressInputCitySequenceJP = new AddressInputCitySequenceJP(this.commandListFactory, this.env, addressInputCityScreenModelAccessJP, this.previewMap, this.spellerStack, this, this.cityHistory);
        AddressInputCityScreenListenerJP addressInputCityScreenListenerJP = new AddressInputCityScreenListenerJP(this.env, this.previewMap, this.commandListFactory, (IAddressInputManager)this, addressInputCitySequenceJP, n, n2, n3);
        return addressInputCityScreenListenerJP;
    }

    private AddressInputWardScreenListenerJP initWardScreenListener() {
        int n = DIScreensEvo.getDiJpWardScreenMenuModel();
        int n2 = DIScreensEvo.getDiJpWardScreenMatchSpellerModel();
        int n3 = DIScreensEvo.getDiJpWardScreenTiledListModel();
        AddressInputWardInputModelAccessJP addressInputWardInputModelAccessJP = new AddressInputWardInputModelAccessJP(this.env, n2, n3, this.modelAccessHelper);
        AddressInputWardSequence addressInputWardSequence = new AddressInputWardSequence(this.commandListFactory, this.env, addressInputWardInputModelAccessJP, this.previewMap, this.spellerStack, this);
        AddressInputWardScreenListenerJP addressInputWardScreenListenerJP = new AddressInputWardScreenListenerJP(this.env, this.previewMap, this.commandListFactory, this, addressInputWardSequence, n, n2, n3);
        return addressInputWardScreenListenerJP;
    }

    private AddressInputPlacenameScreenListenerJP initPlaceNameScreenListener() {
        int n = DIScreensEvo.getDiJpPlacenameScreenMenuModel();
        int n2 = DIScreensEvo.getDiJpPlacenameScreenMatchSpellerModel();
        int n3 = DIScreensEvo.getDiJpPlacenameScreenTiledListModel();
        AddressInputPlacenameInputModelAccessJP addressInputPlacenameInputModelAccessJP = new AddressInputPlacenameInputModelAccessJP(this.env, n2, n3, this.modelAccessHelper);
        AddressInputPlacenameSequence addressInputPlacenameSequence = new AddressInputPlacenameSequence(this.commandListFactory, this.env, addressInputPlacenameInputModelAccessJP, this.previewMap, this.spellerStack, this);
        AddressInputPlacenameScreenListenerJP addressInputPlacenameScreenListenerJP = new AddressInputPlacenameScreenListenerJP(this.env, this.previewMap, this.commandListFactory, (IAddressInputManager)this, addressInputPlacenameSequence, n, n2, n3);
        return addressInputPlacenameScreenListenerJP;
    }

    private AddressInputChomeScreenListenerJP initChomeScreenListener() {
        int n = DIScreensEvo.getDiJpChomeScreenMenuModel();
        int n2 = DIScreensEvo.getDiJpChomeScreenMatchSpellerModel();
        int n3 = DIScreensEvo.getDiJpChomeScreenTiledListModel();
        AddressInputChomeInputModelAccessJP addressInputChomeInputModelAccessJP = new AddressInputChomeInputModelAccessJP(this.env, n2, n3, this.modelAccessHelper);
        AddressInputChomeSequence addressInputChomeSequence = new AddressInputChomeSequence(this.commandListFactory, this.env, addressInputChomeInputModelAccessJP, this.previewMap, this.spellerStack, this);
        AddressInputChomeScreenListenerJP addressInputChomeScreenListenerJP = new AddressInputChomeScreenListenerJP(this.env, this.previewMap, this.commandListFactory, (IAddressInputManager)this, addressInputChomeSequence, n, n2, n3);
        return addressInputChomeScreenListenerJP;
    }

    private AddressInputHouseNumberListenerJP intiHouseNumberScreenListener() {
        int n = DIScreensEvo.getDiJpHouseNumberScreenMenuModel();
        int n2 = DIScreensEvo.getDiJpHouseNumberScreenMatchSpellerModel();
        int n3 = DIScreensEvo.getDiJpHouseNumberScreenTiledListModel();
        AddressInputHouseNumberModelAccessJP addressInputHouseNumberModelAccessJP = new AddressInputHouseNumberModelAccessJP(this.env, n2, n3, this.modelAccessHelper);
        AddressInputHouseNumberSequenceAsia addressInputHouseNumberSequenceAsia = new AddressInputHouseNumberSequenceAsia(this.commandListFactory, this.env, addressInputHouseNumberModelAccessJP, this.previewMap, this.spellerStack, this);
        AddressInputHouseNumberListenerJP addressInputHouseNumberListenerJP = new AddressInputHouseNumberListenerJP(this.env, this.previewMap, this.commandListFactory, (IAddressInputManager)this, addressInputHouseNumberSequenceAsia, n, n2, n3);
        return addressInputHouseNumberListenerJP;
    }

    @Override
    public IAddressInputMainScreenListener getMainScreenListener() {
        return this.mainScreenListener;
    }

    public AddressInputRightDrawerListenerJP getRightDrawerListener() {
        return this.rightDrawerListener;
    }

    public AddressInputPrefectureScreenListenerJP getPrefectureScreenListener() {
        return this.prefectureScreenListener;
    }

    public AddressInputCityScreenListenerJP getCityScreenListener() {
        return this.cityScreenListener;
    }

    public AddressInputWardScreenListenerJP getWardScreenListener() {
        return this.wardScreenListener;
    }

    public AddressInputPlacenameScreenListenerJP getPlaceNameScreenListener() {
        return this.placeScreenListener;
    }

    public AddressInputChomeScreenListenerJP getChomeScreenListener() {
        return this.chomeScreenListener;
    }

    public AddressInputHouseNumberListenerJP gethouseNumberScreenListenerJP() {
        return this.houseNumberScreenListener;
    }

    @Override
    public int getAutoSelectLeftElementEventId() {
        return 20204;
    }

    @Override
    public int getStreetScreenAmbiguousListElementSelecteEventId() {
        return 20504;
    }

    @Override
    public int getStreetScreenNonAmbiguousListElementSelectedEventId() {
        return 20503;
    }

    @Override
    public int getStartForOnlineEventId() {
        return 20013;
    }

    @Override
    public int getStartForRemoteHMIEventId() {
        return 20014;
    }

    @Override
    public int getStartCityInputFromMainScreenEventId() {
        return 20003;
    }

    static /* synthetic */ IPreviewMap access$000(AddressInputManagerJP addressInputManagerJP) {
        return addressInputManagerJP.previewMap;
    }

    static /* synthetic */ ChoiceModelApp access$100(AddressInputManagerJP addressInputManagerJP) {
        return addressInputManagerJP.prefectureNationwideSelectedChoice;
    }

    static /* synthetic */ IPreviewMap access$200(AddressInputManagerJP addressInputManagerJP) {
        return addressInputManagerJP.previewMap;
    }

    static /* synthetic */ IPreviewMap access$300(AddressInputManagerJP addressInputManagerJP) {
        return addressInputManagerJP.previewMap;
    }
}

