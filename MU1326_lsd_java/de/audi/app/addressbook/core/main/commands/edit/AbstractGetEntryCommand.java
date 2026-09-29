/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.main.commands.edit;

import de.audi.app.addressbook.core.common.ADBDbgUtils;
import de.audi.app.addressbook.core.common.commands.AbstractADBCommand;
import de.audi.app.addressbook.core.main.AbstractAddressBookApplication;
import de.audi.atip.hmi.modelaccess.HMIModelApp;
import org.dsi.ifc.organizer.AdbEntry;

public abstract class AbstractGetEntryCommand
extends AbstractADBCommand {
    protected AbstractAddressBookApplication appAdr;
    protected long entryId;
    protected HMIModelApp syncModel;

    public AbstractGetEntryCommand(AbstractAddressBookApplication abstractAddressBookApplication, long l, HMIModelApp hMIModelApp) {
        super(abstractAddressBookApplication);
        this.appAdr = abstractAddressBookApplication;
        this.entryId = l;
        this.syncModel = hMIModelApp;
        hMIModelApp.setStatus(0);
    }

    public AbstractGetEntryCommand(AbstractAddressBookApplication abstractAddressBookApplication, long l) {
        this(abstractAddressBookApplication, l, abstractAddressBookApplication.getHMIService().getModelApp(1370491392));
    }

    @Override
    public void execute() {
        this.logger.log(1078071040, "AbstractGetEntryCommand#execute(): entryId: %1", this.entryId);
        boolean bl = this.adbDSIAccess.getEntries(new long[]{this.entryId}, 0, 0);
        if (!bl) {
            this.logger.log(10000, "AbstractGetEntryCommand#execute(): dsi call was not successful, finishing command and setting syncModel status to ERROR!.");
            this.syncModel.setStatus(2);
            this.commandList.commandFinished();
        }
    }

    @Override
    public void getEntriesResult(int n, AdbEntry[] adbEntryArray) {
        this.logger.log(-2137614336, "AbstractGetEntryCommand#getEntriesResult(): success: %2, entryList: %1", (Object)adbEntryArray, (Object)ADBDbgUtils.dbgSuccessFlag(n));
        if (n == 0 && adbEntryArray != null && adbEntryArray.length == 1) {
            this.logger.log(-2137614336, "AbstractGetEntryCommand#getEntriesResult(): got entry: %1", (Object)adbEntryArray[0]);
            this.appAdr.setCurrentEntry(adbEntryArray[0]);
            this.appAdr.setFocusedEntryId(adbEntryArray[0].entryId);
            this.appAdr.setFocusedEntryType(adbEntryArray[0].entryType);
            this.appAdr.getSelectedEntryDetails().updateEntryDetails(adbEntryArray[0]);
            boolean bl = this.handleGetEntryResult(adbEntryArray[0]);
            this.syncModel.setStatus(bl ? 1 : 2);
        } else {
            this.logger.log(10000, "AbstractGetEntryCommand#getEntriesResult(): #getEntries() was not successful, setting syncModel status to ERROR!");
            this.syncModel.setStatus(2);
        }
        this.commandList.commandFinished();
    }

    protected abstract boolean handleGetEntryResult(AdbEntry adbEntry) {
    }
}

