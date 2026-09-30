/*
 * Decompiled with CFR 0.152.
 */
package de.eso.widgets.preset;

import de.audi.atip.preset.IAppPresetExecutionHandler;
import de.esolutions.fw.util.commons.SimpleIntObjectMap;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public final class PresetExecutionHandlerRegistry {
    private final SimpleIntObjectMap registry = new SimpleIntObjectMap(7);
    private ServiceTracker presetExecutionHandlerTracker;
    static /* synthetic */ Class class$de$audi$atip$preset$IAppPresetExecutionHandler;

    public void startTracker(final BundleContext bundleContext) {
        this.presetExecutionHandlerTracker = new ServiceTracker(bundleContext, (class$de$audi$atip$preset$IAppPresetExecutionHandler == null ? (class$de$audi$atip$preset$IAppPresetExecutionHandler = PresetExecutionHandlerRegistry.class$("de.audi.atip.preset.IAppPresetExecutionHandler")) : class$de$audi$atip$preset$IAppPresetExecutionHandler).getName(), new ServiceTrackerCustomizer(){

            public Object addingService(ServiceReference serviceReference) {
                Object object = null;
                try {
                    object = bundleContext.getService(serviceReference);
                    if (object instanceof IAppPresetExecutionHandler) {
                        PresetExecutionHandlerRegistry.this.registerExecutionHandler((IAppPresetExecutionHandler)object);
                        return object;
                    }
                    bundleContext.ungetService(serviceReference);
                    return null;
                }
                catch (Exception exception) {
                    if (object != null) {
                        bundleContext.ungetService(serviceReference);
                    }
                    return null;
                }
            }

            public void modifiedService(ServiceReference serviceReference, Object object) {
            }

            public void removedService(ServiceReference serviceReference, Object object) {
                try {
                    bundleContext.ungetService(serviceReference);
                    if (object instanceof IAppPresetExecutionHandler) {
                        PresetExecutionHandlerRegistry.this.unregisterExecutionHandler((IAppPresetExecutionHandler)object);
                    }
                }
                catch (Exception exception) {
                    IWidgetLogChannel.logPreset.log(10000, "PresetExecutionHandlerRegistry#ServiceTracker#removedService %1", (Throwable)exception);
                }
            }
        });
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
}

