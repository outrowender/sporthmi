/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.ui.mib2;

import de.audi.remotehmi.ui.mib2.DrawerEntryIcon;
import de.audi.remotehmi.ui.mib2.grid.IGrid;
import de.audi.remotehmi.util.DeepCloneable;
import java.util.HashMap;
import java.util.Map;

public interface DrawerEntry
extends DeepCloneable {
    public static final String RIGHT_DRAWER_GLOBAL_ENTRIES = "____global____";
    public static final int UPDATE_TYPE_MAIN = 1;
    public static final int UPDATE_TYPE_REFLECTION = 2;
    public static final int UPDATE_TYPE_CLOSED = 3;
    public static final int UPDATE_TYPE_CLOSED_INACTIVE = 4;
    public static final int WIDGET_TYPE_ACTION = 1;
    public static final int WIDGET_TYPE_SUBMENU = 2;
    public static final int WIDGET_TYPE_CHECKBOX = 3;
    public static final int WIDGET_TYPE_SUBMENU_PREVIEW = 4;
    public static final int WIDGET_TYPE_DROPDOWN = 5;
    public static final Map widgetTypeMap = new HashMap(){
        private static final long serialVersionUID = -1111848786856739068L;
        {
            this.put("action", new Integer(1));
            this.put("submenu", new Integer(2));
            this.put("checkbox", new Integer(3));
            this.put("submenupreview", new Integer(4));
            this.put("dropdown", new Integer(5));
        }
    };

    public DrawerEntryIcon getIcon();

    public DrawerEntryIcon getReflectionIcon();

    public String getEntryName();

    public String getEvent();

    public String getEntryId();

    public String getEntryContext();

    public IGrid getWidgetGridForEntry();

    public int getWidgetType();

    public void setCheckboxValue(boolean var1);

    public boolean getCheckboxValue();

    public void setDefaultSelection(int var1);

    public int getSortOrder();

    public boolean isMenuSpecific();

    public void setInputFieldText(String var1);

    public String getAppId();

    public boolean isBlocking();

    public String getInfoText();

    public void setEnabled(boolean var1);

    public boolean isEnabled();

    public boolean isMediaContext();
}

