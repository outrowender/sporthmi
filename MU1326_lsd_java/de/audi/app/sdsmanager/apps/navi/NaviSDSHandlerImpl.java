/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.navi;

import de.audi.app.sdsmanager.SDSManagerBaseActivator;
import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.apps.AbstractSDSApplication;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSAppFactory;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.navi.NaviSDSHandler;
import de.audi.app.sdsmanager.apps.navi.NaviSDSPOIOnlineServiceListenerImpl;
import de.audi.app.sdsmanager.apps.navi.NaviSDSPicklistListener;
import de.audi.app.sdsmanager.apps.navi.NaviSDSTrufflesHistoryHelper;
import de.audi.app.sdsmanager.apps.navi.NaviSDSUtils;
import de.audi.app.sdsmanager.apps.navi.NaviServiceListenerImpl;
import de.audi.app.sdsmanager.apps.navi.commands.NaviAddDestinationCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviAddressInputCorrectionCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviAddressInputCursorCorrectionCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviAddressInputCursorSetCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviAlternativeRouteCalcCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviAlternativeRouteNumberSetCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviBlockRouteSetNLUCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviBlockRouteValueSetCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviCheckBetterRouteCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviCheckRouteGuidanceCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviDestinationAvailableAsiaCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviDestinationAvailableCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviDestinationDeleteCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviDestinationGetCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviDestinationSetCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviDestinationStatusCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviDetailsPhoneCallCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviEnterGeoCoordinatesCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviEnterPoiNameSearchCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviEnterRubberbandCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviFavoriteDestinationSetCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviFillPromptLabelsCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviFurtherInputPossibleCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviGetInfoCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviGetTpegPOIResultsByCategoryCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviGuidanceStartCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviGuidanceStopCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviHomeSaveCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviHomeSetCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviHouseNumberCheckCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviHouseNumberResolveCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviHouseNumberSetCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviHousenumberJPKRValidate;
import de.audi.app.sdsmanager.apps.navi.commands.NaviInputModeCheckCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviInputStartedCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviIntelliDestinationSetCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviLastDestinationSetCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviListHideCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviListLineDataGetCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviListShowCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviMapCodeAddCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviMapCodeDeleteCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviMapCodeGetCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviMapCodeNavigableCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviMapCodeResolveCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviMapOptionsSetCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviMapZoomCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviMyAudiContactSelectCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviOneshotAmbiguousCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviOneshotFilterPicklistCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviOneshotStoreDataCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviOperatorcallCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviPOICorrectionCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviPOIHistoryEntryUniqueCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviPOIOneshotAmbiguousCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviPOIOneshotFilterPicklistCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviPOIOnlineDidYouMeanCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviPOIOnlineRecogCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviPOIOnlineSearchAreaSetCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviPOIOnlineSearchCancelCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviPOIOnlineSearchInitCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviPOIOnlineSelectDestinationCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviPOIOnlineShowListCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviPOIOnlineUniqueResultCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviPOIPromptLabelSetCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviPOISearchAreaSetCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviPOIShortCutSetCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviPOIValueSetCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviPhoneNumberAddCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviPhoneNumberDeleteCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviPhoneNumberGetCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviPostCodeCheckCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviRouteInfosSetCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviRouteOptionsSetCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviSUITypeGetCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviSelectTpegPOIResultCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviSetBypassRouteCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviSimpleMapAreaSetCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviSimpleMapFreeSelectionInitCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviSpeedLimitGetCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviSpellingModeCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviSpellingModeCorrectionCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviStartTpegPOICommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviSynchronizeCountryCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviTriggerTpegPOIReturnCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviTrufflesCancelSearchCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviTrufflesCorrectionCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviTrufflesEndCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviTrufflesSearchDestinationCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviTrufflesSearchPreviousDestinationCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviVDEOneshotAmbiguousCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviVDEOneshotFilterPicklistCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviVoiceGuidanceSetCommand;
import de.audi.app.sdsmanager.apps.navi.commands.SystemTruffleSetCommand;
import de.audi.app.sdsmanager.common.ISDSPopupHelper;
import de.audi.app.sdsmanager.common.Logger;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.dsi.SpeechRecognitionHandler;
import de.audi.app.sdsmanager.grammar.DynamicSlotContent;
import de.audi.app.sdsmanager.grammar.IDynamicLists;
import de.audi.app.sdsmanager.grammar.ITTSASR;
import de.audi.app.sdsmanager.nbest.IPicklist;
import de.audi.app.sdsmanager.nbest.IPicklistElement;
import de.audi.app.sdsmanager.nbest.IPicklistSlot;
import de.audi.app.sdsmanager.nbest.NBestStorageAccess;
import de.audi.app.sdsmanager.oneshot.NaviOneshotHandler;
import de.audi.app.sdsmanager.oneshot.OneshotHandler;
import de.audi.app.sdsmanager.oneshot.OneshotHandlerFactory;
import de.audi.app.sdsmanager.syscall.ISystemCallParameter;
import de.audi.app.sdsmanager.syscall.SystemCall;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.i18n.ILanguageManager;
import de.audi.atip.interapp.ADBSDSService;
import de.audi.atip.interapp.AppInfoKrService;
import de.audi.atip.interapp.AppInfoKrServiceListener;
import de.audi.atip.interapp.MapService;
import de.audi.atip.interapp.MapServiceListener;
import de.audi.atip.interapp.NaviSDSPOIOnlineService;
import de.audi.atip.interapp.NaviSDSPOIOnlineServiceListener;
import de.audi.atip.interapp.NaviService;
import de.audi.atip.interapp.NaviServiceListener;
import de.audi.atip.interapp.NullADBSDSService;
import de.audi.atip.interapp.SDSListEntry;
import de.audi.atip.interapp.def.NullAppInfoKrService;
import de.audi.atip.interapp.def.NullMapService;
import de.audi.atip.interapp.def.NullNaviService;
import de.audi.atip.interapp.def.NullOnlineDestinationService;
import de.audi.atip.interapp.def.NullOperatorCallSDSService;
import de.audi.atip.interapp.def.NullPOIOnlineService;
import de.audi.atip.interapp.def.NullSDSMyAudiService;
import de.audi.atip.interapp.online.IOnlineDestinationService;
import de.audi.atip.interapp.online.IOnlineSDSMyAudiService;
import de.audi.atip.interapp.online.IOperatorCallSDSService;
import de.audi.atip.interapp.online.IOperatorCallSDSServiceListener;
import de.audi.atip.log.LogChannel;
import de.audi.atip.statemachine.sds.ITTSASRContext;
import de.audi.atip.sysapp.carcoding.CarFuncAdap;
import de.audi.tghu.command.CommandList;
import de.esolutions.fw.util.commons.Buffer;
import java.util.HashMap;
import java.util.Map;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.speechrec.NBestList;
import org.dsi.ifc.speechrec.VDECapabilities;

public class NaviSDSHandlerImpl
extends AbstractSDSApplication
implements NaviSDSHandler,
MapServiceListener,
IOperatorCallSDSServiceListener,
AppInfoKrServiceListener {
    private static int[] commands = new int[]{40062, 40063, 40015, 40078, 40001, 40074, 40013, 40011, 40004, 40003, 40005, 40007, 40010, 40009, 40076, 40065, 40079, 40021, 40060, 40061, 40059, 40020, 40018, 40019, 40086, 40023, 40024, 40071, 40066, 40026, 40053, 40028, 40029, 40031, 40070, 40073, 40072, 40068, 40069, 40033, 40034, 40040, 40032, 40043, 40045, 40044, 40046, 40064, 40042, 40049, 40077, 40051, 40052, 40075, 40050, 40067, 40055, 40057, 40056, 40080, 40081, 40082, 40083, 40084, 1060, 40085, 40087, 40088, 40089, 40090, 40091, 40092, 40106, 40107, 40093, 40094, 40095, 40096, 40097, 40098, 40105, 40099, 40100, 40101, 40102, 40103, 40104, 40108, 40109, 40110, 40111, 40112, 40113, 40114};
    private final LogChannel lc = Logger.getAppNaviLog();
    private final SDSAppFactory factory;
    private final OneshotHandlerFactory oneshotHandlerFactory;
    private NaviService naviService = new NullNaviService(this.lc);
    private ADBSDSService adbService = new NullADBSDSService(this.lc);
    private MapService mapService = new NullMapService(this.lc);
    private NaviSDSPOIOnlineService poiOnlineService = new NullPOIOnlineService(this.lc);
    private AppInfoKrService appInfoKrService = new NullAppInfoKrService(this.lc);
    private IOnlineSDSMyAudiService myAudiService = new NullSDSMyAudiService(this.lc);
    private IOperatorCallSDSService operatorCallService = new NullOperatorCallSDSService(this.lc);
    private final ILanguageManager languageManager;
    private final SpeechRecognitionHandler srHandler;
    private final ISDSPopupHelper sdsPopupHelper;
    private final HMIService hmi;
    private final NaviServiceListener naviServiceListener;
    private final NaviSDSPOIOnlineServiceListener poiOnlineServiceListener;
    private String[] pickListEntryNames = new String[0];
    private IPicklist initialEntryPicklist;
    private IPicklist entryPicklist;
    private SDSListEntry[] favoriteDestinations;
    private SDSListEntry[] lastDestinations;
    private SDSListEntry[] myAudiContacts;
    private final NaviService.OneshotData[] oneshotData = new NaviService.OneshotData[5];
    private byte pickListMode = (byte)-1;
    private boolean poiOnlineOneshotRecog;
    private NavLocation poiOnlineDestination;
    private boolean useAltRouteCalc = false;
    private byte addressInputMode = 0;
    private String currentCountryAbbreviation;
    private AdbEntry currentMyAudiContact;
    private IOnlineDestinationService onlineDestinationService;
    private final NaviSDSPicklistListener listListener;
    private ITTSASR ttsASR;
    private NaviOneshotHandler oneshotHandler = null;
    private byte ldcHandling = 0;
    private IPicklistSlot houseNumberSlot = null;
    private String currentTrufflesCountryAbbreviation;
    private NaviSDSTrufflesHistoryHelper naviTrufflesHist;
    private boolean aifCountryFlag = false;
    private IDynamicLists dynamicLists;
    private final Map simpleMapLists = new HashMap();

    public NaviSDSHandlerImpl(HMIService hMIService, SDSHandlerService sDSHandlerService, SDSAppFactory sDSAppFactory, NBestStorageAccess nBestStorageAccess, IDynamicLists iDynamicLists, SpeechRecognitionHandler speechRecognitionHandler, ILanguageManager iLanguageManager, ISDSPopupHelper iSDSPopupHelper, OneshotHandlerFactory oneshotHandlerFactory) {
        super(sDSHandlerService, nBestStorageAccess);
        this.hmi = hMIService;
        this.srHandler = speechRecognitionHandler;
        this.factory = sDSAppFactory;
        this.languageManager = iLanguageManager;
        this.sdsPopupHelper = iSDSPopupHelper;
        this.oneshotHandlerFactory = oneshotHandlerFactory;
        this.listListener = new NaviSDSPicklistListener(hMIService, this);
        this.naviServiceListener = new NaviServiceListenerImpl(this, iDynamicLists, iLanguageManager, sDSHandlerService.getFramework());
        this.poiOnlineServiceListener = new NaviSDSPOIOnlineServiceListenerImpl();
        this.checkVZEStatus();
        this.naviTrufflesHist = new NaviSDSTrufflesHistoryHelper(this.lc);
        this.dynamicLists = iDynamicLists;
        this.lc.log(10000000, "NaviSDSHandlerImpl#NaviSDSHandler initialized.");
    }

    public void setNaviService(NaviService naviService) {
        if (naviService != null) {
            this.naviService = naviService;
        }
    }

    public NaviService getNaviService() {
        return this.naviService;
    }

    public void setADBService(ADBSDSService aDBSDSService) {
        if (aDBSDSService == null) {
            return;
        }
        this.adbService = aDBSDSService;
    }

    public void setOperatorCallService(IOperatorCallSDSService iOperatorCallSDSService) {
        if (iOperatorCallSDSService == null) {
            return;
        }
        this.operatorCallService = iOperatorCallSDSService;
    }

    public IOperatorCallSDSService getOperatorCallService() {
        return this.operatorCallService;
    }

    public void unsetNaviService() {
        this.naviService = new NullNaviService(this.lc);
    }

    public void unsetADBService() {
        this.adbService = new NullADBSDSService(this.lc);
    }

    public void unsetOperatorCallService() {
        this.operatorCallService = new NullOperatorCallSDSService(this.lc);
    }

    public void setPOIOnlineService(NaviSDSPOIOnlineService naviSDSPOIOnlineService) {
        if (naviSDSPOIOnlineService != null) {
            this.poiOnlineService = naviSDSPOIOnlineService;
        }
    }

    public void unsetPOIOnlineService() {
        this.poiOnlineService = new NullPOIOnlineService(this.lc);
    }

    public void setMapService(MapService mapService) {
        if (mapService != null) {
            this.mapService = mapService;
        }
    }

    public void unsetMapService() {
        this.mapService = new NullMapService(this.lc);
    }

    public void setMyAudiService(IOnlineSDSMyAudiService iOnlineSDSMyAudiService) {
        if (iOnlineSDSMyAudiService != null) {
            this.myAudiService = iOnlineSDSMyAudiService;
            this.listListener.initOnlineLists();
        }
    }

    public void setOnlineDestinationService(IOnlineDestinationService iOnlineDestinationService) {
        if (iOnlineDestinationService != null) {
            this.onlineDestinationService = iOnlineDestinationService;
        }
    }

    public void unsetOnlineDestinationService() {
        this.onlineDestinationService = new NullOnlineDestinationService(this.lc);
    }

    public void unsetMyAudiService() {
        this.myAudiService = new NullSDSMyAudiService(this.lc);
    }

    public int[] getCommands() {
        return commands;
    }

    public void setMyAudiContacts(SDSListEntry[] sDSListEntryArray) {
        if (sDSListEntryArray == null) {
            this.myAudiContacts = new SDSListEntry[0];
            return;
        }
        this.myAudiContacts = sDSListEntryArray;
    }

    public boolean freezeLists() {
        this.lc.log(10000000, "NaviSDSHandlerImpl#freezeLists: called");
        return this.naviService.freezeDynamicLists() == 0;
    }

    public boolean unfreezeLists() {
        this.lc.log(10000000, "NaviSDSHandlerImpl#unfreezeLists: called");
        return this.naviService.unfreezeDynamicLists() == 0;
    }

    private void checkVZEStatus() {
        CarFuncAdap carFuncAdap = this.sdsHandlerService.getFramework().getSysConstManager().getCarFuncAdaptation();
        boolean bl = false;
        if (carFuncAdap != null) {
            bl = carFuncAdap.isMenuDisplayActivated((short)30);
        }
        SDSModelAccess.setVZEAvailableChoice(bl);
    }

    private boolean checkOperationState(int n) {
        boolean bl = SDSModelAccess.isCustomerNaviUpdateRunning();
        if (bl) {
            this.lc.log(100000, "NaviSDSHandlerImpl#checkOperationState: customerUpdate is active!", bl);
            if (SystemCall.requiresResponse(n)) {
                this.sdsHandlerService.sendResult(40005);
            }
            return false;
        }
        if (SDSModelAccess.getNaviVDEMediumState() != 1) {
            this.lc.log(100000, "NaviSDSHandlerImpl#checkOperationState: VDE-medium not available or data corrupt, currentVDEMediumState=%1!", (long)SDSModelAccess.getNaviVDEMediumState());
            if (SystemCall.requiresResponse(n)) {
                this.sdsHandlerService.sendResult(1006);
            }
            return false;
        }
        byte by = this.naviService.getOperationState();
        switch (by) {
            case 1: {
                this.lc.log(100000, "NaviSDSHandlerImpl#checkOperationState: Navigation not operable, aborting call with ID %1!", (long)n);
                if (SystemCall.requiresResponse(n)) {
                    this.sdsHandlerService.sendResult(40018);
                }
                return false;
            }
            case 2: {
                this.lc.log(100000, "NaviSDSHandlerImpl#checkOperationState: Navigation SD card removed, aborting call with ID %1!", (long)n);
                if (SystemCall.requiresResponse(n)) {
                    this.sdsHandlerService.sendResult(1006);
                }
                return false;
            }
        }
        this.lc.log(10000000, "NaviSDSHandlerImpl#checkOperationState: Navigation considered operable!");
        return true;
    }

    public void processCommand(int n, ISystemCallParameter[] iSystemCallParameterArray) {
        this.lc.log(10000000, "NaviSDSHandlerImpl#processCommand: id=%2, params=%1", (Object)SDSUtils.toString((Object[])iSystemCallParameterArray, false), (Object)SDSManagerBaseActivator.getSystemCallNames().getName(n));
        CommandList commandList = new CommandList(SDSManagerBaseActivator.getSysCallCmdListManager());
        if (!this.checkOperationState(n)) {
            return;
        }
        if (NaviSDSHandlerImpl.isPOICommand(n)) {
            this.processPOICommand(n, iSystemCallParameterArray, commandList);
            return;
        }
        if (NaviSDSHandlerImpl.isRouteCommand(n)) {
            this.processRouteCommand(n, iSystemCallParameterArray, commandList);
            return;
        }
        if (NaviSDSHandlerImpl.isDestinationCommand(n)) {
            this.processDestinationCommand(n, iSystemCallParameterArray, commandList);
            return;
        }
        if (NaviSDSHandlerImpl.isSpellingCommand(n)) {
            this.processSpellingCommand(n, iSystemCallParameterArray, commandList);
            return;
        }
        if (NaviSDSHandlerImpl.isListCommand(n)) {
            this.processListCommand(n, iSystemCallParameterArray, commandList);
            return;
        }
        if (NaviSDSHandlerImpl.isMainCommand(n)) {
            this.processMainCommand(n, iSystemCallParameterArray, commandList);
            return;
        }
        this.lc.log(10000, "NaviSDSHandlerImpl#processCommand: Unknown id %1!", (long)n);
    }

    private void processMainCommand(int n, ISystemCallParameter[] iSystemCallParameterArray, CommandList commandList) {
        String string = SDSManagerBaseActivator.getSystemCallNames().getName(n);
        switch (n) {
            case 1064: {
                this.initializeOneshotHandler(SDSUtils.retrieveInteger(iSystemCallParameterArray, 0));
                break;
            }
            case 40079: {
                commandList.add(new NaviFillPromptLabelsCommand(this.lc, string, this.sdsHandlerService, this.naviService, this));
                commandList.execute("SYSTEMCALL " + string);
                break;
            }
            case 40021: {
                commandList.add(new NaviGetInfoCommand(this.lc, string, this.sdsHandlerService, this.naviService, this.languageManager));
                commandList.execute("SYSTEMCALL " + string);
                break;
            }
            case 40023: {
                commandList.add(new NaviInputModeCheckCommand(this.lc, string, this.sdsHandlerService, this.naviService, this.srHandler, this));
                commandList.execute("SYSTEMCALL " + string);
                break;
            }
            case 40024: {
                commandList.add(new NaviInputStartedCommand(this.lc, string, this.sdsHandlerService, iSystemCallParameterArray, this, this.naviService, this.onlineDestinationService));
                commandList.execute("SYSTEMCALL " + string);
                break;
            }
            case 40051: {
                commandList.add(new NaviPostCodeCheckCommand(this.lc, string, this.sdsHandlerService, this.naviService));
                commandList.execute("SYSTEMCALL " + string);
                break;
            }
            case 40055: {
                commandList.add(new NaviVoiceGuidanceSetCommand(this.lc, string, this.sdsHandlerService, iSystemCallParameterArray, this.naviService));
                commandList.execute("SYSTEMCALL " + string);
                break;
            }
            case 40020: {
                commandList.add(new NaviHomeSetCommand(this.lc, string, this.sdsHandlerService, this, this.naviService));
                commandList.execute("SYSTEMCALL " + string);
                break;
            }
            case 40059: {
                commandList.add(new NaviHomeSaveCommand(this.lc, string, this.sdsHandlerService, this.naviService));
                commandList.execute("SYSTEMCALL " + string);
                break;
            }
            case 40029: {
                commandList.add(new NaviMapOptionsSetCommand(this.lc, string, this.sdsHandlerService, iSystemCallParameterArray, this.mapService));
                commandList.execute("SYSTEMCALL " + string);
                break;
            }
            case 40031: {
                commandList.add(new NaviMapZoomCommand(this.lc, string, this.sdsHandlerService, iSystemCallParameterArray, this.mapService));
                commandList.execute("SYSTEMCALL " + string);
                break;
            }
            case 40050: {
                commandList.add(new NaviSpeedLimitGetCommand(this.lc, string, this.sdsHandlerService, this.naviService));
                commandList.execute("SYSTEMCALL " + string);
                break;
            }
            case 40080: {
                commandList.add(new NaviEnterGeoCoordinatesCommand(this.lc, string, this.sdsHandlerService, this.naviService));
                commandList.execute("SYSTEMCALL " + string);
                break;
            }
            case 40082: {
                commandList.add(new NaviOperatorcallCommand(this.lc, string, this.sdsHandlerService, iSystemCallParameterArray, this.operatorCallService, this));
                commandList.execute("SYSTEMCALL " + string);
                break;
            }
            case 1060: {
                commandList.add(new SystemTruffleSetCommand(this.lc, string, this.sdsHandlerService, this.nBestStorage, this.naviService));
                commandList.execute("SYSTEMCALL " + string);
                break;
            }
            case 40087: {
                commandList.add(new NaviOneshotAmbiguousCommand(this.lc, string, this.sdsHandlerService, this, this.nBestStorage));
                commandList.execute("SYSTEMCALL " + string);
                break;
            }
            case 40088: {
                commandList.add(new NaviOneshotFilterPicklistCommand(this.lc, string, this.sdsHandlerService, this, iSystemCallParameterArray));
                commandList.execute("SYSTEMCALL " + string);
                break;
            }
            case 40097: {
                commandList.add(new NaviTrufflesSearchDestinationCommand(this.lc, string, this.sdsHandlerService, this.naviService, this.nBestStorage, (NaviServiceListenerImpl)this.naviServiceListener, this.naviTrufflesHist));
                commandList.execute("SYSTEMCALL " + string);
                break;
            }
            case 40098: {
                commandList.add(new NaviTrufflesCorrectionCommand(this.lc, string, this.sdsHandlerService, this.srHandler, this.naviService, this.nBestStorage, this.naviTrufflesHist));
                commandList.execute("SYSTEMCALL " + string);
                break;
            }
            case 40099: {
                commandList.add(new NaviAddressInputCorrectionCommand(this.lc, string, this.sdsHandlerService, iSystemCallParameterArray, this, this.naviService));
                commandList.execute("SYSTEMCALL " + string);
                break;
            }
            case 40104: {
                commandList.add(new NaviSynchronizeCountryCommand(this.lc, string, this.sdsHandlerService, this, this.naviService));
                commandList.execute("SYSTEMCALL " + string);
                break;
            }
            case 40105: {
                commandList.add(new NaviTrufflesEndCommand(this.lc, string, this.sdsHandlerService, this.srHandler, this.naviTrufflesHist));
                commandList.execute("SYSTEMCALL " + string);
                break;
            }
            case 40108: {
                commandList.add(new NaviTrufflesCancelSearchCommand(this.lc, string, this.sdsHandlerService, this.naviService));
                commandList.execute("SYSTEMCALL " + string);
                break;
            }
            case 40109: {
                commandList.add(new NaviSimpleMapAreaSetCommand(this.lc, string, this.sdsHandlerService, this.appInfoKrService, this.nBestStorage));
                commandList.execute("SYSTEMCALL " + string);
                break;
            }
            case 40110: {
                commandList.add(new NaviAddressInputCursorCorrectionCommand(this.lc, string, this.sdsHandlerService, iSystemCallParameterArray, this, this.naviService));
                commandList.execute("SYSTEMCALL " + string);
                break;
            }
            case 40111: {
                commandList.add(new NaviAddressInputCursorSetCommand(this.lc, string, this.sdsHandlerService, iSystemCallParameterArray, this.naviService));
                commandList.execute("SYSTEMCALL " + string);
                break;
            }
            case 40112: {
                commandList.add(new NaviSimpleMapFreeSelectionInitCommand(this.lc, string, this.sdsHandlerService, this.appInfoKrService));
                commandList.execute("SYSTEMCALL " + string);
                break;
            }
            case 40114: {
                commandList.add(new NaviTrufflesSearchPreviousDestinationCommand(this.lc, string, this.sdsHandlerService, this.naviService, this.nBestStorage, (NaviServiceListenerImpl)this.naviServiceListener, this.naviTrufflesHist));
                commandList.execute("SYSTEMCALL " + string);
                break;
            }
            default: {
                this.lc.log(10000, "NaviSDSHandlerImpl#processMainCommand: Unknown id %1!", (long)n);
            }
        }
    }

    private void processPOICommand(int n, ISystemCallParameter[] iSystemCallParameterArray, CommandList commandList) {
        String string = SDSManagerBaseActivator.getSystemCallNames().getName(n);
        switch (n) {
            case 40043: {
                commandList.add(new NaviPOIOnlineSearchAreaSetCommand(this.lc, string, this.sdsHandlerService, iSystemCallParameterArray, this.poiOnlineService));
                commandList.execute("SYSTEMCALL " + string);
                break;
            }
            case 40045: {
                commandList.add(new NaviPOIOnlineSearchCancelCommand(this.lc, string, this.sdsHandlerService, this.poiOnlineService));
                commandList.execute("SYSTEMCALL " + string);
                break;
            }
            case 40046: {
                commandList.add(new NaviPOIOnlineSearchInitCommand(this.lc, string, this.sdsHandlerService, iSystemCallParameterArray, this.poiOnlineService));
                commandList.execute("SYSTEMCALL " + string);
                break;
            }
            case 40077: {
                commandList.add(new NaviPOIOnlineSelectDestinationCommand(this.lc, string, this.sdsHandlerService, this, this.poiOnlineService));
                commandList.execute("SYSTEMCALL " + string);
                break;
            }
            case 40044: {
                commandList.add(new NaviPOIOnlineDidYouMeanCommand(this.lc, string, this.sdsHandlerService, this.poiOnlineService));
                commandList.execute("SYSTEMCALL " + string);
                break;
            }
            case 40042: {
                commandList.add(new NaviPOIOnlineRecogCommand(this.lc, string, this.sdsHandlerService, iSystemCallParameterArray));
                commandList.execute("SYSTEMCALL " + string);
                break;
            }
            case 40049: {
                commandList.add(new NaviPOIOnlineUniqueResultCommand(this.lc, string, this.sdsHandlerService, this.hmi));
                commandList.execute("SYSTEMCALL " + string);
                break;
            }
            case 40033: {
                commandList.add(new NaviPOISearchAreaSetCommand(this.lc, string, this.sdsHandlerService, iSystemCallParameterArray, this.naviService));
                commandList.execute("SYSTEMCALL " + string);
                break;
            }
            case 40034: {
                commandList.add(new NaviPOIShortCutSetCommand(this.lc, string, this.sdsHandlerService, iSystemCallParameterArray, this, this.naviService));
                commandList.execute("SYSTEMCALL " + string);
                break;
            }
            case 40040: {
                commandList.add(new NaviPOIValueSetCommand(this.lc, string, this.sdsHandlerService, iSystemCallParameterArray, this.naviService, this.nBestStorage, this));
                commandList.execute("SYSTEMCALL " + string);
                break;
            }
            case 40032: {
                commandList.add(new NaviPOICorrectionCommand(this.lc, string, this.sdsHandlerService, this.naviService));
                commandList.execute("SYSTEMCALL " + string);
                break;
            }
            case 40064: {
                commandList.add(new NaviPOIOnlineShowListCommand(this.lc, string, this.sdsHandlerService, this.poiOnlineService, iSystemCallParameterArray));
                commandList.execute("SYSTEMCALL " + string);
                break;
            }
            case 40068: {
                commandList.add(new NaviPOIOneshotAmbiguousCommand(this.lc, string, this.sdsHandlerService, this, this.nBestStorage));
                commandList.execute("SYSTEMCALL " + string);
                break;
            }
            case 40069: {
                commandList.add(new NaviPOIOneshotFilterPicklistCommand(this.lc, string, this.sdsHandlerService, this, iSystemCallParameterArray));
                commandList.execute("SYSTEMCALL " + string);
                break;
            }
            case 40072: {
                commandList.add(new NaviPOIPromptLabelSetCommand(this.lc, string, this.sdsHandlerService, this.naviService, this, iSystemCallParameterArray));
                commandList.execute("SYSTEMCALL " + string);
                break;
            }
            case 40084: {
                commandList.add(new NaviPOIHistoryEntryUniqueCommand(this.lc, string, this.sdsHandlerService, iSystemCallParameterArray, this.operatorCallService));
                commandList.execute("SYSTEMCALL " + string);
                break;
            }
            case 40096: {
                commandList.add(new NaviEnterPoiNameSearchCommand(this.lc, string, this.sdsHandlerService, this.naviService));
                commandList.execute("SYSTEMCALL " + string);
                break;
            }
            case 40100: {
                commandList.add(new NaviStartTpegPOICommand(this.lc, string, this.sdsHandlerService, this.naviService));
                commandList.execute("SYSTEMCALL " + string);
                break;
            }
            case 40101: {
                commandList.add(new NaviGetTpegPOIResultsByCategoryCommand(this.lc, string, this.sdsHandlerService, this.naviService));
                commandList.execute("SYSTEMCALL " + string);
                break;
            }
            case 40102: {
                commandList.add(new NaviSelectTpegPOIResultCommand(this.lc, string, this.sdsHandlerService, this.naviService));
                commandList.execute("SYSTEMCALL " + string);
                break;
            }
            case 40103: {
                commandList.add(new NaviTriggerTpegPOIReturnCommand(this.lc, string, this.sdsHandlerService, this.naviService));
                commandList.execute("SYSTEMCALL " + string);
                break;
            }
            default: {
                this.lc.log(10000, "NaviSDSHandlerImpl#processPOICommand: Unknown id %1!", (long)n);
            }
        }
    }

    private void processRouteCommand(int n, ISystemCallParameter[] iSystemCallParameterArray, CommandList commandList) {
        String string = SDSManagerBaseActivator.getSystemCallNames().getName(n);
        switch (n) {
            case 40063: {
                commandList.add(new NaviAlternativeRouteCalcCommand(this.lc, string, this.sdsHandlerService, this.naviService));
                break;
            }
            case 40015: {
                commandList.add(new NaviAlternativeRouteNumberSetCommand(this.lc, string, this.sdsHandlerService, iSystemCallParameterArray, this.naviService));
                break;
            }
            case 40078: {
                commandList.add(new NaviBlockRouteSetNLUCommand(this.lc, string, this.sdsHandlerService, this.nBestStorage));
                break;
            }
            case 40001: {
                commandList.add(new NaviBlockRouteValueSetCommand(this.lc, string, this.sdsHandlerService, iSystemCallParameterArray, this.naviService));
                break;
            }
            case 40074: {
                commandList.add(new NaviCheckBetterRouteCommand(this.lc, string, this.sdsHandlerService, this.naviService));
                break;
            }
            case 40013: {
                commandList.add(new NaviCheckRouteGuidanceCommand(this.lc, string, this.sdsHandlerService, this.naviService));
                break;
            }
            case 40052: {
                commandList.add(new NaviRouteOptionsSetCommand(this.lc, string, this.sdsHandlerService, iSystemCallParameterArray, this.naviService));
                break;
            }
            case 40075: {
                commandList.add(new NaviSetBypassRouteCommand(this.lc, string, this.sdsHandlerService, iSystemCallParameterArray, this.naviService));
                break;
            }
            case 40083: {
                commandList.add(new NaviEnterRubberbandCommand(this.lc, string, this.sdsHandlerService, this.naviService));
                break;
            }
            case 40085: {
                commandList.add(new NaviRouteInfosSetCommand(this.lc, string, this.sdsHandlerService, iSystemCallParameterArray, this.naviService));
                break;
            }
            default: {
                this.lc.log(10000, "NaviSDSHandlerImpl#processRouteCommand: Unknown id %1!", (long)n);
                return;
            }
        }
        String string2 = new Buffer("SYSTEMCALL ").append(string).toString();
        commandList.execute(string2);
    }

    private void processDestinationCommand(int n, ISystemCallParameter[] iSystemCallParameterArray, CommandList commandList) {
        String string = SDSManagerBaseActivator.getSystemCallNames().getName(n);
        switch (n) {
            case 40018: {
                commandList.add(new NaviHouseNumberCheckCommand(this.lc, string, this.sdsHandlerService, this, this.nBestStorage));
                commandList.execute("SYSTEMCALL " + string);
                break;
            }
            case 40019: {
                commandList.add(new NaviHouseNumberSetCommand(this.lc, string, this.sdsHandlerService, this));
                commandList.execute("SYSTEMCALL " + string);
                break;
            }
            case 40086: {
                commandList.add(new NaviHouseNumberResolveCommand(this.lc, string, this.sdsHandlerService, iSystemCallParameterArray, this.naviService, this, this.nBestStorage));
                commandList.execute("SYSTEMCALL " + string);
                break;
            }
            case 40004: {
                commandList.add(new NaviDestinationAvailableCommand(this.lc, string, this.sdsHandlerService, iSystemCallParameterArray, this.naviService));
                commandList.execute("SYSTEMCALL " + string);
                break;
            }
            case 40003: {
                commandList.add(new NaviDestinationDeleteCommand(this.lc, "NAVI_DESTINATIONDELETE", this.sdsHandlerService, this.naviService));
                commandList.execute("SYSTEMCALL " + string);
                break;
            }
            case 40005: {
                commandList.add(new NaviDestinationGetCommand(this.lc, "NAVI_DESTINATIONGET", this.sdsHandlerService, iSystemCallParameterArray, this.naviService));
                commandList.execute("SYSTEMCALL " + string);
                break;
            }
            case 40007: {
                commandList.add(new NaviDestinationSetCommand(this.lc, "NAVI_DESTINATIONSET", this.sdsHandlerService, iSystemCallParameterArray, this, this.naviService, this.operatorCallService, this.nBestStorage));
                commandList.execute("SYSTEMCALL " + string);
                break;
            }
            case 40009: {
                commandList.add(new NaviDestinationStatusCommand(this.lc, "NAVI_DESTINATIONSTATUS", this.sdsHandlerService, this.naviService));
                commandList.execute("SYSTEMCALL " + string);
                break;
            }
            case 40076: {
                commandList.add(new NaviDetailsPhoneCallCommand(this.lc, "NAVI_DETAILSPHONECALL", this.sdsHandlerService, this.hmi, this.naviService));
                commandList.execute("SYSTEMCALL " + string);
                break;
            }
            case 40056: {
                if (this.oneshotHandler == null) {
                    commandList.add(new NaviVDEOneshotAmbiguousCommand(this.lc, "NAVI_VDEONESHOTISAMBIGUOUS", this.sdsHandlerService, this, this.nBestStorage));
                    commandList.execute("SYSTEMCALL " + string);
                    break;
                }
                commandList.add(new NaviOneshotAmbiguousCommand(this.lc, "NAVI_ONESHOTISAMBIGUOUS", this.sdsHandlerService, this, this.nBestStorage));
                commandList.execute("SYSTEMCALL " + string);
                break;
            }
            case 40057: {
                if (this.oneshotHandler == null) {
                    commandList.add(new NaviVDEOneshotFilterPicklistCommand(this.lc, "NAVI_VDEONESHOTFILTERPICKLIST", this.sdsHandlerService, this, iSystemCallParameterArray));
                    commandList.execute("SYSTEMCALL " + string);
                    break;
                }
                commandList.add(new NaviOneshotFilterPicklistCommand(this.lc, "NAVI_ONESHOTFILTERPICKLIST", this.sdsHandlerService, this, iSystemCallParameterArray));
                commandList.execute("SYSTEMCALL " + string);
                break;
            }
            case 40062: {
                commandList.add(new NaviAddDestinationCommand(this.lc, "NAVI_ADD_DESTINATION", this.sdsHandlerService, iSystemCallParameterArray, this.naviService));
                commandList.execute("SYSTEMCALL " + string);
                break;
            }
            case 40065: {
                commandList.add(new NaviFavoriteDestinationSetCommand(this.lc, "NAVI_FAVORITEDESTINATIONSET", this.sdsHandlerService, iSystemCallParameterArray, this, this.naviService, this.nBestStorage));
                commandList.execute("SYSTEMCALL " + string);
                break;
            }
            case 40066: {
                commandList.add(new NaviLastDestinationSetCommand(this.lc, "NAVI_LASTDESTINATIONSET", this.sdsHandlerService, iSystemCallParameterArray, this, this.naviService, this.nBestStorage));
                commandList.execute("SYSTEMCALL " + string);
                break;
            }
            case 40060: {
                commandList.add(new NaviGuidanceStartCommand(this.lc, "NAVI_GUIDANCE_START", this.sdsHandlerService, this, this.naviService));
                commandList.execute("SYSTEMCALL " + string);
                break;
            }
            case 40061: {
                commandList.add(new NaviGuidanceStopCommand(this.lc, "NAVI_GUIDANCE_STOP", this.sdsHandlerService, this.naviService));
                commandList.execute("SYSTEMCALL " + string);
                break;
            }
            case 40067: {
                commandList.add(new NaviSUITypeGetCommand(this.lc, "NAVI_SUITYPEGET", this.sdsHandlerService, this.nBestStorage));
                commandList.execute("SYSTEMCALL " + string);
                break;
            }
            case 40070: {
                commandList.add(new NaviMyAudiContactSelectCommand(this.lc, "NAVI_MYAUDICONTACTSELECT", this.sdsHandlerService, iSystemCallParameterArray, this, this.myAudiService, this.nBestStorage));
                commandList.execute("SYSTEMCALL " + string);
                break;
            }
            case 40071: {
                commandList.add(new NaviIntelliDestinationSetCommand(this.lc, "NAVI_INTELLIDESTSET", this.sdsHandlerService, this, this.naviService, iSystemCallParameterArray));
                commandList.execute("SYSTEMCALL " + string);
                break;
            }
            case 40073: {
                commandList.add(new NaviOneshotStoreDataCommand(this.lc, "NAVI_ONESHOTSTOREDATA", this.sdsHandlerService, this, this.nBestStorage, iSystemCallParameterArray));
                commandList.execute("SYSTEMCALL " + string);
                break;
            }
            case 40081: {
                commandList.add(new NaviDestinationAvailableAsiaCommand(this.lc, "NAVI_DESTINATIONAVAILABLE_ASIA", this.sdsHandlerService, iSystemCallParameterArray, this.naviService));
                commandList.execute("SYSTEMCALL " + string);
                break;
            }
            case 40089: {
                commandList.add(new NaviMapCodeAddCommand(this.lc, "NAVI_MAPCODEADD", this.sdsHandlerService, this.naviService, this.nBestStorage));
                commandList.execute("SYSTEMCALL " + string);
                break;
            }
            case 40090: {
                commandList.add(new NaviMapCodeDeleteCommand(this.lc, "NAVI_MAPCODEDELETE", this.sdsHandlerService, iSystemCallParameterArray, this.naviService));
                commandList.execute("SYSTEMCALL " + string);
                break;
            }
            case 40091: {
                commandList.add(new NaviMapCodeGetCommand(this.lc, "NAVI_MAPCODEGET", this.sdsHandlerService, this.naviService));
                commandList.execute("SYSTEMCALL " + string);
                break;
            }
            case 40092: {
                commandList.add(new NaviMapCodeResolveCommand(this.lc, "NAVI_MAPCODERESOLVE", this.sdsHandlerService, this.naviService));
                commandList.execute("SYSTEMCALL " + string);
                break;
            }
            case 40106: {
                commandList.add(new NaviMapCodeNavigableCommand(this.lc, "NAVI_MAPCODENAVIGABLE", this.sdsHandlerService, this.naviService));
                commandList.execute("SYSTEMCALL " + string);
                break;
            }
            case 40107: {
                commandList.add(new NaviFurtherInputPossibleCommand(this.lc, "NAVI_FURTHERINPUTPOSSIBLE", this.sdsHandlerService, iSystemCallParameterArray, this.naviService));
                commandList.execute("SYSTEMCALL " + string);
                break;
            }
            case 40093: {
                commandList.add(new NaviPhoneNumberAddCommand(this.lc, "NAVI_PHONENUMBERADD", this.sdsHandlerService, this.naviService, this.nBestStorage));
                commandList.execute("SYSTEMCALL " + string);
                break;
            }
            case 40094: {
                commandList.add(new NaviPhoneNumberDeleteCommand(this.lc, "NAVI_PHONENUMBERDELETE", this.sdsHandlerService, iSystemCallParameterArray, this.naviService));
                commandList.execute("SYSTEMCALL " + string);
                break;
            }
            case 40095: {
                commandList.add(new NaviPhoneNumberGetCommand(this.lc, "NAVI_PHONENUMBERGET", this.sdsHandlerService, this.naviService));
                commandList.execute("SYSTEMCALL " + string);
                break;
            }
            case 40113: {
                commandList.add(new NaviHousenumberJPKRValidate(this.lc, string, this.sdsHandlerService, this.nBestStorage));
                commandList.execute("SYSTEMCALL " + string);
                break;
            }
            default: {
                this.lc.log(10000, "NaviSDSHandlerImpl#processVDECommand: Unknown id %1!", (long)n);
            }
        }
    }

    private void processSpellingCommand(int n, ISystemCallParameter[] iSystemCallParameterArray, CommandList commandList) {
        String string = SDSManagerBaseActivator.getSystemCallNames().getName(n);
        switch (n) {
            case 40010: {
                commandList.add(new NaviSpellingModeCommand(this.lc, string, this.sdsHandlerService, iSystemCallParameterArray));
                commandList.execute("SYSTEMCALL " + string);
                break;
            }
            case 40011: {
                commandList.add(new NaviSpellingModeCorrectionCommand(this.lc, string, this.sdsHandlerService, iSystemCallParameterArray));
                commandList.execute("SYSTEMCALL " + string);
                break;
            }
            default: {
                this.lc.log(10000, "NaviSDSHandlerImpl#processSpellingCommand: Unknown id %1!", (long)n);
            }
        }
    }

    private void processListCommand(int n, ISystemCallParameter[] iSystemCallParameterArray, CommandList commandList) {
        String string = SDSManagerBaseActivator.getSystemCallNames().getName(n);
        switch (n) {
            case 40028: {
                commandList.add(new NaviListShowCommand(this.lc, string, this.sdsHandlerService, iSystemCallParameterArray, this, this.factory, this.hmi, this.sdsPopupHelper, this.naviService, this.adbService, this.nBestStorage));
                commandList.execute("SYSTEMCALL " + string);
                break;
            }
            case 40026: {
                commandList.add(new NaviListHideCommand(this.lc, string, this.sdsHandlerService, iSystemCallParameterArray, this.hmi, this.sdsPopupHelper));
                commandList.execute("SYSTEMCALL " + string);
                break;
            }
            case 40053: {
                commandList.add(new NaviListLineDataGetCommand(this.lc, string, this.sdsHandlerService, iSystemCallParameterArray, this.hmi, this, this.nBestStorage));
                commandList.execute("SYSTEMCALL " + string);
                break;
            }
            default: {
                this.lc.log(10000, "NaviSDSHandlerImpl#processListCommand: Unknown id %1!", (long)n);
            }
        }
    }

    private static boolean isMainCommand(int n) {
        return n == 40079 || n == 40021 || n == 40023 || n == 40024 || n == 40020 || n == 40059 || n == 40029 || n == 40031 || n == 40051 || n == 40050 || n == 40055 || n == 40080 || n == 40082 || n == 1060 || n == 1064 || n == 40087 || n == 40088 || n == 40104 || n == 40097 || n == 40098 || n == 40105 || n == 40099 || n == 40108 || n == 40109 || n == 40110 || n == 40111 || n == 40112 || n == 40114;
    }

    private static boolean isPOICommand(int n) {
        return n == 40032 || n == 40042 || n == 40043 || n == 40045 || n == 40044 || n == 40046 || n == 40049 || n == 40077 || n == 40033 || n == 40034 || n == 40064 || n == 40068 || n == 40069 || n == 40072 || n == 40084 || n == 40040 || n == 40096 || n == 40100 || n == 40101 || n == 40102 || n == 40103;
    }

    private static boolean isDestinationCommand(int n) {
        return n == 40062 || n == 40004 || n == 40003 || n == 40005 || n == 40007 || n == 40086 || n == 40009 || n == 40076 || n == 40065 || n == 40060 || n == 40061 || n == 40018 || n == 40019 || n == 40071 || n == 40066 || n == 40070 || n == 40073 || n == 40067 || n == 40057 || n == 40056 || n == 40081 || n == 40089 || n == 40090 || n == 40091 || n == 40092 || n == 40106 || n == 40107 || n == 40093 || n == 40094 || n == 40095 || n == 40113;
    }

    private static boolean isRouteCommand(int n) {
        return n == 40063 || n == 40015 || n == 40078 || n == 40001 || n == 40074 || n == 40013 || n == 40052 || n == 40083 || n == 40075 || n == 40085;
    }

    private static boolean isSpellingCommand(int n) {
        return n == 40010 || n == 40011;
    }

    private static boolean isListCommand(int n) {
        return n == 40028 || n == 40026 || n == 40053;
    }

    public void sessionEnded() {
        this.lc.log(10000000, "NaviSDSHandlerImpl#sessionEnded: Resetting models!");
        this.setSDSAddressInputMode((byte)0);
        this.setPickListMode((byte)-1);
        SDSModelAccess.setNaviDestinationTypeModel(-1);
        this.houseNumberSlot = null;
        this.oneshotHandler = null;
    }

    public boolean isListLineDataGetActive() {
        return SDSUtils.getActiveSystemCall() instanceof NaviListLineDataGetCommand;
    }

    public void sdsListLineDataGet(int n, int n2) {
        this.lc.log(10000000, "NaviSDSHandlerImpl#sdsListLineDataGet: modelID=%1, absLine=%2", (long)n, (long)n2);
        AbstractSystemCallCommand abstractSystemCallCommand = SDSUtils.getActiveSystemCall();
        if (abstractSystemCallCommand == null) {
            this.lc.log(10000, "NaviSDSHandlerImpl#sdsListLineDataGet: No active command!");
            return;
        }
        try {
            ((NaviListLineDataGetCommand)SDSUtils.getActiveSystemCall()).sdsListLineDataGet(n2);
        }
        catch (ClassCastException classCastException) {
            this.lc.log(10000, "NaviSDSHandlerImpl#sdsListLineDataGet: Active command is no NaviListLineDataGetCommand!");
        }
    }

    public void responseVDECapabilities(int n, VDECapabilities vDECapabilities, String string) {
        AbstractSystemCallCommand abstractSystemCallCommand;
        this.lc.log(10000000, "NaviSDSHandlerImpl#responseVDECapabilities: result=%1, capabilities=%2, sdsLanguage=%3", (Object)Integer.toString(n), (Object)vDECapabilities, (Object)string);
        if (this.handleSUIModel(vDECapabilities, string)) {
            this.reloadSUIVDERelatedGrammars();
        }
        boolean bl = vDECapabilities == null ? false : vDECapabilities.flexVDE;
        String[] stringArray = vDECapabilities == null ? new String[]{} : vDECapabilities.getFlexVDELanguage();
        String string2 = vDECapabilities == null ? "" : vDECapabilities.countryAbbreviation;
        this.lc.log(10000000, "NaviSDSHandlerImpl#responseVDECapabilities: trufflesForCountry=%1, trufflesLangCodes=%2, trufflesCountryAbbreviation=%3!", bl, (Object)stringArray, (Object)string2);
        boolean bl2 = bl && SDSUtils.contains(string, stringArray);
        boolean bl3 = !string2.equals(this.currentTrufflesCountryAbbreviation);
        SDSModelAccess.setNaviTrufflesAvailable(bl2);
        if (bl2 && bl3) {
            this.reloadTruffleVDERelatedGrammars();
        }
        if (bl3) {
            this.currentTrufflesCountryAbbreviation = string2;
        }
        if ((abstractSystemCallCommand = SDSUtils.getActiveSystemCall()) instanceof NaviInputModeCheckCommand) {
            this.lc.log(10000000, "NaviSDSHandlerImpl#responseVDECapabilities: Active command is NaviInputModeCheckCommand!");
            ((NaviInputModeCheckCommand)abstractSystemCallCommand).sdsInputModeCheckResult(n == 0 ? (byte)0 : 1, vDECapabilities, string);
        }
    }

    public void responseDeleteLastTrufflesSearchText(int n, NBestList nBestList) {
        this.lc.log(10000000, "NaviSDSHandlerImpl#responseDeleteLastTrufflesSearchText: replyCode=%2, results=%1!", (Object)nBestList, (long)n);
        AbstractSystemCallCommand abstractSystemCallCommand = SDSUtils.getActiveSystemCall();
        if (abstractSystemCallCommand instanceof NaviTrufflesCorrectionCommand) {
            ((NaviTrufflesCorrectionCommand)abstractSystemCallCommand).responseDeleteLastTrufflesSearchText(n, nBestList);
        } else {
            this.lc.log(100000, "NaviSDSHandlerImpl#responseDeleteLastTrufflesSearchText: Active command is not NaviTrufflesCorrectionCommand but %1!", (Object)abstractSystemCallCommand);
        }
    }

    public void responseClearTrufflesSearchHistory(int n) {
        this.lc.log(10000000, "NaviSDSHandlerImpl#responseClearTrufflesSearchHistory: replyCode=%1!", (long)n);
        AbstractSystemCallCommand abstractSystemCallCommand = SDSUtils.getActiveSystemCall();
        if (abstractSystemCallCommand instanceof NaviTrufflesCorrectionCommand) {
            ((NaviTrufflesCorrectionCommand)abstractSystemCallCommand).responseClearTrufflesSearchHistory(n);
        } else if (abstractSystemCallCommand instanceof NaviTrufflesEndCommand) {
            ((NaviTrufflesEndCommand)abstractSystemCallCommand).responseClearTrufflesSearchHistory(n);
        } else {
            this.lc.log(100000, "NaviSDSHandlerImpl#responseClearTrufflesSearchHistory: Active command is neiter NaviTrufflesCorrection nor NaviTrufflesEnd but %1!", (Object)abstractSystemCallCommand);
        }
    }

    private boolean handleSUIModel(VDECapabilities vDECapabilities, String string) {
        if (this.ldcHandling == 1) {
            SDSModelAccess.setDestinationCountrySystemLanguage(true);
            return true;
        }
        if (this.ldcHandling == 2) {
            SDSModelAccess.setDestinationCountrySystemLanguage(false);
            return false;
        }
        if (vDECapabilities == null) {
            this.lc.log(100000, "NaviSDSHandlerImpl#handleSUIModel: Empty capabilities, setting model to false!");
            SDSModelAccess.setDestinationCountrySystemLanguage(false);
            return false;
        }
        boolean bl = SDSUtils.contains(string, vDECapabilities.getGrammarLanguage());
        boolean bl2 = vDECapabilities.oneShot;
        boolean bl3 = bl && bl2;
        this.lc.log(10000000, "NaviSDSHandlerImpl#handleSUIModel: containsSDSLanguage=%1, oneShotAvailable=%2!", bl, bl2);
        SDSModelAccess.setDestinationCountrySystemLanguage(bl3);
        return bl3;
    }

    public void reloadSUIVDERelatedGrammars() {
        int n;
        int[] nArray = SDSManagerBaseActivator.getMapping().getSUIGrammars(1);
        int[] nArray2 = SDSManagerBaseActivator.getMapping().getSUIGrammars(4);
        this.lc.log(10000000, "NaviSDSHandlerImpl#reloadSUIVDERelatedGrammars: Reloading suiVDERuleIDs %1 and suiPOICityRuleIDs %2!", (Object)nArray, (Object)nArray2);
        ITTSASRContext iTTSASRContext = this.ttsASR.createGrammarContext();
        if (!SDSUtils.isEmpty(nArray)) {
            for (n = 0; n < nArray.length; ++n) {
                iTTSASRContext.addToGrammar(nArray[n], 3);
            }
        }
        if (!SDSUtils.isEmpty(nArray2)) {
            for (n = 0; n < nArray2.length; ++n) {
                iTTSASRContext.addToGrammar(nArray2[n], 3);
            }
        }
        this.ttsASR.reloadGrammarContext(iTTSASRContext);
    }

    public void reloadTruffleVDERelatedGrammars() {
        int[] nArray = SDSManagerBaseActivator.getMapping().getTruffleGrammars(1);
        this.lc.log(10000000, "NaviSDSHandlerImpl#reloadTruffleVDERelatedGrammars: Reloading truffleVDERuleIDs %1!", (Object)nArray);
        ITTSASRContext iTTSASRContext = this.ttsASR.createGrammarContext();
        if (!SDSUtils.isEmpty(nArray)) {
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                iTTSASRContext.addToGrammar(nArray[i2], 3);
            }
        }
        this.ttsASR.reloadGrammarContext(iTTSASRContext);
    }

    public void setSDSAddressInputMode(byte by) {
        this.lc.log(10000000, "NaviSDSHandlerImpl#setSDSAddressInputMode: value=%1", (long)by);
        this.addressInputMode = by;
    }

    public synchronized void setSpeechDSIStatus(boolean bl) {
        this.lc.log(10000000, "NaviSDSHandlerImpl#setSpeechDSIStatus: ready=%1, currentCountryAbbreviation=%2", bl, (Object)this.currentCountryAbbreviation);
        if (!bl || SDSUtils.isEmpty(this.currentCountryAbbreviation)) {
            this.lc.log(10000000, "NaviSDSHandlerImpl#setSpeechDSIStatus: Speech DSI not ready or currentCountryAbbreviation empty => NOP!");
            return;
        }
        this.lc.log(10000000, "NaviSDSHandlerImpl#setSpeechDSIStatus: Requesting VDE capabilities with countryAbbreviation %1!", (Object)this.currentCountryAbbreviation);
        this.srHandler.requestVDECapabilities(this.currentCountryAbbreviation);
        this.currentCountryAbbreviation = "";
    }

    public NaviServiceListener getNaviServiceListener() {
        return this.naviServiceListener;
    }

    public NaviSDSPOIOnlineServiceListener getPOIOnlineServiceListener() {
        return this.poiOnlineServiceListener;
    }

    public synchronized void updateDestinationCountryCode(String string, String string2) {
        this.lc.log(10000000, "NaviSDSHandlerImpl#updateDestinationCountryCode: country=%1, countryAbbreviation=%2", (Object)string, (Object)string2);
        SDSModelAccess.setNaviCurrentCountryLabel(string);
        if (!this.srHandler.requestVDECapabilities(string2)) {
            this.lc.log(10000000, "NaviSDSHandlerImpl#updateDestinationCountryCode: VDE capabilities NOT requested, overwriting currentCountryAbbreviation %1!", (Object)this.currentCountryAbbreviation);
            this.currentCountryAbbreviation = string2;
            return;
        }
        this.lc.log(10000000, "NaviSDSHandlerImpl#updateDestinationCountryCode: Erasing currentCountryAbbreviation!");
        this.currentCountryAbbreviation = "";
    }

    public synchronized void updateDestinationStateCode(String string, String string2) {
    }

    public byte getSDSAddressInputMode() {
        this.lc.log(10000000, "NaviSDSHandlerImpl#getSDSAddressInputMode: addressInputMode=%1", (long)this.addressInputMode);
        return this.addressInputMode;
    }

    private void clearOneshotData(byte by) {
        for (byte by2 = by; by2 <= 3; by2 = (byte)(by2 + 1)) {
            this.setOneshotData(new NaviService.OneshotData("", ""), by2);
        }
    }

    public NaviService.OneshotData getOneshotData(byte by) {
        if (this.oneshotHandler == null) {
            return this.oneshotData[by];
        }
        return this.oneshotHandler.getOneshotData(by);
    }

    public void setOneshotData(NaviService.OneshotData oneshotData, byte by) {
        this.lc.log(10000000, "NaviSDSHandlerImpl#setOneshotData: data=%1, level=%2", (Object)oneshotData, (long)by);
        this.oneshotData[by] = oneshotData;
    }

    public boolean setOneshotData(int n) {
        IPicklist iPicklist = this.nBestStorage.getMatchingPicklist((byte)0);
        if (iPicklist == null) {
            this.lc.log(100000, "NaviSDSHandlerImpl#setOneshotData: Empty picklist!");
            return false;
        }
        for (byte by = 0; by < 4; by = (byte)(by + 1)) {
            IPicklistSlot iPicklistSlot = iPicklist.getSlot(n, by);
            this.lc.log(10000000, "NaviSDSHandlerImpl#setOneshotData: Slot #%2=%1!", (Object)iPicklistSlot, (long)by);
            if (iPicklistSlot == null) {
                this.lc.log(10000000, "NaviSDSHandlerImpl#setOneshotData: Empty slot %1!", (long)by);
                this.setOneshotData(new NaviService.OneshotData("", "", -1L), by);
                continue;
            }
            this.setOneshotData(new NaviService.OneshotData(iPicklistSlot.getText(), iPicklistSlot.getObjectStringID(), iPicklistSlot.getObjID()), by);
        }
        return true;
    }

    public void storeUniqueOneshotData(byte by, byte by2, int n, int n2, int n3) {
        switch (by) {
            case 0: {
                if (n < n2 || n > n3) {
                    this.lc.log(100000, "NaviSDSHandlerImpl#storeUniqueOneshotData: Illegal listMode %1 for RECOG_EMPTY!", (long)n);
                    return;
                }
                this.lc.log(10000000, "NaviSDSHandlerImpl#storeUniqueOneshotData: Clearing oneshot data from listMode %1 for RECOG_EMPTY!", (long)n);
                this.clearOneshotData(by2);
                break;
            }
            case 1: {
                IPicklistSlot iPicklistSlot = this.getEntryPicklist().getSlot(0, 0);
                String string = iPicklistSlot != null ? iPicklistSlot.getText() : "";
                long l = iPicklistSlot != null ? iPicklistSlot.getObjID() : -1L;
                String string2 = iPicklistSlot != null ? iPicklistSlot.getObjectStringID() : "";
                this.lc.log(10000000, "NaviSDSHandlerImpl#storeUniqueOneshotData: Requested level %3: %1 (%2)", (Object)string, (Object)string2, (long)(by2 + 1));
                this.setOneshotData(new NaviService.OneshotData(string, string2, l), by2);
                SDSModelAccess.setSlotModel(by2 + 1, string);
                SDSModelAccess.setSlotModelStringID(by2 + 1, string2);
                SDSModelAccess.setListLineDataGetModel(string);
                break;
            }
            case 2: 
            case 3: {
                this.lc.log(10000000, "NaviSDSHandlerImpl#storeUniqueOneshotData: Multiple entries found => NOP!");
                break;
            }
            default: {
                this.lc.log(100000, "NaviSDSHandlerImpl#storeUniqueOneshotData: Unhandled nextPicklistSizeType %1!", (long)by);
            }
        }
    }

    public byte getNextPicklistSizeType(byte by, boolean bl) {
        String[] stringArray;
        this.lc.log(10000000, "NaviSDSHandlerImpl#getNextPicklistSizeType: column=%1", (long)by);
        IPicklist iPicklist = this.getInitialEntryPicklist();
        if (SDSUtils.isEmpty(iPicklist)) {
            this.lc.log(100000, "NaviSDSHandlerImpl#getNextPicklistSizeType: Empty entryPicklist!");
            return 0;
        }
        String[] stringArray2 = stringArray = bl ? this.getOneshotFilterStrings(by) : new String[]{};
        if (stringArray == null) {
            return 0;
        }
        IPicklist iPicklist2 = this.pickListMode == 3 ? NaviSDSUtils.thinOutHousenumberEntryPicklist(iPicklist, stringArray, by, this.lc) : SDSUtils.thinOutEntryPicklist(iPicklist, stringArray, by, this.lc);
        this.setEntryPicklist(iPicklist2);
        return SDSUtils.getPicklistSizeConstant(iPicklist2.getSize());
    }

    public String[] getOneshotFilterStrings(byte by) {
        this.lc.log(10000000, "NaviSDSHandlerImpl#getOneshotFilterStrings: column=%1", (long)by);
        String[] stringArray = null;
        NaviService.OneshotData oneshotData = null;
        NaviService.OneshotData oneshotData2 = null;
        NaviService.OneshotData oneshotData3 = null;
        switch (by) {
            case 0: {
                stringArray = new String[]{};
                break;
            }
            case 1: {
                oneshotData = this.getOneshotData((byte)0);
                if (oneshotData == null) break;
                stringArray = new String[]{oneshotData.getText()};
                break;
            }
            case 2: {
                oneshotData = this.getOneshotData((byte)0);
                oneshotData2 = this.getOneshotData((byte)1);
                if (oneshotData == null || oneshotData2 == null) break;
                stringArray = new String[]{oneshotData.getText(), oneshotData2.getText()};
                break;
            }
            case 3: {
                oneshotData = this.getOneshotData((byte)0);
                oneshotData2 = this.getOneshotData((byte)1);
                oneshotData3 = this.getOneshotData((byte)2);
                if (oneshotData == null || oneshotData2 == null || oneshotData3 == null) break;
                stringArray = new String[]{oneshotData.getText(), oneshotData2.getText(), oneshotData3.getText()};
                break;
            }
        }
        if (stringArray == null) {
            this.lc.log(10000, "NaviSDSHandlerImpl#getOneshotFilterStrings: oneshot data insufficient for column %1!", (long)by);
        }
        return stringArray;
    }

    public void markCurrentPOIUsedFor(byte by) {
        this.lc.log(10000000, "[NaviSDSHandlerImpl#markCurrentPOIUsedFor] type=%1", (long)by);
        this.poiOnlineService.markCurrentPOIUsedFor(by);
    }

    public byte poiOnlineVoiceDataAvailable() {
        int n = this.sdsHandlerService.getFramework().isCn() ? 1 : 2;
        this.lc.log(10000000, "NaviSDSHandlerImpl#poiOnlineVoiceDataAvailable: called - audioFormat:%1", (long)n);
        byte by = this.poiOnlineService.poiOnlineVoiceDataAvailable("/tmp/speech-online.pcm", n);
        this.lc.log(10000000, "NaviSDSHandlerImpl#poiOnlineVoiceDataAvailable: replyCode=%1!", (long)by);
        return by;
    }

    public boolean usesAltRouteCalc() {
        return this.useAltRouteCalc;
    }

    public void setUseAltRouteCalc(boolean bl) {
        this.useAltRouteCalc = bl;
    }

    public byte getPickListMode() {
        return this.pickListMode;
    }

    public void setPickListMode(byte by) {
        this.lc.log(10000000, "[NaviSDSHandlerImpl#setPickListMode] value=%1", (long)by);
        this.pickListMode = by;
    }

    public IPicklist getEntryPicklist() {
        return this.entryPicklist;
    }

    public void setEntryPicklist(IPicklist iPicklist) {
        this.lc.log(10000000, "[NaviSDSHandlerImpl#setEntryPicklist] picklist=%1", (Object)iPicklist);
        this.entryPicklist = iPicklist;
    }

    private IPicklist getInitialEntryPicklist() {
        return this.initialEntryPicklist;
    }

    public boolean isPoiOnlineOneshotRecog() {
        return this.poiOnlineOneshotRecog;
    }

    public String[] getPickListEntryNames() {
        return this.pickListEntryNames;
    }

    public void setPickListEntryNames(String[] stringArray) {
        this.pickListEntryNames = stringArray;
    }

    public void setSuggestions(boolean bl) {
        this.poiOnlineServiceListener.setSuggestions(bl);
    }

    public String getLastDestination(long l) {
        if (SDSUtils.isEmpty(this.lastDestinations)) {
            return "";
        }
        int n = this.lastDestinations.length;
        for (int i2 = 0; i2 < n; ++i2) {
            SDSListEntry sDSListEntry = this.lastDestinations[i2];
            if (sDSListEntry == null || sDSListEntry.getId() != l) continue;
            return sDSListEntry.getName();
        }
        return "";
    }

    public String getFavoriteDestination(long l) {
        if (SDSUtils.isEmpty(this.favoriteDestinations)) {
            return "";
        }
        int n = this.favoriteDestinations.length;
        for (int i2 = 0; i2 < n; ++i2) {
            SDSListEntry sDSListEntry = this.favoriteDestinations[i2];
            if (sDSListEntry == null || sDSListEntry.getId() != l) continue;
            return sDSListEntry.getName();
        }
        return "";
    }

    public String getLastDestinationByIndex(int n) {
        if (n < 0 || n >= this.lastDestinations.length) {
            this.lc.log(100000, "NaviSDSHandlerImpl#getLastDestinationByIndex: Unhandled index %1!", (long)n);
            return "";
        }
        return this.lastDestinations[n].getName();
    }

    public String getFavoriteDestinationByIndex(int n) {
        if (n < 0 || n >= this.favoriteDestinations.length) {
            this.lc.log(100000, "NaviSDSHandlerImpl#getFavoriteDestinationByIndex: Unhandled index %1!", (long)n);
            return "";
        }
        return this.favoriteDestinations[n].getName();
    }

    public void setLastDestinations(SDSListEntry[] sDSListEntryArray) {
        this.lastDestinations = sDSListEntryArray;
    }

    public void setFavoriteDestinations(SDSListEntry[] sDSListEntryArray) {
        this.favoriteDestinations = sDSListEntryArray;
    }

    public boolean initializeEntryPicklist() {
        this.lc.log(10000000, "NaviSDSHandlerImpl#initializeEntryPicklist()!");
        this.initialEntryPicklist = this.nBestStorage.getMatchingPicklist((byte)2);
        if (SDSUtils.isEmpty(this.initialEntryPicklist)) {
            this.lc.log(100000, "NaviSDSHandlerImpl#initializeEntryPicklist: Empty nBestPicklist for multislot, returning false!");
            return false;
        }
        return true;
    }

    public void storeMyAudiContact(AdbEntry adbEntry) {
        this.lc.log(10000000, "NaviSDSHandlerImpl#storeMyAudiContact()!");
        this.currentMyAudiContact = adbEntry;
    }

    public SDSListEntry getMyAudiContactById(long l) {
        if (SDSUtils.isEmpty(this.myAudiContacts)) {
            return null;
        }
        int n = this.myAudiContacts.length;
        for (int i2 = 0; i2 < n; ++i2) {
            SDSListEntry sDSListEntry = this.myAudiContacts[i2];
            if (sDSListEntry == null || sDSListEntry.getId() != l) continue;
            return sDSListEntry;
        }
        return null;
    }

    public SDSListEntry getMyAudiContactByIndex(int n) {
        if (n < 0 || n >= this.myAudiContacts.length) {
            this.lc.log(100000, "NaviSDSHandlerImpl#getMyAudiContactByIndex: Unhandled index %1!", (long)n);
            return null;
        }
        return this.myAudiContacts[n];
    }

    public AdbEntry getCurrentMyAudiContact() {
        return this.currentMyAudiContact;
    }

    public void setTTSASR(ITTSASR iTTSASR) {
        this.ttsASR = iTTSASR;
    }

    public void updateRemainingRange(int n, int n2, int n3) {
        int n4 = n == 2 ? 1 : 0;
        SDSModelAccess.setNaviRangeValue(n2, n4);
        SDSModelAccess.setNaviRangeScaleUnit(n3);
    }

    public void onEnterGoogleMapPopup(int n) {
        int n2 = n == 0 ? 0 : 1;
        this.lc.log(10000000, "NaviSDSHandlerImpl#onEnterGoogleMapPopup: popupType=%1, cachedData=%2", (long)n, (long)n2);
        SDSModelAccess.setNaviGoogleMapAvailableModel(n2);
    }

    public String toString() {
        return "NaviSDSHandlerImpl";
    }

    public void setPoiOnlineDestination(NavLocation navLocation) {
        this.poiOnlineDestination = navLocation;
    }

    public NavLocation getPoiOnlineDestination() {
        return this.poiOnlineDestination;
    }

    public void startCallcenterCallBySDSResult(int n) {
        AbstractSystemCallCommand abstractSystemCallCommand = SDSUtils.getActiveSystemCall();
        if (abstractSystemCallCommand == null) {
            this.lc.log(100000, "NaviSDSHandlerImpl#startCallcenterCallBySDSResult: no active command is available");
            return;
        }
        try {
            ((NaviOperatorcallCommand)abstractSystemCallCommand).startCallcenterCallBySDSResult(n);
        }
        catch (ClassCastException classCastException) {
            this.lc.log(100000, "NaviSDSHandlerImpl#startCallcenterCallBySDSResult: active command is not of type NaviOperatorcallCommand");
        }
    }

    public boolean storePOILineData(int n) {
        this.lc.log(10000000, "NaviSDSHandlerImpl#storePOILineData: absLine=%1", (long)n);
        NaviService.POISDSListEntry pOISDSListEntry = null;
        try {
            pOISDSListEntry = this.naviService.getPOIEntryDetails(n, (byte)1);
        }
        catch (Exception exception) {
            this.lc.log(100000, "NaviSDSHandlerImpl#storePOILineData: Exception (%1) in Navi for getPOIEntryDetails and line %2!", (Object)exception.getMessage(), (long)n);
            return false;
        }
        this.lc.log(10000000, "NaviSDSHandlerImpl#storePOILineData: selectedElement=%1", (Object)pOISDSListEntry);
        if (pOISDSListEntry == null) {
            this.lc.log(100000, "NaviSDSHandlerImpl#storePOILineData: empty selected element!");
            return false;
        }
        SDSModelAccess.setListLineDataGetModel(pOISDSListEntry.getName());
        return true;
    }

    public boolean storePOIPickList(IPicklist iPicklist) {
        SDSListEntry[] sDSListEntryArray = SDSUtils.createSDSListFromPicklist(iPicklist);
        this.lc.log(10000000, "NaviSDSHandlerImpl#showPOIPickListHelper: entries=%1!", (Object)sDSListEntryArray);
        SDSModelAccess.setDisambiguationLabel(sDSListEntryArray);
        return this.naviService.fillPOIPickList(sDSListEntryArray) == 0;
    }

    public boolean storeSUIData(IPicklistElement iPicklistElement, boolean bl) {
        this.lc.log(10000000, "%1#storeSUIData: element=%2", (Object)NaviSDSHandlerImpl.getName(), (Object)iPicklistElement);
        int n = iPicklistElement.getRuleID();
        int n2 = SDSManagerBaseActivator.getMapping().getSUITypeForRule(n);
        this.lc.log(10000000, "%1#storeSUIData: ruleID=%2, suiMappingType=%3!", (Object)NaviSDSHandlerImpl.getName(), (long)n, (long)n2);
        Object[] objectArray = iPicklistElement.getSlots();
        if (SDSUtils.isEmpty(objectArray)) {
            this.lc.log(100000, "%1#storeSUIData: Empty slots!", (Object)NaviSDSHandlerImpl.getName());
            return false;
        }
        switch (n2) {
            case 2: {
                Object object = objectArray[0];
                if (object == null) {
                    this.lc.log(100000, "%1#storeSUIData: Empty first slot!", (Object)NaviSDSHandlerImpl.getName());
                    return false;
                }
                long l = object.getObjID();
                this.lc.log(10000000, "%1#storeSUIData: Setting objID %2 in ADB!", (Object)NaviSDSHandlerImpl.getName(), l);
                this.factory.getSDSHandlerADB().setSelectedEntryID(l);
                break;
            }
            case 4: {
                this.lc.log(10000000, "%1#storeSUIData: Handling POI_CITY!");
                this.handleVDE((IPicklistSlot[])objectArray);
                break;
            }
            case 1: {
                if (bl) {
                    this.lc.log(10000000, "%1#storeSUIData: Handling VDE!", (Object)NaviSDSHandlerImpl.getName());
                    this.storeOneshotSUIData(0, (IPicklistSlot[])objectArray);
                    break;
                }
                this.handleVDE((IPicklistSlot[])objectArray);
                break;
            }
            default: {
                this.lc.log(10000000, "%1#storeSUIData: Unhandled suiMappingType %2!", (Object)NaviSDSHandlerImpl.getName(), (long)n2);
            }
        }
        return true;
    }

    private void handleVDE(IPicklistSlot[] iPicklistSlotArray) {
        byte by = iPicklistSlotArray.length;
        for (byte by2 = 0; by2 < by; by2 = (byte)(by2 + 1)) {
            IPicklistSlot iPicklistSlot = iPicklistSlotArray[by2];
            String string = iPicklistSlot == null ? "" : iPicklistSlot.getText();
            String string2 = iPicklistSlot == null ? "" : iPicklistSlot.getObjectStringID();
            long l = iPicklistSlot == null ? -1L : iPicklistSlot.getObjID();
            this.lc.log(10000000, "%1#storeSUIData: slotText[%4]=%2, slotStringID[%4]=%3!", (Object)NaviSDSHandlerImpl.getName(), (Object)string, (Object)string2, (long)by2);
            this.setOneshotData(new NaviService.OneshotData(string, string2, l), by2);
        }
    }

    private void storeOneshotSUIData(int n, IPicklistSlot[] iPicklistSlotArray) {
        this.initializeOneshotHandler(n);
        if (this.oneshotData != null) {
            this.oneshotHandler.setOneshotData(iPicklistSlotArray);
        }
    }

    private static String getName() {
        return "NaviSDSHandlerImpl";
    }

    public OneshotHandler initializeOneshotHandler(int n) {
        this.lc.log(10000000, "%1#initializeOneshotHandler: usecase=%2", (Object)NaviSDSHandlerImpl.getName(), (long)n);
        this.oneshotHandler = (NaviOneshotHandler)this.oneshotHandlerFactory.initializeUsecase(n, this.nBestStorage.getMatchingPicklist((byte)2));
        return this.oneshotHandler;
    }

    public NaviOneshotHandler getOneshotHandler() {
        return this.oneshotHandler;
    }

    public void setLDCHandling(byte by) {
        this.ldcHandling = by;
    }

    public void updateVDEMediumState(int n) {
        SDSModelAccess.setNavVDEMediumState(n);
    }

    public void setSpokenHouseNumberUnresolved(IPicklistSlot iPicklistSlot) {
        this.lc.log(10000000, "%1#setSpokenHouseNumberUnresolved: storing house number : %2", (Object)NaviSDSHandlerImpl.getName(), (Object)iPicklistSlot);
        this.houseNumberSlot = iPicklistSlot;
        SDSModelAccess.setOneshotHouseNRLabel(iPicklistSlot.getText());
    }

    public IPicklistSlot getSpokenHouseNumberUnresolved() {
        return this.houseNumberSlot;
    }

    public void setAppInfoKrService(AppInfoKrService appInfoKrService) {
        if (appInfoKrService != null) {
            this.appInfoKrService = appInfoKrService;
        }
    }

    public void unsetAppInfoKrService() {
        this.appInfoKrService = new NullAppInfoKrService(this.lc);
    }

    public void responseShowSimpleMap(int n) {
        this.lc.log(10000000, "NaviSDSHandlerImpl#responseShowSimpleMap: replyCode=%1!", (long)n);
        AbstractSystemCallCommand abstractSystemCallCommand = SDSUtils.getActiveSystemCall();
        if (abstractSystemCallCommand instanceof NaviSimpleMapAreaSetCommand) {
            ((NaviSimpleMapAreaSetCommand)abstractSystemCallCommand).responseSimpleMapAreaSet(n);
        } else {
            this.lc.log(100000, "NaviSDSHandlerImpl#responseShowSimpleMap: Active command is not NaviSimpleMapAreaSetCommand but %1!", (Object)abstractSystemCallCommand);
        }
    }

    public void responseStartSimpleMapFreeSelection(int n) {
        this.lc.log(10000000, "NaviSDSHandlerImpl#responseStartSimpleMapFreeSelection: result=%1!", (long)n);
        AbstractSystemCallCommand abstractSystemCallCommand = SDSUtils.getActiveSystemCall();
        if (abstractSystemCallCommand instanceof NaviSimpleMapFreeSelectionInitCommand) {
            ((NaviSimpleMapFreeSelectionInitCommand)abstractSystemCallCommand).responseStartSimpleMapFreeSelection(n);
        } else {
            this.lc.log(100000, "NaviSDSHandlerImpl#responseStartSimpleMapFreeSelection: Active command is not NaviSimpleMapFreeSelectionInitCommand but %1!", (Object)abstractSystemCallCommand);
        }
    }

    public void setAIFCountry(boolean bl) {
        this.aifCountryFlag = bl;
    }

    public boolean getAIFCountry() {
        return this.aifCountryFlag;
    }

    public NaviSDSPOIOnlineService getPOIOnlineService() {
        return this.poiOnlineService;
    }

    public void updateSpeakableSimpleMaps(SDSListEntry[] sDSListEntryArray) {
        this.lc.log(10000000, "[NaviSDSHandlerImpl#updateSpeakableSimpleMaps] called");
        if (sDSListEntryArray == null || sDSListEntryArray.length == 0) {
            this.lc.log(100000, "[NaviSDSHandlerImpl#updateSpeakableStationList] Empty entries!");
            this.dynamicLists.removeFromLookup(56);
            return;
        }
        DynamicSlotContent dynamicSlotContent = new DynamicSlotContent("simple maps", sDSListEntryArray, 0);
        this.dynamicLists.addToLookup(56, dynamicSlotContent);
        this.updateSlotGrammars(56);
    }

    private void updateSlotGrammars(int n) {
        int n2 = SDSManagerBaseActivator.getMapping().getHMISlotGrammar(n);
        this.lc.log(10000000, "[NaviSDSHandlerImpl#updateSlotGrammars] slotMappingID=%1, slotID=%2", (long)n, (long)n2);
        if (!this.dynamicLists.contains(n2)) {
            this.lc.log(100000, "[NaviSDSHandlerImpl#updateSlotGrammars] No slot entries available!");
            return;
        }
        ITTSASRContext iTTSASRContext = this.ttsASR.createGrammarContext();
        iTTSASRContext.addToGrammar(-2000, new int[]{n2}, 8);
        this.ttsASR.setSlotGrammarContext(iTTSASRContext);
    }

    public void responseRefreshSpeakableSimpleMaps(int n) {
        this.lc.log(10000000, "NaviSDSHandlerImpl#responseRefreshSpeakableSimpleMaps: result=%1!", (long)n);
        AbstractSystemCallCommand abstractSystemCallCommand = SDSUtils.getActiveSystemCall();
        if (abstractSystemCallCommand instanceof NaviSimpleMapAreaSetCommand) {
            ((NaviSimpleMapAreaSetCommand)abstractSystemCallCommand).responseRefreshSpeakableSimpleMaps(n);
        } else {
            this.lc.log(100000, "NaviSDSHandlerImpl#responseRefreshSpeakableSimpleMaps: Active command is not NaviSimpleMapAreaSetCommand but %1!", (Object)abstractSystemCallCommand);
        }
    }
}

