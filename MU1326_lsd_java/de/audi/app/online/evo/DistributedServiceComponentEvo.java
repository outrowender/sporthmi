/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo;

import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.util.StringUtilities;
import de.audi.tghu.online.app.AbstractDistributedServiceComponent;
import de.audi.tghu.online.app.remotehmi.AbstractExternalServiceProvider;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;
import de.audi.tghu.online.app.remotehmi.util.OnlineApplicationOtherContextImpl;

public class DistributedServiceComponentEvo
extends AbstractDistributedServiceComponent {
    public void init(LogChannel logChannel, RemoteHMIService remoteHMIService) {
        super.init(logChannel, remoteHMIService);
    }

    protected void initiateHMIJump(String string) {
        Object object;
        if (string == null) {
            return;
        }
        this.appContext = "";
        int n = 111;
        int n2 = 2300852;
        int n3 = 2300853;
        this.logChannel.log(1000000, "DistributedServiceComponentEvo#initiateHMIJump: trigger jump to %1", (Object)string);
        this.disableLineNumbers(this.hmiService);
        if (string.endsWith("service")) {
            object = this.remoteHmiService.getNaviComponent().getMapService();
            n = this.mapServiceToModelValue(string);
            switch (n) {
                case 2: 
                case 9: {
                    if (object != null) break;
                    this.logChannel.log(10000, "DistributedServiceComponentEvo#initiateHMIJump: mapService is null");
                    return;
                }
                case 10: {
                    if (object != null) break;
                    this.logChannel.log(10000, "DistributedServiceComponentEvo#initiateHMIJump: mapService is null");
                    return;
                }
                case 3: {
                    this.appContext = StringUtilities.getStringBetween(string, "_", "_", true);
                    break;
                }
                case 21: {
                    this.hmiService.getChoiceModel(2301200).setValue(1);
                    break;
                }
                case 22: {
                    this.hmiService.getChoiceModel(2301379).setValue(0);
                    break;
                }
            }
        } else if (string.equals("userSettings_service_opt")) {
            this.hmiService.getChoiceModel(2301379).setValue(1);
            n = 22;
        } else if (string.equals("rhmiMainWizard")) {
            n = 11;
            n3 = 2301166;
        } else if (string.equals("connectivitySettings")) {
            n = 1;
            n2 = 2300877;
            n3 = 2300877;
        } else if (string.equals("licensingScreen")) {
            n = 1;
            n2 = 2300960;
            n3 = 2300960;
            if (this.remoteHmiService.getLicenseCollectionService() != null) {
                this.remoteHmiService.getLicenseCollectionService().refreshLicensesDependingOnServiceList();
            }
        } else if (string.startsWith("license")) {
            n = this.mapServiceToModelValue(string);
            this.setLicenseDetailScreen(n);
            n2 = 2301088;
            n3 = 2301088;
        } else if (string.equals("stepUp")) {
            this.hmiService.getChoiceModel(2301200).setValue(0);
            n = 1;
            n2 = 2301103;
            n3 = 2301103;
        } else if (string.equals("service_trafficlight")) {
            n = 24;
        } else if (string.equals("DataPrivacy")) {
            this.logChannel.log(1000000, "DistributedServiceComponentEvo#initiateHMIJump: call Data Privacy Setting Screen!");
            n = 1;
            n2 = 2301770;
            n3 = 2301770;
        }
        if (this.remoteHmiService.isSDSRunning()) {
            this.logChannel.log(1000000, "DistributedServiceComponentEvo#initiateHMIJump: SDS is running, jump to service itself");
            if (this.handleSDSJump(n, string)) {
                this.logChannel.log(1000000, "DistributedServiceComponentEvo#initiateHMIJump: jump handled by SDS");
                return;
            }
        }
        this.logChannel.log(1000000, "DistributedServiceComponentEvo#initiateHMIJump model: %1, value: %2", (Object)new Integer(n2), (Object)new Integer(n));
        this.setMediaContext(n);
        this.hmiService.getChoiceModel(n2).setValue(n);
        object = this.hmiService.getChoiceModel(n3);
        object.setValue(~object.getValue());
    }

    private void setMediaContext(int n) {
        LabelModelApp labelModelApp = this.hmiService.getLabelModel(2301290);
        LabelModelApp labelModelApp2 = this.hmiService.getLabelModel(2301291);
        if (n == 3) {
            OnlineApplicationOtherContextImpl onlineApplicationOtherContextImpl;
            AbstractExternalServiceProvider abstractExternalServiceProvider = this.remoteHmiService.getOnlineServiceProvider();
            if (abstractExternalServiceProvider != null && (onlineApplicationOtherContextImpl = abstractExternalServiceProvider.getOnlineMediaAppByContext(this.appContext)) != null) {
                String string = onlineApplicationOtherContextImpl.getAppName();
                String string2 = onlineApplicationOtherContextImpl.getAppDescription();
                labelModelApp.setText(string);
                labelModelApp2.setText(string2);
                this.logChannel.log(1000000, "DistributedServiceComponentEvo#initiateHMIJump Name: '%1', Desc: %2", (Object)string, (Object)string2);
            }
        } else {
            labelModelApp.setText("");
            labelModelApp2.setText("");
        }
    }

    protected boolean handleSDSJump(int n, String string) {
        this.logChannel.log(1000000, "DistributedServiceComponentEvo#handleSDSJump: called with hmiState %1 and dest %2", (Object)new Integer(n), (Object)string);
        int n2 = -1;
        if (string.startsWith("license")) {
            n = this.mapServiceToModelValue(string);
            this.setLicenseDetailScreen(n);
            int n3 = 2301088;
            int n4 = 2301088;
            n2 = 2432;
            this.hmiService.getChoiceModel(n3).setValue(n);
            ChoiceModelApp choiceModelApp = this.hmiService.getChoiceModel(n4);
            choiceModelApp.setValue(~choiceModelApp.getValue());
            this.remoteHmiService.getASR().setDistributedServiceMoveType(n2);
            this.triggerSMSpeechEvent(n, n2);
            return true;
        }
        if (!string.endsWith("service")) {
            this.logChannel.log(1000000, "DistributedServiceComponentEvo#handleSDSJump: no handling of service %1", (Object)string);
            return false;
        }
        HMIService hMIService = this.getFrameworkAccess().getHMIService();
        int n5 = 2300852;
        hMIService.getChoiceModel(n5).setValue(n);
        switch (n) {
            case 0: {
                n2 = 2295;
                break;
            }
            case 1: {
                n2 = 2303;
                break;
            }
            case 2: {
                n2 = 2301;
                break;
            }
            case 4: {
                n2 = 2464;
                break;
            }
            case 8: {
                n2 = 2304;
                break;
            }
            case 12: {
                n2 = 2305;
                break;
            }
            case 5: 
            case 7: 
            case 10: 
            case 13: {
                n2 = 2294;
                break;
            }
            case 3: {
                this.appContext = StringUtilities.getStringBetween(string, "_", "_", true);
                n2 = 2445;
                break;
            }
            default: {
                n2 = 2294;
            }
        }
        ChoiceModelApp choiceModelApp = hMIService.getChoiceModel(2301235);
        choiceModelApp.setValue(~choiceModelApp.getValue());
        if (n2 != -1) {
            this.remoteHmiService.getASR().setDistributedServiceMoveType(n2);
            this.triggerSMSpeechEvent(n, n2);
            this.setMediaContext(n);
        }
        return true;
    }

    private void triggerSMSpeechEvent(int n, int n2) {
        if (n2 != -1) {
            this.logChannel.log(1000000, "DistributedServiceComponentEvo#triggerSMSpeechEvent: hmiState is %1, firing event %2", (long)n, (long)n2);
            this.getFrameworkAccess().getHMIService().fireSMEvent(6, n2);
        } else {
            this.logChannel.log(10000, "DistributedServiceComponentEvo#triggerSMSpeechEvent: invalid parameter");
        }
    }

    protected void disableLineNumbers(HMIService hMIService) {
        ChoiceModelApp choiceModelApp = hMIService.getChoiceModel(2301016);
        choiceModelApp.setValue(0);
    }

    protected void setLicenseDetailScreen(int n) {
        int n2 = 2301023;
        this.hmiService.getChoiceModel(n2).setValue(n);
    }

    public int getCurrentSelectedDistributedService() {
        ChoiceModelApp choiceModelApp = this.hmiService.getChoiceModel(2300852);
        return choiceModelApp.getValue();
    }
}

