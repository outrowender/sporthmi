/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.phone;

public class PhoneSequenceElement {
    private String number;
    private boolean haptical;

    public PhoneSequenceElement(String string, boolean bl) {
        this.number = string;
        this.haptical = bl;
    }

    public String toString() {
        return this.haptical ? "(" + this.number + ")" : this.number;
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String string) {
        this.number = string;
    }

    public boolean isHaptical() {
        return this.haptical;
    }
}

