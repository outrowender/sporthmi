/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.data.search;

import de.audi.app.media.content.media.data.search.AbstractSearchHandler;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.SpellerModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.search.AbstractSearch;
import de.audi.atip.search.util.SearchResultListRow;

public abstract class AbstractSearchHandlerEvo
extends AbstractSearchHandler {
    private static final int DISPLAY_NORMAL_LIST = 0;
    private static final int DISPLAY_SEARCHRESULT_LIST = 1;
    static final int ITEM_NOTSELECTED = 0;
    static final int ITEM_SELECTED = 1;
    protected final ChoiceModelApp displaySearchResultList;

    public AbstractSearchHandlerEvo(LogChannel logChannel, BaseListModelApp baseListModelApp, SpellerModelApp spellerModelApp, ChoiceModelApp choiceModelApp, ChoiceModelApp choiceModelApp2, int[] nArray, AbstractSearch abstractSearch, ChoiceModelApp choiceModelApp3) {
        super(logChannel, baseListModelApp, spellerModelApp, choiceModelApp, nArray, abstractSearch, choiceModelApp3);
        this.displaySearchResultList = choiceModelApp2;
    }

    public void init() {
        this.configureSuggestions(false, true);
    }

    public void reset() {
        if (this.lc.isDebug2()) {
            this.lc.log(100000000, "[%1.reset]", (Object)this.getLogClass());
        }
        this.displaySearchResultList.setValue(0);
        super.reset();
    }

    public synchronized void searchStarted() {
        super.searchStarted();
        this.lc.log(1000000, "[%1.searchStarted]", (Object)this.getLogClass());
        if (this.mdlSpellerSearchText.getText() != null && this.mdlSpellerSearchText.getText().length() > 0) {
            this.displaySearchResultList.setValue(1);
        } else {
            this.appSearch.cancelQuery();
            this.displaySearchResultList.setValue(0);
        }
    }

    public void textChanged(int n, String string, char c2, int n2) {
        this.lc.log(1000000, "[%1.textChanged '%2']", (Object)this.getLogClass(), (Object)string);
        if (null != string && string.length() > 0) {
            this.searchEntered();
            if (string.length() > 2 && string.indexOf(32) > 0) {
                this.getMediaSearch().setSearchFilterType(2);
            } else {
                this.getMediaSearch().setSearchFilterType(1);
            }
            super.textChanged(n, string, c2, n2);
        } else {
            this.appSearch.cancelQuery();
            this.displaySearchResultList.setValue(0);
        }
    }

    protected void searchEntered() {
    }

    protected void showNormalList() {
        this.lc.log(1000000, "[%1.showNormalList]", (Object)this.getLogClass());
        this.displaySearchResultList.setValue(0);
    }

    public void keyTyped(int n, int n2, int n3) {
        if (this.mdlListSearchResults.getLength() == 1) {
            this.searchResultSelected((SearchResultListRow)this.mdlListSearchResults.getRow(0), n3, n);
        }
        super.keyTyped(n, n2, n3);
    }
}

