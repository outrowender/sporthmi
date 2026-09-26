/*
 * Decompiled with CFR 0.152.
 */
package de.eso.widgets.preset;

import de.audi.atip.preset.IAppPresetDefinitionHandler;
import de.audi.atip.preset.IOnlinePresetHandler;
import de.audi.atip.preset.ITunerNARHandler;
import de.eso.widgets.preset.PresetDefinitionHandlerRegistry;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class PresetDefinitionHandlerRegistry$1
implements ServiceTrackerCustomizer {
    private final /* synthetic */ BundleContext val$context;
    private final /* synthetic */ PresetDefinitionHandlerRegistry this$0;

    PresetDefinitionHandlerRegistry$1(PresetDefinitionHandlerRegistry presetDefinitionHandlerRegistry, BundleContext bundleContext) {
        this.this$0 = presetDefinitionHandlerRegistry;
        this.val$context = bundleContext;
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        Object object = null;
        try {
            object = this.val$context.getService(serviceReference);
            if (object instanceof IAppPresetDefinitionHandler) {
                this.this$0.registerPresetDefinitionHandler((IAppPresetDefinitionHandler)object);
                if (object instanceof ITunerNARHandler) {
                    PresetDefinitionHandlerRegistry.access$002(this.this$0, (ITunerNARHandler)object);
                    PresetDefinitionHandlerRegistry.access$000(this.this$0).injectPresetManager(PresetDefinitionHandlerRegistry.access$100(this.this$0));
                }
                if (object instanceof IOnlinePresetHandler) {
                    PresetDefinitionHandlerRegistry.access$202(this.this$0, (IOnlinePresetHandler)object);
                }
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
            if (object instanceof IAppPresetDefinitionHandler) {
                this.this$0.unregisterPresetDefinitionHandler((IAppPresetDefinitionHandler)object);
                if (object instanceof ITunerNARHandler) {
                    PresetDefinitionHandlerRegistry.access$002(this.this$0, null);
                }
            }
        }
        catch (Exception exception) {
            IWidgetLogChannel.logPreset.log(10000, "PresetDefinitionHandlerRegistry#ServiceTracker#removedService %1", (Throwable)exception);
        }
    }
}

