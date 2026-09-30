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

    public void scheduleQuery(String string, int[] nArray, ITelSearchQueryListener iTelSearchQueryListener) {
        this.log.log(100000, "[TelDummyDSISearchAccess#scheduleQuery] Search not supported --> NOP!");
    }

    public void cancelActiveSearchQuery() {
        this.log.log(100000, "[TelDummyDSISearchAccess#cancelActiveSearchQuery] Search not supported --> NOP!");
    }
}

