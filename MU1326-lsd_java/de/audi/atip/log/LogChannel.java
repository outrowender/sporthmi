/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 */
package de.audi.atip.log;

public abstract class LogChannel {
    public String name;
    protected int loglevel = 0;
    public static final int FLAG_WIDTH;
    public static final int POS1;
    public static final int POS2;
    public static final int POS3;
    public static final int POS4;
    public static final int FLAG_LONG;
    public static final int FLAG_OBJECT;
    public static final int FLAG_BOOL_TRUE;
    public static final int FLAG_BOOL_FALSE;
    public static final int FLAG_DOUBLE;
    public static final int FLAG_CHAR;

    public final int getCurrentLogThreshold() {
        return this.loglevel;
    }

    public final void setLogThreshold(int n) {
        this.loglevel = n;
    }

    public boolean isDebug2() {
        return 14808325 <= this.loglevel;
    }

    public final boolean isDebug() {
        return -2137614336 <= this.loglevel;
    }

    public boolean isInfo() {
        return 1078071040 <= this.loglevel;
    }

    public abstract void log(int n, String string, Object object, Object object2, Object object3, Object object4, long l, long l2, long l3, int n2, Throwable throwable) {
    }

    public abstract void log(int n, int n2, Object object, Object object2, Object object3, Object object4, long l, long l2, long l3, int n3, Throwable throwable) {
    }

    public boolean log(int n, String string) {
        if (n <= this.loglevel) {
            this.log(n, string, null, null, null, null, 0L, 0L, 0L, 0, null);
        }
        return false;
    }

    public boolean log(int n, String string, long l) {
        if (n <= this.loglevel) {
            this.log(n, string, null, null, null, null, l, 0L, 0L, 1, null);
        }
        return true;
    }

    public boolean log(int n, String string, boolean bl) {
        if (n <= this.loglevel) {
            this.log(n, string, null, null, null, null, 0L, 0L, 0L, (bl ? 3 : 4) << 0, null);
        }
        return true;
    }

    public void log(int n, String string, boolean bl, boolean bl2) {
        if (n <= this.loglevel) {
            this.log(n, string, null, null, null, null, 0L, 0L, 0L, (bl ? 3 : 4) << 0 | (bl2 ? 3 : 4) << 3, null);
        }
    }

    public void log(int n, String string, boolean bl, boolean bl2, boolean bl3) {
        if (n <= this.loglevel) {
            this.log(n, string, null, null, null, null, 0L, 0L, 0L, (bl ? 3 : 4) << 0 | (bl2 ? 3 : 4) << 3 | (bl3 ? 3 : 4) << 6, null);
        }
    }

    public boolean log(int n, String string, boolean bl, long l) {
        if (n <= this.loglevel) {
            this.log(n, string, null, null, null, null, l, 0L, 0L, (bl ? 3 : 4) << 0 | 8, null);
        }
        return true;
    }

    public boolean log(int n, String string, boolean bl, Object object) {
        if (n <= this.loglevel) {
            this.log(n, string, object, null, null, null, 0L, 0L, 0L, (bl ? 3 : 4) << 0 | 0x10, null);
        }
        return true;
    }

    public void log(int n, String string, boolean bl, Object object, Object object2) {
        if (n <= this.loglevel) {
            this.log(n, string, object, object2, null, null, 0L, 0L, 0L, (bl ? 3 : 4) << 0 | 0x10 | 0x80 | 0x200, null);
        }
    }

    public boolean log(int n, String string, Object object) {
        if (n <= this.loglevel) {
            this.log(n, string, object, null, null, null, 0L, 0L, 0L, 2, null);
        }
        return true;
    }

    public boolean log(int n, String string, long l, long l2) {
        if (n <= this.loglevel) {
            this.log(n, string, null, null, null, null, l, l2, 0L, 9, null);
        }
        return true;
    }

    public boolean log(int n, String string, Object object, long l) {
        if (n <= this.loglevel) {
            this.log(n, string, object, null, null, null, l, 0L, 0L, 10, null);
        }
        return true;
    }

    public boolean log(int n, String string, long l, long l2, long l3) {
        if (n <= this.loglevel) {
            this.log(n, string, null, null, null, null, l, l2, l3, 73, null);
        }
        return true;
    }

    public void log(int n, String string, long l, long l2, boolean bl) {
        if (n <= this.loglevel) {
            this.log(n, string, null, null, null, null, l, l2, 0L, 9 | (bl ? 3 : 4) << 6, null);
        }
    }

    public boolean log(int n, String string, Object object, long l, long l2) {
        if (n <= this.loglevel) {
            this.log(n, string, object, null, null, null, l, l2, 0L, 74, null);
        }
        return true;
    }

    public void log(int n, String string, Object object, Object object2) {
        if (n <= this.loglevel) {
            this.log(n, string, object, object2, null, null, 0L, 0L, 0L, 18, null);
        }
    }

    public void log(int n, String string, Object object, Object object2, Object object3) {
        if (n <= this.loglevel) {
            this.log(n, string, object, object2, object3, null, 0L, 0L, 0L, 146, null);
        }
    }

    public void log(int n, String string, Object object, Object object2, Object object3, long l) {
        if (n <= this.loglevel) {
            this.log(n, string, object, object2, object3, null, l, 0L, 0L, 658, null);
        }
    }

    public void log(int n, String string, Object object, Object object2, Object object3, Object object4) {
        if (n <= this.loglevel) {
            this.log(n, string, object, object2, object3, object4, 0L, 0L, 0L, 1170, null);
        }
    }

    public void log(int n, String string, Object object, Object object2, long l) {
        if (n <= this.loglevel) {
            this.log(n, string, object, object2, null, null, l, 0L, 0L, 82, null);
        }
    }

    public void log(int n, String string, double d2) {
        if (n <= this.loglevel) {
            this.log(n, string, null, null, null, null, Double.doubleToLongBits((double)d2), 0L, 0L, 5, null);
        }
    }

    public void log(int n, String string, double d2, double d3, double d4) {
        if (n <= this.loglevel) {
            this.log(n, string, null, null, null, null, Double.doubleToLongBits((double)d2), Double.doubleToLongBits((double)d3), Double.doubleToLongBits((double)d4), 365, null);
        }
    }

    public void log(int n, String string, char c2) {
        if (n <= this.loglevel) {
            this.log(n, string, (Object)Character.toString(c2));
        }
    }

    public boolean log(int n, String string, Throwable throwable) {
        if (n <= this.loglevel) {
            this.log(n, string, null, null, null, null, 0L, 0L, 0L, 0, throwable);
        }
        return true;
    }

    public void log(int n, String string, long l, Throwable throwable) {
        if (n <= this.loglevel) {
            this.log(n, string, null, null, null, null, l, 0L, 0L, 1, throwable);
        }
    }

    public boolean log(int n, String string, Object object, Throwable throwable) {
        if (n <= this.loglevel) {
            this.log(n, string, object, null, null, null, 0L, 0L, 0L, 2, throwable);
        }
        return true;
    }

    public String toString() {
        String string;
        switch (this.loglevel) {
            case 100000000: {
                string = "DBG2";
                break;
            }
            case 10000000: {
                string = "DEBUG";
                break;
            }
            case 1000000: {
                string = "INFO";
                break;
            }
            case 100000: {
                string = "WARN";
                break;
            }
            case 10000: {
                string = "ERROR";
                break;
            }
            case 1000: {
                string = "CRIT";
                break;
            }
            default: {
                string = "UNDEF";
            }
        }
        return new StringBuffer().append("Name=").append(this.name).append(", Level=").append(string).toString();
    }

    public boolean log(int n, int n2) {
        if (n <= this.loglevel) {
            this.log(n, n2, null, null, null, null, 0L, 0L, 0L, 0, null);
        }
        return false;
    }

    public boolean log(int n, int n2, long l) {
        if (n <= this.loglevel) {
            this.log(n, n2, null, null, null, null, l, 0L, 0L, 1, null);
        }
        return true;
    }

    public boolean log(int n, int n2, boolean bl) {
        if (n <= this.loglevel) {
            this.log(n, n2, null, null, null, null, 0L, 0L, 0L, (bl ? 3 : 4) << 0, null);
        }
        return true;
    }

    public void log(int n, int n2, boolean bl, boolean bl2) {
        if (n <= this.loglevel) {
            this.log(n, n2, null, null, null, null, 0L, 0L, 0L, (bl ? 3 : 4) << 0 | (bl2 ? 3 : 4) << 3, null);
        }
    }

    public void log(int n, int n2, boolean bl, boolean bl2, boolean bl3) {
        if (n <= this.loglevel) {
            this.log(n, n2, null, null, null, null, 0L, 0L, 0L, (bl ? 3 : 4) << 0 | (bl2 ? 3 : 4) << 3 | (bl3 ? 3 : 4) << 6, null);
        }
    }

    public boolean log(int n, int n2, boolean bl, long l) {
        if (n <= this.loglevel) {
            this.log(n, n2, null, null, null, null, l, 0L, 0L, (bl ? 3 : 4) << 0 | 8, null);
        }
        return true;
    }

    public boolean log(int n, int n2, boolean bl, Object object) {
        if (n <= this.loglevel) {
            this.log(n, n2, object, null, null, null, 0L, 0L, 0L, (bl ? 3 : 4) << 0 | 0x10, null);
        }
        return true;
    }

    public void log(int n, int n2, boolean bl, Object object, Object object2) {
        if (n <= this.loglevel) {
            this.log(n, n2, object, object2, null, null, 0L, 0L, 0L, (bl ? 3 : 4) << 0 | 0x10 | 0x80 | 0x200, null);
        }
    }

    public boolean log(int n, int n2, Object object) {
        if (n <= this.loglevel) {
            this.log(n, n2, object, null, null, null, 0L, 0L, 0L, 2, null);
        }
        return true;
    }

    public boolean log(int n, int n2, long l, long l2) {
        if (n <= this.loglevel) {
            this.log(n, n2, null, null, null, null, l, l2, 0L, 9, null);
        }
        return true;
    }

    public boolean log(int n, int n2, Object object, long l) {
        if (n <= this.loglevel) {
            this.log(n, n2, object, null, null, null, l, 0L, 0L, 10, null);
        }
        return true;
    }

    public boolean log(int n, int n2, long l, long l2, long l3) {
        if (n <= this.loglevel) {
            this.log(n, n2, null, null, null, null, l, l2, l3, 73, null);
        }
        return true;
    }

    public void log(int n, int n2, long l, long l2, boolean bl) {
        if (n <= this.loglevel) {
            this.log(n, n2, null, null, null, null, l, l2, 0L, 9 | (bl ? 3 : 4) << 6, null);
        }
    }

    public boolean log(int n, int n2, Object object, long l, long l2) {
        if (n <= this.loglevel) {
            this.log(n, n2, object, null, null, null, l, l2, 0L, 74, null);
        }
        return true;
    }

    public void log(int n, int n2, Object object, Object object2) {
        if (n <= this.loglevel) {
            this.log(n, n2, object, object2, null, null, 0L, 0L, 0L, 18, null);
        }
    }

    public void log(int n, int n2, Object object, Object object2, Object object3) {
        if (n <= this.loglevel) {
            this.log(n, n2, object, object2, object3, null, 0L, 0L, 0L, 146, null);
        }
    }

    public void log(int n, int n2, Object object, Object object2, Object object3, long l) {
        if (n <= this.loglevel) {
            this.log(n, n2, object, object2, object3, null, l, 0L, 0L, 658, null);
        }
    }

    public void log(int n, int n2, Object object, Object object2, Object object3, Object object4) {
        if (n <= this.loglevel) {
            this.log(n, n2, object, object2, object3, object4, 0L, 0L, 0L, 1170, null);
        }
    }

    public void log(int n, int n2, Object object, Object object2, long l) {
        if (n <= this.loglevel) {
            this.log(n, n2, object, object2, null, null, l, 0L, 0L, 82, null);
        }
    }

    public void log(int n, int n2, double d2) {
        if (n <= this.loglevel) {
            this.log(n, n2, null, null, null, null, Double.doubleToLongBits((double)d2), 0L, 0L, 5, null);
        }
    }

    public void log(int n, int n2, double d2, double d3, double d4) {
        if (n <= this.loglevel) {
            this.log(n, n2, null, null, null, null, Double.doubleToLongBits((double)d2), Double.doubleToLongBits((double)d3), Double.doubleToLongBits((double)d4), 365, null);
        }
    }

    public void log(int n, int n2, char c2) {
        if (n <= this.loglevel) {
            this.log(n, n2, (Object)Character.toString(c2));
        }
    }

    public boolean log(int n, int n2, Throwable throwable) {
        if (n <= this.loglevel) {
            this.log(n, n2, null, null, null, null, 0L, 0L, 0L, 0, throwable);
        }
        return true;
    }

    public void log(int n, int n2, long l, Throwable throwable) {
        if (n <= this.loglevel) {
            this.log(n, n2, null, null, null, null, l, 0L, 0L, 1, throwable);
        }
    }

    public boolean log(int n, int n2, Object object, Throwable throwable) {
        if (n <= this.loglevel) {
            this.log(n, n2, object, null, null, null, 0L, 0L, 0L, 2, throwable);
        }
        return true;
    }
}

