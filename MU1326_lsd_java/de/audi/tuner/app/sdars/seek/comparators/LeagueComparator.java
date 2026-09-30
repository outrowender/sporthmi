/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars.seek.comparators;

import de.audi.tuner.app.LanguageManager;
import java.util.Comparator;
import org.dsi.ifc.sdars.LeagueEntry;

public class LeagueComparator
implements Comparator {
    private final LanguageManager langMngr;

    public LeagueComparator(LanguageManager languageManager) {
        this.langMngr = languageManager;
    }

    public int compare(Object object, Object object2) {
        if (object == null) {
            return -1;
        }
        if (object2 == null) {
            return 1;
        }
        String string = ((LeagueEntry)object).getLeagueName();
        String string2 = ((LeagueEntry)object2).getLeagueName();
        return this.langMngr.getCollator().compare(string, string2);
    }
}

