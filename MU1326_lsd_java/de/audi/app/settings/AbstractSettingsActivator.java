/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.settings.SettingsDiag
 */
package de.audi.app.settings;

import de.audi.app.settings.SettingsApp;
import de.audi.app.settings.SettingsEnv;
import de.audi.app.settings.display.AbstractDisplayHandler;
import de.audi.app.settings.display.KombiBrightnessHandler;
import de.audi.app.settings.etc.ETCHandler;
import de.audi.app.settings.sdis.AbstractSDISHandler;
import de.audi.atip.activator.AbstractActivator;
import de.audi.atip.browser.IBrowserHandler;
import de.audi.atip.diag.sw.AbstractSwDiagnosis;
import de.audi.atip.diag.sw.SwDiagnosisManager;
import de.audi.atip.interapp.sdis.ISDISBlockingService;
import de.audi.atip.interapp.sdis.ISDISHeadUnitService;
import de.audi.atip.interapp.tts.TTSService;
import de.audi.atip.interapp.tts.TTSSingleSpeakService;
import de.audi.atip.log.LogChannel;
import de.audi.atip.statemachine.ActionProxy;
import de.mib.swdiagnosis.settings.SettingsDiag;
import java.util.Dictionary;
import java.util.Hashtable;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.carcomfort.DSICarComfort;
import org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguage;
import org.dsi.ifc.navigation.DSINavigation;
import org.dsi.ifc.tollcollect.DSITollCollect;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public abstract class AbstractSettingsActivator
extends AbstractActivator
implements ServiceTrackerCustomizer {
    private ServiceTracker serviceTracker;
    protected AbstractDisplayHandler displayHandler;
    protected AbstractSDISHandler sdisHandler;
    protected KombiBrightnessHandler kombiBrightnessHandler;
    private final SettingsEnv env = new SettingsEnv();
    private final SettingsApp app = new SettingsApp();
    static /* synthetic */ Class class$de$audi$atip$power$PowerEventListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$tv$ITVStateListener;
    static /* synthetic */ Class class$org$dsi$ifc$tollcollect$DSITollCollectListener;
    static /* synthetic */ Class class$org$dsi$ifc$base$DSIListener;
    static /* synthetic */ Class class$org$dsi$ifc$tollcollect$DSITollCollect;
    static /* synthetic */ Class class$de$audi$atip$interapp$tts$TTSListener;
    static /* synthetic */ Class class$de$audi$atip$msg$MsgListener;
    static /* synthetic */ Class class$de$audi$app$settings$SettingsApp;
    static /* synthetic */ Class class$de$audi$atip$hmi$HMIApplication;
    static /* synthetic */ Class class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguageListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$FactResetService;
    static /* synthetic */ Class class$de$audi$atip$i18n$I18NTarget;
    static /* synthetic */ Class class$de$audi$atip$statemachine$ActionProxy;
    static /* synthetic */ Class class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguage;
    static /* synthetic */ Class class$org$dsi$ifc$carcomfort$DSICarComfort;
    static /* synthetic */ Class class$de$audi$atip$browser$IBrowserHandler;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigation;
    static /* synthetic */ Class class$de$audi$atip$diag$sw$SwDiagnosisManager;
    static /* synthetic */ Class class$de$audi$atip$interapp$tts$TTSService;

    @Override
    public void start(BundleContext bundleContext) {
        Object object;
        super.start(bundleContext);
        this.getEnv().init(this.framework, bundleContext);
        this.registerService((class$de$audi$atip$power$PowerEventListener == null ? (class$de$audi$atip$power$PowerEventListener = AbstractSettingsActivator.class$("de.audi.atip.power.PowerEventListener")) : class$de$audi$atip$power$PowerEventListener).getName(), (Object)this.getEnv().getUnitHandler(), null);
        this.registerService((class$de$audi$atip$power$PowerEventListener == null ? (class$de$audi$atip$power$PowerEventListener = AbstractSettingsActivator.class$("de.audi.atip.power.PowerEventListener")) : class$de$audi$atip$power$PowerEventListener).getName(), (Object)this.getEnv().getTimeHandler(), null);
        this.registerService((class$de$audi$atip$interapp$tv$ITVStateListener == null ? (class$de$audi$atip$interapp$tv$ITVStateListener = AbstractSettingsActivator.class$("de.audi.atip.interapp.tv.ITVStateListener")) : class$de$audi$atip$interapp$tv$ITVStateListener).getName(), (Object)this.getEnv().getFactoryResetHandler(), null);
        if (this.getEnv().isETCAvailable()) {
            object = this.getEnv().getEtcHandler();
            Hashtable hashtable = new Hashtable();
            ((Dictionary)hashtable).put("DEVICE_NAME", (class$org$dsi$ifc$tollcollect$DSITollCollectListener == null ? (class$org$dsi$ifc$tollcollect$DSITollCollectListener = AbstractSettingsActivator.class$("org.dsi.ifc.tollcollect.DSITollCollectListener")) : class$org$dsi$ifc$tollcollect$DSITollCollectListener).getName());
            ((Dictionary)hashtable).put("DEVICE_INSTANCE", new Integer(0));
            this.registerService((class$org$dsi$ifc$base$DSIListener == null ? (class$org$dsi$ifc$base$DSIListener = AbstractSettingsActivator.class$("org.dsi.ifc.base.DSIListener")) : class$org$dsi$ifc$base$DSIListener).getName(), object, (Dictionary)hashtable);
            this.registerService((class$de$audi$atip$power$PowerEventListener == null ? (class$de$audi$atip$power$PowerEventListener = AbstractSettingsActivator.class$("de.audi.atip.power.PowerEventListener")) : class$de$audi$atip$power$PowerEventListener).getName(), (Object)this.getEnv().getEtcHandler(), null);
            this.framework.startDSIService((class$org$dsi$ifc$tollcollect$DSITollCollect == null ? (class$org$dsi$ifc$tollcollect$DSITollCollect = AbstractSettingsActivator.class$("org.dsi.ifc.tollcollect.DSITollCollect")) : class$org$dsi$ifc$tollcollect$DSITollCollect).getName(), 0);
            hashtable = new Hashtable();
            ((Dictionary)hashtable).put("TTS_CLIENT_ID", TTSService.CLIENT_ID_ETC_WARNING);
            ((Dictionary)hashtable).put("ApplicationName", "CLIENT_ID_ETC_WARNING");
            this.registerService((class$de$audi$atip$interapp$tts$TTSListener == null ? (class$de$audi$atip$interapp$tts$TTSListener = AbstractSettingsActivator.class$("de.audi.atip.interapp.tts.TTSListener")) : class$de$audi$atip$interapp$tts$TTSListener).getName(), (Object)((ETCHandler)object).getTTSHandler(), (Dictionary)hashtable);
            hashtable = new Hashtable();
            ((Dictionary)hashtable).put("TTS_CLIENT_ID", TTSService.CLIENT_ID_ETC_INFORMATION);
            ((Dictionary)hashtable).put("ApplicationName", "CLIENT_ID_ETC_INFORMATION");
            this.registerService((class$de$audi$atip$interapp$tts$TTSListener == null ? (class$de$audi$atip$interapp$tts$TTSListener = AbstractSettingsActivator.class$("de.audi.atip.interapp.tts.TTSListener")) : class$de$audi$atip$interapp$tts$TTSListener).getName(), (Object)((ETCHandler)object).getTTSHandler(), (Dictionary)hashtable);
            this.registerService((class$de$audi$atip$msg$MsgListener == null ? (class$de$audi$atip$msg$MsgListener = AbstractSettingsActivator.class$("de.audi.atip.msg.MsgListener")) : class$de$audi$atip$msg$MsgListener).getName(), object, null);
        }
        object = new Hashtable();
        ((Dictionary)object).put("ApplicationName", (class$de$audi$app$settings$SettingsApp == null ? (class$de$audi$app$settings$SettingsApp = AbstractSettingsActivator.class$("de.audi.app.settings.SettingsApp")) : class$de$audi$app$settings$SettingsApp).getName());
        ((Dictionary)object).put("moduleID", new Integer(this.app.getId()));
        this.registerService((class$de$audi$atip$hmi$HMIApplication == null ? (class$de$audi$atip$hmi$HMIApplication = AbstractSettingsActivator.class$("de.audi.atip.hmi.HMIApplication")) : class$de$audi$atip$hmi$HMIApplication).getName(), (Object)this.app, (Dictionary)object);
        object = new Hashtable();
        ((Dictionary)object).put("DEVICE_NAME", (class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguageListener == null ? (class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguageListener = AbstractSettingsActivator.class$("org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguageListener")) : class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguageListener).getName());
        ((Dictionary)object).put("DEVICE_INSTANCE", new Integer(0));
        this.registerService((class$org$dsi$ifc$base$DSIListener == null ? (class$org$dsi$ifc$base$DSIListener = AbstractSettingsActivator.class$("org.dsi.ifc.base.DSIListener")) : class$org$dsi$ifc$base$DSIListener).getName(), (Object)this.getEnv().getDSIManager(), (Dictionary)object);
        this.registerService((class$de$audi$atip$interapp$FactResetService == null ? (class$de$audi$atip$interapp$FactResetService = AbstractSettingsActivator.class$("de.audi.atip.interapp.FactResetService")) : class$de$audi$atip$interapp$FactResetService).getName(), (Object)this.getEnv().getFactoryResetHandler().getResetService(), null);
        this.registerI18NTarget();
        this.initTracker();
    }

    @Override
    public void stop(BundleContext bundleContext) {
        this.deinitTracker();
        this.getEnv().deinit();
        this.kombiBrightnessHandler = null;
        this.displayHandler = null;
        this.sdisHandler = null;
        super.stop(bundleContext);
    }

    private final void logServiceProblem(String string, ServiceReference serviceReference, Object object, Throwable throwable) {
        LogChannel logChannel = this.getEnv().getFw().getLogChannel("App.Settings.Main");
        logChannel.log(-1601830656, "AbstractSettingsActivator.%1(svcRef= %2, serivce= %3) failed!", (Object)string, (Object)serviceReference, object);
        logChannel.log(-1601830656, "with Exception: ", throwable);
    }

    protected final SettingsEnv getEnv() {
        return this.env;
    }

    private void registerI18NTarget() {
        Hashtable hashtable = new Hashtable();
        ((Dictionary)hashtable).put("LANG_COMPONENT_TYPE", "LANG_COMPONENT_HMI");
        this.registerService((class$de$audi$atip$i18n$I18NTarget == null ? (class$de$audi$atip$i18n$I18NTarget = AbstractSettingsActivator.class$("de.audi.atip.i18n.I18NTarget")) : class$de$audi$atip$i18n$I18NTarget).getName(), (Object)this.getEnv().getDSIManager().getLanguageHandler(), (Dictionary)hashtable);
    }

    protected void registerActionProxy(ActionProxy actionProxy, int n) {
        Hashtable hashtable = new Hashtable();
        hashtable.put("moduleID", new Integer(n));
        this.registerService((class$de$audi$atip$statemachine$ActionProxy == null ? (class$de$audi$atip$statemachine$ActionProxy = AbstractSettingsActivator.class$("de.audi.atip.statemachine.ActionProxy")) : class$de$audi$atip$statemachine$ActionProxy).getName(), (Object)actionProxy, (Dictionary)hashtable);
    }

    private void initTracker() {
        String[] stringArray = new String[]{(class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguage == null ? (class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguage = AbstractSettingsActivator.class$("org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguage")) : class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguage).getName(), (class$org$dsi$ifc$carcomfort$DSICarComfort == null ? (class$org$dsi$ifc$carcomfort$DSICarComfort = AbstractSettingsActivator.class$("org.dsi.ifc.carcomfort.DSICarComfort")) : class$org$dsi$ifc$carcomfort$DSICarComfort).getName(), (class$de$audi$atip$browser$IBrowserHandler == null ? (class$de$audi$atip$browser$IBrowserHandler = AbstractSettingsActivator.class$("de.audi.atip.browser.IBrowserHandler")) : class$de$audi$atip$browser$IBrowserHandler).getName(), (class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = AbstractSettingsActivator.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName(), (class$de$audi$atip$diag$sw$SwDiagnosisManager == null ? (class$de$audi$atip$diag$sw$SwDiagnosisManager = AbstractSettingsActivator.class$("de.audi.atip.diag.sw.SwDiagnosisManager")) : class$de$audi$atip$diag$sw$SwDiagnosisManager).getName()};
        if (this.getEnv().isETCAvailable()) {
            stringArray = this.mergeServiceNames(stringArray, new String[]{(class$org$dsi$ifc$tollcollect$DSITollCollect == null ? (class$org$dsi$ifc$tollcollect$DSITollCollect = AbstractSettingsActivator.class$("org.dsi.ifc.tollcollect.DSITollCollect")) : class$org$dsi$ifc$tollcollect$DSITollCollect).getName(), (class$de$audi$atip$interapp$tts$TTSService == null ? (class$de$audi$atip$interapp$tts$TTSService = AbstractSettingsActivator.class$("de.audi.atip.interapp.tts.TTSService")) : class$de$audi$atip$interapp$tts$TTSService).getName()});
        }
        this.serviceTracker = new ServiceTracker(this.getBundleContext(), stringArray, (ServiceTrackerCustomizer)this);
        this.serviceTracker.open();
    }

    private final String[] mergeServiceNames(String[] stringArray, String[] stringArray2) {
        String[] stringArray3 = new String[stringArray.length + stringArray2.length];
        System.arraycopy((Object)stringArray, 0, (Object)stringArray3, 0, stringArray.length);
        System.arraycopy((Object)stringArray2, 0, (Object)stringArray3, stringArray.length, stringArray2.length);
        return stringArray3;
    }

    private void deinitTracker() {
        this.serviceTracker = this.closeTracker(this.serviceTracker);
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        Object object = this.getBundleContext().getService(serviceReference);
        try {
            if (object instanceof DSICarTimeUnitsLanguage) {
                this.getEnv().getDSIManager().setDSI((DSICarTimeUnitsLanguage)object);
            } else if (object instanceof DSICarComfort) {
                this.getEnv().getDSICarComfortManager().setDSI((DSICarComfort)object);
            } else if (object instanceof DSINavigation) {
                ((DSINavigation)object).setNotification(97, (DSIListener)this.getEnv().getNavigationListener());
            } else if (object instanceof SwDiagnosisManager) {
                ((SwDiagnosisManager)object).addDiagGateway((AbstractSwDiagnosis)new SettingsDiag(this.env, this.displayHandler, this.sdisHandler));
            } else if (object instanceof IBrowserHandler) {
                Object object2 = serviceReference.getProperty("DEVICE_INSTANCE");
                if ((Integer)object2 == 1) {
                    IBrowserHandler iBrowserHandler = (IBrowserHandler)object;
                    this.getEnv().getLicenseBrowser().setBrowserHandler(iBrowserHandler);
                } else {
                    object = null;
                }
            } else if (object instanceof ISDISBlockingService) {
                AbstractSDISHandler abstractSDISHandler = this.sdisHandler;
                if (abstractSDISHandler != null) {
                    abstractSDISHandler.setSDISBlockingService((ISDISBlockingService)object);
                } else {
                    object = null;
                }
            } else if (object instanceof ISDISHeadUnitService) {
                AbstractSDISHandler abstractSDISHandler = this.sdisHandler;
                if (abstractSDISHandler != null) {
                    abstractSDISHandler.setSDISHeadUnitService((ISDISHeadUnitService)object);
                } else {
                    object = null;
                }
            } else if (this.getEnv().isETCAvailable() && object instanceof DSITollCollect) {
                ETCHandler eTCHandler = this.getEnv().getEtcHandler();
                if (eTCHandler != null) {
                    eTCHandler.setDSI((DSITollCollect)object);
                }
            } else if (this.getEnv().isETCAvailable() && object instanceof TTSService) {
                ETCHandler eTCHandler;
                int n = (Integer)serviceReference.getProperty("TTS_CLIENT_ID");
                if ((n == 13 || n == 14) && (eTCHandler = this.getEnv().getEtcHandler()) != null) {
                    eTCHandler.getTTSHandler().setTTSService(n, (TTSSingleSpeakService)object);
                }
            } else {
                object = null;
            }
        }
        catch (Exception exception) {
            this.logServiceProblem("addingService", serviceReference, object, exception);
            object = null;
        }
        catch (NoClassDefFoundError noClassDefFoundError) {
            this.logServiceProblem("addingService", serviceReference, object, noClassDefFoundError);
            object = null;
        }
        if (object == null) {
            this.getBundleContext().ungetService(serviceReference);
        }
        return object;
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        try {
            ETCHandler eTCHandler;
            int n;
            if (object instanceof DSICarTimeUnitsLanguage) {
                this.getEnv().getDSIManager().setDSI(null);
            } else if (object instanceof DSICarComfort) {
                this.getEnv().getDSICarComfortManager().setDSI(null);
            } else if (object instanceof DSINavigation) {
                ((DSINavigation)object).clearNotification(97, (DSIListener)this.getEnv().getNavigationListener());
            } else if (object instanceof IBrowserHandler) {
                this.getEnv().getLicenseBrowser().setBrowserHandler(null);
            } else if (object instanceof ISDISBlockingService) {
                AbstractSDISHandler abstractSDISHandler = this.sdisHandler;
                if (abstractSDISHandler != null) {
                    abstractSDISHandler.setSDISBlockingService(null);
                }
            } else if (object instanceof ISDISHeadUnitService) {
                AbstractSDISHandler abstractSDISHandler = this.sdisHandler;
                if (abstractSDISHandler != null) {
                    abstractSDISHandler.setSDISHeadUnitService(null);
                }
            } else if (this.getEnv().isETCAvailable() && object instanceof DSITollCollect) {
                ETCHandler eTCHandler2 = this.getEnv().getEtcHandler();
                if (eTCHandler2 != null) {
                    eTCHandler2.setDSI(null);
                }
            } else if (this.getEnv().isETCAvailable() && object instanceof TTSService && ((n = ((Integer)serviceReference.getProperty("TTS_CLIENT_ID")).intValue()) == 14 || n == 13) && (eTCHandler = this.getEnv().getEtcHandler()) != null) {
                eTCHandler.getTTSHandler().setTTSService(n, null);
            }
        }
        catch (Exception exception) {
            this.logServiceProblem("removedService", serviceReference, object, exception);
            object = null;
        }
        catch (NoClassDefFoundError noClassDefFoundError) {
            this.logServiceProblem("removedService", serviceReference, object, noClassDefFoundError);
            object = null;
        }
        finally {
            this.getBundleContext().ungetService(serviceReference);
        }
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

