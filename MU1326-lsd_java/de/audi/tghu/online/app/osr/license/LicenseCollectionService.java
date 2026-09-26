/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr.license;

import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.interapp.bap.eni.data.License;
import de.audi.atip.interapp.bap.eni.data.Service;
import de.audi.atip.interapp.online.OnlineServiceListState;
import de.audi.atip.log.LogChannel;
import de.audi.atip.util.StringUtilities;
import de.audi.remotehmi.IRemoteHMILicense;
import de.audi.remotehmi.RemoteHMIAction;
import de.audi.tghu.online.app.IOnlineLanguageChangeListener;
import de.audi.tghu.online.app.osr.OnlineServiceRegistrationSubsystem;
import de.audi.tghu.online.app.osr.command.AbstractOSRCommand;
import de.audi.tghu.online.app.osr.command.OSRCommandList;
import de.audi.tghu.online.app.osr.command.OSRGetLicensesCommand;
import de.audi.tghu.online.app.osr.command.OSRGetOnlineApplicationListCommand;
import de.audi.tghu.online.app.osr.command.OSRPreCheckOnlineServiceEsim;
import de.audi.tghu.online.app.osr.command.OSRPreCheckOnlineServiceSymbolicName;
import de.audi.tghu.online.app.osr.license.LicenseCollectionService$1;
import de.audi.tghu.online.app.osr.license.LicenseCollectionService$2;
import de.audi.tghu.online.app.osr.license.LicenseCollectionService$3;
import de.audi.tghu.online.app.osr.license.LicenseCollectionService$4;
import de.audi.tghu.online.app.osr.license.LicenseCollectionService$5;
import de.audi.tghu.online.app.osr.license.LicenseHmiListener;
import de.audi.tghu.online.app.osr.license.LicenseModelManager;
import de.audi.tghu.online.app.remotehmi.RemoteHMIDSIAccess$IRemoteHMIDSIListener;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;
import de.esolutions.fw.util.commons.Buffer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map$Entry;
import org.dsi.ifc.global.DateTime;
import org.dsi.ifc.online.OSRApplication;
import org.dsi.ifc.online.OSRLicense;
import org.dsi.ifc.online.OSRServiceState;

public abstract class LicenseCollectionService
implements RemoteHMIDSIAccess$IRemoteHMIDSIListener,
IOnlineLanguageChangeListener {
    public static final String SYMBOLIC_NAME_ID_ESIM;
    public static final String SYMBOLIC_NAME_HOTSPOTWLAN;
    public static final String SYMBOLIC_NAME_SERVICE_PICNAV;
    public static final String SYMBOLIC_NAME_BREAKDOWNCALL;
    public static final String SYMBOLIC_NAME_POICALL;
    public static final String SYMBOLIC_NAME_SATELLITEMAPS;
    public static final String SYMBOLIC_NAME_SATELLITEMAPS_EB;
    public static final String SYMBOLIC_NAME_SATELLITEMAPS_AW;
    public static final String SYMBOLIC_NAME_WEATHER_GRID;
    public static final String SYMBOLIC_NAME_TRAFFICLIGHT;
    public static final String SYMBOLIC_NAME_TRAFFIC;
    public static final String SYMBOLIC_NAME_LIC_TRAFFIC;
    public static final String SYMBOLIC_NAME_DICTATION;
    public static final String SYMBOLIC_NAME_ZIELEINSPEISUNG;
    public static final String SYMBOLIC_NAME_POI_SDS;
    public static final String SYMBOLIC_NAME_POI_HAPTIC;
    public static final String SYMBOLIC_NAME_GRACENOTE;
    public static final String SYMBOLIC_NAME_PPOI;
    public static final String SYMBOLIC_NAME_NAVUPDATE;
    public static final String SYMBOLIC_NAME_DESTIMPORT;
    protected static final String SYMBOLIC_NAME_RHMI_ECHARGE;
    private static final String CGW_TIME_FORMAT;
    protected static final String LOGCLASS;
    protected final LogChannel log;
    public static Map licenses;
    protected OnlineServiceRegistrationSubsystem orsApplication;
    protected LicenseModelManager modelManager;
    protected LicenseHmiListener hmiListener;
    protected boolean isLicenseRequestRunning = false;
    protected static final int LICENSE_WAITING;
    protected static final int LICENSE_AVAILABLE;
    protected static final int LICENSE_UNAVAILABLE;
    protected static final int EXPIRED_LICENSE;
    protected static final int TEASER_LICENSE;
    protected static final int NOT_LICENSED;
    protected static final int NOT_ACTIVATED;
    protected static final int REVOKED_REJECTED;
    protected static final int LICENSE_ERROR;
    protected static final int DATAUPDATE_AVAILABLE;
    protected static final int DATAUPDATE_UNAVAILABLE;
    protected static final int DATAUPDATE_UPDATE;
    protected static final int DATAUPDATE_ERROR;
    protected boolean isServiceListAlreadyLoaded = false;
    private boolean licensesFromCGWDownloaded = false;
    protected RemoteHMIService remoteHMIService;
    protected String symbolicName;
    protected String appID;
    protected String applicationName;
    protected OnlineServiceListState serviceListState;
    private final String DELIMITER;
    protected LinkedHashMap licensesBySymbolicName = new LinkedHashMap();
    protected LinkedHashMap licensesByServiceID = new LinkedHashMap();
    private boolean isLicenseOverviewEntered = false;
    private boolean isStandard = false;
    protected Service[] services;

    public LicenseCollectionService(LogChannel logChannel, HMIService hMIService, RemoteHMIService remoteHMIService, boolean bl) {
        this.DELIMITER = ".";
        this.log = logChannel;
        logChannel.log(14808325, "LicenseCollectionService#init");
        this.isStandard = bl;
        logChannel.log(-2137614336, "LicenseCollectionService#isStandard %1", bl);
        this.remoteHMIService = remoteHMIService;
        this.serviceListState = new OnlineServiceListState(0, 0);
        if (remoteHMIService != null && remoteHMIService.getDsiAccess() != null) {
            remoteHMIService.getDsiAccess().addDSIListener(this);
        }
    }

    public void setOnlineServiceRegistration(OnlineServiceRegistrationSubsystem onlineServiceRegistrationSubsystem) {
        this.orsApplication = onlineServiceRegistrationSubsystem;
    }

    public void setLicenseCheckEnteredAppID(String string, String string2) {
        this.symbolicName = string;
        this.appID = string2;
        if (this.isLicenseCheckForServiceDisabled(string)) {
            return;
        }
        this.log.log(-2137614336, "LicenseCollectionService#setLicenseCheckEntered: serviceList state is %1", (Object)this.serviceListState.getCurrentServiceStateAsText());
        this.modelManager.setServiceListDownloaded(2);
        if (this.modelManager.isESimUsed()) {
            this.log.log(-2137614336, "LicenseCollectionService#setLicenseCheckEntered: eSIM is used, check eSIM license first");
            this.preCheckEsim();
            return;
        }
        this.preCheckLicense(string, string2);
    }

    protected void preCheckEsim() {
        if (this.orsApplication == null) {
            this.log.log(-2137614336, "LicenseCollectionService#preCheckEsim: no OSR available");
            return;
        }
        OSRCommandList oSRCommandList = this.orsApplication.createCommandList();
        OSRPreCheckOnlineServiceEsim oSRPreCheckOnlineServiceEsim = new OSRPreCheckOnlineServiceEsim(this);
        this.log.log(-2137614336, "LicenseCollectionService#preCheckEsim Called.");
        oSRCommandList.add(oSRPreCheckOnlineServiceEsim);
        oSRCommandList.setErrorCommand(this.getESimErrorCommand());
        oSRCommandList.execute("LicenseCollectionService#preCheckEsim");
    }

    protected AbstractOSRCommand getESimErrorCommand() {
        return new LicenseCollectionService$2(this);
    }

    protected void preCheckLicense(String string, String string2) {
        if (this.orsApplication == null) {
            this.log.log(-2137614336, "LicenseCollectionService#preCheckLicense: no OSR available");
            return;
        }
        OSRCommandList oSRCommandList = this.orsApplication.createCommandList();
        OSRPreCheckOnlineServiceSymbolicName oSRPreCheckOnlineServiceSymbolicName = new OSRPreCheckOnlineServiceSymbolicName(string2, string, this);
        this.log.log(-2137614336, "LicenseCollectionService#preCheckLicense Called.");
        oSRCommandList.add(oSRPreCheckOnlineServiceSymbolicName);
        oSRCommandList.setErrorCommand(this.getPreCheckErrorCommand());
        oSRCommandList.execute("LicenseCollectionService#preCheckLicense");
    }

    protected AbstractOSRCommand getPreCheckErrorCommand() {
        return new LicenseCollectionService$3(this);
    }

    public void setLicenseCheckEntered(String string, String string2) {
        this.log.log(-1601830656, "__UPPERCLASS__%1#setLicenseCheckEntered with %2, %3", (Object)"LicenseCollector", (Object)string, (Object)string2);
        this.modelManager.setLabelForEnteredApplication(string2);
        String string3 = LicenseCollectionService.getAppIdForSymbolicName(string);
        if (!StringUtilities.isNullOrEmpty(string3)) {
            this.setLicenseCheckEnteredAppID(string, string3);
            return;
        }
        this.log.log(-2137614336, "LicenseCollectionService#setLicenseCheckEntered: no matching symbolicName found, showing error screen");
        this.modelManager.setServiceListDownloaded(3);
    }

    protected static String getAppIdForSymbolicName(String string) {
        String string2 = (String)licenses.get(string);
        return string2 == null ? "" : string2;
    }

    protected boolean isLicenseCheckForServiceDisabled(String string) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("SkipLicenseCheck");
        stringBuffer.append(".");
        stringBuffer.append(string);
        String string2 = stringBuffer.toString();
        if (System.getProperty("SkipLicenseCheck") != null) {
            this.modelManager.setServiceListDownloaded(0);
            this.indicateActiveLicense(new OSRLicense());
            this.log.log(-2137614336, "LicenseCollectionService#isLicenseCheckForServiceDisabled: skip license check activated: jumping directly to service");
            return true;
        }
        if (System.getProperty(string2) != null) {
            this.modelManager.setServiceListDownloaded(0);
            this.indicateActiveLicense(new OSRLicense());
            this.log.log(-2137614336, "LicenseCollectionService#isLicenseCheckForServiceDisabled: license check disabled, jumping directly to service");
            return true;
        }
        return false;
    }

    public void requestLicenses() {
        if (this.orsApplication == null) {
            this.log.log(-2137614336, "LicenseCollectionService#requestLicenses: no OnlineServiceRegistrationSubsystem available");
            return;
        }
        if (this.isLicenseRequestRunning) {
            this.log.log(-2137614336, "LicenseCollectionService#requestLicenses: license request already running, not starting new one.");
            return;
        }
        this.isLicenseRequestRunning = true;
        OSRCommandList oSRCommandList = this.orsApplication.createCommandList();
        OSRGetLicensesCommand oSRGetLicensesCommand = new OSRGetLicensesCommand(this);
        this.log.log(-2137614336, "LicenseCollectionService#requestLicenses Called.");
        oSRCommandList.add(oSRGetLicensesCommand);
        oSRCommandList.setErrorCommand(new LicenseCollectionService$4(this));
        oSRCommandList.execute("LicenseCollectionService#requestLicenses.");
    }

    public void setLicenseList(int n, OSRLicense[] oSRLicenseArray) {
        this.log.log(-2137614336, "LicenseCollectionService#setLicenseList: Called");
        this.isLicenseRequestRunning = false;
        if (n == 0) {
            this.copyLicensesAndSort(oSRLicenseArray);
        } else {
            this.log.log(-2137614336, "LicenseCollectionService#setLicenseList: error result code %1", (long)n);
            if (this.licensesFromCGWDownloaded && this.licensesByServiceID != null && this.licensesByServiceID.size() > 0) {
                this.log.log(-2137614336, "LicenseCollectionService#setLicenseList: error in getting licenses from CoreServices, but licenses from CGW available");
                this.processLicensesForOverview(false);
                this.modelManager.setLicenseAvailableStatus(1);
            } else {
                this.log.log(-2137614336, "LicenseCollectionService#setLicenseList: error in getting licenses from CoreServices and no licenses from CGW available");
                this.modelManager.setLicenseAvailableStatus(2);
            }
        }
    }

    protected void setLicenseDetailScreenForLicenseInclude(String string, IRemoteHMILicense iRemoteHMILicense) {
        int n = 5;
        int n2 = 3;
        long l = System.currentTimeMillis();
        switch (iRemoteHMILicense.getState()) {
            case 1: {
                if (iRemoteHMILicense.expires.getTime() - l >= 0L) {
                    this.log.log(-2137614336, "LicenseCollectionService#setLicenseDetailScreenForLicenseInclude: license activated for current status for symbolicName %1 ", (Object)string);
                }
                this.log.log(-2137614336, "LicenseCollectionService#setLicenseDetailScreenForLicenseInclude: license activated for symbolicName %1 ", (Object)string);
                n2 = 0;
                break;
            }
            case 4: {
                this.log.log(-2137614336, "LicenseCollectionService#setLicenseDetailScreenForLicenseInclude: got expired license for symbolicName %1", (Object)string);
                n = 0;
                n2 = 1;
                break;
            }
            case 3: {
                n = 2;
                n2 = 1;
                break;
            }
            case 2: {
                n = 3;
                n2 = 1;
                break;
            }
            case 6: {
                n = 5;
                n2 = 1;
                break;
            }
            case 7: {
                n = 4;
                n2 = 1;
                break;
            }
            case 5: {
                if (iRemoteHMILicense.expires.getTime() - l >= 0L) {
                    this.log.log(-2137614336, "LicenseCollectionService#setLicenseDetailScreenForLicenseInclude: license offered for current status for symbolicName %1 ", (Object)string);
                }
                this.log.log(-2137614336, "LicenseCollectionService#setLicenseDetailScreenForLicenseInclude: license offered for symbolicName %1 ", (Object)string);
                n2 = 0;
                break;
            }
            default: {
                n2 = 3;
            }
        }
        this.modelManager.setLicenseExpirationDetail(n);
        this.modelManager.setServiceListDownloaded(n2);
    }

    public void processLicensesForOverview(boolean bl) {
        Object object;
        if (this.remoteHMIService != null) {
            object = this.remoteHMIService.getAction(1700);
            ((RemoteHMIAction)object).getParameters().put("licensesByServiceID", this.licensesByServiceID);
            ((RemoteHMIAction)object).getParameters().put("licensesBySymbolicName", this.licensesBySymbolicName);
            ((RemoteHMIAction)object).getParameters().putBoolean("forceUpdate", bl);
            this.log.log(-2137614336, "LicenseCollectionService#processLicensesForOverview: sending all licenses to southside");
            this.remoteHMIService.invokeAction((RemoteHMIAction)object);
        }
        if (this.licensesByServiceID == null || this.licensesByServiceID.isEmpty()) {
            this.log.log(-1601830656, "LicenseCollectionService#processLicensesForOverview: no licenses set yet");
            this.modelManager.setLicenseAvailableStatus(2);
            return;
        }
        object = this.licensesByServiceID.entrySet().iterator();
        BaseListModelApp baseListModelApp = this.modelManager.baseListModel.getCopy();
        int n = 0;
        while (object.hasNext()) {
            Map$Entry map$Entry = (Map$Entry)object.next();
            String string = (String)map$Entry.getKey();
            Object object2 = map$Entry.getValue();
            if (object2 instanceof List) {
                this.modelManager.setListContent(baseListModelApp, (List)object2, string, n);
            } else {
                this.log.log(-1601830656, "LicenseCollectionService#processLicensesForOverview: no licenses available for %1", (Object)string);
            }
            ++n;
        }
        if (this.isLicenseOverviewEntered() || this.isStandard) {
            this.log.log(1078071040, "LicenseCollectionService#processLicensesForOverview: updating base list");
            this.modelManager.baseListModel.update(baseListModelApp);
        } else {
            this.log.log(1078071040, "LicenseCollectionService#processLicensesForOverview: not updating base list, screen not active");
        }
        this.modelManager.handleWarnPopups();
        this.modelManager.setLicenseAvailableStatus(1);
    }

    protected void copyLicensesAndSort(OSRLicense[] oSRLicenseArray) {
        this.licensesBySymbolicName.clear();
        this.licensesByServiceID.clear();
        if (this.licensesFromCGWDownloaded) {
            this.log.log(-2137614336, "LicenseCollectionService#copyLicensesAndSort: adding CGW licenses");
            try {
                this.addCGWLicenses();
            }
            catch (Exception exception) {
                this.log.log(-1601830656, "LicenseCollectionService#copyLicensesAndSort: exception occured %1", (Throwable)exception);
            }
        }
        if (oSRLicenseArray == null || oSRLicenseArray.length <= 0) {
            this.log.log(-2137614336, "LicenseCollectionService#copyLicensesAndSort: licenseList from DSI is empty");
        } else {
            for (int i2 = 0; i2 < oSRLicenseArray.length; ++i2) {
                String string;
                OSRLicense oSRLicense = oSRLicenseArray[i2];
                String string2 = oSRLicense.getName();
                if (string2 != null && !this.licensesBySymbolicName.containsKey(string2)) {
                    this.licensesBySymbolicName.put(string2, this.getLicensesForSymbolicName(string2, oSRLicenseArray));
                }
                if ((string = oSRLicense.getServiceID()) == null || this.licensesByServiceID.containsKey(string)) continue;
                this.licensesByServiceID.put(string, this.getLicensesForServiceID(string, oSRLicenseArray));
            }
        }
        this.isLicenseRequestRunning = false;
        this.handleESimLicense();
        this.processLicensesForOverview(false);
    }

    private void handleESimLicense() {
        this.log.log(1078071040, "LicenseCollectionService#handleESimLicense: called.");
        Object object = this.licensesBySymbolicName.get("esim");
        int n = 1;
        if (object == null) {
            this.log.log(1078071040, "LicenseCollectionService#handleESimLicense: no license for esim available");
            n = 5;
        } else if (object instanceof List) {
            n = this.extractLicenseState(object);
        }
        if (this.remoteHMIService != null && this.remoteHMIService.getRemoteHMIESimLicenseListener() != null) {
            this.remoteHMIService.getRemoteHMIESimLicenseListener().updateLicenseState(n);
        } else {
            this.log.log(-2137614336, "LicenseCollectionService#handleESimLicense: no remotehmiService or Interapp available");
        }
    }

    private int extractLicenseState(Object object) {
        int n;
        IRemoteHMILicense iRemoteHMILicense = (IRemoteHMILicense)((List)object).get(0);
        if (iRemoteHMILicense != null) {
            switch (iRemoteHMILicense.getState()) {
                case 4: {
                    n = 3;
                    break;
                }
                case 1: {
                    if (iRemoteHMILicense.getType() == 1) {
                        n = 2;
                        break;
                    }
                    n = 4;
                    break;
                }
                case 3: {
                    n = 5;
                    break;
                }
                default: {
                    n = 1;
                    break;
                }
            }
        } else {
            this.log.log(-2137614336, "LicenseCollectionService#extractLicenseState: license is null, using UNKNOWN STATE");
            n = 1;
        }
        this.log.log(1078071040, "LicenseCollectionService#extractLicenseState: sending updateLicenseState %1", (long)n);
        return n;
    }

    private DateTime parseCGWLicenseDate(String string) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmm");
        Date date = null;
        DateTime dateTime = new DateTime();
        try {
            date = simpleDateFormat.parse(string);
        }
        catch (ParseException parseException) {
            this.log.log(-2137614336, "LicenseCollectionService#parseCGWLicenseDate: expception while parsing license date %1", (Throwable)parseException);
        }
        if (date != null) {
            this.log.log(-2137614336, "LicenseCollectionService#parseCGWLicenseDate:  %1", (Object)date.toString());
            dateTime.setTime(date.getTime());
        }
        return dateTime;
    }

    protected IRemoteHMILicense convertCGWLicensetoRHMILicense(Service service) {
        if (service == null) {
            this.log.log(-1601830656, "LicenseCollectionService#convertCGWLicensetoRHMILicense: given service is null!");
            return null;
        }
        License license = service.getLicense();
        if (license == null) {
            this.log.log(-1601830656, "LicenseCollectionService#convertCGWLicensetoRHMILicense: given service is null!");
            return null;
        }
        String string = service.getName();
        String string2 = service.getId();
        int n = this.mapCGWLicenseState(license.getState());
        String string3 = license.getExpirationDate();
        String string4 = license.getActivationDate();
        boolean bl = service.hasExpirationWarning();
        this.log.log(1078071040, "LicenseCollectionService#addCGWLicenses: processing license for service with symbolicName %1 and serviceID %2 and licence %3", (Object)string, (Object)string2, (Object)license);
        if (string3.length() == 0 && n != 4 || string4.length() == 0) {
            this.log.log(-1601830656, "LicenseCollectionService#addCGWLicenses: License Date is invalid (empty) ExpirationDate %1, ActivationDate %2", (Object)string3, (Object)string4);
        }
        if (n == 4 && string3.length() == 0) {
            this.log.log(-1601830656, "LicenseCollectionService#addCGWLicenses: Expired Licences for Service %1, ignoring ExpDate!", (Object)service.getName());
            string4 = ((Object)string4.subSequence(0, "yyyyMMddHHmm".length())).toString();
        } else if (string3.length() != 0 && string4.length() != 0) {
            string3 = ((Object)string3.subSequence(0, "yyyyMMddHHmm".length())).toString();
            string4 = ((Object)string4.subSequence(0, "yyyyMMddHHmm".length())).toString();
        }
        DateTime dateTime = this.parseCGWLicenseDate(string3);
        DateTime dateTime2 = this.parseCGWLicenseDate(string4);
        return new IRemoteHMILicense(service.getId(), this.mapCGWLicenseState(license.getState()), dateTime2, dateTime, null, service.getId(), bl, service.getId(), null, this.mapCGWLicenseType(license.getState()));
    }

    protected void addCGWLicenses() {
        if (this.services == null || this.services.length < 0) {
            this.log.log(-2137614336, "LicenseCollectionService#addCGWLicenses: no CGW services available, skipping.");
            return;
        }
        for (int i2 = 0; i2 < this.services.length; ++i2) {
            Service service = this.services[i2];
            IRemoteHMILicense iRemoteHMILicense = this.convertCGWLicensetoRHMILicense(service);
            if (iRemoteHMILicense == null) {
                this.log.log(-1601830656, "LicenseCollectionService#addCGWLicenses: given remoteHMILicense is null! Skipping Entry %1", (Object)service.getName());
                continue;
            }
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(iRemoteHMILicense);
            this.licensesByServiceID.put(service.getId(), arrayList);
            String string = service.getName();
            if (string == null || string.length() <= 0) continue;
            this.licensesBySymbolicName.put(service.getName(), arrayList);
        }
    }

    private int mapCGWLicenseType(int n) {
        switch (n) {
            case 0: 
            case 1: 
            case 2: 
            case 3: 
            case 5: {
                return 0;
            }
            case 4: {
                return 1;
            }
        }
        return 0;
    }

    private int mapCGWLicenseState(int n) {
        switch (n) {
            case 2: {
                return 1;
            }
            case 3: {
                return 4;
            }
            case 5: {
                return 6;
            }
            case 1: {
                return 2;
            }
            case 0: {
                return 3;
            }
            case 4: {
                return 1;
            }
        }
        return 1;
    }

    private int mapOSRLicenseState(int n) {
        switch (n) {
            case 1: {
                return 1;
            }
            case 4: {
                return 4;
            }
            case 6: {
                return 6;
            }
            case 7: {
                return 7;
            }
            case 2: {
                return 2;
            }
            case 3: {
                return 3;
            }
            case 5: {
                return 5;
            }
        }
        return 1;
    }

    private int mapOSRLicenseType(int n) {
        switch (n) {
            case 2: {
                return 2;
            }
            case 0: {
                return 0;
            }
            case 1: {
                return 1;
            }
        }
        return 0;
    }

    private List getLicensesForSymbolicName(String string, OSRLicense[] oSRLicenseArray) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < oSRLicenseArray.length; ++i2) {
            OSRLicense oSRLicense = oSRLicenseArray[i2];
            if (oSRLicense == null || oSRLicense.getName() == null || !oSRLicense.getName().equals(string)) continue;
            if (this.remoteHMIService != null && !this.remoteHMIService.isTT()) {
                arrayList.add(new IRemoteHMILicense(oSRLicense.id, this.mapOSRLicenseState(oSRLicense.state), oSRLicense.activation, oSRLicense.expires, oSRLicense.duration, oSRLicense.serviceID, oSRLicense.warn, oSRLicense.name, oSRLicense.description, this.mapOSRLicenseType(oSRLicense.type)));
                continue;
            }
            arrayList.add(new IRemoteHMILicense(oSRLicense.id, this.mapOSRLicenseState(oSRLicense.state), oSRLicense.activation, oSRLicense.expires, oSRLicense.duration, oSRLicense.serviceID, oSRLicense.warn, oSRLicense.name, oSRLicense.description, this.mapOSRLicenseType(oSRLicense.type)));
        }
        return arrayList;
    }

    private List getLicensesForServiceID(String string, OSRLicense[] oSRLicenseArray) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < oSRLicenseArray.length; ++i2) {
            OSRLicense oSRLicense = oSRLicenseArray[i2];
            if (oSRLicense == null || oSRLicense.getServiceID() == null || !oSRLicense.getServiceID().equals(string)) continue;
            arrayList.add(new IRemoteHMILicense(oSRLicense.id, oSRLicense.state, oSRLicense.activation, oSRLicense.expires, oSRLicense.duration, oSRLicense.serviceID, oSRLicense.warn, oSRLicense.name, oSRLicense.description, oSRLicense.type));
        }
        return arrayList;
    }

    public String printAvailableLicenses() {
        Buffer buffer = new Buffer();
        Iterator iterator = this.licensesBySymbolicName.entrySet().iterator();
        while (iterator.hasNext()) {
            Map$Entry map$Entry = (Map$Entry)iterator.next();
            buffer.append(new StringBuffer().append("LICENSE: ").append(map$Entry.getKey()).append(" = ").append(map$Entry.getValue()).toString());
            buffer.append("\n");
        }
        return buffer.toString();
    }

    public String printAvailableLicensesByServiceID() {
        Buffer buffer = new Buffer();
        Iterator iterator = this.licensesByServiceID.entrySet().iterator();
        while (iterator.hasNext()) {
            Map$Entry map$Entry = (Map$Entry)iterator.next();
            buffer.append(new StringBuffer().append("LICENSE: ").append(map$Entry.getKey()).append(" = ").append(map$Entry.getValue()).toString());
            buffer.append("\n");
        }
        return buffer.toString();
    }

    public LinkedHashMap getLicensesByServiceID() {
        return this.licensesByServiceID;
    }

    public void refreshLicensesDependingOnServiceList() {
        this.log.log(-2137614336, "LicenseCollectionService#refreshLicensesDependingOnServiceList: serviceList state: %1", (Object)this.serviceListState);
        this.modelManager.setLicenseAvailableStatus(0);
        if (!this.isLicenseRequestRunning) {
            this.requestLicenses();
        } else {
            this.log.log(-2137614336, "LicenseCollectionService#refreshLicensesDependingOnServiceList: license request already running, waiting for response");
        }
    }

    public void sendToSouthside(OSRApplication[] oSRApplicationArray) {
        if (this.remoteHMIService != null) {
            this.log.log(-2137614336, "LicenseCollectionService#sendToSouthside: sending applications to southside");
            RemoteHMIAction remoteHMIAction = this.remoteHMIService.getAction(1320785920);
            remoteHMIAction.getParameters().put("OsrApplications", oSRApplicationArray);
            this.remoteHMIService.invokeAction(remoteHMIAction);
        }
    }

    public void requestApplicationList() {
        if (this.orsApplication == null) {
            this.log.log(-2137614336, "LicenseCollectionService#requestApplicationList: no OnlineServiceRegistrationSubsystem available");
            return;
        }
        OSRCommandList oSRCommandList = this.orsApplication.createCommandList();
        OSRGetOnlineApplicationListCommand oSRGetOnlineApplicationListCommand = new OSRGetOnlineApplicationListCommand(this);
        oSRCommandList.add(oSRGetOnlineApplicationListCommand);
        oSRCommandList.setErrorCommand(new LicenseCollectionService$5(this));
        oSRCommandList.execute("LicenseCollectionService#requestApplicationList.");
    }

    public void setLicensesFromCGW(Service[] serviceArray) {
        if (serviceArray == null || serviceArray.length <= 0) {
            this.log.log(-2137614336, "LicenseCollectionService#setLicensesFromCGW: services from CGW are empty");
            return;
        }
        this.log.log(-2137614336, "LicenseCollectionService#setLicensesFromCGW: setting licenses from CGW %1", (Object)serviceArray);
        this.licensesFromCGWDownloaded = true;
        this.services = serviceArray;
        this.addCGWLicenses();
        this.processLicensesForOverview(true);
    }

    public void updateServiceState(OnlineServiceListState onlineServiceListState) {
        if (!onlineServiceListState.isValid()) {
            this.log.log(10000, "LicenseCollectionService#updateServiceState: invalid update info");
            return;
        }
        if ((onlineServiceListState.isOnline() || onlineServiceListState.isOffline()) && !onlineServiceListState.isPending() && onlineServiceListState.isConnectivityAvailable() && !this.isLicenseRequestRunning) {
            this.requestLicenses();
        }
        this.log.log(-2137614336, "LicenseCollectionService#updateServiceState: updating serviceState from %1 to %2", (Object)this.serviceListState, (Object)onlineServiceListState);
        this.serviceListState = onlineServiceListState;
    }

    public void preCheckOnlineServiceSymbolicNameResponse(String string, OSRServiceState oSRServiceState) {
        if (string == null) {
            this.log.log(-1601830656, "LicenseCollectionService#preCheckOnlineServiceSymbolicNameResponse: appID is empty, showing errorscreen");
            this.modelManager.setServiceListDownloaded(3);
            return;
        }
        if (oSRServiceState != null) {
            this.log.log(1078071040, "LicenseCollectionService#preCheckOnlineServiceSymbolicNameResponse: received for appID %1: state %2", (Object)string, (Object)oSRServiceState);
            int n = oSRServiceState.getErrorCode();
            OSRLicense oSRLicense = null;
            if (oSRServiceState.getServiceListEntry() != null) {
                oSRLicense = oSRServiceState.getServiceListEntry().getLicense();
            } else {
                this.log.log(-1601830656, "LicenseCollectionService#preCheckOnlineServiceSymbolicNameResponse: servicelistentry is null! appID %1: state %2", (Object)string, (Object)oSRServiceState);
            }
            if (n == 0) {
                this.log.log(1078071040, "LicenseCollectionService#preCheckOnlineServiceSymbolicNameResponse: license for appID %1 is activated", (Object)string);
                this.modelManager.setServiceListDownloaded(0);
                this.indicateActiveLicense(oSRLicense);
            } else if (n == 24) {
                this.log.log(1078071040, "LicenseCollectionService#preCheckOnlineServiceSymbolicNameResponse: onlineService %1 is disabled, showing error screen", (Object)string);
                this.modelManager.setServiceListDownloaded(3);
            } else if (n == 3) {
                this.log.log(1078071040, "LicenseCollectionService#preCheckOnlineServiceSymbolicNameResponse: appID %1 not allowed to send any request, checking license", (Object)string);
                if (oSRLicense != null) {
                    IRemoteHMILicense iRemoteHMILicense = new IRemoteHMILicense(oSRLicense.id, oSRLicense.state, oSRLicense.activation, oSRLicense.expires, oSRLicense.duration, oSRLicense.serviceID, oSRLicense.warn, oSRLicense.name, oSRLicense.description, oSRLicense.type);
                    this.setLicenseDetailScreenForLicenseInclude(this.symbolicName, iRemoteHMILicense);
                } else {
                    this.log.log(1078071040, "LicenseCollectionService#preCheckOnlineServiceSymbolicNameResponse: no license available for app %1, showing service", (Object)string);
                    this.modelManager.setServiceListDownloaded(0);
                }
            } else if (n == 17) {
                this.log.log(1078071040, "LicenseCollectionService#preCheckOnlineServiceSymbolicNameResponse: serviceList could not be requested");
                this.modelManager.setServiceListDownloaded(3);
            } else {
                this.log.log(1078071040, "LicenseCollectionService#preCheckOnlineServiceSymbolicNameResponse: handling error code %1", (long)n);
                this.modelManager.setServiceListDownloaded(3);
            }
        } else {
            this.log.log(-1601830656, "LicenseCollectionService#preCheckOnlineServiceSymbolicNameResponse: OSRServiceState is null");
            this.modelManager.setServiceListDownloaded(3);
        }
    }

    public boolean isESimUsed() {
        return false;
    }

    public void preCheckOnlineServiceEsimResponse(String string, OSRServiceState oSRServiceState) {
        this.log.log(-1601830656, "LicenseCollectionService#preCheckOnlineServiceEsimResponse: called.");
        if (string == null) {
            this.log.log(-1601830656, "LicenseCollectionService#preCheckOnlineServiceEsimResponse: appID is empty, showing errorscreen");
            this.modelManager.setServiceListDownloaded(3);
            return;
        }
        if (oSRServiceState != null) {
            this.log.log(1078071040, "LicenseCollectionService#preCheckOnlineServiceEsimResponse: received for appID %1: state %2", (Object)string, (Object)oSRServiceState);
            int n = oSRServiceState.getErrorCode();
            if (n == 0) {
                this.log.log(1078071040, "LicenseCollectionService#preCheckOnlineServiceEsimResponse: license for appID %1 is activated", (Object)string);
                this.preCheckLicense(this.symbolicName, this.appID);
            } else if (n == 24) {
                this.log.log(1078071040, "LicenseCollectionService#preCheckOnlineServiceEsimResponse: onlineService %1 is disabled, showing error screen", (Object)this.appID);
                this.modelManager.setServiceListDownloaded(3);
            } else if (n == 3) {
                this.log.log(1078071040, "LicenseCollectionService#preCheckOnlineServiceEsimResponse: appID %1 not allowed to send any request, checking license", (Object)this.appID);
                OSRLicense oSRLicense = oSRServiceState.getServiceListEntry().getLicense();
                if (oSRLicense == null) {
                    this.log.log(1078071040, "LicenseCollectionService#preCheckOnlineServiceEsimResponse: no license available for app %1, showing service", (Object)this.appID);
                    this.modelManager.setServiceListDownloaded(0);
                }
            } else if (n == 17) {
                this.log.log(1078071040, "LicenseCollectionService#preCheckOnlineServiceEsimResponse: serviceList could not be requested");
                this.modelManager.setServiceListDownloaded(3);
            } else {
                this.log.log(1078071040, "LicenseCollectionService#preCheckOnlineServiceEsimResponse: handling error code %1", (long)n);
                this.modelManager.setServiceListDownloaded(3);
            }
        } else {
            this.log.log(-1601830656, "LicenseCollectionService#preCheckOnlineServiceEsimResponse: OSRServiceState is null");
            this.modelManager.setServiceListDownloaded(3);
        }
    }

    @Override
    public void remoteHmiDsiReady() {
        if (this.licensesByServiceID != null && !this.licensesByServiceID.isEmpty() && this.licensesBySymbolicName != null && !this.licensesBySymbolicName.isEmpty() && this.remoteHMIService != null) {
            RemoteHMIAction remoteHMIAction = this.remoteHMIService.getAction(1700);
            remoteHMIAction.getParameters().put("licensesByServiceID", this.licensesByServiceID);
            remoteHMIAction.getParameters().put("licensesBySymbolicName", this.licensesBySymbolicName);
            this.log.log(-2137614336, "LicenseCollectionService#remoteHmiDsiReady: sending CGW licenses to southside");
            this.remoteHMIService.invokeAction(remoteHMIAction);
        }
    }

    public void setLicenseOverviewEntered() {
        this.log.log(-2137614336, "LicenseCollectionService#setLicenseOverviewEntered: Called");
        this.isLicenseOverviewEntered = true;
    }

    public void setLicenseOverviewExited() {
        this.log.log(-2137614336, "LicenseCollectionService#setLicenseOverviewExited: Called");
        this.isLicenseOverviewEntered = false;
    }

    public boolean isLicenseOverviewEntered() {
        return this.isLicenseOverviewEntered;
    }

    protected abstract void indicateActiveLicense(OSRLicense oSRLicense) {
    }

    @Override
    public void languageChanged() {
        this.processLicensesForOverview(false);
    }

    static {
        licenses = new LicenseCollectionService$1();
    }
}

