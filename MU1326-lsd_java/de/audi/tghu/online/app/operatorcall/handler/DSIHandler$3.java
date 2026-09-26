/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.operatorcall.handler;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.online.app.operatorcall.handler.DSIHandler;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.online.DSIOperatorCallListener;

class DSIHandler$3
extends CommandResponse {
    private final /* synthetic */ int val$errorCode;
    private final /* synthetic */ String val$errorMsg;
    private final /* synthetic */ int val$requestType;
    private final /* synthetic */ DSIHandler this$0;

    DSIHandler$3(DSIHandler dSIHandler, int n, String string, int n2) {
        this.this$0 = dSIHandler;
        this.val$errorCode = n;
        this.val$errorMsg = string;
        this.val$requestType = n2;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSIOperatorCallListener)dSIListener).asyncException(this.val$errorCode, this.val$errorMsg, this.val$requestType);
    }
}

