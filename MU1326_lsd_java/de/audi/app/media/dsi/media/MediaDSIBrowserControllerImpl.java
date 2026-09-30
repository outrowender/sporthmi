/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media;

import de.audi.app.media.dsi.AbstractDSIController;
import de.audi.app.media.dsi.media.IMediaBrowserListListener;
import de.audi.app.media.dsi.media.IMediaBrowserListener;
import de.audi.app.media.dsi.media.IMediaBrowserSearchListListener;
import de.audi.app.media.dsi.media.IMediaBrowserSearchListener;
import de.audi.app.media.dsi.media.IMediaBrowserStateListener;
import de.audi.app.media.dsi.media.IMediaDSIBrowserController;
import de.audi.app.media.dsi.media.MediaDSIBrowserListener;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.app.media.dsi.media.NullDSIMediaBrowser;
import de.audi.app.media.dsi.media.requests.MediaDSIBrowserRequestListHandler;
import de.audi.app.media.dsi.media.requests.MediaDSIBrowserRequestPickListHandler;
import de.audi.app.media.dsi.media.requests.MediaDSIBrowserSearchResultExtListHandler;
import de.audi.app.media.dsi.media.requests.MediaDSIBrowserSearchResultListHandler;
import de.audi.app.media.dsi.media.requests.RequestParameterList;
import de.audi.app.media.dsi.media.requests.RequestPickListParameterList;
import de.audi.app.media.logger.LogUtil;
import de.audi.app.media.osgi.IServiceManager;
import de.audi.app.media.source.MediaSourceSlot;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import java.util.HashMap;
import java.util.Map;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.media.DSIMediaBrowser;
import org.dsi.ifc.media.ListEntry;

public class MediaDSIBrowserControllerImpl
extends AbstractDSIController
implements IMediaDSIBrowserController {
    private static final String LOGCLASS = "MediaDSIBrowserControllerImpl";
    private final NullDSIMediaBrowser nullDSIMediaBrowser;
    private final MediaDSIBrowserListener dsiListener;
    private final Object sourceActivationMutex = new Object();
    private final MediaDSIBrowserRequestListHandler requestListHandler;
    private final MediaDSIBrowserRequestPickListHandler requestPickListHandler;
    private final MediaDSIBrowserSearchResultListHandler requestSearchResultListHandler;
    private final MediaDSIBrowserSearchResultExtListHandler requestSearchResultExtListHandler;
    private volatile DSIMediaBrowser dsiMediaBrowser = null;
    private volatile IMediaBrowserStateListener browserStateListener;
    private volatile IMediaBrowserListener browserListener;
    private volatile IMediaBrowserSearchListener browserSearchListener;
    private Map browserSearchListListener;
    private Map browserListListener;
    private MediaSourceSlot requestedActiveBrowseSourceSlot;
    static /* synthetic */ Class class$org$dsi$ifc$media$DSIMediaBrowserListener;
    static /* synthetic */ Class class$org$dsi$ifc$media$DSIMediaBrowser;

    public MediaDSIBrowserControllerImpl(int n, IServiceManager iServiceManager, IFrameworkAccess iFrameworkAccess, DispatcherBase dispatcherBase, LogChannel logChannel) {
        super(n, iServiceManager, iFrameworkAccess, dispatcherBase, true, logChannel);
        this.dsiListener = new MediaDSIBrowserListener(this, logChannel, dispatcherBase);
        this.requestListHandler = new MediaDSIBrowserRequestListHandler(logChannel, n);
        this.requestPickListHandler = new MediaDSIBrowserRequestPickListHandler(logChannel, n);
        this.requestSearchResultListHandler = new MediaDSIBrowserSearchResultListHandler(logChannel, n);
        this.requestSearchResultExtListHandler = new MediaDSIBrowserSearchResultExtListHandler(logChannel, n);
        this.browserListListener = new HashMap(2);
        this.browserSearchListListener = new HashMap(2);
        this.nullDSIMediaBrowser = new NullDSIMediaBrowser(logChannel);
        this.dsiMediaBrowser = this.nullDSIMediaBrowser;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void deinit() {
        super.deinit();
        this.logger.log(1000000, "[%1.deinit] Deinit.", (Object)LOGCLASS);
        this.clearAttributeNotification(this.dsiMediaBrowser);
        this.browserStateListener = null;
        this.browserListener = null;
        Map map = this.browserListListener;
        synchronized (map) {
            this.browserListListener.clear();
        }
        map = this.browserSearchListListener;
        synchronized (map) {
            this.browserSearchListListener.clear();
        }
    }

    public void addDSIService(DSIBase dSIBase) {
        this.logger.log(1000000, "[%1.addDSIService] [%3] '%2'.", (Object)LOGCLASS, (Object)dSIBase, (long)this.getInstanceID());
        this.dsiMediaBrowser = (DSIMediaBrowser)dSIBase;
        this.requestListHandler.setDSI(this.dsiMediaBrowser);
        this.requestPickListHandler.setDSI(this.dsiMediaBrowser);
        this.requestSearchResultListHandler.setDSI(this.dsiMediaBrowser);
        this.requestSearchResultExtListHandler.setDSI(this.dsiMediaBrowser);
        this.registerAttributeNotifications(dSIBase);
    }

    protected void removeDSIService() {
        this.logger.log(1000000, "[%1.removeDSIService] [%2] DSI service removed.", (Object)LOGCLASS, (long)this.getInstanceID());
        this.dsiMediaBrowser = this.nullDSIMediaBrowser;
        this.requestListHandler.setDSI(null);
        this.requestPickListHandler.setDSI(null);
        this.requestSearchResultListHandler.setDSI(null);
        this.requestSearchResultExtListHandler.setDSI(null);
    }

    protected void registerAttributeNotifications(DSIBase dSIBase) {
        this.logger.log(10000000, "[%1.registerAttributeNotifications] [%2]", (Object)LOGCLASS, (long)this.getInstanceID());
        this.dsiMediaBrowser.setNotification(new int[]{4, 3, 1, 2, 5, 7, 6, 8}, this.getDSIListener());
    }

    protected Class getDSIListenerClass() {
        return class$org$dsi$ifc$media$DSIMediaBrowserListener == null ? (class$org$dsi$ifc$media$DSIMediaBrowserListener = MediaDSIBrowserControllerImpl.class$("org.dsi.ifc.media.DSIMediaBrowserListener")) : class$org$dsi$ifc$media$DSIMediaBrowserListener;
    }

    protected DSIListener getDSIListener() {
        return this.dsiListener;
    }

    protected Class getDSIServiceClass() {
        return class$org$dsi$ifc$media$DSIMediaBrowser == null ? (class$org$dsi$ifc$media$DSIMediaBrowser = MediaDSIBrowserControllerImpl.class$("org.dsi.ifc.media.DSIMediaBrowser")) : class$org$dsi$ifc$media$DSIMediaBrowser;
    }

    protected MediaDSIBrowserRequestListHandler getRequestListHandler() {
        return this.requestListHandler;
    }

    protected MediaDSIBrowserRequestPickListHandler getRequestPickListHandler() {
        return this.requestPickListHandler;
    }

    protected MediaDSIBrowserSearchResultListHandler getRequestSearchResultListHandler() {
        return this.requestSearchResultListHandler;
    }

    protected MediaDSIBrowserSearchResultExtListHandler getRequestSearchResultExtListHandler() {
        return this.requestSearchResultExtListHandler;
    }

    public void setBrowserStateListener(IMediaBrowserStateListener iMediaBrowserStateListener) {
        this.logger.log(1000000, "[%1.setBrowserStateListener] [%3] '%2'", (Object)LOGCLASS, (Object)iMediaBrowserStateListener, (long)this.getInstanceID());
        this.browserStateListener = iMediaBrowserStateListener;
    }

    protected IMediaBrowserStateListener getBrowserStateListener() {
        return this.browserStateListener;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void addBrowserListListener(IMediaBrowserListListener iMediaBrowserListListener) {
        this.logger.log(1000000, "[%1.addBrowserListListener] [%3] '%2'", (Object)LOGCLASS, (Object)iMediaBrowserListListener, (long)this.getInstanceID());
        Map map = this.browserListListener;
        synchronized (map) {
            this.browserListListener.put(new Integer(iMediaBrowserListListener.getClientID()), iMediaBrowserListListener);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void removeAllBrowserListListener() {
        this.logger.log(1000000, "[%1.removeAllBrowserListListener] [%2].", (Object)LOGCLASS, (long)this.getInstanceID());
        Map map = this.browserListListener;
        synchronized (map) {
            this.browserListListener.clear();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected IMediaBrowserListListener getBrowserListListener(int n) {
        Map map = this.browserListListener;
        synchronized (map) {
            return (IMediaBrowserListListener)this.browserListListener.get(new Integer(n));
        }
    }

    public void setBrowserListener(IMediaBrowserListener iMediaBrowserListener) {
        this.logger.log(1000000, "[%1.setBrowserListener] [%3] '%2'", (Object)LOGCLASS, (Object)iMediaBrowserListener, (long)this.getInstanceID());
        this.browserListener = iMediaBrowserListener;
    }

    protected IMediaBrowserListener getBrowserListener() {
        return this.browserListener;
    }

    public void setBrowserSearchListener(IMediaBrowserSearchListener iMediaBrowserSearchListener) {
        this.logger.log(1000000, "[%1.setBrowserSearchListener] [%3] '%2'.", (Object)LOGCLASS, (Object)iMediaBrowserSearchListener, (long)this.getInstanceID());
        this.browserSearchListener = iMediaBrowserSearchListener;
    }

    protected IMediaBrowserSearchListener getBrowserSearchListener() {
        return this.browserSearchListener;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void addBrowserSearchListListener(IMediaBrowserSearchListListener iMediaBrowserSearchListListener) {
        this.logger.log(1000000, "[%1.addBrowserSearchListListener] [%3] client '%2' added.", (Object)LOGCLASS, (long)iMediaBrowserSearchListListener.getClientID(), (long)this.getInstanceID());
        Map map = this.browserSearchListListener;
        synchronized (map) {
            this.browserSearchListListener.put(new Integer(iMediaBrowserSearchListListener.getClientID()), iMediaBrowserSearchListListener);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void removeBrowserSearchListListener(IMediaBrowserSearchListListener iMediaBrowserSearchListListener) {
        this.logger.log(1000000, "[%1.removeBrowserSearchListListener] [%3] client '%2' removed.", (Object)LOGCLASS, (long)iMediaBrowserSearchListListener.getClientID(), (long)this.getInstanceID());
        Map map = this.browserSearchListListener;
        synchronized (map) {
            this.browserSearchListListener.remove(new Integer(iMediaBrowserSearchListListener.getClientID()));
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected IMediaBrowserSearchListListener getBrowserSearchListListener(int n) {
        Map map = this.browserSearchListListener;
        synchronized (map) {
            return (IMediaBrowserSearchListListener)this.browserSearchListListener.get(new Integer(n));
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void activate(MediaSourceSlot mediaSourceSlot) {
        this.logger.log(1000000, "[%1.activate] [%3] '%2'", (Object)LOGCLASS, (Object)mediaSourceSlot, (long)this.getInstanceID());
        if (mediaSourceSlot == null) {
            throw new IllegalArgumentException();
        }
        Object object = this.sourceActivationMutex;
        synchronized (object) {
            this.requestedActiveBrowseSourceSlot = mediaSourceSlot;
            if (this.logger.isInfo()) {
                this.logger.log(1000000, "[%1.activate] [%4] setBrowseMedia(%2,%3)", (Object)LOGCLASS, (Object)String.valueOf(this.requestedActiveBrowseSourceSlot.getDeviceID()), (Object)String.valueOf(this.requestedActiveBrowseSourceSlot.getMediaID()), (Object)String.valueOf(this.getInstanceID()));
            }
            this.dsiMediaBrowser.setBrowseMedia(this.requestedActiveBrowseSourceSlot.getDeviceID(), this.requestedActiveBrowseSourceSlot.getMediaID());
        }
    }

    public void deactivate() {
        this.logger.log(1000000, "[%1.deactivate] [%2] setBrowseMedia(0,0)", (Object)LOGCLASS, (Object)String.valueOf(this.getInstanceID()));
        if (7 != this.getInstanceID()) {
            this.dsiMediaBrowser.setBrowseMedia(0L, 0L);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void browserActivated(long l, long l2) {
        IMediaBrowserListener iMediaBrowserListener = this.getBrowserListener();
        Object object = this.sourceActivationMutex;
        synchronized (object) {
            if (l == 0L && l2 == 0L) {
                if (iMediaBrowserListener == null) {
                    return;
                }
                iMediaBrowserListener.browseSourceDeactivated();
                return;
            }
            if (this.requestedActiveBrowseSourceSlot == null || this.requestedActiveBrowseSourceSlot.getDeviceID() != l || this.requestedActiveBrowseSourceSlot.getMediaID() != l2) {
                this.logger.log(1000000, "[%1.browserActivated] [%4] Not current requested slot activated (deviceID='%2',mediaID='%3'). Ignore.", (Object)LOGCLASS, (Object)String.valueOf(l), (Object)String.valueOf(l2), (Object)String.valueOf(this.getInstanceID()));
                return;
            }
        }
        this.requestListHandler.reset();
        this.requestPickListHandler.reset();
        this.requestSearchResultListHandler.reset();
        this.requestSearchResultExtListHandler.reset();
        if (iMediaBrowserListener == null) {
            return;
        }
        iMediaBrowserListener.browseSourceActivated();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void browserInvalidated(long l, long l2) {
        Object object = this.sourceActivationMutex;
        synchronized (object) {
            if (this.requestedActiveBrowseSourceSlot == null || this.requestedActiveBrowseSourceSlot.getDeviceID() != l || this.requestedActiveBrowseSourceSlot.getMediaID() != l2) {
                this.logger.log(1000000, "[%1.browserInvalidated] [%4] Not current requested slot (deviceID='%2',mediaID='%3'). Ignore.", (Object)LOGCLASS, (Object)String.valueOf(l), (Object)String.valueOf(l2), (Object)String.valueOf(this.getInstanceID()));
                return;
            }
        }
        object = this.getBrowserListener();
        if (object == null) {
            return;
        }
        object.browseSourceInvalidated();
    }

    public void addSelection(boolean bl, int n, long l, int n2, boolean bl2) {
        if (this.logger.isInfo()) {
            Buffer buffer = new Buffer();
            buffer.append("[").append(this.getInstanceID()).append("] '");
            buffer.append(bl ? "SELECT" : "DESELECT").append("','").append(n == 1 ? "ALL" : "INDEX");
            buffer.append("',entryID='").append(l).append("',cT='").append(n2).append("','").append(bl2).append("'");
            this.logger.log(1000000, "[%1.addSelection] %2", (Object)LOGCLASS, (Object)buffer);
        }
        this.dsiMediaBrowser.addSelection(bl, n, l, n2, bl2);
    }

    public void changeFolder(MediaListEntry[] mediaListEntryArray) {
        if (mediaListEntryArray == null) {
            this.logger.log(100000, "[%1.changeFolder] [%2] Folder path is null. Ignore.", (Object)LOGCLASS, (long)this.getInstanceID());
            throw new IllegalArgumentException();
        }
        if (mediaListEntryArray.length == 0) {
            this.logger.log(100000, "[%1.changeFolder] [%2] Folder path length is 0. Ignore.", (Object)LOGCLASS, (long)this.getInstanceID());
            throw new IllegalArgumentException();
        }
        ListEntry[] listEntryArray = MediaListEntry.convert(mediaListEntryArray);
        if (this.logger.isInfo()) {
            this.logger.log(1000000, "[%1.changeFolder] [%3] '%2'.", (Object)LOGCLASS, (Object)LogUtil.listEntryToStr(listEntryArray), (long)this.getInstanceID());
        }
        this.dsiMediaBrowser.changeFolder(listEntryArray);
    }

    public void enableRecurseSubdirectories(boolean bl) {
        this.logger.log(1000000, "[%2.enableRecurseSubdirectories] [%3] '%1'", bl, (Object)LOGCLASS, (Object)String.valueOf(this.getInstanceID()));
        this.dsiMediaBrowser.enableRecurseSubdirectories(bl);
    }

    public void requestList(long l, int n, int n2, int n3, int n4) {
        this.logger.log(1000000, "[%1.requestList] [%2]", (Object)LOGCLASS, (long)this.getInstanceID());
        this.requestListHandler.request(new RequestParameterList(l, n, n2, n3, n4));
    }

    public void discardListRequest(int n) {
        this.requestListHandler.discard(n);
    }

    public void requestPickList(long[] lArray, int n) {
        this.logger.log(1000000, "[%1.requestPickList] [%2]", (Object)LOGCLASS, (long)this.getInstanceID());
        this.requestPickListHandler.request(new RequestPickListParameterList(lArray, n));
    }

    public void discardPickListRequest(int n) {
        this.requestPickListHandler.discard(n);
    }

    public void resetSelection() {
        this.logger.log(1000000, "[%1.resetSelection] [%2]", (Object)LOGCLASS, (long)this.getInstanceID());
        this.dsiMediaBrowser.resetSelection();
    }

    public void setBrowseMode(int n) {
        this.logger.log(1000000, "[%1.setBrowseMode] [%3] '%2'", (Object)LOGCLASS, (long)n, (long)this.getInstanceID());
        this.dsiMediaBrowser.setBrowseMode(n);
    }

    public void setContentFilter(int n) {
        this.logger.log(1000000, "[%1.setContentFilter] [%3] '%2'", (Object)LOGCLASS, (long)n, (long)this.getInstanceID());
        this.dsiMediaBrowser.setContentFilter(n);
    }

    public void activateSearchSpeller() {
        this.logger.log(1000000, "[%1.activateSearchSpeller] [%2]", (Object)LOGCLASS, (long)this.getInstanceID());
        this.dsiMediaBrowser.activateSearchSpeller();
    }

    public void deactivateSearchSpeller() {
        this.logger.log(1000000, "[%1.deactivateSearchSpeller] [%2]", (Object)LOGCLASS, (long)this.getInstanceID());
        this.dsiMediaBrowser.deactivateSearchSpeller();
    }

    public void setSearchCriteria(int n) {
        this.logger.log(1000000, "[%1.setSearchCriteria] [%2] '%3'.", (Object)LOGCLASS, (long)this.getInstanceID(), (long)n);
        this.dsiMediaBrowser.setSearchCriteria(n);
    }

    public void setSearchString(String string) {
        this.logger.log(1000000, "[%1.setSearchString] [%3] '%2'.", (Object)LOGCLASS, (Object)string, (long)this.getInstanceID());
        this.dsiMediaBrowser.setSearchString(string);
    }

    public void resetSearchString() {
        this.logger.log(1000000, "[%1.resetSearchString] [%2]", (Object)LOGCLASS, (long)this.getInstanceID());
        this.dsiMediaBrowser.resetSearchString();
    }

    public void selectSearchResult(long l) {
        this.logger.log(1000000, "[%1.selectSearchResult] [%2] '%3'.", (Object)LOGCLASS, (long)this.getInstanceID(), l);
        this.dsiMediaBrowser.selectSearchResult(l);
    }

    public void requestSearchList(long l, int n, int n2, int n3) {
        this.requestSearchResultListHandler.request(new RequestParameterList(l, 0, n, n2, n3));
    }

    public void requestSearchListExt(long l, int n, int n2, int n3) {
        this.requestSearchResultExtListHandler.request(new RequestParameterList(l, 0, n, n2, n3));
    }

    public void discardSearchListRequests(int n) {
        this.requestSearchResultListHandler.discard(n);
    }

    public void discardSearchListExtRequests(int n) {
        this.requestSearchResultExtListHandler.discard(n);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

