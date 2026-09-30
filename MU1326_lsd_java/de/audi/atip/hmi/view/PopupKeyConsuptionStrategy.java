/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.view;

import de.audi.atip.hmi.view.IPopupKeyConsumptionListener;
import de.audi.atip.hmi.view.IPopupKeyConsuptionStrategy;
import java.lang.ref.WeakReference;
import java.util.Arrays;

public class PopupKeyConsuptionStrategy
implements IPopupKeyConsuptionStrategy {
    private int popupID;
    protected int consumeHKReturn = 0;
    protected int consumeDDSPress = 0;
    protected int consumeKeyTurned = 0;
    protected int consumeSKPress = 0;
    protected int consumeTouchpad = 0;
    protected int consumeGeneric = 0;
    private int[] consumeGenericKeyIDs;
    private int[] hKFilterKeys;
    private WeakReference listenerRef;

    public PopupKeyConsuptionStrategy(int n) {
        this.popupID = n;
    }

    public int getPopupID() {
        return this.popupID;
    }

    public void setConsumeHKReturn(int n) {
        this.consumeHKReturn = n;
    }

    public void setConsumeDDSPress(int n) {
        this.consumeDDSPress = n;
    }

    public void setConsumeKeyTurned(int n) {
        this.consumeKeyTurned = n;
    }

    public void setConsumeSKPress(int n) {
        this.consumeSKPress = n;
    }

    public void setConsumeTouchPad(int n) {
        this.consumeTouchpad = n;
    }

    public int getConsumeHKReturn() {
        return this.consumeHKReturn;
    }

    public int getConsumeDDSPress() {
        return this.consumeDDSPress;
    }

    public int getConsumeKeyTurned() {
        return this.consumeKeyTurned;
    }

    public int getConsumeSKPress() {
        return this.consumeSKPress;
    }

    public int getConsumeTouchPad() {
        return this.consumeTouchpad;
    }

    public void setConsumeGenericKeys(int n, int[] nArray) {
        this.consumeGeneric = n;
        this.consumeGenericKeyIDs = nArray;
    }

    public int getConsumeGenericStrategy() {
        return this.consumeGeneric;
    }

    public int[] getConsumeGenericKeys() {
        return this.consumeGenericKeyIDs;
    }

    public void setHKPressFilter(int[] nArray) {
        this.hKFilterKeys = nArray;
        if (this.hKFilterKeys != null) {
            Arrays.sort(this.hKFilterKeys);
        }
    }

    public int[] getHKPressFilter() {
        return null == this.hKFilterKeys ? new int[]{} : this.hKFilterKeys;
    }

    public void registerPopupKeyConsumptionListener(IPopupKeyConsumptionListener iPopupKeyConsumptionListener) {
        this.listenerRef = new WeakReference(iPopupKeyConsumptionListener);
    }

    private void notifyConsumptionListener(boolean bl, int n) {
        if (this.listenerRef == null) {
            return;
        }
        IPopupKeyConsumptionListener iPopupKeyConsumptionListener = (IPopupKeyConsumptionListener)this.listenerRef.get();
        if (iPopupKeyConsumptionListener != null) {
            iPopupKeyConsumptionListener.hKPressed(bl, n);
        }
    }

    public boolean doesHKFilterContainsKey(int n) {
        if (this.hKFilterKeys != null) {
            if (Arrays.binarySearch(this.hKFilterKeys, n) < 0) {
                this.notifyConsumptionListener(false, n);
                return false;
            }
            this.notifyConsumptionListener(true, n);
            return true;
        }
        this.notifyConsumptionListener(false, n);
        return false;
    }
}

