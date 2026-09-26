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
    private static final String CLASSNAME;
    private final SwdlDSIHandlerSelection selectionDSIHandler;
    private final SwdlDSIHandlerDeviceInfo deviceInfoDSIHandler;
    private boolean userDownload = false;
    private IDeviceInfoManager deviceInfoManager;

    protected AbstractSelectionManager(SwdlEnv swdlEnv, AbstractPopupManager abstractPopupManager, IDeviceInfoManager iDeviceInfoManager, SwdlDSIHandlerSelection swdlDSIHandlerSelection, SwdlDSIHandlerDeviceInfo swdlDSIHandlerDeviceInfo) {
        super(swdlEnv, abstractPopupManager);
        this.selectionDSIHandler = swdlDSIHandlerSelection;
        this.deviceInfoDSIHandler = swdlDSIHandlerDeviceInfo;
        this.getLogHMI().log(-2137614336, "%1 <init>", (Object)"[AbstractSelectionManager]");
        this.getSwdlModels().getIpSpeller().setMaxLength(15);
        this.deviceInfoManager = iDeviceInfoManager;
    }

    private final SwdlDSIHandlerDeviceInfo getDeviceInfoDSIHandler() {
        return this.deviceInfoDSIHandler;
    }

    @Override
    public final SwdlDSIHandlerSelection getSelectionDSIHandler() {
        return this.selectionDSIHandler;
    }

    protected IDeviceInfoManager getDeviceInfoManager() {
        return this.deviceInfoManager;
    }

    protected void setDeviceInfoManager(IDeviceInfoManager iDeviceInfoManager) {
        this.deviceInfoManager = iDeviceInfoManager;
    }

    @Override
    public void updateRingNotOk(boolean bl) {
        this.getSwdlEnv().getLogMain().log(-2137614336, "%1 updateRingNotOk( %2 ) ", (Object)"[AbstractSelectionManager]", (Object)bl);
        if (bl) {
            this.getPopupManager().indicateDismissAllPopUps(4);
        }
    }

    @Override
    public void updateUserSwdl(boolean bl) {
        this.getSwdlEnv().getLogMain().log(-2137614336, "%1 updateUserSwdl( %2 ) ", (Object)"[AbstractSelectionManager]", (Object)bl);
        this.userDownload = bl;
        if (!this.isUserSwdl()) {
            // empty if block
        }
    }

    protected boolean isUserSwdl() {
        return this.userDownload;
    }

    @Override
    public void updateNfsIpAddress(String string) {
        this.getSwdlEnv().getLogHMI().log(1078071040, "%1 IP Address of Download Server is: %2 ", (Object)"[AbstractSelectionManager]", (Object)string);
        this.getSwdlModels().getIpSpeller().setText(string);
        this.getSwdlModels().getSelectIpAddressLabel().setText(string);
    }

    @Override
    public void updateNfsPath(String string) {
        this.getSwdlEnv().getLogHMI().log(1078071040, "%1 Path of Download Server is: %2 ", (Object)"[AbstractSelectionManager]", (Object)string);
        this.getSwdlModels().getFsPathSpeller().setText(string);
        this.getSwdlModels().getSelectNetworkPathLabel().setText(string);
    }

    @Override
    public void updateFsPath(String string) {
    }

    protected String getNfsIpAddress() {
        return this.getSwdlModels().getIpSpeller().getText();
    }

    @Override
    public void doGetSourceMedia() {
        this.getLogHMI().log(1078071040, "%1 -> doGetSourceMedia() ", (Object)"[AbstractSelectionManager]");
        this.getSelectionDSIHandler().doGetMedia();
    }

    @Override
    public void leaveReadingReleases() {
        this.getLogHMI().log(1078071040, "%1 -> leaveReadingReleases() ", (Object)"[AbstractSelectionManager]");
        this.getSelectionDSIHandler().doAbortSetMedium();
    }

    @Override
    public void leaveReadingMetainfo() {
        this.getLogHMI().log(1078071040, "%1 -> leaveReadingMetainfo() ", (Object)"[AbstractSelectionManager]");
        this.getSelectionDSIHandler().doAbortSetRelease();
    }

    @Override
    public void updateUserDefinedAllowed(boolean bl) {
        this.getSwdlModels().getUserDefinedChoice().setValue(bl ? 1 : 0);
    }

    protected void doSetInstallationType(boolean bl) {
        this.getSelectionDSIHandler().doSetInstallationType(bl);
    }

    @Override
    public boolean isUserDefinedMode() {
        return this.getSelectionDSIHandler().isUserDefinedMode();
    }

    public void doCheckConsistency() {
        this.getLogHMI().log(1078071040, "%1 doCheckConsistency ", (Object)"[AbstractSelectionManager]");
        this.getSwdlModels().getIncompatibleUpdatesChoice().setValue(0);
        this.getSelectionDSIHandler().doCheckConsistency();
    }

    @Override
    public void doCheckStartDownload() {
        this.getLogHMI().log(1078071040, "%1 doCheckStartDownload ", (Object)"[AbstractSelectionManager]");
        if (this.getSwdlModels().getShowDowngradeWarningChoice().getValue() == 0) {
            this.checkDowngrade();
        }
        this.doCheckConsistency();
    }

    public void doGetAdditionalInfo(int n, int n2) {
        this.getDeviceInfoDSIHandler().doGetAdditionalInfo(n, n2);
    }

    @Override
    public abstract void updateSourceMediaList(int[] nArray) {
    }

    @Override
    public abstract void doSelectSourceMedium(int n) {
    }

    @Override
    public abstract void updateReleaseList(String[] stringArray, String string, int n) {
    }

    @Override
    public abstract void doSelectRelease(int n) {
    }

    @Override
    public abstract void updateReleaseResult(String string, int n) {
    }

    @Override
    public void setDefaultMedium(int n) {
    }

    @Override
    public void preSelectSourceMedium(int n) {
    }

    @Override
    public void doStartVersionUpload() {
    }

    @Override
    public void versionUploadDone(boolean bl) {
    }

    @Override
    public void enterComponentUpdateConfirmation() {
    }

    public void checkDowngrade() {
        this.deviceInfoManager.checkModulesDowngrade();
    }
}

