/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr.license;

import de.audi.atip.hmi.HMIService;
import de.audi.atip.interapp.bap.eni.data.Service;
import de.audi.atip.log.LogChannel;
import de.audi.remotehmi.IRemoteHMILicense;
import de.audi.remotehmi.textconstants.ITextConstantsConverter;
import de.audi.tghu.online.app.osr.license.LicenseCollectionService;
import de.audi.tghu.online.app.osr.license.LicenseHMIListenerEvo;
import de.audi.tghu.online.app.osr.license.LicensingModelManagerEvo;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;
import de.audi.tghu.online.app.standard.OnlineEvoStandardModelHandler;
import java.util.ArrayList;
import org.dsi.ifc.online.OSRLicense;

public class LicenseCollectionServiceEvo
extends LicenseCollectionService {
    public LicenseCollectionServiceEvo(LogChannel logChannel, HMIService hMIService, RemoteHMIService remoteHMIService, ITextConstantsConverter iTextConstantsConverter, boolean bl) {
        super(logChannel, hMIService, remoteHMIService, bl);
        this.modelManager = new LicensingModelManagerEvo(hMIService, logChannel, remoteHMIService, this, iTextConstantsConverter);
        logChannel.log(14808325, "LicenseCollectionServiceEvo#ctor: Called.");
        this.hmiListener = new LicenseHMIListenerEvo(logChannel, this, remoteHMIService);
        this.hmiListener.setModelManager(this.modelManager);
    }

    @Override
    protected void indicateActiveLicense(OSRLicense oSRLicense) {
    }

    @Override
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
                n = this.remoteHMIService != null && !this.remoteHMIService.isTT() ? (iRemoteHMILicense.getType() == 0 || iRemoteHMILicense.getType() == 2 ? 0 : 1) : 0;
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

    @Override
    protected void addCGWLicenses() {
        if (this.services == null || this.services.length < 0) {
            this.log.log(-2137614336, "LicenseCollectionServiceEvo#addCGWLicenses: no CGW services available, skipping.");
            return;
        }
        super.addCGWLicenses();
        for (int i2 = 0; i2 < this.services.length; ++i2) {
            Service service = this.services[i2];
            if (!OnlineEvoStandardModelHandler.isAlertService(service.getId())) continue;
            IRemoteHMILicense iRemoteHMILicense = this.convertCGWLicensetoRHMILicense(service);
            if (iRemoteHMILicense == null) {
                this.log.log(-1601830656, "LicenseCollectionService#addCGWLicenses: given remoteHMILicense is null! Skipping Entry %1", (Object)service.getName());
                continue;
            }
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(iRemoteHMILicense);
            this.licensesBySymbolicName.put("alert_services", arrayList);
            break;
        }
    }
}

