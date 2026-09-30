/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.setup;

import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.setup.IRouteCriteria;
import de.audi.tghu.navi.app.setup.IRouteCriteriaConfiguration;
import de.audi.tghu.navi.app.util.Util;

public class RouteCriteriaEvoConfiguration
implements IRouteCriteriaConfiguration {
    public void initRouteCriteria(IRouteCriteria iRouteCriteria) {
        if (Util.isHURegionNAR()) {
            this.setCriteriaForNAR(iRouteCriteria);
        } else if (Util.isHURegionAsia()) {
            if (Util.isHURegionCN() || Util.isHURegionTW()) {
                this.setCriteriaForCNTW(iRouteCriteria);
            }
            if (Util.isHURegionJP() || Util.isHURegionKR()) {
                this.setCriteriaForJPKR(iRouteCriteria);
            }
        } else if (Util.isHURegionRdW()) {
            this.setCriteriaForRdW(iRouteCriteria);
        } else {
            this.setCriteriaForEU(iRouteCriteria);
        }
    }

    private void setCriteriaForRdW(IRouteCriteria iRouteCriteria) {
        iRouteCriteria.setTrafficRerouting(3);
        iRouteCriteria.setFreeways(1);
        iRouteCriteria.setVignettes(1);
        iRouteCriteria.setVignetteCountries(new int[0]);
        iRouteCriteria.setTollRoads(1);
        iRouteCriteria.setFerries(1);
        iRouteCriteria.setMotorrail(1);
        iRouteCriteria.setTimeRestrictedRoads(3);
        iRouteCriteria.setSeasonRestricted(3);
        iRouteCriteria.setTrailer(6);
        iRouteCriteria.setRouteOption(-1);
        iRouteCriteria.setUnpaved(1);
        iRouteCriteria.setIpd(1);
    }

    private void setCriteriaForNAR(IRouteCriteria iRouteCriteria) {
        iRouteCriteria.setTrafficRerouting(4);
        iRouteCriteria.setTollRoads(1);
        iRouteCriteria.setHovLanes(2);
        iRouteCriteria.setFreeways(1);
        iRouteCriteria.setFerries(1);
        iRouteCriteria.setSeasonRestricted(3);
        iRouteCriteria.setTimeRestrictedRoads(3);
        iRouteCriteria.setRouteOption(-1);
        iRouteCriteria.setTrailer(6);
        iRouteCriteria.setUnpaved(0);
        iRouteCriteria.setIpd(0);
    }

    private void setCriteriaForJPKR(IRouteCriteria iRouteCriteria) {
        iRouteCriteria.setRouteOption(5);
        iRouteCriteria.setTollRoads(1);
        iRouteCriteria.setFerries(Util.isHURegionKR() ? 2 : 1);
        iRouteCriteria.setTrafficRerouting(3);
        iRouteCriteria.setFreeways(1);
        iRouteCriteria.setMotorrail(1);
        iRouteCriteria.setTimeRestrictedRoads(1);
        iRouteCriteria.setSeasonRestricted(3);
        iRouteCriteria.setTrailer(6);
        iRouteCriteria.setUnpaved(0);
        iRouteCriteria.setIpd(0);
    }

    private void setCriteriaForCNTW(IRouteCriteria iRouteCriteria) {
        iRouteCriteria.setRouteOption(0);
        iRouteCriteria.setTollRoads(1);
        iRouteCriteria.setTrafficRerouting(3);
        iRouteCriteria.setFreeways(1);
        iRouteCriteria.setMotorrail(1);
        iRouteCriteria.setTimeRestrictedRoads(1);
        iRouteCriteria.setSeasonRestricted(3);
        iRouteCriteria.setTrailer(6);
        iRouteCriteria.setHovLanes(0);
        iRouteCriteria.setUnpaved(0);
    }

    private void setCriteriaForEU(IRouteCriteria iRouteCriteria) {
        iRouteCriteria.setTrafficRerouting(3);
        iRouteCriteria.setFreeways(1);
        iRouteCriteria.setVignettes(1);
        iRouteCriteria.setVignetteCountries(new int[0]);
        iRouteCriteria.setTollRoads(1);
        iRouteCriteria.setFerries(1);
        iRouteCriteria.setMotorrail(1);
        iRouteCriteria.setTimeRestrictedRoads(3);
        iRouteCriteria.setSeasonRestricted(3);
        iRouteCriteria.setTrailer(6);
        iRouteCriteria.setRouteOption(-1);
        iRouteCriteria.setUnpaved(2);
        iRouteCriteria.setIpd(2);
    }

    public void checkForEncodedTrailer(IRouteCriteria iRouteCriteria, NavigationEnv navigationEnv) {
        if (!Util.isTrailerModeAvailable(navigationEnv.getFramework())) {
            iRouteCriteria.setTrailer(6);
        }
    }

    public void checkForRegionConsistency(IRouteCriteria iRouteCriteria) {
        if (Util.isHURegionNAR()) {
            this.resetWrongCriteriaForNAR(iRouteCriteria);
        } else if (Util.isHURegionAsia()) {
            if (Util.isHURegionCN() || Util.isHURegionTW()) {
                this.resetWrongCriteriaForCNTW(iRouteCriteria);
            }
            if (Util.isHURegionJP() || Util.isHURegionKR()) {
                this.resetWrongCriteriaForJPKR(iRouteCriteria);
            }
        } else if (Util.isHURegionRdW()) {
            this.resetWrongCriteriaForRdW(iRouteCriteria);
        } else {
            this.resetWrongCriteriaForEU(iRouteCriteria);
        }
    }

    private void resetWrongCriteriaForRdW(IRouteCriteria iRouteCriteria) {
        iRouteCriteria.setHovLanes(0);
        iRouteCriteria.setUnpaved(1);
        iRouteCriteria.setIpd(1);
    }

    private void resetWrongCriteriaForEU(IRouteCriteria iRouteCriteria) {
        iRouteCriteria.setHovLanes(0);
        iRouteCriteria.setUnpaved(2);
        iRouteCriteria.setIpd(2);
    }

    private void resetWrongCriteriaForCNTW(IRouteCriteria iRouteCriteria) {
        iRouteCriteria.setFerries(0);
        iRouteCriteria.setHovLanes(0);
        iRouteCriteria.setUnpaved(0);
        iRouteCriteria.setIpd(0);
        iRouteCriteria.setVignettes(0);
        iRouteCriteria.setVignetteCountries(new int[0]);
    }

    private void resetWrongCriteriaForJPKR(IRouteCriteria iRouteCriteria) {
        iRouteCriteria.setHovLanes(0);
        iRouteCriteria.setUnpaved(0);
        iRouteCriteria.setIpd(0);
        iRouteCriteria.setVignettes(0);
        iRouteCriteria.setVignetteCountries(new int[0]);
    }

    private void resetWrongCriteriaForNAR(IRouteCriteria iRouteCriteria) {
        iRouteCriteria.setVignettes(0);
        iRouteCriteria.setVignetteCountries(new int[0]);
        iRouteCriteria.setTimeRestrictedRoads(3);
        iRouteCriteria.setSeasonRestricted(3);
        iRouteCriteria.setMotorrail(0);
        iRouteCriteria.setUnpaved(0);
        iRouteCriteria.setIpd(0);
    }
}

