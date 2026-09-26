/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.templates;

import de.audi.app.messaging.core.swdiagnosis.IDiagPlugIn;
import de.audi.app.messaging.core.templates.TemplateList;

final class TemplateList$DiagPlugIn
implements IDiagPlugIn {
    private final /* synthetic */ TemplateList this$0;

    TemplateList$DiagPlugIn(TemplateList templateList) {
        this.this$0 = templateList;
    }

    public Object getTemplateList() {
        return this.this$0;
    }
}

