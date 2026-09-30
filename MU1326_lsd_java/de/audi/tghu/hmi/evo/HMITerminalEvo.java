/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.hmi.evo;

import de.audi.atip.hmi.HMITerminal;
import de.audi.atip.hmi.view.IVisualFeedback;
import de.audi.tghu.hmi.evo.IDrawerConditionEngine;
import de.audi.tghu.hmi.evo.IDrawerFocusManagerEvo;
import de.audi.tghu.hmi.evo.IKanziResourceLoader;
import de.audi.tghu.hmi.evo.ILockingManager;
import de.audi.tghu.hmi.evo.IPresetInputHandler;
import de.audi.tghu.hmi.evo.IWidgetRegistry;
import de.audi.tghu.hmi.evo.PreloadManager;

public interface HMITerminalEvo
extends HMITerminal {
    public static final int SKIN_STANDARD = 0;
    public static final int SKIN_SPORT = 1;

    public IKanziResourceLoader getKanziResourceLoader();

    public IDrawerFocusManagerEvo getDrawerFocusManager();

    public IDrawerConditionEngine getDrawerConditionEngine();

    public IPresetInputHandler getPresetPopupHandler();

    public IVisualFeedback getVisualFeedback();

    public void setSkin(int var1);

    public int getSkin();

    public void initializeViewSize(int var1);

    public void initializeDrawerViewSize();

    public IWidgetRegistry getWidgetRegistryIf();

    public PreloadManager getPreloadManager();

    public ILockingManager getLockingManager();
}

