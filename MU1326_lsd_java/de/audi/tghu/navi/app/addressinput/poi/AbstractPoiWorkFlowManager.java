/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi;

import de.audi.tghu.navi.app.addressinput.poi.IPoiWorkFlowManager;
import de.audi.tghu.navi.app.util.Util;

public abstract class AbstractPoiWorkFlowManager
implements IPoiWorkFlowManager {
    protected final String CLASS_NAME = Util.getClassNameFromPackageName(this.getClass());

    protected boolean isPoiMainScreen(int n) {
        return n >= 1 && n <= 100;
    }

    protected boolean isPoiResultScreenWithSpeller(int n) {
        return n >= 101 && n <= 200;
    }

    protected boolean isPoiResultScreenNoSpeller(int n) {
        return n >= 201 && n <= 300;
    }

    protected boolean isPoiResultScreenWithMatchSpeller(int n) {
        return n >= 301 && n <= 400;
    }

    protected boolean isPoiClassScreen(int n) {
        return n >= 401 && n <= 500;
    }

    protected boolean isPoiCategoryScreen(int n) {
        return n >= 501 && n <= 600;
    }

    protected boolean isPoiBrandScreen(int n) {
        return n >= 601 && n <= 700;
    }

    protected boolean isPoiBrandResultScreen(int n) {
        return n >= 701 && n <= 800;
    }

    protected boolean isPoiParentChildCategoryScreen(int n) {
        return n >= 1001 && n <= 1100;
    }

    protected boolean isPoiParentChildResultScreen(int n) {
        return n >= 1101 && n <= 1200;
    }

    protected boolean isPoiParkingNearDestinationScreen(int n) {
        return n >= 1201 && n <= 1300;
    }

    protected boolean isPoiSearchAreaCityScreen(int n) {
        return n >= 1301 && n <= 1400;
    }

    protected boolean isPoiFuelWarningScreen(int n) {
        return n >= 1601 && n <= 1700;
    }

    protected boolean isPoiDetailScreen(int n) {
        return n >= 1401 && n <= 1500;
    }

    protected boolean isPoiSDS(int n) {
        return n >= 1501 && n <= 1600;
    }
}

