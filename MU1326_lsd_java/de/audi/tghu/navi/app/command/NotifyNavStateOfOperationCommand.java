/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.base.DSIListener;

public class NotifyNavStateOfOperationCommand
extends NavCommand {
    private boolean waitForFullyOperable = false;

    public NotifyNavStateOfOperationCommand(boolean bl) {
        this.waitForFullyOperable = bl;
    }

    public long getTimeout() {
        return this.waitForFullyOperable ? -1L : super.getTimeout();
    }

    public void execute() {
        this.logger.log(10000000, "NotifyNavStateOfOperationCommand#execute() - command setNotification() for ATTR_NAVSTATEOFOPERATION ");
        this.getDSINavigation().setNotification(new int[]{52}, (DSIListener)this.getDispatcher());
    }

    public void updateNavstateOfOperation(int n) {
        this.logger.log(10000000, "NotifyNavStateOfOperationCommand#updateNavstateOfOperation( %1 ) ", (long)n);
        super.updateNavstateOfOperation(n);
        if (this.waitForFullyOperable) {
            if (n == 5) {
                this.logger.log(10000000, "NotifyNavStateOfOperationCommand#updateNavstateOfOperation() - navigation is fully operable ");
                Util.logStartupEvent(this.env.getFramework(), "[Startup] NotifyNavStateOfOperationCommand#updateNavstateOfOperation() - navigation is fully operable ");
                this.navigation.getOperationManager().taskCompleted(2);
                this.getCommandList().commandFinished();
            }
        } else {
            this.getCommandList().commandFinished();
        }
    }
}

