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
import de.audi.app.media.logger.LogUtil;
import de.audi.app.media.util.CopyOnWriteArrayList;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import java.util.Iterator;
import java.util.List;
import org.dsi.ifc.media.DSIMediaBaseListener;
import org.dsi.ifc.media.DeviceInfo;
import org.dsi.ifc.media.MediaInfo;

public class MediaDSIBaseListener
extends AbstractDSIListener
implements DSIMediaBaseListener {
    private static final String LOGCLASS = "MediaDSIBaseListener";
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

    protected String getLogClass() {
        return LOGCLASS;
    }

    public void responseResetFactorySettings(final int n, final boolean bl) {
        this.dispatcher.execute(new Runnable(){

            public void run() {
                MediaDSIBaseListener.this.logger.log(1000000, "[%1.responseResetFactorySettings] resetMode='%2',success='%3'.", (Object)MediaDSIBaseListener.LOGCLASS, (Object)String.valueOf(n), (Object)String.valueOf(bl));
                if (MediaDSIBaseListener.this.factoryResetListener == null) {
                    return;
                }
                MediaDSIBaseListener.this.factoryResetListener.responseResetFactorySettings(n, bl);
            }

            public String toString() {
                return "DSIMediaBase.responseResetFactorySettings";
            }
        });
    }

    public void updateCustomerUpdate(int n, int n2) {
        if (!this.isUpdateValid("updateApplicationVersion", this.dsiBaseControllerInstanceID, n2)) {
            return;
        }
        final int n3 = n == 2 ? 1 : 0;
        this.dispatcher.execute(new Runnable(){

            public void run() {
                MediaDSIBaseListener.this.logger.log(1000000, "[%1.updateCustomerUpdate] '%2'.", (Object)MediaDSIBaseListener.LOGCLASS, (long)n3);
                Iterator iterator = MediaDSIBaseListener.this.mediaInfoListener.iterator();
                while (iterator.hasNext()) {
                    try {
                        ((IMediaVersionListener)iterator.next()).updateCustomerUpdate(n3);
                    }
                    catch (Exception exception) {
                        MediaDSIBaseListener.this.logger.log(100000, "[%1.updateCustomerUpdate] %2", (Object)MediaDSIBaseListener.LOGCLASS, (Throwable)exception);
                    }
                }
            }

            public String toString() {
                return "DSIMediaBase.updateCustomerUpdate";
            }
        });
    }

    public void updateDeviceList(final DeviceInfo[] deviceInfoArray, int n) {
        if (!this.isUpdateValid("updateDeviceList", this.dsiBaseControllerInstanceID, n)) {
            return;
        }
        this.dispatcher.execute(new Runnable(){

            public void run() {
                if (deviceInfoArray == null) {
                    MediaDSIBaseListener.this.logger.log(100000, "[%1.updateDeviceList] Device list is null. Ignore.", (Object)MediaDSIBaseListener.LOGCLASS);
                    return;
                }
                if (deviceInfoArray.length == 0) {
                    MediaDSIBaseListener.this.logger.log(100000, "[%1.updateDeviceList] Device list contains no entries. Ignore.", (Object)MediaDSIBaseListener.LOGCLASS);
                    return;
                }
                if (MediaDSIBaseListener.this.logger.isInfo()) {
                    for (int i2 = 0; i2 < deviceInfoArray.length; ++i2) {
                        MediaDSIBaseListener.this.logger.log(1000000, "[%1.updateDeviceList] DeviceInfo[%2] %3", (Object)MediaDSIBaseListener.LOGCLASS, (Object)new Integer(i2), (Object)LogUtil.deviceInfoToStr(deviceInfoArray[i2]));
                    }
                }
                Iterator iterator = MediaDSIBaseListener.this.mediaDeviceListeners.iterator();
                while (iterator.hasNext()) {
                    try {
                        ((IMediaDeviceListener)iterator.next()).updateDeviceList(deviceInfoArray);
                    }
                    catch (Exception exception) {
                        MediaDSIBaseListener.this.logger.log(100000, "[%1.updateDeviceList] %2", (Object)MediaDSIBaseListener.LOGCLASS, (Throwable)exception);
                    }
                }
            }

            public String toString() {
                return "DSIMediaBase.updateDeviceList";
            }
        });
    }

    public void updateMediaList(final MediaInfo[] mediaInfoArray, int n) {
        if (!this.isUpdateValid("updateMediaList", this.dsiBaseControllerInstanceID, n)) {
            return;
        }
        this.dispatcher.execute(new Runnable(){

            public void run() {
                if (mediaInfoArray == null) {
                    MediaDSIBaseListener.this.logger.log(100000, "[%1.updateMediaList] Media list is null. Ignore.", (Object)MediaDSIBaseListener.LOGCLASS);
                    return;
                }
                if (mediaInfoArray.length == 0) {
                    MediaDSIBaseListener.this.logger.log(100000, "[%1.updateMediaList] Media list contains no entries. Ignore.", (Object)MediaDSIBaseListener.LOGCLASS);
                    return;
                }
                if (MediaDSIBaseListener.this.logger.isInfo()) {
                    for (int i2 = 0; i2 < mediaInfoArray.length; ++i2) {
                        MediaDSIBaseListener.this.logger.log(1000000, "[%1.updateMediaList] MediaInfo[%2] %3", (Object)MediaDSIBaseListener.LOGCLASS, (Object)new Integer(i2), (Object)LogUtil.mediaInfoToStr(mediaInfoArray[i2]));
                    }
                }
                Iterator iterator = MediaDSIBaseListener.this.mediaDeviceListeners.iterator();
                while (iterator.hasNext()) {
                    try {
                        ((IMediaDeviceListener)iterator.next()).updateMediaList(mediaInfoArray);
                    }
                    catch (Exception exception) {
                        MediaDSIBaseListener.this.logger.log(100000, "[%1.updateMediaList] %2", (Object)MediaDSIBaseListener.LOGCLASS, (Throwable)exception);
                    }
                }
            }

            public String toString() {
                return "DSIMediaBase.updateMediaList";
            }
        });
    }

    public void updateParentalML(final int n, int n2) {
        if (!this.isUpdateValid("updateParentalML", this.dsiBaseControllerInstanceID, n2)) {
            return;
        }
        this.dispatcher.execute(new Runnable(){

            public void run() {
                MediaDSIBaseListener.this.logger.log(1000000, "[%1.updateParentalML] '%2'.", (Object)MediaDSIBaseListener.LOGCLASS, (long)n);
                Iterator iterator = MediaDSIBaseListener.this.mediaPMLListeners.iterator();
                while (iterator.hasNext()) {
                    try {
                        ((IMediaParentalManagementListener)iterator.next()).updateParentalML(n);
                    }
                    catch (Exception exception) {
                        MediaDSIBaseListener.this.logger.log(100000, "[%1.updateParentalML] %2", (Object)MediaDSIBaseListener.LOGCLASS, (Throwable)exception);
                    }
                }
            }

            public String toString() {
                return "DSIMediaBase.updateParentalML";
            }
        });
    }

    public void updatePreferredLanguage(final String string, int n) {
        if (!this.isUpdateValid("updatePreferredLanguage", this.dsiBaseControllerInstanceID, n)) {
            return;
        }
        this.dispatcher.execute(new Runnable(){

            public void run() {
                MediaDSIBaseListener.this.logger.log(1000000, "[%1.updatePreferredLanguage] '%2'.", (Object)MediaDSIBaseListener.LOGCLASS, (Object)string);
                if (string == null) {
                    MediaDSIBaseListener.this.logger.log(100000, "[%1.updatePreferredLanguage] Language is null. Ignore.", (Object)MediaDSIBaseListener.LOGCLASS);
                    return;
                }
                Iterator iterator = MediaDSIBaseListener.this.languageListeners.iterator();
                while (iterator.hasNext()) {
                    try {
                        ((IMediaLanguageListener)iterator.next()).updatePreferredLanguage(string);
                    }
                    catch (Exception exception) {
                        MediaDSIBaseListener.this.logger.log(100000, "[%1.updatePreferredLanguage] %2", (Object)MediaDSIBaseListener.LOGCLASS, (Throwable)exception);
                    }
                }
            }

            public String toString() {
                return "DSIMediaBase.updatePreferredLanguage";
            }
        });
    }

    public void asyncException(int n, String string, int n2) {
    }

    public void updateApplicationVersion(final String string, int n) {
        if (!this.isUpdateValid("updateApplicationVersion", this.dsiBaseControllerInstanceID, n)) {
            return;
        }
        this.dispatcher.execute(new Runnable(){

            public void run() {
                MediaDSIBaseListener.this.logger.log(1000000, "[%1.updateApplicationVersion] '%2'.", (Object)MediaDSIBaseListener.LOGCLASS, (Object)string);
                if (string == null) {
                    MediaDSIBaseListener.this.logger.log(100000, "[%1.updateApplicationVersion] Version is null. Ignore.", (Object)MediaDSIBaseListener.LOGCLASS);
                    return;
                }
                Iterator iterator = MediaDSIBaseListener.this.mediaInfoListener.iterator();
                while (iterator.hasNext()) {
                    try {
                        ((IMediaVersionListener)iterator.next()).updateMediaApplicationVersion(string);
                    }
                    catch (Exception exception) {
                        MediaDSIBaseListener.this.logger.log(100000, "[%1.updateApplicationVersion] %2", (Object)MediaDSIBaseListener.LOGCLASS, (Throwable)exception);
                    }
                }
            }

            public String toString() {
                return "DSIMediaBase.updateApplicationVersion";
            }
        });
    }

    public void updateMetadataDBVersion(final String string, int n) {
        if (!this.isUpdateValid("updateMetadataDBVersion", this.dsiBaseControllerInstanceID, n)) {
            return;
        }
        this.dispatcher.execute(new Runnable(){

            public void run() {
                MediaDSIBaseListener.this.logger.log(1000000, "[%1.updateMetadataDBVersion] '%2'.", (Object)MediaDSIBaseListener.LOGCLASS, (Object)string);
                if (string == null) {
                    MediaDSIBaseListener.this.logger.log(100000, "[%1.updateMetadataDBVersion] Version is null. Ignore.", (Object)MediaDSIBaseListener.LOGCLASS);
                    return;
                }
                Iterator iterator = MediaDSIBaseListener.this.mediaInfoListener.iterator();
                while (iterator.hasNext()) {
                    try {
                        ((IMediaVersionListener)iterator.next()).updateMetadataDBVersion(string);
                    }
                    catch (Exception exception) {
                        MediaDSIBaseListener.this.logger.log(100000, "[%1.updateMetadataDBVersion] %2", (Object)MediaDSIBaseListener.LOGCLASS, (Throwable)exception);
                    }
                }
            }

            public String toString() {
                return "DSIMediaBase.updateMetadataDBVersion";
            }
        });
    }

    public void launchAppResult(long l, long l2, String string, boolean bl) {
    }

    public void updateProfileState(int n, int n2, int n3) {
    }

    public void profileChanged(int n, int n2) {
    }

    public void profileCopied(int n, int n2, int n3) {
    }

    public void profileReset(int n, int n2) {
    }

    public void profileResetAll(int n) {
    }
}

