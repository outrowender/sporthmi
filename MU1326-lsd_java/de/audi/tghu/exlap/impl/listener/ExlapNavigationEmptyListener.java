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
    @Override
    public void updateLocation(AddressContainer addressContainer) {
    }

    @Override
    public void updateGuidanceState(GuidanceStateContainer guidanceStateContainer) {
    }

    @Override
    public void updateGuidanceDestination(AddressContainer addressContainer) {
    }

    @Override
    public void updateGuidanceRemaining(GuidanceRemainingContainer guidanceRemainingContainer) {
    }

    @Override
    public void updateLastDestinations(LastDestinationsContainer lastDestinationsContainer) {
    }
}

