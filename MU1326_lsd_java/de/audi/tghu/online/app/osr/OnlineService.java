/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr;

import de.audi.atip.interapp.online.IOnlineService;
import de.audi.atip.interapp.online.IOnlineServiceListener;
import de.audi.atip.interapp.online.OnlineServiceListState;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.online.app.osr.OnlineServiceRegistrationHelper;
import de.audi.tghu.online.app.osr.OnlineServiceRegistrationSubsystem;
import de.audi.tghu.online.app.osr.command.AbstractOSRCommand;
import de.audi.tghu.online.app.osr.command.OSRActivateLicenseCommand;
import de.audi.tghu.online.app.osr.command.OSRCommandList;
import de.audi.tghu.online.app.osr.command.OSRGetOnlineApplicationCommand;
import de.audi.tghu.online.app.osr.command.OSRPOnlineApplicationPreCheck;
import de.audi.tghu.online.app.osr.command.OSRSetApplicationPropertiesCommand;
import de.audi.tghu.online.app.osr.command.OSRSetOnlineApplicationStateCommand;
import de.audi.tghu.online.app.osr.command.OSRWaitCommand;
import de.audi.tghu.online.app.osr.license.LicenseCollectionService;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.dsi.ifc.online.OSRApplication;
import org.dsi.ifc.online.OSRApplicationProperties;
import org.dsi.ifc.online.OSRLicense;
import org.dsi.ifc.online.OSRNotifyProperties;
import org.dsi.ifc.online.OSRServiceState;
import org.osgi.framework.ServiceRegistration;

public class OnlineService
implements IOnlineService {
    private String applicationId;
    private final OnlineServiceRegistrationSubsystem system;
    private LogChannel logChannel;
    private ServiceRegistration serviceRegistration = null;
    private OSRApplication onlineApplication = null;
    private OSRNotifyProperties properties = null;
    private List serviceCallbacks = null;
    private int onlineApplicationState = 0;
    private boolean roamingActive;

    public OnlineService(String string, OnlineServiceRegistrationSubsystem onlineServiceRegistrationSubsystem) {
        this.applicationId = string;
        this.system = onlineServiceRegistrationSubsystem;
        this.logChannel = onlineServiceRegistrationSubsystem.getLogChannel();
        this.serviceCallbacks = new LinkedList();
    }

    public void setOnlineApplicationState(int n, IOnlineServiceListener iOnlineServiceListener) {
        this.logChannel.log(10000000, "[OnlineService#setOnlineApplicationState] application:%1 state:%2 ", (Object)this.applicationId, (long)n);
        this.onlineApplicationState = n;
        int n2 = n == 1 ? 3 : 0;
        this.logChannel.log(10000000, "[OnlineService#setOnlineApplicationState] application:%1 stateWithRoaming:%2 ", (Object)this.applicationId, (long)n2);
        OSRCommandList oSRCommandList = this.system.createCommandList(1);
        oSRCommandList.add(new OSRSetOnlineApplicationStateCommand(this.applicationId, n2, iOnlineServiceListener));
        oSRCommandList.execute("ORSMediator#setOnlineApplicationState");
    }

    private int determineRoamingState(int n) {
        if (!this.roamingActive) {
            return n;
        }
        return n | 2;
    }

    public void activateLicense(final IOnlineServiceListener iOnlineServiceListener) {
        this.logChannel.log(10000000, "[OnlineService#activateLicense] application:%1", (Object)this.applicationId);
        OSRCommandList oSRCommandList = this.system.createCommandList();
        oSRCommandList.setErrorCommand(new AbstractOSRCommand("ErrorCommand"){

            public void execute() {
                OnlineService.this.logChannel.log(100000, "[OnlineService#activateLicense] error occured for application:%1", (Object)OnlineService.this.applicationId);
                String string = (String)this.getCommandList().get("LICENSE_RESPONSE_SENT");
                if (string != null && string.equals("true")) {
                    OnlineService.this.logChannel.log(10000000, "[OnlineService#activateLicense] notifying callback handler that error occured");
                    iOnlineServiceListener.activateLicenseResponse(6);
                }
                this.getCommandList().commandFinished();
            }

            public void updateServiceList(OSRServiceState[] oSRServiceStateArray, int n) {
            }
        });
        OSRLicense[] oSRLicenseArray = this.onlineApplication.getLicenseList();
        if (oSRLicenseArray != null) {
            for (int i2 = 0; i2 < oSRLicenseArray.length; ++i2) {
                OSRLicense oSRLicense = oSRLicenseArray[i2];
                if (oSRLicense.getState() != 2) continue;
                this.logChannel.log(10000000, "[OnlineService#activateLicense] found activatable license with id: %1", (Object)oSRLicense.getId());
                final OSRActivateLicenseCommand oSRActivateLicenseCommand = new OSRActivateLicenseCommand(this.applicationId, oSRLicense);
                oSRCommandList.add(oSRActivateLicenseCommand);
                oSRCommandList.add(new AbstractOSRCommand("TagCommand"){

                    public void execute() {
                        this.getCommandList().put("LICENSE_RESPONSE_SENT", "true");
                        this.getCommandList().commandFinished();
                    }

                    public void updateServiceList(OSRServiceState[] oSRServiceStateArray, int n) {
                    }
                });
                oSRCommandList.add(new OSRGetOnlineApplicationCommand(this.applicationId, iOnlineServiceListener));
                oSRCommandList.add(new AbstractOSRCommand("call callback"){

                    public void execute() {
                        OnlineService.this.logChannel.log(1000000, "[OnlineService#activateLicense] delegating license information (%2) for application (%1)", (Object)OnlineService.this.applicationId, (long)oSRActivateLicenseCommand.getLicenseStatus());
                        iOnlineServiceListener.activateLicenseResponse(oSRActivateLicenseCommand.getLicenseStatus());
                        this.getCommandList().commandFinished();
                    }

                    public void updateServiceList(OSRServiceState[] oSRServiceStateArray, int n) {
                    }
                });
                break;
            }
        }
        oSRCommandList.execute("ORSMediator#activateLicense");
    }

    public void setReminderState(int n, final IOnlineServiceListener iOnlineServiceListener) {
        this.logChannel.log(10000000, "[OnlineService#setReminderState] application:%1 reminderStatus:%2", (Object)this.applicationId, (long)n);
        OSRCommandList oSRCommandList = this.system.createCommandList();
        oSRCommandList.setErrorCommand(new AbstractOSRCommand("ErrorCommand"){

            public void execute() {
                OnlineService.this.logChannel.log(10000000, "[OnlineService#setReminderState] error occured for application:%1", (Object)OnlineService.this.applicationId);
                iOnlineServiceListener.setReminderStateResponse(0);
                this.getCommandList().commandFinished();
            }

            public void updateServiceList(OSRServiceState[] oSRServiceStateArray, int n) {
            }
        });
        OSRApplicationProperties[] oSRApplicationPropertiesArray = OnlineServiceRegistrationHelper.changeReminderProperty(this.onlineApplication.getPropertyList(), n);
        OSRSetApplicationPropertiesCommand oSRSetApplicationPropertiesCommand = new OSRSetApplicationPropertiesCommand(this.applicationId, oSRApplicationPropertiesArray);
        oSRCommandList.add(oSRSetApplicationPropertiesCommand);
        oSRCommandList.add(new AbstractOSRCommand("call callback handler"){

            public void execute() {
                OnlineService.this.logChannel.log(10000000, "[OnlineService#setReminderState] application:%1 delegating reminder status", (Object)OnlineService.this.applicationId);
                int n = OnlineServiceRegistrationHelper.getReminderStatus(OnlineService.this.onlineApplication, OnlineService.this.logChannel);
                iOnlineServiceListener.setReminderStateResponse(n);
                this.getCommandList().commandFinished();
            }

            public void updateServiceList(OSRServiceState[] oSRServiceStateArray, int n) {
            }
        });
        oSRCommandList.execute("ORSMediator#setReminderState");
    }

    public void getLicenseInformation(final IOnlineServiceListener iOnlineServiceListener) {
        this.logChannel.log(10000000, "[OnlineService#getLicenseInformation] application:%1", (Object)this.applicationId);
        OSRCommandList oSRCommandList = this.system.createCommandList();
        oSRCommandList.setErrorCommand(new AbstractOSRCommand("ErrorCommand"){

            public void execute() {
                OnlineService.this.logChannel.log(100000, "[OnlineService#getLicenseInformation] error occured for application:%1 - core services did not respond in time", (Object)OnlineService.this.applicationId);
                iOnlineServiceListener.getLicenseInformationResult(null);
                this.getCommandList().commandFinished();
            }

            public void updateServiceList(OSRServiceState[] oSRServiceStateArray, int n) {
            }
        });
        oSRCommandList.add(new AbstractOSRCommand("check if license(s) are available and trigger #getServiceList if necessary"){

            public void execute() {
                OSRLicense[] oSRLicenseArray = OnlineService.this.onlineApplication.getLicenseList();
                if (oSRLicenseArray == null || oSRLicenseArray.length == 0) {
                    OnlineService.this.logChannel.log(10000000, "[OnlineService#getLicenseInformation] no license found for application:%1 - trigger core service to retrieve new service list", (Object)OnlineService.this.applicationId);
                    OSRCommandList oSRCommandList = OnlineService.this.system.createCommandList();
                    oSRCommandList.add(new OSRWaitCommand(1000L));
                    oSRCommandList.add(new OSRGetOnlineApplicationCommand(OnlineService.this.applicationId));
                    this.getCommandList().commandFinishedWithPostSequence(oSRCommandList);
                } else {
                    OnlineService.this.logChannel.log(10000000, "[OnlineService#getLicenseInformation] %2 license(s) found for application:%1", (Object)OnlineService.this.applicationId, (long)oSRLicenseArray.length);
                    this.getCommandList().commandFinished();
                }
            }

            public void updateServiceList(OSRServiceState[] oSRServiceStateArray, int n) {
            }
        });
        oSRCommandList.add(new AbstractOSRCommand("call callback handler"){

            public void execute() {
                OSRLicense[] oSRLicenseArray = OnlineService.this.getOnlineApplication().getLicenseList();
                OnlineService.this.logChannel.log(10000000, "[OnlineService#getLicenseInformation] application:%1 delegating license list (number:%2)", (Object)OnlineService.this.applicationId, (long)oSRLicenseArray.length);
                iOnlineServiceListener.getLicenseInformationResult(oSRLicenseArray);
                this.getCommandList().commandFinished();
            }

            public void updateServiceList(OSRServiceState[] oSRServiceStateArray, int n) {
            }
        });
        oSRCommandList.execute("ORSMediator#getLicenseInformation");
    }

    public void getReminderStatus(final IOnlineServiceListener iOnlineServiceListener) {
        this.logChannel.log(10000000, "[OnlineService#getReminderStatus] application:%1", (Object)this.applicationId);
        OSRCommandList oSRCommandList = this.system.createCommandList();
        oSRCommandList.setErrorCommand(new AbstractOSRCommand("ErrorCommand"){

            public void execute() {
                OnlineService.this.logChannel.log(100000, "[OnlineService#getReminderStatus] error occured for application:%1", (Object)OnlineService.this.applicationId);
                iOnlineServiceListener.getReminderStatusResult(0);
                this.getCommandList().commandFinished();
            }

            public void updateServiceList(OSRServiceState[] oSRServiceStateArray, int n) {
            }
        });
        oSRCommandList.add(new AbstractOSRCommand("check if query is needed"){

            public void execute() {
                OnlineService.this.logChannel.log(10000000, "[OnlineService#getReminderStatus] application:%1 check if info was retrieved before", (Object)OnlineService.this.applicationId);
                if (!OnlineServiceRegistrationHelper.isKeyAvailable("ONLINE_TRAFFIC_LICENCE_EXPIRES_REMINDER_STATE", OnlineService.this.onlineApplication)) {
                    OnlineService.this.logChannel.log(10000000, "[OnlineService#getReminderStatus] Key ONLINE_TRAFFIC_LICENCE_EXPIRES_REMINDER_STATE is not available, trigger getOnlineApplication(%1)", (Object)OnlineService.this.applicationId);
                    OSRCommandList oSRCommandList = OnlineService.this.system.createCommandList();
                    oSRCommandList.add(new OSRGetOnlineApplicationCommand(OnlineService.this.applicationId));
                    this.getCommandList().commandFinishedWithPostSequence(oSRCommandList);
                } else {
                    this.getCommandList().commandFinished();
                }
            }

            public void updateServiceList(OSRServiceState[] oSRServiceStateArray, int n) {
            }
        });
        oSRCommandList.add(new AbstractOSRCommand("call callback handler"){

            public void execute() {
                OnlineService.this.logChannel.log(10000000, "[OnlineService#getReminderStatus] application:%1 delegating reminder status", (Object)OnlineService.this.applicationId);
                int n = OnlineServiceRegistrationHelper.getReminderStatus(OnlineService.this.onlineApplication, OnlineService.this.logChannel);
                iOnlineServiceListener.getReminderStatusResult(n);
                this.getCommandList().commandFinished();
            }

            public void updateServiceList(OSRServiceState[] oSRServiceStateArray, int n) {
            }
        });
        oSRCommandList.execute("ORSMediator#getReminderStatus");
    }

    public boolean addCallBackListener(IOnlineServiceListener iOnlineServiceListener) {
        this.logChannel.log(10000000, "[OnlineService#addCallBackListener] application:%1", (Object)this.applicationId);
        boolean bl = this.serviceCallbacks.add(iOnlineServiceListener);
        if (this.onlineApplication != null) {
            this.logChannel.log(10000000, "[OnlineService#setCallBackListener] propagating initial app status");
            iOnlineServiceListener.getOnlineApplicationResponse(this.onlineApplication);
        } else {
            this.logChannel.log(10000000, "[OnlineService#setCallBackListener] no online application set yet");
        }
        return bl;
    }

    public boolean removeCallBackListener(IOnlineServiceListener iOnlineServiceListener) {
        this.logChannel.log(10000000, "[OnlineService#removeCallBackListener] application:%1", (Object)this.applicationId);
        return this.serviceCallbacks.remove(iOnlineServiceListener);
    }

    public void setOnlineApplication(OSRApplication oSRApplication) {
        this.onlineApplication = oSRApplication;
        if (oSRApplication == null) {
            this.logChannel.log(10000000, "[OnlineService#setOnlineApplication] deleting online app");
        }
    }

    public void updateApplicationState(OSRNotifyProperties[] oSRNotifyPropertiesArray) {
        this.logChannel.log(10000000, "[OnlineService#updateApplicationState] delegating status update to callback...");
        for (int i2 = 0; i2 < this.serviceCallbacks.size(); ++i2) {
            ((IOnlineServiceListener)this.serviceCallbacks.get(i2)).updateApplicationState(oSRNotifyPropertiesArray);
        }
    }

    public OSRNotifyProperties getProperties() {
        return this.properties;
    }

    public String getApplicationId() {
        return this.applicationId;
    }

    public ServiceRegistration getServiceRegistration() {
        return this.serviceRegistration;
    }

    public void setServiceRegistration(ServiceRegistration serviceRegistration) {
        this.serviceRegistration = serviceRegistration;
    }

    public OSRApplication getOnlineApplication() {
        return this.onlineApplication;
    }

    public void updateRoamingState(boolean bl) {
        if (bl == this.roamingActive) {
            return;
        }
        this.roamingActive = bl;
    }

    public void getOnlineApplicationPreCheck(IOnlineServiceListener iOnlineServiceListener, String string) {
        String string2 = "";
        string2 = string != null && string.length() > 0 && !string.equals(this.applicationId) ? string : this.getSymbolicnameForAppId(LicenseCollectionService.licenses);
        if (string2 == null) {
            this.logChannel.log(100000, "[OnlineService#getOnlineApplicationPreCheck] no symbolic name for application:%1", (Object)this.applicationId);
            return;
        }
        this.logChannel.log(1000000, "[OnlineService#getOnlineApplicationPreCheck] symbolic name for application:%1 symbolicName: %2", (Object)this.applicationId, (Object)string2);
        OSRCommandList oSRCommandList = this.system.createCommandList();
        oSRCommandList.setErrorCommand(new AbstractOSRCommand("ErrorCommand"){

            public void execute() {
                OnlineService.this.logChannel.log(100000, "[OnlineService#getOnlineApplicationPreCheck] error occured for application:%1", (Object)OnlineService.this.applicationId);
                this.getCommandList().commandFinished();
            }

            public void updateServiceList(OSRServiceState[] oSRServiceStateArray, int n) {
            }
        });
        oSRCommandList.add(new OSRPOnlineApplicationPreCheck(this.applicationId, string2, this, iOnlineServiceListener));
        oSRCommandList.execute("OnlineService#getOnlineApplicationPreCheck");
    }

    private String getSymbolicnameForAppId(Map map) {
        if (this.applicationId.equals("service_dsi_satellitemaps")) {
            return "satellitemaps";
        }
        if (this.applicationId.equals("ebnav")) {
            return "satellitemaps_eb";
        }
        if (this.applicationId.equals("awnavicore")) {
            return "satellitemaps";
        }
        if (this.applicationId.equals("service_dsi_onlinetraffic")) {
            return "lic_traffic";
        }
        if (this.applicationId.equals("service_dsi_destimport")) {
            return "zieleinspeisung";
        }
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            String string = (String)entry.getValue();
            if (!this.applicationId.equals(string)) continue;
            return (String)entry.getKey();
        }
        return null;
    }

    public void getOnlineApplicationPreCheckResult(String string, OSRServiceState oSRServiceState, IOnlineServiceListener iOnlineServiceListener) {
        this.logChannel.log(10000000, "[OnlineService#getOnlineApplicationPreCheckResult] preCheckResult for application %1: %2", (Object)string, (Object)oSRServiceState);
        iOnlineServiceListener.getPreCheckResult(oSRServiceState);
    }

    public void updateServiceState(OnlineServiceListState onlineServiceListState) {
        this.logChannel.log(1000000, "OnlineService#updateServiceState %1", (Object)onlineServiceListState);
        for (int i2 = 0; i2 < this.serviceCallbacks.size(); ++i2) {
            IOnlineServiceListener iOnlineServiceListener = (IOnlineServiceListener)this.serviceCallbacks.get(i2);
            this.logChannel.log(1000000, "OnlineService#updateServiceState calling handler %1", (Object)iOnlineServiceListener);
            iOnlineServiceListener.updateServiceState(onlineServiceListState);
        }
    }
}

