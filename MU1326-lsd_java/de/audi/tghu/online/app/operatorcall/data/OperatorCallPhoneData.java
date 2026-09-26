/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.operatorcall.data;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.online.app.Online;

public class OperatorCallPhoneData {
    private final LogChannel logChannel = Online.getInstance().getOperatorCallLogChannel();
    private String serviceId;
    private String[] operatorPhoneNumber;
    private int transferType;

    public void savePhoneData(String string, String[] stringArray, int n) {
        if (stringArray != null && string != null) {
            this.logChannel.log(-2137614336, "OperatorCallPhoneData#savePhoneData: serviceId = %1, number of phoneNumbers: %2", (Object)string, (long)stringArray.length);
        } else {
            if (string == null) {
                this.logChannel.log(-2137614336, "OperatorCallPhoneData#savePhoneData: serviceId is null.");
            }
            if (stringArray == null) {
                this.logChannel.log(-2137614336, "OperatorCallPhoneData#savePhoneData: array of phoneNumbers is null.");
            }
        }
        this.serviceId = string;
        this.operatorPhoneNumber = stringArray;
        this.transferType = n;
    }

    public String getServiceId() {
        return this.serviceId;
    }

    public String[] getOperatorPhoneNumber() {
        return this.operatorPhoneNumber;
    }

    public int getTransferType() {
        return this.transferType;
    }

    public void resetPhoneData() {
        this.savePhoneData(null, null, -1);
    }
}

