/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.combi.bap.navi.data;

public final class CombiBAPSemiDynamicRouteInfo {
    private static final int INVALID;
    boolean trafficImpactOnCurrentRoute;
    boolean alternativeRouteAvailable;
    int delayHour;
    int delayMinute;
    long newDTDDistance = -1L;
    int newDTDUnit = 255;
    int newDTDTypeOfDistance = 255;
    int newTTDTimeInfoType = 15;
    int newTTDNavigationTimeFormat = 0;
    int newTTDMinute = -1;
    int newTTDHour = -1;
    int newTTDDay = -1;
    int newTTDMonth = -1;
    int newTTDYear = -1;

    public CombiBAPSemiDynamicRouteInfo(boolean bl, boolean bl2, int n, int n2, long l, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10, int n11) {
        this.trafficImpactOnCurrentRoute = bl;
        this.alternativeRouteAvailable = bl2;
        this.delayHour = n;
        this.delayMinute = n2;
        this.newDTDDistance = l;
        this.newDTDUnit = n3;
        this.newDTDTypeOfDistance = n4;
        this.newTTDTimeInfoType = n5;
        this.newTTDNavigationTimeFormat = n6;
        this.newTTDMinute = n7;
        this.newTTDHour = n8;
        this.newTTDDay = n9;
        this.newTTDMonth = n10;
        this.newTTDYear = n11;
    }

    public CombiBAPSemiDynamicRouteInfo(boolean bl, boolean bl2, int n, int n2) {
        this.trafficImpactOnCurrentRoute = bl;
        this.alternativeRouteAvailable = bl2;
        this.delayHour = n;
        this.delayMinute = n2;
    }

    public void setDistanceToDestination(long l, int n, int n2) {
        this.newDTDDistance = l;
        this.newDTDUnit = n;
        this.newDTDTypeOfDistance = n2;
    }

    public void setTimeToDestination(int n, int n2, int n3, int n4, int n5, int n6, int n7) {
        this.newTTDTimeInfoType = n;
        this.newTTDNavigationTimeFormat = n2;
        this.newTTDMinute = n3;
        this.newTTDHour = n4;
        this.newTTDDay = n5;
        this.newTTDMonth = n6;
        this.newTTDYear = n7;
    }

    public boolean isTrafficImpactOnCurrentRoute() {
        return this.trafficImpactOnCurrentRoute;
    }

    public boolean isAlternativeRouteAvailable() {
        return this.alternativeRouteAvailable;
    }

    public int getDelayHour() {
        return this.delayHour;
    }

    public int getDelayMinute() {
        return this.delayMinute;
    }

    public long getNewDTDDistance() {
        return this.newDTDDistance;
    }

    public int getNewDTDUnit() {
        return this.newDTDUnit;
    }

    public int getNewDTDTypeOfDistance() {
        return this.newDTDTypeOfDistance;
    }

    public int getNewTTDTimeInfoType() {
        return this.newTTDTimeInfoType;
    }

    public int getNewTTDNavigationTimeFormat() {
        return this.newTTDNavigationTimeFormat;
    }

    public int getNewTTDMinute() {
        return this.newTTDMinute;
    }

    public int getNewTTDHour() {
        return this.newTTDHour;
    }

    public int getNewTTDDay() {
        return this.newTTDDay;
    }

    public int getNewTTDMonth() {
        return this.newTTDMonth;
    }

    public int getNewTTDYear() {
        return this.newTTDYear;
    }

    public boolean isNewDTDValid() {
        return this.newDTDDistance != -1L;
    }

    public boolean isNewTTDMinuteValid() {
        return this.newTTDMinute != -1;
    }

    public boolean isNewTTDHourValid() {
        return this.newTTDHour != -1;
    }

    public boolean isNewTTDDayValid() {
        return this.newTTDDay != -1;
    }

    public boolean isNewTTDMonthValid() {
        return this.newTTDMonth != -1;
    }

    public boolean isNewTTDYearValid() {
        return this.newTTDYear != -1;
    }
}

