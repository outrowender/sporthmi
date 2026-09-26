/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.common.commands;

import de.audi.app.addressbook.core.common.commands.ADBDSIListener;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.organizer.DSIAdbVCardExchangeListener;

class ADBDSIListener$80
extends CommandResponse {
    private final /* synthetic */ int val$success;
    private final /* synthetic */ long[] val$entryIdList;
    private final /* synthetic */ int val$listMode;
    private final /* synthetic */ String val$fullPathToVCards;
    private final /* synthetic */ ADBDSIListener this$0;

    ADBDSIListener$80(ADBDSIListener aDBDSIListener, int n, long[] lArray, int n2, String string) {
        this.this$0 = aDBDSIListener;
        this.val$success = n;
        this.val$entryIdList = lArray;
        this.val$listMode = n2;
        this.val$fullPathToVCards = string;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSIAdbVCardExchangeListener)dSIListener).createVCardResult(this.val$success, this.val$entryIdList, this.val$listMode, this.val$fullPathToVCards);
    }
}

