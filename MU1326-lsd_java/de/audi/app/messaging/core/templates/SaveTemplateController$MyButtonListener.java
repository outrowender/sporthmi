/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.templates;

import de.audi.app.messaging.core.templates.SaveTemplateController;
import de.audi.app.messaging.core.templates.SaveTemplateController$1;
import de.audi.atip.hmi.model.DefaultButtonListener;

class SaveTemplateController$MyButtonListener
extends DefaultButtonListener {
    private final /* synthetic */ SaveTemplateController this$0;

    private SaveTemplateController$MyButtonListener(SaveTemplateController saveTemplateController) {
        this.this$0 = saveTemplateController;
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        if (n == -1533927168 || n == 1066606848) {
            SaveTemplateController.access$200(this.this$0, n, n3);
        } else if (n == -544071424) {
            SaveTemplateController.access$300(this.this$0, n, n3);
        } else if (n == -1701699328) {
            SaveTemplateController.access$400(this.this$0, n, n3);
        } else {
            SaveTemplateController.access$500(this.this$0).log(10000, "[SaveTemplateController#keyTyped] Unexpected modelID = %1", (long)n);
        }
    }

    /* synthetic */ SaveTemplateController$MyButtonListener(SaveTemplateController saveTemplateController, SaveTemplateController$1 saveTemplateController$1) {
        this(saveTemplateController);
    }
}

