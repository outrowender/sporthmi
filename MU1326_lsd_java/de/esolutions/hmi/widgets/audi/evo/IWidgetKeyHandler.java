/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo;

import de.audi.atip.hmi.event.JoystickEvent;
import de.audi.atip.hmi.event.KeyEvent;
import de.audi.atip.hmi.event.WheelButtonEvent;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;

public interface IWidgetKeyHandler {
    public void keyPressed(AbstractWidgetController var1, KeyEvent var2);

    public void keyReleased(AbstractWidgetController var1, KeyEvent var2);

    public void keyTurned(AbstractWidgetController var1, WheelButtonEvent var2);

    public void keyMoved(AbstractWidgetController var1, JoystickEvent var2);
}

