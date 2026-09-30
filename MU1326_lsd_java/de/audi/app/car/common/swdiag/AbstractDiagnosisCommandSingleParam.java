/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.swdiag;

import de.audi.app.car.common.swdiag.IDiagnosisCommand;
import de.audi.app.car.common.swdiag.InvalidCommandParameterException;
import de.esolutions.fw.util.commons.Buffer;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public abstract class AbstractDiagnosisCommandSingleParam
implements IDiagnosisCommand {
    protected static final int PARAMETER_TYPE_STRING = 0;
    protected static final int PARAMETER_TYPE_BOOL = 1;
    protected static final int PARAMETER_TYPE_INT = 2;
    public static final int NUMBER_OF_VALUES_UNLIMITED = 65535;
    private final String[] possibleValues;
    private final int paramType;
    private List parsedValues;
    private final int min;
    private final int max;
    private final String commandString;
    private final boolean optional;
    private final int maxNumberOfValues;

    protected AbstractDiagnosisCommandSingleParam(String string, String string2, int n, int n2, String[] stringArray, int n3, int n4, boolean bl) {
        Buffer buffer = new Buffer(string).append(' ').append(string2);
        this.paramType = n2;
        this.possibleValues = this.paramType == 1 ? new String[]{"true", "false"} : stringArray;
        this.min = n3;
        this.max = n4;
        buffer.append(' ');
        if (bl) {
            buffer.append('[');
        }
        if (this.possibleValues != null) {
            buffer.append(stringArray[0]);
            for (int i2 = 1; i2 < stringArray.length; ++i2) {
                buffer.append('|').append(stringArray[i2]);
            }
        } else {
            buffer.append(n3).append("..").append(n4);
        }
        if (bl) {
            buffer.append(']');
        }
        this.commandString = buffer.toString();
        this.optional = bl;
        this.maxNumberOfValues = n;
    }

    public void parseParameters(String string) throws InvalidCommandParameterException {
        Buffer buffer = new Buffer();
        this.parsedValues = new ArrayList();
        StringTokenizer stringTokenizer = new StringTokenizer(string);
        if (this.paramType != 2) {
            if (this.possibleValues == null) {
                throw new InvalidCommandParameterException("possibleValues==null");
            }
            if (this.possibleValues.length == 0) {
                throw new InvalidCommandParameterException("possibleValues.length==0");
            }
        }
        if (!this.optional && !stringTokenizer.hasMoreTokens()) {
            throw new InvalidCommandParameterException("value required");
        }
        while (stringTokenizer.hasMoreTokens()) {
            if (this.parsedValues.size() == this.maxNumberOfValues) {
                buffer.append("Give maximal ").append(this.maxNumberOfValues).append(" value(s)");
                throw new InvalidCommandParameterException(buffer.toString());
            }
            String string2 = stringTokenizer.nextToken();
            if (this.possibleValues == null) {
                buffer.append(this.parseIntValue(string2));
            } else {
                boolean bl = false;
                block5: for (int i2 = 0; i2 < this.possibleValues.length && !bl; ++i2) {
                    if (!string2.equalsIgnoreCase(this.possibleValues[i2])) continue;
                    bl = true;
                    switch (this.paramType) {
                        case 2: {
                            buffer.append(this.parseIntValue(string2));
                            continue block5;
                        }
                        case 1: {
                            buffer.append(this.parseBoolValue(string2));
                            continue block5;
                        }
                        default: {
                            this.parsedValues.add(string2);
                        }
                    }
                }
                if (!bl) {
                    buffer.append("unexpected value ").append(string2);
                    throw new InvalidCommandParameterException(buffer.toString());
                }
            }
            if (buffer.length() <= 0) continue;
            throw new InvalidCommandParameterException(buffer.toString());
        }
    }

    private String parseBoolValue(String string) {
        Boolean bl;
        Buffer buffer = new Buffer();
        if (string.equalsIgnoreCase("true")) {
            bl = Boolean.TRUE;
        } else if (string.equalsIgnoreCase("false")) {
            bl = Boolean.FALSE;
        } else {
            return buffer.append("input value ").append(string).append(" is not a boolean. (true or false expected)").toString();
        }
        this.parsedValues.add(bl);
        return "";
    }

    private String parseIntValue(String string) {
        Integer n;
        Buffer buffer = new Buffer();
        try {
            n = new Integer(Integer.parseInt(string));
        }
        catch (NumberFormatException numberFormatException) {
            return buffer.append("input value ").append(string).append(" is not an integer.").toString();
        }
        if (n < this.min) {
            return buffer.append("input value ").append(n).append(" is too small. Must be greater or equal ").append(this.min).toString();
        }
        if (n > this.max) {
            return buffer.append("input value ").append(n).append(" is too big. Must be smaller or equal ").append(this.max).toString();
        }
        this.parsedValues.add(n);
        return "";
    }

    public Object[] getParsedValues() {
        return this.parsedValues.toArray();
    }

    public String getCommandString() {
        return this.commandString;
    }
}

