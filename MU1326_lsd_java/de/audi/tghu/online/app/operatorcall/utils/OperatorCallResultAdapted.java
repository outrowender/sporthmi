/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.operatorcall.utils;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.online.app.Online;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.online.OperatorCallAddressEntry;
import org.dsi.ifc.online.OperatorCallResult;

public class OperatorCallResultAdapted
extends OperatorCallResult {
    private final LogChannel logChannel = Online.getInstance().getOperatorCallLogChannel();
    private Buffer buffer = new Buffer();

    public OperatorCallResultAdapted(OperatorCallResult operatorCallResult) {
        this.serviceType = operatorCallResult.getServiceType();
        this.location = operatorCallResult.getLocation();
        this.name = this.trimString("poiName", operatorCallResult.getName(), 40);
        this.address = this.trimAddress(operatorCallResult.getAddress());
        this.serviceId = this.trimString("serviceId", operatorCallResult.getServiceId(), 40);
        this.logChannel.log(1078071040, this.buffer.toString());
    }

    private OperatorCallAddressEntry trimAddress(OperatorCallAddressEntry operatorCallAddressEntry) {
        OperatorCallAddressEntry operatorCallAddressEntry2 = new OperatorCallAddressEntry();
        operatorCallAddressEntry2.street = this.trimString("street", operatorCallAddressEntry.getStreet(), 40);
        operatorCallAddressEntry2.zip = this.trimString("zip", operatorCallAddressEntry.getZip(), 40);
        operatorCallAddressEntry2.city = this.trimString("city", operatorCallAddressEntry.getCity(), 40);
        operatorCallAddressEntry2.region = this.trimString("region", operatorCallAddressEntry.getRegion(), 40);
        operatorCallAddressEntry2.country = this.trimString("country", operatorCallAddressEntry.getCountry(), 40);
        operatorCallAddressEntry2.phoneNumber = this.trimString("phoneNumber", operatorCallAddressEntry.getPhoneNumber(), 40);
        operatorCallAddressEntry2.url = this.trimString("url", operatorCallAddressEntry.getUrl(), 255);
        operatorCallAddressEntry2.statusURL = this.trimString("statusURL", operatorCallAddressEntry.getStatusURL(), 255);
        return operatorCallAddressEntry2;
    }

    private String trimString(String string, String string2, int n) {
        this.buffer.append("OperatorCallResultAdapted#trimString: element=");
        this.buffer.append(string);
        this.buffer.append(", maxTrimLength = ");
        this.buffer.append(n);
        if (string2 != null) {
            this.buffer.append("\nstring before:");
            this.buffer.append(string2);
            int n2 = Math.min(string2.length(), n);
            this.buffer.append("\nstring will be cut at length ");
            this.buffer.append(n2);
            String string3 = string2.substring(0, n2);
            this.buffer.append("\nstring after: ");
            this.buffer.append(string3);
            this.buffer.append("\n\n");
            return string3;
        }
        this.buffer.append("string is null.\n\n");
        return null;
    }
}

