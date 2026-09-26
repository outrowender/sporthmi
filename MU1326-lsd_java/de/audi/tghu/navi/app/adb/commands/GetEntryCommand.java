/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.adb.commands;

import de.audi.app.addressbook.core.common.ADBDbgUtils;
import de.audi.app.addressbook.core.common.ADBUtils;
import de.audi.app.addressbook.core.common.commands.AbstractADBCommand;
import de.audi.atip.hmi.modelaccess.HMIModelApp;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.adb.NaviADBHandler;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.organizer.AdbEntry;

public class GetEntryCommand
extends AbstractADBCommand {
    private NaviADBHandler adbHandler;
    private long entryId;
    private HMIModelApp syncModel;
    private final NavCommand navCommand;
    static /* synthetic */ Class class$de$audi$tghu$navi$app$adb$commands$GetEntryCommand;

    public GetEntryCommand(NaviADBHandler naviADBHandler, long l, HMIModelApp hMIModelApp, NavCommand navCommand) {
        super(naviADBHandler);
        this.adbHandler = naviADBHandler;
        this.entryId = l;
        this.syncModel = hMIModelApp;
        this.navCommand = navCommand;
    }

    public NavCommand getNavCommand() {
        return this.navCommand;
    }

    public NaviADBHandler getAdbHandler() {
        return this.adbHandler;
    }

    public HMIModelApp getSyncModel() {
        return this.syncModel;
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "GetEntryCommand#execute()");
        boolean bl = this.adbDSIAccess.getEntries(new long[]{this.entryId}, 0, 0);
        if (!bl) {
            this.logger.log(10000, "GetEntryCommand#execute(): dsi call was not successful, finishing command.");
            this.commandList.commandFinished();
            if (this.navCommand != null) {
                this.navCommand.getCommandList().commandFinished();
            }
        }
    }

    @Override
    public void getEntriesResult(int n, AdbEntry[] adbEntryArray) {
        this.logger.log(-2137614336, "GetEntryCommand#getEntriesResult(): success: %2, entryList: %1", (Object)adbEntryArray, (Object)ADBDbgUtils.dbgSuccessFlag(n));
        if (n == 0) {
            if (adbEntryArray.length == 1) {
                this.logger.log(-2137614336, "GetEntryCommand#getEntriesResult(): got entry: %1", (Object)ADBDbgUtils.dbg(adbEntryArray[0]));
                ADBUtils.checkAndFixADBEntry(adbEntryArray[0], this.adbHandler.getFramework());
                this.adbHandler.setCurrentEntry(adbEntryArray[0]);
                this.syncModel.setStatus(1);
            } else {
                this.logger.log(10000, "GetEntryCommand#getEntriesResult(): exactly one entry was requested, but entryList length is: %1", (long)adbEntryArray.length);
            }
        }
        this.commandList.commandFinished();
        if (this.navCommand != null) {
            this.navCommand.getCommandList().commandFinished();
        }
    }

    public static void createGetEntryCommand(NaviADBHandler naviADBHandler, long l, HMIModelApp hMIModelApp, NavCommand navCommand) {
        hMIModelApp.setStatus(0);
        GetEntryCommand getEntryCommand = new GetEntryCommand(naviADBHandler, l, hMIModelApp, navCommand);
        CommandList commandList = new CommandList(naviADBHandler.getCommandListManager());
        commandList.add(getEntryCommand);
        commandList.execute((class$de$audi$tghu$navi$app$adb$commands$GetEntryCommand == null ? (class$de$audi$tghu$navi$app$adb$commands$GetEntryCommand = GetEntryCommand.class$("de.audi.tghu.navi.app.adb.commands.GetEntryCommand")) : class$de$audi$tghu$navi$app$adb$commands$GetEntryCommand).getName());
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

