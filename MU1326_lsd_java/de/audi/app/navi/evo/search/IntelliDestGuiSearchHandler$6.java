/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.search;

import de.audi.app.navi.evo.search.IntelliDestGuiSearchHandler;
import de.audi.app.navi.evo.search.NaviAdbEntryListRow;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.organizer.AdbEntry;

class IntelliDestGuiSearchHandler$6
extends NavCommand {
    private final /* synthetic */ EvoListRow val$favoriteRow;
    private final /* synthetic */ NavLocation val$location;
    private final /* synthetic */ IntelliDestGuiSearchHandler this$0;

    IntelliDestGuiSearchHandler$6(IntelliDestGuiSearchHandler intelliDestGuiSearchHandler, String string, EvoListRow evoListRow, NavLocation navLocation) {
        this.this$0 = intelliDestGuiSearchHandler;
        this.val$favoriteRow = evoListRow;
        this.val$location = navLocation;
        super(string);
    }

    @Override
    public void execute() {
        if (this.val$favoriteRow != null && this.val$favoriteRow instanceof NaviAdbEntryListRow) {
            IntelliDestGuiSearchHandler.access$600(this.this$0).log(1078071040, "%1#saveAsFavorite - NaviAdbEntryListRow", (Object)"IntelliDestGuiSearchHandler");
            NaviAdbEntryListRow naviAdbEntryListRow = (NaviAdbEntryListRow)this.val$favoriteRow;
            AdbEntry adbEntry = naviAdbEntryListRow.getAdbEntry();
            String string = adbEntry.getCombinedName();
            if (!Util.isEmpty(string)) {
                IntelliDestGuiSearchHandler.access$700(this.this$0).addToFavorites(this.val$location, string);
            }
        } else {
            IntelliDestGuiSearchHandler.access$800(this.this$0).log(1078071040, "%1#saveAsFavorite - no NaviAdbEntryListRow", (Object)"IntelliDestGuiSearchHandler");
            IntelliDestGuiSearchHandler.access$700(this.this$0).addToFavorites(this.val$location);
        }
        this.getCommandList().commandFinished();
    }
}

