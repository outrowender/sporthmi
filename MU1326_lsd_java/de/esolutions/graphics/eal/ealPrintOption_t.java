/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal;

import de.esolutions.graphics.ealswigJNI;

public final class ealPrintOption_t {
    public static final ealPrintOption_t EAL_PRINT_OPTION_NONE = new ealPrintOption_t("EAL_PRINT_OPTION_NONE", ealswigJNI.eal_EAL_PRINT_OPTION_NONE_get());
    public static final ealPrintOption_t EAL_PRINT_OPTION_MODE_VISIBLE = new ealPrintOption_t("EAL_PRINT_OPTION_MODE_VISIBLE", ealswigJNI.eal_EAL_PRINT_OPTION_MODE_VISIBLE_get());
    public static final ealPrintOption_t EAL_PRINT_OPTION_MODE_LAYER_ONLY = new ealPrintOption_t("EAL_PRINT_OPTION_MODE_LAYER_ONLY", ealswigJNI.eal_EAL_PRINT_OPTION_MODE_LAYER_ONLY_get());
    public static final ealPrintOption_t EAL_PRINT_OPTION_MODE_EXT = new ealPrintOption_t("EAL_PRINT_OPTION_MODE_EXT", ealswigJNI.eal_EAL_PRINT_OPTION_MODE_EXT_get());
    public static final ealPrintOption_t EAL_PRINT_OPTION_MODE_PR = new ealPrintOption_t("EAL_PRINT_OPTION_MODE_PR", ealswigJNI.eal_EAL_PRINT_OPTION_MODE_PR_get());
    public static final ealPrintOption_t EAL_PRINT_OPTION_OUTPUT_STDOUT = new ealPrintOption_t("EAL_PRINT_OPTION_OUTPUT_STDOUT", ealswigJNI.eal_EAL_PRINT_OPTION_OUTPUT_STDOUT_get());
    public static final ealPrintOption_t EAL_PRINT_OPTION_OUTPUT_TRACE = new ealPrintOption_t("EAL_PRINT_OPTION_OUTPUT_TRACE", ealswigJNI.eal_EAL_PRINT_OPTION_OUTPUT_TRACE_get());
    public static final ealPrintOption_t EAL_PRINT_OPTION_TYPE_PLAIN = new ealPrintOption_t("EAL_PRINT_OPTION_TYPE_PLAIN", ealswigJNI.eal_EAL_PRINT_OPTION_TYPE_PLAIN_get());
    public static final ealPrintOption_t EAL_PRINT_OPTION_TYPE_JSON = new ealPrintOption_t("EAL_PRINT_OPTION_TYPE_JSON", ealswigJNI.eal_EAL_PRINT_OPTION_TYPE_JSON_get());
    public static final ealPrintOption_t EAL_PRINT_OPTION_TYPE_XML = new ealPrintOption_t("EAL_PRINT_OPTION_TYPE_XML", ealswigJNI.eal_EAL_PRINT_OPTION_TYPE_XML_get());
    public static final ealPrintOption_t EAL_PRINT_FLAG_PROPERTIES = new ealPrintOption_t("EAL_PRINT_FLAG_PROPERTIES", ealswigJNI.eal_EAL_PRINT_FLAG_PROPERTIES_get());
    public static final ealPrintOption_t EAL_PRINT_OPTION_MASK_MODE = new ealPrintOption_t("EAL_PRINT_OPTION_MASK_MODE", ealswigJNI.eal_EAL_PRINT_OPTION_MASK_MODE_get());
    public static final ealPrintOption_t EAL_PRINT_OPTION_MASK_OUTPUT = new ealPrintOption_t("EAL_PRINT_OPTION_MASK_OUTPUT", ealswigJNI.eal_EAL_PRINT_OPTION_MASK_OUTPUT_get());
    public static final ealPrintOption_t EAL_PRINT_OPTION_MASK_TYPE = new ealPrintOption_t("EAL_PRINT_OPTION_MASK_TYPE", ealswigJNI.eal_EAL_PRINT_OPTION_MASK_TYPE_get());
    private static ealPrintOption_t[] swigValues = new ealPrintOption_t[]{EAL_PRINT_OPTION_NONE, EAL_PRINT_OPTION_MODE_VISIBLE, EAL_PRINT_OPTION_MODE_LAYER_ONLY, EAL_PRINT_OPTION_MODE_EXT, EAL_PRINT_OPTION_MODE_PR, EAL_PRINT_OPTION_OUTPUT_STDOUT, EAL_PRINT_OPTION_OUTPUT_TRACE, EAL_PRINT_OPTION_TYPE_PLAIN, EAL_PRINT_OPTION_TYPE_JSON, EAL_PRINT_OPTION_TYPE_XML, EAL_PRINT_FLAG_PROPERTIES, EAL_PRINT_OPTION_MASK_MODE, EAL_PRINT_OPTION_MASK_OUTPUT, EAL_PRINT_OPTION_MASK_TYPE};
    private static int swigNext = 0;
    private final int swigValue;
    private final String swigName;
    static /* synthetic */ Class class$de$esolutions$graphics$eal$ealPrintOption_t;

    public final int swigValue() {
        return this.swigValue;
    }

    public String toString() {
        return this.swigName;
    }

    public static ealPrintOption_t swigToEnum(int n) {
        if (n < swigValues.length && n >= 0 && ealPrintOption_t.swigValues[n].swigValue == n) {
            return swigValues[n];
        }
        for (int i2 = 0; i2 < swigValues.length; ++i2) {
            if (ealPrintOption_t.swigValues[i2].swigValue != n) continue;
            return swigValues[i2];
        }
        throw new IllegalArgumentException(new StringBuffer().append("No enum ").append(class$de$esolutions$graphics$eal$ealPrintOption_t == null ? (class$de$esolutions$graphics$eal$ealPrintOption_t = ealPrintOption_t.class$("de.esolutions.graphics.eal.ealPrintOption_t")) : class$de$esolutions$graphics$eal$ealPrintOption_t).append(" with value ").append(n).toString());
    }

    private ealPrintOption_t(String string) {
        this.swigName = string;
        this.swigValue = swigNext++;
    }

    private ealPrintOption_t(String string, int n) {
        this.swigName = string;
        this.swigValue = n;
        swigNext = n + 1;
    }

    private ealPrintOption_t(String string, ealPrintOption_t ealPrintOption_t2) {
        this.swigName = string;
        this.swigValue = ealPrintOption_t2.swigValue;
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

