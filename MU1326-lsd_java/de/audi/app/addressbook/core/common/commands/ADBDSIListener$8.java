/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.common.commands;

import de.audi.app.addressbook.core.common.commands.ADBDSIListener;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.organizer.DSIAdbListListener;
import org.dsi.ifc.organizer.DataSet;

class ADBDSIListener$8
extends CommandResponse {
    private final /* synthetic */ int val$success;
    private final /* synthetic */ int val$spellerhandle;
    private final /* synthetic */ DataSet[] val$dataSetList;
    private final /* synthetic */ int val$totalEntries;
    private final /* synthetic */ ADBDSIListener this$0;

    ADBDSIListener$8(ADBDSIListener aDBDSIListener, int n, int n2, DataSet[] dataSetArray, int n3) {
        this.this$0 = aDBDSIListener;
        this.val$success = n;
        this.val$spellerhandle = n2;
        this.val$dataSetList = dataSetArray;
        this.val$totalEntries = n3;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSIAdbListListener)dSIListener).getSpellerViewWindowResult(this.val$success, this.val$spellerhandle, this.val$dataSetList, this.val$totalEntries);
    }
}

