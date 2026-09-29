/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.handler;

import de.audi.app.car.common.handler.ButtonModelHandler;
import de.audi.app.car.common.handler.business.Range2DModelEventBusiness;
import de.audi.atip.hmi.modelaccess.RangeModel2DApp;

public interface Range2DModelHandler
extends ButtonModelHandler {
    default public void updateOnAdjustment(int n, int n2) {
    }

    default public RangeModel2DApp getRange2DModel() {
    }

    default public Range2DModelEventBusiness getRange2DEventBusiness() {
    }

    default public void updateRangeModel2DLimits(int n, int n2, int n3, int n4, int n5, int n6) {
    }

    default public void updateRangeModel2DLimitsX(int n, int n2, int n3) {
    }

    default public void updateRangeModel2DLimitsY(int n, int n2, int n3) {
    }

    default public void updateRange2DModelValue(int n, int n2) {
    }

    default public void updateRangeModelValueX(int n) {
    }

    default public void updateRangeModelValueY(int n) {
    }
}

