/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.util;

import de.audi.atip.hmi.model.list.EvoListRow;
import de.esolutions.fw.util.commons.Buffer;

public class TelLoggingUtils {
    public static final String EMPTY_STRING = "";
    public static final String SEPARATOR = ", ";
    public static final String NEW_LINE = "\n";

    private static Buffer baseListRowMsg(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        Buffer buffer = new Buffer();
        buffer.append("row=");
        buffer.append(evoListRow);
        buffer.append(SEPARATOR);
        buffer.append("model=");
        buffer.append(n);
        buffer.append(SEPARATOR);
        buffer.append("index=");
        buffer.append(n2);
        buffer.append(SEPARATOR);
        buffer.append("col=");
        buffer.append(n3);
        buffer.append(SEPARATOR);
        buffer.append("terminal=");
        buffer.append(n4);
        return buffer;
    }

    private static Buffer optionModelListenerMsg(int n, int n2, int n3, int n4, int n5) {
        Buffer buffer = new Buffer();
        buffer.append("modelID=");
        buffer.append(n);
        buffer.append(SEPARATOR);
        buffer.append("targetModelID=");
        buffer.append(n2);
        buffer.append(SEPARATOR);
        buffer.append("targetRow=");
        buffer.append(n3);
        buffer.append(SEPARATOR);
        buffer.append("targetWidgetID=");
        buffer.append(n4);
        buffer.append(SEPARATOR);
        buffer.append("terminalID=");
        buffer.append(n5);
        return buffer;
    }

    private static Buffer listRowMsg(int n, int n2, int n3, int n4) {
        Buffer buffer = new Buffer();
        buffer.append("modelID=");
        buffer.append(n);
        buffer.append(SEPARATOR);
        buffer.append("row=");
        buffer.append(n2);
        buffer.append(SEPARATOR);
        buffer.append("col=");
        buffer.append(n3);
        buffer.append(SEPARATOR);
        buffer.append("terminalID=");
        buffer.append(n4);
        return buffer;
    }

    public static Buffer textChanged(int n, String string, char c2, int n2) {
        Buffer buffer = new Buffer();
        buffer.append("model=");
        buffer.append(n);
        buffer.append(SEPARATOR);
        buffer.append("text=");
        buffer.append(string);
        buffer.append(SEPARATOR);
        buffer.append("latestChar=");
        buffer.append(c2);
        buffer.append(SEPARATOR);
        buffer.append("terminal=");
        buffer.append(n2);
        return buffer;
    }

    public static Buffer itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        return TelLoggingUtils.baseListRowMsg(evoListRow, n, n2, n3, n4);
    }

    public static Buffer itemLongSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        return TelLoggingUtils.baseListRowMsg(evoListRow, n, n2, n3, n4);
    }

    public static Buffer itemReleased(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        return TelLoggingUtils.baseListRowMsg(evoListRow, n, n2, n3, n4);
    }

    public static Buffer itemSelectedBaseList(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        return TelLoggingUtils.baseListRowMsg(evoListRow, n, n2, n3, n4);
    }

    public static Buffer itemSelectedList(int n, int n2, int n3, int n4) {
        return TelLoggingUtils.listRowMsg(n, n2, n3, n4);
    }

    public static Buffer itemFocused(int n, int n2, int n3, int n4) {
        return TelLoggingUtils.listRowMsg(n, n2, n3, n4);
    }

    public static Buffer itemSelectedChoice(int n, int n2, int n3, int n4) {
        Buffer buffer = new Buffer();
        buffer.append("modelID=");
        buffer.append(n);
        buffer.append(SEPARATOR);
        buffer.append("itemID=");
        buffer.append(n2);
        buffer.append(SEPARATOR);
        buffer.append("col=");
        buffer.append(n3);
        buffer.append(SEPARATOR);
        buffer.append("terminalID=");
        buffer.append(n4);
        return buffer;
    }

    public static Buffer asyncException(int n, String string, int n2) {
        Buffer buffer = new Buffer();
        buffer.append("errorCode=");
        buffer.append(n);
        buffer.append(SEPARATOR);
        buffer.append("errorMsg=");
        buffer.append(string);
        buffer.append(SEPARATOR);
        buffer.append("requestType=");
        buffer.append(n2);
        buffer.append(SEPARATOR);
        return buffer;
    }

    public static Buffer keyTypedOption(int n, int n2, int n3, int n4, int n5) {
        return TelLoggingUtils.optionModelListenerMsg(n, n2, n3, n4, n5);
    }

    public static Buffer keyTyped(int n, int n2, int n3) {
        Buffer buffer = new Buffer();
        buffer.append("modelID=");
        buffer.append(n);
        buffer.append(SEPARATOR);
        buffer.append("keyID=");
        buffer.append(n2);
        buffer.append(SEPARATOR);
        buffer.append("terminalID=");
        buffer.append(n3);
        return buffer;
    }

    public static Buffer focusedCharacter(int n, char c2, int n2) {
        Buffer buffer = new Buffer();
        buffer.append("model=");
        buffer.append(n);
        buffer.append(SEPARATOR);
        buffer.append("focusedCharacter=");
        buffer.append(c2);
        buffer.append(SEPARATOR);
        buffer.append("terminal=");
        buffer.append(n2);
        return buffer;
    }

    public static Buffer itemFocusedMenuModel(int n, int n2, long l, int n3) {
        Buffer buffer = new Buffer();
        buffer.append("menuItemID=");
        buffer.append(n);
        buffer.append(SEPARATOR);
        buffer.append("model=");
        buffer.append(n2);
        buffer.append(SEPARATOR);
        buffer.append("uniqueListRowID=");
        buffer.append(l);
        buffer.append(SEPARATOR);
        buffer.append("terminal=");
        buffer.append(n3);
        return buffer;
    }

    public static Buffer objectArray2StringNewLines(Object[] objectArray) {
        Buffer buffer = new Buffer();
        if (objectArray != null) {
            if (objectArray.length > 0) {
                buffer.append(NEW_LINE);
                for (int i2 = 0; i2 < objectArray.length; ++i2) {
                    buffer.append(objectArray[i2]);
                    if (i2 >= objectArray.length - 1) continue;
                    buffer.append(NEW_LINE);
                }
            } else {
                buffer.append("[]");
            }
        } else {
            buffer.append("null");
        }
        return buffer;
    }
}

