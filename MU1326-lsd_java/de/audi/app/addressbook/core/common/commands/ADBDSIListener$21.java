/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.common.commands;

import de.audi.app.addressbook.core.common.commands.ADBDSIListener;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.organizer.DSIAdbEditListener;
import org.dsi.ifc.organizer.DataSet;

class ADBDSIListener$21
extends CommandResponse {
    private final /* synthetic */ int val$success;
    private final /* synthetic */ DataSet[] val$entryDataSetList;
    private final /* synthetic */ ADBDSIListener this$0;

    ADBDSIListener$21(ADBDSIListener aDBDSIListener, int n, DataSet[] dataSetArray) {
        this.this$0 = aDBDSIListener;
        this.val$success = n;
        this.val$entryDataSetList = dataSetArray;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSIAdbEditListener)dSIListener).getEntryDataSetsResult(this.val$success, this.val$entryDataSetList);
    }
}

