/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media;

import de.audi.app.media.dsi.AbstractDSIController;
import de.audi.app.media.dsi.media.IMediaDSIOnlineController;
import de.audi.app.media.dsi.media.IMediaDSIOnlineListener;
import de.audi.app.media.dsi.media.MediaDSIOnlineController$1;
import de.audi.app.media.dsi.media.MediaDSIOnlineController$2;
import de.audi.app.media.dsi.media.MediaDSIOnlineController$3;
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
    private static final String LOGCLASS;
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

    @Override
    public void deinit() {
        super.deinit();
        this.logger.log(1078071040, "[%1.deinit] Deinit.", (Object)"MediaDSIOnlineController");
        this.clearAttributeNotification(this.dsiMediaOnline);
        this.dsiMediaOnline = null;
    }

    @Override
    public void addDSIService(DSIBase dSIBase) {
        this.logger.log(1078071040, "[%1.addDSIService] [%2] '%3'.", (Object)"MediaDSIOnlineController", (Object)new Integer(this.getInstanceID()), (Object)dSIBase);
        this.dsiMediaOnline = (DSIMediaOnline)dSIBase;
        this.registerAttributeNotifications(this.dsiMediaOnline);
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        this.logger.log(1078071040, "[%1.asyncException] errCode='%2' errorMsg='%3'", (Object)"MediaDSIOnlineController", (Object)String.valueOf(n), (Object)string);
    }

    @Override
    public void updateBufferState(int n, int n2) {
        if (n2 != 1) {
            this.logger.log(1078071040, "[%1.updateBufferState] Not valid.", (Object)"MediaDSIOnlineController");
            return;
        }
        this.dispatcher.execute(new MediaDSIOnlineController$1(this, "MediaDSIOnlineController.updateBufferState", n));
    }

    @Override
    public void updateBufferFillInfo(int n, int n2, int n3) {
        if (n3 != 1) {
            this.logger.log(1078071040, "[%1.updateBufferFillInfo] Not valid.", (Object)"MediaDSIOnlineController");
            return;
        }
        this.dispatcher.execute(new MediaDSIOnlineController$2(this, "MediaDSIOnlineController.updateBufferFillInfo", n, n2));
    }

    @Override
    public void updateAudioSettings(int n, int n2, int n3) {
        if (n3 != 1) {
            this.logger.log(1078071040, "[%1.updateAudioSettings] Not valid.", (Object)"MediaDSIOnlineController");
            return;
        }
        this.dispatcher.execute(new MediaDSIOnlineController$3(this, "MediaDSIOnlineController.updateAudioSettings", n, n2));
    }

    @Override
    public void addMediaOnlineListener(IMediaDSIOnlineListener iMediaDSIOnlineListener) {
        this.logger.log(1078071040, "[%1.addMediaOnlineListener]", (Object)"MediaDSIOnlineController");
        this.mediaDSIOnlineListener = null == iMediaDSIOnlineListener ? this.nullMediaDSIOnlineListener : iMediaDSIOnlineListener;
    }

    @Override
    protected Class getDSIServiceClass() {
        return class$org$dsi$ifc$media$DSIMediaOnline == null ? (class$org$dsi$ifc$media$DSIMediaOnline = MediaDSIOnlineController.class$("org.dsi.ifc.media.DSIMediaOnline")) : class$org$dsi$ifc$media$DSIMediaOnline;
    }

    @Override
    protected DSIListener getDSIListener() {
        return this;
    }

    @Override
    protected Class getDSIListenerClass() {
        return class$org$dsi$ifc$media$DSIMediaOnlineListener == null ? (class$org$dsi$ifc$media$DSIMediaOnlineListener = MediaDSIOnlineController.class$("org.dsi.ifc.media.DSIMediaOnlineListener")) : class$org$dsi$ifc$media$DSIMediaOnlineListener;
    }

    @Override
    protected void removeDSIService() {
        this.dsiMediaOnline = null;
    }

    protected void registerAttributeNotifications(DSIBase dSIBase) {
        this.logger.log(-2137614336, "[%1.registerAttributeNotifications]", (Object)"MediaDSIOnlineController");
        dSIBase.setNotification(new int[]{3, 2, 1}, this.getDSIListener());
    }

    static /* synthetic */ LogChannel access$000(MediaDSIOnlineController mediaDSIOnlineController) {
        return mediaDSIOnlineController.logger;
    }

    static /* synthetic */ IMediaDSIOnlineListener access$100(MediaDSIOnlineController mediaDSIOnlineController) {
        return mediaDSIOnlineController.mediaDSIOnlineListener;
    }

    static /* synthetic */ LogChannel access$200(MediaDSIOnlineController mediaDSIOnlineController) {
        return mediaDSIOnlineController.logger;
    }

    static /* synthetic */ LogChannel access$300(MediaDSIOnlineController mediaDSIOnlineController) {
        return mediaDSIOnlineController.logger;
    }

    static /* synthetic */ LogChannel access$400(MediaDSIOnlineController mediaDSIOnlineController) {
        return mediaDSIOnlineController.logger;
    }

    static /* synthetic */ LogChannel access$500(MediaDSIOnlineController mediaDSIOnlineController) {
        return mediaDSIOnlineController.logger;
    }

    static /* synthetic */ LogChannel access$600(MediaDSIOnlineController mediaDSIOnlineController) {
        return mediaDSIOnlineController.logger;
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

