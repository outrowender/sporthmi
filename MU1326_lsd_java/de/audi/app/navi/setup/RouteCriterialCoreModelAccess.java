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

    public void onStart(IRouteCriteria iRouteCriteria) {
        this.env.getLogChannel().log(10000000, "RouteCriteriaModelAccess#onStart() - %1", (Object)iRouteCriteria);
        this.onUpdateCriteria(iRouteCriteria);
    }

    protected void onUpdateCriteria(IRouteCriteria iRouteCriteria) {
        this.env.getLogChannel().log(10000000, "RouteCriteriaModelAccess#onUpdateCriteria() - %1", (Object)iRouteCriteria);
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
                this.env.getLogChannel().log(10000000, "RouteCriterialCoreModelAccess#setRouteCalcType - unknown route calculation type: %1, ignoring call", (long)n2);
                return;
            }
        }
        this.env.getChoiceModel(400701).setValue(n);
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
        if (this.env.getChoiceModel(400695).getValue() != n2) {
            this.env.getChoiceModel(400695).setValue(n2);
        }
    }

    protected void setTollRoadsModel(boolean bl) {
        int n;
        int n2 = n = bl ? 0 : 1;
        if (this.env.getChoiceModel(400692).getValue() != n) {
            this.env.getChoiceModel(400692).setValue(n);
        }
    }

    protected void setTunnelsModel(boolean bl) {
        int n;
        int n2 = n = bl ? 0 : 1;
        if (this.env.getChoiceModel(400694).getValue() != n) {
            this.env.getChoiceModel(400694).setValue(n);
        }
    }

    protected void setHovLanesModel(boolean bl) {
        int n;
        int n2 = n = bl ? 0 : 1;
        if (this.env.getChoiceModel(400691).getValue() != n) {
            this.env.getChoiceModel(400691).setValue(n);
        }
    }

    protected void setFerriesModel(boolean bl) {
        int n;
        int n2 = n = bl ? 0 : 1;
        if (this.env.getChoiceModel(400689).getValue() != n) {
            this.env.getChoiceModel(400689).setValue(n);
        }
    }

    protected void setMotorrail(boolean bl) {
        int n;
        int n2 = n = bl ? 0 : 1;
        if (this.env.getChoiceModel(400693).getValue() != n) {
            this.env.getChoiceModel(400693).setValue(n);
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
        if (this.env.getChoiceModel(400687).getValue() != n2) {
            this.env.getChoiceModel(400687).setValue(n2);
        }
    }

    protected void setSeasonalRestricted(int n) {
        if (this.env.getChoiceModel(400702).getValue() != n) {
            this.env.getChoiceModel(400702).setValue(n);
        }
    }

    protected abstract void setTrailerModel(int var1);

    protected abstract void setFreewaysModel(boolean var1);

    protected abstract void setTrafficReroutingModel(int var1);
}

