/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.view;

import de.audi.atip.hmi.view.IWidgetDiagnosis;
import de.audi.atip.hmi.view.Screen;
import de.audi.tghu.tts.TTSStringUtil;
import de.esolutions.fw.util.commons.Buffer;
import java.util.GregorianCalendar;
import java.util.List;

public class WidgetInfoDiag {
    public static final int DRAWER_TYPE_MAIN_AREA;
    public static final int DRAWER_TYPE_SELECTION_DRAWER;
    public static final int DRAWER_TYPE_OPTION_DRAWER;
    public static final int DRAWER_TYPE_ENTERTAINMENT_DRAWER;
    private static final String VERSION_OF_WIDGETINFODIAG;
    private static int[] activeColorPlate;

    private static void addAttrib(String string, int n, Buffer buffer) {
        buffer.append(' ');
        buffer.append(string);
        buffer.append("=\"");
        buffer.append(n);
        buffer.append('\"');
    }

    private static void addAttrib(String string, boolean bl, Buffer buffer) {
        buffer.append(' ');
        buffer.append(string);
        buffer.append("=\"");
        buffer.append(bl ? "true" : "false");
        buffer.append('\"');
    }

    private static void addAttrib(String string, int[] nArray, Buffer buffer) {
        if (nArray != null) {
            buffer.append(' ');
            buffer.append(string);
            buffer.append("=\"{");
            int n = nArray.length;
            for (int i2 = 0; i2 < n; ++i2) {
                buffer.append(nArray[i2]);
                if (i2 == n - 1) continue;
                buffer.append(", ");
            }
            buffer.append("}\"");
        }
    }

    private static void addAttrib(String string, String string2, Buffer buffer) {
        if (string2 != null) {
            buffer.append(' ');
            buffer.append(string);
            buffer.append("=\"");
            buffer.append(WidgetInfoDiag.escapeXmlSpecialChars(string2));
            buffer.append('\"');
        }
    }

    private static String escapeXmlSpecialChars(String string) {
        return TTSStringUtil.escapeXml(string);
    }

    private static void addModelIDAttrib(IWidgetDiagnosis iWidgetDiagnosis, Buffer buffer) {
        int n = iWidgetDiagnosis.getModelID();
        if (n != -1) {
            buffer.append(" modelID=\"");
            buffer.append(n);
            buffer.append('\"');
        }
    }

    private static boolean hasComparablePosition(String string) {
        return !"PartialPopupActivatorWidget".equals(string);
    }

    private static boolean hasComparableDimensions(String string) {
        return !"PartialPopupActivatorWidget".equals(string) && !"PartialPopupWidgetDynamicWidth".equals(string);
    }

    private static boolean hasComparableDepth(String string) {
        return !"PartialPopupActivatorWidget".equals(string) && !"MenuWidgetD4".equals(string) && !"MenuWidgetSDSD4".equals(string) && !"MenuWidgetInfiniteD4".equals(string) && !"MenuWidgetInfiniteSDSD4".equals(string) && !"MenuWidgetRoutePlanD4".equals(string) && !"CursorBarWidgetD4".equals(string) && !"BorderWidgetD4".equals(string) && !"SoftkeyWidgetD4".equals(string) && !"StatusBarWidgetD4".equals(string) && !"SubtitleWidgetD4".equals(string) && !"WizardWidgetD4".equals(string);
    }

    private static boolean hasComparableColors(String string) {
        return !"PartialPopupActivatorWidget".equals(string);
    }

    private static String getWidgetColors(IWidgetDiagnosis iWidgetDiagnosis) {
        int[] nArray = iWidgetDiagnosis.getColorIndices();
        if (nArray == null) {
            return null;
        }
        Buffer buffer = new Buffer(64);
        buffer.append('{');
        int n = activeColorPlate == null ? 0 : activeColorPlate.length;
        int n2 = nArray.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (nArray[i2] < n) {
                buffer.append("0x");
                buffer.append(Integer.toHexString(activeColorPlate[nArray[i2]]).toUpperCase());
            } else {
                buffer.append("0xFF00FFFF");
            }
            if (i2 == n2 - 1) continue;
            buffer.append(", ");
        }
        buffer.append('}');
        return buffer.toString();
    }

    private static void addWidgetInfosAsXML(List list, Buffer buffer, int n) {
        if (list == null) {
            return;
        }
        int n2 = list.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            Object object = list.get(i2);
            if (!(object instanceof IWidgetDiagnosis)) continue;
            IWidgetDiagnosis iWidgetDiagnosis = (IWidgetDiagnosis)object;
            WidgetInfoDiag.addWidgetInfos(iWidgetDiagnosis, buffer, n);
        }
    }

    private static void addWidgetInfos(IWidgetDiagnosis iWidgetDiagnosis, Buffer buffer, int n) {
        for (int i2 = 0; i2 < n; ++i2) {
            buffer.append('\t');
        }
        buffer.append('<');
        String string = iWidgetDiagnosis.getClassName();
        string = string.replace('$', '_');
        buffer.append(string);
        if (WidgetInfoDiag.hasComparablePosition(string)) {
            WidgetInfoDiag.addAttrib("x", iWidgetDiagnosis.getX(), buffer);
            WidgetInfoDiag.addAttrib("y", iWidgetDiagnosis.getY(), buffer);
        }
        if (WidgetInfoDiag.hasComparableDimensions(string)) {
            WidgetInfoDiag.addAttrib("width", iWidgetDiagnosis.getWidth(), buffer);
            WidgetInfoDiag.addAttrib("height", iWidgetDiagnosis.getHeight(), buffer);
        }
        if (WidgetInfoDiag.hasComparableDepth(string)) {
            WidgetInfoDiag.addAttrib("depth", iWidgetDiagnosis.getDepth(), buffer);
        }
        if (WidgetInfoDiag.hasComparableColors(string)) {
            WidgetInfoDiag.addAttrib("colors", WidgetInfoDiag.getWidgetColors(iWidgetDiagnosis), buffer);
        }
        WidgetInfoDiag.addModelIDAttrib(iWidgetDiagnosis, buffer);
        String string2 = iWidgetDiagnosis.getInternalInfo();
        if (string2 != null) {
            buffer.append(new StringBuffer().append(" ").append(string2).toString());
        }
        WidgetInfoDiag.addAttrib("bitmapIDs", iWidgetDiagnosis.getBitmapIndices(), buffer);
        WidgetInfoDiag.addAttrib("enabled", iWidgetDiagnosis.isEnabled(), buffer);
        WidgetInfoDiag.addAttrib("visible", iWidgetDiagnosis.isVisible(), buffer);
        WidgetInfoDiag.addAttrib("highlighted", iWidgetDiagnosis.isHighlighted(), buffer);
        WidgetInfoDiag.addAttrib("active", iWidgetDiagnosis.isActive(), buffer);
        WidgetInfoDiag.addAttrib("focused", iWidgetDiagnosis.isFocused(), buffer);
        WidgetInfoDiag.addAttrib("functional", iWidgetDiagnosis.isFunctional(), buffer);
        WidgetInfoDiag.addAttrib("text", iWidgetDiagnosis.getDiagnosisText(), buffer);
        List list = iWidgetDiagnosis.getDiagnosisChildren();
        if (list != null && !list.isEmpty()) {
            buffer.append(">\n");
            WidgetInfoDiag.addWidgetInfosAsXML(list, buffer, n + 1);
            for (int i3 = 0; i3 < n; ++i3) {
                buffer.append('\t');
            }
            buffer.append("</");
            buffer.append(string);
            buffer.append('>');
        } else {
            buffer.append("/>");
        }
        buffer.append('\n');
    }

    public static void generateWidgetInfoXML(Screen screen, Buffer buffer, int n, String string) {
        buffer.append("<!-- Generated XML-file containing drawer- and widget-infos for testautomation -->\n<!-- Creation date: ");
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        buffer.append(gregorianCalendar.get(5));
        buffer.append('.');
        buffer.append(gregorianCalendar.get(2) + 1);
        buffer.append('.');
        buffer.append(gregorianCalendar.get(1));
        buffer.append(' ');
        buffer.append(gregorianCalendar.get(11));
        buffer.append(':');
        buffer.append(gregorianCalendar.get(12));
        buffer.append(':');
        buffer.append(gregorianCalendar.get(13));
        buffer.append(" -->\n<!-- WidgetInfoDiag Version: ");
        buffer.append("0.2");
        String string2 = WidgetInfoDiag.getDrawerText(n);
        buffer.append(" -->\n<").append(string2);
        WidgetInfoDiag.addAttrib("id", screen.getID(), buffer);
        if (string != null) {
            WidgetInfoDiag.addAttrib("name", string, buffer);
        }
        buffer.append(">\n");
        List list = ((IWidgetDiagnosis)((Object)screen)).getDiagnosisChildren();
        activeColorPlate = screen.getCurrentColorPalette();
        WidgetInfoDiag.addWidgetInfosAsXML(list, buffer, 1);
        buffer.append("</").append(string2).append(">\n");
    }

    private static String getDrawerText(int n) {
        String string;
        switch (n) {
            case 1: {
                string = "Screen";
                break;
            }
            case 2: {
                string = "SelectionDrawer";
                break;
            }
            case 3: {
                string = "OptionDrawer";
                break;
            }
            case 4: {
                string = "EntertainmentDrawer";
                break;
            }
            default: {
                string = "Screen";
            }
        }
        return string;
    }
}

