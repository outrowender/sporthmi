/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.grammar;

import de.audi.app.sdsmanager.common.Logger;
import de.audi.app.sdsmanager.grammar.IDynamicLists;
import de.audi.app.sdsmanager.grammar.ITTSASRAppContext;
import de.audi.app.sdsmanager.grammar.SpeechTreeSet;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;

class TTSASRContextImpl
implements ITTSASRAppContext {
    private static final String LOGCLASS;
    private final LogChannel lc = Logger.getGrammarAddingLog();
    private final SpeechTreeSet newRuleIDSet = new SpeechTreeSet();
    private final SpeechTreeSet newSlotIDSet = new SpeechTreeSet();
    private final HashMap newSRGSStrings = new HashMap();
    private final IDynamicLists dynamicLists;
    private int ruleIDForNBest = -1;
    private final List ruleIDsForSpelling = new ArrayList(1);
    private volatile boolean dynamicListUpdate = false;

    TTSASRContextImpl(IDynamicLists iDynamicLists) {
        this.dynamicLists = iDynamicLists;
    }

    @Override
    public boolean isDynamicListUpdate() {
        return this.dynamicListUpdate;
    }

    private void setRuleIDs(int n, int n2) {
        switch (n2) {
            case 6: {
                this.lc.log(-2137614336, "[%1#setRuleIDs] Setting ruleIDForNBest to %2!", (Object)"TTSASRContextImpl", (long)n);
                this.ruleIDForNBest = n;
                break;
            }
            case 5: {
                this.lc.log(-2137614336, "[%1#setRuleIDs] Adding ruleID %2 to ruleIDsForSpelling!", (Object)"TTSASRContextImpl", (long)n);
                this.ruleIDsForSpelling.add(new Integer(n));
                break;
            }
        }
    }

    @Override
    public void addToGrammar(int n, String string) {
        this.lc.log(-2137614336, "[%1#addToGrammar] ruleID=%3, grammarText=%2", (Object)"TTSASRContextImpl", (Object)string, (long)n);
        if (n < 0) {
            this.lc.log(-1601830656, "[%1#addToGrammar] Unhandled ruleID %2!", (Object)"TTSASRContextImpl", (long)n);
            return;
        }
        Integer n2 = new Integer(n);
        this.newRuleIDSet.add(n2);
        this.newSRGSStrings.put(n2, string);
    }

    @Override
    public void addToGrammar(int n, int n2) {
        this.lc.log(-2137614336, "[%1#addToGrammar] ruleID=%2, grammarType=%3", (Object)"TTSASRContextImpl", (long)n, (long)n2);
        if (n < 0) {
            this.lc.log(-1601830656, "[%1#addToGrammar] Unhandled ruleID %2!", (Object)"TTSASRContextImpl", (long)n);
            return;
        }
        this.newRuleIDSet.add(new Integer(n));
        this.setRuleIDs(n, n2);
    }

    private static boolean isDynamicListUpdate(int n) {
        return n == -1000 || n == -1001 || n == -1002;
    }

    private static void logAddToGrammar(int n, int[] nArray, int n2, LogChannel logChannel) {
        if (logChannel.isDebug()) {
            Buffer buffer = new Buffer();
            buffer.append("ruleID=").append(n).append(", slotIDs=[");
            if (nArray != null) {
                for (int i2 = 0; i2 < nArray.length; ++i2) {
                    buffer.append(nArray[i2]).append(",");
                }
            }
            buffer.append("], gramType=").append(n2);
            logChannel.log(-2137614336, "[%1#addToGrammar] %2", (Object)"TTSASRContextImpl", (Object)buffer);
        }
    }

    @Override
    public void addToGrammar(int n, int[] nArray, int n2) {
        TTSASRContextImpl.logAddToGrammar(n, nArray, n2, this.lc);
        if (n < 0 && !TTSASRContextImpl.isDynamicListUpdate(n)) {
            this.lc.log(-1601830656, "[%1#addToGrammar] Unhandled ruleID %2!", (Object)"TTSASRContextImpl", (long)n);
            return;
        }
        if (nArray == null) {
            this.lc.log(-1601830656, "[%1#addToGrammar] No slotIDs given!", (Object)"TTSASRContextImpl");
            return;
        }
        this.dynamicListUpdate = TTSASRContextImpl.isDynamicListUpdate(n);
        if (n2 == 2 || n2 == 8) {
            int n3;
            int n4 = nArray.length;
            boolean bl = true;
            for (n3 = 0; n3 < n4; ++n3) {
                int n5 = nArray[n3];
                if (this.dynamicLists.contains(n5)) continue;
                this.lc.log(-1601830656, "[%1#addToGrammar] No slot entries available for slot %2 and curSlotModelID %3!", (Object)"TTSASRContextImpl", (long)n3, (long)n5);
                bl = false;
                break;
            }
            if (bl) {
                this.lc.log(-2137614336, "[%1#addToGrammar] Slot entries available!", (Object)"TTSASRContextImpl");
                for (n3 = 0; n3 < n4; ++n3) {
                    this.newSlotIDSet.add(new Integer(nArray[n3]));
                }
                if (!this.dynamicListUpdate) {
                    this.newRuleIDSet.add(new Integer(n));
                }
            }
        } else if (!this.dynamicListUpdate) {
            this.newRuleIDSet.add(new Integer(n));
        }
        this.setRuleIDs(n, n2);
    }

    @Override
    public SortedSet getRuleIds() {
        return this.newRuleIDSet;
    }

    @Override
    public SortedSet getSlotIds() {
        return this.newSlotIDSet;
    }

    @Override
    public int getRuleIDForNBest() {
        return this.ruleIDForNBest;
    }

    @Override
    public List getRuleIDsForSpelling() {
        return this.ruleIDsForSpelling;
    }

    @Override
    public String getSRGSString(int n) {
        return (String)this.newSRGSStrings.get(new Integer(n));
    }

    public HashMap getSRGSStrings() {
        return this.newSRGSStrings;
    }

    public String toString() {
        Buffer buffer = new Buffer("'ruleIDs=[");
        Iterator iterator = this.newRuleIDSet.iterator();
        while (iterator.hasNext()) {
            buffer.append(iterator.next()).append(",");
        }
        buffer.append("], slotIDs=[");
        iterator = this.newSlotIDSet.iterator();
        while (iterator.hasNext()) {
            buffer.append(iterator.next()).append(",");
        }
        buffer.append("], nbestRuleID=").append(this.ruleIDForNBest).append(", spellingRuleIDs=[");
        iterator = this.ruleIDsForSpelling.iterator();
        while (iterator.hasNext()) {
            buffer.append(iterator.next()).append(",");
        }
        buffer.append("]'");
        return buffer.toString();
    }
}

