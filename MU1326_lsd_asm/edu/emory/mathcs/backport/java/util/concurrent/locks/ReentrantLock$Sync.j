.version 50 0 
.class super abstract [81] 
.super [83] 
.implements [85] 
.field private static final [86] [87] 
.field protected transient [88] [89] 
.field protected transient [90] [91] 

.method protected [93] : [94] 
    .attribute [92] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [13] 
L4:     aload_0 
L5:     aconst_null 
L6:     putfield [17] 
L9:     aload_0 
L10:    iconst_0 
L11:    putfield [18] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public abstract [95] : [96] 
    .attribute [92] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method public abstract [97] : [98] 
    .attribute [92] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method final [99] : [100] 
    .attribute [92] .code stack 3 locals 1 
L0:     aload_0 
L1:     dup 
L2:     getfield [11] 
L5:     iconst_1 
L6:     iadd 
L7:     dup_x1 
L8:     putfield [18] 
L11:    istore_1 
L12:    iload_1 
L13:    ifge L26 
L16:    new [19] 
L19:    dup 
L20:    ldc [3] 
L22:    invokespecial [14] 
L25:    athrow 
L26:    aload_0 
L27:    iload_1 
L28:    putfield [18] 
L31:    return 
L32:    
    .end code 
.end method 

.method public [101] : [102] 
    .attribute [92] .code stack 2 locals 3 
L0:     invokestatic [4] 
L3:     astore_1 
L4:     aload_0 
L5:     dup 
L6:     astore_2 
L7:     monitorenter 
        .catch [0] from L8 to L28 using L50 
L8:     aload_0 
L9:     getfield [10] 
L12:    ifnonnull L29 
L15:    aload_0 
L16:    aload_1 
L17:    putfield [17] 
L20:    aload_0 
L21:    iconst_1 
L22:    putfield [18] 
L25:    iconst_1 
L26:    aload_2 
L27:    monitorexit 
L28:    areturn 
        .catch [0] from L29 to L44 using L50 
L29:    aload_1 
L30:    aload_0 
L31:    getfield [10] 
L34:    if_acmpne L45 
L37:    aload_0 
L38:    invokespecial [15] 
L41:    iconst_1 
L42:    aload_2 
L43:    monitorexit 
L44:    areturn 
        .catch [0] from L45 to L47 using L50 
L45:    aload_2 
L46:    monitorexit 
L47:    goto L55 
        .catch [0] from L50 to L53 using L50 
L50:    astore_3 
L51:    aload_2 
L52:    monitorexit 
L53:    aload_3 
L54:    athrow 
L55:    iconst_0 
L56:    areturn 
L57:    nop 
L58:    nop 
L59:    nop 
L60:    
    .end code 
.end method 

.method public abstract [103] : [104] 
    .attribute [92] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method public abstract [105] : [106] 
    .attribute [92] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method public synchronized [107] : [108] 
    .attribute [92] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokevirtual [12] 
L4:     ifeq L14 
L7:     aload_0 
L8:     getfield [11] 
L11:    goto L15 
L14:    iconst_0 
L15:    areturn 
L16:    
    .end code 
.end method 

.method public synchronized [109] : [110] 
    .attribute [92] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [11] 
L4:     ifle L21 
L7:     invokestatic [4] 
L10:    aload_0 
L11:    getfield [10] 
L14:    if_acmpne L21 
L17:    iconst_1 
L18:    goto L22 
L21:    iconst_0 
L22:    areturn 
L23:    nop 
L24:    
    .end code 
.end method 

.method public synchronized [111] : [112] 
    .attribute [92] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [10] 
L4:     ifnull L11 
L7:     iconst_1 
L8:     goto L12 
L11:    iconst_0 
L12:    areturn 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public abstract [113] : [114] 
    .attribute [92] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method protected synchronized [115] : [116] 
    .attribute [92] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [10] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [117] : [118] 
    .attribute [92] .code stack 3 locals 0 
L0:     new [20] 
L3:     dup 
L4:     ldc [6] 
L6:     invokespecial [16] 
L9:     athrow 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [119] : [120] 
    .attribute [92] .code stack 3 locals 0 
L0:     new [20] 
L3:     dup 
L4:     ldc [6] 
L6:     invokespecial [16] 
L9:     athrow 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [121] : [122] 
    .attribute [92] .code stack 3 locals 0 
L0:     new [20] 
L3:     dup 
L4:     ldc [6] 
L6:     invokespecial [16] 
L9:     athrow 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [123] : [124] 
    .attribute [92] .code stack 3 locals 0 
L0:     new [20] 
L3:     dup 
L4:     ldc [6] 
L6:     invokespecial [16] 
L9:     athrow 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [21] 
.const [3] = String [22] 
.const [4] = Method [23] [24] 
.const [5] = Class [25] 
.const [6] = String [26] 
.const [7] = Class [27] 
.const [8] = Class [28] 
.const [9] = Class [29] 
.const [10] = Field [30] [31] 
.const [11] = Field [32] [33] 
.const [12] = Method [34] [35] 
.const [13] = Method [36] [37] 
.const [14] = Method [38] [39] 
.const [15] = Method [40] [41] 
.const [16] = Method [42] [43] 
.const [17] = Field [44] [45] 
.const [18] = Field [46] [47] 
.const [19] = Class [48] 
.const [20] = Class [49] 
.const [21] = Utf8 java/lang/Error 
.const [22] = Utf8 'Maximum lock count exceeded' 
.const [23] = Class [50] 
.const [24] = NameAndType [51] [52] 
.const [25] = Utf8 java/lang/UnsupportedOperationException 
.const [26] = Utf8 'Use FAIR version' 
.const [27] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/locks/ReentrantLock$Sync 
.const [28] = Utf8 java/lang/Object 
.const [29] = Utf8 java/lang/Thread 
.const [30] = Class [53] 
.const [31] = NameAndType [54] [55] 
.const [32] = Class [56] 
.const [33] = NameAndType [57] [58] 
.const [34] = Class [59] 
.const [35] = NameAndType [60] [61] 
.const [36] = Class [62] 
.const [37] = NameAndType [63] [64] 
.const [38] = Class [65] 
.const [39] = NameAndType [66] [67] 
.const [40] = Class [68] 
.const [41] = NameAndType [69] [70] 
.const [42] = Class [71] 
.const [43] = NameAndType [72] [73] 
.const [44] = Class [74] 
.const [45] = NameAndType [75] [76] 
.const [46] = Class [77] 
.const [47] = NameAndType [78] [79] 
.const [48] = Utf8 java/lang/Error 
.const [49] = Utf8 java/lang/UnsupportedOperationException 
.const [50] = Utf8 java/lang/Thread 
.const [51] = Utf8 currentThread 
.const [52] = Utf8 ()Ljava/lang/Thread; 
.const [53] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/locks/ReentrantLock$Sync 
.const [54] = Utf8 owner_ 
.const [55] = Utf8 Ljava/lang/Thread; 
.const [56] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/locks/ReentrantLock$Sync 
.const [57] = Utf8 holds_ 
.const [58] = Utf8 I 
.const [59] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/locks/ReentrantLock$Sync 
.const [60] = Utf8 isHeldByCurrentThread 
.const [61] = Utf8 ()Z 
.const [62] = Utf8 java/lang/Object 
.const [63] = Utf8 <init> 
.const [64] = Utf8 ()V 
.const [65] = Utf8 java/lang/Error 
.const [66] = Utf8 <init> 
.const [67] = Utf8 (Ljava/lang/String;)V 
.const [68] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/locks/ReentrantLock$Sync 
.const [69] = Utf8 incHolds 
.const [70] = Utf8 ()V 
.const [71] = Utf8 java/lang/UnsupportedOperationException 
.const [72] = Utf8 <init> 
.const [73] = Utf8 (Ljava/lang/String;)V 
.const [74] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/locks/ReentrantLock$Sync 
.const [75] = Utf8 owner_ 
.const [76] = Utf8 Ljava/lang/Thread; 
.const [77] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/locks/ReentrantLock$Sync 
.const [78] = Utf8 holds_ 
.const [79] = Utf8 I 
.const [80] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/locks/ReentrantLock$Sync 
.const [81] = Class [80] 
.const [82] = Utf8 java/lang/Object 
.const [83] = Class [82] 
.const [84] = Utf8 java/io/Serializable 
.const [85] = Class [84] 
.const [86] = Utf8 serialVersionUID 
.const [87] = Utf8 J 
.const [88] = Utf8 owner_ 
.const [89] = Utf8 Ljava/lang/Thread; 
.const [90] = Utf8 holds_ 
.const [91] = Utf8 I 
.const [92] = Utf8 Code 
.const [93] = Utf8 <init> 
.const [94] = Utf8 ()V 
.const [95] = Utf8 lock 
.const [96] = Utf8 ()V 
.const [97] = Utf8 lockInterruptibly 
.const [98] = Utf8 ()V 
.const [99] = Utf8 incHolds 
.const [100] = Utf8 ()V 
.const [101] = Utf8 tryLock 
.const [102] = Utf8 ()Z 
.const [103] = Utf8 tryLock 
.const [104] = Utf8 (J)Z 
.const [105] = Utf8 unlock 
.const [106] = Utf8 ()V 
.const [107] = Utf8 getHoldCount 
.const [108] = Utf8 ()I 
.const [109] = Utf8 isHeldByCurrentThread 
.const [110] = Utf8 ()Z 
.const [111] = Utf8 isLocked 
.const [112] = Utf8 ()Z 
.const [113] = Utf8 isFair 
.const [114] = Utf8 ()Z 
.const [115] = Utf8 getOwner 
.const [116] = Utf8 ()Ljava/lang/Thread; 
.const [117] = Utf8 hasQueuedThreads 
.const [118] = Utf8 ()Z 
.const [119] = Utf8 getQueueLength 
.const [120] = Utf8 ()I 
.const [121] = Utf8 getQueuedThreads 
.const [122] = Utf8 ()Ljava/util/Collection; 
.const [123] = Utf8 isQueued 
.const [124] = Utf8 (Ljava/lang/Thread;)Z 
.end class 
