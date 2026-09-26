/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.charisma;

import de.audi.app.car.common.handler.ChoiceModelHandler;
import de.audi.app.car.common.handler.business.ChoiceModelEventBusinessAdapter;
import de.audi.atip.log.LogChannel;

public class CharismaAddInfoConfigChoiceListenerBusiness
extends ChoiceModelEventBusinessAdapter {
    public CharismaAddInfoConfigChoiceListenerBusiness(LogChannel logChannel) {
        super(null, logChannel);
    }

    @Override
    public boolean processItemSelected(int n, ChoiceModelHandler choiceModelHandler) {
        if (choiceModelHandler != null) {
            choiceModelHandler.updateChoiceModelValue(n);
            return true;
        }
        return false;
    }
}

