/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.common.commands;

import de.audi.app.addressbook.core.common.commands.ADBDSIListener;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.organizer.DSIAdbListListener;
import org.dsi.ifc.organizer.IndexInformation;

class ADBDSIListener$11
extends CommandResponse {
    private final /* synthetic */ IndexInformation[] val$indexInfos;
    private final /* synthetic */ int val$validFlag;
    private final /* synthetic */ ADBDSIListener this$0;

    ADBDSIListener$11(ADBDSIListener aDBDSIListener, IndexInformation[] indexInformationArray, int n) {
        this.this$0 = aDBDSIListener;
        this.val$indexInfos = indexInformationArray;
        this.val$validFlag = n;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSIAdbListListener)dSIListener).updateAlphabeticalIndex(this.val$indexInfos, this.val$validFlag);
    }
}

