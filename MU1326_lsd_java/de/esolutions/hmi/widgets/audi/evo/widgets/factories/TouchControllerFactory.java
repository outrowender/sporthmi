/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.factories;

import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.WordPredictionAccess;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchController;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchControllerArabia;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.IPartialConversionHelper;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.ITouchInputDataAsia;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.PartialConversionHelperWithUndoImpl;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.PartialConversionHelperWithoutUndoImpl;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.TouchControllerAsia;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.TouchInputDataAsia;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.TouchInputDataKorean;

public final class TouchControllerFactory {
    private static final IPartialConversionHelper partialConversionHelper = TouchControllerFactory.getPartialConversionImpl();

    private TouchControllerFactory() {
    }

    public static TouchController create() {
        boolean bl;
        int n = AbstractWidget.framework.getSysConst(4518);
        boolean bl2 = bl = n == 1;
        if (AbstractWidget.isArabia()) {
            return new TouchControllerArabia();
        }
        if (AbstractWidget.isKr() && !bl) {
            return TouchControllerFactory.createTouchControllerAsia(new TouchInputDataKorean(), bl);
        }
        if (AbstractWidget.isAsia()) {
            return TouchControllerFactory.createTouchControllerAsia(new TouchInputDataAsia(), bl);
        }
        return new TouchController();
    }

    private static TouchController createTouchControllerAsia(ITouchInputDataAsia iTouchInputDataAsia, boolean bl) {
        TouchControllerAsia touchControllerAsia = new TouchControllerAsia(iTouchInputDataAsia, bl, partialConversionHelper);
        if (bl) {
            touchControllerAsia.setWordPredictionAccess(new WordPredictionAccess(touchControllerAsia));
        }
        return touchControllerAsia;
    }

    private static IPartialConversionHelper getPartialConversionImpl() {
        if (AbstractWidget.isCN() || AbstractWidget.isTW()) {
            return new PartialConversionHelperWithUndoImpl();
        }
        return new PartialConversionHelperWithoutUndoImpl();
    }
}

