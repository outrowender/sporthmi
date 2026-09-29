/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.dsi;

import de.audi.atip.log.LogChannel;
import de.audi.atip.metrics.GeoMetric;
import de.audi.tghu.navi.app.map.IContext;
import de.audi.tghu.navi.app.map.context.CtxShown;
import de.audi.tghu.navi.app.map.context.HasPosInfo;
import de.audi.tghu.navi.app.map.dsi.AbstractResponser;
import de.audi.tghu.navi.app.map.dsi.MVRequestControl;
import de.audi.tghu.navi.app.map.dsi.MVRequestZoomEngine;
import de.audi.tghu.navi.app.map.utils.MapEnv;
import de.audi.tghu.navi.app.map.utils.MapUtils;
import de.audi.tghu.navi.app.map.utils.PosInfoWrapper;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.map.AvailableRoute;
import org.dsi.ifc.map.DSIMapViewerControlListener;
import org.dsi.ifc.map.MapFlag;
import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.PosInfo;
import org.dsi.ifc.map.Rect;
import org.dsi.ifc.map.RouteBrowserInfo;
import org.dsi.ifc.map.ViewPort;

public class MVResponseControl
extends AbstractResponser
implements DSIMapViewerControlListener {
    protected int mInstanceID;
    private float[] sdsZoomLevelsMetrical;
    private float[] sdsZoomLevelsImperial;
    protected boolean mReady = false;
    private int mCurrentViewType = -1;
    private boolean mDayNightView = false;
    protected Rect mViewScreenViewPort = null;
    protected boolean mViewVisible = false;
    protected boolean mViewFreeze = false;
    protected float[] mZoomList = null;
    private int mZoomListIndex = -1;
    private short mMapRotation = 0;
    private NavLocationWgs84 mMapPosition = null;
    private int mMapOrientation = -1;
    private Point mCarPosition = null;
    private int mMapMode = -1;
    private ViewPort mViewPort = null;
    private boolean mTmcVisible = false;
    private boolean mSoftJumpEnabled = false;
    private boolean mSoftRotationEnabled = false;
    private boolean mSoftTiltEnabled = false;
    private boolean mSoftZoomEnabled = false;
    private AvailableRoute[] mAvailableRoutes = null;
    private PosInfo[] mInfoList = null;
    private long[] mFlags = null;
    private boolean mRouteCalcModeEnabled = false;
    private boolean mSatelliteDataVisible = false;
    private int mMapViewerRunLevel = -1;
    private int mMapViewerSuspensionAndWakeUpProgress = -1;
    private int mMapViewerSuspensionSupported = -1;
    private MapFlag[] mMapPersonalDest = null;
    private boolean mHorizonMarkerVisible = false;
    private int mCityModelMode = 0;
    protected LogChannel mDSILogChannel;
    protected IContext listener;

    public MVResponseControl(int n, LogChannel logChannel) {
        super(logChannel);
        this.mInstanceID = n;
        this.mDSILogChannel = logChannel;
        this.initSdsZoomLevels();
    }

    @Override
    protected void cleanup() {
        super.cleanup();
        this.listener = null;
    }

    public int getID() {
        return this.mInstanceID;
    }

    @Override
    public String getName() {
        return "MVResponseControl";
    }

    private void initSdsZoomLevels() {
        if (this.mInstanceID == 0) {
            this.sdsZoomLevelsMetrical = new float[]{8403781, 4234309, 4201542, 4234310, 5260103, 5292871, 5260104, 2421832, 2389065, 2421833, -2137614262, -2137647029, -2137614261, 549207628, -1058970548};
            this.sdsZoomLevelsImperial = new float[]{4205381, 13667909, 13635142, 3182150, 3841351, 3808584, 3841352, -2138553271, -2138520503, -2138553270, -1599408822, -1599441589, -1599408821, -1599441588};
        } else {
            this.sdsZoomLevelsMetrical = new float[]{8403781, 4234309, 4201542, 4234310, 5260103, 5292871, 5260104, 2421832, 2389065, 2421833, -2137614262, -2137647029, -2137614261, 549207628, -1058970548, 549240396, 549207629, 678129229};
            this.sdsZoomLevelsImperial = new float[]{4205381, 13667909, 13635142, 3182150, 3841351, 3808584, 3841352, -2138553271, -2138520503, -2138553270, -1599408822, -1599441589, -1599408821, -1599441588, -130041780, -1534453427, -162568627};
        }
    }

    public void setListener(IContext iContext) {
        this.mDSILogChannel.log(-2137614336, "MVResponseControl#setListener( %1 )", (Object)iContext);
        this.listener = iContext;
    }

    protected IContext getListener() {
        return this.listener;
    }

    protected boolean isActive() {
        return this.mInstanceID == this.naviMap.getSatellitemapsManager().getActiveRendererID();
    }

    public float[] getSdsZoomLevelsMetrical() {
        return this.sdsZoomLevelsMetrical;
    }

    public float[] getSdsZoomLevelsImperial() {
        return this.sdsZoomLevelsImperial;
    }

    @Override
    public void configureFlags(long[] lArray) {
        this.mDSILogChannel.log(-2137614336, "MVResponseControl#configureFlags() - handles : [%1]", (Object)MapUtils.toString(lArray));
        this.mFlags = lArray;
        try {
            if (this.isActive()) {
                this.naviMap.getMVRequest().configureFlagsIsActive(false);
                this.handleQueuedInfoForPosition();
            }
            if (!this.naviMap.getMapFlagHandler().configureFlags(lArray)) {
                this.naviMap.getMapResponseDispatcher().configureFlags(lArray);
            }
        }
        catch (Exception exception) {
            this.mDSILogChannel.log(10000, "MVResponseControl#configureFlags() - ERROR=%1", (Throwable)exception);
        }
    }

    public long[] getConfiguredFlags() {
        return this.mFlags;
    }

    public MapFlag[] getMapPersonalDest() {
        return this.mMapPersonalDest;
    }

    public void storeMapPersonalDest(MapFlag[] mapFlagArray) {
        this.mDSILogChannel.log(14808325, "MVResponseControl#storeMapPersonalDest() - length: %1", mapFlagArray == null ? 0L : (long)mapFlagArray.length);
        if (mapFlagArray != null) {
            this.mMapPersonalDest = new MapFlag[mapFlagArray.length];
            for (int i2 = 0; i2 < mapFlagArray.length; ++i2) {
                this.mMapPersonalDest[i2] = new MapFlag(mapFlagArray[i2].geoX, mapFlagArray[i2].geoY, mapFlagArray[i2].styleIndex, mapFlagArray[i2].handle);
                this.mDSILogChannel.log(14808325, "MVResponseControl#storeMapPersonalDest() -  mMapPersonalDest[%2]=%1", (Object)this.mMapPersonalDest[i2], (long)i2);
            }
        } else {
            this.mMapPersonalDest = null;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void getInfoForPosition(PosInfo[] posInfoArray) {
        int n;
        if (posInfoArray == null || posInfoArray.length == 0) {
            this.mDSILogChannel.log(-2137614336, "MVResponseControl#getInfoForPosition(): infoList is empty!");
        } else {
            for (n = 0; n < posInfoArray.length; ++n) {
                if (this.mDSILogChannel.isDebug2()) {
                    this.mDSILogChannel.log(-2137614336, "MVResponseControl#getInfoForPosition(): infoList[%2] = %1", (Object)posInfoArray[n], (long)n);
                    continue;
                }
                this.mDSILogChannel.log(-2137614336, "MVResponseControl#getInfoForPosition(): infoList[%2] = %1", (Object)PosInfoWrapper.toShortString(posInfoArray[n]), (long)n);
            }
        }
        if (this.isActive()) {
            MVRequestControl mVRequestControl = this.naviMap.getMVRequest().getMVRequestControlActive();
            synchronized (mVRequestControl) {
                this.naviMap.getMVRequest().setInfoForPositionIsActive(false);
                n = this.handleQueuedInfoForPosition() ? 1 : 0;
            }
            if (n == 0) {
                this.mInfoList = posInfoArray;
                if (this.naviMap.getActiveContext() instanceof HasPosInfo) {
                    ((HasPosInfo)((Object)this.naviMap.getActiveContext())).updateInfoForPosition(posInfoArray);
                } else {
                    this.getLogger().log(-1601830656, "MVResponseControl#getInfoForPosition() - the active context (id=%2) of %1 is not HasPosInfo", (Object)this.naviMap.getName(), (long)this.naviMap.getActiveContextIndex());
                }
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private boolean handleQueuedInfoForPosition() {
        boolean bl = false;
        Point point = new Point(-1, -1);
        MVRequestControl mVRequestControl = this.naviMap.getMVRequest().getMVRequestControlActive();
        synchronized (mVRequestControl) {
            bl = this.naviMap.getMVRequest().getQueueGetInfoForPosition();
            point = this.naviMap.getMVRequest().getQueueGetInfoForScreenPositionPoint();
            if (bl) {
                if (point.xPos >= 0 && point.yPos >= 0) {
                    this.naviMap.getMVRequest().getInfoForScreenPosition(point);
                } else {
                    this.naviMap.getMVRequest().getInfoForPosition();
                }
            }
        }
        return bl;
    }

    public PosInfo[] getInfoList() {
        return this.mInfoList;
    }

    @Override
    public void getNumberOfPOIs(long l) {
        this.mDSILogChannel.log(-2137614336, "MVResponseControl#getNumberOfPOIs( %1 ) - unexpected call!", l);
    }

    @Override
    public void unpackPOIContainerResult(boolean bl) {
        this.mDSILogChannel.log(-2137614336, "MVResponseControl#unpackPOIContainerResult( %1 ) - unexpected call!", bl);
    }

    @Override
    public void updateAvailableRoutes(AvailableRoute[] availableRouteArray, int n) {
        if (n == 1) {
            if (availableRouteArray == null || availableRouteArray.length == 0) {
                this.mDSILogChannel.log(-2137614336, "MVResponseControl#updateAvailableRoutes(): availableRoutes is empty!");
            } else {
                Buffer buffer = new Buffer();
                for (int i2 = 0; i2 < availableRouteArray.length; ++i2) {
                    buffer.append(" [").append(i2).append("]").append(availableRouteArray[i2].getNavSegmentID()).append(";");
                }
                this.mDSILogChannel.log(-2137614336, "MVResponseControl#updateAvailableRoutes() -%1", (Object)buffer.toString());
            }
            this.mAvailableRoutes = availableRouteArray;
            if (this.isActive()) {
                this.naviMap.getActiveContext().updateAvailableRoutes(availableRouteArray);
                this.naviMap.getRouteCalculationHandler().updateAvailableRoutes(availableRouteArray, this.getID());
            }
        }
    }

    public AvailableRoute[] getAvailableRoutes() {
        return this.mAvailableRoutes;
    }

    @Override
    public void updateCarPosition(Point point, int n) {
        if (n == 1) {
            this.mDSILogChannel.log(-2137614336, "MVResponseControl#updateCarPosition( %1 )", (Object)point);
            this.mCarPosition = point;
            if (this.isActive()) {
                this.naviMap.getActiveContext().updateCarPosition(point);
            }
        }
    }

    public Point getCarPosition() {
        return this.mCarPosition;
    }

    @Override
    public void updateCurrentViewType(int n, int n2) {
        if (n2 == 1) {
            this.mDSILogChannel.log(-2137614336, "MVResponseControl#updateCurrentViewType( %1 )", (long)n);
            this.mCurrentViewType = n;
            if (this.isActive()) {
                this.naviMap.getActiveContext().updateCurrentViewType(n);
            }
        }
    }

    public int getCurrentViewType() {
        return this.mCurrentViewType;
    }

    @Override
    public void updateDayNightView(boolean bl, int n) {
        if (n == 1) {
            this.mDSILogChannel.log(-2137614336, "MVResponseControl#updateDayNightView( %1 )", bl);
            this.mDayNightView = bl;
            if (this.isActive()) {
                this.naviMap.getActiveContext().updateDayNightView(bl);
            }
        }
    }

    public boolean getDayNightView() {
        return this.mDayNightView;
    }

    @Override
    public void updateMapMode(int n, int n2) {
        if (n2 == 1) {
            this.mDSILogChannel.log(-2137614336, "MVResponseControl#updateMapMode( %1 )", (long)n);
            this.mMapMode = n;
            if (this.isActive()) {
                this.naviMap.getActiveContext().updateMapMode(n);
            }
        }
    }

    public int getMapMode() {
        return this.mMapMode;
    }

    @Override
    public void updateMapOrientation(int n, int n2) {
        if (n2 == 1) {
            this.mDSILogChannel.log(-2137614336, "MVResponseControl#updateMapOrientation(%1)", (long)n);
            this.mMapOrientation = n;
            if (this.isActive()) {
                this.naviMap.getActiveContext().updateMapOrientation(n);
            }
        }
    }

    public int getMapOrientation() {
        return this.mMapOrientation;
    }

    @Override
    public void updateMapPosition(NavLocationWgs84 navLocationWgs84, int n) {
        if (n == 1) {
            GeoMetric geoMetric = new GeoMetric(navLocationWgs84.getLatitude(), navLocationWgs84.getLongitude());
            this.mDSILogChannel.log(-2137614336, "MVResponseControl#updateMapPosition(  %1,   %2  ) - long=%4, lat=%3", (Object)geoMetric.formatLatitude(), (Object)geoMetric.formatLongitude(), (Object)Integer.toString(navLocationWgs84.getLatitude()), (Object)Integer.toString(navLocationWgs84.getLongitude()));
            this.mMapPosition = navLocationWgs84;
            if (this.isActive()) {
                this.naviMap.getActiveContext().updateMapPosition(navLocationWgs84);
            }
        }
    }

    public NavLocationWgs84 getMapPosition() {
        return this.mMapPosition;
    }

    @Override
    public void updateMapRotation(short s, int n) {
        if (n == 1) {
            this.mMapRotation = s;
            if (this.isActive()) {
                this.naviMap.getActiveContext().updateMapRotation(s);
                if (this.getMVRequestZoomEngine() != null) {
                    this.getMVRequestZoomEngine().setMapRotation(s);
                }
            }
        }
    }

    public short getMapRotation() {
        return this.mMapRotation;
    }

    @Override
    public void updateRBInfoOfSelectedSegments(RouteBrowserInfo routeBrowserInfo, int n) {
    }

    @Override
    public void updateReady(boolean bl, int n) {
        if (n == 1) {
            this.mDSILogChannel.log(-2137614336, "MVResponseControl#updateReady( %1 )", bl);
            this.mReady = bl;
            this.naviMap.getActiveContext().updateReady(bl, this.mInstanceID);
            if (this.getListener() != null) {
                this.getListener().updateReady(bl, this.mInstanceID);
            }
        }
    }

    public boolean getMapReady() {
        return this.mReady;
    }

    @Override
    public void updateRouteCalcModeEnabled(boolean bl, int n) {
        if (n == 1) {
            this.mDSILogChannel.log(-2137614336, "MVResponseControl#updateRouteCalcModeEnabled( %1 )", bl);
            this.mRouteCalcModeEnabled = bl;
            if (this.isActive()) {
                this.naviMap.getActiveContext().updateRouteCalcModeEnabled(bl);
            }
        }
    }

    public boolean getRouteCalcModeEnabled() {
        return this.mRouteCalcModeEnabled;
    }

    public boolean getSatelliteDataVisible() {
        return this.mSatelliteDataVisible;
    }

    @Override
    public void updateSelectedPoi(PosInfo posInfo, int n) {
        if (n == 1) {
            this.mDSILogChannel.log(-2137614336, "MVResponseControl#updateSelectedPoi( %1 ) - unexpected call!", (Object)posInfo);
        }
    }

    @Override
    public void updateSoftJumpEnabled(boolean bl, int n) {
        if (n == 1) {
            this.mDSILogChannel.log(-2137614336, "MVResponseControl#updateSoftJumpEnabled(%1)", bl);
            this.mSoftJumpEnabled = bl;
            if (this.isActive()) {
                this.naviMap.getActiveContext().updateSoftJumpEnabled(bl);
            }
        }
    }

    public boolean getSoftJumpEnabled() {
        return this.mSoftJumpEnabled;
    }

    @Override
    public void updateSoftRotationEnabled(boolean bl, int n) {
        if (n == 1) {
            this.mDSILogChannel.log(-2137614336, "MVResponseControl#updateSoftRotationEnabled(%1)", bl);
            this.mSoftRotationEnabled = bl;
            if (this.isActive()) {
                this.naviMap.getActiveContext().updateSoftRotationEnabled(bl);
            }
        }
    }

    public boolean getSoftRotationEnabled() {
        return this.mSoftRotationEnabled;
    }

    @Override
    public void updateSoftTiltEnabled(boolean bl, int n) {
        if (n == 1) {
            this.mDSILogChannel.log(-2137614336, "MVResponseControl#updateSoftTiltEnabled(%1)", bl);
            this.mSoftTiltEnabled = bl;
            if (this.isActive()) {
                this.naviMap.getActiveContext().updateSoftTiltEnabled(bl);
            }
        }
    }

    public boolean getSoftTiltEnabled() {
        return this.mSoftTiltEnabled;
    }

    @Override
    public void updateSoftZoomEnabled(boolean bl, int n) {
        if (n == 1) {
            this.mDSILogChannel.log(-2137614336, "MVResponseControl#updateSoftZoomEnabled(%1)", bl);
            this.mSoftZoomEnabled = bl;
            if (this.isActive()) {
                this.naviMap.getZoomEventListener().updateSoftZoomEnabled(bl);
            }
        }
    }

    public boolean getSoftZoomEnabled() {
        return this.mSoftZoomEnabled;
    }

    @Override
    public void updateSpeedAndFlowVisible(boolean bl, int n) {
        if (n == 1) {
            this.mDSILogChannel.log(-2137614336, "MVResponseControl#updateSpeedAndFlowVisible( %1 ) - unexpected call!", bl);
        }
    }

    @Override
    public void updateTmcVisible(boolean bl, int n) {
        if (n == 1) {
            this.mDSILogChannel.log(-2137614336, "MVResponseControl#updateTmcVisible( %1 )", bl);
            this.mTmcVisible = bl;
            if (this.isActive()) {
                this.naviMap.getActiveContext().updateTmcVisible(bl);
            }
        }
    }

    public boolean getTmcVisible() {
        return this.mTmcVisible;
    }

    @Override
    public void updateViewFreeze(boolean bl, int n) {
        if (n == 1) {
            this.mDSILogChannel.log(-2137614336, "MVResponseControl#updateViewFreeze(%1)", bl);
            this.mViewFreeze = bl;
            if (this.isActive()) {
                this.naviMap.getActiveContext().updateViewFreeze(bl);
                if (!bl && this.naviMap.isMapMain()) {
                    this.naviMap.getNaviInterface().updateMapFreeze(false);
                    if (MapEnv.waitForReadyBeforeEnterMap(this.naviMap.getNavigationEnv())) {
                        this.naviMap.getRouteCalculationHandler().notifyMapUnfrozen();
                    }
                }
            }
            if (this.getListener() != null) {
                this.getListener().updateViewFreeze(bl);
            }
        }
    }

    public boolean getViewFreeze() {
        return this.mViewFreeze;
    }

    @Override
    public void updateViewPort(ViewPort viewPort, int n) {
        if (n == 1) {
            this.mDSILogChannel.log(-2137614336, "MVResponseControl#updateViewPort() - %1", (Object)viewPort);
            this.mViewPort = viewPort;
            if (this.isActive()) {
                this.naviMap.getActiveContext().updateViewPort(viewPort);
            }
        }
    }

    public ViewPort getViewPort() {
        return this.mViewPort;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updateViewScreenViewPort(Rect rect, int n) {
        if (n == 1) {
            this.mDSILogChannel.log(-2137614336, "MVResponseControl#updateViewScreenViewPort() - %1, %2", (long)rect.diffX, (long)rect.diffY);
            this.mViewScreenViewPort = rect;
            if (this.isActive()) {
                boolean bl;
                MVRequestControl mVRequestControl = this.naviMap.getMVRequest().getMVRequestControlActive();
                synchronized (mVRequestControl) {
                    this.naviMap.getMVRequest().setPendingScreenViewport(null);
                    bl = this.handleQueuedScreenViewport();
                }
                if (!bl) {
                    this.naviMap.getActiveContext().updateViewScreenViewPort(rect);
                }
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private boolean handleQueuedScreenViewport() {
        boolean bl;
        MVRequestControl mVRequestControl = this.naviMap.getMVRequest().getMVRequestControlActive();
        synchronized (mVRequestControl) {
            Rect rect = this.naviMap.getMVRequest().getQueuedScreenViewport();
            boolean bl2 = bl = rect != null;
            if (bl) {
                this.naviMap.getMVRequest().setQueuedScreenViewport(null);
                this.naviMap.getMVRequest().viewSetScreenViewport(rect);
            }
        }
        return bl;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Rect getViewScreenViewPort() {
        MVRequestControl mVRequestControl = this.naviMap.getMVRequest().getMVRequestControlActive();
        synchronized (mVRequestControl) {
            if (this.naviMap.getMVRequest().getPendingScreenViewport() != null) {
                return null;
            }
            return this.mViewScreenViewPort;
        }
    }

    public synchronized void setViewScreenViewPort(Rect rect) {
        this.mViewScreenViewPort = rect;
    }

    @Override
    public void updateViewVisible(boolean bl, int n) {
        if (n == 1) {
            this.mDSILogChannel.log(-2137614336, "MVResponseControl#updateViewVisible(%1)", bl);
            this.mViewVisible = bl;
            if (this.isActive()) {
                this.naviMap.getActiveContext().updateViewVisible(bl);
            }
            if (this.getListener() != null) {
                this.getListener().updateViewVisible(bl);
            }
        }
    }

    public boolean getViewVisible() {
        return this.mViewVisible;
    }

    @Override
    public void updateZoomLevel(float f2, int n) {
        if (n == 1) {
            this.getLogger().log(-2137614336, "MVResponseControl#updateZoomLevel( %1 )", (Object)Float.toString(f2));
            if (this.isActive()) {
                this.naviMap.getZoomEventListener().updateZoomLevel(f2);
                this.naviMap.getMVRequest().getMVRequestControlActive().setZoomLevelMember(f2);
                this.naviMap.getActiveContext().updateZoomLevel(f2);
            }
        }
    }

    @Override
    public void updateZoomList(float[] fArray, int n) {
        if (n == 1) {
            float[] fArray2 = this.mZoomList;
            this.mZoomList = fArray;
            if (this.mZoomList != null) {
                this.getLogger().log(-2137614336, "MVResponseControl#updateZoomList() - length: %2, maxValue = %1", (Object)(this.mZoomList.length == 0 ? "n/a" : Float.toString(this.mZoomList[this.mZoomList.length - 1])), (long)this.mZoomList.length);
                if (this.getLogger().isDebug2()) {
                    Buffer buffer = new Buffer(800);
                    for (int i2 = 0; i2 < this.mZoomList.length; ++i2) {
                        buffer.append('[').append(i2).append(':').append(this.mZoomList[i2]).append("]\n");
                    }
                    this.getLogger().log(14808325, "MVResponseControl#updateZoomList() - %1", (Object)buffer);
                }
            } else {
                this.getLogger().log(10000, "MVResponseControl#updateZoomList() - zoom list is empty.");
            }
            if (this.isActive()) {
                this.naviMap.getZoomEventListener().updateZoomList(fArray, fArray2);
            }
            if (this.getListener() != null) {
                this.getListener().updateZoomList(fArray, this.getZoomListIndex(), fArray2);
            }
        }
    }

    public float[] getZoomList() {
        return this.mZoomList;
    }

    public void initZoomListIndex(int n) {
        this.mDSILogChannel.log(-2137614336, "MVResponseControl#initZoomListIndex( %1 )", (long)n);
        this.mZoomListIndex = n;
    }

    @Override
    public void updateZoomListIndex(int n, int n2) {
        if (n2 == 1) {
            this.mDSILogChannel.log(-2137614336, "MVResponseControl#updateZoomListIndex( %1 )", (long)n);
            this.mZoomListIndex = n;
            if (this.isActive()) {
                this.naviMap.getZoomEventListener().updateZoomListIndex(n);
                this.naviMap.getMVRequest().getMVRequestControlActive().setZoomIndexMember(n);
                if (this.naviMap.getNaviInterface().isDemoModeActive() && this.getID() != 2 && this.naviMap.getActiveContext() instanceof CtxShown) {
                    ((CtxShown)this.naviMap.getActiveContext()).calculateAndSetDemoModeSpeed();
                }
            }
        }
    }

    public int getZoomListIndex() {
        this.mDSILogChannel.log(14808325, "MVResponseControl#getZoomListIndex( %1 )", (long)this.mZoomListIndex);
        return this.mZoomListIndex;
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        this.mDSILogChannel.log(10000, "MVResponseControl#asyncException(): code = %2, msg = %1, type = %3", (Object)string, (long)n, (long)n2);
    }

    @Override
    public void resetMemberVariables() {
        this.mDSILogChannel.log(-2137614336, "MVResponseControl#resetMemberVariables() ");
        this.mReady = false;
        this.mCurrentViewType = -1;
        this.mDayNightView = false;
        this.mViewScreenViewPort = null;
        this.mViewVisible = false;
        this.mViewFreeze = false;
        this.mZoomList = null;
        this.mZoomListIndex = -1;
        this.mMapRotation = 0;
        this.mMapPosition = null;
        this.mMapOrientation = -1;
        this.mCarPosition = null;
        this.mMapMode = -1;
        this.mViewPort = null;
        this.mTmcVisible = false;
        this.mSoftJumpEnabled = false;
        this.mSoftRotationEnabled = false;
        this.mSoftTiltEnabled = false;
        this.mSoftZoomEnabled = false;
        this.mAvailableRoutes = null;
        this.mInfoList = null;
        this.mFlags = null;
        this.mRouteCalcModeEnabled = false;
        this.mSatelliteDataVisible = false;
        this.mMapPersonalDest = null;
    }

    @Override
    public void updateCurrentLanduseStyle(int n, int n2) {
    }

    @Override
    public void updateCurrentMetricSystem(int n, int n2) {
    }

    @Override
    public void updateSoftJumpRunning(boolean bl, int n) {
        this.mDSILogChannel.log(-2137614336, "MVResponseControl#updateSoftJumpRunning( %1 ) - unexpected call!", bl);
    }

    @Override
    public void updateSoftRotationRunning(boolean bl, int n) {
        this.mDSILogChannel.log(-2137614336, "MVResponseControl#updateSoftRotationRunning( %1 ) - unexpected call!", bl);
    }

    @Override
    public void updateSoftTiltRunning(boolean bl, int n) {
        if (n == 1 && this.isActive()) {
            try {
                this.mDSILogChannel.log(14808325, "MVResponseControl#updateSoftTiltRunning( %1 )", bl);
                this.getActiveContext().updateSoftTiltRunning(bl);
            }
            catch (Exception exception) {
                this.mDSILogChannel.log(10000, "MVResponseControl#updateSoftTiltRunning( %1 )", (Throwable)exception);
            }
        }
    }

    @Override
    public void updateSoftZoomRunning(boolean bl, int n) {
        this.mDSILogChannel.log(-2137614336, "MVResponseControl#updateSoftZoomRunning( %1 ) - unexpected call!", bl);
    }

    @Override
    public void updateCityModelMode(int n, int n2) {
        if (n2 == 1) {
            this.mDSILogChannel.log(-2137614336, "MVResponseControl#updateCityModelMode( %1 )", (long)n);
            this.mCityModelMode = n;
        }
    }

    @Override
    public void finishDrawRectangleInMapResult(int n, NavLocationWgs84 navLocationWgs84, NavLocationWgs84 navLocationWgs842) {
        this.mDSILogChannel.log(-2137614336, "MVResponseControl#finishDrawRectangleInMapResult( %1, %2 ) - unexpected call!", (Object)navLocationWgs84, (Object)navLocationWgs842);
    }

    @Override
    public void setNorthEastCornerOfRectangleInMapResult(int n, NavLocationWgs84 navLocationWgs84) {
        this.mDSILogChannel.log(-2137614336, "MVResponseControl#setNorthEastCornerOfRectangleInMapResult( %1 ) - unexpected call!", (Object)navLocationWgs84);
    }

    @Override
    public void setSouthWestCornerOfRectangleInMapResult(int n, NavLocationWgs84 navLocationWgs84) {
        this.mDSILogChannel.log(-2137614336, "MVResponseControl#setSouthWestCornerOfRectangleInMapResult( %1 ) - unexpected call!", (Object)navLocationWgs84);
    }

    @Override
    public void setViewFocusOnBlockResult(int n) {
        this.mDSILogChannel.log(-2137614336, "MVResponseControl#setViewFocusOnBlockResult( %1 ) - unexpected call!", (long)n);
    }

    @Override
    public void startToDrawNewRectangleInMapResult(int n, NavLocationWgs84 navLocationWgs84, NavLocationWgs84 navLocationWgs842) {
        this.mDSILogChannel.log(-2137614336, "MVResponseControl#startToDrawNewRectangleInMapResult( %1, %2 ) - unexpected call!", (Object)navLocationWgs84, (Object)navLocationWgs842);
    }

    @Override
    public void displayRemainingRangeOfVehicleResult(boolean bl) {
        this.mDSILogChannel.log(-2137614336, "MVResponseControl#displayRemainingRangeOfVehicleResult( %1 ) - unexpected call!", bl);
    }

    @Override
    public void touchApproachResult(boolean bl) {
        this.mDSILogChannel.log(-2137614336, "MVResponseControl#touchApproachResult( %1 ) - unexpected call!", bl);
    }

    @Override
    public void setBrandIconStyleResult(int n) {
        this.mDSILogChannel.log(-2137614336, "MVResponseControl#setBrandIconStyleResult( %1 )", (long)n);
    }

    @Override
    public void setGuidanceSymbolResult(int n) {
        this.mDSILogChannel.log(-2137614336, "MVResponseControl#setGuidanceSymbolResult( %1 ) - unexpected call!", (long)n);
    }

    @Override
    public void setHOVLaneVisibilityResult(int n) {
        this.mDSILogChannel.log(-2137614336, "MVResponseControl#setHOVLaneVisibilityResult( %1 ) - unexpected call!", (long)n);
    }

    @Override
    public void rbGetIDOfSelectedSegmentResult(long l, int n) {
        if (n == 0) {
            this.mDSILogChannel.log(-2137614336, "MVResponseControl#rbGetIDOfSelectedSegmentResult( %1 )", l);
            if (this.isActive()) {
                this.naviMap.getActiveContext().rbGetIDOfSelectedSegmentResult(l);
            }
        }
    }

    @Override
    public void rbGetRRDToSelectedSegmentResult(long l, int n, int n2) {
        if (n2 == 0) {
            this.mDSILogChannel.log(-2137614336, "MVResponseControl#rbGetRRDToSelectedSegmentResult( %1, %2 )", l, (long)n);
            if (this.isActive()) {
                this.naviMap.getActiveContext().rbGetRRDToSelectedSegmentResult(l, n);
            }
        }
    }

    @Override
    public void setTollRoadHighLightingResult(boolean bl, int n) {
        this.mDSILogChannel.log(-2137614336, "MVResponseControl#setTollRoadHighLightingResult( %1 ) - unexpected call!", (long)n);
    }

    @Override
    public void setMountainPeakMarkerResult(boolean bl, int n) {
        this.mDSILogChannel.log(-2137614336, "MVResponseControl#setMountainPeakMarkerResult( %1 ) - unexpected call!", (long)n);
    }

    public void setViewFocusOnCombinedRouteListElementsResult(int n) {
        this.mDSILogChannel.log(-2137614336, "MVResponseControl#setViewFocusOnCombinedRouteListElementsResult( %1 ) - unexpected call!", (long)n);
    }

    @Override
    public void suspendMapViewerResult(int n) {
        this.mDSILogChannel.log(-2137614336, "MVResponseControl#suspendMapViewerResult( %1 )", (long)n);
    }

    @Override
    public void wakeupMapViewerResult(int n) {
        this.mDSILogChannel.log(-2137614336, "MVResponseControl#wakeupMapViewerResult( %1 )", (long)n);
    }

    @Override
    public void updateMapViewerRunLevel(int n, int n2) {
        if (n2 == 1) {
            this.mDSILogChannel.log(-2137614336, "MVResponseControl#updateMapViewerRunLevel( %1 )", (long)n);
            this.mMapViewerRunLevel = n;
        }
    }

    public int getMapViewerRunLevel() {
        this.mDSILogChannel.log(-2137614336, "MVResponseControl#getMapViewerRunLevel( %1 )", (long)this.mMapViewerRunLevel);
        return this.mMapViewerRunLevel;
    }

    @Override
    public void updateMapViewerSuspensionSupported(int n, int n2) {
        if (n2 == 1) {
            this.mDSILogChannel.log(-2137614336, "MVResponseControl#updateMapViewerSuspensionSupported( %1 )", (long)n);
            this.mMapViewerSuspensionSupported = n;
        }
    }

    public int getMapViewerSuspensionSupported() {
        this.mDSILogChannel.log(-2137614336, "MVResponseControl#getMapViewerSuspensionSupported( %1 )", (long)this.mMapViewerSuspensionSupported);
        return this.mMapViewerSuspensionSupported;
    }

    @Override
    public void updateMapViewerSuspensionAndWakeUpProgress(int n, int n2) {
        if (n2 == 1) {
            this.mDSILogChannel.log(-2137614336, "MVResponseControl#updateMapViewerSuspensionAndWakeUpProgress( %1 )", (long)n);
            this.mMapViewerSuspensionAndWakeUpProgress = n;
        }
    }

    int getMapViewerSuspensionAndWakeUpProgress() {
        this.mDSILogChannel.log(-2137614336, "MVResponseControl#getMapViewerSuspensionAndWakeUpProgress( %1 )", (long)this.mMapViewerSuspensionAndWakeUpProgress);
        return this.mMapViewerSuspensionAndWakeUpProgress;
    }

    @Override
    public void updateAvailableCountryOverviews(String[] stringArray, int n) {
        this.mDSILogChannel.log(-2137614336, "MVResponseControl#updateAvailableCountryOverviews( %1 ) - unexpected call!", (Object)stringArray);
    }

    @Override
    public void updateGeneralPoiVisibility(boolean bl, int n) {
        this.mDSILogChannel.log(-2137614336, "MVResponseControl#updateGeneralPoiVisibility( %1 ) - unexpected call!", bl);
    }

    @Override
    public void isDetailedMapMaterialAvailable(NavLocationWgs84 navLocationWgs84, boolean bl) {
        this.mDSILogChannel.log(-2137614336, "MVResponseControl#isDetailedMapMaterialAvailable( %2, %1 )", bl, (Object)navLocationWgs84);
        this.naviMap.getMapResponseDispatcher().isDetailedMapMaterialAvailable(navLocationWgs84, bl);
    }

    @Override
    public void updateHorizonMarkerVisibility(boolean bl, int n) {
        if (n == 1) {
            this.mDSILogChannel.log(-2137614336, "MVResponseControl#updateHorizonMarkerVisibility( %1 )", bl);
            this.mHorizonMarkerVisible = bl;
        }
    }

    @Override
    public void updateViewScreenViewPortMaximum(Rect rect, int n) {
        if (n == 1) {
            this.mDSILogChannel.log(-2137614336, "MVResponseControl#updateViewScreenViewPortMaximum( %1 )", (Object)rect);
        }
    }

    @Override
    public void updateDragRoutePosition(NavLocationWgs84 navLocationWgs84, int n) {
        if (n == 1) {
            this.mDSILogChannel.log(-2137614336, "MVResponseControl#updateDragRoutePosition( %1 )", (Object)navLocationWgs84);
            if (this.isActive()) {
                this.naviMap.getActiveContext().updateDragRoutePosition(navLocationWgs84);
            }
        } else {
            this.mDSILogChannel.log(14808325, "MVResponseControl#updateDragRoutePosition( %1, %2 )", (Object)navLocationWgs84, (long)n);
        }
    }

    @Override
    public void updateEhCategoryVisibility(int[] nArray, int n) {
        if (n == 1) {
            this.mDSILogChannel.log(-2137614336, "MVResponseControl#updateEhCategoryVisibility( ) - [%1]", (Object)MapUtils.toString(nArray));
            if (this.isActive() && this.naviMap.getMapContentHandler() != null) {
                this.naviMap.getMapContentHandler().updateEhCategoryVisibility(nArray);
            }
        } else {
            this.mDSILogChannel.log(-1601830656, "MVResponseControl#updateEhCategoryVisibility( ) - invalid");
        }
    }

    @Override
    public void setMapOverlaysResult(int n, int n2) {
        this.mDSILogChannel.log(14808325, "MVResponseControl#setMapOverlaysResult(): ID = %1, resultCode = %2", (long)n, (long)n2);
    }

    @Override
    public void updateMapLayerAvailable(int[] nArray, int n) {
        if (n == 1) {
            this.mDSILogChannel.log(14808325, "MVResponseControl#updateMapLayerAvailable(): mapLayerAvailable.length = %1", nArray != null ? (long)nArray.length : -1L);
        }
    }

    @Override
    public void updateMapLayerVisible(int[] nArray, int n) {
        if (n == 1) {
            this.mDSILogChannel.log(14808325, "MVResponseControl#updateMapLayerVisible(): mapLayerVisible.lenth = %1", nArray != null ? (long)nArray.length : -1L);
        }
    }

    @Override
    public void updateTemperatureScale(int n, int n2) {
        if (n2 == 1) {
            this.mDSILogChannel.log(14808325, "MVResponseControl#updateTemperatureScale(): temperatureScale = %1", (long)n);
        }
    }

    public int getCityModelMode() {
        return this.mCityModelMode;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("mReady = ").append(this.mReady).append("\n");
        buffer.append("mCurrentViewType = ").append(this.mCurrentViewType).append("\n");
        buffer.append("mDayNightView = ").append(this.mDayNightView).append("\n");
        buffer.append("mViewScreenViewPort = ").append(this.mViewScreenViewPort).append("\n");
        buffer.append("mViewVisible = ").append(this.mViewVisible).append("\n");
        buffer.append("mViewFreeze = ").append(this.mViewFreeze).append("\n");
        buffer.append("mZoomList = ").append(this.mZoomList).append("\n");
        buffer.append("mZoomListIndex = ").append(this.mZoomListIndex).append("\n");
        buffer.append("mMapRotation = ").append(this.mMapRotation).append("\n");
        buffer.append("mMapPosition = ").append(this.mMapPosition).append("\n");
        buffer.append("mMapOrientation = ").append(this.mMapOrientation).append("\n");
        buffer.append("mCarPosition = ").append(this.mCarPosition).append("\n");
        buffer.append("mMapMode = ").append(this.mMapMode).append("\n");
        buffer.append("mViewPort = ").append(this.mViewPort).append("\n");
        buffer.append("mTmcVisible = ").append(this.mTmcVisible).append("\n");
        buffer.append("mSoftJumpEnabled = ").append(this.mSoftJumpEnabled).append("\n");
        buffer.append("mSoftRotationEnabled = ").append(this.mSoftRotationEnabled).append("\n");
        buffer.append("mSoftTiltEnabled = ").append(this.mSoftTiltEnabled).append("\n");
        buffer.append("mSoftZoomEnabled = ").append(this.mSoftZoomEnabled).append("\n");
        buffer.append("mAvailableRoutes = ").append(this.mAvailableRoutes).append("\n");
        buffer.append("mInfoList = ").append(this.mInfoList).append("\n");
        buffer.append("mFlags = ").append(this.mFlags).append("\n");
        buffer.append("mRouteCalcModeEnabled = ").append(this.mRouteCalcModeEnabled).append("\n");
        buffer.append("mSatelliteDataVisible = ").append(this.mSatelliteDataVisible).append("\n");
        buffer.append("mMapViewerRunLevel = ").append(this.mMapViewerRunLevel).append("\n");
        buffer.append("mMapViewerSuspensionAndWakeUpProgress = ").append(this.mMapViewerSuspensionAndWakeUpProgress).append("\n");
        buffer.append("mMapViewerSuspensionSupported = ").append(this.mMapViewerSuspensionSupported).append("\n");
        buffer.append("mMapPersonalDest = ").append(this.mMapPersonalDest).append("\n");
        buffer.append("mHorizonMarkerVisible = ").append(this.mHorizonMarkerVisible).append("\n");
        return buffer.toString();
    }

    @Override
    public void updateSpeedAndFlowRoadClass(int n, int n2) {
        this.mDSILogChannel.log(-2137614336, "MVResponseControl#updateSpeedAndFlowRoadClass, roadClass is: ( %1 ), validFlag is: (2%)", (long)n, (long)n2);
    }

    @Override
    public void updateRouteVisibility(boolean bl, int n) {
    }

    private MVRequestZoomEngine getMVRequestZoomEngine() {
        return this.naviMap.getMVRequest().getMVRequestZoomEngine();
    }

    @Override
    public void updateSoftAnimationSpeed(int n, int n2) {
    }

    @Override
    public void updateMapStyle(int n, int n2) {
        if (n2 == 1) {
            this.mDSILogChannel.log(-2137614336, "MVResponseControl#updateMapStyle( ) - [%1]", (long)n);
            this.naviMap.getMapManager().getSatelliteMapsMediator().updateMapStyle(this.mInstanceID, n);
        }
    }
}

