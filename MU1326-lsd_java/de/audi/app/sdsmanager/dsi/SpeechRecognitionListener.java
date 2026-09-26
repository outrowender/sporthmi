/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dsi;

import de.audi.app.sdsmanager.AppSDSManager;
import de.audi.app.sdsmanager.SDSManagerBaseActivator;
import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.apps.SDSAdapter;
import de.audi.app.sdsmanager.apps.SDSAppFactory;
import de.audi.app.sdsmanager.apps.SDSTimeoutHandler;
import de.audi.app.sdsmanager.commands.CommandChangeLanguage;
import de.audi.app.sdsmanager.common.ISDSMapping;
import de.audi.app.sdsmanager.common.Logger;
import de.audi.app.sdsmanager.common.SDSStrategyAbstractFactory;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.dsi.ISpeechRecognitionStateListener;
import de.audi.app.sdsmanager.dsi.ISpeechRecogntionStateSupplier;
import de.audi.app.sdsmanager.dsi.SpeechRecognitionHandler;
import de.audi.app.sdsmanager.dsi.SpeechRecognitionHandlerUtils;
import de.audi.app.sdsmanager.dsi.SpeechRecognitionListener$1;
import de.audi.app.sdsmanager.dsi.SpeechRecognitionListener$10;
import de.audi.app.sdsmanager.dsi.SpeechRecognitionListener$11;
import de.audi.app.sdsmanager.dsi.SpeechRecognitionListener$2;
import de.audi.app.sdsmanager.dsi.SpeechRecognitionListener$3;
import de.audi.app.sdsmanager.dsi.SpeechRecognitionListener$4;
import de.audi.app.sdsmanager.dsi.SpeechRecognitionListener$5;
import de.audi.app.sdsmanager.dsi.SpeechRecognitionListener$6;
import de.audi.app.sdsmanager.dsi.SpeechRecognitionListener$7;
import de.audi.app.sdsmanager.dsi.SpeechRecognitionListener$8;
import de.audi.app.sdsmanager.dsi.SpeechRecognitionListener$9;
import de.audi.app.sdsmanager.grammar.ISDSGrammarStateStrategy;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Command;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.CommandListManager;
import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.command.ICommandResponseSupplier;
import de.esolutions.fw.util.commons.Formatter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.speechrec.DSISpeechRec;
import org.dsi.ifc.speechrec.DSISpeechRecListener;
import org.dsi.ifc.speechrec.GrammarInfo;
import org.dsi.ifc.speechrec.GrammarStateInfo;
import org.dsi.ifc.speechrec.NBestList;
import org.dsi.ifc.speechrec.VDECapabilities;

public class SpeechRecognitionListener
implements DSISpeechRecListener,
ICommandResponseSupplier,
ISpeechRecogntionStateSupplier {
    private static boolean firstRecogOpened = false;
    protected LogChannel lc = Logger.getDSIASRLog();
    protected final IFrameworkAccess framework;
    protected final SpeechRecognitionHandler speechRecHandler;
    private final AppSDSManager sdsManager;
    private final SDSAppFactory appFactory;
    private final SDSTimeoutHandler sdsTimeoutHandler;
    private CommandListManager cmdListManager;
    private final SDSAdapter sdsAdapter;
    private volatile int speechRecognizerState = 1;
    private volatile boolean waitingPromptTriggeredForRecognition = false;
    private final Set speechRecognitionStateListeners = new HashSet();
    private final SDSStrategyAbstractFactory sdsStrategyAbstractFactory;

    public SpeechRecognitionListener(IFrameworkAccess iFrameworkAccess, SpeechRecognitionHandler speechRecognitionHandler, AppSDSManager appSDSManager, SDSAppFactory sDSAppFactory, SDSAdapter sDSAdapter, SDSTimeoutHandler sDSTimeoutHandler, SDSStrategyAbstractFactory sDSStrategyAbstractFactory) {
        this.framework = iFrameworkAccess;
        this.speechRecHandler = speechRecognitionHandler;
        this.sdsManager = appSDSManager;
        this.appFactory = sDSAppFactory;
        this.sdsAdapter = sDSAdapter;
        this.sdsTimeoutHandler = sDSTimeoutHandler;
        this.sdsStrategyAbstractFactory = sDSStrategyAbstractFactory;
        this.lc.log(-2137614336, "SpeechRecognitionListener initialized.");
    }

    public void stop() {
        this.lc.log(-2137614336, "[SpeechRecognitionListener#stop] called");
    }

    public void setDSI(DSISpeechRec dSISpeechRec) {
        this.lc.log(-2137614336, "[SpeechRecognitionListener#setDSI]");
        this.speechRecHandler.setDSISR(dSISpeechRec);
        dSISpeechRec.setNotification(new int[]{3, 6, 2, 19, 10, 4, 15, 20, 21, 1, 8, 9, 12, 5, 16, 18, 14, 13, 11, 22, 24}, (DSIListener)this);
        this.lc.log(-2137614336, "[SpeechRecognitionListener#setDSI] Connected to DSISpeechRec version %1!", (Object)"2.11.25");
    }

    @Override
    public void responseLoadGrammar(int n, GrammarInfo[] grammarInfoArray) {
        this.lc.log(-2137614336, "[SpeechRecognitionListener#responseLoadGrammar] replyCode=%2, grammarIDs=%1", (Object)SDSUtils.toString(SpeechRecognitionHandlerUtils.getGrammarIDs(grammarInfoArray)), (long)n);
        CommandResponse.execute(this, new SpeechRecognitionListener$1(this, n, grammarInfoArray));
    }

    @Override
    public void responsePreloadGrammar(int n, GrammarInfo[] grammarInfoArray) {
        this.lc.log(-2137614336, "[SpeechRecognitionListener#responsePreloadGrammar] replyCode=%2, grammarIDs=%1", (Object)SDSUtils.toString(SpeechRecognitionHandlerUtils.getGrammarIDs(grammarInfoArray)), (long)n);
        if (n == 200) {
            this.lc.log(-2137614336, "[SpeechRecognitionListener#responsePreloadGrammar] result ignored due to recognition abort");
            return;
        }
    }

    @Override
    public void responseUnloadGrammar(int n, GrammarInfo[] grammarInfoArray) {
        this.lc.log(-2137614336, "[SpeechRecognitionListener#responseUnloadGrammar] replyCode=%2, grammarIDs=%1", (Object)SDSUtils.toString(SpeechRecognitionHandlerUtils.getGrammarIDs(grammarInfoArray)), (long)n);
        CommandResponse.execute(this, new SpeechRecognitionListener$2(this, n, grammarInfoArray));
    }

    @Override
    public void responseUnpreloadGrammar(int n, GrammarInfo[] grammarInfoArray) {
        this.lc.log(-2137614336, "[SpeechRecognitionListener#responseUnpreloadGrammar] replyCode=%2, grammarIDs=%1", (Object)SDSUtils.toString(SpeechRecognitionHandlerUtils.getGrammarIDs(grammarInfoArray)), (long)n);
        if (n == 200) {
            this.lc.log(-2137614336, "[SpeechRecognitionListener#responseUnpreloadGrammar] result ignored due to recognition abort");
            return;
        }
        if (SDSUtils.checkReplyCodeForError(n, this.lc)) {
            this.lc.log(-1601830656, "[SpeechRecognitionListener#responseUnloadGrammar] Error found, sending ASR_ERROR event!");
            this.sdsAdapter.sendSpeechSMEvent(3001, false, false);
            return;
        }
    }

    @Override
    public void responseStartRecognition(int n) {
        this.lc.log(-2137614336, "[SpeechRecognitionListener#responseStartRecognition] replyCode=%1", (long)n);
        CommandResponse.execute(this, new SpeechRecognitionListener$3(this, n));
    }

    @Override
    public void responseWaitForResults(int n, NBestList nBestList) {
        this.lc.log(-2137614336, "[SpeechRecognitionListener#responseWaitForResults] replyCode=%2, results='%1'", (Object)nBestList, (long)n);
        if (nBestList != null && nBestList.entries != null && nBestList.entries.length > 0 && nBestList.entries[0] != null) {
            System.out.println(new StringBuffer().append("TOP RECOGNIZED ENTRY: ").append(nBestList.entries[0]).toString());
        }
        this.waitingPromptTriggeredForRecognition = false;
        CommandResponse.execute(this, new SpeechRecognitionListener$4(this, n, nBestList));
    }

    @Override
    public void responseAbort(int n) {
        this.lc.log(-2137614336, "[SpeechRecognitionListener#responseAbort] replyCode=%1", (long)n);
        this.sdsAdapter.removeSDSProgressIcon();
        CommandResponse.execute(this, new SpeechRecognitionListener$5(this, n));
    }

    @Override
    public void responseShutdown(int n) {
        this.lc.log(-2137614336, "[SpeechRecognitionListener#responseShutdown] replyCode=%1", (long)n);
        if (SDSUtils.checkReplyCodeForError(n, this.lc)) {
            this.lc.log(-1601830656, "[SpeechRecognitionListener#responseShutdown] Error found, sending ERROR!");
            this.sdsAdapter.sendSpeechSMEvent(3001, false, false);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updateRecognizerState(int n, int n2) {
        if (n2 == 2) {
            this.lc.log(-2137614336, "[SpeechRecognitionListener#updateRecognizerState] Called, invalid update.");
            return;
        }
        this.speechRecognizerState = n;
        this.lc.log(-2137614336, "[SpeechRecognitionListener#updateRecognizerState] sdsState=%1", (long)this.speechRecognizerState);
        switch (this.speechRecognizerState) {
            case 7: {
                this.lc.log(-2137614336, "[SpeechRecognitionListener#updateRecognizerState] Speech recognition is aborted!");
                this.sdsManager.setRecognition(false);
                break;
            }
            case 1: {
                this.lc.log(-2137614336, "[SpeechRecognitionListener#updateRecognizerState] Speech recognition is idle!");
                if (!SDSUtils.isOnlineRecogActive(this.lc)) break;
                byte by = this.appFactory.getSDSHandlerNavi().poiOnlineVoiceDataAvailable();
                this.lc.log(-2137614336, "[SpeechRecognitionListener#updateRecognizerState] Online recognition active, voiceDataAvailable=%1!", (long)by);
                break;
            }
            case 3: {
                this.lc.log(-2137614336, "[SpeechRecognitionListener#updateRecognizerState] Speech recognition is in progress!");
                if (!firstRecogOpened) {
                    firstRecogOpened = true;
                    this.framework.getStartupMgr().logStartupEvent("[Startup SDS] Phase 8: First recognizer opened.");
                }
                this.sdsManager.setRecognition(true);
                if (!SDSModelAccess.isMsgDictateActive()) break;
                this.lc.log(-2137614336, "[SpeechRecognitionListener#updateRecognizerState] Message dictation recognition started, signaling start of speech!");
                this.appFactory.getSDSHandlerMessageDictation().signalStartOfSpeech();
                break;
            }
            case 4: {
                this.lc.log(-2137614336, "[SpeechRecognitionListener#updateRecognizerState] Speech recognition is finished!");
                this.sdsManager.setRecognition(false);
                if (!SDSModelAccess.isMsgDictateActive()) break;
                this.lc.log(-2137614336, "[SpeechRecognitionListener#updateRecognizerState] Message dictation recognition finished, signaling end of speech!");
                this.appFactory.getSDSHandlerMessageDictation().signalEndOfSpeech();
                break;
            }
            case 8: {
                this.lc.log(-1601830656, "[SpeechRecognitionListener#updateRecognizerState] Speech recognition timed out!");
                this.sdsManager.setRecognition(false);
                break;
            }
            case 5: {
                this.lc.log(-2137614336, "[SpeechRecognitionListener#updateRecognizerState] Speech recognition user utterance started!");
                break;
            }
            case 6: {
                this.lc.log(-2137614336, "[SpeechRecognitionListener#updateRecognizerState] Speech recognition user utterance finished, (re)starting progress icon timer!");
                this.sdsTimeoutHandler.restartProgressIconTimer();
                this.sdsManager.setRecognition(false);
                break;
            }
            default: {
                this.lc.log(-1601830656, "[SpeechRecognitionListener#updateRecognizerState] Unhandled sdsState %1!", (long)n);
                this.sdsManager.setRecognition(false);
            }
        }
        Set set = this.speechRecognitionStateListeners;
        synchronized (set) {
            Iterator iterator = this.speechRecognitionStateListeners.iterator();
            while (iterator.hasNext()) {
                ISpeechRecognitionStateListener iSpeechRecognitionStateListener = (ISpeechRecognitionStateListener)iterator.next();
                if (iSpeechRecognitionStateListener == null) {
                    this.lc.log(-1601830656, "[SpeechRecognitionListener#updateRecognizerState] Listener is null => NOP!");
                    continue;
                }
                iSpeechRecognitionStateListener.updateSpeechRecognitionState(this.speechRecognizerState);
            }
        }
    }

    @Override
    public void updateAborted(boolean bl, int n) {
        if (n == 2) {
            this.lc.log(-2137614336, "[SpeechRecognitionListener#updateAborted] Called, invalid update.");
            return;
        }
        this.lc.log(-2137614336, "[SpeechRecognitionListener#updateAborted] isAborted=%1", bl);
    }

    @Override
    public void updateFailure(boolean bl, int n) {
        if (n == 2) {
            this.lc.log(-2137614336, "[SpeechRecognitionListener#updateFailure] Called, invalid update.");
            return;
        }
        this.lc.log(-2137614336, "[SpeechRecognitionListener#updateFailure] isFailure=%1", bl);
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        this.lc.log(-1601830656, "SpeechRecognitionListener#asyncException called: %2 %1 %3", (Object)string, (long)n, (long)n2);
    }

    @Override
    public void responseInit(int n) {
        this.lc.log(-2137614336, "[SpeechRecognitionListener#responseInit] replyCode=%1", (long)n);
        CommandResponse.execute(this, new SpeechRecognitionListener$6(this, n));
    }

    @Override
    public void responseSetLanguage(int n) {
        this.lc.log(-2137614336, "[SpeechRecognitionListener#responseSetLanguage] replyCode=%1", (long)n);
        CommandResponse.execute(this, new SpeechRecognitionListener$7(this, n));
    }

    @Override
    public void updateAvailableLanguages(String[] stringArray, int n) {
        if (n == 2) {
            this.lc.log(-2137614336, "[SpeechRecognitionListener#updateAvailableLanguages] Called, invalid update.");
            return;
        }
        this.lc.log(-2137614336, "[SpeechRecognitionListener#updateAvailableLanguages] availableLanguages=%1", (Object)stringArray);
        this.speechRecHandler.updateAvailableLanguages(stringArray);
    }

    @Override
    public void updateLanguage(String string, int n, int n2) {
        if (n2 == 2) {
            this.lc.log(-2137614336, "[SpeechRecognitionListener#updateLanguage] Called, invalid update.");
            return;
        }
        this.lc.log(-2137614336, "[SpeechRecognitionListener#updateLanguage] language=%1, skinId=%2", (Object)string, (long)n);
    }

    @Override
    public void responseInitVoiceTag(int n) {
        this.lc.log(-2137614336, "[SpeechRecognitionListener#responseInitVoiceTag] replyCode=%1", (long)n);
    }

    @Override
    public void responseRecordVoiceTag(int n) {
        this.lc.log(-2137614336, "[SpeechRecognitionListener#responseRecordVoiceTag] replyCode=%1", (long)n);
    }

    @Override
    public void responseDeleteVoiceTag(int n) {
        this.lc.log(-2137614336, "[SpeechRecognitionListener#responseDeleteVoiceTag] replyCode=%1", (long)n);
    }

    @Override
    public void responseSetConfidenceRejectThreshold(int n) {
        this.lc.log(-2137614336, "[SpeechRecognitionListener#responseSetConfidenceRejectThreshold] replyCode=%1", (long)n);
    }

    @Override
    public void responseSetUnambiguousResultThreshold(int n) {
        this.lc.log(-2137614336, "[SpeechRecognitionListener#responseSetUnambiguousResultThreshold] replyCode=%1", (long)n);
    }

    @Override
    public void responseSetFirstLevelSize(int n) {
        this.lc.log(-2137614336, "[SpeechRecognitionListener#responseSetFirstLevelSize] replyCode=%1", (long)n);
    }

    @Override
    public void responseSetUnambiguousResultRange(int n) {
        this.lc.log(-2137614336, "[SpeechRecognitionListener#responseSetUnambiguousResultRange] replyCode=%1", (long)n);
    }

    @Override
    public void responseSetRecognitionTimeout(int n) {
        this.lc.log(-2137614336, "[SpeechRecognitionListener#responseSetRecognitionTimeout] replyCode=%1", (long)n);
    }

    @Override
    public void responseSetUtteranceStartTimeout(int n) {
        this.lc.log(-2137614336, "[SpeechRecognitionListener#responseSetUtteranceStartTimeout] replyCode=%1", (long)n);
    }

    @Override
    public void updateAbsoluteConfidenceThreshold(int n, int n2) {
        if (n2 == 2) {
            this.lc.log(-2137614336, "[SpeechRecognitionListener#updateAbsoluteConfidenceThreshold] Called, invalid update.");
            return;
        }
        this.lc.log(-2137614336, "[SpeechRecognitionListener#updateAbsoluteConfidenceThreshold] threshold=%1", (long)n);
    }

    @Override
    public void updateConfidenceRejectThreshold(int n, int n2) {
        if (n2 == 2) {
            this.lc.log(-2137614336, "[SpeechRecognitionListener#updateConfidenceRejectThreshold] Called, invalid update.");
            return;
        }
        this.lc.log(-2137614336, "[SpeechRecognitionListener#updateConfidenceRejectThreshold] threshold=%1", (long)n);
    }

    @Override
    public void updateUnambiguousResultThreshold(int n, int n2) {
        if (n2 == 2) {
            this.lc.log(-2137614336, "[SpeechRecognitionListener#updateUnambiguousResultThreshold] Called, invalid update.");
            return;
        }
        this.lc.log(-2137614336, "[SpeechRecognitionListener#updateUnambiguousResultThreshold] threshold=%1", (long)n);
    }

    @Override
    public void updateFirstLevelSize(int n, int n2) {
        if (n2 == 2) {
            this.lc.log(-2137614336, "[SpeechRecognitionListener#updateFirstLevelSize] Called, invalid update.");
            return;
        }
        this.lc.log(-2137614336, "[SpeechRecognitionListener#updateFirstLevelSize] threshold=%1", (long)n);
    }

    @Override
    public void updateMaxCommandNBestListSize(int n, int n2) {
        if (n2 == 2) {
            this.lc.log(-2137614336, "[SpeechRecognitionListener#updateMaxCommandNBestListSize] Called, invalid update.");
            return;
        }
        this.lc.log(-2137614336, "[SpeechRecognitionListener#updateMaxCommandNBestListSize] size=%1", (long)n);
    }

    @Override
    public void updateMaxSlotNBestListSize(int n, int n2) {
        if (n2 == 2) {
            this.lc.log(-2137614336, "[SpeechRecognitionListener#updateMaxSlotNBestListSize] Called, invalid update.");
            return;
        }
        this.lc.log(-2137614336, "[SpeechRecognitionListener#updateMaxSlotNBestListSize] size=%1", (long)n);
    }

    @Override
    public void updateUnambiguousResultRange(int n, int n2) {
        if (n2 == 2) {
            this.lc.log(-2137614336, "[SpeechRecognitionListener#updateUnambiguousResultRange] Called, invalid update.");
            return;
        }
        this.lc.log(-2137614336, "[SpeechRecognitionListener#updateUnambiguousResultRange] threshold=%1", (long)n);
    }

    @Override
    public void updateRecognitionTimeout(int n, int n2) {
        if (n2 == 2) {
            this.lc.log(-2137614336, "[SpeechRecognitionListener#updateRecognitionTimeout] Called, invalid update.");
            return;
        }
        this.lc.log(-2137614336, "[SpeechRecognitionListener#updateRecognitionTimeout] threshold=%1", (long)n);
    }

    @Override
    public void updateUtteranceStartTimeout(int n, int n2) {
        if (n2 == 2) {
            this.lc.log(-2137614336, "[SpeechRecognitionListener#updateUtteranceStartTimeout] Called, invalid update.");
            return;
        }
        this.lc.log(-2137614336, "[SpeechRecognitionListener#updateUtteranceStartTimeout] threshold=%1", (long)n);
    }

    @Override
    public void responseStartPostTraining(int n) {
        this.lc.log(-2137614336, "[SpeechRecognitionListener#responseStartPostTraining] replyCode=%1", (long)n);
    }

    @Override
    public void responseStopPostTraining(int n) {
        this.lc.log(-2137614336, "[SpeechRecognitionListener#responseStopPostTraining] replyCode=%1", (long)n);
    }

    @Override
    public void responseRequestSDSAvailability(int n, int n2) {
        this.lc.log(-2137614336, "[SpeechRecognitionListener#responseRequestSDSAvailability] sdsAvailability=%1, replyCode=%2 -> NOP", (long)n, (long)n2);
    }

    @Override
    public void updateSDSAvailability(int n, int n2) {
        this.lc.log(-2137614336, "[SpeechRecognitionListener#updateSDSAvailability] sdsAvailability=%1, validFlag=%2", (long)n, (long)n2);
        if (n2 != 1) {
            return;
        }
        boolean bl = n != 2;
        this.lc.log(-2137614336, "[SpeechRecognitionListener#updateSDSAvailability] %1 SDS", (Object)(bl ? "Disable" : "Enable"));
        SDSModelAccess.setSDSDisabled(bl);
    }

    @Override
    public void responseSetSpellingMode(int n) {
        this.lc.log(-2137614336, "[SpeechRecognitionListener#responseSetSpellingMode] replyCode=%1", (long)n);
    }

    @Override
    public void responseDeleteLastSpellingBlock(int n, NBestList nBestList) {
        this.lc.log(-2137614336, "[SpeechRecognitionListener#responseDeleteLastSpellingBlock] replyCode=%1", (long)n);
    }

    @Override
    public void responseStartDialogue(int n) {
        this.lc.log(-2137614336, "[SpeechRecognitionListener#responseStartDialogue] replyCode=%1", (long)n);
        this.sdsManager.updateStatusActive();
    }

    @Override
    public void responseStopDialogue(int n) {
        this.lc.log(-2137614336, "[SpeechRecognitionListener#responseStopDialogue] replyCode=%1", (long)n);
        this.sdsManager.updateStatusInactive();
    }

    @Override
    public void updateTemporaryG2PLanguageChangeActive(boolean bl, int n) {
        if (n == 2) {
            this.lc.log(-2137614336, "[SpeechRecognitionListener#updateTemporaryG2PLanguageChangeActive] Called, invalid update.");
            return;
        }
        this.lc.log(-2137614336, "[SpeechRecognitionListener#updateTemporaryG2PLanguageChangeActive] changeActive=%1", bl);
    }

    @Override
    public void responseSetMaxCommandNBestListSize(int n) {
        this.lc.log(-2137614336, "[SpeechRecognitionListener#responseSetMaxCommandNBestListSize] replyCode=%1", (long)n);
        CommandResponse.execute(this, new SpeechRecognitionListener$8(this, n));
    }

    @Override
    public void responseSetMaxSlotNBestListSize(int n) {
        this.lc.log(-2137614336, "[SpeechRecognitionListener#responseSetMaxSlotNBestListSize] replyCode=%1", (long)n);
        CommandResponse.execute(this, new SpeechRecognitionListener$9(this, n));
    }

    @Override
    public void responseRequestGraphemicGroupAsNBestList(int n, NBestList nBestList) {
        this.lc.log(-2137614336, "[SpeechRecognitionListener#responseRequestGraphemicGroupAsNBestList] replyCode=%2, results='%1'", (Object)nBestList, (long)n);
        this.appFactory.getSDSHandlerSystem().responseRequestGGAsNBestList(n, nBestList);
    }

    @Override
    public void responseGetVersion(String string) {
        this.lc.log(-2137614336, "[SpeechRecognitionListener#responseGetVersion] version=%1", (Object)string);
        String string2 = this.framework.getVersionInfo().getTextToolSDSVersion();
        Formatter.standardTargetSysout("################### [responseGetVersion] ###############");
        Formatter.standardTargetSysout(new StringBuffer().append("Resources SDS Version : ").append(string).toString());
        Formatter.standardTargetSysout(new StringBuffer().append("   HMI    SDS Version : ").append(string2).toString());
        Formatter.standardTargetSysout("########################################################");
    }

    @Override
    public void responseRequestVDECapabilities(int n, VDECapabilities vDECapabilities) {
        this.lc.log(-2137614336, "[SpeechRecognitionListener#responseRequestVDECapabilities] replyCode=%2, capabilities=%1!", (Object)vDECapabilities, (long)n);
        String string = this.framework.getLanguageMgr().getCurrentLanguage("LANG_COMPONENT_SDS").getLanguageCode();
        this.lc.log(-2137614336, "[SpeechRecognitionListener#responseRequestVDECapabilities] currentSDSLangCode=%1!", (Object)string);
        this.appFactory.getSDSHandlerNavi().responseVDECapabilities(n, vDECapabilities, string);
        CommandList commandList = this.getActiveCommandList();
        if (commandList == null) {
            return;
        }
        Command command = commandList.getActiveCommand();
        if (command instanceof CommandChangeLanguage) {
            ((CommandChangeLanguage)command).responseRequestVDECapabilities(n);
        }
    }

    @Override
    public void responseDeleteProfile(int n) {
        this.lc.log(-2137614336, "SpeechRecognitionListener#responseDeleteProfile: replyCode=%1", (long)n);
    }

    @Override
    public void responseLoadProfile(int n) {
        this.lc.log(-2137614336, "SpeechRecognitionListener#responseLoadProfile: replyCode=%1", (long)n);
    }

    @Override
    public void responseUnloadProfile(int n) {
        this.lc.log(-2137614336, "SpeechRecognitionListener#responseUnloadProfile: replyCode=%1", (long)n);
    }

    @Override
    public void updateAvailableProfiles(int[] nArray, int n) {
        if (n == 2) {
            this.lc.log(-2137614336, "[SpeechRecognitionListener#updateAvailableProfiles] Called, invalid update.");
            return;
        }
        this.lc.log(-2137614336, "SpeechRecognitionListener#updateAvailableProfiles: availableProfiles=%1", (Object)nArray);
    }

    @Override
    public void updateGrammarStatus(int n, boolean bl, int n2) {
    }

    @Override
    public void updateGrammarState(GrammarStateInfo grammarStateInfo, int n) {
        if (n == 2) {
            this.lc.log(-2137614336, "[SpeechRecognitionListener#updateGrammarState] Called, invalid update.");
            return;
        }
        this.lc.log(-2137614336, "[SpeechRecognitionListener#updateGrammarState] info=%1", (Object)grammarStateInfo);
        if (grammarStateInfo == null) {
            this.lc.log(-1601830656, "updateGrammarState: No info given!");
            return;
        }
        int[] nArray = grammarStateInfo.getSlotIds();
        if (nArray == null) {
            return;
        }
        ISDSGrammarStateStrategy iSDSGrammarStateStrategy = this.sdsStrategyAbstractFactory.createSdsGrammarStateStrategy(grammarStateInfo);
        byte by = iSDSGrammarStateStrategy.getGrammarStatus();
        boolean bl = iSDSGrammarStateStrategy.isGrammarStatusCompiling();
        block6: for (int n2 : nArray) {
            int n3 = SDSManagerBaseActivator.getMapping().getSlotTypeMapping(n2);
            this.lc.log(-2137614336, "[SpeechRecognitionListener#updateGrammarState] handle slotID %1 => mappingID %2", (long)n2, (long)n3);
            switch (n3) {
                case 3: {
                    SDSModelAccess.setMediaAlbumGrammarAvailableChoice(by);
                    SDSModelAccess.setMediaGrammarCompiling(bl ? 1 : 0);
                    continue block6;
                }
                case 2: {
                    SDSModelAccess.setMediaArtistGrammarAvailableChoice(by);
                    SDSModelAccess.setMediaGrammarCompiling(bl ? 1 : 0);
                    continue block6;
                }
                case 1: {
                    SDSModelAccess.setMediaTitleGrammarAvailableChoice(by);
                    SDSModelAccess.setMediaGrammarCompiling(bl ? 1 : 0);
                    continue block6;
                }
                case 4: {
                    SDSModelAccess.setADBGrammarAvailableModel(iSDSGrammarStateStrategy.getGrammarStatusForMedia());
                    continue block6;
                }
                default: {
                    this.lc.log(-1601830656, "[SpeechRecognitionListener#updateGrammarState] slotID %1 => mappingID %2 undefined!", (long)n2, (long)n3);
                    continue block6;
                }
            }
        }
        if (SDSModelAccess.checkAllMediaSlotGrammarsAvailable()) {
            SDSModelAccess.setMediaGrammarAvailableModel(1);
        } else {
            SDSModelAccess.setMediaGrammarAvailableModel(0);
        }
    }

    @Override
    public void responseRestoreFactorySettings(int n) {
        this.lc.log(-2137614336, "SpeechRecognitionListener#responseRestoreFactorySettings: replyCode=%1", (long)n);
    }

    @Override
    public void responseSetDictionary(int n) {
        this.lc.log(-2137614336, "SpeechRecognitionListener#responseSetDictionary: replyCode=%1", (long)n);
    }

    @Override
    public void responseEnableContinuousUpdate(int n) {
        this.lc.log(-2137614336, "SpeechRecognitionListener#responseEnableContinuousUpdate: replyCode=%1", (long)n);
    }

    @Override
    public void responseCheckDbPartition(int n) {
        this.lc.log(-2137614336, "SpeechRecognitionListener#responseCheckDbPartition: checkResult=%1", (long)n);
        CommandResponse.execute(this, new SpeechRecognitionListener$10(this, n));
    }

    @Override
    public void responseSetASRParameterConfiguration(int n) {
        this.lc.log(-1601830656, "SpeechRecognitionListener#responseSetASRParameterConfiguration: replyCode=%1 => NOP!", (long)n);
    }

    @Override
    public void updateASRParameterConfiguration(int[] nArray, int[] nArray2, int[] nArray3, int n) {
        if (n == 2) {
            this.lc.log(-2137614336, "SpeechRecognitionListener#updateNBestList: Called, invalid update.");
            return;
        }
        this.lc.log(-1601830656, "SpeechRecognitionListener#updateASRParameterConfiguration: NOP!");
    }

    @Override
    public void updateNBestList(NBestList nBestList, int n) {
        int n2;
        if (this.sdsManager.isSDSAborting()) {
            this.lc.log(-2137614336, "SpeechRecognitionListener#updateNBestList: SDS is aborting: ignoring updateNBestList updates!");
            return;
        }
        if (n == 2) {
            this.lc.log(-2137614336, "SpeechRecognitionListener#updateNBestList: Called, invalid update => NOP!");
            return;
        }
        if (SDSUtils.isEmpty(nBestList)) {
            this.lc.log(-2137614336, "SpeechRecognitionListener#updateNBestList: N-Best list is null or empty => NOP!");
            return;
        }
        if (this.waitingPromptTriggeredForRecognition) {
            this.lc.log(-2137614336, "SpeechRecognitionListener#updateNBestList: Already triggered waiting prompt for current recognition => NOP!");
            return;
        }
        ISDSMapping iSDSMapping = SDSManagerBaseActivator.getMapping();
        boolean bl = iSDSMapping.isSUIGrammar(n2 = nBestList.getEntries()[0].getGrammarId());
        if (bl) {
            this.lc.log(-2137614336, "SpeechRecognitionListener#updateNBestList: Recognizing SUI grammar with ID=%1 => send SM-event for delay prompt!", (long)n2);
            this.sdsAdapter.setSDSProgressIconRemovalAfterPrompt(false);
            this.waitingPromptTriggeredForRecognition = true;
            this.sdsAdapter.sendSpeechSMEvent(1015, false, false);
            return;
        }
        boolean bl2 = iSDSMapping.isNaviTrufflesInitialEvent(iSDSMapping.getEventIdForRule(n2));
        boolean bl3 = SDSModelAccess.getNaviTrufflesContextActive();
        if (bl2 && !bl3) {
            this.lc.log(-2137614336, "SpeechRecognitionListener#updateNBestList: Recognizing initial truffles grammar with ID=%1 => send SM-event for delay prompt!", (long)n2);
            this.sdsAdapter.setSDSProgressIconRemovalAfterPrompt(false);
            this.waitingPromptTriggeredForRecognition = true;
            this.sdsAdapter.sendSpeechSMEvent(1015, false, false);
            return;
        }
        this.lc.log(-2137614336, "SpeechRecognitionListener#updateNBestList: Neither recognizing SUI-, nor initial truffles-grammar (grammar=%2, truffleContextActive=%1) => NOP!", bl3, (long)n2);
    }

    @Override
    public DSIListener getDSIDefaultHandler() {
        return new SpeechRecognitionListener$11(this, Logger.getCommandLog(), "DEFAULT");
    }

    @Override
    public CommandList getActiveCommandList() {
        return this.cmdListManager.getActiveCommandList();
    }

    @Override
    public LogChannel getLogChannel() {
        return Logger.getCommandLog();
    }

    @Override
    public String getHandlerName() {
        return super.getClass().getName();
    }

    public void setCommandListManager(CommandListManager commandListManager) {
        this.cmdListManager = commandListManager;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean registerSpeechRecognitionStateListener(ISpeechRecognitionStateListener iSpeechRecognitionStateListener) {
        boolean bl;
        if (iSpeechRecognitionStateListener == null) {
            this.lc.log(10000, "SpeechRecognitionListener#registerSpeechRecognitionStateListener: Listener is null!");
            return false;
        }
        Set set = this.speechRecognitionStateListeners;
        synchronized (set) {
            bl = this.speechRecognitionStateListeners.add(iSpeechRecognitionStateListener);
        }
        if (bl) {
            this.lc.log(-2137614336, "SpeechRecognitionListener#registerSpeechRecognitionStateListener: Listener %1 added => Immediately send update!", (Object)super.getClass().getName());
            iSpeechRecognitionStateListener.updateSpeechRecognitionState(this.speechRecognizerState);
        } else {
            this.lc.log(-1601830656, "SpeechRecognitionListener#registerSpeechRecognitionStateListener: Listener %1 already contained!", (Object)super.getClass().getName());
        }
        return bl;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean unregisterSpeechRecognitionStateListener(ISpeechRecognitionStateListener iSpeechRecognitionStateListener) {
        boolean bl;
        if (iSpeechRecognitionStateListener == null) {
            this.lc.log(10000, "SpeechRecognitionListener#unregisterSpeechRecognitionStateListener: Listener is null!");
            return false;
        }
        Set set = this.speechRecognitionStateListeners;
        synchronized (set) {
            bl = this.speechRecognitionStateListeners.remove(iSpeechRecognitionStateListener);
        }
        if (bl) {
            this.lc.log(-2137614336, "SpeechRecognitionListener#unregisterSpeechRecognitionStateListener: Listener %1 removed!", (Object)super.getClass().getName());
        } else {
            this.lc.log(-1601830656, "SpeechRecognitionListener#unregisterSpeechRecognitionStateListener: Listener %1 was not contained!", (Object)super.getClass().getName());
        }
        return bl;
    }

    @Override
    public void responseDeleteLastFlexVDEPart(int n, NBestList nBestList) {
        this.appFactory.getSDSHandlerNavi().responseDeleteLastTrufflesSearchText(n, nBestList);
    }

    @Override
    public void responseClearFlexVDEHistory(int n) {
        this.appFactory.getSDSHandlerNavi().responseClearTrufflesSearchHistory(n);
    }

    @Override
    public void updateVDEMediumState(int n, int n2) {
        if (n2 == 2) {
            this.lc.log(-2137614336, "SpeechRecognitionListener#updateVDEMediumState: Called, invalid update => NOP!");
            return;
        }
        this.lc.log(-2137614336, "SpeechRecognitionListener#updateVDEMediumState: Called, vdeMediumState=%1!", (long)n);
        this.appFactory.getSDSHandlerNavi().updateVDEMediumState(n);
    }

    @Override
    public void updateAvailableSLMLanguages(String[] stringArray, int n) {
    }

    @Override
    public void updateOnlineCapabilities(String[] stringArray, int n) {
    }
}

