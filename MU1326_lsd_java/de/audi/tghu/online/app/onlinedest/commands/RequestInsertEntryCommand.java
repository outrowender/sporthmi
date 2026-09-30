/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.onlinedest.commands;

import de.audi.tghu.online.app.onlinedest.commands.AbstractOnlineDestinationCommand;
import org.dsi.ifc.organizer.AdbEntry;

public class RequestInsertEntryCommand
extends AbstractOnlineDestinationCommand {
    private IInsertEntryListener listener;
    private AdbEntry entry;

    public RequestInsertEntryCommand(AdbEntry adbEntry, IInsertEntryListener iInsertEntryListener) {
        this.listener = iInsertEntryListener;
        this.entry = adbEntry;
    }

    public void execute() {
        this.logger.log(1000000, "RequestInsertEntryCommand#execute()");
    }

    public void responseInsertEntry(int n) {
        this.logger.log(1000000, "RequestInsertEntryCommand#responseInsertEntry() success for entry %1: %2", this.entry.getEntryId(), (long)n);
        int n2 = n == 0 ? 1 : (n == 5 || n == 6 ? 6 : (n == 2 ? 7 : 2));
        this.listener.responseInsertEntry(n2);
        this.getCommandList().commandFinished();
    }

    public static interface IInsertEntryListener {
        public void responseInsertEntry(int var1);
    }
}

