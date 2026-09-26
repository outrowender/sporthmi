/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.bap.ecall.data;

import de.audi.atip.interapp.bap.ecall.data.EmergencyNumber$Builder;

public class EmergencyNumber {
    private String id;
    private String telNumber;

    public static EmergencyNumber$Builder builder() {
        return new EmergencyNumber$Builder();
    }

    private EmergencyNumber(String string, String string2) {
        this.id = string;
        this.telNumber = string2;
    }

    public String getId() {
        return this.id;
    }

    public String getTelNumber() {
        return this.telNumber;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("EmergencyNumber [");
        stringBuffer.append("id=").append(this.getId());
        stringBuffer.append(", telNumber=").append(this.getTelNumber());
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + (this.id == null ? 0 : this.id.hashCode());
        n = 31 * n + (this.telNumber == null ? 0 : this.telNumber.hashCode());
        return n;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (super.getClass() != object.getClass()) {
            return false;
        }
        EmergencyNumber emergencyNumber = (EmergencyNumber)object;
        if (this.id == null ? emergencyNumber.id != null : !this.id.equals(emergencyNumber.id)) {
            return false;
        }
        return !(this.telNumber == null ? emergencyNumber.telNumber != null : !this.telNumber.equals(emergencyNumber.telNumber));
    }
}

