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
    public void updateLocation(AddressContainer var1);

    public void updateGuidanceState(GuidanceStateContainer var1);

    public void updateGuidanceDestination(AddressContainer var1);

    public void updateGuidanceRemaining(GuidanceRemainingContainer var1);

    public void updateLastDestinations(LastDestinationsContainer var1);
}

