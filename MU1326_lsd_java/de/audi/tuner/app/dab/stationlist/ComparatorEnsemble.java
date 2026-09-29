/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.dab.stationlist;

import de.audi.tuner.app.LanguageManager;
import de.audi.tuner.app.dab.DabStation;
import java.util.Comparator;
import org.dsi.ifc.radio.EnsembleInfo;

public class ComparatorEnsemble
implements Comparator {
    private final LanguageManager langMngr;

    public ComparatorEnsemble(LanguageManager languageManager) {
        this.langMngr = languageManager;
    }

    @Override
    public int compare(Object object, Object object2) {
        String string;
        String string2;
        if (object == null) {
            return -1;
        }
        if (object2 == null) {
            return 1;
        }
        if (object instanceof DabStation) {
            string2 = ((DabStation)object).getFullName();
            string = ((DabStation)object2).getFullName();
        } else {
            string2 = ((EnsembleInfo)object).fullName;
            string = ((EnsembleInfo)object2).fullName;
        }
        return this.langMngr.getCollator().compare(string2, string);
    }
}

