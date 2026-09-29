/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.operatorcall.data;

import de.audi.atip.util.StringUtilities;
import de.esolutions.fw.util.commons.Buffer;
import java.io.DataOutputStream;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.online.OperatorCallAddressEntry;
import org.dsi.ifc.online.OperatorCallResult;

public class OperatorCallPoiStorage {
    private final String serviceId;
    private final int serviceType;
    private final String name;
    private final String street;
    private final String zip;
    private final String city;
    private final String region;
    private final String country;
    private final String phoneNumber;
    private final String url;
    private final String statusURL;
    private final int longitude;
    private final int latitude;

    public OperatorCallPoiStorage(OperatorCallResult operatorCallResult) {
        this.serviceId = operatorCallResult.serviceId;
        this.serviceType = operatorCallResult.serviceType;
        this.name = operatorCallResult.name;
        OperatorCallAddressEntry operatorCallAddressEntry = operatorCallResult.getAddress();
        if (operatorCallAddressEntry != null) {
            this.street = operatorCallAddressEntry.getStreet();
            this.zip = operatorCallAddressEntry.getZip();
            this.city = operatorCallAddressEntry.getCity();
            this.region = operatorCallAddressEntry.getRegion();
            this.country = operatorCallAddressEntry.getCountry();
            this.phoneNumber = operatorCallAddressEntry.getPhoneNumber();
            this.url = operatorCallAddressEntry.getUrl();
            this.statusURL = operatorCallAddressEntry.getStatusURL();
        } else {
            this.street = null;
            this.zip = null;
            this.city = null;
            this.region = null;
            this.country = null;
            this.phoneNumber = null;
            this.url = null;
            this.statusURL = null;
        }
        NavLocationWgs84 navLocationWgs84 = operatorCallResult.getLocation();
        this.longitude = navLocationWgs84.getLongitude();
        this.latitude = navLocationWgs84.getLatitude();
    }

    public String getServiceId() {
        return this.serviceId;
    }

    public int getServiceType() {
        return this.serviceType;
    }

    public String getName() {
        return this.name;
    }

    public OperatorCallAddressEntry getAddress() {
        return new OperatorCallAddressEntry(this.street, this.zip, this.city, this.region, this.country, this.phoneNumber, this.url, this.statusURL);
    }

    public NavLocationWgs84 getLocation() {
        return new NavLocationWgs84(this.longitude, this.latitude);
    }

    public void serialize(DataOutputStream dataOutputStream) {
        dataOutputStream.writeUTF(this.serviceId);
        dataOutputStream.writeInt(this.serviceType);
        dataOutputStream.writeUTF(this.name);
        dataOutputStream.writeUTF(StringUtilities.getStringNotNull(this.street));
        dataOutputStream.writeUTF(StringUtilities.getStringNotNull(this.zip));
        dataOutputStream.writeUTF(StringUtilities.getStringNotNull(this.city));
        dataOutputStream.writeUTF(StringUtilities.getStringNotNull(this.region));
        dataOutputStream.writeUTF(StringUtilities.getStringNotNull(this.country));
        dataOutputStream.writeUTF(StringUtilities.getStringNotNull(this.phoneNumber));
        dataOutputStream.writeUTF(StringUtilities.getStringNotNull(this.url));
        dataOutputStream.writeUTF(StringUtilities.getStringNotNull(this.statusURL));
        dataOutputStream.writeInt(this.latitude);
        dataOutputStream.writeInt(this.longitude);
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("*****\nserviceId = ");
        buffer.append(this.serviceId);
        buffer.append("\nserviceType = ");
        buffer.append(this.serviceType);
        buffer.append("\nname = ");
        buffer.append(this.name);
        buffer.append("\nstreet = ");
        buffer.append(StringUtilities.getStringNotNull(this.street));
        buffer.append("\nzip = ");
        buffer.append(StringUtilities.getStringNotNull(this.zip));
        buffer.append("\ncity = ");
        buffer.append(StringUtilities.getStringNotNull(this.city));
        buffer.append("\nregion = ");
        buffer.append(StringUtilities.getStringNotNull(this.region));
        buffer.append("\ncountry = ");
        buffer.append(StringUtilities.getStringNotNull(this.country));
        buffer.append("\nphoneNumber = ");
        buffer.append(StringUtilities.getStringNotNull(this.phoneNumber));
        buffer.append("\nurl = ");
        buffer.append(StringUtilities.getStringNotNull(this.url));
        buffer.append("\nstatusURL = ");
        buffer.append(StringUtilities.getStringNotNull(this.statusURL));
        buffer.append("\nlatitude = ");
        buffer.append(this.latitude);
        buffer.append("\nlongitude = ");
        buffer.append(this.longitude);
        return buffer.toString();
    }
}

