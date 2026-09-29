/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.onlinefunctions.bap;

import de.audi.app.onlinefunctions.bap.TrafficLightInfo;

public final class TrafficLightInfo$Builder {
    private int trafficLight;
    private int mainDirection;
    private int[] sideStreetDirections;
    private int level;
    private int layout;

    public TrafficLightInfo$Builder setTrafficLight(int n) {
        this.trafficLight = n;
        return this;
    }

    public TrafficLightInfo$Builder setMainDirection(int n) {
        this.mainDirection = n;
        return this;
    }

    public TrafficLightInfo$Builder setSideStreetDirections(int[] nArray) {
        this.sideStreetDirections = nArray;
        return this;
    }

    public TrafficLightInfo$Builder setLevel(int n) {
        this.level = n;
        return this;
    }

    public TrafficLightInfo$Builder setLayout(int n) {
        this.layout = n;
        return this;
    }

    public TrafficLightInfo build() {
        return new TrafficLightInfo(this.trafficLight, this.mainDirection, this.sideStreetDirections, this.level, this.layout);
    }
}

