/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.coverflow;

import de.audi.app.media.dsi.AbstractDSIController;
import de.audi.app.media.dsi.coverflow.CoverflowDSIListener;
import de.audi.app.media.dsi.coverflow.ICoverflowDSIController;
import de.audi.app.media.dsi.coverflow.ICoverflowListener;
import de.audi.app.media.osgi.IServiceManager;
import de.audi.app.media.source.ISourceSlot;
import de.audi.app.media.source.MediaSourceSlot;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import org.dsi.ifc.albumbrowser.DSIAlbumBrowser;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.base.DSIListener;

public class CoverflowDSIControllerImpl
extends AbstractDSIController
implements ICoverflowDSIController {
    private static final String LOGCLASS = "CoverflowDSIControllerImpl";
    private final CoverflowDSIListener dsiListener;
    private volatile DSIAlbumBrowser dsiService = null;
    private volatile ICoverflowListener coverflowListener;
    static /* synthetic */ Class class$org$dsi$ifc$albumbrowser$DSIAlbumBrowser;
    static /* synthetic */ Class class$org$dsi$ifc$albumbrowser$DSIAlbumBrowserListener;

    public CoverflowDSIControllerImpl(int n, IServiceManager iServiceManager, IFrameworkAccess iFrameworkAccess, DispatcherBase dispatcherBase, LogChannel logChannel) {
        super(n, iServiceManager, iFrameworkAccess, dispatcherBase, true, logChannel);
        this.dsiListener = new CoverflowDSIListener(logChannel, this);
    }

    public void deinit() {
        super.deinit();
        this.logger.log(1000000, "[%1.deinit] Deinit.", (Object)LOGCLASS);
        this.clearAttributeNotification(this.dsiService);
    }

    public void addDSIService(DSIBase dSIBase) {
        this.logger.log(1000000, "[%1.addDSIService] '%2'.", (Object)LOGCLASS, (Object)dSIBase);
        this.dsiService = (DSIAlbumBrowser)dSIBase;
        this.registerAttributeNotifications(dSIBase);
    }

    protected void removeDSIService() {
        this.logger.log(1000000, "[%1.removeDSIService] DSI service removed.", (Object)LOGCLASS);
        this.dsiService = null;
    }

    protected void registerAttributeNotifications(DSIBase dSIBase) {
        this.logger.log(10000000, "[%1.registerDSI] Set attribute notifications.", (Object)LOGCLASS);
        dSIBase.setNotification(new int[]{1, 2, 3, 4, 5}, (DSIListener)this.dsiListener);
    }

    protected DSIListener getDSIListener() {
        return this.dsiListener;
    }

    protected Class getDSIServiceClass() {
        return class$org$dsi$ifc$albumbrowser$DSIAlbumBrowser == null ? (class$org$dsi$ifc$albumbrowser$DSIAlbumBrowser = CoverflowDSIControllerImpl.class$("org.dsi.ifc.albumbrowser.DSIAlbumBrowser")) : class$org$dsi$ifc$albumbrowser$DSIAlbumBrowser;
    }

    protected Class getDSIListenerClass() {
        return class$org$dsi$ifc$albumbrowser$DSIAlbumBrowserListener == null ? (class$org$dsi$ifc$albumbrowser$DSIAlbumBrowserListener = CoverflowDSIControllerImpl.class$("org.dsi.ifc.albumbrowser.DSIAlbumBrowserListener")) : class$org$dsi$ifc$albumbrowser$DSIAlbumBrowserListener;
    }

    public void setCoverflowListener(ICoverflowListener iCoverflowListener) {
        this.logger.log(1000000, "[%1.setCoverflowListener] '%2'.", (Object)LOGCLASS, (Object)iCoverflowListener);
        this.coverflowListener = iCoverflowListener;
    }

    protected ICoverflowListener getCoverflowListener() {
        return this.coverflowListener;
    }

    public void startActive() {
        this.logger.log(1000000, "[%1.startActive]", (Object)LOGCLASS);
        DSIAlbumBrowser dSIAlbumBrowser = this.dsiService;
        if (dSIAlbumBrowser == null) {
            return;
        }
        dSIAlbumBrowser.startActive();
    }

    public void startSingle() {
        this.logger.log(1000000, "[%1.startSingle]", (Object)LOGCLASS);
        DSIAlbumBrowser dSIAlbumBrowser = this.dsiService;
        if (dSIAlbumBrowser == null) {
            return;
        }
        dSIAlbumBrowser.startSingle();
    }

    public void startPreview() {
        this.logger.log(1000000, "[%1.startPreview]", (Object)LOGCLASS);
        DSIAlbumBrowser dSIAlbumBrowser = this.dsiService;
        if (dSIAlbumBrowser == null) {
            return;
        }
        dSIAlbumBrowser.startPreview();
    }

    public void stop() {
        this.logger.log(1000000, "[%1.stop]", (Object)LOGCLASS);
        DSIAlbumBrowser dSIAlbumBrowser = this.dsiService;
        if (dSIAlbumBrowser == null) {
            return;
        }
        dSIAlbumBrowser.stop();
    }

    public void deinitialize() {
        this.logger.log(1000000, "[%1.deinitialize]", (Object)LOGCLASS);
        DSIAlbumBrowser dSIAlbumBrowser = this.dsiService;
        if (dSIAlbumBrowser == null) {
            return;
        }
        dSIAlbumBrowser.deinitializeBrowser();
    }

    public void initialize(ISourceSlot iSourceSlot) {
        MediaSourceSlot mediaSourceSlot = (MediaSourceSlot)iSourceSlot;
        this.logger.log(1000000, "[%1.initialize] deviceID='%2', mediaID='%3'.", (Object)LOGCLASS, mediaSourceSlot.getDeviceID(), mediaSourceSlot.getMediaID());
        DSIAlbumBrowser dSIAlbumBrowser = this.dsiService;
        if (dSIAlbumBrowser == null) {
            return;
        }
        dSIAlbumBrowser.initializeBrowser(mediaSourceSlot.getDeviceID(), mediaSourceSlot.getMediaID(), 0);
    }

    public void moveFocus(long l, boolean bl) {
        this.logger.log(1000000, "[%1.moveFocus] '%3' ('%2').", (Object)LOGCLASS, (Object)(bl ? "ANIMATED" : "STILL"), l);
        DSIAlbumBrowser dSIAlbumBrowser = this.dsiService;
        if (dSIAlbumBrowser == null) {
            return;
        }
        dSIAlbumBrowser.moveFocus(l, bl ? 1 : 0);
    }

    public void scrollTicks(int n) {
        this.logger.log(1000000, "[%1.scrollTicks] '%2'.", (Object)LOGCLASS, (long)n);
        DSIAlbumBrowser dSIAlbumBrowser = this.dsiService;
        if (dSIAlbumBrowser == null) {
            return;
        }
        dSIAlbumBrowser.scrollTicks(n);
    }

    public void setScrollMode(int n) {
        this.logger.log(1000000, "[%1.setScrollMode] '%2'.", (Object)LOGCLASS, (long)n);
        DSIAlbumBrowser dSIAlbumBrowser = this.dsiService;
        if (dSIAlbumBrowser == null) {
            return;
        }
        dSIAlbumBrowser.setScrollMode(n);
    }

    public void selectAlbum(long l) {
        this.logger.log(1000000, "[%1.selectAlbum] '%2'.", (Object)LOGCLASS, l);
        DSIAlbumBrowser dSIAlbumBrowser = this.dsiService;
        if (dSIAlbumBrowser == null) {
            return;
        }
        dSIAlbumBrowser.selectAlbum(l);
    }

    public void requestAlbumIdxForFID(long l) {
        this.logger.log(1000000, "[%1.requestAlbumIdxForFID] '%2'.", (Object)LOGCLASS, l);
        DSIAlbumBrowser dSIAlbumBrowser = this.dsiService;
        if (dSIAlbumBrowser == null) {
            return;
        }
        dSIAlbumBrowser.albumIdxForFID(l);
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

