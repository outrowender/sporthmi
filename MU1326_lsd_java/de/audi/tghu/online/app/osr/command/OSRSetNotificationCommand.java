/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr.command;

import de.audi.tghu.online.app.osr.command.AbstractOSRCommand;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.online.OSRServiceState;

public class OSRSetNotificationCommand
extends AbstractOSRCommand {
    private static final int[] OSR_ATTRIBUTES = new int[]{1, 5, 3, 4, 6};

    @Override
    public void execute() {
        this.logger.log(-2137614336, "ORSSetNotificationCommand#execute() - call method setNotification( %1 )", (Object)OSR_ATTRIBUTES);
        this.getDSI().setNotification(OSR_ATTRIBUTES, (DSIListener)this.application.getDSIListener());
        this.getCommandList().commandFinished();
    }

    public void updateServiceList(OSRServiceState[] oSRServiceStateArray, int n) {
    }
}

