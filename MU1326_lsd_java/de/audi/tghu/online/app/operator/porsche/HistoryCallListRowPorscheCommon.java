/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.operator.porsche;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tghu.online.app.operatorcall.data.AbstractHistoryCallListRow;
import java.util.Date;

public class HistoryCallListRowPorscheCommon
extends AbstractHistoryCallListRow {
    public HistoryCallListRowPorscheCommon(IFrameworkAccess iFrameworkAccess, String string, Date date, boolean bl, int n) {
        super(iFrameworkAccess, string, date, bl, n);
    }

    public HistoryCallListRowPorscheCommon(HistoryCallListRowPorscheCommon historyCallListRowPorscheCommon) {
        super(historyCallListRowPorscheCommon);
    }

    @Override
    public void createPropertyListCell(boolean bl) {
    }

    @Override
    public int getCategory() {
        return 0;
    }

    @Override
    public EvoListRow copy() {
        return new HistoryCallListRowPorscheCommon(this);
    }
}

