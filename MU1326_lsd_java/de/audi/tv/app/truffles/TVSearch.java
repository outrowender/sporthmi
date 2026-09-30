/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.truffles;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.atip.search.AbstractGuiSearchHandler;
import de.audi.atip.search.AbstractSearch;
import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.truffles.ISearchGUI;
import de.audi.tv.app.truffles.ITVSearch;
import org.dsi.ifc.search.ConflictMatch;
import org.osgi.framework.BundleContext;

public class TVSearch
extends AbstractSearch
implements ITVSearch {
    private static final String LOGCLASS = (class$de$audi$tv$app$truffles$TVSearch == null ? (class$de$audi$tv$app$truffles$TVSearch = TVSearch.class$("de.audi.tv.app.truffles.TVSearch")) : class$de$audi$tv$app$truffles$TVSearch).getName();
    private final TVEnv env;
    private boolean ignoreUpdateSearchIsActive = false;
    static /* synthetic */ Class class$de$audi$tv$app$truffles$TVSearch;

    public TVSearch(BundleContext bundleContext, IFrameworkAccess iFrameworkAccess, LogChannel logChannel, TVEnv tVEnv) {
        super(bundleContext, iFrameworkAccess, logChannel, 10);
        this.env = tVEnv;
        this.init();
    }

    public final void init() {
        this.logChannel.log(1000000, "[%1.init]", (Object)LOGCLASS);
        this.startDSI();
    }

    public final void deinit() {
        this.logChannel.log(1000000, "[%1.deinit]", (Object)LOGCLASS);
        this.stopDSI();
    }

    protected void initDSI() {
        super.initDSI();
        this.env.getChoiceModel(2600121).setValue(1);
    }

    public void setActiveGuiSearchHandler(ISearchGUI iSearchGUI) {
        super.setActiveGuiSearchHandler((AbstractGuiSearchHandler)((Object)iSearchGUI));
    }

    public void cancelQuerry() {
        super.cancelQuery();
    }

    public void setEnvironmentResult(int n) {
    }

    public void updateSearchIsActive(boolean bl, int n) {
        if (!this.ignoreUpdateSearchIsActive || bl) {
            super.updateSearchIsActive(bl, n);
        }
        this.ignoreUpdateSearchIsActive = false;
    }

    public void updateSearchIsActive(int n, boolean bl, int n2) {
        this.updateSearchIsActive(bl, n2);
    }

    public void setIgnoreSearchIsActive(boolean bl) {
        this.ignoreUpdateSearchIsActive = bl;
    }

    public void removeAllFromHistoryBySourceResult(int n) {
    }

    public int getSearchId() {
        return 10;
    }

    public void cancelQueryResult(int n, int n2) {
        this.cancelQueryResult(n2);
    }

    public void updatePotentialConflict(int n, boolean bl, ConflictMatch conflictMatch, int n2) {
    }

    public void updateProfileState(int n, int n2, int n3) {
    }

    public void profileChanged(int n, int n2) {
    }

    public void profileCopied(int n, int n2, int n3) {
    }

    public void profileReset(int n, int n2) {
    }

    public void profileResetAll(int n) {
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

