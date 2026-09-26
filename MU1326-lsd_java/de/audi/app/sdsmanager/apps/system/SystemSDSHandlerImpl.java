/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.system;

import de.audi.app.sdsmanager.AppSDSManager;
import de.audi.app.sdsmanager.SDSAudioHandler;
import de.audi.app.sdsmanager.SDSHMIListener;
import de.audi.app.sdsmanager.SDSManagerBaseActivator;
import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.apps.AbstractSDSApplication;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.PlayPrioPromptCallback;
import de.audi.app.sdsmanager.apps.SDSAppFactory;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.SDSTimeoutHandler;
import de.audi.app.sdsmanager.apps.system.ISDSScreenConnectedUpdatable;
import de.audi.app.sdsmanager.apps.system.ISDSScreenFadedOutUpdatable;
import de.audi.app.sdsmanager.apps.system.ISystemSessionEndCommand;
import de.audi.app.sdsmanager.apps.system.ISystemSessionStartCommand;
import de.audi.app.sdsmanager.apps.system.ISystemVBIHandler;
import de.audi.app.sdsmanager.apps.system.SystemSDSHandler;
import de.audi.app.sdsmanager.apps.system.commands.SystemAbortStartCommand;
import de.audi.app.sdsmanager.apps.system.commands.SystemAbsoluteLineNumberSetCommand;
import de.audi.app.sdsmanager.apps.system.commands.SystemAnyCalledCommand;
import de.audi.app.sdsmanager.apps.system.commands.SystemCommandListHideCommand;
import de.audi.app.sdsmanager.apps.system.commands.SystemCommandListShowCommand;
import de.audi.app.sdsmanager.apps.system.commands.SystemConnectionAcceptCommand;
import de.audi.app.sdsmanager.apps.system.commands.SystemCorrectionCaseCommand;
import de.audi.app.sdsmanager.apps.system.commands.SystemCounterIncrementCommand;
import de.audi.app.sdsmanager.apps.system.commands.SystemCounterResetCommand;
import de.audi.app.sdsmanager.apps.system.commands.SystemCursorHighlightLineCommand;
import de.audi.app.sdsmanager.apps.system.commands.SystemDisambiguationListHideCommand;
import de.audi.app.sdsmanager.apps.system.commands.SystemDisambiguationListShowCommand;
import de.audi.app.sdsmanager.apps.system.commands.SystemDisclaimerAcceptCommand;
import de.audi.app.sdsmanager.apps.system.commands.SystemGraphemicGroupRecognizedCommand;
import de.audi.app.sdsmanager.apps.system.commands.SystemIncrementModelCommand;
import de.audi.app.sdsmanager.apps.system.commands.SystemJumpPointActionCommand;
import de.audi.app.sdsmanager.apps.system.commands.SystemListClearCommand;
import de.audi.app.sdsmanager.apps.system.commands.SystemListHideCommand;
import de.audi.app.sdsmanager.apps.system.commands.SystemListLineDataGetCommand;
import de.audi.app.sdsmanager.apps.system.commands.SystemListLineGetCommand;
import de.audi.app.sdsmanager.apps.system.commands.SystemListLineRequestCommand;
import de.audi.app.sdsmanager.apps.system.commands.SystemListLineSetCommand;
import de.audi.app.sdsmanager.apps.system.commands.SystemListPageSetCommand;
import de.audi.app.sdsmanager.apps.system.commands.SystemListShowCommand;
import de.audi.app.sdsmanager.apps.system.commands.SystemParamSetNLUCommand;
import de.audi.app.sdsmanager.apps.system.commands.SystemPlayBeepCommand;
import de.audi.app.sdsmanager.apps.system.commands.SystemRemoveFromPicklistHistoryCommand;
import de.audi.app.sdsmanager.apps.system.commands.SystemSecondCounterIncrementCommand;
import de.audi.app.sdsmanager.apps.system.commands.SystemSecondCounterResetCommand;
import de.audi.app.sdsmanager.apps.system.commands.SystemSessionEndCommand;
import de.audi.app.sdsmanager.apps.system.commands.SystemSessionStartCommand;
import de.audi.app.sdsmanager.apps.system.commands.SystemSessionWaitCommand;
import de.audi.app.sdsmanager.apps.system.commands.SystemSetModelCommand;
import de.audi.app.sdsmanager.apps.system.commands.SystemSlotSetNLUCommand;
import de.audi.app.sdsmanager.apps.system.commands.SystemStartRecognitionCommand;
import de.audi.app.sdsmanager.apps.system.commands.SystemStateSetCommand;
import de.audi.app.sdsmanager.apps.system.commands.SystemStorePicklistInHistoryCommand;
import de.audi.app.sdsmanager.apps.system.commands.SystemTTSAbortCommand;
import de.audi.app.sdsmanager.apps.system.commands.SystemWaitForScreenConnectedCommand;
import de.audi.app.sdsmanager.apps.system.commands.SystemWaitForScreenFadedOutCommand;
import de.audi.app.sdsmanager.apps.system.commands.SystemWaitStateCommand;
import de.audi.app.sdsmanager.common.ISDSPopupHelper;
import de.audi.app.sdsmanager.common.Logger;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.dsi.SpeechRecognitionHandler;
import de.audi.app.sdsmanager.dsi.SpeechTTSHandler;
import de.audi.app.sdsmanager.nbest.NBestStorageAccess;
import de.audi.app.sdsmanager.syscall.ISystemCallParameter;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.interapp.ISdsConnectivityService;
import de.audi.atip.interapp.def.NullSDSConnectivityService;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.CommandListManager;
import org.dsi.ifc.speechrec.NBestList;

public class SystemSDSHandlerImpl
extends AbstractSDSApplication
implements SystemSDSHandler {
    private static final int[] commands = new int[]{1000, 1055, 1001, 1002, 1003, 1007, 1029, 1045, 1063, 1012, 1013, 1014, 1015, 1010, 1058, 1048, 1047, 1057, 1035, 1017, 1019, 1020, 1021, 1022, 1023, 1024, 1056, 1025, 1027, 1053, 1030, 1032, 1034, 1059, 1038, 1039, 1040, 1049, 1051, 1041, 1043, 1042, 1052, 1044, 1046, 1061, 1062, 1064};
    private LogChannel lc = Logger.getAppSystemLog();
    private final HMIService hmiService;
    private final SpeechRecognitionHandler srHandler;
    private final SpeechTTSHandler ttsHandler;
    private final AppSDSManager sdsManager;
    private final SDSHMIListener hmiListener;
    private CommandListManager grammarCmdListManager;
    private final SDSAudioHandler audioHandler;
    private final SDSAppFactory factory;
    private final SDSTimeoutHandler sdsTimeoutHandler;
    private final ISDSPopupHelper sdsPopupHelper;
    private ISystemVBIHandler systemVBIHandler;
    private ISdsConnectivityService connectivityService = new NullSDSConnectivityService(this.lc);
    private byte abortingType = 0;
    private int abortingEventID = -1;
    private boolean abortingDirect = false;
    private PlayPrioPromptCallback playPrioPromptCallback;

    public SystemSDSHandlerImpl(SDSAppFactory sDSAppFactory, IFrameworkAccess iFrameworkAccess, SDSHandlerService sDSHandlerService, SpeechRecognitionHandler speechRecognitionHandler, SpeechTTSHandler speechTTSHandler, AppSDSManager appSDSManager, SDSHMIListener sDSHMIListener, SDSAudioHandler sDSAudioHandler, NBestStorageAccess nBestStorageAccess, SDSTimeoutHandler sDSTimeoutHandler, ISDSPopupHelper iSDSPopupHelper) {
        super(sDSHandlerService, nBestStorageAccess);
        this.factory = sDSAppFactory;
        this.hmiService = iFrameworkAccess.getHMIService();
        this.srHandler = speechRecognitionHandler;
        this.ttsHandler = speechTTSHandler;
        this.sdsManager = appSDSManager;
        this.hmiListener = sDSHMIListener;
        this.audioHandler = sDSAudioHandler;
        this.sdsTimeoutHandler = sDSTimeoutHandler;
        this.sdsPopupHelper = iSDSPopupHelper;
        this.lc.log(-2137614336, "SystemSDSHandlerImpl initialized.");
    }

    @Override
    public int[] getCommands() {
        return commands;
    }

    @Override
    public void sessionEnded() {
        this.lc.log(-2137614336, "SystemSDSHandlerImpl#sessionEnded: called");
        this.sdsPopupHelper.removeSmallCommandDisplay();
    }

    @Override
    public void processCommand(int n, ISystemCallParameter[] iSystemCallParameterArray) {
        this.lc.log(-2137614336, "SystemSDSHandlerImpl#processCommand: id=%2, params=%1", (Object)SDSUtils.toString((Object[])iSystemCallParameterArray, false), (Object)SDSManagerBaseActivator.getSystemCallNames().getName(n));
        CommandList commandList = new CommandList(SDSManagerBaseActivator.getSysCallCmdListManager());
        if (SystemSDSHandlerImpl.isDisplayCommand(n)) {
            this.processDisplayCommand(n, iSystemCallParameterArray, commandList);
        } else if (SystemSDSHandlerImpl.isGenericCommand(n)) {
            this.processGenericCommand(n, iSystemCallParameterArray, commandList);
        } else if (SystemSDSHandlerImpl.isConnectivityCommand(n)) {
            this.processConnectivityCommand(n, iSystemCallParameterArray, commandList);
        } else {
            this.processMainCommand(n, iSystemCallParameterArray, commandList);
        }
    }

    private void processConnectivityCommand(int n, ISystemCallParameter[] iSystemCallParameterArray, CommandList commandList) {
        switch (n) {
            case 1057: {
                commandList.add(new SystemDisclaimerAcceptCommand(this.lc, "SYSTEM_DISCLAIMERACCEPT", this.sdsHandlerService, this.connectivityService, iSystemCallParameterArray));
                commandList.execute("SYSTEMCALL SYSTEM_DISCLAIMERACCEPT");
                break;
            }
            case 1029: {
                commandList.add(new SystemConnectionAcceptCommand(this.lc, "SYSTEM_CONNECTIONACCEPT", this.sdsHandlerService, this.connectivityService, iSystemCallParameterArray));
                commandList.execute("SYSTEMCALL SYSTEM_CONNECTIONACCEPT");
                break;
            }
            default: {
                this.lc.log(10000, "SystemSDSHandlerImpl#processMainCommand: Unhandled id %1!", (long)n);
            }
        }
    }

    private void processMainCommand(int n, ISystemCallParameter[] iSystemCallParameterArray, CommandList commandList) {
        switch (n) {
            case 1000: {
                commandList.add(new SystemAbortStartCommand(this.lc, "SYSTEM_ABORTSTART", this.sdsHandlerService, this.sdsManager));
                commandList.execute("SYSTEMCALL SYSTEM_ABORTSTART");
                this.sdsManager.setSDSAborting(true);
                break;
            }
            case 1019: {
                commandList.add(new SystemJumpPointActionCommand(this.lc, "SYSTEM_JUMPPOINTACTION", this.sdsHandlerService));
                commandList.execute("SYSTEMCALL SYSTEM_JUMPPOINTACTION");
                break;
            }
            case 1032: {
                commandList.add(new SystemPlayBeepCommand(this.lc, "SYSTEM_PLAYBEEP", this.sdsHandlerService, this.ttsHandler, iSystemCallParameterArray));
                commandList.execute("SYSTEMCALL SYSTEM_PLAYBEEP");
                break;
            }
            case 1034: {
                this.promptTypeSet(iSystemCallParameterArray);
                break;
            }
            case 1039: {
                commandList.add(new SystemSessionStartCommand(this.lc, "SYSTEM_SESSIONSTART", this.sdsHandlerService, this.sdsManager, this.srHandler, this.nBestStorage));
                commandList.execute("SYSTEMCALL SYSTEM_SESSIONSTART");
                break;
            }
            case 1038: {
                commandList.add(new SystemSessionEndCommand(this.lc, "SYSTEM_SESSIONEND", this.sdsHandlerService, this.sdsManager, this.srHandler, this.audioHandler, this.sdsPopupHelper));
                commandList.execute("SYSTEMCALL SYSTEM_SESSIONEND");
                break;
            }
            case 1040: {
                commandList.add(new SystemSessionWaitCommand(this.lc, "SYSTEM_SESSIONWAIT", this.sdsHandlerService, this.audioHandler, this.sdsManager, null));
                commandList.execute("SYSTEMCALL SYSTEM_SESSIONWAIT");
                break;
            }
            case 1049: {
                commandList.add(new SystemSessionWaitCommand(this.lc, "SYSTEM_SESSIONWAIT", this.sdsHandlerService, this.audioHandler, this.sdsManager, this.sdsPopupHelper));
                commandList.execute("SYSTEMCALL SYSTEM_SESSIONWAIT");
                break;
            }
            case 1041: {
                commandList.add(new SystemStartRecognitionCommand(this.lc, "SYSTEM_STARTRECOGNITION", this.sdsHandlerService, iSystemCallParameterArray, this.srHandler, this.grammarCmdListManager, this.nBestStorage, this.sdsTimeoutHandler, this.systemVBIHandler, this.factory));
                commandList.execute("SYSTEMCALL SYSTEM_STARTRECOGNITION");
                break;
            }
            case 1042: {
                this.abortCurrentRecognition((byte)0, false, -1);
                break;
            }
            case 1043: {
                commandList.add(new SystemStateSetCommand(this.lc, "SYSTEM_STATESET", this.sdsHandlerService, iSystemCallParameterArray, this.sdsManager, this.srHandler, this.factory, this.hmiListener));
                commandList.execute("SYSTEMCALL SYSTEM_STATESET");
                break;
            }
            case 1044: {
                commandList.add(new SystemTTSAbortCommand(this.lc, "SYSTEM_TTSABORT", this.sdsManager, this.sdsHandlerService, this, this.systemVBIHandler));
                commandList.execute("SYSTEMCALL SYSTEM_TTSABORT");
                break;
            }
            case 1046: {
                commandList.add(new SystemWaitStateCommand(this.lc, "SYSTEM_WAITSTATE", this.sdsHandlerService, this.sdsPopupHelper));
                commandList.execute("SYSTEMCALL SYSTEM_WAITSTATE");
                break;
            }
            case 1053: {
                commandList.add(new SystemParamSetNLUCommand(this.lc, "SYSTEM_PARAMSETNLU", this.sdsHandlerService, this.nBestStorage, iSystemCallParameterArray));
                commandList.execute("SYSTEMCALL SYSTEM_PARAMSETNLU");
                break;
            }
            case 1030: {
                commandList.add(new SystemSlotSetNLUCommand(this.lc, "SYSTEM_SLOTSETNLU", this.sdsHandlerService, this.nBestStorage));
                commandList.execute("SYSTEMCALL SYSTEM_SLOTSETNLU");
                break;
            }
            case 1064: {
                this.initializeOneshotHandler(SDSUtils.retrieveInteger(iSystemCallParameterArray, 0));
                break;
            }
            default: {
                this.lc.log(10000, "SystemSDSHandlerImpl#processMainCommand: Unhandled id %1!", (long)n);
            }
        }
    }

    private void initializeOneshotHandler(int n) {
        if (n == 2 || n == 3) {
            this.factory.getSDSHandlerMedia().initializeOneshotHandler(n);
        } else {
            this.factory.getSDSHandlerNavi().initializeOneshotHandler(n);
        }
    }

    private void processGenericCommand(int n, ISystemCallParameter[] iSystemCallParameterArray, CommandList commandList) {
        switch (n) {
            case 1012: {
                commandList.add(new SystemCounterIncrementCommand(this.lc, "SYSTEM_COUNTERINCREMENT", this.sdsHandlerService));
                commandList.execute("SYSTEMCALL SYSTEM_COUNTERINCREMENT");
                break;
            }
            case 1013: {
                commandList.add(new SystemCounterResetCommand(this.lc, "SYSTEM_COUNTERRESET", this.sdsHandlerService));
                commandList.execute("SYSTEMCALL SYSTEM_COUNTERRESET");
                break;
            }
            case 1015: {
                commandList.add(new SystemSecondCounterResetCommand(this.lc, "SYSTEM_COUNTERSECONDRESET", this.sdsHandlerService));
                commandList.execute("SYSTEMCALL SYSTEM_COUNTERSECONDRESET");
                break;
            }
            case 1014: {
                commandList.add(new SystemSecondCounterIncrementCommand(this.lc, "SYSTEM_COUNTERSECONDINCREMENT", this.sdsHandlerService));
                commandList.execute("SYSTEMCALL SYSTEM_COUNTERSECONDINCREMENT");
                break;
            }
            case 1010: {
                commandList.add(new SystemCorrectionCaseCommand(this.lc, "SYSTEM_CORRECTIONCASE", this.sdsHandlerService, this.nBestStorage));
                commandList.execute("SYSTEMCALL SYSTEM_CORRECTIONCASE");
                break;
            }
            case 1051: {
                SystemSetModelCommand systemSetModelCommand = new SystemSetModelCommand(this.lc, "SYSTEM_SETMODEL", this.sdsHandlerService, this.hmiService, iSystemCallParameterArray);
                systemSetModelCommand.execute();
                break;
            }
            case 1017: {
                commandList.add(new SystemIncrementModelCommand(this.lc, "SYSTEM_INCREMENTMODEL", this.sdsHandlerService, iSystemCallParameterArray));
                commandList.execute("SYSTEMCALL SYSTEM_INCREMENTMODEL");
                break;
            }
            case 1035: {
                commandList.add(new SystemGraphemicGroupRecognizedCommand(this.lc, "SYSTEM_GRAPHEMICGROUPRECOGNIZED", this.sdsHandlerService, this.nBestStorage, this.srHandler));
                commandList.execute("SYSTEMCALL SYSTEM_GRAPHEMICGROUPRECOGNIZED");
                break;
            }
            case 1045: {
                this.contextSet(iSystemCallParameterArray);
                break;
            }
            case 1063: {
                this.dialogContextSet(iSystemCallParameterArray);
                break;
            }
            case 1052: {
                commandList.add(new SystemStorePicklistInHistoryCommand(this.lc, "SYSTEM_STOREPICKLISTINHISTORY", this.sdsHandlerService, this.nBestStorage));
                commandList.execute("SYSTEMCALL SYSTEM_STOREPICKLISTINHISTORY");
                break;
            }
            case 1059: {
                commandList.add(new SystemRemoveFromPicklistHistoryCommand(this.lc, "SYSTEM_REMOVEFROMPICKLISTHISTORY", this.sdsHandlerService, this.nBestStorage, iSystemCallParameterArray));
                commandList.execute("SYSTEMCALL SYSTEM_REMOVEFROMPICKLISTHISTORY");
                break;
            }
            default: {
                this.lc.log(10000, "SystemSDSHandlerImpl#processGenericCommand: Unhandled id %1!", (long)n);
            }
        }
    }

    private void processDisplayCommand(int n, ISystemCallParameter[] iSystemCallParameterArray, CommandList commandList) {
        switch (n) {
            case 1002: {
                commandList.add(new SystemCommandListHideCommand(this.lc, "SYSTEM_COMMANDLISTHIDE", this.sdsHandlerService, this.sdsPopupHelper, this.hmiListener, iSystemCallParameterArray));
                commandList.execute("SYSTEMCALL SYSTEM_COMMANDLISTHIDE");
                break;
            }
            case 1003: {
                commandList.add(new SystemCommandListShowCommand(this.lc, "SYSTEM_COMMANDLISTSHOW", this.sdsHandlerService, this.hmiListener, this.sdsPopupHelper, this.srHandler, iSystemCallParameterArray));
                commandList.execute("SYSTEMCALL SYSTEM_COMMANDLISTSHOW");
                break;
            }
            case 1007: {
                this.commandModeSet(iSystemCallParameterArray);
                break;
            }
            case 1058: {
                commandList.add(new SystemCursorHighlightLineCommand(this.lc, "SYSTEM_CURSORHIGHLIGHTLINE", this.sdsHandlerService, this.hmiService, iSystemCallParameterArray));
                commandList.execute("SYSTEMCALL SYSTEM_CURSORHIGHLIGHTLINE");
                break;
            }
            case 1020: {
                commandList.add(new SystemListClearCommand(this.lc, "SYSTEM_LISTCLEAR", this.sdsHandlerService, this.sdsPopupHelper, this.sdsManager));
                commandList.execute("SYSTEMCALL SYSTEM_LISTCLEAR");
                break;
            }
            case 1021: {
                commandList.add(new SystemListHideCommand(this.lc, "SYSTEM_LISTHIDE", this.sdsHandlerService, iSystemCallParameterArray, this.sdsPopupHelper, this.systemVBIHandler));
                commandList.execute("SYSTEMCALL SYSTEM_LISTHIDE");
                break;
            }
            case 1022: {
                commandList.add(new SystemListLineDataGetCommand(this.lc, "SYSTEM_LISTLINEDATAGET", this.sdsHandlerService, this.hmiService));
                commandList.execute("SYSTEMCALL SYSTEM_LISTLINEDATAGET");
                break;
            }
            case 1023: {
                commandList.add(new SystemListLineGetCommand(this.lc, "SYSTEM_LISTLINEGET", this.sdsHandlerService));
                commandList.execute("SYSTEMCALL SYSTEM_LISTLINEGET");
                break;
            }
            case 1024: {
                commandList.add(new SystemListLineSetCommand(this.lc, "SYSTEM_LISTLINESET", this.sdsHandlerService, this.hmiService, iSystemCallParameterArray));
                commandList.execute("SYSTEMCALL SYSTEM_LISTLINESET");
                break;
            }
            case 1056: {
                commandList.add(new SystemListLineRequestCommand(this.lc, "SYSTEM_LISTLINEREQUEST", this.sdsHandlerService, this.hmiService));
                commandList.execute("SYSTEMCALL SYSTEM_LISTLINEREQUEST");
                break;
            }
            case 1055: {
                commandList.add(new SystemAbsoluteLineNumberSetCommand(this.lc, "SYSTEM_ABSOLUTELINENUMBERSET", this.sdsHandlerService, this.hmiService, iSystemCallParameterArray));
                commandList.execute("SYSTEMCALL SYSTEM_ABSOLUTELINENUMBERSET");
                break;
            }
            case 1001: {
                commandList.add(new SystemAnyCalledCommand(this.lc, "SYSTEM_ANYCALLED", this.sdsHandlerService));
                commandList.execute("SYSTEMCALL SYSTEM_ANYCALLED");
                break;
            }
            case 1025: {
                commandList.add(new SystemListPageSetCommand(this.lc, "SYSTEM_LISTPAGESET", this.sdsHandlerService, this.sdsPopupHelper, this.hmiService, iSystemCallParameterArray));
                commandList.execute("SYSTEMCALL SYSTEM_LISTPAGESET");
                break;
            }
            case 1027: {
                commandList.add(new SystemListShowCommand(this.lc, "SYSTEM_LISTSHOW", this.sdsHandlerService, iSystemCallParameterArray, this.sdsPopupHelper, this.systemVBIHandler));
                commandList.execute("SYSTEMCALL SYSTEM_LISTSHOW");
                break;
            }
            case 1048: {
                commandList.add(new SystemDisambiguationListHideCommand(this.lc, "SYSTEM_DISAMBIGUATIONLISTHIDE", this.sdsHandlerService, this.sdsPopupHelper, iSystemCallParameterArray));
                commandList.execute("SYSTEMCALL SYSTEM_DISAMBIGUATIONLISTHIDE");
                break;
            }
            case 1047: {
                commandList.add(new SystemDisambiguationListShowCommand(this.lc, "SYSTEM_DISAMBIGUATIONLISTSHOW", this.sdsHandlerService, this.nBestStorage, this.sdsPopupHelper, iSystemCallParameterArray));
                commandList.execute("SYSTEMCALL SYSTEM_DISAMBIGUATIONLISTSHOW");
                break;
            }
            case 1061: {
                commandList.add(new SystemWaitForScreenConnectedCommand(this.lc, "SYSTEM_WAITFORSCREENCONNECTED", this.sdsHandlerService, this.hmiListener, iSystemCallParameterArray));
                commandList.execute("SYSTEMCALL SYSTEM_WAITFORSCREENCONNECTED");
                break;
            }
            case 1062: {
                commandList.add(new SystemWaitForScreenFadedOutCommand(this.lc, "SYSTEM_WAITFORSCREENFADEDOUT", this.sdsHandlerService, this.hmiListener, iSystemCallParameterArray));
                commandList.execute("SYSTEMCALL SYSTEM_WAITFORSCREENFADEDOUT");
                break;
            }
            default: {
                this.lc.log(10000, "SystemSDSHandlerImpl#processDisplayCommand: Unhandled id %1!", (long)n);
            }
        }
    }

    private void commandModeSet(ISystemCallParameter[] iSystemCallParameterArray) {
        int n = SDSUtils.retrieveInteger(iSystemCallParameterArray, 0);
        int n2 = SDSUtils.retrieveInteger(iSystemCallParameterArray, 1);
        int n3 = SDSUtils.retrieveInteger(iSystemCallParameterArray, 2);
        this.lc.log(-2137614336, "SystemSDSHandlerImpl#commandModeSet: commandModeSmall=%1, commandModeBig=%2!", (long)n, (long)n2);
        this.lc.log(-2137614336, "SystemSDSHandlerImpl#commandModeSet: commandModeFurther=%1!", (long)n3);
        if (n != -1 && n != -1) {
            SDSModelAccess.setCommandModeSmall(n);
        }
        if (n2 != -1 && n2 != -1) {
            SDSModelAccess.setCommandModeBig(n2);
        }
        if (n3 != -1 && n3 != -1) {
            SDSModelAccess.setCommandModeFurther(n3);
        }
    }

    private void contextSet(ISystemCallParameter[] iSystemCallParameterArray) {
        int n = SDSUtils.retrieveInteger(iSystemCallParameterArray, 0);
        this.lc.log(-2137614336, "SystemSDSHandlerImpl#contextSet: context=%1", (long)n);
        SDSModelAccess.setContextChoice(n);
    }

    private void dialogContextSet(ISystemCallParameter[] iSystemCallParameterArray) {
        int n = SDSUtils.retrieveInteger(iSystemCallParameterArray, 0);
        this.lc.log(-2137614336, "SystemSDSHandlerImpl#dialogContextSet: dialogContext=%1", (long)n);
        if (n != -1) {
            this.sdsManager.setDialogContext(n);
        }
    }

    private void promptTypeSet(ISystemCallParameter[] iSystemCallParameterArray) {
        int n = SDSUtils.retrieveInteger(iSystemCallParameterArray, 0);
        this.lc.log(-2137614336, "SystemSDSHandlerImpl#promptTypeSet: promptType=%1", (long)n);
        this.ttsHandler.setPromptType((byte)n);
    }

    @Override
    public void responseRequestGGAsNBestList(int n, NBestList nBestList) {
        this.lc.log(-2137614336, "SystemSDSHandlerImpl#responseRequestGGAsNBestList: NOP", (long)n);
        try {
            ((SystemGraphemicGroupRecognizedCommand)SDSUtils.getActiveSystemCall()).responseRequestGGAsNBestList(n, nBestList);
        }
        catch (ClassCastException classCastException) {
            this.lc.log(10000, "SystemSDSHandlerImpl#responseRequestGGAsNBestList: Active command is no SystemGraphemicGroupRecognizedCommand!");
        }
        catch (NullPointerException nullPointerException) {
            this.lc.log(10000, "SystemSDSHandlerImpl#responseRequestGGAsNBestList: NullpointerException. No active command!");
        }
    }

    @Override
    public void responseRequestAudioConnections(boolean bl) {
        this.lc.log(-2137614336, "SystemSDSHandlerImpl#responseRequestAudioConnections: ok=%1", bl);
        try {
            ((ISystemSessionStartCommand)((Object)SDSUtils.getActiveSystemCall())).responseRequestAudioConnections(bl);
        }
        catch (ClassCastException classCastException) {
            this.lc.log(10000, "SystemSDSHandlerImpl#responseRequestAudioConnections: Active command is no SystemSessionWaitCommand!");
        }
        catch (NullPointerException nullPointerException) {
            this.lc.log(10000, "SystemSDSHandlerImpl#responseRequestAudioConnections: NullpointerException. No active command!");
        }
    }

    @Override
    public void responseReleaseAudioConnections(boolean bl) {
        this.lc.log(-2137614336, "SystemSDSHandlerImpl#responseReleaseAudioConnections: ok=%1", bl);
        try {
            ((ISystemSessionEndCommand)((Object)SDSUtils.getActiveSystemCall())).responseReleaseAudioConnections(bl);
        }
        catch (ClassCastException classCastException) {
            this.lc.log(10000, "SystemSDSHandlerImpl#responseReleaseAudioConnections: Active command is no SystemSessionEndCommand!");
        }
        catch (NullPointerException nullPointerException) {
            this.lc.log(10000, "SystemSDSHandlerImpl#responseReleaseAudioConnections: NullpointerException. No active command!");
        }
    }

    @Override
    public boolean abortCurrentRecognition(byte by, boolean bl, int n) {
        this.lc.log(-2137614336, "SystemSDSHandlerImpl#abortCurrentRecognition: type=%2, direct=%1, evID=%3", (Object)bl, (long)by, (long)n);
        this.abortingType = by;
        this.abortingDirect = bl;
        this.abortingEventID = n;
        AbstractSystemCallCommand abstractSystemCallCommand = SDSUtils.getActiveSystemCall();
        if (abstractSystemCallCommand instanceof SystemStartRecognitionCommand) {
            this.lc.log(-2137614336, "SystemSDSHandlerImpl#abortCurrentRecognition: Active command is SystemStartRecognitionCommand, calling stopCurrentRecognition there!");
            return ((SystemStartRecognitionCommand)abstractSystemCallCommand).stopCurrentRecognition();
        }
        if (by != 0) {
            this.lc.log(-2137614336, "SystemSDSHandlerImpl#abortCurrentRecognition: Aborting type is no systemcall and no recognition running, returning false!", (long)by);
            return false;
        }
        if (abstractSystemCallCommand == null) {
            this.lc.log(-2137614336, "SystemSDSHandlerImpl#abortCurrentRecognition: No active command!");
        }
        this.lc.log(-2137614336, "SystemSDSHandlerImpl#abortCurrentRecognition: Sending OK for systemcall and returning false!");
        this.sdsHandlerService.sendResult(3000);
        return false;
    }

    @Override
    public void abortedCurrentRecognition() {
        AbstractSystemCallCommand abstractSystemCallCommand = SDSUtils.getActiveSystemCall();
        switch (this.abortingType) {
            case 1: {
                this.lc.log(-2137614336, "SystemSDSHandlerImpl#abortedCurrentRecognition: Recognition aborted by event!");
                if (abstractSystemCallCommand instanceof SystemStartRecognitionCommand) {
                    ((SystemStartRecognitionCommand)abstractSystemCallCommand).recognitionAborted();
                    break;
                }
                this.sdsHandlerService.sendEvent(this.abortingEventID);
                break;
            }
            case 3: {
                this.lc.log(-2137614336, "SystemSDSHandlerImpl#abortedCurrentRecognition: Recognition aborted by speech I/O event!");
                this.sdsHandlerService.sendSpeechSMEvent(this.abortingEventID, this.abortingDirect, true);
                if (this.playPrioPromptCallback == null) break;
                this.playPrioPromptCallback.callback();
                this.setPlayPrioPromptCallback(null);
                break;
            }
            case 2: {
                this.lc.log(-2137614336, "SystemSDSHandlerImpl#abortedCurrentRecognition: Recognition aborted by barge-in => NOP!");
                break;
            }
            case 4: {
                this.lc.log(-2137614336, "SystemSDSHandlerImpl#abortedCurrentRecognition: Recognition aborted by left or right drawer or view key => try to enter waiting state!");
                this.sdsManager.checkAbortingAndTriggerWaitState();
                break;
            }
            case 0: {
                this.lc.log(-2137614336, "SystemSDSHandlerImpl#abortedCurrentRecognition: Recognition aborted by systemcall -> send response OK!");
                if (abstractSystemCallCommand instanceof SystemStartRecognitionCommand) {
                    ((SystemStartRecognitionCommand)abstractSystemCallCommand).recognitionAborted();
                    break;
                }
                this.sdsHandlerService.sendResult(3000);
                break;
            }
            default: {
                this.lc.log(-1601830656, "SystemSDSHandlerImpl#abortedCurrentRecognition: Recognition aborted by another client => NOP!");
            }
        }
    }

    @Override
    public void setPlayPrioPromptCallback(PlayPrioPromptCallback playPrioPromptCallback) {
        this.playPrioPromptCallback = playPrioPromptCallback;
    }

    @Override
    public void abortedCurrentPrompt() {
        this.lc.log(-2137614336, "SystemSDSHandlerImpl#abortedCurrentPrompt: called");
        AbstractSystemCallCommand abstractSystemCallCommand = SDSUtils.getActiveSystemCall();
        switch (this.abortingType) {
            case 1: {
                this.lc.log(-2137614336, "SystemSDSHandlerImpl#abortedCurrentPrompt: TTS aborted by event!");
                if (abstractSystemCallCommand instanceof SystemTTSAbortCommand) {
                    ((SystemTTSAbortCommand)abstractSystemCallCommand).currentTTSPromptEnded();
                    break;
                }
                this.sdsHandlerService.sendEvent(this.abortingEventID);
                break;
            }
            case 3: {
                this.lc.log(-2137614336, "SystemSDSHandlerImpl#abortedCurrentPrompt: TTS aborted by speech I/O event!");
                this.sdsHandlerService.sendSpeechSMEvent(this.abortingEventID, this.abortingDirect, true);
                break;
            }
            case 2: {
                this.lc.log(-2137614336, "SystemSDSHandlerImpl#abortedCurrentPrompt: TTS aborted by barge-in => NOP!");
                break;
            }
            case 4: {
                this.lc.log(-2137614336, "SystemSDSHandlerImpl#abortedCurrentPrompt: TTS aborted by left or right drawer or view key => try to enter waiting state!");
                this.sdsManager.checkAbortingAndTriggerWaitState();
                break;
            }
            case 0: {
                try {
                    ((SystemTTSAbortCommand)abstractSystemCallCommand).currentTTSPromptEnded();
                }
                catch (ClassCastException classCastException) {
                    this.lc.log(10000, "SystemSDSHandlerImpl#abortedCurrentPrompt: Active command is no SystemTTSAbortCommand");
                }
                catch (NullPointerException nullPointerException) {
                    this.lc.log(10000, "SystemSDSHandlerImpl#abortedCurrentPrompt: NullpointerException. No active command!");
                }
                break;
            }
            default: {
                this.lc.log(-1601830656, "SystemSDSHandlerImpl#abortedCurrentPrompt: TTS aborted by another client, sending TTS_FINISH!");
                this.sdsHandlerService.sendEvent(2000);
            }
        }
    }

    @Override
    public void handleIllegalCommand(String string) {
        this.lc.log(-2137614336, "SystemSDSHandlerImpl#handleIllegalCommand: errorText=%1", (Object)string);
        this.ttsHandler.playText(string, true);
    }

    @Override
    public void responseHandleIllegalCommand() {
        this.lc.log(-2137614336, "SystemSDSHandlerImpl#responseHandleIllegalCommand: called");
        try {
            SDSUtils.getActiveSystemCall().sendResult(3001);
        }
        catch (NullPointerException nullPointerException) {
            this.lc.log(10000, "SystemSDSHandlerImpl#responseHandleIllegalCommand: NullpointerException. No active command!");
        }
    }

    @Override
    public void setCommandListManager(CommandListManager commandListManager) {
        this.grammarCmdListManager = commandListManager;
    }

    @Override
    public void setSystemVBIHandler(ISystemVBIHandler iSystemVBIHandler) {
        this.systemVBIHandler = iSystemVBIHandler;
    }

    @Override
    public boolean isListLineDataGetActive() {
        return SDSUtils.getActiveSystemCall() instanceof SystemListLineDataGetCommand;
    }

    @Override
    public void sdsListLineDataGet(int n, int n2) {
        this.lc.log(-2137614336, "SystemSDSHandlerImpl#sdsListLineDataGet: modelID=%1, absLine=%2", (long)n, (long)n2);
        try {
            ((SystemListLineDataGetCommand)SDSUtils.getActiveSystemCall()).sdsListLineDataGet(n, n2);
        }
        catch (ClassCastException classCastException) {
            this.lc.log(10000, "SystemSDSHandlerImpl#sdsListLineDataGet: Active command is no SystemListLineDataGetCommand!");
        }
        catch (NullPointerException nullPointerException) {
            this.lc.log(10000, "SystemSDSHandlerImpl#sdsListLineDataGet: NullpointerException. No active command!");
        }
    }

    @Override
    public void systemScreenConnected(int n) {
        this.lc.log(-2137614336, "SystemSDSHandlerImpl#systemScreenConnected: screenID=%1", (long)n);
        AbstractSystemCallCommand abstractSystemCallCommand = SDSUtils.getActiveSystemCall();
        if (abstractSystemCallCommand instanceof ISDSScreenConnectedUpdatable) {
            if (this.sdsManager.isSDSAborting()) {
                this.lc.log(-2137614336, "SystemSDSHandlerImpl#systemScreenConnected: SDS aborting => abort syscall that is waiting for connecting screen!");
                abstractSystemCallCommand.processingFinished();
            } else {
                this.lc.log(-2137614336, "SystemSDSHandlerImpl#systemScreenConnected: active syscall is instanceof ISDSScreenConnectedUpdatable.");
                ((ISDSScreenConnectedUpdatable)((Object)abstractSystemCallCommand)).updateSDSScreenConnected(n);
            }
        }
    }

    @Override
    public void systemScreenFadedOut(int n) {
        this.lc.log(-2137614336, "SystemSDSHandlerImpl#systemScreenFadedOut: screenID=%1", (long)n);
        AbstractSystemCallCommand abstractSystemCallCommand = SDSUtils.getActiveSystemCall();
        if (abstractSystemCallCommand instanceof ISDSScreenFadedOutUpdatable) {
            if (this.sdsManager.isSDSAborting()) {
                this.lc.log(-2137614336, "SystemSDSHandlerImpl#systemScreenFadedOut: SDS aborting => abort syscall that is waiting for out fading screen!");
                abstractSystemCallCommand.processingFinished();
            } else {
                this.lc.log(-2137614336, "SystemSDSHandlerImpl#systemScreenFadedOut: active syscall is instanceof ISDSScreenFadedOutUpdatable.");
                ((ISDSScreenFadedOutUpdatable)((Object)abstractSystemCallCommand)).updateSDSScreenFadedOut(n);
            }
        }
    }

    private static boolean isGenericCommand(int n) {
        return n == 1012 || n == 1013 || n == 1017 || n == 1014 || n == 1015 || n == 1035 || n == 1045 || n == 1051 || n == 1010 || n == 1059 || n == 1052 || n == 1063;
    }

    private static boolean isConnectivityCommand(int n) {
        return n == 1029 || n == 1057;
    }

    private static boolean isDisplayCommand(int n) {
        return n == 1001 || n == 1007 || n == 1002 || n == 1003 || n == 1020 || n == 1021 || n == 1022 || n == 1023 || n == 1056 || n == 1024 || n == 1058 || n == 1055 || n == 1025 || n == 1027 || n == 1048 || n == 1047 || n == 1061 || n == 1062;
    }

    @Override
    public boolean abortCurrentPrompt(byte by, boolean bl, int n) {
        this.lc.log(-2137614336, "SystemSDSHandlerImpl#abortCurrentPrompt: type=%2, direct=%1, eventID=%3", (Object)bl, (long)by, (long)n);
        this.abortingType = by;
        this.abortingDirect = bl;
        this.abortingEventID = n;
        return this.ttsHandler.abort();
    }

    @Override
    public void unsetConnectivityService() {
        this.connectivityService = new NullSDSConnectivityService(this.lc);
    }

    @Override
    public void setConnectivityService(ISdsConnectivityService iSdsConnectivityService) {
        if (iSdsConnectivityService != null) {
            this.connectivityService = iSdsConnectivityService;
        }
    }

    public String toString() {
        return "SystemSDSHandlerImpl";
    }

    @Override
    public SpeechTTSHandler getTTSHandler() {
        return this.ttsHandler;
    }

    @Override
    public byte getAbortingType() {
        return this.abortingType;
    }
}

