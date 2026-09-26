/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.commands;

import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.apps.SDSAdapter;
import de.audi.app.sdsmanager.commands.AbstractSpeechCommand;
import de.audi.app.sdsmanager.commands.CommandSetGrammarContext;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.dsi.SpeechRecognitionHandler;
import de.audi.app.sdsmanager.grammar.IDynamicLists;
import de.audi.app.sdsmanager.grammar.ISDSGrammarState;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.interapp.NaviService;
import de.audi.atip.log.LogChannel;
import java.util.ArrayList;
import java.util.SortedSet;
import java.util.TreeSet;
import org.dsi.ifc.speechrec.Grammar;
import org.dsi.ifc.speechrec.GrammarInfo;

public class CommandChangeLanguage
extends AbstractSpeechCommand {
    private static final String LOGCLASS;
    private final String languageCode;
    private final SpeechRecognitionHandler srHandler;
    private final SDSAdapter sdsAdapter;
    private final IFrameworkAccess framework;
    private final IDynamicLists dynamicHMIList;
    private final ISDSGrammarState grammarState;
    private final NaviService naviService;
    private boolean vdeCapabilitiesRequested = false;

    public CommandChangeLanguage(LogChannel logChannel, String string, SpeechRecognitionHandler speechRecognitionHandler, SDSAdapter sDSAdapter, IFrameworkAccess iFrameworkAccess, IDynamicLists iDynamicLists, ISDSGrammarState iSDSGrammarState, NaviService naviService) {
        super(logChannel, "CHANGE_LANGUAGE");
        this.languageCode = string;
        this.srHandler = speechRecognitionHandler;
        this.sdsAdapter = sDSAdapter;
        this.framework = iFrameworkAccess;
        this.dynamicHMIList = iDynamicLists;
        this.grammarState = iSDSGrammarState;
        this.naviService = naviService;
    }

    private void processingFinished() {
        this.logger.log(1078071040, "%1#processingFinished", (Object)"CommandChangeLanguage");
        this.getCommandList().commandFinished();
    }

    @Override
    public void execute() {
        this.logger.log(1078071040, "%1#execute: languageCode='%2'", (Object)"CommandChangeLanguage", (Object)this.languageCode);
        this.sdsAdapter.setSDSReady(false);
        this.sdsAdapter.updateSDSState(SDSUtils.isEmpty(this.languageCode) ? (byte)2 : 4);
        if (!this.srHandler.setLanguage(this.languageCode)) {
            this.logger.log(-1601830656, "%1#execute: Language change failed.", (Object)"CommandChangeLanguage");
            this.processingFinished();
            return;
        }
        this.logger.log(1078071040, "%1#execute: Wait for responseSetLanguage", (Object)"CommandChangeLanguage");
    }

    @Override
    public void responseSetLanguage(int n) {
        this.logger.log(1078071040, "%1#responseSetLanguage: replyCode=%2", (Object)"CommandChangeLanguage", (long)n);
        boolean bl = SDSModelAccess.isSDSDisabledForLanguage();
        this.logger.log(1078071040, "%1#responseSetLanguage: sdsDisabledForLanguage=%2!", (Object)"CommandChangeLanguage", (Object)bl);
        if (SDSUtils.checkReplyCodeForError(n, this.logger) || bl) {
            this.logger.log(-1601830656, "%1#responseSetLanguage: FAILED or language disabled, do NOT clear grammar state!", (Object)"CommandChangeLanguage");
            this.framework.getLanguageMgr().responseSetLanguage("LANG_COMPONENT_SDS", false);
            this.processingFinished();
            return;
        }
        this.framework.getLanguageMgr().responseSetLanguage("LANG_COMPONENT_SDS", true);
        this.logger.log(1078071040, "[%1#responseSetLanguage] Reload all current grammars.", (Object)"CommandChangeLanguage");
        SortedSet sortedSet = this.dynamicHMIList.resetLoadedSlotRuleIDs();
        SortedSet sortedSet2 = this.grammarState.getCurrentlyLoadedGrammarRuleIDs();
        CommandSetGrammarContext.showIDSet(sortedSet2, "RULEIDS", this.logger);
        CommandSetGrammarContext.showIDSet(sortedSet, "SLOTIDS", this.logger);
        ArrayList arrayList = new ArrayList(sortedSet2.size() + sortedSet.size());
        arrayList.addAll(CommandSetGrammarContext.slotIDsToDSIGrammar(this.logger, this.dynamicHMIList, sortedSet));
        arrayList.addAll(CommandSetGrammarContext.ruleIDsToDSIGrammar(this.logger, null, this.dynamicHMIList, sortedSet2, false, null));
        if (arrayList.isEmpty()) {
            this.logger.log(1078071040, "[%1#responseSetLanguage] Empty DSI grammar list.", (Object)"CommandChangeLanguage");
            this.requestVDECapabilities();
            return;
        }
        boolean bl2 = this.srHandler.loadGrammar((Grammar[])arrayList.toArray(new Grammar[arrayList.size()]));
        if (!bl2) {
            this.logger.log(-1601830656, "%1#responseSetLanguage: loadGrammar failed. Clear grammar state.", (Object)"CommandChangeLanguage");
            this.grammarState.setCurrentlyLoadedGrammarRuleIDs(new TreeSet());
            this.requestVDECapabilities();
            return;
        }
        this.dynamicHMIList.markAllSlotsAsLoaded(bl2);
        this.logger.log(1078071040, "%1#responseSetLanguage Wait for responseLoadGrammar", (Object)"CommandChangeLanguage");
    }

    @Override
    public void responseLoadGrammar(int n, GrammarInfo[] grammarInfoArray) {
        this.logger.log(1078071040, "%1#responseLoadGrammar: replyCode=%3, info='%2'", (Object)"CommandChangeLanguage", (Object)SDSUtils.toString((Object[])grammarInfoArray, false), (long)n);
        if (SDSUtils.checkReplyCodeForError(n, this.logger)) {
            this.logger.log(-1601830656, "%1#responseLoadGrammar: Loading grammars failed, clearing grammar state!", (Object)"CommandChangeLanguage");
            this.grammarState.setCurrentlyLoadedGrammarRuleIDs(new TreeSet());
        }
        this.requestVDECapabilities();
    }

    private void requestVDECapabilities() {
        this.logger.log(-2137614336, "%1#requestVDECapabilities: called", (Object)"CommandChangeLanguage");
        this.vdeCapabilitiesRequested = true;
        if (this.naviService == null) {
            this.logger.log(-1601830656, "%1#requestVDECapabilities: naviService not available!", (Object)"CommandChangeLanguage");
            this.responseRequestVDECapabilities(0);
            return;
        }
        String string = this.naviService.getCurrentCountryCode();
        this.logger.log(-1601830656, "%1#requestVDECapabilities: Requesting VDE capabilities for countryCode %2!", (Object)"CommandChangeLanguage", (Object)string);
        this.srHandler.requestVDECapabilities(string);
    }

    public void responseRequestVDECapabilities(int n) {
        if (!this.vdeCapabilitiesRequested) {
            this.logger.log(-2137614336, "%1#responseRequestVDECapabilities: has not been called by this command", (Object)"CommandChangeLanguage", (long)n);
            return;
        }
        this.logger.log(-2137614336, "%1#responseRequestVDECapabilities: result=%2", (Object)"CommandChangeLanguage", (long)n);
        if (n == 0) {
            this.sdsAdapter.setSDSReady(true);
            this.sdsAdapter.setInitializationStep((byte)9);
        }
        this.processingFinished();
    }
}

