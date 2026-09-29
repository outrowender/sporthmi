/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.menu;

public class MenuKeyEventHandler$AccelerationFunctionParameters {
    static final MenuKeyEventHandler$AccelerationFunctionParameters TURN_PARAMS = new MenuKeyEventHandler$AccelerationFunctionParameters();
    static final MenuKeyEventHandler$AccelerationFunctionParameters TOUCH_PARAMS = new MenuKeyEventHandler$AccelerationFunctionParameters();
    public int decelerateTimePerStep = 800;
    public int minDistanceForAccelerate = 5;
    public int accelerationPerStep = 3;
    public int maxAccelerationSteps = 3;
    public int maxSpeed = 1 + this.accelerationPerStep * this.maxAccelerationSteps;
}

