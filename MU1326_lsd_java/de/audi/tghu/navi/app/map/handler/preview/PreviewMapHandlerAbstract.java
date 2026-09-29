/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.handler.preview;

import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.interapp.PreviewMapCallback;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.map.handler.NullPreviewMapCallback;
import de.audi.tghu.navi.app.map.handler.preview.PreviewMapEventVisibilities;
import de.audi.tghu.navi.app.map.handler.preview.PreviewMapUtils;
import de.audi.tghu.navi.app.map.handler.preview.gui.GuiModelAccessForPreviewMapDetailScreenDefault;
import de.audi.tghu.navi.app.map.handler.preview.gui.GuiPreviewMapLayout;
import de.audi.tghu.navi.app.map.handler.preview.states.FactoryPreviewMapStateAbstract;
import de.audi.tghu.navi.app.map.handler.preview.states.PreviewMapStateAbstract;
import de.audi.tghu.navi.app.map.utils.MapPin;
import de.audi.tghu.navi.app.map.utils.MapUtils;
import java.util.HashMap;
import java.util.Map;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.Rect;

public abstract class PreviewMapHandlerAbstract
implements IPreviewMap {
    protected static final int PREVIEW_MAP_MODE_IDLE;
    protected static final int PREVIEW_MAP_MODE_ACTIVE_MAP_DETAIL_SCREEN;
    protected static final int PREVIEW_MAP_MODE_ACTIVE_MAP_FULL_SCREEN_WITH_TOOLTIP;
    protected static final int PREVIEW_MAP_MODE_APPLY_ITEM_BEFORE_SHOWN;
    protected int previewMapMode = 1;
    protected final NavigationEnv env;
    protected final LogChannel logger;
    protected PreviewMapCallback previewMapListHandler;
    protected final AbstractMap mapForPreview;
    protected FactoryPreviewMapStateAbstract factoryPreviewMapState;
    protected volatile boolean freezeAllowed = true;
    protected volatile boolean unfreezeRequired = false;
    protected volatile boolean refreshAllowed = false;
    protected Map mapPreviewMapLayouts = new HashMap();
    protected PreviewMapEventVisibilities previewMapEventVisibilities;
    protected boolean isRefreshLayoutNecessary = false;
    protected boolean isRefreshMapContextNecessary = false;
    private boolean mapPositionRefreshAllowed = true;
    protected volatile PreviewMapStateAbstract previewMapStateToReleaseForApplyToScreenDetail = null;
    protected volatile PreviewMapStateAbstract previewMapStateToReleaseForApplyToFullScreenMap = null;

    protected PreviewMapHandlerAbstract(NavigationEnv navigationEnv, AbstractMap abstractMap) {
        this.env = navigationEnv;
        this.mapForPreview = abstractMap;
        this.logger = abstractMap.getMapLogChannel();
        this.previewMapListHandler = new NullPreviewMapCallback(this.logger);
        this.factoryPreviewMapState = this.getFactoryPreviewMapState();
        this.previewMapEventVisibilities = new PreviewMapEventVisibilities(this);
    }

    public AbstractMap getMapForPreview() {
        return this.mapForPreview;
    }

    public abstract GuiModelAccessForPreviewMapDetailScreenDefault getGuiModelAccessForPreviewMapDetailScreenDefault() {
    }

    public abstract FactoryPreviewMapStateAbstract getFactoryPreviewMapState() {
    }

    public AbstractMap getMapForFullScreen() {
        return this.mapForPreview;
    }

    public LogChannel getLogChannel() {
        return this.logger;
    }

    protected boolean isPreviewMapOperable() {
        if (!this.mapForPreview.getNaviInterface().getOperationManager().isFullyOperable()) {
            this.logger.log(-2137614336, "PreviewMapHandlerAbstract#isPreviewMapOperable() - not fully operable ");
            return false;
        }
        if (!this.mapForPreview.getMVRequest().getMVRequestControlActive().isOperable()) {
            this.logger.log(-2137614336, "PreviewMapHandlerAbstract#isPreviewMapOperable() - MVRequest not fully operable ");
            return false;
        }
        return true;
    }

    protected boolean isPreviewMapReady() {
        if (!this.isPreviewMapOperable()) {
            this.logger.log(-2137614336, "PreviewMapHandlerAbstract#isPreviewMapReady() - not operable ");
            return false;
        }
        if (this.mapForPreview.getActiveContextIndex() != 30) {
            this.logger.log(-2137614336, "PreviewMapHandlerAbstract#isPreviewMapReady() - active context: %1 ", (long)this.mapForPreview.getActiveContextIndex());
            return false;
        }
        return true;
    }

    public void setFlagsInMap(NavLocationWgs84[] navLocationWgs84Array, int[] nArray, int n) {
        if (navLocationWgs84Array.length < n) {
            this.logger.log(10000, "PreviewMapHandlerAbstract#setFlagsInMap() - wrong size");
            return;
        }
        this.logger.log(1078071040, "PreviewMapHandlerAbstract#setFlagsInMap() - number of positions: %1, number of styleTypes: %2", navLocationWgs84Array == null ? 0L : (long)n, nArray == null ? 0L : (long)nArray.length);
        int n2 = 28;
        int n3 = navLocationWgs84Array == null ? 0 : n;
        int n4 = nArray == null ? 0 : nArray.length;
        MapPin[] mapPinArray = new MapPin[n3];
        for (int i2 = 0; i2 < n3; ++i2) {
            if (navLocationWgs84Array[i2] != null) {
                int n5;
                if (n4 <= i2) {
                    n5 = n2;
                } else {
                    n5 = nArray[i2];
                    n2 = nArray[i2];
                }
                mapPinArray[i2] = new MapPin(navLocationWgs84Array[i2].getLongitude(), navLocationWgs84Array[i2].getLatitude(), n5, -1);
                continue;
            }
            this.logger.log(10000, "PreviewMapHandlerAbstract#setFlagsInMap() - invalid flagPosition at index %1", (long)i2);
        }
        this.mapForPreview.getMapFlagHandler().setTemporaryPins(mapPinArray);
    }

    protected void mapFreeze() {
        this.logger.log(-2137614336, "PreviewMapHandlerAbstract#mapFreeze() - freezeAllowed=%1", this.freezeAllowed);
        if (this.freezeAllowed) {
            this.unfreezeRequired = true;
            this.mapForPreview.getActiveContext().freezeMap();
        }
    }

    protected void mapUnfreeze() {
        this.logger.log(-2137614336, "PreviewMapHandlerAbstract#mapUnfreeze() - freezeAllowed=%1 unfreezeRequired=%2", this.freezeAllowed, this.unfreezeRequired);
        if (this.freezeAllowed || this.unfreezeRequired) {
            this.unfreezeRequired = false;
            this.mapForPreview.getMVRequest().viewFreeze(false);
        }
    }

    protected void mapUnfreezeLevel1() {
        this.logger.log(-2137614336, "PreviewMapHandlerAbstract#mapUnfreezeLevel1() - freezeAllowed=%1 unfreezeRequired=%2", this.freezeAllowed, this.unfreezeRequired);
        if (this.freezeAllowed || this.unfreezeRequired) {
            this.unfreezeRequired = false;
            this.mapForPreview.getActiveContext().unfreezeMapLevel1();
        }
    }

    protected abstract int getPreviewMapLayoutIdCurrent() {
    }

    protected abstract PreviewMapStateAbstract getPreviewMapStateCurrent() {
    }

    public abstract void setPreviewMapModeAndFrameRate(int n) {
    }

    public PreviewMapEventVisibilities getPreviewMapEventVisibilities() {
        return this.previewMapEventVisibilities;
    }

    @Override
    public void resetEventVisibilities(boolean bl, boolean bl2) {
        this.getPreviewMapEventVisibilities().resetEventVisibilities(bl, bl2);
    }

    @Override
    public void previewMapScreenEntering(int n, int n2, int n3, int n4) {
        this.logger.log(-2137614336, "PreviewMapHandlerAbstract#previewMapScreenEntering() width=%1, height=%2, offsetX=%3, offsetY=%4", (Object)new Integer(n), (Object)new Integer(n2), (Object)new Integer(n3), (Object)new Integer(n4));
        this.setPreviewMapMode(2);
        this.previewMapScreenEntering(n, n2, n3, n4, false);
    }

    @Override
    public void previewMapScreenEntering(int n, int n2) {
        this.logger.log(-2137614336, "PreviewMapHandlerAbstract#previewMapScreenEntering() previewMapClientId=%1 previewMapScreenLayoutId=%2", (long)n, (long)n2);
        this.setPreviewMapMode(2);
    }

    @Override
    public void previewMapScreenApplyItemBeforeShown(int n, int n2) {
        if (this.previewMapMode == 1) {
            this.logger.log(-2137614336, "PreviewMapHandlerAbstract#previewMapScreenApplyItemBeforeShown() previewMapClientId=%1 previewMapScreenLayoutId=%2 previewMapMode=%3", (long)n, (long)n2, (long)this.previewMapMode);
            this.setPreviewMapMode(4);
        } else {
            this.logger.log(-2137614336, "PreviewMapHandlerAbstract#previewMapScreenApplyItemBeforeShown() previewMapClientId=%1 previewMapScreenLayoutId=%2 previewMapMode=%3 apply not possible", (long)n, (long)n2, (long)this.previewMapMode);
        }
    }

    @Override
    public void previewMapScreenExited() {
        this.logger.log(-2137614336, "PreviewMapHandlerAbstract#previewMapScreenExited()");
        if (this.previewMapMode == 2) {
            this.setPreviewMapMode(1);
        }
    }

    @Override
    public void previewMapFullScreenShowItemSelectedWithToolTip(int n) {
        this.logger.log(-2137614336, "PreviewMapHandlerAbstract#previewMapFullScreenShowItemSelectedWithToolTip() previewMapClientId=%1", (long)n);
        this.setPreviewMapMode(3);
    }

    @Override
    public void previewMapFullScreenShowItemInMapWithToolTip() {
        this.logger.log(-2137614336, "PreviewMapHandlerAbstract#previewMapFullScreenShowItemInMapWithToolTip()");
        this.setPreviewMapMode(3);
    }

    @Override
    public void previewMapFullScreenHidden() {
        this.logger.log(-2137614336, "PreviewMapHandlerAbstract#previewMapFullScreenHidden() previewMapMode=%1", (long)this.previewMapMode);
        if (this.previewMapMode == 3) {
            this.setPreviewMapMode(1);
        }
    }

    @Override
    public void previewMapScreenLayoutRegister(int n, int n2, int n3, int n4, int n5) {
        int n6;
        GuiPreviewMapLayout guiPreviewMapLayout;
        GuiPreviewMapLayout guiPreviewMapLayout2;
        this.logger.log(-2137614336, new StringBuffer().append("PreviewMapHandlerAbstract#previewMapScreenLayoutRegister() previewMapScreenLayoutId=%1 width=%2 height=%3 offsetX=%4 offsetY=").append(n5).toString(), (Object)new Integer(n), (Object)new Integer(n2), (Object)new Integer(n3), (Object)new Integer(n4));
        if (this.mapPreviewMapLayouts == null) {
            this.logger.log(10000, "PreviewMapHandlerAbstract#previewMapScreenLayoutRegister() cleanUp was called");
            this.mapPreviewMapLayouts = new HashMap();
        }
        if (!((guiPreviewMapLayout2 = (GuiPreviewMapLayout)this.mapPreviewMapLayouts.put(new Integer(n), guiPreviewMapLayout = new GuiPreviewMapLayout(n2, n3, n4, n5))) != null && guiPreviewMapLayout2.equals(guiPreviewMapLayout) || (n6 = this.getPreviewMapLayoutIdCurrent()) == -1 || n6 != n)) {
            this.refreshPreviewMapLayoutZoomArea();
        }
    }

    @Override
    public void previewMapScreenErrorUpdateByClientWithDelay() {
        this.logger.log(10000, "PreviewMapHandlerAbstract#previewMapScreenErrorUpdateByClientWithDelay() previewMapClientIdLast=%1", (long)this.getPreviewMapClientIdLast());
    }

    protected void refreshMapContext() {
        this.isRefreshMapContextNecessary = false;
    }

    protected void refreshPreviewMapLayoutZoomArea() {
        this.logger.log(-2137614336, "PreviewMapHandlerAbstract#refreshPreviewMapLayoutZoomArea() layoutChanged=%1 previewMapMode=%2", this.isRefreshLayoutNecessary, (long)this.previewMapMode);
        if (this.previewMapMode == 4 || this.previewMapMode == 2) {
            this.isRefreshLayoutNecessary = false;
            GuiPreviewMapLayout guiPreviewMapLayout = this.getGuiPreviewMapLayoutCurrent();
            if (guiPreviewMapLayout != null) {
                this.getMapForPreview().getMapDataContainer().sPreviewMapWidth = guiPreviewMapLayout.width;
                this.getMapForPreview().getMapDataContainer().sPreviewMapHeight = guiPreviewMapLayout.height;
                this.getMapForPreview().getMapDataContainer().sPreviewMapOffsetX = guiPreviewMapLayout.xOffset;
                this.getMapForPreview().getMapDataContainer().sPreviewMapOffsetY = guiPreviewMapLayout.yOffset;
                this.getMapForPreview().getMVRequest().setZoomArea(guiPreviewMapLayout.getVisibleArea());
                this.refreshHotPointAndCarPosition();
            } else {
                this.logger.log(10000, "PreviewMapHandlerAbstract#refreshPreviewMapLayoutZoomArea() no layout set");
            }
        }
    }

    private void refreshHotPointAndCarPosition() {
        GuiPreviewMapLayout guiPreviewMapLayout = this.getGuiPreviewMapLayoutCurrent();
        if (guiPreviewMapLayout != null) {
            int n = guiPreviewMapLayout.width >> 1;
            int n2 = guiPreviewMapLayout.height >> 1;
            Point point = new Point(n + guiPreviewMapLayout.xOffset, n2 + guiPreviewMapLayout.yOffset);
            this.getMapForPreview().getMVRequest().setHotPoint(point);
            this.getMapForPreview().getMVRequest().setCarPosition(point);
        } else {
            this.logger.log(10000, "PreviewMapHandlerAbstract#refreshHotPointAndCarPosition() no layout");
        }
    }

    abstract GuiPreviewMapLayout getGuiPreviewMapLayoutCurrent() {
    }

    @Override
    public Rect getGuiPreviewMapLayoutVisibleAreaCurrent() {
        GuiPreviewMapLayout guiPreviewMapLayout = this.getGuiPreviewMapLayoutCurrent();
        if (guiPreviewMapLayout != null) {
            return guiPreviewMapLayout.getVisibleArea();
        }
        return null;
    }

    public int getPreviewMapMode() {
        return this.previewMapMode;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void setPreviewMapMode(int n) {
        this.logger.log(-2137614336, "PreviewMapHandlerAbstract#setPreviewMapMode() previewMapModeNew=%1 current=%2", (long)n, (long)this.previewMapMode);
        if (this.previewMapMode != n) {
            int n2 = this.previewMapMode;
            this.previewMapMode = n;
            if (this.previewMapMode != 1) {
                if (this.isRefreshAllowed()) {
                    this.refreshMapContext();
                    this.refreshPreviewMapLayoutZoomArea();
                } else {
                    this.isRefreshMapContextNecessary = true;
                    this.isRefreshLayoutNecessary = true;
                }
            } else {
                Object object = this.getMapForPreview().getMutexSwitchToContext();
                synchronized (object) {
                    if (this.isPreviewMapReady()) {
                        try {
                            if (MapUtils.isPreviewMapContext(this.getMapForPreview().getActiveContextIndex())) {
                                this.getMapForPreview().switchToHiddenContext();
                            }
                        }
                        catch (Exception exception) {
                            this.logger.log(1078071040, "PreviewMapHandlerAbstract#setPreviewMapMode: Exception %1", (Throwable)exception);
                        }
                    } else {
                        this.logger.log(-2137614336, "PreviewMapHandlerAbstract#setPreviewMapMode() - preview map not ready!");
                    }
                }
                if (n2 == 2) {
                    this.releasePreviewMapStateForApplyToScreenDetail();
                }
                if (n2 == 3) {
                    this.releasePreviewMapStateForApplyToFullScreenMap();
                }
            }
        }
    }

    protected void releasePreviewMapStateForApplyToScreenDetail() {
        PreviewMapStateAbstract previewMapStateAbstract = this.previewMapStateToReleaseForApplyToScreenDetail;
        if (previewMapStateAbstract != null) {
            this.previewMapStateToReleaseForApplyToScreenDetail = null;
            previewMapStateAbstract.releaseApplyToScreenDetail();
        }
    }

    protected void releasePreviewMapStateForApplyToFullScreenMap() {
        PreviewMapStateAbstract previewMapStateAbstract = this.previewMapStateToReleaseForApplyToFullScreenMap;
        if (previewMapStateAbstract != null) {
            this.previewMapStateToReleaseForApplyToFullScreenMap = null;
            previewMapStateAbstract.releaseApplyToScreenFullMap();
        }
    }

    @Override
    public void setPreviewMapCallbackHandler(PreviewMapCallback previewMapCallback) {
        this.logger.log(1078071040, "PreviewMapHandler#setPreviewMapCallbackHandler()");
        if (!this.isPreviewMapOperable()) {
            this.logger.log(1078071040, "PreviewMapHandler#setPreviewMapCallbackHandler() - preview map not operable!");
            return;
        }
        this.mapForPreview.getGuiInterface().showPreviewMap(false);
        if (previewMapCallback != null) {
            this.previewMapListHandler = previewMapCallback;
        } else {
            this.logger.log(10000, "PreviewMapHandler#setPreviewMapCallbackHandler() - list handler is null!");
            this.previewMapListHandler = new NullPreviewMapCallback(this.logger);
        }
    }

    @Override
    public void hidePreviewMap() {
        this.logger.log(1078071040, "PreviewMapHandlerAbstract#hidePreviewMap()");
        this.mapForPreview.getGuiInterface().showPreviewMap(false);
    }

    @Override
    public void setPreviewMapPositionRefreshAllowed(boolean bl) {
        this.mapPositionRefreshAllowed = bl;
    }

    public boolean isPreviewMapPositionRefreshAllowed() {
        return this.mapPositionRefreshAllowed;
    }

    protected void setRefreshAllowed(boolean bl) {
        if (this.refreshAllowed != bl) {
            this.refreshAllowed = bl;
            if (this.refreshAllowed) {
                if (this.isRefreshLayoutNecessary) {
                    this.refreshPreviewMapLayoutZoomArea();
                }
                if (this.isRefreshMapContextNecessary) {
                    this.refreshMapContext();
                }
            }
        }
    }

    protected boolean isRefreshAllowed() {
        return this.refreshAllowed;
    }

    @Override
    public int getMapContextCorrected(int n) {
        return n;
    }

    @Override
    public void cleanUp() {
        this.mapPreviewMapLayouts = null;
    }

    @Override
    public int getPreviewMapModelHkBackBehavior() {
        return 0;
    }

    @Override
    public void setPreviewMapModelHkBackBehavior(int n) {
    }

    @Override
    public boolean isFullscreenPreviewMapVisible() {
        return this.previewMapMode == 2 || this.previewMapMode == 3;
    }

    @Override
    public boolean isPreviewMapItemArea() {
        PreviewMapStateAbstract previewMapStateAbstract = this.getPreviewMapStateCurrent();
        if (!PreviewMapUtils.isPreviewMapStateValid(previewMapStateAbstract)) {
            return false;
        }
        return previewMapStateAbstract.isPreviewMapItemArea();
    }

    public ChoiceModelApp getPreviewMapModelDetailView() {
        return null;
    }

    public ButtonModelApp getPreviewMapModelDetailButton() {
        return null;
    }

    public LabelModelApp getPreviewMapModelDetailUrlLabel() {
        return null;
    }
}

