/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.base;

import de.audi.atip.base.BaseLogEntryImpl$1;
import de.audi.atip.error.FatalSystemError;
import de.audi.atip.log.LogEntry;
import de.audi.atip.util.StringUtilities;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.Converter;
import de.esolutions.fw.util.commons.Formatter;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import org.osgi.framework.BundleException;

public class BaseLogEntryImpl
implements LogEntry {
    private static final int MAX_LOG_CHANNEL_NAME_LENGTH;
    private static final int MAX_NESTED;
    private static final int MAX_ARGS;
    private static final int FLAG_MASK;
    private final String logChannelName;
    protected String template;
    private String message;
    private Throwable exception;
    protected final int logLevel;
    private final long timeStamp;
    protected final long long1;
    private final long long2;
    private final long long3;
    private Object obj1;
    private Object obj2;
    private Object obj3;
    private Object obj4;
    private final int flags;

    public BaseLogEntryImpl(String string, int n, String string2, Object object, Object object2, Object object3, Object object4, long l, long l2, long l3, int n2, Throwable throwable) {
        this(System.currentTimeMillis(), string, n, string2, object, object2, object3, object4, l, l2, l3, n2, throwable);
    }

    public BaseLogEntryImpl(long l, String string, int n, String string2, Object object, Object object2, Object object3, Object object4, long l2, long l3, long l4, int n2, Throwable throwable) {
        this.timeStamp = l;
        this.logChannelName = string;
        this.logLevel = n;
        this.template = string2;
        this.obj1 = object;
        this.obj2 = object2;
        this.obj3 = object3;
        this.obj4 = object4;
        this.long1 = l2;
        this.long2 = l3;
        this.long3 = l4;
        this.flags = n2;
        this.exception = throwable;
    }

    @Override
    public String getChannelName() {
        return this.logChannelName;
    }

    @Override
    public Throwable getException() {
        return this.exception;
    }

    @Override
    public String getFormatedTimestamp() {
        return Converter.timestampToString(this.timeStamp);
    }

    @Override
    public int getLevel() {
        return this.logLevel;
    }

    @Override
    public String getLevelName() {
        switch (this.logLevel) {
            case 100000000: {
                return "DBG2 ";
            }
            case 10000000: {
                return "DEBUG";
            }
            case 1000000: {
                return "INFO ";
            }
            case 100000: {
                return "WARN ";
            }
            case 10000: {
                return "ERROR";
            }
            case 1000: {
                return "CRIT ";
            }
        }
        return new StringBuffer().append("<").append(Integer.toString(this.logLevel)).append(">").toString();
    }

    @Override
    public String getMsg() {
        if (this.message == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            PrintStream printStream = new PrintStream(byteArrayOutputStream);
            this.print(printStream);
            printStream.flush();
            this.message = byteArrayOutputStream.toString();
        }
        return this.message;
    }

    @Override
    public String getLogMessage() {
        return this.getLogMessage(null);
    }

    @Override
    public String getLogMessage(String string) {
        Buffer buffer = new Buffer(200);
        if (string != null) {
            buffer.append(string);
        }
        if (this.template != null) {
            this.printMessage(buffer);
        }
        if (this.exception != null) {
            this.printException(buffer);
        }
        return buffer.toString();
    }

    @Override
    public String getTemplate() {
        return this.template;
    }

    @Override
    public long getTimeStamp() {
        return this.timeStamp;
    }

    @Override
    public String toString() {
        return this.getMsg();
    }

    @Override
    public void print(PrintStream printStream) {
        Buffer buffer = new Buffer();
        this.print(buffer);
        printStream.print(buffer.toCharArray());
    }

    @Override
    public void print(Buffer buffer) {
        Formatter.formatTimestamp(buffer, this.timeStamp);
        buffer.append(' ');
        buffer.append(this.getLevelName());
        buffer.append(' ');
        this.appendFixedWidthLogChannelName(buffer);
        buffer.append(' ');
        if (this.getTemplate() != null) {
            this.printMessage(buffer);
        }
        if (this.exception != null) {
            this.printException(buffer);
        }
    }

    @Override
    public void freezeArgs() {
        if (this.obj1 != null && !(this.obj1 instanceof String)) {
            this.obj1 = Converter.objectToString(this.obj1);
        }
        if (this.obj2 != null && !(this.obj2 instanceof String)) {
            this.obj2 = Converter.objectToString(this.obj2);
        }
        if (this.obj3 != null && !(this.obj3 instanceof String)) {
            this.obj3 = Converter.objectToString(this.obj3);
        }
        if (this.obj4 != null && !(this.obj4 instanceof String)) {
            this.obj4 = Converter.objectToString(this.obj4);
        }
    }

    private long getLong(int n) {
        int n2 = 0;
        int n3 = this.flags;
        int n4 = 0;
        while (n4 < n) {
            switch (n3 & 7) {
                case 1: 
                case 5: 
                case 6: {
                    ++n2;
                    break;
                }
            }
            ++n4;
            n3 >>= 3;
        }
        switch (n2) {
            case 0: {
                return this.long1;
            }
            case 1: {
                return this.long2;
            }
            case 2: {
                return this.long3;
            }
        }
        return 0L;
    }

    private Object getObj(int n) {
        int n2 = 0;
        int n3 = this.flags;
        int n4 = 0;
        while (n4 < n) {
            if ((n3 & 7) == 2) {
                ++n2;
            }
            ++n4;
            n3 >>= 3;
        }
        switch (n2) {
            case 0: {
                return this.obj1;
            }
            case 1: {
                return this.obj2;
            }
            case 2: {
                return this.obj3;
            }
            case 3: {
                return this.obj4;
            }
        }
        return null;
    }

    private void appendLong(Buffer buffer, long l, int n) {
        if (n < 2) {
            buffer.append(l);
            return;
        }
        char c2 = this.getTemplate().charAt(n - 2);
        if (c2 != '0') {
            buffer.append(l);
            return;
        }
        char c3 = this.getTemplate().charAt(n - 1);
        switch (c3) {
            case 'x': {
                buffer.append(Long.toHexString(l));
                return;
            }
            case 'b': {
                buffer.append(Long.toBinaryString(l));
                return;
            }
        }
        buffer.append(l);
    }

    private void printMessage(Buffer buffer) {
        StringUtilities.formatMessage(buffer, this.getTemplate(), new BaseLogEntryImpl$1(this));
    }

    private void printException(Buffer buffer) {
        Throwable throwable = this.exception;
        buffer.append(Formatter.LINE_SEPARATOR);
        buffer.append("#####   Start Exception StackTrace   #####");
        buffer.append(Formatter.LINE_SEPARATOR);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        throwable.printStackTrace(printStream);
        for (int i2 = 0; throwable != null && i2 < 5; ++i2) {
            if ((throwable = throwable instanceof BundleException ? ((BundleException)this.exception).getNestedException() : (throwable instanceof FatalSystemError ? ((FatalSystemError)this.exception).getCause() : null)) == null) continue;
            printStream.println();
            printStream.print("Nested Exception: ");
            if (throwable.getMessage() != null) {
                printStream.println(throwable.getMessage());
            }
            throwable.printStackTrace(printStream);
        }
        String string = "";
        try {
            string = byteArrayOutputStream.toString("UTF8");
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            unsupportedEncodingException.printStackTrace();
        }
        buffer.append(string);
        buffer.append(Formatter.LINE_SEPARATOR);
        buffer.append("#####    End Exception StackTrace    #####");
    }

    private void appendFixedWidthLogChannelName(Buffer buffer) {
        buffer.append('<');
        buffer.append(this.logChannelName);
        int n = this.logChannelName.length();
        if (n < 18) {
            char[] cArray = new char[18 - n];
            Arrays.fill(cArray, ' ');
            buffer.append('>');
            buffer.append(new String(cArray));
        } else {
            buffer.append('>');
        }
    }

    static /* synthetic */ int access$000(BaseLogEntryImpl baseLogEntryImpl) {
        return baseLogEntryImpl.flags;
    }

    static /* synthetic */ long access$100(BaseLogEntryImpl baseLogEntryImpl, int n) {
        return baseLogEntryImpl.getLong(n);
    }

    static /* synthetic */ void access$200(BaseLogEntryImpl baseLogEntryImpl, Buffer buffer, long l, int n) {
        baseLogEntryImpl.appendLong(buffer, l, n);
    }

    static /* synthetic */ Object access$300(BaseLogEntryImpl baseLogEntryImpl, int n) {
        return baseLogEntryImpl.getObj(n);
    }
}

