/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.swdiag;

import de.audi.app.car.common.swdiag.AbstractDiagnosisCommandSingleParam;

public abstract class AbstractDiagnosisCommandSingleParamInt
extends AbstractDiagnosisCommandSingleParam {
    public AbstractDiagnosisCommandSingleParamInt(String string, String string2, int n, String[] stringArray, boolean bl) {
        super(string, string2, n, 0, stringArray, 0, 0, bl);
    }

    public AbstractDiagnosisCommandSingleParamInt(String string, String string2, int n, boolean bl) {
        super(string, string2, n, 2, null, 128, -129, bl);
    }

    public AbstractDiagnosisCommandSingleParamInt(String string, String string2, int n, int n2, int n3, boolean bl) {
        super(string, string2, n, 2, null, n2, n3, bl);
    }
}

