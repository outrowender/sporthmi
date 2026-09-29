/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media;

import de.audi.app.media.dsi.media.IMediaDSIBaseController;
import de.audi.app.media.dsi.media.IMediaDeviceListener;
import de.audi.app.media.osgi.IServiceManager;
import de.audi.atip.interapp.IEjectHandler;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Hashtable;
import org.dsi.ifc.media.DeviceInfo;
import org.dsi.ifc.media.MediaInfo;
import org.osgi.framework.ServiceRegistration;

public class EjectHandler
implements IEjectHandler,
IMediaDeviceListener {
    private static final String LOGCLASS;
    private final LogChannel logger;
    private final IServiceManager serviceManager;
    private final IMediaDSIBaseController dsiBaseController;
    private ServiceRegistration serviceRegistration;
    private volatile MediaInfo[] mediaList;
    private volatile DeviceInfo[] deviceList;
    static /* synthetic */ Class class$de$audi$atip$interapp$IEjectHandler;

    public EjectHandler(LogChannel logChannel, IServiceManager iServiceManager, IMediaDSIBaseController iMediaDSIBaseController) {
        this.logger = logChannel;
        this.serviceManager = iServiceManager;
        this.dsiBaseController = iMediaDSIBaseController;
    }

    public void init() {
        this.logger.log(1078071040, "[%1.init]", (Object)"EjectHandler");
        this.dsiBaseController.addMediaDeviceListener(this);
    }

    public void deinit() {
        this.logger.log(1078071040, "[%1.deinit]", (Object)"EjectHandler");
        if (this.serviceRegistration != null) {
            this.serviceManager.unregisterService(this.serviceRegistration);
            this.serviceRegistration = null;
        }
    }

    @Override
    public void ejectCD() {
        this.logger.log(1078071040, "[%1.ejectCD]", (Object)"EjectHandler");
        DeviceInfo[] deviceInfoArray = this.deviceList;
        MediaInfo[] mediaInfoArray = this.mediaList;
        long l = -1L;
        for (int i2 = 0; i2 < deviceInfoArray.length; ++i2) {
            boolean bl;
            DeviceInfo deviceInfo = deviceInfoArray[i2];
            boolean bl2 = bl = deviceInfo.getDeviceType() == 3 || deviceInfo.getDeviceType() == 4;
            if (!bl || deviceInfo.numSlots <= 0) continue;
            l = deviceInfo.getDeviceID();
            break;
        }
        if (l == -1L) {
            this.logger.log(-1601830656, "[%1.ejectCD] DVD/CD device not found.", (Object)"EjectHandler");
            return;
        }
        this.logger.log(-2137614336, "[%1.ejectCD] Device found (deviceID='%2')", (Object)"EjectHandler", l);
        MediaInfo mediaInfo = null;
        for (int i3 = 0; i3 < mediaInfoArray.length; ++i3) {
            if (mediaInfoArray[i3].getDeviceID() != l) continue;
            mediaInfo = mediaInfoArray[i3];
            break;
        }
        if (mediaInfo == null) {
            this.logger.log(-2137614336, "[%1.ejectCD] Media slot not found.", (Object)"EjectHandler");
            return;
        }
        this.dsiBaseController.eject(mediaInfo.getDeviceID(), mediaInfo.getMediaID());
    }

    @Override
    public void updateDeviceList(DeviceInfo[] deviceInfoArray) {
        this.logger.log(1078071040, "[%1.updateDeviceList]", (Object)"EjectHandler");
        this.deviceList = deviceInfoArray;
    }

    @Override
    public void updateMediaList(MediaInfo[] mediaInfoArray) {
        this.logger.log(1078071040, "[%1.updateMediaList]", (Object)"EjectHandler");
        this.mediaList = mediaInfoArray;
        if (this.serviceRegistration == null) {
            this.logger.log(1078071040, "[%1.updateMediaList] Registering as IEjectHandler", (Object)"EjectHandler");
            this.serviceRegistration = this.serviceManager.registerService(class$de$audi$atip$interapp$IEjectHandler == null ? (class$de$audi$atip$interapp$IEjectHandler = EjectHandler.class$("de.audi.atip.interapp.IEjectHandler")) : class$de$audi$atip$interapp$IEjectHandler, this, new Hashtable(0));
        }
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("EjectHandler").append("@").append(this.hashCode());
        return buffer.toString();
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

