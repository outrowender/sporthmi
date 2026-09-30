/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.browser;

import de.audi.app.media.browser.BrowseListContextImpl;
import de.audi.app.media.browser.IBrowseListContext;
import de.audi.app.media.dsi.IDSIControllerStateListener;
import de.audi.app.media.dsi.media.IMediaBrowserListener;
import de.audi.app.media.dsi.media.IMediaDSIBrowserController;
import de.audi.app.media.dsi.media.MediaDSIBrowserControllerImpl;
import de.audi.app.media.osgi.IServiceManager;
import de.audi.app.media.source.ISourceController;
import de.audi.app.media.source.ISourceSlot;
import de.audi.app.media.source.MediaSourceSlot;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.job.DispatcherBase;

public abstract class AbstractMediaBrowser
implements IMediaBrowserListener,
IDSIControllerStateListener {
    private static final String LOGCLASS = "AbstractMediaBrowser";
    private final IMediaDSIBrowserController dsiMediaBrowser;
    protected final LogChannel logger;
    private final Object activateDeactivateMutex = new Object();
    private ISourceSlot activeSourceSlot;
    private BrowseListContextImpl browseListContext;
    private final ISourceController sourceController;
    private volatile boolean browserInvalidation;

    public AbstractMediaBrowser(LogChannel logChannel, LogChannel logChannel2, IServiceManager iServiceManager, IFrameworkAccess iFrameworkAccess, DispatcherBase dispatcherBase, int n, ISourceController iSourceController) {
        this.logger = logChannel;
        this.dsiMediaBrowser = new MediaDSIBrowserControllerImpl(n, iServiceManager, iFrameworkAccess, dispatcherBase, logChannel2);
        this.sourceController = iSourceController;
    }

    protected abstract void browserActivated(IBrowseListContext var1);

    protected abstract void browserDeactivated(ISourceSlot var1, boolean var2);

    public void init() {
        this.logger.log(1000000, "[%1.init]", (Object)LOGCLASS);
        this.dsiMediaBrowser.init();
    }

    public void deinit() {
        this.logger.log(1000000, "[%1.deinit]", (Object)LOGCLASS);
        this.dsiMediaBrowser.deinit();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void activate(ISourceSlot iSourceSlot) {
        this.logger.log(1000000, "[%1.activate]", (Object)LOGCLASS);
        Object object = this.activateDeactivateMutex;
        synchronized (object) {
            this.activeSourceSlot = iSourceSlot;
        }
        if (!this.dsiMediaBrowser.isStarted()) {
            this.logger.log(1000000, "[%1.activate (%2)] Start DSI.", (Object)LOGCLASS, (long)this.dsiMediaBrowser.getInstanceID());
            this.dsiMediaBrowser.startDSI();
        }
        this.dsiMediaBrowser.setStateListener(this);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void deactivate(boolean bl) {
        Object object = this.activateDeactivateMutex;
        synchronized (object) {
            this.logger.log(1000000, "[%1.deactivate(%3)] '%2'", (Object)LOGCLASS, (Object)String.valueOf(bl), (long)this.dsiMediaBrowser.getInstanceID());
            this.browserInvalidation = bl;
            this.dsiMediaBrowser.setStateListener(null);
            if (this.activeSourceSlot == null) {
                this.logger.log(1000000, "[%1.deactivate] Browser not activated.", (Object)LOGCLASS);
                return;
            }
            ISourceSlot iSourceSlot = this.activeSourceSlot;
            if (!this.browserInvalidation) {
                this.activeSourceSlot = null;
                this.dsiMediaBrowser.setBrowserListener(null);
            }
            this.dsiMediaBrowser.deactivate();
            if (this.browseListContext != null) {
                this.browseListContext.deinit();
                this.browseListContext = null;
            }
            this.browserDeactivated(iSourceSlot, this.browserInvalidation);
        }
    }

    public void deactivate() {
        this.deactivate(false);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final void browseSourceActivated() {
        Object object = this.activateDeactivateMutex;
        synchronized (object) {
            this.logger.log(1000000, "[%1.browseSourceActivated]", (Object)LOGCLASS);
            if (this.activeSourceSlot == null) {
                this.logger.log(1000000, "[%1.browseSourceActivated] Not active any more.", (Object)LOGCLASS);
                return;
            }
            if (this.browseListContext == null) {
                this.browseListContext = new BrowseListContextImpl(this.logger, this.dsiMediaBrowser, this.activeSourceSlot, this.sourceController);
                this.browseListContext.init();
            }
            this.browserActivated(this.browseListContext);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final void browseSourceDeactivated() {
        this.logger.log(1000000, "[%1.browseSourceDeactivated]", (Object)LOGCLASS);
        Object object = this.activateDeactivateMutex;
        synchronized (object) {
            if (this.browserInvalidation) {
                this.activate(this.activeSourceSlot);
                this.browserInvalidation = false;
            }
        }
    }

    public final void browseSourceInvalidated() {
        this.logger.log(1000000, "[%1.browseSourceDeactivated]", (Object)LOGCLASS);
        this.deactivate(true);
    }

    public void asyncException(int n, String string, int n2) {
        this.logger.log(1000000, "[%1.asyncException] Receive async exception. Deactivated the browser.", (Object)LOGCLASS);
        this.deactivate(false);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void dsiAvailable() {
        Object object = this.activateDeactivateMutex;
        synchronized (object) {
            this.logger.log(1000000, "[%1.dsiAvailable] Browser DSI available.", (Object)LOGCLASS);
            if (this.activeSourceSlot == null) {
                this.logger.log(1000000, "[%1.dsiAvailable] Not active. Ignore.", (Object)LOGCLASS);
                return;
            }
            this.dsiMediaBrowser.setBrowserListener(this);
            this.dsiMediaBrowser.activate((MediaSourceSlot)this.activeSourceSlot);
        }
    }

    public void dsiUnavailable() {
    }

    protected void diagResetBrowser() {
        this.browseSourceInvalidated();
    }
}

