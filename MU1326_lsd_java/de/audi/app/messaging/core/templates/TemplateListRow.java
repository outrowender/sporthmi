/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.templates;

import de.audi.app.messaging.core.templates.ITemplatePropertyFactory;
import de.audi.atip.hmi.model.IntegerListCell;
import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.model.ListRow;
import de.audi.atip.hmi.model.PropertyListCell;
import de.audi.atip.hmi.model.TextListCell;
import de.audi.atip.hmi.model.list.EvoListRow;
import org.dsi.ifc.messaging.Template;

public final class TemplateListRow
extends EvoListRow {
    static final int COLUMN_COUNT = 5;
    private static final int CELL_ID_TEMPLATE_TYPE = 0;
    private static final int CELL_VALUE_TEMPLATE_TYPE_PREDEFINED = 0;
    private static final int CELL_VALUE_TEMPLATE_TYPE_USER = 1;
    private static final int CELL_ID_PREDEFINED_TEMPLATE_ID = 1;
    private static final int CELL_ID_USER_TEMPLATE_TEXT = 2;
    private static final int CELL_ID_ICON = 3;
    private static final int CELL_IDX_PROPERTIES = 4;
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

    public int hashCode() {
        return this.getTemplate().getId();
    }

    LegacyListRow asLegacyListRow() {
        return new LegacyListRow();
    }

    final class LegacyListRow
    extends ListRow {
        private LegacyListRow() {
            ListCell[] listCellArray = new ListCell[]{IntegerListCell.create(TemplateListRow.this.getInteger(0)), IntegerListCell.create(TemplateListRow.this.getInteger(1)), TextListCell.create(TemplateListRow.this.getText(2)), IntegerListCell.create(TemplateListRow.this.getInteger(3)), (PropertyListCell)TemplateListRow.this.getCell(4)};
            this.setCells(listCellArray);
        }

        public TemplateListRow asTemplateListRow() {
            return TemplateListRow.this;
        }

        public boolean equals(Object object) {
            boolean bl = false;
            try {
                LegacyListRow legacyListRow = (LegacyListRow)object;
                TemplateListRow templateListRow = legacyListRow.asTemplateListRow();
                bl = TemplateListRow.this.equals(templateListRow);
            }
            catch (Exception exception) {
                bl = false;
            }
            return bl;
        }

        public int hashCode() {
            return TemplateListRow.this.hashCode();
        }
    }
}

