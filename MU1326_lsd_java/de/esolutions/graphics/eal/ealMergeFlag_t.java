/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal;

import de.esolutions.graphics.ealswigJNI;

public final class ealMergeFlag_t {
    public static final ealMergeFlag_t EAL_MERGE_FLAG_NONE = new ealMergeFlag_t("EAL_MERGE_FLAG_NONE", ealswigJNI.eal_EAL_MERGE_FLAG_NONE_get());
    public static final ealMergeFlag_t EAL_MERGE_FLAG_FORCE = new ealMergeFlag_t("EAL_MERGE_FLAG_FORCE", ealswigJNI.eal_EAL_MERGE_FLAG_FORCE_get());
    public static final ealMergeFlag_t EAL_MERGE_FLAG_LOADING_HINT_PRELOAD = new ealMergeFlag_t("EAL_MERGE_FLAG_LOADING_HINT_PRELOAD", ealswigJNI.eal_EAL_MERGE_FLAG_LOADING_HINT_PRELOAD_get());
    public static final ealMergeFlag_t EAL_MERGE_FLAG_LOADING_HINT_MAP = new ealMergeFlag_t("EAL_MERGE_FLAG_LOADING_HINT_MAP", ealswigJNI.eal_EAL_MERGE_FLAG_LOADING_HINT_MAP_get());
    public static final ealMergeFlag_t EAL_MERGE_FLAG_LOADING_MASK = new ealMergeFlag_t("EAL_MERGE_FLAG_LOADING_MASK", ealswigJNI.eal_EAL_MERGE_FLAG_LOADING_MASK_get());
    private static ealMergeFlag_t[] swigValues = new ealMergeFlag_t[]{EAL_MERGE_FLAG_NONE, EAL_MERGE_FLAG_FORCE, EAL_MERGE_FLAG_LOADING_HINT_PRELOAD, EAL_MERGE_FLAG_LOADING_HINT_MAP, EAL_MERGE_FLAG_LOADING_MASK};
    private static int swigNext = 0;
    private final int swigValue;
    private final String swigName;
    static /* synthetic */ Class class$de$esolutions$graphics$eal$ealMergeFlag_t;

    public final int swigValue() {
        return this.swigValue;
    }

    public String toString() {
        return this.swigName;
    }

    public static ealMergeFlag_t swigToEnum(int n) {
        if (n < swigValues.length && n >= 0 && ealMergeFlag_t.swigValues[n].swigValue == n) {
            return swigValues[n];
        }
        for (int i2 = 0; i2 < swigValues.length; ++i2) {
            if (ealMergeFlag_t.swigValues[i2].swigValue != n) continue;
            return swigValues[i2];
        }
        throw new IllegalArgumentException(new StringBuffer().append("No enum ").append(class$de$esolutions$graphics$eal$ealMergeFlag_t == null ? (class$de$esolutions$graphics$eal$ealMergeFlag_t = ealMergeFlag_t.class$("de.esolutions.graphics.eal.ealMergeFlag_t")) : class$de$esolutions$graphics$eal$ealMergeFlag_t).append(" with value ").append(n).toString());
    }

    private ealMergeFlag_t(String string) {
        this.swigName = string;
        this.swigValue = swigNext++;
    }

    private ealMergeFlag_t(String string, int n) {
        this.swigName = string;
        this.swigValue = n;
        swigNext = n + 1;
    }

    private ealMergeFlag_t(String string, ealMergeFlag_t ealMergeFlag_t2) {
        this.swigName = string;
        this.swigValue = ealMergeFlag_t2.swigValue;
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

