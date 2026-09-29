.version 50 0 
.class final super [123] 
.super [125] 
.field private static final [126] [127] 

.method protected annotation [129] : [130] 
    .attribute [128] .code stack 2 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     invokespecial [22] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method private static [131] : [132] 
    .attribute [128] .code stack 3 locals 0 
L0:     iload_0 
L1:     iconst_1 
L2:     if_icmpeq L15 
L5:     new [28] 
L8:     dup 
L9:     ldc [3] 
L11:    invokespecial [23] 
L14:    athrow 
L15:    return 
L16:    
    .end code 
.end method 

.method public [133] : [134] 
    .attribute [128] .code stack 3 locals 5 
L0:     iload_1 
L1:     ifne L5 
L4:     return 
L5:     iload_1 
L6:     invokestatic [4] 
L9:     aload_0 
L10:    dup 
L11:    astore_2 
L12:    monitorenter 
L13:    aload_0 
L14:    getfield [19] 
L17:    ifle L33 
L20:    aload_0 
L21:    dup 
L22:    getfield [19] 
L25:    iconst_1 
L26:    isub 
L27:    putfield [29] 
L30:    aload_2 
L31:    monitorexit 
L32:    return 
L33:    invokestatic [5] 
L36:    istore_3 
        .catch [6] from L37 to L41 using L44 
        .catch [0] from L37 to L65 using L78 
L37:    aload_0 
L38:    invokespecial [24] 
L41:    goto L48 
L44:    astore 4 
L46:    iconst_1 
L47:    istore_3 
L48:    aload_0 
L49:    getfield [19] 
L52:    ifle L37 
L55:    aload_0 
L56:    dup 
L57:    getfield [19] 
L60:    iconst_1 
L61:    isub 
L62:    putfield [29] 
L65:    iload_3 
L66:    ifeq L75 
L69:    invokestatic [7] 
L72:    invokevirtual [20] 
L75:    aload_2 
L76:    monitorexit 
L77:    return 
        .catch [0] from L78 to L80 using L78 
        .catch [0] from L13 to L32 using L93 
        .catch [0] from L33 to L77 using L93 
        .catch [0] from L78 to L97 using L93 
L78:    astore 5 
L80:    iload_3 
L81:    ifeq L90 
L84:    invokestatic [7] 
L87:    invokevirtual [20] 
L90:    aload 5 
L92:    athrow 
L93:    astore 6 
L95:    aload_2 
L96:    monitorexit 
L97:    aload 6 
L99:    athrow 
L100:   
    .end code 
.end method 

.method public [135] : [136] 
    .attribute [128] .code stack 3 locals 3 
L0:     invokestatic [5] 
L3:     ifeq L14 
L6:     new [30] 
L9:     dup 
L10:    invokespecial [25] 
L13:    athrow 
L14:    iload_1 
L15:    ifne L19 
L18:    return 
L19:    iload_1 
L20:    invokestatic [4] 
L23:    aload_0 
L24:    dup 
L25:    astore_2 
L26:    monitorenter 
L27:    aload_0 
L28:    getfield [19] 
L31:    ifgt L48 
        .catch [6] from L34 to L38 using L41 
        .catch [0] from L27 to L60 using L63 
L34:    aload_0 
L35:    invokespecial [24] 
L38:    goto L27 
L41:    astore_3 
L42:    aload_0 
L43:    invokespecial [26] 
L46:    aload_3 
L47:    athrow 
L48:    aload_0 
L49:    dup 
L50:    getfield [19] 
L53:    iconst_1 
L54:    isub 
L55:    putfield [29] 
L58:    aload_2 
L59:    monitorexit 
L60:    goto L70 
        .catch [0] from L63 to L67 using L63 
L63:    astore 4 
L65:    aload_2 
L66:    monitorexit 
L67:    aload 4 
L69:    athrow 
L70:    return 
L71:    nop 
L72:    
    .end code 
.end method 

.method public [137] : [138] 
    .attribute [128] .code stack 4 locals 4 
L0:     invokestatic [5] 
L3:     ifeq L14 
L6:     new [30] 
L9:     dup 
L10:    invokespecial [25] 
L13:    athrow 
L14:    iload_1 
L15:    ifne L20 
L18:    iconst_1 
L19:    areturn 
L20:    iload_1 
L21:    invokestatic [4] 
L24:    aload_0 
L25:    dup 
L26:    astore 4 
L28:    monitorenter 
L29:    aload_0 
L30:    getfield [19] 
L33:    ifle L51 
L36:    aload_0 
L37:    dup 
L38:    getfield [19] 
L41:    iconst_1 
L42:    isub 
L43:    putfield [29] 
L46:    iconst_1 
L47:    aload 4 
L49:    monitorexit 
L50:    areturn 
L51:    lload_2 
L52:    lconst_0 
L53:    lcmp 
L54:    ifgt L62 
L57:    iconst_0 
L58:    aload 4 
L60:    monitorexit 
L61:    areturn 
        .catch [6] from L62 to L95 using L117 
L62:    invokestatic [8] 
L65:    lload_2 
L66:    ladd 
L67:    lstore 5 
L69:    getstatic [9] 
L72:    aload_0 
L73:    lload_2 
L74:    invokevirtual [21] 
L77:    aload_0 
L78:    getfield [19] 
L81:    ifle L99 
L84:    aload_0 
L85:    dup 
L86:    getfield [19] 
L89:    iconst_1 
L90:    isub 
L91:    putfield [29] 
L94:    iconst_1 
L95:    aload 4 
L97:    monitorexit 
L98:    areturn 
        .catch [6] from L99 to L113 using L117 
        .catch [0] from L29 to L50 using L126 
        .catch [0] from L51 to L61 using L126 
        .catch [0] from L62 to L98 using L126 
        .catch [0] from L99 to L116 using L126 
L99:    lload 5 
L101:   invokestatic [8] 
L104:   lsub 
L105:   lstore_2 
L106:   lload_2 
L107:   lconst_0 
L108:   lcmp 
L109:   ifgt L69 
L112:   iconst_0 
L113:   aload 4 
L115:   monitorexit 
L116:   areturn 
        .catch [0] from L117 to L131 using L126 
L117:   astore 5 
L119:   aload_0 
L120:   invokespecial [26] 
L123:   aload 5 
L125:   athrow 
L126:   astore 7 
L128:   aload 4 
L130:   monitorexit 
L131:   aload 7 
L133:   athrow 
L134:   nop 
L135:   nop 
L136:   
    .end code 
.end method 

.method public synchronized [139] : [140] 
    .attribute [128] .code stack 3 locals 1 
L0:     iload_1 
L1:     ifge L14 
L4:     new [31] 
L7:     dup 
L8:     ldc [11] 
L10:    invokespecial [27] 
L13:    athrow 
L14:    aload_0 
L15:    dup 
L16:    getfield [19] 
L19:    iload_1 
L20:    iadd 
L21:    putfield [29] 
L24:    iconst_0 
L25:    istore_2 
L26:    iload_2 
L27:    iload_1 
L28:    if_icmpge L41 
L31:    aload_0 
L32:    invokespecial [26] 
L35:    iinc 2 1 
L38:    goto L26 
L41:    return 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 

.method public [141] : [142] 
    .attribute [128] .code stack 3 locals 0 
L0:     new [28] 
L3:     dup 
L4:     ldc [12] 
L6:     invokespecial [23] 
L9:     athrow 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [143] : [144] 
    .attribute [128] .code stack 3 locals 0 
L0:     new [28] 
L3:     dup 
L4:     ldc [12] 
L6:     invokespecial [23] 
L9:     athrow 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [145] : [146] 
    .attribute [128] .code stack 3 locals 0 
L0:     new [28] 
L3:     dup 
L4:     ldc [12] 
L6:     invokespecial [23] 
L9:     athrow 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [32] 
.const [3] = String [33] 
.const [4] = Method [34] [35] 
.const [5] = Method [36] [37] 
.const [6] = Class [38] 
.const [7] = Method [39] [40] 
.const [8] = Method [41] [42] 
.const [9] = Field [43] [44] 
.const [10] = Class [45] 
.const [11] = String [46] 
.const [12] = String [47] 
.const [13] = Class [48] 
.const [14] = Class [49] 
.const [15] = Class [50] 
.const [16] = Class [51] 
.const [17] = Class [52] 
.const [18] = Class [53] 
.const [19] = Field [54] [55] 
.const [20] = Method [56] [57] 
.const [21] = Method [58] [59] 
.const [22] = Method [60] [61] 
.const [23] = Method [62] [63] 
.const [24] = Method [64] [65] 
.const [25] = Method [66] [67] 
.const [26] = Method [68] [69] 
.const [27] = Method [70] [71] 
.const [28] = Class [72] 
.const [29] = Field [73] [74] 
.const [30] = Class [75] 
.const [31] = Class [76] 
.const [32] = Utf8 java/lang/UnsupportedOperationException 
.const [33] = Utf8 'Atomic multi-acquire supported only in FAIR semaphores' 
.const [34] = Class [77] 
.const [35] = NameAndType [78] [79] 
.const [36] = Class [80] 
.const [37] = NameAndType [81] [82] 
.const [38] = Utf8 java/lang/InterruptedException 
.const [39] = Class [83] 
.const [40] = NameAndType [84] [85] 
.const [41] = Class [86] 
.const [42] = NameAndType [87] [88] 
.const [43] = Class [89] 
.const [44] = NameAndType [90] [91] 
.const [45] = Utf8 java/lang/IllegalArgumentException 
.const [46] = Utf8 'Negative argument' 
.const [47] = Utf8 'Use FAIR version' 
.const [48] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/Semaphore$NonfairSync 
.const [49] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/Semaphore$Sync 
.const [50] = Utf8 java/lang/Thread 
.const [51] = Utf8 java/lang/Object 
.const [52] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/helpers/Utils 
.const [53] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/TimeUnit 
.const [54] = Class [92] 
.const [55] = NameAndType [93] [94] 
.const [56] = Class [95] 
.const [57] = NameAndType [96] [97] 
.const [58] = Class [98] 
.const [59] = NameAndType [99] [100] 
.const [60] = Class [101] 
.const [61] = NameAndType [102] [103] 
.const [62] = Class [104] 
.const [63] = NameAndType [105] [106] 
.const [64] = Class [107] 
.const [65] = NameAndType [108] [109] 
.const [66] = Class [110] 
.const [67] = NameAndType [111] [112] 
.const [68] = Class [113] 
.const [69] = NameAndType [114] [115] 
.const [70] = Class [116] 
.const [71] = NameAndType [117] [118] 
.const [72] = Utf8 java/lang/UnsupportedOperationException 
.const [73] = Class [119] 
.const [74] = NameAndType [120] [121] 
.const [75] = Utf8 java/lang/InterruptedException 
.const [76] = Utf8 java/lang/IllegalArgumentException 
.const [77] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/Semaphore$NonfairSync 
.const [78] = Utf8 checkAgainstMultiacquire 
.const [79] = Utf8 (I)V 
.const [80] = Utf8 java/lang/Thread 
.const [81] = Utf8 interrupted 
.const [82] = Utf8 ()Z 
.const [83] = Utf8 java/lang/Thread 
.const [84] = Utf8 currentThread 
.const [85] = Utf8 ()Ljava/lang/Thread; 
.const [86] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/helpers/Utils 
.const [87] = Utf8 nanoTime 
.const [88] = Utf8 ()J 
.const [89] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/TimeUnit 
.const [90] = Utf8 NANOSECONDS 
.const [91] = Utf8 Ledu/emory/mathcs/backport/java/util/concurrent/TimeUnit; 
.const [92] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/Semaphore$NonfairSync 
.const [93] = Utf8 permits_ 
.const [94] = Utf8 I 
.const [95] = Utf8 java/lang/Thread 
.const [96] = Utf8 interrupt 
.const [97] = Utf8 ()V 
.const [98] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/TimeUnit 
.const [99] = Utf8 timedWait 
.const [100] = Utf8 (Ljava/lang/Object;J)V 
.const [101] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/Semaphore$Sync 
.const [102] = Utf8 <init> 
.const [103] = Utf8 (I)V 
.const [104] = Utf8 java/lang/UnsupportedOperationException 
.const [105] = Utf8 <init> 
.const [106] = Utf8 (Ljava/lang/String;)V 
.const [107] = Utf8 java/lang/Object 
.const [108] = Utf8 wait 
.const [109] = Utf8 ()V 
.const [110] = Utf8 java/lang/InterruptedException 
.const [111] = Utf8 <init> 
.const [112] = Utf8 ()V 
.const [113] = Utf8 java/lang/Object 
.const [114] = Utf8 notify 
.const [115] = Utf8 ()V 
.const [116] = Utf8 java/lang/IllegalArgumentException 
.const [117] = Utf8 <init> 
.const [118] = Utf8 (Ljava/lang/String;)V 
.const [119] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/Semaphore$NonfairSync 
.const [120] = Utf8 permits_ 
.const [121] = Utf8 I 
.const [122] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/Semaphore$NonfairSync 
.const [123] = Class [122] 
.const [124] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/Semaphore$Sync 
.const [125] = Class [124] 
.const [126] = Utf8 serialVersionUID 
.const [127] = Utf8 J 
.const [128] = Utf8 Code 
.const [129] = Utf8 <init> 
.const [130] = Utf8 (I)V 
.const [131] = Utf8 checkAgainstMultiacquire 
.const [132] = Utf8 (I)V 
.const [133] = Utf8 acquireUninterruptibly 
.const [134] = Utf8 (I)V 
.const [135] = Utf8 acquire 
.const [136] = Utf8 (I)V 
.const [137] = Utf8 attempt 
.const [138] = Utf8 (IJ)Z 
.const [139] = Utf8 release 
.const [140] = Utf8 (I)V 
.const [141] = Utf8 hasQueuedThreads 
.const [142] = Utf8 ()Z 
.const [143] = Utf8 getQueueLength 
.const [144] = Utf8 ()I 
.const [145] = Utf8 getQueuedThreads 
.const [146] = Utf8 ()Ljava/util/Collection; 
.end class 
