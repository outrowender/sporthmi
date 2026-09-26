/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.common.commands;

import de.audi.app.addressbook.core.common.commands.ADBDSIListener;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.organizer.DSIAdbListListener;

class ADBDSIListener$1
extends CommandResponse {
    private final /* synthetic */ int val$errorCode;
    private final /* synthetic */ String val$errorMsg;
    private final /* synthetic */ int val$requestType;
    private final /* synthetic */ ADBDSIListener this$0;

    ADBDSIListener$1(ADBDSIListener aDBDSIListener, int n, String string, int n2) {
        this.this$0 = aDBDSIListener;
        this.val$errorCode = n;
        this.val$errorMsg = string;
        this.val$requestType = n2;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSIAdbListListener)dSIListener).asyncException(this.val$errorCode, this.val$errorMsg, this.val$requestType);
    }
}

