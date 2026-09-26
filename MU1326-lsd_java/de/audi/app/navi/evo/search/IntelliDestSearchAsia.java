/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.search;

import de.audi.app.navi.evo.search.IntelliDestController;
import de.audi.app.navi.evo.search.IntelliDestSearch;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.guidance.IVehicle;
import de.audi.tghu.navi.app.search.LastDestSearch;
import org.dsi.ifc.search.ConflictMatch;
import org.osgi.framework.BundleContext;

public class IntelliDestSearchAsia
extends IntelliDestSearch {
    public IntelliDestSearchAsia(IntelliDestController intelliDestController, BundleContext bundleContext, IFrameworkAccess iFrameworkAccess, int n, IVehicle iVehicle, LogChannel logChannel, NavigationEnv navigationEnv, LastDestSearch lastDestSearch) {
        super(intelliDestController, bundleContext, iFrameworkAccess, n, iVehicle, logChannel, navigationEnv, lastDestSearch);
    }

    @Override
    public void updatePotentialConflict(int n, boolean bl, ConflictMatch conflictMatch, int n2) {
        this.logChannel.log(-2137614336, "IntelliDestSearchAsia#updatePotentialConflict conflictMatch=%1, conflictMode=%2, isConflict=%3, queryId=%4", (Object)conflictMatch, (long)(this.conflictMode ? 1 : 0), (long)(bl ? 1 : 0));
        int n3 = this.getLastQueryID();
        if (n != n3) {
            this.logChannel.log(-2137614336, "IntelliDestSearch#updatePotentialConflict recveived conflict for queryId %1 but currentQuerryId is %2", (long)n, (long)n3);
            return;
        }
        if (bl && !this.conflictMode && conflictMatch.type == 2) {
            this.lastConflictMatch = conflictMatch;
            this.conflictMode = bl;
            this.restartSearch();
        } else {
            super.updatePotentialConflict(n, bl, conflictMatch, n2);
        }
    }
}

