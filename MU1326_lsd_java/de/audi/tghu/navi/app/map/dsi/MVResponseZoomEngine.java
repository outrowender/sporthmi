/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.dsi;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.map.dsi.AbstractResponser;
import org.dsi.ifc.map.DSIMapViewerZoomEngineListener;

public final class MVResponseZoomEngine
extends AbstractResponser
implements DSIMapViewerZoomEngineListener {
    private boolean mAutoZoom = false;
    private boolean mManoeuvreZoom = false;
    private int mZoomEngineState = -1;
    private float mRecommendedZoom = -1.0f;

    public MVResponseZoomEngine(AbstractMap abstractMap) {
        super(abstractMap.getMapDSILogChannel());
        this.bind(abstractMap);
    }

    public MVResponseZoomEngine(LogChannel logChannel) {
        super(logChannel);
    }

    public String getName() {
        return "MVResponseZoomEngine";
    }

    public void updateAutoZoomEnabled(boolean bl, int n) {
        if (n == 1) {
            this.getLogger().log(10000000, "MVResponseZoomEngine#updateAutoZoomEnabled(%1)", bl);
            this.mAutoZoom = bl;
            this.naviMap.getZoomEventListener().updateAutoZoomEnabled(bl);
        }
    }

    public boolean getAutoZoom() {
        return this.mAutoZoom;
    }

    public void updateManoeuvreZoomEnabled(boolean bl, int n) {
        if (n == 1) {
            this.getLogger().log(10000000, "MVResponseZoomEngine#updateManoeuvreZoomEnabled(%1)", bl);
            this.mManoeuvreZoom = bl;
            this.naviMap.getZoomEventListener().updateManoeuvreZoomEnabled(bl);
        }
    }

    public boolean getManoeuvreZoom() {
        return this.mManoeuvreZoom;
    }

    public void updateZoomEngineState(int n, int n2) {
        if (n2 == 1) {
            this.getLogger().log(10000000, "MVResponseZoomEngine#updateZoomEngineState(%1) - 0:off/1:ready/2:auto/3:mano", (long)n);
            this.mZoomEngineState = n;
            this.naviMap.getZoomEventListener().updateZoomEngineState(n);
            if (this.getMap() == null) {
                return;
            }
            if (this.getMap().isMapMain()) {
                this.naviMap.getMapManager().getMapEventDispatcher().fireEvent(104, n);
            } else if (this.getMap().isMapKombi()) {
                this.naviMap.getMapManager().getMapEventDispatcher().fireEvent(107, n);
            }
        }
    }

    public int getZoomEngineState() {
        return this.mZoomEngineState;
    }

    public void updateRecommendedZoom(float f2, int n) {
        if (n == 1) {
            this.getLogger().log(10000000, "MVResponseZoomEngine#updateRecommendedZoom(%1)", (Object)Float.toString(f2));
            this.mRecommendedZoom = f2;
            this.naviMap.getZoomEventListener().updateRecommendedZoom(this.mRecommendedZoom);
        }
    }

    public float getRecommendedZoom() {
        return this.mRecommendedZoom;
    }

    public void asyncException(int n, String string, int n2) {
        this.getLogger().log(10000, "MVResponseZoomEngine#asyncException(): code = %2, msg = %1, type = %3", (Object)string, (long)n, (long)n2);
    }

    public void resetMemberVariables() {
        this.mAutoZoom = false;
        this.mManoeuvreZoom = false;
        this.mZoomEngineState = -1;
        this.mRecommendedZoom = -1.0f;
    }
}

