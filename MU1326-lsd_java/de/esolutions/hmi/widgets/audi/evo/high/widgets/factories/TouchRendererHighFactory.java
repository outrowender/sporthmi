/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets.factories;

import de.esolutions.hmi.widgets.audi.evo.high.widgets.TouchRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.TouchRendererHighArabia;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.asia.TouchRendererHighAsia;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchController;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchControllerArabia;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.TouchControllerAsia;

public final class TouchRendererHighFactory {
    private TouchRendererHighFactory() {
    }

    public static TouchRendererHigh create(TouchController touchController) {
        if (touchController instanceof TouchControllerArabia) {
            return new TouchRendererHighArabia((TouchControllerArabia)touchController);
        }
        if (touchController instanceof TouchControllerAsia) {
            return new TouchRendererHighAsia((TouchControllerAsia)touchController);
        }
        return new TouchRendererHigh(touchController);
    }
}

