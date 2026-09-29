/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.cluster;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.interapp.combi.ddp2.CombiService;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.cluster.ClusterService;
import de.audi.tghu.navi.app.util.Util;
import de.esolutions.fw.util.commons.Buffer;

public class ClusterViewMode {
    public static final int VIEWMODE_COMPASS;
    public static final int VIEWMODE_RGI;
    public static final int VIEWMODE_KDK;
    public static final int VIEWMODE_MAP;
    private final NavigationEnv env;
    private LogChannel logChannel;
    private ClusterService clusterService;
    private CombiService combiService;
    private int favoredViewMode;
    private boolean favoredViewModeReceived = false;
    private boolean rgiValid;
    private boolean gfxAvailable;
    private boolean mapReady;
    private boolean komoViewEnabled;
    private boolean komoViewVisible;
    private int dataRate;
    private ChoiceModelApp viewMode;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ClusterViewMode(NavigationEnv navigationEnv, ClusterService clusterService) {
        this.env = navigationEnv;
        this.logChannel = navigationEnv.getLogChannel();
        this.clusterService = clusterService;
        this.viewMode = navigationEnv.getChoiceModel(67);
        ClusterViewMode clusterViewMode = this;
        synchronized (clusterViewMode) {
            this.favoredViewMode = 1;
            this.rgiValid = false;
            this.gfxAvailable = false;
            this.komoViewEnabled = Util.isClusterMapMOSTAlwaysOn();
            this.komoViewVisible = false;
            this.dataRate = 0;
            this.mapReady = false;
            this.viewMode.setValue(0);
        }
    }

    public void setCombiService(CombiService combiService) {
        this.logChannel.log(-2137614336, "ClusterViewMode#setCombiService( %1 )", (Object)combiService);
        this.combiService = combiService;
        this.refreshRGState();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void refreshRGState() {
        ClusterViewMode clusterViewMode = this;
        synchronized (clusterViewMode) {
            if (this.combiService != null) {
                this.logChannel.log(-2137614336, "ClusterViewMode#refreshRGState()");
                boolean bl = this.env.getContainer().isRgActive();
                this.combiService.updateRGState(bl ? 6 : 1);
            } else {
                this.logChannel.log(-1601830656, "ClusterViewMode#refreshRGState() - combiService not available!");
            }
            this.refreshViewMode();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setFavoredViewMode(int n) {
        ClusterViewMode clusterViewMode = this;
        synchronized (clusterViewMode) {
            this.favoredViewModeReceived = true;
            if (this.favoredViewMode != n) {
                this.logChannel.log(-2137614336, "ClusterViewMode#setFavoredViewMode( %1 )", (Object)ClusterViewMode.viewModeToString(n));
                this.favoredViewMode = n;
            }
            this.refreshViewMode();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setRGIValid(boolean bl) {
        ClusterViewMode clusterViewMode = this;
        synchronized (clusterViewMode) {
            if (this.rgiValid != bl) {
                this.rgiValid = bl;
                this.refreshViewMode();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setGFXAvailable(boolean bl) {
        ClusterViewMode clusterViewMode = this;
        synchronized (clusterViewMode) {
            if (this.gfxAvailable != bl) {
                this.gfxAvailable = bl;
                this.refreshViewMode();
                if (bl) {
                    this.clusterService.setKOMODataRate(this.dataRate);
                } else {
                    this.clusterService.setKOMODataRate(0);
                }
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setKOMOViewEnabled(boolean bl) {
        ClusterViewMode clusterViewMode = this;
        synchronized (clusterViewMode) {
            if (this.komoViewEnabled != bl) {
                this.komoViewEnabled = bl;
                this.refreshViewMode();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setKOMOViewVisible(boolean bl) {
        ClusterViewMode clusterViewMode = this;
        synchronized (clusterViewMode) {
            if (this.komoViewVisible != bl) {
                this.komoViewVisible = bl;
                this.refreshViewMode();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setDataRate(int n) {
        ClusterViewMode clusterViewMode = this;
        synchronized (clusterViewMode) {
            if (this.dataRate != n) {
                this.dataRate = n;
                this.refreshMapVisibility();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setKombiMapReady(boolean bl) {
        ClusterViewMode clusterViewMode = this;
        synchronized (clusterViewMode) {
            if (this.mapReady != bl) {
                this.mapReady = bl;
                this.refreshViewMode();
            }
        }
    }

    private void refreshViewMode() {
        if (Util.isClusterMapFPK(this.env.getFramework()) || Util.isClusterMMI(this.env.getFramework())) {
            return;
        }
        int n = this.viewMode.getValue();
        this.logChannel.log(-2137614336, "ClusterViewMode#refreshViewMode() - current: %1, favored: %2", (Object)ClusterViewMode.viewModeToString(n), (Object)ClusterViewMode.viewModeToString(this.favoredViewMode));
        if (this.favoredViewMode == 0) {
            this.logChannel.log(1078071040, "ClusterViewMode#refreshViewMode() - switch to COMPASS");
            this.viewMode.setValue(0);
        } else {
            switch (n) {
                case 1: {
                    if (this.favoredViewMode == 1) {
                        if (!this.rgiValid) {
                            this.logChannel.log(-1601830656, "ClusterViewMode#refreshViewMode() - RGI not longer valid!");
                            this.viewMode.setValue(0);
                            break;
                        }
                        this.logChannel.log(1078071040, "ClusterViewMode#refreshViewMode() - stay in RGI");
                        break;
                    }
                    if (this.favoredViewMode == 2) {
                        if (this.isKDKReady()) {
                            this.logChannel.log(1078071040, "ClusterViewMode#refreshViewMode() - switch to KDK");
                            this.viewMode.setValue(2);
                            break;
                        }
                        if (!this.rgiValid) {
                            this.logChannel.log(-1601830656, "ClusterViewMode#refreshViewMode() - RGI not longer valid!");
                            this.viewMode.setValue(0);
                            break;
                        }
                        this.logChannel.log(1078071040, "ClusterViewMode#refreshViewMode() - KDK not ready, stay in RGI");
                        break;
                    }
                    if (this.favoredViewMode == 3) {
                        if (this.isMapReady()) {
                            this.logChannel.log(1078071040, "ClusterViewMode#refreshViewMode() - switch to MAP");
                            this.viewMode.setValue(3);
                            break;
                        }
                        if (!this.rgiValid) {
                            this.logChannel.log(-1601830656, "ClusterViewMode#refreshViewMode() - RGI not longer valid!");
                            this.viewMode.setValue(0);
                            break;
                        }
                        this.logChannel.log(1078071040, "ClusterViewMode#refreshViewMode() - MAP not ready, stay in RGI");
                        break;
                    }
                    this.logChannel.log(-1601830656, "ClusterViewMode#refreshViewMode() - favoredViewMode: %1 not valid!", (long)this.favoredViewMode);
                    break;
                }
                case 2: {
                    if (this.favoredViewMode == 0) {
                        this.logChannel.log(1078071040, "ClusterViewMode#refreshViewMode() - switch to COMPASS");
                        this.viewMode.setValue(0);
                        break;
                    }
                    if (this.favoredViewMode == 1) {
                        if (this.rgiValid) {
                            this.logChannel.log(1078071040, "ClusterViewMode#refreshViewMode() - switch to RGI");
                            this.viewMode.setValue(1);
                            break;
                        }
                        if (!this.isKDKReady()) {
                            this.logChannel.log(-1601830656, "ClusterViewMode#refreshViewMode() - KDK not longer valid!");
                            this.viewMode.setValue(0);
                            break;
                        }
                        this.logChannel.log(1078071040, "ClusterViewMode#refreshViewMode() - RGI not ready, stay in MOST_KDK");
                        break;
                    }
                    if (this.favoredViewMode == 2) {
                        if (!this.isKDKReady()) {
                            this.logChannel.log(-1601830656, "ClusterViewMode#refreshViewMode() - KDK not longer valid!");
                            this.viewMode.setValue(0);
                            break;
                        }
                        this.logChannel.log(1078071040, "ClusterViewMode#refreshViewMode() - stay in KDK");
                        break;
                    }
                    if (this.favoredViewMode == 3) {
                        if (this.isMapReady()) {
                            this.logChannel.log(1078071040, "ClusterViewMode#refreshViewMode() - switch to MAP");
                            this.viewMode.setValue(3);
                            break;
                        }
                        this.logChannel.log(-1601830656, "ClusterViewMode#refreshViewMode() - MAP not longer valid!");
                        this.viewMode.setValue(0);
                        break;
                    }
                    this.logChannel.log(-1601830656, "ClusterViewMode#refreshViewMode() - favoredViewMode: %1 not valid!", (long)this.favoredViewMode);
                    break;
                }
                case 3: {
                    if (this.favoredViewMode == 1) {
                        if (this.rgiValid) {
                            this.logChannel.log(1078071040, "ClusterViewMode#refreshViewMode() - switch to RGI");
                            this.viewMode.setValue(1);
                            break;
                        }
                        if (!this.isKDKReady()) {
                            this.logChannel.log(-1601830656, "ClusterViewMode#refreshViewMode() - KDK not longer valid!");
                            this.viewMode.setValue(0);
                            break;
                        }
                        this.logChannel.log(1078071040, "ClusterViewMode#refreshViewMode() - RGI not ready, stay in MAP");
                        break;
                    }
                    if (this.favoredViewMode == 2) {
                        if (this.isKDKReady()) {
                            this.logChannel.log(1078071040, "ClusterViewMode#refreshViewMode() - switch to KDK");
                            this.viewMode.setValue(2);
                            break;
                        }
                        this.logChannel.log(-1601830656, "ClusterViewMode#refreshViewMode() - KDK not longer valid!");
                        this.viewMode.setValue(0);
                        break;
                    }
                    if (this.favoredViewMode == 3) {
                        if (!this.isMapReady()) {
                            this.logChannel.log(-1601830656, "ClusterViewMode#refreshViewMode() - MOST not longer valid or map not ready! - gfxAvailable: %1, mapReady: %2, komoViewEnabled: %3", this.gfxAvailable, this.mapReady, this.komoViewEnabled);
                            this.viewMode.setValue(0);
                            break;
                        }
                        this.logChannel.log(1078071040, "ClusterViewMode#refreshViewMode() - stay in MAP");
                        break;
                    }
                    this.logChannel.log(-1601830656, "ClusterViewMode#refreshViewMode() - favoredViewMode: %1 not valid!", (long)this.favoredViewMode);
                    break;
                }
                default: {
                    if (this.favoredViewMode == 1 && this.rgiValid) {
                        this.logChannel.log(1078071040, "ClusterViewMode#refreshViewMode() - switch to RGI");
                        this.viewMode.setValue(1);
                        break;
                    }
                    if (this.favoredViewMode == 2 && this.isKDKReady()) {
                        this.logChannel.log(1078071040, "ClusterViewMode#refreshViewMode() - switch to KDK");
                        this.viewMode.setValue(2);
                        break;
                    }
                    if (this.favoredViewMode == 3 && this.isMapReady()) {
                        this.logChannel.log(1078071040, "ClusterViewMode#refreshViewMode() - switch to MAP");
                        this.viewMode.setValue(3);
                        break;
                    }
                    this.logChannel.log(1078071040, "ClusterViewMode#refreshViewMode() - stay in COMPASS!");
                    this.viewMode.setValue(0);
                }
            }
        }
        this.refreshMapVisibility();
        int n2 = this.viewMode.getValue();
        if (this.favoredViewModeReceived || n2 != n) {
            this.clusterService.refreshViewMode(n2);
        }
        this.refreshDisplayContext();
        if (n2 != n) {
            this.clusterService.getKomoService().doFadeOut(1);
            this.refreshDisplayContext();
            this.refreshRgMode();
            this.clusterService.getKomoService().doFadeIn(1);
        }
    }

    private boolean isMostViewMode(int n) {
        return Util.isClusterMapMOST(this.env.getFramework()) && n == 2 || n == 3;
    }

    protected void fadeOutFinished() {
        this.logChannel.log(1078071040, "ClusterViewMode#fadeOutFinished()");
    }

    private void refreshDisplayContext() {
        if (this.viewMode.getValue() == 2) {
            this.clusterService.switchDisplayContextKombi(9);
        } else if (this.viewMode.getValue() == 3) {
            this.clusterService.switchDisplayContextKombi(8);
        }
    }

    private void refreshMapVisibility() {
        boolean bl;
        if (!Util.isClusterMapAvailable(this.env.getFramework())) {
            return;
        }
        boolean bl2 = Util.isClusterMapMOST(this.env.getFramework()) ? this.dataRate == 2 : (bl = true);
        if (this.viewMode.getValue() == 3 && bl) {
            this.clusterService.showKombiMap(true);
        } else {
            this.clusterService.showKombiMap(false);
        }
    }

    void refreshRgMode() {
        int n;
        int n2 = this.viewMode.getValue();
        switch (n2) {
            case 0: {
                n = 2;
                break;
            }
            case 2: {
                n = 1;
                break;
            }
            case 3: {
                n = 3;
                break;
            }
            case 1: {
                n = 0;
                break;
            }
            default: {
                this.logChannel.log(10000, "ClusterViewMode#refreshRgSelect() - unknown viewmode: %1", (long)n2);
                n = 2;
            }
        }
        this.clusterService.getKomoService().setRgSelect(n);
    }

    public static final String viewModeToString(int n) {
        String string;
        switch (n) {
            case 0: {
                string = "COMPASS";
                break;
            }
            case 1: {
                string = "RGI";
                break;
            }
            case 2: {
                string = "KDK";
                break;
            }
            case 3: {
                string = "MAP";
                break;
            }
            default: {
                string = "UNKNOWN";
            }
        }
        return string;
    }

    private boolean isKDKReady() {
        boolean bl;
        boolean bl2 = bl = this.komoViewEnabled && this.komoViewVisible && this.env.getContainer().isRgActive();
        if (Util.isClusterMapMOST(this.env.getFramework())) {
            bl &= this.gfxAvailable;
        }
        if (!bl) {
            Buffer buffer = new Buffer(60);
            buffer.append(this.komoViewEnabled ? "" : "komoViewEnabled ");
            buffer.append(this.komoViewVisible ? "" : "komoViewVisible ");
            buffer.append(this.env.getContainer().isRgActive() ? "" : "isRgActive ");
            buffer.append(!Util.isClusterMapMOST(this.env.getFramework()) || this.gfxAvailable ? "" : "gfxAvailable");
            this.logChannel.log(1078071040, "ClusterViewMode#isKDKReady() - KDK is not ready because of: %1", (Object)buffer);
        }
        return bl;
    }

    private boolean isMapReady() {
        boolean bl = this.mapReady;
        if (Util.isClusterMapMOST(this.env.getFramework())) {
            bl &= this.gfxAvailable;
        }
        if (!bl) {
            Buffer buffer = new Buffer(30);
            buffer.append(this.mapReady ? "" : "mapReady ");
            buffer.append(!Util.isClusterMapMOST(this.env.getFramework()) || this.gfxAvailable ? "" : "gfxAvailable");
            this.logChannel.log(1078071040, "ClusterViewMode#isMapReady() - Map is not ready because of: %1", (Object)buffer);
        }
        return bl;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("combiService: ").append(this.combiService != null ? "available" : "n/a").append('\n');
        buffer.append("currentViewMode: ").append(ClusterViewMode.viewModeToString(this.viewMode.getValue())).append('\n');
        buffer.append("favoredViewMode: ").append(ClusterViewMode.viewModeToString(this.favoredViewMode)).append('\n');
        buffer.append("rgiValid: ").append(this.rgiValid).append('\n');
        buffer.append("gfxAvailable: ").append(this.gfxAvailable).append('\n');
        buffer.append("mapReady: ").append(this.mapReady).append('\n');
        buffer.append("dataRate: ").append(this.dataRate).append('\n');
        buffer.append("komoViewEnabled: ").append(this.komoViewEnabled).append('\n');
        buffer.append("komoViewVisible: ").append(this.komoViewVisible).append('\n');
        return buffer.toString();
    }
}

