/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command;

import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.base.DSIListener;

public class SetNotificationCommand
extends NavCommand {
    private int[] attributes;

    public SetNotificationCommand(int[] nArray) {
        this.attributes = nArray;
    }

    public void execute() {
        if (this.attributes != null && this.attributes.length > 0) {
            this.logger.log(10000000, "NotifyRestCommand#execute() - calling setNotification( %1 )", (long)this.attributes.length);
            this.getDSINavigation().setNotification(this.attributes, (DSIListener)this.getDispatcher());
        }
        this.getCommandList().commandFinished();
    }
}

