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
    private static final String ARG_ALL;
    private static final String VAL_VISIBLE;
    private static final String VAL_INVISIBLE;
    private static final String VAL_NA_SYSTEM;
    private static final String VAL_NA_CL15;
    private static final String VAL_NA_SPEED;
    private static final String VO_VALUES;
    private final Map viewOptions = new HashMap();

    public AbstractDiagnosisCommandVO(String string, String[] stringArray) {
        Buffer buffer = new Buffer(string).append(" updateVO [").append("all");
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            buffer.append('|').append(stringArray[i2]);
            this.viewOptions.put(stringArray[i2].toLowerCase(), null);
        }
        buffer.append("] ").append("[vis|invis|system|clamp15|speed]");
        this.command = buffer.toString();
    }

    @Override
    public String getCommandString() {
        return this.command;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public void parseParameters(String string) {
        CarViewOption carViewOption;
        String string2;
        StringTokenizer stringTokenizer = new StringTokenizer(string);
        if (!stringTokenizer.hasMoreTokens()) {
            this.setAll(new CarViewOption(2, 0));
            return;
        }
        String string3 = stringTokenizer.nextToken();
        if (string3.equalsIgnoreCase("all")) {
            if (!stringTokenizer.hasMoreTokens()) {
                this.setAll(new CarViewOption(2, 0));
                return;
            }
            string2 = stringTokenizer.nextToken();
            carViewOption = this.parseValue(string2);
            if (carViewOption == null) {
                throw new InvalidCommandParameterException(new StringBuffer().append("invalid view option value ").append(string2).toString());
            }
            this.setAll(carViewOption);
        } else {
            if (!this.viewOptions.containsKey(string3.toLowerCase())) throw new InvalidCommandParameterException(new StringBuffer().append("wrong view option argument ").append(string3).toString());
            if (!stringTokenizer.hasMoreTokens()) throw new InvalidCommandParameterException(new StringBuffer().append("view option value missing for argument ").append(string3).toString());
            string2 = stringTokenizer.nextToken();
            carViewOption = this.parseValue(string2);
            if (carViewOption == null) {
                throw new InvalidCommandParameterException(new StringBuffer().append("invalid view option value ").append(string2).toString());
            }
            this.viewOptions.put(string3.toLowerCase(), carViewOption);
        }
        while (stringTokenizer.hasMoreTokens()) {
            string3 = stringTokenizer.nextToken();
            if (!this.viewOptions.containsKey(string3.toLowerCase())) throw new InvalidCommandParameterException(new StringBuffer().append("wrong view option argument ").append(string3).toString());
            if (!stringTokenizer.hasMoreTokens()) throw new InvalidCommandParameterException(new StringBuffer().append("view option value missing for argument ").append(string3).toString());
            string2 = stringTokenizer.nextToken();
            carViewOption = this.parseValue(string2);
            if (carViewOption == null) {
                throw new InvalidCommandParameterException(new StringBuffer().append("invalid view option value ").append(string2).toString());
            }
            this.viewOptions.put(string3.toLowerCase(), carViewOption);
        }
    }

    public CarViewOption getViewOption(String string) {
        return (CarViewOption)this.viewOptions.get(string.toLowerCase());
    }

    private CarViewOption parseValue(String string) {
        if (string.equalsIgnoreCase("vis")) {
            return new CarViewOption(2, 0);
        }
        if (string.equalsIgnoreCase("invis")) {
            return new CarViewOption(0, 0);
        }
        if (string.equalsIgnoreCase("clamp15")) {
            return new CarViewOption(1, 2);
        }
        if (string.equalsIgnoreCase("speed")) {
            return new CarViewOption(1, 3);
        }
        if (string.equalsIgnoreCase("system")) {
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

