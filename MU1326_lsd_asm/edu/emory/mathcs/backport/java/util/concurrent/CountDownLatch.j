.version 50 0 
.class public super [139] 
.super [141] 
.field private [142] [143] 

.method public [145] : [146] 
    .attribute [144] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [23] 
L4:     iload_1 
L5:     ifge L18 
L8:     new [30] 
L11:    dup 
L12:    ldc [3] 
L14:    invokespecial [24] 
L17:    athrow 
L18:    aload_0 
L19:    iload_1 
L20:    putfield [31] 
L23:    return 
L24:    
    .end code 
.end method 

.method public [147] : [148] 
    .attribute [144] .code stack 2 locals 2 
L0:     invokestatic [4] 
L3:     ifeq L14 
L6:     new [32] 
L9:     dup 
L10:    invokespecial [25] 
L13:    athrow 
L14:    aload_0 
L15:    dup 
L16:    astore_1 
L17:    monitorenter 
        .catch [0] from L18 to L34 using L37 
L18:    aload_0 
L19:    getfield [16] 
L22:    ifle L32 
L25:    aload_0 
L26:    invokespecial [26] 
L29:    goto L18 
L32:    aload_1 
L33:    monitorexit 
L34:    goto L42 
        .catch [0] from L37 to L40 using L37 
L37:    astore_2 
L38:    aload_1 
L39:    monitorexit 
L40:    aload_2 
L41:    athrow 
L42:    return 
L43:    nop 
L44:    
    .end code 
.end method 

.method public [149] : [150] 
    .attribute [144] .code stack 4 locals 6 
L0:     invokestatic [4] 
L3:     ifeq L14 
L6:     new [32] 
L9:     dup 
L10:    invokespecial [25] 
L13:    athrow 
L14:    aload_3 
L15:    lload_1 
L16:    invokevirtual [17] 
L19:    lstore 4 
L21:    aload_0 
L22:    dup 
L23:    astore 6 
L25:    monitorenter 
        .catch [0] from L26 to L37 using L99 
L26:    aload_0 
L27:    getfield [16] 
L30:    ifgt L38 
L33:    iconst_1 
L34:    aload 6 
L36:    monitorexit 
L37:    areturn 
        .catch [0] from L38 to L49 using L99 
L38:    lload 4 
L40:    lconst_0 
L41:    lcmp 
L42:    ifgt L50 
L45:    iconst_0 
L46:    aload 6 
L48:    monitorexit 
L49:    areturn 
        .catch [0] from L50 to L78 using L99 
L50:    invokestatic [6] 
L53:    lload 4 
L55:    ladd 
L56:    lstore 7 
L58:    getstatic [7] 
L61:    aload_0 
L62:    lload 4 
L64:    invokevirtual [18] 
L67:    aload_0 
L68:    getfield [16] 
L71:    ifgt L79 
L74:    iconst_1 
L75:    aload 6 
L77:    monitorexit 
L78:    areturn 
        .catch [0] from L79 to L98 using L99 
L79:    lload 7 
L81:    invokestatic [6] 
L84:    lsub 
L85:    lstore 4 
L87:    lload 4 
L89:    lconst_0 
L90:    lcmp 
L91:    ifgt L58 
L94:    iconst_0 
L95:    aload 6 
L97:    monitorexit 
L98:    areturn 
        .catch [0] from L99 to L104 using L99 
L99:    astore 9 
L101:   aload 6 
L103:   monitorexit 
L104:   aload 9 
L106:   athrow 
L107:   nop 
L108:   
    .end code 
.end method 

.method public synchronized [151] : [152] 
    .attribute [144] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [16] 
L4:     ifne L8 
L7:     return 
L8:     aload_0 
L9:     dup 
L10:    getfield [16] 
L13:    iconst_1 
L14:    isub 
L15:    dup_x1 
L16:    putfield [31] 
L19:    ifne L26 
L22:    aload_0 
L23:    invokespecial [27] 
L26:    return 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [153] : [154] 
    .attribute [144] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [16] 
L4:     i2l 
L5:     freturn 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [155] : [156] 
    .attribute [144] .code stack 3 locals 0 
L0:     new [33] 
L3:     dup 
L4:     invokespecial [28] 
L7:     aload_0 
L8:     invokespecial [29] 
L11:    invokevirtual [19] 
L14:    ldc [9] 
L16:    invokevirtual [19] 
L19:    aload_0 
L20:    invokevirtual [20] 
L23:    invokevirtual [21] 
L26:    ldc [10] 
L28:    invokevirtual [19] 
L31:    invokevirtual [22] 
L34:    areturn 
L35:    nop 
L36:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [34] 
.const [3] = String [35] 
.const [4] = Method [36] [37] 
.const [5] = Class [38] 
.const [6] = Method [39] [40] 
.const [7] = Field [41] [42] 
.const [8] = Class [43] 
.const [9] = String [44] 
.const [10] = String [45] 
.const [11] = Class [46] 
.const [12] = Class [47] 
.const [13] = Class [48] 
.const [14] = Class [49] 
.const [15] = Class [50] 
.const [16] = Field [51] [52] 
.const [17] = Method [53] [54] 
.const [18] = Method [55] [56] 
.const [19] = Method [57] [58] 
.const [20] = Method [59] [60] 
.const [21] = Method [61] [62] 
.const [22] = Method [63] [64] 
.const [23] = Method [65] [66] 
.const [24] = Method [67] [68] 
.const [25] = Method [69] [70] 
.const [26] = Method [71] [72] 
.const [27] = Method [73] [74] 
.const [28] = Method [75] [76] 
.const [29] = Method [77] [78] 
.const [30] = Class [79] 
.const [31] = Field [80] [81] 
.const [32] = Class [82] 
.const [33] = Class [83] 
.const [34] = Utf8 java/lang/IllegalArgumentException 
.const [35] = Utf8 'count < 0' 
.const [36] = Class [84] 
.const [37] = NameAndType [85] [86] 
.const [38] = Utf8 java/lang/InterruptedException 
.const [39] = Class [87] 
.const [40] = NameAndType [88] [89] 
.const [41] = Class [90] 
.const [42] = NameAndType [91] [92] 
.const [43] = Utf8 java/lang/StringBuffer 
.const [44] = Utf8 '[Count = ' 
.const [45] = Utf8 ']' 
.const [46] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/CountDownLatch 
.const [47] = Utf8 java/lang/Object 
.const [48] = Utf8 java/lang/Thread 
.const [49] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/TimeUnit 
.const [50] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/helpers/Utils 
.const [51] = Class [93] 
.const [52] = NameAndType [94] [95] 
.const [53] = Class [96] 
.const [54] = NameAndType [97] [98] 
.const [55] = Class [99] 
.const [56] = NameAndType [100] [101] 
.const [57] = Class [102] 
.const [58] = NameAndType [103] [104] 
.const [59] = Class [105] 
.const [60] = NameAndType [106] [107] 
.const [61] = Class [108] 
.const [62] = NameAndType [109] [110] 
.const [63] = Class [111] 
.const [64] = NameAndType [112] [113] 
.const [65] = Class [114] 
.const [66] = NameAndType [115] [116] 
.const [67] = Class [117] 
.const [68] = NameAndType [118] [119] 
.const [69] = Class [120] 
.const [70] = NameAndType [121] [122] 
.const [71] = Class [123] 
.const [72] = NameAndType [124] [125] 
.const [73] = Class [126] 
.const [74] = NameAndType [127] [128] 
.const [75] = Class [129] 
.const [76] = NameAndType [130] [131] 
.const [77] = Class [132] 
.const [78] = NameAndType [133] [134] 
.const [79] = Utf8 java/lang/IllegalArgumentException 
.const [80] = Class [135] 
.const [81] = NameAndType [136] [137] 
.const [82] = Utf8 java/lang/InterruptedException 
.const [83] = Utf8 java/lang/StringBuffer 
.const [84] = Utf8 java/lang/Thread 
.const [85] = Utf8 interrupted 
.const [86] = Utf8 ()Z 
.const [87] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/helpers/Utils 
.const [88] = Utf8 nanoTime 
.const [89] = Utf8 ()J 
.const [90] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/TimeUnit 
.const [91] = Utf8 NANOSECONDS 
.const [92] = Utf8 Ledu/emory/mathcs/backport/java/util/concurrent/TimeUnit; 
.const [93] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/CountDownLatch 
.const [94] = Utf8 count_ 
.const [95] = Utf8 I 
.const [96] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/TimeUnit 
.const [97] = Utf8 toNanos 
.const [98] = Utf8 (J)J 
.const [99] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/TimeUnit 
.const [100] = Utf8 timedWait 
.const [101] = Utf8 (Ljava/lang/Object;J)V 
.const [102] = Utf8 java/lang/StringBuffer 
.const [103] = Utf8 append 
.const [104] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [105] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/CountDownLatch 
.const [106] = Utf8 getCount 
.const [107] = Utf8 ()J 
.const [108] = Utf8 java/lang/StringBuffer 
.const [109] = Utf8 append 
.const [110] = Utf8 (J)Ljava/lang/StringBuffer; 
.const [111] = Utf8 java/lang/StringBuffer 
.const [112] = Utf8 toString 
.const [113] = Utf8 ()Ljava/lang/String; 
.const [114] = Utf8 java/lang/Object 
.const [115] = Utf8 <init> 
.const [116] = Utf8 ()V 
.const [117] = Utf8 java/lang/IllegalArgumentException 
.const [118] = Utf8 <init> 
.const [119] = Utf8 (Ljava/lang/String;)V 
.const [120] = Utf8 java/lang/InterruptedException 
.const [121] = Utf8 <init> 
.const [122] = Utf8 ()V 
.const [123] = Utf8 java/lang/Object 
.const [124] = Utf8 wait 
.const [125] = Utf8 ()V 
.const [126] = Utf8 java/lang/Object 
.const [127] = Utf8 notifyAll 
.const [128] = Utf8 ()V 
.const [129] = Utf8 java/lang/StringBuffer 
.const [130] = Utf8 <init> 
.const [131] = Utf8 ()V 
.const [132] = Utf8 java/lang/Object 
.const [133] = Utf8 toString 
.const [134] = Utf8 ()Ljava/lang/String; 
.const [135] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/CountDownLatch 
.const [136] = Utf8 count_ 
.const [137] = Utf8 I 
.const [138] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/CountDownLatch 
.const [139] = Class [138] 
.const [140] = Utf8 java/lang/Object 
.const [141] = Class [140] 
.const [142] = Utf8 count_ 
.const [143] = Utf8 I 
.const [144] = Utf8 Code 
.const [145] = Utf8 <init> 
.const [146] = Utf8 (I)V 
.const [147] = Utf8 await 
.const [148] = Utf8 ()V 
.const [149] = Utf8 await 
.const [150] = Utf8 (JLedu/emory/mathcs/backport/java/util/concurrent/TimeUnit;)Z 
.const [151] = Utf8 countDown 
.const [152] = Utf8 ()V 
.const [153] = Utf8 getCount 
.const [154] = Utf8 ()J 
.const [155] = Utf8 toString 
.const [156] = Utf8 ()Ljava/lang/String; 
.end class 
