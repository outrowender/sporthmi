/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.ui.mib2.grid;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ISpeller {
    public static final int TYPE_SCAN_GRID = 0;
    public static final int TYPE_FREE = 1;
    public static final Map typeOptions = new HashMap(){
        private static final long serialVersionUID = 9212433984669498163L;
        {
            this.put("scanGrid", new Integer(0));
            this.put("free", new Integer(1));
        }
    };
    public static final int DEFAULT_TYPE = 1;

    public int getType();

    public String getInitialText();

    public void setInitialText(String var1);

    public String getHelpText();

    public void setHelpText(String var1);

    public String getInfoText();

    public void setInfoText(String var1);

    public void setOkButtonDisabled(boolean var1);

    public boolean isOkButtonDisabled();

    public Object getSpellerListener();

    public void setSpellerListener(Object var1);

    public List getDrawerTypes();

    public void setDrawerTypes(List var1);

    public void setText(String var1);

    public String getText();
}

