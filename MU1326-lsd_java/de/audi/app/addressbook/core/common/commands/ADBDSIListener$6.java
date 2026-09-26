/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.common.commands;

import de.audi.app.addressbook.core.common.commands.ADBDSIListener;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.organizer.AdbViewSize;
import org.dsi.ifc.organizer.DSIAdbListListener;

class ADBDSIListener$6
extends CommandResponse {
    private final /* synthetic */ AdbViewSize val$viewSize;
    private final /* synthetic */ int val$validFlag;
    private final /* synthetic */ ADBDSIListener this$0;

    ADBDSIListener$6(ADBDSIListener aDBDSIListener, AdbViewSize adbViewSize, int n) {
        this.this$0 = aDBDSIListener;
        this.val$viewSize = adbViewSize;
        this.val$validFlag = n;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSIAdbListListener)dSIListener).updateViewSize(this.val$viewSize, this.val$validFlag);
    }
}

