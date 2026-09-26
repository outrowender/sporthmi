/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.handler.preview;

import de.audi.atip.interapp.navigation.previewmap.gui.GuiModelAccessForPreviewMapDetailScreen;
import de.audi.atip.interapp.navigation.previewmap.gui.GuiTooltipInformationContainer;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.map.handler.preview.PreviewMapHandlerAbstract;
import de.audi.tghu.navi.app.map.handler.preview.PreviewMapUtils;
import de.audi.tghu.navi.app.map.handler.preview.gui.GuiPreviewMapLayout;
import de.audi.tghu.navi.app.map.handler.preview.gui.GuiTimerWaitingForApply;
import de.audi.tghu.navi.app.map.handler.preview.states.PreviewMapStateAbstract;
import de.audi.tghu.navi.app.map.utils.MapUtils;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Util;
import java.util.HashMap;
import java.util.Map;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.global.NavRectangle;
import org.dsi.ifc.global.NavSegmentID;
import org.dsi.ifc.tmc.TmcMessage;

public abstract class PreviewMapHandlerAbstractMapStatesMultiple
extends PreviewMapHandlerAbstract {
    protected Map mapPreviewMapClientIdToPreviewMapLayoutId = new HashMap();
    protected Map hashMapPreviewMapStates = new HashMap();
    protected volatile int previewMapClientIdActive = -1;
    protected volatile int previewMapClientIdLast = -1;
    protected GuiTimerWaitingForApply guiTimerWaitingForApply;

    public PreviewMapHandlerAbstractMapStatesMultiple(NavigationEnv navigationEnv, AbstractMap abstractMap) {
        super(navigationEnv, abstractMap);
        this.guiTimerWaitingForApply = new GuiTimerWaitingForApply(navigationEnv, this.logger);
    }

    @Override
    public void setPreviewMapWaitSyncChoiceModelId(int n) {
        GuiTimerWaitingForApply guiTimerWaitingForApply = this.guiTimerWaitingForApply;
        if (guiTimerWaitingForApply != null) {
            guiTimerWaitingForApply.setPreviewMapWaitSyncModelId(n);
        }
    }

    protected PreviewMapStateAbstract getPreviewMapState(int n) {
        if (n == -1) {
            this.logger.log(-1601830656, "PreviewMapHandlerAbstractMapStatesMultiple#getPreviewMapState() no valid client id");
            return null;
        }
        if (this.hashMapPreviewMapStates == null) {
            this.logger.log(10000, "PreviewMapHandlerAbstractMapStatesMultiple#getPreviewMapState() no hash map");
            return null;
        }
        PreviewMapStateAbstract previewMapStateAbstract = (PreviewMapStateAbstract)this.hashMapPreviewMapStates.get(new Integer(n));
        if (previewMapStateAbstract == null) {
            this.logger.log(-2137614336, "PreviewMapHandlerAbstractMapStatesMultiple#getPreviewMapState() clientId=%1 no previewMapState available", (long)n);
        }
        return previewMapStateAbstract;
    }

    @Override
    protected PreviewMapStateAbstract getPreviewMapStateCurrent() {
        int n = this.getPreviewMapClientIdActive();
        PreviewMapStateAbstract previewMapStateAbstract = this.getPreviewMapState(n);
        if (previewMapStateAbstract != null) {
            this.logger.log(-2137614336, "PreviewMapHandlerAbstractMapStatesMultiple#getPreviewMapStateCurrent() clientId=%1 %2", (Object)new Integer(n), (Object)previewMapStateAbstract);
        } else {
            this.logger.log(-2137614336, "PreviewMapHandlerAbstractMapStatesMultiple#getPreviewMapStateCurrent() clientId=%1 null", (Object)new Integer(n));
        }
        return previewMapStateAbstract;
    }

    protected void setPreviewMapState(int n, PreviewMapStateAbstract previewMapStateAbstract) {
        if (previewMapStateAbstract != null) {
            Object object;
            this.setGuiWaitingForApply(true);
            previewMapStateAbstract.setPreviewMapClientId(n);
            if (this.hashMapPreviewMapStates == null) {
                this.logger.log(10000, "PreviewMapHandlerAbstractMapStatesMultiple#setPreviewMapState() no hash map");
                this.hashMapPreviewMapStates = new HashMap();
            }
            if ((object = this.hashMapPreviewMapStates.put(new Integer(n), previewMapStateAbstract)) != null) {
                this.logger.log(-2137614336, "PreviewMapHandlerAbstractMapStatesMultiple#setPreviewMapState() clientId=%1 new=%2 old=%3", (Object)new Integer(n), (Object)previewMapStateAbstract, object);
            } else {
                this.logger.log(-2137614336, "PreviewMapHandlerAbstractMapStatesMultiple#setPreviewMapState() clientId=%1 new=%2 no-old", (Object)new Integer(n), (Object)previewMapStateAbstract);
            }
            if (n == this.getPreviewMapClientIdActive()) {
                this.refreshMapPreviewDetailIfActive(previewMapStateAbstract);
                this.refreshMapFullScreenIfActive(previewMapStateAbstract);
                if (this.previewMapMode == 4) {
                    this.logger.log(-2137614336, "PreviewMapHandlerAbstractMapStatesMultiple#setPreviewMapState() apply before shown");
                    this.refreshMapContext();
                }
            }
        } else {
            Object object = this.hashMapPreviewMapStates.remove(new Integer(n));
            if (object != null) {
                this.logger.log(-2137614336, "PreviewMapHandlerAbstractMapStatesMultiple#setPreviewMapState() clientId=%1 removed=%2", (Object)new Integer(n), object);
            } else {
                this.logger.log(-2137614336, "PreviewMapHandlerAbstractMapStatesMultiple#setPreviewMapState() clientId=%1 removed", (Object)new Integer(n));
            }
            if (this.previewMapMode == 3) {
                this.setPreviewMapMode(1);
            }
        }
    }

    private void refreshMapFullScreenIfActive(PreviewMapStateAbstract previewMapStateAbstract) {
        if (this.previewMapMode == 3) {
            this.logger.log(-2137614336, "PreviewMapHandlerAbstractMapStatesMultiple#refreshMapFullScreenIfActive() refreshMapFullScreen");
            this.refreshMapFullScreen(previewMapStateAbstract);
        }
    }

    @Override
    public void refreshLastRequestedState(int n) {
        PreviewMapStateAbstract previewMapStateAbstract = this.getPreviewMapStateCurrent();
        if (PreviewMapUtils.isPreviewMapStateValid(previewMapStateAbstract) && (n != 2 || previewMapStateAbstract.isRefreshRequiredOnUpdateRgActive())) {
            this.logger.log(-2137614336, "PreviewMapHandlerAbstractMapStatesMultiple#refreshMapPreviewDetailIfActive");
            this.refreshMapPreviewDetailIfActive(previewMapStateAbstract);
        }
    }

    private void refreshMapPreviewDetailIfActive(PreviewMapStateAbstract previewMapStateAbstract) {
        if (this.previewMapMode == 2) {
            this.logger.log(-2137614336, "PreviewMapHandlerAbstractMapStatesMultiple#refreshMapPreviewDetailIfActive() refreshMapPreview");
            this.refreshMapPreviewDetail(previewMapStateAbstract);
        }
    }

    @Override
    public void setPreviewMapNone(int n) {
        this.logger.log(-2137614336, "PreviewMapHandlerAbstractMapStatesMultiple#setPreviewMapNone() clientId=%1", (long)n);
        this.setPreviewMapState(n, null);
    }

    protected boolean setPreviewMapClientIdActive(int n) {
        if (n != this.previewMapClientIdActive) {
            int n2 = this.previewMapClientIdActive;
            this.previewMapClientIdActive = n;
            if (n != -1) {
                this.previewMapClientIdLast = n;
            }
            this.logger.log(-2137614336, "PreviewMapHandlerAbstractMapStatesMultiple#setPreviewMapClientIdActive() previewMapClientId=%1 old=%2 last=%3", (long)n, (long)n2, (long)this.previewMapClientIdLast);
            if (n != n2 && !PreviewMapUtils.isPreviewMapStateValid(this.getPreviewMapState(n))) {
                this.releasePreviewMapStateForApplyToScreenDetail();
                this.releasePreviewMapStateForApplyToFullScreenMap();
            }
            if (this.isRefreshAllowed()) {
                this.refreshMapContext();
            } else {
                this.isRefreshMapContextNecessary = true;
            }
            return true;
        }
        return false;
    }

    protected int getPreviewMapClientIdActive() {
        return this.previewMapClientIdActive;
    }

    @Override
    protected int getPreviewMapLayoutIdCurrent() {
        int n = this.getPreviewMapClientIdActive();
        if (n == -1) {
            return -1;
        }
        Integer n2 = (Integer)this.mapPreviewMapClientIdToPreviewMapLayoutId.get(new Integer(n));
        if (n2 != null) {
            return n2;
        }
        return -1;
    }

    @Override
    public int getPreviewMapClientIdLast() {
        return this.previewMapClientIdLast;
    }

    @Override
    protected void refreshMapContext() {
        super.refreshMapContext();
        int n = 0;
        if (this.previewMapMode == 4) {
            PreviewMapStateAbstract previewMapStateAbstract = this.getPreviewMapStateCurrent();
            if (PreviewMapUtils.isPreviewMapStateValid(previewMapStateAbstract)) {
                this.refreshMapPreviewDetail(previewMapStateAbstract);
            } else {
                this.logger.log(-2137614336, "PreviewMapHandlerAbstractMapStatesMultiple#refreshMapContext() - no entry");
            }
        } else {
            if (this.previewMapMode == 3) {
                n = PreviewMapUtils.getMapContextCrosshairByClientId(this.previewMapClientIdActive);
            } else if (this.previewMapMode == 2) {
                n = 30;
            }
            int n2 = this.getMapForPreview().getActiveContextIndex();
            if (n != 0 && (n2 != n || n2 == 12) && this.previewMapClientIdActive != -1) {
                if (n == 13) {
                    PreviewMapStateAbstract previewMapStateAbstract = this.getPreviewMapStateCurrent();
                    NavLocation navLocation = null;
                    if (previewMapStateAbstract != null) {
                        navLocation = previewMapStateAbstract.getNavLocationForEnterInMap();
                    }
                    this.getMapForFullScreen().getMapInterface().destOptShowInMapPAG(navLocation, false);
                } else {
                    this.getMapForPreview().switchToContext(3);
                    this.logger.log(-2137614336, "PreviewMapHandlerAbstractMapStatesMultiple#refreshMapContext() mapContextNew=%1", (long)n);
                    this.getMapForPreview().switchToContext(n);
                }
            } else {
                this.logger.log(-2137614336, "PreviewMapHandlerAbstractMapStatesMultiple#refreshMapContext() not possible - mapContextNew=%1 activeCid=%2 previewMapClientIdActive=%3", (long)n, (long)this.getMapForPreview().getActiveContextIndex(), (long)this.previewMapClientIdActive);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void previewMapScreenEntering(int n, int n2) {
        this.setRefreshAllowed(false);
        try {
            boolean bl = this.setPreviewMapClientIdActive(n);
            super.previewMapScreenEntering(n, n2);
            this.previewMapScreenSetLayout(n, n2, bl);
        }
        catch (Exception exception) {
            this.logger.log(-2137614336, "PreviewMapHandlerAbstractMapStatesMultiple#previewMapScreenEntering() exception=%1", (Throwable)exception);
        }
        finally {
            this.setRefreshAllowed(true);
        }
        if (this.isRefreshLayoutNecessary) {
            this.refreshPreviewMapLayoutZoomArea();
        }
    }

    private void previewMapScreenSetLayout(int n, int n2, boolean bl) {
        Integer n3 = (Integer)this.mapPreviewMapClientIdToPreviewMapLayoutId.put(new Integer(n), new Integer(n2));
        this.isRefreshLayoutNecessary = n3 == null || n3 != n2;
        this.logger.log(-2137614336, "PreviewMapHandlerAbstractMapStatesMultiple#previewMapScreenEntering() clientChanged=%1 layoutChanged=%2", (Object)new Boolean(bl), (Object)new Boolean(this.isRefreshLayoutNecessary));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void previewMapScreenApplyItemBeforeShown(int n, int n2) {
        if (this.previewMapMode == 1 || this.previewMapMode == 4) {
            this.setRefreshAllowed(false);
            try {
                boolean bl = this.setPreviewMapClientIdActive(n);
                super.previewMapScreenApplyItemBeforeShown(n, n2);
                this.previewMapScreenSetLayout(n, n2, bl);
            }
            catch (Exception exception) {
                this.logger.log(-2137614336, "PreviewMapHandlerAbstractMapStatesMultiple#previewMapScreenEntering() exception=%1", (Throwable)exception);
            }
            finally {
                this.setRefreshAllowed(true);
            }
            if (this.isRefreshLayoutNecessary) {
                this.refreshPreviewMapLayoutZoomArea();
            }
        } else {
            this.logger.log(-2137614336, "PreviewMapHandlerAbstract#previewMapScreenApplyItemBeforeShown() previewMapClientId=%1 previewMapScreenLayoutId=%2 previewMapMode=%3 apply not possible", (long)n, (long)n2, (long)this.previewMapMode);
        }
    }

    @Override
    public void previewMapScreenExited() {
        super.previewMapScreenExited();
        if (this.previewMapMode == 1) {
            this.setPreviewMapClientIdActive(-1);
        }
    }

    @Override
    public void previewMapFullScreenShowItemSelectedWithToolTipLast() {
        this.logger.log(-2137614336, "PreviewMapHandlerAbstractMapStatesMultiple#previewMapFullScreenShowItemSelectedWithToolTipLast() previewMapClientIdLast=%1", (long)this.previewMapClientIdLast);
        if (this.previewMapClientIdLast != -1) {
            this.previewMapFullScreenShowItemSelectedWithToolTip(this.previewMapClientIdLast);
        } else {
            this.logger.log(10000, "PreviewMapHandlerAbstractMapStatesMultiple#previewMapFullScreenShowItemSelectedWithToolTipLast() no last clientId");
        }
    }

    @Override
    public void previewMapFullScreenShowItemSelectedWithToolTip(int n) {
        super.previewMapFullScreenShowItemSelectedWithToolTip(n);
        boolean bl = this.setPreviewMapClientIdActive(n);
        this.logger.log(-2137614336, "PreviewMapHandlerAbstractMapStatesMultiple#previewMapFullScreenShowItemSelectedWithToolTip() clientChanged=%1", bl);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void previewMapFullScreenShowItemInMapWithToolTip() {
        this.setRefreshAllowed(false);
        try {
            super.previewMapFullScreenShowItemInMapWithToolTip();
            boolean bl = this.setPreviewMapClientIdActive(0);
            this.logger.log(-2137614336, "PreviewMapHandlerAbstractMapStatesMultiple#previewMapFullScreenShowItemInMapWithToolTip() clientChanged=%1", bl);
        }
        catch (Exception exception) {
            this.logger.log(-2137614336, "PreviewMapHandlerAbstractMapStatesMultiple#previewMapFullScreenShowItemInMapWithToolTip() exception=%1", (Throwable)exception);
        }
        finally {
            this.setRefreshAllowed(true);
        }
    }

    @Override
    public void previewMapFullScreenShowItemInMapWithToolTipWithoutCenteringMapPosition() {
        this.logger.log(-2137614336, "PreviewMapHandlerAbstractMapStatesMultiple#previewMapFullScreenShowItemInMapWithToolTipWithoutCenteringMapPosition()");
        this.setPreviewMapPositionRefreshAllowed(false);
        this.previewMapFullScreenShowItemInMapWithToolTip();
        this.setPreviewMapPositionRefreshAllowed(true);
    }

    @Override
    public void callbackByMapContextOnEnteringMapPreview() {
        PreviewMapStateAbstract previewMapStateAbstract = this.getPreviewMapStateCurrent();
        if (PreviewMapUtils.isPreviewMapStateValid(previewMapStateAbstract)) {
            this.logger.log(-2137614336, "PreviewMapHandlerAbstractMapStatesMultiple#callbackByMapContextOnEnteringMapPreview() - apply backupState");
            this.freezeAllowed = false;
            this.refreshMapPreviewDetail(previewMapStateAbstract);
            this.freezeAllowed = true;
        } else {
            this.logger.log(-2137614336, "PreviewMapHandlerAbstractMapStatesMultiple#callbackByMapContextOnEnteringMapPreview() - no entry");
        }
    }

    @Override
    public void callbackByMapContextOnEnteringMapFullscreen() {
        PreviewMapStateAbstract previewMapStateAbstract = this.getPreviewMapStateCurrent();
        if (PreviewMapUtils.isPreviewMapStateValid(previewMapStateAbstract)) {
            this.logger.log(-2137614336, "PreviewMapHandlerAbstractMapStatesMultiple#callbackByMapContextOnEnteringMapFullscreen() - enter");
            this.freezeAllowed = false;
            this.refreshMapFullScreen(previewMapStateAbstract);
            this.freezeAllowed = true;
        } else {
            this.logger.log(-2137614336, "PreviewMapHandlerAbstractMapStatesMultiple#callbackByMapContextOnEnteringMapFullscreen() - no entry");
        }
    }

    public void refreshMapPreviewDetail(PreviewMapStateAbstract previewMapStateAbstract) {
        if (PreviewMapUtils.isPreviewMapStateValid(previewMapStateAbstract)) {
            this.mapFreeze();
            this.refreshPreviewMapLayoutZoomArea();
            try {
                if (this.previewMapStateToReleaseForApplyToScreenDetail != null && previewMapStateAbstract.equals(this.previewMapStateToReleaseForApplyToScreenDetail)) {
                    this.previewMapStateToReleaseForApplyToScreenDetail = null;
                }
                if (this.previewMapStateToReleaseForApplyToFullScreenMap != null && previewMapStateAbstract.equals(this.previewMapStateToReleaseForApplyToFullScreenMap)) {
                    this.previewMapStateToReleaseForApplyToFullScreenMap = null;
                }
                this.releasePreviewMapStateForApplyToFullScreenMap();
                this.releasePreviewMapStateForApplyToScreenDetail();
                previewMapStateAbstract.applyToScreenDetail();
                this.previewMapStateToReleaseForApplyToScreenDetail = previewMapStateAbstract;
                this.setGuiWaitingForApply(false);
            }
            catch (Exception exception) {
                this.logger.log(10000, "PreviewMapHandlerAbstractMapStatesMultiple#refreshMapPreviewDetail() - failed by exception %1", (Throwable)exception);
            }
            this.mapUnfreeze();
            this.getMapForPreview().getGuiInterface().showPreviewMap(true);
        } else {
            this.logger.log(-2137614336, "PreviewMapHandlerAbstractMapStatesMultiple#refreshMapPreviewDetail() - not ready to apply");
        }
    }

    public void refreshMapFullScreen(PreviewMapStateAbstract previewMapStateAbstract) {
        if (PreviewMapUtils.isPreviewMapStateValid(previewMapStateAbstract)) {
            this.logger.log(-2137614336, "PreviewMapHandlerAbstractMapStatesMultiple#refreshMapFullScreen() previewMapState=%1", (Object)previewMapStateAbstract);
            this.mapFreeze();
            try {
                this.releasePreviewMapStatesOld(previewMapStateAbstract);
                previewMapStateAbstract.applyToScreenFullMap();
                this.previewMapStateToReleaseForApplyToFullScreenMap = previewMapStateAbstract;
                previewMapStateAbstract.applyToScreenDetailModels();
                this.setGuiWaitingForApply(false);
            }
            catch (Exception exception) {
                this.logger.log(10000, "PreviewMapHandlerAbstractMapStatesMultiple#refreshMapFullScreen() - failed by exception %1", (Throwable)exception);
            }
            this.mapUnfreeze();
        } else {
            this.logger.log(-2137614336, "PreviewMapHandlerAbstractMapStatesMultiple#refreshMapFullScreen() - not ready to apply");
        }
    }

    private void releasePreviewMapStatesOld(PreviewMapStateAbstract previewMapStateAbstract) {
        if (PreviewMapUtils.isPreviewMapStateValid(previewMapStateAbstract)) {
            if (this.previewMapStateToReleaseForApplyToScreenDetail != null && previewMapStateAbstract.equals(this.previewMapStateToReleaseForApplyToScreenDetail)) {
                this.previewMapStateToReleaseForApplyToScreenDetail = null;
            }
            if (this.previewMapStateToReleaseForApplyToFullScreenMap != null && previewMapStateAbstract.equals(this.previewMapStateToReleaseForApplyToFullScreenMap)) {
                this.previewMapStateToReleaseForApplyToFullScreenMap = null;
            }
        }
        this.releasePreviewMapStateForApplyToScreenDetail();
        this.releasePreviewMapStateForApplyToFullScreenMap();
    }

    @Override
    public void previewMapScreenEntering(int n, int n2, int n3, int n4, boolean bl) {
        this.logger.log(10000, "PreviewMapHandlerAbstractMapStatesMultiple#previewMapScreenEntering() not used in PAG");
    }

    @Override
    public void setPreviewAreaAroundCCP(int n) {
        this.logger.log(-2137614336, "PreviewMapHandlerAbstractMapStatesMultiple#setPreviewAreaAroundCCP() previewMapClientId=%1", (Object)new Integer(n));
        this.setPreviewMapState(n, this.getFactoryPreviewMapState().createPreviewMapAroundCCP());
    }

    @Override
    public void setPreviewLocation(NavLocation navLocation, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        this.logger.log(-2137614336, "PreviewMapHandlerAbstractMapStatesMultiple#setPreviewLocation() previewMapClientId=%1 navLocation=%2", (Object)new Integer(n), (Object)navLocation);
        this.setPreviewMapState(n, this.getFactoryPreviewMapState().createPreviewMapNavLocation(navLocation, guiModelAccessForPreviewMapDetailScreen, guiTooltipInformationContainer));
    }

    @Override
    public void setPreviewLocationSds(NavLocation navLocation, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        this.logger.log(-2137614336, "PreviewMapHandlerAbstractMapStatesMultiple#setPreviewLocationSds() previewMapClientId=%1 navLocation=%2", (Object)new Integer(n), (Object)navLocation);
        this.setPreviewMapState(n, this.getFactoryPreviewMapState().createPreviewMapNavLocation(navLocation, guiModelAccessForPreviewMapDetailScreen, guiTooltipInformationContainer));
    }

    @Override
    public void setPreviewLocationDistant(NavLocation navLocation, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        this.logger.log(-2137614336, "PreviewMapHandlerAbstractMapStatesMultiple#setPreviewLocationDistant() previewMapClientId=%1 navLocation=%2", (Object)new Integer(n), (Object)navLocation);
        this.setPreviewMapState(n, this.getFactoryPreviewMapState().createPreviewMapNavLocation(navLocation, guiModelAccessForPreviewMapDetailScreen, guiTooltipInformationContainer));
    }

    @Override
    public void setPreviewLocationAroundReferencePoint(NavLocation navLocation, NavLocationWgs84 navLocationWgs84, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        this.logger.log(-2137614336, "PreviewMapHandlerAbstractMapStatesMultiple#setPreviewLocationAroundReferencePoint() previewMapClientId=%1 navLocation=%2 referencePoint=%3", (Object)new Integer(n), (Object)navLocation, (Object)navLocationWgs84);
        this.setPreviewMapState(n, this.getFactoryPreviewMapState().createPreviewMapNavLocation(navLocation, guiModelAccessForPreviewMapDetailScreen, guiTooltipInformationContainer));
    }

    @Override
    public void setPreviewLocationAroundCCP(NavLocation navLocation, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        this.logger.log(-2137614336, "PreviewMapHandlerAbstractMapStatesMultiple#setPreviewLocationAroundCCP() previewMapClientId=%1 navLocation=%2", (Object)new Integer(n), (Object)navLocation);
        this.setPreviewMapState(n, this.getFactoryPreviewMapState().createPreviewMapNavLocation(navLocation, guiModelAccessForPreviewMapDetailScreen, guiTooltipInformationContainer));
    }

    @Override
    public void setPreviewLocationAroundDestination(NavLocation navLocation, NavLocationWgs84 navLocationWgs84, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        this.logger.log(-2137614336, "PreviewMapHandlerAbstractMapStatesMultiple#setPreviewLocationAroundDestination() previewMapClientId=%1 navLocation=%2 destination=%3", (Object)new Integer(n), (Object)navLocation, (Object)navLocationWgs84);
        this.setPreviewMapState(n, this.getFactoryPreviewMapState().createPreviewMapNavLocation(navLocation, guiModelAccessForPreviewMapDetailScreen, guiTooltipInformationContainer));
    }

    @Override
    public void setPreviewDestination(NavLocation navLocation, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        this.logger.log(-2137614336, "PreviewMapHandlerAbstractMapStatesMultiple#setPreviewDestination() previewMapClientId=%1 navLocation=%2", (Object)new Integer(n), (Object)navLocation);
        this.setPreviewMapState(n, this.getFactoryPreviewMapState().createPreviewMapNavLocation(navLocation, guiModelAccessForPreviewMapDetailScreen, guiTooltipInformationContainer));
    }

    @Override
    public void setPreviewAddressBookEntry(NavLocation navLocation, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        this.logger.log(-2137614336, "PreviewMapHandlerAbstractMapStatesMultiple#setPreviewAddressBookEntry() previewMapClientId=%1 navLocation=%2", (Object)new Integer(n), (Object)navLocation);
        this.setPreviewMapState(n, this.getFactoryPreviewMapState().createPreviewMapNavLocation(navLocation, guiModelAccessForPreviewMapDetailScreen, guiTooltipInformationContainer));
    }

    @Override
    public void setPreviewFavoriteHome(NavLocation navLocation, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        this.logger.log(-2137614336, "PreviewMapHandlerAbstractMapStatesMultiple#setPreviewFavoriteHome() previewMapClientId=%1 homeLocation=%2", (Object)new Integer(n), (Object)navLocation);
        this.setPreviewMapState(n, this.getFactoryPreviewMapState().createPreviewMapNavLocation(navLocation, guiModelAccessForPreviewMapDetailScreen, guiTooltipInformationContainer));
    }

    @Override
    public void setPreviewState(NavLocation navLocation, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        this.logger.log(-2137614336, "PreviewMapHandlerAbstractMapStatesMultiple#setPreviewState() previewMapClientId=%1 locationOfState=%2", (Object)new Integer(n), (Object)navLocation);
        this.setPreviewMapState(n, this.getFactoryPreviewMapState().createPreviewMapNavLocation(navLocation, guiModelAccessForPreviewMapDetailScreen, guiTooltipInformationContainer));
    }

    @Override
    public void setPreviewLocationCity(NavLocation navLocation, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        this.logger.log(-2137614336, "PreviewMapHandlerAbstractMapStatesMultiple#setPreviewLocationCity() previewMapClientId=%1 locationOfCity=%2", (Object)new Integer(n), (Object)navLocation);
        this.setPreviewMapState(n, this.getFactoryPreviewMapState().createPreviewMapNavLocation(navLocation, guiModelAccessForPreviewMapDetailScreen, guiTooltipInformationContainer));
    }

    @Override
    public void setPreviewLocations(NavLocation[] navLocationArray, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        this.logger.log(-2137614336, "PreviewMapHandlerAbstractMapStatesMultiple#setPreviewLocations() previewMapClientId=%1 locations=%2", (Object)new Integer(n), (Object)navLocationArray);
        this.setPreviewMapState(n, this.getFactoryPreviewMapState().createPreviewMapNavLocations(navLocationArray, guiModelAccessForPreviewMapDetailScreen, guiTooltipInformationContainer));
    }

    @Override
    public void setPreviewTour(NavLocation[] navLocationArray, String string, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        this.logger.log(-2137614336, "PreviewMapHandlerAbstractMapStatesMultiple#setPreviewTour() previewMapClientId=%1 locations=%2 tourName=%3", (Object)new Integer(n), (Object)navLocationArray, (Object)string);
        this.setPreviewMapState(n, this.getFactoryPreviewMapState().createPreviewMapTour(navLocationArray, string, guiModelAccessForPreviewMapDetailScreen, guiTooltipInformationContainer));
    }

    @Override
    public void setPreviewLocationsForOperatorCall(NavLocationWgs84[] navLocationWgs84Array, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        this.logger.log(-2137614336, "PreviewMapHandlerAbstractMapStatesMultiple#setPreviewLocationsForOperatorCall() previewMapClientId=%1 locations=%2", (Object)new Integer(n), (Object)navLocationWgs84Array);
        this.setPreviewMapState(n, this.getFactoryPreviewMapState().createPreviewMapNavLocations(Util.wgs84sToNavLocations(navLocationWgs84Array), guiModelAccessForPreviewMapDetailScreen, guiTooltipInformationContainer));
    }

    @Override
    public void setPreviewPOIsOnboard(NavLocation[] navLocationArray, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        this.logger.log(-2137614336, "PreviewMapHandlerAbstractMapStatesMultiple#setPreviewPOIsOnboard() previewMapClientId=%1 locations=%2", (Object)new Integer(n), (Object)navLocationArray);
        this.setPreviewMapState(n, this.getFactoryPreviewMapState().createPreviewMapNavLocations(navLocationArray, guiModelAccessForPreviewMapDetailScreen, guiTooltipInformationContainer));
    }

    @Override
    public void setPreviewPOIsOnboardDistant(NavLocation[] navLocationArray, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        this.logger.log(-2137614336, "PreviewMapHandlerAbstractMapStatesMultiple#setPreviewPOIsOnboardDistant() previewMapClientId=%1 locations=%2", (Object)new Integer(n), (Object)navLocationArray);
        this.setPreviewMapState(n, this.getFactoryPreviewMapState().createPreviewMapNavLocations(navLocationArray, guiModelAccessForPreviewMapDetailScreen, guiTooltipInformationContainer));
    }

    @Override
    public void setPreviewPOIsOnboardAroundCCP(NavLocation[] navLocationArray, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        this.logger.log(-2137614336, "PreviewMapHandlerAbstractMapStatesMultiple#setPreviewPOIsOnboardAroundCCP() previewMapClientId=%1 locations=%2", (Object)new Integer(n), (Object)navLocationArray);
        this.setPreviewMapState(n, this.getFactoryPreviewMapState().createPreviewMapNavLocations(navLocationArray, guiModelAccessForPreviewMapDetailScreen, guiTooltipInformationContainer));
    }

    @Override
    public void setPreviewPOIsOnboardAroundReferencePoint(NavLocation[] navLocationArray, NavLocationWgs84 navLocationWgs84, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        this.logger.log(-2137614336, "PreviewMapHandlerAbstractMapStatesMultiple#setPreviewPOIsOnboardAroundReferencePoint() previewMapClientId=%1 locations=%2", (Object)new Integer(n), (Object)navLocationArray);
        this.setPreviewMapState(n, this.getFactoryPreviewMapState().createPreviewMapNavLocations(navLocationArray, guiModelAccessForPreviewMapDetailScreen, guiTooltipInformationContainer));
    }

    @Override
    public void setPreviewPOIsOnboardAroundDestination(NavLocation[] navLocationArray, NavLocationWgs84 navLocationWgs84, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        this.logger.log(-2137614336, "PreviewMapHandlerAbstractMapStatesMultiple#setPreviewPOIsOnboardAroundDestination() previewMapClientId=%1 locations=%2", (Object)new Integer(n), (Object)navLocationArray);
        this.setPreviewMapState(n, this.getFactoryPreviewMapState().createPreviewMapNavLocations(navLocationArray, guiModelAccessForPreviewMapDetailScreen, guiTooltipInformationContainer));
    }

    @Override
    public void setPreviewRoadSegment(int n, int n2, int n3, int n4, long l, long l2, int n5, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        this.logger.log(10000, "PreviewMapHandlerAbstractMapStatesMultiple#setPreviewRoadSegment() not implemented");
    }

    @Override
    public void setPreviewTrafficInfoTmcEvent(TmcMessage tmcMessage, int n, boolean bl) {
        this.logger.log(-2137614336, "PreviewMapHandlerAbstractMapStatesMultiple#setPreviewTrafficInfoTmcEvent()");
        if (tmcMessage == null) {
            this.logger.log(10000, "PreviewMapHandlerAbstractMapStatesMultiple#setPreviewTrafficInfoTmcEvent() tmcMessage is null");
        }
        this.getMapForFullScreen().getNaviInterface().getTMCGateWay().setPreviewTrafficInfoTmcEvent(tmcMessage, n, bl);
    }

    @Override
    public void setPreviewTrafficInfoTmcEvents(long[] lArray, NavRectangle navRectangle, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        this.logger.log(-2137614336, "PreviewMapHandlerAbstractMapStatesMultiple#setPreviewTrafficInfoTmcEvents() previewMapClientId=%1 messageIds=%2 rectangle=%3", (Object)new Integer(n), (Object)lArray, (Object)navRectangle);
        this.setPreviewMapState(n, this.getFactoryPreviewMapState().createPreviewMapTrafficInfoEvents(lArray, navRectangle, guiModelAccessForPreviewMapDetailScreen, guiTooltipInformationContainer));
    }

    @Override
    public void setPreviewRoute(boolean bl, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        this.logger.log(-2137614336, "PreviewMapHandlerAbstractMapStatesMultiple#setPreviewRoute() previewMapClientId=%1 completeRoute=%2", (Object)new Integer(n), (Object)new Boolean(bl));
        this.setPreviewMapState(n, this.getFactoryPreviewMapState().createPreviewMapRoute(bl));
    }

    @Override
    public void setPreviewRoute(boolean bl, boolean bl2, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        this.logger.log(-2137614336, "PreviewMapHandlerAbstractMapStatesMultiple#setPreviewRoute() previewMapClientId=%1 completeRoute=%2 rgActive=%3", (Object)new Integer(n), (Object)new Boolean(bl), (Object)new Boolean(bl2));
        this.setPreviewMapState(n, this.getFactoryPreviewMapState().createPreviewMapRouteRgActive(bl, bl2));
    }

    @Override
    public void setPreviewRouteEvent(NavLocation navLocation, int n, int n2, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        this.logger.log(1078071040, "PreviewMapHandler#previewRouteEvent() - NOT YET IMPLEMENTED");
    }

    @Override
    public void setPreviewSDSPicklistEvents(NavLocation[] navLocationArray, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        this.logger.log(-2137614336, "PreviewMapHandlerAbstractMapStatesMultiple#setPreviewSDSPicklistEvents() previewMapClientId=%1 locations=%2", (Object)new Integer(n), (Object)navLocationArray);
        this.setPreviewMapState(n, this.getFactoryPreviewMapState().createPreviewMapSDSPicklistEvents(navLocationArray, guiModelAccessForPreviewMapDetailScreen, guiTooltipInformationContainer));
    }

    @Override
    public void setPreviewTrafficInfoTmcEvent(long l, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        this.logger.log(-2137614336, "PreviewMapHandlerAbstractMapStatesMultiple#setPreviewTrafficInfoTmcEvent() previewMapClientId=%1 messageId=%2", (Object)new Integer(n), l);
        this.setPreviewMapState(n, this.getFactoryPreviewMapState().createPreviewMapTrafficInfoEvent(l, guiModelAccessForPreviewMapDetailScreen, guiTooltipInformationContainer));
    }

    @Override
    public void setPreviewTrafficInfoTmcEventsForRouteList(NavRectangle navRectangle, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        this.logger.log(-2137614336, "PreviewMapHandlerAbstractMapStatesMultiple#setPreviewTrafficInfoTmcEventsForRouteList() previewMapClientId=%1 rectangle=%2", (Object)new Integer(n), (Object)navRectangle);
        this.setPreviewMapState(n, this.getFactoryPreviewMapState().createPreviewMapTrafficInfoEventsForRouteList(navRectangle, guiModelAccessForPreviewMapDetailScreen, guiTooltipInformationContainer));
    }

    @Override
    public void setPreviewPredictiveNavigationRoute(NavSegmentID navSegmentID, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        this.setPreviewMapState(n, this.getFactoryPreviewMapState().createPreviewMapRouteSelenaSingle(navSegmentID, guiModelAccessForPreviewMapDetailScreen, guiTooltipInformationContainer));
    }

    @Override
    public void setPreviewPredictiveNavigationRoutes(NavSegmentID[] navSegmentIDArray, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        this.setPreviewMapState(n, this.getFactoryPreviewMapState().createPreviewMapRouteSelenaOverview(navSegmentIDArray, guiModelAccessForPreviewMapDetailScreen, guiTooltipInformationContainer));
    }

    @Override
    public void setPreviewRouteOffroad(NavSegmentID navSegmentID, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        this.setPreviewMapState(n, this.getFactoryPreviewMapState().createPreviewMapRouteOffroad(navSegmentID, guiModelAccessForPreviewMapDetailScreen, guiTooltipInformationContainer));
    }

    @Override
    public void setPreviewPoiOnlineAroundCCP(NavLocation navLocation, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        this.logger.log(-2137614336, "PreviewMapHandlerAbstractMapStatesMultiple#setPreviewPoiOnlineAroundCCP() previewMapClientId=%1 locations=%2", (Object)new Integer(n), (Object)navLocation);
        this.setPreviewMapState(n, this.getFactoryPreviewMapState().createPreviewMapNavLocation(navLocation, guiModelAccessForPreviewMapDetailScreen, guiTooltipInformationContainer));
    }

    @Override
    public void setPreviewPoiOnlineAroundDestination(NavLocation navLocation, NavLocationWgs84 navLocationWgs84, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        this.logger.log(-2137614336, "PreviewMapHandlerAbstractMapStatesMultiple#setPreviewPoiOnlineAroundDestination() previewMapClientId=%1 location=%2 destination=%3", (Object)new Integer(n), (Object)LocationFormatter.formatLocationShort(navLocation), (Object)navLocationWgs84);
        this.setPreviewMapState(n, this.getFactoryPreviewMapState().createPreviewMapNavLocations(new NavLocation[]{navLocation}, false, false, navLocationWgs84 != null, navLocationWgs84, guiModelAccessForPreviewMapDetailScreen, guiTooltipInformationContainer));
    }

    @Override
    public void setPreviewPoiOnlineAroundReferencePoint(NavLocation navLocation, NavLocationWgs84 navLocationWgs84, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        this.logger.log(-2137614336, "PreviewMapHandlerAbstractMapStatesMultiple#setPreviewPoiOnlineAroundReferencePoint() previewMapClientId=%1 location=%2 referencePoint=%3", (Object)new Integer(n), (Object)LocationFormatter.formatLocationShort(navLocation), (Object)navLocationWgs84);
        this.setPreviewMapState(n, this.getFactoryPreviewMapState().createPreviewMapNavLocations(new NavLocation[]{navLocation}, false, false, navLocationWgs84 != null, navLocationWgs84, guiModelAccessForPreviewMapDetailScreen, guiTooltipInformationContainer));
    }

    @Override
    public void setPreviewFavorite(NavLocation navLocation, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        this.logger.log(-2137614336, "PreviewMapHandlerAbstractMapStatesMultiple#setPreviewFavorite() previewMapClientId=%1 location=%2", (Object)new Integer(n), (Object)navLocation);
        this.setPreviewMapState(n, this.getFactoryPreviewMapState().createPreviewMapNavLocation(navLocation, guiModelAccessForPreviewMapDetailScreen, guiTooltipInformationContainer));
    }

    @Override
    public void setPreviewLocationConcierge(NavLocationWgs84 navLocationWgs84, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        this.logger.log(-2137614336, "PreviewMapHandlerAbstractMapStatesMultiple#setPreviewLocationConcierge() previewMapClientId=%1", (long)n);
        this.setPreviewMapState(n, this.getFactoryPreviewMapState().createPreviewMapNavLocation(Util.wgs84ToNavLocation(navLocationWgs84), guiModelAccessForPreviewMapDetailScreen, guiTooltipInformationContainer));
    }

    @Override
    public void setPreviewLocationTpeg(NavLocation navLocation, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        this.logger.log(-2137614336, "PreviewMapHandlerAbstractMapStatesMultiple#setPreviewLocationTpeg() previewMapClientId=%1 location=%2", (Object)new Integer(n), (Object)navLocation);
        this.setPreviewLocation(navLocation, n, guiModelAccessForPreviewMapDetailScreen, guiTooltipInformationContainer);
    }

    @Override
    public void setPreviewPOIsOnboardFromTourListOrRouteList(NavLocation[] navLocationArray, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        this.logger.log(-2137614336, "PreviewMapHandlerAbstractMapStatesMultiple#setPreviewPOIsOnboardFromTourListOrRouteList() previewMapClientId=%1 location=%2", (Object)new Integer(n), (Object)navLocationArray);
        this.setPreviewLocations(navLocationArray, n, guiModelAccessForPreviewMapDetailScreen, guiTooltipInformationContainer);
    }

    @Override
    public void setPreviewLocationFromTourList(NavLocation navLocation, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        this.logger.log(-2137614336, "PreviewMapHandlerAbstractMapStatesMultiple#setPreviewLocationFromTourList() previewMapClientId=%1 location=%2", (Object)new Integer(n), (Object)navLocation);
        this.setPreviewLocation(navLocation, n, guiModelAccessForPreviewMapDetailScreen, guiTooltipInformationContainer);
    }

    @Override
    public void setStoreFocusForEnterOnce(boolean bl) {
    }

    @Override
    public GuiPreviewMapLayout getGuiPreviewMapLayoutCurrent() {
        if (this.mapPreviewMapLayouts == null) {
            return null;
        }
        int n = this.getPreviewMapLayoutIdCurrent();
        if (n == -1) {
            this.logger.log(10000, "PreviewMapHandlerAbstractMapStatesMultiple#getGuiPreviewMapLayoutCurrent() no layout set");
            return null;
        }
        GuiPreviewMapLayout guiPreviewMapLayout = (GuiPreviewMapLayout)this.mapPreviewMapLayouts.get(new Integer(n));
        if (guiPreviewMapLayout == null) {
            this.logger.log(10000, "PreviewMapHandlerAbstractMapStatesMultiple#getGuiPreviewMapLayoutCurrent() no layout found");
        }
        return guiPreviewMapLayout;
    }

    protected void setGuiWaitingForApply(boolean bl) {
        GuiTimerWaitingForApply guiTimerWaitingForApply = this.guiTimerWaitingForApply;
        if (guiTimerWaitingForApply != null) {
            guiTimerWaitingForApply.setActive(bl);
        }
    }

    @Override
    public int getMapContextCorrected(int n) {
        int n2 = n;
        if (n == 13) {
            if (this.getPreviewMapClientIdActive() == 0) {
                n2 = 12;
                this.logger.log(10000, "PreviewMapHandlerAbstractMapStatesMultiple#getMapContextPreferred() corrected");
            }
        } else if (MapUtils.isCtxPositionMap(n) && this.getPreviewMapClientIdActive() == 0 && PreviewMapUtils.isPreviewMapStateValid(this.getPreviewMapStateCurrent())) {
            n2 = 12;
            this.logger.log(-2137614336, "PreviewMapHandlerAbstractMapStatesMultiple#getMapContextPreferred() corrected position map to crosshair map");
        }
        return n2;
    }

    @Override
    public void cleanUp() {
        GuiTimerWaitingForApply guiTimerWaitingForApply = this.guiTimerWaitingForApply;
        if (guiTimerWaitingForApply != null) {
            guiTimerWaitingForApply.cleanUp();
        }
        this.guiTimerWaitingForApply = null;
        this.hashMapPreviewMapStates = null;
    }

    @Override
    public void setPreviewLocation(NavLocation navLocation, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer, boolean bl, String string) {
        this.logger.log(-2137614336, "PreviewMapHandlerAbstractMapStatesMultiple#setPreviewLocation() previewMapClientId=%1 navLocation=%2", (Object)new Integer(n), (Object)navLocation);
        this.setPreviewMapState(n, this.getFactoryPreviewMapState().createPreviewMapNavLocation(navLocation, guiModelAccessForPreviewMapDetailScreen, guiTooltipInformationContainer, bl, string));
    }
}

