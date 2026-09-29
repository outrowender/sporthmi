/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.audi.atip.hmi.drawerfocus.DrawerFocusUtil;
import de.audi.atip.hmi.event.KeyEvent;
import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.event.WheelButtonEvent;
import de.audi.atip.hmi.intercommunication.MapDynamicSidebarConstants;
import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.hmi.model.RangeModel;
import de.audi.atip.hmi.model.VirtualButtonModel;
import de.audi.atip.hmi.model.list.TiledListModelGUI;
import de.audi.atip.hmi.modelaccess.ButtonModelGUI;
import de.audi.atip.hmi.modelaccess.ChoiceModelGUI;
import de.audi.atip.hmi.modelaccess.RangeModelGUI;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.widgets.ModelStubController;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.AbstractDynamicSidebar;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.MapCrosshairController;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.MapDynamicSidebar$MapScrollHandler;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.MapDynamicSidebar$MapZoomHandler;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.MapDynamicSidebarSegment;
import de.esolutions.hmi.widgets.audi.evo.widgets.FocusCursorController;
import java.util.ArrayList;
import java.util.List;

public class MapDynamicSidebar
extends AbstractDynamicSidebar
implements MapDynamicSidebarConstants {
    protected static final int LABEL_WITH_LINEBREAK_ENABLED;
    protected MapDynamicSidebar$MapScrollHandler mapScroll;
    protected MapDynamicSidebar$MapZoomHandler mapZoom;
    protected static final boolean useWidgetMovement;
    protected static final int MODEL_SCREEN_CHOICE;
    protected static final int VALUE_GENERAL;
    protected static final int VALUE_BRIEFING;
    protected static final int STATUS_GENERAL;
    protected static final int STATUS_SCROLLING;
    protected static final int STATUS_STREETVIEW;
    protected static final int MODEL_STREETVIEW_VISIBLE;
    public static final int VALUE_VISIBLE;
    protected static final int MODEL_VIRTUAL_BUTTON;
    protected static final int MODEL_ZOOM_LEVELS;
    protected static final int MODEL_PINCH_ZOOM_RANGE;
    protected static final int MODEL_MAGNIFICATION_RANGE;
    protected static final int MODEL_CROSSHAIR_BUTTON;
    protected static final int AUTOZOOM_ACTIVE;
    protected int segment_STREETVIEW_PREVIEW_MAP;
    protected int segment_COMPASS;
    protected int segment_ROUTE_INFO;
    protected int segment_TRAFFIC;
    protected int segment_ZOOMLEVEL;
    protected int segment_MAP_SCROLLING;
    protected int segment_OK;
    protected int segment_ELEVATION;
    protected int segment_STREETVIEW_ZOOM;
    protected int segment_STREETVIEW_PAN;
    protected int segment_BOTTOM;
    protected MapCrosshairController mapCrosshair;
    protected int state = 0;
    protected int selectedSegmentIndexOnExitScrollingForToolbox;
    protected int selectedSegmentIndexOnExitScrollingForStreetView;
    protected int cachedStateForReinit;
    protected int stateOnExitScrolling;
    protected List modelStubs = new ArrayList(5);
    protected ChoiceModelGUI modelScreenChoice;
    protected ChoiceModelGUI modelStreetViewVisibleChoice;
    protected RangeModelGUI modelMagnificationRange;
    protected ButtonModelGUI modelCrosshairButton;
    protected boolean modelsSetUp = false;

    public MapDynamicSidebar() {
        this.mapZoom = new MapDynamicSidebar$MapZoomHandler();
        this.mapZoom.setParent(this);
        this.mapScroll = new MapDynamicSidebar$MapScrollHandler();
        this.mapScroll.setParent(this);
    }

    @Override
    public void add(AbstractWidget abstractWidget) {
        super.add(abstractWidget);
        if (abstractWidget instanceof FocusCursorController) {
            this.cursor = (FocusCursorController)abstractWidget;
            return;
        }
        if (abstractWidget instanceof ModelStubController) {
            this.modelStubs.add(abstractWidget);
            sideBarLogChannel.log(-2137614336, "MapDynamicSidebar#add ModelStub with modelID = %1", (long)abstractWidget.getModelID());
            return;
        }
    }

    protected void calculateSegmentIndices() {
        int n = this.segments.size();
        block13: for (int i2 = 0; i2 < n; ++i2) {
            MapDynamicSidebarSegment mapDynamicSidebarSegment = this.getMapSegment(i2);
            switch (mapDynamicSidebarSegment.getRole()) {
                case 0: {
                    this.segment_STREETVIEW_PREVIEW_MAP = i2;
                    continue block13;
                }
                case 1: {
                    this.segment_COMPASS = i2;
                    continue block13;
                }
                case 2: {
                    this.segment_ROUTE_INFO = i2;
                    continue block13;
                }
                case 3: {
                    this.segment_TRAFFIC = i2;
                    continue block13;
                }
                case 4: {
                    this.segment_ZOOMLEVEL = i2;
                    continue block13;
                }
                case 5: {
                    this.segment_MAP_SCROLLING = i2;
                    continue block13;
                }
                case 6: {
                    this.segment_OK = i2;
                    continue block13;
                }
                case 7: {
                    this.segment_ELEVATION = i2;
                    continue block13;
                }
                case 8: {
                    this.segment_STREETVIEW_ZOOM = i2;
                    continue block13;
                }
                case 9: {
                    this.segment_STREETVIEW_PAN = i2;
                    continue block13;
                }
                case 10: {
                    this.segment_BOTTOM = i2;
                    continue block13;
                }
                default: {
                    sideBarLogChannel.log(-1601830656, "MapDynamicSidebar#calculateSegmentIndices unknown role = %1", (long)mapDynamicSidebarSegment.getRole());
                }
            }
        }
    }

    protected void calculateInitialState() {
        sideBarLogChannel.log(-2137614336, "MapDynamicSidebar#calculateInitialState state = %1", (long)this.state);
        boolean bl = true;
        if (this.modelScreenChoice != null) {
            int n = this.modelScreenChoice.getValue();
            int n2 = this.modelScreenChoice.getStatus();
            if (n == 0) {
                if (n2 == 3) {
                    if (this.selectedSegmentIndexOnExitScrollingForToolbox != -1) {
                        this.selectedSegmentIndex = this.selectedSegmentIndexOnExitScrollingForToolbox;
                        this.enterState(2);
                        this.enterState(1);
                    }
                    int n3 = this.state;
                    if (this.cachedStateForReinit != -1) {
                        n3 = this.cachedStateForReinit;
                        this.enterState(2);
                        this.enterState(1);
                    }
                    switch (n3) {
                        case 1: {
                            this.setCursorPosition(this.selectedSegmentIndex);
                        }
                        case 2: 
                        case 4: {
                            this.enterState(n3);
                            break;
                        }
                        case 3: {
                            this.enterState(2);
                            break;
                        }
                        default: {
                            this.enterState(2);
                        }
                    }
                    bl = false;
                } else if (n2 == 4) {
                    if (this.selectedSegmentIndexOnExitScrollingForStreetView != -1) {
                        this.selectedSegmentIndex = this.selectedSegmentIndexOnExitScrollingForStreetView;
                        this.enterState(5);
                        this.enterState(6);
                    }
                    int n4 = this.state;
                    if (this.cachedStateForReinit != -1) {
                        n4 = this.cachedStateForReinit;
                        this.enterState(5);
                        this.enterState(6);
                    }
                    switch (n4) {
                        case 6: {
                            this.setCursorPosition(this.selectedSegmentIndex);
                        }
                        case 5: 
                        case 7: {
                            this.enterState(n4);
                            break;
                        }
                        default: {
                            this.enterState(5);
                        }
                    }
                    bl = false;
                }
            }
        }
        if (bl) {
            this.enterState(0);
        }
        sideBarLogChannel.log(-2137614336, "MapDynamicSidebar#calculateInitialState cursor visible: %1, cursor should render: %2", this.cursor.isVisible(), this.cursor.shouldRender());
    }

    @Override
    public void connected(InitializationContext initializationContext) {
        if (sideBarLogChannel.isDebug()) {
            sideBarLogChannel.log(-2137614336, "MapDynamicSidebar#connected sidebarOpened = %1", this.isOpen());
        }
        if (!this.isScale()) {
            sideBarLogChannel.log(-2137614336, "MapDynamicSidebar#connected Target is not MMI-Scale.");
            return;
        }
        super.connected(initializationContext);
        this.calculateSegmentIndices();
        if (!this.modelsSetUp) {
            this.initModelStubs();
            this.modelsSetUp = true;
        } else {
            this.mapZoom.updateZoomLevels();
            if (this.modelMagnificationRange != null) {
                this.mapZoom.updateZoomLevel(this.modelMagnificationRange.getValue(), false);
            }
        }
        this.calculateInitialState();
        this.storeSelectedSegmentForToolbox(-1);
        this.storeSelectedSegmentForStreetViewToolbox(-1);
    }

    @Override
    public void disconnecting() {
        sideBarLogChannel.log(-2137614336, "MapDynamicSidebar#disconnecting state = %1", (long)this.state);
        this.onExit(this.state);
        super.disconnecting();
    }

    protected void enterState(int n) {
        sideBarLogChannel.log(-2137614336, "MapDynamicSidebar#enterState state = %1, newState = %2", (long)this.state, (long)n);
        this.cachedStateForReinit = -1;
        this.onExit(this.state);
        this.onEnter(n);
        this.state = n;
    }

    public int getCurrentState() {
        return this.state;
    }

    public MapCrosshairController getMapCrosshair() {
        return this.mapCrosshair;
    }

    protected MapDynamicSidebarSegment getMapSegment(int n) {
        return (MapDynamicSidebarSegment)super.getSegment(n);
    }

    public int getZoomLevel() {
        return this.mapZoom.getZoomLevel();
    }

    @Override
    protected void handleFocusChanged(int n, int n2, int n3) {
        if (DrawerFocusUtil.isFocusLost(n) && this.state == 3) {
            this.enterState(2);
        }
    }

    protected void initModelStubs() {
        sideBarLogChannel.log(-2137614336, "MapDynamicSidebar#initModelStubs");
        int n = this.modelStubs.size();
        block9: for (int i2 = 0; i2 < n; ++i2) {
            ModelStubController modelStubController = (ModelStubController)this.modelStubs.get(i2);
            int n2 = modelStubController.getModelID();
            Object object = modelStubController.getModel();
            if (object == null) {
                sideBarLogChannel.log(10000, "MapDynamicSidebar#initModelStubs Model for id %1 is not set.", (long)n2);
                return;
            }
            switch (n2) {
                case 400448: {
                    this.mapScroll.setModel((VirtualButtonModel)object);
                    continue block9;
                }
                case 401133: {
                    this.mapZoom.setModel((TiledListModelGUI)object);
                    this.mapZoom.updateZoomLevels();
                    if (this.modelMagnificationRange == null) continue block9;
                    this.mapZoom.updateZoomLevel(this.modelMagnificationRange.getValue(), true);
                    continue block9;
                }
                case 400898: {
                    this.mapZoom.setModel((RangeModel)object);
                    this.mapZoom.updateZoomLevels();
                    continue block9;
                }
                case 401124: {
                    this.modelScreenChoice = (ChoiceModelGUI)object;
                    continue block9;
                }
                case 400824: {
                    this.modelStreetViewVisibleChoice = (ChoiceModelGUI)object;
                    continue block9;
                }
                case 400476: {
                    this.modelMagnificationRange = (RangeModelGUI)object;
                    this.mapZoom.updateZoomLevel(this.modelMagnificationRange.getValue(), true);
                    continue block9;
                }
                case 401004: {
                    this.modelCrosshairButton = (ButtonModelGUI)object;
                    continue block9;
                }
                default: {
                    sideBarLogChannel.log(-1601830656, "MapDynamicSidebar#initModelStubs unknown model id %1", (long)n2);
                }
            }
        }
    }

    protected boolean isStreetViewVisible() {
        if (this.modelStreetViewVisibleChoice != null) {
            return this.modelStreetViewVisibleChoice.getValue() == 1;
        }
        return false;
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        sideBarLogChannel.log(-2137614336, "MapDynamicSidebar#keyPressed evt = %1", (Object)keyEvent);
        super.keyPressed(keyEvent);
        int n = keyEvent.getKeyCode();
        block0 : switch (n) {
            case 15: {
                switch (this.state) {
                    case 2: {
                        this.enterState(1);
                        keyEvent.consume();
                        break block0;
                    }
                    case 4: {
                        this.enterState(1);
                        keyEvent.consume();
                        break block0;
                    }
                    case 1: {
                        if (this.modelCrosshairButton != null) {
                            this.modelCrosshairButton.keyPressed(n, this.terminal.getTerminalID());
                            this.modelCrosshairButton.keyTyped(n, this.terminal.getTerminalID());
                        } else {
                            sideBarLogChannel.log(10000, "MapDynamicSidebar#keyPressed Crosshair Button is null.");
                        }
                        keyEvent.consume();
                        break block0;
                    }
                    case 3: {
                        keyEvent.consume();
                        break block0;
                    }
                    case 5: 
                    case 7: {
                        this.enterState(6);
                        keyEvent.consume();
                        break block0;
                    }
                    case 6: {
                        if (this.modelCrosshairButton != null) {
                            this.modelCrosshairButton.keyPressed(n, this.terminal.getTerminalID());
                            this.modelCrosshairButton.keyTyped(n, this.terminal.getTerminalID());
                        }
                        keyEvent.consume();
                        break block0;
                    }
                }
                break;
            }
            case 17: {
                switch (this.state) {
                    case 2: {
                        this.enterState(3);
                        keyEvent.consume();
                        break block0;
                    }
                    case 1: {
                        int n2 = this.getActiveSegment();
                        if (n2 == this.segment_ZOOMLEVEL) {
                            this.enterState(4);
                            keyEvent.consume();
                            break block0;
                        }
                        if (n2 == this.segment_MAP_SCROLLING) {
                            this.enterState(2);
                            keyEvent.consume();
                            break block0;
                        }
                        if (n2 != this.segment_OK) break block0;
                        sideBarLogChannel.log(1078071040, "MapDynamicSidebar#keyPressed Event will be processed by virtual button NAV_MAP_CROSSHAIRS_EVENT_HANDLER_VIRTUAL_BUTTON segmentIndex == segment_OK state = %1", (long)this.state);
                        break block0;
                    }
                    case 5: 
                    case 7: {
                        break block0;
                    }
                    case 0: {
                        break block0;
                    }
                    case 6: {
                        int n3 = this.getActiveSegment();
                        if (n3 == this.segment_STREETVIEW_ZOOM) {
                            this.enterState(5);
                        } else if (n3 == this.segment_STREETVIEW_PAN) {
                            this.enterState(7);
                        }
                        keyEvent.consume();
                        break block0;
                    }
                }
                sideBarLogChannel.log(-1601830656, "MapDynamicSidebar#keyPressed unknown state = %1", (long)this.state);
                break;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        sideBarLogChannel.log(-2137614336, "MapDynamicSidebar#keyReleased evt = %1", (Object)keyEvent);
        super.keyReleased(keyEvent);
        int n = keyEvent.getKeyCode();
        switch (n) {
            case 17: {
                if (this.state != 3) break;
                this.enterState(2);
                keyEvent.consume();
                break;
            }
        }
    }

    @Override
    public void keyTurned(WheelButtonEvent wheelButtonEvent) {
        sideBarLogChannel.log(-2137614336, "MapDynamicSidebar#keyTurned state = %1", (long)this.state);
        switch (this.state) {
            case 1: 
            case 6: {
                this.listScrolling.keyTurned(wheelButtonEvent);
                break;
            }
            case 0: 
            case 4: 
            case 5: {
                this.mapZoom.keyTurned(wheelButtonEvent);
                break;
            }
            case 7: {
                this.mapScroll.keyTurnedInStreetView(wheelButtonEvent);
                break;
            }
            case 2: 
            case 3: {
                this.mapScroll.keyTurned(wheelButtonEvent);
                break;
            }
            default: {
                sideBarLogChannel.log(-1601830656, "MapDynamicSidebar#keyTurned unknown state = %1", (long)this.state);
            }
        }
        int n = wheelButtonEvent.getDirection();
        if (n == 1 || n == 0) {
            this.cursorHeightAtAnimationStart = this.cursor.getHeight();
            this.startPosition = this.listScrolling.getCurrentPosition();
            this.endPosition = this.listScrolling.getDestinationPosition();
            this.animationDistance = Math.abs(this.startPosition - this.endPosition);
        }
        super.keyTurned(wheelButtonEvent);
    }

    protected void onEnter(int n) {
        switch (n) {
            case 0: {
                sideBarLogChannel.log(-2137614336, "MapDynamicSidebar#onEnter Unlock elevation, traffic and route info");
                this.unlockInvisible(this.segment_TRAFFIC);
                this.unlockInvisible(this.segment_ROUTE_INFO);
                this.unlockInvisible(this.segment_ELEVATION);
                this.getMapSegment(this.segment_COMPASS).setEnabled(true);
                this.getMapSegment(this.segment_ZOOMLEVEL).setVisibleOnly(true);
                this.getMapSegment(this.segment_MAP_SCROLLING).setVisibleOnly(false);
                this.getMapSegment(this.segment_OK).setVisibleOnly(false);
                this.getMapSegment(this.segment_STREETVIEW_PAN).setVisibleOnly(false);
                this.getMapSegment(this.segment_STREETVIEW_ZOOM).setVisibleOnly(false);
                this.getMapSegment(this.segment_BOTTOM).setVisibleOnly(false);
                this.segmentVisibilityChanged();
                this.cursor.setEnabled(false);
                this.cursor.setVisible(false);
                this.cursor.setCompositesDirty(true);
                this.setMapCrosshairActive(false);
                this.setMapCrosshairMode(0);
                if (!this.isOpen()) break;
                this.sidebarClose();
                break;
            }
            case 1: {
                this.getMapSegment(this.segment_COMPASS).setEnabled(false);
                this.cursor.setVisible(true);
                this.cursor.setEnabled(true);
                this.cursor.setCompositesDirty(true);
                this.setMapCrosshairActive(false);
                this.setMapCrosshairMode(0);
                break;
            }
            case 2: {
                this.getMapSegment(this.segment_COMPASS).setEnabled(false);
                this.getMapSegment(this.segment_ZOOMLEVEL).setVisibleOnly(true);
                this.getMapSegment(this.segment_MAP_SCROLLING).setVisibleOnly(true);
                this.getMapSegment(this.segment_OK).setVisibleOnly(true);
                this.getMapSegment(this.segment_STREETVIEW_PAN).setVisibleOnly(false);
                this.getMapSegment(this.segment_STREETVIEW_ZOOM).setVisibleOnly(false);
                this.getMapSegment(this.segment_BOTTOM).setVisibleOnly(true);
                this.segmentVisibilityChanged();
                this.cursor.setEnabled(false);
                this.cursor.setVisible(true);
                this.cursor.setCompositesDirty(true);
                this.setCursorPosition(this.segment_MAP_SCROLLING);
                this.setMapCrosshairActive(true);
                this.setMapCrosshairMode(2);
                if (this.isOpen()) break;
                this.sidebarOpen();
                break;
            }
            case 3: {
                this.mapScroll.ddsPressed();
                this.setMapCrosshairMode(1);
                this.setMapCrosshairActive(true);
                break;
            }
            case 4: {
                this.getMapSegment(this.segment_COMPASS).setEnabled(false);
                this.getMapSegment(this.segment_ZOOMLEVEL).setVisibleOnly(true);
                this.getMapSegment(this.segment_MAP_SCROLLING).setVisibleOnly(true);
                this.getMapSegment(this.segment_OK).setVisibleOnly(true);
                this.getMapSegment(this.segment_STREETVIEW_ZOOM).setVisibleOnly(false);
                this.getMapSegment(this.segment_STREETVIEW_PAN).setVisibleOnly(false);
                this.getMapSegment(this.segment_BOTTOM).setVisibleOnly(true);
                this.segmentVisibilityChanged();
                this.setCursorPosition(this.segment_ZOOMLEVEL);
                this.cursor.setEnabled(false);
                this.cursor.setVisible(true);
                this.cursor.setCompositesDirty(true);
                this.setMapCrosshairActive(true);
                this.setMapCrosshairMode(0);
                break;
            }
            case 5: {
                this.getMapSegment(this.segment_ZOOMLEVEL).setVisibleOnly(false);
                this.getMapSegment(this.segment_MAP_SCROLLING).setVisibleOnly(false);
                this.getMapSegment(this.segment_OK).setVisibleOnly(false);
                this.getMapSegment(this.segment_STREETVIEW_ZOOM).setVisibleOnly(true);
                this.getMapSegment(this.segment_STREETVIEW_PAN).setVisibleOnly(true);
                this.getMapSegment(this.segment_BOTTOM).setVisibleOnly(true);
                this.segmentVisibilityChanged();
                this.cursor.setEnabled(false);
                this.cursor.setVisible(true);
                this.cursor.setCompositesDirty(true);
                this.setCursorPosition(this.segment_STREETVIEW_ZOOM);
                if (this.isOpen()) break;
                this.sidebarOpen();
                break;
            }
            case 6: {
                this.cursor.setEnabled(true);
                this.cursor.setVisible(true);
                this.cursor.setCompositesDirty(true);
                break;
            }
            case 7: {
                this.cursor.setEnabled(false);
                this.cursor.setVisible(true);
                this.cursor.setCompositesDirty(true);
                this.setCursorPosition(this.segment_STREETVIEW_PAN);
                break;
            }
            default: {
                sideBarLogChannel.log(-1601830656, "MapDynamicSidebar#onEnter unknown state = %1", (long)n);
            }
        }
    }

    protected void unlockInvisible(int n) {
        MapDynamicSidebarSegment mapDynamicSidebarSegment = this.getMapSegment(n);
        if (mapDynamicSidebarSegment == null) {
            sideBarLogChannel.log(-1601830656, "MapDynamicSidebar#unlockInvisible segment with id: %1 is null", (long)n);
            return;
        }
        mapDynamicSidebarSegment.unlockVisibility();
    }

    protected void lockInvisible(int n) {
        MapDynamicSidebarSegment mapDynamicSidebarSegment = this.getMapSegment(n);
        if (mapDynamicSidebarSegment == null) {
            sideBarLogChannel.log(-1601830656, "MapDynamicSidebar#lockInvisible segment with id: %1 is null", (long)n);
            return;
        }
        if (mapDynamicSidebarSegment.isVisibilityLocked()) {
            mapDynamicSidebarSegment.unlockVisibility();
        }
        boolean bl = mapDynamicSidebarSegment.isVisible();
        mapDynamicSidebarSegment.setVisibleOnly(false);
        mapDynamicSidebarSegment.lockVisibility();
        mapDynamicSidebarSegment.setVisibleOnly(bl);
    }

    protected void onExit(int n) {
        switch (n) {
            case 0: {
                sideBarLogChannel.log(-2137614336, "MapDynamicSidebar#onExit elevation, lock traffic and route info");
                this.lockInvisible(this.segment_TRAFFIC);
                this.lockInvisible(this.segment_ROUTE_INFO);
                this.lockInvisible(this.segment_ELEVATION);
                break;
            }
            case 1: 
            case 2: {
                break;
            }
            case 3: {
                this.mapScroll.ddsReleased();
                break;
            }
            case 4: 
            case 5: 
            case 6: 
            case 7: {
                break;
            }
            default: {
                sideBarLogChannel.log(-1601830656, "MapDynamicSidebar#onExit unknown state = %1", (long)n);
            }
        }
    }

    @Override
    public void processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
        sideBarLogChannel.log(-2137614336, "MapDynamicSidebar#processModelUpdateEvent Received update from model %1", (Object)modelUpdateEvent);
        if (!this.isConnected()) {
            return;
        }
        if (!this.isScale()) {
            return;
        }
        HMIModel hMIModel = hmiService.getModel(modelUpdateEvent.getModelId());
        block0 : switch (modelUpdateEvent.getModelId()) {
            case 401124: {
                ChoiceModelGUI choiceModelGUI = (ChoiceModelGUI)((Object)hMIModel);
                int n = choiceModelGUI.getValue();
                int n2 = choiceModelGUI.getStatus();
                switch (this.state) {
                    case 0: {
                        if (n != 0 || n2 != 3) break block0;
                        this.enterState(2);
                        break;
                    }
                    case 1: {
                        if (n != 0 || n2 != 0) break block0;
                        this.storeSelectedSegmentForToolbox(this.getActiveSegment());
                        this.enterState(0);
                        break;
                    }
                    case 6: {
                        if (n != 0 || n2 != 0) break block0;
                        this.storeSelectedSegmentForStreetViewToolbox(this.getActiveSegment());
                        this.enterState(0);
                        break;
                    }
                    default: {
                        if (n != 0 || n2 != 0) break block0;
                        int n3 = this.state;
                        this.enterState(0);
                        this.storeCachedStateForReinit(n3);
                        break;
                    }
                }
                break;
            }
            case 400824: {
                ChoiceModelGUI choiceModelGUI = (ChoiceModelGUI)((Object)hMIModel);
                int n = choiceModelGUI.getValue();
                if (n == 1) {
                    switch (this.state) {
                        case 4: {
                            this.enterState(5);
                            break block0;
                        }
                    }
                    break;
                }
                if (this.modelMagnificationRange != null) {
                    this.mapZoom.setZoomLevelNoModelWrite(this.modelMagnificationRange.getValue());
                } else {
                    sideBarLogChannel.log(10000, "MapDynamicSidebar#processModelUpdateEvent Magnification range model is not set.");
                }
                switch (this.state) {
                    case 5: 
                    case 6: 
                    case 7: {
                        this.enterState(4);
                        break block0;
                    }
                }
                break;
            }
            case 401133: {
                this.mapZoom.updateZoomLevels();
                break;
            }
            case 400476: {
                this.mapZoom.updateZoomLevel(this.modelMagnificationRange.getValue(), false);
                break;
            }
            default: {
                sideBarLogChannel.log(-2137614336, "MapDynamicSidebar#processModelUpdateEvent Received update from unknown model %1", (Object)modelUpdateEvent);
            }
        }
    }

    public void setMapCrosshair(MapCrosshairController mapCrosshairController) {
        this.mapCrosshair = mapCrosshairController;
    }

    protected void setMapCrosshairActive(boolean bl) {
        if (this.mapCrosshair != null) {
            this.mapCrosshair.setCrosshairActive(bl);
        }
    }

    protected void setMapCrosshairMode(int n) {
        if (this.mapCrosshair != null) {
            this.mapCrosshair.setCurrentCrosshairMode(n);
        }
    }

    @Override
    protected void sidebarOpen() {
        super.sidebarOpen();
        this.storeSelectedSegmentForToolbox(-1);
        this.storeSelectedSegmentForStreetViewToolbox(-1);
    }

    protected void storeSelectedSegmentForStreetViewToolbox(int n) {
        sideBarLogChannel.log(-2137614336, "MapDynamicSidebar#storeSelectedSegmentForStreetViewToolbox selectedIndex = %1", (long)n);
        this.selectedSegmentIndexOnExitScrollingForStreetView = n;
    }

    protected void storeSelectedSegmentForToolbox(int n) {
        sideBarLogChannel.log(-2137614336, "MapDynamicSidebar#storeSelectedSegmentForToolbox selectedIndex = %1", (long)n);
        this.selectedSegmentIndexOnExitScrollingForToolbox = n;
    }

    protected void storeCachedStateForReinit(int n) {
        sideBarLogChannel.log(-2137614336, "MapDynamicSidebar#storeCachedStateForReinit reinitState = %1", (long)n);
        this.cachedStateForReinit = n;
    }
}

