/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base;

import de.audi.atip.hmi.view.IDrawerController;
import de.esolutions.hmi.widgets.audi.base.IContentChangeListener;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;

public interface IDrawerManager
extends IContentChangeListener {
    public void activateSelectionDrawer(long var1);

    public void activateOptionDrawer(long var1, long[] var3);

    public void activateEntertainmentDrawer();

    public AbstractWidgetController getNewEntertainmentContent(int var1);

    public void activateEntertainmentDrawerContent(AbstractWidgetController var1);

    public void startTrackingServices();

    public int getBlackListedConnection();

    public void notifyADCListeners(int var1, int var2);

    public void entertainmentDrawerClosed();

    public void entertainmentDrawerOpened();

    public IDrawerController getOptionDrawer(long var1);

    public void languageChanged();

    public void clear();
}

