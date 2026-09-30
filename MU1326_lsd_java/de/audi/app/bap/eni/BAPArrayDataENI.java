/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.eni;

import de.audi.app.bap.eni.BAPArrayElementListENI;
import de.audi.app.bap.fw.functiontypes.AbstractBAPArrayElementListASG;
import de.audi.atip.interapp.bap.eni.data.Address;
import de.audi.atip.interapp.bap.eni.data.Destination;
import de.audi.atip.interapp.bap.eni.data.GeoCoordinates;
import de.audi.atip.interapp.bap.eni.data.License;
import de.audi.atip.interapp.bap.eni.data.PhoneNumber;
import de.audi.atip.interapp.bap.eni.data.Service;
import de.audi.atip.interapp.bap.eni.data.User;
import de.audi.atip.log.LogChannel;
import de.vw.mib.bap.datatypes.BAPArrayElement;
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
        return (Destination[])this.destinationList.toArray(class$de$audi$atip$interapp$bap$eni$data$Destination == null ? (class$de$audi$atip$interapp$bap$eni$data$Destination = BAPArrayDataENI.class$("de.audi.atip.interapp.bap.eni.data.Destination")) : class$de$audi$atip$interapp$bap$eni$data$Destination, new AbstractBAPArrayElementListASG.BAPElementConverter(){

            public Object convert(BAPArrayElement bAPArrayElement) {
                return BAPArrayDataENI.destinationFromDestinationListData((DestinationsList_Data)bAPArrayElement);
            }
        });
    }

    public User[] users() {
        return (User[])this.userList.toArray(class$de$audi$atip$interapp$bap$eni$data$User == null ? (class$de$audi$atip$interapp$bap$eni$data$User = BAPArrayDataENI.class$("de.audi.atip.interapp.bap.eni.data.User")) : class$de$audi$atip$interapp$bap$eni$data$User, new AbstractBAPArrayElementListASG.BAPElementConverter(){

            public Object convert(BAPArrayElement bAPArrayElement) {
                return BAPArrayDataENI.userFromUserListData((UserList_Data)bAPArrayElement);
            }
        });
    }

    public Service[] services() {
        return (Service[])this.serviceList.toArray(class$de$audi$atip$interapp$bap$eni$data$Service == null ? (class$de$audi$atip$interapp$bap$eni$data$Service = BAPArrayDataENI.class$("de.audi.atip.interapp.bap.eni.data.Service")) : class$de$audi$atip$interapp$bap$eni$data$Service, new AbstractBAPArrayElementListASG.BAPElementConverter(){

            public Object convert(BAPArrayElement bAPArrayElement) {
                return BAPArrayDataENI.serviceFromServiceListData((ServiceList_Data)bAPArrayElement);
            }
        });
    }

    public void clear() {
        this.destinationList.clear();
        this.userList.clear();
        this.serviceList.clear();
    }

    private static Destination destinationFromDestinationListData(DestinationsList_Data destinationsList_Data) {
        Address.Builder builder = Address.builder();
        builder.setCity(destinationsList_Data.addr_Town.toString());
        builder.setCountry(destinationsList_Data.addr_Country.toString());
        builder.setNumber(destinationsList_Data.addr_Number.toString());
        builder.setPostalCode(destinationsList_Data.addr_PostalCode.toString());
        builder.setState(destinationsList_Data.addr_State.toString());
        builder.setStreet(destinationsList_Data.addr_Street.toString());
        GeoCoordinates geoCoordinates = GeoCoordinates.getInstance(destinationsList_Data.position_Longitude, destinationsList_Data.position_Latitude);
        PhoneNumber phoneNumber = PhoneNumber.getInstance(destinationsList_Data.addr_Telephone.toString());
        Destination.Builder builder2 = Destination.builder();
        builder2.setAddress(builder.build());
        builder2.setGeoCoordinates(geoCoordinates);
        builder2.setDestinationKind(destinationsList_Data.typeOfDestination);
        builder2.setName(destinationsList_Data.name.toString());
        builder2.setPhoneNumber(phoneNumber);
        builder2.setPoiExtension(destinationsList_Data.poi_Extension.toString());
        builder2.setPoiKind(destinationsList_Data.poi_Type);
        builder2.setStopOverSequenceNumber(destinationsList_Data.stopover_Sn);
        builder2.setTourId(destinationsList_Data.tour_Id);
        return builder2.build();
    }

    private static User userFromUserListData(UserList_Data userList_Data) {
        return User.getInstance(userList_Data.userName.toString(), userList_Data.userType == 0);
    }

    private static Service serviceFromServiceListData(ServiceList_Data serviceList_Data) {
        License.Builder builder = License.builder();
        builder.setActivationDate(serviceList_Data.dateOfActivation.toString());
        builder.setExpirationDate(serviceList_Data.dateOfExpiry.toString());
        builder.setId(serviceList_Data.licenseId.toString());
        builder.setState(serviceList_Data.licenseState);
        builder.setValidityDuration(serviceList_Data.periodOfValidity.toString());
        Service.Builder builder2 = Service.builder();
        builder2.setEnabled(serviceList_Data.serviceState.serviceEnabled);
        builder2.setEnabledByUser(serviceList_Data.userSettings.serviceActivatedAllowedByDriver);
        builder2.setAllowedByVehicle(serviceList_Data.userSettings.serviceAllowedByVehicle);
        builder2.setHasExpirationWarning(serviceList_Data.serviceState.licenseExpirationWarning);
        builder2.setId(serviceList_Data.serviceId.toString());
        builder2.setInternalId(serviceList_Data.getPos());
        builder2.setLicense(builder.build());
        builder2.setGPSRequired(BAPArrayDataENI.isGPSRequired(serviceList_Data));
        builder2.setName(serviceList_Data.serviceName.toString());
        builder2.setProtected(serviceList_Data.serviceState.protectedService);
        builder2.setDisablingByDriverAllowed(serviceList_Data.serviceState.disablingByDriverAllowedDf3_3);
        builder2.setRoamingAllowed(serviceList_Data.serviceState.roamingAllowed);
        builder2.setVersion(serviceList_Data.serviceVersion.toString());
        return builder2.build();
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
}

