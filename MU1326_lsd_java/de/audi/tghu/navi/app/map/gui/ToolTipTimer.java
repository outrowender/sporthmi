/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.gui;

import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.map.PosInfo;

public final class ToolTipTimer
implements TimerListener {
    private final Timer mTimer;
    private Object mMutex;
    private String mMessage;
    private int mX;
    private int mY;
    private PosInfo mPositionInfo;
    private String mURL;
    private boolean mIsStack;
    private boolean mIsPicNav;
    private ResourceLocator mPicNavLocator;
    private boolean mCancelled;
    private LogChannel logChannel;
    private AbstractMap naviMap;

    public ToolTipTimer(NavigationEnv navigationEnv, LogChannel logChannel, AbstractMap abstractMap) {
        this.logChannel = logChannel;
        this.naviMap = abstractMap;
        this.mTimer = new Timer("ToolTipTimer", 700L, true, this);
        this.mMutex = new Object();
        this.mCancelled = Util.isPorsche(navigationEnv.getFramework());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void restart(String string, int n, int n2, PosInfo posInfo, String string2, boolean bl, boolean bl2, ResourceLocator resourceLocator) {
        Object object = this.mMutex;
        synchronized (object) {
            this.mMessage = string;
            this.mX = n;
            this.mY = n2;
            this.mPositionInfo = posInfo;
            this.mURL = string2;
            this.mIsStack = bl;
            this.mIsPicNav = bl2;
            this.mPicNavLocator = resourceLocator;
            this.logChannel.log(10000000, "CtxFreeMap#ToolTipTimer#restart(%1, ...)", (Object)this.mMessage);
            this.mCancelled = false;
            this.mTimer.restart();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setDelay(long l) {
        Object object = this.mMutex;
        synchronized (object) {
            this.mTimer.setDelay(l);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void cancelAndHideToolTip() {
        Object object = this.mMutex;
        synchronized (object) {
            if (!this.mCancelled) {
                this.logChannel.log(10000000, "CtxFreeMap#ToolTipTimer#cancelAndHideToolTip()");
                this.mCancelled = true;
                this.mTimer.cancel();
                this.logChannel.log(10000000, "CtxShown#hideToolTip()");
                this.naviMap.getGuiInterface().hideToolTip();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void fireTimer(Timer timer) {
        Object object = this.mMutex;
        synchronized (object) {
            this.logChannel.log(10000000, "CtxFreeMap#ToolTipTimer#fireTimer - mapScrollDir: %1 mCancelled: %2", (long)this.naviMap.getMapDataContainer().sMapScrollDir, (long)(this.mCancelled ? 1 : 0));
            if (this.naviMap.getMapDataContainer().sMapScrollDir < 0 && !this.mCancelled) {
                this.naviMap.getMapTooltip().showToolTip(this.mMessage, this.mX, this.mY, this.mPositionInfo, this.mURL, this.mIsStack, this.mIsPicNav, this.mPicNavLocator);
            }
        }
    }

    public void cancelTimer(Timer timer) {
    }
}

