/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.setup;

import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.setup.IRouteCriteria;
import de.audi.tghu.navi.app.setup.IRouteCriteriaModelAccess;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.navigation.RouteOptions;

public abstract class RouteCriterialCoreModelAccess
implements IRouteCriteriaModelAccess {
    protected final NavigationEnv env;

    public RouteCriterialCoreModelAccess(NavigationEnv navigationEnv) {
        this.env = navigationEnv;
    }

    @Override
    public void onStart(IRouteCriteria iRouteCriteria) {
        this.env.getLogChannel().log(-2137614336, "RouteCriteriaModelAccess#onStart() - %1", (Object)iRouteCriteria);
        this.onUpdateCriteria(iRouteCriteria);
    }

    protected void onUpdateCriteria(IRouteCriteria iRouteCriteria) {
        this.env.getLogChannel().log(-2137614336, "RouteCriteriaModelAccess#onUpdateCriteria() - %1", (Object)iRouteCriteria);
        this.setTrafficReroutingModel(iRouteCriteria.getTrafficRerouting());
        this.setFreewaysModel(iRouteCriteria.getFreeways() == 1);
        this.setVignetteChoiceModel(iRouteCriteria.getVignettes());
        this.setTollRoadsModel(iRouteCriteria.getTollRoads() == 1);
        this.setFerriesModel(iRouteCriteria.getFerries() == 1);
        this.setMotorrail(iRouteCriteria.getMotorrail() == 1);
        this.setTimeRestricted(iRouteCriteria.getTimeRestrictedRoads());
        this.setSeasonalRestricted(iRouteCriteria.getSeasonRestricted());
        this.setTrailerModel(iRouteCriteria.getTrailer());
        this.setRouteCalcType(iRouteCriteria.getRouteOptions(true)[0]);
        this.setTunnelsModel(iRouteCriteria.getTunnels() == 1);
        this.setHovLanesModel(iRouteCriteria.getHovLanes() == 1);
    }

    protected void setRouteCalcType(RouteOptions routeOptions) {
        int n;
        int n2 = routeOptions.getRouteType();
        switch (n2) {
            case 0: 
            case 9: {
                if ((Util.isHURegionJP() || Util.isHURegionKR()) && !Util.isPorsche(this.env.getFramework())) {
                    n = 5;
                    break;
                }
                n = 1;
                break;
            }
            case 1: {
                n = 2;
                break;
            }
            case 7: 
            case 10: {
                n = 0;
                break;
            }
            case 5: {
                if (routeOptions.getTollroads() == 1) {
                    n = 3;
                    break;
                }
                n = 4;
                break;
            }
            default: {
                this.env.getLogChannel().log(-2137614336, "RouteCriterialCoreModelAccess#setRouteCalcType - unknown route calculation type: %1, ignoring call", (long)n2);
                return;
            }
        }
        this.env.getChoiceModel(1025312256).setValue(n);
    }

    protected void setVignetteChoiceModel(int n) {
        int n2 = 0;
        if (n == 1) {
            n2 = 0;
        } else if (n == 2) {
            n2 = 1;
        } else if (n == 7) {
            n2 = 2;
        }
        if (this.env.getChoiceModel(924648960).getValue() != n2) {
            this.env.getChoiceModel(924648960).setValue(n2);
        }
    }

    protected void setTollRoadsModel(boolean bl) {
        int n;
        int n2 = n = bl ? 0 : 1;
        if (this.env.getChoiceModel(874317312).getValue() != n) {
            this.env.getChoiceModel(874317312).setValue(n);
        }
    }

    protected void setTunnelsModel(boolean bl) {
        int n;
        int n2 = n = bl ? 0 : 1;
        if (this.env.getChoiceModel(907871744).getValue() != n) {
            this.env.getChoiceModel(907871744).setValue(n);
        }
    }

    protected void setHovLanesModel(boolean bl) {
        int n;
        int n2 = n = bl ? 0 : 1;
        if (this.env.getChoiceModel(857540096).getValue() != n) {
            this.env.getChoiceModel(857540096).setValue(n);
        }
    }

    protected void setFerriesModel(boolean bl) {
        int n;
        int n2 = n = bl ? 0 : 1;
        if (this.env.getChoiceModel(823985664).getValue() != n) {
            this.env.getChoiceModel(823985664).setValue(n);
        }
    }

    protected void setMotorrail(boolean bl) {
        int n;
        int n2 = n = bl ? 0 : 1;
        if (this.env.getChoiceModel(891094528).getValue() != n) {
            this.env.getChoiceModel(891094528).setValue(n);
        }
    }

    protected void setTimeRestricted(int n) {
        int n2 = 0;
        if (n == 1) {
            n2 = 1;
        } else if (n == 2) {
            n2 = 2;
        } else if (n == 3) {
            n2 = 0;
        }
        if (this.env.getChoiceModel(790431232).getValue() != n2) {
            this.env.getChoiceModel(790431232).setValue(n2);
        }
    }

    protected void setSeasonalRestricted(int n) {
        if (this.env.getChoiceModel(1042089472).getValue() != n) {
            this.env.getChoiceModel(1042089472).setValue(n);
        }
    }

    protected abstract void setTrailerModel(int n) {
    }

    protected abstract void setFreewaysModel(boolean bl) {
    }

    protected abstract void setTrafficReroutingModel(int n) {
    }
}

