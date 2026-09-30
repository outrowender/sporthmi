/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.kr;

import de.audi.app.navi.evo.addressinput.AddressInputFormOnlineModelAccess;
import de.audi.app.navi.evo.addressinput.housenumber.HousenumberMatchspellerInputModelAccess;
import de.audi.app.navi.evo.di.AbstractAddressInputManagerEvo;
import de.audi.app.navi.evo.di.DIScreensEvo;
import de.audi.app.navi.evo.di.kr.listener.AddressInputCityScreenListenerKR;
import de.audi.app.navi.evo.di.kr.listener.AddressInputMainScreenListenerKR;
import de.audi.app.navi.evo.di.kr.listener.AddressInputNumberScreenListenerKR;
import de.audi.app.navi.evo.di.kr.listener.AddressInputProvinceScreenListenerKR;
import de.audi.app.navi.evo.di.kr.listener.AddressInputRightDrawerListenerKR;
import de.audi.app.navi.evo.di.kr.listener.AddressInputTownStreetScreenListenerKR;
import de.audi.app.navi.evo.di.kr.listener.AddressInputVillageStreetListenerKR;
import de.audi.app.navi.evo.di.kr.listener.AddressInputWardScreenListenerKR;
import de.audi.app.navi.evo.di.kr.models.AddressInputCityScreenModelAccessKR;
import de.audi.app.navi.evo.di.kr.models.AddressInputMainScreenModelAccessKR;
import de.audi.app.navi.evo.di.kr.models.AddressInputProvinceModelAccessKR;
import de.audi.app.navi.evo.di.kr.models.AddressInputTownStreetModelAccessKR;
import de.audi.app.navi.evo.di.kr.models.AddressInputVillageStreetModelAccessKR;
import de.audi.app.navi.evo.di.kr.models.AddressInputWardModelAccessKR;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.interapp.locationaccessor.IMyLocationAccessor;
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
import de.audi.tghu.navi.app.addressinput.CmdNaviPreviewMapUpdate;
import de.audi.tghu.navi.app.addressinput.IAddressInputFormModelAccessHelper;
import de.audi.tghu.navi.app.addressinput.commands.UpdateAddressInputFormScreenModelsCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.LIRestoreStateCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.IAddressInputMainScreenListener;
import de.audi.tghu.navi.app.di.IAddressInputManager;
import de.audi.tghu.navi.app.di.IAddressInputWorkFlowManager;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputCitySequenceKR;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputHouseNumberSequenceAsia;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputProvinceSequenceAsia;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputTownStreetSequence;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputVillageStreetSequence;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputWardSequence;
import de.audi.tghu.navi.app.di.sequences.nospeller.AddressInputMainScreenSequence;
import de.audi.tghu.navi.app.favorite.INaviFavoriteHandler;
import de.audi.tghu.navi.app.guidance.IVehicle;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.map.MapInterface;
import de.audi.tghu.navi.app.navlocationextractor.AsyncNavLocationExtractor;
import de.audi.tghu.navi.app.routeguidance.IRouteManager;
import de.audi.tghu.navi.app.routeguidance.IStartGuidanceToDestinationSequence;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;

public class AddressInputManagerKR
extends AbstractAddressInputManagerEvo {
    private static final int DESTINATION_TYPE_FOR_CCP_LOCATION_STRIPPING = 23;
    private AddressInputMainScreenListenerKR mainScreenListener;
    private AddressInputRightDrawerListenerKR rightDrawerListener;
    private AddressInputProvinceScreenListenerKR provinceScreenListener;
    private AddressInputCityScreenListenerKR cityScreenListener;
    private AddressInputWardScreenListenerKR wardScreenListener;
    private AddressInputTownStreetScreenListenerKR townStreetScreenListener;
    private AddressInputVillageStreetListenerKR villageStreetScreenListener;
    private AddressInputNumberScreenListenerKR numberScreenListener;
    private final ChoiceModelApp provinceNationwideSelectedChoice;

    public AddressInputManagerKR(NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory, IAddressInputWorkFlowManager iAddressInputWorkFlowManager, SpellerStack spellerStack, IPreviewMap iPreviewMap, IStartGuidanceToDestinationSequence iStartGuidanceToDestinationSequence, IVehicle iVehicle, LocationSerializer locationSerializer, IRouteManager iRouteManager, CityHistory cityHistory, NaviADBHandler naviADBHandler, INaviFavoriteHandler iNaviFavoriteHandler, AsyncNavLocationExtractor asyncNavLocationExtractor, ADBInterAppService aDBInterAppService, HomeAddressHandler homeAddressHandler, MapInterface mapInterface, AsyncNavLocationExtractor asyncNavLocationExtractor2, IAddressInputFormModelAccessHelper iAddressInputFormModelAccessHelper, HomeAddressHandler homeAddressHandler2) {
        super(navigationEnv, iCommandListFactory, iAddressInputWorkFlowManager, spellerStack, iPreviewMap, iStartGuidanceToDestinationSequence, iVehicle, locationSerializer, iRouteManager, cityHistory, naviADBHandler, iNaviFavoriteHandler, asyncNavLocationExtractor, aDBInterAppService, homeAddressHandler, mapInterface, asyncNavLocationExtractor2, iAddressInputFormModelAccessHelper, homeAddressHandler2);
        this.provinceNationwideSelectedChoice = navigationEnv.getChoiceModel(DIScreensEvo.getDiKrProvinceNationwideButtonSelectedChoiceModel());
    }

    protected void initListeners() {
        this.mainScreenListener = this.initMainScreenListener();
        this.rightDrawerListener = this.initRightDrawerListener();
        this.provinceScreenListener = this.initProvinceScreenListener();
        this.cityScreenListener = this.initCityScreenListener();
        this.wardScreenListener = this.initWardScreenListener();
        this.townStreetScreenListener = this.initTownStreetScreenListener();
        this.villageStreetScreenListener = this.initVillageStreetScreenListener();
        this.numberScreenListener = this.initNumberScreenListener();
    }

    public void start(NavLocation navLocation) {
        if (!this.addressInputCommandListMonitor.isActive()) {
            this.logChannel.log(10000000, "%1#start with navLocation=%2", (Object)this.CLASS_NAME, (Object)LocationFormatter.formatLocationShort(navLocation));
            CommandList commandList = this.commandListFactory.createCommandList();
            commandList.addMonitor(this.addressInputCommandListMonitor);
            this.mainScreenListener.resetPreviousLocation();
            if (navLocation != null) {
                this.logChannel.log(10000000, "%1#start() with navLocation: %2", (Object)this.CLASS_NAME, (Object)LocationFormatter.formatLocationShort(navLocation));
                commandList.put("startMainScreenNavLocation", navLocation);
            } else {
                this.logChannel.log(10000000, "%1#start() with CCP", (Object)this.CLASS_NAME);
                this.addStripLocationForCcpCommands(commandList, 23);
            }
            this.enterSearchAreaFromPoiContext();
            this.executeAddressInputEvent(commandList, 40012);
        } else {
            this.logChannel.log(10000000, "%1#start - the command list to start address input is still running - ignoring further calls.", (Object)this.CLASS_NAME);
        }
    }

    public void startWithoutStrip(NavLocation navLocation) {
        this.start(navLocation);
    }

    public void startForRemoteHMI() {
        this.logChannel.log(10000000, "%1#startForRemoteHMI", (Object)this.CLASS_NAME);
        this.enterSearchAreaFromRemoteHmi();
        CommandList commandList = this.commandListFactory.createCommandList();
        this.addStripLocationForCcpCommands(commandList, 23);
        this.startForRemoteHMI(commandList);
    }

    public void startForOnline() {
        this.logChannel.log(10000000, "%1#startForOnline", (Object)this.CLASS_NAME);
        this.enterSearchAreaFromOnlinePoiContext();
        CommandList commandList = this.commandListFactory.createCommandList();
        this.addStripLocationForCcpCommands(commandList, 23);
        this.startForOnline(commandList);
    }

    public void addAddressToFavorites(NavLocation navLocation) {
        this.naviFavoriteHandler.addToFavorites(navLocation);
    }

    public void destAddressInputHKReturn(int n, int n2, Command command, Command command2) {
        this.logChannel.log(10000000, "%1#destAddressInputHKReturn called with removeHandler=%2", (Object)this.CLASS_NAME, (long)n2);
        SpellerStack.StackElement stackElement = null;
        switch (n2) {
            default: 
        }
        stackElement = this.spellerStack.pop();
        if (stackElement != null) {
            this.logChannel.log(10000000, "%1#destAddressInputHKReturn element popped from speller stack=%2", (Object)this.CLASS_NAME, (Object)stackElement);
            CommandList commandList = this.commandListFactory.createCommandList();
            commandList.add(new LIRestoreStateCommand(stackElement));
            NavLocation navLocation = this.env.getContainer().getLiCurrentLD();
            IMyLocationAccessor iMyLocationAccessor = Util.getLocationAccessor(navLocation);
            final String string = iMyLocationAccessor.getState();
            final String string2 = iMyLocationAccessor.getTown();
            final String string3 = iMyLocationAccessor.getSubmunicipalTown();
            final String string4 = iMyLocationAccessor.getStreet();
            this.logChannel.log(10000000, "%1#destAddressInputHKReturn with liCurrentLD = %2", (Object)this.CLASS_NAME, (Object)LocationFormatter.formatLocationShort(navLocation));
            commandList.add(new NavCommand(new StringBuffer().append(this.CLASS_NAME).append("#destAddressInputHKReturn - Show or Hide Preview Map").toString()){

                public void execute() {
                    if (!Util.isEmpty(string)) {
                        boolean bl = false;
                        if (!Util.isEmpty(string2) && Util.isEmpty(string3) && Util.isEmpty(string4)) {
                            bl = true;
                        }
                        this.getCommandList().commandFinishedWithPostCommand(new CmdNaviPreviewMapUpdate(AddressInputManagerKR.this.previewMap, bl, 1, null, null));
                    } else if (AddressInputManagerKR.this.provinceNationwideSelectedChoice.getValue() == 1) {
                        AddressInputManagerKR.this.previewMap.setPreviewAreaAroundCCP(1);
                        this.getCommandList().commandFinished();
                    } else {
                        AddressInputManagerKR.this.previewMap.hidePreviewMap();
                        this.getCommandList().commandFinished();
                    }
                }
            });
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
            this.logChannel.log(100000, "%1#destAddressInputHKReturn - popped element from SpellerStack but element is null!", (Object)this.CLASS_NAME);
        }
    }

    private AddressInputMainScreenListenerKR initMainScreenListener() {
        AddressInputMainScreenModelAccessKR addressInputMainScreenModelAccessKR = new AddressInputMainScreenModelAccessKR(this.env, this.modelAccessHelper);
        AddressInputFormOnlineModelAccess addressInputFormOnlineModelAccess = new AddressInputFormOnlineModelAccess(this.env, this.cityHistory, DIScreensEvo.getDiCnOnlineSearchAreaBaseListModel(), this.modelAccessHelper);
        AddressInputMainScreenSequence addressInputMainScreenSequence = new AddressInputMainScreenSequence(this.commandListFactory, this.env, this.startRouteGuidanceSequence, addressInputMainScreenModelAccessKR, this.previewMap, this.spellerStack, this, addressInputFormOnlineModelAccess);
        AddressInputMainScreenListenerKR addressInputMainScreenListenerKR = new AddressInputMainScreenListenerKR(this.env, this.previewMap, this.commandListFactory, this, addressInputMainScreenSequence, this.adbInterAppService, this.homeAddressHandler);
        return addressInputMainScreenListenerKR;
    }

    private AddressInputRightDrawerListenerKR initRightDrawerListener() {
        AddressInputRightDrawerListenerKR addressInputRightDrawerListenerKR = new AddressInputRightDrawerListenerKR(this.env, this.previewMap, this.commandListFactory, this, this.mapInterface, this.asyncLiValueListNavLocationExctractor, this.asyncLiCityStateStreetHistoryListNavLocationExtractor, this.mainScreenListener);
        return addressInputRightDrawerListenerKR;
    }

    private AddressInputProvinceScreenListenerKR initProvinceScreenListener() {
        AddressInputProvinceModelAccessKR addressInputProvinceModelAccessKR = new AddressInputProvinceModelAccessKR(this.env, DIScreensEvo.getDiKrProvinceScreenMatchSpellerModel(), DIScreensEvo.getDiKrProvinceScreenTiledListModel(), this.cityHistory, this.modelAccessHelper);
        AddressInputProvinceSequenceAsia addressInputProvinceSequenceAsia = new AddressInputProvinceSequenceAsia(this.commandListFactory, this.env, addressInputProvinceModelAccessKR, this.previewMap, this.spellerStack, this, this.cityHistory);
        int n = DIScreensEvo.getDiKrProvinceScreenMenuModel();
        int n2 = DIScreensEvo.getDiKrProvinceScreenMatchSpellerModel();
        int n3 = DIScreensEvo.getDiKrProvinceScreenTiledListModel();
        AddressInputProvinceScreenListenerKR addressInputProvinceScreenListenerKR = new AddressInputProvinceScreenListenerKR(this.env, this.previewMap, this.commandListFactory, (IAddressInputManager)this, addressInputProvinceSequenceAsia, n, n2, n3);
        return addressInputProvinceScreenListenerKR;
    }

    private AddressInputCityScreenListenerKR initCityScreenListener() {
        AddressInputCityScreenModelAccessKR addressInputCityScreenModelAccessKR = new AddressInputCityScreenModelAccessKR(this.env, DIScreensEvo.getDiKrCityScreenMatchSpellerModel(), DIScreensEvo.getDiKrCityScreenTiledListModel(), this.cityHistory, this.modelAccessHelper);
        AddressInputCitySequenceKR addressInputCitySequenceKR = new AddressInputCitySequenceKR(this.commandListFactory, this.env, addressInputCityScreenModelAccessKR, this.previewMap, this.spellerStack, this, this.cityHistory);
        int n = DIScreensEvo.getDiKrCityScreenMenuModel();
        int n2 = DIScreensEvo.getDiKrCityScreenMatchSpellerModel();
        int n3 = DIScreensEvo.getDiKrCityScreenTiledListModel();
        AddressInputCityScreenListenerKR addressInputCityScreenListenerKR = new AddressInputCityScreenListenerKR(this.env, this.previewMap, this.commandListFactory, (IAddressInputManager)this, addressInputCitySequenceKR, n, n2, n3);
        return addressInputCityScreenListenerKR;
    }

    private AddressInputWardScreenListenerKR initWardScreenListener() {
        AddressInputWardModelAccessKR addressInputWardModelAccessKR = new AddressInputWardModelAccessKR(this.env, DIScreensEvo.getDiKrWardScreenMatchSpellerModel(), DIScreensEvo.getDiKrWardScreenTiledListModel(), this.modelAccessHelper);
        AddressInputWardSequence addressInputWardSequence = new AddressInputWardSequence(this.commandListFactory, this.env, addressInputWardModelAccessKR, this.previewMap, this.spellerStack, this);
        int n = DIScreensEvo.getDiKrWardScreenMenuModel();
        int n2 = DIScreensEvo.getDiKrWardScreenMatchSpellerModel();
        int n3 = DIScreensEvo.getDiKrWardScreenTiledListModel();
        AddressInputWardScreenListenerKR addressInputWardScreenListenerKR = new AddressInputWardScreenListenerKR(this.env, this.previewMap, this.commandListFactory, (IAddressInputManager)this, addressInputWardSequence, n, n2, n3);
        return addressInputWardScreenListenerKR;
    }

    private AddressInputTownStreetScreenListenerKR initTownStreetScreenListener() {
        AddressInputTownStreetModelAccessKR addressInputTownStreetModelAccessKR = new AddressInputTownStreetModelAccessKR(this.env, DIScreensEvo.getDiKrTownStreetScreenMatchSpellerModel(), DIScreensEvo.getDiKrTownStreetScreenTiledListModel(), this.modelAccessHelper);
        AddressInputTownStreetSequence addressInputTownStreetSequence = new AddressInputTownStreetSequence(this.commandListFactory, this.env, addressInputTownStreetModelAccessKR, this.previewMap, this.spellerStack, this);
        int n = DIScreensEvo.getDiKrTownStreetScreenMenuModel();
        int n2 = DIScreensEvo.getDiKrTownStreetScreenMatchSpellerModel();
        int n3 = DIScreensEvo.getDiKrTownStreetScreenTiledListModel();
        AddressInputTownStreetScreenListenerKR addressInputTownStreetScreenListenerKR = new AddressInputTownStreetScreenListenerKR(this.env, this.previewMap, this.commandListFactory, (IAddressInputManager)this, addressInputTownStreetSequence, n, n2, n3);
        return addressInputTownStreetScreenListenerKR;
    }

    private AddressInputVillageStreetListenerKR initVillageStreetScreenListener() {
        AddressInputVillageStreetModelAccessKR addressInputVillageStreetModelAccessKR = new AddressInputVillageStreetModelAccessKR(this.env, DIScreensEvo.getDiKrVillageStreetScreenMatchSpellerModel(), DIScreensEvo.getDiKrVillageStreetScreenTiledListModel(), this.modelAccessHelper);
        AddressInputVillageStreetSequence addressInputVillageStreetSequence = new AddressInputVillageStreetSequence(this.commandListFactory, this.env, addressInputVillageStreetModelAccessKR, this.previewMap, this.spellerStack, this);
        int n = DIScreensEvo.getDiKrVillageStreetScreenMenuModel();
        int n2 = DIScreensEvo.getDiKrVillageStreetScreenMatchSpellerModel();
        int n3 = DIScreensEvo.getDiKrVillageStreetScreenTiledListModel();
        AddressInputVillageStreetListenerKR addressInputVillageStreetListenerKR = new AddressInputVillageStreetListenerKR(this.env, this.previewMap, this.commandListFactory, (IAddressInputManager)this, addressInputVillageStreetSequence, n, n2, n3);
        return addressInputVillageStreetListenerKR;
    }

    private AddressInputNumberScreenListenerKR initNumberScreenListener() {
        HousenumberMatchspellerInputModelAccess housenumberMatchspellerInputModelAccess = new HousenumberMatchspellerInputModelAccess(this.env, DIScreensEvo.getDiKrNumberScreenMatchSpellerModel(), DIScreensEvo.getDiKrNumberScreenTiledListModel(), this.modelAccessHelper);
        AddressInputHouseNumberSequenceAsia addressInputHouseNumberSequenceAsia = new AddressInputHouseNumberSequenceAsia(this.commandListFactory, this.env, housenumberMatchspellerInputModelAccess, this.previewMap, this.spellerStack, this);
        int n = DIScreensEvo.getDiKrNumberScreenMenuModel();
        int n2 = DIScreensEvo.getDiKrNumberScreenMatchSpellerModel();
        int n3 = DIScreensEvo.getDiKrNumberScreenTiledListModel();
        AddressInputNumberScreenListenerKR addressInputNumberScreenListenerKR = new AddressInputNumberScreenListenerKR(this.env, this.previewMap, this.commandListFactory, (IAddressInputManager)this, addressInputHouseNumberSequenceAsia, n, n2, n3);
        return addressInputNumberScreenListenerKR;
    }

    public IAddressInputMainScreenListener getMainScreenListener() {
        return this.mainScreenListener;
    }

    public AddressInputRightDrawerListenerKR getRightDrawerListener() {
        return this.rightDrawerListener;
    }

    public AddressInputProvinceScreenListenerKR getProvinceScreenListener() {
        return this.provinceScreenListener;
    }

    public AddressInputCityScreenListenerKR getCityScreenListener() {
        return this.cityScreenListener;
    }

    public AddressInputWardScreenListenerKR getWardScreenListener() {
        return this.wardScreenListener;
    }

    public AddressInputTownStreetScreenListenerKR getTownStreetScreenListener() {
        return this.townStreetScreenListener;
    }

    public AddressInputVillageStreetListenerKR getVillageStreetScreenListener() {
        return this.villageStreetScreenListener;
    }

    public AddressInputNumberScreenListenerKR getNumberScreenListener() {
        return this.numberScreenListener;
    }

    public int getAutoSelectLeftElementEventId() {
        return 40204;
    }

    public int getStreetScreenAmbiguousListElementSelecteEventId() {
        return 40504;
    }

    public int getStreetScreenNonAmbiguousListElementSelectedEventId() {
        return 40503;
    }

    public int getStartForOnlineEventId() {
        return 40013;
    }

    public int getStartForRemoteHMIEventId() {
        return 40014;
    }

    public int getStartCityInputFromMainScreenEventId() {
        return 40003;
    }
}

