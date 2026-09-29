/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal;

import de.esolutions.graphics.ealswigJNI;

public final class event_t {
    public static final event_t EVENTTYPE_MERGE_LOADED = new event_t("EVENTTYPE_MERGE_LOADED", ealswigJNI.eal_EVENTTYPE_MERGE_LOADED_get());
    public static final event_t EVENTTYPE_MERGE_MERGED = new event_t("EVENTTYPE_MERGE_MERGED", ealswigJNI.eal_EVENTTYPE_MERGE_MERGED_get());
    public static final event_t EVENTTYPE_IMAGE = new event_t("EVENTTYPE_IMAGE", ealswigJNI.eal_EVENTTYPE_IMAGE_get());
    public static final event_t EVENTTYPE_IMAGE_SAVE = new event_t("EVENTTYPE_IMAGE_SAVE", ealswigJNI.eal_EVENTTYPE_IMAGE_SAVE_get());
    public static final event_t EVENTTYPE_FONTGROUP = new event_t("EVENTTYPE_FONTGROUP", ealswigJNI.eal_EVENTTYPE_FONTGROUP_get());
    public static final event_t EVENTTYPE_SAVE = new event_t("EVENTTYPE_SAVE", ealswigJNI.eal_EVENTTYPE_SAVE_get());
    private static event_t[] swigValues = new event_t[]{EVENTTYPE_MERGE_LOADED, EVENTTYPE_MERGE_MERGED, EVENTTYPE_IMAGE, EVENTTYPE_IMAGE_SAVE, EVENTTYPE_FONTGROUP, EVENTTYPE_SAVE};
    private static int swigNext = 0;
    private final int swigValue;
    private final String swigName;
    static /* synthetic */ Class class$de$esolutions$graphics$eal$event_t;

    public final int swigValue() {
        return this.swigValue;
    }

    public String toString() {
        return this.swigName;
    }

    public static event_t swigToEnum(int n) {
        if (n < swigValues.length && n >= 0 && event_t.swigValues[n].swigValue == n) {
            return swigValues[n];
        }
        for (int i2 = 0; i2 < swigValues.length; ++i2) {
            if (event_t.swigValues[i2].swigValue != n) continue;
            return swigValues[i2];
        }
        throw new IllegalArgumentException(new StringBuffer().append("No enum ").append(class$de$esolutions$graphics$eal$event_t == null ? (class$de$esolutions$graphics$eal$event_t = event_t.class$("de.esolutions.graphics.eal.event_t")) : class$de$esolutions$graphics$eal$event_t).append(" with value ").append(n).toString());
    }

    private event_t(String string) {
        this.swigName = string;
        this.swigValue = swigNext++;
    }

    private event_t(String string, int n) {
        this.swigName = string;
        this.swigValue = n;
        swigNext = n + 1;
    }

    private event_t(String string, event_t event_t2) {
        this.swigName = string;
        this.swigValue = event_t2.swigValue;
        swigNext = this.swigValue + 1;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

