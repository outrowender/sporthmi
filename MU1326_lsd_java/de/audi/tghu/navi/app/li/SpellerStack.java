/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.li;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.IRestorable;
import de.audi.tghu.navi.app.li.IAdditionalStateInfo;
import de.audi.tghu.navi.app.li.sc.SpellerContext;
import de.audi.tghu.navi.app.util.Util;
import de.esolutions.fw.util.commons.Buffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.dsi.ifc.navigation.LISpellerData;
import org.dsi.ifc.navigation.LIValueListElement;

public class SpellerStack {
    private static final int SPELLER_STACK_SIZE = 10;
    private static SpellerStack instance;
    private final String CLASS_NAME = Util.getClassNameFromPackageName(this.getClass());
    private final List stack = new ArrayList(10);
    private LogChannel logChannel;

    private SpellerStack(NavigationEnv navigationEnv) {
        this.logChannel = navigationEnv.getLogChannel();
    }

    public static synchronized void init(NavigationEnv navigationEnv) {
        if (instance == null) {
            instance = new SpellerStack(navigationEnv);
        }
    }

    public static synchronized boolean isInitialized() {
        return instance != null;
    }

    public static SpellerStack getInstance() throws IllegalStateException {
        if (instance == null) {
            throw new IllegalStateException("The SpellerStack was not initialized yet! Make sure to call #init() before using it.");
        }
        return instance;
    }

    public synchronized void reset() {
        this.stack.clear();
    }

    public synchronized boolean push(StackElement stackElement) {
        boolean bl = false;
        if (stackElement != null) {
            this.logChannel.log(10000000, "SpellerStack#push( %1 ) - oldSize = %2 new Size = %3 ", (Object)stackElement, (long)this.stack.size(), (long)(this.stack.size() + 1));
            bl = this.stack.add(stackElement);
        } else {
            this.logChannel.log(100000, "SpellerStack#push() - failed to push element=null on stack! ");
        }
        this.logChannel.log(1000000, "SpellerStack#push() - currentStack = %1", (Object)this.toString());
        return bl;
    }

    public synchronized StackElement pop() {
        StackElement stackElement = null;
        int n = this.stack.size();
        this.logChannel.log(10000000, "SpellerStack#pop() - old size: %1 ", (long)n);
        if (n == 0) {
            this.logChannel.log(10000, "SpellerStack#pop() - speller stack size = 0!");
        } else {
            int n2 = n - 1;
            stackElement = (StackElement)this.stack.remove(n2);
            this.logChannel.log(10000000, "SpellerStack#pop() - new size: %1", (long)n2);
        }
        this.logChannel.log(1000000, "SpellerStack#pop() - currentStack:\n %1", (Object)this.toString());
        return stackElement;
    }

    public synchronized StackElement popToId(int[] nArray) {
        this.logChannel.log(10000000, "%1#popToId() - ids to test = %2", (Object)this.CLASS_NAME, (Object)nArray);
        StackElement stackElement = null;
        if (nArray != null && nArray.length > 0) {
            while (!this.stack.isEmpty()) {
                if (this.arrayContainsValue(nArray, this.getActiveSC().getContextID())) {
                    stackElement = this.pop();
                    break;
                }
                this.pop();
            }
        }
        this.logChannel.log(10000000, "%1#popToId() returns %2", (Object)this.CLASS_NAME, stackElement);
        return stackElement;
    }

    private boolean arrayContainsValue(int[] nArray, int n) {
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            if (nArray[i2] != n) continue;
            return true;
        }
        return false;
    }

    public synchronized StackElement peekFirstStackElement() {
        if (this.stack.size() > 0) {
            Object object = this.stack.get(0);
            if (object instanceof StackElement) {
                return (StackElement)object;
            }
            this.logChannel.log(10000, "SpellerStack#peekFirstStackElement - element is no instance of StackElement!");
        } else {
            this.logChannel.log(10000, "SpellerStack#peekFirstStackElement - speller stack size = 0!");
        }
        return null;
    }

    public synchronized StackElement peekLastSelection() {
        StackElement stackElement = null;
        int n = this.stack.size();
        if (n == 0) {
            this.logChannel.log(10000, "SpellerStack#peekLastSelection() - speller stack size = 0! ");
        } else {
            for (int i2 = n - 1; i2 >= 0; --i2) {
                StackElement stackElement2 = (StackElement)this.stack.get(i2);
                if (stackElement2.element == null && stackElement2.categoryUid == -1) continue;
                stackElement = stackElement2;
                break;
            }
            if (stackElement == null) {
                this.logChannel.log(10000, "SpellerStack#peekLastSelection() - no selection found on stack! ");
            }
        }
        return stackElement;
    }

    public synchronized boolean isEmpty() {
        return this.stack.isEmpty();
    }

    public synchronized SpellerContext getActiveSC() {
        SpellerContext spellerContext = null;
        int n = this.stack.size();
        for (int i2 = n - 1; i2 >= 0 && spellerContext == null; --i2) {
            StackElement stackElement = (StackElement)this.stack.get(i2);
            spellerContext = stackElement.sc;
        }
        return spellerContext;
    }

    public synchronized boolean containsContextID(int n) {
        for (int i2 = this.stack.size() - 1; i2 >= 0; --i2) {
            StackElement stackElement = (StackElement)this.stack.get(i2);
            if (stackElement.sc == null || stackElement.sc.getContextID() != n) continue;
            return true;
        }
        return false;
    }

    public synchronized boolean isActiveSpellerContextIDEqual(int n) {
        SpellerContext spellerContext = this.getActiveSC();
        return spellerContext != null && spellerContext.getContextID() == n;
    }

    public synchronized StackElement getLastStackElement() {
        Object object;
        if (this.stack.size() > 0 && (object = this.stack.get(this.stack.size() - 1)) instanceof StackElement) {
            return (StackElement)object;
        }
        return null;
    }

    public IAdditionalStateInfo[] getAdditionalStateForFirstContextFound(int n) {
        for (int i2 = this.stack.size() - 1; i2 >= 0; --i2) {
            StackElement stackElement = (StackElement)this.stack.get(i2);
            if (stackElement.sc.getContextID() != n) continue;
            return stackElement.infos;
        }
        return null;
    }

    public synchronized int getSize() {
        return this.stack.size();
    }

    public synchronized String toString() {
        Buffer buffer = new Buffer();
        if (this.isEmpty()) {
            buffer.append("empty speller stack\n");
        } else {
            buffer.append("active SC: ").append(this.getActiveSC()).append('\n');
            Iterator iterator = this.stack.iterator();
            int n = 0;
            while (iterator.hasNext()) {
                buffer.append(iterator.next());
                buffer.append('\n');
                if (++n <= 10) continue;
                buffer.append("[...]");
                break;
            }
        }
        return buffer.toString();
    }

    public static class StackElement {
        public LISpellerData spellerData;
        public LIValueListElement element;
        public int categoryUid;
        public IAdditionalStateInfo[] infos;
        public SpellerContext sc;
        public IRestorable restorable;

        public StackElement(LISpellerData lISpellerData) {
            this(lISpellerData, null, -1, null, null, null);
        }

        public StackElement(LISpellerData lISpellerData, LIValueListElement lIValueListElement, int n, IAdditionalStateInfo[] iAdditionalStateInfoArray, SpellerContext spellerContext) {
            this(lISpellerData, lIValueListElement, n, iAdditionalStateInfoArray, spellerContext, null);
        }

        public StackElement(LISpellerData lISpellerData, LIValueListElement lIValueListElement, int n, IAdditionalStateInfo[] iAdditionalStateInfoArray, SpellerContext spellerContext, IRestorable iRestorable) {
            this.spellerData = lISpellerData;
            this.element = lIValueListElement;
            this.categoryUid = n;
            this.infos = iAdditionalStateInfoArray;
            this.sc = spellerContext;
            this.restorable = iRestorable;
        }

        public String toString() {
            Buffer buffer = new Buffer(100);
            buffer.append("[spellerData.length=");
            buffer.append(this.spellerData != null && this.spellerData.getSpellerStateData() != null ? this.spellerData.getSpellerStateData().length : 0);
            buffer.append(", ");
            buffer.append(this.element != null ? this.element.getData() : "<null>");
            buffer.append(", ");
            buffer.append(this.categoryUid);
            buffer.append(", ");
            buffer.append(this.sc);
            buffer.append(", ");
            buffer.append(this.restorable != null ? this.restorable.toString() : "<null>");
            if (this.infos != null) {
                for (int i2 = 0; i2 < this.infos.length; ++i2) {
                    buffer.append(", ");
                    buffer.append(this.infos[i2] != null ? this.infos[i2].toString() : "<null>");
                }
            }
            buffer.append(']');
            return buffer.toString();
        }
    }
}

