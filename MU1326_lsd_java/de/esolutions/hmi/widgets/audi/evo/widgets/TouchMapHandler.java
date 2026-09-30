/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.hmi.drawerfocus.DrawerFocusUtil;
import de.audi.atip.hmi.event.ATIPEvent;
import de.audi.atip.hmi.event.ATIPEventListener;
import de.audi.atip.hmi.event.JoystickEvent;
import de.audi.atip.hmi.event.KeyEvent;
import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.event.TimerEvent;
import de.audi.atip.hmi.event.TouchEvent;
import de.audi.atip.hmi.event.WheelButtonEvent;
import de.audi.atip.hmi.model.RangeModel;
import de.audi.atip.hmi.model.list.GuiListRow;
import de.audi.atip.hmi.model.list.TiledListModelGUI;
import de.audi.atip.hmi.modelaccess.ChoiceModelGUI;
import de.audi.atip.hmi.modelaccess.RangeModelGUI;
import de.audi.atip.hmi.modelaccess.VirtualButtonModelGUI;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.job.Job;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.base.widgets.ModelStubController;
import de.esolutions.hmi.widgets.audi.evo.widgets.IViewSizeAnimatable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TouchMapHandler
extends AbstractWidgetController
implements ATIPEventListener,
IViewSizeAnimatable {
    private static final int MINIMUM_DISTANCE_FOR_MOVEMENT_TW = 3844;
    private static final int MINIMUM_DISTANCE_FOR_MOVEMENT_AIT = 961;
    private static final int ZOOM_CONSTANT_TW = 20;
    private static final int ZOOM_CONSTANT_AIT = 12;
    public static TouchMapHandler singleton;
    private static final float CONST1 = 1.4285715f;
    private static final int KEYPANEL_TW_2014 = 1;
    private static final int KEYPANEL_AIT_2014 = 2;
    private static final int AUTOZOOM_ACTIVE = 1;
    private static final long PHYSICS_TIME = 50L;
    private static final long ACCUMULATION_TIME = 50L;
    public static int vectorLengthMinimumTw;
    public static int vectorLengthMinimumAit;
    private static final float DELTA_COORDINATES_FACTOR_TW = 0.55f;
    private static final float DELTA_COORDINATES_FACTOR_AIT = 1.5f;
    private static final float SPEED_THRESHOLD_AIT = 120.0f;
    public static float maxDecelerationSpeedThresholdAit;
    public static float maxDecelerationSpeedThreshold2Ait;
    public static float maxDecelerationSpeedThresholdTw;
    public static float maxDecelerationSpeedThreshold2Tw;
    public static float speedDecelerationFactorAit;
    public static float speedDecelerationFactor2Ait;
    public static float speedDecelerationFactorTw;
    public static float speedDecelerationFactor2Tw;
    public static float pixelPerLevelCurrentLevelDependence;
    public static final float PIXEL_PER_LEVEL_CURRENT_LEVEL_DEPENDENCE_AIT = 10.0f;
    public static float pixelPerLevelFactor;
    public static final float PIXEL_PER_LEVEL_FACTOR_AIT = 6.0f;
    public static boolean pixelPerLevelZoomLevelDependenceActive;
    public static int pixelPerLevelAit;
    public static int pixelPerLevelTw;
    public static float maximumPinchMoveSpeedDifferenceTw;
    private static final int PINCH_ZOOM_GESTURE_RELEASED_TIMEOUT = 100;
    public static int f2f1ChangeTimeout;
    public static int ddsPressedTimeout;
    private static final short PINCH_MOVE_UNDECIDED = 0;
    private static final short PINCH_MOVE_MOVE = 1;
    private static final short PINCH_MOVE_PINCH = 2;
    private static final short PINCH_MOVE_MOVE_AND_PINCH = 3;
    private static final short PINCH_MOVE_PINCH_1F = 4;
    public static int lowerMoveThresholdTw;
    public static int upperMoveThresholdTw;
    private static final int LOWER_PINCH_THRESHOLD_TW = 3;
    private static final int UPPER_PINCH_THRESHOLD_TW = 8;
    private static final int LOWER_MOVE_THRESHOLD_AIT = 15;
    private static final int UPPER_MOVE_THRESHOLD_AIT = 25;
    public static float lowerPinchThresholdAit;
    public static float upperPinchThresholdAit;
    public static final float MAP_PANNING_DECELERATION_FACTOR_FOR_STREET_VIEW_X = 0.6f;
    public static final float MAP_PANNING_DECELERATION_FACTOR_FOR_STREET_VIEW_Y = 0.8f;
    public static float decelerationFactor;
    public static float decelerationFactorTw;
    private Job physicsTimer = null;
    private TimerEvent timerEvent = null;
    private int lastMoveActionTime = 0;
    private Job dataUpdateDelayTimer = null;
    private TimerEvent dataUpdateDelayEvent = null;
    private static final long DATA_UPDATE_TIMEOUT = 300L;
    private int deltaX = 0;
    private int deltaY = 0;
    private int previousXCoordinate = 0;
    private int previousYCoordinate = 0;
    private int previousDistance = 0;
    private short pinchMoveMode = 0;
    private int xSumAbs;
    private int ySumAbs;
    private float scalarSumFeature;
    public static float scalarSumThreshold;
    private float[] prevDirection = new float[2];
    private boolean prevDirectionValid;
    public static final int BUFFER_SIZE = 10;
    private List innerProductBuffer = new ArrayList(10);
    private int fingersOnTP = 0;
    private boolean physicStarted = false;
    private int scrollMode = 1;
    private int[] ringEventBuffer = new int[6];
    private int ringBufferIndex = 0;
    private int keypanelType = 2;
    private int fingerDistance = 0;
    private int fingerDistanceSum = 0;
    private int initialFingerDistance = 0;
    private int currentZoomLevel = 3000;
    private int zoomLevelAfterTPReleased = -1;
    private int zoomLevelIndexAfterTPReleased = -1;
    private boolean softZoomEnabled = true;
    private static final long LAST_TURN_EVENT_TIMEOUT = 400L;
    private Job turnEventTimer = null;
    private TimerEvent turnTimeoutEvent = null;
    private int zoomLevelIndex = 0;
    private int initialZoomLevelIndex = 0;
    private float pinchZoomTargetLevelIndex;
    private RangeModelGUI pinchZoomRangeModel = null;
    private ChoiceModelGUI topBarVisibleModel = null;
    private ChoiceModelGUI streetViewVisibleModel = null;
    private ChoiceModelGUI routeGuidanceActiveModel = null;
    private ChoiceModelGUI mapScreenChoiceModel = null;
    private ChoiceModelGUI routeCalculatingPrepare = null;
    private static final int KEY_TURNED_DELTA_TIME = 5000;
    private long zoomLevelReadTimestamp = 0L;
    public static final int MODEL_ZOOM_LIST = 0;
    public static final int MODEL_MAGNIFICATION_RANGE = 1;
    public static final int MODEL_STREET_VIEW_VISIBLE = 2;
    private int[] modelStubIDs = new int[]{-1, -1, -1};
    private int[] zoomLevels = null;
    private int storedZoomLevelIndex;
    private int storedMagnificationValue;
    private long timeStamp2fPinchZoomGestureReleased;
    private long timeStampDDSPressed;
    private long timeStamp2FingerChangeTo1Finger;
    private boolean ignoreInitialFingerDistance = true;
    private static final int MOVE_DISTANCE_HISTORY_LENGTH = 5;
    private float[] distanceHistory = new float[5];
    private boolean[] fingerLiftDetected = new boolean[4];
    private boolean fingerLiftDetectionActive = true;
    private boolean fingerLiftDetectionResetDeltasOnly = false;

    public IRenderer getRenderer() {
        return null;
    }

    public void initializeWidget() {
        super.initializeWidget();
        this.initializeModelReferences();
        this.updateZoomLevels();
        if (this.terminal.getKbdService() != null) {
            switch (this.terminal.getKbdService().getCurrentKeyboardType()) {
                case 6: {
                    this.keypanelType = 2;
                    break;
                }
                case 5: {
                    this.keypanelType = 1;
                    break;
                }
                case 15: {
                    this.keypanelType = 1;
                    break;
                }
                default: {
                    this.keypanelType = 1;
                }
            }
            tpLogChannelKeypanel.log(10000000, "TouchMapHandler#initializeWidget keypanel type = %1", (long)this.keypanelType);
        } else {
            this.keypanelType = 1;
        }
        this.setRecognizerModeMIB2Gestures();
        this.zoomLevelReadTimestamp = 0L;
    }

    private boolean isRouteBriefing() {
        return this.mapScreenChoiceModel != null && this.mapScreenChoiceModel.getValue() == 1;
    }

    private boolean isCalculatingPrepareBusy() {
        return this.routeCalculatingPrepare != null && this.routeCalculatingPrepare.getValue() != 0;
    }

    private boolean isRouteGuidanceActive() {
        return this.routeGuidanceActiveModel != null && this.routeGuidanceActiveModel.getValue() == 2;
    }

    public void disconnecting() {
        super.disconnecting();
        this.cancelPhysicsTimer();
        this.physicsTimer = null;
        this.timerEvent = null;
        this.storedZoomLevelIndex = 0;
        this.storedMagnificationValue = 0;
        this.resetDeltas();
    }

    public void touchPadPressed(TouchEvent touchEvent) {
        this.scrollMode = this.fingersOnTP = touchEvent.getFingerCount();
        this.updateZoomLevel();
        this.cancelPhysicsTimer();
        this.cancelDataUpdateDelayTimer();
        this.clearRingBuffer();
        this.previousXCoordinate = touchEvent.getX();
        this.previousYCoordinate = touchEvent.getY();
        this.xSumAbs = 0;
        this.ySumAbs = 0;
        this.previousDistance = 0;
        this.pinchMoveMode = 1;
        this.scalarSumFeature = 0.0f;
        this.innerProductBuffer.clear();
        this.prevDirectionValid = false;
        tpLogChannelKeypanel.log(10000000, "TouchMapHandler#touchPadPressed x: %1 y: %2 fingerCount: %3", (long)this.previousXCoordinate, (long)this.previousYCoordinate, (long)this.fingersOnTP);
    }

    public void touchPadReleased(TouchEvent touchEvent) {
        this.touchPadReleased(touchEvent.getDeltaTime());
    }

    private void touchPadReleased(int n) {
        tpLogChannelKeypanel.log(10000000, "TouchMapHandler#touchPadReleased");
        this.touchPadReleasedInternal(n);
        this.resetFingerLift();
        this.resetDistanceHistory();
    }

    private void touchPadReleasedInternal(int n) {
        this.fingersOnTP = 0;
        this.fingerDistanceSum = 0;
        this.fingerDistance = 0;
        this.refreshInitialLevel();
        int n2 = this.lastMoveActionTime + n;
        tpLogChannelKeypanel.log(10000000, "TouchMapHandler#touchPadReleasedInternal lastMoveActionTime: %1 fingerSteadyTime: %2", (long)this.lastMoveActionTime, (long)n2);
        int n3 = this.getSquaredVectorLength(this.deltaX, this.deltaY);
        if (n3 > this.getMinimumVectorLength() && n2 < 60) {
            if (this.isFingerLiftDetected()) {
                this.resetDeltas();
                tpLogChannelKeypanel.log(10000000, "TouchMapHandler#touchPadReleasedInternal Do not start physics timer because finger lift was detected.");
                return;
            }
            if (this.isStreetViewVisible()) {
                tpLogChannelKeypanel.log(10000000, "TouchMapHandler#touchPadReleasedInternal Do not start physics timer because street view is visible.");
                return;
            }
            this.restartPhysicsTimer();
            this.physicStarted = true;
        } else {
            if (framework.getMonotonicTime() - this.timeStampDDSPressed < (long)ddsPressedTimeout) {
                tpLogChannelKeypanel.log(10000000, "TouchMapHandler#touchPadReleasedInternal Do not start data update timer. Ignore tp movements after DDS pressed.");
                return;
            }
            this.restartDataUpdateDelayTimer();
        }
    }

    public void touchPadApproached(TouchEvent touchEvent) {
        tpLogChannelKeypanel.log(10000000, "TouchMapHandler#touchPadApproached code = %1", (long)touchEvent.getCode());
    }

    public void touchPadAbandoned(TouchEvent touchEvent) {
        tpLogChannelKeypanel.log(10000000, "TouchMapHandler#touchPadAbandoned code = %1", (long)touchEvent.getCode());
    }

    private void addToRingBuffer(int n, int n2) {
        this.ringEventBuffer[this.ringBufferIndex] = n;
        this.ringEventBuffer[this.ringBufferIndex + 1] = n2;
        this.ringBufferIndex += 2;
        if (this.ringBufferIndex >= this.ringEventBuffer.length) {
            this.ringBufferIndex = 0;
        }
    }

    private int getAverageVector(boolean bl) {
        int n = 0;
        if (!bl) {
            n = 1;
        }
        int n2 = 0;
        int n3 = 0;
        for (int i2 = 0; i2 < this.ringEventBuffer.length; i2 += 2) {
            if (this.ringEventBuffer[i2 + n] == 0) continue;
            n3 += this.ringEventBuffer[i2 + n];
            ++n2;
        }
        if (tpLogChannelKeypanel.isDebug()) {
            Buffer buffer = new Buffer(10);
            for (int i3 = 0; i3 < this.ringEventBuffer.length; ++i3) {
                buffer.append(this.ringEventBuffer[i3]);
                buffer.append(';');
            }
            tpLogChannelKeypanel.log(10000000, "TouchMapHandler#getAverageVector ringBufferContent: %1", (Object)buffer);
        }
        if (n2 == 0) {
            tpLogChannelKeypanel.log(10000000, "TouchMapHandler#getAverageVector return 0");
            return 0;
        }
        tpLogChannelKeypanel.log(10000000, "TouchMapHandler#getAverageVector sum/divisor: %1", (long)(n3 / n2));
        return n3 / n2;
    }

    private void clearRingBuffer() {
        for (int i2 = 0; i2 < this.ringEventBuffer.length; ++i2) {
            this.ringEventBuffer[i2] = 0;
        }
        this.ringBufferIndex = 0;
    }

    float norm(float f2, float f3) {
        return (float)Math.sqrt(f2 * f2 + f3 * f3);
    }

    public void touchPadPositionMoved(TouchEvent touchEvent) {
        int n = touchEvent.getX() - this.previousXCoordinate;
        int n2 = touchEvent.getY() - this.previousYCoordinate;
        this.xSumAbs += Math.abs(n);
        this.ySumAbs += Math.abs(n2);
        if (this.keypanelType == 2) {
            this.calculateScalarSumFeature(n, n2);
        }
        int n3 = this.getSquaredVectorLength(this.xSumAbs, this.ySumAbs);
        if (this.fingersOnTP > 1 || !this.ignoreInitialFingerDistance || n3 >= this.getMinimumDistanceForMovement()) {
            if (framework.getMonotonicTime() - this.timeStampDDSPressed < (long)ddsPressedTimeout) {
                tpLogChannelKeypanel.log(10000000, "TouchMapHandler#touchPadPositionMoved Ignore tp movements after DDS pressed.");
                return;
            }
            if (this.isCrosshairMapActive() || this.isSemidynRGActive()) {
                int n4 = this.fingersOnTP;
                this.fingersOnTP = touchEvent.getFingerCount();
                tpLogChannelKeypanel.log(10000000, "TouchMapHandler#touchPadPositionMoved fingerCount: %1", (long)this.fingersOnTP);
                if (this.fingersOnTP == 0) {
                    this.touchPadReleasedInternal(touchEvent.getDeltaTime());
                } else {
                    this.cancelPhysicsTimer();
                    this.processMapPanning(touchEvent, n4);
                }
            } else {
                tpLogChannelKeypanel.log(10000000, "TouchMapHandler#touchPadPositionMoved cross hair mode is not active, ignore map panning events");
            }
        } else {
            tpLogChannelKeypanel.log(10000000, "TouchMapHandler#touchPadPositionMoved Ignore tp moved events below 3mm (distance = %1)", (long)n3);
        }
        tpLogChannelKeypanel.log(10000000, "TouchMapHandler#touchPadPositionMoved Finger distance = %1.", (long)touchEvent.getDistance());
        this.previousXCoordinate = touchEvent.getX();
        this.previousYCoordinate = touchEvent.getY();
        this.previousDistance = (int)this.getFingerDistance(touchEvent.getDistance());
    }

    private boolean isSemidynRGActive() {
        return this.mapScreenChoiceModel != null && this.mapScreenChoiceModel.getValue() == 0 && this.mapScreenChoiceModel.getStatus() == 1;
    }

    private boolean isCrosshairMapActive() {
        return this.topBarVisibleModel.getValue() == 1;
    }

    private boolean isLowestZoomLevel() {
        return this.currentZoomLevel == this.zoomLevels[0];
    }

    private boolean isStreetViewVisible() {
        if (this.streetViewVisibleModel != null) {
            return this.streetViewVisibleModel.getValue() == 1;
        }
        return false;
    }

    private void processMapPanning(TouchEvent touchEvent, int n) {
        float f2 = 0.0f;
        float f3 = 0.0f;
        tpLogChannelKeypanel.log(10000000, "TouchMapHandler#processMapPanning X = %1, Y = %2", (long)touchEvent.getX(), (long)touchEvent.getY());
        if (n == this.fingersOnTP) {
            f2 = this.calculateCenterPointSpeed(touchEvent);
            f3 = this.calculatePinchSpeed(touchEvent);
            tpLogChannelKeypanel.log(10000000, "TouchMapHandler#processMapPanning centerPointSpeed: %1, pinchSpeed: %2", (double)f2, (double)f3, 0.0);
        } else if (n > this.fingersOnTP) {
            if (this.pinchMoveMode == 2 || this.pinchMoveMode == 4) {
                this.timeStamp2fPinchZoomGestureReleased = framework.getMonotonicTime();
            }
            this.timeStamp2FingerChangeTo1Finger = framework.getMonotonicTime();
            tpLogChannelInternal.log(10000000, "TouchMapHandler#processMapPanning Number of fingers changed from %1 to %2.", (long)n, (long)this.fingersOnTP);
            this.refreshInitialLevel();
            this.fingerDistance = 0;
        }
        switch (this.keypanelType) {
            case 1: {
                this.mapPanningTw(touchEvent, n, f2, f3);
                break;
            }
            case 2: {
                this.mapPanningAit(touchEvent, n, f2, f3);
                break;
            }
            default: {
                this.processMapPanningAiT(touchEvent, n);
            }
        }
        tpLogChannelInternal.log(10000000, "TouchMapHandler#processMapPanning pinchMoveMode = %1", (long)this.pinchMoveMode);
    }

    private void mapPanningAit(TouchEvent touchEvent, int n, float f2, float f3) {
        float f4 = this.getScalarSumFeature();
        if (this.pinchMoveMode == 0) {
            if (f3 > upperPinchThresholdAit) {
                if (f2 < 15.0f) {
                    this.pinchMoveMode = (short)2;
                } else if (f2 > 25.0f) {
                    this.pinchMoveMode = (short)3;
                }
            } else if (f2 > 25.0f) {
                this.pinchMoveMode = 1;
            }
            if (this.pinchMoveMode == 0) {
                if (Math.abs(f2 - f3) < Math.min(0.2f * f2, maximumPinchMoveSpeedDifferenceTw)) {
                    this.pinchMoveMode = (short)4;
                } else if (f4 >= scalarSumThreshold) {
                    this.pinchMoveMode = 1;
                }
            }
        } else if (this.pinchMoveMode == 1) {
            if (f2 < 15.0f && f3 > upperPinchThresholdAit) {
                this.pinchMoveMode = (short)2;
            } else if (this.undecidedAITCondition(touchEvent, f2, f3) && !(f4 >= scalarSumThreshold)) {
                this.pinchMoveMode = 0;
            } else if (f2 > 25.0f && f3 > upperPinchThresholdAit) {
                this.pinchMoveMode = (short)3;
            }
            this.fingerDistanceSum = 0;
        } else if (this.pinchMoveMode == 2) {
            if (f2 > 25.0f && f3 < lowerPinchThresholdAit) {
                this.pinchMoveMode = 1;
            } else if (this.undecidedAITCondition(touchEvent, f2, f3)) {
                this.pinchMoveMode = 0;
            } else if (f2 > 25.0f && f3 > upperPinchThresholdAit) {
                this.pinchMoveMode = (short)3;
            }
        } else if (this.pinchMoveMode == 4) {
            if (f3 < 1.0f && f2 < 1.0f) {
                this.pinchMoveMode = 0;
            }
        } else if (f2 > 25.0f && f3 < lowerPinchThresholdAit) {
            this.pinchMoveMode = 1;
        } else if (f2 < 15.0f && f3 > upperPinchThresholdAit) {
            this.pinchMoveMode = (short)2;
        } else if (this.undecidedAITCondition(touchEvent, f2, f3)) {
            this.pinchMoveMode = 0;
        }
        if (this.pinchMoveMode == 0 && this.fingersOnTP == 1 || this.pinchMoveMode == 1 || this.fingersOnTP == 1) {
            this.processMapPanningAiT(touchEvent, n);
        }
        if (this.pinchMoveMode == 2 || this.pinchMoveMode == 4 || this.pinchMoveMode == 3) {
            this.processZoomGesture(touchEvent);
        }
    }

    private void mapPanningTw(TouchEvent touchEvent, int n, float f2, float f3) {
        if (this.pinchMoveMode == 0) {
            if (f3 > 8.0f) {
                if (f2 < (float)lowerMoveThresholdTw) {
                    this.pinchMoveMode = (short)2;
                }
            } else if (f2 > (float)upperMoveThresholdTw) {
                this.pinchMoveMode = 1;
            }
            if (this.pinchMoveMode == 0 && Math.abs(f2 - f3) < Math.min(0.2f * f2, maximumPinchMoveSpeedDifferenceTw)) {
                this.pinchMoveMode = (short)4;
            }
        } else if (this.pinchMoveMode == 1) {
            if (f2 < (float)lowerMoveThresholdTw && f3 > 8.0f) {
                this.pinchMoveMode = (short)2;
            } else if (this.undecidedTWCondition(touchEvent, f2, f3)) {
                this.pinchMoveMode = 0;
            }
            this.fingerDistanceSum = 0;
        } else if (this.pinchMoveMode == 4) {
            if (f3 < 1.0f && f2 < 1.0f) {
                this.pinchMoveMode = 0;
            } else if (f2 > (float)upperMoveThresholdTw && f3 < 3.0f) {
                this.pinchMoveMode = 1;
            }
        } else if (f2 > (float)upperMoveThresholdTw && f3 < 3.0f) {
            this.pinchMoveMode = 1;
        } else if (this.undecidedTWCondition(touchEvent, f2, f3)) {
            this.pinchMoveMode = 0;
        }
        if (this.pinchMoveMode == 0 && this.fingersOnTP == 1 || this.pinchMoveMode == 1 || this.fingersOnTP == 1) {
            this.processMapPanningTT3(touchEvent, n);
        }
        if (this.pinchMoveMode == 2 || this.pinchMoveMode == 4) {
            this.processZoomGesture(touchEvent);
        }
    }

    private boolean undecidedTWCondition(TouchEvent touchEvent, float f2, float f3) {
        return (long)touchEvent.getDeltaTime() > 150L || f2 < 5.0f && f3 < 3.0f;
    }

    private boolean undecidedAITCondition(TouchEvent touchEvent, float f2, float f3) {
        return (long)touchEvent.getDeltaTime() > 150L || f2 < 5.0f && f3 < lowerPinchThresholdAit;
    }

    private float calculateCenterPointSpeed(TouchEvent touchEvent) {
        int n = touchEvent.getX();
        int n2 = touchEvent.getY();
        if (this.previousXCoordinate != Integer.MIN_VALUE) {
            int n3 = this.previousXCoordinate - n;
            int n4 = this.previousYCoordinate - n2;
            return this.calculateSpeed(n3, n4, touchEvent.getDeltaTime());
        }
        return 0.0f;
    }

    private float calculatePinchSpeed(TouchEvent touchEvent) {
        if (this.previousXCoordinate != Integer.MIN_VALUE) {
            int n = (int)((float)this.previousDistance - this.getFingerDistance(touchEvent.getDistance()));
            return this.calculateSpeed(n, 0, touchEvent.getDeltaTime());
        }
        return 0.0f;
    }

    private void processMapPanningAiT(TouchEvent touchEvent, int n) {
        if (this.model instanceof VirtualButtonModelGUI) {
            long l = framework.getMonotonicTime() - this.timeStamp2FingerChangeTo1Finger;
            if (this.scrollMode == 1 || l > (long)f2f1ChangeTimeout) {
                this.scrollMode = this.fingersOnTP;
            }
            if (this.fingersOnTP == 1 && framework.getMonotonicTime() - this.timeStamp2fPinchZoomGestureReleased < 100L) {
                tpLogChannelInternal.log(10000000, "TouchMapHandler#processMapPanningAiT No map panning after 2F released allowed.");
                return;
            }
            int n2 = touchEvent.getX();
            int n3 = touchEvent.getY();
            tpLogChannelKeypanel.log(10000000, "TouchMapHandler#processMapPanningAiT calling touchPadPositionMoved at virtual button model evtX: %1 evtY: %2", (long)n2, (long)n3);
            if (n == this.fingersOnTP) {
                if (this.previousXCoordinate != Integer.MIN_VALUE) {
                    this.deltaX = this.previousXCoordinate - n2;
                    this.deltaY = this.previousYCoordinate - n3;
                    VirtualButtonModelGUI virtualButtonModelGUI = (VirtualButtonModelGUI)this.model;
                    tpLogChannelKeypanel.log(10000000, "TouchMapHandler#processMapPanningAiT calling touchPadPositionMoved at virtual buton model deltaEvtX: %1 deltaEvtY: %2", (long)this.deltaX, (long)this.deltaY);
                    float f2 = this.calculateSpeed(this.deltaX, this.deltaY, touchEvent.getDeltaTime());
                    tpLogChannelKeypanel.log(10000000, "TouchMapHandler#processMapPanningAiT deltaX: %1, deltaY: %2, currentSpeed: %3", (double)this.deltaX, (double)this.deltaY, (double)f2);
                    if (f2 > 120.0f && !this.isStreetViewVisible()) {
                        this.deltaX = (int)((float)this.deltaX * 1.5f);
                        this.deltaY = (int)((float)this.deltaY * 1.5f);
                    } else if (f2 < maxDecelerationSpeedThreshold2Ait) {
                        this.deltaX = (int)((float)this.deltaX * speedDecelerationFactor2Ait);
                        this.deltaY = (int)((float)this.deltaY * speedDecelerationFactor2Ait);
                    } else if (f2 < maxDecelerationSpeedThresholdAit) {
                        this.deltaX = (int)((float)this.deltaX * speedDecelerationFactorAit);
                        this.deltaY = (int)((float)this.deltaY * speedDecelerationFactorAit);
                    }
                    if (this.isStreetViewVisible()) {
                        this.deltaX = (int)((float)this.deltaX * 0.6f);
                        this.deltaY = (int)((float)this.deltaY * 0.8f);
                    }
                    virtualButtonModelGUI.touchPadPositionMoved(this.scrollMode, 0, this.deltaX, this.deltaY, this.terminal.getTerminalID());
                    this.lastMoveActionTime = 0;
                    this.addToRingBuffer(this.deltaX, this.deltaY);
                }
            } else {
                tpLogChannelKeypanel.log(10000000, "TouchMapHandler#processMapPanningAiT do not move map, number of fingers has changed");
            }
            touchEvent.consume(false);
        }
    }

    private void processMapPanningTT3(TouchEvent touchEvent, int n) {
        if (this.model instanceof VirtualButtonModelGUI) {
            long l = framework.getMonotonicTime() - this.timeStamp2FingerChangeTo1Finger;
            if (this.scrollMode == 1 || l > (long)f2f1ChangeTimeout) {
                this.scrollMode = this.fingersOnTP;
                tpLogChannelKeypanel.log(10000000, "TouchMapHandler#processMapPanningTT3 switch scroll mode %1, time since finger change = %2", (long)this.scrollMode, l);
            }
            if (this.fingersOnTP == 1 && framework.getMonotonicTime() - this.timeStamp2fPinchZoomGestureReleased < 100L) {
                tpLogChannelInternal.log(10000000, "TouchMapHandler#processMapPanningAiT No map panning after 2F released allowed.");
                return;
            }
            int n2 = touchEvent.getX();
            int n3 = touchEvent.getY();
            tpLogChannelKeypanel.log(10000000, "TouchMapHandler#processMapPanningTT3 calling touchPadPositionMoved at virtual buton model evtX: %1 evtY: %2", (long)n2, (long)n3);
            if (n == this.fingersOnTP) {
                if (this.previousXCoordinate != Integer.MIN_VALUE) {
                    this.deltaX = this.previousXCoordinate - n2;
                    this.deltaY = this.previousYCoordinate - n3;
                    VirtualButtonModelGUI virtualButtonModelGUI = (VirtualButtonModelGUI)this.model;
                    tpLogChannelKeypanel.log(10000000, "TouchMapHandler#processMapPanningTT3 calling touchPadPositionMoved at virtual buton model deltaEvtX: %1 deltaEvtY: %2", (long)this.deltaX, (long)this.deltaY);
                    float f2 = this.calculateSpeed(this.deltaX, this.deltaY, touchEvent.getDeltaTime());
                    tpLogChannelKeypanel.log(10000000, "TouchMapHandler#processMapPanningTT3 deltaX: %1, deltaY: %2, currentSpeed: %3", (double)this.deltaX, (double)this.deltaY, (double)f2);
                    if (f2 < maxDecelerationSpeedThreshold2Tw) {
                        this.deltaX = (int)((float)this.deltaX * speedDecelerationFactor2Tw);
                        this.deltaY = (int)((float)this.deltaY * speedDecelerationFactor2Tw);
                    } else if (f2 < maxDecelerationSpeedThresholdTw) {
                        this.deltaX = (int)((float)this.deltaX * speedDecelerationFactorTw);
                        this.deltaY = (int)((float)this.deltaY * speedDecelerationFactorTw);
                    } else {
                        this.deltaX = (int)((float)this.deltaX * 0.55f);
                        this.deltaY = (int)((float)this.deltaY * 0.55f);
                    }
                    if (this.isStreetViewVisible()) {
                        this.deltaX = (int)((float)this.deltaX * 0.6f);
                        this.deltaY = (int)((float)this.deltaY * 0.8f);
                    }
                    if (this.fingerLiftDetectionActive && this.detectFingerLifting(touchEvent.getDeltaTime()) && !this.fingerLiftDetectionResetDeltasOnly) {
                        tpLogChannelInternal.log(10000000, "TouchMapHandler#processMapPanningTT3 Discard event.");
                        return;
                    }
                    virtualButtonModelGUI.touchPadPositionMoved(this.scrollMode, 0, this.deltaX, this.deltaY, this.terminal.getTerminalID());
                    this.lastMoveActionTime = 0;
                    this.addToRingBuffer(this.deltaX, this.deltaY);
                }
            } else {
                tpLogChannelKeypanel.log(10000000, "TouchMapHandler#processMapPanningTT3 do not move map, number of fingers has changed");
            }
            touchEvent.consume(false);
        }
    }

    private float calculateSpeed(int n, int n2, float f2) {
        int n3 = this.getSquaredVectorLength(n, n2);
        if (f2 > 0.0f) {
            return (float)n3 / f2;
        }
        return n3;
    }

    private int getSquaredVectorLength(int n, int n2) {
        return n * n + n2 * n2;
    }

    private void handlePinchZoom(int n, float f2) {
        if (this.isStreetViewVisible()) {
            return;
        }
        int n2 = 0;
        if (this.zoomLevelAfterTPReleased != -1) {
            n2 = this.zoomLevelAfterTPReleased - this.zoomLevels[this.initialZoomLevelIndex];
            tpLogChannelInternal.log(10000000, "TouchMapHandler#handlePinchZoom zoomLevelAfterTPReleased = %1, differenceToDiscreteZoomLevel = %1", (long)this.zoomLevelAfterTPReleased, (long)n2);
        }
        int n3 = n - this.initialFingerDistance;
        int n4 = Math.abs(n3);
        float f3 = (float)n4 / f2;
        tpLogChannelInternal.log(10000000, "TouchMapHandler#handlePinchZoom deltaDistance: %1", (long)n3);
        if (n3 < 0) {
            float f4;
            tpLogChannelInternal.log(10000000, "TouchMapHandler#handlePinchZoom zooming out, initialZoomLevelIndex: %1 myZoomLevelIndex: %2 maxZoomLevels: %3", (double)this.initialZoomLevelIndex, (double)f3, (double)(this.zoomLevels.length - 1));
            this.pinchZoomTargetLevelIndex = f4 = (float)this.initialZoomLevelIndex + f3;
            if (f4 < (float)(this.zoomLevels.length - 1)) {
                int n5 = (int)f4;
                float f5 = f4 - (float)n5;
                int n6 = (int)((float)(this.zoomLevels[n5 + 1] - this.zoomLevels[n5]) * f5);
                this.currentZoomLevel = this.zoomLevels[n5] + n6;
                tpLogChannelInternal.log(10000000, "TouchMapHandler#handlePinchZoom currentZoomLevel: %1 targetLevelFloat: %2 interpolatedDelta: %3 ", (double)this.currentZoomLevel, (double)f4, (double)n6);
            } else {
                this.currentZoomLevel = this.zoomLevels[this.zoomLevels.length - 1];
                tpLogChannelInternal.log(10000000, "TouchMapHandler#handlePinchZoom currentZoomLevel: %1 - maximum reached", (long)this.currentZoomLevel);
            }
        } else {
            float f6;
            if (this.isLowestZoomLevel()) {
                tpLogChannelInternal.log(10000000, "TouchMapHandler#handlePinchZoom Already on lowest zoom level (current zoom level: %1).", (long)this.currentZoomLevel);
                return;
            }
            tpLogChannelInternal.log(10000000, "TouchMapHandler#handlePinchZoom zooming in, initialZoomLevelIndex: %1 myZoomLevelIndex: %2 maxZoomLevels: %3", (double)this.initialZoomLevelIndex, (double)f3, (double)(this.zoomLevels.length - 1));
            this.pinchZoomTargetLevelIndex = f6 = (float)this.initialZoomLevelIndex - f3;
            if (f6 > 0.0f) {
                if (f6 < (float)(this.zoomLevels.length - 1)) {
                    int n7 = (int)f6;
                    float f7 = f6 - (float)n7;
                    int n8 = (int)((float)(this.zoomLevels[n7 + 1] - this.zoomLevels[n7]) * f7);
                    this.currentZoomLevel = this.zoomLevels[n7] + n8;
                    tpLogChannelInternal.log(10000000, "TouchMapHandler#handlePinchZoom currentZoomLevel: %1 targetLevelFloat: %2 interpolatedDelta: %3 ", (double)this.currentZoomLevel, (double)f6, (double)n8);
                }
            } else {
                this.currentZoomLevel = this.zoomLevels[0];
                n2 = 0;
                this.zoomLevelAfterTPReleased = -1;
            }
        }
        this.currentZoomLevel += n2;
        tpLogChannelKeypanel.log(10000000, "TouchMapHandler#handlePinchZoom currentZoomLevel: %1", (long)this.currentZoomLevel);
        this.pinchZoomRangeModel.increment(this.currentZoomLevel, this.terminal.getTerminalID());
    }

    private void refreshInitialLevel() {
        tpLogChannelInternal.log(10000000, "TouchMapHandler#refreshInitialLevel before currentZoomLevel: %1, initialZoomLevelIndex: %2 zoomLevelIndex: %3", (long)this.currentZoomLevel, (long)this.initialZoomLevelIndex, (long)this.zoomLevelIndex);
        if (this.currentZoomLevel != this.zoomLevels[this.zoomLevelIndex]) {
            for (int i2 = 0; i2 < this.zoomLevels.length; ++i2) {
                if (this.currentZoomLevel > this.zoomLevels[i2]) continue;
                this.initialZoomLevelIndex = i2 > 0 && this.currentZoomLevel - this.zoomLevels[i2 - 1] < this.zoomLevels[i2] - this.currentZoomLevel ? i2 - 1 : i2;
                this.zoomLevelAfterTPReleased = this.currentZoomLevel;
                this.zoomLevelIndexAfterTPReleased = this.initialZoomLevelIndex;
                this.currentZoomLevel = this.zoomLevels[this.initialZoomLevelIndex];
                this.zoomLevelIndex = this.initialZoomLevelIndex;
                break;
            }
        }
        tpLogChannelKeypanel.log(10000000, "TouchMapHandler#refreshInitialLevel currentZoomLevel: %1", (long)this.currentZoomLevel);
        tpLogChannelInternal.log(10000000, "TouchMapHandler#refreshInitialLevel after currentZoomLevel: %1, initialZoomLevelIndex: %2 zoomLevelIndex: %3", (long)this.currentZoomLevel, (long)this.initialZoomLevelIndex, (long)this.zoomLevelIndex);
    }

    private void updateZoomLevel() {
        this.currentZoomLevel = this.pinchZoomRangeModel.getValue();
        tpLogChannelInternal.log(10000000, "TouchMapHandler#updateZoomLevel read value from model currentZoomLevel: %1 ", (long)this.currentZoomLevel);
    }

    private void enableSoftZoom() {
        if (this.model instanceof RangeModelGUI) {
            int n = this.getTerminalImpl().getTerminalID();
            this.pinchZoomRangeModel.keyReleased(-1, n);
            this.softZoomEnabled = true;
        }
    }

    private void disableSoftZoom() {
        if (this.model instanceof RangeModelGUI) {
            int n = this.getTerminalImpl().getTerminalID();
            this.pinchZoomRangeModel.keyPressed(-1, n);
            this.softZoomEnabled = false;
        }
    }

    private void processZoomGesture(TouchEvent touchEvent) {
        tpLogChannelKeypanel.log(10000000, "TouchMapHandler#processZoomGesture fingerCount: %1, fingerDistance: %2 evt.getDistance(): %3", (long)touchEvent.getFingerCount(), (long)this.fingerDistance, (long)touchEvent.getDistance());
        if (touchEvent.getFingerCount() < 2) {
            this.fingerDistanceSum = 0;
            this.fingerDistance = 0;
            return;
        }
        if (this.softZoomEnabled) {
            this.disableSoftZoom();
        }
        int n = this.fingerDistance;
        this.fingerDistance = (int)this.getFingerDistance(touchEvent.getDistance());
        if (n == 0) {
            tpLogChannelKeypanel.log(10000000, "TouchMapHandler#processZoomGesture previousDistance is 0 - do not zoom");
            this.initialFingerDistance = this.fingerDistance;
            this.initialZoomLevelIndex = this.zoomLevelIndex;
            return;
        }
        int n2 = this.getZoomConstant();
        int n3 = n - this.fingerDistance;
        int n4 = Math.abs(n3);
        if (n4 < n2) {
            this.fingerDistanceSum += n3;
            int n5 = Math.abs(this.fingerDistanceSum);
            if (n5 < n2) {
                tpLogChannelKeypanel.log(10000000, "TouchMapHandler#processZoomGesture absoluteDistance is too small, do not zoom fingerDistanceSumAbs: %1", (long)n5);
                return;
            }
            n4 = n5;
            this.fingerDistanceSum = 0;
        }
        tpLogChannelKeypanel.log(10000000, "TouchMapHandler#processZoomGesture zoomFactor: %1", (long)n4);
        this.handlePinchZoom(this.fingerDistance, this.getPixelPerLevel());
    }

    private int getZoomConstant() {
        int n = 12;
        if (this.keypanelType == 1) {
            n = 20;
        }
        return n;
    }

    private int getMinimumVectorLength() {
        int n = vectorLengthMinimumAit;
        if (this.keypanelType == 1) {
            n = vectorLengthMinimumTw;
        }
        return n;
    }

    private int getMinimumDistanceForMovement() {
        int n = 961;
        if (this.keypanelType == 1) {
            n = 3844;
        }
        return n;
    }

    private float getPixelPerLevel(float f2) {
        float f3 = 0.0f;
        float f4 = 0.0f;
        float f5 = 0.0f;
        f3 = pixelPerLevelAit;
        f4 = 6.0f;
        f5 = 10.0f;
        if (this.keypanelType == 1) {
            f3 = pixelPerLevelTw;
            f4 = pixelPerLevelFactor;
            f5 = pixelPerLevelCurrentLevelDependence;
        }
        if (pixelPerLevelZoomLevelDependenceActive) {
            tpLogChannelInternal.log(10000000, "TouchMapHandler#handlePinchZoom targetZoomLevelIndex = %1", (double)this.pinchZoomTargetLevelIndex);
            float f6 = f2 + 1.0f;
            float f7 = 1.0f + f4 * 1.0f / (f6 * f6);
            float f8 = (float)Math.pow(1.0f - f2 / (f5 * (float)this.zoomLevels.length), 2.0);
            tpLogChannelInternal.log(10000000, "TouchMapHandler#getPixelPerLevel factor1 = %1, factor2 = %2", (double)f7, (double)f8, 0.0);
            tpLogChannelInternal.log(10000000, "TouchMapHandler#getPixelPerLevel ppL = %1", (double)(f3 *= f7 * f8));
        }
        return f3;
    }

    private float getPixelPerLevel() {
        return this.getPixelPerLevel(this.pinchZoomTargetLevelIndex);
    }

    private boolean isEvoScale() {
        return framework.getSysConst(4581) == 0 && framework.getSysConst(522) == 1;
    }

    public void keyMoved(JoystickEvent joystickEvent) {
        if (this.isSemidynRGActive()) {
            tpLogChannelKeypanel.log(10000000, "TouchMapHandler#keyMoved Do not handle key event because semidyn. RG is active.");
            return;
        }
        if (!this.isCrosshairMapActive() && !this.isStreetViewVisible()) {
            if (this.event != 0 && joystickEvent.getDirection() == 2) {
                tpLogChannelKeypanel.log(10000000, "TouchMapHandler#keyMoved isCrosshairMapActive: %1, event: %2 is thrown on Joystick N", this.isCrosshairMapActive(), (long)this.event);
                hmiService.fireSMEvent(this.terminal.getTerminalID(), this.event);
            } else {
                tpLogChannelKeypanel.log(10000000, "TouchMapHandler#keyMoved evt.getKeyCode(): %1, event: %2 - ignore event, only Joystick_N is processed and only if an event is configured", (long)joystickEvent.getKeyCode(), (long)this.event);
            }
        } else {
            tpLogChannelKeypanel.log(10000000, "TouchMapHandler#keyMoved isCrosshairMapActive: %1, isStreetViewVisible: %2 - ignore Joystick up event", this.isCrosshairMapActive(), this.isStreetViewVisible());
        }
        if (this.isEvoScale() && this.isCrosshairMapActive()) {
            VirtualButtonModelGUI virtualButtonModelGUI = (VirtualButtonModelGUI)this.model;
            int n = this.getTerminal().getTerminalID();
            int n2 = joystickEvent.getDirection();
            switch (n2) {
                case 2: {
                    virtualButtonModelGUI.joyN(n);
                    break;
                }
                case 4: {
                    virtualButtonModelGUI.joyE(n);
                    break;
                }
                case 6: {
                    virtualButtonModelGUI.joyS(n);
                    break;
                }
                case 8: {
                    virtualButtonModelGUI.joyW(n);
                    break;
                }
                default: {
                    virtualButtonModelGUI.joyIdle(n);
                }
            }
            joystickEvent.consume();
        }
    }

    public void keyPressed(KeyEvent keyEvent) {
        tpLogChannelKeypanel.log(10000000, "TouchMapHandler#keyPressed evt: %1, model: %2", (Object)keyEvent, this.model);
        if (this.isSemidynRGActive()) {
            tpLogChannelKeypanel.log(10000000, "TouchMapHandler#keyPressed Do not handle key event because semidyn. RG is active.");
            return;
        }
        int n = keyEvent.getKeyCode();
        if (n == 17 || n == 15) {
            keyEvent.consume();
        }
        if (n == 17 && this.isCrosshairMapActive()) {
            this.terminal.getUserHintHandler().requestInitialHint(103);
        }
        if (n == 17 || n == 15 || n == 19) {
            this.cancelPhysicsTimer();
            this.resetDeltas();
        }
        if (keyEvent.getKeyCode() == 17) {
            this.timeStampDDSPressed = framework.getMonotonicTime();
        }
        if (keyEvent.isConsumed()) {
            return;
        }
        super.keyPressed(keyEvent);
    }

    public void keyTurned(WheelButtonEvent wheelButtonEvent) {
        if (this.isSemidynRGActive()) {
            tpLogChannelKeypanel.log(10000000, "TouchMapHandler#keyTurned Do not handle key event because semidyn. RG is active.");
            return;
        }
        this.enableSoftZoom();
        int n = wheelButtonEvent.getClickCount();
        int n2 = wheelButtonEvent.getSubClickCount();
        tpLogChannelKeypanel.log(10000000, "TouchMapHandler#keyTurned clickCount: %1 subClickCount: %2", (long)n, (long)n2);
        WheelButtonEvent wheelButtonEvent2 = wheelButtonEvent;
        if (n == 0 && (this.isStreetViewVisible() || n2 > 0 && this.isLowestZoomLevel())) {
            return;
        }
        long l = framework.getMonotonicTime();
        if (l - this.zoomLevelReadTimestamp > 5000L || this.zoomLevelReadTimestamp == 0L || this.isStreetViewVisible()) {
            this.updateMagnificationRange();
        }
        this.zoomLevelReadTimestamp = l;
        if (this.isStreetViewVisible()) {
            if (n > 0) {
                n = 1;
            } else if (n < 0) {
                n = -1;
            }
            n2 = 0;
        }
        boolean bl = false;
        if (n > 0) {
            if (wheelButtonEvent2.getDirection() == 1) {
                this.zoomLevelIndex += n;
                if (this.zoomLevelIndex > this.zoomLevels.length - 1) {
                    this.zoomLevelIndex = this.zoomLevels.length - 1;
                    bl = true;
                }
            } else {
                this.zoomLevelIndex -= n;
                if (this.zoomLevelIndex < 0) {
                    this.zoomLevelIndex = 0;
                    bl = true;
                }
            }
        }
        if (this.zoomLevelIndex != this.zoomLevelIndexAfterTPReleased && this.zoomLevelAfterTPReleased != -1) {
            this.zoomLevelAfterTPReleased = -1;
            this.zoomLevelIndexAfterTPReleased = -1;
            tpLogChannelInternal.log(10000000, "TouchMapHandler#keyTurned revert zoom level index after TP released");
        }
        int n3 = 0;
        if (0 <= this.zoomLevelIndex && this.zoomLevelIndex < this.zoomLevels.length) {
            n3 = this.zoomLevels[this.zoomLevelIndex];
            if (this.zoomLevelAfterTPReleased != -1) {
                n3 = this.zoomLevelAfterTPReleased;
            }
        }
        this.pinchZoomTargetLevelIndex = this.zoomLevelIndex;
        tpLogChannelInternal.log(10000000, "TouchMapHandler#keyTurned - actual zoom level = %1", (long)n3);
        int n4 = n3;
        if (!bl) {
            if (n2 < 0) {
                if (this.zoomLevelIndex < this.zoomLevels.length - 1) {
                    int n5 = this.zoomLevels[this.zoomLevelIndex + 1] - n3;
                    n4 = (int)((float)n4 + (float)n5 * ((float)(-n2) / 100.0f));
                    tpLogChannelKeypanel.log(10000000, "TouchMapHandler#keyTurned - zoomLevelIndex: %1 deltaZoomLevel: %2  deltaZoomLevel*(subClickCount/100.f): %3", (double)this.zoomLevelIndex, (double)n5, (double)((float)n5 * ((float)(-n2) / 100.0f)));
                }
            } else if (n2 > 0 && this.zoomLevelIndex > 0) {
                int n6 = n3 - this.zoomLevels[this.zoomLevelIndex - 1];
                n4 = (int)((float)n4 - (float)n6 * ((float)n2 / 100.0f));
                tpLogChannelKeypanel.log(10000000, "TouchMapHandler#keyTurned - setting zoomLevel to %1", (long)this.zoomLevels[this.zoomLevelIndex]);
                tpLogChannelKeypanel.log(10000000, "TouchMapHandler#keyTurned - zoomLevelIndex: %1 deltaZoomLevel: %2  deltaZoomLevel*(subClickCount/100.f): %3", (double)this.zoomLevelIndex, (double)n6, (double)((float)n6 * ((float)n2 / 100.0f)));
            }
        } else {
            tpLogChannelKeypanel.log(10000000, "TouchMapHandler#keyTurned - zoom range exceeded: %1 - ignoring subclicks", bl);
        }
        tpLogChannelKeypanel.log(10000000, "TouchMapHandler#keyTurned subClickCount: %1 zoomLevel: %2  ", (long)n2, (long)n4);
        this.pinchZoomRangeModel.increment(n4, this.terminal.getTerminalID());
        this.currentZoomLevel = n4;
        if (n2 != 0) {
            this.restartKeyTurnTimeout();
        } else {
            this.cancelKeyTurnTimeout();
        }
        wheelButtonEvent2.consume(false);
    }

    private void restartKeyTurnTimeout() {
        if (this.turnTimeoutEvent == null) {
            this.turnTimeoutEvent = new TimerEvent(this);
        }
        this.cancelKeyTurnTimeout();
        this.turnEventTimer = hmiService.getEventDispatcher().postEvent(this.turnTimeoutEvent, 400L);
    }

    private void cancelKeyTurnTimeout() {
        if (this.turnEventTimer != null && !this.turnEventTimer.isCanceled()) {
            this.turnEventTimer.cancel();
        }
    }

    private void setRecognizerModeMIB2Gestures() {
        if (this.initContext != null) {
            this.terminal.getTouchInputManager().setDesiredRecognizerMode(this, 25);
        } else {
            tpLogChannelInternal.log(10000, "TouchMapHandler#setRecognizerMode initContext is null, recognizerMode not set!");
        }
    }

    private void restartPhysicsTimer() {
        if (this.timerEvent == null) {
            this.timerEvent = new TimerEvent(this);
        }
        this.cancelPhysicsTimer();
        this.physicsTimer = hmiService.getEventDispatcher().postEvent(this.timerEvent, 50L);
    }

    public void cancelPhysicsTimer() {
        if (this.physicsTimer != null && !this.physicsTimer.isCanceled()) {
            this.physicsTimer.cancel();
        }
    }

    private void restartDataUpdateDelayTimer() {
        if (this.dataUpdateDelayEvent == null) {
            this.dataUpdateDelayEvent = new TimerEvent(this);
        }
        this.cancelDataUpdateDelayTimer();
        this.dataUpdateDelayTimer = hmiService.getEventDispatcher().postEvent(this.dataUpdateDelayEvent, 300L);
    }

    public void cancelDataUpdateDelayTimer() {
        if (this.dataUpdateDelayTimer != null && !this.dataUpdateDelayTimer.isCanceled()) {
            this.dataUpdateDelayTimer.cancel();
        }
    }

    public void processEvent(ATIPEvent aTIPEvent) {
        if (aTIPEvent.equals(this.timerEvent) && this.fingersOnTP == 0) {
            if (this.model instanceof VirtualButtonModelGUI) {
                VirtualButtonModelGUI virtualButtonModelGUI = (VirtualButtonModelGUI)this.model;
                tpLogChannelKeypanel.log(10000000, "TouchMapHandler#processEvent calling touchPadPositionMoved at virtual button model deltaEvtX: %1 deltaEvtY: %2", (long)this.deltaX, (long)this.deltaY);
                virtualButtonModelGUI.touchPadPositionMoved(this.scrollMode, 0, this.deltaX, this.deltaY, this.terminal.getTerminalID());
            }
            if (this.physicStarted) {
                this.physicStarted = false;
                this.deltaX = this.getAverageVector(true);
                this.deltaY = this.getAverageVector(false);
                this.clearRingBuffer();
                tpLogChannelKeypanel.log(10000000, "TouchMapHandler#processEvent calling touchPadPositionMoved at virtual button model deltaX: %1 deltaY: %2", (long)this.deltaX, (long)this.deltaY);
            }
            float f2 = this.keypanelType == 1 ? decelerationFactorTw : decelerationFactor;
            this.deltaX = Math.round((float)this.deltaX / f2);
            this.deltaY = Math.round((float)this.deltaY / f2);
            int n = this.getSquaredVectorLength(this.deltaX, this.deltaY);
            if (n > this.getMinimumVectorLength()) {
                this.restartPhysicsTimer();
            } else {
                this.restartDataUpdateDelayTimer();
            }
        } else if (aTIPEvent.equals(this.dataUpdateDelayEvent)) {
            if (framework.getMonotonicTime() - this.timeStampDDSPressed < (long)ddsPressedTimeout) {
                tpLogChannelInternal.log(10000000, "TouchMapHandler#processEvent trigger no data update since DDS was pressed");
            } else {
                tpLogChannelInternal.log(10000000, "TouchMapHandler#processEvent calling joystick idle at virtual button model - to trigger data update");
                this.triggerDataUpdate();
            }
        }
    }

    public void processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
        int n = modelUpdateEvent.getModelId();
        if (n == this.modelStubIDs[0]) {
            this.updateZoomLevels();
        } else if (n == this.modelStubIDs[1]) {
            tpLogChannelInternal.log(10000000, "TouchMapHandler#processModelUpdateEvent Model update on magnification range model");
            ChoiceModelGUI choiceModelGUI = (ChoiceModelGUI)((Object)hmiService.getModel(400911));
            if (choiceModelGUI.getValue() == 1) {
                this.updateMagnificationRange();
                this.pinchZoomTargetLevelIndex = this.zoomLevelIndex;
                this.zoomLevelAfterTPReleased = -1;
            } else {
                tpLogChannelInternal.log(10000000, "TouchMapHandler#processModelUpdateEvent ignore magnification range update.");
            }
        } else if (n == this.modelStubIDs[2]) {
            tpLogChannelInternal.log(10000000, "TouchMapHandler#processModelUpdateEvent street view visible = %1", this.isStreetViewVisible());
            if (this.isStreetViewVisible()) {
                RangeModel rangeModel = this.getMapMagnificationRangeModel();
                int n2 = rangeModel.getValue();
                if (this.zoomLevelIndex != 0 && n2 != 0) {
                    this.storedZoomLevelIndex = this.zoomLevelIndex;
                    this.zoomLevelIndex = 0;
                    this.currentZoomLevel = this.zoomLevels[this.zoomLevelIndex];
                    ((RangeModel)this.pinchZoomRangeModel).setValue(this.currentZoomLevel);
                    this.storedMagnificationValue = n2;
                    rangeModel.setValue(0);
                }
            } else if (this.storedZoomLevelIndex != 0 && this.storedMagnificationValue != 0) {
                this.zoomLevelIndex = this.storedZoomLevelIndex;
                this.currentZoomLevel = this.zoomLevels[this.zoomLevelIndex];
                this.pinchZoomRangeModel.increment(this.currentZoomLevel, this.terminal.getTerminalID());
                RangeModel rangeModel = this.getMapMagnificationRangeModel();
                rangeModel.setValue(this.storedMagnificationValue);
                this.storedZoomLevelIndex = 0;
                this.storedMagnificationValue = 0;
            } else {
                this.updateMagnificationRange();
            }
        } else {
            tpLogChannelInternal.log(10000, "TouchMapHandler#processModelUpdateEvent No model stub configured for model ID %1", (long)n);
        }
    }

    private void triggerDataUpdate() {
        if (this.model instanceof VirtualButtonModelGUI) {
            VirtualButtonModelGUI virtualButtonModelGUI = (VirtualButtonModelGUI)this.model;
            virtualButtonModelGUI.joyIdle(this.terminal.getTerminalID());
        }
    }

    public void setPinchZoomModel(RangeModelGUI rangeModelGUI) {
        this.pinchZoomRangeModel = rangeModelGUI;
    }

    public void setTopBarModeModel(ChoiceModelGUI choiceModelGUI) {
        this.topBarVisibleModel = choiceModelGUI;
    }

    private void initializeModelReferences() {
        List list;
        if (this.pinchZoomRangeModel == null) {
            this.pinchZoomRangeModel = (RangeModelGUI)((Object)hmiService.getModel(400898));
        }
        if (this.topBarVisibleModel == null) {
            this.topBarVisibleModel = (ChoiceModelGUI)((Object)hmiService.getModel(400455));
        }
        if (this.mapScreenChoiceModel == null) {
            this.mapScreenChoiceModel = (ChoiceModelGUI)((Object)hmiService.getModel(401124));
        }
        if (this.routeGuidanceActiveModel == null) {
            this.routeGuidanceActiveModel = (ChoiceModelGUI)((Object)hmiService.getModel(400871));
        }
        if (this.routeCalculatingPrepare == null) {
            this.routeCalculatingPrepare = (ChoiceModelGUI)((Object)hmiService.getModel(400682));
        }
        if (!(list = this.getChildren()).isEmpty()) {
            Iterator iterator = list.iterator();
            int n = 0;
            while (iterator.hasNext() && n < this.modelStubIDs.length) {
                Object object = iterator.next();
                if (!(object instanceof ModelStubController)) continue;
                this.modelStubIDs[n++] = ((ModelStubController)object).getModelID();
                tpLogChannelInternal.log(10000000, "TouchMapHandler#initializeModelReferences Connect model stub with model-id = %1", (long)((ModelStubController)object).getModelID());
            }
        }
        if (this.modelStubIDs[2] == -1) {
            this.modelStubIDs[2] = 400824;
        }
        this.streetViewVisibleModel = (ChoiceModelGUI)((Object)hmiService.getModel(this.modelStubIDs[2]));
    }

    public static int[] updateZoomLevels(TiledListModelGUI tiledListModelGUI) {
        int n;
        int[] nArray;
        if (tiledListModelGUI != null) {
            GuiListRow guiListRow;
            int n2 = tiledListModelGUI.getLength();
            nArray = new int[n2];
            for (n = 0; n < n2 && (guiListRow = tiledListModelGUI.getGuiRow(n)) != null && guiListRow.getColumnCount() > 0; ++n) {
                nArray[n] = ((Long)guiListRow.getCell(0)).intValue();
            }
        } else {
            tpLogChannelInternal.log(100000, "TouchMapHandler#updateZoomLevels failed - no model available - taking default EU zoom levels");
            nArray = new int[]{3000, 5000, 7500, 10000, 15000, 20000, 30000, 40000, 50000, 75000, 100000, 150000, 200000, 300000, 400000, 500000, 600000, 800000, 1000000, 1500000, 2000000, 3000000, 4000000, 5000000, 6000000, 7000000, 8000000, 9000000, 10000000, 12500000, 15000000, 17500000, 20000000, 25000000, 30000000, 50000000, 60000000, 100000000, 200000000, 250000000};
        }
        if (tpLogChannelInternal.isDebug()) {
            Buffer buffer = new Buffer(256);
            buffer.append("TouchMapHandler#updateZoomLevels zoomLevels: ");
            for (n = 0; n < nArray.length; ++n) {
                buffer.append(nArray[n]);
                buffer.append(',');
            }
            String string = buffer.toString();
            tpLogChannelInternal.log(10000000, string);
        }
        return nArray;
    }

    private void updateZoomLevels() {
        TiledListModelGUI tiledListModelGUI = (TiledListModelGUI)((Object)hmiService.getModel(this.modelStubIDs[0]));
        if (tiledListModelGUI == null) {
            tiledListModelGUI = (TiledListModelGUI)((Object)hmiService.getModel(401133));
            this.modelStubIDs[0] = 401133;
        }
        this.zoomLevels = TouchMapHandler.updateZoomLevels(tiledListModelGUI);
        this.updateMagnificationRange();
    }

    private void updateMagnificationRange() {
        RangeModel rangeModel = this.getMapMagnificationRangeModel();
        if (rangeModel != null) {
            int n = rangeModel.getValue();
            tpLogChannelInternal.log(10000000, "TouchMapHandler#updateMagnificationRange magnification range update (oldValue = %1, newValue = %2)", (long)this.zoomLevelIndex, (long)n);
            if (0 <= n && n < this.zoomLevels.length) {
                this.zoomLevelIndex = n;
                this.currentZoomLevel = this.zoomLevels[n];
            }
        }
        tpLogChannelInternal.log(10000000, "TouchMapHandler#updateMagnificationRange zoomLevelIndex: %1, currentZoomLevel: %2", (long)this.zoomLevelIndex, (long)this.currentZoomLevel);
    }

    private RangeModel getMapMagnificationRangeModel() {
        RangeModel rangeModel = (RangeModel)hmiService.getModel(this.modelStubIDs[1]);
        if (rangeModel == null) {
            rangeModel = (RangeModel)hmiService.getModel(400476);
        }
        return rangeModel;
    }

    public void setViewSizeAnimation(float f2, float[] fArray, float[] fArray2, boolean bl) {
    }

    public void setViewSizeAnimationFinished(float[] fArray, boolean bl) {
    }

    public void viewSizeTargetChanged(float[] fArray, float[] fArray2, boolean bl) {
        if (fArray2[0] == 1.0f) {
            this.terminal.getUserHintHandler().removeCurrentUserHint();
        }
    }

    private float getFingerDistance(int n) {
        return 1.4285715f * (float)n;
    }

    public void setIgnoreInitialFingerDistance(boolean bl) {
        tpLogChannelInternal.log(10000000, "TouchMapHandler#setIgnoreInitialFingerDistance %1", bl);
        this.ignoreInitialFingerDistance = bl;
    }

    public void viewSizeAnimationStarted(float f2, float[] fArray, float[] fArray2) {
    }

    public void dumpPixelPerLevel() {
        for (int i2 = 0; i2 < this.zoomLevels.length; ++i2) {
            float f2 = this.getPixelPerLevel(i2);
            tpLogChannelInternal.log(10000000, "TouchMapHandler#dumpPixelPerLevel i = %1, zoomLevel = %2, pixelPerLevel = %3", (double)i2, (double)this.zoomLevels[i2], (double)f2);
        }
    }

    public TouchMapHandler() {
        singleton = this;
    }

    private boolean detectFingerLifting(int n) {
        int n2;
        float f2;
        float f3 = this.distanceHistory[0];
        for (int i2 = 0; i2 < this.distanceHistory.length - 1; ++i2) {
            this.distanceHistory[i2] = this.distanceHistory[i2 + 1];
        }
        this.distanceHistory[4] = f2 = (float)this.getSquaredVectorLength(this.deltaX, this.deltaY) / (float)n;
        float[] fArray = new float[5];
        fArray[0] = this.distanceHistory[0] - f3;
        for (int i3 = 0; i3 < this.distanceHistory.length - 1; ++i3) {
            fArray[i3 + 1] = this.distanceHistory[i3 + 1] - this.distanceHistory[i3];
        }
        float f4 = 0.0f;
        for (n2 = 0; n2 < fArray.length; ++n2) {
            f4 += fArray[n2];
        }
        if (f2 > 300.0f) {
            this.resetFingerLift();
            tpLogChannelInternal.log(10000000, "TouchMapHandler#detectFingerLifting Target approached.");
        }
        this.fingerLiftDetected[0] = this.fingerLiftDetected[1];
        this.fingerLiftDetected[1] = this.fingerLiftDetected[2];
        if (this.fingerLiftDetected[2] && !this.fingerLiftDetected[3]) {
            this.resetDeltas();
            this.fingerLiftDetected[2] = false;
            return true;
        }
        this.fingerLiftDetected[2] = this.fingerLiftDetected[3];
        if (this.fingerLiftDetected[3]) {
            if (f4 > 0.0f && (double)Math.abs(f4) < 0.1 || f2 > 1.0f) {
                this.fingerLiftDetected[3] = false;
            }
            if (!this.fingerLiftDetected[3]) {
                this.resetDeltas();
                return true;
            }
        } else {
            n2 = 1;
            int n3 = 0;
            for (int i4 = 0; i4 < this.distanceHistory.length - 1; ++i4) {
                if ((double)this.distanceHistory[i4] < 0.005) {
                    ++n3;
                }
                if (!(this.distanceHistory[i4] > 3.0f)) continue;
                n2 = 0;
            }
            if (n3 > 1) {
                n2 = 0;
            }
            if (n2 == 0) {
                if (f4 < 0.0f && f2 < 1.0f) {
                    this.fingerLiftDetected[3] = true;
                    tpLogChannelInternal.log(10000000, "TouchMapHandler#detectFingerLifting Target approached.");
                }
            } else if (f4 < 0.0f && this.distanceHistory[4] == 0.0f && this.distanceHistory[3] == 0.0f) {
                this.fingerLiftDetected[3] = true;
                tpLogChannelInternal.log(10000000, "TouchMapHandler#detectFingerLifting Slow motion.");
            } else if (f2 > 20.0f && f2 < 300.0f) {
                this.resetDeltas();
                this.fingerLiftDetected[0] = false;
                this.fingerLiftDetected[1] = false;
                this.fingerLiftDetected[2] = true;
                this.fingerLiftDetected[3] = false;
                tpLogChannelInternal.log(10000000, "TouchMapHandler#detectFingerLifting Heavy increase during slow motion.");
                return true;
            }
        }
        return false;
    }

    private boolean isFingerLiftDetected() {
        for (int i2 = 0; i2 < this.fingerLiftDetected.length; ++i2) {
            if (!this.fingerLiftDetected[i2]) continue;
            return true;
        }
        return false;
    }

    private void resetFingerLift() {
        for (int i2 = 0; i2 < this.fingerLiftDetected.length; ++i2) {
            this.fingerLiftDetected[i2] = false;
        }
    }

    private void resetDistanceHistory() {
        for (int i2 = 0; i2 < this.distanceHistory.length; ++i2) {
            this.distanceHistory[i2] = 0.0f;
        }
    }

    private void resetDeltas() {
        this.deltaX = 0;
        this.deltaY = 0;
    }

    public void activateFingerLiftDetection(boolean bl, boolean bl2) {
        this.fingerLiftDetectionActive = bl;
        this.fingerLiftDetectionResetDeltasOnly = bl2;
    }

    private void calculateScalarSumFeature(int n, int n2) {
        float f2;
        int n3 = this.innerProductBuffer.size();
        float f3 = 0.0f;
        float f4 = this.norm(n, n2);
        if (f4 != 0.0f) {
            Object object;
            f2 = (float)n / f4;
            float f5 = (float)n2 / f4;
            if (this.prevDirectionValid) {
                object = this.prevDirection;
                f3 = this.pinchMoveMode == 2 || this.pinchMoveMode == 4 ? 0.01f : f2 * object[0] + f5 * object[1];
                this.scalarSumFeature += f3;
                this.innerProductBuffer.add(new Float(f3));
            }
            this.prevDirection[0] = f2;
            this.prevDirection[1] = f5;
            this.prevDirectionValid = true;
            if (n3 > 10) {
                object = (Float)this.innerProductBuffer.remove(0);
                this.scalarSumFeature -= ((Float)object).floatValue();
            }
        }
        n3 = this.innerProductBuffer.size();
        if (tpLogChannelInternal.isDebug() && n3 > 1) {
            f2 = this.scalarSumFeature / (float)n3;
            tpLogChannelInternal.log(10000000, "TouchMapHandler#calculateScalarSumFeature scalarSumFeature = %1, currentValue = %2, bufferSize = %3", (double)f2, (double)f3, (double)n3);
        }
    }

    private float getScalarSumFeature() {
        if (this.keypanelType == 2) {
            float f2 = 0.0f;
            int n = this.innerProductBuffer.size();
            if (n >= 4) {
                f2 = this.scalarSumFeature / (float)n;
            }
            return f2;
        }
        tpLogChannelInternal.log(10000000, "TouchMapHandler#getScalarSumFeature Scalar sum feature not supported for keypanel type: %1", (long)this.keypanelType);
        return 0.0f;
    }

    protected void handleFocusChanged(int n, int n2, int n3) {
        tpLogChannelInternal.log(10000000, "TouchMapHandler#handleFocusChanged: evt:%1   state:%2", (long)n, (long)n2);
        if (DrawerFocusUtil.isFocusLost(n)) {
            tpLogChannelInternal.log(10000000, "TouchMapHandler#handleFocusChanged Focus lost. Sending touchPadReleased.");
            this.touchPadReleased(0);
        } else if (n == 2 && n2 == 16) {
            tpLogChannelInternal.log(10000000, "TouchMapHandler#handleFocusChanged Focus gained. Trying to show Userhint");
            this.doShowInitialHint();
        }
    }

    private void doShowInitialHint() {
        if (this.isStreetViewVisible()) {
            tpLogChannelInternal.log(1000000, "TouchMapHandler#doShowHintInitial: Not requesting Userhint because StreetView is active!");
            return;
        }
        if (this.isCrosshairMapActive()) {
            this.terminal.getUserHintHandler().requestInitialHint(103);
        } else if (!(this.isRouteGuidanceActive() || this.isRouteBriefing() || this.isCalculatingPrepareBusy())) {
            this.terminal.getUserHintHandler().requestInitialHint(105);
        }
    }

    static {
        vectorLengthMinimumTw = 200;
        vectorLengthMinimumAit = 90;
        maxDecelerationSpeedThresholdAit = 10.0f;
        maxDecelerationSpeedThreshold2Ait = 1.0f;
        maxDecelerationSpeedThresholdTw = 100.0f;
        maxDecelerationSpeedThreshold2Tw = 10.0f;
        speedDecelerationFactorAit = 0.5f;
        speedDecelerationFactor2Ait = 0.25f;
        speedDecelerationFactorTw = 0.25f;
        speedDecelerationFactor2Tw = 0.15f;
        pixelPerLevelCurrentLevelDependence = 4.0f;
        pixelPerLevelFactor = 3.0f;
        pixelPerLevelZoomLevelDependenceActive = true;
        pixelPerLevelAit = 80;
        pixelPerLevelTw = 120;
        maximumPinchMoveSpeedDifferenceTw = 10.0f;
        f2f1ChangeTimeout = 100;
        ddsPressedTimeout = 1000;
        lowerMoveThresholdTw = 15;
        upperMoveThresholdTw = 25;
        lowerPinchThresholdAit = 3.0f;
        upperPinchThresholdAit = 5.0f;
        decelerationFactor = 1.2f;
        decelerationFactorTw = 1.14f;
        scalarSumThreshold = 0.7f;
    }
}

