/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.diag.sw;

import de.audi.atip.diag.sw.CmdDescriptionMap;
import de.audi.atip.diag.sw.ComplicatedParser;
import de.audi.atip.diag.sw.DiagCMDResultException;
import de.audi.atip.diag.sw.OriginalParser;
import de.esolutions.fw.util.commons.Buffer;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public abstract class AbstractSwDiagnosis {
    public static final String COMPLEX_PARSER_EX = "#!CPXPRS!#";
    public static final String COMMA_EX = "#!KMA!#";
    public static final String CURLY_BRACKET_OPENED_EX = "#!CBRAO!#";
    public static final String CURLY_BRACKET_CLOSED_EX = "#!CBRAC!#";
    public static String[][] rplStrsPreParsing = new String[][]{{"\\n", "\n"}, {"\\r", "\r"}, {"\\t", "\t"}, {"\\\"", "\""}, {"\\'", "'"}, {"\\,", "#!KMA!#"}, {"\\{", "#!CBRAO!#"}, {"\\}", "#!CBRAC!#"}, {"#!CPXPRS!#", ""}};
    public static String[][] rplStrsPostParsing = new String[][]{{"#!KMA!#", ","}, {"#!CPXPRS!#", ""}, {"#!CBRAO!#", "{"}, {"#!CBRAC!#", "}"}};
    protected static final int ID_POWER_MANAGER = 995;
    protected static final int ID_WAVEPLAYER = 666;
    protected static final int ID_TOOLS = 44;
    protected static final int ID_KEYPANEL = 38;
    protected static final int ID_ATIPAUDIO = 31012011;
    protected static final int ID_ATIPAUDIO_SDIS = 29072013;
    protected static final int ID_TUNER_SDIS = 23412397;
    protected static final int ID_SEARCH = 14062012;
    protected static final int ID_SETTINGS = 11;
    protected static final int ID_SETTINGS_PORSCHE = 323232323;
    protected static final int ID_APP_SDS_MANAGER_DICTATION = 22072013;
    private static final String CMD_METHOD_PREFIX = "cmd";
    private static final String KEY_METHOD_PREFIX = "get";
    protected ComplicatedParser cp = new ComplicatedParser();
    protected OriginalParser op = new OriginalParser();
    private Object modelbank = null;
    protected CmdDescriptionMap commandDescriptions = null;
    static /* synthetic */ Class class$de$audi$atip$diag$sw$AbstractSwDiagnosis;
    static /* synthetic */ Class class$java$lang$Object;

    public abstract String getName();

    public abstract int getId();

    public int getModelBankId() {
        return this.getId();
    }

    public Object getModelBank() {
        return this.modelbank;
    }

    public void setModelBank(Object object) {
        this.modelbank = object;
    }

    protected Object getValue(Object object, String string) {
        try {
            Method method = object.getClass().getMethod(string, new Class[0]);
            method.setAccessible(true);
            return method.invoke(object, new Object[0]);
        }
        catch (NoSuchMethodException noSuchMethodException) {
            return new StringBuffer().append("No method found for key = ").append(string).toString();
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return new StringBuffer().append("Exception occured in ").append(string).append("() : ").append(exception.toString()).toString();
        }
    }

    public Object getValue(String string) {
        return this.getValue(this, string);
    }

    public String[] getKeys() {
        return this.getKeys(this.getClass());
    }

    protected String[] getKeys(Class clazz) {
        LinkedList linkedList = new LinkedList();
        Method[] methodArray = clazz.getMethods();
        if (methodArray != null) {
            for (int i2 = 0; i2 < methodArray.length; ++i2) {
                String string = methodArray[i2].getName();
                int n = methodArray[i2].getModifiers();
                if (n != 1 || !string.startsWith(KEY_METHOD_PREFIX)) continue;
                linkedList.add(this.getKeyName(methodArray[i2]));
            }
        }
        Method[] methodArray2 = (class$de$audi$atip$diag$sw$AbstractSwDiagnosis == null ? (class$de$audi$atip$diag$sw$AbstractSwDiagnosis = AbstractSwDiagnosis.class$("de.audi.atip.diag.sw.AbstractSwDiagnosis")) : class$de$audi$atip$diag$sw$AbstractSwDiagnosis).getDeclaredMethods();
        for (int i3 = 0; i3 < methodArray2.length; ++i3) {
            String string = methodArray2[i3].getName();
            if (!linkedList.contains(string)) continue;
            linkedList.remove(string);
        }
        return (String[])linkedList.toArray(new String[linkedList.size()]);
    }

    protected String getKeyName(Method method) {
        return method.getName();
    }

    public String[] getCommands() {
        return this.getCommands(this.getClass());
    }

    protected String[] getCommands(Class clazz) {
        LinkedList linkedList = new LinkedList();
        Method[] methodArray = clazz.getMethods();
        if (methodArray != null) {
            for (int i2 = 0; i2 < methodArray.length; ++i2) {
                String string = methodArray[i2].getName();
                if (!string.startsWith(CMD_METHOD_PREFIX)) continue;
                linkedList.add(this.getCommandName(methodArray[i2]));
            }
        }
        return (String[])linkedList.toArray(new String[linkedList.size()]);
    }

    public CmdDescriptionMap getCommandDescriptions() {
        return this.commandDescriptions;
    }

    protected String getCommandName(Method method) {
        Class[] classArray = method.getParameterTypes();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < classArray.length; ++i2) {
            if (i2 != 0) {
                stringBuffer.append(" | ");
            }
            stringBuffer.append(classArray[i2].getName());
        }
        return new StringBuffer().append(method.getName()).append('(').append(stringBuffer.toString()).append(')').toString();
    }

    protected String replaceSequences(String string, String[][] stringArray) {
        String string2 = string;
        if (string != null && string.length() > 0 && stringArray != null && stringArray.length > 0) {
            for (int i2 = 0; i2 < stringArray.length; ++i2) {
                if (stringArray[i2] == null || stringArray[i2].length <= 1) continue;
                String string3 = stringArray[i2][0];
                String string4 = stringArray[i2][1];
                int n = -string4.length();
                do {
                    if ((n = string2.indexOf(string3, n + string4.length())) == -1) continue;
                    string2 = new StringBuffer().append(string2.substring(0, n)).append(string4).append(string2.substring(n + string3.length())).toString();
                } while (n != -1);
            }
        }
        return string2;
    }

    protected Object postProcess(Object stringArray) {
        if (stringArray instanceof LinkedList) {
            int n;
            Object[] objectArray = ((LinkedList)stringArray).toArray();
            for (n = 0; n < objectArray.length; ++n) {
                objectArray[n] = this.postProcess(objectArray[n]);
            }
            ((LinkedList)stringArray).clear();
            for (n = 0; n < objectArray.length; ++n) {
                ((LinkedList)stringArray).add(objectArray[n]);
            }
        } else if (stringArray instanceof String) {
            stringArray = this.replaceSequences((String)stringArray, rplStrsPostParsing);
        } else if (stringArray instanceof String[]) {
            String[] stringArray2 = stringArray;
            for (int i2 = 0; i2 < stringArray2.length; ++i2) {
                stringArray2[i2] = (String)this.postProcess(stringArray2[i2]);
            }
            stringArray = stringArray2;
        } else if (stringArray instanceof String[][]) {
            String[][] stringArray3 = (String[][])stringArray;
            for (int i3 = 0; i3 < stringArray3.length; ++i3) {
                stringArray3[i3] = (String[])this.postProcess(stringArray3[i3]);
            }
            stringArray = stringArray3;
        } else if (stringArray instanceof String[][][]) {
            String[][][] stringArray4 = (String[][][])stringArray;
            for (int i4 = 0; i4 < stringArray4.length; ++i4) {
                stringArray4[i4] = (String[][])this.postProcess(stringArray4[i4]);
            }
            stringArray = stringArray4;
        }
        return stringArray;
    }

    protected Object processNewCommand(Object object, String string, Object object2) {
        int n;
        String string2;
        OriginalParser originalParser = this.op;
        if (object2 instanceof String) {
            string2 = (String)object2;
            originalParser = string2.indexOf(COMPLEX_PARSER_EX) != -1 ? this.cp : originalParser;
            object2 = this.replaceSequences(string2, rplStrsPreParsing);
            originalParser = ((String)object2).indexOf(123) != -1 ? this.cp : originalParser;
        }
        string2 = (n = string.indexOf(40)) != -1 ? string.substring(0, n) : string;
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        boolean bl = false;
        if (object2 instanceof String && (bl = originalParser.parseParams((String)object2, linkedList, linkedList2))) {
            linkedList2 = (LinkedList)this.postProcess(linkedList2);
        }
        AccessibleObject accessibleObject = null;
        try {
            if (bl) {
                accessibleObject = object.getClass().getMethod(string2, (Class[])linkedList.toArray(new Class[linkedList.size()]));
            } else {
                System.out.println("Param Parsing Failed");
            }
        }
        catch (Exception exception) {
            object2 = AbstractSwDiagnosis.removeLongIdentifiers((String)object2);
            int n2 = this.processCommand(string, object2);
            if (n2 != -10) {
                return new Integer(n2);
            }
            this.printErrorMessageMethodNotFound(string2, linkedList);
            return exception;
        }
        if (accessibleObject != null) {
            try {
                accessibleObject.setAccessible(true);
                Object object3 = ((Method)accessibleObject).invoke(object, linkedList2.toArray());
                if (object3 != null) {
                    return object3;
                }
                return new Integer(0);
            }
            catch (Exception exception) {
                Throwable throwable = exception.getCause();
                if (throwable != null) {
                    if (throwable instanceof DiagCMDResultException) {
                        return throwable.getMessage();
                    }
                    exception.printStackTrace();
                    return throwable;
                }
                exception.printStackTrace();
                return exception;
            }
        }
        return new Integer(this.processCommand(string, object2));
    }

    public Object processNewCommand(String string, Object object) {
        return this.processNewCommand(this, string, object);
    }

    private void printErrorMessageMethodNotFound(String string, LinkedList linkedList) {
        ArrayList arrayList = new ArrayList();
        String[] stringArray = this.getCommands();
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            if (!stringArray[i2].startsWith(string)) continue;
            arrayList.add(stringArray[i2]);
        }
        Buffer buffer = new Buffer(new StringBuffer().append(string).append("(").toString());
        Iterator iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            buffer.append(iterator.next());
            if (!iterator.hasNext()) continue;
            buffer.append(" | ");
        }
        buffer.append(")");
        if (arrayList.isEmpty()) {
            System.out.println(new StringBuffer().append("Method name not found: ").append(buffer).toString());
        } else {
            System.out.println(new StringBuffer().append("Method not found:  ").append(buffer).toString());
            iterator = arrayList.iterator();
            while (iterator.hasNext()) {
                System.out.println(new StringBuffer().append("Did you mean this: ").append(iterator.next()).toString());
            }
        }
    }

    public int processCommand(String string, Object object) {
        return -10;
    }

    public static String dumpObject(Object object) {
        Buffer buffer = new Buffer(1000);
        Class clazz = object.getClass();
        do {
            AbstractSwDiagnosis.emitXMLHeader(buffer, clazz);
            Field[] fieldArray = clazz.getDeclaredFields();
            for (int i2 = 0; i2 < fieldArray.length; ++i2) {
                Field field = fieldArray[i2];
                field.setAccessible(true);
                Object object2 = null;
                try {
                    object2 = field.get(object);
                }
                catch (IllegalArgumentException illegalArgumentException) {
                    illegalArgumentException.printStackTrace();
                    continue;
                }
                catch (IllegalAccessException illegalAccessException) {
                    illegalAccessException.printStackTrace();
                    continue;
                }
                if ((field.getType().isPrimitive() || "java.lang.String".equals(field.getType().getName())) && object2 != null) {
                    AbstractSwDiagnosis.emitXML(buffer, field.getType().getName(), field.getName(), object2);
                    continue;
                }
                if (field.getType().isArray() && object2 != null) {
                    buffer.append(new StringBuffer().append("  <").append(field.getName()).append(">\n").toString());
                    for (int i3 = 0; i3 < Array.getLength(object2); ++i3) {
                        Object object3 = Array.get(object2, i3);
                        AbstractSwDiagnosis.emitXML(buffer, object3.getClass().getName(), new StringBuffer().append("[").append(i3).append("]").toString(), object3);
                    }
                    buffer.append(new StringBuffer().append("  </").append(field.getName()).append(">\n").toString());
                    continue;
                }
                buffer.append(new StringBuffer().append("  <").append(field.getName()).append(">\n").toString());
                buffer.append(new StringBuffer().append("    ").append(object2 == null ? "null" : object2).toString());
                buffer.append(new StringBuffer().append("\n  </").append(field.getName()).append(">\n").toString());
            }
            AbstractSwDiagnosis.emitXMLFooter(buffer, clazz);
        } while ((clazz = clazz.getSuperclass()) != (class$java$lang$Object == null ? AbstractSwDiagnosis.class$("java.lang.Object") : class$java$lang$Object));
        return buffer.toString();
    }

    protected Field getField(Class clazz, String string) throws SecurityException, NoSuchFieldException {
        Field field = clazz.getDeclaredField(string);
        field.setAccessible(true);
        return field;
    }

    protected Field[] getFields(Field[] fieldArray, String string) {
        ArrayList arrayList = new ArrayList(fieldArray.length);
        for (int i2 = 0; i2 < fieldArray.length; ++i2) {
            if (fieldArray[i2].getName().indexOf(string) == -1) continue;
            arrayList.add(fieldArray[i2]);
        }
        Object[] objectArray = new Field[arrayList.size()];
        arrayList.toArray(objectArray);
        return objectArray;
    }

    protected Field[] getFields(Field[] fieldArray, Object object) throws IllegalAccessException {
        ArrayList arrayList = new ArrayList(fieldArray.length);
        for (int i2 = 0; i2 < fieldArray.length; ++i2) {
            if (!fieldArray[i2].get(new Object()).equals(object)) continue;
            arrayList.add(fieldArray[i2]);
        }
        Object[] objectArray = new Field[arrayList.size()];
        arrayList.toArray(objectArray);
        return objectArray;
    }

    protected String toString(Field[] fieldArray) {
        if (fieldArray.length == 1) {
            return this.toString(fieldArray[0]);
        }
        Buffer buffer = new Buffer(1000);
        for (int i2 = 0; i2 < fieldArray.length; ++i2) {
            buffer.append(this.toString(fieldArray[i2])).append(", ");
        }
        return buffer.toString();
    }

    private String toString(Field field) {
        try {
            return new Buffer().append(field.getName()).append(" (").append(field.get(new Object())).append(')').toString();
        }
        catch (IllegalAccessException illegalAccessException) {
            return new Buffer().append(field.getName()).append(" (").append(illegalAccessException).toString();
        }
    }

    private static void emitXML(Buffer buffer, String string, String string2, Object object) {
        buffer.append(new StringBuffer().append("  <").append(string).append(" name=\"").append(string2).append("\" value=\"").append(object.toString()).append("\" />\n").toString());
    }

    private static void emitXMLHeader(Buffer buffer, Class clazz) {
        buffer.append('\n').append(new StringBuffer().append("<").append(clazz.getName()).append(">\n").toString());
    }

    private static void emitXMLFooter(Buffer buffer, Class clazz) {
        buffer.append(new StringBuffer().append("</").append(clazz.getName()).append(">\n").toString());
    }

    public static String removeLongIdentifiers(String string) {
        StringTokenizer stringTokenizer = new StringTokenizer(string, ",");
        Buffer buffer = new Buffer();
        while (stringTokenizer.hasMoreTokens()) {
            String string2 = stringTokenizer.nextToken().trim();
            if (OriginalParser.isLongWithIdentifier(string2)) {
                string2 = string2.substring(0, string2.length() - 1);
            }
            buffer.append(string2);
            if (!stringTokenizer.hasMoreTokens()) continue;
            buffer.append(',');
        }
        return buffer.toString();
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

