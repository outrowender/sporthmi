/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.sysapp;

import de.audi.atip.activator.AbstractFrameworkActivator;
import de.audi.atip.audio.HMIAudioService;
import de.audi.atip.base.FwServices;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.atip.sysapp.SysApp;
import de.audi.atip.sysapp.SysAppActivator$1;
import java.util.Dictionary;
import java.util.Hashtable;
import org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguage;
import org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStates;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class SysAppActivator
extends AbstractFrameworkActivator {
    private ServiceRegistration sRegPowerManagementListener;
    private ServiceRegistration sRegTimeUnitsLanguageListener;
    private ServiceRegistration sRegGeneralVehicleStatesListener;
    private DSIGeneralVehicleStates dsiGeneralVehicleStates;
    private DSICarTimeUnitsLanguage dsiCarTimeUnitsLanguage;
    private ServiceTracker dsiTracker;
    private LogChannel lc;
    private SysApp sysApp;
    private final FwServices fwServices;
    static /* synthetic */ Class class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStatesListener;
    static /* synthetic */ Class class$org$dsi$ifc$base$DSIListener;
    static /* synthetic */ Class class$de$audi$atip$audio$HMIAudioServiceListener;
    static /* synthetic */ Class class$de$audi$atip$power$PowerEventListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$cartrip$ITripDataProvider;
    static /* synthetic */ Class class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguageListener;
    static /* synthetic */ Class class$de$audi$atip$audio$HMIAudioService;
    static /* synthetic */ Class class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguage;
    static /* synthetic */ Class class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates;
    static /* synthetic */ Class class$de$audi$atip$interapp$SDSService;
    static /* synthetic */ Class class$de$audi$atip$diag$sw$SwDiagnosisManager;

    public SysAppActivator(FwServices fwServices) {
        super("SysApp");
        this.fwServices = fwServices;
    }

    public SysApp getService() {
        return this.sysApp;
    }

    @Override
    protected void startInternal(BundleContext bundleContext) {
        this.lc = this.framework.getLogChannel("Fw.SysApp");
        this.sysApp = new SysApp(this.framework);
    }

    public void initModels() {
        this.getService().initModels();
        Hashtable hashtable = new Hashtable();
        hashtable.put("DEVICE_NAME", (class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStatesListener == null ? (class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStatesListener = SysAppActivator.class$("org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStatesListener")) : class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStatesListener).getName());
        hashtable.put("DEVICE_INSTANCE", new Integer(0));
        this.sRegGeneralVehicleStatesListener = this.bundleContext.registerService((class$org$dsi$ifc$base$DSIListener == null ? (class$org$dsi$ifc$base$DSIListener = SysAppActivator.class$("org.dsi.ifc.base.DSIListener")) : class$org$dsi$ifc$base$DSIListener).getName(), (Object)this.sysApp.getGeneralVehicleStateHandler(), (Dictionary)hashtable);
        Hashtable hashtable2 = new Hashtable();
        hashtable2.put("AUDIO_CLIENT_ID", HMIAudioService.CLIENT_CAR);
        this.bundleContext.registerService((class$de$audi$atip$audio$HMIAudioServiceListener == null ? (class$de$audi$atip$audio$HMIAudioServiceListener = SysAppActivator.class$("de.audi.atip.audio.HMIAudioServiceListener")) : class$de$audi$atip$audio$HMIAudioServiceListener).getName(), (Object)this.sysApp.getGeneralVehicleStateHandler().audioListener, (Dictionary)hashtable2);
        this.sRegPowerManagementListener = this.bundleContext.registerService((class$de$audi$atip$power$PowerEventListener == null ? (class$de$audi$atip$power$PowerEventListener = SysAppActivator.class$("de.audi.atip.power.PowerEventListener")) : class$de$audi$atip$power$PowerEventListener).getName(), (Object)this.sysApp.getGeneralVehicleStateHandler(), null);
        this.initServiceListeners();
        this.initTracker();
        Hashtable hashtable3 = new Hashtable();
        hashtable3.put("DEVICE_NAME", (class$de$audi$atip$interapp$cartrip$ITripDataProvider == null ? (class$de$audi$atip$interapp$cartrip$ITripDataProvider = SysAppActivator.class$("de.audi.atip.interapp.cartrip.ITripDataProvider")) : class$de$audi$atip$interapp$cartrip$ITripDataProvider).getName());
        this.bundleContext.registerService((class$de$audi$atip$interapp$cartrip$ITripDataProvider == null ? (class$de$audi$atip$interapp$cartrip$ITripDataProvider = SysAppActivator.class$("de.audi.atip.interapp.cartrip.ITripDataProvider")) : class$de$audi$atip$interapp$cartrip$ITripDataProvider).getName(), (Object)this.sysApp.getDSICarTimeUnitsLanguageListener(), (Dictionary)hashtable3);
    }

    @Override
    public void stop(BundleContext bundleContext) {
        this.deinitServiceListeners();
        if (this.dsiTracker != null) {
            this.dsiTracker.close();
            this.dsiTracker = null;
        }
        super.stop(bundleContext);
    }

    private void initServiceListeners() {
        Hashtable hashtable = new Hashtable();
        hashtable.put("DEVICE_NAME", (class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguageListener == null ? (class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguageListener = SysAppActivator.class$("org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguageListener")) : class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguageListener).getName());
        hashtable.put("DEVICE_INSTANCE", new Integer(0));
        this.sRegTimeUnitsLanguageListener = this.bundleContext.registerService((class$org$dsi$ifc$base$DSIListener == null ? (class$org$dsi$ifc$base$DSIListener = SysAppActivator.class$("org.dsi.ifc.base.DSIListener")) : class$org$dsi$ifc$base$DSIListener).getName(), (Object)this.sysApp.getDSICarTimeUnitsLanguageListener(), (Dictionary)hashtable);
    }

    private void deinitServiceListeners() {
        if (this.sRegTimeUnitsLanguageListener != null) {
            this.sRegTimeUnitsLanguageListener.unregister();
            this.sRegTimeUnitsLanguageListener = null;
        }
        if (this.sRegPowerManagementListener != null) {
            this.sRegPowerManagementListener.unregister();
            this.sRegPowerManagementListener = null;
        }
        if (this.sRegGeneralVehicleStatesListener != null) {
            this.sRegGeneralVehicleStatesListener.unregister();
            this.sRegGeneralVehicleStatesListener = null;
        }
    }

    private void initTracker() {
        String[] stringArray = new String[]{(class$de$audi$atip$audio$HMIAudioService == null ? (class$de$audi$atip$audio$HMIAudioService = SysAppActivator.class$("de.audi.atip.audio.HMIAudioService")) : class$de$audi$atip$audio$HMIAudioService).getName(), (class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguage == null ? (class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguage = SysAppActivator.class$("org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguage")) : class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguage).getName(), (class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates == null ? (class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates = SysAppActivator.class$("org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStates")) : class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates).getName(), (class$de$audi$atip$interapp$SDSService == null ? (class$de$audi$atip$interapp$SDSService = SysAppActivator.class$("de.audi.atip.interapp.SDSService")) : class$de$audi$atip$interapp$SDSService).getName(), (class$de$audi$atip$diag$sw$SwDiagnosisManager == null ? (class$de$audi$atip$diag$sw$SwDiagnosisManager = SysAppActivator.class$("de.audi.atip.diag.sw.SwDiagnosisManager")) : class$de$audi$atip$diag$sw$SwDiagnosisManager).getName()};
        this.dsiTracker = new ServiceTracker(this.bundleContext, stringArray, (ServiceTrackerCustomizer)new SysAppActivator$1(this));
        this.dsiTracker.open();
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ BundleContext access$000(SysAppActivator sysAppActivator) {
        return sysAppActivator.bundleContext;
    }

    static /* synthetic */ SysApp access$100(SysAppActivator sysAppActivator) {
        return sysAppActivator.sysApp;
    }

    static /* synthetic */ FwServices access$200(SysAppActivator sysAppActivator) {
        return sysAppActivator.fwServices;
    }

    static /* synthetic */ BundleContext access$300(SysAppActivator sysAppActivator) {
        return sysAppActivator.bundleContext;
    }

    static /* synthetic */ BundleContext access$400(SysAppActivator sysAppActivator) {
        return sysAppActivator.bundleContext;
    }

    static /* synthetic */ BundleContext access$500(SysAppActivator sysAppActivator) {
        return sysAppActivator.bundleContext;
    }

    static /* synthetic */ DSICarTimeUnitsLanguage access$600(SysAppActivator sysAppActivator) {
        return sysAppActivator.dsiCarTimeUnitsLanguage;
    }

    static /* synthetic */ DSICarTimeUnitsLanguage access$602(SysAppActivator sysAppActivator, DSICarTimeUnitsLanguage dSICarTimeUnitsLanguage) {
        sysAppActivator.dsiCarTimeUnitsLanguage = dSICarTimeUnitsLanguage;
        return sysAppActivator.dsiCarTimeUnitsLanguage;
    }

    static /* synthetic */ LogChannel access$700(SysAppActivator sysAppActivator) {
        return sysAppActivator.lc;
    }

    static /* synthetic */ IFrameworkAccess access$800(SysAppActivator sysAppActivator) {
        return sysAppActivator.framework;
    }

    static /* synthetic */ DSIGeneralVehicleStates access$900(SysAppActivator sysAppActivator) {
        return sysAppActivator.dsiGeneralVehicleStates;
    }

    static /* synthetic */ DSIGeneralVehicleStates access$902(SysAppActivator sysAppActivator, DSIGeneralVehicleStates dSIGeneralVehicleStates) {
        sysAppActivator.dsiGeneralVehicleStates = dSIGeneralVehicleStates;
        return sysAppActivator.dsiGeneralVehicleStates;
    }

    static /* synthetic */ IFrameworkAccess access$1000(SysAppActivator sysAppActivator) {
        return sysAppActivator.framework;
    }
}

