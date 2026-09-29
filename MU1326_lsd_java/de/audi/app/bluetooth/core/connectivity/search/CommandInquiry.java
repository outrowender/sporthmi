/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bluetooth.core.connectivity.search;

import de.audi.app.bluetooth.core.AbstractBluetoothCommand;
import de.audi.app.bluetooth.core.IBluetoothApplication;
import de.audi.app.bluetooth.core.connectivity.search.IInquiry;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.bluetooth.DSIBluetooth;

final class CommandInquiry
extends AbstractBluetoothCommand {
    private static final long TIMEOUT;
    private IInquiry inquiry;
    static /* synthetic */ Class class$de$audi$app$bluetooth$core$connectivity$search$CommandInquiry;

    static void schedule(IBluetoothApplication iBluetoothApplication, DSIBluetooth dSIBluetooth) {
        CommandInquiry commandInquiry = new CommandInquiry(iBluetoothApplication.getLogChannel(), iBluetoothApplication.getInquiry(), dSIBluetooth);
        AbstractBluetoothCommand.schedule(iBluetoothApplication.getCommandListManager(), commandInquiry);
    }

    private CommandInquiry(LogChannel logChannel, IInquiry iInquiry, DSIBluetooth dSIBluetooth) {
        super(logChannel, dSIBluetooth, (class$de$audi$app$bluetooth$core$connectivity$search$CommandInquiry == null ? (class$de$audi$app$bluetooth$core$connectivity$search$CommandInquiry = CommandInquiry.class$("de.audi.app.bluetooth.core.connectivity.search.CommandInquiry")) : class$de$audi$app$bluetooth$core$connectivity$search$CommandInquiry).getName());
        this.inquiry = iInquiry;
    }

    @Override
    public long getTimeout() {
        return 0;
    }

    @Override
    public void execute() {
        if (this.dsiBluetooth != null) {
            this.dsiBluetooth.requestInquiry(48, 50, 2);
        } else {
            this.logger.log(-1601830656, "CommandInquiry#execute(): dsiBluetooth is NULL");
            this.commandList.commandFinished();
        }
    }

    @Override
    public void abort() {
        this.logger.log(-1601830656, "CommandInquiry#abort()");
        this.inquiry.inquiryEnded(2);
    }

    @Override
    public void responseInquiry(int n, int n2) {
        this.logger.log(1078071040, "CommandInquiry#responseInquiry(): result=%1", (long)n2);
        this.inquiryEnded(n2);
    }

    void abortInquiry() {
        if (this.dsiBluetooth != null) {
            this.logger.log(1078071040, "CommandInquiry#abortInquiry()");
            this.dsiBluetooth.abortInquiry();
        } else {
            this.logger.log(-1601830656, "CommandInquiry#abortInquiry(): dsiBluetooth is NULL");
            this.commandList.commandFinished();
        }
    }

    @Override
    public void responseAbortInquiry(int n) {
        this.logger.log(1078071040, "CommandInquiry#responseAbortInquiry(): result=%1", (long)n);
        this.inquiryEnded(n);
    }

    private void inquiryEnded(int n) {
        this.inquiry.inquiryEnded(n);
        this.commandList.commandFinished();
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

