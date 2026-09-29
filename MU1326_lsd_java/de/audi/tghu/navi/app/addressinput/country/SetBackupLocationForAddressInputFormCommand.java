/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.country;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.IBackupLocationHandler;

public class SetBackupLocationForAddressInputFormCommand
extends NavCommand {
    private final IBackupLocationHandler backupLocationHandler;

    public SetBackupLocationForAddressInputFormCommand(IBackupLocationHandler iBackupLocationHandler) {
        this.backupLocationHandler = iBackupLocationHandler;
    }

    @Override
    public void execute() {
        if (this.backupLocationHandler == null) {
            this.getCommandList().commandAborted("Backup Location Handler is null");
            return;
        }
        this.backupLocationHandler.setBackupLocation(this.dsiResponseContainer.getLiCurrentLD());
        this.getCommandList().commandFinished();
    }
}

