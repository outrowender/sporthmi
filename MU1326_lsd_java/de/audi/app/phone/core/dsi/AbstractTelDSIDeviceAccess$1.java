/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi;

import de.audi.app.phone.core.dsi.AbstractTelDSIDeviceAccess;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.Monitor;

class AbstractTelDSIDeviceAccess$1
extends Monitor {
    private final /* synthetic */ int val$callID;
    private final /* synthetic */ AbstractTelDSIDeviceAccess this$0;

    AbstractTelDSIDeviceAccess$1(AbstractTelDSIDeviceAccess abstractTelDSIDeviceAccess, LogChannel logChannel, int n) {
        this.this$0 = abstractTelDSIDeviceAccess;
        this.val$callID = n;
        super(logChannel);
    }

    @Override
    public void prologue(CommandList commandList) {
        this.this$0.hangupMonitorMap.put(new Integer(this.val$callID), this);
        super.prologue(commandList);
    }

    @Override
    public void epilogue(CommandList commandList) {
        super.epilogue(commandList);
        this.this$0.hangupMonitorMap.remove(new Integer(this.val$callID));
    }
}

