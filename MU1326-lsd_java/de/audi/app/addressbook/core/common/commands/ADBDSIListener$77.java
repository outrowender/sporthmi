/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.common.commands;

import de.audi.app.addressbook.core.common.commands.ADBDSIListener;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.organizer.DSIAdbVCardExchangeListener;

class ADBDSIListener$77
extends CommandResponse {
    private final /* synthetic */ int val$success;
    private final /* synthetic */ int val$countSuccess;
    private final /* synthetic */ int val$countFailure;
    private final /* synthetic */ int val$failureReason;
    private final /* synthetic */ ADBDSIListener this$0;

    ADBDSIListener$77(ADBDSIListener aDBDSIListener, int n, int n2, int n3, int n4) {
        this.this$0 = aDBDSIListener;
        this.val$success = n;
        this.val$countSuccess = n2;
        this.val$countFailure = n3;
        this.val$failureReason = n4;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSIAdbVCardExchangeListener)dSIListener).importVCardResult(this.val$success, this.val$countSuccess, this.val$countFailure, this.val$failureReason);
    }
}

