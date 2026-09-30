/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import com.ibm.oti.util.Msg;
import java.util.Date;
import java.util.TimerTask;

public class Timer {
    private TimerImpl impl;
    private Object finalizer = new Object(){

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void finalize() {
            TimerImpl timerImpl = Timer.this.impl;
            synchronized (timerImpl) {
                Timer.this.impl.finished = true;
                Timer.this.impl.notify();
            }
        }
    };

    public Timer(boolean bl) {
        this.impl = new TimerImpl(bl);
    }

    public Timer() {
        this.impl = new TimerImpl(false);
    }

    public void cancel() {
        this.impl.cancel();
    }

    public void schedule(TimerTask timerTask, Date date) {
        if (date.getTime() < 0L) {
            throw new IllegalArgumentException();
        }
        long l = date.getTime() - System.currentTimeMillis();
        this.scheduleImpl(timerTask, l < 0L ? 0L : l, -1L, false);
    }

    public void schedule(TimerTask timerTask, long l) {
        if (l < 0L) {
            throw new IllegalArgumentException();
        }
        this.scheduleImpl(timerTask, l, -1L, false);
    }

    public void schedule(TimerTask timerTask, long l, long l2) {
        if (l < 0L || l2 <= 0L) {
            throw new IllegalArgumentException();
        }
        this.scheduleImpl(timerTask, l, l2, false);
    }

    public void schedule(TimerTask timerTask, Date date, long l) {
        if (l <= 0L || date.getTime() < 0L) {
            throw new IllegalArgumentException();
        }
        long l2 = date.getTime() - System.currentTimeMillis();
        this.scheduleImpl(timerTask, l2 < 0L ? 0L : l2, l, false);
    }

    public void scheduleAtFixedRate(TimerTask timerTask, long l, long l2) {
        if (l < 0L || l2 <= 0L) {
            throw new IllegalArgumentException();
        }
        this.scheduleImpl(timerTask, l, l2, true);
    }

    public void scheduleAtFixedRate(TimerTask timerTask, Date date, long l) {
        if (l <= 0L || date.getTime() < 0L) {
            throw new IllegalArgumentException();
        }
        long l2 = date.getTime() - System.currentTimeMillis();
        this.scheduleImpl(timerTask, l2 < 0L ? 0L : l2, l, true);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void scheduleImpl(TimerTask timerTask, long l, long l2, boolean bl) {
        TimerImpl timerImpl = this.impl;
        synchronized (timerImpl) {
            if (this.impl.cancelled) {
                throw new IllegalStateException(Msg.getString("K00f3"));
            }
            long l3 = l + System.currentTimeMillis();
            if (l3 < 0L) {
                throw new IllegalArgumentException(Msg.getString("K00f5"));
            }
            if (timerTask.isScheduled()) {
                throw new IllegalStateException(Msg.getString("K00f6"));
            }
            if (timerTask.isCancelled()) {
                throw new IllegalStateException(Msg.getString("K00f7"));
            }
            timerTask.when = l3;
            timerTask.period = l2;
            timerTask.fixedRate = bl;
            this.impl.insertTask(timerTask);
        }
    }

    private static final class TimerImpl
    extends Thread {
        private boolean cancelled = false;
        private boolean finished = false;
        private TimerTree tasks = new TimerTree();

        TimerImpl(boolean bl) {
            this.setDaemon(bl);
            this.start();
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void run() {
            while (true) {
                TimerTask timerTask;
                TimerImpl timerImpl = this;
                synchronized (timerImpl) {
                    if (this.cancelled) {
                        return;
                    }
                    if (this.tasks.isEmpty()) {
                        if (this.finished) {
                            return;
                        }
                        try {
                            this.wait();
                        }
                        catch (Exception exception) {}
                        continue;
                    }
                    long l = System.currentTimeMillis();
                    TimerNode timerNode = this.tasks.minimum();
                    timerTask = timerNode.task;
                    if (timerTask.isCancelled()) {
                        this.tasks.delete(timerNode);
                        continue;
                    }
                    long l2 = timerTask.when - l;
                    if (l2 > 0L) {
                        try {
                            this.wait(l2);
                        }
                        catch (Exception exception) {}
                        continue;
                    }
                    timerTask.setScheduledTime(timerTask.when);
                    this.tasks.delete(timerNode);
                    if (timerTask.period >= 0L) {
                        timerTask.when = timerTask.fixedRate ? (timerTask.when += timerTask.period) : System.currentTimeMillis() + timerTask.period;
                        this.insertTask(timerTask);
                    } else {
                        timerTask.when = 0L;
                    }
                }
                try {
                    timerTask.run();
                    continue;
                }
                catch (Exception exception) {
                    continue;
                }
                break;
            }
        }

        private void insertTask(TimerTask timerTask) {
            this.tasks.insert(new TimerNode(timerTask));
            this.notify();
        }

        public synchronized void cancel() {
            this.cancelled = true;
            this.tasks = new TimerTree();
            this.notify();
        }

        private static final class TimerNode {
            TimerNode parent;
            TimerNode left;
            TimerNode right;
            TimerTask task;

            public TimerNode(TimerTask timerTask) {
                this.task = timerTask;
            }
        }

        private static final class TimerTree {
            TimerNode root;

            TimerTree() {
            }

            boolean isEmpty() {
                return this.root == null;
            }

            void insert(TimerNode timerNode) {
                TimerNode timerNode2 = null;
                TimerNode timerNode3 = this.root;
                while (timerNode3 != null) {
                    timerNode2 = timerNode3;
                    timerNode3 = timerNode.task.when < timerNode3.task.when ? timerNode3.left : timerNode3.right;
                }
                timerNode.parent = timerNode2;
                if (timerNode2 == null) {
                    this.root = timerNode;
                } else if (timerNode.task.when < timerNode2.task.when) {
                    timerNode2.left = timerNode;
                } else {
                    timerNode2.right = timerNode;
                }
            }

            void delete(TimerNode timerNode) {
                TimerNode timerNode2 = null;
                TimerNode timerNode3 = null;
                timerNode2 = timerNode.left == null || timerNode.right == null ? timerNode : this.successor(timerNode);
                timerNode3 = timerNode2.left != null ? timerNode2.left : timerNode2.right;
                if (timerNode3 != null) {
                    timerNode3.parent = timerNode2.parent;
                }
                if (timerNode2.parent == null) {
                    this.root = timerNode3;
                } else if (timerNode2 == timerNode2.parent.left) {
                    timerNode2.parent.left = timerNode3;
                } else {
                    timerNode2.parent.right = timerNode3;
                }
                if (timerNode2 != timerNode) {
                    timerNode.task = timerNode2.task;
                }
            }

            private TimerNode successor(TimerNode timerNode) {
                if (timerNode.right != null) {
                    return this.minimum(timerNode.right);
                }
                TimerNode timerNode2 = timerNode.parent;
                while (timerNode2 != null && timerNode == timerNode2.right) {
                    timerNode = timerNode2;
                    timerNode2 = timerNode2.parent;
                }
                return timerNode2;
            }

            private TimerNode minimum(TimerNode timerNode) {
                while (timerNode.left != null) {
                    timerNode = timerNode.left;
                }
                return timerNode;
            }

            TimerNode minimum() {
                return this.minimum(this.root);
            }
        }
    }
}

