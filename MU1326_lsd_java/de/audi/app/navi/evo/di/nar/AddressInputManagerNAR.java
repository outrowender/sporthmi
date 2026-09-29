/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.nar;

import de.audi.app.navi.evo.addressinput.city.CityZipInputModelAccess;
import de.audi.app.navi.evo.addressinput.country.CountryInputModelAccess;
import de.audi.app.navi.evo.addressinput.housenumber.HousenumberSpellerInputModelAccess;
import de.audi.app.navi.evo.addressinput.junction.JunctionInputModelAccess;
import de.audi.app.navi.evo.di.AbstractAddressInputManagerEvo;
import de.audi.app.navi.evo.di.DIScreensEvo;
import de.audi.app.navi.evo.di.nar.AddressInputManagerNAR$1;
import de.audi.app.navi.evo.di.nar.listeners.AddressInputCityZipScreenListenerNAR;
import de.audi.app.navi.evo.di.nar.listeners.AddressInputCountryStateScreenListenerNAR;
import de.audi.app.navi.evo.di.nar.listeners.AddressInputHousenumberScreenListenerNAR;
import de.audi.app.navi.evo.di.nar.listeners.AddressInputIntersectionScreenListenerNAR;
import de.audi.app.navi.evo.di.nar.listeners.AddressInputMainScreenListenerNAR;
import de.audi.app.navi.evo.di.nar.listeners.AddressInputRightDrawerListenerNAR;
import de.audi.app.navi.evo.di.nar.listeners.AddressInputStreetRefinementScreenListenerNAR;
import de.audi.app.navi.evo.di.nar.listeners.AddressInputStreetScreenListenerNAR;
import de.audi.app.navi.evo.di.nar.models.AddressInputCityZipRefinementModelAccessNAR;
import de.audi.app.navi.evo.di.nar.models.AddressInputMainScreenModelAccessNAR;
import de.audi.app.navi.evo.di.nar.models.AddressInputStreetModelAccessNAR;
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
import de.audi.tghu.navi.app.addressinput.commands.SetHistoryContextWithCurrentLDCommand;
import de.audi.tghu.navi.app.addressinput.commands.SetStreetForCityHistoryCommand;
import de.audi.tghu.navi.app.addressinput.commands.UpdateAddressInputFormScreenModelsCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.LIRestoreStateCommand;
import de.audi.tghu.navi.app.di.IAddressInputMainScreenListener;
import de.audi.tghu.navi.app.di.IAddressInputWorkFlowManager;
import de.audi.tghu.navi.app.di.sequences.freetextspeller.AddressInputHousenumberFreetextSequence;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputCityZipSequenceNAR;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputCountrySequence;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputJunctionSequence;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputStreetSequenceNAR;
import de.audi.tghu.navi.app.di.sequences.nospeller.AddressInputMainScreenSequenceNAR;
import de.audi.tghu.navi.app.di.sequences.nospeller.AddressInputRefineByAssociationSequence;
import de.audi.tghu.navi.app.favorite.INaviFavoriteHandler;
import de.audi.tghu.navi.app.guidance.IVehicle;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.li.SpellerStack$StackElement;
import de.audi.tghu.navi.app.map.MapInterface;
import de.audi.tghu.navi.app.navlocationextractor.AsyncNavLocationExtractor;
import de.audi.tghu.navi.app.routeguidance.IRouteManager;
import de.audi.tghu.navi.app.routeguidance.IStartGuidanceToDestinationSequence;
import de.audi.tghu.navi.app.util.LocationFormatter;
import org.dsi.ifc.global.NavLocation;

public class AddressInputManagerNAR
extends AbstractAddressInputManagerEvo {
    private AddressInputMainScreenListenerNAR mainScreenListener;
    private AddressInputCountryStateScreenListenerNAR countryScreenListener;
    private AddressInputStreetScreenListenerNAR streetScreenListener;
    private AddressInputCityZipScreenListenerNAR cityZipScreenListener;
    private AddressInputHousenumberScreenListenerNAR housenumberScreenListener;
    private AddressInputIntersectionScreenListenerNAR intersectionScreenListener;
    private AddressInputRightDrawerListenerNAR rightDrawerListener;
    private AddressInputStreetRefinementScreenListenerNAR streetRefinementScreenListener;

    public AddressInputManagerNAR(NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory, IAddressInputWorkFlowManager iAddressInputWorkFlowManager, SpellerStack spellerStack, IPreviewMap iPreviewMap, IStartGuidanceToDestinationSequence iStartGuidanceToDestinationSequence, IVehicle iVehicle, LocationSerializer locationSerializer, IRouteManager iRouteManager, CityHistory cityHistory, NaviADBHandler naviADBHandler, INaviFavoriteHandler iNaviFavoriteHandler, AsyncNavLocationExtractor asyncNavLocationExtractor, ADBInterAppService aDBInterAppService, HomeAddressHandler homeAddressHandler, MapInterface mapInterface, AsyncNavLocationExtractor asyncNavLocationExtractor2, IAddressInputFormModelAccessHelper iAddressInputFormModelAccessHelper, HomeAddressHandler homeAddressHandler2) {
        super(navigationEnv, iCommandListFactory, iAddressInputWorkFlowManager, spellerStack, iPreviewMap, iStartGuidanceToDestinationSequence, iVehicle, locationSerializer, iRouteManager, cityHistory, naviADBHandler, iNaviFavoriteHandler, asyncNavLocationExtractor, aDBInterAppService, homeAddressHandler, mapInterface, asyncNavLocationExtractor2, iAddressInputFormModelAccessHelper, homeAddressHandler2);
    }

    @Override
    protected void initListeners() {
        this.mainScreenListener = this.initMainScreenListener();
        this.countryScreenListener = this.initCountryScreenListener();
        this.cityZipScreenListener = this.initCityZipScreenListener();
        this.streetScreenListener = this.initStreetScreenListener();
        this.streetRefinementScreenListener = this.initStreetRefinementScreenListener();
        this.housenumberScreenListener = this.initHousenumberScreenListener();
        this.intersectionScreenListener = this.initIntersectionScreenListener();
        this.rightDrawerListener = this.initRightDrawerListener();
    }

    private AddressInputMainScreenListenerNAR initMainScreenListener() {
        AddressInputMainScreenModelAccessNAR addressInputMainScreenModelAccessNAR = new AddressInputMainScreenModelAccessNAR(this.env, this.modelAccessHelper);
        AddressInputMainScreenSequenceNAR addressInputMainScreenSequenceNAR = new AddressInputMainScreenSequenceNAR(this.commandListFactory, this.env, this.startRouteGuidanceSequence, addressInputMainScreenModelAccessNAR, this.previewMap, this.spellerStack, this, null);
        return new AddressInputMainScreenListenerNAR(this.env, this.previewMap, this.commandListFactory, this, addressInputMainScreenSequenceNAR, this.routeManager, this.adbInterAppService, this.homeAddressHandler);
    }

    private AddressInputStreetScreenListenerNAR initStreetScreenListener() {
        AddressInputStreetModelAccessNAR addressInputStreetModelAccessNAR = new AddressInputStreetModelAccessNAR(this.env, DIScreensEvo.getDiNarStreetScreenMatchSpellerModel(), DIScreensEvo.getDiNarStreetScreenTiledListModel(), this.modelAccessHelper, this.cityHistory, this.spellerStack);
        AddressInputStreetSequenceNAR addressInputStreetSequenceNAR = new AddressInputStreetSequenceNAR(this.commandListFactory, this.env, addressInputStreetModelAccessNAR, this.previewMap, this.spellerStack, this);
        return new AddressInputStreetScreenListenerNAR(this.env, this.previewMap, this.commandListFactory, this, addressInputStreetSequenceNAR);
    }

    private AddressInputStreetRefinementScreenListenerNAR initStreetRefinementScreenListener() {
        AddressInputCityZipRefinementModelAccessNAR addressInputCityZipRefinementModelAccessNAR = new AddressInputCityZipRefinementModelAccessNAR(this.env, this.modelAccessHelper, DIScreensEvo.getDiNarStreetRefinementScreenTiledListModel());
        AddressInputRefineByAssociationSequence addressInputRefineByAssociationSequence = new AddressInputRefineByAssociationSequence(127, this, this.commandListFactory, this.env, addressInputCityZipRefinementModelAccessNAR, this.previewMap, this.spellerStack);
        AddressInputStreetRefinementScreenListenerNAR addressInputStreetRefinementScreenListenerNAR = new AddressInputStreetRefinementScreenListenerNAR(this.env, this.previewMap, this.commandListFactory, this, addressInputRefineByAssociationSequence);
        return addressInputStreetRefinementScreenListenerNAR;
    }

    private AddressInputCityZipScreenListenerNAR initCityZipScreenListener() {
        CityZipInputModelAccess cityZipInputModelAccess = new CityZipInputModelAccess(this.env, DIScreensEvo.getDiNarCityZipScreenMatchSpellerModel(), DIScreensEvo.getDiNarCityZipScreenTiledListModel(), this.cityHistory, this.modelAccessHelper);
        AddressInputCityZipSequenceNAR addressInputCityZipSequenceNAR = new AddressInputCityZipSequenceNAR(this.commandListFactory, this.env, cityZipInputModelAccess, this.previewMap, this.spellerStack, this, this.cityHistory);
        AddressInputCityZipScreenListenerNAR addressInputCityZipScreenListenerNAR = new AddressInputCityZipScreenListenerNAR(this.env, this.previewMap, this.commandListFactory, this, addressInputCityZipSequenceNAR);
        return addressInputCityZipScreenListenerNAR;
    }

    private AddressInputCountryStateScreenListenerNAR initCountryScreenListener() {
        CountryInputModelAccess countryInputModelAccess = new CountryInputModelAccess(this.env, DIScreensEvo.getDiNarCountryScreenMatchSpellerModel(), DIScreensEvo.getDiNarCountryScreenTiledListModel(), this.modelAccessHelper);
        AddressInputCountrySequence addressInputCountrySequence = new AddressInputCountrySequence(this.commandListFactory, this.env, countryInputModelAccess, this.previewMap, this.spellerStack, this);
        return new AddressInputCountryStateScreenListenerNAR(this.env, this.previewMap, this.commandListFactory, this, addressInputCountrySequence);
    }

    private AddressInputHousenumberScreenListenerNAR initHousenumberScreenListener() {
        HousenumberSpellerInputModelAccess housenumberSpellerInputModelAccess = new HousenumberSpellerInputModelAccess(this.env, DIScreensEvo.getDiNarHousenumberScreenSpellerModel(), DIScreensEvo.getDiNarHousenumberScreenTiledListModel(), this, this.modelAccessHelper);
        AddressInputHousenumberFreetextSequence addressInputHousenumberFreetextSequence = new AddressInputHousenumberFreetextSequence(this.commandListFactory, housenumberSpellerInputModelAccess, this.previewMap, this);
        AddressInputHousenumberScreenListenerNAR addressInputHousenumberScreenListenerNAR = new AddressInputHousenumberScreenListenerNAR(this.env, this.previewMap, this.commandListFactory, this, addressInputHousenumberFreetextSequence);
        return addressInputHousenumberScreenListenerNAR;
    }

    private AddressInputIntersectionScreenListenerNAR initIntersectionScreenListener() {
        JunctionInputModelAccess junctionInputModelAccess = new JunctionInputModelAccess(this.env, DIScreensEvo.getDiNarIntersectionScreenMatchSpellerModel(), DIScreensEvo.getDiNarIntersectionScreenTiledListModel(), this.modelAccessHelper);
        AddressInputJunctionSequence addressInputJunctionSequence = new AddressInputJunctionSequence(this.commandListFactory, this.env, junctionInputModelAccess, this.previewMap, this.spellerStack, this);
        AddressInputIntersectionScreenListenerNAR addressInputIntersectionScreenListenerNAR = new AddressInputIntersectionScreenListenerNAR(this.env, this.previewMap, this.commandListFactory, addressInputJunctionSequence, this);
        return addressInputIntersectionScreenListenerNAR;
    }

    private AddressInputRightDrawerListenerNAR initRightDrawerListener() {
        AddressInputRightDrawerListenerNAR addressInputRightDrawerListenerNAR = new AddressInputRightDrawerListenerNAR(this.env, this.previewMap, this.commandListFactory, this, this.mapInterface, this.asyncLiValueListNavLocationExctractor, this.asyncLiCityStateStreetHistoryListNavLocationExtractor, this.mainScreenListener);
        return addressInputRightDrawerListenerNAR;
    }

    @Override
    public int getAutoSelectLeftElementEventId() {
        return 30204;
    }

    @Override
    public IAddressInputMainScreenListener getMainScreenListener() {
        return this.mainScreenListener;
    }

    public AddressInputCountryStateScreenListenerNAR getCountryScreenListener() {
        return this.countryScreenListener;
    }

    public AddressInputStreetScreenListenerNAR getStreetScreenListener() {
        return this.streetScreenListener;
    }

    public AddressInputCityZipScreenListenerNAR getCityZipScreenListener() {
        return this.cityZipScreenListener;
    }

    public AddressInputHousenumberScreenListenerNAR getHousenumberScreenListener() {
        return this.housenumberScreenListener;
    }

    public AddressInputIntersectionScreenListenerNAR getIntersectionScreenListener() {
        return this.intersectionScreenListener;
    }

    public AddressInputRightDrawerListenerNAR getRightDrawerListener() {
        return this.rightDrawerListener;
    }

    public AddressInputStreetRefinementScreenListenerNAR getStreetRefinementScreenListener() {
        return this.streetRefinementScreenListener;
    }

    @Override
    public void start(NavLocation navLocation) {
        if (!this.addressInputCommandListMonitor.isActive()) {
            this.logChannel.log(-2137614336, "%1#start with navLocation=%2", (Object)this.CLASS_NAME, (Object)LocationFormatter.formatLocationShort(navLocation));
            CommandList commandList = this.commandListFactory.createCommandList();
            commandList.addMonitor(this.addressInputCommandListMonitor);
            if (navLocation != null) {
                commandList.put("startMainScreenNavLocation", navLocation);
            }
            if (this.inputModeManager.getInputMode() == 0) {
                if (this.env.getContainer().isRgActive()) {
                    this.logChannel.log(-2137614336, "%1#start - was started without strip because rgIsActive", (Object)this.CLASS_NAME);
                    this.executeAddressInputEvent(commandList, 30016);
                } else {
                    this.logChannel.log(-2137614336, "%1#start -  was started with strip rg is not active", (Object)this.CLASS_NAME);
                    this.executeAddressInputEvent(commandList, 30007);
                }
            } else {
                this.logChannel.log(-2137614336, "%1#start - was started without strip because the navigationMode is = %2", (Object)this.CLASS_NAME, (long)this.inputModeManager.getInputMode());
                this.executeAddressInputEvent(commandList, 30016);
            }
        } else {
            this.logChannel.log(-2137614336, "%1#start - the command list to start address input is still running - ignoring further calls.", (Object)this.CLASS_NAME);
        }
    }

    @Override
    public void startWithoutStrip(NavLocation navLocation) {
        this.logChannel.log(-2137614336, "%1#startWithoutStrip", (Object)this.CLASS_NAME);
        CommandList commandList = this.commandListFactory.createCommandList();
        if (navLocation != null) {
            commandList.put("startMainScreenNavLocation", navLocation);
        }
        this.logChannel.log(-2137614336, "%1#startWithoutStrip - was startet without strip because the navigationMode is = %2", (Object)this.CLASS_NAME, (long)this.inputModeManager.getInputMode());
        this.executeAddressInputEvent(commandList, 30016);
    }

    @Override
    public int getStreetScreenAmbiguousListElementSelecteEventId() {
        return 30304;
    }

    @Override
    public int getStreetScreenNonAmbiguousListElementSelectedEventId() {
        return 30303;
    }

    @Override
    public int getStartForOnlineEventId() {
        return 30014;
    }

    @Override
    public int getStartForRemoteHMIEventId() {
        return 30017;
    }

    @Override
    public int getStartCityInputFromMainScreenEventId() {
        return 30003;
    }

    @Override
    public void destAddressInputHKReturn(int n, int n2, Command command, Command command2) {
        this.logChannel.log(-2137614336, "%1#destAddressInputHKReturn() - called with removeHandler=%2", (Object)this.CLASS_NAME, (long)n2);
        SpellerStack$StackElement spellerStack$StackElement = this.spellerStack.pop();
        if (spellerStack$StackElement != null) {
            this.logChannel.log(-2137614336, "%1#addressInputHKReturn element popped from speller stack=%2", (Object)this.CLASS_NAME, (Object)spellerStack$StackElement);
            CommandList commandList = this.commandListFactory.createCommandList();
            commandList.add(new LIRestoreStateCommand(spellerStack$StackElement));
            if (this.spellerStack.getActiveSC() != null) {
                if (this.needsRestoreStreetForCity()) {
                    commandList.add(new SetStreetForCityHistoryCommand());
                }
                if (this.spellerStack.isActiveSpellerContextIDEqual(57) && spellerStack$StackElement.sc.getContextID() == 65) {
                    this.logChannel.log(-2137614336, "%1#destAddressInputHKReturn() - HK_BACK from STREET_FIRST identified --> setHistoryContextWithCurrentLD will be added to commandList to restore CityHistory", (Object)this.CLASS_NAME);
                    commandList.add(new SetHistoryContextWithCurrentLDCommand());
                }
            }
            commandList.add(new AddressInputManagerNAR$1(this, new StringBuffer().append(this.CLASS_NAME).append("#destAddressInputHKReturn - Show or Hide Preview Map").toString()));
            commandList.add(new UpdateAddressInputFormScreenModelsCommand(this.modelAccessHelper));
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

    private boolean needsRestoreStreetForCity() {
        return this.spellerStack.getActiveSC().getContextID() == 66 || this.spellerStack.getActiveSC().getContextID() == 88 && this.spellerStack.containsContextID(65);
    }

    static /* synthetic */ IPreviewMap access$000(AddressInputManagerNAR addressInputManagerNAR) {
        return addressInputManagerNAR.previewMap;
    }

    static /* synthetic */ IPreviewMap access$100(AddressInputManagerNAR addressInputManagerNAR) {
        return addressInputManagerNAR.previewMap;
    }
}

