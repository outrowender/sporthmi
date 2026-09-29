/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.asia;

import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$ButtonItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$ISpellerItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$SingleCharItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$SpellerButtonType;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.ITouchPredictionLine;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.IWordPredictionDataFetcher;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.SpellerControllerAsia;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.SpellerControllerAsia$TouchResultsLine;
import java.util.Iterator;
import java.util.List;

public final class SpellerControllerAsia$TouchPredictionLine
extends SpellerControllerAsia$TouchResultsLine
implements ITouchPredictionLine {
    private final IWordPredictionDataFetcher wordPredictionDataFetcher;
    private boolean outdatedData = false;
    private boolean isTruffleSearchMode = false;
    private SpellerController$ButtonItem truffleButton = null;
    private int lastTimeFocusItem = 3;

    public SpellerControllerAsia$TouchPredictionLine(SpellerControllerAsia spellerControllerAsia, IWordPredictionDataFetcher iWordPredictionDataFetcher, boolean bl) {
        this(spellerControllerAsia, iWordPredictionDataFetcher, 20, bl);
    }

    protected SpellerControllerAsia$TouchPredictionLine(SpellerControllerAsia spellerControllerAsia, IWordPredictionDataFetcher iWordPredictionDataFetcher, int n, boolean bl) {
        super(spellerControllerAsia, n);
        this.isTruffleSearchMode = bl;
        if (bl) {
            this.truffleButton = SpellerController$ButtonItem.createInstance(SpellerController$SpellerButtonType.ASIA_ACCEPT_TRUFFLE_SUGGESTION);
            this.items.add(this.truffleButton);
            this.truffleButton.setEnabled(false);
        }
        this.wordPredictionDataFetcher = iWordPredictionDataFetcher == null ? IWordPredictionDataFetcher.NULL : iWordPredictionDataFetcher;
    }

    @Override
    public void itemPressed(SpellerController$ISpellerItem spellerController$ISpellerItem) {
        this.lastTimeFocusItem = this.items.indexOf(spellerController$ISpellerItem);
        if (this.lastTimeFocusItem > 3 || this.lastTimeFocusItem < 2) {
            this.lastTimeFocusItem = 3;
        }
    }

    @Override
    public void resetInitialItem(boolean bl) {
        if (this.hasResultItems()) {
            super.resetInitialItem(bl);
        } else {
            this.setCurrentFocusedItem(this.lastTimeFocusItem);
        }
    }

    @Override
    public void updateWordPredictionContext(String string, String string2) {
        this.wordPredictionDataFetcher.updateWordPredictionContext(string, string2, 20);
    }

    @Override
    public void setResultItems(List list) {
        this.deleteOldResultItemsIfPresent();
        if (!list.isEmpty()) {
            Iterator iterator = list.iterator();
            for (int i2 = 0; iterator.hasNext() && i2 < this.maxTouchResults; ++i2) {
                String string = (String)iterator.next();
                this.items.add(SpellerController$SingleCharItem.createInstance(string));
            }
        }
        SpellerControllerAsia.access$1000(this.speller, this);
        this.setOutdatedData(false);
    }

    @Override
    public void clear() {
        this.deleteOldResultItemsIfPresent();
    }

    public boolean isOutdatedData() {
        return this.outdatedData;
    }

    public void setOutdatedData(boolean bl) {
        this.outdatedData = bl;
    }

    @Override
    protected int getAmountOfStaticItems() {
        int n = super.getAmountOfStaticItems();
        return this.isTruffleSearchMode ? n + 1 : n;
    }

    @Override
    public void onSuggestionChange(boolean bl) {
        if (this.truffleButton != null) {
            this.truffleButton.setEnabled(bl);
        }
    }

    @Override
    public SpellerController$ISpellerItem getTruffleButton() {
        return this.truffleButton;
    }

    public IWordPredictionDataFetcher getWordPredictionDataFetcher() {
        return this.wordPredictionDataFetcher;
    }
}

