/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw;

import de.audi.app.bap.fw.AbstractBAPModuleASG;
import de.audi.app.bap.fw.AbstractFunctionList;
import de.vw.mib.bap.requests.StatusProperty;

public abstract class AbstractFunctionListASG
extends AbstractFunctionList {
    protected AbstractBAPModuleASG moduleAsg;

    public void init(AbstractBAPModuleASG abstractBAPModuleASG) {
        this.moduleAsg = abstractBAPModuleASG;
        this.functionSupported = new boolean[this.getMaxFctID() + 1];
        this.functionSupported[this.getGetAllFctID()] = true;
        this.functionSupported[this.getBAPConfigBAPFctID()] = true;
        this.functionSupported[this.getFctListBAPFctID()] = true;
    }

    public abstract void setFunctionListConfiguration(StatusProperty var1);
}

