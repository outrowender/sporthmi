/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.statemachine.mediator;

import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.hmi.modelaccess.ButtonModelGUI;
import de.audi.atip.hmi.modelaccess.ChoiceModelGUI;
import de.audi.atip.hmi.modelaccess.LabelModelGUI;
import de.audi.atip.hmi.modelaccess.MatchspellerModelGUI;
import de.audi.atip.hmi.modelaccess.RangeModelGUI;
import de.audi.atip.hmi.modelaccess.SpellerModelGUI;
import de.audi.atip.hmi.modelaccess.TextfieldModelGUI;
import de.audi.atip.statemachine.mediator.AbstractDataBuffer$ButtonDataBuffer;
import de.audi.atip.statemachine.mediator.AbstractDataBuffer$ChoiceDataBuffer;
import de.audi.atip.statemachine.mediator.AbstractDataBuffer$DefaultDataBuffer;
import de.audi.atip.statemachine.mediator.AbstractDataBuffer$LabelDataBuffer;
import de.audi.atip.statemachine.mediator.AbstractDataBuffer$MatchSpellerDataBuffer;
import de.audi.atip.statemachine.mediator.AbstractDataBuffer$RangeDataBuffer;
import de.audi.atip.statemachine.mediator.AbstractDataBuffer$SpellerDataBuffer;
import de.audi.atip.statemachine.mediator.AbstractDataBuffer$TextfieldDataBuffer;

abstract class AbstractDataBuffer {
    AbstractDataBuffer() {
    }

    public static AbstractDataBuffer createDataBuffer(HMIModel hMIModel) {
        if (hMIModel == null) {
            return null;
        }
        int n = hMIModel.getModelType();
        switch (n) {
            case 1: {
                return new AbstractDataBuffer$ButtonDataBuffer((ButtonModelGUI)((Object)hMIModel));
            }
            case 2: {
                return new AbstractDataBuffer$ChoiceDataBuffer((ChoiceModelGUI)((Object)hMIModel));
            }
            case 3: {
                return new AbstractDataBuffer$LabelDataBuffer((LabelModelGUI)((Object)hMIModel));
            }
            case 7: {
                return new AbstractDataBuffer$MatchSpellerDataBuffer((MatchspellerModelGUI)((Object)hMIModel));
            }
            case 5: {
                return new AbstractDataBuffer$RangeDataBuffer((RangeModelGUI)((Object)hMIModel));
            }
            case 6: {
                return new AbstractDataBuffer$SpellerDataBuffer((SpellerModelGUI)((Object)hMIModel));
            }
            case 8: {
                return new AbstractDataBuffer$TextfieldDataBuffer((TextfieldModelGUI)((Object)hMIModel));
            }
        }
        return new AbstractDataBuffer$DefaultDataBuffer(null);
    }

    public abstract boolean valueChanged(HMIModel hMIModel) {
    }
}

