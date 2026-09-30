/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.operatorcall;

import de.audi.atip.interapp.online.IOperatorCallNaviService;
import org.dsi.ifc.online.OperatorCallResult;

public interface INaviOperatorCallService {
    public void setContext(int var1);

    public void receiveEvent(OperatorCallResult var1, int var2);

    public void setOnlineOperatorCallService(IOperatorCallNaviService var1);
}

