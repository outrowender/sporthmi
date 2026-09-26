/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.dictation;

import de.audi.app.messaging.core.dictation.EulaManager;
import de.audi.app.messaging.core.dictation.EulaManager$1;
import de.audi.atip.hmi.model.DefaultButtonListener;

class EulaManager$MyButtonListener
extends DefaultButtonListener {
    private final /* synthetic */ EulaManager this$0;

    private EulaManager$MyButtonListener(EulaManager eulaManager) {
        this.this$0 = eulaManager;
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        if (n == 1905402112) {
            EulaManager.access$200(this.this$0, n, n3);
        } else {
            EulaManager.access$300(this.this$0).log(10000, "[EulaManager#keyTyped] Unexpected modelID = %1", (long)n);
        }
    }

    /* synthetic */ EulaManager$MyButtonListener(EulaManager eulaManager, EulaManager$1 eulaManager$1) {
        this(eulaManager);
    }
}

