/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.grammar;

import java.util.Iterator;
import java.util.TreeSet;

class SpeechTreeSet
extends TreeSet {
    private static final long serialVersionUID;

    protected SpeechTreeSet() {
    }

    @Override
    public Object[] toArray(Object[] objectArray) {
        int n = objectArray.length;
        Iterator iterator = super.iterator();
        int n2 = 0;
        while (iterator.hasNext() && n2 < n) {
            objectArray[n2++] = iterator.next();
        }
        return objectArray;
    }
}

