/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.poi.IPoiSubstringSearchListener;
import de.audi.tghu.navi.app.addressinput.poi.models.ISubstringSearchModelAccess;
import org.dsi.ifc.navigation.ValueListStatus;

public class SubstringSearchHandler
implements IPoiSubstringSearchListener {
    private final ISubstringSearchModelAccess modelAccess;
    private boolean substringSearchStarted;
    private final LogChannel logChannel;

    public SubstringSearchHandler(NavigationEnv navigationEnv, ISubstringSearchModelAccess iSubstringSearchModelAccess) {
        this.modelAccess = iSubstringSearchModelAccess;
        this.logChannel = navigationEnv.getPOILogChannel();
    }

    public synchronized void stopSearch(String string) {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(100000000, "SubstringSearchHandler#stopSearch(%1)", (Object)string);
        }
        this.substringSearchStarted = false;
    }

    public synchronized void updatePoiSubstringSearchStatus(ValueListStatus valueListStatus) {
        int n = valueListStatus.getStatus();
        this.logChannel.log(10000000, "SubstringSearchHandler#updatePoiSubstringSearchStatus() - status=%1", (long)n);
        if (n == 0) {
            this.logChannel.log(10000000, "SubstringSearchHandler#updatePoiSubstringSearchStatus() - status is invalid.");
            return;
        }
        if (n == 1) {
            this.logChannel.log(10000000, "SubstringSearchHandler#updatePoiSubstringSearchStatus() - The search has been canceled.");
            this.substringSearchStarted = false;
            return;
        }
        int n2 = valueListStatus.getNumberOfAvailableItems();
        int n3 = valueListStatus.getDistance();
        if (n == 2 && n3 == 0 && n2 == 0) {
            this.logChannel.log(10000000, "SubstringSearchHandler#updatePoiSubstringSearchStatus() - search is starting.");
            this.substringSearchStarted = true;
        }
        if (!this.substringSearchStarted) {
            this.logChannel.log(10000000, "SubstringSearchHandler#updatePoiSubstringSearchStatus() - update was received but no search was started.");
            return;
        }
        if (n == 3) {
            this.substringSearchStarted = false;
        }
        if (this.modelAccess != null) {
            this.modelAccess.onUpdateSearchStatus(valueListStatus);
        }
    }
}

