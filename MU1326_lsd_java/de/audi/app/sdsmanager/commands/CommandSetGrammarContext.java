/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.commands;

import de.audi.app.sdsmanager.apps.SDSAdapter;
import de.audi.app.sdsmanager.commands.AbstractSpeechCommand;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.dsi.SpeechRecognitionHandler;
import de.audi.app.sdsmanager.grammar.IDynamicLists;
import de.audi.app.sdsmanager.grammar.ISDSGrammarState;
import de.audi.app.sdsmanager.grammar.ITTSASRAppContext;
import de.audi.app.sdsmanager.nbest.NBestStorageAccess;
import de.audi.atip.log.LogChannel;
import de.audi.atip.statemachine.sds.ITTSASRContext;
import de.esolutions.fw.util.commons.Buffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import org.dsi.ifc.speechrec.Grammar;
import org.dsi.ifc.speechrec.GrammarInfo;

public class CommandSetGrammarContext
extends AbstractSpeechCommand {
    private static final String LOGCLASS = "CommandSetGrammarContext";
    private final ITTSASRContext contextToLoad;
    private final ISDSGrammarState currentGrammarState;
    private final SpeechRecognitionHandler speechRecognitionHandler;
    private final IDynamicLists dynamicHMILists;
    private final NBestStorageAccess nbestStorage;
    private final SDSAdapter sdsAdapter;
    private final ISDSGrammarState grammarState;
    private volatile SortedSet grammarsToUnload;
    private volatile SortedSet grammarsToLoad;
    private final boolean reload;

    public CommandSetGrammarContext(LogChannel logChannel, String string, ITTSASRContext iTTSASRContext, ISDSGrammarState iSDSGrammarState, SpeechRecognitionHandler speechRecognitionHandler, IDynamicLists iDynamicLists, NBestStorageAccess nBestStorageAccess, SDSAdapter sDSAdapter, boolean bl) {
        super(logChannel, string);
        this.contextToLoad = iTTSASRContext;
        this.currentGrammarState = iSDSGrammarState;
        this.speechRecognitionHandler = speechRecognitionHandler;
        this.dynamicHMILists = iDynamicLists;
        this.nbestStorage = nBestStorageAccess;
        this.sdsAdapter = sDSAdapter;
        this.grammarState = iSDSGrammarState;
        this.reload = bl;
    }

    public void execute() {
        boolean bl = this.contextToLoad.isDynamicListUpdate();
        this.logger.log(1000000, "[%1#execute] isDynamic=%2, reload=%3", (Object)LOGCLASS, (Object)bl, (Object)this.reload);
        if (!this.sdsAdapter.isSDSAndTTSReady()) {
            this.logger.log(1000000, "[%1#execute] SDS or TTS not ready. Do NOT clear grammar state!", (Object)LOGCLASS);
            this.dynamicHMILists.resetLoadedSlotRuleIDs();
            this.processingFinished();
            return;
        }
        SortedSet sortedSet = this.contextToLoad.getRuleIds();
        SortedSet sortedSet2 = this.currentGrammarState.getCurrentlyLoadedGrammarRuleIDs();
        CommandSetGrammarContext.showIDSet(sortedSet2, "CURRENT", this.logger);
        CommandSetGrammarContext.showIDSet(sortedSet, "RULEIDS TO LOAD", this.logger);
        CommandSetGrammarContext.showIDSet(this.contextToLoad.getSlotIds(), "SLOTIDS TO LOAD", this.logger);
        if (bl) {
            this.grammarsToUnload = new TreeSet();
        } else if (this.reload) {
            this.grammarsToUnload = new TreeSet(sortedSet);
            this.grammarsToUnload.retainAll(sortedSet2);
        } else {
            this.grammarsToUnload = new TreeSet(sortedSet2);
            this.grammarsToUnload.removeAll(sortedSet);
            CommandSetGrammarContext.showIDSet(this.grammarsToUnload, "TO UNLOAD", this.logger);
        }
        this.grammarsToLoad = new TreeSet(sortedSet);
        if (!this.reload) {
            this.grammarsToLoad.removeAll(sortedSet2);
        } else {
            this.grammarsToLoad.retainAll(sortedSet2);
        }
        CommandSetGrammarContext.showIDSet(this.grammarsToLoad, "TO LOAD", this.logger);
        if (!this.grammarsToUnload.isEmpty()) {
            this.logger.log(1000000, "[%1#execute] Unload grammars", (Object)LOGCLASS);
            if (this.unloadGrammars()) {
                this.logger.log(1000000, "[%1#execute] Waiting for responseUnloadGrammar.", (Object)LOGCLASS);
                return;
            }
            this.logger.log(1000000, "[%1#execute] Unload failed. Abort.", (Object)LOGCLASS);
            this.processingFinished();
            return;
        }
        this.logger.log(1000000, "[%1#execute] No unload necessary", (Object)LOGCLASS);
        if (this.startLoadGrammar()) {
            this.logger.log(1000000, "[%1#execute] Waiting for responseLoadGrammar", (Object)LOGCLASS);
            return;
        }
        this.logger.log(1000000, "[%1#execute] No load necessary", (Object)LOGCLASS);
        this.processingFinished();
    }

    private boolean startLoadGrammar() {
        if (!this.contextToLoad.isDynamicListUpdate() && this.grammarsToLoad.isEmpty() && !this.isSlotContentNew()) {
            this.logger.log(1000000, "[%1#startLoadGrammar] No grammars to load.", (Object)LOGCLASS);
            return false;
        }
        List list = this.constructGrammars(this.grammarsToLoad);
        if (list.isEmpty()) {
            this.logger.log(1000000, "[%1#startLoadGrammar] DSI grammar list empty.", (Object)LOGCLASS);
            return false;
        }
        if (!this.loadGrammars(list)) {
            this.logger.log(1000000, "[%1#startLoadGrammar] FAILED", (Object)LOGCLASS);
            return false;
        }
        this.logger.log(1000000, "[%1#startLoadGrammar] SUCCESSFUL", (Object)LOGCLASS);
        return true;
    }

    private void processingFinished() {
        this.getCommandList().commandFinished();
    }

    private boolean unloadGrammars() {
        this.logger.log(1000000, "[%1#unloadGrammars]", (Object)LOGCLASS);
        int[] nArray = new int[this.grammarsToUnload.size()];
        int n = 0;
        Iterator iterator = this.grammarsToUnload.iterator();
        while (iterator.hasNext()) {
            nArray[n] = (Integer)iterator.next();
            ++n;
        }
        boolean bl = this.speechRecognitionHandler.unloadGrammar(nArray);
        this.logger.log(10000000, "[%1#unloadGrammars] '%2'", (Object)LOGCLASS, (Object)(bl ? "SUCCESSFUL" : "FAILED"));
        return bl;
    }

    private List constructGrammars(SortedSet sortedSet) {
        this.logger.log(1000000, "[%1#constructGrammars]", (Object)LOGCLASS);
        LinkedList linkedList = new LinkedList();
        SortedSet sortedSet2 = this.contextToLoad.getSlotIds();
        if (sortedSet2 != null) {
            this.logger.log(10000000, "[%1#constructGrammars] Process slotIDs.", (Object)LOGCLASS);
            linkedList.addAll(CommandSetGrammarContext.slotIDsToDSIGrammar(this.logger, this.dynamicHMILists, sortedSet2));
        }
        if (sortedSet != null) {
            this.logger.log(10000000, "[%1#constructGrammars] Process ruleIDs.", (Object)LOGCLASS);
            linkedList.addAll(CommandSetGrammarContext.ruleIDsToDSIGrammar(this.logger, this.nbestStorage, this.dynamicHMILists, sortedSet, true, this.contextToLoad));
        }
        return linkedList;
    }

    static List ruleIDsToDSIGrammar(LogChannel logChannel, NBestStorageAccess nBestStorageAccess, IDynamicLists iDynamicLists, SortedSet sortedSet, boolean bl, ITTSASRContext iTTSASRContext) {
        logChannel.log(1000000, "[%1#ruleIDsToDSIGrammar]", (Object)LOGCLASS);
        if (bl && (nBestStorageAccess == null || iTTSASRContext == null)) {
            throw new IllegalArgumentException("Data not set.");
        }
        ArrayList arrayList = new ArrayList(sortedSet.size());
        ITTSASRAppContext iTTSASRAppContext = iTTSASRContext instanceof ITTSASRAppContext ? (ITTSASRAppContext)iTTSASRContext : null;
        Iterator iterator = sortedSet.iterator();
        while (iterator.hasNext()) {
            int n = (Integer)iterator.next();
            int n2 = 4;
            int n3 = 0;
            String string = "";
            if (bl) {
                int n4 = iTTSASRContext.getRuleIDForNBest();
                List list = iTTSASRContext.getRuleIDsForSpelling();
                String string2 = string = iTTSASRAppContext != null ? iTTSASRAppContext.getSRGSString(n) : "";
                if (n4 == n) {
                    n3 = nBestStorageAccess.getLatestPicklistID();
                    logChannel.log(10000000, "[%1#ruleIDsToDSIGrammar] [%2] nBestListID='%3'", (Object)LOGCLASS, (long)n, (long)n3);
                } else if (list.contains(new Integer(n))) {
                    logChannel.log(10000000, "[%1#ruleIDsToDSIGrammar] [%2] Spelling rule.'", (Object)LOGCLASS, (long)n);
                    n2 = 5;
                } else if (!SDSUtils.isEmpty(string)) {
                    logChannel.log(10000000, "[%1#ruleIDsToDSIGrammar] [%2] SRGS rule.'", (Object)LOGCLASS, (long)n);
                    n2 = 1;
                }
            }
            arrayList.add(new Grammar(n2, 0, true, new String[0], new long[0], 0, n, string, 0, n3));
        }
        return arrayList;
    }

    static List slotIDsToDSIGrammar(LogChannel logChannel, IDynamicLists iDynamicLists, SortedSet sortedSet) {
        logChannel.log(10000000, "[%1#slotIDsToDSIGrammar]", (Object)LOGCLASS);
        ArrayList arrayList = new ArrayList(sortedSet.size());
        Iterator iterator = sortedSet.iterator();
        while (iterator.hasNext()) {
            int n = (Integer)iterator.next();
            String string = "SlotGrammar_" + n;
            if (!iDynamicLists.isSlotContentNew(n)) {
                logChannel.log(10000000, "[%1#slotIDsToDSIGrammar] [%2] not updated.", (Object)LOGCLASS, (long)n);
                continue;
            }
            String[] stringArray = iDynamicLists.getDynListStrings(n);
            long[] lArray = iDynamicLists.getDynListIDs(n);
            logChannel.log(10000000, "[%1#slotIDsToDSIGrammar] [%2] strData='%3', idData=%4", (Object)LOGCLASS, (Object)new Integer(n), (Object)stringArray, (Object)lArray);
            if (stringArray != null) {
                int n2 = 8;
                if (lArray == null || lArray.length == 0) {
                    logChannel.log(10000000, "[%1#slotIDsToDSIGrammar] [%2] new HMI filled grammar - only strings", (Object)LOGCLASS, (long)n);
                    n2 = 2;
                    lArray = new long[]{};
                } else {
                    logChannel.log(10000000, "[%1#slotIDsToDSIGrammar] [%2] new HMI filled grammar - strings + IDs", (Object)LOGCLASS, (long)n);
                }
                arrayList.add(new Grammar(n2, 0, false, stringArray, lArray, -1, n, string, 0, 0));
                iDynamicLists.setSlotContentStatus(n, (byte)1);
                continue;
            }
            logChannel.log(100000, "[%1#slotIDsToDSIGrammar] [%2] ID data not found.", (Object)LOGCLASS, (long)n);
        }
        return arrayList;
    }

    private boolean loadGrammars(List list) {
        this.logger.log(1000000, "[%1#loadGrammars]", (Object)LOGCLASS);
        boolean bl = this.speechRecognitionHandler.loadGrammar((Grammar[])list.toArray(new Grammar[list.size()]));
        this.logger.log(1000000, "[%2#loadGrammars] '%1'", (Object)(bl ? "SUCCESSFUL" : "FAILED"), (Object)LOGCLASS);
        this.dynamicHMILists.markAllSlotsAsLoaded(bl);
        return bl;
    }

    static void showIDSet(SortedSet sortedSet, String string, LogChannel logChannel) {
        if (sortedSet == null) {
            logChannel.log(10000000, "[%1#showIDSet] [%2] No IDs available!", (Object)LOGCLASS, (Object)string);
            return;
        }
        if (sortedSet.isEmpty()) {
            logChannel.log(10000000, "[%1#showIDSet] [%2] Empty", (Object)LOGCLASS, (Object)string);
            return;
        }
        if (logChannel.isDebug()) {
            Iterator iterator = sortedSet.iterator();
            Buffer buffer = new Buffer();
            while (iterator.hasNext()) {
                buffer.append(iterator.next());
                if (!iterator.hasNext()) continue;
                buffer.append(", ");
            }
            logChannel.log(10000000, "[%1#showIDSet] [%2] %3", (Object)LOGCLASS, (Object)string, (Object)buffer);
        }
    }

    public void responseUnloadGrammar(int n, GrammarInfo[] grammarInfoArray) {
        this.logger.log(10000000, "[%1#responseUnloadGrammar] replyCode=%3, info=%2", (Object)LOGCLASS, (Object)SDSUtils.toString((Object[])grammarInfoArray, false), (long)n);
        if (SDSUtils.checkReplyCodeForError(n, this.logger)) {
            this.logger.log(100000, "[%1#responseUnloadGrammar] Error from DSI, sending ERROR!", (Object)LOGCLASS);
            this.sdsAdapter.sendSpeechSMEvent(3001, false, false);
            this.processingFinished();
            return;
        }
        this.logger.log(1000000, "[%1#responseUnloadGrammar] Change grammar state.", (Object)LOGCLASS);
        TreeSet treeSet = new TreeSet(this.currentGrammarState.getCurrentlyLoadedGrammarRuleIDs());
        treeSet.removeAll(this.grammarsToUnload);
        this.currentGrammarState.setCurrentlyLoadedGrammarRuleIDs(treeSet);
        if (this.startLoadGrammar()) {
            this.logger.log(1000000, "[%1#responseUnloadGrammar] Waiting for responseLoadGrammar", (Object)LOGCLASS);
            return;
        }
        this.processingFinished();
    }

    public void responseLoadGrammar(int n, GrammarInfo[] grammarInfoArray) {
        if (this.logger.isDebug()) {
            this.logger.log(1000000, "[%1#responseLoadGrammar] replyCode='%3', info='%2'", (Object)LOGCLASS, (Object)SDSUtils.toString((Object[])grammarInfoArray, false), (long)n);
        }
        if (SDSUtils.checkReplyCodeForError(n, this.logger)) {
            this.logger.log(100000, "[%1#responseLoadGrammar] Error from DSI, sending SDS_ERROR!", (Object)LOGCLASS);
            this.grammarState.setCurrentlyLoadedGrammarRuleIDs(new TreeSet());
            this.sdsAdapter.sendSpeechSMEvent(3001, false, false);
            this.processingFinished();
            return;
        }
        this.logger.log(1000000, "[%1#responseLoadGrammar] Change grammar state.", (Object)LOGCLASS);
        TreeSet treeSet = new TreeSet(this.currentGrammarState.getCurrentlyLoadedGrammarRuleIDs());
        treeSet.addAll(this.grammarsToLoad);
        this.currentGrammarState.setCurrentlyLoadedGrammarRuleIDs(treeSet);
        this.processingFinished();
    }

    private boolean isSlotContentNew() {
        int n = this.contextToLoad.getSlotIds().size();
        Object[] objectArray = this.contextToLoad.getSlotIds().toArray();
        for (int i2 = 0; i2 < n; ++i2) {
            int n2 = (Integer)objectArray[i2];
            if (!this.dynamicHMILists.isSlotContentNew(n2)) continue;
            this.logger.log(1000000, "[%1#isSlotContentNew] New dynamic HMI slot content available.", (Object)LOGCLASS);
            return true;
        }
        this.logger.log(1000000, "[%1#isSlotContentNew] No new dynamic HMI slot content available.", (Object)LOGCLASS);
        return false;
    }

    public String toString() {
        return "CommandSetGrammarContext@" + this.hashCode();
    }
}

