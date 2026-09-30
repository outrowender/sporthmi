/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.vcardexchange.commands;

import de.audi.app.addressbook.core.common.ADBDbgUtils;
import de.audi.app.addressbook.core.common.commands.AbstractADBCommand;
import de.audi.app.addressbook.core.vcardexchange.VCardExchangeADBHandler;
import de.audi.tghu.command.CommandList;

public final class VCardExportCommand
extends AbstractADBCommand {
    private final VCardExchangeADBHandler vCardExchangeAdbHandler;
    private final int spellerHandle;
    private final int exportMemoryType;
    private final String destMountPoint;
    private final long[] selectedEntries;
    private final int listMode;
    static /* synthetic */ Class class$de$audi$app$addressbook$core$vcardexchange$commands$VCardExportCommand;

    private VCardExportCommand(VCardExchangeADBHandler vCardExchangeADBHandler, int n, int n2, String string, long[] lArray, int n3) {
        super(vCardExchangeADBHandler);
        this.vCardExchangeAdbHandler = vCardExchangeADBHandler;
        this.spellerHandle = n;
        this.exportMemoryType = n2;
        this.destMountPoint = string;
        this.selectedEntries = lArray;
        this.listMode = n3;
    }

    public void execute() {
        boolean bl;
        this.logger.log(10000000, "VCardExportCommand#execute()");
        boolean bl2 = bl = this.spellerHandle == -1 ? this.adbDSIAccess.exportVCard(this.exportMemoryType, this.destMountPoint, this.selectedEntries, this.listMode) : this.adbDSIAccess.exportSpellerVCard(this.spellerHandle, this.exportMemoryType, this.destMountPoint, this.selectedEntries, this.listMode);
        if (!bl) {
            this.logger.log(10000, "VCardExportCommand#execute(): dsi call was not successful, finishing command.");
            this.commandList.commandFinished();
        }
    }

    public long getTimeout() {
        return -1L;
    }

    public void exportVCardResult(int n, int n2, int n3, int n4) {
        this.logger.log(1000000, "VCardExportCommand#exportVCardResult(): success: %1, countSuccess: %2 countFailure: %3, failureReason: %4", (Object)ADBDbgUtils.dbgSuccessFlag(n), (Object)Integer.toString(n2), (Object)Integer.toString(n3), (Object)ADBDbgUtils.dbgFailureReason(n4));
        this.handleResult(n2, n3, n4);
    }

    public void exportSpellerVCardResult(int n, int n2, int n3, int n4, int n5) {
        this.logger.log(1000000, "VCardExportCommand#exportSpellerVCardResult(): success: %1, countSuccess: %2 countFailure: %3, failureReason: %4", (Object)ADBDbgUtils.dbgSuccessFlag(n), (Object)Integer.toString(n3), (Object)Integer.toString(n4), (Object)ADBDbgUtils.dbgFailureReason(n5));
        this.handleResult(n3, n4, n5);
    }

    private void handleResult(int n, int n2, int n3) {
        int n4 = 0;
        switch (n3) {
            case 2: {
                n4 = 0;
                break;
            }
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: {
                n4 = 1;
                break;
            }
            case 0: {
                n4 = 2;
                break;
            }
            default: {
                this.logger.log(100000, "VCardExportCommand#handleResult(): unknown failure reason %1", (long)n3);
            }
        }
        this.vCardExchangeAdbHandler.getHMIService().getLabelModel(700456).setText(Long.toString(n));
        this.vCardExchangeAdbHandler.getHMIService().getLabelModel(700457).setText(Long.toString(n2));
        this.vCardExchangeAdbHandler.getHMIService().getChoiceModel(700458).setValue(n4);
        this.vCardExchangeAdbHandler.getHMIService().getModelApp(700495).setStatus(1);
        this.vCardExchangeAdbHandler.getHMIService().getChoiceModel(700253).setValue(0);
        this.vCardExchangeAdbHandler.getVCardExportListHandler().reset();
        this.vCardExchangeAdbHandler.getVCardExportListHandler().refreshFromStart();
        this.commandList.commandFinished();
    }

    public static void createVCardExportCommand(VCardExchangeADBHandler vCardExchangeADBHandler, int n, int n2, String string, long[] lArray, int n3) {
        vCardExchangeADBHandler.getHMIService().getLabelModel(700495).setStatus(0);
        vCardExchangeADBHandler.getHMIService().getChoiceModel(700253).setValue(1);
        VCardExportCommand vCardExportCommand = new VCardExportCommand(vCardExchangeADBHandler, n, n2, string, lArray, n3);
        CommandList commandList = new CommandList(vCardExchangeADBHandler.getCommandListManager());
        commandList.add(vCardExportCommand);
        commandList.execute((class$de$audi$app$addressbook$core$vcardexchange$commands$VCardExportCommand == null ? (class$de$audi$app$addressbook$core$vcardexchange$commands$VCardExportCommand = VCardExportCommand.class$("de.audi.app.addressbook.core.vcardexchange.commands.VCardExportCommand")) : class$de$audi$app$addressbook$core$vcardexchange$commands$VCardExportCommand).getName());
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

