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
    private int maxPhoneEntries = Integer.MAX_VALUE;
    private int maxLocalEntries = Integer.MAX_VALUE;
    private DownloadInfo downloadCountMe;
    private DownloadInfo downloadCountSim;
    private volatile int activeProfilePhoneEntries;
    private volatile int commonProfileEntries;

    public UserProfileUpdater(LogChannel logChannel, AbstractAddressBookApplication abstractAddressBookApplication) {
        this.log = logChannel;
        this.appAdr = abstractAddressBookApplication;
        this.hmiService = abstractAddressBookApplication.getHMIService();
        this.hmiService.getRangeModel(700543).setLimits(0, 100, 1);
        this.hmiService.getRangeModel(700593).setLimits(0, 100, 1);
        this.hmiService.getRangeModel(700542).setLimits(0, 100, 1);
        this.hmiService.getRangeModel(700559).setLimits(0, 100, 1);
        this.hmiService.getChoiceModel(700448).forceUpdate(true);
    }

    public void updateDownloadState(int n, int n2) {
        this.log.log(1000000, "UserProfileUpdater#updateDownloadState(): downloadState: %1, failureReason: %2", (Object)ADBDbgUtils.dbgDownloadState(n), (Object)ADBDbgUtils.dbgFailureReason(n2));
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
                this.log.log(1000000, "UserProfileUpdater#updateDownloadState(): Cannot access address book");
                n3 = 3;
            } else if (n2 == 1) {
                this.log.log(1000000, "UserProfileUpdater#updateDownloadState(): not all entries could be downloaded");
                n3 = 0;
            } else if (n == 4) {
                this.log.log(1000000, "UserProfileUpdater#updateDownloadState(): all entries have been downloaded and new data is available.");
                n3 = 1;
            }
            this.hmiService.getChoiceModel(700448).setValue(n3);
            this.hmiService.getChoiceModel(700449).setValue(this.hmiService.getChoiceModel(700449).getValue() == 0 ? 1 : 0);
        }
    }

    public void updateDownloadState2ndPhone(int n, int n2) {
        this.log.log(1000000, "UserProfileUpdater#updateDownloadState2ndPhone(): downloadState: %1, failureReason: %2", (Object)ADBDbgUtils.dbgDownloadState(n), (Object)ADBDbgUtils.dbgFailureReason(n2));
        boolean bl = ADBUtils.isDownloadStateActive(n);
        this.hmiService.getChoiceModel(4419).setStatus(bl ? 0 : 1);
        this.hmiService.getChoiceModel(4419).setValue(bl ? 0 : 1);
    }

    public void updateDownloadCountMe(DownloadInfo downloadInfo) {
        this.log.log(10000000, "UserProfileUpdater#updateDownloadCountMe(): downloadCountMe: %1", (Object)downloadInfo);
        this.downloadCountMe = downloadInfo;
        this.updateDownloadProgress();
    }

    public void updateDownloadCountSim(DownloadInfo downloadInfo) {
        this.log.log(10000000, "UserProfileUpdater#updateDownloadCountSim(): downloadCountSim: %1", (Object)downloadInfo);
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
        this.hmiService.getLabelModel(700478).setText(Integer.toString(n));
        this.hmiService.getLabelModel(700479).setText(Integer.toString(n2));
        if (n3 > 0) {
            this.hmiService.getLabelModel(700445).setText(Integer.toString(n + n2));
            this.hmiService.getLabelModel(700446).setText(Integer.toString(n3));
            this.hmiService.getRangeModel(700559).setValue(ADBModelUtils.getPercentageValueForProgressBars((float)(n + n2) * 100.0f / (float)n3));
            this.hmiService.getRangeModel(700559).setStatus(0);
        } else {
            this.hmiService.getRangeModel(700559).setStatus(1);
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
        this.log.log(1000000, "UserProfileUpdater#updateDeviceConnected(): deviceConnected: %1", bl);
        this.hmiService.getChoiceModel(700444).setValue(bl ? 1 : 0);
    }

    public void updateActiveProfileModels() {
        ProfileInfo profileInfo = this.appAdr.getAdbStateHandler().getActiveProfileInfo();
        if (profileInfo == null) {
            this.log.log(10000, "UserProfileUpdater#updateActiveProfileModels(): could not determine active profile info!");
            return;
        }
        this.hmiService.getChoiceModel(700427).setValue(profileInfo.getNum());
        this.hmiService.getLabelModel(700428).setText(profileInfo.getName());
    }

    public void updateMaxPhoneEntries(int n) {
        this.maxPhoneEntries = n != 0 ? n : Integer.MAX_VALUE;
        this.updatePhoneCapacityInfo();
    }

    public void updateMaxLocalEntries(int n) {
        this.maxLocalEntries = n != 0 ? n : Integer.MAX_VALUE;
        this.updateCommonCapacityInfo();
    }

    public void updatePhoneCapacityInfo() {
        int n = ADBModelUtils.getPercentageValueForProgressBars((float)this.activeProfilePhoneEntries * 100.0f / (float)this.maxPhoneEntries);
        this.hmiService.getLabelModel(700435).setText(Integer.toString(this.activeProfilePhoneEntries));
        this.hmiService.getLabelModel(700436).setText(Integer.toString(this.maxPhoneEntries));
        this.hmiService.getRangeModel(700543).setValue(n);
        this.hmiService.getRangeModel(700593).setValue(Math.round((float)this.activeProfilePhoneEntries * 100.0f / (float)this.maxPhoneEntries));
    }

    public void updateCommonCapacityInfo() {
        int n = ADBModelUtils.getPercentageValueForProgressBars((float)this.commonProfileEntries * 100.0f / (float)this.maxLocalEntries);
        this.hmiService.getLabelModel(700429).setText(Integer.toString(this.commonProfileEntries));
        this.hmiService.getLabelModel(700430).setText(Integer.toString(this.maxLocalEntries));
        this.hmiService.getRangeModel(700542).setValue(n);
    }

    public void updateCapacityInfo(int n, int n2) {
        this.log.log(1000000, "UserProfileUpdater#updateCapacityInfo(): activeProfilePhoneEntries: %1, commonProfileEntries: %2", (long)n, (long)n2);
        this.activeProfilePhoneEntries = n;
        this.commonProfileEntries = n2;
        this.updatePhoneCapacityInfo();
        this.updateCommonCapacityInfo();
    }
}

