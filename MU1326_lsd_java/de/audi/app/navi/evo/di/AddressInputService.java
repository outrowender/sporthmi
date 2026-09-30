/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di;

import de.audi.app.navi.evo.addressinput.AddressInputFormModelAccessHelperCN;
import de.audi.app.navi.evo.addressinput.AddressInputFormModelAccessHelperEU;
import de.audi.app.navi.evo.addressinput.AddressInputFormModelAccessHelperJP;
import de.audi.app.navi.evo.addressinput.AddressInputFormModelAccessHelperKR;
import de.audi.app.navi.evo.addressinput.AddressInputFormModelAccessHelperNAR;
import de.audi.app.navi.evo.addressinput.poi.models.GuiModelAccessDetailsLocationPoi;
import de.audi.app.navi.evo.addressinput.sds.AddressInputSDSForm;
import de.audi.app.navi.evo.addressinput.sds.AddressInputSDSFormCN;
import de.audi.app.navi.evo.addressinput.sds.AddressInputSDSFormJP;
import de.audi.app.navi.evo.addressinput.sds.AddressInputSDSFormKR;
import de.audi.app.navi.evo.addressinput.sds.AddressInputSDSFormNAR;
import de.audi.app.navi.evo.di.cn.AddressInputManagerCN;
import de.audi.app.navi.evo.di.cn.AddressInputWorkFlowManagerCN;
import de.audi.app.navi.evo.di.eu.AddressInputManagerEU;
import de.audi.app.navi.evo.di.eu.AddressInputWorkFlowManagerEU;
import de.audi.app.navi.evo.di.jp.AddressInputManagerJP;
import de.audi.app.navi.evo.di.jp.AddressInputWorkFlowManagerJP;
import de.audi.app.navi.evo.di.kr.AddressInputManagerKR;
import de.audi.app.navi.evo.di.kr.AddressInputWorkFlowManagerKR;
import de.audi.app.navi.evo.di.nar.AddressInputManagerNAR;
import de.audi.app.navi.evo.di.nar.AddressInputWorkFlowManagerNAR;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.ADBInterAppService;
import de.audi.tghu.navi.app.CityHistory;
import de.audi.tghu.navi.app.HomeAddressHandler;
import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.LocationSerializer;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.adb.NaviADBHandler;
import de.audi.tghu.navi.app.addressinput.IAddressInputForm;
import de.audi.tghu.navi.app.details.IDetailsHMIListener;
import de.audi.tghu.navi.app.di.AbstractAddressInputService;
import de.audi.tghu.navi.app.di.sequences.disambiguation.ILocationDisambiguatorPopupHandler;
import de.audi.tghu.navi.app.di.sequences.disambiguation.ILocationDisambiguatorSequence;
import de.audi.tghu.navi.app.favorite.INaviFavoriteHandler;
import de.audi.tghu.navi.app.guidance.IVehicle;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.map.MapInterface;
import de.audi.tghu.navi.app.navlocationextractor.AsyncNavLocationExtractor;
import de.audi.tghu.navi.app.navobserver.NullNavObserverRegistry;
import de.audi.tghu.navi.app.routeguidance.IRouteManager;
import de.audi.tghu.navi.app.routeguidance.IStartGuidanceToDestinationSequence;
import de.audi.tghu.navi.app.util.Util;

public class AddressInputService
extends AbstractAddressInputService {
    public AddressInputService(NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory, SpellerStack spellerStack, IPreviewMap iPreviewMap, IStartGuidanceToDestinationSequence iStartGuidanceToDestinationSequence, IVehicle iVehicle, LocationSerializer locationSerializer, IRouteManager iRouteManager, CityHistory cityHistory, NaviADBHandler naviADBHandler, INaviFavoriteHandler iNaviFavoriteHandler, AsyncNavLocationExtractor asyncNavLocationExtractor, ADBInterAppService aDBInterAppService, HomeAddressHandler homeAddressHandler, MapInterface mapInterface, AsyncNavLocationExtractor asyncNavLocationExtractor2, IDetailsHMIListener iDetailsHMIListener, IconHandler iconHandler, HomeAddressHandler homeAddressHandler2, ILocationDisambiguatorSequence iLocationDisambiguatorSequence, ILocationDisambiguatorPopupHandler iLocationDisambiguatorPopupHandler) {
        super(navigationEnv, iCommandListFactory, spellerStack, iPreviewMap, iStartGuidanceToDestinationSequence, iVehicle, locationSerializer, iRouteManager, cityHistory, naviADBHandler, iNaviFavoriteHandler, asyncNavLocationExtractor, aDBInterAppService, homeAddressHandler, mapInterface, asyncNavLocationExtractor2, iconHandler, iDetailsHMIListener, homeAddressHandler2, iLocationDisambiguatorSequence, iLocationDisambiguatorPopupHandler, new NullNavObserverRegistry());
    }

    protected final void initAddressInput() {
        if (Util.isHURegionEU()) {
            this.modelAccessHelper = new AddressInputFormModelAccessHelperEU(this.env);
            this.workFlowManager = new AddressInputWorkFlowManagerEU(this.env, this.commandListFactory, this.spellerStack);
            this.inputManager = new AddressInputManagerEU(this.env, this.commandListFactory, this.workFlowManager, this.spellerStack, this.previewMap, this.startRouteGuidanceSequence, this.vehicle, this.locationSerializer, this.routeManager, this.cityHistory, this.adbHandler, this.naviFavoriteHandler, this.asyncLiValueListNavLocationExctractor, this.adbInterAppService, this.homeAddressHandler, this.mapInterface, this.asyncLiCityHistoryListNavLocationExtractor, this.modelAccessHelper, this.officeAddressHandler);
            this.startAddressInputWFMId = 7;
            this.addressInputSDSForm = new AddressInputSDSForm((IAddressInputForm)this, this.env.getSDSLogChannel(), this.commandListFactory, this.spellerStack, this.cityHistory, this.env, this.previewMap, new GuiModelAccessDetailsLocationPoi(this.env, this.iconHandler, this.detailsHMIListener.getDestinationHandler()), this.modelAccessHelper);
        } else if (Util.isHURegionNAR()) {
            this.modelAccessHelper = new AddressInputFormModelAccessHelperNAR(this.env);
            this.workFlowManager = new AddressInputWorkFlowManagerNAR(this.env, this.commandListFactory, this.spellerStack, this.cityHistory);
            this.inputManager = new AddressInputManagerNAR(this.env, this.commandListFactory, this.workFlowManager, this.spellerStack, this.previewMap, this.startRouteGuidanceSequence, this.vehicle, this.locationSerializer, this.routeManager, this.cityHistory, this.adbHandler, this.naviFavoriteHandler, this.asyncLiValueListNavLocationExctractor, this.adbInterAppService, this.homeAddressHandler, this.mapInterface, this.asyncLiCityHistoryListNavLocationExtractor, this.modelAccessHelper, this.officeAddressHandler);
            this.workFlowManager.setAddressInputManager(this.inputManager);
            this.startAddressInputWFMId = 30007;
            this.addressInputSDSForm = new AddressInputSDSFormNAR((IAddressInputForm)this, this.env.getSDSLogChannel(), this.commandListFactory, this.spellerStack, this.cityHistory, this.env, this.previewMap, new GuiModelAccessDetailsLocationPoi(this.env, this.iconHandler, this.detailsHMIListener.getDestinationHandler()), this.modelAccessHelper);
        } else if (Util.isHURegionCN() || Util.isHURegionTW()) {
            this.modelAccessHelper = new AddressInputFormModelAccessHelperCN(this.env);
            this.workFlowManager = new AddressInputWorkFlowManagerCN(this.env, this.commandListFactory, this.spellerStack);
            this.inputManager = new AddressInputManagerCN(this.env, this.commandListFactory, this.workFlowManager, this.spellerStack, this.previewMap, this.startRouteGuidanceSequence, this.vehicle, this.locationSerializer, this.routeManager, this.cityHistory, this.adbHandler, this.naviFavoriteHandler, this.asyncLiValueListNavLocationExctractor, this.adbInterAppService, this.homeAddressHandler, this.mapInterface, this.asyncLiCityHistoryListNavLocationExtractor, this.modelAccessHelper, this.officeAddressHandler);
            this.startAddressInputWFMId = 10008;
            this.addressInputSDSForm = new AddressInputSDSFormCN((IAddressInputForm)this, this.env.getSDSLogChannel(), this.commandListFactory, this.spellerStack, this.cityHistory, this.env, this.previewMap, new GuiModelAccessDetailsLocationPoi(this.env, this.iconHandler, this.detailsHMIListener.getDestinationHandler()), this.modelAccessHelper);
        } else if (Util.isHURegionJP()) {
            this.modelAccessHelper = new AddressInputFormModelAccessHelperJP(this.env);
            this.workFlowManager = new AddressInputWorkFlowManagerJP(this.env, this.commandListFactory, this.spellerStack);
            this.inputManager = new AddressInputManagerJP(this.env, this.commandListFactory, this.workFlowManager, this.spellerStack, this.previewMap, this.startRouteGuidanceSequence, this.vehicle, this.locationSerializer, this.routeManager, this.cityHistory, this.adbHandler, this.naviFavoriteHandler, this.asyncLiValueListNavLocationExctractor, this.adbInterAppService, this.homeAddressHandler, this.mapInterface, this.asyncLiCityHistoryListNavLocationExtractor, this.modelAccessHelper, this.officeAddressHandler);
            this.startAddressInputWFMId = 20012;
            this.addressInputSDSForm = new AddressInputSDSFormJP(this, this.env.getSDSLogChannel(), this.commandListFactory, this.spellerStack, this.cityHistory, this.env, this.previewMap, new GuiModelAccessDetailsLocationPoi(this.env, this.iconHandler, this.detailsHMIListener.getDestinationHandler()), this.modelAccessHelper, this.startRouteGuidanceSequence, this.disambiguationSequence, this.popupHandler, this.detailsHMIListener);
        } else if (Util.isHURegionKR()) {
            this.modelAccessHelper = new AddressInputFormModelAccessHelperKR(this.env);
            this.workFlowManager = new AddressInputWorkFlowManagerKR(this.env, this.commandListFactory, this.spellerStack);
            this.inputManager = new AddressInputManagerKR(this.env, this.commandListFactory, this.workFlowManager, this.spellerStack, this.previewMap, this.startRouteGuidanceSequence, this.vehicle, this.locationSerializer, this.routeManager, this.cityHistory, this.adbHandler, this.naviFavoriteHandler, this.asyncLiValueListNavLocationExctractor, this.adbInterAppService, this.homeAddressHandler, this.mapInterface, this.asyncLiCityHistoryListNavLocationExtractor, this.modelAccessHelper, this.officeAddressHandler);
            this.startAddressInputWFMId = 40012;
            this.addressInputSDSForm = new AddressInputSDSFormKR(this, this.env.getSDSLogChannel(), this.commandListFactory, this.spellerStack, this.cityHistory, this.env, this.previewMap, new GuiModelAccessDetailsLocationPoi(this.env, this.iconHandler, this.detailsHMIListener.getDestinationHandler()), this.modelAccessHelper, this.vehicle, this.startRouteGuidanceSequence, this.iconHandler, this.routeManager, this.detailsHMIListener);
        } else if (Util.isHURegionRdW()) {
            this.modelAccessHelper = new AddressInputFormModelAccessHelperEU(this.env);
            this.workFlowManager = new AddressInputWorkFlowManagerEU(this.env, this.commandListFactory, this.spellerStack);
            this.inputManager = new AddressInputManagerEU(this.env, this.commandListFactory, this.workFlowManager, this.spellerStack, this.previewMap, this.startRouteGuidanceSequence, this.vehicle, this.locationSerializer, this.routeManager, this.cityHistory, this.adbHandler, this.naviFavoriteHandler, this.asyncLiValueListNavLocationExctractor, this.adbInterAppService, this.homeAddressHandler, this.mapInterface, this.asyncLiCityHistoryListNavLocationExtractor, this.modelAccessHelper, this.officeAddressHandler);
            this.startAddressInputWFMId = 7;
            this.addressInputSDSForm = new AddressInputSDSForm((IAddressInputForm)this, this.env.getSDSLogChannel(), this.commandListFactory, this.spellerStack, this.cityHistory, this.env, this.previewMap, new GuiModelAccessDetailsLocationPoi(this.env, this.iconHandler, this.detailsHMIListener.getDestinationHandler()), this.modelAccessHelper);
        } else {
            this.modelAccessHelper = new AddressInputFormModelAccessHelperEU(this.env);
            this.workFlowManager = new AddressInputWorkFlowManagerEU(this.env, this.commandListFactory, this.spellerStack);
            this.inputManager = new AddressInputManagerEU(this.env, this.commandListFactory, this.workFlowManager, this.spellerStack, this.previewMap, this.startRouteGuidanceSequence, this.vehicle, this.locationSerializer, this.routeManager, this.cityHistory, this.adbHandler, this.naviFavoriteHandler, this.asyncLiValueListNavLocationExctractor, this.adbInterAppService, this.homeAddressHandler, this.mapInterface, this.asyncLiCityHistoryListNavLocationExtractor, this.modelAccessHelper, this.officeAddressHandler);
            this.startAddressInputWFMId = 7;
            this.addressInputSDSForm = new AddressInputSDSForm((IAddressInputForm)this, this.env.getSDSLogChannel(), this.commandListFactory, this.spellerStack, this.cityHistory, this.env, this.previewMap, new GuiModelAccessDetailsLocationPoi(this.env, this.iconHandler, this.detailsHMIListener.getDestinationHandler()), this.modelAccessHelper);
        }
        if (this.workFlowManager != null && this.inputManager != null) {
            this.workFlowManager.setAddressInputManager(this.inputManager);
        }
    }
}

