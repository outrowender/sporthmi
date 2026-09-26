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
    @Override
    default public IComponentConditionManager getComponentConditionManager() {
    }

    default public Object getKanziResource(String string, Object object, int n, int n2, int n3) {
    }

    default public IDrawerControllerEvo[] getSelectionDrawers(int n, int n2) {
    }

    default public IDrawerControllerEvo[] getOptionDrawers(int n, int n2) {
    }

    @Override
    default public boolean isPartialPopupVisibleInSlot(int n, int n2) {
    }

    @Override
    default public void setPartialPopupsEnabled(int n, boolean bl) {
    }

    @Override
    default public void showPartialPopup(int n, int n2) {
    }

    @Override
    default public void removePartialPopup(int n, int n2) {
    }

    @Override
    default public void replacePartialPopup(int n, int n2, int n3) {
    }

    @Override
    default public void removeAllPartialPopupsForSlots(int n, int[] nArray) {
    }

    default public void switchToDisplayContext(int n, int n2, int n3, int n4) {
    }

    default public Screen getPartialPopup(int n, int n2) {
    }
}

