/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.vcardexchange.commands;

import de.audi.app.addressbook.core.common.ADBDbgUtils;
import de.audi.app.addressbook.core.common.commands.AbstractADBCommand;
import de.audi.app.addressbook.core.vcardexchange.VCardExchangeADBHandler;
import de.audi.app.addressbook.core.vcardexchange.VCardImportProgress;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.filebrowser.IFileBrowser;

public final class FinishVCardImportCommand
extends AbstractADBCommand {
    private final VCardExchangeADBHandler vCardExchangeAdbHandler;
    private IFileBrowser fileSelectionBrowser;
    static /* synthetic */ Class class$de$audi$app$addressbook$core$vcardexchange$commands$FinishVCardImportCommand;

    private FinishVCardImportCommand(VCardExchangeADBHandler vCardExchangeADBHandler, IFileBrowser iFileBrowser) {
        super(vCardExchangeADBHandler);
        this.vCardExchangeAdbHandler = vCardExchangeADBHandler;
        this.fileSelectionBrowser = iFileBrowser;
    }

    public void execute() {
        this.logger.log(10000000, "FinishVCardImportCommand#execute()");
        this.fileSelectionBrowser.close();
        boolean bl = this.adbDSIAccess.importVCard(null, 0);
        if (!bl) {
            this.logger.log(10000, "FinishVCardImportCommand#execute(): dsi call was not successful, finishing command.");
            this.commandList.commandFinished();
        }
    }

    public void importVCardResult(int n, int n2, int n3, int n4) {
        if (this.logger.isDebug()) {
            this.logger.log(10000000, "FinishVCardImportCommand#importVCardResult(): success: %1, countSuccess: %3, countFailure: %4, failureReason: %2", (Object)ADBDbgUtils.dbgSuccessFlag(n), (Object)ADBDbgUtils.dbgFailureReason(n4), (Object)Integer.toString(n2), (long)n3);
        }
        VCardImportProgress vCardImportProgress = this.vCardExchangeAdbHandler.getImportProgress();
        int n5 = 2;
        switch (vCardImportProgress.getErrorReason()) {
            case 1: 
            case 2: {
                n5 = 0;
                break;
            }
            case 3: 
            case 7: {
                n5 = 1;
                break;
            }
            case 5: 
            case 9: {
                n5 = 2;
                break;
            }
            case 0: {
                n5 = 3;
                break;
            }
            case 6: {
                n5 = 4;
                break;
            }
            default: {
                this.logger.log(10000, "FinishVCardImportCommand#importVCardResult(): unknown failure reason %1", (long)vCardImportProgress.getErrorReason());
            }
        }
        this.vCardExchangeAdbHandler.getHMIService().getLabelModel(700480).setText(Integer.toString(vCardImportProgress.getCountSuccess()));
        this.vCardExchangeAdbHandler.getHMIService().getLabelModel(700481).setText(Integer.toString(vCardImportProgress.getCountFailure()));
        this.vCardExchangeAdbHandler.getHMIService().getChoiceModel(700482).setValue(n5);
        this.vCardExchangeAdbHandler.getHMIService().getModelApp(700496).setStatus(1);
        this.commandList.commandFinished();
    }

    public static void createFinishVCardImportCommand(VCardExchangeADBHandler vCardExchangeADBHandler, IFileBrowser iFileBrowser) {
        FinishVCardImportCommand finishVCardImportCommand = new FinishVCardImportCommand(vCardExchangeADBHandler, iFileBrowser);
        CommandList commandList = new CommandList(vCardExchangeADBHandler.getCommandListManager());
        commandList.add(finishVCardImportCommand);
        commandList.execute((class$de$audi$app$addressbook$core$vcardexchange$commands$FinishVCardImportCommand == null ? (class$de$audi$app$addressbook$core$vcardexchange$commands$FinishVCardImportCommand = FinishVCardImportCommand.class$("de.audi.app.addressbook.core.vcardexchange.commands.FinishVCardImportCommand")) : class$de$audi$app$addressbook$core$vcardexchange$commands$FinishVCardImportCommand).getName());
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

