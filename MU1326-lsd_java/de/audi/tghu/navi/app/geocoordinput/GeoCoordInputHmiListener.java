/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.geocoordinput;

import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.hmi.model.MetricsListener;
import de.audi.atip.log.LogChannel;
import de.audi.atip.metrics.GeoMetric;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.favorite.NaviFavoriteHandler;
import de.audi.tghu.navi.app.geocoordinput.GeoCoordInputManager;

public class GeoCoordInputHmiListener
implements ButtonListener,
MetricsListener,
ChoiceListener {
    protected final NavigationEnv env;
    protected final GeoCoordInputManager geoCoordInputManager;
    protected final LogChannel logChannel;
    protected final NaviFavoriteHandler favoriteHandler;
    protected static final int CURSOR_WAS_ON_LATITUDE;
    protected static final int CURSOR_WAS_ON_LONGITUDE;
    protected int cursorposition = -1;

    public GeoCoordInputHmiListener(NavigationEnv navigationEnv, GeoCoordInputManager geoCoordInputManager, NaviFavoriteHandler naviFavoriteHandler) {
        this.env = navigationEnv;
        this.favoriteHandler = naviFavoriteHandler;
        this.logChannel = navigationEnv.getGeoCoordInputLogChannel();
        this.geoCoordInputManager = geoCoordInputManager;
        this.setupListeners();
    }

    private void setupListeners() {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(14808325, "GeoCoordInputHmiListener#setupListeners()");
        }
        this.env.getButtonModel(-836827648).setButtonListener(this);
        this.env.getButtonModel(-820050432).setButtonListener(this);
        this.env.getButtonModel(-266729984).setButtonListener(this);
        this.env.getButtonModel(236979712).setButtonListener(this);
        this.env.getButtonModel(253756928).setButtonListener(this);
        this.env.getMetricsModel(538641920).setMetricsListener(this);
        this.env.getChoiceModel(153093632).setChoiceListener(this);
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(14808325, "GeoCoordInputHmiListener#keyPressed()");
        }
        switch (n) {
            case 401358: {
                this.geoCoordInputManager.start();
                break;
            }
            case 401359: {
                this.geoCoordInputManager.enterWithCCPAsCoordinates();
                break;
            }
            case 400112: {
                this.geoCoordInputManager.enterWithCCPAsCoordinates();
                break;
            }
            case 401422: {
                this.geoCoordInputManager.storeToAdb();
                break;
            }
            case 401423: {
                this.geoCoordInputManager.storeHomeAddress();
                break;
            }
            default: {
                this.logChannel.log(-2137614336, "GeoCoordInputHmiListener#keyPressed() - Unknown Button pressed: %1", (long)n);
            }
        }
        this.env.fireModelEvent(n, n3);
    }

    @Override
    public void metricsUpdated(int n, int n2) {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(14808325, "GeoCoordInputHmiListener#metricsUpdated()");
        }
        if (n == 538641920) {
            this.geoCoordInputManager.coordinateUpdate((GeoMetric)this.env.getMetricsModel(n).getMetric(), this.cursorposition);
            this.env.fireModelEvent(n, n2);
            this.cursorposition = -1;
        }
    }

    @Override
    public void itemFocused(int n, int n2, int n3, int n4) {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(14808325, "GeoCoordInputHmiListener#itemFocused()");
        }
        if (n == 153093632) {
            if (this.logChannel.isDebug2()) {
                this.logChannel.log(14808325, "   --> Event from Trigger Choice Model");
            }
            if (n2 == 0) {
                if (this.logChannel.isDebug2()) {
                    this.logChannel.log(14808325, "      --> CURSOR_WAS_ON_LATITUDE");
                }
                this.cursorposition = 0;
            } else if (n2 == 1) {
                if (this.logChannel.isDebug2()) {
                    this.logChannel.log(14808325, "      --> CURSOR_WAS_ON_LONGITUDE");
                }
                this.cursorposition = 1;
            } else {
                if (this.logChannel.isDebug2()) {
                    this.logChannel.log(14808325, "      --> Unknown Value: %1", (long)n);
                }
                this.cursorposition = -1;
            }
        }
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
    }

    public void enterGeoCoordInput(int n) {
    }
}

