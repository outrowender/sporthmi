/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.command.DeleteSatelliteCacheCommand;
import de.audi.tghu.navi.app.map.ISatelliteMapsGUI;
import de.audi.tghu.navi.app.map.ISatelliteMapsMediatorFSM;
import de.audi.tghu.navi.app.map.IVisibleContext;
import de.audi.tghu.navi.app.map.MapManager;
import de.audi.tghu.navi.app.map.SatelliteMapsMediatorFSM2;
import de.audi.tghu.navi.app.util.Util;

public class SatelliteMapsMediator {
    private final NavigationEnv env;
    private final MapManager mapManager;
    private LogChannel logger;
    private static final int ENTER_MAP_STATE_NOT_ENTERED = -1;
    private volatile int enterMapState = -1;
    private static final int ENTER_MAP_STATE_LICENSE_FAIL = 0;
    private static final int ENTER_MAP_STATE_OK = 1;
    private static final int ENTER_MAP_STATE_SHOW_CLUSTER_MAP = 2;
    private volatile boolean isGEBlocked = false;
    private volatile boolean routeCalcActive = false;
    private ISatelliteMapsMediatorFSM mmuSatellitemapsmanagerFSM = ISatelliteMapsMediatorFSM.NULL_SATELLITES_MANAGAER_FSM;
    private ISatelliteMapsMediatorFSM kombiSatellitemapsmanagerFSM = ISatelliteMapsMediatorFSM.NULL_SATELLITES_MANAGAER_FSM;
    private ISatelliteMapsGUI satelliteMapsGUI;
    private boolean disableUpdates = false;

    public SatelliteMapsMediator(NavigationEnv navigationEnv, MapManager mapManager, ISatelliteMapsGUI iSatelliteMapsGUI, IconHandler iconHandler) {
        this.env = navigationEnv;
        this.mapManager = mapManager;
        this.logger = mapManager.getMapMain().getMapLogChannel();
        this.satelliteMapsGUI = iSatelliteMapsGUI;
        this.createSatelliteMapsmanagerFSM(navigationEnv, mapManager, iSatelliteMapsGUI, iconHandler);
        this.hackModel();
    }

    protected void createSatelliteMapsmanagerFSM(NavigationEnv navigationEnv, MapManager mapManager, ISatelliteMapsGUI iSatelliteMapsGUI, IconHandler iconHandler) {
        this.mmuSatellitemapsmanagerFSM = new SatelliteMapsMediatorFSM2(navigationEnv, this.logger, mapManager.getMapMain().getSatellitemapsManager(), iSatelliteMapsGUI, true, 0, 0, iconHandler);
        if (mapManager.getMapKombi() != null) {
            LogChannel logChannel = mapManager.getMapKombi().getMapLogChannel();
            this.kombiSatellitemapsmanagerFSM = new SatelliteMapsMediatorFSM2(navigationEnv, logChannel, mapManager.getMapKombi().getSatellitemapsManager(), iSatelliteMapsGUI, true, 3, 1, iconHandler);
        }
    }

    private void hackModel() {
        this.mapManager.getMapMain().getGuiInterface().setGEGreyOutOption(false);
        this.env.getChoiceModel(401182).setValue(1);
        this.env.getChoiceModel(400385).setValue(2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void onMapRepresentationChanged(int n, int n2) {
        this.logger.log(1000000, "SatelliteMapsMediator#onMapRepresentationChanged() - mapRepresentation: %1, oldRepresentation: %2", (long)n, (long)n2);
        Object object = this.mapManager.getMutexSwitchToContext();
        synchronized (object) {
            if (Util.isGoogleEarthPresent(this.env.getFramework())) {
                boolean bl = n == 1 && n2 != 1;
                this.mapManager.getGoogleMapLicenseHandler().setGoogleMapActive(bl);
            }
            this.resetEnterMapState();
            this.refreshActiveMapStyle(false);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void onSatMapBlockingBitChanged(boolean bl) {
        this.logger.log(1000000, "SatelliteMapsMediator2#onSatMapBlockingBitChanged() - isGEBlocked: %1", bl);
        if (this.mapManager.getMapMain() == null) {
            this.logger.log(100000, "SatelliteMapsMediator2#onSatMapBlockingBitChanged() - map main is null, cancel");
            return;
        }
        Object object = this.mapManager.getMutexSwitchToContext();
        synchronized (object) {
            this.isGEBlocked = bl;
            this.refreshActiveMapStyle(true);
        }
    }

    public void resetEnterMapState() {
        this.logger.log(10000000, "SatelliteMapsMediator#resetEnterMapState() ");
        this.enterMapState = -1;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void refreshActiveMapStyle(boolean bl) {
        this.logger.log(1000000, "SatelliteMapsMediator#refreshActiveMapStyle() - current enterMapState: %1", (long)this.enterMapState);
        this.logger.log(1000000, "SatelliteMapsMediator#refreshActiveMapStyle() - triggeredByGeBlockingBit: %1 ", bl);
        if (!Util.isGoogleEarthPresent(this.env.getFramework())) {
            this.logger.log(1000000, "SatelliteMapsMediator#refreshActiveMapStyle() - GE not present - ignore!");
            return;
        }
        if (this.routeCalcActive && !bl) {
            this.logger.log(100000, "SatelliteMapsMediator#refreshActiveMapStyle() - route calculation currently active - ignore!");
            return;
        }
        Object object = this.mapManager.getMutexSwitchToContext();
        synchronized (object) {
            boolean bl2 = this.mapManager.getMapMain().getSetup().getMapRepresentation() == 1;
            boolean bl3 = false;
            this.logger.log(1000000, "SatelliteMapsMediator#refreshActiveMapStyle() - isSetupGE: %1,  isGEBlocked: %2 ", bl2, this.isGEBlocked);
            if (Util.isClusterMapAvailable(this.env.getFramework()) && this.enterMapState == -1) {
                boolean bl4;
                boolean bl5 = bl4 = this.mapManager.getGoogleMapLicenseHandler().getPersistedLicenseState() == 1;
                if (this.mapManager.getMapInterface().validateGELicenseState(bl4) && this.mapManager.getMapKombi().getActiveContext() instanceof IVisibleContext) {
                    this.logger.log(1000000, "SatelliteMapsMediator#refreshActiveMapStyle() - adjusted enterMapState for cluster map ");
                    this.enterMapState = 2;
                }
            }
            if (this.enterMapState == 1) {
                bl3 = bl2 && !this.isGEBlocked;
                this.logger.log(1000000, "SatelliteMapsMediator#refreshActiveMapStyle() -ENTER_MAP_STATE_OK ");
            } else if (this.enterMapState == 2) {
                if (bl2 && !this.isGEBlocked) {
                    bl3 = true;
                }
                this.logger.log(1000000, "SatelliteMapsMediator#refreshActiveMapStyle() -ENTER_MAP_STATE_SHOW_CLUSTER_MAP ");
            } else if (this.enterMapState == -1) {
                bl3 = false;
                this.logger.log(1000000, "SatelliteMapsMediator#refreshActiveMapStyle() - ENTER_MAP_STATE_NOT_ENTERED ");
            } else {
                bl3 = false;
                if (bl2) {
                    this.mapManager.restoreBackupMapRepresentationForStandardMap();
                    this.logger.log(1000000, "SatelliteMapsMediator#refreshActiveMapStyle() - not licensed ");
                    return;
                }
            }
            if (bl) {
                // empty if block
            }
            this.logger.log(1000000, "SatelliteMapsMediator#refreshActiveMapStyle() - GOING To CHANGE STATE ");
            this.getMmuSatellitemapsmanagerFSM().setMapStyle(bl3 ? 1 : 0, bl);
            this.getKombiSatellitemapsmanagerFSM().setMapStyle(bl3 ? 1 : 0, bl);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void onEnterOnlineMap(boolean bl) {
        this.logger.log(1000000, "SatelliteMapsMediator#onEnterOnlineMap() - licenseStatus: %1 ", bl);
        Object object = this.mapManager.getMutexSwitchToContext();
        synchronized (object) {
            if (!bl) {
                this.enterMapState = 0;
            } else {
                this.mapManager.getGoogleMapLicenseHandler().setGoogleMapLicenseValid();
                this.enterMapState = 1;
            }
            this.refreshActiveMapStyle(false);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void onRouteCalcActiveStateChanged(boolean bl) {
        this.logger.log(1000000, "SatelliteMapsMediator#onRouteCalcActiveStateChanged( %1 ) - was %2 ", bl, this.routeCalcActive);
        if (this.routeCalcActive != bl) {
            Object object = this.mapManager.getMutexSwitchToContext();
            synchronized (object) {
                this.routeCalcActive = bl;
                if (!bl) {
                    this.refreshActiveMapStyle(false);
                }
            }
        }
    }

    public void updateMapStyle(int n, int n2) {
        this.logger.log(1000000, "SatelliteMapsMediator#updateMapStyle(instance %1 confirmedmapStyle %2) disableupdate %3 ", (long)n, (long)n2, this.disableUpdates);
        if (this.disableUpdates) {
            return;
        }
        if (n == 0) {
            this.getMmuSatellitemapsmanagerFSM().updatemapStyle(n2);
        }
        if (n == 3) {
            this.getKombiSatellitemapsmanagerFSM().updatemapStyle(n2);
        }
    }

    public void cleanUp() {
        this.getMmuSatellitemapsmanagerFSM().cleanUp();
    }

    public ISatelliteMapsMediatorFSM getMmuSatellitemapsmanagerFSM() {
        return this.mmuSatellitemapsmanagerFSM;
    }

    ISatelliteMapsMediatorFSM getKombiSatellitemapsmanagerFSM() {
        return this.kombiSatellitemapsmanagerFSM;
    }

    public void deleteSatelliteCache() {
        CommandList commandList = this.mapManager.getCommandListFactory().createCommandList();
        commandList.add(new DeleteSatelliteCacheCommand());
        commandList.execute("SatelliteMapsMediator#deleteSatelliteCache()");
    }

    public ISatelliteMapsGUI getSatelliteMapsGUI() {
        return this.satelliteMapsGUI;
    }

    public void disableUpdates() {
        this.disableUpdates = true;
    }

    public void enableUpdates() {
        this.disableUpdates = false;
    }
}

