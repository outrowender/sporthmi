/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.PowerManagerDiag
 */
package de.audi.tghu.power;

import de.audi.atip.activator.AbstractFrameworkActivator;
import de.audi.atip.audio.HMIAudioService;
import de.audi.atip.base.FwServices;
import de.audi.atip.diag.sw.AbstractSwDiagnosis;
import de.audi.atip.diag.sw.SwDiagnosisManager;
import de.audi.atip.power.IPowerManager;
import de.audi.atip.power.PowerEventListener;
import de.audi.tghu.power.PowerManager;
import de.mib.swdiagnosis.PowerManagerDiag;
import java.util.Dictionary;
import java.util.Hashtable;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.displaycontroller.DSIDisplayController;
import org.dsi.ifc.displaymanagement.DSIDisplayManagement;
import org.dsi.ifc.keypanel.DSIKeyPanel;
import org.dsi.ifc.powermanagement.DSIPowerManagement;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public final class PowerActivator
extends AbstractFrameworkActivator
implements ServiceTrackerCustomizer {
    private PowerManager powerMgr;
    private ServiceTracker tracker;
    private ServiceRegistration sRegPower;
    private ServiceRegistration sRegDisplay;
    private FwServices fwService;
    static /* synthetic */ Class class$de$audi$atip$audio$HMIAudioServiceListener;
    static /* synthetic */ Class class$de$audi$atip$msg$MsgListener;
    static /* synthetic */ Class class$org$dsi$ifc$powermanagement$DSIPowerManagementListener;
    static /* synthetic */ Class class$org$dsi$ifc$base$DSIListener;
    static /* synthetic */ Class class$org$dsi$ifc$displaymanagement$DSIDisplayManagementListener;
    static /* synthetic */ Class class$org$dsi$ifc$powermanagement$DSIPowerManagement;
    static /* synthetic */ Class class$de$audi$atip$audio$HMIAudioService;
    static /* synthetic */ Class class$org$dsi$ifc$displaymanagement$DSIDisplayManagement;
    static /* synthetic */ Class class$org$dsi$ifc$displaycontroller$DSIDisplayController;
    static /* synthetic */ Class class$org$dsi$ifc$keypanel$DSIKeyPanel;
    static /* synthetic */ Class class$de$audi$atip$power$PowerEventListener;
    static /* synthetic */ Class class$de$audi$atip$diag$sw$SwDiagnosisManager;

    public PowerActivator(FwServices fwServices) {
        super("FwPowerMgmt");
        this.fwService = fwServices;
    }

    public IPowerManager getService() {
        return this.powerMgr;
    }

    @Override
    protected void startInternal(BundleContext bundleContext) {
        Hashtable hashtable;
        this.powerMgr = new PowerManager(this.fwService);
        Hashtable hashtable2 = new Hashtable();
        hashtable2.put("AUDIO_CLIENT_ID", HMIAudioService.CLIENT_POWER);
        bundleContext.registerService((class$de$audi$atip$audio$HMIAudioServiceListener == null ? (class$de$audi$atip$audio$HMIAudioServiceListener = PowerActivator.class$("de.audi.atip.audio.HMIAudioServiceListener")) : class$de$audi$atip$audio$HMIAudioServiceListener).getName(), (Object)this.powerMgr.getPwrAudioHandler(), (Dictionary)hashtable2);
        DSIListener dSIListener = this.powerMgr.getPwrDSIHandler();
        if (dSIListener != null) {
            bundleContext.registerService((class$de$audi$atip$msg$MsgListener == null ? (class$de$audi$atip$msg$MsgListener = PowerActivator.class$("de.audi.atip.msg.MsgListener")) : class$de$audi$atip$msg$MsgListener).getName(), (Object)dSIListener, null);
            hashtable = new Hashtable();
            ((Dictionary)hashtable).put("DEVICE_NAME", (class$org$dsi$ifc$powermanagement$DSIPowerManagementListener == null ? (class$org$dsi$ifc$powermanagement$DSIPowerManagementListener = PowerActivator.class$("org.dsi.ifc.powermanagement.DSIPowerManagementListener")) : class$org$dsi$ifc$powermanagement$DSIPowerManagementListener).getName());
            ((Dictionary)hashtable).put("DEVICE_INSTANCE", new Integer(0));
            this.sRegPower = bundleContext.registerService((class$org$dsi$ifc$base$DSIListener == null ? (class$org$dsi$ifc$base$DSIListener = PowerActivator.class$("org.dsi.ifc.base.DSIListener")) : class$org$dsi$ifc$base$DSIListener).getName(), (Object)dSIListener, (Dictionary)hashtable);
        }
        if ((dSIListener = this.powerMgr.getNativeDisplayHandler()) != null) {
            hashtable = new Hashtable();
            ((Dictionary)hashtable).put("DEVICE_NAME", (class$org$dsi$ifc$displaymanagement$DSIDisplayManagementListener == null ? (class$org$dsi$ifc$displaymanagement$DSIDisplayManagementListener = PowerActivator.class$("org.dsi.ifc.displaymanagement.DSIDisplayManagementListener")) : class$org$dsi$ifc$displaymanagement$DSIDisplayManagementListener).getName());
            ((Dictionary)hashtable).put("DEVICE_INSTANCE", new Integer(0));
            this.sRegDisplay = bundleContext.registerService((class$org$dsi$ifc$base$DSIListener == null ? (class$org$dsi$ifc$base$DSIListener = PowerActivator.class$("org.dsi.ifc.base.DSIListener")) : class$org$dsi$ifc$base$DSIListener).getName(), (Object)dSIListener, (Dictionary)hashtable);
        }
        String[] stringArray = new String[]{(class$org$dsi$ifc$powermanagement$DSIPowerManagement == null ? (class$org$dsi$ifc$powermanagement$DSIPowerManagement = PowerActivator.class$("org.dsi.ifc.powermanagement.DSIPowerManagement")) : class$org$dsi$ifc$powermanagement$DSIPowerManagement).getName(), (class$de$audi$atip$audio$HMIAudioService == null ? (class$de$audi$atip$audio$HMIAudioService = PowerActivator.class$("de.audi.atip.audio.HMIAudioService")) : class$de$audi$atip$audio$HMIAudioService).getName(), (class$org$dsi$ifc$displaymanagement$DSIDisplayManagement == null ? (class$org$dsi$ifc$displaymanagement$DSIDisplayManagement = PowerActivator.class$("org.dsi.ifc.displaymanagement.DSIDisplayManagement")) : class$org$dsi$ifc$displaymanagement$DSIDisplayManagement).getName(), (class$org$dsi$ifc$displaycontroller$DSIDisplayController == null ? (class$org$dsi$ifc$displaycontroller$DSIDisplayController = PowerActivator.class$("org.dsi.ifc.displaycontroller.DSIDisplayController")) : class$org$dsi$ifc$displaycontroller$DSIDisplayController).getName(), (class$org$dsi$ifc$keypanel$DSIKeyPanel == null ? (class$org$dsi$ifc$keypanel$DSIKeyPanel = PowerActivator.class$("org.dsi.ifc.keypanel.DSIKeyPanel")) : class$org$dsi$ifc$keypanel$DSIKeyPanel).getName(), (class$de$audi$atip$power$PowerEventListener == null ? (class$de$audi$atip$power$PowerEventListener = PowerActivator.class$("de.audi.atip.power.PowerEventListener")) : class$de$audi$atip$power$PowerEventListener).getName(), (class$de$audi$atip$diag$sw$SwDiagnosisManager == null ? (class$de$audi$atip$diag$sw$SwDiagnosisManager = PowerActivator.class$("de.audi.atip.diag.sw.SwDiagnosisManager")) : class$de$audi$atip$diag$sw$SwDiagnosisManager).getName()};
        this.tracker = new ServiceTracker(this.bundleContext, stringArray, (ServiceTrackerCustomizer)this);
        this.tracker.open();
        this.framework.startDSIService((class$org$dsi$ifc$powermanagement$DSIPowerManagement == null ? (class$org$dsi$ifc$powermanagement$DSIPowerManagement = PowerActivator.class$("org.dsi.ifc.powermanagement.DSIPowerManagement")) : class$org$dsi$ifc$powermanagement$DSIPowerManagement).getName(), 0);
        this.framework.startDSIService((class$org$dsi$ifc$displaymanagement$DSIDisplayManagement == null ? (class$org$dsi$ifc$displaymanagement$DSIDisplayManagement = PowerActivator.class$("org.dsi.ifc.displaymanagement.DSIDisplayManagement")) : class$org$dsi$ifc$displaymanagement$DSIDisplayManagement).getName(), 0);
        this.framework.startDSIService((class$org$dsi$ifc$displaycontroller$DSIDisplayController == null ? (class$org$dsi$ifc$displaycontroller$DSIDisplayController = PowerActivator.class$("org.dsi.ifc.displaycontroller.DSIDisplayController")) : class$org$dsi$ifc$displaycontroller$DSIDisplayController).getName(), 0);
    }

    @Override
    public void stop(BundleContext bundleContext) {
        if (this.sRegPower != null) {
            this.sRegPower.unregister();
            this.sRegPower = null;
        }
        if (this.sRegDisplay != null) {
            this.sRegDisplay.unregister();
            this.sRegDisplay = null;
        }
        if (this.tracker != null) {
            this.tracker.close();
            this.tracker = null;
        }
        super.stop(bundleContext);
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        Object object = this.bundleContext.getService(serviceReference);
        if (object instanceof HMIAudioService) {
            if (!HMIAudioService.CLIENT_POWER.equals(serviceReference.getProperty("AUDIO_CLIENT_ID"))) {
                this.bundleContext.ungetService(serviceReference);
                return null;
            }
            this.powerMgr.getPwrCmdFactory().setAudioDeviceServiceCmd((HMIAudioService)object);
        } else if (object instanceof DSIPowerManagement) {
            this.powerMgr.getPwrCmdFactory().setPowerDeviceServiceCmd((DSIPowerManagement)object);
        } else if (object instanceof DSIDisplayManagement) {
            this.powerMgr.getPwrCmdFactory().setDSIDisplayManagement((DSIDisplayManagement)object);
        } else if (object instanceof DSIDisplayController) {
            this.powerMgr.getPwrCmdFactory().setDSIDisplayController((DSIDisplayController)object);
        } else if (object instanceof DSIKeyPanel) {
            this.powerMgr.getPwrCmdFactory().setDSIKeyPanel((DSIKeyPanel)object);
        } else if (object instanceof PowerEventListener) {
            this.powerMgr.getPwrCmdFactory().setRegListenerCmd((PowerEventListener)object);
        } else if (object instanceof SwDiagnosisManager) {
            ((SwDiagnosisManager)object).addDiagGateway((AbstractSwDiagnosis)new PowerManagerDiag(this.fwService));
        } else {
            return null;
        }
        return object;
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        if (object instanceof PowerEventListener) {
            this.powerMgr.getPwrCmdFactory().setUnregListenerCmd((PowerEventListener)object);
        }
        this.bundleContext.ungetService(serviceReference);
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

