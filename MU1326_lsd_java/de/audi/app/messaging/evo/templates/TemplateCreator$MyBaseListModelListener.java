/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.evo.templates;

import de.audi.app.messaging.core.templates.TemplateListRow;
import de.audi.app.messaging.evo.templates.TemplateCreator;
import de.audi.app.messaging.evo.templates.TemplateCreator$1;
import de.audi.atip.hmi.model.list.DefaultBaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import org.dsi.ifc.messaging.Template;

final class TemplateCreator$MyBaseListModelListener
extends DefaultBaseListModelListener {
    private final /* synthetic */ TemplateCreator this$0;

    private TemplateCreator$MyBaseListModelListener(TemplateCreator templateCreator) {
        this.this$0 = templateCreator;
    }

    @Override
    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        TemplateCreator.access$800(this.this$0).log(1078071040, "[TemplateCreator#itemSelected] row = %1", (Object)evoListRow);
        Template template = ((TemplateListRow)evoListRow).getTemplate();
        TemplateCreator.access$900(this.this$0, template);
        TemplateCreator.access$1000(this.this$0).getHmiServiceApp().getModelApp(n).fireEvent(n4);
    }

    @Override
    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        TemplateCreator.access$1100(this.this$0).log(1078071040, "[TemplateCreator#itemFocused] row = %1", (Object)evoListRow);
        Template template = ((TemplateListRow)evoListRow).getTemplate();
        TemplateCreator.access$1200(this.this$0).getNewMessage().getDeleteTemplateController().setDeleteCandidate(template);
    }

    /* synthetic */ TemplateCreator$MyBaseListModelListener(TemplateCreator templateCreator, TemplateCreator$1 templateCreator$1) {
        this(templateCreator);
    }
}

