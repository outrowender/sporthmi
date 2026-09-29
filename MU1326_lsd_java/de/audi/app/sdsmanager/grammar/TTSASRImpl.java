/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.grammar;

import de.audi.app.sdsmanager.AppSDSManager;
import de.audi.app.sdsmanager.SDSManagerBaseActivator;
import de.audi.app.sdsmanager.apps.SDSAdapter;
import de.audi.app.sdsmanager.commands.CommandSetGrammarContext;
import de.audi.app.sdsmanager.common.Logger;
import de.audi.app.sdsmanager.dsi.SpeechRecognitionHandler;
import de.audi.app.sdsmanager.dsi.SpeechTTSHandler;
import de.audi.app.sdsmanager.grammar.IDynamicLists;
import de.audi.app.sdsmanager.grammar.ISDSGrammarState;
import de.audi.app.sdsmanager.grammar.ITTSASR;
import de.audi.app.sdsmanager.grammar.ITTSASRAppContext;
import de.audi.app.sdsmanager.grammar.TTSASRContextImpl;
import de.audi.app.sdsmanager.nbest.NBestStorageAccess;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.log.LogChannel;
import de.audi.atip.statemachine.sds.ITTSASRContext;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.CommandListManager;
import de.esolutions.fw.util.commons.Buffer;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;
import java.util.SortedSet;

public class TTSASRImpl
implements ITTSASR {
    private static final boolean DEBUG;
    private static final String LOGCLASS;
    private ArrayList prompts = new ArrayList();
    private SpeechRecognitionHandler srHandler;
    private SpeechTTSHandler ttsHandler;
    private IDynamicLists dynamicLists;
    private final LogChannel lcASR = Logger.getGrammarLog();
    private final LogChannel lcTTS = Logger.getDSITTSLog();
    private final NBestStorageAccess nbestStorage;
    private final ISDSGrammarState grammarState;
    private final SDSAdapter sdsAdapter;
    private final AppSDSManager sdsManager;
    private CommandListManager cmdListManager;
    private final HMIService hmi;

    public TTSASRImpl(SpeechRecognitionHandler speechRecognitionHandler, SpeechTTSHandler speechTTSHandler, IDynamicLists iDynamicLists, NBestStorageAccess nBestStorageAccess, ISDSGrammarState iSDSGrammarState, SDSAdapter sDSAdapter, AppSDSManager appSDSManager, HMIService hMIService) {
        this.srHandler = speechRecognitionHandler;
        this.ttsHandler = speechTTSHandler;
        this.dynamicLists = iDynamicLists;
        this.nbestStorage = nBestStorageAccess;
        this.sdsAdapter = sDSAdapter;
        this.grammarState = iSDSGrammarState;
        this.sdsManager = appSDSManager;
        this.hmi = hMIService;
        this.lcASR.log(-2137614336, "[%1#<init>] initialized", (Object)"TTSASRImpl");
    }

    @Override
    public void addToPrompt(String string) {
        this.lcTTS.log(-2137614336, "[%1#addToPrompt] '%2'", (Object)"TTSASRImpl", (Object)string);
        this.prompts.add(string);
    }

    @Override
    public void startPrompt() {
        this.lcTTS.log(-2137614336, "[%1#startPrompt]", (Object)"TTSASRImpl");
        this.prompts.clear();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void stopPrompt() {
        this.lcTTS.log(-2137614336, "[%1#stopPrompt]", (Object)"TTSASRImpl");
        String string = this.getRandomPrompt().trim();
        if ("".equals(string)) {
            this.lcTTS.log(-2137614336, "[%1#stopPrompt] Prompt is empty!", (Object)"TTSASRImpl");
            this.sdsAdapter.sendSpeechSMEvent(2000, false, false);
            return;
        }
        Object object = this.sdsAdapter.pttRunningMutex;
        synchronized (object) {
            if (this.sdsAdapter.isPttRunning()) {
                this.lcTTS.log(-2137614336, "[%1#stopPrompt] PTT running, not playing text!", (Object)"TTSASRImpl");
                this.sdsAdapter.sendSpeechSMEvent(2000, false, false);
                return;
            }
            this.ttsHandler.playText(string);
        }
    }

    private String getRandomPrompt() {
        if (!this.prompts.isEmpty()) {
            return (String)this.prompts.get(new Random().nextInt(this.prompts.size()));
        }
        this.lcTTS.log(-1601830656, "[%1#getRandomPrompt] No Prompts to choose from", (Object)"TTSASRImpl");
        return "";
    }

    private String getAllPrompts() {
        Buffer buffer = new Buffer();
        ListIterator listIterator = this.prompts.listIterator();
        while (listIterator.hasNext()) {
            buffer.append(listIterator.next());
            buffer.append(" ");
        }
        return buffer.toString();
    }

    @Override
    public ITTSASRContext createGrammarContext() {
        return new TTSASRContextImpl(this.dynamicLists);
    }

    @Override
    public ITTSASRAppContext createAppGrammarContext() {
        return (ITTSASRAppContext)this.createGrammarContext();
    }

    @Override
    public SortedSet getLoadedGrammarIDs() {
        return this.grammarState.getCurrentlyLoadedGrammarRuleIDs();
    }

    @Override
    public void setGrammarContext(ITTSASRContext iTTSASRContext) {
        this.lcASR.log(-2137614336, "[%1#setGrammarContext] pContext=%2", (Object)"TTSASRImpl", (Object)iTTSASRContext);
        this.handleGrammarContext(iTTSASRContext, "LOAD_UNLOAD_GRAMMAR", false);
    }

    @Override
    public void setSlotGrammarContext(ITTSASRContext iTTSASRContext) {
        this.lcASR.log(-2137614336, "[%1#setSlotGrammarContext] pContext=%2", (Object)"TTSASRImpl", (Object)iTTSASRContext);
        this.handleGrammarContext(iTTSASRContext, "SET_SLOT_GRAMMAR", false);
    }

    @Override
    public void reloadGrammarContext(ITTSASRContext iTTSASRContext) {
        this.lcASR.log(-2137614336, "[%1#reloadGrammarContext] pContext=%2", (Object)"TTSASRImpl", (Object)iTTSASRContext);
        this.handleGrammarContext(iTTSASRContext, "RELOAD_GRAMMAR", true);
    }

    private void handleGrammarContext(ITTSASRContext iTTSASRContext, String string, boolean bl) {
        this.lcASR.log(-2137614336, "[%1#handleGrammarContext] name=%2, reload=%3", (Object)"TTSASRImpl", (Object)string, (Object)bl);
        CommandList commandList = new CommandList(this.cmdListManager);
        commandList.add(new CommandSetGrammarContext(this.lcASR, string, iTTSASRContext, this.grammarState, this.srHandler, this.dynamicLists, this.nbestStorage, this.sdsAdapter, bl));
        commandList.execute(string);
    }

    @Override
    public void sdsPopupRemoved() {
        this.lcASR.log(-2137614336, "[%1#sdsPopupRemoved] called, resetting dialog flags!", (Object)"TTSASRImpl");
        this.sdsManager.setSDSSpeechPopupActive(false);
        this.sdsManager.resetDialogFlags();
    }

    @Override
    public void setCommandListManager(CommandListManager commandListManager) {
        this.cmdListManager = commandListManager;
    }

    @Override
    public void initializeStateMachine() {
        int n = SDSManagerBaseActivator.getMapping().getEventID(0);
        this.lcASR.log(-2137614336, "%1#initializeStateMachine: called, firing event %2!", (Object)"TTSASRImpl", (long)n);
        this.hmi.fireSMEvent(6, n);
    }
}

