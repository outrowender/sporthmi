/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.rml;

import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.rml.RMLSequence;
import org.dsi.ifc.navigation.RgInfoForNextDestination;

public class RMLDSIHandler {
    private final NavigationEnv env;
    private RMLSequence rmlSequence;

    public RMLDSIHandler(NavigationEnv navigationEnv) {
        this.env = navigationEnv;
    }

    public void windowChanged(int n) {
        if (n == 0) {
            this.updateList(true);
        } else {
            this.env.getRMLLogChannel().log(10000000, "RMLDSIHandler#windowChanged - reason = %1 ignored", (long)n);
        }
    }

    public void updateList(boolean bl) {
        if (!this.checkRmlSequenceRegistered()) {
            return;
        }
        this.env.getRMLLogChannel().log(10000000, "RMLDSIHandler#windowChanged - windowChanged(%1)", bl);
        this.rmlSequence.windowChanged(bl);
    }

    public void updateRgInfoForNextDestination(RgInfoForNextDestination rgInfoForNextDestination) {
        if (!this.checkRmlSequenceRegistered()) {
            return;
        }
        this.rmlSequence.updateInfoForNextDestination(rgInfoForNextDestination);
    }

    public void updateElementsTotal(long l, long l2, int n) {
        if (!this.checkRmlSequenceRegistered()) {
            return;
        }
        this.env.getRMLLogChannel().log(10000000, "RMLDSIHandler#updateElementsTotal - total = %1, visible = %2, valid = %3", l, l2, (long)n);
        this.rmlSequence.updateElementsTotal(l);
    }

    private boolean checkRmlSequenceRegistered() {
        return this.rmlSequence != null;
    }

    public void registerForUpdates(RMLSequence rMLSequence) {
        this.rmlSequence = rMLSequence;
    }

    public void unregisterForUpdates() {
        this.rmlSequence = null;
    }
}

