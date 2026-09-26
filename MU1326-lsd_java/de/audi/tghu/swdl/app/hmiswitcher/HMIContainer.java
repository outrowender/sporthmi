/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.hmiswitcher;

import de.audi.tghu.swdl.app.hmiswitcher.manager.IDeviceInfoManager;
import de.audi.tghu.swdl.app.hmiswitcher.manager.ILoggingManager;
import de.audi.tghu.swdl.app.hmiswitcher.manager.IProgressManager;
import de.audi.tghu.swdl.app.hmiswitcher.manager.ISelectionManager;

public class HMIContainer {
    private final int typeId;
    private final ISelectionManager selectionManager;
    private final IDeviceInfoManager deviceInfoManager;
    private final IProgressManager progressManager;
    private final ILoggingManager loggingManager;

    public HMIContainer(int n, ISelectionManager iSelectionManager, IDeviceInfoManager iDeviceInfoManager, IProgressManager iProgressManager, ILoggingManager iLoggingManager) {
        this.typeId = n;
        this.selectionManager = iSelectionManager;
        this.deviceInfoManager = iDeviceInfoManager;
        this.progressManager = iProgressManager;
        this.loggingManager = iLoggingManager;
    }

    public final ISelectionManager getSelectionManager() {
        return this.selectionManager;
    }

    public final IDeviceInfoManager getDeviceInfoManager() {
        return this.deviceInfoManager;
    }

    public final IProgressManager getProgressManager() {
        return this.progressManager;
    }

    public final ILoggingManager getLoggingManager() {
        return this.loggingManager;
    }

    public final int getTypeId() {
        return this.typeId;
    }
}

