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
    private static final String LOGCLASS;
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

    @Override
    public void init() {
        this.logger.log(1078071040, "[%1.init]", (Object)"MediaDSIBaseControllerImpl");
        super.init();
        Hashtable hashtable = new Hashtable(1);
        hashtable.put("LANG_COMPONENT_TYPE", "LANG_COMPONENT_HMI");
        this.i18nServiceRegistration = this.getServiceManager().registerService(class$de$audi$atip$i18n$I18NTarget == null ? (class$de$audi$atip$i18n$I18NTarget = MediaDSIBaseControllerImpl.class$("de.audi.atip.i18n.I18NTarget")) : class$de$audi$atip$i18n$I18NTarget, this, hashtable);
    }

    @Override
    public void deinit() {
        this.logger.log(1078071040, "[%1.deinit]", (Object)"MediaDSIBaseControllerImpl");
        super.deinit();
        this.i18nServiceRegistration.unregister();
        this.clearAttributeNotification(this.dsiMediaBase);
    }

    @Override
    public void addDSIService(DSIBase dSIBase) {
        this.logger.log(1078071040, "[%1.addDSIService] '%2'.", (Object)"MediaDSIBaseControllerImpl", (Object)dSIBase);
        this.dsiMediaBase = (DSIMediaBase)dSIBase;
        this.registerAttributeNotifications(dSIBase);
        this.setPreferredLanguage(this.framework.getLanguageMgr().getCurrentLanguage("LANG_COMPONENT_HMI").getHmiCode());
        this.setParentalML(this.pmLevel);
    }

    @Override
    protected void removeDSIService() {
        this.logger.log(1078071040, "[%1.removeDSIService] DSI service removed.", (Object)"MediaDSIBaseControllerImpl");
        this.dsiMediaBase = null;
    }

    private void registerAttributeNotifications(DSIBase dSIBase) {
        this.logger.log(-2137614336, "[%1.registerAttributeNotifications]", (Object)"MediaDSIBaseControllerImpl");
        dSIBase.setNotification(4, this.getDSIListener());
        dSIBase.setNotification(new int[]{5, 3, 1, 2, 8, 7}, this.getDSIListener());
    }

    @Override
    protected DSIListener getDSIListener() {
        return this.dsiListener;
    }

    @Override
    protected Class getDSIListenerClass() {
        return class$org$dsi$ifc$media$DSIMediaBaseListener == null ? (class$org$dsi$ifc$media$DSIMediaBaseListener = MediaDSIBaseControllerImpl.class$("org.dsi.ifc.media.DSIMediaBaseListener")) : class$org$dsi$ifc$media$DSIMediaBaseListener;
    }

    @Override
    protected Class getDSIServiceClass() {
        return class$org$dsi$ifc$media$DSIMediaBase == null ? (class$org$dsi$ifc$media$DSIMediaBase = MediaDSIBaseControllerImpl.class$("org.dsi.ifc.media.DSIMediaBase")) : class$org$dsi$ifc$media$DSIMediaBase;
    }

    @Override
    public boolean setParentalML(int n) {
        this.logger.log(1078071040, "[%1.setParentalML] pml='%2'", (Object)"MediaDSIBaseControllerImpl", (long)n);
        DSIMediaBase dSIMediaBase = this.dsiMediaBase;
        if (dSIMediaBase == null) {
            this.logger.log(-1601830656, "[%1.setParentalML] No DSIMediaBase service registered. Ignore.", (Object)"MediaDSIBaseControllerImpl");
            return false;
        }
        this.pmLevel = n;
        dSIMediaBase.setParentalML(n);
        return true;
    }

    @Override
    public boolean setPreferredLanguage(String string) {
        this.logger.log(1078071040, "[%1.setPreferredLanguage] languageCode='%2'", (Object)"MediaDSIBaseControllerImpl", (Object)string);
        if (string == null) {
            throw new IllegalArgumentException();
        }
        DSIMediaBase dSIMediaBase = this.dsiMediaBase;
        if (dSIMediaBase == null) {
            this.logger.log(-1601830656, "[%1.setPreferredLanguage] No DSIMediaBase service registered. Ignore.", (Object)"MediaDSIBaseControllerImpl");
            return false;
        }
        dSIMediaBase.setPreferredLanguage(string);
        return true;
    }

    @Override
    public boolean requestResetFactorySettings(int n) {
        this.logger.log(1078071040, "[%1.requestResetFactorySettings] resetMode='%2'", (Object)"MediaDSIBaseControllerImpl", (long)n);
        DSIMediaBase dSIMediaBase = this.dsiMediaBase;
        if (dSIMediaBase == null) {
            this.logger.log(-1601830656, "[%1.requestResetFactorySettings] No DSIMediaBase service registered. Ignore.", (Object)"MediaDSIBaseControllerImpl");
            return false;
        }
        dSIMediaBase.requestResetFactorySettings(n);
        return true;
    }

    @Override
    public boolean eject(long l, long l2) {
        this.logger.log(1078071040, "[%1.eject] deviceID='%2',mediaID='%3''", (Object)"MediaDSIBaseControllerImpl", l, l2);
        DSIMediaBase dSIMediaBase = this.dsiMediaBase;
        if (dSIMediaBase == null) {
            this.logger.log(-1601830656, "[%1.eject] No DSIMediaBase service registered. Ignore.", (Object)"MediaDSIBaseControllerImpl");
            return false;
        }
        dSIMediaBase.ejectMedium(l, l2);
        return true;
    }

    @Override
    public void setFactorySettingListener(IMediaFactoryResetListener iMediaFactoryResetListener) {
        this.logger.log(-2137614336, "[%1.setFactorySettingListener] %2'", (Object)"MediaDSIBaseControllerImpl", (Object)iMediaFactoryResetListener);
        this.dsiListener.setFactoryResetListener(iMediaFactoryResetListener);
    }

    @Override
    public void addLanguageListener(IMediaLanguageListener iMediaLanguageListener) {
        this.logger.log(1078071040, "[%1.addLanguageListener] Add language listener ('%2')", (Object)"MediaDSIBaseControllerImpl", (Object)iMediaLanguageListener);
        this.dsiListener.addLanguageListener(iMediaLanguageListener);
    }

    @Override
    public void addParentalManagementListener(IMediaParentalManagementListener iMediaParentalManagementListener) {
        this.logger.log(1078071040, "[%1.addParentalManagementListener] Add PML listener ('%2')", (Object)"MediaDSIBaseControllerImpl", (Object)iMediaParentalManagementListener);
        this.dsiListener.addParentalManagementListener(iMediaParentalManagementListener);
    }

    @Override
    public void removeParentalManagementListener(IMediaParentalManagementListener iMediaParentalManagementListener) {
        this.logger.log(1078071040, "[%1.addParentalManagementListener] Add PML listener ('%2')", (Object)"MediaDSIBaseControllerImpl", (Object)iMediaParentalManagementListener);
        this.dsiListener.removeParentalManagementListener(iMediaParentalManagementListener);
    }

    @Override
    public void addMediaVersionListener(IMediaVersionListener iMediaVersionListener) {
        this.logger.log(1078071040, "[%1.addMediaVersionListener] Add '%2'", (Object)"MediaDSIBaseControllerImpl", (Object)iMediaVersionListener);
        this.dsiListener.addMediaVersionListener(iMediaVersionListener);
    }

    @Override
    public void removeMediaVersionListener(IMediaVersionListener iMediaVersionListener) {
        this.logger.log(1078071040, "[%1.removeMediaVersionListener] Remove '%2'", (Object)"MediaDSIBaseControllerImpl", (Object)iMediaVersionListener);
        this.dsiListener.removeMediaVersionListener(iMediaVersionListener);
    }

    @Override
    public void setLanguage(Language language) {
        this.logger.log(1078071040, "[%1.setLanguage] Language change", (Object)"MediaDSIBaseControllerImpl");
        DSIMediaBase dSIMediaBase = this.dsiMediaBase;
        if (dSIMediaBase == null) {
            this.logger.log(-1601830656, "[%1.setLanguage] No DSIMediaBase service registered. Ignore.", (Object)"MediaDSIBaseControllerImpl");
            return;
        }
        dSIMediaBase.setPreferredLanguage(language.getHmiCode());
    }

    @Override
    public void addMediaDeviceListener(IMediaDeviceListener iMediaDeviceListener) {
        this.logger.log(1078071040, "[%1.addMediaDeviceListener] '%2'", (Object)"MediaDSIBaseControllerImpl", (Object)iMediaDeviceListener);
        this.dsiListener.addMediaDeviceListener(iMediaDeviceListener);
    }

    @Override
    public boolean launchMediaApp(long l, long l2, String string) {
        this.logger.log(1078071040, "[%1.launchMediaApp] pAppName='%2'", (Object)"MediaDSIBaseControllerImpl", (Object)string);
        if (this.dsiMediaBase == null) {
            this.logger.log(-1601830656, "[%1.launchMediaApp] No DSIMediaBase service registered. Ignore.", (Object)"MediaDSIBaseControllerImpl");
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

