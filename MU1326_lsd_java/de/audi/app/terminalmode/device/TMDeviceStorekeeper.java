/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.device;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.ITerminalModeComponent;
import de.audi.app.terminalmode.device.IDeviceListListener;
import de.audi.app.terminalmode.device.TMDevice;
import de.audi.app.terminalmode.util.IStreamableStorageContainer;
import de.audi.atip.utils.generics.GList;
import java.util.List;

public class TMDeviceStorekeeper
implements ITerminalModeComponent {
    private final IContext context;
    private final IDeviceListListener deviceListener;
    private IStreamableStorageContainer storage;
    private volatile boolean isFactoryResetRequested;
    static /* synthetic */ Class class$de$audi$app$terminalmode$util$IStreamableStorageContainer;

    public TMDeviceStorekeeper(IContext iContext) {
        this.context = iContext;
        this.deviceListener = new DeviceListListener();
        this.isFactoryResetRequested = false;
    }

    public void init() {
        this.isFactoryResetRequested = false;
        this.storage = (IStreamableStorageContainer)this.context.get(class$de$audi$app$terminalmode$util$IStreamableStorageContainer == null ? (class$de$audi$app$terminalmode$util$IStreamableStorageContainer = TMDeviceStorekeeper.class$("de.audi.app.terminalmode.util.IStreamableStorageContainer")) : class$de$audi$app$terminalmode$util$IStreamableStorageContainer);
        this.context.getDeviceManager().addDeviceListListener(this.deviceListener);
    }

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

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    private final class DeviceListListener
    implements IDeviceListListener {
        private DeviceListListener() {
        }

        @Override
        public void updateDeviceList(GList<TMDevice> gList) {
            if (!TMDeviceStorekeeper.this.isFactoryResetRequested) {
                TMDeviceStorekeeper.this.storage.writeListToStorage((List)gList.getBackingCollection());
            }
        }
    }
}

