/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base;

import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.view.IPartialPopupListener;

public interface IUserHintHandler {
    default public void processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
    }

    default public void requestHintAnimation(int n, int n2, int n3) {
    }

    default public void updateUserHintPos(int n, int n2) {
    }

    default public boolean shallShowUserHints() {
    }

    default public void requestInitialHint(int n, IPartialPopupListener iPartialPopupListener) {
    }

    default public void requestInitialHint(int n) {
    }

    default public void removeCurrentUserHint() {
    }
}

