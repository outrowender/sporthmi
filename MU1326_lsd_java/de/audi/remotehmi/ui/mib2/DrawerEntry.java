/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.ui.mib2;

import de.audi.remotehmi.ui.mib2.DrawerEntry$1;
import de.audi.remotehmi.ui.mib2.DrawerEntryIcon;
import de.audi.remotehmi.ui.mib2.grid.IGrid;
import de.audi.remotehmi.util.DeepCloneable;
import java.util.Map;

public interface DrawerEntry
extends DeepCloneable {
    public static final String RIGHT_DRAWER_GLOBAL_ENTRIES;
    public static final int UPDATE_TYPE_MAIN;
    public static final int UPDATE_TYPE_REFLECTION;
    public static final int UPDATE_TYPE_CLOSED;
    public static final int UPDATE_TYPE_CLOSED_INACTIVE;
    public static final int WIDGET_TYPE_ACTION;
    public static final int WIDGET_TYPE_SUBMENU;
    public static final int WIDGET_TYPE_CHECKBOX;
    public static final int WIDGET_TYPE_SUBMENU_PREVIEW;
    public static final int WIDGET_TYPE_DROPDOWN;
    public static final Map widgetTypeMap;

    default public DrawerEntryIcon getIcon() {
    }

    default public DrawerEntryIcon getReflectionIcon() {
    }

    default public String getEntryName() {
    }

    default public String getEvent() {
    }

    default public String getEntryId() {
    }

    default public String getEntryContext() {
    }

    default public IGrid getWidgetGridForEntry() {
    }

    default public int getWidgetType() {
    }

    default public void setCheckboxValue(boolean bl) {
    }

    default public boolean getCheckboxValue() {
    }

    default public void setDefaultSelection(int n) {
    }

    default public int getSortOrder() {
    }

    default public boolean isMenuSpecific() {
    }

    default public void setInputFieldText(String string) {
    }

    default public String getAppId() {
    }

    default public boolean isBlocking() {
    }

    default public String getInfoText() {
    }

    default public void setEnabled(boolean bl) {
    }

    default public boolean isEnabled() {
    }

    default public boolean isMediaContext() {
    }

    static {
        widgetTypeMap = new DrawerEntry$1();
    }
}

