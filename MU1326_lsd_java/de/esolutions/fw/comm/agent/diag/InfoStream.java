/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.diag;

import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.StringUtils;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Stack;

public class InfoStream {
    private final PrintStream ps;
    private int indent = 0;
    private final Stack stack;
    protected boolean brief = false;

    public InfoStream(PrintStream printStream) {
        this.ps = printStream;
        this.stack = new Stack();
    }

    public InfoStream(PrintStream printStream, boolean bl) {
        this.ps = printStream;
        this.stack = new Stack();
        this.brief = bl;
    }

    public void begin(String string) {
        Buffer buffer = new Buffer();
        if (!this.brief) {
            this.addIndent(buffer);
        }
        buffer.append(string);
        this.ps.println(buffer.toString());
        ++this.indent;
        this.stack.push(new ArrayList());
    }

    public void end() {
        Entry entry;
        ArrayList arrayList = (ArrayList)this.stack.pop();
        ListIterator listIterator = arrayList.listIterator();
        int n = 0;
        while (listIterator.hasNext()) {
            entry = (Entry)listIterator.next();
            int n2 = entry.key.length();
            if (n2 <= n) continue;
            n = n2;
        }
        listIterator = arrayList.listIterator();
        while (listIterator.hasNext()) {
            entry = (Entry)listIterator.next();
            String string = this.brief ? entry.key : StringUtils.padString(entry.key, n, 4);
            String string2 = entry.value;
            Buffer buffer = new Buffer();
            if (!this.brief) {
                this.addIndent(buffer);
            }
            buffer.append(string);
            if (!this.brief) {
                buffer.append("  ");
            }
            buffer.append(string2);
            this.ps.println(buffer.toString());
        }
        --this.indent;
    }

    public void print(String string) {
        Buffer buffer = new Buffer();
        if (!this.brief) {
            this.addIndent(buffer);
        }
        buffer.append(string);
        this.ps.println(buffer.toString());
    }

    public void print(String string, Object object) {
        ArrayList arrayList = (ArrayList)this.stack.peek();
        if (arrayList != null) {
            String string2 = object == null ? "[null]" : object.toString();
            arrayList.add(new Entry(string, string2));
        }
    }

    public void print(String string, int n) {
        ArrayList arrayList = (ArrayList)this.stack.peek();
        if (arrayList != null) {
            arrayList.add(new Entry(string, Integer.toString(n)));
        }
    }

    private void addIndent(Buffer buffer) {
        for (int i2 = 0; i2 < this.indent; ++i2) {
            buffer.append("  ");
        }
    }

    public boolean isBrief() {
        return this.brief;
    }

    private static class Entry {
        public final String key;
        public final String value;

        public Entry(String string, String string2) {
            this.key = string;
            this.value = string2;
        }
    }
}

