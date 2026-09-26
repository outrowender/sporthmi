/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.tuner;

import de.audi.app.tuner.AppTunerEvo;
import de.audi.app.tuner.TunerVariantExt;
import de.audi.app.tuner.evo.proxy.TunerActionProxyEvo;
import de.audi.app.tuner.truffles.RadioSearchDataProvider;
import de.audi.tuner.app.TunerActivatorBase;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.ap.TunerActionProxyListener;
import java.util.Hashtable;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.search.DSISearchDataProvider;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class TunerActivator
extends TunerActivatorBase {
    private TunerActionProxyEvo actionProxy;
    private AppTunerEvo appTunerEvo;
    private ServiceTracker tracker;
    private boolean trackerInitialized;
    static /* synthetic */ Class class$org$dsi$ifc$search$DSISearchDataProvider;
    static /* synthetic */ Class class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceTuner;
    static /* synthetic */ Class class$de$audi$atip$statemachine$ActionProxy;
    static /* synthetic */ Class class$org$dsi$ifc$search$DSISearchDataProviderListener;

    @Override
    public void start(BundleContext bundleContext) {
        super.start(bundleContext, new TunerVariantExt());
        this.appTunerEvo = new AppTunerEvo(this.appTuner, this.framework, bundleContext);
        this.doStartAll();
    }

    @Override
    protected void doStartAll() {
        super.doStartAll();
        TunerActionProxyListener[] tunerActionProxyListenerArray = this.appTuner.getCoreActionProxyListeners();
        TunerActionProxyListener[] tunerActionProxyListenerArray2 = this.appTunerEvo.getActionProxyListeners();
        TunerActionProxyListener[] tunerActionProxyListenerArray3 = new TunerActionProxyListener[tunerActionProxyListenerArray.length + tunerActionProxyListenerArray2.length];
        System.arraycopy((Object)tunerActionProxyListenerArray, 0, (Object)tunerActionProxyListenerArray3, 0, tunerActionProxyListenerArray.length);
        System.arraycopy((Object)tunerActionProxyListenerArray2, 0, (Object)tunerActionProxyListenerArray3, tunerActionProxyListenerArray.length, tunerActionProxyListenerArray2.length);
        this.actionProxy = new TunerActionProxyEvo(this.appTuner.getBasics().getLogger().sm, tunerActionProxyListenerArray3);
        this.initTracker();
        if (Utilities.isEvoHigh()) {
            this.registerSearchDataProviderDSI();
        }
        this.registerActionProxy();
    }

    @Override
    public void stop(BundleContext bundleContext) {
        this.tracker.close();
        super.stop(bundleContext);
    }

    private void initTracker() {
        String[] stringArray;
        if (this.trackerInitialized) {
            return;
        }
        if (Utilities.isEvoHigh()) {
            String[] stringArray2 = new String[2];
            stringArray2[0] = (class$org$dsi$ifc$search$DSISearchDataProvider == null ? (class$org$dsi$ifc$search$DSISearchDataProvider = TunerActivator.class$("org.dsi.ifc.search.DSISearchDataProvider")) : class$org$dsi$ifc$search$DSISearchDataProvider).getName();
            stringArray = stringArray2;
            stringArray2[1] = (class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceTuner == null ? (class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceTuner = TunerActivator.class$("de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceTuner")) : class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceTuner).getName();
        } else {
            String[] stringArray3 = new String[1];
            stringArray = stringArray3;
            stringArray3[0] = (class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceTuner == null ? (class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceTuner = TunerActivator.class$("de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceTuner")) : class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceTuner).getName();
        }
        String[] stringArray4 = stringArray;
        this.tracker = new ServiceTracker(this.bundleContext, stringArray4, (ServiceTrackerCustomizer)this);
        this.tracker.open();
        this.trackerInitialized = true;
    }

    private void registerActionProxy() {
        Hashtable hashtable = new Hashtable();
        hashtable.put("moduleID", new Integer(20));
        this.registerFrameworkService(class$de$audi$atip$statemachine$ActionProxy == null ? (class$de$audi$atip$statemachine$ActionProxy = TunerActivator.class$("de.audi.atip.statemachine.ActionProxy")) : class$de$audi$atip$statemachine$ActionProxy, this.actionProxy, hashtable);
    }

    private void registerSearchDataProviderDSI() {
        this.registerDSIListener(class$org$dsi$ifc$search$DSISearchDataProviderListener == null ? (class$org$dsi$ifc$search$DSISearchDataProviderListener = TunerActivator.class$("org.dsi.ifc.search.DSISearchDataProviderListener")) : class$org$dsi$ifc$search$DSISearchDataProviderListener, this.appTunerEvo.searchDataProvider, 1);
        if (!((RadioSearchDataProvider)this.appTunerEvo.searchDataProvider).isDsiFound()) {
            this.framework.startDSIService((class$org$dsi$ifc$search$DSISearchDataProvider == null ? (class$org$dsi$ifc$search$DSISearchDataProvider = TunerActivator.class$("org.dsi.ifc.search.DSISearchDataProvider")) : class$org$dsi$ifc$search$DSISearchDataProvider).getName(), 1);
            this.framework.getStartupMgr().logStartupEvent("[RADIO] startDSIService(DSISearchDataProvider)");
        }
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        Object object = super.addingService(serviceReference);
        if (object != null) {
            return object;
        }
        Object object2 = serviceReference.getProperty("DEVICE_INSTANCE");
        Object object3 = this.bundleContext.getService(serviceReference);
        if (Utilities.isEvoHigh() && object3 instanceof DSISearchDataProvider && object2 != null && (Integer)object2 == 1) {
            this.appTunerEvo.setDeviceService((DSIBase)object3);
            return object3;
        }
        this.bundleContext.ungetService(serviceReference);
        return null;
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

