/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.setup;

import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.IStorageAccess;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.PersistentState;
import de.audi.tghu.navi.app.command.RGSetRouteOptionsCommand;
import de.audi.tghu.navi.app.setup.IRouteCriteria;
import de.audi.tghu.navi.app.setup.IRouteCriteriaConfiguration;
import de.audi.tghu.navi.app.setup.IRouteCriteriaManager;
import de.audi.tghu.navi.app.setup.IRouteCriteriaModelAccess;
import de.audi.tghu.navi.app.setup.RouteCriteria;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

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
        this.logChannel.log(10000000, "[RouteGuidance] RouteCriteriaManager#loadState");
        RouteCriteriaState routeCriteriaState = new RouteCriteriaState(navigationEnv.getFramework().getStorageMgr(), this.logChannel);
        routeCriteriaState.readAndDeserialize();
        iRouteCriteria.setValuesFromObject(routeCriteriaState.getRouteCriteria());
    }

    public void persistState() {
        this.logChannel.log(10000000, "[RouteGuidance] RouteCriteriaManager#persistState()");
        if (this.routeCriteria.equals(this.persistedRouteCriteria)) {
            return;
        }
        this.logChannel.log(10000000, "[RouteGuidance] RouteCriteriaManager#persistState() - there was a change, continue with persisting the new values.");
        RouteCriteriaState routeCriteriaState = new RouteCriteriaState(this.env.getFramework().getStorageMgr(), this.logChannel);
        routeCriteriaState.setRouteCriteria(this.routeCriteria);
        routeCriteriaState.serializeAndWrite();
        this.persistedRouteCriteria.setValuesFromObject(this.routeCriteria);
        if (this.env.getContainer().isRgActive() || this.env.getContainer().getRgRouteCalculationState() != 0) {
            this.sendRouteOptionsToDSI();
        }
    }

    public void resetSettings() {
        this.env.getLogChannel().log(10000000, "RouteCriteriaManager#resetSettings()");
        this.routeCriteriaSystemConfiguration.initRouteCriteria(this.routeCriteria);
        this.persistState();
    }

    private void sendRouteOptionsToDSI() {
        CommandList commandList = this.commandListFactory.createCommandList(1);
        commandList.add(new RGSetRouteOptionsCommand(this.persistedRouteCriteria.getRouteOptions(true)[0]));
        commandList.execute("[RouteGuidance]RouteCriteriaManager#sendRouteOptionsToDSI");
    }

    public IRouteCriteria getRouteCriteria() {
        this.logChannel.log(10000000, "[RouteGuidance] RouteCriteriaManager#getRouteCriteria() - %1", (Object)this.persistedRouteCriteria);
        return new RouteCriteria(this.persistedRouteCriteria, this.env);
    }

    public void setRouteCriteria(IRouteCriteria iRouteCriteria) {
        this.logChannel.log(10000000, "[RouteGuidance] RouteCriteriaManager#setRouteCriteria() - %1", (Object)iRouteCriteria);
        this.routeCriteria.setValuesFromObject(iRouteCriteria);
    }

    private class RouteCriteriaState
    extends PersistentState {
        public static final int VERSION = 3;
        public static final int KEY = 850;
        private IRouteCriteria routeCriteria;

        public RouteCriteriaState(IStorageAccess iStorageAccess, LogChannel logChannel) {
            super(iStorageAccess, 3, 1004, 850, logChannel);
            this.routeCriteria = new RouteCriteria(RouteCriteriaManager.this.env);
        }

        protected void initWithDefaultValues() {
            this.getLogChannel().log(10000000, "[RouteGuidance] RouteCriteriaState#initWithDefaultValues()");
            RouteCriteriaManager.this.routeCriteriaSystemConfiguration.initRouteCriteria(this.routeCriteria);
        }

        protected void initFromOldKeys(IStorageAccess iStorageAccess) {
            this.getLogChannel().log(10000000, "[RouteGuidance] RouteCriteriaState#initFromOldKeys()");
            RouteCriteriaManager.this.routeCriteriaSystemConfiguration.initRouteCriteria(this.routeCriteria);
        }

        protected void convertContainer(int n, int n2, DataInputStream dataInputStream) {
            this.getLogChannel().log(10000000, "[RouteGuidance] RouteCriteriaState#convertContainer( %1, %2 )", (long)n, (long)n2);
            this.initWithDefaultValues();
        }

        protected void serialize(DataOutputStream dataOutputStream) throws IOException {
            this.getLogChannel().log(10000000, "[RouteGuidance] RouteCriteriaState#serialize - routeCriteria: %1", (Object)this.routeCriteria);
            dataOutputStream.writeInt(this.routeCriteria.getTrafficRerouting());
            dataOutputStream.writeInt(this.routeCriteria.getFreeways());
            dataOutputStream.writeInt(this.routeCriteria.getTollRoads());
            dataOutputStream.writeInt(this.routeCriteria.getFerries());
            dataOutputStream.writeInt(this.routeCriteria.getMotorrail());
            dataOutputStream.writeInt(this.routeCriteria.getTimeRestrictedRoads());
            dataOutputStream.writeInt(this.routeCriteria.getSeasonRestricted());
            dataOutputStream.writeInt(this.routeCriteria.getTrailer());
            dataOutputStream.writeInt(this.routeCriteria.getVignettes());
            dataOutputStream.writeInt(this.routeCriteria.getRouteOptions(true)[0].getRouteType());
            this.serializeIntArray(this.routeCriteria.getVignetteCountries(), dataOutputStream);
            dataOutputStream.writeInt(this.routeCriteria.getTunnels());
            dataOutputStream.writeInt(this.routeCriteria.getHovLanes());
        }

        protected void deserialize(DataInputStream dataInputStream) throws IOException {
            this.getLogChannel().log(10000000, "[RouteGuidance] RouteCriteriaState#deserialize");
            this.routeCriteria.setTrafficRerouting(dataInputStream.readInt());
            this.routeCriteria.setFreeways(dataInputStream.readInt());
            this.routeCriteria.setTollRoads(dataInputStream.readInt());
            this.routeCriteria.setFerries(dataInputStream.readInt());
            this.routeCriteria.setMotorrail(dataInputStream.readInt());
            this.routeCriteria.setTimeRestrictedRoads(dataInputStream.readInt());
            this.routeCriteria.setSeasonRestricted(dataInputStream.readInt());
            this.routeCriteria.setTrailer(dataInputStream.readInt());
            this.routeCriteria.setVignettes(dataInputStream.readInt());
            this.routeCriteria.setRouteOption(dataInputStream.readInt());
            this.routeCriteria.setVignetteCountries(this.deserializeIntArray(dataInputStream));
            this.routeCriteria.setTunnels(dataInputStream.readInt());
            this.routeCriteria.setHovLanes(dataInputStream.readInt());
            this.getLogChannel().log(10000000, "[RouteGuidance] RouteCriteriaState#deserialize - resulting routeCriteria: %1", (Object)this.routeCriteria);
            RouteCriteriaManager.this.routeCriteriaSystemConfiguration.checkForRegionConsistency(this.routeCriteria);
            RouteCriteriaManager.this.routeCriteriaSystemConfiguration.checkForEncodedTrailer(this.routeCriteria, RouteCriteriaManager.this.env);
        }

        public IRouteCriteria getRouteCriteria() {
            return this.routeCriteria;
        }

        public void setRouteCriteria(IRouteCriteria iRouteCriteria) {
            if (iRouteCriteria == null) {
                return;
            }
            this.routeCriteria = new RouteCriteria(iRouteCriteria, RouteCriteriaManager.this.env);
        }
    }
}

