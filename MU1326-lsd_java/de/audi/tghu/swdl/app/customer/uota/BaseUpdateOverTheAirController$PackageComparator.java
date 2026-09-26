/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.customer.uota;

import de.audi.tghu.swdl.app.customer.uota.BaseUpdateOverTheAirController;
import de.audi.tghu.swdl.app.customer.uota.UotaPkgInfoWrapper;
import java.util.Comparator;

class BaseUpdateOverTheAirController$PackageComparator
implements Comparator {
    private final /* synthetic */ BaseUpdateOverTheAirController this$0;

    BaseUpdateOverTheAirController$PackageComparator(BaseUpdateOverTheAirController baseUpdateOverTheAirController) {
        this.this$0 = baseUpdateOverTheAirController;
    }

    protected boolean isSysProposalPriority(int n) {
        return n >= 1000 && n <= 2000;
    }

    @Override
    public int compare(Object object, Object object2) {
        if (object instanceof UotaPkgInfoWrapper && object2 instanceof UotaPkgInfoWrapper) {
            UotaPkgInfoWrapper uotaPkgInfoWrapper = (UotaPkgInfoWrapper)object;
            UotaPkgInfoWrapper uotaPkgInfoWrapper2 = (UotaPkgInfoWrapper)object2;
            boolean bl = this.isSysProposalPriority(uotaPkgInfoWrapper.getPriority());
            boolean bl2 = this.isSysProposalPriority(uotaPkgInfoWrapper2.getPriority());
            if (uotaPkgInfoWrapper.getPriority() == uotaPkgInfoWrapper2.getPriority()) {
                if (uotaPkgInfoWrapper.getReleaseVersion() == uotaPkgInfoWrapper2.getReleaseVersion()) {
                    return uotaPkgInfoWrapper.getLastName().compareTo(uotaPkgInfoWrapper2.getLastName());
                }
                return uotaPkgInfoWrapper2.getReleaseVersion().compareTo(uotaPkgInfoWrapper.getReleaseVersion());
            }
            if (bl && !bl2) {
                return -1;
            }
            if (!bl && bl2) {
                return 1;
            }
            if (uotaPkgInfoWrapper.getPriority() < uotaPkgInfoWrapper2.getPriority() && uotaPkgInfoWrapper.getPriority() > 0) {
                return -1;
            }
            return 1;
        }
        return object instanceof UotaPkgInfoWrapper ? 1 : 0;
    }
}

