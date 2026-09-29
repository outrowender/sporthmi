/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.system.AppSystemDiag
 */
package de.audi.app.system;

import de.audi.app.system.AbstractAppSystemActivator;
import de.audi.app.system.AppSystemEvo;
import de.audi.app.system.FrameworkActionProxyImpl;
import de.audi.app.system.locking.AbstractLockingEvaluator;
import de.audi.app.system.locking.LockingEvaluator;
import de.audi.atip.diag.sw.AbstractSwDiagnosis;
import de.audi.atip.diag.sw.SwDiagnosisManager;
import de.mib.swdiagnosis.system.AppSystemDiag;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import org.dsi.ifc.carvehiclestates.DSICarVehicleStates;
import org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStates;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class AppSystemActivator
extends AbstractAppSystemActivator {
    protected ServiceTracker tracker;
    private AbstractLockingEvaluator lockingEvaluator = null;
    static /* synthetic */ Class class$de$audi$atip$hmi$HMIApplication;
    static /* synthetic */ Class class$de$audi$atip$statemachine$ActionProxy;
    static /* synthetic */ Class class$de$audi$app$system$locking$ILockingInformationProvider;
    static /* synthetic */ Class class$org$dsi$ifc$carvehiclestates$DSICarVehicleStates;
    static /* synthetic */ Class class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates;
    static /* synthetic */ Class class$de$audi$atip$diag$sw$SwDiagnosisManager;
    static /* synthetic */ Class class$de$audi$atip$power$PowerEventListener;

    @Override
    public void start(BundleContext bundleContext) {
        super.start(bundleContext);
        AppSystemEvo appSystemEvo = new AppSystemEvo(this.framework);
        FrameworkActionProxyImpl frameworkActionProxyImpl = new FrameworkActionProxyImpl(this.framework);
        this.getFramework().getSysApp().registerAppSystem(appSystemEvo);
        this.registerService((class$de$audi$atip$hmi$HMIApplication == null ? (class$de$audi$atip$hmi$HMIApplication = AppSystemActivator.class$("de.audi.atip.hmi.HMIApplication")) : class$de$audi$atip$hmi$HMIApplication).getName(), (Object)appSystemEvo, null);
        Hashtable hashtable = new Hashtable(6);
        hashtable.put("moduleID", new Integer(4));
        this.registerService((class$de$audi$atip$statemachine$ActionProxy == null ? (class$de$audi$atip$statemachine$ActionProxy = AppSystemActivator.class$("de.audi.atip.statemachine.ActionProxy")) : class$de$audi$atip$statemachine$ActionProxy).getName(), (Object)frameworkActionProxyImpl, (Dictionary)hashtable);
        this.lockingEvaluator = new LockingEvaluator(this.framework);
        this.registerService((class$de$audi$app$system$locking$ILockingInformationProvider == null ? (class$de$audi$app$system$locking$ILockingInformationProvider = AppSystemActivator.class$("de.audi.app.system.locking.ILockingInformationProvider")) : class$de$audi$app$system$locking$ILockingInformationProvider).getName(), (Object)this.lockingEvaluator, null);
        this.initTracker();
    }

    @Override
    public void stop(BundleContext bundleContext) {
        this.tracker = this.closeTracker(this.tracker);
        this.framework.getSysApp().registerAppSystem(null);
        super.stop(bundleContext);
    }

    protected void initTracker() {
        ArrayList arrayList = new ArrayList(2);
        arrayList.add((class$org$dsi$ifc$carvehiclestates$DSICarVehicleStates == null ? (class$org$dsi$ifc$carvehiclestates$DSICarVehicleStates = AppSystemActivator.class$("org.dsi.ifc.carvehiclestates.DSICarVehicleStates")) : class$org$dsi$ifc$carvehiclestates$DSICarVehicleStates).getName());
        arrayList.add((class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates == null ? (class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates = AppSystemActivator.class$("org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStates")) : class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates).getName());
        arrayList.add((class$de$audi$atip$diag$sw$SwDiagnosisManager == null ? (class$de$audi$atip$diag$sw$SwDiagnosisManager = AppSystemActivator.class$("de.audi.atip.diag.sw.SwDiagnosisManager")) : class$de$audi$atip$diag$sw$SwDiagnosisManager).getName());
        this.tracker = new ServiceTracker(this.bundleContext, (String[])arrayList.toArray(new String[0]), (ServiceTrackerCustomizer)this);
        this.tracker.open();
        this.bundleContext.registerService((class$de$audi$atip$power$PowerEventListener == null ? (class$de$audi$atip$power$PowerEventListener = AppSystemActivator.class$("de.audi.atip.power.PowerEventListener")) : class$de$audi$atip$power$PowerEventListener).getName(), (Object)this.lockingEvaluator, null);
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        String string = (String)serviceReference.getProperty("DEVICE_NAME");
        Object object = this.bundleContext.getService(serviceReference);
        if (string != null && string.equals((class$org$dsi$ifc$carvehiclestates$DSICarVehicleStates == null ? (class$org$dsi$ifc$carvehiclestates$DSICarVehicleStates = AppSystemActivator.class$("org.dsi.ifc.carvehiclestates.DSICarVehicleStates")) : class$org$dsi$ifc$carvehiclestates$DSICarVehicleStates).getName())) {
            this.lockingEvaluator.setDSI((DSICarVehicleStates)object);
        } else if (string != null && string.equals((class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates == null ? (class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates = AppSystemActivator.class$("org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStates")) : class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates).getName())) {
            this.lockingEvaluator.setDSI((DSIGeneralVehicleStates)object);
        } else if (object instanceof SwDiagnosisManager) {
            ((SwDiagnosisManager)object).addDiagGateway((AbstractSwDiagnosis)new AppSystemDiag(this.framework, this.lockingEvaluator));
        }
        return object;
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        if (object instanceof DSICarVehicleStates) {
            this.lockingEvaluator.releaseDSI();
            this.bundleContext.ungetService(serviceReference);
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

