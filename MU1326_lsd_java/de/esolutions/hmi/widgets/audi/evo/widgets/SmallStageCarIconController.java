/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.evo.widgets.IconController;

public class SmallStageCarIconController
extends IconController {
    public void processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
    }

    public int getBitmap(int n) {
        int n2 = this.terminal.getCarCodingHelper().getCarType();
        boolean bl = AbstractWidget.isRightHandDrive();
        if (n2 == 20) {
            n = bl ? 0 : 1;
        } else if (n2 == 21) {
            n = bl ? 2 : 3;
        } else if (this.terminal.getCarCodingHelper().isR8()) {
            n = bl ? 4 : 5;
        }
        return super.getBitmap(n);
    }
}

