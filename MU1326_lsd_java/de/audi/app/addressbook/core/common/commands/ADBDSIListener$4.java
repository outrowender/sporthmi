/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.common.commands;

import de.audi.app.addressbook.core.common.commands.ADBDSIListener;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.organizer.DSIAdbListListener;
import org.dsi.ifc.organizer.DataSet;

class ADBDSIListener$4
extends CommandResponse {
    private final /* synthetic */ int val$success;
    private final /* synthetic */ int val$spellerHandle;
    private final /* synthetic */ DataSet[] val$dataSetList;
    private final /* synthetic */ int val$totalHits;
    private final /* synthetic */ String val$validChars;
    private final /* synthetic */ String val$uniqueChars;
    private final /* synthetic */ ADBDSIListener this$0;

    ADBDSIListener$4(ADBDSIListener aDBDSIListener, int n, int n2, DataSet[] dataSetArray, int n3, String string, String string2) {
        this.this$0 = aDBDSIListener;
        this.val$success = n;
        this.val$spellerHandle = n2;
        this.val$dataSetList = dataSetArray;
        this.val$totalHits = n3;
        this.val$validChars = string;
        this.val$uniqueChars = string2;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSIAdbListListener)dSIListener).spellerResult(this.val$success, this.val$spellerHandle, this.val$dataSetList, this.val$totalHits, this.val$validChars, this.val$uniqueChars);
    }
}

