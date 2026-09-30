/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.eu;

import de.audi.app.navi.evo.addressinput.AddressInputFormOnlineModelAccess;
import de.audi.app.navi.evo.addressinput.city.CityZipInputModelAccess;
import de.audi.app.navi.evo.addressinput.country.CountryInputModelAccess;
import de.audi.app.navi.evo.addressinput.housenumber.HousenumberMatchspellerInputModelAccess;
import de.audi.app.navi.evo.addressinput.housenumber.HousenumberSpellerInputModelAccess;
import de.audi.app.navi.evo.addressinput.junction.JunctionInputModelAccess;
import de.audi.app.navi.evo.addressinput.street.StreetInputModelAccess;
import de.audi.app.navi.evo.di.AbstractAddressInputManagerEvo;
import de.audi.app.navi.evo.di.DIScreensEvo;
import de.audi.app.navi.evo.di.eu.listeners.AddressInputCityZipScreenListenerEU;
import de.audi.app.navi.evo.di.eu.listeners.AddressInputCountryScreenListenerEU;
import de.audi.app.navi.evo.di.eu.listeners.AddressInputHousenumberFreetextScreenListenerEU;
import de.audi.app.navi.evo.di.eu.listeners.AddressInputHousenumberMatchSpellerScreenListenerEU;
import de.audi.app.navi.evo.di.eu.listeners.AddressInputJunctionScreenListenerEU;
import de.audi.app.navi.evo.di.eu.listeners.AddressInputMainScreenListenerEU;
import de.audi.app.navi.evo.di.eu.listeners.AddressInputRefinementScreenListenerEU;
import de.audi.app.navi.evo.di.eu.listeners.AddressInputRightDrawerListenerEU;
import de.audi.app.navi.evo.di.eu.listeners.AddressInputStreetScreenListenerEU;
import de.audi.app.navi.evo.di.eu.models.AddressInputMainScreenModelAccessEU;
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
import de.audi.tghu.navi.app.di.IAddressInputWorkFlowManager;
import de.audi.tghu.navi.app.di.sequences.freetextspeller.AddressInputHousenumberFreetextSequence;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputCityZipSequence;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputCountrySequence;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputHousenumberMatchSpellerSequence;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputJunctionSequence;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputRefinementSequence;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputStreetSequence;
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

public class AddressInputManagerEU
extends AbstractAddressInputManagerEvo {
    private AddressInputMainScreenListenerEU mainScreenListener;
    private AddressInputCountryScreenListenerEU countryScreenListener;
    private AddressInputCityZipScreenListenerEU cityZipScreenListener;
    private AddressInputStreetScreenListenerEU streetScreenListener;
    private AddressInputHousenumberFreetextScreenListenerEU housenumberFreetextScreenListener;
    private AddressInputHousenumberMatchSpellerScreenListenerEU housenumberMatchSpellerListener;
    private AddressInputJunctionScreenListenerEU junctionScreenListener;
    private AddressInputRefinementScreenListenerEU refinementScreenListener;
    private AddressInputRightDrawerListenerEU rightDrawerListener;

    public AddressInputManagerEU(NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory, IAddressInputWorkFlowManager iAddressInputWorkFlowManager, SpellerStack spellerStack, IPreviewMap iPreviewMap, IStartGuidanceToDestinationSequence iStartGuidanceToDestinationSequence, IVehicle iVehicle, LocationSerializer locationSerializer, IRouteManager iRouteManager, CityHistory cityHistory, NaviADBHandler naviADBHandler, INaviFavoriteHandler iNaviFavoriteHandler, AsyncNavLocationExtractor asyncNavLocationExtractor, ADBInterAppService aDBInterAppService, HomeAddressHandler homeAddressHandler, MapInterface mapInterface, AsyncNavLocationExtractor asyncNavLocationExtractor2, IAddressInputFormModelAccessHelper iAddressInputFormModelAccessHelper, HomeAddressHandler homeAddressHandler2) {
        super(navigationEnv, iCommandListFactory, iAddressInputWorkFlowManager, spellerStack, iPreviewMap, iStartGuidanceToDestinationSequence, iVehicle, locationSerializer, iRouteManager, cityHistory, naviADBHandler, iNaviFavoriteHandler, asyncNavLocationExtractor, aDBInterAppService, homeAddressHandler, mapInterface, asyncNavLocationExtractor2, iAddressInputFormModelAccessHelper, homeAddressHandler2);
    }

    protected void initListeners() {
        this.mainScreenListener = this.initMainScreenListener();
        this.countryScreenListener = this.initCountryScreenListener();
        this.cityZipScreenListener = this.initCityZipScreenListener();
        this.streetScreenListener = this.initStreetScreenListener();
        this.housenumberFreetextScreenListener = this.initHousenumberFreetextScreenListener();
        this.housenumberMatchSpellerListener = this.initHousenumberMatchSpellerScreenListener();
        this.junctionScreenListener = this.initJunctionScreenListener();
        this.refinementScreenListener = this.initRefinementScreenListener();
        this.rightDrawerListener = this.initRightDrawerListener();
    }

    public void start(NavLocation navLocation) {
        if (!this.addressInputCommandListMonitor.isActive()) {
            this.logChannel.log(10000000, "%1#start with navLocation=%2", (Object)this.CLASS_NAME, (Object)LocationFormatter.formatLocationShort(navLocation));
            CommandList commandList = this.commandListFactory.createCommandList();
            commandList.addMonitor(this.addressInputCommandListMonitor);
            this.mainScreenListener.resetPreviousLocation();
            if (navLocation != null) {
                commandList.put("startMainScreenNavLocation", navLocation);
            }
            if (this.inputModeManager.getInputMode() == 5 || this.inputModeManager.getInputMode() == 4) {
                this.executeAddressInputEvent(commandList, 17);
            } else {
                this.executeAddressInputEvent(commandList, 7);
            }
        } else {
            this.logChannel.log(10000000, "%1#start - the command list to start address input is still running - ignoring further calls.", (Object)this.CLASS_NAME);
        }
    }

    public void startWithoutStrip(NavLocation navLocation) {
        this.start(navLocation);
    }

    private AddressInputMainScreenListenerEU initMainScreenListener() {
        AddressInputMainScreenModelAccessEU addressInputMainScreenModelAccessEU = new AddressInputMainScreenModelAccessEU(this.env, this.modelAccessHelper);
        AddressInputFormOnlineModelAccess addressInputFormOnlineModelAccess = new AddressInputFormOnlineModelAccess(this.env, this.cityHistory, DIScreensEvo.getDiEuOnlineSearchAreaBaseListModel(), this.modelAccessHelper);
        AddressInputMainScreenSequence addressInputMainScreenSequence = new AddressInputMainScreenSequence(this.commandListFactory, this.env, this.startRouteGuidanceSequence, addressInputMainScreenModelAccessEU, this.previewMap, this.spellerStack, this, addressInputFormOnlineModelAccess);
        AddressInputMainScreenListenerEU addressInputMainScreenListenerEU = new AddressInputMainScreenListenerEU(this.env, this.previewMap, this.commandListFactory, this, addressInputMainScreenSequence, this.adbInterAppService, this.homeAddressHandler);
        return addressInputMainScreenListenerEU;
    }

    private AddressInputCountryScreenListenerEU initCountryScreenListener() {
        CountryInputModelAccess countryInputModelAccess = new CountryInputModelAccess(this.env, DIScreensEvo.getDiEuCountryScreenMatchSpellerModel(), DIScreensEvo.getDiEuCountryScreenTiledListModel(), this.modelAccessHelper);
        AddressInputCountrySequence addressInputCountrySequence = new AddressInputCountrySequence(this.commandListFactory, this.env, countryInputModelAccess, this.previewMap, this.spellerStack, this);
        AddressInputCountryScreenListenerEU addressInputCountryScreenListenerEU = new AddressInputCountryScreenListenerEU(this.env, this.previewMap, this.commandListFactory, this, addressInputCountrySequence);
        return addressInputCountryScreenListenerEU;
    }

    private AddressInputCityZipScreenListenerEU initCityZipScreenListener() {
        CityZipInputModelAccess cityZipInputModelAccess = new CityZipInputModelAccess(this.env, DIScreensEvo.getDiEuCityZipScreenMatchSpellerModel(), DIScreensEvo.getDiEuCityZipScreenTiledListModel(), this.cityHistory, this.modelAccessHelper);
        AddressInputCityZipSequence addressInputCityZipSequence = new AddressInputCityZipSequence(this.commandListFactory, this.env, cityZipInputModelAccess, this.previewMap, this.spellerStack, this, this.cityHistory);
        AddressInputCityZipScreenListenerEU addressInputCityZipScreenListenerEU = new AddressInputCityZipScreenListenerEU(this.env, this.previewMap, this.commandListFactory, this, addressInputCityZipSequence);
        return addressInputCityZipScreenListenerEU;
    }

    private AddressInputStreetScreenListenerEU initStreetScreenListener() {
        StreetInputModelAccess streetInputModelAccess = new StreetInputModelAccess(this.env, DIScreensEvo.getDiEuStreetScreenMatchSpellerModel(), DIScreensEvo.getDiEuStreetScreenTiledListModel(), this.modelAccessHelper);
        AddressInputStreetSequence addressInputStreetSequence = new AddressInputStreetSequence(this.commandListFactory, this.env, streetInputModelAccess, this.previewMap, this.spellerStack, this);
        AddressInputStreetScreenListenerEU addressInputStreetScreenListenerEU = new AddressInputStreetScreenListenerEU(this.env, this.previewMap, this.commandListFactory, this, addressInputStreetSequence);
        return addressInputStreetScreenListenerEU;
    }

    private AddressInputHousenumberMatchSpellerScreenListenerEU initHousenumberMatchSpellerScreenListener() {
        HousenumberMatchspellerInputModelAccess housenumberMatchspellerInputModelAccess = new HousenumberMatchspellerInputModelAccess(this.env, DIScreensEvo.getDiEuHousenumberMatchSpellerScreenMatchSpellerModel(), DIScreensEvo.getDiEuHousenumberMatchSpellerScreenTiledListModel(), this.modelAccessHelper);
        AddressInputHousenumberMatchSpellerSequence addressInputHousenumberMatchSpellerSequence = new AddressInputHousenumberMatchSpellerSequence(this.commandListFactory, this.env, housenumberMatchspellerInputModelAccess, this.previewMap, this.spellerStack, this);
        AddressInputHousenumberMatchSpellerScreenListenerEU addressInputHousenumberMatchSpellerScreenListenerEU = new AddressInputHousenumberMatchSpellerScreenListenerEU(this.env, this.previewMap, this.commandListFactory, this, addressInputHousenumberMatchSpellerSequence);
        return addressInputHousenumberMatchSpellerScreenListenerEU;
    }

    private AddressInputHousenumberFreetextScreenListenerEU initHousenumberFreetextScreenListener() {
        HousenumberSpellerInputModelAccess housenumberSpellerInputModelAccess = new HousenumberSpellerInputModelAccess(this.env, DIScreensEvo.getDiEuHousenumberFreetextScreenSpellerModel(), DIScreensEvo.getDiEuHousenumberFreetextScreenTiledListModel(), this, this.modelAccessHelper);
        AddressInputHousenumberFreetextSequence addressInputHousenumberFreetextSequence = new AddressInputHousenumberFreetextSequence(this.commandListFactory, housenumberSpellerInputModelAccess, this.previewMap, this);
        AddressInputHousenumberFreetextScreenListenerEU addressInputHousenumberFreetextScreenListenerEU = new AddressInputHousenumberFreetextScreenListenerEU(this.env, this.previewMap, this.commandListFactory, this, addressInputHousenumberFreetextSequence);
        return addressInputHousenumberFreetextScreenListenerEU;
    }

    private AddressInputJunctionScreenListenerEU initJunctionScreenListener() {
        JunctionInputModelAccess junctionInputModelAccess = new JunctionInputModelAccess(this.env, DIScreensEvo.getDiEuJunctionScreenMatchSpellerModel(), DIScreensEvo.getDiEuJunctionScreenTiledListModel(), this.modelAccessHelper);
        AddressInputJunctionSequence addressInputJunctionSequence = new AddressInputJunctionSequence(this.commandListFactory, this.env, junctionInputModelAccess, this.previewMap, this.spellerStack, this);
        AddressInputJunctionScreenListenerEU addressInputJunctionScreenListenerEU = new AddressInputJunctionScreenListenerEU(this.env, this.previewMap, this.commandListFactory, this, addressInputJunctionSequence);
        return addressInputJunctionScreenListenerEU;
    }

    private AddressInputRefinementScreenListenerEU initRefinementScreenListener() {
        StreetInputModelAccess streetInputModelAccess = new StreetInputModelAccess(this.env, DIScreensEvo.getDiEuRefinementScreenMatchSpellerModel(), DIScreensEvo.getDiEuRefinementScreenTiledListModel(), this.modelAccessHelper);
        AddressInputRefinementSequence addressInputRefinementSequence = new AddressInputRefinementSequence(this.commandListFactory, this.env, streetInputModelAccess, this.previewMap, this.spellerStack, this);
        AddressInputRefinementScreenListenerEU addressInputRefinementScreenListenerEU = new AddressInputRefinementScreenListenerEU(this.env, this.previewMap, this.commandListFactory, this, addressInputRefinementSequence);
        return addressInputRefinementScreenListenerEU;
    }

    private AddressInputRightDrawerListenerEU initRightDrawerListener() {
        AddressInputRightDrawerListenerEU addressInputRightDrawerListenerEU = new AddressInputRightDrawerListenerEU(this.env, this.previewMap, this.commandListFactory, this, this.mapInterface, this.asyncLiValueListNavLocationExctractor, this.asyncLiCityStateStreetHistoryListNavLocationExtractor, this.mainScreenListener);
        return addressInputRightDrawerListenerEU;
    }

    public IAddressInputMainScreenListener getMainScreenListener() {
        return this.mainScreenListener;
    }

    public AddressInputCountryScreenListenerEU getCountryScreenListener() {
        return this.countryScreenListener;
    }

    public AddressInputCityZipScreenListenerEU getCityZipScreenListener() {
        return this.cityZipScreenListener;
    }

    public AddressInputStreetScreenListenerEU getStreetScreenListener() {
        return this.streetScreenListener;
    }

    public AddressInputHousenumberFreetextScreenListenerEU getHousenumberFreetextScreenListener() {
        return this.housenumberFreetextScreenListener;
    }

    public AddressInputHousenumberMatchSpellerScreenListenerEU getHousenumberMatchSpellerScreenListener() {
        return this.housenumberMatchSpellerListener;
    }

    public AddressInputJunctionScreenListenerEU getJunctionScreenListener() {
        return this.junctionScreenListener;
    }

    public AddressInputRefinementScreenListenerEU getRefinementScreenListener() {
        return this.refinementScreenListener;
    }

    public AddressInputRightDrawerListenerEU getRightDrawerListener() {
        return this.rightDrawerListener;
    }

    public int getAutoSelectLeftElementEventId() {
        return 204;
    }

    public int getStreetScreenAmbiguousListElementSelecteEventId() {
        return 304;
    }

    public int getStreetScreenNonAmbiguousListElementSelectedEventId() {
        return 303;
    }

    public int getStartForOnlineEventId() {
        return 14;
    }

    public int getStartForRemoteHMIEventId() {
        return 17;
    }

    public int getStartCityInputFromMainScreenEventId() {
        return 3;
    }
}

