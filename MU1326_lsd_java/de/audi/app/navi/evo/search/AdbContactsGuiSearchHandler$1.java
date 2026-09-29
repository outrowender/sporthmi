/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.search;

import de.audi.app.navi.evo.search.AdbContactsGuiSearchHandler;
import de.audi.atip.search.util.SearchResultListRow;
import de.audi.tghu.navi.app.adb.commands.GetEntryCommand;
import de.audi.tghu.navi.app.command.NavCommand;

class AdbContactsGuiSearchHandler$1
extends NavCommand {
    private final /* synthetic */ SearchResultListRow val$listRow;
    private final /* synthetic */ AdbContactsGuiSearchHandler this$0;

    AdbContactsGuiSearchHandler$1(AdbContactsGuiSearchHandler adbContactsGuiSearchHandler, String string, SearchResultListRow searchResultListRow) {
        this.this$0 = adbContactsGuiSearchHandler;
        this.val$listRow = searchResultListRow;
        super(string);
    }

    @Override
    public void execute() {
        GetEntryCommand.createGetEntryCommand(this.this$0.naviADBHandler, this.val$listRow.getSearchResult().dataId, AdbContactsGuiSearchHandler.access$000(this.this$0), this);
    }
}

