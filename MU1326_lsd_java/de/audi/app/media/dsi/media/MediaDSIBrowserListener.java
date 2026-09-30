/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.dsi.AbstractDSIListener;
import de.audi.app.media.dsi.IRequestParameter;
import de.audi.app.media.dsi.media.IMediaBrowserListListener;
import de.audi.app.media.dsi.media.IMediaBrowserListener;
import de.audi.app.media.dsi.media.IMediaBrowserSearchListListener;
import de.audi.app.media.dsi.media.IMediaBrowserSearchListener;
import de.audi.app.media.dsi.media.IMediaBrowserStateListener;
import de.audi.app.media.dsi.media.MediaDSIBrowserControllerImpl;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.app.media.dsi.media.requests.RequestParameterList;
import de.audi.app.media.dsi.media.requests.RequestPickListParameterList;
import de.audi.app.media.logger.LogUtil;
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
    private static final String LOGCLASS = "MediaDSIBrowserListener";
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
        buffer.append("[").append(LOGCLASS).append(".responseList] [").append(this.controller.getInstanceID()).append("]");
        this.logPrefixResponseList = buffer.toString();
        Buffer buffer2 = new Buffer(20);
        buffer2.append("[").append(LOGCLASS).append(".responsePickList] [").append(this.controller.getInstanceID()).append("]");
        this.logPrefixResponsePickList = buffer.toString();
        this.logPrefixDispatcher = new Buffer(20).append("DSIMediaBrowser[").append(mediaDSIBrowserControllerImpl.getInstanceID()).append("].").toString();
    }

    protected String getLogClass() {
        return LOGCLASS;
    }

    public void responseList(final ListEntry[] listEntryArray, final int n) {
        this.dispatcher.execute(new Runnable(){

            public void run() {
                MediaDSIBrowserListener.this.logger.log(1000000, "[%1.responseList] [%3] index='%2'.", (Object)MediaDSIBrowserListener.LOGCLASS, (long)n, (long)MediaDSIBrowserListener.this.controller.getInstanceID());
                RequestParameterList requestParameterList = (RequestParameterList)MediaDSIBrowserListener.this.controller.getRequestListHandler().dataResponded();
                if (requestParameterList == null || requestParameterList.isOutdated()) {
                    MediaDSIBrowserListener.this.logger.log(100000, "[%1.responseList] [%2] Request is out dated. Ignore.", (Object)MediaDSIBrowserListener.LOGCLASS, (long)MediaDSIBrowserListener.this.controller.getInstanceID());
                    return;
                }
                if (listEntryArray == null) {
                    MediaDSIBrowserListener.this.logger.log(100000, "[%1.responseList] [%2] Response list is null. Ignore.", (Object)MediaDSIBrowserListener.LOGCLASS, (long)MediaDSIBrowserListener.this.controller.getInstanceID());
                    return;
                }
                LogUtil.logEntryList(MediaDSIBrowserListener.this.logPrefixResponseList, MediaDSIBrowserListener.this.logger, listEntryArray);
                IMediaBrowserListListener iMediaBrowserListListener = MediaDSIBrowserListener.this.controller.getBrowserListListener(requestParameterList.getClientID());
                if (iMediaBrowserListListener == null) {
                    MediaDSIBrowserListener.this.logger.log(100000, "[%1.responseList] [%2] No client with ID '%3' registered. Ignore.", (Object)MediaDSIBrowserListener.LOGCLASS, (long)MediaDSIBrowserListener.this.controller.getInstanceID(), (long)requestParameterList.getClientID());
                    return;
                }
                iMediaBrowserListListener.responseList(MediaListEntry.convert(listEntryArray), n);
            }

            public String toString() {
                return new StringBuffer().append(MediaDSIBrowserListener.this.logPrefixDispatcher).append("responseList").toString();
            }
        });
    }

    public void responseSearchList(final SearchListEntry[] searchListEntryArray, final int n) {
        this.dispatcher.execute(new Runnable(){

            public void run() {
                MediaDSIBrowserListener.this.logger.log(1000000, "[%1.responseSearchList] [%2] index='%3'.", (Object)MediaDSIBrowserListener.LOGCLASS, (long)MediaDSIBrowserListener.this.controller.getInstanceID(), (long)n);
                RequestParameterList requestParameterList = (RequestParameterList)MediaDSIBrowserListener.this.controller.getRequestSearchResultListHandler().dataResponded();
                if (requestParameterList == null || requestParameterList.isOutdated()) {
                    MediaDSIBrowserListener.this.logger.log(100000, "[%1.responseSearchList] [%2] Request is out dated. Ignore.", (Object)MediaDSIBrowserListener.LOGCLASS, (long)MediaDSIBrowserListener.this.controller.getInstanceID());
                    return;
                }
                if (searchListEntryArray == null) {
                    MediaDSIBrowserListener.this.logger.log(100000, "[%1.responseSearchList] [%2] Searchlist is null. Ignoring.", (Object)MediaDSIBrowserListener.LOGCLASS, (long)MediaDSIBrowserListener.this.controller.getInstanceID());
                    return;
                }
                LogUtil.logSearchList(MediaDSIBrowserListener.this.logger, searchListEntryArray);
                IMediaBrowserSearchListListener iMediaBrowserSearchListListener = MediaDSIBrowserListener.this.controller.getBrowserSearchListListener(requestParameterList.getClientID());
                if (iMediaBrowserSearchListListener == null) {
                    MediaDSIBrowserListener.this.logger.log(100000, "[%1.responseSearchList] [%2] No client with ID '%3' available. Ignoring.", (Object)MediaDSIBrowserListener.LOGCLASS, (long)MediaDSIBrowserListener.this.controller.getInstanceID(), (long)requestParameterList.getClientID());
                    return;
                }
                iMediaBrowserSearchListListener.responseSearchList(searchListEntryArray, n);
            }

            public String toString() {
                return new StringBuffer().append(MediaDSIBrowserListener.this.logPrefixDispatcher).append("responseSearchList").toString();
            }
        });
    }

    public void responseSearchListExt(final SearchListEntryExt[] searchListEntryExtArray, final int n) {
        this.dispatcher.execute(new Runnable(){

            public void run() {
                MediaDSIBrowserListener.this.logger.log(1000000, "[%1.responseSearchListExt] [%2] index='%3'.", (Object)MediaDSIBrowserListener.LOGCLASS, (long)MediaDSIBrowserListener.this.controller.getInstanceID(), (long)n);
                RequestParameterList requestParameterList = (RequestParameterList)MediaDSIBrowserListener.this.controller.getRequestSearchResultExtListHandler().dataResponded();
                if (requestParameterList == null || requestParameterList.isOutdated()) {
                    MediaDSIBrowserListener.this.logger.log(100000, "[%1.responseSearchListExt] [%2] Request is out dated. Ignore.", (Object)MediaDSIBrowserListener.LOGCLASS, (long)MediaDSIBrowserListener.this.controller.getInstanceID());
                    return;
                }
                if (searchListEntryExtArray == null) {
                    MediaDSIBrowserListener.this.logger.log(100000, "[%1.responseSearchListExt] [%2] Searchlist is null. Ignoring.", (Object)MediaDSIBrowserListener.LOGCLASS, (long)MediaDSIBrowserListener.this.controller.getInstanceID());
                    return;
                }
                LogUtil.logSearchExtList(MediaDSIBrowserListener.this.logger, searchListEntryExtArray);
                IMediaBrowserSearchListListener iMediaBrowserSearchListListener = MediaDSIBrowserListener.this.controller.getBrowserSearchListListener(requestParameterList.getClientID());
                if (iMediaBrowserSearchListListener == null) {
                    MediaDSIBrowserListener.this.logger.log(100000, "[%1.responseSearchListExt] [%2] No client with ID '%3' available. Ignoring.", (Object)MediaDSIBrowserListener.LOGCLASS, (long)MediaDSIBrowserListener.this.controller.getInstanceID(), (long)requestParameterList.getClientID());
                    return;
                }
                iMediaBrowserSearchListListener.responseSearchListExt(searchListEntryExtArray, n);
            }

            public String toString() {
                return new StringBuffer().append(MediaDSIBrowserListener.this.logPrefixDispatcher).append("responseSearchListExt").toString();
            }
        });
    }

    public void responseSelectSearchResult(final long l, final long l2, final boolean bl) {
        this.dispatcher.execute(new Runnable(){

            public void run() {
                Object object;
                if (MediaDSIBrowserListener.this.logger.isInfo()) {
                    object = new Buffer();
                    ((Buffer)object).append("seachID='").append(l).append("',entryID='").append(l2).append("',result='").append(bl).append("'");
                    MediaDSIBrowserListener.this.logger.log(1000000, "[%1.responseSelectSearchResult] [%3] %2", (Object)MediaDSIBrowserListener.LOGCLASS, object, (long)MediaDSIBrowserListener.this.controller.getInstanceID());
                }
                if ((object = MediaDSIBrowserListener.this.controller.getBrowserSearchListener()) == null) {
                    MediaDSIBrowserListener.this.logger.log(100000, "[%1.responseSelectSearchResult] No search listener registered!", (Object)MediaDSIBrowserListener.LOGCLASS);
                    return;
                }
                object.responseSelectSearchResult(l, l2, bl);
            }

            public String toString() {
                return new StringBuffer().append(MediaDSIBrowserListener.this.logPrefixDispatcher).append("responseSelectSearchResult").toString();
            }
        });
    }

    public void responseSetSearchCriteria(final int n, final boolean bl) {
        this.dispatcher.execute(new Runnable(){

            public void run() {
                Object object;
                if (MediaDSIBrowserListener.this.logger.isInfo()) {
                    object = new Buffer();
                    ((Buffer)object).append("mask='").append(n).append("',result='").append(bl).append("'");
                    MediaDSIBrowserListener.this.logger.log(1000000, "[%1.responseSetSearchCriteria] [%3] %2", (Object)MediaDSIBrowserListener.LOGCLASS, object, (long)MediaDSIBrowserListener.this.controller.getInstanceID());
                }
                if ((object = MediaDSIBrowserListener.this.controller.getBrowserSearchListener()) == null) {
                    MediaDSIBrowserListener.this.logger.log(100000, "[%1.responseSetSearchCriteria] No search listener registered!", (Object)MediaDSIBrowserListener.LOGCLASS);
                    return;
                }
                object.responseSetSearchCriteria(n, bl);
            }

            public String toString() {
                return new StringBuffer().append(MediaDSIBrowserListener.this.logPrefixDispatcher).append("responseSetSearchCriteria").toString();
            }
        });
    }

    public void responseSetSearchString(final String string, final boolean bl) {
        this.dispatcher.execute(new Runnable(){

            public void run() {
                MediaDSIBrowserListener.this.logger.log(1000000, "[%1.responseSetSearchString] [%3] '%2'", (Object)MediaDSIBrowserListener.LOGCLASS, (Object)string, (long)MediaDSIBrowserListener.this.controller.getInstanceID());
                IMediaBrowserSearchListener iMediaBrowserSearchListener = MediaDSIBrowserListener.this.controller.getBrowserSearchListener();
                if (iMediaBrowserSearchListener == null) {
                    MediaDSIBrowserListener.this.logger.log(100000, "[%1.responseSetSearchString] No search listener registered!", (Object)MediaDSIBrowserListener.LOGCLASS);
                    return;
                }
                iMediaBrowserSearchListener.responseSetSearchString(string, bl);
            }

            public String toString() {
                return new StringBuffer().append(MediaDSIBrowserListener.this.logPrefixDispatcher).append("responseSetSearchString").toString();
            }
        });
    }

    public void updateSearchSize(final int n, final int n2, final int n3, final int n4, final int n5) {
        this.dispatcher.execute(new Runnable(){

            public void run() {
                Object object;
                if (!MediaDSIBrowserListener.this.isUpdateRelevant("updateSearchSize", MediaDSIBrowserListener.this.controller.getInstanceID(), n5)) {
                    return;
                }
                if (MediaDSIBrowserListener.this.logger.isInfo()) {
                    object = new Buffer();
                    ((Buffer)object).append("#total='").append(n).append("',#artist='").append(n2).append("',#album='").append(n3).append("',#album='").append(n3).append("',#title='").append(n4).append("'");
                    MediaDSIBrowserListener.this.logger.log(1000000, "[%1.updateSearchSize] [%3] %2", (Object)MediaDSIBrowserListener.LOGCLASS, object, (long)MediaDSIBrowserListener.this.controller.getInstanceID());
                }
                if ((object = MediaDSIBrowserListener.this.controller.getBrowserSearchListener()) == null) {
                    MediaDSIBrowserListener.this.logger.log(100000, "[%1.updateSearchSize] No search listener registered!", (Object)MediaDSIBrowserListener.LOGCLASS);
                    return;
                }
                object.updateSearchSize(n, n2, n3, n4);
            }

            public String toString() {
                return new StringBuffer().append(MediaDSIBrowserListener.this.logPrefixDispatcher).append("updateSearchSize").toString();
            }
        });
    }

    public void updateSearchSpellerState(final int n, final int n2) {
        this.dispatcher.execute(new Runnable(){

            public void run() {
                if (!MediaDSIBrowserListener.this.isUpdateRelevant("updateSearchSpellerState", MediaDSIBrowserListener.this.controller.getInstanceID(), n2)) {
                    return;
                }
                MediaDSIBrowserListener.this.logger.log(1000000, "[%1.updateSearchSpellerState] [%2] '%3'.", (Object)MediaDSIBrowserListener.LOGCLASS, (long)MediaDSIBrowserListener.this.controller.getInstanceID(), (long)n);
                IMediaBrowserSearchListener iMediaBrowserSearchListener = MediaDSIBrowserListener.this.controller.getBrowserSearchListener();
                if (iMediaBrowserSearchListener == null) {
                    MediaDSIBrowserListener.this.logger.log(100000, "[%1.updateSearchSpellerState] No search listener registered!", (Object)MediaDSIBrowserListener.LOGCLASS);
                    return;
                }
                iMediaBrowserSearchListener.updateSearchSpellerState(n);
            }

            public String toString() {
                return new StringBuffer().append(MediaDSIBrowserListener.this.logPrefixDispatcher).append("updateSearchSpellerState").toString();
            }
        });
    }

    public void selectionResult(final int n, final int n2, final boolean bl, final long l, final long l2, final long l3, final long l4, final long l5) {
        this.dispatcher.execute(new Runnable(){

            public void run() {
                Object object;
                if (MediaDSIBrowserListener.this.logger.isInfo()) {
                    object = new Buffer(20);
                    ((Buffer)object).append("result='").append(n).append("',state='").append(n2).append("',#entriesSelected='").append(l4).append("'");
                    MediaDSIBrowserListener.this.logger.log(1000000, "[%1.selectionResult] [%3] '%2'", (Object)MediaDSIBrowserListener.LOGCLASS, object, (Object)new Integer(MediaDSIBrowserListener.this.controller.getInstanceID()));
                }
                if ((object = MediaDSIBrowserListener.this.controller.getBrowserStateListener()) == null) {
                    MediaDSIBrowserListener.this.logger.log(100000, "[%1.selectionResult] No state listener registered!", (Object)MediaDSIBrowserListener.LOGCLASS);
                    return;
                }
                object.selectionResult(n, n2, bl, l, l2, l3, l4, l5);
            }

            public String toString() {
                return new StringBuffer().append(MediaDSIBrowserListener.this.logPrefixDispatcher).append("selectionResult").toString();
            }
        });
    }

    public void updateBrowseFolder(final ListEntry[] listEntryArray, int n) {
        if (!this.isUpdateRelevant("updateBrowseFolder", this.controller.getInstanceID(), n)) {
            return;
        }
        this.dispatcher.execute(new Runnable(){

            public void run() {
                IMediaBrowserStateListener iMediaBrowserStateListener;
                if (listEntryArray == null) {
                    MediaDSIBrowserListener.this.logger.log(100000, "[%1.updateBrowseFolder] [%2] Folder is null", (Object)MediaDSIBrowserListener.LOGCLASS, (long)MediaDSIBrowserListener.this.controller.getInstanceID());
                    return;
                }
                if (listEntryArray.length <= 0) {
                    MediaDSIBrowserListener.this.logger.log(100000, "[%1.updateBrowseFolder] [%2] Folder length <= 0", (Object)MediaDSIBrowserListener.LOGCLASS, (long)MediaDSIBrowserListener.this.controller.getInstanceID());
                    return;
                }
                if (MediaDSIBrowserListener.this.logger.isInfo()) {
                    MediaDSIBrowserListener.this.logger.log(1000000, "[%1.updateBrowseFolder] [%3] '%2'.", (Object)MediaDSIBrowserListener.LOGCLASS, (Object)LogUtil.listEntryToStr(listEntryArray), (long)MediaDSIBrowserListener.this.controller.getInstanceID());
                }
                if ((iMediaBrowserStateListener = MediaDSIBrowserListener.this.controller.getBrowserStateListener()) == null) {
                    MediaDSIBrowserListener.this.logger.log(100000, "[%1.updateBrowseFolder] No state listener registered!", (Object)MediaDSIBrowserListener.LOGCLASS);
                    return;
                }
                iMediaBrowserStateListener.updateBrowseFolder(MediaListEntry.convert(listEntryArray));
            }

            public String toString() {
                return new StringBuffer().append(MediaDSIBrowserListener.this.logPrefixDispatcher).append("updateBrowseFolder").toString();
            }
        });
    }

    public void updateBrowseMedia(final long l, final long l2, int n) {
        if (n == 2 && l != 0L && l2 != 0L) {
            this.dispatcher.execute(new AbstractDispatcherRunnable(new StringBuffer().append(this.logPrefixDispatcher).append("updateBrowseMedia (INVALID)").toString()){

                public void run() {
                    MediaDSIBrowserListener.this.logger.log(1000000, "[%1.updateBrowseMedia] [%2] Invalidation.", (Object)MediaDSIBrowserListener.LOGCLASS, (Object)new Integer(MediaDSIBrowserListener.this.controller.getInstanceID()));
                    MediaDSIBrowserListener.this.controller.browserInvalidated(l, l2);
                }
            });
            return;
        }
        if (!this.isUpdateRelevant("updateBrowseMedia", this.controller.getInstanceID(), n)) {
            return;
        }
        this.dispatcher.execute(new Runnable(){

            public void run() {
                if (MediaDSIBrowserListener.this.logger.isInfo()) {
                    MediaDSIBrowserListener.this.logger.log(1000000, "[%1.updateBrowseMedia] [%4] deviceID='%2', mediaID='%3'.", (Object)MediaDSIBrowserListener.LOGCLASS, (Object)String.valueOf(l), (Object)String.valueOf(l2), (Object)String.valueOf(MediaDSIBrowserListener.this.controller.getInstanceID()));
                }
                MediaDSIBrowserListener.this.controller.browserActivated(l, l2);
            }

            public String toString() {
                return new StringBuffer().append(MediaDSIBrowserListener.this.logPrefixDispatcher).append("updateBrowseMedia").toString();
            }
        });
    }

    public void updateBrowseMode(final int n, int n2) {
        if (!this.isUpdateRelevant("updateBrowseMode", this.controller.getInstanceID(), n2)) {
            return;
        }
        this.dispatcher.execute(new Runnable(){

            public void run() {
                MediaDSIBrowserListener.this.logger.log(1000000, "[%1.updateBrowseMode] [%3] '%2'.", (Object)MediaDSIBrowserListener.LOGCLASS, (long)n, (long)MediaDSIBrowserListener.this.controller.getInstanceID());
                IMediaBrowserStateListener iMediaBrowserStateListener = MediaDSIBrowserListener.this.controller.getBrowserStateListener();
                if (iMediaBrowserStateListener == null) {
                    MediaDSIBrowserListener.this.logger.log(100000, "[%1.updateBrowseMode] No state listener registered!", (Object)MediaDSIBrowserListener.LOGCLASS);
                    return;
                }
                iMediaBrowserStateListener.updateBrowseMode(n);
            }

            public String toString() {
                return new StringBuffer().append(MediaDSIBrowserListener.this.logPrefixDispatcher).append("updateBrowseMode").toString();
            }
        });
    }

    public void updateContentFilter(final int n, int n2) {
        if (!this.isUpdateRelevant("updateContentFilter", this.controller.getInstanceID(), n2)) {
            return;
        }
        this.dispatcher.execute(new Runnable(){

            public void run() {
                IMediaBrowserStateListener iMediaBrowserStateListener;
                if (MediaDSIBrowserListener.this.logger.isInfo()) {
                    MediaDSIBrowserListener.this.logger.log(1000000, "[%1.updateContentFilter] [%3] '%2'.", (Object)MediaDSIBrowserListener.LOGCLASS, (long)n, (long)MediaDSIBrowserListener.this.controller.getInstanceID());
                }
                if ((iMediaBrowserStateListener = MediaDSIBrowserListener.this.controller.getBrowserStateListener()) == null) {
                    MediaDSIBrowserListener.this.logger.log(100000, "[%1.updateContentFilter] No state listener registered!", (Object)MediaDSIBrowserListener.LOGCLASS);
                    return;
                }
                iMediaBrowserStateListener.updateContentFilter(n);
            }

            public String toString() {
                return new StringBuffer().append(MediaDSIBrowserListener.this.logPrefixDispatcher).append("updateContentFilter").toString();
            }
        });
    }

    public void updateListSize(final int n, final int n2, int n3) {
        if (!this.isUpdateRelevant("updateListSize", this.controller.getInstanceID(), n3)) {
            return;
        }
        this.dispatcher.execute(new Runnable(){

            public void run() {
                if (MediaDSIBrowserListener.this.logger.isInfo()) {
                    MediaDSIBrowserListener.this.logger.log(1000000, "[%1.updateListSize] [%4] size='%2', flags='%3'.", (Object)MediaDSIBrowserListener.LOGCLASS, (Object)String.valueOf(n), (Object)String.valueOf(n2), (Object)String.valueOf(MediaDSIBrowserListener.this.controller.getInstanceID()));
                }
                if (n < 0) {
                    MediaDSIBrowserListener.this.logger.log(100000, "[%1.updateListSize] [%2] List size < 0. Ignore.", (Object)MediaDSIBrowserListener.LOGCLASS, (long)MediaDSIBrowserListener.this.controller.getInstanceID());
                    return;
                }
                IMediaBrowserStateListener iMediaBrowserStateListener = MediaDSIBrowserListener.this.controller.getBrowserStateListener();
                if (iMediaBrowserStateListener == null) {
                    MediaDSIBrowserListener.this.logger.log(100000, "[%1.updateListSize] No state listener registered!", (Object)MediaDSIBrowserListener.LOGCLASS);
                    return;
                }
                iMediaBrowserStateListener.updateListSize(n, n2);
            }

            public String toString() {
                return new StringBuffer().append(MediaDSIBrowserListener.this.logPrefixDispatcher).append("updateListSize").toString();
            }
        });
    }

    public void asyncException(final int n, final String string, final int n2) {
        this.dispatcher.execute(new Runnable(){

            public void run() {
                if (MediaDSIBrowserListener.this.logger.getCurrentLogThreshold() >= 1000000) {
                    MediaDSIBrowserListener.this.logger.log(1000000, "[%1.asyncException] [%2] errorCode='%3',type='%4'.", (Object)MediaDSIBrowserListener.LOGCLASS, (Object)String.valueOf(MediaDSIBrowserListener.this.controller.getInstanceID()), (Object)String.valueOf(n), (Object)String.valueOf(n2));
                    MediaDSIBrowserListener.this.logger.log(1000000, "[%1.asyncException] [%3] msg='%2'.", (Object)MediaDSIBrowserListener.LOGCLASS, (Object)string, (long)MediaDSIBrowserListener.this.controller.getInstanceID());
                }
                switch (n2) {
                    case 1008: 
                    case 2000: {
                        IMediaBrowserListListener iMediaBrowserListListener;
                        IRequestParameter iRequestParameter = MediaDSIBrowserListener.this.controller.getRequestListHandler().dataResponded();
                        if (iRequestParameter == null || (iMediaBrowserListListener = MediaDSIBrowserListener.this.controller.getBrowserListListener(iRequestParameter.getClientID())) == null) break;
                        iMediaBrowserListListener.errorListRequestAborted();
                        break;
                    }
                    case 1009: 
                    case 2002: {
                        IMediaBrowserListListener iMediaBrowserListListener;
                        IRequestParameter iRequestParameter = MediaDSIBrowserListener.this.controller.getRequestPickListHandler().dataResponded();
                        if (iRequestParameter == null || (iMediaBrowserListListener = MediaDSIBrowserListener.this.controller.getBrowserListListener(iRequestParameter.getClientID())) == null) break;
                        iMediaBrowserListListener.errorPickListRequestAborted();
                        break;
                    }
                    case 1007: {
                        IMediaBrowserStateListener iMediaBrowserStateListener = MediaDSIBrowserListener.this.controller.getBrowserStateListener();
                        if (iMediaBrowserStateListener == null) {
                            return;
                        }
                        iMediaBrowserStateListener.errorFolderChange();
                        break;
                    }
                    case 1001: 
                    case 1003: {
                        IMediaBrowserStateListener iMediaBrowserStateListener = MediaDSIBrowserListener.this.controller.getBrowserStateListener();
                        if (iMediaBrowserStateListener == null) {
                            return;
                        }
                        iMediaBrowserStateListener.errorSelection();
                        break;
                    }
                    case 1000: 
                    case 1004: 
                    case 1005: {
                        IMediaBrowserStateListener iMediaBrowserStateListener = MediaDSIBrowserListener.this.controller.getBrowserStateListener();
                        if (iMediaBrowserStateListener == null) {
                            return;
                        }
                        iMediaBrowserStateListener.errorBrowseMode();
                        break;
                    }
                    case 1006: {
                        IMediaBrowserListener iMediaBrowserListener = MediaDSIBrowserListener.this.controller.getBrowserListener();
                        if (iMediaBrowserListener == null) {
                            return;
                        }
                        iMediaBrowserListener.asyncException(n, string, n2);
                        break;
                    }
                }
            }

            public String toString() {
                return new StringBuffer().append(MediaDSIBrowserListener.this.logPrefixDispatcher).append("asyncException").toString();
            }
        });
    }

    public void updateAlphabeticalIndex(final CharacterInfo[] characterInfoArray, int n) {
        if (!this.isUpdateRelevant("updateAlphabeticalIndex", this.controller.getInstanceID(), n)) {
            return;
        }
        this.dispatcher.execute(new Runnable(){

            public void run() {
                if (MediaDSIBrowserListener.this.logger.isInfo()) {
                    MediaDSIBrowserListener.this.logger.log(1000000, "[%1.updateAlphabeticalIndex] [%2]", (Object)MediaDSIBrowserListener.LOGCLASS, (Object)String.valueOf(MediaDSIBrowserListener.this.controller.getInstanceID()));
                }
                if (null == characterInfoArray) {
                    MediaDSIBrowserListener.this.logger.log(100000, "[%1.updateAlphabeticalIndex] Invalid character information", (Object)MediaDSIBrowserListener.LOGCLASS);
                    return;
                }
                IMediaBrowserStateListener iMediaBrowserStateListener = MediaDSIBrowserListener.this.controller.getBrowserStateListener();
                if (iMediaBrowserStateListener == null) {
                    return;
                }
                iMediaBrowserStateListener.updateAlphabeticalIndex(characterInfoArray);
            }

            public String toString() {
                return new StringBuffer().append(MediaDSIBrowserListener.this.logPrefixDispatcher).append("updateAlphabeticalIndex").toString();
            }
        });
    }

    public void responsePickList(final ListEntry[] listEntryArray) {
        this.dispatcher.execute(new Runnable(){

            public void run() {
                MediaDSIBrowserListener.this.logger.log(1000000, "[%1.responsePickList] [%2] ", (Object)MediaDSIBrowserListener.LOGCLASS, (long)MediaDSIBrowserListener.this.controller.getInstanceID());
                RequestPickListParameterList requestPickListParameterList = (RequestPickListParameterList)MediaDSIBrowserListener.this.controller.getRequestPickListHandler().dataResponded();
                if (requestPickListParameterList == null || requestPickListParameterList.isOutdated()) {
                    MediaDSIBrowserListener.this.logger.log(100000, "[%1.responsePickList] [%2] Request is out dated. Ignore.", (Object)MediaDSIBrowserListener.LOGCLASS, (long)MediaDSIBrowserListener.this.controller.getInstanceID());
                    return;
                }
                if (listEntryArray == null) {
                    MediaDSIBrowserListener.this.logger.log(100000, "[%1.responsePickList] [%2] Response list is null. Ignore.", (Object)MediaDSIBrowserListener.LOGCLASS, (long)MediaDSIBrowserListener.this.controller.getInstanceID());
                    return;
                }
                LogUtil.logEntryList(MediaDSIBrowserListener.this.logPrefixResponsePickList, MediaDSIBrowserListener.this.logger, listEntryArray);
                IMediaBrowserListListener iMediaBrowserListListener = MediaDSIBrowserListener.this.controller.getBrowserListListener(requestPickListParameterList.getClientID());
                if (iMediaBrowserListListener == null) {
                    MediaDSIBrowserListener.this.logger.log(100000, "[%1.responsePickList] [%2] No client with ID '%3' registered. Ignore.", (Object)MediaDSIBrowserListener.LOGCLASS, (long)MediaDSIBrowserListener.this.controller.getInstanceID(), (long)requestPickListParameterList.getClientID());
                    return;
                }
                iMediaBrowserListListener.responsePickList(MediaListEntry.convert(listEntryArray));
            }

            public String toString() {
                return new StringBuffer().append(MediaDSIBrowserListener.this.logPrefixDispatcher).append("responsePickList").toString();
            }
        });
    }

    public void responseFullyQualifiedName(long l, String string) {
    }
}

