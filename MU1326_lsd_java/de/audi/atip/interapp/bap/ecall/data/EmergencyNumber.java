/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.bap.ecall.data;

public class EmergencyNumber {
    private String id;
    private String telNumber;

    public static Builder builder() {
        return new Builder();
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
        if (this.getClass() != object.getClass()) {
            return false;
        }
        EmergencyNumber emergencyNumber = (EmergencyNumber)object;
        if (this.id == null ? emergencyNumber.id != null : !this.id.equals(emergencyNumber.id)) {
            return false;
        }
        return !(this.telNumber == null ? emergencyNumber.telNumber != null : !this.telNumber.equals(emergencyNumber.telNumber));
    }

    public static final class Builder {
        private String id;
        private String telNumber;

        public Builder setId(String string) {
            this.id = string;
            return this;
        }

        public Builder setTelNumber(String string) {
            this.telNumber = string;
            return this;
        }

        public EmergencyNumber build() {
            return new EmergencyNumber(this.id, this.telNumber);
        }
    }
}

