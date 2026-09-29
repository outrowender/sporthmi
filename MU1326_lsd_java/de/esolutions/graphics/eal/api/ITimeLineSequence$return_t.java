/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal.api;

import de.esolutions.graphics.eal.api.ITimeLineSequence;
import de.esolutions.graphics.ealswigJNI;

public final class ITimeLineSequence$return_t {
    public static final ITimeLineSequence$return_t RETURN_INVALID = new ITimeLineSequence$return_t("RETURN_INVALID", ealswigJNI.eal_api_ITimeLineSequence_RETURN_INVALID_get());
    private static ITimeLineSequence$return_t[] swigValues = new ITimeLineSequence$return_t[]{RETURN_INVALID};
    private static int swigNext = 0;
    private final int swigValue;
    private final String swigName;

    public final int swigValue() {
        return this.swigValue;
    }

    public String toString() {
        return this.swigName;
    }

    public static ITimeLineSequence$return_t swigToEnum(int n) {
        if (n < swigValues.length && n >= 0 && ITimeLineSequence$return_t.swigValues[n].swigValue == n) {
            return swigValues[n];
        }
        for (int i2 = 0; i2 < swigValues.length; ++i2) {
            if (ITimeLineSequence$return_t.swigValues[i2].swigValue != n) continue;
            return swigValues[i2];
        }
        throw new IllegalArgumentException(new StringBuffer().append("No enum ").append(ITimeLineSequence.class$de$esolutions$graphics$eal$api$ITimeLineSequence$return_t == null ? (ITimeLineSequence.class$de$esolutions$graphics$eal$api$ITimeLineSequence$return_t = ITimeLineSequence.class$("de.esolutions.graphics.eal.api.ITimeLineSequence$return_t")) : ITimeLineSequence.class$de$esolutions$graphics$eal$api$ITimeLineSequence$return_t).append(" with value ").append(n).toString());
    }

    private ITimeLineSequence$return_t(String string) {
        this.swigName = string;
        this.swigValue = swigNext++;
    }

    private ITimeLineSequence$return_t(String string, int n) {
        this.swigName = string;
        this.swigValue = n;
        swigNext = n + 1;
    }

    private ITimeLineSequence$return_t(String string, ITimeLineSequence$return_t iTimeLineSequence$return_t) {
        this.swigName = string;
        this.swigValue = iTimeLineSequence$return_t.swigValue;
        swigNext = this.swigValue + 1;
    }
}

