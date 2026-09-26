/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.common.commands;

import de.audi.app.addressbook.core.common.commands.ADBDSIListener;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.organizer.DSIAdbListListener;

class ADBDSIListener$10
extends CommandResponse {
    private final /* synthetic */ int val$resultType;
    private final /* synthetic */ int val$spellerHandle;
    private final /* synthetic */ int val$offset;
    private final /* synthetic */ String val$validHanziChars;
    private final /* synthetic */ int val$totalCount;
    private final /* synthetic */ ADBDSIListener this$0;

    ADBDSIListener$10(ADBDSIListener aDBDSIListener, int n, int n2, int n3, String string, int n4) {
        this.this$0 = aDBDSIListener;
        this.val$resultType = n;
        this.val$spellerHandle = n2;
        this.val$offset = n3;
        this.val$validHanziChars = string;
        this.val$totalCount = n4;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSIAdbListListener)dSIListener).getValidHanziCharsWindowResult(this.val$resultType, this.val$spellerHandle, this.val$offset, this.val$validHanziChars, this.val$totalCount);
    }
}

