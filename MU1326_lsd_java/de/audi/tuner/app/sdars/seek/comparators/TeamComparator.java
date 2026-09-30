/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars.seek.comparators;

import de.audi.tuner.app.LanguageManager;
import java.util.Comparator;
import org.dsi.ifc.sdars.TeamEntry;

public class TeamComparator
implements Comparator {
    private final LanguageManager langMngr;

    public TeamComparator(LanguageManager languageManager) {
        this.langMngr = languageManager;
    }

    public int compare(Object object, Object object2) {
        if (object == null) {
            return -1;
        }
        if (object2 == null) {
            return 1;
        }
        String string = ((TeamEntry)object).getTeamName();
        String string2 = ((TeamEntry)object2).getTeamName();
        return this.langMngr.getCollator().compare(string, string2);
    }
}

