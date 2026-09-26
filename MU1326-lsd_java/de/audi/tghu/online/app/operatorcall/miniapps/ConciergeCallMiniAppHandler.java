/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.operatorcall.miniapps;

import de.audi.tghu.online.app.OnlineEnv;
import de.audi.tghu.online.app.operatorcall.abstractclasses.AbstractBaseModelHandler;
import de.audi.tghu.online.app.operatorcall.abstractclasses.AbstractOperatorCall;
import de.audi.tghu.online.app.operatorcall.miniapps.AbstractMiniAppHandler;
import de.audi.tghu.online.app.operatorcall.miniapps.ConciergeCallMiniAppModelHandler;

public class ConciergeCallMiniAppHandler
extends AbstractMiniAppHandler {
    public ConciergeCallMiniAppHandler(OnlineEnv onlineEnv, AbstractOperatorCall abstractOperatorCall) {
        super(onlineEnv, abstractOperatorCall);
    }

    @Override
    protected void initializeOptionModels() {
        this.option01 = -1877138688;
        this.option02 = -1759698176;
        this.option03 = -1860361472;
        this.option04 = -1910693120;
        this.option05 = -1826807040;
        this.option06 = -1776475392;
        this.option07 = -1927470336;
        this.option08 = -1692589312;
        this.option09 = -2128796928;
        this.option10 = -1961024768;
        this.option11 = -2078465280;
        this.option12 = -1977801984;
        this.option13 = -1742920960;
        this.option14 = -2044910848;
        this.option15 = -2028133632;
    }

    @Override
    protected void initializeTargetListModels() {
        this.historyCallList = 958210816;
        this.resultList = 1058874112;
    }

    @Override
    protected AbstractBaseModelHandler createModelHandler() {
        return new ConciergeCallMiniAppModelHandler(this.env, this.listener, this);
    }
}

