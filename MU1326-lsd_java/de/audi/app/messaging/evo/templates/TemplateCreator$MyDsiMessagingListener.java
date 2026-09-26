/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.evo.templates;

import de.audi.app.messaging.core.dsi.messaging.DsiMessagingEmptyListener;
import de.audi.app.messaging.core.templates.ITemplatePropertyFactory;
import de.audi.app.messaging.core.templates.TemplateListRow;
import de.audi.app.messaging.evo.templates.TemplateCreator;
import de.audi.app.messaging.evo.templates.TemplateCreator$1;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import org.dsi.ifc.messaging.Template;

class TemplateCreator$MyDsiMessagingListener
extends DsiMessagingEmptyListener {
    private final /* synthetic */ TemplateCreator this$0;

    private TemplateCreator$MyDsiMessagingListener(TemplateCreator templateCreator) {
        this.this$0 = templateCreator;
    }

    @Override
    public void getTemplatesResponse(int n, Template[] templateArray) {
        TemplateCreator.access$1700(this.this$0).log(-2137614336, "[TemplateCreator#getTemplatesResponse]");
        if (n == 0) {
            ITemplatePropertyFactory iTemplatePropertyFactory = TemplateCreator.access$1800(this.this$0).getTemplateList().getTemplatePropertyFactory();
            BaseListModelApp baseListModelApp = TemplateCreator.access$1900(this.this$0).getCopy();
            baseListModelApp.removeAll();
            for (int i2 = 0; i2 < templateArray.length; ++i2) {
                TemplateListRow templateListRow = new TemplateListRow(templateArray[i2], i2, iTemplatePropertyFactory);
                baseListModelApp.append(templateListRow);
            }
            TemplateCreator.access$1900(this.this$0).update(baseListModelApp);
        }
    }

    /* synthetic */ TemplateCreator$MyDsiMessagingListener(TemplateCreator templateCreator, TemplateCreator$1 templateCreator$1) {
        this(templateCreator);
    }
}

