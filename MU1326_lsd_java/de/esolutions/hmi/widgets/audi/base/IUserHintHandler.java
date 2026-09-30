/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base;

import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.view.IPartialPopupListener;

public interface IUserHintHandler {
    public void processModelUpdateEvent(ModelUpdateEvent var1);

    public void requestHintAnimation(int var1, int var2, int var3);

    public void updateUserHintPos(int var1, int var2);

    public boolean shallShowUserHints();

    public void requestInitialHint(int var1, IPartialPopupListener var2);

    public void requestInitialHint(int var1);

    public void removeCurrentUserHint();
}

