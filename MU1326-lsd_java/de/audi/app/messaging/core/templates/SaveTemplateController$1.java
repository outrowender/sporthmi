/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.templates;

import de.audi.app.messaging.core.templates.ChangeTemplateCommand$ResultHandler;
import de.audi.app.messaging.core.templates.SaveTemplateController;

class SaveTemplateController$1
implements ChangeTemplateCommand$ResultHandler {
    private final /* synthetic */ SaveTemplateController this$0;

    SaveTemplateController$1(SaveTemplateController saveTemplateController) {
        this.this$0 = saveTemplateController;
    }

    @Override
    public void handleResult(long l, boolean bl) {
        SaveTemplateController.access$000(this.this$0, l, bl);
    }
}

