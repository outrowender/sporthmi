/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.listener;

import de.audi.tghu.exlap.ifc.listener.ExlapNavigationListener;
import de.audi.tghu.exlap.impl.container.AddressContainer;
import de.audi.tghu.exlap.impl.container.GuidanceRemainingContainer;
import de.audi.tghu.exlap.impl.container.GuidanceStateContainer;
import de.audi.tghu.exlap.impl.container.LastDestinationsContainer;

public class ExlapNavigationEmptyListener
implements ExlapNavigationListener {
    public void updateLocation(AddressContainer addressContainer) {
    }

    public void updateGuidanceState(GuidanceStateContainer guidanceStateContainer) {
    }

    public void updateGuidanceDestination(AddressContainer addressContainer) {
    }

    public void updateGuidanceRemaining(GuidanceRemainingContainer guidanceRemainingContainer) {
    }

    public void updateLastDestinations(LastDestinationsContainer lastDestinationsContainer) {
    }
}

