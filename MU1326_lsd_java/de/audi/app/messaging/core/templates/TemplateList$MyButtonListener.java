/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.templates;

import de.audi.app.messaging.core.templates.TemplateList;
import de.audi.app.messaging.core.templates.TemplateList$1;
import de.audi.atip.hmi.model.DefaultButtonListener;

class TemplateList$MyButtonListener
extends DefaultButtonListener {
    private final /* synthetic */ TemplateList this$0;

    private TemplateList$MyButtonListener(TemplateList templateList) {
        this.this$0 = templateList;
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        if (n == -946724608) {
            TemplateList.access$500(this.this$0, n, n3);
        } else {
            TemplateList.access$600(this.this$0).log(10000, "[TemplateList#keyTyped] Unexpected modelID = %1", (long)n);
        }
    }

    /* synthetic */ TemplateList$MyButtonListener(TemplateList templateList, TemplateList$1 templateList$1) {
        this(templateList);
    }
}

