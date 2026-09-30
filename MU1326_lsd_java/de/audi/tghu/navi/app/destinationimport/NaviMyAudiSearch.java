/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.destinationimport;

import de.audi.atip.interapp.OnlineAdbEntry;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.destinationimport.INaviMyAudiSearchCallBack;
import de.audi.tghu.navi.app.util.Util;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import de.esolutions.fw.util.commons.job.Job;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NaviMyAudiSearch {
    private final String CLASS_NAME = Util.getClassNameFromPackageName(this.getClass());
    private final LogChannel logChannel;
    private final List unfilteredEntries;
    private final DispatcherBase dispatcher;
    private Job currentJob;

    public NaviMyAudiSearch(NavigationEnv navigationEnv, List list, DispatcherBase dispatcherBase) {
        this.unfilteredEntries = list;
        this.logChannel = navigationEnv.getOnlineLogChannel();
        this.dispatcher = dispatcherBase;
    }

    public void getFilteredList(String string, INaviMyAudiSearchCallBack iNaviMyAudiSearchCallBack) {
        this.logChannel.log(10000000, "%1#getFilteredList - textToFilter=%2", (Object)this.CLASS_NAME, (Object)string);
        if (this.currentJob != null) {
            this.currentJob.cancel();
        }
        MyAudiSearchTask myAudiSearchTask = new MyAudiSearchTask(string, iNaviMyAudiSearchCallBack);
        this.currentJob = this.dispatcher.execute(myAudiSearchTask);
    }

    private class MyAudiSearchTask
    implements Runnable {
        private final String textToFilterLowerCase;
        private final INaviMyAudiSearchCallBack callback;

        public MyAudiSearchTask(String string, INaviMyAudiSearchCallBack iNaviMyAudiSearchCallBack) {
            this.textToFilterLowerCase = string != null ? string.toLowerCase() : "";
            this.callback = iNaviMyAudiSearchCallBack;
        }

        public void run() {
            this.filterList();
        }

        private void filterList() {
            OnlineAdbEntry[] onlineAdbEntryArray;
            NaviMyAudiSearch.this.logChannel.log(10000000, "%1#filterList starting", (Object)NaviMyAudiSearch.this.CLASS_NAME);
            ArrayList arrayList = new ArrayList();
            Iterator iterator = NaviMyAudiSearch.this.unfilteredEntries.iterator();
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
                NaviMyAudiSearch.this.logChannel.log(100000, "%1#filterList - caller is null!", (Object)NaviMyAudiSearch.this.CLASS_NAME);
            }
        }
    }
}

