/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.eni;

import de.audi.app.bap.eni.BAPArrayDataENI$1;
import de.audi.app.bap.eni.BAPArrayDataENI$2;
import de.audi.app.bap.eni.BAPArrayDataENI$3;
import de.audi.app.bap.eni.BAPArrayElementListENI;
import de.audi.atip.interapp.bap.eni.data.Address;
import de.audi.atip.interapp.bap.eni.data.Address$Builder;
import de.audi.atip.interapp.bap.eni.data.Destination;
import de.audi.atip.interapp.bap.eni.data.Destination$Builder;
import de.audi.atip.interapp.bap.eni.data.GeoCoordinates;
import de.audi.atip.interapp.bap.eni.data.License;
import de.audi.atip.interapp.bap.eni.data.License$Builder;
import de.audi.atip.interapp.bap.eni.data.PhoneNumber;
import de.audi.atip.interapp.bap.eni.data.Service;
import de.audi.atip.interapp.bap.eni.data.Service$Builder;
import de.audi.atip.interapp.bap.eni.data.User;
import de.audi.atip.log.LogChannel;
import de.vw.mib.bap.generated.eni.serializer.DestinationsList_Data;
import de.vw.mib.bap.generated.eni.serializer.ServiceList_Data;
import de.vw.mib.bap.generated.eni.serializer.UserList_Data;

public final class BAPArrayDataENI {
    private final BAPArrayElementListENI destinationList;
    private final BAPArrayElementListENI userList;
    private final BAPArrayElementListENI serviceList;
    static /* synthetic */ Class class$de$audi$atip$interapp$bap$eni$data$Destination;
    static /* synthetic */ Class class$de$audi$atip$interapp$bap$eni$data$User;
    static /* synthetic */ Class class$de$audi$atip$interapp$bap$eni$data$Service;

    public BAPArrayDataENI(LogChannel logChannel) {
        this.destinationList = new BAPArrayElementListENI(logChannel);
        this.userList = new BAPArrayElementListENI(logChannel);
        this.serviceList = new BAPArrayElementListENI(logChannel);
    }

    public BAPArrayElementListENI getDestinationList() {
        return this.destinationList;
    }

    public BAPArrayElementListENI getUserList() {
        return this.userList;
    }

    public BAPArrayElementListENI getServiceList() {
        return this.serviceList;
    }

    public Destination[] destinations() {
        return (Destination[])this.destinationList.toArray(class$de$audi$atip$interapp$bap$eni$data$Destination == null ? (class$de$audi$atip$interapp$bap$eni$data$Destination = BAPArrayDataENI.class$("de.audi.atip.interapp.bap.eni.data.Destination")) : class$de$audi$atip$interapp$bap$eni$data$Destination, new BAPArrayDataENI$1(this));
    }

    public User[] users() {
        return (User[])this.userList.toArray(class$de$audi$atip$interapp$bap$eni$data$User == null ? (class$de$audi$atip$interapp$bap$eni$data$User = BAPArrayDataENI.class$("de.audi.atip.interapp.bap.eni.data.User")) : class$de$audi$atip$interapp$bap$eni$data$User, new BAPArrayDataENI$2(this));
    }

    public Service[] services() {
        return (Service[])this.serviceList.toArray(class$de$audi$atip$interapp$bap$eni$data$Service == null ? (class$de$audi$atip$interapp$bap$eni$data$Service = BAPArrayDataENI.class$("de.audi.atip.interapp.bap.eni.data.Service")) : class$de$audi$atip$interapp$bap$eni$data$Service, new BAPArrayDataENI$3(this));
    }

    public void clear() {
        this.destinationList.clear();
        this.userList.clear();
        this.serviceList.clear();
    }

    private static Destination destinationFromDestinationListData(DestinationsList_Data destinationsList_Data) {
        Address$Builder address$Builder = Address.builder();
        address$Builder.setCity(destinationsList_Data.addr_Town.toString());
        address$Builder.setCountry(destinationsList_Data.addr_Country.toString());
        address$Builder.setNumber(destinationsList_Data.addr_Number.toString());
        address$Builder.setPostalCode(destinationsList_Data.addr_PostalCode.toString());
        address$Builder.setState(destinationsList_Data.addr_State.toString());
        address$Builder.setStreet(destinationsList_Data.addr_Street.toString());
        GeoCoordinates geoCoordinates = GeoCoordinates.getInstance(destinationsList_Data.position_Longitude, destinationsList_Data.position_Latitude);
        PhoneNumber phoneNumber = PhoneNumber.getInstance(destinationsList_Data.addr_Telephone.toString());
        Destination$Builder destination$Builder = Destination.builder();
        destination$Builder.setAddress(address$Builder.build());
        destination$Builder.setGeoCoordinates(geoCoordinates);
        destination$Builder.setDestinationKind(destinationsList_Data.typeOfDestination);
        destination$Builder.setName(destinationsList_Data.name.toString());
        destination$Builder.setPhoneNumber(phoneNumber);
        destination$Builder.setPoiExtension(destinationsList_Data.poi_Extension.toString());
        destination$Builder.setPoiKind(destinationsList_Data.poi_Type);
        destination$Builder.setStopOverSequenceNumber(destinationsList_Data.stopover_Sn);
        destination$Builder.setTourId(destinationsList_Data.tour_Id);
        return destination$Builder.build();
    }

    private static User userFromUserListData(UserList_Data userList_Data) {
        return User.getInstance(userList_Data.userName.toString(), userList_Data.userType == 0);
    }

    private static Service serviceFromServiceListData(ServiceList_Data serviceList_Data) {
        License$Builder license$Builder = License.builder();
        license$Builder.setActivationDate(serviceList_Data.dateOfActivation.toString());
        license$Builder.setExpirationDate(serviceList_Data.dateOfExpiry.toString());
        license$Builder.setId(serviceList_Data.licenseId.toString());
        license$Builder.setState(serviceList_Data.licenseState);
        license$Builder.setValidityDuration(serviceList_Data.periodOfValidity.toString());
        Service$Builder service$Builder = Service.builder();
        service$Builder.setEnabled(serviceList_Data.serviceState.serviceEnabled);
        service$Builder.setEnabledByUser(serviceList_Data.userSettings.serviceActivatedAllowedByDriver);
        service$Builder.setAllowedByVehicle(serviceList_Data.userSettings.serviceAllowedByVehicle);
        service$Builder.setHasExpirationWarning(serviceList_Data.serviceState.licenseExpirationWarning);
        service$Builder.setId(serviceList_Data.serviceId.toString());
        service$Builder.setInternalId(serviceList_Data.getPos());
        service$Builder.setLicense(license$Builder.build());
        service$Builder.setGPSRequired(BAPArrayDataENI.isGPSRequired(serviceList_Data));
        service$Builder.setName(serviceList_Data.serviceName.toString());
        service$Builder.setProtected(serviceList_Data.serviceState.protectedService);
        service$Builder.setDisablingByDriverAllowed(serviceList_Data.serviceState.disablingByDriverAllowedDf3_3);
        service$Builder.setRoamingAllowed(serviceList_Data.serviceState.roamingAllowed);
        service$Builder.setVersion(serviceList_Data.serviceVersion.toString());
        return service$Builder.build();
    }

    private static boolean isGPSRequired(ServiceList_Data serviceList_Data) {
        boolean bl = serviceList_Data.serviceState.serviceAllocatedToGroup1Df3_5;
        bl |= serviceList_Data.serviceState.serviceAllocatedToGroup2Df3_5;
        return bl |= serviceList_Data.serviceState.serviceAllocatedToGroup5Df3_5;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ Destination access$000(DestinationsList_Data destinationsList_Data) {
        return BAPArrayDataENI.destinationFromDestinationListData(destinationsList_Data);
    }

    static /* synthetic */ User access$100(UserList_Data userList_Data) {
        return BAPArrayDataENI.userFromUserListData(userList_Data);
    }

    static /* synthetic */ Service access$200(ServiceList_Data serviceList_Data) {
        return BAPArrayDataENI.serviceFromServiceListData(serviceList_Data);
    }
}

