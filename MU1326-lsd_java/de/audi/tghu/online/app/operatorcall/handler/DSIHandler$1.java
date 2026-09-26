/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.operatorcall.handler;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.online.app.operatorcall.handler.DSIHandler;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.online.DSIOperatorCallListener;
import org.dsi.ifc.online.OperatorCallResult;

class DSIHandler$1
extends CommandResponse {
    private final /* synthetic */ int val$resultType;
    private final /* synthetic */ OperatorCallResult[] val$results;
    private final /* synthetic */ DSIHandler this$0;

    DSIHandler$1(DSIHandler dSIHandler, int n, OperatorCallResult[] operatorCallResultArray) {
        this.this$0 = dSIHandler;
        this.val$resultType = n;
        this.val$results = operatorCallResultArray;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSIOperatorCallListener)dSIListener).responseOperatorCallResult(this.val$resultType, this.val$results);
    }
}

