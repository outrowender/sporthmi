/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.screenstate;

import de.audi.app.car.common.screenstate.IPartialPopupStateListener;
import de.audi.app.car.common.screenstate.IPopupStateDispatcher;
import de.audi.app.car.common.screenstate.IPopupStateListener;
import de.audi.app.car.common.screenstate.IScreenStateListener;
import de.audi.atip.log.LogChannel;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class PopupStateDispatcher
implements IPopupStateDispatcher {
    private final LogChannel logChannel;
    private final Object mutex = new Object();
    private final Map popupStateListeners;
    private final Map partialPopupStateListeners;
    private final Map screenStateListeners;

    public PopupStateDispatcher(LogChannel logChannel) {
        this.logChannel = logChannel;
        this.popupStateListeners = new HashMap();
        this.partialPopupStateListeners = new HashMap();
        this.screenStateListeners = new HashMap();
    }

    @Override
    public void init() {
        this.logChannel.log(1078071040, "[PopupStateDispatcher#init] called");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void deinit() {
        this.logChannel.log(1078071040, "[PopupStateDispatcher#deinit] called");
        Object object = this.mutex;
        synchronized (object) {
            this.popupStateListeners.clear();
            this.partialPopupStateListeners.clear();
            this.screenStateListeners.clear();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void addPopupStateListener(int n, IPopupStateListener iPopupStateListener) {
        this.logChannel.log(1078071040, "[PopupStateDispatcher#addPopupStateListener] popupID='%1', listener='%2'", (Object)Integer.toString(n), (Object)iPopupStateListener);
        Object object = this.mutex;
        synchronized (object) {
            LinkedList linkedList = (LinkedList)this.popupStateListeners.get(new Integer(n));
            if (linkedList == null) {
                linkedList = new LinkedList();
                this.popupStateListeners.put(new Integer(n), linkedList);
            }
            if (linkedList.contains(iPopupStateListener)) {
                this.logChannel.log(1078071040, "[PopupStateDispatcher#addPopupStateListener] Listener is already added.");
                return;
            }
            linkedList.add(iPopupStateListener);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void removePopupStateListener(int n, IPopupStateListener iPopupStateListener) {
        this.logChannel.log(1078071040, "[PopupStateDispatcher#removePopupStateListener] popupID='%1', listener='%2'", (Object)Integer.toString(n), (Object)iPopupStateListener);
        Object object = this.mutex;
        synchronized (object) {
            LinkedList linkedList = (LinkedList)this.popupStateListeners.get(new Integer(n));
            if (linkedList == null) {
                return;
            }
            linkedList.remove(iPopupStateListener);
            if (linkedList.isEmpty()) {
                this.popupStateListeners.remove(new Integer(n));
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void addScreenStateListener(int n, IScreenStateListener iScreenStateListener) {
        this.logChannel.log(1078071040, "[PopupStateDispatcher#addScreenStateListener] screenID='%1', listener='%2'", (Object)Integer.toString(n), (Object)iScreenStateListener);
        Object object = this.mutex;
        synchronized (object) {
            LinkedList linkedList = (LinkedList)this.screenStateListeners.get(new Integer(n));
            if (linkedList == null) {
                linkedList = new LinkedList();
                this.screenStateListeners.put(new Integer(n), linkedList);
            }
            if (linkedList.contains(iScreenStateListener)) {
                this.logChannel.log(1078071040, "[PopupStateDispatcher#addPopupStateListener] Listener is already added.");
                return;
            }
            linkedList.add(iScreenStateListener);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void removeScreenStateListener(int n, IScreenStateListener iScreenStateListener) {
        this.logChannel.log(1078071040, "[PopupStateDispatcher#removeScreenStateListener] screenID='%1', listener='%2'", (Object)Integer.toString(n), (Object)iScreenStateListener);
        Object object = this.mutex;
        synchronized (object) {
            LinkedList linkedList = (LinkedList)this.screenStateListeners.get(new Integer(n));
            if (linkedList == null) {
                return;
            }
            linkedList.remove(iScreenStateListener);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void addPartialPopupStateListener(int n, IPartialPopupStateListener iPartialPopupStateListener) {
        this.logChannel.log(1078071040, "[PopupStateDispatcher#addPartialPopupStateListener] popupID='%1', listener='%2'", (Object)Integer.toString(n), (Object)iPartialPopupStateListener);
        Object object = this.mutex;
        synchronized (object) {
            LinkedList linkedList = (LinkedList)this.partialPopupStateListeners.get(new Integer(n));
            if (linkedList == null) {
                linkedList = new LinkedList();
                this.partialPopupStateListeners.put(new Integer(n), linkedList);
            }
            if (linkedList.contains(iPartialPopupStateListener)) {
                this.logChannel.log(1078071040, "[PopupStateDispatcher#addPartialPopupStateListener] Listener is already added.");
                return;
            }
            linkedList.add(iPartialPopupStateListener);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void removePartialPopupStateListener(int n, IPartialPopupStateListener iPartialPopupStateListener) {
        this.logChannel.log(1078071040, "[PopupStateDispatcher#removePartialPopupStateListener] popupID='%1', listener='%2'", (Object)Integer.toString(n), (Object)iPartialPopupStateListener);
        Object object = this.mutex;
        synchronized (object) {
            LinkedList linkedList = (LinkedList)this.partialPopupStateListeners.get(new Integer(n));
            if (linkedList == null) {
                return;
            }
            linkedList.remove(iPartialPopupStateListener);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void notifyPopupVisible(int n, int n2) {
        LinkedList linkedList;
        this.logChannel.log(1078071040, "[PopupStateDispatcher#notifyPopupVisible] ID='%1', terminalID='%2'", (Object)Integer.toString(n), (Object)Integer.toString(n2));
        Object object = this.popupStateListeners;
        synchronized (object) {
            LinkedList linkedList2 = (LinkedList)this.popupStateListeners.get(new Integer(n));
            if (linkedList2 == null) {
                this.logChannel.log(1078071040, "[PopupStateDispatcher#notifyPopupVisible] no listeners registered");
                return;
            }
            linkedList = (LinkedList)linkedList2.clone();
        }
        object = linkedList.iterator();
        while (object.hasNext()) {
            try {
                ((IPopupStateListener)object.next()).notifyPopupVisible(n);
            }
            catch (Exception exception) {
                this.logChannel.log(-1601830656, "[PopupStateDispatcher#notifyPopupVisible] exception occured: ", (Throwable)exception);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void notifyPopupHidden(int n, int n2) {
        LinkedList linkedList;
        this.logChannel.log(1078071040, "[PopupStateDispatcher#notifyPopupHidden] ID='%1', terminalID='%2'", (Object)Integer.toString(n), (Object)Integer.toString(n2));
        Object object = this.popupStateListeners;
        synchronized (object) {
            LinkedList linkedList2 = (LinkedList)this.popupStateListeners.get(new Integer(n));
            if (linkedList2 == null) {
                return;
            }
            linkedList = (LinkedList)linkedList2.clone();
        }
        object = linkedList.iterator();
        while (object.hasNext()) {
            try {
                ((IPopupStateListener)object.next()).notifyPopupHidden(n);
            }
            catch (Exception exception) {
                this.logChannel.log(-1601830656, "[PopupStateDispatcher#notifyPopupHidden] exception occured: ", (Throwable)exception);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void notifyPopupRemoved(int n, int n2) {
        LinkedList linkedList;
        this.logChannel.log(1078071040, "[PopupStateDispatcher#notifyPopupRemoved] ID='%1', terminalID='%2'", (Object)Integer.toString(n), (Object)Integer.toString(n2));
        Object object = this.popupStateListeners;
        synchronized (object) {
            LinkedList linkedList2 = (LinkedList)this.popupStateListeners.get(new Integer(n));
            if (linkedList2 == null) {
                return;
            }
            linkedList = (LinkedList)linkedList2.clone();
        }
        object = linkedList.iterator();
        while (object.hasNext()) {
            try {
                ((IPopupStateListener)object.next()).notifyPopupRemoved(n);
            }
            catch (Exception exception) {
                this.logChannel.log(-1601830656, "[PopupStateDispatcher#notifyPopupRemoved] exception occured: ", (Throwable)exception);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void notifyScreenVisible(int n, int n2) {
        LinkedList linkedList;
        this.logChannel.log(1078071040, "[PopupStateDispatcher#notifyScreenVisible] ID='%1', terminalID='%2'", (Object)Integer.toString(n), (Object)Integer.toString(n2));
        Object object = this.screenStateListeners;
        synchronized (object) {
            LinkedList linkedList2 = (LinkedList)this.screenStateListeners.get(new Integer(n));
            if (linkedList2 == null) {
                return;
            }
            linkedList = (LinkedList)linkedList2.clone();
        }
        object = linkedList.iterator();
        while (object.hasNext()) {
            try {
                ((IScreenStateListener)object.next()).notifyScreenVisible(n);
            }
            catch (Exception exception) {
                this.logChannel.log(-1601830656, "[PopupStateDispatcher#notifyScreenVisible] exception occured: ", (Throwable)exception);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void notifyScreenHidden(int n, int n2) {
        LinkedList linkedList;
        this.logChannel.log(1078071040, "[PopupStateDispatcher#notifyScreenHidden] ID='%1', terminalID='%2'", (Object)Integer.toString(n), (Object)Integer.toString(n2));
        Object object = this.screenStateListeners;
        synchronized (object) {
            LinkedList linkedList2 = (LinkedList)this.screenStateListeners.get(new Integer(n));
            if (linkedList2 == null) {
                return;
            }
            linkedList = (LinkedList)linkedList2.clone();
        }
        object = linkedList.iterator();
        while (object.hasNext()) {
            try {
                ((IScreenStateListener)object.next()).notifyScreenHidden(n);
            }
            catch (Exception exception) {
                this.logChannel.log(-1601830656, "[PopupStateDispatcher#notifyScreenHidden] exception occured: ", (Throwable)exception);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void notifyScreenFadedOut(int n, int n2) {
        LinkedList linkedList;
        this.logChannel.log(1078071040, "[PopupStateDispatcher#notifyScreenFadedOut] ID='%1', terminalID='%2'", (Object)Integer.toString(n), (Object)Integer.toString(n2));
        Object object = this.screenStateListeners;
        synchronized (object) {
            LinkedList linkedList2 = (LinkedList)this.screenStateListeners.get(new Integer(n));
            if (linkedList2 == null) {
                return;
            }
            linkedList = (LinkedList)linkedList2.clone();
        }
        object = linkedList.iterator();
        while (object.hasNext()) {
            try {
                ((IScreenStateListener)object.next()).notifyScreenFadedOut(n);
            }
            catch (Exception exception) {
                this.logChannel.log(-1601830656, "[PopupStateDispatcher#notifyScreenFadedOut] exception occured: ", (Throwable)exception);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void notifyScreenConnected(int n, int n2) {
        LinkedList linkedList;
        this.logChannel.log(1078071040, "[PopupStateDispatcher#notifyScreenConnected] ID='%1', terminalID='%2'", (Object)Integer.toString(n), (Object)Integer.toString(n2));
        Object object = this.screenStateListeners;
        synchronized (object) {
            LinkedList linkedList2 = (LinkedList)this.screenStateListeners.get(new Integer(n));
            if (linkedList2 == null) {
                return;
            }
            linkedList = (LinkedList)linkedList2.clone();
        }
        object = linkedList.iterator();
        while (object.hasNext()) {
            try {
                ((IScreenStateListener)object.next()).notifyScreenConnected(n);
            }
            catch (Exception exception) {
                this.logChannel.log(-1601830656, "[PopupStateDispatcher#notifyScreenConnected] exception occured: ", (Throwable)exception);
            }
        }
    }
}

