/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.atip.utils.Preconditions
 *  de.audi.atip.utils.reactive.bindings.SilentModelBindings$ButtonListenerAdapter
 *  de.audi.atip.utils.reactive.bindings.SilentModelBindings$ChoiceModelBindingImpl
 *  de.audi.atip.utils.reactive.bindings.SilentModelBindings$LabelModelBindingImpl
 *  de.audi.atip.utils.reactive.bindings.SilentModelBindings$RangeModelBindingImpl
 *  de.audi.atip.utils.reactive.properties.LoggingPropertyFactory
 */
package de.audi.atip.utils.reactive.bindings;

import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.hmi.modelaccess.RangeModelApp;
import de.audi.atip.utils.Preconditions;
import de.audi.atip.utils.reactive.Disposable;
import de.audi.atip.utils.reactive.bindings.ModelBindings;
import de.audi.atip.utils.reactive.bindings.ModelBindings$ButtonModelBinding;
import de.audi.atip.utils.reactive.bindings.ModelBindings$ChoiceModelBinding;
import de.audi.atip.utils.reactive.bindings.ModelBindings$LabelModelBinding;
import de.audi.atip.utils.reactive.bindings.ModelBindings$RangeModelBinding;
import de.audi.atip.utils.reactive.bindings.SilentModelBindings;
import de.audi.atip.utils.reactive.bindings.SilentModelBindings$ButtonModelBindingImpl;
import de.audi.atip.utils.reactive.bindings.SilentModelBindings$ChoiceListenerAdapter;
import de.audi.atip.utils.reactive.bindings.SilentModelBindings$RangeListenerAdapter;
import de.audi.atip.utils.reactive.properties.LoggingPropertyFactory;

public class SilentModelBindings
implements Disposable,
ModelBindings {
    private final LoggingPropertyFactory propertyFactory;

    public static ModelBindings create() {
        return new SilentModelBindings(LoggingPropertyFactory.create());
    }

    protected SilentModelBindings(LoggingPropertyFactory loggingPropertyFactory) {
        this.propertyFactory = (LoggingPropertyFactory)Preconditions.checkNotNull((Object)loggingPropertyFactory);
    }

    @Override
    public ModelBindings$ButtonModelBinding from(ButtonModelApp buttonModelApp) {
        return new SilentModelBindings$ButtonModelBindingImpl(new ButtonListenerAdapter(this, buttonModelApp));
    }

    @Override
    public ModelBindings$ChoiceModelBinding from(ChoiceModelApp choiceModelApp) {
        return new ChoiceModelBindingImpl(choiceModelApp, new SilentModelBindings$ChoiceListenerAdapter(this, choiceModelApp));
    }

    @Override
    public ModelBindings$LabelModelBinding from(LabelModelApp labelModelApp) {
        return new LabelModelBindingImpl(labelModelApp);
    }

    @Override
    public ModelBindings$RangeModelBinding from(RangeModelApp rangeModelApp) {
        return new RangeModelBindingImpl(rangeModelApp, new SilentModelBindings$RangeListenerAdapter(this, rangeModelApp));
    }

    @Override
    public void dispose() {
        this.propertyFactory.dispose();
    }

    static /* synthetic */ LoggingPropertyFactory access$000(SilentModelBindings silentModelBindings) {
        return silentModelBindings.propertyFactory;
    }
}

