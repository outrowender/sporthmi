/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.common.commands;

import de.audi.app.addressbook.core.common.commands.ADBDSIListener;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.organizer.DSIAdbListListener;
import org.dsi.ifc.organizer.DataSet;

class ADBDSIListener$2
extends CommandResponse {
    private final /* synthetic */ int val$success;
    private final /* synthetic */ DataSet[] val$dataSetList;
    private final /* synthetic */ int val$totalEntries;
    private final /* synthetic */ ADBDSIListener this$0;

    ADBDSIListener$2(ADBDSIListener aDBDSIListener, int n, DataSet[] dataSetArray, int n2) {
        this.this$0 = aDBDSIListener;
        this.val$success = n;
        this.val$dataSetList = dataSetArray;
        this.val$totalEntries = n2;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSIAdbListListener)dSIListener).getViewWindowResult(this.val$success, this.val$dataSetList, this.val$totalEntries);
    }
}

