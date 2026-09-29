/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.contactimport;

import de.audi.app.messaging.core.contactimport.ImportContactController;
import de.audi.app.messaging.core.contactimport.ImportContactController$1;
import de.audi.atip.hmi.model.DefaultButtonListener;

class ImportContactController$MyButtonListener
extends DefaultButtonListener {
    private final /* synthetic */ ImportContactController this$0;

    private ImportContactController$MyButtonListener(ImportContactController importContactController) {
        this.this$0 = importContactController;
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        if (n == 2022842624) {
            ImportContactController.access$900(this.this$0, n, n3);
        } else {
            ImportContactController.access$1000(this.this$0).log(10000, "[OptionsManager#keyTyped] Unexpected modelID = %1", (long)n);
        }
    }

    /* synthetic */ ImportContactController$MyButtonListener(ImportContactController importContactController, ImportContactController$1 importContactController$1) {
        this(importContactController);
    }
}

