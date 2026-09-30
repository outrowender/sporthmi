/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.util;

import de.esolutions.fw.util.commons.traceme.TraceMe;
import de.esolutions.fw.util.tracing.util.IThreadEntityCreator;
import java.util.WeakHashMap;

public class ThreadCache {
    private WeakHashMap mapThreadToInfo = new WeakHashMap();
    private Thread lastThread;
    private Info lastInfo;
    private IThreadEntityCreator creator;

    public ThreadCache(IThreadEntityCreator iThreadEntityCreator) {
        this.creator = iThreadEntityCreator;
    }

    public synchronized Info getThreadInfo(Thread thread) {
        Info info;
        String string = thread.getName();
        if (string == null || string.length() == 0) {
            string = "noname";
        }
        if ((info = this.lastThread == thread ? this.lastInfo : (Info)this.mapThreadToInfo.get(thread)) == null) {
            String[] stringArray = this.splitThreadName(string);
            info = this.createInfo(stringArray[0]);
            this.mapThreadToInfo.put(thread, info);
            info.msgPrefix = stringArray[1];
            info.threadName = string;
        } else if (!string.equals(info.threadName)) {
            info.threadName = string;
            String[] stringArray = this.splitThreadName(string);
            info.msgPrefix = stringArray[0].equals(info.entityName) ? stringArray[1] : " ~" + string + "~";
        }
        this.lastThread = thread;
        this.lastInfo = info;
        return info;
    }

    private String[] splitThreadName(String string) {
        String[] stringArray = new String[2];
        int n = string.indexOf(93);
        int n2 = string.length();
        if (n > 0 && n < n2 - 1) {
            stringArray[0] = string.substring(0, n + 1);
            stringArray[1] = " ~" + string.substring(n + 1) + "~";
        } else {
            stringArray[0] = string;
        }
        return stringArray;
    }

    private Info createInfo(String string) {
        int n = this.creator.createThreadEntity(string);
        TraceMe.msg(TraceMe.INFO, "Thread", "create %1 -> tid=%2", string, new Integer(n));
        return new Info(n, string);
    }

    public static class Info {
        public final int id;
        public final String entityName;
        public String msgPrefix;
        public String threadName;

        public Info(int n, String string) {
            this.id = n;
            this.entityName = string;
        }
    }
}

