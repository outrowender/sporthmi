/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.map.ISatelliteMapsManager;
import de.audi.tghu.navi.app.map.ISatelliteMapsMediatorFSM;
import de.audi.tghu.navi.app.map.SatelliteMapsMediator;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavRectangle;

public class SatelliteMapsManager
implements ISatelliteMapsManager {
    private NavigationEnv env;
    private AbstractMap abstractMap;
    private int navMapActiveRendererChoiceModelId;
    private int terminal;
    private LogChannel logger;
    private SatelliteMapsMediator sattelliteMapMediator;

    public SatelliteMapsManager(NavigationEnv navigationEnv, AbstractMap abstractMap, int n, int n2) {
        this.env = navigationEnv;
        this.abstractMap = abstractMap;
        this.navMapActiveRendererChoiceModelId = n;
        this.terminal = n2;
        this.logger = abstractMap.getMapLogChannel();
    }

    @Override
    public void setCopyrightPosition(NavRectangle navRectangle, int n, int n2) {
        this.logger.log(1078071040, "SatelliteMapsManager#setCopyrightPosition()");
        this.abstractMap.getMVRequest().getMVRequestStd().setCopyrightPosition(navRectangle, n, n2);
    }

    @Override
    public void changeMapStyle(int n) {
        this.logger.log(1078071040, "SatelliteMapsManager#changeMapStyle() - requestedMapStyle: %1", (long)n);
        this.abstractMap.getMVRequest().getMVRequestStd().setMapStyle(n);
    }

    @Override
    public boolean isSatelliteMapSupported() {
        return Util.isGoogleEarthPresent(this.env.getFramework()) && this.abstractMap.getMapConfig().hasGoogleEarth();
    }

    @Override
    public boolean isSatelliteMapActive() {
        if (this.abstractMap.isMapMain()) {
            return this.sattelliteMapMediator.getMmuSatellitemapsmanagerFSM().isSatelliteMapsActive();
        }
        return this.sattelliteMapMediator.getKombiSatellitemapsmanagerFSM().isSatelliteMapsActive();
    }

    @Override
    public void setMediator(SatelliteMapsMediator satelliteMapsMediator) {
        this.sattelliteMapMediator = satelliteMapsMediator;
    }

    @Override
    public void setSatelliteMapIconsAccordingToSetup() {
        this.getMediatorFSMForActiveMap().setLogosAccordingToSetup();
    }

    private ISatelliteMapsMediatorFSM getMediatorFSMForActiveMap() {
        if (this.abstractMap.isMapMain()) {
            return this.sattelliteMapMediator.getMmuSatellitemapsmanagerFSM();
        }
        return this.sattelliteMapMediator.getKombiSatellitemapsmanagerFSM();
    }

    @Override
    public AbstractMap getMap() {
        return this.abstractMap;
    }

    @Override
    public int getActiveRendererID() {
        return this.abstractMap.getMainRequestCtl().getID();
    }
}

