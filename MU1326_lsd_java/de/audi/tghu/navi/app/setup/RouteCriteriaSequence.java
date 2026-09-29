/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.setup;

import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.IMatchspellerModelAccess;
import de.audi.tghu.navi.app.setup.IRouteCriteria;
import de.audi.tghu.navi.app.setup.IRouteCriteriaManager;
import de.audi.tghu.navi.app.setup.IRouteCriteriaModelAccess;
import de.audi.tghu.navi.app.setup.RouteCriteria;
import de.audi.tghu.navi.app.setup.VignetteCountryInputSequence;

public class RouteCriteriaSequence {
    private final NavigationEnv env;
    private final ICommandListFactory commandListFactory;
    private final IRouteCriteriaManager manager;
    private final IRouteCriteriaModelAccess modelAccess;
    private IRouteCriteria routeCriteria;

    public RouteCriteriaSequence(NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory, IRouteCriteriaManager iRouteCriteriaManager, IRouteCriteriaModelAccess iRouteCriteriaModelAccess) {
        this.env = navigationEnv;
        this.commandListFactory = iCommandListFactory;
        this.manager = iRouteCriteriaManager;
        this.modelAccess = iRouteCriteriaModelAccess;
    }

    public void resetSettings() {
        this.env.getLogChannel().log(-2137614336, "RouteCriteriaSequence#resetSettings()");
        this.manager.resetSettings();
        this.routeCriteria = null;
        this.startSequence();
    }

    public void startSequence() {
        this.env.getLogChannel().log(-2137614336, "[RouteGuidance] RouteCriteriaSequence#startSequence");
        this.routeCriteria = new RouteCriteria(this.manager.getRouteCriteria(), this.env);
        if (this.modelAccess != null) {
            this.modelAccess.onStart(this.routeCriteria);
        }
    }

    public void finishSequence() {
        this.env.getLogChannel().log(-2137614336, "[RouteGuidance] RouteCriteriaSequence#finishSequence()");
        if (this.routeCriteria == null) {
            this.env.getLogChannel().log(10000, "[RouteGuidance] RouteCriteriaSequence#finishSequence() - routeCriteria is null.");
            return;
        }
        this.manager.setRouteCriteria(this.routeCriteria);
        this.manager.persistState();
    }

    public void startCountriesSequence(IMatchspellerModelAccess iMatchspellerModelAccess, boolean bl) {
        VignetteCountryInputSequence vignetteCountryInputSequence = new VignetteCountryInputSequence(this.env, iMatchspellerModelAccess, this.commandListFactory);
        vignetteCountryInputSequence.start(bl);
    }

    public void setTrafficRerouting(int n) {
        this.routeCriteria.setTrafficRerouting(n);
    }

    public void setFreeways(int n) {
        this.routeCriteria.setFreeways(n);
    }

    public void setTollRoads(int n) {
        this.routeCriteria.setTollRoads(n);
    }

    public void setFerries(int n) {
        this.routeCriteria.setFerries(n);
    }

    public void setMotorrail(int n) {
        this.routeCriteria.setMotorrail(n);
    }

    public void setTimeRestrictedRoads(int n) {
        this.routeCriteria.setTimeRestrictedRoads(n);
    }

    public void setSeasonRestricted(int n) {
        this.routeCriteria.setSeasonRestricted(n);
    }

    public void setTrailer(int n) {
        this.routeCriteria.setTrailer(n);
    }

    public void setVignettes(int n) {
        this.routeCriteria.setVignettes(n);
    }

    public void setHovLanes(int n) {
        this.routeCriteria.setHovLanes(n);
    }

    public void setVignetteCountries(int[] nArray) {
        this.routeCriteria.setVignetteCountries(nArray);
    }

    public void setRouteOption(int n) {
        if (this.routeCriteria != null) {
            this.routeCriteria.setRouteOption(n);
        } else {
            this.env.getLogChannel().log(-2137614336, "[RouteGuidance] RouteCriteriaSequence#setRouteOption() - routeCriteria is null.");
        }
    }

    public void setTunnels(int n) {
        this.routeCriteria.setTunnels(n);
    }
}

