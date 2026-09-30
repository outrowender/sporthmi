/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.hmiswitcher.manager;

import de.audi.tghu.swdl.app.SwdlEnv;
import de.audi.tghu.swdl.app.dsi.SwdlDSIHandlerDeviceInfo;
import de.audi.tghu.swdl.app.dsi.SwdlDSIHandlerSelection;
import de.audi.tghu.swdl.app.hmiswitcher.manager.AbstractManager;
import de.audi.tghu.swdl.app.hmiswitcher.manager.AbstractPopupManager;
import de.audi.tghu.swdl.app.hmiswitcher.manager.IDeviceInfoManager;
import de.audi.tghu.swdl.app.hmiswitcher.manager.ISelectionManager;

public abstract class AbstractSelectionManager
extends AbstractManager
implements ISelectionManager {
    private static final String CLASSNAME = "[AbstractSelectionManager]";
    private final SwdlDSIHandlerSelection selectionDSIHandler;
    private final SwdlDSIHandlerDeviceInfo deviceInfoDSIHandler;
    private boolean userDownload = false;
    private IDeviceInfoManager deviceInfoManager;

    protected AbstractSelectionManager(SwdlEnv swdlEnv, AbstractPopupManager abstractPopupManager, IDeviceInfoManager iDeviceInfoManager, SwdlDSIHandlerSelection swdlDSIHandlerSelection, SwdlDSIHandlerDeviceInfo swdlDSIHandlerDeviceInfo) {
        super(swdlEnv, abstractPopupManager);
        this.selectionDSIHandler = swdlDSIHandlerSelection;
        this.deviceInfoDSIHandler = swdlDSIHandlerDeviceInfo;
        this.getLogHMI().log(10000000, "%1 <init>", (Object)CLASSNAME);
        this.getSwdlModels().getIpSpeller().setMaxLength(15);
        this.deviceInfoManager = iDeviceInfoManager;
    }

    private final SwdlDSIHandlerDeviceInfo getDeviceInfoDSIHandler() {
        return this.deviceInfoDSIHandler;
    }

    public final SwdlDSIHandlerSelection getSelectionDSIHandler() {
        return this.selectionDSIHandler;
    }

    protected IDeviceInfoManager getDeviceInfoManager() {
        return this.deviceInfoManager;
    }

    protected void setDeviceInfoManager(IDeviceInfoManager iDeviceInfoManager) {
        this.deviceInfoManager = iDeviceInfoManager;
    }

    public void updateRingNotOk(boolean bl) {
        this.getSwdlEnv().getLogMain().log(10000000, "%1 updateRingNotOk( %2 ) ", (Object)CLASSNAME, (Object)bl);
        if (bl) {
            this.getPopupManager().indicateDismissAllPopUps(4);
        }
    }

    public void updateUserSwdl(boolean bl) {
        this.getSwdlEnv().getLogMain().log(10000000, "%1 updateUserSwdl( %2 ) ", (Object)CLASSNAME, (Object)bl);
        this.userDownload = bl;
        if (!this.isUserSwdl()) {
            // empty if block
        }
    }

    protected boolean isUserSwdl() {
        return this.userDownload;
    }

    public void updateNfsIpAddress(String string) {
        this.getSwdlEnv().getLogHMI().log(1000000, "%1 IP Address of Download Server is: %2 ", (Object)CLASSNAME, (Object)string);
        this.getSwdlModels().getIpSpeller().setText(string);
        this.getSwdlModels().getSelectIpAddressLabel().setText(string);
    }

    public void updateNfsPath(String string) {
        this.getSwdlEnv().getLogHMI().log(1000000, "%1 Path of Download Server is: %2 ", (Object)CLASSNAME, (Object)string);
        this.getSwdlModels().getFsPathSpeller().setText(string);
        this.getSwdlModels().getSelectNetworkPathLabel().setText(string);
    }

    public void updateFsPath(String string) {
    }

    protected String getNfsIpAddress() {
        return this.getSwdlModels().getIpSpeller().getText();
    }

    public void doGetSourceMedia() {
        this.getLogHMI().log(1000000, "%1 -> doGetSourceMedia() ", (Object)CLASSNAME);
        this.getSelectionDSIHandler().doGetMedia();
    }

    public void leaveReadingReleases() {
        this.getLogHMI().log(1000000, "%1 -> leaveReadingReleases() ", (Object)CLASSNAME);
        this.getSelectionDSIHandler().doAbortSetMedium();
    }

    public void leaveReadingMetainfo() {
        this.getLogHMI().log(1000000, "%1 -> leaveReadingMetainfo() ", (Object)CLASSNAME);
        this.getSelectionDSIHandler().doAbortSetRelease();
    }

    public void updateUserDefinedAllowed(boolean bl) {
        this.getSwdlModels().getUserDefinedChoice().setValue(bl ? 1 : 0);
    }

    protected void doSetInstallationType(boolean bl) {
        this.getSelectionDSIHandler().doSetInstallationType(bl);
    }

    public boolean isUserDefinedMode() {
        return this.getSelectionDSIHandler().isUserDefinedMode();
    }

    public void doCheckConsistency() {
        this.getLogHMI().log(1000000, "%1 doCheckConsistency ", (Object)CLASSNAME);
        this.getSwdlModels().getIncompatibleUpdatesChoice().setValue(0);
        this.getSelectionDSIHandler().doCheckConsistency();
    }

    public void doCheckStartDownload() {
        this.getLogHMI().log(1000000, "%1 doCheckStartDownload ", (Object)CLASSNAME);
        if (this.getSwdlModels().getShowDowngradeWarningChoice().getValue() == 0) {
            this.checkDowngrade();
        }
        this.doCheckConsistency();
    }

    public void doGetAdditionalInfo(int n, int n2) {
        this.getDeviceInfoDSIHandler().doGetAdditionalInfo(n, n2);
    }

    public abstract void updateSourceMediaList(int[] var1);

    public abstract void doSelectSourceMedium(int var1);

    public abstract void updateReleaseList(String[] var1, String var2, int var3);

    public abstract void doSelectRelease(int var1);

    public abstract void updateReleaseResult(String var1, int var2);

    public void setDefaultMedium(int n) {
    }

    public void preSelectSourceMedium(int n) {
    }

    public void doStartVersionUpload() {
    }

    public void versionUploadDone(boolean bl) {
    }

    public void enterComponentUpdateConfirmation() {
    }

    public void checkDowngrade() {
        this.deviceInfoManager.checkModulesDowngrade();
    }
}

