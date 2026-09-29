/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.navi;

import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.adb.commands.ADBDestSetCommand;
import de.audi.app.sdsmanager.apps.navi.ISDSNaviDestinationSetCommand;
import de.audi.app.sdsmanager.apps.navi.ISDSNaviGuidanceStartingCommand;
import de.audi.app.sdsmanager.apps.navi.ISDSNaviInputStartingCommand;
import de.audi.app.sdsmanager.apps.navi.ISDSNaviPOIValueSettingCommand;
import de.audi.app.sdsmanager.apps.navi.NaviSDSHandler;
import de.audi.app.sdsmanager.apps.navi.NaviSDSUtils;
import de.audi.app.sdsmanager.apps.navi.commands.NaviAddDestinationCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviAddressInputCorrectionCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviAddressInputCursorCorrectionCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviAlternativeRouteCalcCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviAlternativeRouteNumberSetCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviBlockRouteValueSetCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviCheckRouteGuidanceCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviDestinationDeleteCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviDestinationSetCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviDetailsPhoneCallCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviEnterPoiNameSearchCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviFavoriteDestinationSetCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviGetTpegPOIResultsByCategoryCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviGuidanceStopCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviHouseNumberResolveCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviInputStartedCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviIntelliDestinationSetCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviLastDestinationSetCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviMapCodeAddCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviMapCodeDeleteCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviMapCodeResolveCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviPOIShortCutSetCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviPhoneNumberAddCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviPhoneNumberDeleteCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviPostCodeCheckCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviRouteOptionsSetCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviSpeedLimitGetCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviSynchronizeCountryCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviTrufflesSearchDestinationCommand;
import de.audi.app.sdsmanager.common.Logger;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.grammar.DynamicSlotContent;
import de.audi.app.sdsmanager.grammar.IDynamicLists;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.i18n.ILanguageManager;
import de.audi.atip.interapp.NaviService$NaviInfoDetails;
import de.audi.atip.interapp.NaviService$POISDSListEntry;
import de.audi.atip.interapp.NaviServiceListener;
import de.audi.atip.interapp.SDSListEntry;
import de.audi.atip.interapp.online.IOnlineSDSMyAudiServiceListener;
import de.audi.atip.log.LogChannel;
import de.audi.atip.metrics.DateMetric;
import de.audi.atip.metrics.Distance;
import java.util.ArrayList;

public class NaviServiceListenerImpl
implements NaviServiceListener,
IOnlineSDSMyAudiServiceListener {
    private final LogChannel lc = Logger.getAppNaviLog();
    private final NaviSDSHandler sdsHandler;
    private final IDynamicLists dynamicLists;
    private final ILanguageManager languageManager;
    private final IFrameworkAccess framework;
    private volatile int currentTSQueryID = -1;

    NaviServiceListenerImpl(NaviSDSHandler naviSDSHandler, IDynamicLists iDynamicLists, ILanguageManager iLanguageManager, IFrameworkAccess iFrameworkAccess) {
        this.sdsHandler = naviSDSHandler;
        this.dynamicLists = iDynamicLists;
        this.languageManager = iLanguageManager;
        this.framework = iFrameworkAccess;
    }

    @Override
    public void responseSetLocationPart(byte by) {
        this.lc.log(-2137614336, "NaviServiceListenerImpl#responseSetLocationPart: result=%1", (long)by);
        AbstractSystemCallCommand abstractSystemCallCommand = SDSUtils.getActiveSystemCall();
        if (abstractSystemCallCommand instanceof NaviDestinationSetCommand) {
            ((NaviDestinationSetCommand)abstractSystemCallCommand).sdsDestinationSetResult(by);
        } else if (abstractSystemCallCommand instanceof NaviHouseNumberResolveCommand) {
            ((NaviHouseNumberResolveCommand)abstractSystemCallCommand).sdsDestinationSetResult(by);
        } else {
            this.lc.log(10000, "NaviServiceListenerImpl#responseSetLocationPart: no command or wrong command active");
        }
    }

    @Override
    public void responseQueryLocationPartListLength(byte by, long l, String[] stringArray) {
        this.lc.log(-1601830656, "NaviServiceListenerImpl#responseQueryLocationPartListLength: result=%2, length=%3, entryNames=%1 => NOP!", (Object)stringArray, (long)by, l);
    }

    @Override
    public void responseQuerySpelledLocationPartResultList(byte by, String[] stringArray, Object[] objectArray) {
        this.lc.log(-2137614336, "NaviServiceListenerImpl#responseQuerySpelledLocationPartResultList deprecated -> NOP");
    }

    @Override
    public void responseSetSpelledLocationPart(byte by) {
        this.lc.log(-2137614336, "NaviServiceListenerImpl#responseSetSpelledLocationPart: -> NOP!");
    }

    @Override
    public void responseValidateSpelledStreetName(byte by) {
        this.lc.log(-2137614336, "NaviServiceListenerImpl#responseValidateSpelledStreetName: -> NOP!");
    }

    @Override
    public void responseStartDestinationInput(byte by) {
        this.lc.log(-2137614336, "NaviServiceListenerImpl#responseStartDestinationInput: result=%1", (long)by);
        try {
            AbstractSystemCallCommand abstractSystemCallCommand = SDSUtils.getActiveSystemCall();
            if (abstractSystemCallCommand instanceof ISDSNaviInputStartingCommand) {
                ((ISDSNaviInputStartingCommand)((Object)abstractSystemCallCommand)).responseStartDestinationInput(by);
            } else {
                this.lc.log(10000, "NaviServiceListenerImpl#responseStartDestinationInput: Active command is no ISDSNaviInputStartingCommand!");
            }
        }
        catch (NullPointerException nullPointerException) {
            this.lc.log(10000, "NaviServiceListenerImpl#responseStartDestinationInput: NullpointerException. No active command!");
        }
    }

    @Override
    public void responseTriggerAddressInputReturn(byte by) {
        this.lc.log(-2137614336, "NaviServiceListenerImpl#responseTriggerAddressInputReturn: result=%1", (long)by);
        try {
            AbstractSystemCallCommand abstractSystemCallCommand = SDSUtils.getActiveSystemCall();
            if (abstractSystemCallCommand instanceof NaviAddressInputCorrectionCommand) {
                ((NaviAddressInputCorrectionCommand)abstractSystemCallCommand).responseTriggerAddressInputReturn(by);
            } else if (abstractSystemCallCommand instanceof NaviAddressInputCursorCorrectionCommand) {
                ((NaviAddressInputCursorCorrectionCommand)abstractSystemCallCommand).responseTriggerAddressInputReturn(by);
            } else {
                this.lc.log(10000, "NaviServiceListenerImpl#responseTriggerAddressInputReturn: Active command is no NaviAddressInputCorrectionCommand!");
            }
        }
        catch (NullPointerException nullPointerException) {
            this.lc.log(10000, "NaviServiceListenerImpl#responseTriggerAddressInputReturn: NullpointerException. No active command!");
        }
    }

    @Override
    public void responseFinishDestinationInput(byte by, byte by2) {
        this.lc.log(-1601830656, "NaviServiceListenerImpl#responseFinishDestinationInput: result=%1, status=%2 => NOP!", (long)by, (long)by2);
    }

    @Override
    public void responsePrepareRouteGuidance(byte by, byte by2) {
        this.lc.log(-1601830656, "NaviServiceListenerImpl#responsePrepareRouteGuidance: result=%1, status=%2 => NOP!", (long)by, (long)by2);
    }

    @Override
    public void responseCheckRouteGuidance(byte by) {
        this.lc.log(-2137614336, "NaviServiceListenerImpl#responseCheckRouteGuidance: result=%1", (long)by);
        try {
            ((NaviCheckRouteGuidanceCommand)SDSUtils.getActiveSystemCall()).responseCheckRouteGuidance(by);
        }
        catch (ClassCastException classCastException) {
            this.lc.log(10000, "NaviServiceListenerImpl#responseCheckRouteGuidance: Active command is no NaviCheckRouteGuidanceCommand!");
        }
        catch (NullPointerException nullPointerException) {
            this.lc.log(10000, "NaviServiceListenerImpl#responseCheckRouteGuidance: NullpointerException. No active command!");
        }
    }

    @Override
    public void responseSetRouteOptionCalcType(byte by) {
        this.lc.log(-1601830656, "NaviServiceListenerImpl#responseSetRouteOptionCalcType: NOP!");
    }

    @Override
    public void responseSetRouteOptionDynamic(byte by) {
        this.lc.log(-2137614336, "NaviServiceListenerImpl#responseSetRouteOptionCalcType: result=%1, status=%2", (long)by);
        try {
            ((NaviRouteOptionsSetCommand)SDSUtils.getActiveSystemCall()).responseSetRouteOption(by);
        }
        catch (ClassCastException classCastException) {
            this.lc.log(10000, "NaviServiceListenerImpl#responseSetRouteOptionDynamic: Active command is no NaviRouteOptionsSetCommand!");
        }
        catch (NullPointerException nullPointerException) {
            this.lc.log(10000, "NaviServiceListenerImpl#responseSetRouteOptionDynamic: NullpointerException. No active command!");
        }
    }

    @Override
    public void responseReduceRouteToFinalDestination(byte by) {
        this.lc.log(-2137614336, "NaviServiceListenerImpl#responseReduceRouteToFinalDestination: result=%1, status=%2", (long)by);
        try {
            ((NaviDestinationDeleteCommand)SDSUtils.getActiveSystemCall()).responseReduceRouteToFinalDestination(by);
        }
        catch (ClassCastException classCastException) {
            this.lc.log(10000, "NaviServiceListenerImpl#responseReduceRouteToFinalDestination: Active command is no NaviDestinationDeleteCommand!");
        }
        catch (NullPointerException nullPointerException) {
            this.lc.log(10000, "NaviServiceListenerImpl#responseReduceRouteToFinalDestination: NullpointerException. No active command!");
        }
    }

    @Override
    public void responseSetOneShotData(byte by) {
        this.lc.log(-2137614336, "NaviServiceListenerImpl#responseSetOneShotData: result=%1", (long)by);
        try {
            ((NaviDestinationSetCommand)SDSUtils.getActiveSystemCall()).sdsDestinationSetResult(by);
        }
        catch (ClassCastException classCastException) {
            this.lc.log(10000, "NaviServiceListenerImpl#responseSetOneShotData: Active command is no NaviDestinationSetCommand!");
        }
        catch (NullPointerException nullPointerException) {
            this.lc.log(10000, "NaviServiceListenerImpl#responseSetOneShotData: NullpointerException. No active command!");
        }
    }

    @Override
    public void responseSetDestination(byte by) {
        this.lc.log(-2137614336, "NaviServiceListenerImpl#responseSetDestination: result=%1", (long)by);
        this.handleDestinationResponse(by);
    }

    @Override
    public void responseSetLocation(byte by) {
        this.lc.log(-2137614336, "NaviServiceListenerImpl#responseSetLocation: result=%1", (long)by);
        this.handleDestinationResponse(by);
    }

    private void handleDestinationResponse(byte by) {
        AbstractSystemCallCommand abstractSystemCallCommand = SDSUtils.getActiveSystemCall();
        if (abstractSystemCallCommand == null) {
            this.lc.log(10000, "NaviServiceListenerImpl#responseSetDestination: No command active!");
            return;
        }
        if (abstractSystemCallCommand instanceof ADBDestSetCommand) {
            ((ADBDestSetCommand)abstractSystemCallCommand).sdsDestinationSetResult(by);
        } else if (abstractSystemCallCommand instanceof NaviDestinationSetCommand) {
            ((NaviDestinationSetCommand)abstractSystemCallCommand).sdsDestinationSetResult(by);
        } else if (abstractSystemCallCommand instanceof ISDSNaviDestinationSetCommand) {
            ((ISDSNaviDestinationSetCommand)((Object)abstractSystemCallCommand)).sdsDestinationSetResult(by);
        } else {
            this.lc.log(10000, "NaviSDSHandlerImpl#responseSetLocation: Active command is no ADBDestSetCommand and no NaviDestinationSetCommand!");
        }
    }

    @Override
    public void responseTriggerRouteGuidance(byte by) {
        this.lc.log(-1601830656, "NaviServiceListenerImpl#responseTriggerRouteGuidance: NOP!");
    }

    @Override
    public void responseStopRouteGuidance(byte by) {
        this.lc.log(-2137614336, "NaviServiceListenerImpl#responseStopRouteGuidance: result=%1", (long)by);
        try {
            ((NaviGuidanceStopCommand)SDSUtils.getActiveSystemCall()).responseStopRouteGuidance(by);
        }
        catch (ClassCastException classCastException) {
            this.lc.log(10000, "NaviServiceListenerImpl#responseStopRouteGuidance: Active command is no NaviGuidanceStopCommand!");
        }
        catch (NullPointerException nullPointerException) {
            this.lc.log(10000, "NaviServiceListenerImpl#responseStopRouteGuidance: NullpointerException. No active command!");
        }
    }

    @Override
    public void responseStartRouteGuidance(byte by) {
        this.lc.log(-2137614336, "NaviServiceListenerImpl#responseStartRouteGuidance: result=%1", (long)by);
        try {
            AbstractSystemCallCommand abstractSystemCallCommand = SDSUtils.getActiveSystemCall();
            if (abstractSystemCallCommand != null) {
                ((ISDSNaviGuidanceStartingCommand)((Object)abstractSystemCallCommand)).responseStartRouteGuidance(by);
            } else {
                this.lc.log(10000, "NaviServiceListenerImpl#responseStartRouteGuidance: There is no Active Command!");
            }
        }
        catch (ClassCastException classCastException) {
            this.lc.log(10000, "NaviServiceListenerImpl#responseStartRouteGuidance: Active command doesn't implement the ISDSNaviGuidanceStartingCommand interface!");
        }
    }

    @Override
    public void responseCalculateAlternativeRoutes(byte by) {
        this.lc.log(-2137614336, "NaviServiceListenerImpl#responseCalculateAlternativeRoutes: result=%1", (long)by);
        try {
            AbstractSystemCallCommand abstractSystemCallCommand = SDSUtils.getActiveSystemCall();
            if (abstractSystemCallCommand != null) {
                ((NaviAlternativeRouteCalcCommand)abstractSystemCallCommand).responseCalculateAlternativeRoutes(by);
            } else {
                this.lc.log(1078071040, "NaviServiceListenerImpl#responseCalculateAlternativeRoutes: There is no active command!");
            }
        }
        catch (ClassCastException classCastException) {
            this.lc.log(10000, "NaviServiceListenerImpl#responseCalculateAlternativeRoutes: Active command is no NaviAlternativeRouteCalcCommand!");
        }
    }

    @Override
    public void responseSelectAlternativeRoute(byte by) {
        this.lc.log(-2137614336, "NaviServiceListenerImpl#responseSelectAlternativeRoute: result=%1", (long)by);
        try {
            ((NaviAlternativeRouteNumberSetCommand)SDSUtils.getActiveSystemCall()).responseSelectAlternativeRoute(by);
        }
        catch (ClassCastException classCastException) {
            this.lc.log(10000, "NaviServiceListenerImpl#responseSelectAlternativeRoute: Active command is no NaviAlternativeRouteNumberSetCommand!");
        }
        catch (NullPointerException nullPointerException) {
            this.lc.log(10000, "NaviServiceListenerImpl#responseSelectAlternativeRoute: NullpointerException. No active command!");
        }
    }

    @Override
    public void responseSelectTopPOI(byte by) {
        this.lc.log(-2137614336, "NaviServiceListenerImpl#responseSelectTopPOI: result=%1", (long)by);
        AbstractSystemCallCommand abstractSystemCallCommand = SDSUtils.getActiveSystemCall();
        if (abstractSystemCallCommand instanceof NaviPOIShortCutSetCommand) {
            ((NaviPOIShortCutSetCommand)SDSUtils.getActiveSystemCall()).responsePOISelection(by);
        } else if (abstractSystemCallCommand instanceof NaviGetTpegPOIResultsByCategoryCommand) {
            ((NaviGetTpegPOIResultsByCategoryCommand)SDSUtils.getActiveSystemCall()).responseSelectTopPOI(by);
        } else {
            this.lc.log(10000, "NaviServiceListenerImpl#responseSelectTopPOI: Active command is no NaviPOIShortCutSetCommand!");
        }
    }

    @Override
    public void responseSelectPOI(byte by, NaviService$POISDSListEntry[] naviService$POISDSListEntryArray) {
        this.lc.log(-2137614336, "NaviServiceListenerImpl#responseSelectPOI: result=%2, entries=%1", (Object)SDSUtils.toString((Object[])naviService$POISDSListEntryArray, false), (long)by);
        AbstractSystemCallCommand abstractSystemCallCommand = SDSUtils.getActiveSystemCall();
        if (abstractSystemCallCommand instanceof ISDSNaviPOIValueSettingCommand) {
            ((ISDSNaviPOIValueSettingCommand)((Object)SDSUtils.getActiveSystemCall())).responseSelectPOIByUID(by, naviService$POISDSListEntryArray);
        } else if (abstractSystemCallCommand instanceof NaviPOIShortCutSetCommand) {
            ((NaviPOIShortCutSetCommand)SDSUtils.getActiveSystemCall()).responsePOISelection(by);
        } else {
            this.lc.log(10000, "NaviServiceListenerImpl#responseSelectPOI: Active command is no NaviPOIValueSetCommand!");
        }
    }

    @Override
    public void responseSelectPOIbyListIndex(byte by) {
        this.lc.log(-2137614336, "NaviServiceListenerImpl#responseSelectPOIbyListIndex: result=%1", (long)by);
        try {
            ((ISDSNaviPOIValueSettingCommand)((Object)SDSUtils.getActiveSystemCall())).responseSelectPOIByListIndex(by);
        }
        catch (ClassCastException classCastException) {
            this.lc.log(10000, "NaviServiceListenerImpl#responseSelectPOIbyListIndex: Active command is no NaviPOIValueSetCommand!");
        }
        catch (NullPointerException nullPointerException) {
            this.lc.log(10000, "NaviServiceListenerImpl#responseSelectPOIbyListIndex: NullpointerException. No active command!");
        }
    }

    @Override
    public void responseBlockRoute(byte by) {
        this.lc.log(-2137614336, "NaviServiceListenerImpl#responseBlockRoute: result=%1", (long)by);
        try {
            ((NaviBlockRouteValueSetCommand)SDSUtils.getActiveSystemCall()).responseBlockRoute(by);
        }
        catch (ClassCastException classCastException) {
            this.lc.log(10000, "NaviServiceListenerImpl#responseBlockRoute: Active command is no NaviBlockRouteValueSetCommand!");
        }
        catch (NullPointerException nullPointerException) {
            this.lc.log(10000, "NaviServiceListenerImpl#responseBlockRoute: NullpointerException. No active command!");
        }
    }

    @Override
    public void responseUnblockRoute(byte by) {
        this.lc.log(-2137614336, "NaviServiceListenerImpl#responseUnblockRoute: result=%1", (long)by);
        try {
            ((NaviBlockRouteValueSetCommand)SDSUtils.getActiveSystemCall()).responseUnblockRoute(by);
        }
        catch (ClassCastException classCastException) {
            this.lc.log(10000, "NaviServiceListenerImpl#responseUnblockRoute: Active command is no NaviBlockRouteValueSetCommand!");
        }
        catch (NullPointerException nullPointerException) {
            this.lc.log(10000, "NaviServiceListenerImpl#responseUnblockRoute: NullpointerException. No active command!");
        }
    }

    @Override
    public void responsePostCodeFormat(byte by, boolean bl) {
        this.lc.log(-2137614336, "NaviServiceListenerImpl#responsePostCodeFormat: result=%2, isNumeric=%1", bl, (long)by);
        try {
            ((NaviPostCodeCheckCommand)SDSUtils.getActiveSystemCall()).sdsPostCodeCheckResult(by, bl);
        }
        catch (ClassCastException classCastException) {
            this.lc.log(10000, "NaviServiceListenerImpl#responsePostCodeFormat: Active command is no NaviPostCodeCheckCommand!");
        }
        catch (NullPointerException nullPointerException) {
            this.lc.log(10000, "NaviServiceListenerImpl#responsePostCodeFormat: NullpointerException. No active command!");
        }
    }

    @Override
    public void responseCurrentSpeedLimit(byte by, int n, byte by2) {
        this.lc.log(-2137614336, "NaviServiceListenerImpl#responseCurrentSpeedLimit: result=%1, speedLimit=%2, speedUnit=%3", (long)by, (long)n, (long)by2);
        try {
            ((NaviSpeedLimitGetCommand)SDSUtils.getActiveSystemCall()).responseCurrentSpeedLimit(by, n, by2);
        }
        catch (ClassCastException classCastException) {
            this.lc.log(10000, "NaviServiceListenerImpl#responseCurrentSpeedLimit: Active command is no NaviSpeedLimitGetCommand!");
        }
        catch (NullPointerException nullPointerException) {
            this.lc.log(10000, "NaviServiceListenerImpl#responseCurrentSpeedLimit: NullpointerException. No active command!");
        }
    }

    @Override
    public void updateFavoriteDestinations(SDSListEntry[] sDSListEntryArray) {
        if (sDSListEntryArray == null) {
            this.lc.log(-1601830656, "NaviServiceListenerImpl#updateFavoriteDestinations: No entries given!");
            return;
        }
        this.lc.log(-2137614336, "NaviServiceListenerImpl#updateFavoriteDestinations: favorites.length=%1!", (long)sDSListEntryArray.length);
        this.sdsHandler.setFavoriteDestinations(sDSListEntryArray);
        this.dynamicLists.addToLookup(22, new DynamicSlotContent("navi favorites", sDSListEntryArray, 0));
    }

    @Override
    public void updateLastDestinations(SDSListEntry[] sDSListEntryArray) {
        if (sDSListEntryArray == null) {
            this.lc.log(-1601830656, "NaviServiceListenerImpl#updateLastDestinations: No entries given!");
            return;
        }
        this.lc.log(-2137614336, "NaviServiceListenerImpl#updateLastDestinations: destinations.length=%1!", (long)sDSListEntryArray.length);
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < sDSListEntryArray.length; ++i2) {
            if (sDSListEntryArray[i2] == null || SDSUtils.isEmpty(sDSListEntryArray[i2].getName())) continue;
            arrayList.add(sDSListEntryArray[i2]);
        }
        SDSListEntry[] sDSListEntryArray2 = (SDSListEntry[])arrayList.toArray(new SDSListEntry[arrayList.size()]);
        this.sdsHandler.setLastDestinations(sDSListEntryArray);
        this.dynamicLists.addToLookup(21, new DynamicSlotContent("navi last destinations", sDSListEntryArray2, 0));
    }

    @Override
    public void updateMyAudiContacts(SDSListEntry[] sDSListEntryArray) {
        this.sdsHandler.setMyAudiContacts(sDSListEntryArray);
        this.dynamicLists.addToLookup(23, new DynamicSlotContent("my audi contacts", sDSListEntryArray, 0));
        SDSModelAccess.setMyAudiGrammarAvailableModel(SDSUtils.isEmpty(sDSListEntryArray) ? 0 : 1);
    }

    @Override
    public void updateFullyOperableStateChanged(boolean bl) {
        this.lc.log(-2137614336, "NaviServiceListenerImpl#updateFullyOperableStateChanged: operable=%1", bl);
    }

    @Override
    public void updateDestinationCountryCode(String string, String string2) {
        this.lc.log(-2137614336, "NaviServiceListenerImpl#updateDestinationCountryCode: country=%1, countryAbbreviation=%2", (Object)string, (Object)string2);
        this.sdsHandler.updateDestinationCountryCode(string, string2);
    }

    @Override
    public void updateDestinationStateCode(String string, String string2) {
        this.lc.log(-2137614336, "NaviServiceListenerImpl#updateDestinationStateCode: state=%1, stateAbbreviation=%2", (Object)string, (Object)string2);
        this.sdsHandler.updateDestinationStateCode(string, string2);
    }

    @Override
    public void responseAddSelectedDestinationAtIndex(byte by) {
        this.lc.log(-2137614336, "NaviServiceListenerImpl#responseAddSelectedDestinationAtIndex: result=%1", (long)by);
        try {
            ((NaviAddDestinationCommand)SDSUtils.getActiveSystemCall()).responseAddSelectedDestinationAtIndex(by);
        }
        catch (ClassCastException classCastException) {
            this.lc.log(10000, "NaviServiceListenerImpl#responseAddSelectedDestinationAtIndex: Active command is not NaviAddDestinationCommand!");
        }
        catch (NullPointerException nullPointerException) {
            this.lc.log(10000, "NaviServiceListenerImpl#responseAddSelectedDestinationAtIndex: NullpointerException. No active command!");
        }
    }

    @Override
    public void responseSetLastDestination(byte by) {
        this.lc.log(-2137614336, "NaviServiceListenerImpl#responseSetLastDestinationByIndex: result=%1", (long)by);
        try {
            ((NaviLastDestinationSetCommand)SDSUtils.getActiveSystemCall()).responseLastDestinationSet(by);
        }
        catch (ClassCastException classCastException) {
            this.lc.log(10000, "NaviServiceListenerImpl#responseSetLastDestinationByIndex: Active command is not NaviLastDestinationSetCommand!");
        }
        catch (NullPointerException nullPointerException) {
            this.lc.log(10000, "NaviServiceListenerImpl#responseSetLastDestinationByIndex: NullpointerException. No active command!");
        }
    }

    @Override
    public void responseSetFavoriteDestination(byte by) {
        this.lc.log(-2137614336, "NaviServiceListenerImpl#responseSetFavoriteDestinationByIndex: result=%1", (long)by);
        try {
            ((NaviFavoriteDestinationSetCommand)SDSUtils.getActiveSystemCall()).responseFavoriteDestinationSet(by);
        }
        catch (ClassCastException classCastException) {
            this.lc.log(10000, "NaviServiceListenerImpl#responseSetFavoriteDestinationByIndex: Active command is not NaviFavoriteDestinationSetCommand!");
        }
        catch (NullPointerException nullPointerException) {
            this.lc.log(10000, "NaviServiceListenerImpl#responseSetFavoriteDestinationByIndex: NullpointerException. No active command!");
        }
    }

    @Override
    public void updateTrafficSituation(boolean bl, DateMetric dateMetric, int n, long l, int n2) {
        int n3;
        if (n2 == 0) {
            this.lc.log(-2137614336, "NaviServiceListenerImpl#updateTrafficSituation: Invalid update!");
            return;
        }
        this.lc.log(-2137614336, "NaviServiceListenerImpl#updateTrafficSituation: delay=%1, delayTime=%2, tmcEventsOnRoute=%3!", (Object)bl, (Object)dateMetric, (long)n);
        this.lc.log(-2137614336, "NaviServiceListenerImpl#updateTrafficSituation: distanceToNextEvent=%1", l);
        String string = bl ? NaviSDSUtils.formatTimeString(dateMetric, this.languageManager, this.framework, this.lc) : "";
        StringBuffer stringBuffer = new StringBuffer(string);
        if (bl && this.framework.isJp() && "ja_JP".equals(this.languageManager.getCurrentLanguage("LANG_COMPONENT_TTS").getLanguageCode())) {
            stringBuffer = new StringBuffer();
            n3 = string.indexOf(32);
            if (n3 != -1) {
                stringBuffer.append(string.substring(0, n3)).append(string.substring(n3 + 1));
            }
        }
        this.lc.log(-2137614336, "NaviServiceListenerImpl#updateTrafficSituation: timeString=%1!", (Object)string);
        SDSModelAccess.setNavTrafficDelayTime(stringBuffer.toString());
        if (n > 0) {
            int n4;
            float f2;
            n3 = n;
            NaviService$NaviInfoDetails naviService$NaviInfoDetails = this.sdsHandler.getNaviService().getNaviInfo(true);
            boolean bl2 = naviService$NaviInfoDetails != null ? naviService$NaviInfoDetails.distanceUnit == 0 || naviService$NaviInfoDetails.distanceUnit == 1 : true;
            Distance distance = new Distance(l, 5);
            if (bl2) {
                if (distance.getValue(1) < 1.0f) {
                    f2 = distance.getValue(5);
                    n4 = 1;
                } else {
                    f2 = distance.getValue(1);
                    n4 = 0;
                }
            } else if (distance.getValue(2) < 1.0f) {
                if (this.framework.isPorsche() && this.framework.isNar() && "en_US".equals(this.framework.getLanguageMgr().getCurrentLanguage("LANG_COMPONENT_HMI").getLanguageCode())) {
                    f2 = distance.getValue(3);
                    n4 = 4;
                } else {
                    f2 = distance.getValue(4);
                    n4 = 3;
                }
            } else {
                f2 = distance.getValue(2);
                n4 = 2;
            }
            SDSModelAccess.setNavTrafficDistance((int)f2);
            SDSModelAccess.setNavTrafficInfoScaleUnit(n4);
        } else if (bl) {
            n3 = 1;
            SDSModelAccess.setNavTrafficDistance(-1);
        } else {
            n3 = 0;
        }
        SDSModelAccess.setNavTrafficEventsOnRoute(n3);
    }

    @Override
    public void responseIntelliDestination(byte by) {
        this.lc.log(-2137614336, "NaviServiceListenerImpl#responseIntelliDestination: result=%1", (long)by);
        try {
            ((NaviIntelliDestinationSetCommand)SDSUtils.getActiveSystemCall()).responseIntelliDestinationSet(by);
        }
        catch (ClassCastException classCastException) {
            this.lc.log(10000, "NaviServiceListenerImpl#responseIntelliDestination: Active command is not NaviIntelliDestinationSetCommand!");
        }
        catch (NullPointerException nullPointerException) {
            this.lc.log(10000, "NaviServiceListenerImpl#responseIntelliDestination: NullpointerException. No active command!");
        }
    }

    @Override
    public void responseDialDetailsNumber(byte by) {
        this.lc.log(-2137614336, "NaviServiceListenerImpl#responseDialDetailsNumber: result=%1", (long)by);
        try {
            ((NaviDetailsPhoneCallCommand)SDSUtils.getActiveSystemCall()).responseDialDetailsNumber(by);
        }
        catch (ClassCastException classCastException) {
            this.lc.log(10000, "NaviServiceListenerImpl#responseIntelliDestination: Active command is not NaviDetailsPhoneCallCommand!");
        }
        catch (NullPointerException nullPointerException) {
            this.lc.log(10000, "NaviServiceListenerImpl#responseIntelliDestination: NullpointerException. No active command!");
        }
    }

    @Override
    public void updateRgActive(boolean bl) {
    }

    @Override
    public void responseMapCodeResult(byte by) {
        this.lc.log(-2137614336, "NaviServiceListenerImpl#responseMapCodeResult: result=%1", (long)by);
        try {
            AbstractSystemCallCommand abstractSystemCallCommand = SDSUtils.getActiveSystemCall();
            if (abstractSystemCallCommand != null) {
                if (abstractSystemCallCommand instanceof NaviMapCodeAddCommand) {
                    ((NaviMapCodeAddCommand)abstractSystemCallCommand).mapCodeAddResult(by);
                } else if (abstractSystemCallCommand instanceof NaviMapCodeDeleteCommand) {
                    ((NaviMapCodeDeleteCommand)abstractSystemCallCommand).mapCodeDeleteResult(by);
                } else if (abstractSystemCallCommand instanceof NaviMapCodeResolveCommand) {
                    ((NaviMapCodeResolveCommand)abstractSystemCallCommand).mapCodeResolveResult(by);
                } else if (abstractSystemCallCommand instanceof NaviDestinationSetCommand) {
                    ((NaviDestinationSetCommand)abstractSystemCallCommand).sdsDestinationSetResult(by);
                } else if (abstractSystemCallCommand instanceof NaviInputStartedCommand) {
                    ((NaviInputStartedCommand)abstractSystemCallCommand).responseStartDestinationInput(by);
                } else if (abstractSystemCallCommand instanceof NaviAddressInputCorrectionCommand) {
                    ((NaviAddressInputCorrectionCommand)abstractSystemCallCommand).responseMapCodeResult(by);
                }
            } else {
                this.lc.log(10000, "NaviServiceListenerImpl#responseMapCodeResult: There is no Active Command!");
            }
        }
        catch (ClassCastException classCastException) {
            this.lc.log(10000, "NaviServiceListenerImpl#responseMapCodeResult: Active command is not of Map Code Command Set!");
        }
    }

    @Override
    public void responseTelephoneNumberResult(byte by) {
        this.lc.log(-2137614336, "NaviServiceListenerImpl#responseTelephoneNumberResult: result=%1", (long)by);
        try {
            AbstractSystemCallCommand abstractSystemCallCommand = SDSUtils.getActiveSystemCall();
            if (abstractSystemCallCommand != null) {
                if (abstractSystemCallCommand instanceof NaviPhoneNumberAddCommand) {
                    ((NaviPhoneNumberAddCommand)abstractSystemCallCommand).naviPhoneNumberAddResult(by);
                } else if (abstractSystemCallCommand instanceof NaviPhoneNumberDeleteCommand) {
                    ((NaviPhoneNumberDeleteCommand)abstractSystemCallCommand).naviPhoneNumberDeleteResult(by);
                } else if (abstractSystemCallCommand instanceof NaviDestinationSetCommand) {
                    ((NaviDestinationSetCommand)abstractSystemCallCommand).sdsDestinationSetResult(by);
                } else if (abstractSystemCallCommand instanceof NaviInputStartedCommand) {
                    ((NaviInputStartedCommand)abstractSystemCallCommand).responseStartDestinationInput(by);
                }
            } else {
                this.lc.log(10000, "NaviServiceListenerImpl#responseMapCodeResult: There is no Active Command!");
            }
        }
        catch (ClassCastException classCastException) {
            this.lc.log(10000, "NaviServiceListenerImpl#responseMapCodeResult: Active command is not of Map Code Command Set!");
        }
    }

    @Override
    public void responseStartPoiSearchByName(byte by) {
        this.lc.log(-2137614336, "NaviServiceListenerImpl#responseStartPoiSearchByName: result=%1", (long)by);
        AbstractSystemCallCommand abstractSystemCallCommand = SDSUtils.getActiveSystemCall();
        if (abstractSystemCallCommand instanceof NaviEnterPoiNameSearchCommand) {
            ((NaviEnterPoiNameSearchCommand)abstractSystemCallCommand).responseStartPoiSearchByName(by);
        } else {
            this.lc.log(-1601830656, "NaviServiceListenerImpl#responseStartPoiSearchByName: result=%1, but no active systemcall!", (long)by);
        }
    }

    @Override
    public void updateResponseStartTrufflesSearch(byte by, int n, boolean bl, int n2) {
        AbstractSystemCallCommand abstractSystemCallCommand;
        if (this.currentTSQueryID == n2 && (abstractSystemCallCommand = SDSUtils.getActiveSystemCall()) instanceof NaviTrufflesSearchDestinationCommand) {
            this.lc.log(-2137614336, "NaviServiceListenerImpl#updateResponseStartTrufflesSearch: result=%1, numberOfSearchResults=%2 and navDBSearchEnded=%3!", (long)by, (long)n, bl);
            this.lc.log(-2137614336, "NaviServiceListenerImpl#updateResponseStartTrufflesSearch: queryID=%1", (long)n2);
            ((NaviTrufflesSearchDestinationCommand)abstractSystemCallCommand).updateResponseStartTrufflesSearch(by, n, bl, n2);
        }
    }

    public void setTrufflesSearchQueryID(int n) {
        this.currentTSQueryID = n;
    }

    @Override
    public void responseSynchronizeSpeechCountryWithCurrentLDResult(byte by, boolean bl) {
        this.lc.log(-2137614336, "NaviServiceListenerImpl#responseSynchronizeSpeechCountryWithCurrentLDResult: result=%1", (long)by);
        AbstractSystemCallCommand abstractSystemCallCommand = SDSUtils.getActiveSystemCall();
        if (abstractSystemCallCommand instanceof NaviSynchronizeCountryCommand) {
            ((NaviSynchronizeCountryCommand)abstractSystemCallCommand).responseSynchronizeSpeechCountryWithCurrentLDResult(by, bl);
        } else {
            this.lc.log(-1601830656, "NaviServiceListenerImpl#responseSynchronizeSpeechCountryWithCurrentLDResult: result=%1, but no active systemcall!", (long)by);
        }
    }
}

