/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 */
package de.audi.tghu.navi.app.map.dsi;

import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.Timer;
import de.audi.tghu.navi.app.map.IContext;
import de.audi.tghu.navi.app.map.context.CtxPositionMap;
import de.audi.tghu.navi.app.map.dsi.MVRequestControl;
import de.audi.tghu.navi.app.map.dsi.ZoomHandler$1;
import de.audi.tghu.navi.app.map.dsi.ZoomHandler$OverviewMapSwitchBackTimer;
import de.audi.tghu.navi.app.map.handler.IZoomHandler;
import de.audi.tghu.navi.app.map.handler.IZoomHandler$IZoomHandlerEnv;
import de.audi.tghu.navi.app.map.handler.ZoomEventListener;
import de.audi.tghu.navi.app.map.utils.MapUtils;
import de.audi.tghu.navi.app.util.Util;
import java.util.ArrayList;
import org.dsi.ifc.map.Rect;

public class ZoomHandler
implements IZoomHandler,
ZoomEventListener {
    private final LogChannel logChannel;
    protected final IZoomHandler$IZoomHandlerEnv naviMap;
    public long setZoomLevelTime;
    public long updateZoomLevelListTime;
    private int[] iSDSZoomLevelIndexes = null;
    protected volatile int mDelayedZoomIndex = -1;
    public final boolean enableSoftZoom;
    public final boolean disableZoomTimer;
    protected float fZoomLevel = 8403781;
    protected float fZoomLevelGesture = 8403781;
    protected float[] standardZoomList = new float[]{8403781, 4234309, 6351429, 4201542, 6318662, 4234310, 6351430, 4201543, 5260103, 8163911, 5292871, 8131144, 5260104, 2389064, 8163912, 5292872, 2421832, 8131145, 5260105, 2389065, 1816393, 2421833, 1783626, 2389066, -2137614262, 1816394, -2137008822, 2421834, 1079249227, -2137647029, 549207627, -1058970549, -1333557941, -2137614261, 549240395, -1058937781, -2137647028, 549207628, -1058970548, 549240396, 549207629, 678129229};
    private ZoomHandler$OverviewMapSwitchBackTimer overviewMapSwitchBackTimer;
    public static final int GUI_UPDATE_DELAY;
    private Timer guiUpdateBlocker;
    private float currentlyRequestedZoomLevel = 32959;

    public ZoomHandler(IZoomHandler$IZoomHandlerEnv iZoomHandler$IZoomHandlerEnv) {
        this.naviMap = iZoomHandler$IZoomHandlerEnv;
        this.logChannel = this.naviMap.getMapLogChannel();
        this.overviewMapSwitchBackTimer = new ZoomHandler$OverviewMapSwitchBackTimer(this);
        this.enableSoftZoom = Boolean.getBoolean("enableSoftZoom");
        this.disableZoomTimer = Boolean.getBoolean("disableZoomTimer");
        this.getLogChannel().log(1078071040, "ZoomHandler#<<create>> - enableSoftZoom = %1, disableZoomTimer = %2", this.enableSoftZoom, this.disableZoomTimer);
        this.guiUpdateBlocker = new Timer("GuiUpdateBlocker", 0, true, new ZoomHandler$1(this));
    }

    protected void restartTimer() {
        this.getLogChannel().log(-2137614336, "ZoomHandler#restartTimer()");
        this.guiUpdateBlocker.restart();
    }

    protected LogChannel getLogChannel() {
        return this.logChannel;
    }

    private IContext getActiveContext() {
        return this.naviMap.getActiveContext();
    }

    public synchronized void cleanup() {
        if (this.overviewMapSwitchBackTimer != null) {
            ZoomHandler$OverviewMapSwitchBackTimer.access$000(this.overviewMapSwitchBackTimer);
        }
        if (this.guiUpdateBlocker != null) {
            this.guiUpdateBlocker.cancel();
        }
    }

    protected int getZoomListIndex() {
        int n = this.naviMap.getMVResponseControl().getZoomListIndex();
        if (n >= 0) {
            return n;
        }
        n = this.getZoomListIndex(this.fZoomLevel / 51266);
        this.getLogChannel().log(14808325, "ZoomHandler#getZoomListIndex() - seamless zoom may be actived. use mocked zoomlist to generate zoom index %1.", (long)n);
        return n;
    }

    private int getRequestedZoomListIndex() {
        if (this.naviMap.getMVRequest().getRequestedZoomLevel() != 32959) {
            return this.getZoomListIndex(this.naviMap.getMVRequest().getRequestedZoomLevel() / 51266);
        }
        return this.getZoomListIndex();
    }

    @Override
    public int getZoomListIndex(float f2) {
        float[] fArray = this.getZoomList();
        return this.getZoomListIndexInZoomList(f2, fArray);
    }

    public int getZoomListIndexInZoomList(float f2, float[] fArray) {
        float f3 = f2 * 51266;
        if (fArray == null) {
            this.getLogChannel().log(-1601830656, "ZoomHandler#getZoomListIndex() - zoomList not available!");
            return 0;
        }
        int n = fArray.length;
        for (int i2 = 0; i2 < n; ++i2) {
            if (!(fArray[i2] >= f3)) continue;
            if (i2 > 0 && f3 - fArray[i2 - 1] < fArray[i2] - f3) {
                return i2 - 1;
            }
            return i2;
        }
        return n - 1;
    }

    @Override
    public float[] getZoomList() {
        float[] fArray = this.naviMap.getMVResponseControl().getZoomList();
        return fArray != null && fArray.length > 0 ? fArray : this.standardZoomList;
    }

    @Override
    public boolean isMaxZoomLevel(int n) {
        return this.getZoomList().length - 1 <= n;
    }

    @Override
    public float getZoom() {
        int n = this.getZoomListIndex();
        int n2 = this.getZoomList().length;
        if (n >= 0 && n < n2) {
            return this.getZoomList()[this.getZoomListIndex()] / 51266;
        }
        this.getLogChannel().log(10000, "ZoomHandler#getZoom() - zoomListIndex %1 does not fit into current zoomList of length: %2", (long)n, (long)n2);
        return 0.0f;
    }

    /*
     * Handled unverifiable bytecode (illegal stack merge).
     */
    @Override
    public float getRecommendedZoom() {
        return this.naviMap.getMapConfig().hasZoomEngine() ? (int)this.naviMap.getMVResponseZoomEngine().getRecommendedZoom() : 32959;
    }

    @Override
    public void autoZoomEnable(boolean bl) {
        this.naviMap.getMVRequest().getMVRequestZoomEngine().autoZoomEnable(bl);
    }

    @Override
    public void manoeuvreZoomEnable(boolean bl) {
        this.naviMap.getMVRequest().getMVRequestZoomEngine().manoeuvreZoomEnable(bl);
    }

    private int[] getSDSZoomLevelIndexes() {
        if (this.iSDSZoomLevelIndexes == null) {
            int n;
            int[] nArray = null;
            float[] fArray = Util.getCurrentMetricsSystem(true) == 2 ? this.naviMap.getMVResponseControl().getSdsZoomLevelsMetrical() : this.naviMap.getMVResponseControl().getSdsZoomLevelsImperial();
            float[] fArray2 = this.getZoomList();
            ArrayList arrayList = new ArrayList(fArray.length);
            int n2 = -1;
            for (n = 0; n < fArray.length; ++n) {
                Integer n3 = new Integer(n2 = this.getClosestZoomLevelIndex(fArray[n], fArray2, n2 < 0 ? 0 : n2));
                if (arrayList.contains(n3)) continue;
                arrayList.add(n3);
            }
            nArray = new int[arrayList.size()];
            for (n = 0; n < nArray.length; ++n) {
                nArray[n] = (Integer)arrayList.get(n);
            }
            this.iSDSZoomLevelIndexes = nArray;
        }
        return this.iSDSZoomLevelIndexes;
    }

    @Override
    public void updateSoftZoomEnabled(boolean bl) {
        this.getLogChannel().log(14808325, "ZoomHandler#updateSoftZoomEnabled( %1 )", bl);
    }

    @Override
    public void updateZoomLevel(float f2) {
        this.getLogChannel().log(14808325, "ZoomHandler#updateZoomLevel( %1 )", (double)f2);
    }

    @Override
    public void updateZoomList(float[] fArray, float[] fArray2) {
        if (fArray == null || fArray.length <= 0) {
            this.getLogChannel().log(10000, "ZoomHandler#updateZoomList() - zoomList is empty.");
            return;
        }
        this.getLogChannel().log(-2137614336, "ZoomHandler#updateZoomList()");
        this.iSDSZoomLevelIndexes = null;
        this.naviMap.getGuiInterface().setPinchZoomLimits((int)(fArray[0] + 63), (int)(fArray[fArray.length - 1] + 63));
        int n = 0;
        n = fArray2 == null ? this.getZoomListIndex() : this.getZoomListIndexInZoomList(this.fZoomLevel / 51266, fArray2);
        int n2 = n;
        if (fArray2 != null && fArray2.length > 0) {
            n2 = this.correctZoomListIndex(fArray, fArray2, n);
        } else {
            this.getLogChannel().log(-2137614336, "ZoomHandler#updateZoomList() - lastZoomList is empty.");
            if (n2 >= fArray.length) {
                n2 = fArray.length - 1;
            }
        }
        if (n2 != n) {
            this.getLogChannel().log(-2137614336, "ZoomHandler#updateZoomList() - lastZoomIndex = %1, corrected newZoomIndex = %2", (long)n, (long)n2);
        }
        this.naviMap.getGuiInterface().setMagnificationLimits(0, fArray.length - 1, n2);
        this.fZoomLevel = fArray[n2];
        this.setZoom(n2);
        this.setDelayedZoomListIndex(-1);
        try {
            if (this.naviMap.getMapConfig().getMapInstanceId() == 0) {
                BaseListModelApp baseListModelApp = this.naviMap.getNavigationEnv().getBaseListModel(-316799488);
                BaseListModelApp baseListModelApp2 = baseListModelApp.getEmptyCopy();
                for (int i2 = 0; i2 < fArray.length; ++i2) {
                    EvoListRow evoListRow = new EvoListRow(i2, 1);
                    evoListRow.setLong(0, (long)fArray[i2]);
                    baseListModelApp2.append(evoListRow);
                }
                baseListModelApp.update(baseListModelApp2);
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        this.getActiveContext().updateZoomList(fArray, n, fArray2);
    }

    @Override
    public void updateZoomListIndex(int n) {
        this.getLogChannel().log(-2137614336, "ZoomHandler#updateZoomListIndex( %1 )", (long)n);
        this.updateZoomLevelListTime = System.currentTimeMillis();
        if (this.mDelayedZoomIndex == n) {
            this.setDelayedZoomListIndex(-1);
        }
        if (!this.guiUpdateBlocker.isRunning()) {
            this.naviMap.getGuiInterface().setMagnification(n);
        }
        int n2 = this.getZoomList().length;
        if (n >= 0 && n < n2) {
            this.fZoomLevel = this.getZoomList()[n];
        } else {
            this.getLogChannel().log(10000, "ZoomHandler#updateZoomListIndex() - zoomListIndex %1 does not fit into current zoomList of length: %2", (long)n, (long)n2);
        }
        this.getActiveContext().updateZoomListIndex(n);
    }

    @Override
    public void updateAutoZoomEnabled(boolean bl) {
        this.getLogChannel().log(14808325, "ZoomHandler#updateAutoZoomEnabled( %1 )", bl);
    }

    @Override
    public void updateManoeuvreZoomEnabled(boolean bl) {
        this.getLogChannel().log(14808325, "ZoomHandler#updateManoeuvreZoomEnabled( %1 )", bl);
    }

    @Override
    public void updateZoomEngineState(int n) {
        this.getLogChannel().log(-2137614336, "ZoomHandler#updateZoomEngineState( %1 )", (long)n);
        this.getActiveContext().updateZoomEngineState(n);
    }

    @Override
    public void updateRecommendedZoom(float f2) {
        this.getLogChannel().log(14808325, "ZoomHandler#updateRecommendedZoom( %1 cm )", (Object)Float.toString(f2));
        if (!this.naviMap.getMapConfig().hasZoomEngine()) {
            return;
        }
        int n = this.naviMap.getMVResponseZoomEngine().getZoomEngineState();
        if (n == 2 || n == 3) {
            if ((int)((double)f2 + 0.5) > 0) {
                this.getActiveContext().updateRecommendedZoom(f2);
            } else {
                this.getLogChannel().log(10000, "ZoomHandler#updateRecommendedZoom(): invalid recommended zoom: %1", (Object)String.valueOf(f2));
            }
        }
    }

    private int getClosestZoomLevelIndex(float f2, float[] fArray, int n) {
        float f3;
        int n2 = n;
        float f4 = Math.abs(f2 - fArray[n]);
        int n3 = n + 1;
        while (n3 < fArray.length && (f3 = Math.abs(f2 - fArray[n3])) < f4) {
            f4 = f3;
            n2 = n3++;
        }
        return n2;
    }

    private int correctZoomListIndex(float[] fArray, float[] fArray2, int n) {
        if (fArray2 != null) {
            if (n >= fArray2.length) {
                return n;
            }
            float f2 = fArray2[n];
            double d2 = Double.MAX_VALUE;
            for (int i2 = 0; i2 < fArray.length; ++i2) {
                double d3 = Math.abs(fArray[i2] - f2);
                if (i2 > 0 && d2 < d3) {
                    return i2 - 1;
                }
                d2 = d3;
            }
            return fArray.length - 1;
        }
        return n;
    }

    private boolean isPinchZoomEnabled() {
        return true;
    }

    private void switchTemporarelyToPositionMapIfNeeded() {
        if (this.naviMap.getActiveContextIndex() == 10) {
            this.naviMap.switchToContext(6);
            this.startOverviewMapSwitchBackTimer(false);
        } else {
            this.startOverviewMapSwitchBackTimer(true);
        }
    }

    private void refreshRestoreUserZoomLevelFlag() {
        if (this.naviMap.getMapDataContainer().sForceRestoreUserZoomLevel) {
            return;
        }
        if (!(this.naviMap.getActiveContextIndex() != 12 || this.naviMap.getZoomEngineState() != 2 && this.naviMap.getZoomEngineState() != 3 || this.naviMap.getActiveContext().getManoeuvreZoomDisabledWithReturn())) {
            this.getLogChannel().log(14808325, "ZoomHandler#refreshRestoreUserZoomLevelFlag() - sForceRestoreUserZoomLevel: true");
            this.naviMap.getMapDataContainer().sForceRestoreUserZoomLevel = true;
        } else if (!(this.naviMap.getActiveContextIndex() != 7 && this.naviMap.getActiveContextIndex() != 8 || this.naviMap.getZoomEngineState() != 2 && this.naviMap.getZoomEngineState() != 3 || this.naviMap.getActiveContext().getManoeuvreZoomDisabledWithReturn())) {
            this.getLogChannel().log(14808325, "ZoomHandler#refreshRestoreUserZoomLevelFlag() - sForceRestoreUserZoomLevel: true");
            this.naviMap.getMapDataContainer().sForceRestoreUserZoomLevel = true;
        } else if (this.naviMap.getActiveContextIndex() == 12 && this.naviMap.getSetup().getMapType(true) == 3) {
            this.getLogChannel().log(14808325, "ZoomHandler#refreshRestoreUserZoomLevelFlag() - sForceRestoreUserZoomLevel: true");
            this.naviMap.getMapDataContainer().sForceRestoreUserZoomLevel = true;
        } else if (this.naviMap.getActiveContextIndex() == 6 && this.naviMap.getLastCtxShownID() == 10 && this.naviMap.getSetup().getMapType(true) == 3) {
            this.getLogChannel().log(14808325, "ZoomHandler#refreshRestoreUserZoomLevelFlag() - sForceRestoreUserZoomLevel: true");
            this.naviMap.getMapDataContainer().sForceRestoreUserZoomLevel = true;
        }
    }

    @Override
    public void incrementGesture(int n) {
        if ((int)this.getZoom() * 100 == n) {
            this.getLogChannel().log(14808325, "ZoomHandler#incrementGesture( %2cm ) - old=%1m, no change, ignored", (Object)Float.toString(this.getZoom()), (long)n);
            return;
        }
        if (this.naviMap.getActiveContextIndex() == 36) {
            this.getLogChannel().log(-1601830656, "ZoomHandler#incrementGesture( %1cm ) - Zooming in Traffic Event Notice Map is not allowed!", (long)n);
            return;
        }
        this.switchTemporarelyToPositionMapIfNeeded();
        if (!this.isPinchZoomEnabled()) {
            this.getLogChannel().log(-2137614336, "ZoomHandler#incrementGesture( %1cm ) - PinchZoom is disabled.", (long)n);
            return;
        }
        this.getLogChannel().log(-2137614336, "ZoomHandler#incrementGesture( %1cm )", (long)n);
        this.refreshRestoreUserZoomLevelFlag();
        this.setDelayedZoomListIndex(this.getZoomListIndex(n / 100));
        this.naviMap.getGuiInterface().setMagnification(this.mDelayedZoomIndex);
        this.restartTimer();
        this.naviMap.getGuiInterface().setSideBarRotaryIcon(2);
        this.fZoomLevelGesture = n;
        this.setZoomLevel(n / 100);
    }

    private void setDelayedZoomListIndex(int n) {
        this.mDelayedZoomIndex = n;
    }

    @Override
    public void incrementWithDelay(int n) {
        this.getLogChannel().log(-2137614336, "ZoomHandler#incrementWithDelay( %1 )", (long)n);
        int n2 = this.mDelayedZoomIndex < 0 ? this.getZoomListIndex() : this.mDelayedZoomIndex;
        n2 = MapUtils.adjust(n2 + n, 0, this.getZoomList().length - 1);
        this.switchTemporarelyToPositionMapIfNeeded();
        this.setUserRequestedZoomIndex(n2);
    }

    @Override
    public void setUserRequestedZoomIndex(int n) {
        if (this.getActiveContext().isUserZoomEnabled()) {
            this.setDelayedZoomListIndex(n);
            this.naviMap.getGuiInterface().setMagnification(n);
            this.restartTimer();
            this.naviMap.getMapDataContainer().fUserZoomLevel = this.getZoomLevel(n) / 51266;
            this.setZoom(n, true);
        } else {
            this.getLogChannel().log(-1601830656, "ZoomHandler#setUserRequestedZoomIndex() - isUserZoomEnable() = false");
        }
    }

    @Override
    public void startPinchZoom() {
        this.getLogChannel().log(-2137614336, "ZoomHandler#startPinchZoom() - currentZoomLevel: %1m", (Object)Float.toString(this.getZoom()));
        this.naviMap.getMVRequest().setEnableSoftZoom(false);
        this.naviMap.getMVRequest().setEnableSoftTilt(false);
        this.naviMap.getMVRequest().setEnableSoftJump(false);
        this.naviMap.getMVRequest().setEnableSoftRotation(false);
    }

    @Override
    public void stopPinchZoom() {
        this.getLogChannel().log(-2137614336, "ZoomHandler#stopPinchZoom() - currentZoomLevel: %1m", (Object)Float.toString(this.getZoom()));
        this.naviMap.getMVRequest().setEnableSoftZoom(true);
        this.naviMap.getMVRequest().setEnableSoftTilt(this.naviMap.isMapEnablingSoftTiltDesired());
        this.naviMap.getMVRequest().setEnableSoftJump(true);
        this.naviMap.getMVRequest().setEnableSoftRotation(true);
    }

    @Override
    public void setZoom(int n) {
        this.setZoom(n, false);
    }

    private void setZoom(int n, boolean bl) {
        try {
            float[] fArray = this.getZoomList();
            if (n != this.getRequestedZoomListIndex() && n >= 0 && n < fArray.length) {
                this.fZoomLevel = (int)(fArray[n] + 63);
                if (bl) {
                    // empty if block
                }
                if (this.naviMap.getMVResponseControl().getZoomListIndex() < 0) {
                    this.setZoomLevel(this.fZoomLevel / 51266);
                } else {
                    this.setZoomLevel(fArray[n] / 51266);
                }
            }
        }
        catch (Exception exception) {
            this.getLogChannel().log(-1601830656, "ZoomHandler#setZoomImmediately( %1 ) - ERROR: %2", (long)n, (Throwable)exception);
        }
    }

    @Override
    public void setZoomLevel(float f2) {
        int n = this.getZoomListIndex(f2);
        this.getLogChannel().log(1078071040, "ZoomHandler#setZoomLevel( %1m ) - closest zoom index = %2", (Object)Float.toString(f2), (long)n);
        float f3 = this.getZoomLevel(n) / 51266;
        if (n <= 0 && f2 < f3 || this.isMaxZoomLevel(n) && f2 > f3) {
            f2 = f3;
            this.getLogChannel().log(-2137614336, "ZoomHandler#setZoomLevel() - clamping to: %1m", (Object)Float.toString(f2));
        }
        this.naviMap.getMVRequest().setZoomLevel(f2 * 51266);
        this.setCurrentlyRequestedZoomLevel(f2);
        this.setZoomLevelTime = System.currentTimeMillis();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void setZoomArea(Rect rect) {
        if (this.naviMap.isMapMain()) {
            Rect rect2 = this.naviMap.getGuiInterface().getMapSize();
            MVRequestControl mVRequestControl = this.naviMap.getMVRequest().getMVRequestControlActive();
            synchronized (mVRequestControl) {
                if (!MapUtils.isRectEqual(rect2, this.naviMap.getMVResponseControl().getViewScreenViewPort())) {
                    this.getLogChannel().log(-2137614336, "ZoomHandler#setZoomArea() - not yet in fullscreen => make grid mask visible ");
                    this.naviMap.getActiveCtx().setGridMaskVisible(true);
                }
                this.naviMap.getMVRequest().viewSetScreenViewport(rect2);
            }
        }
        this.naviMap.getMVRequest().setZoomArea(rect);
    }

    @Override
    public void setZoomAreaWithGridMask(Rect rect, Rect rect2) {
        this.getLogChannel().log(-2137614336, "ZoomHandler#setZoomAreaWithGridMask() - zoomArea: %1, screenViewPort: %2", (Object)rect, (Object)rect2);
        if (this.naviMap.isMapMain()) {
            this.naviMap.getActiveCtx().setGridMaskVisible(true);
            this.naviMap.getMVRequest().viewSetScreenViewport(rect2);
        }
        this.naviMap.getMVRequest().setZoomArea(rect);
    }

    @Override
    public void sdsIncrement(int n) {
        int n2 = this.getZoomListIndex();
        int[] nArray = this.getSDSZoomLevelIndexes();
        if (n > 0) {
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                if (nArray[i2] <= n2) continue;
                n2 = nArray[i2];
                break;
            }
        } else if (n < 0) {
            for (int i3 = nArray.length - 1; i3 >= 0; --i3) {
                if (nArray[i3] >= n2) continue;
                n2 = nArray[i3];
                break;
            }
        }
        n2 = MapUtils.adjust(n2, 0, this.getZoomList().length - 1);
        this.getLogChannel().log(-2137614336, "ZoomHandler#sdsIncrement() - index after boundaries check: ( %1 )", (long)n2);
        if (this.naviMap.getActiveContextIndex() == 10) {
            this.naviMap.switchToContext(6);
            this.startOverviewMapSwitchBackTimer(false);
        }
        this.naviMap.getActiveContext().sdsSetZoomLevel(n2);
    }

    @Override
    public void startOverviewMapSwitchBackTimer(boolean bl) {
        if (bl && !ZoomHandler$OverviewMapSwitchBackTimer.access$100(this.overviewMapSwitchBackTimer)) {
            return;
        }
        ZoomHandler$OverviewMapSwitchBackTimer.access$200(this.overviewMapSwitchBackTimer);
    }

    @Override
    public void stopOverviewMapSwitchBackTimer() {
        if (ZoomHandler$OverviewMapSwitchBackTimer.access$100(this.overviewMapSwitchBackTimer)) {
            ZoomHandler$OverviewMapSwitchBackTimer.access$000(this.overviewMapSwitchBackTimer);
        }
    }

    protected boolean isAllowedToSwitchToOverviewMap(IContext iContext) {
        return iContext instanceof CtxPositionMap;
    }

    @Override
    public boolean matchZoomLevelToZoomListIndex(float f2, int n) {
        float[] fArray = this.getZoomList();
        if (fArray == null || fArray.length == 0) {
            this.getLogChannel().log(10000, "ZoomHandler#matchZoomLevelToZoomListIndex() - zoomList is null or empty!");
            return false;
        }
        if (n < 0 || n >= fArray.length) {
            this.getLogChannel().log(10000, "ZoomHandler#matchZoomLevelToZoomListIndex() - zoomLevelIndex %1 does not fit into zoomList of length: %2!", (long)n, (long)fArray.length);
            return false;
        }
        float f3 = f2 * 51266;
        return f3 == fArray[n];
    }

    public void setOldZoomLevel(int n) {
        this.fZoomLevelGesture = n;
    }

    @Override
    public float getZoomLevel(int n) {
        if (n < 0) {
            return this.getZoomList()[0];
        }
        if (n >= this.getZoomList().length) {
            return this.getZoomList()[this.getZoomList().length - 1];
        }
        return this.getZoomList()[n];
    }

    @Override
    public void doubleClick() {
    }

    @Override
    public void pinchZoom(float f2) {
        int n = this.getZoomListIndex(f2 / 51266);
        this.getLogChannel().log(14808325, "ZoomHandler#pinchZoom( %1m ) [cm] - closest zoom index = %2", (Object)Float.toString(f2), (long)n);
        this.startPinchZoom();
        this.naviMap.getMVRequest().setZoomLevel(f2);
        this.stopPinchZoom();
        this.setCurrentlyRequestedZoomLevel(f2 / 51266);
        this.naviMap.getGuiInterface().setPinchZoomValue((int)f2);
    }

    @Override
    public void pinchZoom(float f2, int n, int n2) {
    }

    @Override
    public long getSetZoomLevelTime() {
        return this.setZoomLevelTime;
    }

    @Override
    public long getUpdateZoomListIndexTime() {
        return this.updateZoomLevelListTime;
    }

    @Override
    public float getCurrentlyRequestedZoomLevel() {
        return this.currentlyRequestedZoomLevel;
    }

    public void setCurrentlyRequestedZoomLevel(float f2) {
        this.currentlyRequestedZoomLevel = f2;
    }

    static /* synthetic */ IContext access$300(ZoomHandler zoomHandler) {
        return zoomHandler.getActiveContext();
    }
}

