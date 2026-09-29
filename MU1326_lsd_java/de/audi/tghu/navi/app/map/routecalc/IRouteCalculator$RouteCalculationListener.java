/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.routecalc;

public interface IRouteCalculator$RouteCalculationListener {
    default public void onMatchFound() {
    }

    default public void onAllMatchFound(int n) {
    }

    default public void onFailedCalculation() {
    }
}

