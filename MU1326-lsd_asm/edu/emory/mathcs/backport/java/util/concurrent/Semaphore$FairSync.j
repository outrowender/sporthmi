.version 50 0 
.class final super [177] 
.super [179] 
.implements [181] 
.field private static final [182] [183] 
.field private transient [184] [185] 

.method [187] : [188] 
    .attribute [186] .code stack 3 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     invokespecial [30] 
L5:     aload_0 
L6:     new [35] 
L9:     dup 
L10:    invokespecial [31] 
L13:    putfield [36] 
L16:    return 
L17:    nop 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [189] : [190] 
    .attribute [186] .code stack 3 locals 1 
L0:     aload_0 
L1:     iload_1 
L2:     invokevirtual [15] 
L5:     ifeq L9 
L8:     return 
L9:     new [37] 
L12:    dup 
L13:    iload_1 
L14:    invokespecial [32] 
L17:    astore_2 
L18:    aload_2 
L19:    aload_0 
L20:    invokevirtual [16] 
L23:    return 
L24:    
    .end code 
.end method 

.method public [191] : [192] 
    .attribute [186] .code stack 3 locals 1 
L0:     invokestatic [4] 
L3:     ifeq L14 
L6:     new [38] 
L9:     dup 
L10:    invokespecial [33] 
L13:    athrow 
L14:    aload_0 
L15:    iload_1 
L16:    invokevirtual [15] 
L19:    ifeq L23 
L22:    return 
L23:    new [37] 
L26:    dup 
L27:    iload_1 
L28:    invokespecial [32] 
L31:    astore_2 
L32:    aload_2 
L33:    aload_0 
L34:    invokevirtual [17] 
L37:    return 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 

.method public [193] : [194] 
    .attribute [186] .code stack 4 locals 1 
L0:     invokestatic [4] 
L3:     ifeq L14 
L6:     new [38] 
L9:     dup 
L10:    invokespecial [33] 
L13:    athrow 
L14:    aload_0 
L15:    iload_1 
L16:    invokevirtual [15] 
L19:    ifeq L24 
L22:    iconst_1 
L23:    areturn 
L24:    lload_2 
L25:    lconst_0 
L26:    lcmp 
L27:    ifgt L32 
L30:    iconst_0 
L31:    areturn 
L32:    new [37] 
L35:    dup 
L36:    iload_1 
L37:    invokespecial [32] 
L40:    astore 4 
L42:    aload 4 
L44:    aload_0 
L45:    lload_2 
L46:    invokevirtual [18] 
L49:    areturn 
L50:    nop 
L51:    nop 
L52:    
    .end code 
.end method 

.method protected synchronized [195] : [196] 
    .attribute [186] .code stack 3 locals 1 
L0:     aload_0 
L1:     getfield [19] 
L4:     iload_1 
L5:     if_icmplt L12 
L8:     iconst_1 
L9:     goto L13 
L12:    iconst_0 
L13:    istore_2 
L14:    iload_2 
L15:    ifeq L28 
L18:    aload_0 
L19:    dup 
L20:    getfield [19] 
L23:    iload_1 
L24:    isub 
L25:    putfield [39] 
L28:    iload_2 
L29:    areturn 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method public synchronized [197] : [198] 
    .attribute [186] .code stack 3 locals 2 
L0:     aload_1 
L1:     checkcast [3] 
L4:     astore_2 
L5:     aload_0 
L6:     getfield [19] 
L9:     aload_2 
L10:    getfield [20] 
L13:    if_icmplt L20 
L16:    iconst_1 
L17:    goto L21 
L20:    iconst_0 
L21:    istore_3 
L22:    iload_3 
L23:    ifeq L42 
L26:    aload_0 
L27:    dup 
L28:    getfield [19] 
L31:    aload_2 
L32:    getfield [20] 
L35:    isub 
L36:    putfield [39] 
L39:    goto L50 
L42:    aload_0 
L43:    getfield [14] 
L46:    aload_1 
L47:    invokevirtual [21] 
L50:    iload_3 
L51:    areturn 
L52:    
    .end code 
.end method 

.method public enum [199] : [200] 
    .attribute [186] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method protected synchronized [201] : [202] 
    .attribute [186] .code stack 3 locals 1 
L0:     aload_0 
L1:     getfield [14] 
L4:     invokevirtual [22] 
L7:     checkcast [3] 
L10:    astore_2 
L11:    aload_0 
L12:    dup 
L13:    getfield [19] 
L16:    iload_1 
L17:    iadd 
L18:    putfield [39] 
L21:    aload_2 
L22:    ifnonnull L27 
L25:    aconst_null 
L26:    areturn 
L27:    aload_2 
L28:    getfield [20] 
L31:    aload_0 
L32:    getfield [19] 
L35:    if_icmple L48 
L38:    aload_0 
L39:    getfield [14] 
L42:    aload_2 
L43:    invokevirtual [23] 
L46:    aconst_null 
L47:    areturn 
L48:    aload_0 
L49:    dup 
L50:    getfield [19] 
L53:    aload_2 
L54:    getfield [20] 
L57:    isub 
L58:    putfield [39] 
L61:    aload_2 
L62:    areturn 
L63:    nop 
L64:    
    .end code 
.end method 

.method public [203] : [204] 
    .attribute [186] .code stack 3 locals 1 
L0:     iload_1 
L1:     ifge L14 
L4:     new [40] 
L7:     dup 
L8:     ldc [7] 
L10:    invokespecial [34] 
L13:    athrow 
L14:    aload_0 
L15:    iload_1 
L16:    invokevirtual [24] 
L19:    astore_2 
L20:    aload_2 
L21:    ifnonnull L25 
L24:    return 
L25:    aload_2 
L26:    aload_0 
L27:    invokevirtual [25] 
L30:    ifeq L34 
L33:    return 
L34:    aload_2 
L35:    getfield [20] 
L38:    istore_1 
L39:    goto L14 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 

.method public synchronized [205] : [206] 
    .attribute [186] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [14] 
L4:     invokevirtual [26] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public synchronized [207] : [208] 
    .attribute [186] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [14] 
L4:     invokevirtual [27] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public synchronized [209] : [210] 
    .attribute [186] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [14] 
L4:     invokevirtual [28] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method private [211] : [212] 
    .attribute [186] .code stack 3 locals 2 
L0:     aload_1 
L1:     invokevirtual [29] 
L4:     aload_0 
L5:     dup 
L6:     astore_2 
L7:     monitorenter 
        .catch [0] from L8 to L21 using L24 
L8:     aload_0 
L9:     new [35] 
L12:    dup 
L13:    invokespecial [31] 
L16:    putfield [36] 
L19:    aload_2 
L20:    monitorexit 
L21:    goto L29 
        .catch [0] from L24 to L27 using L24 
L24:    astore_3 
L25:    aload_2 
L26:    monitorexit 
L27:    aload_3 
L28:    athrow 
L29:    return 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [41] 
.const [3] = Class [42] 
.const [4] = Method [43] [44] 
.const [5] = Class [45] 
.const [6] = Class [46] 
.const [7] = String [47] 
.const [8] = Class [48] 
.const [9] = Class [49] 
.const [10] = Class [50] 
.const [11] = Class [51] 
.const [12] = Class [52] 
.const [13] = Class [53] 
.const [14] = Field [54] [55] 
.const [15] = Method [56] [57] 
.const [16] = Method [58] [59] 
.const [17] = Method [60] [61] 
.const [18] = Method [62] [63] 
.const [19] = Field [64] [65] 
.const [20] = Field [66] [67] 
.const [21] = Method [68] [69] 
.const [22] = Method [70] [71] 
.const [23] = Method [72] [73] 
.const [24] = Method [74] [75] 
.const [25] = Method [76] [77] 
.const [26] = Method [78] [79] 
.const [27] = Method [80] [81] 
.const [28] = Method [82] [83] 
.const [29] = Method [84] [85] 
.const [30] = Method [86] [87] 
.const [31] = Method [88] [89] 
.const [32] = Method [90] [91] 
.const [33] = Method [92] [93] 
.const [34] = Method [94] [95] 
.const [35] = Class [96] 
.const [36] = Field [97] [98] 
.const [37] = Class [99] 
.const [38] = Class [100] 
.const [39] = Field [101] [102] 
.const [40] = Class [103] 
.const [41] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/helpers/FIFOWaitQueue 
.const [42] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/Semaphore$FairSync$Node 
.const [43] = Class [104] 
.const [44] = NameAndType [105] [106] 
.const [45] = Utf8 java/lang/InterruptedException 
.const [46] = Utf8 java/lang/IllegalArgumentException 
.const [47] = Utf8 'Negative argument' 
.const [48] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/Semaphore$FairSync 
.const [49] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/Semaphore$Sync 
.const [50] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/helpers/WaitQueue$WaitNode 
.const [51] = Utf8 java/lang/Thread 
.const [52] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/helpers/WaitQueue 
.const [53] = Utf8 java/io/ObjectInputStream 
.const [54] = Class [107] 
.const [55] = NameAndType [108] [109] 
.const [56] = Class [110] 
.const [57] = NameAndType [111] [112] 
.const [58] = Class [113] 
.const [59] = NameAndType [114] [115] 
.const [60] = Class [116] 
.const [61] = NameAndType [117] [118] 
.const [62] = Class [119] 
.const [63] = NameAndType [120] [121] 
.const [64] = Class [122] 
.const [65] = NameAndType [123] [124] 
.const [66] = Class [125] 
.const [67] = NameAndType [126] [127] 
.const [68] = Class [128] 
.const [69] = NameAndType [129] [130] 
.const [70] = Class [131] 
.const [71] = NameAndType [132] [133] 
.const [72] = Class [134] 
.const [73] = NameAndType [135] [136] 
.const [74] = Class [137] 
.const [75] = NameAndType [138] [139] 
.const [76] = Class [140] 
.const [77] = NameAndType [141] [142] 
.const [78] = Class [143] 
.const [79] = NameAndType [144] [145] 
.const [80] = Class [146] 
.const [81] = NameAndType [147] [148] 
.const [82] = Class [149] 
.const [83] = NameAndType [150] [151] 
.const [84] = Class [152] 
.const [85] = NameAndType [153] [154] 
.const [86] = Class [155] 
.const [87] = NameAndType [156] [157] 
.const [88] = Class [158] 
.const [89] = NameAndType [159] [160] 
.const [90] = Class [161] 
.const [91] = NameAndType [162] [163] 
.const [92] = Class [164] 
.const [93] = NameAndType [165] [166] 
.const [94] = Class [167] 
.const [95] = NameAndType [168] [169] 
.const [96] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/helpers/FIFOWaitQueue 
.const [97] = Class [170] 
.const [98] = NameAndType [171] [172] 
.const [99] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/Semaphore$FairSync$Node 
.const [100] = Utf8 java/lang/InterruptedException 
.const [101] = Class [173] 
.const [102] = NameAndType [174] [175] 
.const [103] = Utf8 java/lang/IllegalArgumentException 
.const [104] = Utf8 java/lang/Thread 
.const [105] = Utf8 interrupted 
.const [106] = Utf8 ()Z 
.const [107] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/Semaphore$FairSync 
.const [108] = Utf8 wq_ 
.const [109] = Utf8 Ledu/emory/mathcs/backport/java/util/concurrent/helpers/WaitQueue; 
.const [110] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/Semaphore$FairSync 
.const [111] = Utf8 precheck 
.const [112] = Utf8 (I)Z 
.const [113] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/helpers/WaitQueue$WaitNode 
.const [114] = Utf8 doWaitUninterruptibly 
.const [115] = Utf8 (Ledu/emory/mathcs/backport/java/util/concurrent/helpers/WaitQueue$QueuedSync;)V 
.const [116] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/helpers/WaitQueue$WaitNode 
.const [117] = Utf8 doWait 
.const [118] = Utf8 (Ledu/emory/mathcs/backport/java/util/concurrent/helpers/WaitQueue$QueuedSync;)V 
.const [119] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/helpers/WaitQueue$WaitNode 
.const [120] = Utf8 doTimedWait 
.const [121] = Utf8 (Ledu/emory/mathcs/backport/java/util/concurrent/helpers/WaitQueue$QueuedSync;J)Z 
.const [122] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/Semaphore$FairSync 
.const [123] = Utf8 permits_ 
.const [124] = Utf8 I 
.const [125] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/Semaphore$FairSync$Node 
.const [126] = Utf8 requests 
.const [127] = Utf8 I 
.const [128] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/helpers/WaitQueue 
.const [129] = Utf8 insert 
.const [130] = Utf8 (Ledu/emory/mathcs/backport/java/util/concurrent/helpers/WaitQueue$WaitNode;)V 
.const [131] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/helpers/WaitQueue 
.const [132] = Utf8 extract 
.const [133] = Utf8 ()Ledu/emory/mathcs/backport/java/util/concurrent/helpers/WaitQueue$WaitNode; 
.const [134] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/helpers/WaitQueue 
.const [135] = Utf8 putBack 
.const [136] = Utf8 (Ledu/emory/mathcs/backport/java/util/concurrent/helpers/WaitQueue$WaitNode;)V 
.const [137] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/Semaphore$FairSync 
.const [138] = Utf8 getSignallee 
.const [139] = Utf8 (I)Ledu/emory/mathcs/backport/java/util/concurrent/Semaphore$FairSync$Node; 
.const [140] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/Semaphore$FairSync$Node 
.const [141] = Utf8 signal 
.const [142] = Utf8 (Ledu/emory/mathcs/backport/java/util/concurrent/helpers/WaitQueue$QueuedSync;)Z 
.const [143] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/helpers/WaitQueue 
.const [144] = Utf8 hasNodes 
.const [145] = Utf8 ()Z 
.const [146] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/helpers/WaitQueue 
.const [147] = Utf8 getLength 
.const [148] = Utf8 ()I 
.const [149] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/helpers/WaitQueue 
.const [150] = Utf8 getWaitingThreads 
.const [151] = Utf8 ()Ljava/util/Collection; 
.const [152] = Utf8 java/io/ObjectInputStream 
.const [153] = Utf8 defaultReadObject 
.const [154] = Utf8 ()V 
.const [155] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/Semaphore$Sync 
.const [156] = Utf8 <init> 
.const [157] = Utf8 (I)V 
.const [158] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/helpers/FIFOWaitQueue 
.const [159] = Utf8 <init> 
.const [160] = Utf8 ()V 
.const [161] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/Semaphore$FairSync$Node 
.const [162] = Utf8 <init> 
.const [163] = Utf8 (I)V 
.const [164] = Utf8 java/lang/InterruptedException 
.const [165] = Utf8 <init> 
.const [166] = Utf8 ()V 
.const [167] = Utf8 java/lang/IllegalArgumentException 
.const [168] = Utf8 <init> 
.const [169] = Utf8 (Ljava/lang/String;)V 
.const [170] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/Semaphore$FairSync 
.const [171] = Utf8 wq_ 
.const [172] = Utf8 Ledu/emory/mathcs/backport/java/util/concurrent/helpers/WaitQueue; 
.const [173] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/Semaphore$FairSync 
.const [174] = Utf8 permits_ 
.const [175] = Utf8 I 
.const [176] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/Semaphore$FairSync 
.const [177] = Class [176] 
.const [178] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/Semaphore$Sync 
.const [179] = Class [178] 
.const [180] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/helpers/WaitQueue$QueuedSync 
.const [181] = Class [180] 
.const [182] = Utf8 serialVersionUID 
.const [183] = Utf8 J 
.const [184] = Utf8 wq_ 
.const [185] = Utf8 Ledu/emory/mathcs/backport/java/util/concurrent/helpers/WaitQueue; 
.const [186] = Utf8 Code 
.const [187] = Utf8 <init> 
.const [188] = Utf8 (I)V 
.const [189] = Utf8 acquireUninterruptibly 
.const [190] = Utf8 (I)V 
.const [191] = Utf8 acquire 
.const [192] = Utf8 (I)V 
.const [193] = Utf8 attempt 
.const [194] = Utf8 (IJ)Z 
.const [195] = Utf8 precheck 
.const [196] = Utf8 (I)Z 
.const [197] = Utf8 recheck 
.const [198] = Utf8 (Ledu/emory/mathcs/backport/java/util/concurrent/helpers/WaitQueue$WaitNode;)Z 
.const [199] = Utf8 takeOver 
.const [200] = Utf8 (Ledu/emory/mathcs/backport/java/util/concurrent/helpers/WaitQueue$WaitNode;)V 
.const [201] = Utf8 getSignallee 
.const [202] = Utf8 (I)Ledu/emory/mathcs/backport/java/util/concurrent/Semaphore$FairSync$Node; 
.const [203] = Utf8 release 
.const [204] = Utf8 (I)V 
.const [205] = Utf8 hasQueuedThreads 
.const [206] = Utf8 ()Z 
.const [207] = Utf8 getQueueLength 
.const [208] = Utf8 ()I 
.const [209] = Utf8 getQueuedThreads 
.const [210] = Utf8 ()Ljava/util/Collection; 
.const [211] = Utf8 readObject 
.const [212] = Utf8 (Ljava/io/ObjectInputStream;)V 
.end class 
