/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.asia;

import de.audi.atip.util.StringUtilities;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.hmi.widgets.audi.evo.widgets.ReusableInstanceCache$IReusable;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$ButtonItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$ICharacterSpellerItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$ISpellerItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$SingleCharItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$SpellerButtonType;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$ToggleToSpellerButtonItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchCharSetAndTTSHandler;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.ITouchResultLine;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.SpellerControllerAsia;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

public class SpellerControllerAsia$TouchResultsLine
implements ITouchResultLine {
    protected static final int CLOSE_BUTTON_INDEX;
    protected static final int TOGGLE_BUTTON_INDEX;
    protected static final int SPACE_ITEM_INDEX;
    protected static final int DELETE_BUTTON_INDEX;
    private static final int DEFAULT_MAX_TOUCHRESULTS;
    protected final int maxTouchResults;
    protected List items;
    private SpellerController$ISpellerItem currentFocusedItem;
    private boolean upperCase;
    private SpellerController$ISpellerItem spaceCharItem;
    protected final SpellerControllerAsia speller;

    protected SpellerControllerAsia$TouchResultsLine(SpellerControllerAsia spellerControllerAsia, int n) {
        this.items = new ArrayList(this.getAmountOfStaticItems() + n);
        this.items.add(SpellerController$ButtonItem.createInstance(SpellerController$SpellerButtonType.CLOSE));
        this.items.add(SpellerController$ToggleToSpellerButtonItem.createInstance(SpellerControllerAsia.access$500(spellerControllerAsia)));
        this.spaceCharItem = SpellerController$SingleCharItem.createInstance(" ", " ");
        this.items.add(this.spaceCharItem);
        this.items.add(SpellerController$ButtonItem.createInstance(SpellerController$SpellerButtonType.DELETE));
        this.upperCase = true;
        this.currentFocusedItem = (SpellerController$ISpellerItem)this.items.get(0);
        this.maxTouchResults = n;
        this.speller = spellerControllerAsia;
    }

    protected SpellerControllerAsia$TouchResultsLine(SpellerControllerAsia spellerControllerAsia) {
        this(spellerControllerAsia, 5);
    }

    @Override
    public boolean isResultItem(SpellerController$ISpellerItem spellerController$ISpellerItem) {
        if (!this.items.contains(spellerController$ISpellerItem)) {
            return false;
        }
        return spellerController$ISpellerItem instanceof SpellerController$ICharacterSpellerItem && this.items.indexOf(spellerController$ISpellerItem) > 3;
    }

    @Override
    public void updateToggleButton(TouchCharSetAndTTSHandler touchCharSetAndTTSHandler) {
        SpellerController$ISpellerItem spellerController$ISpellerItem = this.getToggleButton();
        if (spellerController$ISpellerItem instanceof SpellerController$ToggleToSpellerButtonItem) {
            ((SpellerController$ToggleToSpellerButtonItem)spellerController$ISpellerItem).setTouchCharSetAndTTSHandler(touchCharSetAndTTSHandler);
        }
    }

    @Override
    public boolean isToggleButton(SpellerController$ISpellerItem spellerController$ISpellerItem) {
        return this.items.get(1) == spellerController$ISpellerItem;
    }

    @Override
    public SpellerController$ISpellerItem getToggleButton() {
        return (SpellerController$ISpellerItem)this.items.get(1);
    }

    @Override
    public SpellerController$ICharacterSpellerItem getSpaceItem() {
        return (SpellerController$ICharacterSpellerItem)this.items.get(2);
    }

    @Override
    public List getSpellerItems() {
        return this.items;
    }

    @Override
    public SpellerController$ISpellerItem getCurrentFocusedItem() {
        return this.currentFocusedItem;
    }

    @Override
    public void setCurrentFocusedItem(SpellerController$ISpellerItem spellerController$ISpellerItem) {
        this.currentFocusedItem = spellerController$ISpellerItem;
    }

    @Override
    public SpellerController$ISpellerItem getOkItem() {
        return null;
    }

    @Override
    public SpellerController$ISpellerItem getCloseButton() {
        return (SpellerController$ISpellerItem)this.items.get(0);
    }

    @Override
    public SpellerController$ISpellerItem getDeleteButton() {
        return (SpellerController$ISpellerItem)this.items.get(3);
    }

    @Override
    public SpellerController$ISpellerItem getDeleteButtonNeighbor() {
        return this.hasResultItems() ? (SpellerController$ISpellerItem)this.items.get(4) : null;
    }

    @Override
    public boolean isUpperCase() {
        return this.upperCase;
    }

    @Override
    public void setIsUpperCase(boolean bl) {
        this.upperCase = bl;
    }

    @Override
    public void setResultItems(List list) {
        this.deleteOldResultItemsIfPresent();
        if (list.size() > 1) {
            Iterator iterator = list.iterator();
            for (int i2 = 0; iterator.hasNext() && i2 < this.maxTouchResults; ++i2) {
                String string = (String)iterator.next();
                this.items.add(SpellerController$SingleCharItem.createInstance(string));
            }
        }
        SpellerControllerAsia.access$600(this.speller, this);
    }

    @Override
    public void setResultItems(String string) {
        this.deleteOldResultItemsIfPresent();
        String string2 = SpellerControllerAsia$TouchResultsLine.hasDuplicates(string) ? SpellerControllerAsia$TouchResultsLine.removeDuplicateCharacters(string) : string;
        int n = string2.length();
        if (n > 1) {
            for (int i2 = 0; i2 < n && i2 < this.maxTouchResults; ++i2) {
                String string3 = string2.substring(i2, i2 + 1);
                this.items.add(SpellerController$SingleCharItem.createInstance(string3));
            }
        }
        SpellerControllerAsia.access$700(this.speller, this);
    }

    private static boolean hasDuplicates(String string) {
        if (StringUtilities.isNullOrEmpty(string) || string.length() == 1) {
            return false;
        }
        char[] cArray = string.toCharArray();
        for (int i2 = 0; i2 < cArray.length; ++i2) {
            char c2 = cArray[i2];
            for (int i3 = i2 + 1; i3 < cArray.length; ++i3) {
                if (c2 != cArray[i3]) continue;
                return true;
            }
        }
        return false;
    }

    protected static String removeDuplicateCharacters(String string) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (int i2 = 0; i2 < string.length(); ++i2) {
            linkedHashSet.add(new Character(string.charAt(i2)));
        }
        Buffer buffer = new Buffer();
        Iterator iterator = linkedHashSet.iterator();
        while (iterator.hasNext()) {
            buffer.append(iterator.next());
        }
        return buffer.toString();
    }

    protected final void setCurrentFocusedItem(int n) {
        this.setCurrentFocusedItem((SpellerController$ISpellerItem)this.items.get(n));
    }

    @Override
    public void deleteOldResultItemsIfPresent() {
        if (this.hasResultItems()) {
            for (int i2 = this.items.size() - 1; i2 >= this.getAmountOfStaticItems(); --i2) {
                ReusableInstanceCache$IReusable reusableInstanceCache$IReusable = (ReusableInstanceCache$IReusable)this.items.remove(i2);
                SpellerControllerAsia.access$800(reusableInstanceCache$IReusable);
            }
        }
    }

    @Override
    public final boolean hasResultItems() {
        return this.items.size() > this.getAmountOfStaticItems();
    }

    protected int getAmountOfStaticItems() {
        return 4;
    }

    @Override
    public void resetInitialItem(boolean bl) {
        if (this.hasResultItems()) {
            this.setCurrentFocusedItem(this.getAmountOfStaticItems());
        } else {
            this.setCurrentFocusedItem(3);
        }
    }

    @Override
    public boolean hasMovingDeleteButton() {
        return false;
    }

    @Override
    public void itemPressed(SpellerController$ISpellerItem spellerController$ISpellerItem) {
    }

    @Override
    public String getFirstResultOrEmptyString() {
        if (!this.hasResultItems()) {
            return "";
        }
        return ((SpellerController$SingleCharItem)this.items.get(this.getAmountOfStaticItems())).getChar(true);
    }

    @Override
    public void autoCompletionAccepted() {
        this.setResultItems("");
    }

    @Override
    public void setSpaceItemEnabled(boolean bl) {
        this.spaceCharItem.setEnabled(bl);
    }

    @Override
    public void free(boolean bl) {
        if (bl) {
            SpellerControllerAsia.access$900(this.items);
            this.items = Collections.EMPTY_LIST;
        }
    }

    @Override
    public List getResultItems() {
        if (!this.hasResultItems()) {
            return Collections.EMPTY_LIST;
        }
        return this.items.subList(this.getAmountOfStaticItems(), this.items.size());
    }

    @Override
    public SpellerController$ISpellerItem getLeftButton() {
        return null;
    }

    @Override
    public SpellerController$ISpellerItem getRightButton() {
        return null;
    }
}

