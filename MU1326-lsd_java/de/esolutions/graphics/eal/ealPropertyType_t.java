/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal;

public final class ealPropertyType_t {
    public static final ealPropertyType_t EAL_PROPERTYTYPE_FLOAT = new ealPropertyType_t("EAL_PROPERTYTYPE_FLOAT");
    public static final ealPropertyType_t EAL_PROPERTYTYPE_INT = new ealPropertyType_t("EAL_PROPERTYTYPE_INT");
    public static final ealPropertyType_t EAL_PROPERTYTYPE_BOOL = new ealPropertyType_t("EAL_PROPERTYTYPE_BOOL");
    public static final ealPropertyType_t EAL_PROPERTYTYPE_COLOR = new ealPropertyType_t("EAL_PROPERTYTYPE_COLOR");
    public static final ealPropertyType_t EAL_PROPERTYTYPE_VEC2 = new ealPropertyType_t("EAL_PROPERTYTYPE_VEC2");
    public static final ealPropertyType_t EAL_PROPERTYTYPE_VEC3 = new ealPropertyType_t("EAL_PROPERTYTYPE_VEC3");
    public static final ealPropertyType_t EAL_PROPERTYTYPE_VEC4 = new ealPropertyType_t("EAL_PROPERTYTYPE_VEC4");
    private static ealPropertyType_t[] swigValues = new ealPropertyType_t[]{EAL_PROPERTYTYPE_FLOAT, EAL_PROPERTYTYPE_INT, EAL_PROPERTYTYPE_BOOL, EAL_PROPERTYTYPE_COLOR, EAL_PROPERTYTYPE_VEC2, EAL_PROPERTYTYPE_VEC3, EAL_PROPERTYTYPE_VEC4};
    private static int swigNext = 0;
    private final int swigValue;
    private final String swigName;
    static /* synthetic */ Class class$de$esolutions$graphics$eal$ealPropertyType_t;

    public final int swigValue() {
        return this.swigValue;
    }

    public String toString() {
        return this.swigName;
    }

    public static ealPropertyType_t swigToEnum(int n) {
        if (n < swigValues.length && n >= 0 && ealPropertyType_t.swigValues[n].swigValue == n) {
            return swigValues[n];
        }
        for (int i2 = 0; i2 < swigValues.length; ++i2) {
            if (ealPropertyType_t.swigValues[i2].swigValue != n) continue;
            return swigValues[i2];
        }
        throw new IllegalArgumentException(new StringBuffer().append("No enum ").append(class$de$esolutions$graphics$eal$ealPropertyType_t == null ? (class$de$esolutions$graphics$eal$ealPropertyType_t = ealPropertyType_t.class$("de.esolutions.graphics.eal.ealPropertyType_t")) : class$de$esolutions$graphics$eal$ealPropertyType_t).append(" with value ").append(n).toString());
    }

    private ealPropertyType_t(String string) {
        this.swigName = string;
        this.swigValue = swigNext++;
    }

    private ealPropertyType_t(String string, int n) {
        this.swigName = string;
        this.swigValue = n;
        swigNext = n + 1;
    }

    private ealPropertyType_t(String string, ealPropertyType_t ealPropertyType_t2) {
        this.swigName = string;
        this.swigValue = ealPropertyType_t2.swigValue;
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

