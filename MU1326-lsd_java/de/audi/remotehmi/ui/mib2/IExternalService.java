/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.ui.mib2;

import de.audi.remotehmi.ui.mib2.IExternalService$1;
import java.util.Map;

public interface IExternalService {
    public static final String HOSTING_CONTEXT_VALUE_NAVIGATION;
    public static final String HOSTING_CONTEXT_VALUE_MEDIA;
    public static final String HOSTING_CONTEXT_VALUE_PHONE;
    public static final int ICON_TYPE_SOURCE_LIST;
    public static final int ICON_TYPE_SOURCE_LIST_INACTIVE;
    public static final int ICON_TYPE_SOURCE_LIST_REFLECTION;
    public static final int ICON_TYPE_CAPTION;
    public static final int ICON_TYPE_LOADING;
    public static final Map iconTypeMap;

    default public String getEntryName() {
    }

    default public String getEntryContext() {
    }

    default public String getInactiveIconLocalUrl() {
    }

    default public String getCaptionIconLocalUrl() {
    }

    default public String getLoadingIconLocalUrl() {
    }

    default public String getIcon() {
    }

    default public String getReflectionIcon() {
    }

    default public boolean isEntryLastMode() {
    }

    default public String getEntryDescription() {
    }

    default public int getEntryPointId() {
    }

    default public String getSubEntryPoint() {
    }

    default public boolean isEnabled() {
    }

    static {
        iconTypeMap = new IExternalService$1();
    }
}

