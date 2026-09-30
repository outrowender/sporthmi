/*
 * Decompiled with CFR 0.152.
 */
package java.text;

import com.ibm.oti.text.CompactIntArray;
import com.ibm.oti.text.IntHashtable;
import java.text.EntryPair;
import java.text.ParseException;
import java.text.RBTableBuilder;
import java.util.Vector;

final class RBCollationTables {
    static final int EXPANDCHARINDEX = 0x7E000000;
    static final int CONTRACTCHARINDEX = 0x7F000000;
    static final int UNMAPPED = -1;
    static final int PRIMARYORDERMASK = -65536;
    static final int SECONDARYORDERMASK = 65280;
    static final int TERTIARYORDERMASK = 255;
    static final int PRIMARYDIFFERENCEONLY = -65536;
    static final int SECONDARYDIFFERENCEONLY = -256;
    static final int PRIMARYORDERSHIFT = 16;
    static final int SECONDARYORDERSHIFT = 8;
    private String rules = null;
    private boolean frenchSec = false;
    private boolean seAsianSwapping = false;
    private CompactIntArray mapping = null;
    private Vector contractTable = null;
    private Vector expandTable = null;
    private IntHashtable contractFlags = null;
    private short maxSecOrder = 0;
    private short maxTerOrder = 0;

    public RBCollationTables(String string, int n) throws ParseException {
        this.rules = string;
        RBTableBuilder rBTableBuilder = new RBTableBuilder(new BuildAPI());
        rBTableBuilder.build(string, n);
    }

    public String getRules() {
        return this.rules;
    }

    public boolean isFrenchSec() {
        return this.frenchSec;
    }

    public boolean isSEAsianSwapping() {
        return this.seAsianSwapping;
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

    boolean usedInContractSeq(char c2) {
        return this.contractFlags.get(c2) == 1;
    }

    int getMaxExpansion(int n) {
        int n2 = 1;
        if (this.expandTable != null) {
            int n3 = 0;
            while (n3 < this.expandTable.size()) {
                int[] nArray = (int[])this.expandTable.elementAt(n3);
                int n4 = nArray.length;
                if (n4 > n2 && nArray[n4 - 1] == n) {
                    n2 = n4;
                }
                ++n3;
            }
        }
        return n2;
    }

    final int[] getExpandValueList(int n) {
        return (int[])this.expandTable.elementAt(n - 0x7E000000);
    }

    int getUnicodeOrder(char c2) {
        return this.mapping.elementAt(c2);
    }

    short getMaxSecOrder() {
        return this.maxSecOrder;
    }

    short getMaxTerOrder() {
        return this.maxTerOrder;
    }

    static void reverse(StringBuffer stringBuffer, int n, int n2) {
        int n3 = n;
        int n4 = n2 - 1;
        while (n3 < n4) {
            char c2 = stringBuffer.charAt(n3);
            stringBuffer.setCharAt(n3, stringBuffer.charAt(n4));
            stringBuffer.setCharAt(n4, c2);
            ++n3;
            --n4;
        }
    }

    static final int getEntry(Vector vector, String string, boolean bl) {
        int n = 0;
        while (n < vector.size()) {
            EntryPair entryPair = (EntryPair)vector.elementAt(n);
            if (entryPair.fwd == bl && entryPair.entryName.equals(string)) {
                return n;
            }
            ++n;
        }
        return -1;
    }

    final class BuildAPI {
        private BuildAPI() {
        }

        void fillInTables(boolean bl, boolean bl2, CompactIntArray compactIntArray, Vector vector, Vector vector2, IntHashtable intHashtable, short s, short s2) {
            RBCollationTables.this.frenchSec = bl;
            RBCollationTables.this.seAsianSwapping = bl2;
            RBCollationTables.this.mapping = compactIntArray;
            RBCollationTables.this.contractTable = vector;
            RBCollationTables.this.expandTable = vector2;
            RBCollationTables.this.contractFlags = intHashtable;
            RBCollationTables.this.maxSecOrder = s;
            RBCollationTables.this.maxTerOrder = s2;
        }
    }
}

