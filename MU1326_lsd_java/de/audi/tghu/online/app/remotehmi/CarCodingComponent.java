/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.atip.log.LogChannel;
import de.audi.atip.sysapp.carcoding.ISysConstManager;
import de.audi.remotehmi.HMIProperties;
import de.audi.remotehmi.RemoteHMIAction;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMIComponent;
import de.audi.tghu.online.app.remotehmi.RemoteHMIDSIAccess;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;

public class CarCodingComponent
extends AbstractRemoteHMIComponent
implements RemoteHMIDSIAccess.IRemoteHMIDSIListener {
    private static final int ONLY_UOTA_PACKAGE_PPOI = 0;

    public void init(LogChannel logChannel, RemoteHMIService remoteHMIService) {
        super.init(logChannel, remoteHMIService);
    }

    public void remoteHmiDsiReady() {
        this.sendCarCoding(this.getCarCoding());
    }

    private void sendCarCoding(HMIProperties hMIProperties) {
        this.logChannel.log(1000000, "CarCodingComponent#sendCarCoding");
        RemoteHMIAction remoteHMIAction = new RemoteHMIAction(0x9899F9);
        remoteHMIAction.setParameters(hMIProperties);
        this.remoteHmiService.invokeAction(remoteHMIAction);
    }

    private HMIProperties getCarCoding() {
        this.logChannel.log(10000000, "CarCodingComponent#getCarCoding");
        HMIProperties hMIProperties = new HMIProperties();
        ISysConstManager iSysConstManager = this.getFrameworkAccess().getSysConstManager();
        hMIProperties.put("googleEarth", new Integer(iSysConstManager.getSysConst(479)));
        hMIProperties.put("picNav", new Integer(iSysConstManager.getSysConst(489)));
        hMIProperties.put("wlan", new Integer(iSysConstManager.getSysConst(492)));
        hMIProperties.put("streetView", new Integer(iSysConstManager.getSysConst(490)));
        if (this.getFrameworkAccess().isNar()) {
            hMIProperties.put("traffic", new Integer(0));
        } else {
            Integer n = new Integer(iSysConstManager.getSysConst(488));
            hMIProperties.put("traffic", n);
        }
        hMIProperties.put("search", new Integer(iSysConstManager.getSysConst(486)));
        hMIProperties.put("myAudi", new Integer(iSysConstManager.getSysConst(485)));
        hMIProperties.put("eni", new Integer(iSysConstManager.getSysConst(4252)));
        hMIProperties.put("propCodingNAD", new Integer(iSysConstManager.getSysConst(463)));
        hMIProperties.put("propResolution", new Integer(iSysConstManager.getSysConst(522)));
        hMIProperties.put("propG21High", new Integer(iSysConstManager.getSysConst(4581)));
        hMIProperties.put("propLongPrompts", new Integer(iSysConstManager.getSysConst(5541)));
        hMIProperties.put("uotaMap", new Integer(iSysConstManager.getSysConst(4120) == 0 ? 0 : 1));
        hMIProperties.put("ppoi", new Integer(iSysConstManager.getSysConst(4477)));
        hMIProperties.put("email", new Integer(iSysConstManager.getSysConst(4004)));
        hMIProperties.put("sms", new Integer(iSysConstManager.getSysConst(549)));
        hMIProperties.put("messagingTemplateOnly", new Integer(iSysConstManager.getSysConst(4062)));
        hMIProperties.put("messaging", new Integer(iSysConstManager.getSysConst(472)));
        hMIProperties.put("eolCodingOnlineMedia", new Integer(this.getFrameworkAccess().getSysConst(3967)));
        hMIProperties.put("serviceDiscovery", new Integer(this.getFrameworkAccess().getSysConst(4526)));
        hMIProperties.put("primaryEngine", new Integer(this.getFrameworkAccess().getSysConst(4524)));
        hMIProperties.put("secondaryEngine", new Integer(this.getFrameworkAccess().getSysConst(4525)));
        hMIProperties.put("huRegion", new Integer(this.getFrameworkAccess().getSysConst(442)));
        this.overrideSystemproperty(hMIProperties, "eolCodingOnlineMedia", "media.config.online");
        this.overrideSystemproperty(hMIProperties, "eolCodingUsersV3", "remoteHmi.usersV3.disabled");
        this.printCoding(hMIProperties);
        return hMIProperties;
    }

    private void overrideSystemproperty(HMIProperties hMIProperties, String string, String string2) {
        String string3 = System.getProperty(string2, "");
        this.logChannel.log(1000000, "CarCodingComponent#overrideSystemproperty vmvalue for %1: %2", (Object)string2, (Object)string3);
        if (string3.length() == 0) {
            return;
        }
        if (string3.equalsIgnoreCase("installed") || string3.equalsIgnoreCase("true")) {
            Integer n = (Integer)hMIProperties.get(string);
            this.logChannel.log(1000000, "CarCodingComponent#overrideSystemproperty overriding EOL Falg %1 with vmArgumewnt 1", (Object)n);
            hMIProperties.put(string, new Integer(1));
        } else if (string3.equalsIgnoreCase("notinstalled") || string3.equalsIgnoreCase("false")) {
            hMIProperties.put(string, new Integer(0));
        }
    }

    private void printCoding(HMIProperties hMIProperties) {
        this.logChannel.log(1000000, "CarCodingComponent#printCoding %1", (Object)hMIProperties.toString());
    }
}

