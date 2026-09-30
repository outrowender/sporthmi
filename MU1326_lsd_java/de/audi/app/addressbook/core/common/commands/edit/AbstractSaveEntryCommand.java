/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.common.commands.edit;

import de.audi.app.addressbook.core.common.ADBApplication;
import de.audi.app.addressbook.core.common.ADBDbgUtils;
import de.audi.app.addressbook.core.common.commands.AbstractADBCommand;
import de.audi.atip.hmi.modelaccess.HMIModelApp;
import org.dsi.ifc.organizer.AdbEntry;

public abstract class AbstractSaveEntryCommand
extends AbstractADBCommand {
    private ADBApplication appAdr;
    private AdbEntry entry;
    private int profileNum;
    private int numDSIResponsesReceived = 0;
    private HMIModelApp syncModel;

    protected AbstractSaveEntryCommand(ADBApplication aDBApplication, AdbEntry adbEntry, int n, HMIModelApp hMIModelApp) {
        super(aDBApplication);
        this.appAdr = aDBApplication;
        this.entry = adbEntry;
        this.profileNum = n;
        this.syncModel = hMIModelApp;
        this.syncModel.setStatus(0);
    }

    public void execute() {
        this.logger.log(10000000, "AbstractSaveEntryCommand#execute() entry : %1", (Object)this.entry);
        boolean bl = false;
        if (this.entry.entryId == 0L) {
            this.logger.log(1000000, "AbstractSaveEntryCommand#execute() insert entry : %1 , profileNum : %2", (Object)this.entry, (long)this.profileNum);
            bl = this.adbDSIAccess.insertEntry(this.entry, this.profileNum);
        } else {
            this.logger.log(1000000, "AbstractSaveEntryCommand#execute() change entry : %1, profileNum : %2", (Object)this.entry, (long)this.profileNum);
            bl = this.adbDSIAccess.changeEntry(this.entry, this.profileNum);
        }
        if (!bl) {
            this.logger.log(10000, "AbstractSaveEntryCommand#execute(): dsi call was not successful, finishing command.");
            this.commandList.commandFinished();
        }
    }

    public abstract void handleInsertEntryResult(int var1, AdbEntry var2);

    public final void insertEntryResult(int n, AdbEntry adbEntry) {
        this.handleInsertEntryResult(n, adbEntry);
        ++this.numDSIResponsesReceived;
        this.checkCommandFinished(n);
    }

    public abstract void handleChangeEntryResult(int var1, AdbEntry var2);

    public final void changeEntryResult(int n, AdbEntry adbEntry) {
        this.handleChangeEntryResult(n, adbEntry);
        ++this.numDSIResponsesReceived;
        this.checkCommandFinished(n);
    }

    public synchronized void invalidData(int n) {
        this.appAdr.handleInvalidData(n, false);
        ++this.numDSIResponsesReceived;
        this.checkCommandFinished(0);
    }

    private void checkCommandFinished(int n) {
        if (n != 0) {
            this.logger.log(10000, "AbstractSaveEntryCommand#checkCommandFinished(): received result != OK (%1), finishing command.", (Object)ADBDbgUtils.dbgSuccessFlag(n));
            this.syncModel.setStatus(1);
            this.commandList.commandFinished();
        } else if (this.numDSIResponsesReceived == 2) {
            this.logger.log(10000000, "AbstractSaveEntryCommand#checkCommandFinished(): finishing command.");
            this.syncModel.setStatus(1);
            this.commandList.commandFinished();
        }
    }
}

