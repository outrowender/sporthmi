/*
 * Decompiled with CFR 0.152.
 */
package de.eso.widgets.preset;

import de.audi.atip.preset.IAppPresetExecutionHandler;
import de.eso.widgets.preset.PresetExecutionHandlerRegistry;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class PresetExecutionHandlerRegistry$1
implements ServiceTrackerCustomizer {
    private final /* synthetic */ BundleContext val$context;
    private final /* synthetic */ PresetExecutionHandlerRegistry this$0;

    PresetExecutionHandlerRegistry$1(PresetExecutionHandlerRegistry presetExecutionHandlerRegistry, BundleContext bundleContext) {
        this.this$0 = presetExecutionHandlerRegistry;
        this.val$context = bundleContext;
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        Object object = null;
        try {
            object = this.val$context.getService(serviceReference);
            if (object instanceof IAppPresetExecutionHandler) {
                PresetExecutionHandlerRegistry.access$000(this.this$0, (IAppPresetExecutionHandler)object);
                return object;
            }
            this.val$context.ungetService(serviceReference);
            return null;
        }
        catch (Exception exception) {
            if (object != null) {
                this.val$context.ungetService(serviceReference);
            }
            return null;
        }
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        try {
            this.val$context.ungetService(serviceReference);
            if (object instanceof IAppPresetExecutionHandler) {
                this.this$0.unregisterExecutionHandler((IAppPresetExecutionHandler)object);
            }
        }
        catch (Exception exception) {
            IWidgetLogChannel.logPreset.log(10000, "PresetExecutionHandlerRegistry#ServiceTracker#removedService %1", (Throwable)exception);
        }
    }
}

