/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.grammar;

import de.audi.app.sdsmanager.common.Logger;
import de.audi.app.sdsmanager.grammar.ISDSGrammarState;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

public class SDSGrammarStateImpl
implements ISDSGrammarState {
    private static final String LOGCLASS = "SDSGrammarStateImpl";
    private LogChannel lc = Logger.getGrammarLog();
    private volatile SortedSet loadedGrammarIdSet = new TreeSet();

    public SortedSet getCurrentlyLoadedGrammarRuleIDs() {
        return this.loadedGrammarIdSet;
    }

    public void setCurrentlyLoadedGrammarRuleIDs(SortedSet sortedSet) {
        if (sortedSet == null) {
            throw new IllegalArgumentException();
        }
        if (this.lc.isDebug()) {
            Buffer buffer = new Buffer();
            Iterator iterator = sortedSet.iterator();
            while (iterator.hasNext()) {
                buffer.append(iterator.next()).append(",");
            }
            this.lc.log(10000000, "[%1#setCurrentlyLoadedGrammerRuleIDs] %2", (Object)LOGCLASS, (Object)buffer);
        }
        this.loadedGrammarIdSet = sortedSet;
    }
}

