/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.operatorcall;

import de.audi.atip.interapp.online.IOperatorCallNaviService;
import org.dsi.ifc.online.OperatorCallResult;

public interface INaviOperatorCallService {
    default public void setContext(int n) {
    }

    default public void receiveEvent(OperatorCallResult operatorCallResult, int n) {
    }

    default public void setOnlineOperatorCallService(IOperatorCallNaviService iOperatorCallNaviService) {
    }
}

