/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.cn;

import de.audi.app.navi.evo.addressinput.AddressInputFormOnlineModelAccess;
import de.audi.app.navi.evo.addressinput.housenumber.HousenumberMatchspellerInputModelAccess;
import de.audi.app.navi.evo.addressinput.junction.JunctionInputModelAccess;
import de.audi.app.navi.evo.addressinput.street.StreetInputModelAccess;
import de.audi.app.navi.evo.di.AbstractAddressInputManagerEvo;
import de.audi.app.navi.evo.di.DIScreensEvo;
import de.audi.app.navi.evo.di.cn.listeners.AddressInputCityScreenListenerCN;
import de.audi.app.navi.evo.di.cn.listeners.AddressInputHouseNumberScreenListenerCN;
import de.audi.app.navi.evo.di.cn.listeners.AddressInputIntersectionScreenListenerCN;
import de.audi.app.navi.evo.di.cn.listeners.AddressInputMainScreenListenerCN;
import de.audi.app.navi.evo.di.cn.listeners.AddressInputRightDrawerListenerCN;
import de.audi.app.navi.evo.di.cn.listeners.AddressInputStreetScreenListenerCN;
import de.audi.app.navi.evo.di.cn.models.AddressInputCityScreenModelAccessCN;
import de.audi.app.navi.evo.di.cn.models.AddressInputMainScreenModelAccessCN;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.ADBInterAppService;
import de.audi.tghu.navi.app.CityHistory;
import de.audi.tghu.navi.app.HomeAddressHandler;
import de.audi.tghu.navi.app.LocationSerializer;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.adb.NaviADBHandler;
import de.audi.tghu.navi.app.addressinput.IAddressInputFormModelAccessHelper;
import de.audi.tghu.navi.app.di.IAddressInputMainScreenListener;
import de.audi.tghu.navi.app.di.IAddressInputManager;
import de.audi.tghu.navi.app.di.IAddressInputWorkFlowManager;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputCityZipSequenceAsia;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputHouseNumberSequenceAsia;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputJunctionSequence;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputStreetSequenceCN;
import de.audi.tghu.navi.app.di.sequences.nospeller.AddressInputMainScreenSequence;
import de.audi.tghu.navi.app.favorite.INaviFavoriteHandler;
import de.audi.tghu.navi.app.guidance.IVehicle;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.map.MapInterface;
import de.audi.tghu.navi.app.navlocationextractor.AsyncNavLocationExtractor;
import de.audi.tghu.navi.app.routeguidance.IRouteManager;
import de.audi.tghu.navi.app.routeguidance.IStartGuidanceToDestinationSequence;
import de.audi.tghu.navi.app.util.LocationFormatter;
import org.dsi.ifc.global.NavLocation;

public class AddressInputManagerCN
extends AbstractAddressInputManagerEvo {
    private static final int DESTINATION_TYPE_FOR_CCP_LOCATION_STRIPPING;
    private AddressInputMainScreenListenerCN mainScreenListener;
    private AddressInputRightDrawerListenerCN rightDrawerListener;
    private AddressInputCityScreenListenerCN cityScreenListener;
    private AddressInputStreetScreenListenerCN streetScreenListener;
    private AddressInputHouseNumberScreenListenerCN houseNumberScreenListener;
    private AddressInputIntersectionScreenListenerCN intersectionScreenListener;

    public AddressInputManagerCN(NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory, IAddressInputWorkFlowManager iAddressInputWorkFlowManager, SpellerStack spellerStack, IPreviewMap iPreviewMap, IStartGuidanceToDestinationSequence iStartGuidanceToDestinationSequence, IVehicle iVehicle, LocationSerializer locationSerializer, IRouteManager iRouteManager, CityHistory cityHistory, NaviADBHandler naviADBHandler, INaviFavoriteHandler iNaviFavoriteHandler, AsyncNavLocationExtractor asyncNavLocationExtractor, ADBInterAppService aDBInterAppService, HomeAddressHandler homeAddressHandler, MapInterface mapInterface, AsyncNavLocationExtractor asyncNavLocationExtractor2, IAddressInputFormModelAccessHelper iAddressInputFormModelAccessHelper, HomeAddressHandler homeAddressHandler2) {
        super(navigationEnv, iCommandListFactory, iAddressInputWorkFlowManager, spellerStack, iPreviewMap, iStartGuidanceToDestinationSequence, iVehicle, locationSerializer, iRouteManager, cityHistory, naviADBHandler, iNaviFavoriteHandler, asyncNavLocationExtractor, aDBInterAppService, homeAddressHandler, mapInterface, asyncNavLocationExtractor2, iAddressInputFormModelAccessHelper, homeAddressHandler2);
    }

    @Override
    protected void initListeners() {
        this.mainScreenListener = this.initMainScreenListener();
        this.rightDrawerListener = this.initRightDrawerListener();
        this.cityScreenListener = this.initCityZipScreenListener();
        this.streetScreenListener = this.initStreetScreenListener();
        this.houseNumberScreenListener = this.initHouseNumberScreenListener();
        this.intersectionScreenListener = this.initIntersectionScreenListener();
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
                this.addStripLocationForCcpCommands(commandList, 20);
            }
            this.enterSearchAreaFromPoiContext();
            this.executeAddressInputEvent(commandList, 10008);
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
        this.addStripLocationForCcpCommands(commandList, 20);
        this.startForOnline(commandList);
    }

    @Override
    public void startForRemoteHMI() {
        this.logChannel.log(-2137614336, "%1#startForRemoteHMI", (Object)this.CLASS_NAME);
        this.enterSearchAreaFromRemoteHmi();
        CommandList commandList = this.commandListFactory.createCommandList();
        this.addStripLocationForCcpCommands(commandList, 20);
        this.startForRemoteHMI(commandList);
    }

    @Override
    public void addAddressToFavorites(NavLocation navLocation) {
        this.naviFavoriteHandler.addToFavorites(navLocation);
    }

    private AddressInputMainScreenListenerCN initMainScreenListener() {
        AddressInputMainScreenModelAccessCN addressInputMainScreenModelAccessCN = new AddressInputMainScreenModelAccessCN(this.env, this.modelAccessHelper);
        AddressInputFormOnlineModelAccess addressInputFormOnlineModelAccess = new AddressInputFormOnlineModelAccess(this.env, this.cityHistory, DIScreensEvo.getDiCnOnlineSearchAreaBaseListModel(), this.modelAccessHelper);
        AddressInputMainScreenSequence addressInputMainScreenSequence = new AddressInputMainScreenSequence(this.commandListFactory, this.env, this.startRouteGuidanceSequence, addressInputMainScreenModelAccessCN, this.previewMap, this.spellerStack, this, addressInputFormOnlineModelAccess);
        AddressInputMainScreenListenerCN addressInputMainScreenListenerCN = new AddressInputMainScreenListenerCN(this.env, this.previewMap, this.commandListFactory, this, addressInputMainScreenSequence, this.adbInterAppService, this.homeAddressHandler);
        return addressInputMainScreenListenerCN;
    }

    private AddressInputRightDrawerListenerCN initRightDrawerListener() {
        AddressInputRightDrawerListenerCN addressInputRightDrawerListenerCN = new AddressInputRightDrawerListenerCN(this.env, this.previewMap, this.commandListFactory, this, this.mapInterface, this.asyncLiValueListNavLocationExctractor, this.asyncLiCityStateStreetHistoryListNavLocationExtractor, this.mainScreenListener);
        return addressInputRightDrawerListenerCN;
    }

    private AddressInputCityScreenListenerCN initCityZipScreenListener() {
        AddressInputCityScreenModelAccessCN addressInputCityScreenModelAccessCN = new AddressInputCityScreenModelAccessCN(this.env, DIScreensEvo.getDiCnCityScreenMatchSpellerModel(), DIScreensEvo.getDiCnCityScreenTiledListModel(), this.cityHistory, this.modelAccessHelper);
        AddressInputCityZipSequenceAsia addressInputCityZipSequenceAsia = new AddressInputCityZipSequenceAsia(this.commandListFactory, this.env, addressInputCityScreenModelAccessCN, this.previewMap, this.spellerStack, this, this.cityHistory);
        int n = DIScreensEvo.getDiCnCityScreenMenuModel();
        int n2 = DIScreensEvo.getDiCnCityScreenMatchSpellerModel();
        int n3 = DIScreensEvo.getDiCnCityScreenTiledListModel();
        AddressInputCityScreenListenerCN addressInputCityScreenListenerCN = new AddressInputCityScreenListenerCN(this.env, this.previewMap, this.commandListFactory, (IAddressInputManager)this, addressInputCityZipSequenceAsia, n, n2, n3);
        return addressInputCityScreenListenerCN;
    }

    private AddressInputStreetScreenListenerCN initStreetScreenListener() {
        StreetInputModelAccess streetInputModelAccess = new StreetInputModelAccess(this.env, DIScreensEvo.getDiCnStreetScreenSpellerModel(), DIScreensEvo.getDiCnStreetScreenTiledListModel(), this.modelAccessHelper);
        AddressInputStreetSequenceCN addressInputStreetSequenceCN = new AddressInputStreetSequenceCN(this.commandListFactory, this.env, streetInputModelAccess, this.previewMap, this.spellerStack, this);
        int n = DIScreensEvo.getDiCnStreetScreenMenuModel();
        int n2 = DIScreensEvo.getDiCnStreetScreenSpellerModel();
        int n3 = DIScreensEvo.getDiCnStreetScreenTiledListModel();
        AddressInputStreetScreenListenerCN addressInputStreetScreenListenerCN = new AddressInputStreetScreenListenerCN(this.env, this.previewMap, this.commandListFactory, (IAddressInputManager)this, addressInputStreetSequenceCN, n, n2, n3);
        return addressInputStreetScreenListenerCN;
    }

    private AddressInputIntersectionScreenListenerCN initIntersectionScreenListener() {
        JunctionInputModelAccess junctionInputModelAccess = new JunctionInputModelAccess(this.env, DIScreensEvo.getDiCnIntersectionScreenMatchSpellerModel(), DIScreensEvo.getDiCnIntersectionScreenTiledListModel(), this.modelAccessHelper);
        AddressInputJunctionSequence addressInputJunctionSequence = new AddressInputJunctionSequence(this.commandListFactory, this.env, junctionInputModelAccess, this.previewMap, this.spellerStack, this);
        int n = DIScreensEvo.getDiCnIntersectionScreenMenuModel();
        int n2 = DIScreensEvo.getDiCnIntersectionScreenMatchSpellerModel();
        int n3 = DIScreensEvo.getDiCnIntersectionScreenTiledListModel();
        AddressInputIntersectionScreenListenerCN addressInputIntersectionScreenListenerCN = new AddressInputIntersectionScreenListenerCN(this.env, this.previewMap, this.commandListFactory, (IAddressInputManager)this, addressInputJunctionSequence, n, n2, n3);
        return addressInputIntersectionScreenListenerCN;
    }

    private AddressInputHouseNumberScreenListenerCN initHouseNumberScreenListener() {
        HousenumberMatchspellerInputModelAccess housenumberMatchspellerInputModelAccess = new HousenumberMatchspellerInputModelAccess(this.env, DIScreensEvo.getDiCnHousenumberScreenMatchSpellerModel(), DIScreensEvo.getDiCnHousenumberScreenTiledListModel(), this.modelAccessHelper);
        AddressInputHouseNumberSequenceAsia addressInputHouseNumberSequenceAsia = new AddressInputHouseNumberSequenceAsia(this.commandListFactory, this.env, housenumberMatchspellerInputModelAccess, this.previewMap, this.spellerStack, this);
        int n = DIScreensEvo.getDiCnHousenumberScreenMenuModel();
        int n2 = DIScreensEvo.getDiCnHousenumberScreenMatchSpellerModel();
        int n3 = DIScreensEvo.getDiCnHousenumberScreenTiledListModel();
        AddressInputHouseNumberScreenListenerCN addressInputHouseNumberScreenListenerCN = new AddressInputHouseNumberScreenListenerCN(this.env, this.previewMap, this.commandListFactory, (IAddressInputManager)this, addressInputHouseNumberSequenceAsia, n, n2, n3);
        return addressInputHouseNumberScreenListenerCN;
    }

    @Override
    public IAddressInputMainScreenListener getMainScreenListener() {
        return this.mainScreenListener;
    }

    public AddressInputRightDrawerListenerCN getRightDrawerListener() {
        return this.rightDrawerListener;
    }

    public AddressInputCityScreenListenerCN getCityZipScreenListener() {
        return this.cityScreenListener;
    }

    public AddressInputStreetScreenListenerCN getStreetScreenListener() {
        return this.streetScreenListener;
    }

    public AddressInputHouseNumberScreenListenerCN getHouseNumberScreenListener() {
        return this.houseNumberScreenListener;
    }

    public AddressInputIntersectionScreenListenerCN getIntersectionScreenListener() {
        return this.intersectionScreenListener;
    }

    @Override
    public int getAutoSelectLeftElementEventId() {
        return 10104;
    }

    @Override
    public int getStreetScreenAmbiguousListElementSelecteEventId() {
        return 10404;
    }

    @Override
    public int getStreetScreenNonAmbiguousListElementSelectedEventId() {
        return 10403;
    }

    @Override
    public int getStartForOnlineEventId() {
        return 10013;
    }

    @Override
    public int getStartForRemoteHMIEventId() {
        return 10014;
    }

    @Override
    public int getStartCityInputFromMainScreenEventId() {
        return 10002;
    }
}

