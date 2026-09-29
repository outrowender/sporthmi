/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.util;

import org.apache.xerces.util.XMLGrammarPoolImpl$Entry;
import org.apache.xerces.xni.grammars.Grammar;
import org.apache.xerces.xni.grammars.XMLGrammarDescription;
import org.apache.xerces.xni.grammars.XMLGrammarPool;

public class XMLGrammarPoolImpl
implements XMLGrammarPool {
    protected static final int TABLE_SIZE;
    protected XMLGrammarPoolImpl$Entry[] fGrammars = null;
    protected boolean fPoolIsLocked;
    protected int fGrammarCount = 0;
    private static final boolean DEBUG;

    public XMLGrammarPoolImpl() {
        this.fGrammars = new XMLGrammarPoolImpl$Entry[11];
        this.fPoolIsLocked = false;
    }

    public XMLGrammarPoolImpl(int n) {
        this.fGrammars = new XMLGrammarPoolImpl$Entry[n];
        this.fPoolIsLocked = false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Grammar[] retrieveInitialGrammarSet(String string) {
        XMLGrammarPoolImpl$Entry[] xMLGrammarPoolImpl$EntryArray = this.fGrammars;
        synchronized (this.fGrammars) {
            int n = this.fGrammars.length;
            Grammar[] grammarArray = new Grammar[this.fGrammarCount];
            int n2 = 0;
            for (int i2 = 0; i2 < n; ++i2) {
                XMLGrammarPoolImpl$Entry xMLGrammarPoolImpl$Entry = this.fGrammars[i2];
                while (xMLGrammarPoolImpl$Entry != null) {
                    if (xMLGrammarPoolImpl$Entry.desc.getGrammarType().equals(string)) {
                        grammarArray[n2++] = xMLGrammarPoolImpl$Entry.grammar;
                    }
                    xMLGrammarPoolImpl$Entry = xMLGrammarPoolImpl$Entry.next;
                }
            }
            Grammar[] grammarArray2 = new Grammar[n2];
            System.arraycopy((Object)grammarArray, 0, (Object)grammarArray2, 0, n2);
            // ** MonitorExit[var2_2] (shouldn't be in output)
            return grammarArray2;
        }
    }

    @Override
    public void cacheGrammars(String string, Grammar[] grammarArray) {
        if (!this.fPoolIsLocked) {
            for (int i2 = 0; i2 < grammarArray.length; ++i2) {
                this.putGrammar(grammarArray[i2]);
            }
        }
    }

    @Override
    public Grammar retrieveGrammar(XMLGrammarDescription xMLGrammarDescription) {
        return this.getGrammar(xMLGrammarDescription);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void putGrammar(Grammar grammar) {
        if (this.fPoolIsLocked) return;
        XMLGrammarPoolImpl$Entry[] xMLGrammarPoolImpl$EntryArray = this.fGrammars;
        synchronized (this.fGrammars) {
            XMLGrammarDescription xMLGrammarDescription = grammar.getGrammarDescription();
            int n = this.hashCode(xMLGrammarDescription);
            int n2 = (n & 0xFFFFFF7F) % this.fGrammars.length;
            XMLGrammarPoolImpl$Entry xMLGrammarPoolImpl$Entry = this.fGrammars[n2];
            while (xMLGrammarPoolImpl$Entry != null) {
                if (xMLGrammarPoolImpl$Entry.hash == n && this.equals(xMLGrammarPoolImpl$Entry.desc, xMLGrammarDescription)) {
                    xMLGrammarPoolImpl$Entry.grammar = grammar;
                    // ** MonitorExit[var2_2] (shouldn't be in output)
                    return;
                }
                xMLGrammarPoolImpl$Entry = xMLGrammarPoolImpl$Entry.next;
            }
            this.fGrammars[n2] = xMLGrammarPoolImpl$Entry = new XMLGrammarPoolImpl$Entry(n, xMLGrammarDescription, grammar, this.fGrammars[n2]);
            ++this.fGrammarCount;
            // ** MonitorExit[var2_2] (shouldn't be in output)
            return;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Grammar getGrammar(XMLGrammarDescription xMLGrammarDescription) {
        XMLGrammarPoolImpl$Entry[] xMLGrammarPoolImpl$EntryArray = this.fGrammars;
        synchronized (this.fGrammars) {
            int n = this.hashCode(xMLGrammarDescription);
            int n2 = (n & 0xFFFFFF7F) % this.fGrammars.length;
            XMLGrammarPoolImpl$Entry xMLGrammarPoolImpl$Entry = this.fGrammars[n2];
            while (xMLGrammarPoolImpl$Entry != null) {
                if (xMLGrammarPoolImpl$Entry.hash == n && this.equals(xMLGrammarPoolImpl$Entry.desc, xMLGrammarDescription)) {
                    // ** MonitorExit[var2_2] (shouldn't be in output)
                    return xMLGrammarPoolImpl$Entry.grammar;
                }
                xMLGrammarPoolImpl$Entry = xMLGrammarPoolImpl$Entry.next;
            }
            // ** MonitorExit[var2_2] (shouldn't be in output)
            return null;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Grammar removeGrammar(XMLGrammarDescription xMLGrammarDescription) {
        XMLGrammarPoolImpl$Entry[] xMLGrammarPoolImpl$EntryArray = this.fGrammars;
        synchronized (this.fGrammars) {
            int n = this.hashCode(xMLGrammarDescription);
            int n2 = (n & 0xFFFFFF7F) % this.fGrammars.length;
            XMLGrammarPoolImpl$Entry xMLGrammarPoolImpl$Entry = this.fGrammars[n2];
            XMLGrammarPoolImpl$Entry xMLGrammarPoolImpl$Entry2 = null;
            while (xMLGrammarPoolImpl$Entry != null) {
                if (xMLGrammarPoolImpl$Entry.hash == n && this.equals(xMLGrammarPoolImpl$Entry.desc, xMLGrammarDescription)) {
                    if (xMLGrammarPoolImpl$Entry2 != null) {
                        xMLGrammarPoolImpl$Entry2.next = xMLGrammarPoolImpl$Entry.next;
                    } else {
                        this.fGrammars[n2] = xMLGrammarPoolImpl$Entry.next;
                    }
                    Grammar grammar = xMLGrammarPoolImpl$Entry.grammar;
                    xMLGrammarPoolImpl$Entry.grammar = null;
                    --this.fGrammarCount;
                    // ** MonitorExit[var2_2] (shouldn't be in output)
                    return grammar;
                }
                xMLGrammarPoolImpl$Entry2 = xMLGrammarPoolImpl$Entry;
                xMLGrammarPoolImpl$Entry = xMLGrammarPoolImpl$Entry.next;
            }
            // ** MonitorExit[var2_2] (shouldn't be in output)
            return null;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean containsGrammar(XMLGrammarDescription xMLGrammarDescription) {
        XMLGrammarPoolImpl$Entry[] xMLGrammarPoolImpl$EntryArray = this.fGrammars;
        synchronized (this.fGrammars) {
            int n = this.hashCode(xMLGrammarDescription);
            int n2 = (n & 0xFFFFFF7F) % this.fGrammars.length;
            XMLGrammarPoolImpl$Entry xMLGrammarPoolImpl$Entry = this.fGrammars[n2];
            while (xMLGrammarPoolImpl$Entry != null) {
                if (xMLGrammarPoolImpl$Entry.hash == n && this.equals(xMLGrammarPoolImpl$Entry.desc, xMLGrammarDescription)) {
                    // ** MonitorExit[var2_2] (shouldn't be in output)
                    return true;
                }
                xMLGrammarPoolImpl$Entry = xMLGrammarPoolImpl$Entry.next;
            }
            // ** MonitorExit[var2_2] (shouldn't be in output)
            return false;
        }
    }

    @Override
    public void lockPool() {
        this.fPoolIsLocked = true;
    }

    @Override
    public void unlockPool() {
        this.fPoolIsLocked = false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void clear() {
        XMLGrammarPoolImpl$Entry[] xMLGrammarPoolImpl$EntryArray = this.fGrammars;
        synchronized (this.fGrammars) {
            for (int i2 = 0; i2 < this.fGrammars.length; ++i2) {
                if (this.fGrammars[i2] == null) continue;
                this.fGrammars[i2].clear();
                this.fGrammars[i2] = null;
            }
            this.fGrammarCount = 0;
            // ** MonitorExit[var1_1] (shouldn't be in output)
            return;
        }
    }

    public boolean equals(XMLGrammarDescription xMLGrammarDescription, XMLGrammarDescription xMLGrammarDescription2) {
        return xMLGrammarDescription.equals(xMLGrammarDescription2);
    }

    public int hashCode(XMLGrammarDescription xMLGrammarDescription) {
        return xMLGrammarDescription.hashCode();
    }
}

