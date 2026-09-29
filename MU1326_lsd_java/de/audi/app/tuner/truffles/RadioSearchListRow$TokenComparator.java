/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.tuner.truffles;

import de.audi.app.tuner.truffles.RadioSearchListRow$1;
import java.io.Serializable;
import java.util.Comparator;
import org.dsi.ifc.search.Token;

class RadioSearchListRow$TokenComparator
implements Comparator,
Serializable {
    private static final long serialVersionUID;

    private RadioSearchListRow$TokenComparator() {
    }

    @Override
    public int compare(Object object, Object object2) {
        Token token = (Token)object;
        Token token2 = (Token)object2;
        if (token.wordType == token2.wordType) {
            return 0;
        }
        if (token.wordType == 22 || token.wordType == 23 && token2.wordType == 24) {
            return -1;
        }
        return 1;
    }

    /* synthetic */ RadioSearchListRow$TokenComparator(RadioSearchListRow$1 radioSearchListRow$1) {
        this();
    }
}

