/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.statemachine;

import java.util.ArrayList;
import java.util.List;

public final class Popup {
    private static List objPool = new ArrayList(8);
    private int popupID = -1;
    private int priority = 0;
    private int topLevelState = -1;
    private int zpmPriority = 0;
    private int zpmSlotID = 0;

    private Popup() {
    }

    public static Popup newPopup(int n, int n2, int n3, int n4, int n5) {
        Popup popup = Popup.newInstance();
        popup.popupID = n;
        popup.priority = n2;
        popup.topLevelState = n3;
        popup.zpmPriority = n4;
        popup.zpmSlotID = n5;
        return popup;
    }

    private static Popup newInstance() {
        Popup popup = null;
        int n = objPool.size();
        if (n > 0) {
            popup = (Popup)objPool.remove(n - 1);
        }
        if (popup != null) {
            return popup;
        }
        return new Popup();
    }

    public int getPopupID() {
        return this.popupID;
    }

    public int getPriority() {
        return this.priority;
    }

    public int getTopLevelState() {
        return this.topLevelState;
    }

    public int getZpmPriority() {
        return this.zpmPriority;
    }

    public int getZpmSlotID() {
        return this.zpmSlotID;
    }
}

