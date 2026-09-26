/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.ui.mib2.grid;

import de.audi.remotehmi.ui.mib2.grid.ISpeller$1;
import java.util.List;
import java.util.Map;

public interface ISpeller {
    public static final int TYPE_SCAN_GRID;
    public static final int TYPE_FREE;
    public static final Map typeOptions;
    public static final int DEFAULT_TYPE;

    default public int getType() {
    }

    default public String getInitialText() {
    }

    default public void setInitialText(String string) {
    }

    default public String getHelpText() {
    }

    default public void setHelpText(String string) {
    }

    default public String getInfoText() {
    }

    default public void setInfoText(String string) {
    }

    default public void setOkButtonDisabled(boolean bl) {
    }

    default public boolean isOkButtonDisabled() {
    }

    default public Object getSpellerListener() {
    }

    default public void setSpellerListener(Object object) {
    }

    default public List getDrawerTypes() {
    }

    default public void setDrawerTypes(List list) {
    }

    default public void setText(String string) {
    }

    default public String getText() {
    }

    static {
        typeOptions = new ISpeller$1();
    }
}

