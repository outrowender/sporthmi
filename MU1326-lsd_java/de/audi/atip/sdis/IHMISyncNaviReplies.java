/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.sdis;

import de.audi.atip.sdis.IHMISyncNaviReplies$CarPosition;
import de.audi.atip.sdis.IHMISyncNaviReplies$LastDestination;

public interface IHMISyncNaviReplies {
    default public void updateCarPosition(CarPosition carPosition) {
    }

    default public void replyLastDestinationList(LastDestination[] lastDestinationArray) {
    }

    default public void replyStartRouteGuidance(int n) {
    }
}

