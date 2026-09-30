/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media.data.search;

import de.audi.app.media.content.media.data.search.IDataMediaSearch;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.SpellerModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.search.AbstractGuiSearchHandler;
import de.audi.atip.search.AbstractSearch;
import de.audi.atip.search.util.SearchResultListRow;

public abstract class AbstractSearchHandler
extends AbstractGuiSearchHandler {
    protected final ChoiceModelApp availabilityChoice;

    public AbstractSearchHandler(LogChannel logChannel, BaseListModelApp baseListModelApp, SpellerModelApp spellerModelApp, ChoiceModelApp choiceModelApp, int[] nArray, AbstractSearch abstractSearch, ChoiceModelApp choiceModelApp2) {
        super(nArray, baseListModelApp, spellerModelApp, choiceModelApp, logChannel, abstractSearch);
        this.availabilityChoice = choiceModelApp2;
    }

    public void deinit() {
        this.lc.log(1000000, "[%1.deinit]", (Object)this.getLogClass());
        this.registryFormatter.clear();
    }

    public void activate() {
        this.lc.log(1000000, "[%1.activate]", (Object)this.getLogClass());
        this.registerListeners();
        this.reset();
    }

    public void deactivate() {
        this.lc.log(1000000, "[%1.deactivate]", (Object)this.getLogClass());
        this.appSearch.cancelQuery();
        this.release();
    }

    public void reset() {
        this.lc.log(1000000, "[%1.reset]", (Object)this.getLogClass());
        this.mdlSpellerSearchText.clear();
    }

    public void textChanged(int n, String string, char c2, int n2) {
        if (this.lc.isDebug()) {
            this.lc.log(10000000, "[%1.textChanged '%2']", (Object)this.getLogClass(), (Object)string);
        }
        this.appSearch.setActiveGuiSearchHandler(this);
        if (null != string && string.length() > 0) {
            super.textChanged(n, string, c2, n2);
        } else {
            this.appSearch.cancelQuery();
        }
    }

    public void refreshQuery() {
        String string = this.mdlSpellerSearchText.getText();
        if (null != string && string.length() > 0) {
            this.lc.log(1000000, "[%1.refreshQuery] text='%2'", (Object)this.getLogClass(), (Object)string);
            super.refreshQuery();
        }
    }

    public void updateListener() {
        this.registerListeners();
    }

    public void childNodeSelected(EvoListRow evoListRow, int n, int n2) {
    }

    public void requestChildrenNodes(SearchResultListRow searchResultListRow, int n) {
    }

    protected IDataMediaSearch getMediaSearch() {
        return (IDataMediaSearch)((Object)this.appSearch);
    }

    protected void setSourceDataAvailability(boolean bl) {
        boolean bl2;
        boolean bl3 = bl2 = this.availabilityChoice.getValue() == 1 != bl;
        if (bl2) {
            this.lc.log(1000000, "[%1.setSourceDataAvailability] '%2'", (Object)this.getLogClass(), (Object)String.valueOf(bl));
            this.availabilityChoice.setValue(bl ? 1 : 0);
            if (!bl) {
                this.appSearch.cancelQuery();
            }
        }
    }

    protected abstract String getLogClass();
}

