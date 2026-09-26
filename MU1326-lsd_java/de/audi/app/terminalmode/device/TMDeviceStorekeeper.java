/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.device;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.ITerminalModeComponent;
import de.audi.app.terminalmode.device.IDeviceListListener;
import de.audi.app.terminalmode.device.TMDeviceStorekeeper$DeviceListListener;
import de.audi.app.terminalmode.util.IStreamableStorageContainer;

public class TMDeviceStorekeeper
implements ITerminalModeComponent {
    private final IContext context;
    private final IDeviceListListener deviceListener;
    private IStreamableStorageContainer storage;
    private volatile boolean isFactoryResetRequested;
    static /* synthetic */ Class class$de$audi$app$terminalmode$util$IStreamableStorageContainer;

    public TMDeviceStorekeeper(IContext iContext) {
        this.context = iContext;
        this.deviceListener = new TMDeviceStorekeeper$DeviceListListener(this, null);
        this.isFactoryResetRequested = false;
    }

    @Override
    public void init() {
        this.isFactoryResetRequested = false;
        this.storage = (IStreamableStorageContainer)this.context.get(class$de$audi$app$terminalmode$util$IStreamableStorageContainer == null ? (class$de$audi$app$terminalmode$util$IStreamableStorageContainer = TMDeviceStorekeeper.class$("de.audi.app.terminalmode.util.IStreamableStorageContainer")) : class$de$audi$app$terminalmode$util$IStreamableStorageContainer);
        this.context.getDeviceManager().addDeviceListListener(this.deviceListener);
    }

    @Override
    public void deinit() {
        this.context.getDeviceManager().removeDeviceListListener(this.deviceListener);
    }

    public void setFactoryResetRequested(boolean bl) {
        this.isFactoryResetRequested = bl;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ boolean access$100(TMDeviceStorekeeper tMDeviceStorekeeper) {
        return tMDeviceStorekeeper.isFactoryResetRequested;
    }

    static /* synthetic */ IStreamableStorageContainer access$200(TMDeviceStorekeeper tMDeviceStorekeeper) {
        return tMDeviceStorekeeper.storage;
    }
}

