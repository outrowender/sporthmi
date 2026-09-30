/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars;

import de.audi.tuner.app.LanguageManager;
import de.audi.tuner.app.sdars.CategoryFilterRow;
import java.util.Comparator;
import org.dsi.ifc.sdars.CategoryInfo;

class SortAlgoCategory
implements Comparator {
    private final LanguageManager langMngr;

    SortAlgoCategory(LanguageManager languageManager) {
        this.langMngr = languageManager;
    }

    public int compare(Object object, Object object2) {
        String string;
        String string2;
        if (object instanceof CategoryInfo) {
            string2 = ((CategoryInfo)object).fullLabel;
            string = ((CategoryInfo)object2).fullLabel;
        } else {
            string2 = ((CategoryFilterRow)object).getText(0);
            string = ((CategoryFilterRow)object2).getText(0);
        }
        if (string2 == null) {
            return 1;
        }
        if (string == null) {
            return -1;
        }
        return this.langMngr.getCollator().compare(string2, string);
    }
}

