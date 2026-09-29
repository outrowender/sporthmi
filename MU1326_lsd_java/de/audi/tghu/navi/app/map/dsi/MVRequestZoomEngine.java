/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.dsi;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.map.dsi.AbstractRequester;
import de.audi.tghu.navi.app.map.dsi.MVResponseZoomEngine;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.map.DSIMapViewerZoomEngine;
import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.Rect;

public class MVRequestZoomEngine
extends AbstractRequester
implements DSIMapViewerZoomEngine {
    private DSIMapViewerZoomEngine mDSIZE;
    private int mOrientation = -1;
    private int mViewtype = -1;
    private Point mScreenCarPosition = new Point(-1, -1);
    private short mMapRotation = (short)-1;
    private Rect mZoomArea = new Rect(0, 0, 0, 0);

    MVRequestZoomEngine(int n, LogChannel logChannel, LogChannel logChannel2) {
        super(n, logChannel, "MVRequestZoomEngine");
        MVResponseZoomEngine mVResponseZoomEngine = new MVResponseZoomEngine(logChannel2);
        this.setResponser(mVResponseZoomEngine);
    }

    protected final boolean isDSIZEAvailable() {
        return this.mDSIZE != null;
    }

    @Override
    protected void cleanup() {
        super.cleanup();
    }

    public void bind(DSIMapViewerZoomEngine dSIMapViewerZoomEngine) {
        if (dSIMapViewerZoomEngine == null) {
            this.cleanupResponserAttributeNotifications();
        }
        this.mDSIZE = dSIMapViewerZoomEngine;
        super.bind(dSIMapViewerZoomEngine);
    }

    public MVResponseZoomEngine getResponserZoomEngine() {
        return (MVResponseZoomEngine)this.getResponser();
    }

    @Override
    protected DSIBase getDSIBase() {
        return this.mDSIZE;
    }

    @Override
    public void autoZoomEnable(boolean bl) {
        if (!this.isDSIZEAvailable()) {
            this.getLogger().log(10000, "MVRequestZoomEngine#autoZoomEnable() - DSIZE not available!");
            return;
        }
        try {
            this.getLogger().log(-2137614336, "MVRequestZoomEngine#autoZoomEnable(%1)", bl);
            this.mDSIZE.autoZoomEnable(bl);
        }
        catch (Exception exception) {
            this.getLogger().log(10000, "MVRequestZoomEngine#autoZoomEnable(): ERROR");
        }
    }

    @Override
    public void manoeuvreZoomEnable(boolean bl) {
        if (!this.isDSIZEAvailable()) {
            this.getLogger().log(10000, "MVRequestZoomEngine#manoeuvreZoomEnable() - DSIZE not available!");
            return;
        }
        try {
            this.getLogger().log(-2137614336, "MVRequestZoomEngine#manoeuvreZoomEnable(%1)", bl);
            this.mDSIZE.manoeuvreZoomEnable(bl);
        }
        catch (Exception exception) {
            this.getLogger().log(10000, "MVRequestZoomEngine#manoeuvreZoomEnable(): ERROR");
        }
    }

    @Override
    public void resetMemberVariables() {
        this.mOrientation = -1;
        this.mViewtype = -1;
        this.mScreenCarPosition = new Point(-1, -1);
        this.mMapRotation = (short)-1;
        this.mZoomArea = new Rect(0, 0, 0, 0);
    }

    @Override
    public void setViewType(int n) {
        if (this.mViewtype != n) {
            if (!this.isDSIZEAvailable()) {
                this.getLogger().log(10000, "MVRequestZoomEngine#setViewType() - DSIZE not available!");
                return;
            }
            try {
                this.getLogger().log(-2137614336, "MVRequestZoomEngine#setViewType(%1)", (long)n);
                this.mDSIZE.setViewType(n);
                this.mViewtype = n;
            }
            catch (Exception exception) {
                this.getLogger().log(10000, "MVRequestZoomEngine#setViewType(): ERROR");
            }
        }
    }

    @Override
    public void setCarPosition(Point point) {
        if (null != this.mScreenCarPosition && (this.mScreenCarPosition.xPos != point.xPos || this.mScreenCarPosition.yPos != point.yPos)) {
            if (!this.isDSIZEAvailable()) {
                this.getLogger().log(10000, "MVRequestZoomEngine#setCarPosition() - DSIZE not available!");
                return;
            }
            try {
                this.getLogger().log(-2137614336, "MVRequestZoomEngine#setCarPosition(%1)", (Object)point);
                this.mDSIZE.setCarPosition(point);
                this.mScreenCarPosition = point;
            }
            catch (Exception exception) {
                this.getLogger().log(10000, "MVRequestZoomEngine#setCarPosition(): ERROR");
            }
        }
    }

    @Override
    public void setMapRotation(short s) {
        if (this.mMapRotation != s) {
            if (!this.isDSIZEAvailable()) {
                this.getLogger().log(10000, "MVRequestZoomEngine#setMapRotation() - DSIZE not available!");
                return;
            }
            try {
                this.getLogger().log(-2137614336, "MVRequestZoomEngine#setMapRotation(%1)", (long)s);
                this.mDSIZE.setMapRotation(s);
                this.mMapRotation = s;
            }
            catch (Exception exception) {
                this.getLogger().log(10000, "MVRequestZoomEngine#setMapRotation(): ERROR");
            }
        }
    }

    public void setMapOrientation(int n) {
        if (this.mOrientation != n) {
            if (!this.isDSIZEAvailable()) {
                this.getLogger().log(10000, "MVRequestZoomEngine#setMapOrientation() - DSIZE not available!");
                return;
            }
            try {
                this.getLogger().log(-2137614336, "MVRequestZoomEngine#setMapOrientation(%1)", (long)n);
                this.mDSIZE.setMapOrientation(n, new Point());
                this.mOrientation = n;
            }
            catch (Exception exception) {
                this.getLogger().log(10000, "MVRequestZoomEngine#setMapOrientation(): ERROR");
            }
        }
    }

    @Override
    public void setMapOrientation(int n, Point point) {
        if (this.mOrientation != n) {
            if (!this.isDSIZEAvailable()) {
                this.getLogger().log(10000, "MVRequestZoomEngine#setMapOrientation() - DSIZE not available!");
                return;
            }
            try {
                this.getLogger().log(-2137614336, "MVRequestZoomEngine#setMapOrientation(%2, %1)", (Object)point, (long)n);
                this.mDSIZE.setMapOrientation(n, point);
                this.mOrientation = n;
            }
            catch (Exception exception) {
                this.getLogger().log(10000, "MVRequestZoomEngine#setMapOrientation(): ERROR");
            }
        }
    }

    @Override
    public void setZoomArea(Rect rect) {
        if (rect == null) {
            this.getLogger().log(-1601830656, "MVRequestZoomEngine#setZoomArea( null )");
            return;
        }
        if (null != this.mZoomArea && (this.mZoomArea.kordX != rect.kordX || this.mZoomArea.kordY != rect.kordY || this.mZoomArea.diffX != rect.diffX || this.mZoomArea.diffY != rect.diffY)) {
            if (!this.isDSIZEAvailable()) {
                this.getLogger().log(10000, "MVRequestZoomEngine#setZoomArea() - DSIZE not available!");
                return;
            }
            try {
                this.getLogger().log(-2137614336, "MVRequestZoomEngine#setZoomArea(%1)", (Object)rect);
                this.mDSIZE.setZoomArea(rect);
                this.mZoomArea = rect;
            }
            catch (Exception exception) {
                this.getLogger().log(10000, "MVRequestZoomEngine#setZoomArea(): ERROR");
            }
        }
    }
}

