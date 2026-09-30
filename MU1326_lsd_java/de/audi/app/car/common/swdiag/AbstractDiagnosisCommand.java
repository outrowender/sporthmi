/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.swdiag;

import de.audi.app.car.common.swdiag.IDiagnosisCommand;
import de.audi.app.car.common.swdiag.InvalidCommandParameterException;
import de.esolutions.fw.util.commons.Buffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public abstract class AbstractDiagnosisCommand
implements IDiagnosisCommand {
    private static final int PARAMETER_TYPE_STRING = 0;
    private static final int PARAMETER_TYPE_BOOL = 1;
    private static final int PARAMETER_TYPE_INT = 2;
    public static final int NUMBER_OF_VALUES_UNLIMITED = 65535;
    private Buffer commandString;
    private Map params;
    private List anonymousParams;
    private List intParams;
    private List boolParams;

    public AbstractDiagnosisCommand(String string, String string2) {
        this.commandString = new Buffer(string).append(' ').append(string2);
        this.params = new HashMap();
        this.anonymousParams = new ArrayList();
        this.intParams = new ArrayList();
        this.boolParams = new ArrayList();
    }

    private void addParameter(String string, int n, int n2, boolean bl) {
        if (string != null && string.length() > 0) {
            this.commandString.append(' ');
            if (bl) {
                this.commandString.append("[");
            }
            this.commandString.append(string);
            if (bl) {
                this.commandString.append("]");
            }
            this.params.put(string.toLowerCase(), new Parameter(null, n, n2, bl));
        } else {
            System.out.println("Give a valid parameter name!");
        }
    }

    private void addParameter(String string, String[] stringArray, int n, int n2, boolean bl) {
        if (string != null && string.length() > 0 && stringArray != null && stringArray.length > 0) {
            this.commandString.append(' ');
            if (bl) {
                this.commandString.append("[");
            }
            this.commandString.append(string).append(':').append(stringArray[0]);
            for (int i2 = 1; i2 < stringArray.length; ++i2) {
                this.commandString.append('|').append(stringArray[i2]);
            }
            if (bl) {
                this.commandString.append("]");
            }
            this.params.put(string.toLowerCase(), new Parameter(stringArray, n, n2, bl));
        } else {
            System.out.println("Give a valid parameter name and valid possible values!");
        }
    }

    public void addStringParameter(String string, String[] stringArray, int n, boolean bl) {
        this.addParameter(string, stringArray, n, 0, bl);
    }

    public void addBooleanParameter(String string, int n, boolean bl) {
        this.addParameter(string, new String[]{"true", "false"}, n, 0, bl);
    }

    public void addIntParameter(String string, String[] stringArray, int n, boolean bl) {
        this.addParameter(string, stringArray, n, 2, bl);
    }

    public void addIntParameter(String string, int n, boolean bl) {
        this.addParameter(string, n, 2, bl);
    }

    public void addIntParameter(String string, int n, int n2, int n3, boolean bl) {
        if (string != null && string.length() > 0) {
            this.commandString.append(' ');
            if (bl) {
                this.commandString.append("[");
            }
            this.commandString.append(string).append(':').append(n).append("..").append(n2);
            if (bl) {
                this.commandString.append("]");
            }
            Parameter parameter = new Parameter(null, n3, 2, bl);
            parameter.min = n;
            parameter.max = n2;
            this.params.put(string.toLowerCase(), parameter);
        } else {
            System.out.println("Give a valid parameter name!");
        }
    }

    public void addValues(String[] stringArray, int n, boolean bl) {
        if (stringArray != null && stringArray.length > 0) {
            this.commandString.append(' ');
            if (bl) {
                this.commandString.append("[");
            }
            this.commandString.append(stringArray[0]);
            for (int i2 = 1; i2 < stringArray.length; ++i2) {
                this.commandString.append('|').append(stringArray[i2]);
            }
            if (bl) {
                this.commandString.append("]");
            }
            this.anonymousParams.add(new Parameter(stringArray, 1, n, bl));
        } else {
            System.out.println("Give valid possible values!");
        }
    }

    public void addIntValue(String string, boolean bl) {
        if (string != null && string.length() > 0) {
            this.commandString.append(' ');
            if (bl) {
                this.commandString.append("[");
            }
            this.commandString.append(" #").append(string);
            if (bl) {
                this.commandString.append("]");
            }
            Parameter parameter = new Parameter(null, 1, 2, bl);
            this.params.put(string.toLowerCase(), new Parameter(null, 1, 2, bl));
            this.intParams.add(parameter);
        } else {
            System.out.println("Give a valid parameter name!");
        }
    }

    public void addIntValue(String string, int n, int n2, boolean bl) {
        this.addIntValue(string, bl);
        Parameter parameter = (Parameter)this.params.get(string);
        parameter.min = n;
        parameter.max = n2;
    }

    public void addIntValue(int n, int n2, boolean bl) {
        this.commandString.append(' ');
        if (bl) {
            this.commandString.append("[");
        }
        this.commandString.append(n).append("..").append(n2);
        if (bl) {
            this.commandString.append("]");
        }
        Parameter parameter = new Parameter(null, 1, 2, bl);
        parameter.min = n;
        parameter.max = n2;
        this.anonymousParams.add(parameter);
    }

    public void addBooleanValue(String string, boolean bl) {
        if (string != null && string.length() > 0) {
            this.commandString.append(' ');
            if (bl) {
                this.commandString.append("[");
            }
            this.commandString.append(" b").append(string.substring(0, 1).toUpperCase()).append(string.substring(1));
            if (bl) {
                this.commandString.append("]");
            }
            Parameter parameter = new Parameter(new String[]{"true", "false"}, 1, 1, bl);
            this.params.put(string.toLowerCase(), parameter);
            this.boolParams.add(parameter);
        } else {
            System.out.println("Give a valid parameter name!");
        }
    }

    public void addBooleanValue(boolean bl) {
        this.commandString.append(' ');
        if (bl) {
            this.commandString.append("[");
        }
        this.commandString.append("true|false");
        if (bl) {
            this.commandString.append("]");
        }
        Parameter parameter = new Parameter(new String[]{"true", "false"}, 1, 1, bl);
        this.anonymousParams.add(parameter);
    }

    public void parseParameters(String string) throws InvalidCommandParameterException {
        Parameter parameter;
        this.resetNonOptionalParameters();
        Buffer buffer = new Buffer();
        StringTokenizer stringTokenizer = new StringTokenizer(string);
        if (this.params.isEmpty() && this.anonymousParams.isEmpty()) {
            return;
        }
        if (stringTokenizer.hasMoreTokens()) {
            this.parseParameters(stringTokenizer.nextToken(), stringTokenizer);
        }
        Iterator iterator = this.params.keySet().iterator();
        while (iterator.hasNext()) {
            String string2 = (String)iterator.next();
            parameter = (Parameter)this.params.get(string2);
            if (parameter.parsedValues.isEmpty() && !parameter.optional) {
                buffer.append("missing value for non-optional parameter ").append(string2);
                throw new InvalidCommandParameterException(buffer.toString());
            }
            if (parameter.parsedValues.size() <= parameter.maxNumberOfValues) continue;
            buffer.append("Give maximal ").append(parameter.maxNumberOfValues).append(" value(s) for parameter ").append(string2);
            throw new InvalidCommandParameterException(buffer.toString());
        }
        for (int i2 = 0; i2 < this.anonymousParams.size(); ++i2) {
            parameter = (Parameter)this.anonymousParams.get(i2);
            if (!parameter.parsedValues.isEmpty() || parameter.optional) continue;
            throw new InvalidCommandParameterException(buffer.toString());
        }
    }

    private void resetNonOptionalParameters() {
        Parameter parameter;
        Iterator iterator = this.params.keySet().iterator();
        while (iterator.hasNext()) {
            parameter = (Parameter)this.params.get(iterator.next());
            if (parameter.optional) continue;
            parameter.parsedValues = new ArrayList();
        }
        for (int i2 = 0; i2 < this.anonymousParams.size(); ++i2) {
            parameter = (Parameter)this.params.get(iterator.next());
            if (parameter.optional) continue;
            parameter.parsedValues = new ArrayList();
        }
    }

    private String parseParameters(String string, StringTokenizer stringTokenizer) throws InvalidCommandParameterException {
        Parameter parameter;
        int n;
        Buffer buffer = new Buffer();
        if (this.params.containsKey(string.toLowerCase())) {
            String string2 = string.toLowerCase();
            Parameter parameter2 = (Parameter)this.params.get(string2);
            if (!stringTokenizer.hasMoreTokens()) {
                buffer.append("Missing value for parameter ").append(string2);
                throw new InvalidCommandParameterException(buffer.toString());
            }
            string = stringTokenizer.nextToken();
            parameter2.parsedValues = new ArrayList();
            return this.parseValues(parameter2, string2, string, stringTokenizer);
        }
        boolean bl = false;
        for (n = 0; n < this.anonymousParams.size(); ++n) {
            parameter = (Parameter)this.anonymousParams.get(n);
            if (parameter.possibleValues == null) {
                if (this.parseIntValue(parameter, string).length() != 0) continue;
                buffer.append(this.checkRange(parameter));
                if (buffer.length() > 0) {
                    throw new InvalidCommandParameterException(buffer.toString());
                }
                bl = true;
                continue;
            }
            if (!this.isPossibleValue(string, parameter.possibleValues)) continue;
            bl = true;
            parameter.parsedValues = new ArrayList();
            if (parameter.type == 1) {
                buffer.append(this.parseBooleanValue(parameter, string));
                if (buffer.length() <= 0) continue;
                throw new InvalidCommandParameterException(buffer.toString());
            }
            parameter.parsedValues.add(string);
        }
        for (n = 0; n < this.intParams.size() && !bl; ++n) {
            parameter = (Parameter)this.intParams.get(n);
            boolean bl2 = bl = this.parseIntValue(parameter, string).length() == 0;
            if (!bl) continue;
            buffer.append(this.checkRange(parameter));
            if (buffer.length() <= 0) continue;
            throw new InvalidCommandParameterException(buffer.toString());
        }
        for (n = 0; n < this.boolParams.size() && !bl; ++n) {
            parameter = (Parameter)this.boolParams.get(n);
            bl = this.parseBooleanValue(parameter, string).length() == 0;
        }
        if (bl) {
            if (stringTokenizer.hasMoreTokens()) {
                return this.parseParameters(stringTokenizer.nextToken(), stringTokenizer);
            }
            return "";
        }
        buffer.append("unexpected input: ").append(string);
        throw new InvalidCommandParameterException(buffer.toString());
    }

    private boolean isPossibleValue(String string, String[] stringArray) {
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            if (!string.equalsIgnoreCase(stringArray[i2])) continue;
            return true;
        }
        return false;
    }

    private String parseValues(Parameter parameter, String string, String string2, StringTokenizer stringTokenizer) throws InvalidCommandParameterException {
        Buffer buffer = new Buffer();
        boolean bl = false;
        if (this.params.containsKey(string2.toLowerCase())) {
            return this.parseParameters(string2, stringTokenizer);
        }
        if (parameter.possibleValues == null) {
            bl = true;
            switch (parameter.type) {
                case 2: {
                    buffer.append(this.parseIntValue(parameter, string2));
                    break;
                }
                case 1: {
                    buffer.append(this.parseBooleanValue(parameter, string2));
                    break;
                }
                default: {
                    parameter.parsedValues.add(string2);
                }
            }
            if (buffer.length() > 0) {
                return buffer.toString();
            }
        } else {
            for (int i2 = 0; i2 < parameter.possibleValues.length; ++i2) {
                if (!string2.equalsIgnoreCase(parameter.possibleValues[i2])) continue;
                switch (parameter.type) {
                    case 2: {
                        buffer.append(this.parseIntValue(parameter, string2));
                        break;
                    }
                    case 1: {
                        buffer.append(this.parseBooleanValue(parameter, string2));
                        break;
                    }
                    default: {
                        parameter.parsedValues.add(string2);
                    }
                }
                if (buffer.length() > 0) {
                    return buffer.toString();
                }
                bl = true;
            }
        }
        if (bl) {
            if (stringTokenizer.hasMoreTokens()) {
                return this.parseValues(parameter, string, stringTokenizer.nextToken(), stringTokenizer);
            }
            return "";
        }
        return this.parseParameters(string2, stringTokenizer);
    }

    private String parseBooleanValue(Parameter parameter, String string) {
        Boolean bl;
        Buffer buffer = new Buffer();
        if (string.equalsIgnoreCase("true")) {
            bl = Boolean.TRUE;
        } else if (string.equalsIgnoreCase("false")) {
            bl = Boolean.FALSE;
        } else {
            return buffer.append("input value ").append(string).append(" is not a boolean. (true or false expected)").toString();
        }
        parameter.parsedValues = new ArrayList();
        parameter.parsedValues.add(bl);
        return "";
    }

    private String parseIntValue(Parameter parameter, String string) {
        Integer n;
        Buffer buffer = new Buffer();
        try {
            n = new Integer(Integer.parseInt(string));
        }
        catch (NumberFormatException numberFormatException) {
            return buffer.append("input value ").append(string).append(" is not an integer.").toString();
        }
        parameter.parsedValues = new ArrayList();
        parameter.parsedValues.add(n);
        return "";
    }

    private String checkRange(Parameter parameter) {
        Buffer buffer = new Buffer();
        Integer n = (Integer)parameter.parsedValues.get(parameter.parsedValues.size() - 1);
        if (n < parameter.min) {
            return buffer.append("input value ").append(n).append(" is too small. Must be greater or equal ").append(parameter.min).toString();
        }
        if (n > parameter.max) {
            return buffer.append("input value ").append(n).append(" is too big. Must be smaller or equal ").append(parameter.max).toString();
        }
        return "";
    }

    public Object[] getParsedValues(String string) {
        Parameter parameter = (Parameter)this.params.get(string.toLowerCase());
        if (parameter.parsedValues.isEmpty()) {
            return new Integer[]{new Integer(0)};
        }
        return parameter.parsedValues.toArray();
    }

    public Object[] getAnonymousParsedValues(int n) {
        return ((Parameter)this.anonymousParams.get((int)n)).parsedValues.toArray();
    }

    public String getCommandString() {
        return this.commandString.toString();
    }

    private class Parameter {
        public final String[] possibleValues;
        public final int type;
        public List parsedValues;
        public final boolean optional;
        public final int maxNumberOfValues;
        public int min = Integer.MIN_VALUE;
        public int max = Integer.MAX_VALUE;

        public Parameter(String[] stringArray, int n, int n2, boolean bl) {
            this.possibleValues = stringArray;
            this.parsedValues = new ArrayList();
            this.type = n2;
            this.optional = bl;
            this.maxNumberOfValues = n;
        }
    }
}

