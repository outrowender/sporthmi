/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.bap.ecall.data;

import de.audi.atip.interapp.bap.ecall.data.EmergencyNumber;

public final class EmergencyNumber$Builder {
    private String id;
    private String telNumber;

    public EmergencyNumber$Builder setId(String string) {
        this.id = string;
        return this;
    }

    public EmergencyNumber$Builder setTelNumber(String string) {
        this.telNumber = string;
        return this;
    }

    public EmergencyNumber build() {
        return new EmergencyNumber(this.id, this.telNumber);
    }
}

