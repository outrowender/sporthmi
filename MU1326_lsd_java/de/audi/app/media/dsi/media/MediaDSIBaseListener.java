/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media;

import de.audi.app.media.dsi.AbstractDSIListener;
import de.audi.app.media.dsi.media.IMediaDeviceListener;
import de.audi.app.media.dsi.media.IMediaFactoryResetListener;
import de.audi.app.media.dsi.media.IMediaLanguageListener;
import de.audi.app.media.dsi.media.IMediaParentalManagementListener;
import de.audi.app.media.dsi.media.IMediaVersionListener;
import de.audi.app.media.dsi.media.MediaDSIBaseListener$1;
import de.audi.app.media.dsi.media.MediaDSIBaseListener$2;
import de.audi.app.media.dsi.media.MediaDSIBaseListener$3;
import de.audi.app.media.dsi.media.MediaDSIBaseListener$4;
import de.audi.app.media.dsi.media.MediaDSIBaseListener$5;
import de.audi.app.media.dsi.media.MediaDSIBaseListener$6;
import de.audi.app.media.dsi.media.MediaDSIBaseListener$7;
import de.audi.app.media.dsi.media.MediaDSIBaseListener$8;
import de.audi.app.media.util.CopyOnWriteArrayList;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import java.util.List;
import org.dsi.ifc.media.DSIMediaBaseListener;
import org.dsi.ifc.media.DeviceInfo;
import org.dsi.ifc.media.MediaInfo;

public class MediaDSIBaseListener
extends AbstractDSIListener
implements DSIMediaBaseListener {
    private static final String LOGCLASS;
    private IMediaFactoryResetListener factoryResetListener;
    private final int dsiBaseControllerInstanceID;
    private final List languageListeners;
    private final List mediaPMLListeners;
    private final List mediaDeviceListeners;
    private final CopyOnWriteArrayList mediaInfoListener;
    private final DispatcherBase dispatcher;

    public MediaDSIBaseListener(LogChannel logChannel, int n, DispatcherBase dispatcherBase) {
        super(logChannel);
        this.dispatcher = dispatcherBase;
        this.languageListeners = new CopyOnWriteArrayList();
        this.mediaPMLListeners = new CopyOnWriteArrayList();
        this.dsiBaseControllerInstanceID = n;
        this.mediaDeviceListeners = new CopyOnWriteArrayList();
        this.mediaInfoListener = new CopyOnWriteArrayList();
    }

    public void setFactoryResetListener(IMediaFactoryResetListener iMediaFactoryResetListener) {
        if (iMediaFactoryResetListener == null) {
            throw new IllegalArgumentException();
        }
        this.factoryResetListener = iMediaFactoryResetListener;
    }

    public void addMediaDeviceListener(IMediaDeviceListener iMediaDeviceListener) {
        if (iMediaDeviceListener == null) {
            throw new IllegalArgumentException();
        }
        this.mediaDeviceListeners.add(iMediaDeviceListener);
    }

    public void addLanguageListener(IMediaLanguageListener iMediaLanguageListener) {
        if (iMediaLanguageListener == null) {
            throw new IllegalArgumentException();
        }
        if (!this.languageListeners.contains(iMediaLanguageListener)) {
            this.languageListeners.add(iMediaLanguageListener);
        }
    }

    public void addParentalManagementListener(IMediaParentalManagementListener iMediaParentalManagementListener) {
        if (iMediaParentalManagementListener == null) {
            throw new IllegalArgumentException();
        }
        if (!this.mediaPMLListeners.contains(iMediaParentalManagementListener)) {
            this.mediaPMLListeners.add(iMediaParentalManagementListener);
        }
    }

    public void removeParentalManagementListener(IMediaParentalManagementListener iMediaParentalManagementListener) {
        if (iMediaParentalManagementListener == null) {
            throw new IllegalArgumentException();
        }
        if (this.mediaPMLListeners.contains(iMediaParentalManagementListener)) {
            this.mediaPMLListeners.remove(iMediaParentalManagementListener);
        }
    }

    public void addMediaVersionListener(IMediaVersionListener iMediaVersionListener) {
        if (iMediaVersionListener == null) {
            throw new IllegalArgumentException();
        }
        this.mediaInfoListener.addIfAbsent(iMediaVersionListener);
    }

    public void removeMediaVersionListener(IMediaVersionListener iMediaVersionListener) {
        if (iMediaVersionListener == null) {
            throw new IllegalArgumentException();
        }
        this.mediaInfoListener.remove(iMediaVersionListener);
    }

    @Override
    protected String getLogClass() {
        return "MediaDSIBaseListener";
    }

    @Override
    public void responseResetFactorySettings(int n, boolean bl) {
        this.dispatcher.execute(new MediaDSIBaseListener$1(this, n, bl));
    }

    @Override
    public void updateCustomerUpdate(int n, int n2) {
        if (!this.isUpdateValid("updateApplicationVersion", this.dsiBaseControllerInstanceID, n2)) {
            return;
        }
        int n3 = n == 2 ? 1 : 0;
        this.dispatcher.execute(new MediaDSIBaseListener$2(this, n3));
    }

    @Override
    public void updateDeviceList(DeviceInfo[] deviceInfoArray, int n) {
        if (!this.isUpdateValid("updateDeviceList", this.dsiBaseControllerInstanceID, n)) {
            return;
        }
        this.dispatcher.execute(new MediaDSIBaseListener$3(this, deviceInfoArray));
    }

    @Override
    public void updateMediaList(MediaInfo[] mediaInfoArray, int n) {
        if (!this.isUpdateValid("updateMediaList", this.dsiBaseControllerInstanceID, n)) {
            return;
        }
        this.dispatcher.execute(new MediaDSIBaseListener$4(this, mediaInfoArray));
    }

    @Override
    public void updateParentalML(int n, int n2) {
        if (!this.isUpdateValid("updateParentalML", this.dsiBaseControllerInstanceID, n2)) {
            return;
        }
        this.dispatcher.execute(new MediaDSIBaseListener$5(this, n));
    }

    @Override
    public void updatePreferredLanguage(String string, int n) {
        if (!this.isUpdateValid("updatePreferredLanguage", this.dsiBaseControllerInstanceID, n)) {
            return;
        }
        this.dispatcher.execute(new MediaDSIBaseListener$6(this, string));
    }

    @Override
    public void asyncException(int n, String string, int n2) {
    }

    @Override
    public void updateApplicationVersion(String string, int n) {
        if (!this.isUpdateValid("updateApplicationVersion", this.dsiBaseControllerInstanceID, n)) {
            return;
        }
        this.dispatcher.execute(new MediaDSIBaseListener$7(this, string));
    }

    @Override
    public void updateMetadataDBVersion(String string, int n) {
        if (!this.isUpdateValid("updateMetadataDBVersion", this.dsiBaseControllerInstanceID, n)) {
            return;
        }
        this.dispatcher.execute(new MediaDSIBaseListener$8(this, string));
    }

    @Override
    public void launchAppResult(long l, long l2, String string, boolean bl) {
    }

    @Override
    public void updateProfileState(int n, int n2, int n3) {
    }

    @Override
    public void profileChanged(int n, int n2) {
    }

    @Override
    public void profileCopied(int n, int n2, int n3) {
    }

    @Override
    public void profileReset(int n, int n2) {
    }

    @Override
    public void profileResetAll(int n) {
    }

    static /* synthetic */ LogChannel access$000(MediaDSIBaseListener mediaDSIBaseListener) {
        return mediaDSIBaseListener.logger;
    }

    static /* synthetic */ IMediaFactoryResetListener access$100(MediaDSIBaseListener mediaDSIBaseListener) {
        return mediaDSIBaseListener.factoryResetListener;
    }

    static /* synthetic */ LogChannel access$200(MediaDSIBaseListener mediaDSIBaseListener) {
        return mediaDSIBaseListener.logger;
    }

    static /* synthetic */ CopyOnWriteArrayList access$300(MediaDSIBaseListener mediaDSIBaseListener) {
        return mediaDSIBaseListener.mediaInfoListener;
    }

    static /* synthetic */ LogChannel access$400(MediaDSIBaseListener mediaDSIBaseListener) {
        return mediaDSIBaseListener.logger;
    }

    static /* synthetic */ LogChannel access$500(MediaDSIBaseListener mediaDSIBaseListener) {
        return mediaDSIBaseListener.logger;
    }

    static /* synthetic */ LogChannel access$600(MediaDSIBaseListener mediaDSIBaseListener) {
        return mediaDSIBaseListener.logger;
    }

    static /* synthetic */ LogChannel access$700(MediaDSIBaseListener mediaDSIBaseListener) {
        return mediaDSIBaseListener.logger;
    }

    static /* synthetic */ LogChannel access$800(MediaDSIBaseListener mediaDSIBaseListener) {
        return mediaDSIBaseListener.logger;
    }

    static /* synthetic */ List access$900(MediaDSIBaseListener mediaDSIBaseListener) {
        return mediaDSIBaseListener.mediaDeviceListeners;
    }

    static /* synthetic */ LogChannel access$1000(MediaDSIBaseListener mediaDSIBaseListener) {
        return mediaDSIBaseListener.logger;
    }

    static /* synthetic */ LogChannel access$1100(MediaDSIBaseListener mediaDSIBaseListener) {
        return mediaDSIBaseListener.logger;
    }

    static /* synthetic */ LogChannel access$1200(MediaDSIBaseListener mediaDSIBaseListener) {
        return mediaDSIBaseListener.logger;
    }

    static /* synthetic */ LogChannel access$1300(MediaDSIBaseListener mediaDSIBaseListener) {
        return mediaDSIBaseListener.logger;
    }

    static /* synthetic */ LogChannel access$1400(MediaDSIBaseListener mediaDSIBaseListener) {
        return mediaDSIBaseListener.logger;
    }

    static /* synthetic */ LogChannel access$1500(MediaDSIBaseListener mediaDSIBaseListener) {
        return mediaDSIBaseListener.logger;
    }

    static /* synthetic */ LogChannel access$1600(MediaDSIBaseListener mediaDSIBaseListener) {
        return mediaDSIBaseListener.logger;
    }

    static /* synthetic */ List access$1700(MediaDSIBaseListener mediaDSIBaseListener) {
        return mediaDSIBaseListener.mediaPMLListeners;
    }

    static /* synthetic */ LogChannel access$1800(MediaDSIBaseListener mediaDSIBaseListener) {
        return mediaDSIBaseListener.logger;
    }

    static /* synthetic */ LogChannel access$1900(MediaDSIBaseListener mediaDSIBaseListener) {
        return mediaDSIBaseListener.logger;
    }

    static /* synthetic */ LogChannel access$2000(MediaDSIBaseListener mediaDSIBaseListener) {
        return mediaDSIBaseListener.logger;
    }

    static /* synthetic */ List access$2100(MediaDSIBaseListener mediaDSIBaseListener) {
        return mediaDSIBaseListener.languageListeners;
    }

    static /* synthetic */ LogChannel access$2200(MediaDSIBaseListener mediaDSIBaseListener) {
        return mediaDSIBaseListener.logger;
    }

    static /* synthetic */ LogChannel access$2300(MediaDSIBaseListener mediaDSIBaseListener) {
        return mediaDSIBaseListener.logger;
    }

    static /* synthetic */ LogChannel access$2400(MediaDSIBaseListener mediaDSIBaseListener) {
        return mediaDSIBaseListener.logger;
    }

    static /* synthetic */ LogChannel access$2500(MediaDSIBaseListener mediaDSIBaseListener) {
        return mediaDSIBaseListener.logger;
    }

    static /* synthetic */ LogChannel access$2600(MediaDSIBaseListener mediaDSIBaseListener) {
        return mediaDSIBaseListener.logger;
    }

    static /* synthetic */ LogChannel access$2700(MediaDSIBaseListener mediaDSIBaseListener) {
        return mediaDSIBaseListener.logger;
    }

    static /* synthetic */ LogChannel access$2800(MediaDSIBaseListener mediaDSIBaseListener) {
        return mediaDSIBaseListener.logger;
    }
}

