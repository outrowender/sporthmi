/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.hmi.evo;

import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.cc.IComponentConditionManager;
import de.audi.atip.hmi.view.Screen;
import de.audi.tghu.hmi.evo.IDrawerControllerEvo;

public interface IHMIServiceEvo
extends HMIService {
    public IComponentConditionManager getComponentConditionManager();

    public Object getKanziResource(String var1, Object var2, int var3, int var4, int var5);

    public IDrawerControllerEvo[] getSelectionDrawers(int var1, int var2);

    public IDrawerControllerEvo[] getOptionDrawers(int var1, int var2);

    public boolean isPartialPopupVisibleInSlot(int var1, int var2);

    public void setPartialPopupsEnabled(int var1, boolean var2);

    public void showPartialPopup(int var1, int var2);

    public void removePartialPopup(int var1, int var2);

    public void replacePartialPopup(int var1, int var2, int var3);

    public void removeAllPartialPopupsForSlots(int var1, int[] var2);

    public void switchToDisplayContext(int var1, int var2, int var3, int var4);

    public Screen getPartialPopup(int var1, int var2);
}

