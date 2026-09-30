/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.dab.stationlist;

import de.audi.tuner.app.LanguageManager;
import de.audi.tuner.app.dab.DabStation;
import java.util.Comparator;
import org.dsi.ifc.radio.ComponentInfo;

public class ComparatorComponent
implements Comparator {
    private final LanguageManager langMngr;

    public ComparatorComponent(LanguageManager languageManager) {
        this.langMngr = languageManager;
    }

    public int compare(Object object, Object object2) {
        ComponentInfo componentInfo;
        ComponentInfo componentInfo2;
        if (object == null) {
            return -1;
        }
        if (object2 == null) {
            return 1;
        }
        if (object instanceof DabStation) {
            componentInfo2 = ((DabStation)object).component;
            componentInfo = ((DabStation)object2).component;
        } else {
            componentInfo2 = (ComponentInfo)object;
            componentInfo = (ComponentInfo)object2;
        }
        int n = this.langMngr.getCollator().compare(componentInfo2.getFullName(), componentInfo.getFullName());
        if (n == 0 && (n = this.compare(componentInfo2.getSID(), componentInfo.getSID())) == 0) {
            return this.compare(componentInfo2.getEnsID(), componentInfo.getEnsID());
        }
        return n;
    }

    private int compare(long l, long l2) {
        if (l < l2) {
            return -1;
        }
        if (l > l2) {
            return 1;
        }
        return 0;
    }
}

