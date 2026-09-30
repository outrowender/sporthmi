/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.operator.porsche;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.tghu.online.app.operator.porsche.HistoryCallListRowPorscheCommon;
import de.audi.tghu.online.app.operatorcall.data.AbstractHistoryCallData;
import de.audi.tghu.online.app.operatorcall.data.AbstractHistoryCallListRow;
import de.audi.tghu.online.app.operatorcall.handler.NavigationHandler;
import java.util.ArrayList;
import java.util.Date;
import org.dsi.ifc.online.OperatorCallResult;

public class HistoryCallDataPorscheCommon
extends AbstractHistoryCallData {
    public HistoryCallDataPorscheCommon(IFrameworkAccess iFrameworkAccess, NavigationHandler navigationHandler, OperatorCallResult[] operatorCallResultArray, ArrayList arrayList, String string, Date date) {
        super(iFrameworkAccess, navigationHandler, operatorCallResultArray, arrayList, string, date);
    }

    protected AbstractHistoryCallListRow createHistoryCallListRow(boolean bl) {
        return new HistoryCallListRowPorscheCommon(this.framework, "call", this.dateTime, bl, this.operatorCallResults.length);
    }
}

