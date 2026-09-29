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
    private float mRecommendedZoom = 32959;

    public MVResponseZoomEngine(AbstractMap abstractMap) {
        super(abstractMap.getMapDSILogChannel());
        this.bind(abstractMap);
    }

    public MVResponseZoomEngine(LogChannel logChannel) {
        super(logChannel);
    }

    @Override
    public String getName() {
        return "MVResponseZoomEngine";
    }

    @Override
    public void updateAutoZoomEnabled(boolean bl, int n) {
        if (n == 1) {
            this.getLogger().log(-2137614336, "MVResponseZoomEngine#updateAutoZoomEnabled(%1)", bl);
            this.mAutoZoom = bl;
            this.naviMap.getZoomEventListener().updateAutoZoomEnabled(bl);
        }
    }

    public boolean getAutoZoom() {
        return this.mAutoZoom;
    }

    @Override
    public void updateManoeuvreZoomEnabled(boolean bl, int n) {
        if (n == 1) {
            this.getLogger().log(-2137614336, "MVResponseZoomEngine#updateManoeuvreZoomEnabled(%1)", bl);
            this.mManoeuvreZoom = bl;
            this.naviMap.getZoomEventListener().updateManoeuvreZoomEnabled(bl);
        }
    }

    public boolean getManoeuvreZoom() {
        return this.mManoeuvreZoom;
    }

    @Override
    public void updateZoomEngineState(int n, int n2) {
        if (n2 == 1) {
            this.getLogger().log(-2137614336, "MVResponseZoomEngine#updateZoomEngineState(%1) - 0:off/1:ready/2:auto/3:mano", (long)n);
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

    @Override
    public void updateRecommendedZoom(float f2, int n) {
        if (n == 1) {
            this.getLogger().log(-2137614336, "MVResponseZoomEngine#updateRecommendedZoom(%1)", (Object)Float.toString(f2));
            this.mRecommendedZoom = f2;
            this.naviMap.getZoomEventListener().updateRecommendedZoom(this.mRecommendedZoom);
        }
    }

    public float getRecommendedZoom() {
        return this.mRecommendedZoom;
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        this.getLogger().log(10000, "MVResponseZoomEngine#asyncException(): code = %2, msg = %1, type = %3", (Object)string, (long)n, (long)n2);
    }

    @Override
    public void resetMemberVariables() {
        this.mAutoZoom = false;
        this.mManoeuvreZoom = false;
        this.mZoomEngineState = -1;
        this.mRecommendedZoom = 32959;
    }
}

