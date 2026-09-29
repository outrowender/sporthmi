/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.vcardexchange.commands;

import de.audi.app.addressbook.core.common.ADBDbgUtils;
import de.audi.app.addressbook.core.common.commands.AbstractADBCommand;
import de.audi.app.addressbook.core.vcardexchange.VCardExchangeADBHandler;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.filebrowser.IFileBrowser;
import org.dsi.ifc.global.ResourceLocator;

public final class VCardImportCommand
extends AbstractADBCommand {
    private final VCardExchangeADBHandler vCardExchangeAdbHandler;
    private IFileBrowser fileSelectionBrowser;
    private int offset;
    private int windowSize;
    private int destinationProfile;
    static /* synthetic */ Class class$de$audi$app$addressbook$core$vcardexchange$commands$VCardImportCommand;

    private VCardImportCommand(VCardExchangeADBHandler vCardExchangeADBHandler, IFileBrowser iFileBrowser, int n, int n2, int n3) {
        super(vCardExchangeADBHandler);
        this.vCardExchangeAdbHandler = vCardExchangeADBHandler;
        this.fileSelectionBrowser = iFileBrowser;
        this.offset = n;
        this.windowSize = n2;
        this.destinationProfile = n3;
    }

    @Override
    public void execute() {
        boolean bl;
        this.logger.log(-2137614336, "VCardImportCommand#execute()");
        if (this.destinationProfile != 0 && this.vCardExchangeAdbHandler.getAdbStateHandler().getActiveProfile() != this.destinationProfile) {
            this.logger.log(-1601830656, "VCardImportCommand#execute(): vCard import destination profile differs from active profile, finishing import command.");
            this.commandList.commandFinished();
            return;
        }
        if (this.vCardExchangeAdbHandler.isImportAborted()) {
            this.commandList.commandFinished();
            return;
        }
        ResourceLocator[] resourceLocatorArray = this.fileSelectionBrowser.getResourceLocators(this.offset, this.windowSize);
        this.logger.log(-2137614336, "VCardImportCommand#execute(): resourceLocators: %1", (Object)ADBDbgUtils.dbg(resourceLocatorArray));
        boolean bl2 = bl = resourceLocatorArray != null && this.adbDSIAccess.importVCard(resourceLocatorArray, this.destinationProfile);
        if (!bl) {
            this.logger.log(10000, "VCardImportCommand#execute(): importVCard dsi call was not successful, or resourceLocators could not be fetched from file browser, finishing command.");
            this.commandList.commandFinished();
        }
    }

    @Override
    public long getTimeout() {
        return -1L;
    }

    @Override
    public void importVCardResult(int n, int n2, int n3, int n4) {
        if (this.logger.isDebug()) {
            this.logger.log(-2137614336, "VCardImportCommand#importVCardResult(): success: %1, countSuccess: %3, countFailure: %4, failureReason: %2", (Object)ADBDbgUtils.dbgSuccessFlag(n), (Object)ADBDbgUtils.dbgFailureReason(n4), (Object)Integer.toString(n2), (long)n3);
        }
        this.vCardExchangeAdbHandler.getImportProgress().updateImportProgress(n2, n3, n4);
        this.commandList.commandFinished();
    }

    public static void createVCardImportCommand(VCardExchangeADBHandler vCardExchangeADBHandler, IFileBrowser iFileBrowser, int n, int n2, int n3) {
        VCardImportCommand vCardImportCommand = new VCardImportCommand(vCardExchangeADBHandler, iFileBrowser, n, n2, n3);
        CommandList commandList = new CommandList(vCardExchangeADBHandler.getCommandListManager());
        commandList.add(vCardImportCommand);
        commandList.execute((class$de$audi$app$addressbook$core$vcardexchange$commands$VCardImportCommand == null ? (class$de$audi$app$addressbook$core$vcardexchange$commands$VCardImportCommand = VCardImportCommand.class$("de.audi.app.addressbook.core.vcardexchange.commands.VCardImportCommand")) : class$de$audi$app$addressbook$core$vcardexchange$commands$VCardImportCommand).getName());
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

