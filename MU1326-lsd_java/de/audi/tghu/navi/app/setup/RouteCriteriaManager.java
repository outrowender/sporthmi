/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.setup;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.command.RGSetRouteOptionsCommand;
import de.audi.tghu.navi.app.setup.IRouteCriteria;
import de.audi.tghu.navi.app.setup.IRouteCriteriaConfiguration;
import de.audi.tghu.navi.app.setup.IRouteCriteriaManager;
import de.audi.tghu.navi.app.setup.IRouteCriteriaModelAccess;
import de.audi.tghu.navi.app.setup.RouteCriteria;
import de.audi.tghu.navi.app.setup.RouteCriteriaManager$RouteCriteriaState;

public class RouteCriteriaManager
implements IRouteCriteriaManager {
    private final NavigationEnv env;
    private final LogChannel logChannel;
    private final ICommandListFactory commandListFactory;
    private final IRouteCriteriaConfiguration routeCriteriaSystemConfiguration;
    private final IRouteCriteria persistedRouteCriteria;
    private final IRouteCriteria routeCriteria;

    public RouteCriteriaManager(NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory, IRouteCriteriaConfiguration iRouteCriteriaConfiguration, IRouteCriteriaModelAccess iRouteCriteriaModelAccess) {
        this.env = navigationEnv;
        this.logChannel = navigationEnv.getLogChannel();
        this.commandListFactory = iCommandListFactory;
        this.routeCriteriaSystemConfiguration = iRouteCriteriaConfiguration;
        this.persistedRouteCriteria = new RouteCriteria(navigationEnv);
        iRouteCriteriaConfiguration.initRouteCriteria(this.persistedRouteCriteria);
        this.loadState(navigationEnv, this.persistedRouteCriteria);
        iRouteCriteriaModelAccess.onStart(this.persistedRouteCriteria);
        this.routeCriteria = new RouteCriteria(this.persistedRouteCriteria, navigationEnv);
    }

    public void resetPersistenceState() {
        this.routeCriteriaSystemConfiguration.initRouteCriteria(this.routeCriteria);
        this.persistState();
    }

    private void loadState(NavigationEnv navigationEnv, IRouteCriteria iRouteCriteria) {
        this.logChannel.log(-2137614336, "[RouteGuidance] RouteCriteriaManager#loadState");
        RouteCriteriaManager$RouteCriteriaState routeCriteriaManager$RouteCriteriaState = new RouteCriteriaManager$RouteCriteriaState(this, navigationEnv.getFramework().getStorageMgr(), this.logChannel);
        routeCriteriaManager$RouteCriteriaState.readAndDeserialize();
        iRouteCriteria.setValuesFromObject(routeCriteriaManager$RouteCriteriaState.getRouteCriteria());
    }

    @Override
    public void persistState() {
        this.logChannel.log(-2137614336, "[RouteGuidance] RouteCriteriaManager#persistState()");
        if (this.routeCriteria.equals(this.persistedRouteCriteria)) {
            return;
        }
        this.logChannel.log(-2137614336, "[RouteGuidance] RouteCriteriaManager#persistState() - there was a change, continue with persisting the new values.");
        RouteCriteriaManager$RouteCriteriaState routeCriteriaManager$RouteCriteriaState = new RouteCriteriaManager$RouteCriteriaState(this, this.env.getFramework().getStorageMgr(), this.logChannel);
        routeCriteriaManager$RouteCriteriaState.setRouteCriteria(this.routeCriteria);
        routeCriteriaManager$RouteCriteriaState.serializeAndWrite();
        this.persistedRouteCriteria.setValuesFromObject(this.routeCriteria);
        if (this.env.getContainer().isRgActive() || this.env.getContainer().getRgRouteCalculationState() != 0) {
            this.sendRouteOptionsToDSI();
        }
    }

    @Override
    public void resetSettings() {
        this.env.getLogChannel().log(-2137614336, "RouteCriteriaManager#resetSettings()");
        this.routeCriteriaSystemConfiguration.initRouteCriteria(this.routeCriteria);
        this.persistState();
    }

    private void sendRouteOptionsToDSI() {
        CommandList commandList = this.commandListFactory.createCommandList(1);
        commandList.add(new RGSetRouteOptionsCommand(this.persistedRouteCriteria.getRouteOptions(true)[0]));
        commandList.execute("[RouteGuidance]RouteCriteriaManager#sendRouteOptionsToDSI");
    }

    @Override
    public IRouteCriteria getRouteCriteria() {
        this.logChannel.log(-2137614336, "[RouteGuidance] RouteCriteriaManager#getRouteCriteria() - %1", (Object)this.persistedRouteCriteria);
        return new RouteCriteria(this.persistedRouteCriteria, this.env);
    }

    @Override
    public void setRouteCriteria(IRouteCriteria iRouteCriteria) {
        this.logChannel.log(-2137614336, "[RouteGuidance] RouteCriteriaManager#setRouteCriteria() - %1", (Object)iRouteCriteria);
        this.routeCriteria.setValuesFromObject(iRouteCriteria);
    }

    static /* synthetic */ NavigationEnv access$000(RouteCriteriaManager routeCriteriaManager) {
        return routeCriteriaManager.env;
    }

    static /* synthetic */ IRouteCriteriaConfiguration access$100(RouteCriteriaManager routeCriteriaManager) {
        return routeCriteriaManager.routeCriteriaSystemConfiguration;
    }
}

