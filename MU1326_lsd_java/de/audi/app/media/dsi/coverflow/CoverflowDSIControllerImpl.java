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
    private static final String LOGCLASS;
    private final CoverflowDSIListener dsiListener;
    private volatile DSIAlbumBrowser dsiService = null;
    private volatile ICoverflowListener coverflowListener;
    static /* synthetic */ Class class$org$dsi$ifc$albumbrowser$DSIAlbumBrowser;
    static /* synthetic */ Class class$org$dsi$ifc$albumbrowser$DSIAlbumBrowserListener;

    public CoverflowDSIControllerImpl(int n, IServiceManager iServiceManager, IFrameworkAccess iFrameworkAccess, DispatcherBase dispatcherBase, LogChannel logChannel) {
        super(n, iServiceManager, iFrameworkAccess, dispatcherBase, true, logChannel);
        this.dsiListener = new CoverflowDSIListener(logChannel, this);
    }

    @Override
    public void deinit() {
        super.deinit();
        this.logger.log(1078071040, "[%1.deinit] Deinit.", (Object)"CoverflowDSIControllerImpl");
        this.clearAttributeNotification(this.dsiService);
    }

    @Override
    public void addDSIService(DSIBase dSIBase) {
        this.logger.log(1078071040, "[%1.addDSIService] '%2'.", (Object)"CoverflowDSIControllerImpl", (Object)dSIBase);
        this.dsiService = (DSIAlbumBrowser)dSIBase;
        this.registerAttributeNotifications(dSIBase);
    }

    @Override
    protected void removeDSIService() {
        this.logger.log(1078071040, "[%1.removeDSIService] DSI service removed.", (Object)"CoverflowDSIControllerImpl");
        this.dsiService = null;
    }

    protected void registerAttributeNotifications(DSIBase dSIBase) {
        this.logger.log(-2137614336, "[%1.registerDSI] Set attribute notifications.", (Object)"CoverflowDSIControllerImpl");
        dSIBase.setNotification(new int[]{1, 2, 3, 4, 5}, (DSIListener)this.dsiListener);
    }

    @Override
    protected DSIListener getDSIListener() {
        return this.dsiListener;
    }

    @Override
    protected Class getDSIServiceClass() {
        return class$org$dsi$ifc$albumbrowser$DSIAlbumBrowser == null ? (class$org$dsi$ifc$albumbrowser$DSIAlbumBrowser = CoverflowDSIControllerImpl.class$("org.dsi.ifc.albumbrowser.DSIAlbumBrowser")) : class$org$dsi$ifc$albumbrowser$DSIAlbumBrowser;
    }

    @Override
    protected Class getDSIListenerClass() {
        return class$org$dsi$ifc$albumbrowser$DSIAlbumBrowserListener == null ? (class$org$dsi$ifc$albumbrowser$DSIAlbumBrowserListener = CoverflowDSIControllerImpl.class$("org.dsi.ifc.albumbrowser.DSIAlbumBrowserListener")) : class$org$dsi$ifc$albumbrowser$DSIAlbumBrowserListener;
    }

    @Override
    public void setCoverflowListener(ICoverflowListener iCoverflowListener) {
        this.logger.log(1078071040, "[%1.setCoverflowListener] '%2'.", (Object)"CoverflowDSIControllerImpl", (Object)iCoverflowListener);
        this.coverflowListener = iCoverflowListener;
    }

    protected ICoverflowListener getCoverflowListener() {
        return this.coverflowListener;
    }

    @Override
    public void startActive() {
        this.logger.log(1078071040, "[%1.startActive]", (Object)"CoverflowDSIControllerImpl");
        DSIAlbumBrowser dSIAlbumBrowser = this.dsiService;
        if (dSIAlbumBrowser == null) {
            return;
        }
        dSIAlbumBrowser.startActive();
    }

    @Override
    public void startSingle() {
        this.logger.log(1078071040, "[%1.startSingle]", (Object)"CoverflowDSIControllerImpl");
        DSIAlbumBrowser dSIAlbumBrowser = this.dsiService;
        if (dSIAlbumBrowser == null) {
            return;
        }
        dSIAlbumBrowser.startSingle();
    }

    @Override
    public void startPreview() {
        this.logger.log(1078071040, "[%1.startPreview]", (Object)"CoverflowDSIControllerImpl");
        DSIAlbumBrowser dSIAlbumBrowser = this.dsiService;
        if (dSIAlbumBrowser == null) {
            return;
        }
        dSIAlbumBrowser.startPreview();
    }

    @Override
    public void stop() {
        this.logger.log(1078071040, "[%1.stop]", (Object)"CoverflowDSIControllerImpl");
        DSIAlbumBrowser dSIAlbumBrowser = this.dsiService;
        if (dSIAlbumBrowser == null) {
            return;
        }
        dSIAlbumBrowser.stop();
    }

    @Override
    public void deinitialize() {
        this.logger.log(1078071040, "[%1.deinitialize]", (Object)"CoverflowDSIControllerImpl");
        DSIAlbumBrowser dSIAlbumBrowser = this.dsiService;
        if (dSIAlbumBrowser == null) {
            return;
        }
        dSIAlbumBrowser.deinitializeBrowser();
    }

    @Override
    public void initialize(ISourceSlot iSourceSlot) {
        MediaSourceSlot mediaSourceSlot = (MediaSourceSlot)iSourceSlot;
        this.logger.log(1078071040, "[%1.initialize] deviceID='%2', mediaID='%3'.", (Object)"CoverflowDSIControllerImpl", mediaSourceSlot.getDeviceID(), mediaSourceSlot.getMediaID());
        DSIAlbumBrowser dSIAlbumBrowser = this.dsiService;
        if (dSIAlbumBrowser == null) {
            return;
        }
        dSIAlbumBrowser.initializeBrowser(mediaSourceSlot.getDeviceID(), mediaSourceSlot.getMediaID(), 0);
    }

    @Override
    public void moveFocus(long l, boolean bl) {
        this.logger.log(1078071040, "[%1.moveFocus] '%3' ('%2').", (Object)"CoverflowDSIControllerImpl", (Object)(bl ? "ANIMATED" : "STILL"), l);
        DSIAlbumBrowser dSIAlbumBrowser = this.dsiService;
        if (dSIAlbumBrowser == null) {
            return;
        }
        dSIAlbumBrowser.moveFocus(l, bl ? 1 : 0);
    }

    @Override
    public void scrollTicks(int n) {
        this.logger.log(1078071040, "[%1.scrollTicks] '%2'.", (Object)"CoverflowDSIControllerImpl", (long)n);
        DSIAlbumBrowser dSIAlbumBrowser = this.dsiService;
        if (dSIAlbumBrowser == null) {
            return;
        }
        dSIAlbumBrowser.scrollTicks(n);
    }

    @Override
    public void setScrollMode(int n) {
        this.logger.log(1078071040, "[%1.setScrollMode] '%2'.", (Object)"CoverflowDSIControllerImpl", (long)n);
        DSIAlbumBrowser dSIAlbumBrowser = this.dsiService;
        if (dSIAlbumBrowser == null) {
            return;
        }
        dSIAlbumBrowser.setScrollMode(n);
    }

    @Override
    public void selectAlbum(long l) {
        this.logger.log(1078071040, "[%1.selectAlbum] '%2'.", (Object)"CoverflowDSIControllerImpl", l);
        DSIAlbumBrowser dSIAlbumBrowser = this.dsiService;
        if (dSIAlbumBrowser == null) {
            return;
        }
        dSIAlbumBrowser.selectAlbum(l);
    }

    @Override
    public void requestAlbumIdxForFID(long l) {
        this.logger.log(1078071040, "[%1.requestAlbumIdxForFID] '%2'.", (Object)"CoverflowDSIControllerImpl", l);
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

