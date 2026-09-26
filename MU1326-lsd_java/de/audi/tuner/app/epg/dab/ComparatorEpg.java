/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.epg.dab;

import de.audi.tuner.app.LanguageManager;
import de.audi.tuner.app.epg.dab.EPGShortInfoExt;
import java.util.Comparator;

class ComparatorEpg
implements Comparator {
    private final LanguageManager langMngr;

    ComparatorEpg(LanguageManager languageManager) {
        this.langMngr = languageManager;
    }

    @Override
    public int compare(Object object, Object object2) {
        if (object == null) {
            return -1;
        }
        if (object2 == null) {
            return 1;
        }
        String string = ((EPGShortInfoExt)object).getServiceName();
        String string2 = ((EPGShortInfoExt)object2).getServiceName();
        return this.langMngr.getCollator().compare(string, string2);
    }
}

