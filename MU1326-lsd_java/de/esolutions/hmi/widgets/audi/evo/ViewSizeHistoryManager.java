/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo;

import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.SystemProperties;

public class ViewSizeHistoryManager
implements IWidgetLogChannel {
    private int preferredViewSize;
    private boolean preferredViewSizeInitialized;
    private int currentViewSize;
    private final boolean isSimulator;
    private int requestedViewSize = -1;
    private static boolean isActive = SystemProperties.getBoolean("EnableAutomaticViewSizeChange", true);

    public ViewSizeHistoryManager(int n) {
        logViewSize.log(1078071040, "ViewSizeHistoryManager#constructor initializing with view size %1", (long)n);
        this.preferredViewSize = n;
        this.currentViewSize = n;
        this.isSimulator = AbstractWidget.framework.isSimulator();
    }

    public int getPreferredViewSize() {
        if (ViewSizeHistoryManager.isActive()) {
            if (this.isSimulator) {
                return this.currentViewSize;
            }
            return this.preferredViewSize;
        }
        logViewSize.log(1078071040, "ViewSizeHistoryManager#getPreferredViewSize Automatic view size change is disabled.");
        return this.currentViewSize;
    }

    public void setPreferredViewSize(int n) {
        logViewSize.log(1078071040, "ViewSizeHistoryManager#setPreferredViewSize preferred view size: %1", (long)n);
        this.preferredViewSize = n;
        this.preferredViewSizeInitialized = true;
    }

    public void setCurrentViewSize(int n) {
        logViewSize.log(1078071040, "ViewSizeHistoryManager#setCurrentViewSize setting current view size to %1", (long)n);
        this.currentViewSize = n;
        if (!this.preferredViewSizeInitialized) {
            logViewSize.log(1078071040, "ViewSizeHistoryManager#setCurrentViewSize setting initial preferred view size to %1", (long)n);
            this.preferredViewSize = n;
            this.preferredViewSizeInitialized = true;
        }
    }

    public int getCurrentViewSize() {
        return this.currentViewSize;
    }

    public boolean isHistoryStateChangeRequired() {
        if (this.getRequestedViewSize() != -1) {
            return this.getRequestedViewSize() != this.getPreferredViewSize();
        }
        return this.getCurrentViewSize() != this.getPreferredViewSize();
    }

    public static boolean isActive() {
        return isActive;
    }

    public static void setActive(boolean bl) {
        isActive = bl;
    }

    public int getRequestedViewSize() {
        return this.requestedViewSize;
    }

    public void setRequestedViewSize(int n) {
        this.requestedViewSize = n;
    }
}

