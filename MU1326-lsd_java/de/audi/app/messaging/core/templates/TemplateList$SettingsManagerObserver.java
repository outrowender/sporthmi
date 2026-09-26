/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.templates;

import de.audi.app.messaging.core.settings.ISettingsManagerObserver;
import de.audi.app.messaging.core.templates.TemplateList;
import de.audi.app.messaging.core.templates.TemplateList$1;

class TemplateList$SettingsManagerObserver
implements ISettingsManagerObserver {
    private final /* synthetic */ TemplateList this$0;

    private TemplateList$SettingsManagerObserver(TemplateList templateList) {
        this.this$0 = templateList;
    }

    @Override
    public void indicateResetToFactorySettings() {
        TemplateList.access$1200(this.this$0).log(-2137614336, "[TemplateList#indicateResetToFactorySettings]");
        TemplateList.access$1300(this.this$0);
    }

    /* synthetic */ TemplateList$SettingsManagerObserver(TemplateList templateList, TemplateList$1 templateList$1) {
        this(templateList);
    }
}

