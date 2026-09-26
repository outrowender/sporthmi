/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

import java.lang.ref.WeakReference;

public class NaviOnlineService$RrdData {
    private String id;
    private String rrdDistance;
    private String airDistance;
    private String roadTripTime;
    private Integer airDirection;
    private Integer latitude;
    private Integer longitude;
    private Integer rrdReferenceLatitude;
    private Integer rrdReferenceLongitude;
    private int idRangeStart = 0;
    private WeakReference modelContainer;
    private WeakReference model;

    public void setIdRangeStart(int n) {
        this.idRangeStart = n;
    }

    public int getIdRangeStart() {
        return this.idRangeStart;
    }

    public void setModelAndContainer(Object object, Object object2) {
        this.setModelContainer(object);
        this.setModel(object2);
    }

    public Object getModelContainer() {
        return this.modelContainer == null ? null : this.modelContainer.get();
    }

    public void setModelContainer(Object object) {
        this.modelContainer = new WeakReference(object);
    }

    public Object getModel() {
        return this.model == null ? null : this.model.get();
    }

    public void setModel(Object object) {
        this.model = new WeakReference(object);
    }

    public String getId() {
        return this.id;
    }

    public void setId(String string) {
        this.id = string;
    }

    public String getRrdDistance() {
        return this.rrdDistance;
    }

    public void setRrdDistance(String string) {
        this.rrdDistance = string;
    }

    public String getAirDistance() {
        return this.airDistance;
    }

    public void setAirDistance(String string) {
        this.airDistance = string;
    }

    public Integer getAirDirection() {
        return this.airDirection;
    }

    public void setAirDirection(Integer n) {
        this.airDirection = n;
    }

    public Integer getLatitude() {
        return this.latitude;
    }

    public void setLatitude(Integer n) {
        this.latitude = n;
    }

    public Integer getLongitude() {
        return this.longitude;
    }

    public void setLongitude(Integer n) {
        this.longitude = n;
    }

    public Integer getRrdReferenceLatitude() {
        return this.rrdReferenceLatitude;
    }

    public void setRrdReferenceLatitude(Integer n) {
        this.rrdReferenceLatitude = n;
    }

    public Integer getRrdReferenceLongitude() {
        return this.rrdReferenceLongitude;
    }

    public void setRrdReferenceLongitude(Integer n) {
        this.rrdReferenceLongitude = n;
    }

    public String getRoadTripTime() {
        return this.roadTripTime;
    }

    public void setRoadTripTime(String string) {
        this.roadTripTime = string;
    }
}

