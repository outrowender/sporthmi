/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.search.cmd;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.search.cmd.ITelDSISearchAccess;
import de.audi.app.phone.core.search.cmd.ITelSearchQueryListener;

public class TelDummyDSISearchAccess
extends AbstractPhoneComponent
implements ITelDSISearchAccess {
    public TelDummyDSISearchAccess(ITelApplication iTelApplication) {
        super(iTelApplication, "App.Phone.Search");
    }

    @Override
    public void scheduleQuery(String string, int[] nArray, ITelSearchQueryListener iTelSearchQueryListener) {
        this.log.log(-1601830656, "[TelDummyDSISearchAccess#scheduleQuery] Search not supported --> NOP!");
    }

    @Override
    public void cancelActiveSearchQuery() {
        this.log.log(-1601830656, "[TelDummyDSISearchAccess#cancelActiveSearchQuery] Search not supported --> NOP!");
    }
}

