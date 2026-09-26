/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.ifc.listener;

import de.audi.tghu.exlap.ExlapListener;
import de.audi.tghu.exlap.impl.container.AddressContainer;
import de.audi.tghu.exlap.impl.container.GuidanceRemainingContainer;
import de.audi.tghu.exlap.impl.container.GuidanceStateContainer;
import de.audi.tghu.exlap.impl.container.LastDestinationsContainer;

public interface ExlapNavigationListener
extends ExlapListener {
    default public void updateLocation(AddressContainer addressContainer) {
    }

    default public void updateGuidanceState(GuidanceStateContainer guidanceStateContainer) {
    }

    default public void updateGuidanceDestination(AddressContainer addressContainer) {
    }

    default public void updateGuidanceRemaining(GuidanceRemainingContainer guidanceRemainingContainer) {
    }

    default public void updateLastDestinations(LastDestinationsContainer lastDestinationsContainer) {
    }
}

