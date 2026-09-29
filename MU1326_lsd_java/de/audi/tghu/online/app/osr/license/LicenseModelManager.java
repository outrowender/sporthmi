/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr.license;

import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.hmi.model.ModelGroup;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.BaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.metrics.AbstractMetrics;
import de.audi.atip.metrics.DateMetric;
import de.audi.remotehmi.IRemoteHMILicense;
import java.util.HashMap;
import java.util.List;
import org.dsi.ifc.online.OSRLicense;

public abstract class LicenseModelManager {
    protected static final int LIST_RECORD_SET;
    protected static final int LIST_NAME_FIELD;
    protected static final int LIST_CURRENT_STATUS_FIELD;
    protected static final int LIST_DATE_NEXT_FIELD;
    protected static final int LIST_LAYOUT_FIELD;
    protected static final int LIST_EXPIRE_DATE_FIELD;
    protected HMIService hmiService;
    protected BaseListModelApp baseListModel;
    protected LogChannel log;
    private ModelGroup licenseExpiredGroup;
    protected HashMap apps = new HashMap(30);

    public LicenseModelManager(HMIService hMIService, LogChannel logChannel) {
        this.hmiService = hMIService;
        this.log = logChannel;
        this.licenseExpiredGroup = new ModelGroup();
        this.setUpLicenseExpiredGroup();
    }

    public void initBaseListModel(int n, BaseListModelListener baseListModelListener) {
    }

    public void setServiceLabel(String string, AbstractMetrics abstractMetrics, AbstractMetrics abstractMetrics2) {
    }

    public void fireEvent(int n, int n2) {
    }

    public IRemoteHMILicense getLicenseByState(IRemoteHMILicense[] iRemoteHMILicenseArray, int n) {
        return null;
    }

    public boolean setWarnFlagFromPersistence(boolean bl) {
        return false;
    }

    public boolean getWarnFlagFromPersistence() {
        return true;
    }

    public void initButtonModel(int n, ButtonListener buttonListener) {
    }

    public abstract void setLicenseAvailableStatus(int n) {
    }

    public abstract void initChoiceModel(int n, ChoiceListener choiceListener) {
    }

    protected String getStringFromDateTime(OSRLicense oSRLicense) {
        return null;
    }

    protected DateMetric getDateFromDateTime(IRemoteHMILicense iRemoteHMILicense) {
        return null;
    }

    protected void setServiceListDownloaded(int n) {
        int n2 = 0;
        int n3 = 0;
        switch (n) {
            case 0: {
                n2 = 1;
                n3 = 3;
                this.log.log(-2137614336, "LicensingModelManager#setServiceListDownloaded: showing service");
                break;
            }
            case 1: {
                n2 = 1;
                n3 = -1;
                this.log.log(-2137614336, "LicensingModelManager#setServiceListDownloaded: showing license screen");
                break;
            }
            case 2: {
                n2 = 0;
                n3 = 0;
                this.log.log(-2137614336, "LicensingModelManager#setServiceListDownloaded: showing 'Please wait' screen");
                break;
            }
            case 3: {
                n2 = 2;
                n3 = 0;
                this.log.log(-2137614336, "LicensingModelManager#setServiceListDownloaded: showing error screen");
                break;
            }
            default: {
                this.log.log(-2137614336, "LicensingModelManager#setServiceListDownloaded: invalid state");
            }
        }
        ChoiceModelApp choiceModelApp = this.hmiService.getChoiceModel(3947);
        ChoiceModelApp choiceModelApp2 = this.hmiService.getChoiceModel(4386);
        choiceModelApp2.setValue(~choiceModelApp2.getValue());
        choiceModelApp.setStatus(n2);
        choiceModelApp.setValue(n3);
        this.flushLicenseExpiredGroup();
    }

    public abstract void setLabelForEnteredApplication(String string) {
    }

    public void setLicenseExpirationDetail(int n) {
    }

    public abstract void setListContent(BaseListModelApp baseListModelApp, List list, String string, int n) {
    }

    public void handleWarnPopups() {
    }

    public void setWarnPopup(boolean bl) {
    }

    public void setUpLicenseExpiredGroup() {
        ChoiceModelApp choiceModelApp = this.hmiService.getChoiceModel(3947);
        ChoiceModelApp choiceModelApp2 = this.hmiService.getChoiceModel(4386);
        this.licenseExpiredGroup.add(choiceModelApp2);
        this.licenseExpiredGroup.add(choiceModelApp);
    }

    public void flushLicenseExpiredGroup() {
        this.licenseExpiredGroup.flush();
    }

    public boolean isESimUsed() {
        ChoiceModelApp choiceModelApp = this.hmiService.getChoiceModel(-601479680);
        return choiceModelApp.getValue() != 0;
    }

    protected String getLicenseNameFromI18N(String string) {
        return null;
    }

    protected int getRowIndex(String string) {
        int n = -1;
        if (this.apps.containsKey(string)) {
            n = (Integer)this.apps.get(string);
        } else {
            n = this.apps.keySet().size();
            this.apps.put(string, new Integer(n));
        }
        return n;
    }

    protected EvoListRow createLicenseListRow(String string) {
        return new EvoListRow(this.getRowIndex(string), 6);
    }

    protected void setLicenseListRow(String string, EvoListRow evoListRow, BaseListModelApp baseListModelApp) {
        int n = this.getRowIndex(string);
        this.log.log(-2137614336, "LicenseModelManager#setLicenseEntryInList() rowIndex=%1, row=%2", (Object)Integer.toString(n), (Object)evoListRow);
        if (n >= baseListModelApp.getLength()) {
            baseListModelApp.append(evoListRow);
        } else {
            baseListModelApp.setRow(n, evoListRow);
        }
    }
}

