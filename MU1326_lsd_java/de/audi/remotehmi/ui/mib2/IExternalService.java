/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.ui.mib2;

import java.util.HashMap;
import java.util.Map;

public interface IExternalService {
    public static final String HOSTING_CONTEXT_VALUE_NAVIGATION = "Navi_Location";
    public static final String HOSTING_CONTEXT_VALUE_MEDIA = "media";
    public static final String HOSTING_CONTEXT_VALUE_PHONE = "phone";
    public static final int ICON_TYPE_SOURCE_LIST = 1;
    public static final int ICON_TYPE_SOURCE_LIST_INACTIVE = 2;
    public static final int ICON_TYPE_SOURCE_LIST_REFLECTION = 3;
    public static final int ICON_TYPE_CAPTION = 4;
    public static final int ICON_TYPE_LOADING = 5;
    public static final Map iconTypeMap = new HashMap(){
        private static final long serialVersionUID = 1L;
        {
            this.put("sourceListIcon", new Integer(1));
            this.put("sourceListInactiveIcon", new Integer(2));
            this.put("sourceListReflectionIcon", new Integer(3));
            this.put("sourceListCaptionIcon", new Integer(4));
            this.put("sourceListLoadingIcon", new Integer(5));
        }
    };

    public String getEntryName();

    public String getEntryContext();

    public String getInactiveIconLocalUrl();

    public String getCaptionIconLocalUrl();

    public String getLoadingIconLocalUrl();

    public String getIcon();

    public String getReflectionIcon();

    public boolean isEntryLastMode();

    public String getEntryDescription();

    public int getEntryPointId();

    public String getSubEntryPoint();

    public boolean isEnabled();
}

