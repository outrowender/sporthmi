/*
 * Decompiled with CFR 0.152.
 */
package de.eso.widgets.preset;

import de.audi.atip.preset.IAppPresetDefinitionHandler;
import de.audi.atip.preset.IOnlinePresetHandler;
import de.audi.atip.preset.ITunerNARHandler;
import de.audi.atip.preset.Preset;
import de.eso.widgets.preset.PresetDefinitionHandlerRegistry$1;
import de.eso.widgets.preset.PresetManager;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.SimpleIntObjectMap;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public final class PresetDefinitionHandlerRegistry {
    private final SimpleIntObjectMap[] registry;
    private final boolean[] usesModelId;
    private ServiceTracker presetHandlerTracker;
    private final PresetManager presetManager;
    private ITunerNARHandler tunerNARHandler;
    private IOnlinePresetHandler onlineHandler;
    static /* synthetic */ Class class$de$audi$atip$preset$IAppPresetDefinitionHandler;

    public PresetDefinitionHandlerRegistry(PresetManager presetManager) {
        this.presetManager = presetManager;
        this.registry = new SimpleIntObjectMap[4];
        this.usesModelId = new boolean[4];
        for (int i2 = 0; i2 < 4; ++i2) {
            this.registry[i2] = new SimpleIntObjectMap();
            this.usesModelId[i2] = false;
        }
    }

    private void addToMap(SimpleIntObjectMap simpleIntObjectMap, int n, IAppPresetDefinitionHandler iAppPresetDefinitionHandler) {
        simpleIntObjectMap.add(n, iAppPresetDefinitionHandler);
    }

    private void removeFromMap(SimpleIntObjectMap simpleIntObjectMap, int n, IAppPresetDefinitionHandler iAppPresetDefinitionHandler) {
        if (simpleIntObjectMap.get(n) == iAppPresetDefinitionHandler) {
            simpleIntObjectMap.remove(n);
        }
    }

    void registerPresetDefinitionHandler(IAppPresetDefinitionHandler iAppPresetDefinitionHandler) {
        if (iAppPresetDefinitionHandler != null) {
            int n = iAppPresetDefinitionHandler.getType();
            int[] nArray = iAppPresetDefinitionHandler.getModelIds();
            if (n < 0 || n >= 4) {
                throw new IllegalArgumentException(new StringBuffer().append("type must be >= 0 and < 4, but type = ").append(n).toString());
            }
            this.usesModelId[n] = nArray != null;
            SimpleIntObjectMap simpleIntObjectMap = this.registry[n];
            if (nArray != null) {
                for (int i2 = 0; i2 < nArray.length; ++i2) {
                    this.addToMap(simpleIntObjectMap, nArray[i2], iAppPresetDefinitionHandler);
                }
            } else {
                this.addToMap(simpleIntObjectMap, 0, iAppPresetDefinitionHandler);
            }
        }
    }

    void unregisterPresetDefinitionHandler(IAppPresetDefinitionHandler iAppPresetDefinitionHandler) {
        if (iAppPresetDefinitionHandler != null) {
            int n = iAppPresetDefinitionHandler.getType();
            int[] nArray = iAppPresetDefinitionHandler.getModelIds();
            if (n < 0 || n >= 4) {
                throw new IllegalArgumentException(new StringBuffer().append("type must be >= 0 and < 4, but type = ").append(n).toString());
            }
            SimpleIntObjectMap simpleIntObjectMap = this.registry[n];
            if (nArray != null) {
                for (int i2 = 0; i2 < nArray.length; ++i2) {
                    this.removeFromMap(simpleIntObjectMap, nArray[i2], iAppPresetDefinitionHandler);
                }
            } else {
                this.removeFromMap(simpleIntObjectMap, 0, iAppPresetDefinitionHandler);
            }
        }
    }

    public IAppPresetDefinitionHandler getPresetDefinitionHandler(int n, int n2) {
        IAppPresetDefinitionHandler iAppPresetDefinitionHandler = null;
        if (n >= 0 && n < 4) {
            iAppPresetDefinitionHandler = (IAppPresetDefinitionHandler)this.registry[n].get(this.usesModelId[n] ? n2 : 0);
        }
        return iAppPresetDefinitionHandler;
    }

    public String getRegisteredTypeInfo() {
        Buffer buffer = new Buffer();
        String string = "";
        for (int i2 = 0; i2 < 4; ++i2) {
            if (this.registry[i2].isEmpty()) continue;
            buffer.append(string);
            buffer.append(Preset.TYPE_NAMES[i2]);
            buffer.append(this.usesModelId[i2] ? " []" : " *");
            string = "\n";
        }
        return buffer.toString();
    }

    public String getTypeInfo(int n) {
        Buffer buffer = new Buffer();
        String string = "\n\t";
        buffer.append(string);
        buffer.append(Preset.TYPE_NAMES[n]);
        buffer.append(this.usesModelId[n] ? " []" : " *");
        int[] nArray = this.registry[n].getKeys();
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            buffer.append(string).append(i2).append(": ").append(this.getPresetDefinitionHandler(n, i2));
        }
        return buffer.toString();
    }

    public void startTracker(BundleContext bundleContext) {
        this.presetHandlerTracker = new ServiceTracker(bundleContext, (class$de$audi$atip$preset$IAppPresetDefinitionHandler == null ? (class$de$audi$atip$preset$IAppPresetDefinitionHandler = PresetDefinitionHandlerRegistry.class$("de.audi.atip.preset.IAppPresetDefinitionHandler")) : class$de$audi$atip$preset$IAppPresetDefinitionHandler).getName(), (ServiceTrackerCustomizer)new PresetDefinitionHandlerRegistry$1(this, bundleContext));
        this.presetHandlerTracker.open();
    }

    public ITunerNARHandler getTunerNARHandler() {
        return this.tunerNARHandler;
    }

    public IOnlinePresetHandler getOnlinePresetHandler() {
        return this.onlineHandler;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ ITunerNARHandler access$002(PresetDefinitionHandlerRegistry presetDefinitionHandlerRegistry, ITunerNARHandler iTunerNARHandler) {
        presetDefinitionHandlerRegistry.tunerNARHandler = iTunerNARHandler;
        return presetDefinitionHandlerRegistry.tunerNARHandler;
    }

    static /* synthetic */ PresetManager access$100(PresetDefinitionHandlerRegistry presetDefinitionHandlerRegistry) {
        return presetDefinitionHandlerRegistry.presetManager;
    }

    static /* synthetic */ ITunerNARHandler access$000(PresetDefinitionHandlerRegistry presetDefinitionHandlerRegistry) {
        return presetDefinitionHandlerRegistry.tunerNARHandler;
    }

    static /* synthetic */ IOnlinePresetHandler access$202(PresetDefinitionHandlerRegistry presetDefinitionHandlerRegistry, IOnlinePresetHandler iOnlinePresetHandler) {
        presetDefinitionHandlerRegistry.onlineHandler = iOnlinePresetHandler;
        return presetDefinitionHandlerRegistry.onlineHandler;
    }
}

