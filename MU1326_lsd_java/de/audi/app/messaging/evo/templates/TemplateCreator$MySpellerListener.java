/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.evo.templates;

import de.audi.app.messaging.evo.templates.TemplateCreator;
import de.audi.app.messaging.evo.templates.TemplateCreator$1;
import de.audi.atip.hmi.model.listener.DefaultSpellerListener;

class TemplateCreator$MySpellerListener
extends DefaultSpellerListener {
    private final /* synthetic */ TemplateCreator this$0;

    private TemplateCreator$MySpellerListener(TemplateCreator templateCreator) {
        this.this$0 = templateCreator;
    }

    @Override
    public void textChanged(int n, String string, char c2, int n2) {
        TemplateCreator.access$1300(this.this$0).log(-2137614336, "[TemplateCreator#textChanged] text = %1", (Object)string);
        TemplateCreator.access$1400(this.this$0).setText(string);
    }

    /* synthetic */ TemplateCreator$MySpellerListener(TemplateCreator templateCreator, TemplateCreator$1 templateCreator$1) {
        this(templateCreator);
    }
}

