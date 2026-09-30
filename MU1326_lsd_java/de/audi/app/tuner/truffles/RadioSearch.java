/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.tuner.truffles;

import de.audi.app.tuner.truffles.IRadioSearch;
import de.audi.app.tuner.truffles.ISearchGUI;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.search.AbstractGuiSearchHandler;
import de.audi.atip.search.AbstractSearch;
import de.audi.tuner.app.Logger;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerModels;
import org.dsi.ifc.search.ConflictMatch;
import org.osgi.framework.BundleContext;

public class RadioSearch
extends AbstractSearch
implements IRadioSearch {
    private static final String LOGCLASS = "RadioSearch";
    private final TunerModels models;
    private final Logger logger;

    public RadioSearch(BundleContext bundleContext, IFrameworkAccess iFrameworkAccess, TunerBasics tunerBasics) {
        super(bundleContext, iFrameworkAccess, tunerBasics.getLogger().truffles, 1);
        this.logger = tunerBasics.getLogger();
        this.models = tunerBasics.getModels();
        this.init();
    }

    public final void init() {
        this.logChannel.log(1000000, "[%1.init]", (Object)LOGCLASS);
        this.startDSI();
    }

    protected void initDSI() {
        super.initDSI();
        this.models.getChoiceModel(100571).setValue(1);
    }

    public void setActiveGuiSearchHandler(ISearchGUI iSearchGUI) {
        super.setActiveGuiSearchHandler((AbstractGuiSearchHandler)((Object)iSearchGUI));
    }

    public void cancelQuerry() {
        super.cancelQuery();
    }

    public void setEnvironmentResult(int n) {
        this.logger.truffles.log(100000, "[RadioSearch.setEnvironmentResult] not Implemented");
    }

    public void updateSearchIsActive(int n, boolean bl, int n2) {
        super.updateSearchIsActive(n, bl, n2);
    }

    public void removeAllFromHistoryBySourceResult(int n) {
        this.logger.truffles.log(100000, "[RadioSearch.removeAllFromHistoryBySourceResult] not Implemented");
    }

    public void cancelQueryResult(int n, int n2) {
        super.cancelQueryResult(n, n2);
    }

    public void updatePotentialConflict(int n, boolean bl, ConflictMatch conflictMatch, int n2) {
        this.logger.truffles.log(100000, "[RadioSearch.updatePotentialConflict] not Implemented");
    }

    public void updateProfileState(int n, int n2, int n3) {
        this.logger.truffles.log(100000, "[RadioSearch.updateProfileState] not Implemented");
    }

    public void profileChanged(int n, int n2) {
        this.logger.truffles.log(100000, "[RadioSearch.profileChanged] not Implemented");
    }

    public void profileCopied(int n, int n2, int n3) {
        this.logger.truffles.log(100000, "[RadioSearch.profileCopied] not Implemented");
    }

    public void profileReset(int n, int n2) {
        this.logger.truffles.log(100000, "[RadioSearch.profileReset] not Implemented");
    }

    public void profileResetAll(int n) {
        this.logger.truffles.log(100000, "[RadioSearch.profileResetAll] not Implemented");
    }

    public void setIgnoreSearchIsActive(boolean bl) {
        this.logger.truffles.log(100000, "[RadioSearch.setIgnoreSearchIsActive] not Implemented");
    }
}

