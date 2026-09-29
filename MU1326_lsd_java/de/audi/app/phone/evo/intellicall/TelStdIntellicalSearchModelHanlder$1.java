/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.intellicall;

import de.audi.app.addressbook.core.common.ADBEntryDetailsListRow;
import de.audi.app.addressbook.core.common.search.ADBSearch;
import de.audi.app.addressbook.core.common.search.ADBSearchListRow;
import de.audi.app.phone.core.adb.ITelADBGetADBEntryListener;
import de.audi.app.phone.evo.adb.TelEntryDetailsListRowBuilder;
import de.audi.app.phone.evo.intellicall.TelStdIntellicalSearchModelHanlder;
import org.dsi.ifc.organizer.AdbEntry;

class TelStdIntellicalSearchModelHanlder$1
implements ITelADBGetADBEntryListener {
    private final /* synthetic */ ADBSearch val$adbSearch;
    private final /* synthetic */ ADBSearchListRow val$selectedRow;
    private final /* synthetic */ TelStdIntellicalSearchModelHanlder this$0;

    TelStdIntellicalSearchModelHanlder$1(TelStdIntellicalSearchModelHanlder telStdIntellicalSearchModelHanlder, ADBSearch aDBSearch, ADBSearchListRow aDBSearchListRow) {
        this.this$0 = telStdIntellicalSearchModelHanlder;
        this.val$adbSearch = aDBSearch;
        this.val$selectedRow = aDBSearchListRow;
    }

    @Override
    public void resultGetADBEntry(AdbEntry adbEntry) {
        ADBEntryDetailsListRow[] aDBEntryDetailsListRowArray = TelEntryDetailsListRowBuilder.getTelDetailsRows(adbEntry, new TelEntryDetailsListRowBuilder());
        this.val$adbSearch.setSearchResultDetails(aDBEntryDetailsListRowArray, this.val$selectedRow);
    }
}

