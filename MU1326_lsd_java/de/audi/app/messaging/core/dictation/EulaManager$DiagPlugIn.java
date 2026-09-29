/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.dictation;

import de.audi.app.messaging.core.dictation.EulaManager;
import de.audi.app.messaging.core.swdiagnosis.IDiagPlugIn;

final class EulaManager$DiagPlugIn
implements IDiagPlugIn {
    private final /* synthetic */ EulaManager this$0;

    EulaManager$DiagPlugIn(EulaManager eulaManager) {
        this.this$0 = eulaManager;
    }

    public Object getEulaManager() {
        return this.this$0;
    }

    public void cmdEulaAccepted() {
        EulaManager.access$200(this.this$0, 1905402112, 0);
    }
}

