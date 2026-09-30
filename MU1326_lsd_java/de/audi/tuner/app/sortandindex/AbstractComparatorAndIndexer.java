/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sortandindex;

import de.audi.tuner.app.LanguageManager;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.sortandindex.AlphabeticalIndexRow;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractComparatorAndIndexer
implements Comparator {
    private static final int NO_INDEX_CHARACTER = -1;
    private final LanguageManager langMngr;
    private final boolean providesIndexInformation;

    protected AbstractComparatorAndIndexer(LanguageManager languageManager, boolean bl) {
        this.langMngr = languageManager;
        this.providesIndexInformation = bl;
    }

    public int compare(Object object, Object object2) {
        return this.compare(object, object2, this.langMngr.getCollator());
    }

    public List sortAndProvideAlphabeticalIndexRowsFor(List list) {
        Collections.sort(list, this);
        return this.provideAlphabeticalIndexRowsForAlreadySortedList(list);
    }

    public List provideAlphabeticalIndexRowsForAlreadySortedList(List list) {
        if (!this.providesIndexInformation) {
            return Collections.EMPTY_LIST;
        }
        int n = 0;
        int n2 = -1;
        ArrayList arrayList = new ArrayList(26);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            int n3 = this.getIndexChar(iterator.next());
            if (n3 != -1 && n3 != n2) {
                arrayList.add(new AlphabeticalIndexRow(n3, n));
                n2 = n3;
            }
            ++n;
        }
        return arrayList;
    }

    private int getIndexChar(Object object) {
        String string = this.getStringUsedForIndexing(object);
        if (Utilities.isEmpty(string)) {
            return -1;
        }
        char c2 = string.charAt(0);
        if ('A' <= c2 && c2 <= 'Z' || 'a' <= c2 && c2 <= 'z') {
            return Character.toUpperCase(c2);
        }
        return -1;
    }

    protected abstract int compare(Object var1, Object var2, Collator var3);

    protected abstract String getStringUsedForIndexing(Object var1);
}

