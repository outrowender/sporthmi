/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dsi;

import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.apps.SDSAdapter;
import de.audi.app.sdsmanager.apps.system.ISystemVBIHandler;
import de.audi.app.sdsmanager.common.Logger;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.dsi.SpeechRecognitionHandlerUtils;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.i18n.ILanguageManager;
import de.audi.atip.log.LogChannel;
import de.audi.atip.util.MethodCall;
import org.dsi.ifc.speechrec.DSISpeechRec;
import org.dsi.ifc.speechrec.DictionaryEntry;
import org.dsi.ifc.speechrec.Grammar;

public class SpeechRecognitionHandler {
    private static boolean firstRecogStarted = false;
    private LogChannel lc = Logger.getDSIASRLog();
    private final IFrameworkAccess framework;
    private final SpeechRecognitionHandlerUtils recUtils;
    private SDSAdapter sdsAdapter;
    private ISystemVBIHandler systemVBIHandler;
    private static final byte RECOGNITION_MODE_NONE = 0;
    private int recognitionMode = 0;
    private volatile boolean longRecognitionTimeoutModeExpected = false;
    private volatile boolean longRecognitionTimeoutModeCurrentlySet = false;
    private final ILanguageManager languageManager;
    private String[] languages;

    public SpeechRecognitionHandler(IFrameworkAccess iFrameworkAccess) {
        this.framework = iFrameworkAccess;
        this.languageManager = iFrameworkAccess.getLanguageMgr();
        this.recUtils = new SpeechRecognitionHandlerUtils();
        this.lc.log(10000000, "SpeechRecognitionHandler initialized.");
    }

    public boolean loadGrammar(Grammar[] grammarArray) {
        DSISpeechRec dSISpeechRec;
        if (this.lc.isInfo()) {
            this.lc.log(1000000, "[SpeechRecognitionHandler#loadGrammar] grammarIDs=%1", (Object)SDSUtils.toString(SpeechRecognitionHandlerUtils.getGrammarIDs(grammarArray)));
        }
        if ((dSISpeechRec = this.getDSISR()) == null) {
            this.lc.log(100000, "[SpeechRecognitionHandler#loadGrammar] No DSISpeechRec available!");
            return false;
        }
        this.lc.log(1000000, "[SpeechRecognitionHandler#loadGrammar] Calling dsiSpeechRec#loadGrammar()!");
        dSISpeechRec.loadGrammar(grammarArray);
        return true;
    }

    void preloadGrammar(Grammar[] grammarArray) {
        this.lc.log(10000000, "[SpeechRecognitionHandler#preLoadGrammar] called");
        DSISpeechRec dSISpeechRec = this.getDSISR();
        if (dSISpeechRec == null) {
            this.lc.log(10000, "[SpeechRecognitionHandler#preLoadGrammar] DSISpeechRec not available!");
            return;
        }
        if (grammarArray == null) {
            return;
        }
        dSISpeechRec.preloadGrammar(grammarArray);
    }

    void unpreloadGrammar(int[] nArray) {
        this.lc.log(10000000, "[SpeechRecognitionHandler#unpreLoadGrammar] called");
        DSISpeechRec dSISpeechRec = this.getDSISR();
        if (dSISpeechRec == null) {
            this.lc.log(10000, "[SpeechRecognitionHandler#unpreloadGrammar] DSISpeechRec not available!");
            return;
        }
        if (this.lc.isDebug()) {
            this.lc.log(10000000, "[SpeechRecognitionHandler#unpreloadGrammar] Unpreloading grammarIDs %1!", (Object)SDSUtils.toString(nArray));
        }
        dSISpeechRec.unpreloadGrammar(SpeechRecognitionHandlerUtils.convertInfo(nArray));
    }

    public boolean unloadGrammar(int[] nArray) {
        this.lc.log(1000000, "[SpeechRecognitionHandler#unloadGrammar] grammarIDs=%1", (Object)nArray);
        DSISpeechRec dSISpeechRec = this.getDSISR();
        if (dSISpeechRec == null) {
            this.lc.log(1000000, "[SpeechRecognitionHandler#unloadGrammar] No DSISpeechRec available!");
            return false;
        }
        dSISpeechRec.unloadGrammar(SpeechRecognitionHandlerUtils.convertInfo(nArray));
        return true;
    }

    public boolean startRecognition(int n, int n2) {
        int n3;
        this.lc.log(10000000, "[SpeechRecognitionHandler#startRecognition] startTone=%1, recogMode=%2!", (long)n, (long)n2);
        if (this.sdsAdapter.isSDSAborting() || !this.sdsAdapter.isSDSActive()) {
            this.lc.log(100000, "[SpeechRecognitionHandler#startRecognition] SDS aborting or inactive => NOP!");
            return false;
        }
        DSISpeechRec dSISpeechRec = this.getDSISR();
        if (dSISpeechRec == null) {
            this.lc.log(10000, "[SpeechRecognitionHandler#startRecognition] No DSISpeechRec available!");
            return false;
        }
        this.systemVBIHandler.initializeRecgonitionMode();
        this.switchLongRecognitionTimeoutMode(this.longRecognitionTimeoutModeExpected);
        int n4 = n3 = this.recognitionMode != 0 ? this.recognitionMode : n2;
        if (!firstRecogStarted) {
            firstRecogStarted = true;
            this.framework.getStartupMgr().logStartupEvent("[Startup SDS] Phase 7: First recognizer started.");
        }
        this.lc.log(10000000, "[SpeechRecognitionHandler#startRecognition] recMode=%1, starting recognition!", (long)n3);
        try {
            MethodCall methodCall = new MethodCall(dSISpeechRec, "startRecognition").arg(n).arg(1).arg(n3);
            methodCall.call();
        }
        catch (Exception exception) {
            MethodCall methodCall = new MethodCall(dSISpeechRec, "startRecognition").arg(n).arg(n3);
            methodCall.call(this.lc);
        }
        return true;
    }

    public boolean waitForResults() {
        this.lc.log(10000000, "[SpeechRecognitionHandler#waitForResults] called");
        DSISpeechRec dSISpeechRec = this.getDSISR();
        if (dSISpeechRec == null) {
            this.lc.log(10000, "[SpeechRecognitionHandler#waitForResults] No DSISpeechRec available!");
            return false;
        }
        this.lc.log(10000000, "[SpeechRecognitionHandler#waitForResults] Waiting for results!");
        dSISpeechRec.waitForResults();
        return true;
    }

    public boolean abortRecognition() {
        DSISpeechRec dSISpeechRec = this.getDSISR();
        if (dSISpeechRec == null) {
            this.lc.log(10000, "[SpeechRecognitionHandler#abortRecognition] No DSISpeechRec available!");
            return false;
        }
        this.lc.log(10000000, "[SpeechRecognitionHandler#abortRecognition] Aborting recognition!");
        dSISpeechRec.abort();
        return true;
    }

    public void shutdown() {
        this.lc.log(10000000, "[SpeechRecognitionHandler#shutdown] called");
        DSISpeechRec dSISpeechRec = this.getDSISR();
        if (dSISpeechRec == null) {
            this.lc.log(10000, "[SpeechRecognitionHandler#shutdown] No DSISpeechRec available!");
            return;
        }
        this.sdsAdapter.setSDSReady(false);
        dSISpeechRec.shutdown();
    }

    public void startDialog() {
        DSISpeechRec dSISpeechRec = this.getDSISR();
        if (dSISpeechRec == null) {
            this.lc.log(10000, "[SpeechRecognitionHandler#startDialog] No DSISpeechRec available!");
            return;
        }
        this.lc.log(10000000, "[SpeechRecognitionHandler#startDialog] Starting dialog!");
        dSISpeechRec.startDialogue();
    }

    public void stopDialog() {
        DSISpeechRec dSISpeechRec = this.getDSISR();
        if (dSISpeechRec == null) {
            this.lc.log(10000, "[SpeechRecognitionHandler#stopDialog] No DSISpeechRec available!");
            return;
        }
        this.lc.log(10000000, "[SpeechRecognitionHandler#stopDialog] Stopping dialog!");
        dSISpeechRec.stopDialogue();
    }

    public void triggerPosttraining(boolean bl, int n) {
        this.lc.log(10000000, "[SpeechRecognitionHandler#triggerPosttraining] %1 posttraining!", (Object)(bl ? "Starting" : "Stopping"));
        if (bl) {
            this.recUtils.startPostTraining(n);
        } else {
            this.recUtils.stopPostTraining();
        }
    }

    public void restoreFactorySettings() {
        this.lc.log(10000000, "[SpeechRecognitionHandler#restoreFactorySettings] called");
        DSISpeechRec dSISpeechRec = this.getDSISR();
        if (dSISpeechRec == null) {
            this.lc.log(10000, "[SpeechRecognitionHandler#restoreFactorySettings] No DSISpeechRec available!");
            return;
        }
        dSISpeechRec.requestRestoreFactorySettings();
    }

    public void reqGGAsNBest(int n) {
        this.lc.log(10000000, "[SpeechRecognitionHandler#reqGGAsNBest] graphemicGroupIndex=%1", (long)n);
        DSISpeechRec dSISpeechRec = this.getDSISR();
        if (dSISpeechRec == null) {
            this.lc.log(10000, "[SpeechRecognitionHandler#reqGGAsNBest] No DSISpeechRec available!");
            return;
        }
        dSISpeechRec.requestGraphemicGroupAsNBestList(n);
    }

    public boolean setLanguage(String string) {
        this.lc.log(10000000, "[SpeechRecognitionHandler#setLanguage] lang=%1", (Object)string);
        String string2 = this.languageManager.getCurrentLanguage("LANG_COMPONENT_TTS").getLanguageCode();
        SDSModelAccess.setSDSDisabledForLanguage(string, string2, this.languages);
        DSISpeechRec dSISpeechRec = this.getDSISR();
        if (dSISpeechRec == null) {
            this.lc.log(10000, "[SpeechRecognitionHandler#setLanguage] No DSISpeechRec available!");
            return false;
        }
        dSISpeechRec.setLanguage(string, 1);
        return true;
    }

    void updateAvailableLanguages(String[] stringArray) {
        this.lc.log(10000000, "[SpeechRecognitionHandler#updateAvailableLanguages] lang=%1", (Object)stringArray);
        this.languageManager.updateAvailableLanguages("LANG_COMPONENT_SDS", stringArray);
        this.languages = stringArray;
    }

    public void stop() {
        this.recUtils.stop();
    }

    public void unsetDSISR() {
        this.recUtils.unsetDSISR();
    }

    private DSISpeechRec getDSISR() {
        return this.recUtils.getDSISR();
    }

    public void setDSISR(DSISpeechRec dSISpeechRec) {
        this.recUtils.setDSISR(dSISpeechRec);
    }

    public boolean init() {
        DSISpeechRec dSISpeechRec = this.getDSISR();
        if (dSISpeechRec == null) {
            this.lc.log(10000, "[SpeechRecognitionHandler#init] No DSISpeechRec available!");
            return false;
        }
        this.lc.log(1000000, "[SpeechRecognitionHandler#init] Initializing DSISpeechRec!");
        dSISpeechRec.init();
        return true;
    }

    public void getVersion() {
        DSISpeechRec dSISpeechRec = this.getDSISR();
        if (dSISpeechRec == null) {
            this.lc.log(10000, "[SpeechRecognitionHandler#getVersion] No DSISpeechRec available!");
            return;
        }
        this.lc.log(1000000, "[SpeechRecognitionHandler#getVersion] Getting version!");
        dSISpeechRec.getVersion();
    }

    public void loadProfile(int n) {
        this.recUtils.loadProfile(n);
    }

    public void unloadProfile() {
        this.recUtils.unloadProfile();
    }

    public void deleteProfile(int n) {
        this.recUtils.deleteProfile(n);
    }

    public boolean requestVDECapabilities(String string) {
        this.lc.log(10000000, "SpeechRecognitionHandler#requestVDECapabilities: countryCode=%1", (Object)string);
        return this.recUtils.requestVDECapabilities(string);
    }

    public void setExpectedLongRecognitionTimeoutMode(boolean bl) {
        this.lc.log(10000000, "SpeechRecognitionHandler#setExpectedLongRecognitionTimeoutMode: Expected mode: %1", (Object)(bl ? "long" : "normal"));
        this.longRecognitionTimeoutModeExpected = bl;
    }

    public void switchLongRecognitionTimeoutMode(boolean bl) {
        if (this.longRecognitionTimeoutModeCurrentlySet == bl) {
            return;
        }
        DSISpeechRec dSISpeechRec = this.getDSISR();
        if (dSISpeechRec == null) {
            this.lc.log(10000, "SpeechRecognitionHandler#switchLongRecognitionTimeoutMode: No DSISpeechRec available!");
            return;
        }
        this.lc.log(10000000, "SpeechRecognitionHandler#switchLongRecognitionTimeoutMode: Switching long recognition timeout %1!", (Object)(bl ? "on" : "off"));
        this.longRecognitionTimeoutModeCurrentlySet = bl;
        dSISpeechRec.setRecognitionTimeout(bl ? 4 : 3);
    }

    public void prolongRecognitionTimeout() {
        if (!this.longRecognitionTimeoutModeCurrentlySet || !this.longRecognitionTimeoutModeExpected) {
            this.lc.log(10000000, "SpeechRecognitionHandler#prolongRecognitionTimeout: No long recognition timeout mode active or wanted => NOP!");
            return;
        }
        this.callProlongTimeout();
    }

    protected void callProlongTimeout() {
        int n = SDSModelAccess.getRecognizer();
        this.lc.log(10000000, "SpeechRecognitionHandler#callProlongTimeout: recognizerModelValue=%1", (long)n);
        if (n != 2) {
            this.lc.log(10000000, "SpeechRecognitionHandler#callProlongTimeout: Recognizer not active => NOP!");
            return;
        }
        DSISpeechRec dSISpeechRec = this.getDSISR();
        if (dSISpeechRec == null) {
            this.lc.log(10000, "SpeechRecognitionHandler#callProlongTimeout: No DSISpeechRec available!");
            return;
        }
        this.lc.log(10000000, "SpeechRecognitionHandler#callProlongTimeout: Prolonging recognition timeout!");
        dSISpeechRec.setRecognitionTimeout(5);
    }

    public void setMaxSlotNBestListSize(int n) {
        this.recUtils.setMaxSlotNBestListSize(n);
    }

    public void setMaxCommandNBestListSize(int n) {
        this.recUtils.setMaxCommandNBestListSize(n);
    }

    public void setSDSAdapter(SDSAdapter sDSAdapter) {
        this.sdsAdapter = sDSAdapter;
    }

    public void setSystemVBIHandler(ISystemVBIHandler iSystemVBIHandler) {
        this.systemVBIHandler = iSystemVBIHandler;
    }

    public void setRecognitionMode(int n) {
        this.recognitionMode = n;
    }

    public void requestSDSAvailability() {
        this.lc.log(10000000, "[SpeechRecognitionHandler#requestSDSAvailability] called");
        DSISpeechRec dSISpeechRec = this.getDSISR();
        if (dSISpeechRec == null) {
            this.lc.log(10000, "[SpeechRecognitionHandler#requestSDSAvailability] No DSISpeechRec available!");
        } else {
            dSISpeechRec.requestSDSAvailability();
        }
    }

    public void requestCheckDbPartition() {
        this.lc.log(10000000, "[SpeechRecognitionHandler#requestCheckDbPartition] called");
        DSISpeechRec dSISpeechRec = this.getDSISR();
        if (dSISpeechRec == null) {
            this.lc.log(10000, "[SpeechRecognitionHandler#requestCheckDbPartition] No DSISpeechRec available!");
            return;
        }
        dSISpeechRec.requestCheckDbPartition();
    }

    public void setDictionary(int n, String string, String string2, DictionaryEntry[] dictionaryEntryArray) {
        this.lc.log(10000000, "[SpeechRecognitionHandler#setDictionary] type=%3, language=%1, format=%2", (Object)string, (Object)string2, (long)n);
        DSISpeechRec dSISpeechRec = this.getDSISR();
        if (dSISpeechRec == null) {
            this.lc.log(10000, "[SpeechRecognitionHandler#setDictionary] No DSISpeechRec available!");
            return;
        }
        dSISpeechRec.setDictionary(n, string, string2, dictionaryEntryArray);
    }

    public void deleteLastTrufflesSearchText() {
        this.lc.log(10000000, "[SpeechRecognitionHandler#deleteLastTrufflesSearchText] called!");
        DSISpeechRec dSISpeechRec = this.getDSISR();
        if (dSISpeechRec == null) {
            this.lc.log(10000, "[SpeechRecognitionHandler#deleteLastTrufflesSearchText] No DSISpeechRec available!");
            return;
        }
        dSISpeechRec.deleteLastFlexVDEPart();
    }

    public void clearTrufflesSearchHistory() {
        this.lc.log(10000000, "[SpeechRecognitionHandler#clearTrufflesSearchHistory] called!");
        DSISpeechRec dSISpeechRec = this.getDSISR();
        if (dSISpeechRec == null) {
            this.lc.log(10000, "[SpeechRecognitionHandler#clearTrufflesSearchHistory] No DSISpeechRec available!");
            return;
        }
        dSISpeechRec.clearFlexVDEHistory();
    }
}

