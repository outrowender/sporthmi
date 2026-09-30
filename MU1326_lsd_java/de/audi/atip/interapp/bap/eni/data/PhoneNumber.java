/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.bap.eni.data;

public final class PhoneNumber {
    private final String phoneNumber;

    public static PhoneNumber getInstance(String string) {
        return new PhoneNumber(string);
    }

    private PhoneNumber(String string) {
        this.phoneNumber = string;
    }

    public String getNumber() {
        return this.phoneNumber;
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + (this.phoneNumber == null ? 0 : this.phoneNumber.hashCode());
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
        PhoneNumber phoneNumber = (PhoneNumber)object;
        return !(this.phoneNumber == null ? phoneNumber.phoneNumber != null : !this.phoneNumber.equals(phoneNumber.phoneNumber));
    }

    public String toString() {
        return "PhoneNumber [number=" + this.phoneNumber + "]";
    }
}

