/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.intellicall.search;

import de.audi.app.phone.core.adb.ITelADBGetADBEntryListener;
import de.audi.app.phone.evo.intellicall.search.AbstractTelIntellicallSearchModelHandler;
import de.audi.app.phone.evo.intellicall.search.IntellicallADBEntryDetailsResultRow;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.search.util.SearchResultListRow;
import de.audi.atip.util.StringUtilities;
import java.util.ArrayList;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.organizer.PhoneData;

class AbstractTelIntellicallSearchModelHandler$1
implements ITelADBGetADBEntryListener {
    private final /* synthetic */ SearchResultListRow val$listRow;
    private final /* synthetic */ AbstractTelIntellicallSearchModelHandler this$0;

    AbstractTelIntellicallSearchModelHandler$1(AbstractTelIntellicallSearchModelHandler abstractTelIntellicallSearchModelHandler, SearchResultListRow searchResultListRow) {
        this.this$0 = abstractTelIntellicallSearchModelHandler;
        this.val$listRow = searchResultListRow;
    }

    @Override
    public void resultGetADBEntry(AdbEntry adbEntry) {
        AbstractTelIntellicallSearchModelHandler.access$000(this.this$0).log(1078071040, "[AbstractTelIntellicallSearchModelHandler.requestChildrenNodes(...).new ITelADBGetADBEntryListener() {...}#resultGetADBEntry] entry=%1", (Object)adbEntry);
        if (adbEntry != null && adbEntry.getPhoneData() != null && adbEntry.getPhoneData().length > 0) {
            PhoneData[] phoneDataArray = adbEntry.getPhoneData();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < phoneDataArray.length; ++i2) {
                String string = phoneDataArray[i2].getNumber();
                if (StringUtilities.isNullOrEmpty(string)) continue;
                arrayList.add(new IntellicallADBEntryDetailsResultRow(adbEntry, i2));
            }
            EvoListRow[] evoListRowArray = (IntellicallADBEntryDetailsResultRow[])arrayList.toArray(new IntellicallADBEntryDetailsResultRow[arrayList.size()]);
            this.this$0.setChildrenNodes(evoListRowArray, this.val$listRow);
        }
    }
}

