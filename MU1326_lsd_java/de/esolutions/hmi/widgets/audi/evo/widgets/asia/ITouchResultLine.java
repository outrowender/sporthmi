/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.asia;

import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchCharSetAndTTSHandler;
import java.util.List;

public interface ITouchResultLine
extends SpellerController.ISpellerBand {
    public void updateToggleButton(TouchCharSetAndTTSHandler var1);

    public boolean isToggleButton(SpellerController.ISpellerItem var1);

    public SpellerController.ISpellerItem getToggleButton();

    public SpellerController.ICharacterSpellerItem getSpaceItem();

    public void deleteOldResultItemsIfPresent();

    public void setSpaceItemEnabled(boolean var1);

    public void setResultItems(String var1);

    public void setResultItems(List var1);

    public boolean isResultItem(SpellerController.ISpellerItem var1);

    public String getFirstResultOrEmptyString();

    public boolean hasResultItems();

    public List getResultItems();
}

