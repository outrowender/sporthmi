/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.adb;

import de.audi.app.navi.evo.search.SearchResultFormatterADB;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.modelaccess.HMIModelApp;
import de.audi.atip.search.AbstractGuiSearchHandler;
import de.audi.atip.search.util.SearchResultListRow;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.adb.NaviADBHandler;
import de.audi.tghu.navi.app.adb.commands.AddChildrenToEntryCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.organizer.AdbEntry;

public class AddChildrenToEntryEvoNaviCommand
extends AddChildrenToEntryCommand {
    private SearchResultFormatterADB searchResultFormatterADB;

    protected AddChildrenToEntryEvoNaviCommand(NaviADBHandler naviADBHandler, long l, HMIModelApp hMIModelApp, NavCommand navCommand, AbstractGuiSearchHandler abstractGuiSearchHandler, SearchResultListRow searchResultListRow, SearchResultFormatterADB searchResultFormatterADB) {
        super(naviADBHandler, l, hMIModelApp, navCommand, abstractGuiSearchHandler, searchResultListRow);
        this.searchResultFormatterADB = searchResultFormatterADB;
    }

    protected EvoListRow[] geteChildrenNodes(AdbEntry adbEntry) {
        return this.searchResultFormatterADB.formatADBEntry(adbEntry);
    }

    public static void createAndExecuteAddChildrenToEntryNaviCommand(NaviADBHandler naviADBHandler, long l, HMIModelApp hMIModelApp, AbstractGuiSearchHandler abstractGuiSearchHandler, SearchResultListRow searchResultListRow, SearchResultFormatterADB searchResultFormatterADB) {
        CommandList commandList = new CommandList(naviADBHandler.getCommandListManager());
        commandList.add(new AddChildrenToEntryEvoNaviCommand(naviADBHandler, l, hMIModelApp, null, abstractGuiSearchHandler, searchResultListRow, searchResultFormatterADB));
        commandList.execute("AddChildrenToEntryEvoNaviCommand#add children to gui search handler");
    }
}

