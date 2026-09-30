/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.dsi.AbstractDSIController;
import de.audi.app.media.dsi.media.IMediaDSIOnlineController;
import de.audi.app.media.dsi.media.IMediaDSIOnlineListener;
import de.audi.app.media.dsi.media.NullMediaDSIOnlineListener;
import de.audi.app.media.osgi.IServiceManager;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.media.DSIMediaOnline;
import org.dsi.ifc.media.DSIMediaOnlineListener;

public class MediaDSIOnlineController
extends AbstractDSIController
implements IMediaDSIOnlineController,
DSIMediaOnlineListener {
    private static final String LOGCLASS = "MediaDSIOnlineController";
    private final IMediaDSIOnlineListener nullMediaDSIOnlineListener;
    private volatile IMediaDSIOnlineListener mediaDSIOnlineListener;
    private final DispatcherBase dispatcher;
    private volatile DSIMediaOnline dsiMediaOnline;
    static /* synthetic */ Class class$org$dsi$ifc$media$DSIMediaOnline;
    static /* synthetic */ Class class$org$dsi$ifc$media$DSIMediaOnlineListener;

    public MediaDSIOnlineController(int n, IServiceManager iServiceManager, IFrameworkAccess iFrameworkAccess, DispatcherBase dispatcherBase, boolean bl, LogChannel logChannel) {
        super(n, iServiceManager, iFrameworkAccess, dispatcherBase, bl, logChannel);
        this.dispatcher = dispatcherBase;
        this.nullMediaDSIOnlineListener = new NullMediaDSIOnlineListener(logChannel);
    }

    public void deinit() {
        super.deinit();
        this.logger.log(1000000, "[%1.deinit] Deinit.", (Object)LOGCLASS);
        this.clearAttributeNotification(this.dsiMediaOnline);
        this.dsiMediaOnline = null;
    }

    public void addDSIService(DSIBase dSIBase) {
        this.logger.log(1000000, "[%1.addDSIService] [%2] '%3'.", (Object)LOGCLASS, (Object)new Integer(this.getInstanceID()), (Object)dSIBase);
        this.dsiMediaOnline = (DSIMediaOnline)dSIBase;
        this.registerAttributeNotifications(this.dsiMediaOnline);
    }

    public void asyncException(int n, String string, int n2) {
        this.logger.log(1000000, "[%1.asyncException] errCode='%2' errorMsg='%3'", (Object)LOGCLASS, (Object)String.valueOf(n), (Object)string);
    }

    public void updateBufferState(final int n, int n2) {
        if (n2 != 1) {
            this.logger.log(1000000, "[%1.updateBufferState] Not valid.", (Object)LOGCLASS);
            return;
        }
        this.dispatcher.execute(new AbstractDispatcherRunnable("MediaDSIOnlineController.updateBufferState"){

            public void run() {
                try {
                    MediaDSIOnlineController.this.logger.log(1000000, "[%1.updateBufferState]", (Object)MediaDSIOnlineController.LOGCLASS);
                    MediaDSIOnlineController.this.mediaDSIOnlineListener.updateBufferState(n);
                }
                catch (Exception exception) {
                    MediaDSIOnlineController.this.logger.log(10000, "[%1.updateBufferState] Error in listener: %2", (Object)MediaDSIOnlineController.LOGCLASS, (Throwable)exception);
                }
            }
        });
    }

    public void updateBufferFillInfo(final int n, final int n2, int n3) {
        if (n3 != 1) {
            this.logger.log(1000000, "[%1.updateBufferFillInfo] Not valid.", (Object)LOGCLASS);
            return;
        }
        this.dispatcher.execute(new AbstractDispatcherRunnable("MediaDSIOnlineController.updateBufferFillInfo"){

            public void run() {
                try {
                    MediaDSIOnlineController.this.logger.log(1000000, "[%1.updateBufferFillInfo]", (Object)MediaDSIOnlineController.LOGCLASS);
                    MediaDSIOnlineController.this.mediaDSIOnlineListener.updateBufferFillInfo(n, n2);
                }
                catch (Exception exception) {
                    MediaDSIOnlineController.this.logger.log(10000, "[%1.updateBufferFillInfo] Error in listener: %2", (Object)MediaDSIOnlineController.LOGCLASS, (Throwable)exception);
                }
            }
        });
    }

    public void updateAudioSettings(final int n, final int n2, int n3) {
        if (n3 != 1) {
            this.logger.log(1000000, "[%1.updateAudioSettings] Not valid.", (Object)LOGCLASS);
            return;
        }
        this.dispatcher.execute(new AbstractDispatcherRunnable("MediaDSIOnlineController.updateAudioSettings"){

            public void run() {
                try {
                    MediaDSIOnlineController.this.logger.log(1000000, "[%1.updateAudioSettings]", (Object)MediaDSIOnlineController.LOGCLASS);
                    MediaDSIOnlineController.this.mediaDSIOnlineListener.updateAudioSettings(n, n2);
                }
                catch (Exception exception) {
                    MediaDSIOnlineController.this.logger.log(10000, "[%1.updateAudioSettings] Error in listener: %2", (Object)MediaDSIOnlineController.LOGCLASS, (Throwable)exception);
                }
            }
        });
    }

    public void addMediaOnlineListener(IMediaDSIOnlineListener iMediaDSIOnlineListener) {
        this.logger.log(1000000, "[%1.addMediaOnlineListener]", (Object)LOGCLASS);
        this.mediaDSIOnlineListener = null == iMediaDSIOnlineListener ? this.nullMediaDSIOnlineListener : iMediaDSIOnlineListener;
    }

    protected Class getDSIServiceClass() {
        return class$org$dsi$ifc$media$DSIMediaOnline == null ? (class$org$dsi$ifc$media$DSIMediaOnline = MediaDSIOnlineController.class$("org.dsi.ifc.media.DSIMediaOnline")) : class$org$dsi$ifc$media$DSIMediaOnline;
    }

    protected DSIListener getDSIListener() {
        return this;
    }

    protected Class getDSIListenerClass() {
        return class$org$dsi$ifc$media$DSIMediaOnlineListener == null ? (class$org$dsi$ifc$media$DSIMediaOnlineListener = MediaDSIOnlineController.class$("org.dsi.ifc.media.DSIMediaOnlineListener")) : class$org$dsi$ifc$media$DSIMediaOnlineListener;
    }

    protected void removeDSIService() {
        this.dsiMediaOnline = null;
    }

    protected void registerAttributeNotifications(DSIBase dSIBase) {
        this.logger.log(10000000, "[%1.registerAttributeNotifications]", (Object)LOGCLASS);
        dSIBase.setNotification(new int[]{3, 2, 1}, this.getDSIListener());
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

