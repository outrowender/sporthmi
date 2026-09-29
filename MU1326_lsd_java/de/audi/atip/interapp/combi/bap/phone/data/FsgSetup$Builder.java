/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.combi.bap.phone.data;

import de.audi.atip.interapp.combi.bap.phone.data.FsgSetup;

public final class FsgSetup$Builder {
    private boolean internalSimCardReaderPresent;
    private boolean cableConnectionPossible;
    private boolean hfpConnectionPossible;
    private boolean rsapConnectionPossible;
    private boolean appleLinkConnectionPossible;
    private boolean googleLinkConnectionPossible;
    private int mobileConnectionType;

    public FsgSetup$Builder setInternalSimCardReaderPresent(boolean bl) {
        this.internalSimCardReaderPresent = bl;
        return this;
    }

    public FsgSetup$Builder setCableConnectionPossible(boolean bl) {
        this.cableConnectionPossible = bl;
        return this;
    }

    public FsgSetup$Builder setHfpConnectionPossible(boolean bl) {
        this.hfpConnectionPossible = bl;
        return this;
    }

    public FsgSetup$Builder setRsapConnectionPossible(boolean bl) {
        this.rsapConnectionPossible = bl;
        return this;
    }

    public FsgSetup$Builder setAppleLinkConnectionPossible(boolean bl) {
        this.appleLinkConnectionPossible = bl;
        return this;
    }

    public FsgSetup$Builder setGoogleLinkConnectionPossible(boolean bl) {
        this.googleLinkConnectionPossible = bl;
        return this;
    }

    public FsgSetup$Builder setMobileConnectionType(int n) {
        this.mobileConnectionType = n;
        return this;
    }

    public FsgSetup build() {
        return new FsgSetup(this.internalSimCardReaderPresent, this.cableConnectionPossible, this.hfpConnectionPossible, this.rsapConnectionPossible, this.appleLinkConnectionPossible, this.googleLinkConnectionPossible, this.mobileConnectionType);
    }
}

