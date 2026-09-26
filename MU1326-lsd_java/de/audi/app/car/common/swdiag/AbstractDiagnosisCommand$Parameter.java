/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.swdiag;

import de.audi.app.car.common.swdiag.AbstractDiagnosisCommand;
import java.util.ArrayList;
import java.util.List;

class AbstractDiagnosisCommand$Parameter {
    public final String[] possibleValues;
    public final int type;
    public List parsedValues;
    public final boolean optional;
    public final int maxNumberOfValues;
    public int min = 128;
    public int max = -129;
    private final /* synthetic */ AbstractDiagnosisCommand this$0;

    public AbstractDiagnosisCommand$Parameter(AbstractDiagnosisCommand abstractDiagnosisCommand, String[] stringArray, int n, int n2, boolean bl) {
        this.this$0 = abstractDiagnosisCommand;
        this.possibleValues = stringArray;
        this.parsedValues = new ArrayList();
        this.type = n2;
        this.optional = bl;
        this.maxNumberOfValues = n;
    }
}

