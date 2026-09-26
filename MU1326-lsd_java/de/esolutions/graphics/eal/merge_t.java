/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal;

public final class merge_t {
    public static final merge_t MERGE_SYNCHRONOUS = new merge_t("MERGE_SYNCHRONOUS");
    public static final merge_t MERGE_ASYNCHRONOUS = new merge_t("MERGE_ASYNCHRONOUS");
    private static merge_t[] swigValues = new merge_t[]{MERGE_SYNCHRONOUS, MERGE_ASYNCHRONOUS};
    private static int swigNext = 0;
    private final int swigValue;
    private final String swigName;
    static /* synthetic */ Class class$de$esolutions$graphics$eal$merge_t;

    public final int swigValue() {
        return this.swigValue;
    }

    public String toString() {
        return this.swigName;
    }

    public static merge_t swigToEnum(int n) {
        if (n < swigValues.length && n >= 0 && merge_t.swigValues[n].swigValue == n) {
            return swigValues[n];
        }
        for (int i2 = 0; i2 < swigValues.length; ++i2) {
            if (merge_t.swigValues[i2].swigValue != n) continue;
            return swigValues[i2];
        }
        throw new IllegalArgumentException(new StringBuffer().append("No enum ").append(class$de$esolutions$graphics$eal$merge_t == null ? (class$de$esolutions$graphics$eal$merge_t = merge_t.class$("de.esolutions.graphics.eal.merge_t")) : class$de$esolutions$graphics$eal$merge_t).append(" with value ").append(n).toString());
    }

    private merge_t(String string) {
        this.swigName = string;
        this.swigValue = swigNext++;
    }

    private merge_t(String string, int n) {
        this.swigName = string;
        this.swigValue = n;
        swigNext = n + 1;
    }

    private merge_t(String string, merge_t merge_t2) {
        this.swigName = string;
        this.swigValue = merge_t2.swigValue;
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

