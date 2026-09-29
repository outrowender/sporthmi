/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.operatorcall.handler;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.online.app.operatorcall.handler.DSIHandler;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.online.DSIOperatorCallListener;

class DSIHandler$2
extends CommandResponse {
    private final /* synthetic */ int val$resultType;
    private final /* synthetic */ String val$serviceId;
    private final /* synthetic */ String[] val$operatorPhoneNumber;
    private final /* synthetic */ int val$transferType;
    private final /* synthetic */ DSIHandler this$0;

    DSIHandler$2(DSIHandler dSIHandler, int n, String string, String[] stringArray, int n2) {
        this.this$0 = dSIHandler;
        this.val$resultType = n;
        this.val$serviceId = string;
        this.val$operatorPhoneNumber = stringArray;
        this.val$transferType = n2;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSIOperatorCallListener)dSIListener).responseOperatorPhoneNumber(this.val$resultType, this.val$serviceId, this.val$operatorPhoneNumber, this.val$transferType);
    }
}

