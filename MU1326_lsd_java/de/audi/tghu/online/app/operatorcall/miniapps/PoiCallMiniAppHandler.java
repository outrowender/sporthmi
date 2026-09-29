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

    @Override
    protected void initializeOptionModels() {
        this.option01 = -2011356416;
        this.option02 = -1810029824;
        this.option03 = -2095242496;
        this.option04 = 2115838720;
        this.option05 = -2112019712;
        this.option06 = -1843584256;
        this.option07 = -1726143744;
        this.option08 = -1994579200;
        this.option09 = -1793252608;
        this.option10 = -1944247552;
        this.option11 = -2145574144;
        this.option12 = -2061688064;
        this.option13 = 2132615936;
        this.option14 = -1709366528;
        this.option15 = -1893915904;
    }

    @Override
    protected void initializeTargetListModels() {
        this.historyCallList = -149150976;
        this.resultList = -165928192;
    }

    @Override
    protected AbstractBaseModelHandler createModelHandler() {
        return new PoiCallMiniAppModelHandler(this.env, this.listener, this);
    }
}

