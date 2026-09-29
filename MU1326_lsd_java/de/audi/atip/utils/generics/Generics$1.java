/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.generics;

import de.audi.atip.utils.generics.GComparator;
import java.util.Comparator;

final class Generics$1
implements Comparator {
    private final /* synthetic */ GComparator val$comparator;

    Generics$1(GComparator gComparator) {
        this.val$comparator = gComparator;
    }

    @Override
    public int compare(Object object, Object object2) {
        return this.val$comparator.compare(object, object2);
    }
}

