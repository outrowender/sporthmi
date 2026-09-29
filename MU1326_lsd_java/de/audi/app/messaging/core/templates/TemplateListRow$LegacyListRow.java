/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.templates;

import de.audi.app.messaging.core.templates.TemplateListRow;
import de.audi.app.messaging.core.templates.TemplateListRow$1;
import de.audi.atip.hmi.model.IntegerListCell;
import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.model.ListRow;
import de.audi.atip.hmi.model.PropertyListCell;
import de.audi.atip.hmi.model.TextListCell;

final class TemplateListRow$LegacyListRow
extends ListRow {
    private final /* synthetic */ TemplateListRow this$0;

    private TemplateListRow$LegacyListRow(TemplateListRow templateListRow) {
        this.this$0 = templateListRow;
        ListCell[] listCellArray = new ListCell[]{IntegerListCell.create(templateListRow.getInteger(0)), IntegerListCell.create(templateListRow.getInteger(1)), TextListCell.create(templateListRow.getText(2)), IntegerListCell.create(templateListRow.getInteger(3)), (PropertyListCell)templateListRow.getCell(4)};
        this.setCells(listCellArray);
    }

    public TemplateListRow asTemplateListRow() {
        return this.this$0;
    }

    @Override
    public boolean equals(Object object) {
        boolean bl = false;
        try {
            TemplateListRow$LegacyListRow templateListRow$LegacyListRow = (TemplateListRow$LegacyListRow)object;
            TemplateListRow templateListRow = templateListRow$LegacyListRow.asTemplateListRow();
            bl = this.this$0.equals(templateListRow);
        }
        catch (Exception exception) {
            bl = false;
        }
        return bl;
    }

    @Override
    public int hashCode() {
        return this.this$0.hashCode();
    }

    /* synthetic */ TemplateListRow$LegacyListRow(TemplateListRow templateListRow, TemplateListRow$1 templateListRow$1) {
        this(templateListRow);
    }
}

