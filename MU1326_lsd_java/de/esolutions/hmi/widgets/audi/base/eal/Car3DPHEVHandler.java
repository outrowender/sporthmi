/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.eal;

import de.audi.atip.hmi.view.AnimationListener;
import de.audi.atip.log.LogChannel;
import de.esolutions.graphics.eal.api.INode;
import de.esolutions.graphics.eal.api.INode3D;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.HMITerminalImpl;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.animation.AbstractAnimation;
import de.esolutions.hmi.widgets.audi.base.animation.AbstractAnimationController;
import de.esolutions.hmi.widgets.audi.base.eal.Car3DResourceHandler;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.eal.EALPropertyCache;

public class Car3DPHEVHandler
implements AnimationListener {
    private static final String PROPERTY_BATTERY_CAPACITY = "phev_battery_capacity";
    private static final String PROPERTY_CHARGING_PROGRESS = "phev_charging_progress";
    private static final String PROPERTY_CHARGING_STATE = "phev_charging_state";
    private static final String PROPERTY_DRIVING_DIRECTION = "phev_driving_direction";
    private static final String PROPERTY_DRIVING_PROGRESS = "phev_driving_progress";
    private static final String PROPERTY_DRIVING_SOURCE_ARROWS = "phev_driving_source_arrow";
    private static final String PROPERTY_DRIVING_SOURCE_ENGINE = "phev_driving_source_motor";
    private static final String PROPERTY_RECUPERATION = "phev_recup";
    private static final String PROPERTY_ARROWS = "phev_show_arrows";
    private static final String PROPERTY_STATE = "phev_state";
    private int phevWheelsDirection;
    private int phevBatteryState;
    private int phevBatteryLevel;
    private int phevMotorState;
    private int phevArrowsMode;
    private int phevCardanState;
    public static final int ENERGY_MONITOR_FRONT_WHEEL_DRIVE = 0;
    public static final int ENERGY_MONITOR_REAR_WHEEL_DRIVE = 1;
    public static final int ENERGY_MONITOR_QUATTRO_WHEEL_DRIVE = 2;
    public static final int ENERGY_MONITOR_WHEELS_NOT_TURNING = 0;
    public static final int ENERGY_MONITOR_WHEELS_TURNING_FORWARD = 1;
    public static final int ENERGY_MONITOR_WHEELS_TURNING_BACKWARD = 2;
    public static final int ENERGY_MONITOR_BATTERY_INACTIVE = 0;
    public static final int ENERGY_MONITOR_BATTERY_NO_CURRENT = 1;
    public static final int ENERGY_MONITOR_BATTERY_CHARGING = 2;
    public static final int ENERGY_MONITOR_BATTERY_DISCHARGING = 3;
    public static final int ENERGY_MONITOR_ARROWS_NONE = 0;
    public static final int ENERGY_MONITOR_ARROWS_POSITIVE_TORQUE_GREEN = 1;
    public static final int ENERGY_MONITOR_ARROWS_POSITIVE_TORQUE_YELLOW = 2;
    public static final int ENERGY_MONITOR_ARROWS_POSITIVE_TORQUE_COMBINED = 3;
    public static final int ENERGY_MONITOR_ARROWS_NEGATIVE_TORQUE_GREEN = 4;
    public static final int ENERGY_MONITOR_ARROWS_NEGATIVE_TORQUE_YELLOW = 5;
    public static final int ENERGY_MONITOR_MOTOR_NONE = 0;
    public static final int ENERGY_MONITOR_MOTOR_YELLOW = 1;
    public static final int ENERGY_MONITOR_MOTOR_NOT_HIGHLIGHTED = 2;
    public static final int ENERGY_MONITOR_CARDAN_NOT_HIGHLIGHTED = 0;
    public static final int ENERGY_MONITOR_CARDAN_GREEN = 1;
    public static final int ENERGY_MONITOR_CARDAN_YELLOW = 2;
    public static final int ENERGY_MONITOR_CARDAN_COMBINED = 3;
    private static final float VALUE_DRIVING_FORWARD = 1.0f;
    private static final float VALUE_DRIVING_STAND = 0.0f;
    private static final float VALUE_DRIVING_BACKWARD = -1.0f;
    private static final float VALUE_ENGINE_ENABLED = 0.0f;
    private static final float VALUE_ENGINE_MIXEDMODE = 1.0f;
    private static final float VALUE_ENGINE_DISABLED = 2.0f;
    private static final float VALUE_ENGINE_ENABLED_RECUP = 3.0f;
    private static final float VALUE_ENGINE_INIT = 4.0f;
    private static final float VALUE_ENGINE_ENABLED_MOTOR = 5.0f;
    private static final float VALUE_ARROWS_NONE = 0.0f;
    private static final float VALUE_ARROWS_AVAILABLE = 1.0f;
    private static final float VALUE_ARROWS_TORQUE_GREEN = 2.0f;
    private static final float VALUE_ARROWS_TORQUE_YELLOW = 0.0f;
    private static final float VALUE_ARROWS_TORQUE_COMBINED = 1.0f;
    private static final float VALUE_BATTERY_SEGMENTS = 8.0f;
    private static final float VALUE_BATTERY_INACTIVE = 0.0f;
    public static final float VALUE_BATTERY_NO_CURRENT = 0.0f;
    public static final float VALUE_BATTERY_CHARGING = 1.0f;
    public static final float VALUE_BATTERY_DISCHARGING = 1.0f;
    private static final float VALUE_RECUPERATION_NOT_SET = 0.0f;
    private static final float VALUE_RECUPERATION_SET = 1.0f;
    private static final float VALUE_ENABLE_PHEV = 1.0f;
    private static final float VALUE_DISABLE_PHEV = 0.0f;
    private static final String DRIVE_SELECT_PROPERTY_NODE = "driveSelect_Controls";
    private static final int ANIMATE_INTERVAL = 30;
    private static final float INITIAL_VALUE = 0.0f;
    private static final float MAX_ANIMATION_LIMIT = 1.0f;
    private static final float ANIMATION_STEP_WHEEL = 0.0125f;
    private static final float ANIMATION_STEP_CHARGING = 0.0125f;
    private static final int ANIMATION_TYPE = 1;
    private boolean loadResources = false;
    private float animationStatusWheel = 0.0f;
    private float animationStatusBatteryCharging = 0.0f;
    private HMITerminalImpl terminal;
    private EALManager ealManager;
    Car3DResourceHandler car3dResourceHandler;
    private LogChannel logChannel3DCar = IWidgetLogChannel.logChannel3DCar;
    private AbstractWidget carViewerController;
    private AbstractAnimation animation;
    private INode3D driveSelectPropertyHolderNode;
    protected final EALPropertyCache propertyCache = new EALPropertyCache();

    public Car3DPHEVHandler(HMITerminalImpl hMITerminalImpl, EALManager eALManager, Car3DResourceHandler car3DResourceHandler) {
        this.terminal = hMITerminalImpl;
        this.ealManager = eALManager;
        this.car3dResourceHandler = car3DResourceHandler;
        this.loadResources();
    }

    public final void loadResources() {
        this.driveSelectPropertyHolderNode = this.getNode3D(DRIVE_SELECT_PROPERTY_NODE);
        if (this.driveSelectPropertyHolderNode == null) {
            return;
        }
        if (this.enablePHEV()) {
            this.loadResources = true;
            this.setPHEVProperties();
        }
    }

    public void updatePHEVProperties(int n, int n2, int n3, int n4, int n5, int n6, int n7) {
        this.phevWheelsDirection = n2;
        this.phevBatteryState = n3;
        this.phevBatteryLevel = n4;
        this.phevMotorState = n5;
        this.phevArrowsMode = n6;
        this.phevCardanState = n7;
        this.setPHEVProperties();
    }

    public void setPHEVProperties() {
        if (this.loadResources) {
            this.setDrivingProgress(this.phevWheelsDirection);
            this.setBatteryState(this.phevBatteryState, this.phevBatteryLevel);
            this.setMotorState(this.phevMotorState, this.phevCardanState);
            this.setEnergyFlow(this.phevMotorState, this.phevArrowsMode, this.phevCardanState);
        } else {
            this.logChannel3DCar.log(10000000, "Car3DPHEVHandler#setPHEVProperties loadResources is false: no update of model values.");
        }
        if (this.phevWheelsDirection == 0 && this.phevBatteryState != 2 && this.phevBatteryState != 3) {
            this.stopAnimation();
        }
    }

    private void setDrivingProgress(int n) {
        switch (n) {
            case 0: {
                this.propertyCache.setProperty((INode)this.driveSelectPropertyHolderNode, PROPERTY_DRIVING_DIRECTION, 0.0f);
                if (!this.logChannel3DCar.isDebug()) break;
                this.logChannel3DCar.log(10000000, "Car3DPHEVHandler#setDrivingProgress wheelsDirection (%1) phevDrivingDirection standing", (long)n);
                break;
            }
            case 1: {
                this.propertyCache.setProperty((INode)this.driveSelectPropertyHolderNode, PROPERTY_DRIVING_DIRECTION, 1.0f);
                if (!this.logChannel3DCar.isDebug()) break;
                this.logChannel3DCar.log(10000000, "Car3DPHEVHandler#setDrivingProgress wheelsDirection (%1) phevDrivingDirection forward", (long)n);
                break;
            }
            case 2: {
                this.propertyCache.setProperty((INode)this.driveSelectPropertyHolderNode, PROPERTY_DRIVING_DIRECTION, -1.0f);
                if (!this.logChannel3DCar.isDebug()) break;
                this.logChannel3DCar.log(10000000, "Car3DPHEVHandler#setDrivingProgress wheelsDirection (%1) phevDrivingDirection backward", (long)n);
                break;
            }
            default: {
                this.logChannel3DCar.log(10000000, "Car3DPHEVHandler#setDrivingProgress invalid given wheelsDirection (%1)", (long)n);
            }
        }
        if (this.phevWheelsDirection != 0) {
            this.startAnimation();
        }
    }

    private void setBatteryState(int n, int n2) {
        switch (n) {
            case 0: {
                this.propertyCache.setProperty((INode)this.driveSelectPropertyHolderNode, PROPERTY_CHARGING_STATE, 0.0f);
                this.logChannel3DCar.log(10000000, "Car3DPHEVHandler#setBatteryState charging state: inactive");
                break;
            }
            case 1: {
                this.propertyCache.setProperty((INode)this.driveSelectPropertyHolderNode, PROPERTY_CHARGING_STATE, 0.0f);
                this.logChannel3DCar.log(10000000, "Car3DPHEVHandler#setBatteryState charging state (1): no current");
                break;
            }
            case 2: {
                this.propertyCache.setProperty((INode)this.driveSelectPropertyHolderNode, PROPERTY_CHARGING_STATE, 1.0f);
                this.logChannel3DCar.log(10000000, "Car3DPHEVHandler#setBatteryState charging state: charging");
                break;
            }
            case 3: {
                this.propertyCache.setProperty((INode)this.driveSelectPropertyHolderNode, PROPERTY_CHARGING_STATE, 0.0f);
                this.logChannel3DCar.log(10000000, "Car3DPHEVHandler#setBatteryState charging state (3): no current");
                break;
            }
            default: {
                this.logChannel3DCar.log(10000000, "Car3DPHEVHandler#setBatteryState invalid state %1: no change for charging", (long)n);
            }
        }
        float f2 = (float)n2 / 8.0f;
        if (n != 0) {
            this.propertyCache.setProperty((INode)this.driveSelectPropertyHolderNode, PROPERTY_BATTERY_CAPACITY, f2);
            if (this.logChannel3DCar.isDebug()) {
                this.logChannel3DCar.log(10000000, "Car3DPHEVHandler#setBatteryState active with state: %1 and level: %2 and batterylevel: %3", (double)n, (double)n2, (double)f2);
            }
        } else {
            this.propertyCache.setProperty((INode)this.driveSelectPropertyHolderNode, PROPERTY_BATTERY_CAPACITY, 0.0f);
            if (this.logChannel3DCar.isDebug()) {
                this.logChannel3DCar.log(10000000, "Car3DPHEVHandler#setBatteryState INactive with state: %1 and level: %2 and batterylevel: %3", (double)n, (double)n2, (double)f2);
            }
        }
        if (this.phevBatteryState == 2) {
            this.startAnimation();
        }
    }

    private void setEnergyFlow(int n, int n2, int n3) {
        if (n2 == 0) {
            this.propertyCache.setProperty((INode)this.driveSelectPropertyHolderNode, PROPERTY_ARROWS, 0.0f);
            this.logChannel3DCar.log(10000000, "Car3DPHEVHandler#setEnergyFlow: ArrowMode (0) - all other propertys are invisible");
        } else {
            this.propertyCache.setProperty((INode)this.driveSelectPropertyHolderNode, PROPERTY_ARROWS, 1.0f);
        }
        switch (n2) {
            case 1: {
                this.propertyCache.setProperty((INode)this.driveSelectPropertyHolderNode, PROPERTY_RECUPERATION, 0.0f);
                this.propertyCache.setProperty((INode)this.driveSelectPropertyHolderNode, PROPERTY_DRIVING_SOURCE_ARROWS, 2.0f);
                this.logChannel3DCar.log(10000000, "Car3DPHEVHandler#setEnergyFlow: arrows available in green and recuperation not set");
                break;
            }
            case 2: {
                this.propertyCache.setProperty((INode)this.driveSelectPropertyHolderNode, PROPERTY_RECUPERATION, 0.0f);
                this.propertyCache.setProperty((INode)this.driveSelectPropertyHolderNode, PROPERTY_DRIVING_SOURCE_ARROWS, 0.0f);
                this.logChannel3DCar.log(10000000, "Car3DPHEVHandler#setEnergyFlow: arrows available in yellow and recuperation not set");
                break;
            }
            case 3: {
                this.propertyCache.setProperty((INode)this.driveSelectPropertyHolderNode, PROPERTY_RECUPERATION, 0.0f);
                this.propertyCache.setProperty((INode)this.driveSelectPropertyHolderNode, PROPERTY_DRIVING_SOURCE_ARROWS, 1.0f);
                this.logChannel3DCar.log(10000000, "Car3DPHEVHandler#setEnergyFlow: arrows available combined with torque and recuperation not set");
                break;
            }
            case 4: {
                this.propertyCache.setProperty((INode)this.driveSelectPropertyHolderNode, PROPERTY_RECUPERATION, 1.0f);
                this.propertyCache.setProperty((INode)this.driveSelectPropertyHolderNode, PROPERTY_DRIVING_SOURCE_ARROWS, 2.0f);
                this.logChannel3DCar.log(10000000, "Car3DPHEVHandler#setEnergyFlow: arrows available in green and recuperation set");
                break;
            }
            case 5: {
                this.propertyCache.setProperty((INode)this.driveSelectPropertyHolderNode, PROPERTY_RECUPERATION, 1.0f);
                this.propertyCache.setProperty((INode)this.driveSelectPropertyHolderNode, PROPERTY_DRIVING_SOURCE_ARROWS, 0.0f);
                this.logChannel3DCar.log(10000000, "Car3DPHEVHandler#setEnergyFlow: arrows available in yellow and recuperation set");
                break;
            }
            default: {
                this.propertyCache.setProperty((INode)this.driveSelectPropertyHolderNode, PROPERTY_RECUPERATION, 0.0f);
                this.logChannel3DCar.log(10000000, "Car3DPHEVHandler#setEnergyFlow: default case - recuperation not set");
            }
        }
    }

    private void setMotorState(int n, int n2) {
        if (this.logChannel3DCar.isDebug()) {
            this.logChannel3DCar.log(10000000, "Car3DPHEVHandler#setMotorState: motorState %1 and cardanState %2", (long)n, (long)n2);
        }
        if (n2 == 1 && n == 1) {
            this.propertyCache.setProperty((INode)this.driveSelectPropertyHolderNode, PROPERTY_DRIVING_SOURCE_ENGINE, 3.0f);
            this.logChannel3DCar.log(10000000, "Car3DPHEVHandler#setMotorState: engine enabled recup - engine orange and gears/cardan in green");
            return;
        }
        if (n2 == 0 && n == 1) {
            this.propertyCache.setProperty((INode)this.driveSelectPropertyHolderNode, PROPERTY_DRIVING_SOURCE_ENGINE, 5.0f);
            this.logChannel3DCar.log(10000000, "Car3DPHEVHandler#setMotorState: engine motor enabled - engine orange and gears/cardan in grey");
            return;
        }
        if (n2 == 2) {
            this.propertyCache.setProperty((INode)this.driveSelectPropertyHolderNode, PROPERTY_DRIVING_SOURCE_ENGINE, 0.0f);
            this.logChannel3DCar.log(10000000, "Car3DPHEVHandler#setMotorState: engine enabled - engine/gears/cardan in orange");
            return;
        }
        if (n2 == 3) {
            this.propertyCache.setProperty((INode)this.driveSelectPropertyHolderNode, PROPERTY_DRIVING_SOURCE_ENGINE, 1.0f);
            this.logChannel3DCar.log(10000000, "Car3DPHEVHandler#setMotorState: engine mixed mode - engine orange and gears/cardan in orange and green mixed");
            return;
        }
        if (n2 == 1) {
            this.propertyCache.setProperty((INode)this.driveSelectPropertyHolderNode, PROPERTY_DRIVING_SOURCE_ENGINE, 2.0f);
            this.logChannel3DCar.log(10000000, "Car3DPHEVHandler#setMotorState: engine disabled - engine grey and gears/cardan in green");
            return;
        }
        if (n2 == 0) {
            this.propertyCache.setProperty((INode)this.driveSelectPropertyHolderNode, PROPERTY_DRIVING_SOURCE_ENGINE, 4.0f);
            this.logChannel3DCar.log(10000000, "Car3DPHEVHandler#setMotorState: engine init - engine/gears/cardan in grey");
            return;
        }
    }

    private boolean enablePHEV() {
        if (!EALPropertyCache.isPropertyAvailable(this.driveSelectPropertyHolderNode, PROPERTY_STATE)) {
            return false;
        }
        if (this.terminal.getCarCodingHelper().isPHEVCar()) {
            this.propertyCache.setProperty((INode)this.driveSelectPropertyHolderNode, PROPERTY_STATE, 1.0f);
            if (this.logChannel3DCar.isDebug()) {
                this.logChannel3DCar.log(10000000, "Car3DPHEVHandler#enablePHEV: phev enabled");
            }
            return true;
        }
        this.propertyCache.setProperty((INode)this.driveSelectPropertyHolderNode, PROPERTY_STATE, 0.0f);
        return false;
    }

    private INode3D getNode3D(String string) {
        INode3D iNode3D = this.ealManager.getProject().getNode3D(string);
        if (!iNode3D.isValid()) {
            this.logChannel3DCar.log(10000, "Car3DPHEVHandler#getNode3D: Could not get node '%1'", (Object)string);
            iNode3D.dispose();
            return null;
        }
        return iNode3D;
    }

    public boolean isAnimating() {
        if (this.animation != null) {
            return this.animation.isAnimating();
        }
        return false;
    }

    private void startAnimation() {
        if (this.animation == null) {
            AbstractAnimationController abstractAnimationController = (AbstractAnimationController)this.terminal.getIAnimationController();
            this.animation = (AbstractAnimation)abstractAnimationController.getIAnimation(1);
            this.animation.addListener(this);
        }
        if (!this.animation.isAnimating() && !this.car3dResourceHandler.isGyroVisible() && this.carViewerController != null && this.carViewerController.getInitContext() != null) {
            this.car3dResourceHandler.setFXAAEnabled(1, false);
            this.logChannel3DCar.log(10000000, "Car3DPHEVHandler#startAnimation: animation is started");
            this.animation.startEndlessAnimation(30, this.carViewerController);
        }
    }

    public void animate(int n, float f2, int n2) {
        if (this.phevWheelsDirection != 0) {
            if (this.animationStatusWheel > 1.0f) {
                this.animationStatusWheel = 0.0f;
            }
            this.propertyCache.setProperty((INode)this.driveSelectPropertyHolderNode, PROPERTY_DRIVING_PROGRESS, this.animationStatusWheel);
            this.animationStatusWheel += 0.0125f;
        } else {
            this.animationStatusWheel = 0.0f;
        }
        if (this.phevBatteryState == 2) {
            if (this.animationStatusBatteryCharging > 1.0f) {
                this.animationStatusBatteryCharging = 0.0f;
            }
            this.propertyCache.setProperty((INode)this.driveSelectPropertyHolderNode, PROPERTY_CHARGING_PROGRESS, this.animationStatusBatteryCharging);
            this.animationStatusBatteryCharging += 0.0125f;
        }
        this.car3dResourceHandler.invalidatePartialRendering();
    }

    public void stopAnimation() {
        if (this.animation != null && this.animation.isAnimating()) {
            this.animation.stopAnimation();
            this.logChannel3DCar.log(10000000, "Car3DPHEVHandler#stopAnimation: animation is stopped");
            this.car3dResourceHandler.setFXAAEnabled(1, true);
        }
    }

    public void enablePhevHandler(boolean bl) {
        if (bl) {
            this.setPHEVProperties();
        } else {
            this.stopAnimation();
        }
    }

    public void setCarViewerController(AbstractWidget abstractWidget) {
        this.carViewerController = abstractWidget;
    }

    public void animationStarted(int n, int n2) {
    }

    public void animationFinished(int n, int n2) {
    }
}

