/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.destinationimport;

import de.audi.atip.interapp.OnlineAdbEntry;
import de.audi.tghu.navi.app.destinationimport.INaviMyAudiSearchCallBack;
import de.audi.tghu.navi.app.destinationimport.NaviMyAudiSearch;
import java.util.ArrayList;
import java.util.Iterator;

class NaviMyAudiSearch$MyAudiSearchTask
implements Runnable {
    private final String textToFilterLowerCase;
    private final INaviMyAudiSearchCallBack callback;
    private final /* synthetic */ NaviMyAudiSearch this$0;

    public NaviMyAudiSearch$MyAudiSearchTask(NaviMyAudiSearch naviMyAudiSearch, String string, INaviMyAudiSearchCallBack iNaviMyAudiSearchCallBack) {
        this.this$0 = naviMyAudiSearch;
        this.textToFilterLowerCase = string != null ? string.toLowerCase() : "";
        this.callback = iNaviMyAudiSearchCallBack;
    }

    @Override
    public void run() {
        this.filterList();
    }

    private void filterList() {
        OnlineAdbEntry[] onlineAdbEntryArray;
        NaviMyAudiSearch.access$100(this.this$0).log(-2137614336, "%1#filterList starting", (Object)NaviMyAudiSearch.access$000(this.this$0));
        ArrayList arrayList = new ArrayList();
        Iterator iterator = NaviMyAudiSearch.access$200(this.this$0).iterator();
        while (iterator.hasNext()) {
            onlineAdbEntryArray = (OnlineAdbEntry[])iterator.next();
            if (onlineAdbEntryArray.getAdbEntry().combinedName.toLowerCase().indexOf(this.textToFilterLowerCase) <= -1) continue;
            arrayList.add(onlineAdbEntryArray);
        }
        onlineAdbEntryArray = new OnlineAdbEntry[arrayList.size()];
        for (int i2 = 0; i2 < arrayList.size(); ++i2) {
            onlineAdbEntryArray[i2] = (OnlineAdbEntry)arrayList.get(i2);
        }
        if (this.callback != null) {
            this.callback.updateAddressList(onlineAdbEntryArray);
        } else {
            NaviMyAudiSearch.access$100(this.this$0).log(-1601830656, "%1#filterList - caller is null!", (Object)NaviMyAudiSearch.access$000(this.this$0));
        }
    }
}

