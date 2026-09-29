/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.evo.templates;

import de.audi.app.messaging.core.templates.ISaveTemplateControllerObserver$EmptyImplementation;
import de.audi.app.messaging.evo.templates.TemplateCreator;
import de.audi.app.messaging.evo.templates.TemplateCreator$1;

final class TemplateCreator$SaveTemplateControllerObserver
extends ISaveTemplateControllerObserver$EmptyImplementation {
    private final /* synthetic */ TemplateCreator this$0;

    private TemplateCreator$SaveTemplateControllerObserver(TemplateCreator templateCreator) {
        this.this$0 = templateCreator;
    }

    @Override
    public void responseSaveTemplate(long l, boolean bl) {
        if (TemplateCreator.access$1500(this.this$0).isDebug()) {
            TemplateCreator.access$1600(this.this$0).log(-2137614336, "[TemplateCreator#responseSaveTemplate] clientRequestId = %1, isResultOk = %2", (Object)String.valueOf(l), (Object)String.valueOf(bl));
        }
    }

    /* synthetic */ TemplateCreator$SaveTemplateControllerObserver(TemplateCreator templateCreator, TemplateCreator$1 templateCreator$1) {
        this(templateCreator);
    }
}

