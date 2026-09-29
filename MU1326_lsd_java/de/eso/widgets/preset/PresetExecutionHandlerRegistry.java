/*
 * Decompiled with CFR 0.152.
 */
package de.eso.widgets.preset;

import de.audi.atip.preset.IAppPresetExecutionHandler;
import de.eso.widgets.preset.PresetExecutionHandlerRegistry$1;
import de.esolutions.fw.util.commons.SimpleIntObjectMap;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public final class PresetExecutionHandlerRegistry {
    private final SimpleIntObjectMap registry = new SimpleIntObjectMap(7);
    private ServiceTracker presetExecutionHandlerTracker;
    static /* synthetic */ Class class$de$audi$atip$preset$IAppPresetExecutionHandler;

    public void startTracker(BundleContext bundleContext) {
        this.presetExecutionHandlerTracker = new ServiceTracker(bundleContext, (class$de$audi$atip$preset$IAppPresetExecutionHandler == null ? (class$de$audi$atip$preset$IAppPresetExecutionHandler = PresetExecutionHandlerRegistry.class$("de.audi.atip.preset.IAppPresetExecutionHandler")) : class$de$audi$atip$preset$IAppPresetExecutionHandler).getName(), (ServiceTrackerCustomizer)new PresetExecutionHandlerRegistry$1(this, bundleContext));
        this.presetExecutionHandlerTracker.open();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void unregisterExecutionHandler(IAppPresetExecutionHandler iAppPresetExecutionHandler) {
        if (iAppPresetExecutionHandler != null) {
            SimpleIntObjectMap simpleIntObjectMap = this.registry;
            synchronized (simpleIntObjectMap) {
                this.registry.remove(iAppPresetExecutionHandler.getExecutionType());
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void registerExecutionHandler(IAppPresetExecutionHandler iAppPresetExecutionHandler) {
        if (iAppPresetExecutionHandler != null) {
            SimpleIntObjectMap simpleIntObjectMap = this.registry;
            synchronized (simpleIntObjectMap) {
                this.registry.add(iAppPresetExecutionHandler.getExecutionType(), iAppPresetExecutionHandler);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    IAppPresetExecutionHandler getPresetExecutionHandler(int n) {
        SimpleIntObjectMap simpleIntObjectMap = this.registry;
        synchronized (simpleIntObjectMap) {
            return (IAppPresetExecutionHandler)this.registry.get(n);
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

    static /* synthetic */ void access$000(PresetExecutionHandlerRegistry presetExecutionHandlerRegistry, IAppPresetExecutionHandler iAppPresetExecutionHandler) {
        presetExecutionHandlerRegistry.registerExecutionHandler(iAppPresetExecutionHandler);
    }
}

