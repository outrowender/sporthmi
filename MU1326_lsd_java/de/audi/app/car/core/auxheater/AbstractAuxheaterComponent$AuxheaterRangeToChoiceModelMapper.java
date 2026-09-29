/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.auxheater;

import de.audi.app.car.core.app.AbstractRangeToChoiceModelMapper;
import de.audi.app.car.core.auxheater.AbstractAuxheaterComponent;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;

final class AbstractAuxheaterComponent$AuxheaterRangeToChoiceModelMapper
extends AbstractRangeToChoiceModelMapper {
    private static final int OFF;
    private static final int ON;
    private final /* synthetic */ AbstractAuxheaterComponent this$0;

    public AbstractAuxheaterComponent$AuxheaterRangeToChoiceModelMapper(AbstractAuxheaterComponent abstractAuxheaterComponent, ChoiceModelApp choiceModelApp, int n, int n2, int n3) {
        this.this$0 = abstractAuxheaterComponent;
        super(choiceModelApp, n, n2, n3);
    }

    @Override
    public int getMapping(int n) {
        return 0 < n ? 1 : 0;
    }
}

