/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.asia;

import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.evo.widgets.ReusableInstanceCache$AbstractInstanceFactory;
import de.esolutions.hmi.widgets.audi.evo.widgets.ReusableInstanceCache$IReusable;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.AbstractConversionWidgetController$MultiCharItem;

final class AbstractConversionWidgetController$1
extends ReusableInstanceCache$AbstractInstanceFactory {
    AbstractConversionWidgetController$1() {
    }

    @Override
    public ReusableInstanceCache$IReusable newInstance(String string) {
        if (!string.equals("ConversionLineController.MultiCharItem")) {
            IWidgetLogChannel.tpLogChannelInternal.log(-1601830656, "ConversionLineController#IInstanceFactory.newInstance: unkown type key '%1'. Returning a MultiCharItem.", (Object)string);
        }
        return new AbstractConversionWidgetController$MultiCharItem();
    }
}

