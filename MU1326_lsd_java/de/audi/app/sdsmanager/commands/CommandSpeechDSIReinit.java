/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.commands;

import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.apps.SDSAdapter;
import de.audi.app.sdsmanager.apps.SDSTimeoutHandler;
import de.audi.app.sdsmanager.apps.navi.NaviSDSHandler;
import de.audi.app.sdsmanager.commands.AbstractSpeechCommand;
import de.audi.app.sdsmanager.commands.CommandSetGrammarContext;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.dsi.SpeechRecognitionHandler;
import de.audi.app.sdsmanager.grammar.IDynamicLists;
import de.audi.app.sdsmanager.grammar.ISDSGrammarState;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import java.util.ArrayList;
import java.util.SortedSet;
import java.util.TreeSet;
import org.dsi.ifc.speechrec.Grammar;
import org.dsi.ifc.speechrec.GrammarInfo;

public class CommandSpeechDSIReinit
extends AbstractSpeechCommand {
    private static final String LOGCLASS = "CommandSpeechDSIReinit";
    private static final int COMMAND_TIMEOUT_SPEECH_DSI_REINIT = -1;
    private final SpeechRecognitionHandler srHandler;
    private final IFrameworkAccess framework;
    private final SDSAdapter sdsAdapter;
    private final SDSTimeoutHandler timeoutHandler;
    private final IDynamicLists dynamicHMILists;
    private final ISDSGrammarState grammarState;
    private final NaviSDSHandler naviHandler;

    public CommandSpeechDSIReinit(LogChannel logChannel, SpeechRecognitionHandler speechRecognitionHandler, IFrameworkAccess iFrameworkAccess, SDSAdapter sDSAdapter, NaviSDSHandler naviSDSHandler, SDSTimeoutHandler sDSTimeoutHandler, IDynamicLists iDynamicLists, ISDSGrammarState iSDSGrammarState) {
        super(logChannel, "REINIT_SPEECH_DSI");
        this.srHandler = speechRecognitionHandler;
        this.framework = iFrameworkAccess;
        this.sdsAdapter = sDSAdapter;
        this.naviHandler = naviSDSHandler;
        this.timeoutHandler = sDSTimeoutHandler;
        this.dynamicHMILists = iDynamicLists;
        this.grammarState = iSDSGrammarState;
    }

    private void processingFinished() {
        this.logger.log(1000000, "[%1#processingFinished]", (Object)LOGCLASS);
        this.commandList.commandFinished();
    }

    public void execute() {
        this.logger.log(1000000, "[%1#execute]", (Object)LOGCLASS);
        this.timeoutHandler.startInitTimer();
        this.sdsAdapter.setSDSReady(false);
        this.sdsAdapter.setInitializationStep((byte)0);
        if (!this.srHandler.init()) {
            this.logger.log(10000, "[%1#execute] Initialization failed.", (Object)LOGCLASS);
            this.processingFinished();
            return;
        }
        this.logger.log(1000000, "[%1#execute] Wait for responseInit.", (Object)LOGCLASS);
    }

    public void responseInit(int n) {
        this.logger.log(1000000, "[%1#responseInit] '%2'", (Object)LOGCLASS, (long)n);
        this.sdsAdapter.setInitializationStep((byte)1);
        String string = this.framework.getLanguageMgr().getCurrentLanguage("LANG_COMPONENT_SDS").getLanguageCode();
        this.logger.log(1000000, "[%1#responseInit] language locale='%2'", (Object)LOGCLASS, (Object)string);
        if (!this.srHandler.setLanguage(string)) {
            this.sdsAdapter.updateSDSState((byte)2);
            this.processingFinished();
            return;
        }
        this.logger.log(1000000, "[%1#responseInit] Wait for responseSetLanguage", (Object)LOGCLASS);
    }

    public void responseSetLanguage(int n) {
        this.logger.log(1000000, "[%1#responseSetLanguage] replyCode=%2, requesting DSISpeechRec version!", (Object)LOGCLASS, (long)n);
        this.sdsAdapter.setInitializationStep((byte)2);
        this.timeoutHandler.cancelInitTimer();
        this.srHandler.getVersion();
        boolean bl = SDSModelAccess.isSDSDisabledForLanguage();
        this.logger.log(1000000, "[%1#responseSetLanguage] sdsDisabledForLanguage=%2!", (Object)LOGCLASS, (Object)bl);
        if (SDSUtils.checkReplyCodeForError(n, this.logger) || bl) {
            this.logger.log(100000, "[%1#responseSetLanguage] FAILED or language disabled!", (Object)LOGCLASS);
            this.sdsAdapter.updateSDSState((byte)2);
            this.framework.getLanguageMgr().responseSetLanguage("LANG_COMPONENT_SDS", false);
            this.processingFinished();
            return;
        }
        this.framework.getLanguageMgr().responseSetLanguage("LANG_COMPONENT_SDS", true);
        this.sdsAdapter.setInitializationStep((byte)7);
        this.naviHandler.setSpeechDSIStatus(true);
        this.logger.log(1000000, "[%1#responseSetLanguage] Wait for responseSetMaxSlotNBestListSize", (Object)LOGCLASS);
        this.srHandler.setMaxSlotNBestListSize(20);
    }

    public void responseSetMaxSlotNBestListSize(int n) {
        this.logger.log(1000000, "[%1#responseSetMaxSlotNBestListSize] replyCode=%2, wait for responseSetMaxCommandNBestListSize", (Object)LOGCLASS, (long)n);
        this.sdsAdapter.setInitializationStep((byte)3);
        this.srHandler.setMaxCommandNBestListSize(2);
    }

    public void responseSetMaxCommandNBestListSize(int n) {
        this.logger.log(1000000, "[%1#responseSetMaxCommandNBestListSize] replyCode=%2, reload all current grammars", (Object)LOGCLASS, (long)n);
        this.sdsAdapter.setInitializationStep((byte)4);
        SortedSet sortedSet = this.dynamicHMILists.resetLoadedSlotRuleIDs();
        SortedSet sortedSet2 = this.grammarState.getCurrentlyLoadedGrammarRuleIDs();
        CommandSetGrammarContext.showIDSet(sortedSet2, "RULEIDS", this.logger);
        CommandSetGrammarContext.showIDSet(sortedSet, "SLOTIDS", this.logger);
        ArrayList arrayList = new ArrayList(sortedSet2.size() + sortedSet.size());
        arrayList.addAll(CommandSetGrammarContext.slotIDsToDSIGrammar(this.logger, this.dynamicHMILists, sortedSet));
        arrayList.addAll(CommandSetGrammarContext.ruleIDsToDSIGrammar(this.logger, null, this.dynamicHMILists, sortedSet2, false, null));
        if (arrayList.isEmpty()) {
            this.logger.log(1000000, "[%1#responseSetMaxCommandNBestListSize] Empty DSI grammar list.", (Object)LOGCLASS);
            this.sdsAdapter.setInitializationStep((byte)9);
            this.sdsAdapter.setSDSReady(true);
            this.processingFinished();
            return;
        }
        boolean bl = this.srHandler.loadGrammar((Grammar[])arrayList.toArray(new Grammar[arrayList.size()]));
        if (!bl) {
            this.logger.log(100000, "[%1#responseSetMaxCommandNBestListSize] loadGrammar failed. Clear grammar state.", (Object)LOGCLASS);
            this.grammarState.setCurrentlyLoadedGrammarRuleIDs(new TreeSet());
            this.sdsAdapter.setSDSReady(true);
            this.sdsAdapter.setInitializationStep((byte)9);
            this.processingFinished();
            return;
        }
        this.sdsAdapter.setInitializationStep((byte)8);
        this.dynamicHMILists.markAllSlotsAsLoaded(bl);
        this.logger.log(1000000, "[%1#responseSetMaxCommandNBestListSize] Wait for responseLoadGrammar", (Object)LOGCLASS);
    }

    public void responseLoadGrammar(int n, GrammarInfo[] grammarInfoArray) {
        if (this.logger.isDebug()) {
            this.logger.log(1000000, "[%1#responseLoadGrammar] replyCode=%3, info='%2'", (Object)LOGCLASS, (Object)SDSUtils.toString((Object[])grammarInfoArray, false), (long)n);
        }
        if (SDSUtils.checkReplyCodeForError(n, this.logger)) {
            this.logger.log(100000, "[%1#responseLoadGrammar] Load grammar failed. Clear grammar state.", (Object)LOGCLASS);
            this.grammarState.setCurrentlyLoadedGrammarRuleIDs(new TreeSet());
        }
        this.sdsAdapter.setSDSReady(true);
        this.sdsAdapter.setInitializationStep((byte)9);
        this.processingFinished();
    }

    public long getTimeout() {
        return -1L;
    }

    public String toString() {
        return LOGCLASS + this.hashCode();
    }
}

