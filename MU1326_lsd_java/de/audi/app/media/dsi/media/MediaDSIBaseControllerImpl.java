/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media;

import de.audi.app.media.diagnosis.IDiagnosisManager;
import de.audi.app.media.dsi.AbstractDSIController;
import de.audi.app.media.dsi.media.IMediaDSIBaseController;
import de.audi.app.media.dsi.media.IMediaDeviceListener;
import de.audi.app.media.dsi.media.IMediaFactoryResetListener;
import de.audi.app.media.dsi.media.IMediaLanguageListener;
import de.audi.app.media.dsi.media.IMediaParentalManagementListener;
import de.audi.app.media.dsi.media.IMediaVersionListener;
import de.audi.app.media.dsi.media.MediaDSIBaseListener;
import de.audi.app.media.osgi.IServiceManager;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.i18n.I18NTarget;
import de.audi.atip.i18n.Language;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import java.util.Hashtable;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.media.DSIMediaBase;
import org.osgi.framework.ServiceRegistration;

public class MediaDSIBaseControllerImpl
extends AbstractDSIController
implements IMediaDSIBaseController,
I18NTarget {
    private static final String LOGCLASS = "MediaDSIBaseControllerImpl";
    private final MediaDSIBaseListener dsiListener;
    private final IFrameworkAccess framework;
    private volatile int pmLevel;
    private volatile DSIMediaBase dsiMediaBase = null;
    private volatile ServiceRegistration i18nServiceRegistration;
    static /* synthetic */ Class class$de$audi$atip$i18n$I18NTarget;
    static /* synthetic */ Class class$org$dsi$ifc$media$DSIMediaBaseListener;
    static /* synthetic */ Class class$org$dsi$ifc$media$DSIMediaBase;

    public MediaDSIBaseControllerImpl(int n, IServiceManager iServiceManager, IFrameworkAccess iFrameworkAccess, DispatcherBase dispatcherBase, IDiagnosisManager iDiagnosisManager, LogChannel logChannel, int n2) {
        super(n, iServiceManager, iFrameworkAccess, dispatcherBase, true, logChannel);
        if (iFrameworkAccess == null || iDiagnosisManager == null) {
            throw new IllegalArgumentException();
        }
        this.framework = iFrameworkAccess;
        this.pmLevel = n2;
        this.dsiListener = new MediaDSIBaseListener(logChannel, this.getInstanceID(), dispatcherBase);
    }

    public void init() {
        this.logger.log(1000000, "[%1.init]", (Object)LOGCLASS);
        super.init();
        Hashtable hashtable = new Hashtable(1);
        hashtable.put("LANG_COMPONENT_TYPE", "LANG_COMPONENT_HMI");
        this.i18nServiceRegistration = this.getServiceManager().registerService(class$de$audi$atip$i18n$I18NTarget == null ? (class$de$audi$atip$i18n$I18NTarget = MediaDSIBaseControllerImpl.class$("de.audi.atip.i18n.I18NTarget")) : class$de$audi$atip$i18n$I18NTarget, this, hashtable);
    }

    public void deinit() {
        this.logger.log(1000000, "[%1.deinit]", (Object)LOGCLASS);
        super.deinit();
        this.i18nServiceRegistration.unregister();
        this.clearAttributeNotification(this.dsiMediaBase);
    }

    public void addDSIService(DSIBase dSIBase) {
        this.logger.log(1000000, "[%1.addDSIService] '%2'.", (Object)LOGCLASS, (Object)dSIBase);
        this.dsiMediaBase = (DSIMediaBase)dSIBase;
        this.registerAttributeNotifications(dSIBase);
        this.setPreferredLanguage(this.framework.getLanguageMgr().getCurrentLanguage("LANG_COMPONENT_HMI").getHmiCode());
        this.setParentalML(this.pmLevel);
    }

    protected void removeDSIService() {
        this.logger.log(1000000, "[%1.removeDSIService] DSI service removed.", (Object)LOGCLASS);
        this.dsiMediaBase = null;
    }

    private void registerAttributeNotifications(DSIBase dSIBase) {
        this.logger.log(10000000, "[%1.registerAttributeNotifications]", (Object)LOGCLASS);
        dSIBase.setNotification(4, this.getDSIListener());
        dSIBase.setNotification(new int[]{5, 3, 1, 2, 8, 7}, this.getDSIListener());
    }

    protected DSIListener getDSIListener() {
        return this.dsiListener;
    }

    protected Class getDSIListenerClass() {
        return class$org$dsi$ifc$media$DSIMediaBaseListener == null ? (class$org$dsi$ifc$media$DSIMediaBaseListener = MediaDSIBaseControllerImpl.class$("org.dsi.ifc.media.DSIMediaBaseListener")) : class$org$dsi$ifc$media$DSIMediaBaseListener;
    }

    protected Class getDSIServiceClass() {
        return class$org$dsi$ifc$media$DSIMediaBase == null ? (class$org$dsi$ifc$media$DSIMediaBase = MediaDSIBaseControllerImpl.class$("org.dsi.ifc.media.DSIMediaBase")) : class$org$dsi$ifc$media$DSIMediaBase;
    }

    public boolean setParentalML(int n) {
        this.logger.log(1000000, "[%1.setParentalML] pml='%2'", (Object)LOGCLASS, (long)n);
        DSIMediaBase dSIMediaBase = this.dsiMediaBase;
        if (dSIMediaBase == null) {
            this.logger.log(100000, "[%1.setParentalML] No DSIMediaBase service registered. Ignore.", (Object)LOGCLASS);
            return false;
        }
        this.pmLevel = n;
        dSIMediaBase.setParentalML(n);
        return true;
    }

    public boolean setPreferredLanguage(String string) {
        this.logger.log(1000000, "[%1.setPreferredLanguage] languageCode='%2'", (Object)LOGCLASS, (Object)string);
        if (string == null) {
            throw new IllegalArgumentException();
        }
        DSIMediaBase dSIMediaBase = this.dsiMediaBase;
        if (dSIMediaBase == null) {
            this.logger.log(100000, "[%1.setPreferredLanguage] No DSIMediaBase service registered. Ignore.", (Object)LOGCLASS);
            return false;
        }
        dSIMediaBase.setPreferredLanguage(string);
        return true;
    }

    public boolean requestResetFactorySettings(int n) {
        this.logger.log(1000000, "[%1.requestResetFactorySettings] resetMode='%2'", (Object)LOGCLASS, (long)n);
        DSIMediaBase dSIMediaBase = this.dsiMediaBase;
        if (dSIMediaBase == null) {
            this.logger.log(100000, "[%1.requestResetFactorySettings] No DSIMediaBase service registered. Ignore.", (Object)LOGCLASS);
            return false;
        }
        dSIMediaBase.requestResetFactorySettings(n);
        return true;
    }

    public boolean eject(long l, long l2) {
        this.logger.log(1000000, "[%1.eject] deviceID='%2',mediaID='%3''", (Object)LOGCLASS, l, l2);
        DSIMediaBase dSIMediaBase = this.dsiMediaBase;
        if (dSIMediaBase == null) {
            this.logger.log(100000, "[%1.eject] No DSIMediaBase service registered. Ignore.", (Object)LOGCLASS);
            return false;
        }
        dSIMediaBase.ejectMedium(l, l2);
        return true;
    }

    public void setFactorySettingListener(IMediaFactoryResetListener iMediaFactoryResetListener) {
        this.logger.log(10000000, "[%1.setFactorySettingListener] %2'", (Object)LOGCLASS, (Object)iMediaFactoryResetListener);
        this.dsiListener.setFactoryResetListener(iMediaFactoryResetListener);
    }

    public void addLanguageListener(IMediaLanguageListener iMediaLanguageListener) {
        this.logger.log(1000000, "[%1.addLanguageListener] Add language listener ('%2')", (Object)LOGCLASS, (Object)iMediaLanguageListener);
        this.dsiListener.addLanguageListener(iMediaLanguageListener);
    }

    public void addParentalManagementListener(IMediaParentalManagementListener iMediaParentalManagementListener) {
        this.logger.log(1000000, "[%1.addParentalManagementListener] Add PML listener ('%2')", (Object)LOGCLASS, (Object)iMediaParentalManagementListener);
        this.dsiListener.addParentalManagementListener(iMediaParentalManagementListener);
    }

    public void removeParentalManagementListener(IMediaParentalManagementListener iMediaParentalManagementListener) {
        this.logger.log(1000000, "[%1.addParentalManagementListener] Add PML listener ('%2')", (Object)LOGCLASS, (Object)iMediaParentalManagementListener);
        this.dsiListener.removeParentalManagementListener(iMediaParentalManagementListener);
    }

    public void addMediaVersionListener(IMediaVersionListener iMediaVersionListener) {
        this.logger.log(1000000, "[%1.addMediaVersionListener] Add '%2'", (Object)LOGCLASS, (Object)iMediaVersionListener);
        this.dsiListener.addMediaVersionListener(iMediaVersionListener);
    }

    public void removeMediaVersionListener(IMediaVersionListener iMediaVersionListener) {
        this.logger.log(1000000, "[%1.removeMediaVersionListener] Remove '%2'", (Object)LOGCLASS, (Object)iMediaVersionListener);
        this.dsiListener.removeMediaVersionListener(iMediaVersionListener);
    }

    public void setLanguage(Language language) {
        this.logger.log(1000000, "[%1.setLanguage] Language change", (Object)LOGCLASS);
        DSIMediaBase dSIMediaBase = this.dsiMediaBase;
        if (dSIMediaBase == null) {
            this.logger.log(100000, "[%1.setLanguage] No DSIMediaBase service registered. Ignore.", (Object)LOGCLASS);
            return;
        }
        dSIMediaBase.setPreferredLanguage(language.getHmiCode());
    }

    public void addMediaDeviceListener(IMediaDeviceListener iMediaDeviceListener) {
        this.logger.log(1000000, "[%1.addMediaDeviceListener] '%2'", (Object)LOGCLASS, (Object)iMediaDeviceListener);
        this.dsiListener.addMediaDeviceListener(iMediaDeviceListener);
    }

    public boolean launchMediaApp(long l, long l2, String string) {
        this.logger.log(1000000, "[%1.launchMediaApp] pAppName='%2'", (Object)LOGCLASS, (Object)string);
        if (this.dsiMediaBase == null) {
            this.logger.log(100000, "[%1.launchMediaApp] No DSIMediaBase service registered. Ignore.", (Object)LOGCLASS);
            return false;
        }
        this.dsiMediaBase.launchApp(l, l2, string);
        return true;
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

