/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.swdiag;

import de.audi.app.car.common.swdiag.IDiagnosisCommand;
import de.audi.app.car.common.swdiag.InvalidCommandParameterException;
import de.esolutions.fw.util.commons.Buffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;
import org.dsi.ifc.global.CarViewOption;

public abstract class AbstractDiagnosisCommandVO
implements IDiagnosisCommand {
    public static final CarViewOption voInvis = new CarViewOption(0, 0);
    private final String command;
    private static final String ARG_ALL = "all";
    private static final String VAL_VISIBLE = "vis";
    private static final String VAL_INVISIBLE = "invis";
    private static final String VAL_NA_SYSTEM = "system";
    private static final String VAL_NA_CL15 = "clamp15";
    private static final String VAL_NA_SPEED = "speed";
    private static final String VO_VALUES = "[vis|invis|system|clamp15|speed]";
    private final Map viewOptions = new HashMap();

    public AbstractDiagnosisCommandVO(String string, String[] stringArray) {
        Buffer buffer = new Buffer(string).append(" updateVO [").append(ARG_ALL);
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            buffer.append('|').append(stringArray[i2]);
            this.viewOptions.put(stringArray[i2].toLowerCase(), null);
        }
        buffer.append("] ").append(VO_VALUES);
        this.command = buffer.toString();
    }

    public String getCommandString() {
        return this.command;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void parseParameters(String string) throws InvalidCommandParameterException {
        CarViewOption carViewOption;
        String string2;
        StringTokenizer stringTokenizer = new StringTokenizer(string);
        if (!stringTokenizer.hasMoreTokens()) {
            this.setAll(new CarViewOption(2, 0));
            return;
        }
        String string3 = stringTokenizer.nextToken();
        if (string3.equalsIgnoreCase(ARG_ALL)) {
            if (!stringTokenizer.hasMoreTokens()) {
                this.setAll(new CarViewOption(2, 0));
                return;
            }
            string2 = stringTokenizer.nextToken();
            carViewOption = this.parseValue(string2);
            if (carViewOption == null) {
                throw new InvalidCommandParameterException("invalid view option value " + string2);
            }
            this.setAll(carViewOption);
        } else {
            if (!this.viewOptions.containsKey(string3.toLowerCase())) throw new InvalidCommandParameterException("wrong view option argument " + string3);
            if (!stringTokenizer.hasMoreTokens()) throw new InvalidCommandParameterException("view option value missing for argument " + string3);
            string2 = stringTokenizer.nextToken();
            carViewOption = this.parseValue(string2);
            if (carViewOption == null) {
                throw new InvalidCommandParameterException("invalid view option value " + string2);
            }
            this.viewOptions.put(string3.toLowerCase(), carViewOption);
        }
        while (stringTokenizer.hasMoreTokens()) {
            string3 = stringTokenizer.nextToken();
            if (!this.viewOptions.containsKey(string3.toLowerCase())) throw new InvalidCommandParameterException("wrong view option argument " + string3);
            if (!stringTokenizer.hasMoreTokens()) throw new InvalidCommandParameterException("view option value missing for argument " + string3);
            string2 = stringTokenizer.nextToken();
            carViewOption = this.parseValue(string2);
            if (carViewOption == null) {
                throw new InvalidCommandParameterException("invalid view option value " + string2);
            }
            this.viewOptions.put(string3.toLowerCase(), carViewOption);
        }
    }

    public CarViewOption getViewOption(String string) {
        return (CarViewOption)this.viewOptions.get(string.toLowerCase());
    }

    private CarViewOption parseValue(String string) {
        if (string.equalsIgnoreCase(VAL_VISIBLE)) {
            return new CarViewOption(2, 0);
        }
        if (string.equalsIgnoreCase(VAL_INVISIBLE)) {
            return new CarViewOption(0, 0);
        }
        if (string.equalsIgnoreCase(VAL_NA_CL15)) {
            return new CarViewOption(1, 2);
        }
        if (string.equalsIgnoreCase(VAL_NA_SPEED)) {
            return new CarViewOption(1, 3);
        }
        if (string.equalsIgnoreCase(VAL_NA_SYSTEM)) {
            return new CarViewOption(1, 1);
        }
        return null;
    }

    private void setAll(CarViewOption carViewOption) {
        Iterator iterator = this.viewOptions.keySet().iterator();
        while (iterator.hasNext()) {
            this.viewOptions.put(iterator.next(), carViewOption);
        }
    }
}

