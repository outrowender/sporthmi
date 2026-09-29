/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.templates;

import de.audi.app.messaging.core.templates.DeleteTemplateController;
import de.audi.app.messaging.core.templates.DeleteTemplateController$1;
import de.audi.atip.hmi.model.DefaultButtonListener;

class DeleteTemplateController$MyButtonListener
extends DefaultButtonListener {
    private final /* synthetic */ DeleteTemplateController this$0;

    private DeleteTemplateController$MyButtonListener(DeleteTemplateController deleteTemplateController) {
        this.this$0 = deleteTemplateController;
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        if (n == -745398016 || n == 1200824576) {
            DeleteTemplateController.access$200(this.this$0, n, n3);
        } else if (n == -711843584 || n == 1133715712) {
            DeleteTemplateController.access$300(this.this$0, n, n3);
        } else {
            DeleteTemplateController.access$400(this.this$0).log(10000, "[DeleteTemplateController#keyTyped] Unexpected modelID = %1", (long)n);
        }
    }

    /* synthetic */ DeleteTemplateController$MyButtonListener(DeleteTemplateController deleteTemplateController, DeleteTemplateController$1 deleteTemplateController$1) {
        this(deleteTemplateController);
    }
}

