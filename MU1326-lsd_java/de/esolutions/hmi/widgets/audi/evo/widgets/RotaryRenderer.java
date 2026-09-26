/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.esolutions.hmi.widgets.audi.base.HMITerminalImpl;
import de.esolutions.hmi.widgets.audi.base.PreferredSize;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;

public interface RotaryRenderer
extends IRenderer,
PreferredSize {
    default public int getPreferredWidth(HMITerminalImpl hMITerminalImpl) {
    }

    default public int getPreferredHeight(HMITerminalImpl hMITerminalImpl) {
    }
}

