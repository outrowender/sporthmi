/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.onlinelogo;

import de.audi.atip.onlinelogo.FileCheckSumCalculator;
import de.audi.atip.onlinelogo.OnlineLogoItem$1;
import de.audi.atip.onlinelogo.OnlineLogoItem$OnlineLogoIOWrapper;

final class OnlineLogoItem$OnlineLogoIOWrapperImpl
extends OnlineLogoItem$OnlineLogoIOWrapper {
    private OnlineLogoItem$OnlineLogoIOWrapperImpl() {
        super(null);
    }

    @Override
    public String computeChecksum(String string) {
        return new FileCheckSumCalculator().calcChecksum(string);
    }

    /* synthetic */ OnlineLogoItem$OnlineLogoIOWrapperImpl(OnlineLogoItem$1 onlineLogoItem$1) {
        this();
    }
}

