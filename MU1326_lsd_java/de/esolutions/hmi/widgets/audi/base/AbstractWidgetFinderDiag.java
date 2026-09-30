/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base;

import de.audi.atip.diag.sw.AbstractSwDiagnosis;
import de.audi.atip.hmi.event.RunnableEvent;
import de.audi.atip.hmi.view.IPartialPopupController;
import de.audi.atip.hmi.view.IPartialPopupManager;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.HMITerminalImpl;
import de.esolutions.hmi.widgets.audi.base.TextToolExport;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public abstract class AbstractWidgetFinderDiag
extends AbstractSwDiagnosis {
    private static final String SOME_BLANKS = "                                                                                                   ";
    private static final String MANY_BLANKS = "                                                                                                                                                                                                                                                                                                                                                                                                            ";
    protected static final int INDENTATION_PER_LEVEL = 4;
    public static final int FORMAT_VERSION_0 = 0;
    public static final int FORMAT_VERSION_1 = 1;
    public static final int FORMAT_VERSION_2 = 2;
    protected int formatVersion = 0;

    public String getName() {
        return "Widgets";
    }

    public int getId() {
        return 44145;
    }

    public String getWidgetHierarchy() {
        this.formatVersion = 0;
        StringBuffer stringBuffer = new StringBuffer();
        this.createTree(this.getCurrentScreen(), stringBuffer, 0);
        return stringBuffer.toString();
    }

    protected abstract AbstractWidget getCurrentScreen();

    public String getWidgetAndDrawablesHierarchy() {
        this.formatVersion = 0;
        return this.getWidgetAndDrawablesHierarchyInternal();
    }

    public String getWidgetAndDrawablesHierarchy2() {
        this.formatVersion = 1;
        return this.getWidgetAndDrawablesHierarchyInternal();
    }

    public String getWidgetAndDrawablesHierarchy3() {
        this.formatVersion = 2;
        return this.getWidgetAndDrawablesHierarchyInternal();
    }

    protected String getWidgetAndDrawablesHierarchyInternal() {
        StringBuffer stringBuffer = new StringBuffer();
        this.createTree(this.getCurrentScreen(), stringBuffer, 0);
        this.createPartialPopupsTree(stringBuffer);
        this.createGraphicsElementsTree(stringBuffer);
        return stringBuffer.toString();
    }

    protected void createPartialPopupsTree(StringBuffer stringBuffer) {
        IPartialPopupManager iPartialPopupManager = this.getTerminal().getPartialPopupManager();
        for (int i2 = 0; i2 < 14; ++i2) {
            IPartialPopupController iPartialPopupController;
            if (!iPartialPopupManager.hasVisiblePopupInSlot(i2) || (iPartialPopupController = iPartialPopupManager.getCurrentVisiblePopup(i2)) == null) continue;
            this.createTree((AbstractWidget)((Object)iPartialPopupController), stringBuffer, 0);
        }
    }

    protected abstract void createGraphicsElementsTree(StringBuffer var1);

    protected void createTree(AbstractWidget abstractWidget, StringBuffer stringBuffer, int n) {
        if (abstractWidget == null) {
            return;
        }
        stringBuffer.append(this.indentation(n)).append(this.format(abstractWidget)).append('\n');
        int n2 = n + 4;
        if (abstractWidget.getChildren() != null) {
            Iterator iterator = abstractWidget.getChildren().iterator();
            while (iterator.hasNext()) {
                AbstractWidget abstractWidget2 = (AbstractWidget)iterator.next();
                if (abstractWidget2 == null) continue;
                this.createTree(abstractWidget2, stringBuffer, n2);
            }
        }
    }

    private String format(AbstractWidget abstractWidget) {
        int[] nArray = this.findAbsoluteCoordinates(abstractWidget);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.collectWidgetProperties(abstractWidget, linkedHashMap, nArray);
        return this.format(abstractWidget.getClassName(), abstractWidget.hashCode(), nArray[0], nArray[1], abstractWidget.getWidth(), abstractWidget.getHeight(), linkedHashMap);
    }

    protected void collectWidgetProperties(AbstractWidget abstractWidget, Map map, int[] nArray) {
        Object object;
        map.put("visible", abstractWidget.isVisible());
        map.put("onScreen", abstractWidget.isOnScreen());
        map.put("visibleOnStage", abstractWidget.isVisibleOnCurrentStage());
        map.put("opacity", new Float(abstractWidget.getRenderOpacity()));
        map.put("depth", new Integer(abstractWidget.getDepth()));
        map.put("modelID", new Integer(abstractWidget.getModelID()));
        map.put("role", new Integer(abstractWidget.getRole()));
        if (abstractWidget instanceof TextToolExport) {
            object = ((TextToolExport)((Object)abstractWidget)).getTextMaxDimension();
            map.put("texttool-WidthDesired", new Integer((int)object[0]));
            map.put("texttool-WidthActual", new Integer((int)object[1]));
            map.put("texttool-HeightDesired", new Integer((int)object[2]));
            map.put("texttool-HeightActual", new Integer((int)object[3]));
        }
        if ((object = abstractWidget.getDiagnosisText()) != null && this.formatVersion != 0) {
            map.put("diagnosisText", object);
        }
    }

    protected String format(String string, int n, int n2, int n3, int n4, int n5, Map map) {
        if (this.formatVersion == 0) {
            return this.formatOld(string, n, n2, n3, n4, n5, map);
        }
        return this.formatNew(string, n, n2, n3, n4, n5, map);
    }

    private String formatOld(String string, int n, int n2, int n3, int n4, int n5, Map map) {
        Buffer buffer = new Buffer();
        buffer.append(string + ", " + n + ", " + n2 + ", " + n3 + ", " + n4 + ", " + n5);
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            buffer.append(", ");
            buffer.append(entry.getKey()).append(": ").append(entry.getValue());
        }
        return buffer.toString();
    }

    private String formatNew(String string, int n, int n2, int n3, int n4, int n5, Map map) {
        Buffer buffer = new Buffer();
        buffer.append(string + ", hash=" + n + ", x=" + n2 + ", y=" + n3 + ", width=" + n4 + ", height=" + n5);
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            buffer.append(", ");
            buffer.append(entry.getKey()).append("=\"").append(this.escapeValue(entry.getValue())).append('\"');
        }
        return buffer.toString();
    }

    protected String escapeValue(Object object) {
        String string = object == null ? "" : object.toString();
        StringBuffer stringBuffer = new StringBuffer(string.length());
        for (int i2 = 0; i2 < string.length(); ++i2) {
            char c2 = string.charAt(i2);
            if (c2 == '\r') {
                stringBuffer.append("\\\\r");
                continue;
            }
            if (c2 == '\n') {
                stringBuffer.append("\\\\n");
                continue;
            }
            if (c2 == '\"' || c2 == '\\') {
                stringBuffer.append('\\');
            }
            stringBuffer.append(c2);
        }
        return stringBuffer.toString();
    }

    protected String indentation(int n) {
        int n2 = n * 4;
        return MANY_BLANKS.substring(0, n2);
    }

    private int[] findAbsoluteCoordinates(AbstractWidget abstractWidget) {
        int n = abstractWidget.getX();
        int n2 = abstractWidget.getY();
        while (abstractWidget.parent != null) {
            abstractWidget = abstractWidget.parent;
            if (!this.isContainerWidget(abstractWidget)) continue;
            n += abstractWidget.getX();
            n2 += abstractWidget.getY();
        }
        return new int[]{n, n2};
    }

    protected boolean isContainerWidget(AbstractWidget abstractWidget) {
        return true;
    }

    public void cmdMarkArea(final int n, final int n2, final int n3, final int n4) {
        AbstractWidget.framework.getHMIService().getEventDispatcher().postEvent(new RunnableEvent(false, new Runnable(){

            public void run() {
                int n5 = Math.max(n3, 1);
                int n22 = Math.max(n4, 1);
                AbstractWidgetFinderDiag.this.markSynced(n, n2, n5, n22);
            }
        }));
    }

    public void cmdCallbackSelected(final String string) {
        AbstractWidget.framework.getHMIService().getEventDispatcher().postEvent(new RunnableEvent(false, new Runnable(){

            public void run() {
                AbstractWidgetFinderDiag.this.callbackSelectedSynced(string);
            }
        }));
    }

    protected abstract void markSynced(int var1, int var2, int var3, int var4);

    protected abstract void callbackSelectedSynced(String var1);

    public void cmdClearMarkedArea() {
        AbstractWidget.framework.getHMIService().getEventDispatcher().postEvent(new RunnableEvent(false, new Runnable(){

            public void run() {
                AbstractWidgetFinderDiag.this.clearMarkerSynced();
            }
        }));
    }

    protected abstract void clearMarkerSynced();

    public HMITerminalImpl getTerminal() {
        return (HMITerminalImpl)AbstractWidget.framework.getHMIService().getHMITerminal(0);
    }
}

