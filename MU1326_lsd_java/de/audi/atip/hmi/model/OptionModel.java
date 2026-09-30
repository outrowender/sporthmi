/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model;

import de.audi.atip.hmi.model.AbstractModel;
import de.audi.atip.hmi.model.OptionModelListener;
import de.audi.atip.hmi.modelaccess.OptionModelApp;
import de.audi.atip.hmi.modelaccess.OptionModelGUI;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.SimpleIntObjectMap;

public class OptionModel
extends AbstractModel
implements OptionModelApp,
OptionModelGUI {
    private static final OptionModelListener FALLBACK_LISTENER = new FallbackListener();
    private volatile OptionModelListener listener = FALLBACK_LISTENER;
    private final String logPrefix;
    private final SimpleIntObjectMap listenersMap = new SimpleIntObjectMap();
    private final SimpleIntObjectMap customIDlistenersMap = new SimpleIntObjectMap();

    public OptionModel(int n) {
        super(n, 0);
        this.logPrefix = new Buffer().append('{').append(n).append("} [OptionModel.").toString();
    }

    public void setListener(OptionModelListener optionModelListener) {
        this.listener = optionModelListener != null ? optionModelListener : FALLBACK_LISTENER;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setListener(OptionModelListener optionModelListener, int n) {
        SimpleIntObjectMap simpleIntObjectMap = this.listenersMap;
        synchronized (simpleIntObjectMap) {
            this.listenersMap.add(n, optionModelListener);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void removeListener(int n) {
        SimpleIntObjectMap simpleIntObjectMap = this.listenersMap;
        synchronized (simpleIntObjectMap) {
            this.listenersMap.remove(n);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setCustomIDListener(OptionModelListener optionModelListener, int n) {
        SimpleIntObjectMap simpleIntObjectMap = this.customIDlistenersMap;
        synchronized (simpleIntObjectMap) {
            this.customIDlistenersMap.add(n, optionModelListener);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void removeCustomIDListener(int n) {
        SimpleIntObjectMap simpleIntObjectMap = this.customIDlistenersMap;
        synchronized (simpleIntObjectMap) {
            this.customIDlistenersMap.remove(n);
        }
    }

    public void resetListener() {
        this.listener = FALLBACK_LISTENER;
        this.listenersMap.clear();
        this.customIDlistenersMap.clear();
    }

    public String dumpContent() {
        int n;
        Buffer buffer = new Buffer(200);
        buffer.append(super.dumpContent());
        buffer.append("\nOptionListeners: ");
        int[] nArray = this.listenersMap.getKeys();
        Object[] objectArray = this.listenersMap.getValues();
        for (n = 0; n < objectArray.length; ++n) {
            buffer.append(nArray[n]);
            buffer.append(':');
            buffer.append(objectArray[n]);
            buffer.append(", ");
        }
        buffer.append("\nCustomIDListeners: ");
        nArray = this.customIDlistenersMap.getKeys();
        objectArray = this.customIDlistenersMap.getValues();
        for (n = 0; n < objectArray.length; ++n) {
            buffer.append(nArray[n]);
            buffer.append(':');
            buffer.append(objectArray[n]);
            buffer.append(", ");
        }
        return buffer.toString();
    }

    public int getModelType() {
        return 28;
    }

    public boolean isEmpty() {
        return false;
    }

    public void keyPressed(int n, int n2, int n3, int n4) {
        this.lc.log(10000000, "%1.keyPressed] targetModelID:%2 targetRow:%3", (Object)this.logPrefix, (long)n, (long)n2);
        try {
            this.listener.keyPressed(this.id, n, n2, n3, n4);
            this.getListener(n).keyPressed(this.id, n, n2, n3, n4);
            if (!this.customIDlistenersMap.isEmpty()) {
                OptionModelListener optionModelListener = this.getCustomIDListener(n3);
                this.lc.log(10000000, "%1.keyPressed] trigger listener: %2 for targetWidgetID: %3", (Object)this.logPrefix, (Object)optionModelListener, (long)n3);
                optionModelListener.keyPressed(this.id, n, n2, n3, n4);
            }
        }
        catch (Exception exception) {
            this.handleListenerException(exception);
        }
    }

    public void keyReleased(int n, int n2, int n3, int n4) {
        this.lc.log(10000000, "%1.keyReleased] targetModelID:%2 targetRow:%3", (Object)this.logPrefix, (long)n, (long)n2);
        try {
            this.listener.keyReleased(this.id, n, n2, n3, n4);
            this.getListener(n).keyReleased(this.id, n, n2, n3, n4);
            if (!this.customIDlistenersMap.isEmpty()) {
                OptionModelListener optionModelListener = this.getCustomIDListener(n3);
                this.lc.log(10000000, "%1.keyReleased] trigger listener: %2 for targetWidgetID: %3", (Object)this.logPrefix, (Object)optionModelListener, (long)n3);
                optionModelListener.keyReleased(this.id, n, n2, n3, n4);
            }
        }
        catch (Exception exception) {
            this.handleListenerException(exception);
        }
    }

    public void keyTyped(int n, int n2, int n3, int n4) {
        this.lc.log(10000000, "%1.keyTyped] targetModelID:%2 targetRow:%3", (Object)this.logPrefix, (long)n, (long)n2);
        try {
            this.listener.keyTyped(this.id, n, n2, n3, n4);
            this.getListener(n).keyTyped(this.id, n, n2, n3, n4);
            if (!this.customIDlistenersMap.isEmpty()) {
                OptionModelListener optionModelListener = this.getCustomIDListener(n3);
                this.lc.log(10000000, "%1.keyTyped] trigger listener: %2 for targetWidgetID: %3", (Object)this.logPrefix, (Object)optionModelListener, (long)n3);
                optionModelListener.keyTyped(this.id, n, n2, n3, n4);
            }
        }
        catch (Exception exception) {
            this.handleListenerException(exception);
        }
    }

    public void customAction(int n, int n2, int n3, int n4) {
        this.lc.log(10000000, "%1.customAction] actionID:%2 targetModelID:%3", (Object)this.logPrefix, (long)n3, (long)n);
        try {
            this.listener.customAction(this.id, n, n3, n2, n4);
            this.getListener(n).customAction(this.id, n, n3, n2, n4);
            if (!this.customIDlistenersMap.isEmpty()) {
                OptionModelListener optionModelListener = this.getCustomIDListener(n2);
                this.lc.log(10000000, "%1.customAction] trigger listener: %2 for targetWidgetID: %3", (Object)this.logPrefix, (Object)optionModelListener, (long)n2);
                optionModelListener.customAction(this.id, n, n3, n2, n4);
            }
        }
        catch (Exception exception) {
            this.handleListenerException(exception);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private OptionModelListener getListener(int n) {
        OptionModelListener optionModelListener;
        SimpleIntObjectMap simpleIntObjectMap = this.listenersMap;
        synchronized (simpleIntObjectMap) {
            optionModelListener = (OptionModelListener)this.listenersMap.get(n);
        }
        if (optionModelListener == null) {
            optionModelListener = FALLBACK_LISTENER;
        }
        return optionModelListener;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private OptionModelListener getCustomIDListener(int n) {
        OptionModelListener optionModelListener;
        SimpleIntObjectMap simpleIntObjectMap = this.customIDlistenersMap;
        synchronized (simpleIntObjectMap) {
            optionModelListener = (OptionModelListener)this.customIDlistenersMap.get(n);
        }
        if (optionModelListener == null) {
            optionModelListener = FALLBACK_LISTENER;
        }
        return optionModelListener;
    }

    private static class FallbackListener
    implements OptionModelListener {
        private FallbackListener() {
        }

        public void keyPressed(int n, int n2, int n3, int n4, int n5) {
        }

        public void keyReleased(int n, int n2, int n3, int n4, int n5) {
        }

        public void keyTyped(int n, int n2, int n3, int n4, int n5) {
        }

        public void customAction(int n, int n2, int n3, int n4, int n5) {
        }
    }
}

