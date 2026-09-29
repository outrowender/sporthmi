/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.destinationimport;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.destinationimport.INaviMyAudiSearchCallBack;
import de.audi.tghu.navi.app.destinationimport.NaviMyAudiSearch$MyAudiSearchTask;
import de.audi.tghu.navi.app.util.Util;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import de.esolutions.fw.util.commons.job.Job;
import java.util.List;

public class NaviMyAudiSearch {
    private final String CLASS_NAME = Util.getClassNameFromPackageName(super.getClass());
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
        this.logChannel.log(-2137614336, "%1#getFilteredList - textToFilter=%2", (Object)this.CLASS_NAME, (Object)string);
        if (this.currentJob != null) {
            this.currentJob.cancel();
        }
        NaviMyAudiSearch$MyAudiSearchTask naviMyAudiSearch$MyAudiSearchTask = new NaviMyAudiSearch$MyAudiSearchTask(this, string, iNaviMyAudiSearchCallBack);
        this.currentJob = this.dispatcher.execute(naviMyAudiSearch$MyAudiSearchTask);
    }

    static /* synthetic */ String access$000(NaviMyAudiSearch naviMyAudiSearch) {
        return naviMyAudiSearch.CLASS_NAME;
    }

    static /* synthetic */ LogChannel access$100(NaviMyAudiSearch naviMyAudiSearch) {
        return naviMyAudiSearch.logChannel;
    }

    static /* synthetic */ List access$200(NaviMyAudiSearch naviMyAudiSearch) {
        return naviMyAudiSearch.unfilteredEntries;
    }
}

