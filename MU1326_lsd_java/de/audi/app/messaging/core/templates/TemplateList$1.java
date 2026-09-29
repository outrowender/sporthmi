/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.templates;

import de.audi.app.messaging.core.dsi.IDsiAccessClient;
import de.audi.app.messaging.core.templates.TemplateList;

class TemplateList$1
implements IDsiAccessClient {
    private final /* synthetic */ TemplateList this$0;

    TemplateList$1(TemplateList templateList) {
        this.this$0 = templateList;
    }

    @Override
    public void updateDsiAvailability(boolean bl) {
        TemplateList.access$300(this.this$0).log(-2137614336, "[TemplateList#updateDsiAvailability] %1 ", bl);
        if (bl) {
            this.this$0.loadTemplates();
        }
    }
}

