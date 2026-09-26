/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo.operatorcall;

import de.audi.app.online.evo.operatorcall.HistoryCallListRowEvo;
import de.audi.app.online.evo.operatorcall.PoiResultListRowEvo;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.tghu.online.app.operatorcall.data.AbstractHistoryCallData;
import de.audi.tghu.online.app.operatorcall.data.AbstractHistoryCallListRow;
import de.audi.tghu.online.app.operatorcall.data.PoiResultListRow;
import de.audi.tghu.online.app.operatorcall.handler.NavigationHandler;
import java.util.ArrayList;
import java.util.Date;
import org.dsi.ifc.online.OperatorCallResult;

public class HistoryCallDataEvo
extends AbstractHistoryCallData {
    public HistoryCallDataEvo(IFrameworkAccess iFrameworkAccess, NavigationHandler navigationHandler, OperatorCallResult[] operatorCallResultArray, ArrayList arrayList, String string, Date date) {
        super(iFrameworkAccess, navigationHandler, operatorCallResultArray, arrayList, string, date);
    }

    @Override
    protected AbstractHistoryCallListRow createHistoryCallListRow(boolean bl) {
        return new HistoryCallListRowEvo(this.framework, this.name, this.dateTime, bl, this.operatorCallResults.length);
    }

    @Override
    protected PoiResultListRow createNewPoiResultListRow(OperatorCallResult operatorCallResult) {
        return new PoiResultListRowEvo(operatorCallResult, this.naviHandler, this);
    }
}

