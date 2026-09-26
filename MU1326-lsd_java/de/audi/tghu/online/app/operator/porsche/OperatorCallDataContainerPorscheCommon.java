/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.operator.porsche;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.tghu.online.app.operator.porsche.HistoryCallDataPorscheCommon;
import de.audi.tghu.online.app.operatorcall.data.AbstractHistoryCallData;
import de.audi.tghu.online.app.operatorcall.data.AbstractOperatorCallDataContainer;
import de.audi.tghu.online.app.operatorcall.handler.NavigationHandler;
import de.audi.tghu.online.app.operatorcall.truffle.IntelliDestOperatorCallDataProvider;
import java.util.Date;
import org.dsi.ifc.online.OperatorCallResult;

public class OperatorCallDataContainerPorscheCommon
extends AbstractOperatorCallDataContainer {
    public OperatorCallDataContainerPorscheCommon(String string, IFrameworkAccess iFrameworkAccess, NavigationHandler navigationHandler, IntelliDestOperatorCallDataProvider intelliDestOperatorCallDataProvider, boolean bl, boolean bl2, int n, int n2) {
        super(string, iFrameworkAccess, navigationHandler, intelliDestOperatorCallDataProvider, bl, true, n, n2);
    }

    @Override
    protected AbstractHistoryCallData createNewHistoryCallData(OperatorCallResult[] operatorCallResultArray, String string, Date date) {
        return new HistoryCallDataPorscheCommon(this.framework, this.naviHandler, operatorCallResultArray, this.calls, string, date);
    }
}

