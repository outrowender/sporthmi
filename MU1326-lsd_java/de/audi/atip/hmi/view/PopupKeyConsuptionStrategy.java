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

    @Override
    public int getPopupID() {
        return this.popupID;
    }

    @Override
    public void setConsumeHKReturn(int n) {
        this.consumeHKReturn = n;
    }

    @Override
    public void setConsumeDDSPress(int n) {
        this.consumeDDSPress = n;
    }

    @Override
    public void setConsumeKeyTurned(int n) {
        this.consumeKeyTurned = n;
    }

    @Override
    public void setConsumeSKPress(int n) {
        this.consumeSKPress = n;
    }

    @Override
    public void setConsumeTouchPad(int n) {
        this.consumeTouchpad = n;
    }

    @Override
    public int getConsumeHKReturn() {
        return this.consumeHKReturn;
    }

    @Override
    public int getConsumeDDSPress() {
        return this.consumeDDSPress;
    }

    @Override
    public int getConsumeKeyTurned() {
        return this.consumeKeyTurned;
    }

    @Override
    public int getConsumeSKPress() {
        return this.consumeSKPress;
    }

    @Override
    public int getConsumeTouchPad() {
        return this.consumeTouchpad;
    }

    @Override
    public void setConsumeGenericKeys(int n, int[] nArray) {
        this.consumeGeneric = n;
        this.consumeGenericKeyIDs = nArray;
    }

    @Override
    public int getConsumeGenericStrategy() {
        return this.consumeGeneric;
    }

    @Override
    public int[] getConsumeGenericKeys() {
        return this.consumeGenericKeyIDs;
    }

    @Override
    public void setHKPressFilter(int[] nArray) {
        this.hKFilterKeys = nArray;
        if (this.hKFilterKeys != null) {
            Arrays.sort(this.hKFilterKeys);
        }
    }

    @Override
    public int[] getHKPressFilter() {
        return null == this.hKFilterKeys ? new int[]{} : this.hKFilterKeys;
    }

    @Override
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

    @Override
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

