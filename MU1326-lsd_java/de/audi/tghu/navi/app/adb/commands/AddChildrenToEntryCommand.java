/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.adb.commands;

import de.audi.app.addressbook.core.common.ADBDbgUtils;
import de.audi.app.addressbook.core.common.ADBUtils;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.modelaccess.HMIModelApp;
import de.audi.atip.search.AbstractGuiSearchHandler;
import de.audi.atip.search.util.SearchResultListRow;
import de.audi.tghu.navi.app.adb.NaviADBHandler;
import de.audi.tghu.navi.app.adb.commands.GetEntryCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.organizer.AdbEntry;

public abstract class AddChildrenToEntryCommand
extends GetEntryCommand {
    protected AbstractGuiSearchHandler abstractGuiSearchHandler;
    protected SearchResultListRow parentRow;

    public AddChildrenToEntryCommand(NaviADBHandler naviADBHandler, long l, HMIModelApp hMIModelApp, NavCommand navCommand, AbstractGuiSearchHandler abstractGuiSearchHandler, SearchResultListRow searchResultListRow) {
        super(naviADBHandler, l, hMIModelApp, navCommand);
        this.abstractGuiSearchHandler = abstractGuiSearchHandler;
        this.parentRow = searchResultListRow;
    }

    @Override
    public void getEntriesResult(int n, AdbEntry[] adbEntryArray) {
        if (n == 0) {
            if (adbEntryArray.length == 1) {
                this.logger.log(-2137614336, "AddChildrenToEntryCommand#getEntriesResult(): got entry: %1", (Object)ADBDbgUtils.dbg(adbEntryArray[0]));
                ADBUtils.checkAndFixADBEntry(adbEntryArray[0], this.getAdbHandler().getFramework());
                this.getAdbHandler().setCurrentEntry(adbEntryArray[0]);
                this.getSyncModel().setStatus(1);
                this.abstractGuiSearchHandler.setChildrenNodes(this.geteChildrenNodes(adbEntryArray[0]), this.parentRow);
            } else {
                this.logger.log(10000, "GetEntryCommand#getEntriesResult(): exactly one entry was requested, but entryList length is: %1", (long)adbEntryArray.length);
            }
        }
        this.commandList.commandFinished();
        if (this.getNavCommand() != null) {
            this.getNavCommand().getCommandList().commandFinished();
        }
    }

    protected abstract EvoListRow[] geteChildrenNodes(AdbEntry adbEntry) {
    }
}

