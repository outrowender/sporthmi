/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.evo.widgets.ReusableInstanceCache$AbstractInstanceFactory;
import de.esolutions.hmi.widgets.audi.evo.widgets.ReusableInstanceCache$IReusable;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$AbstractExpandableItem$Char;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$AbstractExpandableItem$CharSet;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$ButtonItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$SingleCharItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$ToggleCharsetButtonItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$ToggleToSpellerButtonItem;

final class SpellerController$3
extends ReusableInstanceCache$AbstractInstanceFactory {
    SpellerController$3() {
    }

    @Override
    public ReusableInstanceCache$IReusable newInstance(String string) {
        if ("SingleCharItem".equals(string)) {
            return new SpellerController$SingleCharItem(null);
        }
        if ("ExpandableItem.Char".equals(string)) {
            return new SpellerController$AbstractExpandableItem$Char(null);
        }
        if ("ExpandableItem.CharSet".equals(string)) {
            return new SpellerController$AbstractExpandableItem$CharSet(null);
        }
        if ("ButtonItem".equals(string)) {
            return new SpellerController$ButtonItem(null);
        }
        if ("ToggleCharsetButtonItem".equals(string)) {
            return new SpellerController$ToggleCharsetButtonItem(null);
        }
        if ("ToggleToSpellerButtonItem".equals(string)) {
            return new SpellerController$ToggleToSpellerButtonItem(null);
        }
        IWidgetLogChannel.tpLogChannelInternal.log(10000, "SpellerController.AbstractInstanceFactory#newInstance: Could not create speller item, unkown type key %1.", (Object)string);
        return null;
    }
}

