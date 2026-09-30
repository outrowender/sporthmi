/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr.license;

import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.BaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.hmi.modelaccess.MetricsModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.metrics.AbstractMetrics;
import de.audi.atip.metrics.DateMetric;
import de.audi.atip.storage.IStorageAccess;
import de.audi.remotehmi.IRemoteHMILicense;
import de.audi.remotehmi.textconstants.ITextConstantsConverter;
import de.audi.tghu.online.app.osr.license.LicenseCollectionServiceEvo;
import de.audi.tghu.online.app.osr.license.LicenseModelManager;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;
import java.util.Calendar;
import java.util.List;
import org.dsi.ifc.global.DateTime;

public class LicensingModelManagerEvo
extends LicenseModelManager {
    protected static final int LIST_SERVICE_ID_FIELD = 6;
    private RemoteHMIService remoteHMIService;
    private IStorageAccess storageManager;
    private boolean isWarnedInBusCycle = false;
    private ITextConstantsConverter i18nHandler;
    boolean isWarnLicense = false;
    boolean isWarnTeaser = false;

    public LicensingModelManagerEvo(HMIService hMIService, LogChannel logChannel, RemoteHMIService remoteHMIService, LicenseCollectionServiceEvo licenseCollectionServiceEvo, ITextConstantsConverter iTextConstantsConverter) {
        super(hMIService, logChannel);
        this.remoteHMIService = remoteHMIService;
        this.i18nHandler = iTextConstantsConverter;
        if (remoteHMIService != null) {
            this.storageManager = remoteHMIService.getFrameworkAccess().getStorageMgr();
        } else {
            logChannel.log(100000, "LicensingModelManagerEvo#ctor: remoteHMIService is null, not able to retrieve StorageManager");
        }
    }

    public void initBaseListModel(int n, BaseListModelListener baseListModelListener) {
        this.baseListModel = this.hmiService.getBaseListModel(n);
        if (this.baseListModel != null) {
            this.baseListModel.setListener(baseListModelListener);
        }
    }

    public void initButtonModel(int n, ButtonListener buttonListener) {
        ButtonModelApp buttonModelApp = this.hmiService.getButtonModel(n);
        if (buttonModelApp != null) {
            buttonModelApp.setButtonListener(buttonListener);
        }
    }

    public void deinitButtonModel(int n) {
        ButtonModelApp buttonModelApp = this.hmiService.getButtonModel(n);
        if (buttonModelApp != null) {
            buttonModelApp.resetListener();
        }
    }

    public void initChoiceModel(int n, ChoiceListener choiceListener) {
        ChoiceModelApp choiceModelApp = this.hmiService.getChoiceModel(n);
        if (choiceModelApp != null) {
            choiceModelApp.setChoiceListener(choiceListener);
        }
    }

    public void deinitChoiceModel(int n) {
        ChoiceModelApp choiceModelApp = this.hmiService.getChoiceModel(n);
        if (choiceModelApp != null) {
            choiceModelApp.resetListener();
        }
    }

    public void deinitBaseListModel(int n) {
        this.baseListModel = this.hmiService.getBaseListModel(n);
        if (this.baseListModel != null) {
            this.baseListModel.resetListener();
        }
    }

    public void fireEvent(int n, int n2) {
        this.hmiService.getBaseListModel(n).fireEvent(n2);
    }

    public void setServiceLabel(String string, AbstractMetrics abstractMetrics, AbstractMetrics abstractMetrics2) {
        MetricsModelApp metricsModelApp;
        LabelModelApp labelModelApp = this.hmiService.getLabelModel(2300865);
        labelModelApp.setText(string);
        if (abstractMetrics != null) {
            metricsModelApp = this.hmiService.getMetricsModel(2300864);
            metricsModelApp.setMetric(abstractMetrics);
        }
        if (abstractMetrics2 != null) {
            metricsModelApp = this.hmiService.getMetricsModel(2301021);
            metricsModelApp.setMetric(abstractMetrics2);
        }
    }

    public boolean getWarnFlagFromPersistence() {
        if (this.storageManager != null) {
            boolean bl = this.storageManager.getBoolean(1023, 10, false);
            this.log.log(10000000, "[LicensingModelManagerEvo#getWarnFlagFromPersistence: persisted value for warn flag: %1", bl);
            return bl;
        }
        this.log.log(100000, "[LicensingModelManagerEvo#getWarnFlagFromPersistence: storageManager is null, not able to get Persistency");
        return false;
    }

    public boolean setWarnFlagFromPersistence(boolean bl) {
        if (this.storageManager != null) {
            this.log.log(1000000, "LicensingModelManagerEvo#setWarnFlagFromPersistence: called %1]", (Object)Boolean.toString(bl));
            this.storageManager.setBoolean(1023, 10, bl);
            return true;
        }
        this.log.log(100000, "LicensingModelManagerEvo#setWarnFlagFromPersistence: storageManager is null, not able to get Persistency");
        return false;
    }

    public void setListContent(BaseListModelApp baseListModelApp, List list, String string, int n) {
        if (list == null || list.isEmpty()) {
            this.log.log(1000000, "LicensingModelManagerEvo#setListContent: no license for application %1", (Object)string);
            return;
        }
        IRemoteHMILicense iRemoteHMILicense = (IRemoteHMILicense)list.get(0);
        if (iRemoteHMILicense != null && iRemoteHMILicense.getState() == 8) {
            this.log.log(1000000, "LicensingModelManagerEvo#setListContent: skipping license free service %1 %2 %3", (Object)string, (Object)iRemoteHMILicense.getServiceID(), (Object)iRemoteHMILicense.getName());
            return;
        }
        switch (iRemoteHMILicense.getState()) {
            case 1: {
                if (this.remoteHMIService != null && !this.remoteHMIService.isTT() && iRemoteHMILicense.warn) {
                    if (iRemoteHMILicense.getType() != 0) {
                        this.log.log(1000000, "LicensingModelManagerEvo#setListContent: setting warn for teaser license to true for app %1", (Object)string);
                        this.isWarnTeaser = true;
                        break;
                    }
                    this.log.log(1000000, "LicensingModelManagerEvo#setListContent: setting warn for online license to true for app %1", (Object)string);
                    this.isWarnLicense = true;
                    break;
                }
                if (!iRemoteHMILicense.warn) break;
                this.log.log(1000000, "LicensingModelManagerEvo#setListContent: setting warn for online license to true for app %1", (Object)string);
                this.isWarnLicense = true;
                break;
            }
            case 4: {
                break;
            }
        }
        this.setLicenseEntryInList(baseListModelApp, n, string, iRemoteHMILicense);
    }

    public void handleWarnPopups() {
        boolean bl = this.getWarnFlagFromPersistence();
        this.log.log(10000000, "LicensingModelManagerEvo#handleWarnPopups: Called with warningActivated %1, isWarnedInBusCycle %2", bl, this.isWarnedInBusCycle);
        if (this.isWarnedInBusCycle) {
            this.log.log(1000000, "LicensingModelManagerEvo#handleWarnPopups: already warned in this buscycle, not doing it again");
            return;
        }
        if (this.isWarnLicense && bl) {
            this.log.log(1000000, "LicensingModelManagerEvo#handleWarnPopups: showing license warning screen");
            this.hmiService.showPopup(16);
            this.isWarnedInBusCycle = true;
        }
        if (this.isWarnTeaser && bl) {
            this.log.log(1000000, "LicensingModelManagerEvo#handleWarnPopups: showing teaser warning screen");
            this.hmiService.showPopup(17);
            this.isWarnedInBusCycle = true;
        }
    }

    private String resolveTextConstant(String string) {
        if (this.i18nHandler != null) {
            return this.i18nHandler.getText(string);
        }
        this.log.log(10000, "LicensingModelManagerEvo#resolveTextConstant: i18Handler is NULL, cant resolve given TextContant %1", (Object)string);
        return "AN_ERROR_HAPPENED";
    }

    protected EvoListRow createLicenseListRow(String string) {
        return new EvoListRow(this.getRowIndex(string), 7);
    }

    private void setLicenseEntryInList(BaseListModelApp baseListModelApp, int n, String string, IRemoteHMILicense iRemoteHMILicense) {
        EvoListRow evoListRow = this.createLicenseListRow(string);
        String string2 = this.resolveLicenseName(string, iRemoteHMILicense);
        evoListRow.setText(1, string2);
        evoListRow.setText(6, iRemoteHMILicense.getServiceID());
        int n2 = 0;
        DateMetric dateMetric = this.getDateFromDateTime(iRemoteHMILicense);
        ChoiceModelApp choiceModelApp = this.hmiService.getChoiceModel(2301075);
        if (iRemoteHMILicense.getState() == 3 || iRemoteHMILicense.getState() == 2) {
            String string3 = this.resolveTextConstant("TEXT_CONST_RHMI_LICENSE_EXPIRED_NOT_AVAILABLE");
            evoListRow.setText(2, string3);
            choiceModelApp.setValue(1);
            n2 = 1;
        } else if (iRemoteHMILicense.getState() == 4) {
            String string4 = this.resolveTextConstant("TEXT_CONST_RHMI_LICENSE_EXPIRED_EXPIRED");
            evoListRow.setText(2, string4);
            choiceModelApp.setValue(1);
            n2 = 1;
        } else {
            evoListRow.setMetrics(2, dateMetric);
            choiceModelApp.setValue(0);
        }
        evoListRow.setMetrics(5, dateMetric);
        evoListRow.setInteger(4, n2);
        if (iRemoteHMILicense.getState() == 4 || iRemoteHMILicense.warn) {
            evoListRow.setInteger(3, 1);
        }
        this.setLicenseListRow(string, evoListRow, baseListModelApp);
    }

    private String resolveLicenseName(String string, IRemoteHMILicense iRemoteHMILicense) {
        String string2 = null;
        String string3 = iRemoteHMILicense.description;
        String string4 = iRemoteHMILicense.getName();
        this.log.log(1000000, "LicensingModelManagerEvo#resolveLicenseName: having license for app %1, with description %2 and licenseName %3", (Object)string, (Object)string3, (Object)string4);
        if (string3 != null && string3.length() > 0) {
            string2 = string3;
        } else if (string4 != null && string4.length() > 0) {
            string2 = string4;
            if (string4.equals("dwap")) {
                string2 = this.resolveTextConstant("TEXT_CONST_RHMI_DWA_PUSH_MAIN");
            } else if (string4.equals("poi_haptic")) {
                string2 = this.resolveTextConstant("TEXT_CONST_RHMI_DISTR_POI_MAIN");
            } else if (string4.equals("lic_traffic")) {
                string2 = this.resolveTextConstant("TEXT_CONST_RHMI_DISTR_TRAFFICMAP_MAIN");
            } else if (string4.equals("dictation")) {
                string2 = this.resolveTextConstant("TEXT_CONST_RHMI_DISTR_SMSDICTATION_MAIN");
            } else if (string4.equals("zieleinspeisung")) {
                string2 = this.resolveTextConstant("TEXT_CONST_RHMI_DISTR_MY_AUDI_MAIN");
            } else if (string4.equals("service_picnav")) {
                string2 = this.resolveTextConstant("TEXT_CONST_RHMI_DISTR_PICNAV_MAIN");
            } else if (string4.equals("poi_sds")) {
                string2 = this.resolveTextConstant("TEXT_CONST_RHMI_DISTR_POI_SDS_MAIN");
            } else if (string4.equals("satelitemaps") || string4.equals("satellitemaps")) {
                string2 = this.resolveTextConstant("TEXT_CONST_RHMI_DISTR_GOOGLE_EARTH_MAIN");
            } else if (string4.equals("satellitemaps_eb")) {
                string2 = this.resolveTextConstant("TEXT_CONST_RHMI_DISTR_SATELLITE_MAP");
            } else if (string4.equals("streetview")) {
                string2 = this.resolveTextConstant("TEXT_CONST_RHMI_DISTR_STREETVIEW_MAIN");
            } else if (string4.equals("weatherGrid")) {
                string2 = this.resolveTextConstant("TEXT_CONST_RHMI_LICENSE_WEATHER_IN_MAP");
            } else if (string4.equals("esim")) {
                string2 = this.resolveTextConstant("TEXT_CONST_RHMI_LICENSE_ESIM");
            } else if (string4.equals("hotspotwlan")) {
                string2 = this.resolveTextConstant("TEXT_CONST_RHMI_LICENSE_HOTSPOTWLAN");
            } else if (string4.equals("breakdowncall")) {
                string2 = this.resolveTextConstant("TEXT_CONST_RHMI_LICENSE_BREAKDOWN_CALL");
            } else if (string4.equals("poicall")) {
                string2 = this.resolveTextConstant("TEXT_CONST_RHMI_LICENSE_POI_CALL");
            } else if (string4.equals("carfinder_v1")) {
                string2 = this.resolveTextConstant("TEXT_CONST_RHMI_DISTR_CAR_FINDER_MAIN");
            } else if (string4.equals("mobilekey_sales_v1")) {
                string2 = this.resolveTextConstant("TEXT_CONST_RHMI_DISTR_MOBILE_KEY");
            } else if (string4.equals("trafficlightsinfo_v1")) {
                string2 = this.resolveTextConstant("TEXT_CONST_RHMI_DISTR_TRAFFICLIGHT_MAIN");
            } else if (string4.equals("cc_breakdown_v1")) {
                string2 = this.resolveTextConstant("TEXT_CONST_RHMI_DISTR_BREAKDOWNCALL_MAIN");
            } else if (string4.equals("rlu_v1")) {
                string2 = this.resolveTextConstant("TEXT_CONST_RHMI_DISTR_REMOTE_LOCK_MAIN");
            } else if (string4.equals("rheating_v1")) {
                string2 = this.resolveTextConstant("TEXT_CONST_RHMI_DISTR_REMOTE_HEATING_MAIN");
            } else if (string4.equals("dealerappoint_v1")) {
                string2 = this.resolveTextConstant("TEXT_CONST_RHMI_DISTR_DEALER_APPOINT_MAIN");
            } else if (string4.equals("cc_breakdown_v2")) {
                string2 = this.resolveTextConstant("TEXT_CONST_RHMI_DISTR_ONLINE_BREAKDOWNCALL_MAIN");
            } else if (string4.equals("vehicletelemetry_v1")) {
                string2 = this.resolveTextConstant("TEXT_CONST_RHMI_DISTR_VEHICLE_TELEMETRY_MAIN");
            } else if (string4.equals("esim_v1")) {
                string2 = this.resolveTextConstant("TEXT_CONST_RHMI_DISTR_ESIM_MAIN");
            } else if (string4.equals("statusreport_v1")) {
                string2 = this.resolveTextConstant("TEXT_CONST_RHMI_DISTR_STATUS_REPORT_MAIN");
            } else if (string4.equals("theft_v1")) {
                string2 = this.resolveTextConstant("TEXT_CONST_RHMI_DISTR_THEFT_MAIN");
            } else if (string4.equals("geofence_v1")) {
                string2 = this.resolveTextConstant("TEXT_CONST_RHMI_DISTR_GEOFENCE_MAIN");
            } else if (string4.equals("rhonk_v1")) {
                string2 = this.resolveTextConstant("TEXT_CONST_RHMI_DISTR_REMOTE_HONK_MAIN");
            } else if (string4.equals("uota_v1")) {
                string2 = this.resolveTextConstant("TEXT_CONST_RHMI_DISTR_REMOTE_OTA_MAIN");
            } else if (string4.equals("infocall_v1")) {
                string2 = this.resolveTextConstant("TEXT_CONST_RHMI_DISTR_INFOCALL_MAIN");
            } else if (string4.equals("speedalert_v1")) {
                string2 = this.resolveTextConstant("TEXT_CONST_RHMI_DISTR_SPEED_ALERT_MAIN");
            } else if (string4.equals("vts_v1")) {
                string2 = this.resolveTextConstant("TEXT_CONST_RHMI_DISTR_TRACKING_SERVICE_MAIN");
            } else if (string4.equals("ecall_v1")) {
                string2 = this.resolveTextConstant("TEXT_CONST_RHMI_DISTR_E_CALL");
            } else if (string4.equals("simcardalert")) {
                string2 = this.resolveTextConstant("TEXT_CONST_RHMI_LICENSE_SIMCARD_ALERT");
            } else if (string4.equals("lic_uota_nav")) {
                string2 = this.resolveTextConstant("TEXT_CONST_RHMI_LICENSE_UOTA");
            } else if (string4.equals("rbatterycharge_v1")) {
                string2 = this.resolveTextConstant("TEXT_CONST_RHMI_DISTR_BATTERYCHARGE_MAIN");
            } else if (string4.equals("rclima_v1")) {
                string2 = this.resolveTextConstant("TEXT_CONST_RHMI_DISTR_CLIMA_MAIN");
            } else if (string4.equals("trip_statistic_v1")) {
                string2 = this.resolveTextConstant("TEXT_CONST_RHMI_DISTR_TRIPSTATISTIC_MAIN");
            } else if (string4.equals("timerprogramming_v1")) {
                string2 = this.resolveTextConstant("TEXT_CONST_RHMI_DISTR_TIMEPROGRAMMING_MAIN");
            } else if (string4.equals("poi-echarge")) {
                string2 = this.resolveTextConstant("TEXT_CONST_RHMI_DISTR_POIECHARGE_MAIN");
            } else if (string4.equals("rvt_v1")) {
                string2 = this.resolveTextConstant("TEXT_CONST_RHMI_DISTR_REMOTEVEHICLETRACKING_MAIN");
            } else if (string4.equals("valetalert_v1")) {
                string2 = this.resolveTextConstant("TEXT_CONST_RHMI_DISTR_VALETALERT_MAIN");
            } else if (string4.equals("service_trafficlight")) {
                string2 = this.resolveTextConstant("TEXT_CONST_RHMI_DISTR_TRAFFICLIGHT_MAIN");
            } else if (string4.equals("lgi_download")) {
                string2 = this.resolveTextConstant("TEXT_CONST_RHMI_DISTR_LGI_DOWNLOAD_V1");
            } else if (string4.equals("lgi_upload")) {
                string2 = this.resolveTextConstant("TEXT_CONST_RHMI_DISTR_LGI_UPLOAD_V1");
            } else if (string4.equals("vzo_download")) {
                string2 = this.resolveTextConstant("TEXT_CONST_RHMI_DISTR_VZO_DOWNLOAD_V1");
            } else if (string4.equals("vzo_upload")) {
                string2 = this.resolveTextConstant("TEXT_CONST_RHMI_DISTR_VZO_UPLOAD_V1");
            }
        } else {
            string2 = string;
        }
        return string2;
    }

    protected DateMetric getDateFromDateTime(IRemoteHMILicense iRemoteHMILicense) {
        DateTime dateTime = iRemoteHMILicense.getExpires();
        Calendar calendar = Calendar.getInstance();
        DateMetric dateMetric = new DateMetric(calendar.getTime(), 0);
        if (dateTime == null) {
            this.log.log(10000000, "LicensingModelManagerEvo#getDateFromDateTime: no expire dateTime set for license using current date");
            return dateMetric;
        }
        dateMetric.setDate(dateTime.getTime());
        return dateMetric;
    }

    protected String getStringFromDateTime(IRemoteHMILicense iRemoteHMILicense) {
        DateTime dateTime = iRemoteHMILicense.getExpires();
        if (dateTime == null) {
            this.log.log(100000, "LicensingModelManagerEvo#getStringFromDateTime: no expire dateTime set for license");
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(dateTime.getTime());
        StringBuffer stringBuffer = new StringBuffer();
        calendar.get(5);
        calendar.get(1);
        calendar.get(2);
        stringBuffer.append(calendar.get(5)).append(".").append(calendar.get(2) + 1).append(".").append(calendar.get(1));
        return stringBuffer.toString();
    }

    public IRemoteHMILicense getLicenseByState(IRemoteHMILicense[] iRemoteHMILicenseArray, int n) {
        for (int i2 = 0; i2 < iRemoteHMILicenseArray.length; ++i2) {
            IRemoteHMILicense iRemoteHMILicense = iRemoteHMILicenseArray[i2];
            if (iRemoteHMILicense.getState() != n) continue;
            this.log.log(10000000, "LicensingModelManagerEvo#getLicenseByState: found license with state %1", (long)n);
            return iRemoteHMILicense;
        }
        this.log.log(10000000, "LicensingModelManagerEvo#getLicenseByState: no license found with requested state %1", (long)n);
        return null;
    }

    public void setLicenseAvailableStatus(int n) {
        switch (n) {
            case 2: {
                this.log.log(10000000, "LicensingModelManagerEvo#setLicenseAvailableStatus: showing error screen");
                break;
            }
            case 0: {
                this.log.log(10000000, "LicensingModelManagerEvo#setLicenseAvailableStatus: showing 'Please wait screen'");
                break;
            }
            case 1: {
                this.log.log(10000000, "LicensingModelManagerEvo#setLicenseAvailableStatus: showing license overview");
                break;
            }
            default: {
                this.log.log(10000000, "LicensingModelManagerEvo#setLicenseAvailableStatus: default");
            }
        }
        ChoiceModelApp choiceModelApp = this.hmiService.getChoiceModel(2301017);
        choiceModelApp.setValue(n);
    }

    public void setLabelForEnteredApplication(String string) {
        LabelModelApp labelModelApp = this.hmiService.getLabelModel(3949);
        labelModelApp.setText(string);
    }

    public void setLicenseExpirationDetail(int n) {
        this.log.log(10000000, "LicensingModelManagerEvo#setLicenseExpirationDetail: setting status of detail screen to %1", (long)n);
        ChoiceModelApp choiceModelApp = this.hmiService.getChoiceModel(3945);
        choiceModelApp.setValue(n);
    }
}

