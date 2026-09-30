/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.animation;

import de.audi.atip.hmi.view.IAnimationController;
import de.audi.atip.hmi.view.Screen;
import de.audi.atip.log.LogChannel;
import de.audi.atip.mmicombi.IMMICombiAnimationSyncer;
import de.audi.atip.util.Util;
import de.esolutions.hmi.widgets.audi.base.HMITerminalImpl;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.animation.AbstractAnimation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractAnimationController
implements IAnimationController {
    protected HMITerminalImpl terminal;
    protected IMMICombiAnimationSyncer animationSyncer;
    protected List registeredPaintTargets = new ArrayList(1);
    public final List[] actualAnimations;
    public int noOfAnimThatBlockRepaint;
    public final boolean[] blockInformation;
    protected List priorityQueue = new ArrayList(10);
    protected LogChannel logAnimation = IWidgetLogChannel.logAnimation;

    public AbstractAnimationController(int n) {
        this.actualAnimations = new ArrayList[n];
        this.blockInformation = new boolean[n];
        this.noOfAnimThatBlockRepaint = 0;
    }

    public boolean isPaintTargetRegistered(Screen screen) {
        return this.registeredPaintTargets.contains(screen);
    }

    public void registerPaintTarget(Screen screen) {
        if (!this.registeredPaintTargets.contains(screen)) {
            this.registeredPaintTargets.add(screen);
        } else {
            this.logAnimation.log(10000000, "AnimationController#registerPaintTarget paintTarget was already registered %1 ", (Object)screen);
        }
    }

    public void deregisterPaintTarget(Screen screen) {
        this.registeredPaintTargets.remove(screen);
    }

    public List getRegisteredPaintTargets() {
        return this.registeredPaintTargets;
    }

    public void clearRegisteredPaintTargets() {
        this.registeredPaintTargets.clear();
    }

    public void stopAllAnimations() {
        for (int i2 = 0; i2 < this.actualAnimations.length; ++i2) {
            this.stopAnimation(i2);
        }
    }

    protected void stopAnimation(int n) {
        if (this.isAnimationRunning(n)) {
            List list = this.actualAnimations[n];
            Object[] objectArray = new AbstractAnimation[list.size()];
            list.toArray(objectArray);
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                ((AbstractAnimation)objectArray[i2]).stopAnimation();
            }
        }
    }

    public boolean isAnimationRunning(int n) {
        return this.actualAnimations[n].size() > 0;
    }

    public boolean isAnimationRunning() {
        if (this.isScreenChangeAnimationRunning()) {
            return true;
        }
        for (int i2 = 0; i2 < this.actualAnimations.length; ++i2) {
            if (this.actualAnimations[i2].size() <= 0) continue;
            return true;
        }
        return false;
    }

    public boolean isAnimationRunningThatBlocksRepaint() {
        if (this.isScreenChangeAnimationRunning()) {
            return true;
        }
        this.logAnimation.log(10000000, "AbstractAnimationController#isAnimationRunningThatBlocksRepaint no of animation that block repaint: %1", (long)this.noOfAnimThatBlockRepaint);
        return this.noOfAnimThatBlockRepaint > 0;
    }

    public void activateAnimation(int n, AbstractAnimation abstractAnimation) {
        this.logAnimation.log(10000000, "AbstractAnimationController#activateAnimation animationType = %1", (long)n);
        if (abstractAnimation == null) {
            this.logAnimation.log(10000, "AnimationController#activateAnimation animation is NULL");
            return;
        }
        if (this.actualAnimations[n].contains(abstractAnimation)) {
            this.logAnimation.log(10000, "AnimationController#activateAnimation animation with type %1 is already acitvated, setTarget should be called instead", (long)abstractAnimation.getType());
            return;
        }
        this.actualAnimations[n].add(abstractAnimation);
        if (abstractAnimation.blocksRepaint()) {
            ++this.noOfAnimThatBlockRepaint;
        }
        if (this.animationSyncer != null && this.animationSyncer.isCombiSyncNeeded(n)) {
            this.animationSyncer.animationActivated(abstractAnimation);
        }
        int n2 = abstractAnimation.getTimerIntervall();
        int n3 = this.priorityQueue.size();
        for (int i2 = 0; i2 < n3; ++i2) {
            AbstractAnimation abstractAnimation2 = (AbstractAnimation)this.priorityQueue.get(i2);
            if (n2 >= abstractAnimation2.getTimerIntervall()) continue;
            this.priorityQueue.add(i2, abstractAnimation);
            break;
        }
        if (n3 == this.priorityQueue.size()) {
            this.priorityQueue.add(abstractAnimation);
        }
        if (this.logAnimation.isDebug()) {
            this.logAnimation.log(10000000, "AnimationController#activateAnimation shortest delay is %1 ", (long)((AbstractAnimation)this.priorityQueue.get(0)).getTimerIntervall());
        }
    }

    public void deactivateAnimation(int n, AbstractAnimation abstractAnimation, Exception exception) {
        this.logAnimation.log(10000000, "AbstractAnimationController#deactivateAnimation animationType = %1", (long)n);
        if (this.actualAnimations[n].contains(abstractAnimation)) {
            this.actualAnimations[n].remove(abstractAnimation);
            if (abstractAnimation.blocksRepaint()) {
                --this.noOfAnimThatBlockRepaint;
            }
        }
        if (this.priorityQueue.contains(abstractAnimation)) {
            this.priorityQueue.remove(abstractAnimation);
        }
    }

    public HMITerminalImpl getTerminal() {
        return this.terminal;
    }

    public void setTerminal(HMITerminalImpl hMITerminalImpl) {
        this.terminal = hMITerminalImpl;
    }

    public boolean drawForAnimation(AbstractAnimation abstractAnimation) {
        if (this.isScreenChangeAnimationRunning()) {
            return this.isScreenChangeType(abstractAnimation.getType());
        }
        if (!this.priorityQueue.isEmpty()) {
            if (this.priorityQueue.get(0) == abstractAnimation) {
                this.logAnimation.log(10000000, "AnimationController#drawForAnimation draw needed %1 ", (Object)abstractAnimation);
                return true;
            }
            Iterator iterator = this.priorityQueue.iterator();
            while (iterator.hasNext()) {
                AbstractAnimation abstractAnimation2 = (AbstractAnimation)iterator.next();
                if (Util.equals(abstractAnimation2, abstractAnimation)) {
                    this.logAnimation.log(10000000, "AnimationController#drawForAnimation draw needed %1 because all higher prio animations are blocked", (Object)abstractAnimation);
                    return true;
                }
                if (abstractAnimation2.isBlocked()) continue;
                this.logAnimation.log(10000000, "AnimationController#drawForAnimation draw not needed %1 because higher prio animation is not blocked ", (Object)abstractAnimation);
                return false;
            }
            this.logAnimation.log(10000000, "AnimationController#drawForAnimation draw needed %1 because all higher prio animations are blocked", (Object)abstractAnimation);
            return true;
        }
        this.logAnimation.log(10000000, "AnimationController#drawForAnimation draw needed %1 ", (Object)abstractAnimation);
        return true;
    }

    public boolean paintForAnimation(AbstractAnimation abstractAnimation) {
        if (this.isScreenChangeAnimationRunning()) {
            return this.isScreenChangeType(abstractAnimation.getType());
        }
        if (!this.priorityQueue.isEmpty()) {
            if (this.priorityQueue.get(0) == abstractAnimation) {
                return true;
            }
            boolean bl = ((AbstractAnimation)this.priorityQueue.get(0)).getAnimatedScreen() == abstractAnimation.getAnimatedScreen();
            this.logAnimation.log(10000000, "AnimationController#paintForAnimation paint needed %1 ", !bl);
            return !bl;
        }
        this.logAnimation.log(10000000, "AnimationController#paintForAnimation paint needed %1 ", (Object)abstractAnimation);
        return true;
    }

    public void setAnimationBlocked(int n, boolean bl) {
        if (n >= 0 && n < this.blockInformation.length) {
            this.blockInformation[n] = bl;
            if (!bl && this.isAnimationRunning(n)) {
                List list = this.actualAnimations[n];
                Object[] objectArray = new AbstractAnimation[list.size()];
                list.toArray(objectArray);
                for (int i2 = 0; i2 < objectArray.length; ++i2) {
                    ((AbstractAnimation)objectArray[i2]).setBlocked(bl);
                }
            }
        }
    }

    public boolean isAnimationBlocked(int n) {
        return this.blockInformation[n];
    }

    public List getActiveAnimations(int n) {
        return this.actualAnimations[n];
    }

    public void setMMICombiAnimationSyncer(IMMICombiAnimationSyncer iMMICombiAnimationSyncer) {
        this.animationSyncer = iMMICombiAnimationSyncer;
    }

    public IMMICombiAnimationSyncer getAnimationSyncer() {
        return this.animationSyncer;
    }
}

