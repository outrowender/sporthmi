/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.combi.bap.phone.data;

import de.audi.atip.interapp.combi.bap.phone.data.FsgSetup$Builder;

public final class FsgSetup {
    private final boolean internalSimCardReaderPresent;
    private final boolean cableConnectionPossible;
    private final boolean hfpConnectionPossible;
    private final boolean rsapConnectionPossible;
    private final boolean appleLinkConnectionPossible;
    private final boolean googleLinkConnectionPossible;
    private final int mobileConnectionType;

    public static FsgSetup$Builder builder() {
        return new FsgSetup$Builder();
    }

    private FsgSetup(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, int n) {
        this.internalSimCardReaderPresent = bl;
        this.cableConnectionPossible = bl2;
        this.hfpConnectionPossible = bl3;
        this.rsapConnectionPossible = bl4;
        this.appleLinkConnectionPossible = bl5;
        this.googleLinkConnectionPossible = bl6;
        this.mobileConnectionType = n;
    }

    public boolean isInternalSimCardReaderPresent() {
        return this.internalSimCardReaderPresent;
    }

    public boolean isCableConnectionPossible() {
        return this.cableConnectionPossible;
    }

    public boolean isHfpConnectionPossible() {
        return this.hfpConnectionPossible;
    }

    public boolean isRsapConnectionPossible() {
        return this.rsapConnectionPossible;
    }

    public boolean isAppleLinkConnectionPossible() {
        return this.appleLinkConnectionPossible;
    }

    public boolean isGoogleLinkConnectionPossible() {
        return this.googleLinkConnectionPossible;
    }

    public int getMobileConnectionType() {
        return this.mobileConnectionType;
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
        FsgSetup fsgSetup = (FsgSetup)object;
        if (this.appleLinkConnectionPossible != fsgSetup.appleLinkConnectionPossible) {
            return false;
        }
        if (this.cableConnectionPossible != fsgSetup.cableConnectionPossible) {
            return false;
        }
        if (this.googleLinkConnectionPossible != fsgSetup.googleLinkConnectionPossible) {
            return false;
        }
        if (this.hfpConnectionPossible != fsgSetup.hfpConnectionPossible) {
            return false;
        }
        if (this.internalSimCardReaderPresent != fsgSetup.internalSimCardReaderPresent) {
            return false;
        }
        if (this.mobileConnectionType != fsgSetup.mobileConnectionType) {
            return false;
        }
        return this.rsapConnectionPossible == fsgSetup.rsapConnectionPossible;
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + (this.appleLinkConnectionPossible ? 1231 : 1237);
        n = 31 * n + (this.cableConnectionPossible ? 1231 : 1237);
        n = 31 * n + (this.googleLinkConnectionPossible ? 1231 : 1237);
        n = 31 * n + (this.hfpConnectionPossible ? 1231 : 1237);
        n = 31 * n + (this.internalSimCardReaderPresent ? 1231 : 1237);
        n = 31 * n + this.mobileConnectionType;
        n = 31 * n + (this.rsapConnectionPossible ? 1231 : 1237);
        return n;
    }

    public String toString() {
        return new StringBuffer().append("FsgSetup [internalSimCardReaderPresent=").append(this.internalSimCardReaderPresent).append(", cableConnectionPossible=").append(this.cableConnectionPossible).append(", hfpConnectionPossible=").append(this.hfpConnectionPossible).append(", rsapConnectionPossible=").append(this.rsapConnectionPossible).append(", appleLinkConnectionPossible=").append(this.appleLinkConnectionPossible).append(", googleLinkConnectionPossible=").append(this.googleLinkConnectionPossible).append(", mobileConnectionType=").append(this.mobileConnectionType).append("]").toString();
    }
}

