.version 50 0 
.class public super [113] 
.super [115] 
.field [116] [117] 
.field [118] [119] 
.field final [120] [121] 

.method public [123] : [124] 
    .attribute [122] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [17] 
L4:     aload_0 
L5:     iconst_1 
L6:     putfield [20] 
L9:     aload_0 
L10:    aconst_null 
L11:    putfield [21] 
L14:    aload_0 
L15:    invokestatic [2] 
L18:    putfield [22] 
L21:    return 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public interface [125] : [126] 
    .attribute [122] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [14] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public synchronized [127] : [128] 
    .attribute [122] .code stack 2 locals 1 
L0:     aload_0 
L1:     getfield [13] 
L4:     istore_2 
L5:     iload_2 
L6:     ifeq L25 
L9:     aload_0 
L10:    iconst_0 
L11:    putfield [20] 
L14:    aload_0 
L15:    invokespecial [18] 
L18:    aload_1 
L19:    aload_0 
L20:    invokeinterface [23] 0 
L25:    iload_2 
L26:    areturn 
L27:    nop 
L28:    
    .end code 
.end method 

.method public synchronized [129] : [130] 
    .attribute [122] .code stack 4 locals 3 
L0:     aload_1 
L1:     aload_0 
L2:     invokeinterface [24] 0 
L7:     ifne L17 
L10:    aload_0 
L11:    getfield [13] 
L14:    ifne L19 
L17:    iconst_1 
L18:    areturn 
L19:    lload_2 
L20:    lconst_0 
L21:    lcmp 
L22:    ifgt L32 
L25:    aload_0 
L26:    iconst_0 
L27:    putfield [20] 
L30:    iconst_0 
L31:    areturn 
L32:    invokestatic [3] 
L35:    lload_2 
L36:    ladd 
L37:    lstore 4 
        .catch [5] from L39 to L55 using L76 
L39:    getstatic [4] 
L42:    aload_0 
L43:    lload_2 
L44:    invokevirtual [15] 
L47:    aload_0 
L48:    getfield [13] 
L51:    ifne L56 
L54:    iconst_1 
L55:    areturn 
        .catch [5] from L56 to L75 using L76 
L56:    lload 4 
L58:    invokestatic [3] 
L61:    lsub 
L62:    lstore_2 
L63:    lload_2 
L64:    lconst_0 
L65:    lcmp 
L66:    ifgt L39 
L69:    aload_0 
L70:    iconst_0 
L71:    putfield [20] 
L74:    iconst_0 
L75:    areturn 
L76:    astore 6 
L78:    aload_0 
L79:    getfield [13] 
L82:    ifeq L93 
L85:    aload_0 
L86:    iconst_0 
L87:    putfield [20] 
L90:    aload 6 
L92:    athrow 
L93:    invokestatic [2] 
L96:    invokevirtual [16] 
L99:    iconst_1 
L100:   areturn 
L101:   nop 
L102:   nop 
L103:   nop 
L104:   
    .end code 
.end method 

.method public synchronized [131] : [132] 
    .attribute [122] .code stack 2 locals 1 
L0:     aload_1 
L1:     aload_0 
L2:     invokeinterface [24] 0 
L7:     ifne L49 
        .catch [5] from L10 to L24 using L27 
L10:    aload_0 
L11:    getfield [13] 
L14:    ifeq L24 
L17:    aload_0 
L18:    invokespecial [19] 
L21:    goto L10 
L24:    goto L49 
L27:    astore_2 
L28:    aload_0 
L29:    getfield [13] 
L32:    ifeq L42 
L35:    aload_0 
L36:    iconst_0 
L37:    putfield [20] 
L40:    aload_2 
L41:    athrow 
L42:    invokestatic [2] 
L45:    invokevirtual [16] 
L48:    return 
L49:    return 
L50:    nop 
L51:    nop 
L52:    
    .end code 
.end method 

.method public synchronized [133] : [134] 
    .attribute [122] .code stack 2 locals 3 
L0:     aload_1 
L1:     aload_0 
L2:     invokeinterface [24] 0 
L7:     ifne L62 
L10:    invokestatic [6] 
L13:    istore_2 
L14:    aload_0 
L15:    getfield [13] 
L18:    ifeq L34 
        .catch [5] from L21 to L25 using L28 
        .catch [0] from L14 to L34 using L47 
L21:    aload_0 
L22:    invokespecial [19] 
L25:    goto L14 
L28:    astore_3 
L29:    iconst_1 
L30:    istore_2 
L31:    goto L14 
L34:    iload_2 
L35:    ifeq L62 
L38:    invokestatic [2] 
L41:    invokevirtual [16] 
L44:    goto L62 
        .catch [0] from L47 to L49 using L47 
L47:    astore 4 
L49:    iload_2 
L50:    ifeq L59 
L53:    invokestatic [2] 
L56:    invokevirtual [16] 
L59:    aload 4 
L61:    athrow 
L62:    return 
L63:    nop 
L64:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [25] [26] 
.const [3] = Method [27] [28] 
.const [4] = Field [29] [30] 
.const [5] = Class [31] 
.const [6] = Method [32] [33] 
.const [7] = Class [34] 
.const [8] = Class [35] 
.const [9] = Class [36] 
.const [10] = Class [37] 
.const [11] = Class [38] 
.const [12] = Class [39] 
.const [13] = Field [40] [41] 
.const [14] = Field [42] [43] 
.const [15] = Method [44] [45] 
.const [16] = Method [46] [47] 
.const [17] = Method [48] [49] 
.const [18] = Method [50] [51] 
.const [19] = Method [52] [53] 
.const [20] = Field [54] [55] 
.const [21] = Field [56] [57] 
.const [22] = Field [58] [59] 
.const [23] = InterfaceMethod [60] [61] 
.const [24] = InterfaceMethod [62] [63] 
.const [25] = Class [64] 
.const [26] = NameAndType [65] [66] 
.const [27] = Class [67] 
.const [28] = NameAndType [68] [69] 
.const [29] = Class [70] 
.const [30] = NameAndType [71] [72] 
.const [31] = Utf8 java/lang/InterruptedException 
.const [32] = Class [73] 
.const [33] = NameAndType [74] [75] 
.const [34] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/helpers/WaitQueue$WaitNode 
.const [35] = Utf8 java/lang/Object 
.const [36] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/helpers/WaitQueue$QueuedSync 
.const [37] = Utf8 java/lang/Thread 
.const [38] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/helpers/Utils 
.const [39] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/TimeUnit 
.const [40] = Class [76] 
.const [41] = NameAndType [77] [78] 
.const [42] = Class [79] 
.const [43] = NameAndType [80] [81] 
.const [44] = Class [82] 
.const [45] = NameAndType [83] [84] 
.const [46] = Class [85] 
.const [47] = NameAndType [86] [87] 
.const [48] = Class [88] 
.const [49] = NameAndType [89] [90] 
.const [50] = Class [91] 
.const [51] = NameAndType [92] [93] 
.const [52] = Class [94] 
.const [53] = NameAndType [95] [96] 
.const [54] = Class [97] 
.const [55] = NameAndType [98] [99] 
.const [56] = Class [100] 
.const [57] = NameAndType [101] [102] 
.const [58] = Class [103] 
.const [59] = NameAndType [104] [105] 
.const [60] = Class [106] 
.const [61] = NameAndType [107] [108] 
.const [62] = Class [109] 
.const [63] = NameAndType [110] [111] 
.const [64] = Utf8 java/lang/Thread 
.const [65] = Utf8 currentThread 
.const [66] = Utf8 ()Ljava/lang/Thread; 
.const [67] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/helpers/Utils 
.const [68] = Utf8 nanoTime 
.const [69] = Utf8 ()J 
.const [70] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/TimeUnit 
.const [71] = Utf8 NANOSECONDS 
.const [72] = Utf8 Ledu/emory/mathcs/backport/java/util/concurrent/TimeUnit; 
.const [73] = Utf8 java/lang/Thread 
.const [74] = Utf8 interrupted 
.const [75] = Utf8 ()Z 
.const [76] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/helpers/WaitQueue$WaitNode 
.const [77] = Utf8 waiting 
.const [78] = Utf8 Z 
.const [79] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/helpers/WaitQueue$WaitNode 
.const [80] = Utf8 owner 
.const [81] = Utf8 Ljava/lang/Thread; 
.const [82] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/TimeUnit 
.const [83] = Utf8 timedWait 
.const [84] = Utf8 (Ljava/lang/Object;J)V 
.const [85] = Utf8 java/lang/Thread 
.const [86] = Utf8 interrupt 
.const [87] = Utf8 ()V 
.const [88] = Utf8 java/lang/Object 
.const [89] = Utf8 <init> 
.const [90] = Utf8 ()V 
.const [91] = Utf8 java/lang/Object 
.const [92] = Utf8 notify 
.const [93] = Utf8 ()V 
.const [94] = Utf8 java/lang/Object 
.const [95] = Utf8 wait 
.const [96] = Utf8 ()V 
.const [97] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/helpers/WaitQueue$WaitNode 
.const [98] = Utf8 waiting 
.const [99] = Utf8 Z 
.const [100] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/helpers/WaitQueue$WaitNode 
.const [101] = Utf8 next 
.const [102] = Utf8 Ledu/emory/mathcs/backport/java/util/concurrent/helpers/WaitQueue$WaitNode; 
.const [103] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/helpers/WaitQueue$WaitNode 
.const [104] = Utf8 owner 
.const [105] = Utf8 Ljava/lang/Thread; 
.const [106] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/helpers/WaitQueue$QueuedSync 
.const [107] = Utf8 takeOver 
.const [108] = Utf8 (Ledu/emory/mathcs/backport/java/util/concurrent/helpers/WaitQueue$WaitNode;)V 
.const [109] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/helpers/WaitQueue$QueuedSync 
.const [110] = Utf8 recheck 
.const [111] = Utf8 (Ledu/emory/mathcs/backport/java/util/concurrent/helpers/WaitQueue$WaitNode;)Z 
.const [112] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/helpers/WaitQueue$WaitNode 
.const [113] = Class [112] 
.const [114] = Utf8 java/lang/Object 
.const [115] = Class [114] 
.const [116] = Utf8 waiting 
.const [117] = Utf8 Z 
.const [118] = Utf8 next 
.const [119] = Utf8 Ledu/emory/mathcs/backport/java/util/concurrent/helpers/WaitQueue$WaitNode; 
.const [120] = Utf8 owner 
.const [121] = Utf8 Ljava/lang/Thread; 
.const [122] = Utf8 Code 
.const [123] = Utf8 <init> 
.const [124] = Utf8 ()V 
.const [125] = Utf8 getOwner 
.const [126] = Utf8 ()Ljava/lang/Thread; 
.const [127] = Utf8 signal 
.const [128] = Utf8 (Ledu/emory/mathcs/backport/java/util/concurrent/helpers/WaitQueue$QueuedSync;)Z 
.const [129] = Utf8 doTimedWait 
.const [130] = Utf8 (Ledu/emory/mathcs/backport/java/util/concurrent/helpers/WaitQueue$QueuedSync;J)Z 
.const [131] = Utf8 doWait 
.const [132] = Utf8 (Ledu/emory/mathcs/backport/java/util/concurrent/helpers/WaitQueue$QueuedSync;)V 
.const [133] = Utf8 doWaitUninterruptibly 
.const [134] = Utf8 (Ledu/emory/mathcs/backport/java/util/concurrent/helpers/WaitQueue$QueuedSync;)V 
.end class 
