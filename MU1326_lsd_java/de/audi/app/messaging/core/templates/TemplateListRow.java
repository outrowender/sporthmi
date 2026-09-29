/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.templates;

import de.audi.app.messaging.core.templates.ITemplatePropertyFactory;
import de.audi.app.messaging.core.templates.TemplateListRow$LegacyListRow;
import de.audi.atip.hmi.model.list.EvoListRow;
import org.dsi.ifc.messaging.Template;

public final class TemplateListRow
extends EvoListRow {
    static final int COLUMN_COUNT;
    private static final int CELL_ID_TEMPLATE_TYPE;
    private static final int CELL_VALUE_TEMPLATE_TYPE_PREDEFINED;
    private static final int CELL_VALUE_TEMPLATE_TYPE_USER;
    private static final int CELL_ID_PREDEFINED_TEMPLATE_ID;
    private static final int CELL_ID_USER_TEMPLATE_TEXT;
    private static final int CELL_ID_ICON;
    private static final int CELL_IDX_PROPERTIES;
    private final Template template;
    private final int sequenceNumber;
    private final ITemplatePropertyFactory templatePropertyFactory;

    public TemplateListRow(Template template, int n, ITemplatePropertyFactory iTemplatePropertyFactory) {
        super(template.getId(), 5);
        this.template = template;
        this.sequenceNumber = n;
        this.templatePropertyFactory = iTemplatePropertyFactory;
        this.setInteger(0, TemplateListRow.getTemplateType(template));
        this.setInteger(1, template.getId() >= 0 ? 0 : template.getId() * -1);
        this.setText(2, template.getBody());
        this.setInteger(3, TemplateListRow.getIconId(template, n));
        this.setPropertyCell(4, iTemplatePropertyFactory.create(template));
    }

    @Override
    public EvoListRow copy() {
        return new TemplateListRow(this.template, this.sequenceNumber, this.templatePropertyFactory);
    }

    private static int getTemplateType(Template template) {
        return template.isReadOnly() ? 0 : 1;
    }

    private static int getIconId(Template template, int n) {
        int n2 = 0;
        n2 = TemplateListRow.getTemplateType(template) == 0 ? n % 10 : n % 10 + 10;
        return n2;
    }

    public Template getTemplate() {
        return this.template;
    }

    @Override
    public boolean equals(Object object) {
        boolean bl = false;
        try {
            int n = ((TemplateListRow)object).getTemplate().getId();
            int n2 = this.getTemplate().getId();
            bl = n == n2;
        }
        catch (Exception exception) {
            bl = false;
        }
        return bl;
    }

    @Override
    public int hashCode() {
        return this.getTemplate().getId();
    }

    TemplateListRow$LegacyListRow asLegacyListRow() {
        return new TemplateListRow$LegacyListRow(this, null);
    }
}

