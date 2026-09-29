/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.factories;

import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.evo.widgets.FingerTraceController;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.FingerTraceControllerAsia;

public final class FingerTraceControllerFactory {
    private FingerTraceControllerFactory() {
    }

    public static FingerTraceController create() {
        if (AbstractWidget.isAsia()) {
            return new FingerTraceControllerAsia();
        }
        return new FingerTraceController();
    }
}

