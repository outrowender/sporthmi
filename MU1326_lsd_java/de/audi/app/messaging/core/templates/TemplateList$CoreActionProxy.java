/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.templates;

import de.audi.app.messaging.core.guide.DefaultCoreActionProxy;
import de.audi.app.messaging.core.guide.IActionProxySubscriber;
import de.audi.app.messaging.core.templates.TemplateList;
import de.audi.app.messaging.core.templates.TemplateList$1;

final class TemplateList$CoreActionProxy
extends DefaultCoreActionProxy
implements IActionProxySubscriber {
    private final /* synthetic */ TemplateList this$0;

    private TemplateList$CoreActionProxy(TemplateList templateList) {
        this.this$0 = templateList;
    }

    @Override
    public void templateReplacementExited(int n) {
        TemplateList.access$700(this.this$0).log(-2137614336, "[TemplateList#templateReplacementExited]");
        this.this$0.setReplaceMode(false);
    }

    /* synthetic */ TemplateList$CoreActionProxy(TemplateList templateList, TemplateList$1 templateList$1) {
        this(templateList);
    }
}

