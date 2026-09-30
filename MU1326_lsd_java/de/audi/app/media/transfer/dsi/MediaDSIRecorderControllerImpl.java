/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.transfer.dsi;

import de.audi.app.media.dsi.AbstractDSIController;
import de.audi.app.media.osgi.IServiceManager;
import de.audi.app.media.source.ISourceResolver;
import de.audi.app.media.source.MediaSourceSlot;
import de.audi.app.media.transfer.dsi.IMediaDSIRecorderController;
import de.audi.app.media.transfer.dsi.IMediaRecorderListener;
import de.audi.app.media.transfer.dsi.MediaDSIRecorderListener;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.media.DSIMediaRecorder;

public class MediaDSIRecorderControllerImpl
extends AbstractDSIController
implements IMediaDSIRecorderController {
    private static final String LOGCLASS = "MediaDSIRecorderControllerImpl";
    private final MediaDSIRecorderListener dsiListener;
    private volatile DSIMediaRecorder dsiMediaRecorder = null;
    private volatile IMediaRecorderListener recorderListener;
    private volatile MediaSourceSlot slotToActivate;
    static /* synthetic */ Class class$org$dsi$ifc$media$DSIMediaRecorder;
    static /* synthetic */ Class class$org$dsi$ifc$media$DSIMediaRecorderListener;

    public MediaDSIRecorderControllerImpl(int n, IServiceManager iServiceManager, IFrameworkAccess iFrameworkAccess, DispatcherBase dispatcherBase, ISourceResolver iSourceResolver, LogChannel logChannel) {
        super(n, iServiceManager, iFrameworkAccess, dispatcherBase, true, logChannel);
        this.dsiListener = new MediaDSIRecorderListener(this, iSourceResolver, logChannel, dispatcherBase);
    }

    public void deinit() {
        super.deinit();
        this.logger.log(1000000, "[%1.deinit] Deinit.", (Object)LOGCLASS);
        this.clearAttributeNotification(this.dsiMediaRecorder);
        this.recorderListener = null;
    }

    public void setRecorderListener(IMediaRecorderListener iMediaRecorderListener) {
        this.logger.log(10000000, "[%1.setRecorderListener] Set recorder listener '%2'.", (Object)LOGCLASS, (Object)iMediaRecorderListener);
        if (iMediaRecorderListener == null) {
            throw new IllegalArgumentException();
        }
        this.recorderListener = iMediaRecorderListener;
    }

    public IMediaRecorderListener getRecorderListener() {
        return this.recorderListener;
    }

    public void addDSIService(DSIBase dSIBase) {
        this.logger.log(1000000, "[%1.addDSIService] '%2'.", (Object)LOGCLASS, (Object)dSIBase);
        this.dsiMediaRecorder = (DSIMediaRecorder)dSIBase;
        this.registerAttributeNotifications(dSIBase);
    }

    protected void removeDSIService() {
        this.logger.log(1000000, "[%1.removeDSIService] DSI service removed.", (Object)LOGCLASS);
        this.dsiMediaRecorder = null;
        IMediaRecorderListener iMediaRecorderListener = this.getRecorderListener();
        if (null != iMediaRecorderListener) {
            iMediaRecorderListener.dsiServiceRemoved();
        }
    }

    protected void registerAttributeNotifications(DSIBase dSIBase) {
        this.logger.log(10000000, "[%1.registerAttributeNotifications]", (Object)LOGCLASS);
        this.dsiMediaRecorder.setNotification(new int[]{1, 5, 4, 7, 3, 6, 2}, this.getDSIListener());
    }

    protected DSIListener getDSIListener() {
        return this.dsiListener;
    }

    protected Class getDSIServiceClass() {
        return class$org$dsi$ifc$media$DSIMediaRecorder == null ? (class$org$dsi$ifc$media$DSIMediaRecorder = MediaDSIRecorderControllerImpl.class$("org.dsi.ifc.media.DSIMediaRecorder")) : class$org$dsi$ifc$media$DSIMediaRecorder;
    }

    protected Class getDSIListenerClass() {
        return class$org$dsi$ifc$media$DSIMediaRecorderListener == null ? (class$org$dsi$ifc$media$DSIMediaRecorderListener = MediaDSIRecorderControllerImpl.class$("org.dsi.ifc.media.DSIMediaRecorderListener")) : class$org$dsi$ifc$media$DSIMediaRecorderListener;
    }

    public void abortDelete() {
        this.logger.log(1000000, "[%1.abortDelete]", (Object)LOGCLASS);
        DSIMediaRecorder dSIMediaRecorder = this.dsiMediaRecorder;
        if (dSIMediaRecorder == null) {
            this.logger.log(100000, "[%1.abortDelete] No DSIMediaRecorder service registered. Ignore.", (Object)LOGCLASS);
            return;
        }
        dSIMediaRecorder.abortDelete();
    }

    public void abortImport() {
        this.logger.log(1000000, "[%1.abortImport]", (Object)LOGCLASS);
        DSIMediaRecorder dSIMediaRecorder = this.dsiMediaRecorder;
        if (dSIMediaRecorder == null) {
            this.logger.log(100000, "[%1.abortImport] No DSIMediaRecorder service registered. Ignore.", (Object)LOGCLASS);
            return;
        }
        dSIMediaRecorder.abortImport();
    }

    public void setActiveMedia(MediaSourceSlot mediaSourceSlot) {
        this.logger.log(1000000, "[%1.setActiveMedia] slot='%2'", (Object)LOGCLASS, (Object)mediaSourceSlot);
        DSIMediaRecorder dSIMediaRecorder = this.dsiMediaRecorder;
        if (dSIMediaRecorder == null) {
            this.logger.log(100000, "[%1.setActiveMedia] No DSIMediaRecorder service registered. Ignore.", (Object)LOGCLASS);
            return;
        }
        this.slotToActivate = mediaSourceSlot;
        dSIMediaRecorder.setActiveMedia(this.slotToActivate.getDeviceID(), this.slotToActivate.getMediaID());
    }

    protected final MediaSourceSlot getSourceSlotToActivate() {
        return this.slotToActivate;
    }

    public void setSelection(int n) {
        this.logger.log(1000000, "[%1.setSelection] browserID='%2'", (Object)LOGCLASS, (long)n);
        DSIMediaRecorder dSIMediaRecorder = this.dsiMediaRecorder;
        if (dSIMediaRecorder == null) {
            this.logger.log(100000, "[%1.setSelection] No DSIMediaRecorder service registered. Ignore.", (Object)LOGCLASS);
            return;
        }
        dSIMediaRecorder.setSelection(n);
    }

    public void setTargetMedia(long l, long l2) {
        this.logger.log(1000000, "[%1.setTargetMedia] deviceID='%2', mediaID='%3'", (Object)LOGCLASS, l, l2);
        DSIMediaRecorder dSIMediaRecorder = this.dsiMediaRecorder;
        if (dSIMediaRecorder == null) {
            this.logger.log(100000, "[%1.setTargetMedia] No DSIMediaRecorder service registered. Ignore.", (Object)LOGCLASS);
            return;
        }
        dSIMediaRecorder.setTargetMedia(l, l2);
    }

    public void startDelete() {
        this.logger.log(1000000, "[%1.startDelete]", (Object)LOGCLASS);
        DSIMediaRecorder dSIMediaRecorder = this.dsiMediaRecorder;
        if (dSIMediaRecorder == null) {
            this.logger.log(100000, "[%1.startDelete] No DSIMediaRecorder service registered. Ignore.", (Object)LOGCLASS);
            return;
        }
        dSIMediaRecorder.startDelete();
    }

    public void startImport(boolean bl) {
        this.logger.log(1000000, "[%1.startImport] overwrite='%2'", (Object)LOGCLASS, (Object)String.valueOf(bl));
        DSIMediaRecorder dSIMediaRecorder = this.dsiMediaRecorder;
        if (dSIMediaRecorder == null) {
            this.logger.log(100000, "[%1.startImport] No DSIMediaRecorder service registered. Ignore.", (Object)LOGCLASS);
            return;
        }
        dSIMediaRecorder.startImport(bl);
    }

    public void setEncodingQuality(int n) {
        this.logger.log(1000000, "[%1.setEncodingQuality] quality='%2'.", (Object)LOGCLASS, (long)n);
        DSIMediaRecorder dSIMediaRecorder = this.dsiMediaRecorder;
        if (dSIMediaRecorder == null) {
            this.logger.log(100000, "[%1.setEncodingQuality] No DSIMediaRecorder service registered. Ignore.", (Object)LOGCLASS);
            return;
        }
        dSIMediaRecorder.setEncodingQuality(n);
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

