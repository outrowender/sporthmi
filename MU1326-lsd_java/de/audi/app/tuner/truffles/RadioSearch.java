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
    private static final String LOGCLASS;
    private final TunerModels models;
    private final Logger logger;

    public RadioSearch(BundleContext bundleContext, IFrameworkAccess iFrameworkAccess, TunerBasics tunerBasics) {
        super(bundleContext, iFrameworkAccess, tunerBasics.getLogger().truffles, 1);
        this.logger = tunerBasics.getLogger();
        this.models = tunerBasics.getModels();
        this.init();
    }

    @Override
    public final void init() {
        this.logChannel.log(1078071040, "[%1.init]", (Object)"RadioSearch");
        this.startDSI();
    }

    @Override
    protected void initDSI() {
        super.initDSI();
        this.models.getChoiceModel(-611843840).setValue(1);
    }

    @Override
    public void setActiveGuiSearchHandler(ISearchGUI iSearchGUI) {
        super.setActiveGuiSearchHandler((AbstractGuiSearchHandler)((Object)iSearchGUI));
    }

    @Override
    public void cancelQuerry() {
        super.cancelQuery();
    }

    @Override
    public void setEnvironmentResult(int n) {
        this.logger.truffles.log(-1601830656, "[RadioSearch.setEnvironmentResult] not Implemented");
    }

    @Override
    public void updateSearchIsActive(int n, boolean bl, int n2) {
        super.updateSearchIsActive(n, bl, n2);
    }

    @Override
    public void removeAllFromHistoryBySourceResult(int n) {
        this.logger.truffles.log(-1601830656, "[RadioSearch.removeAllFromHistoryBySourceResult] not Implemented");
    }

    @Override
    public void cancelQueryResult(int n, int n2) {
        super.cancelQueryResult(n, n2);
    }

    @Override
    public void updatePotentialConflict(int n, boolean bl, ConflictMatch conflictMatch, int n2) {
        this.logger.truffles.log(-1601830656, "[RadioSearch.updatePotentialConflict] not Implemented");
    }

    @Override
    public void updateProfileState(int n, int n2, int n3) {
        this.logger.truffles.log(-1601830656, "[RadioSearch.updateProfileState] not Implemented");
    }

    @Override
    public void profileChanged(int n, int n2) {
        this.logger.truffles.log(-1601830656, "[RadioSearch.profileChanged] not Implemented");
    }

    @Override
    public void profileCopied(int n, int n2, int n3) {
        this.logger.truffles.log(-1601830656, "[RadioSearch.profileCopied] not Implemented");
    }

    @Override
    public void profileReset(int n, int n2) {
        this.logger.truffles.log(-1601830656, "[RadioSearch.profileReset] not Implemented");
    }

    @Override
    public void profileResetAll(int n) {
        this.logger.truffles.log(-1601830656, "[RadioSearch.profileResetAll] not Implemented");
    }

    @Override
    public void setIgnoreSearchIsActive(boolean bl) {
        this.logger.truffles.log(-1601830656, "[RadioSearch.setIgnoreSearchIsActive] not Implemented");
    }
}

