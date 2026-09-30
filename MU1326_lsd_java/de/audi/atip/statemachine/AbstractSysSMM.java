/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.statemachine;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.statemachine.AbstractSMM;
import de.audi.atip.statemachine.ApplicationSMM;
import de.audi.atip.statemachine.SystemSMM;

public abstract class AbstractSysSMM
extends AbstractSMM
implements SystemSMM {
    protected int[] smmSlotList;
    protected int[] smmSlotModuleIDList;

    public AbstractSysSMM(IFrameworkAccess iFrameworkAccess, int n, String string, int n2, String string2) {
        super(iFrameworkAccess, n, string, 0, n2, string2);
    }

    public AbstractSysSMM(IFrameworkAccess iFrameworkAccess, int n, String string, int n2, int n3, String string2) {
        super(iFrameworkAccess, n, string, n2, n3, string2);
        if (this.smmSlotList == null) {
            this.smmSlotList = EMPTY_INT_LIST;
        }
        if (this.smmSlotModuleIDList == null) {
            this.smmSlotModuleIDList = EMPTY_INT_LIST;
        }
    }

    protected abstract void init();

    public void registerSMM(ApplicationSMM applicationSMM) {
        for (int i2 = 0; i2 < this.smmSlotList.length; ++i2) {
            if (applicationSMM.getModuleID() != this.smmSlotModuleIDList[i2]) continue;
            this.logChannel.log(1000000, "[AbstractSysSMM#registerSMM] [%1] register AppSMM-%3, module '%2'.", (Object)this.terminalName, (Object)applicationSMM.getSMMName(), (long)applicationSMM.getModuleID());
            applicationSMM.setTopLevelSuperstate(this.smmSlotList[i2]);
            break;
        }
    }

    public void deregisterSMM(ApplicationSMM applicationSMM) {
        this.logChannel.log(1000000, "[AbstractSysSMM#deregisterSMM] [%1] deregister AppSMM-%3, module '%2'.", (Object)this.terminalName, (Object)applicationSMM.getSMMName(), (long)applicationSMM.getModuleID());
        applicationSMM.setTopLevelSuperstate(-10);
    }
}

