/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.eni;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.interapp.bap.eni.BAPServiceENI;
import de.audi.atip.interapp.bap.eni.BAPServiceENIListener;
import de.audi.atip.interapp.bap.eni.data.Destination;
import de.audi.atip.interapp.bap.eni.data.License;
import de.audi.atip.interapp.bap.eni.data.MobileKeyCount;
import de.audi.atip.interapp.bap.eni.data.Monitorings;
import de.audi.atip.interapp.bap.eni.data.PrivacySetup;
import de.audi.atip.interapp.bap.eni.data.RemoteProcessState;
import de.audi.atip.interapp.bap.eni.data.Service;
import de.audi.atip.interapp.bap.eni.data.SupportedRemoteProcesses;
import de.audi.atip.interapp.bap.eni.data.User;
import de.audi.atip.interapp.bap.remoteservices.BAPServiceRemoteServices;
import de.audi.atip.interapp.bap.remoteservices.BAPServiceRemoteServicesListener;
import de.audi.atip.interapp.bap.remoteservices.data.MobileKeySetup;
import de.audi.atip.interapp.bap.remoteservices.data.VTANData;
import de.audi.atip.interapp.eni.ENIMobileKeyListener;
import de.audi.atip.interapp.eni.ENIMobileKeyStatusDisplayListener;
import de.audi.atip.interapp.eni.ENIServiceEcall;
import de.audi.atip.interapp.eni.ENIServiceEcallListener;
import de.audi.atip.interapp.eni.ENIServiceOnline;
import de.audi.atip.interapp.eni.ENIServiceOnlineListener;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ENIGateway
implements ENIServiceOnline,
ENIServiceEcall,
BAPServiceENIListener,
BAPServiceRemoteServicesListener {
    private static final int CATALOG_VERSION_UNKNOWN = -1;
    private static final int CATALOG_VERSION_NO_PRIVACY = 0;
    private static final int CATALOG_VERSION_PRIVACY = 1;
    private static final String ECALL_V1 = "ecall_v1";
    static final String VALET_ALERT = "valetalert";
    static final String SPEED_ALERT = "speedalert";
    static final String GEO_FENCE = "geofence";
    private static final int KEY_IS_EXPIRATION_WARNING_CONFIRMED = 1;
    private static final int KEY_IS_EXPIRED_CONFIRMED = 2;
    private static final boolean CONFIRMED = true;
    private static final boolean NOT_CONFIRMED = false;
    private static final int INVALID_LICENCE_DATA = -1;
    private final DispatcherBase dispatcher;
    private volatile boolean receivedUserList;
    private ENIServiceOnlineListener eniServiceOnlineListener;
    private ENIServiceEcallListener eniServiceEcallListener;
    private ENIMobileKeyListener eniMobileKeyListener;
    private ENIMobileKeyStatusDisplayListener eniMobileKeyStatusDisplayListener;
    private BAPServiceENI bapServiceENI;
    private BAPServiceRemoteServices remoteService;
    private Service serviceEcall;
    private final LogChannel logChannel;
    private IFrameworkAccess frameworkAccess;
    private boolean submitChangesToBackend = false;
    private boolean privacyModeFeatureAvailable = true;
    private int privacyModeSupported = -1;
    private PrivacySetup lastPrivacySetup = null;
    private Monitorings lastMonitorings = null;
    private Destination[] lastDestinations = null;
    private Service[] lastServiceList = null;
    private User[] lastUserList = null;
    private boolean lastFleetMode = true;
    private MobileKeySetup lastMobileKeySetup = null;
    private MobileKeyCount lastMobileKeyCount = null;
    private boolean isCgwUp = false;
    private Runnable pendingPrivacyTask = null;

    public ENIGateway(DispatcherBase dispatcherBase, LogChannel logChannel) {
        this.dispatcher = dispatcherBase;
        this.logChannel = logChannel;
    }

    public final void setBAPServiceENI(BAPServiceENI bAPServiceENI) {
        this.bapServiceENI = bAPServiceENI;
    }

    public final void setBAPServiceRemoteServices(BAPServiceRemoteServices bAPServiceRemoteServices) {
        this.remoteService = bAPServiceRemoteServices;
    }

    public final void triggerGetServiceList() {
        this.bapServiceENI.getServiceList();
    }

    public final void triggerGetDestinationList() {
        this.bapServiceENI.getDestinationList();
    }

    private void triggerGetUserList() {
        this.bapServiceENI.getUserList();
    }

    public final void setFrameworkAccess(IFrameworkAccess iFrameworkAccess) {
        this.frameworkAccess = iFrameworkAccess;
    }

    public final void onCommunicationUp() {
        this.dispatcher.execute(new Runnable(){

            public void run() {
                ENIGateway.this.logChannel.log(10000000, "[ENIGateway#onCommunicationUp]");
                ENIGateway.this.triggerGetServiceList();
                ENIGateway.this.triggerGetDestinationList();
                ENIGateway.this.triggerGetUserList();
            }
        });
        this.isCgwUp = true;
        if (this.pendingPrivacyTask != null) {
            this.logChannel.log(1000000, "[ENIGateway#onCommunicationUp] Trigger pending privacy task.");
            this.dispatcher.execute(this.pendingPrivacyTask);
        }
    }

    public void onRemoteProcessFinished(boolean bl) {
    }

    public void onSupportedRemoteProcesses(SupportedRemoteProcesses supportedRemoteProcesses) {
    }

    public final void onRemoteProcessState(RemoteProcessState remoteProcessState) {
        Integer n = new Integer(remoteProcessState.getRemoteProcessKind());
        Integer n2 = new Integer(remoteProcessState.getState());
        Integer n3 = new Integer(remoteProcessState.getExceptionState());
        this.logChannel.log(10000000, "ENIGateway#onRemoteProcessState: kind %1, state %2, exceptionState %3", (Object)n, (Object)n2, (Object)n3);
        switch (n) {
            case 5: {
                this.onRemoteProcessStateConfirmServiceExpiryWarning(remoteProcessState, n2, n3);
                break;
            }
            case 4: {
                this.onRemoteProcessStatePairMainUserUsingVehiclePin(remoteProcessState, n2, n3);
                break;
            }
            case 2: {
                this.onRemoteProcessStateDeleteUserList(remoteProcessState, n2, n3);
                break;
            }
            case 1: {
                this.onRemoteProcessStateUpdateUserList(remoteProcessState, n2, n3);
                break;
            }
            case 18: {
                this.onRemoteProcessPrivacyMode(remoteProcessState, n2, n3);
                break;
            }
            case 8: {
                this.eniMobileKeyListener.onRemoteProcessGetVtan(n2, n3);
                break;
            }
            case 0: {
                this.onIdleState(n2, n3);
                break;
            }
            default: {
                this.logChannel.log(1000000, "ENIGateway#onRemoteProcessState: kind %1, state %2, exceptionState %3 IGNORED", (Object)n, (Object)n2, (Object)n3);
            }
        }
    }

    private void onIdleState(Integer n, Integer n2) {
        this.logChannel.log(1000000, "ENIGateway#onIdleState state: %1", (Object)n);
        if (n == 1 || n == 0) {
            this.logChannel.log(1000000, "ENIGateway#onIdleState state idle or unknown");
            if (this.submitChangesToBackend) {
                this.logChannel.log(1000000, "ENIGateway#onIdleState submitting changes to backend");
                this.submitChangesToBackend = false;
                this.triggerSubmitChangesToBackend();
            } else if (this.eniServiceOnlineListener != null) {
                this.logChannel.log(1000000, "ENIGateway#onIdleState resetting the change-in-progress model");
                this.eniServiceOnlineListener.onRemoteProcessPrivacyModeReturnedToIdle();
            } else {
                this.logChannel.log(100000, "ENIGateway#onIdleState ignoring state %1; HMI startup possibly not finished yet", (Object)n);
            }
        }
    }

    private void onRemoteProcessPrivacyMode(RemoteProcessState remoteProcessState, Integer n, Integer n2) {
        if (n == 3) {
            this.logChannel.log(1000000, "ENIGateway#onRemoteProcessPrivacyMode: succeeded");
            this.submitChangesToBackend = true;
        }
    }

    private void onRemoteProcessStatePairMainUserUsingVehiclePin(RemoteProcessState remoteProcessState, Integer n, Integer n2) {
        int n3 = n2;
        if (this.eniServiceOnlineListener == null) {
            this.logChannel.log(100000, "ENIGateway#onRemoteProcessStatePairMainUserUsingVehiclePin: no online listener!");
        } else if (n == 3) {
            this.logChannel.log(1000000, "ENIGateway#onRemoteProcessStatePairMainUserUsingVehiclePin: succeeded");
            this.eniServiceOnlineListener.triggerMainUserSetUsingVehiclePINResponse(0, -1);
            this.triggerUpdateUserList();
        } else if (n3 == 15) {
            int n4 = remoteProcessState.getPinRetryRemainingCount();
            int n5 = n4 <= 0 ? 3 : 1;
            this.logChannel.log(1000000, "ENIGateway#onRemoteProcessStatePairMainUserUsingVehiclePin: wrong pin (remaining attempts: %1)", (Object)new Integer(n4));
            this.eniServiceOnlineListener.triggerMainUserSetUsingVehiclePINResponse(n5, n4);
        } else if (n3 == 10) {
            this.logChannel.log(1000000, "ENIGateway#onRemoteProcessStatePairMainUserUsingVehiclePin: myAudi Account not verified");
            this.eniServiceOnlineListener.triggerMainUserSetUsingVehiclePINResponse(4, 0);
        } else if (n3 != 0) {
            this.logChannel.log(1000000, "ENIGateway#onRemoteProcessStatePairMainUserUsingVehiclePin: generic error (exceptionState: %1)", (Object)n2);
            this.eniServiceOnlineListener.triggerMainUserSetUsingVehiclePINResponse(2, -1);
        } else {
            this.logChannel.log(1000000, "ENIGateway#onRemoteProcessStatePairMainUserUsingVehiclePin: pair main user with vehiclePIN: no action for state %1", (Object)n);
        }
    }

    private void onRemoteProcessStateDeleteUserList(RemoteProcessState remoteProcessState, Integer n, Integer n2) {
        if (this.eniServiceOnlineListener == null) {
            this.logChannel.log(100000, "ENIGateway#onRemoteProcessStateDeleteUserList: no online listener!");
        } else if (n == 3) {
            this.eniServiceOnlineListener.triggerMainUserResetResponse(true);
            this.logChannel.log(1000000, "ENIGateway#onRemoteProcessStateDeleteUserList: succeeded");
            this.triggerUpdateUserList();
            this.resetMonitoringStates();
        } else if (n2 != 0) {
            this.eniServiceOnlineListener.triggerMainUserResetResponse(false);
            this.logChannel.log(1000000, "ENIGateway#onRemoteProcessStateDeleteUserList: failed with exception state %1", (Object)n2);
        } else if (n == 4) {
            this.eniServiceOnlineListener.triggerMainUserResetResponse(false);
            this.logChannel.log(100000, "ENIGateway#onRemoteProcessStateDeleteUserList: failed with no exception state");
        } else {
            this.logChannel.log(1000000, "ENIGateway#onRemoteProcessStateDeleteUserList: state %1 ignored", (Object)n);
        }
    }

    private void onRemoteProcessStateUpdateUserList(RemoteProcessState remoteProcessState, Integer n, Integer n2) {
        if (this.eniServiceOnlineListener == null) {
            this.logChannel.log(100000, "ENIGateway#onRemoteProcessStateUpdateUserList: no online listener!");
        } else if (n == 3) {
            this.logChannel.log(1000000, "ENIGateway#onRemoteProcessStateUpdateUserList: succeeded");
            this.eniServiceOnlineListener.triggerUpdateUserListResponse(true);
        } else if (n2 != 0) {
            this.logChannel.log(1000000, "ENIGateway#onRemoteProcessStateUpdateUserList: failed with exception state %1", (Object)n2);
            this.eniServiceOnlineListener.triggerUpdateUserListResponse(false);
        } else if (n == 4) {
            this.logChannel.log(100000, "ENIGateway#onRemoteProcessStateUpdateUserList: failed with no exception state");
            this.eniServiceOnlineListener.triggerUpdateUserListResponse(false);
        } else {
            this.logChannel.log(1000000, "ENIGateway#onRemoteProcessStateUpdateUserList: state %1 ignored", (Object)n);
        }
    }

    private void onRemoteProcessStateConfirmServiceExpiryWarning(RemoteProcessState remoteProcessState, Integer n, Integer n2) {
        if (this.eniServiceEcallListener == null) {
            this.logChannel.log(100000, "ENIGateway#onRemoteProcessStateConfirmServiceExpiryWarning: no ecall listener!");
        } else if (n == 3) {
            this.logChannel.log(1000000, "ENIGateway#onRemoteProcessStateConfirmServiceExpiryWarning: succeeded (no listener method defined)");
        } else {
            this.logChannel.log(100000, "ENIGateway#onRemoteProcessStateConfirmServiceExpiryWarning: failed (no listener method defined)");
        }
    }

    public final void onServiceList(final Service[] serviceArray) {
        this.logChannel.log(1000000, "ENIGateway#onServiceList %1", (Object)serviceArray);
        this.lastServiceList = serviceArray;
        this.dispatcher.execute(new Runnable(){

            public void run() {
                ENIGateway.this.logChannel.log(1000000, "ENIGateway#onServiceList: received %1 services", serviceArray == null ? -1L : (long)serviceArray.length);
                if (ENIGateway.this.eniServiceOnlineListener != null) {
                    ENIGateway.this.eniServiceOnlineListener.onServiceList(serviceArray);
                }
                ENIGateway.this.extractEcallLicence();
                ENIGateway.this.handleEcallLicenceWarning();
                ENIGateway.this.handleEcallPrivacyDisclaimer();
                ENIGateway.this.handleAlertServices();
            }
        });
    }

    private void handleEcallPrivacyDisclaimer() {
        if (this.eniServiceEcallListener == null) {
            this.logChannel.log(100000, "ENIGateway#handleEcallPrivacyDisclaimer: eniServiceEcallListener is null!");
            return;
        }
        if (this.serviceEcall == null) {
            this.logChannel.log(100000, "ENIGateway#handleEcallPrivacyDisclaimer: serviceEcall is null!");
            return;
        }
        boolean bl = this.serviceEcall.isDisablingByDriverAllowed();
        this.setEcallPrivacyDisclaimerTextVisible(!bl);
    }

    private void setEcallPrivacyDisclaimerTextVisible(boolean bl) {
        this.eniServiceEcallListener.setEcallPrivacyDisclaimerTextVisible(bl);
    }

    private void handleAlertServices() {
        if (this.lastServiceList == null) {
            this.logChannel.log(100000, "ENIGateway#handleAlertServices: no services array available");
            return;
        }
        boolean bl = false;
        boolean bl2 = false;
        boolean bl3 = false;
        for (int i2 = 0; i2 < this.lastServiceList.length; ++i2) {
            Service service = this.lastServiceList[i2];
            if (service.isDisablingByDriverAllowed()) continue;
            if (service.getId().startsWith(GEO_FENCE)) {
                bl = true;
                continue;
            }
            if (service.getId().startsWith(VALET_ALERT)) {
                bl3 = true;
                continue;
            }
            if (!service.getId().startsWith(SPEED_ALERT)) continue;
            bl2 = true;
        }
        this.setAlertServicesPrivacyDisclaimerTextVisible(bl || bl3 || bl2);
    }

    private void setAlertServicesPrivacyDisclaimerTextVisible(boolean bl) {
        if (this.eniServiceOnlineListener != null) {
            this.eniServiceOnlineListener.setAlertServicesPrivacyDisclaimerTextVisible(bl);
        } else {
            this.logChannel.log(100000, "ENIGateway#setAlertServicesPrivacyDisclaimerTextVisible: no listener to set the disclaimer on; the service list came too soon and no alert disclaimers in the privacy mode popup are going to visible until the next service list update");
        }
    }

    private void extractEcallLicence() {
        this.serviceEcall = null;
        if (this.lastServiceList == null) {
            this.logChannel.log(100000, "ENIGateway#extractEcallLicence: no services array available");
            return;
        }
        for (int i2 = 0; i2 < this.lastServiceList.length; ++i2) {
            if (!this.lastServiceList[i2].getId().equals(ECALL_V1)) continue;
            this.logChannel.log(1000000, "ENIGateway#extractEcallLicence: found valid licence entry %1", (Object)ECALL_V1);
            this.serviceEcall = this.lastServiceList[i2];
            return;
        }
        this.logChannel.log(100000, "ENIGateway#extractEcallLicence: services array doesn't contain %1", (Object)ECALL_V1);
    }

    protected final void handleEcallLicenceWarning() {
        if (this.eniServiceEcallListener == null) {
            this.logChannel.log(100000, "ENIGateway#handleEcallLicenceWarning: eniServiceEcallListener is null!");
            return;
        }
        if (this.serviceEcall == null) {
            this.logChannel.log(100000, "ENIGateway#handleEcallLicenceWarning: serviceEcall is null!");
            return;
        }
        if (!this.serviceEcall.isEnabled()) {
            this.logChannel.log(1000000, "ENIGateway#handleEcallLicenceWarning: ecall service is not enabled");
            return;
        }
        License license = this.serviceEcall.getLicense();
        if (license == null) {
            this.logChannel.log(100000, "ENIGateway#handleEcallLicenceWarning: ecall service does not contain a licence!");
            return;
        }
        boolean bl = this.serviceEcall.hasExpirationWarning();
        boolean bl2 = license.getState() == 4;
        boolean bl3 = license.getState() == 3;
        boolean bl4 = this.isNewLicense(license, bl);
        if (bl4) {
            this.setENIBoolean(1, false);
            this.setENIBoolean(2, false);
        }
        boolean bl5 = this.getENIBoolean(1);
        boolean bl6 = this.getENIBoolean(2);
        if (bl3 && !bl6) {
            this.logChannel.log(100000, "ENIGateway#handleEcallLicenceWarning: ecall service licence is expired!");
            this.eniServiceEcallListener.onLicenceExpired();
            return;
        }
        if (bl && !bl5) {
            String string = license.getExpirationDate();
            int n = this.calculateLicenceDuration(string);
            if (n != -1) {
                this.logChannel.log(1000000, "ENIGateway#handleEcallLicenceWarning: ecall service expires in %1 days", (Object)new Integer(n));
                this.eniServiceEcallListener.onExpirationWarning(bl2, n, false);
            }
        } else {
            this.logChannel.log(1000000, "ENIGateway#handleEcallLicenceWarning: ecall service has no expiration warning");
            return;
        }
    }

    private void resetMonitoringStates() {
        this.eniServiceOnlineListener.onMonitorings(0, 0, 0);
    }

    private void setENIBoolean(int n, boolean bl) {
        this.frameworkAccess.getStorageMgr().setBoolean(1024, n, bl);
    }

    private boolean getENIBoolean(int n) {
        return this.frameworkAccess.getStorageMgr().getBoolean(1024, n, false);
    }

    private boolean isNewLicense(License license, boolean bl) {
        return license.getState() == 4 && !bl || license.getState() == 2 && !bl;
    }

    private int calculateLicenceDuration(String string) {
        long l = this.frameworkAccess.getKombiTime();
        try {
            String string2 = string;
            if (string2.endsWith("Z")) {
                string2 = string2.substring(0, string2.length() - 1);
            }
            long l2 = new SimpleDateFormat("yyyyMMddHHmm").parse(string2).getTime();
            this.logChannel.log(1000000, "ENIGateway#handleEcallLicenceWarning: ecall service expires at %1 (%2)", (Object)Long.toString(l2), (Object)string2);
            double d2 = l2 - l;
            int n = (int)Math.floor(d2 / 8.64E7);
            this.logChannel.log(1000000, "ENIGateway#handleEcallLicenceWarning: expires: %1, kombi: %2, duration: %3, days: %4", (Object)Long.toString(l2), (Object)Long.toString(l), (Object)Double.toString(d2), (Object)Integer.toString(n));
            return n;
        }
        catch (ParseException parseException) {
            this.logChannel.log(100000, "ENIGateway#handleEcallLicenceWarning: couldn't parse date %1", (Object)string);
            return -1;
        }
    }

    public final void onUserList(final User[] userArray) {
        this.logChannel.log(1000000, "ENIGateway#onUserList %1", (Object)userArray);
        this.lastUserList = userArray;
        this.receivedUserList = true;
        this.dispatcher.execute(new Runnable(){

            public void run() {
                ENIGateway.this.logChannel.log(1000000, "ENIGateway#onUserList: received %1 users", userArray == null ? -1L : (long)userArray.length);
                if (ENIGateway.this.eniServiceOnlineListener != null) {
                    ENIGateway.this.eniServiceOnlineListener.onUserList(userArray);
                }
            }
        });
    }

    public final boolean hasReceivedUserList() {
        return this.receivedUserList;
    }

    public final void onDestinationList(Destination[] destinationArray) {
        this.logChannel.log(1000000, "ENIGateway#onDestinationList: received %1 destinations", destinationArray == null ? -1L : (long)destinationArray.length);
        this.lastDestinations = destinationArray;
        this.processDestinations();
    }

    public void processDestinations() {
        this.dispatcher.execute(new Runnable(){

            public void run() {
                if (ENIGateway.this.lastDestinations == null || ENIGateway.this.lastDestinations != null && ENIGateway.this.lastDestinations.length == 0) {
                    ENIGateway.this.logChannel.log(100000, "ENIGateway#onDestinationList: given destinations NULL");
                    return;
                }
                if (ENIGateway.this.lastDestinations.length > 1) {
                    ENIGateway.this.logChannel.log(100000, "ENIGateway#onDestinationList: given destinations > 1");
                }
                Destination destination = ENIGateway.this.lastDestinations[0];
                if (ENIGateway.this.eniServiceEcallListener != null) {
                    ENIGateway.this.eniServiceEcallListener.onDestination(destination);
                    ENIGateway.this.logChannel.log(1000000, "ENIGateway#onDestinationList: Deleting given destination %1 on CGW", (Object)ENIGateway.this.lastDestinations[0]);
                    ENIGateway.this.bapServiceENI.deleteDestination(destination);
                }
            }
        });
    }

    public final void onMonitorings(Monitorings monitorings) {
        this.logChannel.log(1000000, "ENIGateway#onMonitorings: Called!");
        if (monitorings == null) {
            this.logChannel.log(100000, "ENIGateway#onMonitorings: given monitorings NULL");
            return;
        }
        this.logChannel.log(1000000, "ENIGateway#onMonitorings: storing monitorings in local Variable %1.", (Object)monitorings);
        this.lastMonitorings = monitorings;
        if (this.eniServiceOnlineListener == null) {
            this.logChannel.log(100000, "ENIGateway#onMonitorings: listener is not ready, will be called later.");
        } else {
            this.sendMonitoringsToOnlineListener();
        }
    }

    private void sendMonitoringsToOnlineListener() {
        this.logChannel.log(10000000, "ENIGateway#sendMonitoringsToOnlineListener");
        this.eniServiceOnlineListener.onMonitorings(this.lastMonitorings.isGeofenceEnabled() ? 1 : 0, this.lastMonitorings.isSpeedAlertEnabled() ? 1 : 0, this.lastMonitorings.isValetAlertEnabled() ? 1 : 0);
    }

    public final void onPrivacySetup(final PrivacySetup privacySetup) {
        this.logChannel.log(1000000, "ENIGateway#onPrivacySetup: %1 ", (Object)privacySetup);
        this.lastPrivacySetup = privacySetup;
        this.dispatcher.execute(new Runnable(){

            public void run() {
                ENIGateway.this.logChannel.log(1000000, "ENIGateway#onPrivacySetup: received %1 ", (Object)privacySetup.toString());
                if (ENIGateway.this.eniServiceOnlineListener != null) {
                    ENIGateway.this.eniServiceOnlineListener.onPrivacySetup(privacySetup);
                }
            }
        });
    }

    public final void setEniServiceOnlineListener(final ENIServiceOnlineListener eNIServiceOnlineListener) {
        this.dispatcher.execute(new Runnable(){

            public void run() {
                ENIGateway.this.logChannel.log(1000000, "ENIGateway#registerOnlineListener privacyModeSupported=%1", (long)ENIGateway.this.privacyModeSupported);
                ENIGateway.this.eniServiceOnlineListener = eNIServiceOnlineListener;
                if (ENIGateway.this.privacyModeSupported != -1) {
                    eNIServiceOnlineListener.updatePrivacyModeFeatureAvailable(ENIGateway.this.privacyModeSupported == 1);
                }
                if (ENIGateway.this.lastMonitorings != null) {
                    ENIGateway.this.sendMonitoringsToOnlineListener();
                }
                if (ENIGateway.this.lastUserList != null) {
                    eNIServiceOnlineListener.onUserList(ENIGateway.this.lastUserList);
                }
                if (ENIGateway.this.lastServiceList != null) {
                    eNIServiceOnlineListener.onServiceList(ENIGateway.this.lastServiceList);
                }
                if (ENIGateway.this.lastPrivacySetup != null) {
                    eNIServiceOnlineListener.onPrivacySetup(ENIGateway.this.lastPrivacySetup);
                }
            }
        });
    }

    public final void registerMobileKeyListener(final ENIMobileKeyListener eNIMobileKeyListener) {
        this.dispatcher.execute(new Runnable(){

            public void run() {
                ENIGateway.this.eniMobileKeyListener = eNIMobileKeyListener;
                if (ENIGateway.this.lastMobileKeyCount != null) {
                    eNIMobileKeyListener.onMobileDeviceKeyCount(ENIGateway.this.lastMobileKeyCount);
                }
            }
        });
    }

    public void registerMobileKeyStatusDisplayListener(final ENIMobileKeyStatusDisplayListener eNIMobileKeyStatusDisplayListener) {
        this.dispatcher.execute(new Runnable(){

            public void run() {
                ENIGateway.this.eniMobileKeyStatusDisplayListener = eNIMobileKeyStatusDisplayListener;
                eNIMobileKeyStatusDisplayListener.onFleetModeAvailability(ENIGateway.this.lastFleetMode);
                if (ENIGateway.this.lastMobileKeySetup != null) {
                    eNIMobileKeyStatusDisplayListener.onMobDevKeySetup(ENIGateway.this.lastMobileKeySetup);
                }
                if (ENIGateway.this.lastMobileKeyCount != null) {
                    eNIMobileKeyStatusDisplayListener.onMobileDeviceKeyCount(ENIGateway.this.lastMobileKeyCount);
                }
            }
        });
    }

    public final void registerEcallListener(ENIServiceEcallListener eNIServiceEcallListener) {
        this.eniServiceEcallListener = eNIServiceEcallListener;
        if (this.lastDestinations != null) {
            this.processDestinations();
        }
        this.dispatcher.execute(new Runnable(){

            public void run() {
                ENIGateway.this.handleEcallLicenceWarning();
            }
        });
    }

    public final void triggerUpdateUserList() {
        if (this.eniServiceOnlineListener != null) {
            this.logChannel.log(1000000, "ENIGateway#triggerUpdateUserList: using remoteProcessUserlist to get current Userlist!");
            this.bapServiceENI.remoteProcessUpdateUserList();
        } else {
            this.logChannel.log(10000, "ENIGateway#triggerUpdateUserList: using getUserList to get current Userlist!");
            this.bapServiceENI.getUserList();
        }
    }

    public final void triggerPairMainUserUsingVehiclePIN(final String string, final String string2) {
        this.dispatcher.execute(new Runnable(){

            public void run() {
                ENIGateway.this.bapServiceENI.remoteProcessPairMainUserUsingVehiclePin(string, string2);
            }
        });
    }

    public final void triggerMainUserReset() {
        this.dispatcher.execute(new Runnable(){

            public void run() {
                ENIGateway.this.bapServiceENI.remoteProcessDeleteUserList();
            }
        });
    }

    public final void enableService(final Service service) {
        this.dispatcher.execute(new Runnable(){

            public void run() {
                ENIGateway.this.bapServiceENI.enableService(service);
            }
        });
    }

    public final void disableService(final Service service) {
        this.dispatcher.execute(new Runnable(){

            public void run() {
                ENIGateway.this.bapServiceENI.disableService(service);
            }
        });
    }

    public final void confirmExpirationWarning() {
        this.dispatcher.execute(new Runnable(){

            public void run() {
                ENIGateway.this.setENIBoolean(1, true);
                ENIGateway.this.bapServiceENI.remoteProcessConfirmExpirationWarningForService(ENIGateway.this.serviceEcall);
            }
        });
    }

    public final void confirmEcallExpirated() {
        this.dispatcher.execute(new Runnable(){

            public void run() {
                ENIGateway.this.setENIBoolean(2, true);
                ENIGateway.this.bapServiceENI.remoteProcessConfirmExpirationWarningForService(ENIGateway.this.serviceEcall);
            }
        });
    }

    public final void triggerPrivacyMode(final boolean bl) {
        if (!this.privacyModeFeatureAvailable) {
            this.logChannel.log(10000, "ENIGateway#triggerPrivacyMode: Privacy mode feature is not available! Call is ignored.");
            return;
        }
        Runnable runnable = new Runnable(){

            public void run() {
                ENIGateway.this.bapServiceENI.remoteProcessPrivacyMode(bl);
            }
        };
        if (this.isCgwUp) {
            this.logChannel.log(1000000, "[ENIGateway#onCommunicationUp] Trigger privacy: %1", bl);
            this.dispatcher.execute(runnable);
        } else {
            this.logChannel.log(1000000, "[ENIGateway#onCommunicationUp] cGW not up. Wait for privacy switch to %1.", bl);
            this.pendingPrivacyTask = runnable;
        }
    }

    public final void triggerSubmitChangesToBackend() {
        if (!this.privacyModeFeatureAvailable) {
            this.logChannel.log(10000, "ENIGateway#triggerSubmitChangesToBackend: Privacy mode feature is not available! Call is ignored.");
            return;
        }
        this.dispatcher.execute(new Runnable(){

            public void run() {
                ENIGateway.this.bapServiceENI.remoteProcessSubmitChangesToBackend();
            }
        });
    }

    public void onMobDevKeySetup(MobileKeySetup mobileKeySetup) {
        this.logChannel.log(10000000, "ENIGateway#onMobDevKeySetup mobileKeySetup: %1", (Object)mobileKeySetup);
        this.lastMobileKeySetup = mobileKeySetup;
        if (this.eniMobileKeyStatusDisplayListener != null) {
            this.eniMobileKeyStatusDisplayListener.onMobDevKeySetup(mobileKeySetup);
        } else {
            this.logChannel.log(1000000, "ENIGateway#onMobDevKeySetup no remote service");
        }
    }

    public void enableMobileDeviceKey() {
        this.logChannel.log(10000000, "ENIGateway#enableMobileDeviceKey");
        if (this.remoteService != null) {
            this.remoteService.enableMobileDeviceKey();
        } else {
            this.logChannel.log(10000, "ENIGateway#enableMobileDeviceKey no remote service, maybe AppBAPRemoteServices hasn't started yet");
        }
    }

    public void disableMobileDeviceKey() {
        this.logChannel.log(10000000, "ENIGateway#disableMobileDeviceKey");
        if (this.remoteService != null) {
            this.remoteService.disableMobileDeviceKey();
        } else {
            this.logChannel.log(10000, "ENIGateway#disableMobileDeviceKey no remote service, maybe AppBAPRemoteServices hasn't started yet");
        }
    }

    public void onFleetModeAvailability(boolean bl) {
        this.logChannel.log(10000000, "ENIGateway#onFleetModeAvailability fleetModeEnabled: %1", bl);
        this.lastFleetMode = bl;
        if (this.eniMobileKeyStatusDisplayListener != null) {
            this.eniMobileKeyStatusDisplayListener.onFleetModeAvailability(bl);
        } else {
            this.logChannel.log(1000000, "ENIGateway#onFleetModeAvailability no remote service");
        }
    }

    public void onMobileDeviceKeyCount(MobileKeyCount mobileKeyCount) {
        this.logChannel.log(10000000, "ENIGateway#onMobileDeviceKeyCount keyCount: %1", (Object)mobileKeyCount);
        this.lastMobileKeyCount = mobileKeyCount;
        if (this.eniMobileKeyStatusDisplayListener != null) {
            this.eniMobileKeyStatusDisplayListener.onMobileDeviceKeyCount(mobileKeyCount);
        } else {
            this.logChannel.log(1000000, "ENIGateway#onMobileDeviceKeyCount no eniMobileKeyStatusDisplayListener service");
        }
        if (this.eniMobileKeyListener != null) {
            this.eniMobileKeyListener.onMobileDeviceKeyCount(mobileKeyCount);
        } else {
            this.logChannel.log(1000000, "ENIGateway#onMobileDeviceKeyCount no eniMobileKeyListener service");
        }
    }

    public void requestMobileDeviceKeyCount() {
        this.logChannel.log(10000000, "ENIGateway#requestMobileDeviceKeyCount");
        if (this.bapServiceENI != null) {
            this.bapServiceENI.remoteProcessGetMobileDeviceKeyCount();
        } else {
            this.logChannel.log(10000, "ENIGateway#requestMobileDeviceKeyCount no remote service, maybe AppBAPENI hasn't started yet");
        }
    }

    public void onVtanDataEncrypted(String string) {
        this.logChannel.log(10000000, "ENIGateway#onVtanDataEncrypted");
        if (this.eniMobileKeyListener != null) {
            this.eniMobileKeyListener.onVtanDataEncrypted(string);
        } else {
            this.logChannel.log(10000, "ENIGateway#onVtanDataEncrypted no remote service, maybe AppOnline hasn't started yet");
        }
    }

    public void onVTANAuthDataFinished(boolean bl, String string) {
        this.logChannel.log(10000000, "ENIGateway#onVTANAuthDataFinished");
        if (this.eniMobileKeyListener != null) {
            this.eniMobileKeyListener.onVTANAuthDataFinished(bl, string);
        } else {
            this.logChannel.log(10000, "ENIGateway#onVTANAuthDataFinished no remote service, maybe AppOnline hasn't started yet");
        }
    }

    public void onVTANDecryptionFinished(boolean bl, VTANData vTANData) {
        this.logChannel.log(10000000, "ENIGateway#onVTANDecryptionFinished");
        if (this.eniMobileKeyListener != null) {
            this.eniMobileKeyListener.onVTANDecryptionFinished(bl, vTANData);
        } else {
            this.logChannel.log(10000, "ENIGateway#onVTANDecryptionFinished no remote service, maybe AppOnline hasn't started yet");
        }
    }

    public void startVTANAuthData() {
        this.logChannel.log(10000000, "ENIGateway#startVTANAuthData");
        if (this.remoteService != null) {
            this.remoteService.startVTANAuthData();
        } else {
            this.logChannel.log(10000, "ENIGateway#startVTANAuthData no remote service, maybe AppBAPRemoteServices hasn't started yet");
        }
    }

    public void remoteProcessGetVtan(String string) {
        this.logChannel.log(10000000, "ENIGateway#remoteProcessGetVtan");
        if (this.bapServiceENI != null) {
            this.bapServiceENI.remoteProcessGetVtan(string);
        } else {
            this.logChannel.log(10000, "ENIGateway#remoteProcessGetVtan no remote service, maybe AppBAPENI hasn't started yet");
        }
    }

    public void startVTANDecryption(String string) {
        this.logChannel.log(10000000, "ENIGateway#startVTANDecryption");
        if (this.remoteService != null) {
            this.remoteService.startVTANDecryption(string);
        } else {
            this.logChannel.log(10000, "ENIGateway#startVTANDecryption no remote service, maybe AppBAPRemoteServices hasn't started yet");
        }
    }

    public void setPrivacyModeFeatureAvailable(boolean bl) {
        this.logChannel.log(10000000, "ENIGateway#setPrivacyModeFeatureAvailable %1", bl);
        this.privacyModeFeatureAvailable = bl;
    }

    public void onPrivacyModeSupported(boolean bl) {
        this.logChannel.log(10000000, "ENIGateway#onPrivacyModeSupported %1", bl);
        this.privacyModeSupported = bl ? 1 : 0;
        this.privacyModeFeatureAvailable = bl;
        if (this.eniServiceOnlineListener != null) {
            this.eniServiceOnlineListener.updatePrivacyModeFeatureAvailable(bl);
        } else {
            this.logChannel.log(1000000, "ENIGateway#onPrivacyModeSupported: Catalog version received before Online is available.");
        }
    }
}

