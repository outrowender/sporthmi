/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.common.interapp;

import de.audi.app.addressbook.core.common.ADBApplication;
import de.audi.atip.interapp.phone.ITelPresetService;
import de.audi.atip.interapp.phone.ITelServiceADB;
import de.audi.atip.interapp.phone.TelFavoriteStruct;
import de.audi.atip.log.LogChannel;
import de.audi.atip.phone.ITelService;
import de.audi.atip.preset.DefinitionRequest;
import org.dsi.ifc.global.ResourceLocator;

public class PhoneGateway {
    private LogChannel log;
    private volatile ITelService phone;
    private volatile ITelServiceADB phoneAdb;
    private volatile ITelPresetService phonePresetService;
    private ADBApplication appAdr;

    public PhoneGateway(LogChannel logChannel, ADBApplication aDBApplication) {
        this.log = logChannel;
        this.appAdr = aDBApplication;
    }

    public void setPhoneService(ITelService iTelService) {
        this.log.log(10000000, "PhoneGateway#setPhoneService(): phone: %1", (Object)iTelService);
        this.phone = iTelService;
    }

    public void releasePhoneService() {
        this.phone = null;
    }

    public void setPhoneAdbService(ITelServiceADB iTelServiceADB) {
        this.log.log(10000000, "PhoneGateway#setPhoneAdbService(): phoneAdb: %1", (Object)iTelServiceADB);
        this.phoneAdb = iTelServiceADB;
    }

    public void releasePhoneAdbService() {
        this.phoneAdb = null;
    }

    public void setPhonePresetService(ITelPresetService iTelPresetService) {
        this.log.log(10000000, "PhoneGateway#setPhonePresetService(): phonePresetService: %1", (Object)iTelPresetService);
        this.phonePresetService = iTelPresetService;
    }

    public void releasePhonePresetService() {
        this.phonePresetService = null;
    }

    public boolean isPhoneReady() {
        return this.appAdr.getFramework().getHMIService().getChoiceModel(186).getValue() == 1 && this.phone != null;
    }

    public void dialNumber(String string, String string2, int n, int n2, long l, ResourceLocator resourceLocator, int n3, int n4, boolean bl) {
        ITelService iTelService = this.phone;
        if (iTelService == null) {
            this.log.log(10000, "PhoneGateway#dialNumber(): phone service not available!");
            return;
        }
        this.log.log(1000000, "PhoneGateway#dialNumber(): name: %1, number: %2, entryId: %3", (Object)string, (Object)string2, l);
        this.log.log(10000000, "PhoneGateway#dialNumber(): resourceLocator: %1, phoneNumberIndex: %2", (Object)resourceLocator, (long)n3);
        iTelService.dialNumberFromADBEntry(string, string2, (short)n, (short)n2, l, resourceLocator, n3, n4, null, bl);
    }

    public void dialNumber(String string, boolean bl) {
        ITelService iTelService = this.phone;
        if (iTelService == null) {
            this.log.log(10000, "PhoneGateway#dialNumber(): phone service not available!");
            return;
        }
        this.log.log(1000000, "PhoneGateway#dialNumber(): number: %1", (Object)string);
        iTelService.dialNumber(string, null, bl);
    }

    public void prepareDialing(String string, String string2, int n, int n2, long l, ResourceLocator resourceLocator, int n3, int n4) {
        ITelService iTelService = this.phone;
        if (iTelService == null) {
            this.log.log(10000, "PhoneGateway#prepareDialing(): phone service not available!");
            return;
        }
        this.log.log(1000000, "PhoneGateway#prepareDialing(): name: %1, number: %2, entryId: %3", (Object)string, (Object)string2, l);
        this.log.log(10000000, "PhoneGateway#prepareDialing(): resourceLocator: %1, phoneNumberIndex: %2", (Object)resourceLocator, (long)n3);
        iTelService.prepareDialing(string, string2, (short)n, (short)n2, l, resourceLocator, n3, n4, null);
    }

    public void prepareDialing(String string) {
        ITelService iTelService = this.phone;
        if (iTelService == null) {
            this.log.log(10000, "PhoneGateway#prepareDialing(): phone service not available!");
            return;
        }
        this.log.log(1000000, "PhoneGateway#prepareDialing(): number: %1", (Object)string);
        iTelService.prepareDialing(string, null);
    }

    public void addToFavorites(TelFavoriteStruct telFavoriteStruct) {
        ITelServiceADB iTelServiceADB = this.phoneAdb;
        if (iTelServiceADB == null) {
            this.log.log(10000, "PhoneGateway#addToFavorites(): phoneAdb service not available!");
            return;
        }
        this.log.log(1000000, "PhoneGateway#addToFavorites(): telFavorite=%1", (Object)telFavoriteStruct);
        iTelServiceADB.addToFavorites(telFavoriteStruct);
    }

    public void definePreset(DefinitionRequest definitionRequest, String string, String string2, int n) {
        ITelPresetService iTelPresetService = this.phonePresetService;
        if (iTelPresetService == null) {
            this.log.log(10000, "PhoneGateway#definePreset(): telPresetService not available!");
            return;
        }
        this.log.log(1000000, "PhoneGateway#definePreset(): name: %1, number: %2", (Object)string2, (Object)string);
        iTelPresetService.definePreset(definitionRequest, string, string2, n);
    }
}

