/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.data.exchange;

import de.audi.atip.data.exchange.ExchangeRecordComparable;
import de.audi.atip.data.exchange.WrongDataTypeException;
import de.esolutions.fw.util.commons.Buffer;

public class ExchangeRecord
implements ExchangeRecordComparable {
    public static final int TYPE_UNDEF = -1;
    public static final int TYPE_BOOLEAN = 0;
    public static final int TYPE_BYTE = 1;
    public static final int TYPE_SHORT = 2;
    public static final int TYPE_INTEGER = 3;
    public static final int TYPE_LONG = 4;
    public static final int TYPE_FLOAT = 5;
    public static final int TYPE_DOUBLE = 6;
    public static final int TYPE_STRING = 7;
    public static final int TYPE_STRING_NULL = 8;
    static final int COL_COUNT = 5;
    static final int COL_APP = 0;
    static final int COL_KEY = 1;
    static final int COL_VERSION = 2;
    static final int COL_TYPE = 3;
    static final int COL_VALUE = 4;
    private final int app;
    final int key;
    private final int version;
    private final int datatype;
    private final Object value;

    public ExchangeRecord(String[] stringArray) throws IllegalArgumentException, WrongDataTypeException {
        if (stringArray.length != 5) {
            throw new IllegalArgumentException("Expected 5 numer of values, but was " + stringArray.length);
        }
        this.app = Integer.parseInt(stringArray[0]);
        this.key = Integer.parseInt(stringArray[1]);
        this.version = Integer.parseInt(stringArray[2]);
        this.datatype = Integer.parseInt(stringArray[3]);
        String string = stringArray[4];
        try {
            switch (this.getDatatype()) {
                case 0: {
                    this.value = Boolean.valueOf(string);
                    break;
                }
                case 1: {
                    this.value = Byte.valueOf(string);
                    break;
                }
                case 2: {
                    this.value = Short.valueOf(string);
                    break;
                }
                case 3: {
                    this.value = Integer.valueOf(string);
                    break;
                }
                case 4: {
                    this.value = Long.valueOf(string);
                    break;
                }
                case 5: {
                    this.value = Float.valueOf(string);
                    break;
                }
                case 6: {
                    this.value = Double.valueOf(string);
                    break;
                }
                case 7: {
                    this.value = string;
                    break;
                }
                case 8: {
                    this.value = null;
                    break;
                }
                default: {
                    throw new WrongDataTypeException("Unknown data type " + this.getDatatype());
                }
            }
        }
        catch (NumberFormatException numberFormatException) {
            throw new WrongDataTypeException(this.getDatatype(), string);
        }
    }

    private ExchangeRecord(int n, int n2, int n3, Object object, int n4) {
        this.app = n;
        this.key = n2;
        this.version = n3;
        this.value = object;
        this.datatype = n4;
    }

    public ExchangeRecord(int n, int n2, int n3, boolean bl) {
        this(n, n2, n3, bl, 0);
    }

    public ExchangeRecord(int n, int n2, int n3, byte by) {
        this(n, n2, n3, new Byte(by), 1);
    }

    public ExchangeRecord(int n, int n2, int n3, short s) {
        this(n, n2, n3, new Short(s), 2);
    }

    public ExchangeRecord(int n, int n2, int n3, int n4) {
        this(n, n2, n3, new Integer(n4), 3);
    }

    public ExchangeRecord(int n, int n2, int n3, long l) {
        this(n, n2, n3, new Long(l), 4);
    }

    public ExchangeRecord(int n, int n2, int n3, float f2) {
        this(n, n2, n3, new Float(f2), 5);
    }

    public ExchangeRecord(int n, int n2, int n3, double d2) {
        this(n, n2, n3, new Double(d2), 6);
    }

    public ExchangeRecord(int n, int n2, int n3, String string) {
        this(n, n2, n3, string, string == null ? 8 : 7);
    }

    public String[] toCSV() {
        String[] stringArray = new String[]{Integer.toString(this.getApp()), Integer.toString(this.key), Integer.toString(this.getVersion()), Integer.toString(this.getDatatype()), this.getValue() == null ? "null" : this.getValue().toString()};
        return stringArray;
    }

    public String toString() {
        Buffer buffer = new Buffer(500);
        buffer.append("app: ");
        buffer.append(this.getApp());
        buffer.append(" , key: ");
        buffer.append(this.key);
        buffer.append(" , value: ");
        buffer.append(this.getValue());
        buffer.append(" , version: ");
        buffer.append(this.getVersion());
        buffer.append(" , type: ");
        switch (this.getDatatype()) {
            case 0: {
                buffer.append("Boolean");
                break;
            }
            case 1: {
                buffer.append("Byte");
                break;
            }
            case 2: {
                buffer.append("Short");
                break;
            }
            case 3: {
                buffer.append("Integer");
                break;
            }
            case 4: {
                buffer.append("Long");
                break;
            }
            case 5: {
                buffer.append("Float");
                break;
            }
            case 6: {
                buffer.append("Double");
                break;
            }
            case 7: {
                buffer.append("String");
                break;
            }
            case 8: {
                buffer.append("NULL-String");
                break;
            }
            default: {
                buffer.append("Unknown");
            }
        }
        buffer.append(" (");
        buffer.append(this.getDatatype());
        buffer.append(')');
        return buffer.toString();
    }

    public boolean equals(Object object) {
        try {
            return this.key == ((ExchangeRecord)object).key;
        }
        catch (Exception exception) {
            return false;
        }
    }

    public int hashCode() {
        return this.key;
    }

    public int compareTo(Object object) {
        int n = ((ExchangeRecordComparable)object).getKey();
        return this.key - n;
    }

    public int getKey() {
        return this.key;
    }

    public int getApp() {
        return this.app;
    }

    public int getVersion() {
        return this.version;
    }

    public final int getDatatype() {
        return this.datatype;
    }

    public Object getValue() {
        return this.value;
    }
}

