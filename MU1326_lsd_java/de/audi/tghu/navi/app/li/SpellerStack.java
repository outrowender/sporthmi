/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.li;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.li.IAdditionalStateInfo;
import de.audi.tghu.navi.app.li.SpellerStack$StackElement;
import de.audi.tghu.navi.app.li.sc.SpellerContext;
import de.audi.tghu.navi.app.util.Util;
import de.esolutions.fw.util.commons.Buffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SpellerStack {
    private static final int SPELLER_STACK_SIZE;
    private static SpellerStack instance;
    private final String CLASS_NAME = Util.getClassNameFromPackageName(super.getClass());
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

    public static SpellerStack getInstance() {
        if (instance == null) {
            throw new IllegalStateException("The SpellerStack was not initialized yet! Make sure to call #init() before using it.");
        }
        return instance;
    }

    public synchronized void reset() {
        this.stack.clear();
    }

    public synchronized boolean push(SpellerStack$StackElement spellerStack$StackElement) {
        boolean bl = false;
        if (spellerStack$StackElement != null) {
            this.logChannel.log(-2137614336, "SpellerStack#push( %1 ) - oldSize = %2 new Size = %3 ", (Object)spellerStack$StackElement, (long)this.stack.size(), (long)(this.stack.size() + 1));
            bl = this.stack.add(spellerStack$StackElement);
        } else {
            this.logChannel.log(-1601830656, "SpellerStack#push() - failed to push element=null on stack! ");
        }
        this.logChannel.log(1078071040, "SpellerStack#push() - currentStack = %1", (Object)this.toString());
        return bl;
    }

    public synchronized SpellerStack$StackElement pop() {
        SpellerStack$StackElement spellerStack$StackElement = null;
        int n = this.stack.size();
        this.logChannel.log(-2137614336, "SpellerStack#pop() - old size: %1 ", (long)n);
        if (n == 0) {
            this.logChannel.log(10000, "SpellerStack#pop() - speller stack size = 0!");
        } else {
            int n2 = n - 1;
            spellerStack$StackElement = (SpellerStack$StackElement)this.stack.remove(n2);
            this.logChannel.log(-2137614336, "SpellerStack#pop() - new size: %1", (long)n2);
        }
        this.logChannel.log(1078071040, "SpellerStack#pop() - currentStack:\n %1", (Object)this.toString());
        return spellerStack$StackElement;
    }

    public synchronized SpellerStack$StackElement popToId(int[] nArray) {
        this.logChannel.log(-2137614336, "%1#popToId() - ids to test = %2", (Object)this.CLASS_NAME, (Object)nArray);
        SpellerStack$StackElement spellerStack$StackElement = null;
        if (nArray != null && nArray.length > 0) {
            while (!this.stack.isEmpty()) {
                if (this.arrayContainsValue(nArray, this.getActiveSC().getContextID())) {
                    spellerStack$StackElement = this.pop();
                    break;
                }
                this.pop();
            }
        }
        this.logChannel.log(-2137614336, "%1#popToId() returns %2", (Object)this.CLASS_NAME, spellerStack$StackElement);
        return spellerStack$StackElement;
    }

    private boolean arrayContainsValue(int[] nArray, int n) {
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            if (nArray[i2] != n) continue;
            return true;
        }
        return false;
    }

    public synchronized SpellerStack$StackElement peekFirstStackElement() {
        if (this.stack.size() > 0) {
            Object object = this.stack.get(0);
            if (object instanceof SpellerStack$StackElement) {
                return (SpellerStack$StackElement)object;
            }
            this.logChannel.log(10000, "SpellerStack#peekFirstStackElement - element is no instance of StackElement!");
        } else {
            this.logChannel.log(10000, "SpellerStack#peekFirstStackElement - speller stack size = 0!");
        }
        return null;
    }

    public synchronized SpellerStack$StackElement peekLastSelection() {
        SpellerStack$StackElement spellerStack$StackElement = null;
        int n = this.stack.size();
        if (n == 0) {
            this.logChannel.log(10000, "SpellerStack#peekLastSelection() - speller stack size = 0! ");
        } else {
            for (int i2 = n - 1; i2 >= 0; --i2) {
                SpellerStack$StackElement spellerStack$StackElement2 = (SpellerStack$StackElement)this.stack.get(i2);
                if (spellerStack$StackElement2.element == null && spellerStack$StackElement2.categoryUid == -1) continue;
                spellerStack$StackElement = spellerStack$StackElement2;
                break;
            }
            if (spellerStack$StackElement == null) {
                this.logChannel.log(10000, "SpellerStack#peekLastSelection() - no selection found on stack! ");
            }
        }
        return spellerStack$StackElement;
    }

    public synchronized boolean isEmpty() {
        return this.stack.isEmpty();
    }

    public synchronized SpellerContext getActiveSC() {
        SpellerContext spellerContext = null;
        int n = this.stack.size();
        for (int i2 = n - 1; i2 >= 0 && spellerContext == null; --i2) {
            SpellerStack$StackElement spellerStack$StackElement = (SpellerStack$StackElement)this.stack.get(i2);
            spellerContext = spellerStack$StackElement.sc;
        }
        return spellerContext;
    }

    public synchronized boolean containsContextID(int n) {
        for (int i2 = this.stack.size() - 1; i2 >= 0; --i2) {
            SpellerStack$StackElement spellerStack$StackElement = (SpellerStack$StackElement)this.stack.get(i2);
            if (spellerStack$StackElement.sc == null || spellerStack$StackElement.sc.getContextID() != n) continue;
            return true;
        }
        return false;
    }

    public synchronized boolean isActiveSpellerContextIDEqual(int n) {
        SpellerContext spellerContext = this.getActiveSC();
        return spellerContext != null && spellerContext.getContextID() == n;
    }

    public synchronized SpellerStack$StackElement getLastStackElement() {
        Object object;
        if (this.stack.size() > 0 && (object = this.stack.get(this.stack.size() - 1)) instanceof SpellerStack$StackElement) {
            return (SpellerStack$StackElement)object;
        }
        return null;
    }

    public IAdditionalStateInfo[] getAdditionalStateForFirstContextFound(int n) {
        for (int i2 = this.stack.size() - 1; i2 >= 0; --i2) {
            SpellerStack$StackElement spellerStack$StackElement = (SpellerStack$StackElement)this.stack.get(i2);
            if (spellerStack$StackElement.sc.getContextID() != n) continue;
            return spellerStack$StackElement.infos;
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
}

