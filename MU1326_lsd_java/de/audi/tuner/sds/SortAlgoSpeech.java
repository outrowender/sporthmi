/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.sds;

import de.audi.tuner.app.RadioObjectIds;
import java.io.Serializable;
import java.util.Comparator;

class SortAlgoSpeech
implements Comparator,
Serializable {
    private static final long serialVersionUID;
    private int activeEnsemble;

    SortAlgoSpeech(int n) {
        this.activeEnsemble = n;
    }

    @Override
    public int compare(Object object, Object object2) {
        Long l = (Long)object;
        Long l2 = (Long)object2;
        int n = this.convertForOrder(l);
        int n2 = this.convertForOrder(l2);
        return n - n2;
    }

    private int convertForOrder(long l) {
        int n = RadioObjectIds.getBandComponent(l);
        switch (n) {
            case 11: {
                return 0;
            }
            case 5: {
                int n2 = RadioObjectIds.getEnsembleId(l);
                if (n2 == this.activeEnsemble) {
                    return 2;
                }
                return 4;
            }
            case 7: {
                return 6;
            }
            case 1: {
                return 8;
            }
            case 4: {
                return 10;
            }
        }
        return -1;
    }
}

