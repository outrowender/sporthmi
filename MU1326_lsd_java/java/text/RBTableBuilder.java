/*
 * Decompiled with CFR 0.152.
 */
package java.text;

import com.ibm.oti.text.CompactIntArray;
import com.ibm.oti.text.ComposedCharIter;
import com.ibm.oti.text.IntHashtable;
import com.ibm.oti.text.Normalizer;
import com.ibm.oti.util.Msg;
import java.text.EntryPair;
import java.text.MergeCollation;
import java.text.ParseException;
import java.text.PatternEntry;
import java.text.RBCollationTables;
import java.util.Vector;

final class RBTableBuilder {
    static final int CHARINDEX = 0x70000000;
    private static final int IGNORABLEMASK = 65535;
    private static final int PRIMARYORDERINCREMENT = 65536;
    private static final int SECONDARYORDERINCREMENT = 256;
    private static final int TERTIARYORDERINCREMENT = 1;
    private static final int INITIALTABLESIZE = 20;
    private static final int MAXKEYSIZE = 5;
    private RBCollationTables.BuildAPI tables = null;
    private MergeCollation mPattern = null;
    private boolean isOverIgnore = false;
    private StringBuffer key = new StringBuffer(5);
    private IntHashtable contractFlags = new IntHashtable(100);
    private boolean frenchSec = false;
    private boolean seAsianSwapping = false;
    private CompactIntArray mapping = null;
    private Vector contractTable = null;
    private Vector expandTable = null;
    private short maxSecOrder = 0;
    private short maxTerOrder = 0;

    public RBTableBuilder(RBCollationTables.BuildAPI buildAPI) {
        this.tables = buildAPI;
    }

    public void build(String string, int n) throws ParseException {
        int n2 = 0;
        if (string.length() == 0) {
            throw new ParseException(Msg.getString("K01ad"), 0);
        }
        this.mapping = new CompactIntArray(-1);
        Normalizer.Mode mode = Normalizer.getMode(n);
        string = Normalizer.normalize(string, mode, 0, true);
        this.mPattern = new MergeCollation(string);
        int n3 = 0;
        n2 = 0;
        while (n2 < this.mPattern.getCount()) {
            PatternEntry patternEntry = this.mPattern.getItemAt(n2);
            if (patternEntry != null) {
                String string2 = patternEntry.getChars();
                if (string2.length() > 1) {
                    switch (string2.charAt(string2.length() - 1)) {
                        case '@': {
                            this.frenchSec = true;
                            string2 = string2.substring(0, string2.length() - 1);
                            break;
                        }
                        case '!': {
                            this.seAsianSwapping = true;
                            string2 = string2.substring(0, string2.length() - 1);
                        }
                    }
                }
                n3 = this.increment(patternEntry.getStrength(), n3);
                String string3 = patternEntry.getExtension();
                if (string3.length() != 0) {
                    this.addExpandOrder(string2, string3, n3);
                } else if (string2.length() > 1) {
                    this.addContractOrder(string2, n3);
                } else {
                    char c2 = string2.charAt(0);
                    this.addOrder(c2, n3);
                }
            }
            ++n2;
        }
        this.addComposedChars();
        this.commit();
        this.mapping.compact();
        this.tables.fillInTables(this.frenchSec, this.seAsianSwapping, this.mapping, this.contractTable, this.expandTable, this.contractFlags, this.maxSecOrder, this.maxTerOrder);
    }

    private void addComposedChars() throws ParseException {
        StringBuffer stringBuffer = new StringBuffer(1);
        ComposedCharIter composedCharIter = new ComposedCharIter(false, 1);
        while (composedCharIter.hasNext()) {
            char c2 = composedCharIter.next();
            if (this.getCharOrder(c2) != -1) continue;
            String string = composedCharIter.decomposition();
            int n = this.getContractOrder(string);
            if (n != -1) {
                this.addOrder(c2, n);
                continue;
            }
            boolean bl = true;
            int n2 = 0;
            while (n2 < string.length()) {
                if (this.getCharOrder(string.charAt(n2)) == -1) {
                    bl = false;
                    break;
                }
                ++n2;
            }
            if (!bl) continue;
            stringBuffer.setLength(0);
            stringBuffer.append(c2);
            this.addExpandOrder(stringBuffer.toString(), string, -1);
        }
    }

    private final void commit() {
        if (this.expandTable != null) {
            int n = 0;
            while (n < this.expandTable.size()) {
                int[] nArray = (int[])this.expandTable.elementAt(n);
                int n2 = 0;
                while (n2 < nArray.length) {
                    int n3 = nArray[n2];
                    if (n3 < 0x7E000000 && n3 > 0x70000000) {
                        char c2 = (char)(n3 - 0x70000000);
                        int n4 = this.getCharOrder(c2);
                        nArray[n2] = n4 == -1 ? 0xFFFF & c2 : n4;
                    }
                    ++n2;
                }
                ++n;
            }
        }
    }

    private final int increment(int n, int n2) {
        switch (n) {
            case 0: {
                n2 += 65536;
                n2 &= 0xFFFF0000;
                this.isOverIgnore = true;
                break;
            }
            case 1: {
                n2 += 256;
                n2 &= 0xFFFFFF00;
                if (this.isOverIgnore) break;
                this.maxSecOrder = (short)(this.maxSecOrder + 1);
                break;
            }
            case 2: {
                ++n2;
                if (this.isOverIgnore) break;
                this.maxTerOrder = (short)(this.maxTerOrder + 1);
            }
        }
        return n2;
    }

    private final void addOrder(char c2, int n) {
        int n2 = this.mapping.elementAt(c2);
        if (n2 >= 0x7F000000) {
            this.key.setLength(0);
            this.key.append(c2);
            this.addContractOrder(this.key.toString(), n);
        } else {
            this.mapping.setElementAt(c2, n);
        }
    }

    private final void addContractOrder(String string, int n) {
        this.addContractOrder(string, n, true);
    }

    private final void addContractOrder(String string, int n, boolean bl) {
        int n2;
        int n3;
        Vector vector;
        if (this.contractTable == null) {
            this.contractTable = new Vector(20);
        }
        if ((vector = this.getContractValues((n3 = this.mapping.elementAt(string.charAt(0))) - 0x7F000000)) == null) {
            n2 = 0x7F000000 + this.contractTable.size();
            vector = new Vector(20);
            this.contractTable.addElement(vector);
            vector.addElement(new EntryPair(string.substring(0, 1), n3));
            this.mapping.setElementAt(string.charAt(0), n2);
        }
        if ((n2 = RBCollationTables.getEntry(vector, string, bl)) != -1) {
            EntryPair entryPair = (EntryPair)vector.elementAt(n2);
            entryPair.value = n;
        } else {
            EntryPair entryPair = (EntryPair)vector.lastElement();
            if (string.length() > entryPair.entryName.length()) {
                vector.addElement(new EntryPair(string, n, bl));
            } else {
                vector.insertElementAt(new EntryPair(string, n, bl), vector.size() - 1);
            }
        }
        if (bl && string.length() > 1) {
            this.addContractFlags(string);
            this.addContractOrder(new StringBuffer(string).reverse().toString(), n, false);
        }
    }

    private int getContractOrder(String string) {
        int n;
        Vector vector;
        int n2 = -1;
        if (this.contractTable != null && (vector = this.getContractValues(string.charAt(0))) != null && (n = RBCollationTables.getEntry(vector, string, true)) != -1) {
            EntryPair entryPair = (EntryPair)vector.elementAt(n);
            n2 = entryPair.value;
        }
        return n2;
    }

    private final int getCharOrder(char c2) {
        int n = this.mapping.elementAt(c2);
        if (n >= 0x7F000000) {
            Vector vector = this.getContractValues(n - 0x7F000000);
            EntryPair entryPair = (EntryPair)vector.firstElement();
            n = entryPair.value;
        }
        return n;
    }

    Vector getContractValues(char c2) {
        int n = this.mapping.elementAt(c2);
        return this.getContractValues(n - 0x7F000000);
    }

    Vector getContractValues(int n) {
        if (n >= 0) {
            return (Vector)this.contractTable.elementAt(n);
        }
        return null;
    }

    private final void addExpandOrder(String string, String string2, int n) throws ParseException {
        int n2 = this.addExpansion(n, string2);
        if (string.length() > 1) {
            this.addContractOrder(string, n2);
        } else {
            this.addOrder(string.charAt(0), n2);
        }
    }

    private int addExpansion(int n, String string) {
        if (this.expandTable == null) {
            this.expandTable = new Vector(20);
        }
        int n2 = n == -1 ? 0 : 1;
        int[] nArray = new int[string.length() + n2];
        if (n2 == 1) {
            nArray[0] = n;
        }
        int n3 = 0;
        while (n3 < string.length()) {
            char c2 = string.charAt(n3);
            int n4 = this.getCharOrder(c2);
            nArray[n3 + n2] = n4 != -1 ? n4 : 0x70000000 + c2;
            ++n3;
        }
        n3 = 0x7E000000 + this.expandTable.size();
        this.expandTable.addElement(nArray);
        return n3;
    }

    private void addContractFlags(String string) {
        int n = string.length();
        int n2 = 0;
        while (n2 < n) {
            char c2 = string.charAt(n2);
            this.contractFlags.put(c2, 1);
            ++n2;
        }
    }
}

