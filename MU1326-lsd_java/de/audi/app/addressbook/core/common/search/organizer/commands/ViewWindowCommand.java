/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.common.search.organizer.commands;

import de.audi.app.addressbook.core.common.ADBApplication;
import de.audi.app.addressbook.core.common.ADBDbgUtils;
import de.audi.app.addressbook.core.common.commands.AbstractADBCommand;
import de.audi.app.addressbook.core.common.search.organizer.AbstractADBOrganizerSearch;
import de.audi.app.addressbook.core.common.search.organizer.ViewWindowRequestInfo;
import de.audi.atip.hmi.modelaccess.HMIModelApp;
import de.audi.tghu.command.CommandList;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.organizer.DataSet;

public class ViewWindowCommand
extends AbstractADBCommand {
    private HMIModelApp syncModel;
    private ViewWindowRequestInfo requestInfo;
    private AbstractADBOrganizerSearch organizerSearch;
    static /* synthetic */ Class class$de$audi$app$addressbook$core$common$search$organizer$commands$ViewWindowCommand;

    public ViewWindowCommand(ADBApplication aDBApplication, ViewWindowRequestInfo viewWindowRequestInfo, AbstractADBOrganizerSearch abstractADBOrganizerSearch) {
        super(aDBApplication);
        this.syncModel = abstractADBOrganizerSearch.getListSyncModel();
        this.syncModel.setStatus(0);
        this.requestInfo = viewWindowRequestInfo;
        this.organizerSearch = abstractADBOrganizerSearch;
    }

    @Override
    public void execute() {
        boolean bl = false;
        if (this.requestInfo.getSpellerHandle() == -1) {
            bl = this.adbDSIAccess.getViewWindow(this.requestInfo.getRefEntryId(), this.requestInfo.getMovement(), this.requestInfo.getViewType(), this.requestInfo.getWindowSize());
        } else if (this.requestInfo.getSpellerHandle() == this.organizerSearch.getCurrentSpellerHandle()) {
            bl = this.adbDSIAccess.getSpellerViewWindow(this.requestInfo.getSpellerHandle(), this.requestInfo.getRefEntryId(), this.requestInfo.getMovement(), this.requestInfo.getViewType(), this.requestInfo.getWindowSize());
        } else {
            this.logger.log(1078071040, "ViewWindowCommand#execute(): spellerHandler in requestInfo (%1) differs from currentSpellerHandle (%2), finishing command.", (long)this.requestInfo.getSpellerHandle(), (long)this.organizerSearch.getCurrentSpellerHandle());
            this.organizerSearch.updateList(null, this.requestInfo);
            this.syncModel.setStatus(1);
            this.commandList.commandFinished();
            return;
        }
        if (!bl) {
            this.logger.log(10000, "ViewWindowCommand#execute(): dsi call was not successful, finishing command.");
            this.organizerSearch.updateList(null, this.requestInfo);
            this.syncModel.setStatus(2);
            this.commandList.commandFinished();
        }
    }

    @Override
    public void getViewWindowResult(int n, DataSet[] dataSetArray, int n2) {
        if (this.logger.isDebug()) {
            this.logger.log(-2137614336, "ViewWindowCommand#getViewWindowResult(): dataSetList: %1, success: %2; totalEntries: %3", (Object)dataSetArray, (Object)ADBDbgUtils.dbgSuccessFlag(n), (long)n2);
            this.logger.log(-2137614336, "ViewWindowCommand#getViewWindowResult(): dataSetList: %1", (Object)ADBDbgUtils.dbg(dataSetArray));
        }
        this.handleResult(n, dataSetArray, n2);
    }

    @Override
    public void getSpellerViewWindowResult(int n, int n2, DataSet[] dataSetArray, int n3) {
        if (this.logger.isDebug()) {
            Buffer buffer = new Buffer("success: ").append(ADBDbgUtils.dbgSuccessFlag(n)).append(", spellerHandle: ").append(n2).append(", totalEntries: ").append(n3).append(", dataSetList: ").append(ADBDbgUtils.dbg(dataSetArray));
            this.logger.log(-2137614336, "ViewWindowCommand#getSpellerViewWindowResult(): %1", (Object)buffer);
        }
        if (this.requestInfo.getSpellerHandle() != n2) {
            this.logger.log(10000, "ViewWindowCommand#getSpellerViewWindowResult(): requested spellerHandle (%1) does not match received spellerhandle (%2)!", (long)this.requestInfo.getSpellerHandle(), (long)n2);
        }
        this.handleResult(n, dataSetArray, n3);
    }

    private void handleResult(int n, DataSet[] dataSetArray, int n2) {
        if (n == 2 && this.requestInfo.getMovement() != 4) {
            this.requestInfo.setMovement(4);
            this.execute();
            return;
        }
        if (dataSetArray == null || n != 0) {
            this.logger.log(10000, "ViewWindowCommand#handleResult(): received dataSetList is null or resulttype is not OK (success: %1), not updating adb lists!", (Object)ADBDbgUtils.dbgSuccessFlag(n));
            this.organizerSearch.updateList(null, this.requestInfo);
            this.syncModel.setStatus(2);
            this.commandList.commandFinished();
        } else {
            this.requestInfo.setTotalEntries(n2);
            this.organizerSearch.updateList(dataSetArray, this.requestInfo);
            this.syncModel.setStatus(1);
            this.commandList.commandFinished();
        }
    }

    public static void createViewWindowCommand(ADBApplication aDBApplication, ViewWindowRequestInfo viewWindowRequestInfo, AbstractADBOrganizerSearch abstractADBOrganizerSearch) {
        ViewWindowCommand viewWindowCommand = new ViewWindowCommand(aDBApplication, viewWindowRequestInfo, abstractADBOrganizerSearch);
        CommandList commandList = new CommandList(aDBApplication.getCommandListManager());
        commandList.add(viewWindowCommand);
        commandList.execute((class$de$audi$app$addressbook$core$common$search$organizer$commands$ViewWindowCommand == null ? (class$de$audi$app$addressbook$core$common$search$organizer$commands$ViewWindowCommand = ViewWindowCommand.class$("de.audi.app.addressbook.core.common.search.organizer.commands.ViewWindowCommand")) : class$de$audi$app$addressbook$core$common$search$organizer$commands$ViewWindowCommand).getName());
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

