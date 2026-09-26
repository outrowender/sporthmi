/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.util;

import de.audi.tv.app.util.Predicates$Predicate;
import java.util.ArrayList;
import java.util.List;

public class Predicates$OrCompoundPredicate
implements Predicates$Predicate {
    private final List predicates = new ArrayList();

    public void add(Predicates$Predicate predicates$Predicate) {
        this.predicates.add(predicates$Predicate);
    }

    @Override
    public boolean apply(Object object) {
        for (int i2 = 0; i2 < this.predicates.size(); ++i2) {
            if (!((Predicates$Predicate)this.predicates.get(i2)).apply(object)) continue;
            return true;
        }
        return false;
    }
}

