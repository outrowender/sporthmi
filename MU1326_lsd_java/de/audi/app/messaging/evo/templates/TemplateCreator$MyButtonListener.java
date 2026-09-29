/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.evo.templates;

import de.audi.app.messaging.evo.templates.TemplateCreator;
import de.audi.app.messaging.evo.templates.TemplateCreator$1;
import de.audi.atip.hmi.model.DefaultButtonListener;

final class TemplateCreator$MyButtonListener
extends DefaultButtonListener {
    private final /* synthetic */ TemplateCreator this$0;

    private TemplateCreator$MyButtonListener(TemplateCreator templateCreator) {
        this.this$0 = templateCreator;
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        if (n == 1939022080) {
            TemplateCreator.access$500(this.this$0, n, n3);
        } else if (n == 1922244864) {
            TemplateCreator.access$600(this.this$0, n, n3);
        } else {
            TemplateCreator.access$700(this.this$0).log(10000, "[TemplateCreator#keyTyped] Unexpected modelID = %1", (long)n);
        }
    }

    /* synthetic */ TemplateCreator$MyButtonListener(TemplateCreator templateCreator, TemplateCreator$1 templateCreator$1) {
        this(templateCreator);
    }
}

