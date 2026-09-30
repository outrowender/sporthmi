/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.interapp;

import de.audi.atip.interapp.NaviServiceListener;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.setup.IRouteCriteria;
import de.audi.tghu.navi.app.setup.IRouteCriteriaManager;
import de.audi.tghu.navi.app.setup.IRouteCriteriaModelAccess;
import de.audi.tghu.navi.app.setup.RouteCriteria;
import de.audi.tghu.navi.app.setup.RouteCriteriaSequence;
import de.audi.tghu.navi.app.util.Util;

public class RouteCriteriaInterAppService {
    private final IRouteCriteriaManager routeCriteriaManager;
    private final LogChannel logChannel;
    private final IRouteCriteriaModelAccess routeCriteriaModelAccess;
    private final RouteCriteriaSequence routeCriteriaSequence;
    private NavigationEnv env;

    public RouteCriteriaInterAppService(IRouteCriteriaManager iRouteCriteriaManager, LogChannel logChannel, IRouteCriteriaModelAccess iRouteCriteriaModelAccess, RouteCriteriaSequence routeCriteriaSequence, NavigationEnv navigationEnv) {
        this.routeCriteriaManager = iRouteCriteriaManager;
        this.logChannel = logChannel;
        this.routeCriteriaModelAccess = iRouteCriteriaModelAccess;
        this.routeCriteriaSequence = routeCriteriaSequence;
        this.env = navigationEnv;
    }

    public void setRouteOptionDynamic(int n, NaviServiceListener naviServiceListener) {
        int n2;
        this.logChannel.log(10000000, "RouteCriteriaInterAppService#setRouteOptionDynamic( %1 )", (long)n);
        if (n == 0) {
            n2 = 3;
        } else if (n == 1) {
            n2 = 4;
        } else if (n == 2) {
            n2 = 6;
        } else {
            this.logChannel.log(100000, "RouteCriteriaInterAppService#setRouteOptionDynamic( %1 ) - type is invalid!", (long)n);
            n2 = 3;
        }
        this.routeCriteriaSequence.finishSequence();
        RouteCriteria routeCriteria = new RouteCriteria(this.routeCriteriaManager.getRouteCriteria(), this.env);
        routeCriteria.setTrafficRerouting(n2);
        this.routeCriteriaManager.setRouteCriteria(routeCriteria);
        this.routeCriteriaManager.persistState();
        this.routeCriteriaModelAccess.onStart(routeCriteria);
        this.routeCriteriaSequence.startSequence();
        if (naviServiceListener != null) {
            naviServiceListener.responseSetRouteOptionDynamic((byte)0);
        }
    }

    public void setTrailer(boolean bl) {
        this.env.getChoiceModel(401782).setValue(bl ? 1 : 0);
        this.routeCriteriaSequence.finishSequence();
        this.routeCriteriaSequence.startSequence();
    }

    public void setRouteProfile(int n) {
        int n2;
        this.env.getLogChannel().log(10000000, "RouteCriteriaInterAppService#setRouteProfile - type: %1", (long)n);
        int n3 = -1;
        switch (n) {
            case 2: {
                n2 = 7;
                this.env.getChoiceModel(400701).setValue(0);
                break;
            }
            case 0: {
                n2 = 0;
                if ((Util.isHURegionJP() || Util.isHURegionKR()) && !Util.isPorsche(this.env.getFramework())) {
                    this.env.getChoiceModel(400701).setValue(5);
                    break;
                }
                this.env.getChoiceModel(400701).setValue(1);
                break;
            }
            case 1: {
                n2 = 1;
                this.env.getChoiceModel(400701).setValue(2);
                break;
            }
            case 3: {
                n2 = 5;
                n3 = 2;
                this.env.getChoiceModel(400701).setValue(4);
                break;
            }
            case 4: {
                n2 = 5;
                n3 = 1;
                this.env.getChoiceModel(400701).setValue(3);
                break;
            }
            default: {
                this.env.getLogChannel().log(100000, "RouteCriteriaInterAppService#setRouteProfile - invalid type", (long)n);
                return;
            }
        }
        this.routeCriteriaSequence.setRouteOption(n2);
        if (n2 == 5) {
            this.routeCriteriaSequence.setTollRoads(n3);
        }
        IRouteCriteria iRouteCriteria = this.routeCriteriaManager.getRouteCriteria();
        iRouteCriteria.setRouteOption(n2);
        if (n2 == 5) {
            iRouteCriteria.setTollRoads(n3);
        }
        this.routeCriteriaManager.setRouteCriteria(iRouteCriteria);
        this.routeCriteriaManager.persistState();
    }
}

