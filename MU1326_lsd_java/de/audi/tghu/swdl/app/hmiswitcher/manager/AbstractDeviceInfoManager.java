/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.hmiswitcher.manager;

import de.audi.tghu.swdl.app.SwdlEnv;
import de.audi.tghu.swdl.app.dsi.SwdlDSIHandlerDeviceInfo;
import de.audi.tghu.swdl.app.hmiswitcher.manager.AbstractManager;
import de.audi.tghu.swdl.app.hmiswitcher.manager.AbstractPopupManager;
import de.audi.tghu.swdl.app.hmiswitcher.manager.IDeviceInfoManager;

public abstract class AbstractDeviceInfoManager
extends AbstractManager
implements IDeviceInfoManager {
    private int accessType = 1;
    private final SwdlDSIHandlerDeviceInfo deviceInfoDSIHandler;

    protected AbstractDeviceInfoManager(SwdlEnv swdlEnv, AbstractPopupManager abstractPopupManager, SwdlDSIHandlerDeviceInfo swdlDSIHandlerDeviceInfo) {
        super(swdlEnv, abstractPopupManager);
        this.deviceInfoDSIHandler = swdlDSIHandlerDeviceInfo;
        this.setAccessType(1);
    }

    protected SwdlDSIHandlerDeviceInfo getDeviceInfoDSIHandler() {
        return this.deviceInfoDSIHandler;
    }

    protected int getAccessType() {
        return this.accessType;
    }

    private void setAccessType(int n) {
        this.accessType = n;
    }

    public boolean checkAccessType(int n) {
        return this.getAccessType() == n;
    }

    public boolean isStateView() {
        return 1 == this.getSwdlModels().getDeviceStatusEnteredChoice().getStatus();
    }

    public boolean isStandardSelection() {
        return false;
    }

    public void doGetDevices(int n, String string, boolean bl) {
        this.setAccessType(n);
        this.getDeviceInfoDSIHandler().doSetAccessType(n);
    }

    public void doGetModules(int n) {
    }

    public void updateInfoFilePath(String string, String string2) {
    }

    public void doSelectDevice(int n) {
    }

    public void doSelectModule(int n) {
    }

    public void doGetFileInfos() {
    }

    public void doGetFileInfoPath(int n) {
    }
}

