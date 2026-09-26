/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media;

import de.audi.app.media.dsi.AbstractDSIListener;
import de.audi.app.media.dsi.media.MediaDSIBrowserControllerImpl;
import de.audi.app.media.dsi.media.MediaDSIBrowserListener$1;
import de.audi.app.media.dsi.media.MediaDSIBrowserListener$10;
import de.audi.app.media.dsi.media.MediaDSIBrowserListener$11;
import de.audi.app.media.dsi.media.MediaDSIBrowserListener$12;
import de.audi.app.media.dsi.media.MediaDSIBrowserListener$13;
import de.audi.app.media.dsi.media.MediaDSIBrowserListener$14;
import de.audi.app.media.dsi.media.MediaDSIBrowserListener$15;
import de.audi.app.media.dsi.media.MediaDSIBrowserListener$16;
import de.audi.app.media.dsi.media.MediaDSIBrowserListener$17;
import de.audi.app.media.dsi.media.MediaDSIBrowserListener$18;
import de.audi.app.media.dsi.media.MediaDSIBrowserListener$2;
import de.audi.app.media.dsi.media.MediaDSIBrowserListener$3;
import de.audi.app.media.dsi.media.MediaDSIBrowserListener$4;
import de.audi.app.media.dsi.media.MediaDSIBrowserListener$5;
import de.audi.app.media.dsi.media.MediaDSIBrowserListener$6;
import de.audi.app.media.dsi.media.MediaDSIBrowserListener$7;
import de.audi.app.media.dsi.media.MediaDSIBrowserListener$8;
import de.audi.app.media.dsi.media.MediaDSIBrowserListener$9;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import org.dsi.ifc.global.CharacterInfo;
import org.dsi.ifc.media.DSIMediaBrowserListener;
import org.dsi.ifc.media.ListEntry;
import org.dsi.ifc.media.SearchListEntry;
import org.dsi.ifc.media.SearchListEntryExt;

public class MediaDSIBrowserListener
extends AbstractDSIListener
implements DSIMediaBrowserListener {
    private static final String LOGCLASS;
    private final MediaDSIBrowserControllerImpl controller;
    private final String logPrefixResponseList;
    private final String logPrefixResponsePickList;
    private final String logPrefixDispatcher;
    private final DispatcherBase dispatcher;

    public MediaDSIBrowserListener(MediaDSIBrowserControllerImpl mediaDSIBrowserControllerImpl, LogChannel logChannel, DispatcherBase dispatcherBase) {
        super(logChannel);
        this.controller = mediaDSIBrowserControllerImpl;
        this.dispatcher = dispatcherBase;
        Buffer buffer = new Buffer(20);
        buffer.append("[").append("MediaDSIBrowserListener").append(".responseList] [").append(this.controller.getInstanceID()).append("]");
        this.logPrefixResponseList = buffer.toString();
        Buffer buffer2 = new Buffer(20);
        buffer2.append("[").append("MediaDSIBrowserListener").append(".responsePickList] [").append(this.controller.getInstanceID()).append("]");
        this.logPrefixResponsePickList = buffer.toString();
        this.logPrefixDispatcher = new Buffer(20).append("DSIMediaBrowser[").append(mediaDSIBrowserControllerImpl.getInstanceID()).append("].").toString();
    }

    @Override
    protected String getLogClass() {
        return "MediaDSIBrowserListener";
    }

    @Override
    public void responseList(ListEntry[] listEntryArray, int n) {
        this.dispatcher.execute(new MediaDSIBrowserListener$1(this, n, listEntryArray));
    }

    @Override
    public void responseSearchList(SearchListEntry[] searchListEntryArray, int n) {
        this.dispatcher.execute(new MediaDSIBrowserListener$2(this, n, searchListEntryArray));
    }

    @Override
    public void responseSearchListExt(SearchListEntryExt[] searchListEntryExtArray, int n) {
        this.dispatcher.execute(new MediaDSIBrowserListener$3(this, n, searchListEntryExtArray));
    }

    @Override
    public void responseSelectSearchResult(long l, long l2, boolean bl) {
        this.dispatcher.execute(new MediaDSIBrowserListener$4(this, l, l2, bl));
    }

    @Override
    public void responseSetSearchCriteria(int n, boolean bl) {
        this.dispatcher.execute(new MediaDSIBrowserListener$5(this, n, bl));
    }

    @Override
    public void responseSetSearchString(String string, boolean bl) {
        this.dispatcher.execute(new MediaDSIBrowserListener$6(this, string, bl));
    }

    @Override
    public void updateSearchSize(int n, int n2, int n3, int n4, int n5) {
        this.dispatcher.execute(new MediaDSIBrowserListener$7(this, n5, n, n2, n3, n4));
    }

    @Override
    public void updateSearchSpellerState(int n, int n2) {
        this.dispatcher.execute(new MediaDSIBrowserListener$8(this, n2, n));
    }

    @Override
    public void selectionResult(int n, int n2, boolean bl, long l, long l2, long l3, long l4, long l5) {
        this.dispatcher.execute(new MediaDSIBrowserListener$9(this, n, n2, l4, bl, l, l2, l3, l5));
    }

    @Override
    public void updateBrowseFolder(ListEntry[] listEntryArray, int n) {
        if (!this.isUpdateRelevant("updateBrowseFolder", this.controller.getInstanceID(), n)) {
            return;
        }
        this.dispatcher.execute(new MediaDSIBrowserListener$10(this, listEntryArray));
    }

    @Override
    public void updateBrowseMedia(long l, long l2, int n) {
        if (n == 2 && l != 0L && l2 != 0L) {
            this.dispatcher.execute(new MediaDSIBrowserListener$11(this, new StringBuffer().append(this.logPrefixDispatcher).append("updateBrowseMedia (INVALID)").toString(), l, l2));
            return;
        }
        if (!this.isUpdateRelevant("updateBrowseMedia", this.controller.getInstanceID(), n)) {
            return;
        }
        this.dispatcher.execute(new MediaDSIBrowserListener$12(this, l, l2));
    }

    @Override
    public void updateBrowseMode(int n, int n2) {
        if (!this.isUpdateRelevant("updateBrowseMode", this.controller.getInstanceID(), n2)) {
            return;
        }
        this.dispatcher.execute(new MediaDSIBrowserListener$13(this, n));
    }

    @Override
    public void updateContentFilter(int n, int n2) {
        if (!this.isUpdateRelevant("updateContentFilter", this.controller.getInstanceID(), n2)) {
            return;
        }
        this.dispatcher.execute(new MediaDSIBrowserListener$14(this, n));
    }

    @Override
    public void updateListSize(int n, int n2, int n3) {
        if (!this.isUpdateRelevant("updateListSize", this.controller.getInstanceID(), n3)) {
            return;
        }
        this.dispatcher.execute(new MediaDSIBrowserListener$15(this, n, n2));
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        this.dispatcher.execute(new MediaDSIBrowserListener$16(this, n, n2, string));
    }

    @Override
    public void updateAlphabeticalIndex(CharacterInfo[] characterInfoArray, int n) {
        if (!this.isUpdateRelevant("updateAlphabeticalIndex", this.controller.getInstanceID(), n)) {
            return;
        }
        this.dispatcher.execute(new MediaDSIBrowserListener$17(this, characterInfoArray));
    }

    @Override
    public void responsePickList(ListEntry[] listEntryArray) {
        this.dispatcher.execute(new MediaDSIBrowserListener$18(this, listEntryArray));
    }

    @Override
    public void responseFullyQualifiedName(long l, String string) {
    }

    static /* synthetic */ MediaDSIBrowserControllerImpl access$000(MediaDSIBrowserListener mediaDSIBrowserListener) {
        return mediaDSIBrowserListener.controller;
    }

    static /* synthetic */ LogChannel access$100(MediaDSIBrowserListener mediaDSIBrowserListener) {
        return mediaDSIBrowserListener.logger;
    }

    static /* synthetic */ LogChannel access$200(MediaDSIBrowserListener mediaDSIBrowserListener) {
        return mediaDSIBrowserListener.logger;
    }

    static /* synthetic */ LogChannel access$300(MediaDSIBrowserListener mediaDSIBrowserListener) {
        return mediaDSIBrowserListener.logger;
    }

    static /* synthetic */ String access$400(MediaDSIBrowserListener mediaDSIBrowserListener) {
        return mediaDSIBrowserListener.logPrefixResponseList;
    }

    static /* synthetic */ LogChannel access$500(MediaDSIBrowserListener mediaDSIBrowserListener) {
        return mediaDSIBrowserListener.logger;
    }

    static /* synthetic */ LogChannel access$600(MediaDSIBrowserListener mediaDSIBrowserListener) {
        return mediaDSIBrowserListener.logger;
    }

    static /* synthetic */ String access$700(MediaDSIBrowserListener mediaDSIBrowserListener) {
        return mediaDSIBrowserListener.logPrefixDispatcher;
    }

    static /* synthetic */ LogChannel access$800(MediaDSIBrowserListener mediaDSIBrowserListener) {
        return mediaDSIBrowserListener.logger;
    }

    static /* synthetic */ LogChannel access$900(MediaDSIBrowserListener mediaDSIBrowserListener) {
        return mediaDSIBrowserListener.logger;
    }

    static /* synthetic */ LogChannel access$1000(MediaDSIBrowserListener mediaDSIBrowserListener) {
        return mediaDSIBrowserListener.logger;
    }

    static /* synthetic */ LogChannel access$1100(MediaDSIBrowserListener mediaDSIBrowserListener) {
        return mediaDSIBrowserListener.logger;
    }

    static /* synthetic */ LogChannel access$1200(MediaDSIBrowserListener mediaDSIBrowserListener) {
        return mediaDSIBrowserListener.logger;
    }

    static /* synthetic */ LogChannel access$1300(MediaDSIBrowserListener mediaDSIBrowserListener) {
        return mediaDSIBrowserListener.logger;
    }

    static /* synthetic */ LogChannel access$1400(MediaDSIBrowserListener mediaDSIBrowserListener) {
        return mediaDSIBrowserListener.logger;
    }

    static /* synthetic */ LogChannel access$1500(MediaDSIBrowserListener mediaDSIBrowserListener) {
        return mediaDSIBrowserListener.logger;
    }

    static /* synthetic */ LogChannel access$1600(MediaDSIBrowserListener mediaDSIBrowserListener) {
        return mediaDSIBrowserListener.logger;
    }

    static /* synthetic */ LogChannel access$1700(MediaDSIBrowserListener mediaDSIBrowserListener) {
        return mediaDSIBrowserListener.logger;
    }

    static /* synthetic */ LogChannel access$1800(MediaDSIBrowserListener mediaDSIBrowserListener) {
        return mediaDSIBrowserListener.logger;
    }

    static /* synthetic */ LogChannel access$1900(MediaDSIBrowserListener mediaDSIBrowserListener) {
        return mediaDSIBrowserListener.logger;
    }

    static /* synthetic */ LogChannel access$2000(MediaDSIBrowserListener mediaDSIBrowserListener) {
        return mediaDSIBrowserListener.logger;
    }

    static /* synthetic */ LogChannel access$2100(MediaDSIBrowserListener mediaDSIBrowserListener) {
        return mediaDSIBrowserListener.logger;
    }

    static /* synthetic */ LogChannel access$2200(MediaDSIBrowserListener mediaDSIBrowserListener) {
        return mediaDSIBrowserListener.logger;
    }

    static /* synthetic */ LogChannel access$2300(MediaDSIBrowserListener mediaDSIBrowserListener) {
        return mediaDSIBrowserListener.logger;
    }

    static /* synthetic */ LogChannel access$2400(MediaDSIBrowserListener mediaDSIBrowserListener) {
        return mediaDSIBrowserListener.logger;
    }

    static /* synthetic */ LogChannel access$2500(MediaDSIBrowserListener mediaDSIBrowserListener) {
        return mediaDSIBrowserListener.logger;
    }

    static /* synthetic */ boolean access$2600(MediaDSIBrowserListener mediaDSIBrowserListener, String string, int n, int n2) {
        return mediaDSIBrowserListener.isUpdateRelevant(string, n, n2);
    }

    static /* synthetic */ LogChannel access$2700(MediaDSIBrowserListener mediaDSIBrowserListener) {
        return mediaDSIBrowserListener.logger;
    }

    static /* synthetic */ LogChannel access$2800(MediaDSIBrowserListener mediaDSIBrowserListener) {
        return mediaDSIBrowserListener.logger;
    }

    static /* synthetic */ LogChannel access$2900(MediaDSIBrowserListener mediaDSIBrowserListener) {
        return mediaDSIBrowserListener.logger;
    }

    static /* synthetic */ boolean access$3000(MediaDSIBrowserListener mediaDSIBrowserListener, String string, int n, int n2) {
        return mediaDSIBrowserListener.isUpdateRelevant(string, n, n2);
    }

    static /* synthetic */ LogChannel access$3100(MediaDSIBrowserListener mediaDSIBrowserListener) {
        return mediaDSIBrowserListener.logger;
    }

    static /* synthetic */ LogChannel access$3200(MediaDSIBrowserListener mediaDSIBrowserListener) {
        return mediaDSIBrowserListener.logger;
    }

    static /* synthetic */ LogChannel access$3300(MediaDSIBrowserListener mediaDSIBrowserListener) {
        return mediaDSIBrowserListener.logger;
    }

    static /* synthetic */ LogChannel access$3400(MediaDSIBrowserListener mediaDSIBrowserListener) {
        return mediaDSIBrowserListener.logger;
    }

    static /* synthetic */ LogChannel access$3500(MediaDSIBrowserListener mediaDSIBrowserListener) {
        return mediaDSIBrowserListener.logger;
    }

    static /* synthetic */ LogChannel access$3600(MediaDSIBrowserListener mediaDSIBrowserListener) {
        return mediaDSIBrowserListener.logger;
    }

    static /* synthetic */ LogChannel access$3700(MediaDSIBrowserListener mediaDSIBrowserListener) {
        return mediaDSIBrowserListener.logger;
    }

    static /* synthetic */ LogChannel access$3800(MediaDSIBrowserListener mediaDSIBrowserListener) {
        return mediaDSIBrowserListener.logger;
    }

    static /* synthetic */ LogChannel access$3900(MediaDSIBrowserListener mediaDSIBrowserListener) {
        return mediaDSIBrowserListener.logger;
    }

    static /* synthetic */ LogChannel access$4000(MediaDSIBrowserListener mediaDSIBrowserListener) {
        return mediaDSIBrowserListener.logger;
    }

    static /* synthetic */ LogChannel access$4100(MediaDSIBrowserListener mediaDSIBrowserListener) {
        return mediaDSIBrowserListener.logger;
    }

    static /* synthetic */ LogChannel access$4200(MediaDSIBrowserListener mediaDSIBrowserListener) {
        return mediaDSIBrowserListener.logger;
    }

    static /* synthetic */ LogChannel access$4300(MediaDSIBrowserListener mediaDSIBrowserListener) {
        return mediaDSIBrowserListener.logger;
    }

    static /* synthetic */ LogChannel access$4400(MediaDSIBrowserListener mediaDSIBrowserListener) {
        return mediaDSIBrowserListener.logger;
    }

    static /* synthetic */ LogChannel access$4500(MediaDSIBrowserListener mediaDSIBrowserListener) {
        return mediaDSIBrowserListener.logger;
    }

    static /* synthetic */ LogChannel access$4600(MediaDSIBrowserListener mediaDSIBrowserListener) {
        return mediaDSIBrowserListener.logger;
    }

    static /* synthetic */ LogChannel access$4700(MediaDSIBrowserListener mediaDSIBrowserListener) {
        return mediaDSIBrowserListener.logger;
    }

    static /* synthetic */ LogChannel access$4800(MediaDSIBrowserListener mediaDSIBrowserListener) {
        return mediaDSIBrowserListener.logger;
    }

    static /* synthetic */ LogChannel access$4900(MediaDSIBrowserListener mediaDSIBrowserListener) {
        return mediaDSIBrowserListener.logger;
    }

    static /* synthetic */ LogChannel access$5000(MediaDSIBrowserListener mediaDSIBrowserListener) {
        return mediaDSIBrowserListener.logger;
    }

    static /* synthetic */ LogChannel access$5100(MediaDSIBrowserListener mediaDSIBrowserListener) {
        return mediaDSIBrowserListener.logger;
    }

    static /* synthetic */ LogChannel access$5200(MediaDSIBrowserListener mediaDSIBrowserListener) {
        return mediaDSIBrowserListener.logger;
    }

    static /* synthetic */ LogChannel access$5300(MediaDSIBrowserListener mediaDSIBrowserListener) {
        return mediaDSIBrowserListener.logger;
    }

    static /* synthetic */ LogChannel access$5400(MediaDSIBrowserListener mediaDSIBrowserListener) {
        return mediaDSIBrowserListener.logger;
    }

    static /* synthetic */ LogChannel access$5500(MediaDSIBrowserListener mediaDSIBrowserListener) {
        return mediaDSIBrowserListener.logger;
    }

    static /* synthetic */ LogChannel access$5600(MediaDSIBrowserListener mediaDSIBrowserListener) {
        return mediaDSIBrowserListener.logger;
    }

    static /* synthetic */ LogChannel access$5700(MediaDSIBrowserListener mediaDSIBrowserListener) {
        return mediaDSIBrowserListener.logger;
    }

    static /* synthetic */ LogChannel access$5800(MediaDSIBrowserListener mediaDSIBrowserListener) {
        return mediaDSIBrowserListener.logger;
    }

    static /* synthetic */ LogChannel access$5900(MediaDSIBrowserListener mediaDSIBrowserListener) {
        return mediaDSIBrowserListener.logger;
    }

    static /* synthetic */ LogChannel access$6000(MediaDSIBrowserListener mediaDSIBrowserListener) {
        return mediaDSIBrowserListener.logger;
    }

    static /* synthetic */ LogChannel access$6100(MediaDSIBrowserListener mediaDSIBrowserListener) {
        return mediaDSIBrowserListener.logger;
    }

    static /* synthetic */ String access$6200(MediaDSIBrowserListener mediaDSIBrowserListener) {
        return mediaDSIBrowserListener.logPrefixResponsePickList;
    }

    static /* synthetic */ LogChannel access$6300(MediaDSIBrowserListener mediaDSIBrowserListener) {
        return mediaDSIBrowserListener.logger;
    }

    static /* synthetic */ LogChannel access$6400(MediaDSIBrowserListener mediaDSIBrowserListener) {
        return mediaDSIBrowserListener.logger;
    }
}

