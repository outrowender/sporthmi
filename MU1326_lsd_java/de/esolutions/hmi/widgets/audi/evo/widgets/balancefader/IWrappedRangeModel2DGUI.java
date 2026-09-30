/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.balancefader;

import de.audi.atip.hmi.event.ATIPEvent;
import de.esolutions.hmi.widgets.audi.evo.widgets.balancefader.ValuePair;

public interface IWrappedRangeModel2DGUI {
    public ValuePair getPosition();

    public void setPosition(ValuePair var1);

    public ValuePair getSteps();

    public void updateModelSizeAndSteps();

    public ValuePair processEvent(ATIPEvent var1);
}

