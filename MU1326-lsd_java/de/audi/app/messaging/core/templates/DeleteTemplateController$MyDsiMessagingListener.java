/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.templates;

import de.audi.app.messaging.core.dsi.messaging.DsiMessagingEmptyListener;
import de.audi.app.messaging.core.templates.DeleteTemplateController;
import de.audi.app.messaging.core.templates.DeleteTemplateController$1;
import org.dsi.ifc.messaging.Template;

class DeleteTemplateController$MyDsiMessagingListener
extends DsiMessagingEmptyListener {
    private final /* synthetic */ DeleteTemplateController this$0;

    private DeleteTemplateController$MyDsiMessagingListener(DeleteTemplateController deleteTemplateController) {
        this.this$0 = deleteTemplateController;
    }

    @Override
    public void getTemplatesResponse(int n, Template[] templateArray) {
        DeleteTemplateController.access$500(this.this$0).log(-2137614336, "[DeleteTemplateController#getTemplatesResponse]");
        if (n == 0) {
            DeleteTemplateController.access$600(this.this$0, templateArray);
        }
    }

    /* synthetic */ DeleteTemplateController$MyDsiMessagingListener(DeleteTemplateController deleteTemplateController, DeleteTemplateController$1 deleteTemplateController$1) {
        this(deleteTemplateController);
    }
}

