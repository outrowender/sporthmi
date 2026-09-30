/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.bap.ecall.data;

import de.esolutions.fw.util.commons.Buffer;

public final class PhoneCall {
    private final int id;
    private final int kind;
    private final int state;

    public static PhoneCall getInstance(int n, int n2, int n3) {
        return new PhoneCall(n, n2, n3);
    }

    public static PhoneCall getNullInstance() {
        return PhoneCall.getInstance(-1, 0, 0);
    }

    private PhoneCall(int n, int n2, int n3) {
        this.id = n;
        this.kind = n2;
        this.state = n3;
    }

    public int getId() {
        return this.id;
    }

    public int getKind() {
        return this.kind;
    }

    public int getState() {
        return this.state;
    }

    public boolean isServiceCall() {
        return this.getKind() == 7;
    }

    public boolean isLowPrioritySOSCall() {
        return this.getKind() == 1;
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + this.id;
        n = 31 * n + this.kind;
        n = 31 * n + this.state;
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
        PhoneCall phoneCall = (PhoneCall)object;
        if (this.id != phoneCall.id) {
            return false;
        }
        if (this.kind != phoneCall.kind) {
            return false;
        }
        return this.state == phoneCall.state;
    }

    public String toString() {
        return new Buffer("PhoneCall [id=").append(this.id).append(", kind=").append(this.kind).append(", state=").append(this.state).append("]").toString();
    }
}

