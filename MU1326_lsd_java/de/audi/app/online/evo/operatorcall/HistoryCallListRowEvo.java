/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo.operatorcall;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.model.PropertyListCell;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tghu.online.app.operatorcall.data.AbstractHistoryCallListRow;
import java.util.Date;

public class HistoryCallListRowEvo
extends AbstractHistoryCallListRow {
    private final int COLUMN_CATEGORY;

    public HistoryCallListRowEvo(IFrameworkAccess iFrameworkAccess, String string, Date date, boolean bl, int n) {
        super(iFrameworkAccess, string, date, bl, n);
        this.COLUMN_CATEGORY = 4;
    }

    @Override
    public void createPropertyListCell(boolean bl) {
        int n = bl ? 1131354138 : -727859341;
        this.setPropertyCell(4, new PropertyListCell(n, new int[0]));
    }

    @Override
    public int getCategory() {
        PropertyListCell propertyListCell = (PropertyListCell)this.getCell(4);
        return propertyListCell.getCategory();
    }

    @Override
    public EvoListRow copy() {
        return new HistoryCallListRowEvo(this);
    }

    public HistoryCallListRowEvo(HistoryCallListRowEvo historyCallListRowEvo) {
        super(historyCallListRowEvo);
        this.COLUMN_CATEGORY = 4;
    }
}

