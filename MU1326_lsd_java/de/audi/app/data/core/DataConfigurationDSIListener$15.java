/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.data.core;

import de.audi.app.data.core.DataConfigurationDSIListener;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.networking.CPacketCounter;
import org.dsi.ifc.networking.DSIDataConfigurationListener;

class DataConfigurationDSIListener$15
extends CommandResponse {
    private final /* synthetic */ CPacketCounter val$pCounter;
    private final /* synthetic */ int val$validFlag;
    private final /* synthetic */ DataConfigurationDSIListener this$0;

    DataConfigurationDSIListener$15(DataConfigurationDSIListener dataConfigurationDSIListener, CPacketCounter cPacketCounter, int n) {
        this.this$0 = dataConfigurationDSIListener;
        this.val$pCounter = cPacketCounter;
        this.val$validFlag = n;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSIDataConfigurationListener)dSIListener).updatePacketCounter(this.val$pCounter, this.val$validFlag);
    }
}

