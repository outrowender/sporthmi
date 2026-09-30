/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.operatorcall.miniapps;

import de.audi.tghu.online.app.OnlineEnv;
import de.audi.tghu.online.app.operatorcall.abstractclasses.AbstractBaseModelHandler;
import de.audi.tghu.online.app.operatorcall.abstractclasses.AbstractOperatorCall;
import de.audi.tghu.online.app.operatorcall.miniapps.AbstractMiniAppHandler;
import de.audi.tghu.online.app.operatorcall.miniapps.PoiCallMiniAppModelHandler;

public class PoiCallMiniAppHandler
extends AbstractMiniAppHandler {
    public PoiCallMiniAppHandler(OnlineEnv onlineEnv, AbstractOperatorCall abstractOperatorCall) {
        super(onlineEnv, abstractOperatorCall);
    }

    protected void initializeOptionModels() {
        this.option01 = 2301320;
        this.option02 = 2301332;
        this.option03 = 2301315;
        this.option04 = 2301310;
        this.option05 = 2301314;
        this.option06 = 2301330;
        this.option07 = 2301337;
        this.option08 = 2301321;
        this.option09 = 2301333;
        this.option10 = 2301324;
        this.option11 = 2301312;
        this.option12 = 2301317;
        this.option13 = 2301311;
        this.option14 = 2301338;
        this.option15 = 2301327;
    }

    protected void initializeTargetListModels() {
        this.historyCallList = 2301175;
        this.resultList = 2301174;
    }

    protected AbstractBaseModelHandler createModelHandler() {
        return new PoiCallMiniAppModelHandler(this.env, this.listener, this);
    }
}

