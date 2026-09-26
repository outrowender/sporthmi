/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.swdiag;

import de.audi.app.car.common.swdiag.AbstractDiagnosisCommandSingleParam;

public abstract class AbstractDiagnosisCommandSingleParamBool
extends AbstractDiagnosisCommandSingleParam {
    protected AbstractDiagnosisCommandSingleParamBool(String string, String string2, int n, boolean bl) {
        super(string, string2, n, 1, new String[]{"true", "false"}, 0, 0, bl);
    }
}

