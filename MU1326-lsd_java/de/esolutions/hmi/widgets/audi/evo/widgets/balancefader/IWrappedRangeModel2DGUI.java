/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.balancefader;

import de.audi.atip.hmi.event.ATIPEvent;
import de.esolutions.hmi.widgets.audi.evo.widgets.balancefader.ValuePair;

public interface IWrappedRangeModel2DGUI {
    default public ValuePair getPosition() {
    }

    default public void setPosition(ValuePair valuePair) {
    }

    default public ValuePair getSteps() {
    }

    default public void updateModelSizeAndSteps() {
    }

    default public ValuePair processEvent(ATIPEvent aTIPEvent) {
    }
}

