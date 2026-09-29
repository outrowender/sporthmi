/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.main.interapp;

import de.audi.app.addressbook.core.main.AbstractAddressBookApplication;
import de.audi.app.addressbook.core.main.commands.edit.SaveEntryCommand;
import de.audi.atip.interapp.NaviADBService$LocationInputHandler;
import de.audi.atip.log.LogChannel;

public class AddressBookLocationInputHandler
implements NaviADBService$LocationInputHandler {
    private AbstractAddressBookApplication appAdr;
    private LogChannel log;
    private boolean locationInputInterrupted = false;
    private byte[] lastNavLocation;
    private int currentlyEditedAddress = 0;

    public AddressBookLocationInputHandler(AbstractAddressBookApplication abstractAddressBookApplication, LogChannel logChannel) {
        this.appAdr = abstractAddressBookApplication;
        this.log = logChannel;
    }

    public void init(byte[] byArray) {
        this.locationInputInterrupted = false;
        this.lastNavLocation = byArray;
    }

    public void adrEditNavEntered() {
        this.log.log(-2137614336, "AddressBookLocationInputHandler#adrEditNavEntered()");
        if (this.locationInputInterrupted) {
            this.appAdr.getNaviGateway().editLocation(this, this.lastNavLocation);
            this.locationInputInterrupted = false;
        }
    }

    public void setCurrentlyEditedAddress(int n) {
        this.currentlyEditedAddress = n;
    }

    public int getCurrentlyEditedAddress() {
        return this.currentlyEditedAddress;
    }

    @Override
    public void updateLocation(byte[] byArray) {
        this.log.log(1078071040, "AddressBookLocationInputHandler#updateLocation(): navLocation: %1", (Object)byArray);
        this.lastNavLocation = byArray;
        this.appAdr.getCurrentEntry().addressData[this.currentlyEditedAddress].navLocation = byArray;
        SaveEntryCommand.createSaveEntryCommand(this.appAdr);
    }

    @Override
    public void sessionClosed() {
        this.log.log(-2137614336, "AddressBookLocationInputHandler#sessionClosed()");
        this.locationInputInterrupted = true;
    }
}

