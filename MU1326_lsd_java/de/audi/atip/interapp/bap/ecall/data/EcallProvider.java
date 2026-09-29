/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.bap.ecall.data;

public final class EcallProvider {
    private final boolean nameAvailable;
    private final String name;

    public static EcallProvider getInstance(boolean bl, String string) {
        return new EcallProvider(bl, string);
    }

    private EcallProvider(boolean bl, String string) {
        this.nameAvailable = bl;
        this.name = string;
    }

    public boolean isNameAvailable() {
        return this.nameAvailable;
    }

    public String getName() {
        return this.name;
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + (this.nameAvailable ? 1231 : 1237);
        n = 31 * n + (this.name == null ? 0 : this.name.hashCode());
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
        EcallProvider ecallProvider = (EcallProvider)object;
        if (this.nameAvailable != ecallProvider.nameAvailable) {
            return false;
        }
        return !(this.name == null ? ecallProvider.name != null : !this.name.equals(ecallProvider.name));
    }

    public String toString() {
        return new StringBuffer().append("Provider [available=").append(this.nameAvailable).append(", name=").append(this.name).append("]").toString();
    }
}

