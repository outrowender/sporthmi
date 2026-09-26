/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo;

import de.audi.tghu.hmi.evo.IPropertyObject;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;

public class PropertyObject
implements IPropertyObject {
    public static final int TYPE_MAIN_GROUP_SPECIFIC;
    public static final int TYPE_MENU_SPECIFIC;
    public static final int TYPE_CONTEXT_SPECIFIC;
    private AbstractWidget widget = null;
    private int type = 2;
    private int visibleCCID = 0;
    private int enabledCCID = 0;
    private int[] categories = null;
    private int[] contextIDs = null;
    private int[] focusPropertiesToShow = null;
    private int[] focusPropertiesToHide = null;
    private int[] focusPropertiesToDisable = null;
    public static final int CONDITION_TRUE;

    public PropertyObject(AbstractWidget abstractWidget, int n, int n2, int n3, int[] nArray, int[] nArray2, int[] nArray3, int[] nArray4, int[] nArray5) {
        this.widget = abstractWidget;
        this.type = n;
        this.visibleCCID = n2;
        this.enabledCCID = n3;
        this.contextIDs = nArray;
        this.categories = nArray2;
        this.focusPropertiesToShow = nArray3;
        this.focusPropertiesToHide = nArray4;
        this.focusPropertiesToDisable = nArray5;
    }

    public AbstractWidget getWidget() {
        return this.widget;
    }

    public int getType() {
        return this.type;
    }

    @Override
    public int getVisibleCCID() {
        return this.visibleCCID;
    }

    @Override
    public int getEnabledCCID() {
        return this.enabledCCID;
    }

    @Override
    public int[] getContextIDs() {
        return this.contextIDs;
    }

    @Override
    public int[] getCategories() {
        return this.categories;
    }

    @Override
    public int[] getFocusPropertiesToShow() {
        return this.focusPropertiesToShow;
    }

    @Override
    public int[] getFocusPropertiesToHide() {
        return this.focusPropertiesToHide;
    }

    @Override
    public int[] getFocusPropertiesToDisable() {
        return this.focusPropertiesToDisable;
    }
}

