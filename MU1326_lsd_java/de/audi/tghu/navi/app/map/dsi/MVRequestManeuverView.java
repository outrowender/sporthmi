/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.dsi;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.map.dsi.AbstractRequester;
import de.audi.tghu.navi.app.map.dsi.MVResponseManeuverView;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.map.DSIMapViewerManeuverView;

public class MVRequestManeuverView
extends AbstractRequester
implements DSIMapViewerManeuverView {
    private DSIMapViewerManeuverView mDSIMV;

    MVRequestManeuverView(int n, LogChannel logChannel, LogChannel logChannel2) {
        super(n, logChannel, "MVRequestManeuverView");
        MVResponseManeuverView mVResponseManeuverView = new MVResponseManeuverView(logChannel2);
        this.setResponser(mVResponseManeuverView);
    }

    protected final boolean isDSIMVAvailable() {
        return this.mDSIMV != null;
    }

    @Override
    protected void cleanup() {
        super.cleanup();
    }

    public void bind(DSIMapViewerManeuverView dSIMapViewerManeuverView) {
        if (dSIMapViewerManeuverView == null) {
            this.cleanupResponserAttributeNotifications();
        }
        this.mDSIMV = dSIMapViewerManeuverView;
        super.bind(dSIMapViewerManeuverView);
    }

    public MVResponseManeuverView getResponserManeuverView() {
        return (MVResponseManeuverView)this.getResponser();
    }

    @Override
    protected DSIBase getDSIBase() {
        return this.mDSIMV;
    }

    @Override
    public void selectManoeuvreView(int n, boolean bl) {
        if (!this.isDSIMVAvailable()) {
            this.getLogger().log(10000, "MVRequestManeuverView#selectManoeuvreView() - DSIMV not available!");
            return;
        }
        try {
            this.getLogger().log(-2137614336, "MVRequestManeuverView#selectManoeuvreView(%2, %1)", bl, (long)n);
            this.mDSIMV.selectManoeuvreView(n, bl);
        }
        catch (Exception exception) {
            this.getLogger().log(10000, "MVRequestManeuverView#selectManoeuvreView(): ERROR");
        }
    }

    @Override
    public void hideManoeuvreView() {
        if (!this.isDSIMVAvailable()) {
            this.getLogger().log(10000, "MVRequestManeuverView#hideManoeuvreView() - DSIMV not available!");
            return;
        }
        try {
            this.getLogger().log(-2137614336, "MVRequestManeuverView#hideManoeuvreView()");
            this.mDSIMV.hideManoeuvreView();
        }
        catch (Exception exception) {
            this.getLogger().log(10000, "MVRequestManeuverView#hideManoeuvreView(): ERROR");
        }
    }

    @Override
    public void setDistanceString(String string) {
        if (!this.isDSIMVAvailable()) {
            this.getLogger().log(10000, "MVRequestManeuverView#setDistanceString() - DSIMV not available!");
            return;
        }
        try {
            this.getLogger().log(14808325, "MVRequestManeuverView#setDistanceString(%1)", (Object)string);
            this.mDSIMV.setDistanceString(string);
        }
        catch (Exception exception) {
            this.getLogger().log(10000, "MVRequestManeuverView#setDistanceString(): ERROR");
        }
    }

    @Override
    public void disableManeuverViewGeneration(boolean bl) {
        if (!this.isDSIMVAvailable()) {
            this.getLogger().log(10000, "MVRequestManeuverView#disableManeuverViewGeneration() - DSIMV not available!");
            return;
        }
        try {
            this.getLogger().log(-2137614336, "MVRequestManeuverView#disableManeuverViewGeneration(%1)", bl);
            this.mDSIMV.disableManeuverViewGeneration(bl);
        }
        catch (Exception exception) {
            this.getLogger().log(10000, "MVRequestManeuverView#disableManeuverViewGeneration(): ERROR");
        }
    }

    @Override
    public void resetMemberVariables() {
    }
}

