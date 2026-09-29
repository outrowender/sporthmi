/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets.menu;

import de.esolutions.hmi.widgets.audi.evo.high.widgets.IconRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.widgets.IconRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.SeparatingLineController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.SeparatingLines;

public class SeparatingLinesHigh
extends SeparatingLines {
    @Override
    protected IconRenderer createIconRenderer(SeparatingLineController separatingLineController) {
        IconRendererHigh iconRendererHigh = new IconRendererHigh(separatingLineController);
        iconRendererHigh.setAlignment(2, 5);
        return iconRendererHigh;
    }
}

