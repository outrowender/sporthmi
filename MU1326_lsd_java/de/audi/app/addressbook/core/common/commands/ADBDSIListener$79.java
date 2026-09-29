/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.common.commands;

import de.audi.app.addressbook.core.common.commands.ADBDSIListener;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.organizer.DSIAdbVCardExchangeListener;

class ADBDSIListener$79
extends CommandResponse {
    private final /* synthetic */ int val$success;
    private final /* synthetic */ int val$spellerHandle;
    private final /* synthetic */ int val$countSuccess;
    private final /* synthetic */ int val$countFailure;
    private final /* synthetic */ int val$failureReason;
    private final /* synthetic */ ADBDSIListener this$0;

    ADBDSIListener$79(ADBDSIListener aDBDSIListener, int n, int n2, int n3, int n4, int n5) {
        this.this$0 = aDBDSIListener;
        this.val$success = n;
        this.val$spellerHandle = n2;
        this.val$countSuccess = n3;
        this.val$countFailure = n4;
        this.val$failureReason = n5;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSIAdbVCardExchangeListener)dSIListener).exportSpellerVCardResult(this.val$success, this.val$spellerHandle, this.val$countSuccess, this.val$countFailure, this.val$failureReason);
    }
}

