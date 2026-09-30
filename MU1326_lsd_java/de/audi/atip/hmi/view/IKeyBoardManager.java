/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.view;

import de.esolutions.fw.util.commons.job.Job;

public interface IKeyBoardManager {
    public Job fireKeyEvent(int var1, long var2, int var4, int var5);

    public Job fireKeyEvent(int var1, long var2, int var4, long var5, int var7);

    public void fireKeyEventDirectlyInEventDispatchThread(int var1, long var2, int var4, int var5);

    public Job fireJoyStickEvent(int var1, long var2, int var4, int var5, int var6);

    public Job fireWheelButtonEvent(int var1, long var2, int var4, int var5, int var6, int var7, int var8);

    public Job fireWheelButtonEvent(int var1, long var2, int var4, int var5, int var6, int var7);

    public Job fireTouchEvent(int var1, long var2, int var4, int var5, int var6, int var7, int var8);

    public Job fireTouchEvent(int var1, long var2, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11);

    public Job fireTouchEvent(int var1, long var2, int var4, int var5, int var6, int var7, boolean var8, int var9, int var10, int var11, int var12);

    public Job fireTouchEvent(int var1, long var2, int var4, int var5, int var6, String var7, int[] var8, int var9);

    public Job fireGestureEvent(int var1, long var2, int var4, int var5, int var6);

    public Job fireGestureEvent(int var1, int var2, int var3, int var4, int var5, int var6, long var7, int var9);

    public Job fireGestureEvent(int var1, long var2, int var4, int var5, String[] var6, int[] var7, int var8);

    public Job fireProximityEvent(int var1, int var2);
}

