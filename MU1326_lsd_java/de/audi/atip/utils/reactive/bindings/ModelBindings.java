/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.reactive.bindings;

import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.hmi.modelaccess.RangeModelApp;
import de.audi.atip.utils.reactive.bindings.ModelBindings$ButtonModelBinding;
import de.audi.atip.utils.reactive.bindings.ModelBindings$ChoiceModelBinding;
import de.audi.atip.utils.reactive.bindings.ModelBindings$LabelModelBinding;
import de.audi.atip.utils.reactive.bindings.ModelBindings$RangeModelBinding;

public interface ModelBindings {
    default public ModelBindings$ButtonModelBinding from(ButtonModelApp buttonModelApp) {
    }

    default public ModelBindings$ChoiceModelBinding from(ChoiceModelApp choiceModelApp) {
    }

    default public LabelModelBinding from(LabelModelApp labelModelApp) {
    }

    default public RangeModelBinding from(RangeModelApp rangeModelApp) {
    }
}

