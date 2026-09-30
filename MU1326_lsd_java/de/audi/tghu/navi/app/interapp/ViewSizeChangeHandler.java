/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.interapp;

import de.audi.atip.log.LogChannel;
import de.audi.atip.mmicombi.IViewSizeListener;
import de.audi.atip.mmicombi.IViewSizeManager;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.interapp.IViewSizeChangeHandler;
import java.util.ArrayList;

public class ViewSizeChangeHandler
implements IViewSizeChangeHandler {
    final NavigationEnv env;
    private ArrayList listeners;
    LogChannel logChannel;
    private IViewSizeManager viewSizeManager;

    public ViewSizeChangeHandler(NavigationEnv navigationEnv) {
        this.env = navigationEnv;
        this.logChannel = navigationEnv.getLogChannel();
        this.viewSizeManager = null;
        this.listeners = new ArrayList(5);
    }

    public void setViewSizeManager(IViewSizeManager iViewSizeManager) {
        if (iViewSizeManager != null) {
            this.logChannel.log(10000000, "ViewSizeChangeHandler#setViewSizeManager() listeners.size()=%1 ", (long)this.listeners.size());
            this.viewSizeManager = iViewSizeManager;
            try {
                for (int i2 = 0; i2 < this.listeners.size(); ++i2) {
                    this.viewSizeManager.addViewSizeListener((IViewSizeListener)this.listeners.get(i2));
                }
            }
            catch (Exception exception) {
                this.logChannel.log(10000, "ViewSizeChangeHandler#setViewSizeManager() - ERROR = %1", (Throwable)exception);
            }
        } else {
            this.logChannel.log(100000, "ViewSizeChangeHandler#setViewSizeManager( null )");
            this.viewSizeManager = null;
        }
    }

    public boolean isSmallStageActive() {
        if (this.viewSizeManager != null) {
            this.logChannel.log(10000000, "ViewSizeChangeHandler#isSmallStageActive()");
            try {
                return this.viewSizeManager.getCurrentViewSize() == 1;
            }
            catch (Exception exception) {
                this.logChannel.log(10000, "ViewSizeChangeHandler#isSmallStageActive() - ERROR = %1", (Throwable)exception);
                return false;
            }
        }
        this.logChannel.log(100000, "ViewSizeChangeHandler#isSmallStageActive() - null");
        return false;
    }

    public void addViewSizeChangedListener(IViewSizeListener iViewSizeListener) {
        this.listeners.add(iViewSizeListener);
        if (this.viewSizeManager != null) {
            this.logChannel.log(10000000, "ViewSizeChangeHandler#addViewSizeChangedListener()");
            try {
                this.viewSizeManager.addViewSizeListener(iViewSizeListener);
            }
            catch (Exception exception) {
                this.logChannel.log(10000, "ViewSizeChangeHandler#addViewSizeChangedListener() - ERROR = %1", (Throwable)exception);
            }
        } else {
            this.logChannel.log(100000, "ViewSizeChangeHandler#addViewSizeChangedListener() - null");
        }
    }

    public void requestLargeViewSize(int n) {
        if (this.viewSizeManager != null) {
            this.logChannel.log(10000000, "ViewSizeChangeHandler#requestLargeViewSize()");
            try {
                this.viewSizeManager.requestLargeViewSize(n);
            }
            catch (Exception exception) {
                this.logChannel.log(10000, "ViewSizeChangeHandler#requestViewSizeChange() - ERROR = %1", (Throwable)exception);
            }
        } else {
            this.logChannel.log(100000, "ViewSizeChangeHandler#requestViewSizeChange() - null");
        }
    }

    public void unrequestLargeViewSize(int n) {
        if (this.viewSizeManager != null) {
            this.logChannel.log(10000000, "ViewSizeChangeHandler#unrequestLargeViewSize()");
            try {
                this.viewSizeManager.unrequestLargeViewSize(n);
            }
            catch (Exception exception) {
                this.logChannel.log(10000, "ViewSizeChangeHandler#requestViewSizeChange() - ERROR = %1", (Throwable)exception);
            }
        } else {
            this.logChannel.log(100000, "ViewSizeChangeHandler#requestViewSizeChange() - null");
        }
    }
}

