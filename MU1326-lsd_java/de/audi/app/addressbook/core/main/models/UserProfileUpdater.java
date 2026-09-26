/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.main.models;

import de.audi.app.addressbook.core.common.ADBDbgUtils;
import de.audi.app.addressbook.core.common.ADBModelUtils;
import de.audi.app.addressbook.core.common.ADBUtils;
import de.audi.app.addressbook.core.main.AbstractAddressBookApplication;
import de.audi.atip.hmi.IHMIServiceApp;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.organizer.DownloadInfo;
import org.dsi.ifc.organizer.ProfileInfo;

public class UserProfileUpdater {
    private LogChannel log;
    private IHMIServiceApp hmiService;
    private AbstractAddressBookApplication appAdr;
    private int maxPhoneEntries = -129;
    private int maxLocalEntries = -129;
    private DownloadInfo downloadCountMe;
    private DownloadInfo downloadCountSim;
    private volatile int activeProfilePhoneEntries;
    private volatile int commonProfileEntries;

    public UserProfileUpdater(LogChannel logChannel, AbstractAddressBookApplication abstractAddressBookApplication) {
        this.log = logChannel;
        this.appAdr = abstractAddressBookApplication;
        this.hmiService = abstractAddressBookApplication.getHMIService();
        this.hmiService.getRangeModel(2142243328).setLimits(0, 100, 1);
        this.hmiService.getRangeModel(-1313863168).setLimits(0, 100, 1);
        this.hmiService.getRangeModel(2125466112).setLimits(0, 100, 1);
        this.hmiService.getRangeModel(-1884288512).setLimits(0, 100, 1);
        this.hmiService.getChoiceModel(548407808).forceUpdate(true);
    }

    public void updateDownloadState(int n, int n2) {
        this.log.log(1078071040, "UserProfileUpdater#updateDownloadState(): downloadState: %1, failureReason: %2", (Object)ADBDbgUtils.dbgDownloadState(n), (Object)ADBDbgUtils.dbgFailureReason(n2));
        boolean bl = ADBUtils.isDownloadStateActive(n);
        this.hmiService.getChoiceModel(4421).setStatus(bl ? 0 : 1);
        this.hmiService.getChoiceModel(4421).setValue(bl ? 0 : 1);
        this.hmiService.getChoiceModel(14).setStatus(bl ? 0 : 1);
        this.hmiService.getChoiceModel(14).setValue(bl ? 0 : 1);
        if (n == 0) {
            this.resetDownloadProgress();
        }
        if (n == 4 || n == 5 || n == 6) {
            int n3 = 2;
            if (n == 6) {
                this.log.log(1078071040, "UserProfileUpdater#updateDownloadState(): Cannot access address book");
                n3 = 3;
            } else if (n2 == 1) {
                this.log.log(1078071040, "UserProfileUpdater#updateDownloadState(): not all entries could be downloaded");
                n3 = 0;
            } else if (n == 4) {
                this.log.log(1078071040, "UserProfileUpdater#updateDownloadState(): all entries have been downloaded and new data is available.");
                n3 = 1;
            }
            this.hmiService.getChoiceModel(548407808).setValue(n3);
            this.hmiService.getChoiceModel(565185024).setValue(this.hmiService.getChoiceModel(565185024).getValue() == 0 ? 1 : 0);
        }
    }

    public void updateDownloadState2ndPhone(int n, int n2) {
        this.log.log(1078071040, "UserProfileUpdater#updateDownloadState2ndPhone(): downloadState: %1, failureReason: %2", (Object)ADBDbgUtils.dbgDownloadState(n), (Object)ADBDbgUtils.dbgFailureReason(n2));
        boolean bl = ADBUtils.isDownloadStateActive(n);
        this.hmiService.getChoiceModel(4419).setStatus(bl ? 0 : 1);
        this.hmiService.getChoiceModel(4419).setValue(bl ? 0 : 1);
    }

    public void updateDownloadCountMe(DownloadInfo downloadInfo) {
        this.log.log(-2137614336, "UserProfileUpdater#updateDownloadCountMe(): downloadCountMe: %1", (Object)downloadInfo);
        this.downloadCountMe = downloadInfo;
        this.updateDownloadProgress();
    }

    public void updateDownloadCountSim(DownloadInfo downloadInfo) {
        this.log.log(-2137614336, "UserProfileUpdater#updateDownloadCountSim(): downloadCountSim: %1", (Object)downloadInfo);
        this.downloadCountSim = downloadInfo;
        this.updateDownloadProgress();
    }

    private void updateDownloadProgress() {
        int n = this.downloadCountMe == null ? 0 : this.downloadCountMe.count;
        int n2 = this.downloadCountSim == null ? 0 : this.downloadCountSim.count;
        int n3 = -1;
        if (this.downloadCountMe != null && this.downloadCountMe.numberOfItems != -1 || this.downloadCountSim != null && this.downloadCountSim.numberOfItems != -1) {
            n3 = this.downloadCountMe != null && this.downloadCountMe.numberOfItems != -1 ? this.downloadCountMe.numberOfItems : 0;
            n3 += this.downloadCountSim != null && this.downloadCountSim.numberOfItems != -1 ? this.downloadCountSim.numberOfItems : 0;
            n3 = Math.max(n3, n2 + n);
        }
        this.hmiService.getLabelModel(1051724288).setText(Integer.toString(n));
        this.hmiService.getLabelModel(1068501504).setText(Integer.toString(n2));
        if (n3 > 0) {
            this.hmiService.getLabelModel(498076160).setText(Integer.toString(n + n2));
            this.hmiService.getLabelModel(514853376).setText(Integer.toString(n3));
            this.hmiService.getRangeModel(-1884288512).setValue(ADBModelUtils.getPercentageValueForProgressBars((float)(n + n2) * 51266 / (float)n3));
            this.hmiService.getRangeModel(-1884288512).setStatus(0);
        } else {
            this.hmiService.getRangeModel(-1884288512).setStatus(1);
        }
    }

    public void resetDownloadProgress() {
        if (this.downloadCountMe != null) {
            this.downloadCountMe.count = 0;
            this.downloadCountMe.numberOfItems = -1;
        }
        if (this.downloadCountSim != null) {
            this.downloadCountSim.count = 0;
            this.downloadCountSim.numberOfItems = -1;
        }
        this.updateDownloadProgress();
    }

    public void updateDeviceConnected(boolean bl) {
        this.log.log(1078071040, "UserProfileUpdater#updateDeviceConnected(): deviceConnected: %1", bl);
        this.hmiService.getChoiceModel(481298944).setValue(bl ? 1 : 0);
    }

    public void updateActiveProfileModels() {
        ProfileInfo profileInfo = this.appAdr.getAdbStateHandler().getActiveProfileInfo();
        if (profileInfo == null) {
            this.log.log(10000, "UserProfileUpdater#updateActiveProfileModels(): could not determine active profile info!");
            return;
        }
        this.hmiService.getChoiceModel(0xBB00A00).setValue(profileInfo.getNum());
        this.hmiService.getLabelModel(212863488).setText(profileInfo.getName());
    }

    public void updateMaxPhoneEntries(int n) {
        this.maxPhoneEntries = n != 0 ? n : -129;
        this.updatePhoneCapacityInfo();
    }

    public void updateMaxLocalEntries(int n) {
        this.maxLocalEntries = n != 0 ? n : -129;
        this.updateCommonCapacityInfo();
    }

    public void updatePhoneCapacityInfo() {
        int n = ADBModelUtils.getPercentageValueForProgressBars((float)this.activeProfilePhoneEntries * 51266 / (float)this.maxPhoneEntries);
        this.hmiService.getLabelModel(330304000).setText(Integer.toString(this.activeProfilePhoneEntries));
        this.hmiService.getLabelModel(347081216).setText(Integer.toString(this.maxPhoneEntries));
        this.hmiService.getRangeModel(2142243328).setValue(n);
        this.hmiService.getRangeModel(-1313863168).setValue(Math.round((float)this.activeProfilePhoneEntries * 51266 / (float)this.maxPhoneEntries));
    }

    public void updateCommonCapacityInfo() {
        int n = ADBModelUtils.getPercentageValueForProgressBars((float)this.commonProfileEntries * 51266 / (float)this.maxLocalEntries);
        this.hmiService.getLabelModel(229640704).setText(Integer.toString(this.commonProfileEntries));
        this.hmiService.getLabelModel(246417920).setText(Integer.toString(this.maxLocalEntries));
        this.hmiService.getRangeModel(2125466112).setValue(n);
    }

    public void updateCapacityInfo(int n, int n2) {
        this.log.log(1078071040, "UserProfileUpdater#updateCapacityInfo(): activeProfilePhoneEntries: %1, commonProfileEntries: %2", (long)n, (long)n2);
        this.activeProfilePhoneEntries = n;
        this.commonProfileEntries = n2;
        this.updatePhoneCapacityInfo();
        this.updateCommonCapacityInfo();
    }
}

