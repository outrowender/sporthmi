/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo;

import de.audi.atip.hmi.HMITerminal;
import de.audi.atip.hmi.view.HMIView;
import de.audi.atip.hmi.view.ITouchInputManager;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TouchInputManager
implements ITouchInputManager {
    private HMITerminal terminal;
    private static final int REC_MODE_MAX_VALUE = 26;
    private Map registeredWidgets = new HashMap(10);
    private int desiredRecognizerMode = 0;
    private boolean updateRecognizerModeImmediately = true;
    private boolean isPresetPopupActive;
    private long presetPopupDeactivationTimestamp;

    public TouchInputManager(HMITerminal hMITerminal) {
        this.terminal = hMITerminal;
    }

    public void setDesiredRecognizerMode(HMIView hMIView, int n) {
        this.registeredWidgets.put(hMIView, new Integer(n));
        Collection collection = this.registeredWidgets.values();
        Iterator iterator = collection.iterator();
        int n2 = 0;
        while (iterator.hasNext()) {
            int n3 = (Integer)iterator.next();
            if (n3 >= 26) {
                n2 = 26;
                break;
            }
            n2 = Math.max(n2, n3);
        }
        this.desiredRecognizerMode = n2;
        if (this.updateRecognizerModeImmediately) {
            this.updateMode();
        }
    }

    public void deregister(HMIView hMIView) {
        this.registeredWidgets.remove(hMIView);
    }

    public void presetPopupActive(boolean bl) {
        this.isPresetPopupActive = bl;
        if (!bl) {
            this.presetPopupDeactivationTimestamp = AbstractWidget.framework.getMonotonicTime();
        }
    }

    public boolean isPresetPopupActive() {
        long l = AbstractWidget.framework.getMonotonicTime() - this.presetPopupDeactivationTimestamp;
        return this.isPresetPopupActive || l <= 500L;
    }

    public void clear() {
        this.registeredWidgets.clear();
    }

    public void updateRecognizerMode(boolean bl) {
        this.updateRecognizerModeImmediately = bl;
        if (bl) {
            this.updateMode();
        }
    }

    private void updateMode() {
        if (this.terminal.getKbdService() != null) {
            this.terminal.getKbdService().setRecognizerMode(this.desiredRecognizerMode);
            IWidgetLogChannel.tpLogChannelInternal.log(10000000, "TouchInputManager#updateMode desiredRecognizerMode: %1", (long)this.desiredRecognizerMode);
            if (this.desiredRecognizerMode == 26) {
                IWidgetLogChannel.tpLogChannelInternal.log(10000000, "TouchInputManager#updateMode - mode %1 activated - start tts session", (long)this.desiredRecognizerMode);
                if (this.terminal.getTTSHandler() != null) {
                    this.terminal.getTTSHandler().startSession(0);
                }
            } else {
                IWidgetLogChannel.tpLogChannelInternal.log(10000000, "TouchInputManager#updateMode - stop tts session");
                if (this.terminal.getTTSHandler() != null) {
                    this.terminal.getTTSHandler().stopSession(0, false);
                }
            }
        }
    }
}

