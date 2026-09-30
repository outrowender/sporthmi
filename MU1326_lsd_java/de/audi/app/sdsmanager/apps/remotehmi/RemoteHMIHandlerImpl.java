/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.remotehmi;

import de.audi.app.sdsmanager.SDSManagerBaseActivator;
import de.audi.app.sdsmanager.apps.AbstractSDSApplication;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.remotehmi.RemoteHMIHandler;
import de.audi.app.sdsmanager.apps.remotehmi.commands.RemoteHMIDialogStepFinishedCommand;
import de.audi.app.sdsmanager.apps.remotehmi.commands.RemoteHMIGlobalEnterSetCommand;
import de.audi.app.sdsmanager.apps.remotehmi.commands.RemoteHMIGlobalResultSetCommand;
import de.audi.app.sdsmanager.apps.remotehmi.commands.RemoteHMIHelpOpenedCommand;
import de.audi.app.sdsmanager.apps.remotehmi.commands.RemoteHMIHelpUpdateCommand;
import de.audi.app.sdsmanager.apps.remotehmi.commands.RemoteHMINavDestFormResultCommand;
import de.audi.app.sdsmanager.apps.remotehmi.commands.RemoteHMINavLocationInputResetCommand;
import de.audi.app.sdsmanager.apps.remotehmi.commands.RemoteHMIRequestDialogContinuationCommand;
import de.audi.app.sdsmanager.apps.remotehmi.commands.RemoteHMIResultSetCommand;
import de.audi.app.sdsmanager.apps.remotehmi.commands.RemoteHMISetHelpResultCommand;
import de.audi.app.sdsmanager.apps.remotehmi.commands.RemoteHMISetRecognizedLineNumberCommand;
import de.audi.app.sdsmanager.common.Logger;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.dsi.ISpeechRecognitionStateListener;
import de.audi.app.sdsmanager.dsi.SpeechRecognitionHandler;
import de.audi.app.sdsmanager.grammar.DynamicSlotContent;
import de.audi.app.sdsmanager.grammar.IDynamicLists;
import de.audi.app.sdsmanager.grammar.ITTSASR;
import de.audi.app.sdsmanager.nbest.NBestStorageAccess;
import de.audi.app.sdsmanager.syscall.ISystemCallParameter;
import de.audi.atip.interapp.OnlineService;
import de.audi.atip.interapp.OnlineServiceListener;
import de.audi.atip.interapp.SDSListEntry;
import de.audi.atip.interapp.def.NullOnlineService;
import de.audi.atip.log.LogChannel;
import de.audi.atip.statemachine.sds.ITTSASRContext;
import de.audi.tghu.command.CommandList;
import java.util.List;
import org.dsi.ifc.speechrec.DictionaryEntry;

public class RemoteHMIHandlerImpl
extends AbstractSDSApplication
implements RemoteHMIHandler,
OnlineServiceListener,
ISpeechRecognitionStateListener {
    private static final int[] commands = new int[]{230006, 230007, 230005, 230009, 230003, 230004, 230008, 230002, 230000, 230001, 230010};
    private final LogChannel lc = Logger.getAppRemoteHMI();
    private OnlineService onlineService = new NullOnlineService(this.lc);
    private final IDynamicLists dynamicLists;
    private final SpeechRecognitionHandler srHandler;
    private int selectedHelpLine = -1;
    private ITTSASR ttsASR;
    private volatile int speechRecognitionState = 1;
    private boolean isGrammarReloadTriggered = false;

    public RemoteHMIHandlerImpl(SDSHandlerService sDSHandlerService, NBestStorageAccess nBestStorageAccess, IDynamicLists iDynamicLists, SpeechRecognitionHandler speechRecognitionHandler) {
        super(sDSHandlerService, nBestStorageAccess);
        this.dynamicLists = iDynamicLists;
        this.srHandler = speechRecognitionHandler;
    }

    public void setOnlineService(OnlineService onlineService) {
        if (onlineService != null) {
            this.onlineService = onlineService;
        }
    }

    public void unsetOnlineService() {
        this.onlineService = new NullOnlineService(this.lc);
    }

    public void processCommand(int n, ISystemCallParameter[] iSystemCallParameterArray) {
        this.lc.log(10000000, "RemoteHMIHandlerImpl#processCommand: id=%2, parameters=%1", (Object)SDSUtils.toString((Object[])iSystemCallParameterArray, false), (Object)SDSManagerBaseActivator.getSystemCallNames().getName(n));
        CommandList commandList = new CommandList(SDSManagerBaseActivator.getSysCallCmdListManager());
        switch (n) {
            case 230002: {
                this.lc.log(10000000, "RemoteHMIHandlerImpl#processCommand: REMOTEHMI_SETRESULT called!");
                commandList.add(new RemoteHMIResultSetCommand(this.lc, "REMOTEHMI_SETRESULT", this.sdsHandlerService, this.nBestStorage, this.onlineService));
                commandList.execute("SYSTEMCALL REMOTEHMI_SETRESULT");
                break;
            }
            case 230003: {
                this.lc.log(10000000, "RemoteHMIHandlerImpl#processCommand: REMOTEHMI_SETGLOBALRESULT called!");
                commandList.add(new RemoteHMIGlobalResultSetCommand(this.lc, "REMOTEHMI_SETGLOBALRESULT", this.sdsHandlerService, this.nBestStorage, this.onlineService));
                commandList.execute("SYSTEMCALL REMOTEHMI_SETGLOBALRESULT");
                break;
            }
            case 230004: {
                this.lc.log(10000000, "RemoteHMIHandlerImpl#processCommand: REMOTEHMI_SETHELPRESULT called!");
                commandList.add(new RemoteHMISetHelpResultCommand(this.lc, "REMOTEHMI_SETHELPRESULT", this.sdsHandlerService, this.nBestStorage, this.onlineService, this));
                commandList.execute("SYSTEMCALL REMOTEHMI_SETHELPRESULT");
                break;
            }
            case 230005: {
                this.lc.log(10000000, "RemoteHMIHandlerImpl#processCommand: REMOTEHMI_REQUESTDIALOGCONTINUATION called!");
                commandList.add(new RemoteHMIRequestDialogContinuationCommand(this.lc, "REMOTEHMI_REQUESTDIALOGCONTINUATION", this.sdsHandlerService, this.onlineService));
                commandList.execute("SYSTEMCALL REMOTEHMI_REQUESTDIALOGCONTINUATION");
                break;
            }
            case 230006: {
                this.lc.log(10000000, "RemoteHMIHandlerImpl#processCommand: REMOTEHMI_DIALOGSTEPFINISHED called!");
                commandList.add(new RemoteHMIDialogStepFinishedCommand(this.lc, "REMOTEHMI_DIALOGSTEPFINISHED", this.sdsHandlerService, this.onlineService));
                commandList.execute("SYSTEMCALL REMOTEHMI_DIALOGSTEPFINISHED");
                break;
            }
            case 230007: {
                this.lc.log(10000000, "RemoteHMIHandlerImpl#processCommand: REMOTEHMI_HELPOPENED called!");
                commandList.add(new RemoteHMIHelpOpenedCommand(this.lc, "REMOTEHMI_HELPOPENED", this.sdsHandlerService, this.onlineService, iSystemCallParameterArray));
                commandList.execute("SYSTEMCALL REMOTEHMI_HELPOPENED");
                break;
            }
            case 230008: {
                this.lc.log(10000000, "RemoteHMIHandlerImpl#processCommand: REMOTEHMI_SETNAVDESTFORMRESULT called!");
                commandList.add(new RemoteHMINavDestFormResultCommand(this.lc, "REMOTEHMI_SETNAVDESTFORMRESULT", this.sdsHandlerService, this.onlineService));
                commandList.execute("SYSTEMCALL REMOTEHMI_SETNAVDESTFORMRESULT");
                break;
            }
            case 230009: {
                this.lc.log(10000000, "RemoteHMIHandlerImpl#processCommand: ONLINE_SETREMOTEHMIGLOBALENTER called!");
                commandList.add(new RemoteHMIGlobalEnterSetCommand(this.lc, "ONLINE_SETREMOTEHMIGLOBALENTER", this.sdsHandlerService, this.onlineService));
                commandList.execute("SYSTEMCALL ONLINE_SETREMOTEHMIGLOBALENTER");
                break;
            }
            case 230001: {
                this.lc.log(10000000, "RemoteHMIHandlerImpl#processCommand: REMOTEHMI_UPDATEHELP called!");
                commandList.add(new RemoteHMIHelpUpdateCommand(this.lc, "REMOTEHMI_UPDATEHELP", this.sdsHandlerService, this.onlineService));
                commandList.execute("SYSTEMCALL REMOTEHMI_UPDATEHELP");
                break;
            }
            case 230000: {
                this.lc.log(10000000, "RemoteHMIHandlerImpl#processCommand: REMOTEHMI_RESETNAVLOCATIONINPUT called!");
                commandList.add(new RemoteHMINavLocationInputResetCommand(this.lc, "REMOTEHMI_RESETNAVLOCATIONINPUT", this.sdsHandlerService, this.onlineService));
                commandList.execute("SYSTEMCALL REMOTEHMI_RESETNAVLOCATIONINPUT");
                break;
            }
            case 230010: {
                this.lc.log(10000000, "RemoteHMIHandlerImpl#processCommand: REMOTEHMI_SETRECOGNIZEDLINENUMBER called!");
                commandList.add(new RemoteHMISetRecognizedLineNumberCommand(this.lc, "REMOTEHMI_SETRECOGNIZEDLINENUMBER", this.sdsHandlerService, this.onlineService));
                commandList.execute("SYSTEMCALL REMOTEHMI_SETRECOGNIZEDLINENUMBER");
                break;
            }
            default: {
                this.lc.log(10000, "RemoteHMIHandlerImpl#processCommand: Unhandled commandID %1!", (long)n);
            }
        }
    }

    public void updateRemoteHMIList(SDSListEntry[] sDSListEntryArray, boolean bl) {
        if (sDSListEntryArray == null) {
            this.lc.log(100000, "[RemoteHMIHandlerImpl#updateRemoteHMIList] entryList == null");
            this.dynamicLists.removeFromLookup(41);
            return;
        }
        int n = sDSListEntryArray.length;
        this.lc.log(10000000, "[RemoteHMIHandlerImpl#updateRemoteHMIList] entryList.size=%1!", (long)n);
        if (n <= 0 || !bl) {
            this.dynamicLists.removeFromLookup(41);
        } else {
            DynamicSlotContent dynamicSlotContent = new DynamicSlotContent("remote HMI list entries", sDSListEntryArray, 0);
            this.dynamicLists.addToLookup(41, dynamicSlotContent);
            this.reloadRemoteHMIGrammar(41);
        }
    }

    public void updateRemoteHMIGlobalList(SDSListEntry[] sDSListEntryArray, boolean bl) {
        if (sDSListEntryArray == null) {
            this.lc.log(100000, "[RemoteHMIHandlerImpl#updateRemoteHMIGlobalList] entryList == null");
            this.dynamicLists.removeFromLookup(42);
            return;
        }
        int n = sDSListEntryArray.length;
        this.lc.log(10000000, "[RemoteHMIHandlerImpl#updateRemoteHMIGlobalList] entryList.size=%1!", (long)n);
        if (n <= 0 || !bl) {
            this.dynamicLists.removeFromLookup(42);
        } else {
            DynamicSlotContent dynamicSlotContent = new DynamicSlotContent("remote HMI global list entries", sDSListEntryArray, 0);
            this.dynamicLists.addToLookup(42, dynamicSlotContent);
            this.reloadRemoteHMIGrammar(42);
        }
    }

    public void updateRemoteHMIHelpList(SDSListEntry[] sDSListEntryArray, boolean bl) {
        if (sDSListEntryArray == null) {
            this.lc.log(100000, "[RemoteHMIHandlerImpl#updateRemoteHMIHelpList] entryList == null");
            this.dynamicLists.removeFromLookup(43);
            return;
        }
        int n = sDSListEntryArray.length;
        this.lc.log(10000000, "[RemoteHMIHandlerImpl#updateRemoteHMIHelpList] entryList.size=%1!", (long)n);
        if (n <= 0 || !bl) {
            this.dynamicLists.removeFromLookup(43);
        } else {
            DynamicSlotContent dynamicSlotContent = new DynamicSlotContent("remote HMI help list entries", sDSListEntryArray, 0);
            this.dynamicLists.addToLookup(43, dynamicSlotContent);
            this.reloadRemoteHMIGrammar(43);
        }
    }

    private void reloadRemoteHMIGrammar(int n) {
        ITTSASRContext iTTSASRContext = this.ttsASR.createGrammarContext();
        int n2 = SDSManagerBaseActivator.getMapping().getHMISlotGrammar(n);
        iTTSASRContext.addToGrammar(n2, 3);
        this.ttsASR.reloadGrammarContext(iTTSASRContext);
        if (this.speechRecognitionState == 3) {
            this.sdsHandlerService.sendSpeechSMEvent(1, false, false);
            this.isGrammarReloadTriggered = true;
        }
    }

    public void setRemoteHMICategorySetFinished(byte by) {
        this.lc.log(10000000, "RemoteHMIHandlerImpl#setRemoteHMICategorySetFinished: continueDialog=%1", (long)by);
        try {
            ((RemoteHMIRequestDialogContinuationCommand)SDSUtils.getActiveSystemCall()).setRemoteHMICategorySetFinished(by);
        }
        catch (ClassCastException classCastException) {
            this.lc.log(10000, "RemoteHMIHandlerImpl#setRemoteHMICategorySetFinished: Active command is no RemoteHMIRequestDialogContinuationCommand!");
        }
        catch (NullPointerException nullPointerException) {
            this.lc.log(100000, "RemoteHMIHandlerImpl#setRemoteHMICategorySetFinished: NullpointerException. No active command!");
        }
    }

    public int[] getCommands() {
        return commands;
    }

    public void setDictionary(OnlineServiceListener.OnlineSpeechDictionary onlineSpeechDictionary) {
        List list = onlineSpeechDictionary.getDictionaryEntries();
        DictionaryEntry[] dictionaryEntryArray = (DictionaryEntry[])list.toArray(new DictionaryEntry[0]);
        this.srHandler.setDictionary(onlineSpeechDictionary.getType(), onlineSpeechDictionary.getLanguage(), onlineSpeechDictionary.getFormat(), dictionaryEntryArray);
    }

    public void sessionEnded() {
        this.selectedHelpLine = -1;
    }

    public String toString() {
        return "RemoteHMIHandlerImpl";
    }

    public void setSelectedHelpLine(int n) {
        this.selectedHelpLine = n;
    }

    public int getSelectedHelpLine() {
        return this.selectedHelpLine;
    }

    public void setTTSASR(ITTSASR iTTSASR) {
        this.ttsASR = iTTSASR;
    }

    public void updateSpeechRecognitionState(int n) {
        this.speechRecognitionState = n;
    }

    public boolean isGrammarReloadTriggered() {
        return this.isGrammarReloadTriggered;
    }

    public void resetGrammarReloadTriggered() {
        this.isGrammarReloadTriggered = false;
    }
}

