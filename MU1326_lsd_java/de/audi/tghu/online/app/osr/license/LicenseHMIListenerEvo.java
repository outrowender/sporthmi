/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr.license;

import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.hmi.model.list.BaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.metrics.AbstractMetrics;
import de.audi.atip.metrics.DateMetric;
import de.audi.remotehmi.IRemoteHMILicense;
import de.audi.tghu.online.app.osr.license.LicenseCollectionServiceEvo;
import de.audi.tghu.online.app.osr.license.LicenseHmiListener;
import de.audi.tghu.online.app.osr.license.LicenseModelManager;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;
import java.util.LinkedHashMap;
import java.util.List;

public class LicenseHMIListenerEvo
extends LicenseHmiListener
implements BaseListModelListener,
ButtonListener,
ChoiceListener {
    public LicenseHMIListenerEvo(LogChannel logChannel, LicenseCollectionServiceEvo licenseCollectionServiceEvo, RemoteHMIService remoteHMIService) {
        super(logChannel, licenseCollectionServiceEvo, remoteHMIService);
        logChannel.log(10000000, "LicenseHMIListenerEvo#ctor: Called.");
    }

    public final void setModelManager(LicenseModelManager licenseModelManager) {
        this.modelManager = licenseModelManager;
        this.init();
    }

    public final void init() {
        this.modelManager.initBaseListModel(2300863, this);
        this.modelManager.initButtonModel(3931, this);
        this.modelManager.initButtonModel(3934, this);
        this.modelManager.initButtonModel(3932, this);
        this.modelManager.initButtonModel(3935, this);
        this.modelManager.initChoiceModel(2301020, this);
        boolean bl = this.modelManager.getWarnFlagFromPersistence();
        this.updateWarningFlag(bl);
    }

    public final void deinit() {
        this.modelManager.initBaseListModel(2300863, null);
    }

    public final void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.log.log(1000000, "LicenseHMIListenerEvo#itemSelected: Called. %1, index %2", (Object)evoListRow.getText(1), (long)n2);
        LinkedHashMap linkedHashMap = this.controller.getLicensesByServiceID();
        String string = evoListRow.getText(6);
        List list = (List)linkedHashMap.get(string);
        if (list == null) {
            this.log.log(10000, "LicenseHMIListenerEvo#itemSelected: no licenses for this application found");
            return;
        }
        IRemoteHMILicense[] iRemoteHMILicenseArray = (IRemoteHMILicense[])list.toArray(new IRemoteHMILicense[0]);
        if (iRemoteHMILicenseArray.length <= 0) {
            this.log.log(10000, "LicenseHMIListenerEvo#itemSelected: no licenses for this application found");
            return;
        }
        IRemoteHMILicense iRemoteHMILicense = iRemoteHMILicenseArray[0];
        ChoiceModelApp choiceModelApp = this.modelManager.hmiService.getChoiceModel(2301018);
        int n5 = 5;
        this.log.log(1000000, "LicenseHMIListenerEvo#itemSelected: current license ServiceID is %1, state is: %2!", (Object)iRemoteHMILicense.getServiceID(), (long)iRemoteHMILicense.getState());
        switch (iRemoteHMILicense.getState()) {
            case 1: 
            case 5: {
                n5 = this.handleActivatedLicense(iRemoteHMILicense, iRemoteHMILicenseArray);
                break;
            }
            case 4: {
                n5 = this.handleExpiredLicense(iRemoteHMILicense);
                break;
            }
            case 2: {
                n5 = 7;
                break;
            }
            case 3: {
                n5 = 6;
                break;
            }
            case 6: {
                n5 = 5;
                break;
            }
            case 7: {
                n5 = 6;
                break;
            }
            default: {
                n5 = 5;
                this.log.log(100000, "LicenseHMIListenerEvo#itemSelected: unknown license state %1!", (long)iRemoteHMILicense.getState());
            }
        }
        choiceModelApp.setValue(n5);
        this.updateExpireDate(n5, iRemoteHMILicenseArray, evoListRow);
        this.modelManager.fireEvent(n, n4);
    }

    private int handleExpiredLicense(IRemoteHMILicense iRemoteHMILicense) {
        int n = this.remoteHMIService != null && !this.remoteHMIService.isTT() ? (iRemoteHMILicense.getType() == 0 ? 2 : 4) : 2;
        return n;
    }

    private void updateExpireDate(int n, IRemoteHMILicense[] iRemoteHMILicenseArray, EvoListRow evoListRow) {
        AbstractMetrics abstractMetrics = evoListRow.getMetrics(5);
        DateMetric dateMetric = null;
        if (n == 1) {
            IRemoteHMILicense iRemoteHMILicense = this.modelManager.getLicenseByState(iRemoteHMILicenseArray, 2);
            dateMetric = this.modelManager.getDateFromDateTime(iRemoteHMILicense);
        }
        this.modelManager.setServiceLabel(evoListRow.getText(1), abstractMetrics, dateMetric);
    }

    private int handleActivatedLicense(IRemoteHMILicense iRemoteHMILicense, IRemoteHMILicense[] iRemoteHMILicenseArray) {
        IRemoteHMILicense iRemoteHMILicense2;
        IRemoteHMILicense iRemoteHMILicense3;
        int n = 5;
        n = this.remoteHMIService != null && !this.remoteHMIService.isTT() ? (iRemoteHMILicense.getType() == 1 ? 3 : ((iRemoteHMILicense3 = this.modelManager.getLicenseByState(iRemoteHMILicenseArray, 2)) != null ? 1 : 0)) : ((iRemoteHMILicense2 = this.modelManager.getLicenseByState(iRemoteHMILicenseArray, 2)) != null ? 1 : 0);
        return n;
    }

    public final void itemSelected(int n, int n2, int n3, int n4) {
        if (n == 2301020) {
            ChoiceModelApp choiceModelApp = this.modelManager.hmiService.getChoiceModel(n);
            this.log.log(10000000, "LicenseHMIListenerEvo#itemSelected: checkbox pressed, value was %1", (long)choiceModelApp.getValue());
            this.updateWarningFlag(choiceModelApp.getValue() == 0);
            this.log.log(10000000, "LicenseHMIListenerEvo#itemSelected: new value %1", (long)choiceModelApp.getValue());
        }
    }

    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    public final void keyPressed(int n, int n2, int n3) {
        if (n == 3931) {
            ChoiceModelApp choiceModelApp = this.modelManager.hmiService.getChoiceModel(3930);
            choiceModelApp.setValue(~choiceModelApp.getValue());
            this.modelManager.hmiService.removePopup(16);
        } else if (n == 3934) {
            ChoiceModelApp choiceModelApp = this.modelManager.hmiService.getChoiceModel(3933);
            choiceModelApp.setValue(~choiceModelApp.getValue());
            this.modelManager.hmiService.removePopup(17);
        } else if (n == 3932) {
            this.updateWarningFlag(false);
            this.modelManager.hmiService.removePopup(16);
        } else if (n == 3935) {
            this.updateWarningFlag(false);
            this.modelManager.hmiService.removePopup(17);
        }
    }

    private void updateWarningFlag(boolean bl) {
        this.log.log(10000000, "LicenseHMIListenerEvo#updateWarningFlag: %1", (Object)(bl ? "Activating warning" : "Deactivating warning"));
        this.modelManager.setWarnFlagFromPersistence(bl);
        ChoiceModelApp choiceModelApp = this.modelManager.hmiService.getChoiceModel(2301020);
        choiceModelApp.setValue(bl ? 1 : 0);
    }

    public final void keyReleased(int n, int n2, int n3) {
    }

    public final void keyTyped(int n, int n2, int n3) {
    }

    public final void keyLongTyped(int n, int n2, int n3) {
    }
}

