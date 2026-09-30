/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw;

import de.audi.app.bap.fw.AbstractBAPModuleFSG;
import de.audi.app.bap.fw.AbstractFunctionList;
import de.audi.atip.base.IFrameworkAccess;

public abstract class AbstractFunctionListFSG
extends AbstractFunctionList {
    protected static final int AUDI_VARIANT_STD = 0;
    protected static final int AUDI_VARIANT_HIGH_PREM = 1;
    protected static final int AUDI_VARIANT_MMIKOMBI = 2;
    protected static final int AUDI_VARIANT_MMIKOMBI_HUD = 3;
    protected AbstractBAPModuleFSG moduleFsg;

    public void init(AbstractBAPModuleFSG abstractBAPModuleFSG) {
        this.moduleFsg = abstractBAPModuleFSG;
        IFrameworkAccess iFrameworkAccess = abstractBAPModuleFSG.getFrameworkAccess();
        boolean bl = iFrameworkAccess.getSysConstManager().getCarFuncAdaptation().isMenuDisplayActivated((short)22);
        int n = iFrameworkAccess.getKombiType() == 4 ? (bl ? 3 : 2) : (iFrameworkAccess.getSysConst(523) == 0 ? 0 : 1);
        int n2 = iFrameworkAccess.getSysConst(442);
        this.moduleFsg.getLogChannel().log(10000000, "[AbstractFunctionListFSG#AbstractFunctionListFSG] variant: %1 region: %2", (long)n, (long)n2);
        this.initFunctionListStatusWithVariantAndRegion(n, n2);
    }

    protected abstract void initFunctionListStatusWithVariantAndRegion(int var1, int var2);
}

