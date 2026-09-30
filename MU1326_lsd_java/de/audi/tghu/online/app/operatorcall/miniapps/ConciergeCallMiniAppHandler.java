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

    protected void initializeOptionModels() {
        this.option01 = 2301328;
        this.option02 = 2301335;
        this.option03 = 2301329;
        this.option04 = 2301326;
        this.option05 = 2301331;
        this.option06 = 2301334;
        this.option07 = 2301325;
        this.option08 = 2301339;
        this.option09 = 2301313;
        this.option10 = 2301323;
        this.option11 = 2301316;
        this.option12 = 2301322;
        this.option13 = 2301336;
        this.option14 = 2301318;
        this.option15 = 2301319;
    }

    protected void initializeTargetListModels() {
        this.historyCallList = 2301241;
        this.resultList = 2301247;
    }

    protected AbstractBaseModelHandler createModelHandler() {
        return new ConciergeCallMiniAppModelHandler(this.env, this.listener, this);
    }
}

