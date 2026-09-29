/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.templates;

import de.audi.app.messaging.core.templates.TemplateList;
import de.audi.app.messaging.core.templates.TemplateList$1;
import de.audi.atip.i18n.I18NTarget;
import de.audi.atip.i18n.Language;

class TemplateList$MyI18NTarget
implements I18NTarget {
    private final /* synthetic */ TemplateList this$0;

    private TemplateList$MyI18NTarget(TemplateList templateList) {
        this.this$0 = templateList;
    }

    @Override
    public void setLanguage(Language language) {
        if (TemplateList.access$800(this.this$0).isInfo()) {
            TemplateList.access$900(this.this$0).log(1078071040, "[TemplateList#setLanguage] language = %1", (Object)String.valueOf(language));
        }
        TemplateList.access$1000(this.this$0);
        TemplateList.access$1100(this.this$0);
    }

    /* synthetic */ TemplateList$MyI18NTarget(TemplateList templateList, TemplateList$1 templateList$1) {
        this(templateList);
    }
}

