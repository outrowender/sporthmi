/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.tghu.online.app.remotehmi.DiagnosisComponent;
import de.audi.tghu.online.app.remotehmi.DiagnosisComponent$1;

abstract class DiagnosisComponent$AbstractDiagnosisPlugin {
    private final /* synthetic */ DiagnosisComponent this$0;

    private DiagnosisComponent$AbstractDiagnosisPlugin(DiagnosisComponent diagnosisComponent) {
        this.this$0 = diagnosisComponent;
    }

    public abstract void update(Object object, int n) {
    }

    /* synthetic */ DiagnosisComponent$AbstractDiagnosisPlugin(DiagnosisComponent diagnosisComponent, DiagnosisComponent$1 diagnosisComponent$1) {
        this(diagnosisComponent);
    }
}

