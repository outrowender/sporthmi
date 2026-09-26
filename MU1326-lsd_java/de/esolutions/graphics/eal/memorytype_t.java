/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal;

import de.esolutions.graphics.ealswigJNI;

public final class memorytype_t {
    public static final memorytype_t MEMORYTYPE_NONE = new memorytype_t("MEMORYTYPE_NONE", ealswigJNI.eal_MEMORYTYPE_NONE_get());
    public static final memorytype_t MEMORYTYPE_RAM = new memorytype_t("MEMORYTYPE_RAM", ealswigJNI.eal_MEMORYTYPE_RAM_get());
    public static final memorytype_t MEMORYTYPE_GPU = new memorytype_t("MEMORYTYPE_GPU", ealswigJNI.eal_MEMORYTYPE_GPU_get());
    public static final memorytype_t MEMORYTYPE_RAM_GPU = new memorytype_t("MEMORYTYPE_RAM_GPU", ealswigJNI.eal_MEMORYTYPE_RAM_GPU_get());
    private static memorytype_t[] swigValues = new memorytype_t[]{MEMORYTYPE_NONE, MEMORYTYPE_RAM, MEMORYTYPE_GPU, MEMORYTYPE_RAM_GPU};
    private static int swigNext = 0;
    private final int swigValue;
    private final String swigName;
    static /* synthetic */ Class class$de$esolutions$graphics$eal$memorytype_t;

    public final int swigValue() {
        return this.swigValue;
    }

    public String toString() {
        return this.swigName;
    }

    public static memorytype_t swigToEnum(int n) {
        if (n < swigValues.length && n >= 0 && memorytype_t.swigValues[n].swigValue == n) {
            return swigValues[n];
        }
        for (int i2 = 0; i2 < swigValues.length; ++i2) {
            if (memorytype_t.swigValues[i2].swigValue != n) continue;
            return swigValues[i2];
        }
        throw new IllegalArgumentException(new StringBuffer().append("No enum ").append(class$de$esolutions$graphics$eal$memorytype_t == null ? (class$de$esolutions$graphics$eal$memorytype_t = memorytype_t.class$("de.esolutions.graphics.eal.memorytype_t")) : class$de$esolutions$graphics$eal$memorytype_t).append(" with value ").append(n).toString());
    }

    private memorytype_t(String string) {
        this.swigName = string;
        this.swigValue = swigNext++;
    }

    private memorytype_t(String string, int n) {
        this.swigName = string;
        this.swigValue = n;
        swigNext = n + 1;
    }

    private memorytype_t(String string, memorytype_t memorytype_t2) {
        this.swigName = string;
        this.swigValue = memorytype_t2.swigValue;
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

