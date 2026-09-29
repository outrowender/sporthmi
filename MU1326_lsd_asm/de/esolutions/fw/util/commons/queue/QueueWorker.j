.version 50 0 
.class public super abstract [147] 
.super [149] 
.implements [151] 
.field private final [152] [153] 
.field private final [154] [155] 
.field private final [156] [157] 
.field private [158] [159] 

.method public [161] : [162] 
    .attribute [160] .code stack 4 locals 0 
L0:     aload_0 
L1:     invokespecial [21] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [25] 
L9:     aload_0 
L10:    new [26] 
L13:    dup 
L14:    iload_2 
L15:    invokespecial [22] 
L18:    putfield [27] 
L21:    aload_0 
L22:    aload_3 
L23:    putfield [28] 
L26:    return 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [163] : [164] 
    .attribute [160] .code stack 4 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     iload_2 
L3:     aconst_null 
L4:     invokespecial [23] 
L7:     return 
L8:     
    .end code 
.end method 

.method public [165] : [166] 
    .attribute [160] .code stack 5 locals 1 
L0:     aload_0 
L1:     getfield [12] 
L4:     ifnull L8 
L7:     return 
L8:     aconst_null 
L9:     astore_2 
L10:    aload_0 
L11:    getfield [11] 
L14:    ifnull L28 
L17:    aload_0 
L18:    getfield [11] 
L21:    aload_0 
L22:    invokeinterface [30] 0 
L27:    astore_2 
L28:    aload_2 
L29:    ifnonnull L34 
L32:    aload_0 
L33:    astore_2 
L34:    aload_0 
L35:    new [31] 
L38:    dup 
L39:    aload_2 
L40:    aload_0 
L41:    getfield [9] 
L44:    invokespecial [24] 
L47:    putfield [29] 
L50:    aload_0 
L51:    getfield [12] 
L54:    iload_1 
L55:    invokevirtual [13] 
L58:    aload_0 
L59:    getfield [12] 
L62:    invokevirtual [14] 
L65:    return 
L66:    nop 
L67:    nop 
L68:    
    .end code 
.end method 

.method public [167] : [168] 
    .attribute [160] .code stack 2 locals 1 
L0:     aload_0 
L1:     getfield [12] 
L4:     ifnonnull L8 
L7:     return 
L8:     aload_0 
L9:     getfield [10] 
L12:    invokevirtual [15] 
        .catch [4] from L15 to L27 using L30 
L15:    aload_0 
L16:    getfield [12] 
L19:    invokevirtual [16] 
L22:    aload_0 
L23:    aconst_null 
L24:    putfield [29] 
L27:    goto L31 
L30:    astore_1 
L31:    return 
L32:    
    .end code 
.end method 

.method public [169] : [170] 
    .attribute [160] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [12] 
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

.method protected [171] : [172] 
    .attribute [160] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [10] 
L4:     aload_1 
L5:     invokevirtual [17] 
L8:     areturn 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [173] : [174] 
    .attribute [160] .code stack 2 locals 1 
        .catch [5] from L0 to L13 using L16 
        .catch [4] from L0 to L13 using L20 
L0:     aload_0 
L1:     getfield [10] 
L4:     invokevirtual [18] 
L7:     astore_1 
L8:     aload_0 
L9:     aload_1 
L10:    invokevirtual [19] 
L13:    goto L0 
L16:    astore_1 
L17:    goto L24 
L20:    astore_1 
L21:    goto L0 
L24:    return 
L25:    nop 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method protected abstract [175] : [176] 
    .attribute [160] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method public [177] : [178] 
    .attribute [160] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [10] 
L4:     invokevirtual [20] 
L7:     areturn 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [32] 
.const [3] = Class [33] 
.const [4] = Class [34] 
.const [5] = Class [35] 
.const [6] = Class [36] 
.const [7] = Class [37] 
.const [8] = Class [38] 
.const [9] = Field [39] [40] 
.const [10] = Field [41] [42] 
.const [11] = Field [43] [44] 
.const [12] = Field [45] [46] 
.const [13] = Method [47] [48] 
.const [14] = Method [49] [50] 
.const [15] = Method [51] [52] 
.const [16] = Method [53] [54] 
.const [17] = Method [55] [56] 
.const [18] = Method [57] [58] 
.const [19] = Method [59] [60] 
.const [20] = Method [61] [62] 
.const [21] = Method [63] [64] 
.const [22] = Method [65] [66] 
.const [23] = Method [67] [68] 
.const [24] = Method [69] [70] 
.const [25] = Field [71] [72] 
.const [26] = Class [73] 
.const [27] = Field [74] [75] 
.const [28] = Field [76] [77] 
.const [29] = Field [78] [79] 
.const [30] = InterfaceMethod [80] [81] 
.const [31] = Class [82] 
.const [32] = Utf8 de/esolutions/fw/util/commons/queue/Queue 
.const [33] = Utf8 java/lang/Thread 
.const [34] = Utf8 java/lang/InterruptedException 
.const [35] = Utf8 de/esolutions/fw/util/commons/queue/QueueShutdownException 
.const [36] = Utf8 de/esolutions/fw/util/commons/queue/QueueWorker 
.const [37] = Utf8 java/lang/Object 
.const [38] = Utf8 de/esolutions/fw/util/commons/error/IRunnableWrapper 
.const [39] = Class [83] 
.const [40] = NameAndType [84] [85] 
.const [41] = Class [86] 
.const [42] = NameAndType [87] [88] 
.const [43] = Class [89] 
.const [44] = NameAndType [90] [91] 
.const [45] = Class [92] 
.const [46] = NameAndType [93] [94] 
.const [47] = Class [95] 
.const [48] = NameAndType [96] [97] 
.const [49] = Class [98] 
.const [50] = NameAndType [99] [100] 
.const [51] = Class [101] 
.const [52] = NameAndType [102] [103] 
.const [53] = Class [104] 
.const [54] = NameAndType [105] [106] 
.const [55] = Class [107] 
.const [56] = NameAndType [108] [109] 
.const [57] = Class [110] 
.const [58] = NameAndType [111] [112] 
.const [59] = Class [113] 
.const [60] = NameAndType [114] [115] 
.const [61] = Class [116] 
.const [62] = NameAndType [117] [118] 
.const [63] = Class [119] 
.const [64] = NameAndType [120] [121] 
.const [65] = Class [122] 
.const [66] = NameAndType [123] [124] 
.const [67] = Class [125] 
.const [68] = NameAndType [126] [127] 
.const [69] = Class [128] 
.const [70] = NameAndType [129] [130] 
.const [71] = Class [131] 
.const [72] = NameAndType [132] [133] 
.const [73] = Utf8 de/esolutions/fw/util/commons/queue/Queue 
.const [74] = Class [134] 
.const [75] = NameAndType [135] [136] 
.const [76] = Class [137] 
.const [77] = NameAndType [138] [139] 
.const [78] = Class [140] 
.const [79] = NameAndType [141] [142] 
.const [80] = Class [143] 
.const [81] = NameAndType [144] [145] 
.const [82] = Utf8 java/lang/Thread 
.const [83] = Utf8 de/esolutions/fw/util/commons/queue/QueueWorker 
.const [84] = Utf8 name 
.const [85] = Utf8 Ljava/lang/String; 
.const [86] = Utf8 de/esolutions/fw/util/commons/queue/QueueWorker 
.const [87] = Utf8 queue 
.const [88] = Utf8 Lde/esolutions/fw/util/commons/queue/Queue; 
.const [89] = Utf8 de/esolutions/fw/util/commons/queue/QueueWorker 
.const [90] = Utf8 runnableWrapper 
.const [91] = Utf8 Lde/esolutions/fw/util/commons/error/IRunnableWrapper; 
.const [92] = Utf8 de/esolutions/fw/util/commons/queue/QueueWorker 
.const [93] = Utf8 thread 
.const [94] = Utf8 Ljava/lang/Thread; 
.const [95] = Utf8 java/lang/Thread 
.const [96] = Utf8 setPriority 
.const [97] = Utf8 (I)V 
.const [98] = Utf8 java/lang/Thread 
.const [99] = Utf8 start 
.const [100] = Utf8 ()V 
.const [101] = Utf8 de/esolutions/fw/util/commons/queue/Queue 
.const [102] = Utf8 shutdown 
.const [103] = Utf8 ()V 
.const [104] = Utf8 java/lang/Thread 
.const [105] = Utf8 join 
.const [106] = Utf8 ()V 
.const [107] = Utf8 de/esolutions/fw/util/commons/queue/Queue 
.const [108] = Utf8 put 
.const [109] = Utf8 (Ljava/lang/Object;)Z 
.const [110] = Utf8 de/esolutions/fw/util/commons/queue/Queue 
.const [111] = Utf8 get 
.const [112] = Utf8 ()Ljava/lang/Object; 
.const [113] = Utf8 de/esolutions/fw/util/commons/queue/QueueWorker 
.const [114] = Utf8 handleQueuedObject 
.const [115] = Utf8 (Ljava/lang/Object;)V 
.const [116] = Utf8 de/esolutions/fw/util/commons/queue/Queue 
.const [117] = Utf8 size 
.const [118] = Utf8 ()I 
.const [119] = Utf8 java/lang/Object 
.const [120] = Utf8 <init> 
.const [121] = Utf8 ()V 
.const [122] = Utf8 de/esolutions/fw/util/commons/queue/Queue 
.const [123] = Utf8 <init> 
.const [124] = Utf8 (I)V 
.const [125] = Utf8 de/esolutions/fw/util/commons/queue/QueueWorker 
.const [126] = Utf8 <init> 
.const [127] = Utf8 (Ljava/lang/String;ILde/esolutions/fw/util/commons/error/IRunnableWrapper;)V 
.const [128] = Utf8 java/lang/Thread 
.const [129] = Utf8 <init> 
.const [130] = Utf8 (Ljava/lang/Runnable;Ljava/lang/String;)V 
.const [131] = Utf8 de/esolutions/fw/util/commons/queue/QueueWorker 
.const [132] = Utf8 name 
.const [133] = Utf8 Ljava/lang/String; 
.const [134] = Utf8 de/esolutions/fw/util/commons/queue/QueueWorker 
.const [135] = Utf8 queue 
.const [136] = Utf8 Lde/esolutions/fw/util/commons/queue/Queue; 
.const [137] = Utf8 de/esolutions/fw/util/commons/queue/QueueWorker 
.const [138] = Utf8 runnableWrapper 
.const [139] = Utf8 Lde/esolutions/fw/util/commons/error/IRunnableWrapper; 
.const [140] = Utf8 de/esolutions/fw/util/commons/queue/QueueWorker 
.const [141] = Utf8 thread 
.const [142] = Utf8 Ljava/lang/Thread; 
.const [143] = Utf8 de/esolutions/fw/util/commons/error/IRunnableWrapper 
.const [144] = Utf8 wrap 
.const [145] = Utf8 (Ljava/lang/Runnable;)Ljava/lang/Runnable; 
.const [146] = Utf8 de/esolutions/fw/util/commons/queue/QueueWorker 
.const [147] = Class [146] 
.const [148] = Utf8 java/lang/Object 
.const [149] = Class [148] 
.const [150] = Utf8 java/lang/Runnable 
.const [151] = Class [150] 
.const [152] = Utf8 queue 
.const [153] = Utf8 Lde/esolutions/fw/util/commons/queue/Queue; 
.const [154] = Utf8 name 
.const [155] = Utf8 Ljava/lang/String; 
.const [156] = Utf8 runnableWrapper 
.const [157] = Utf8 Lde/esolutions/fw/util/commons/error/IRunnableWrapper; 
.const [158] = Utf8 thread 
.const [159] = Utf8 Ljava/lang/Thread; 
.const [160] = Utf8 Code 
.const [161] = Utf8 <init> 
.const [162] = Utf8 (Ljava/lang/String;ILde/esolutions/fw/util/commons/error/IRunnableWrapper;)V 
.const [163] = Utf8 <init> 
.const [164] = Utf8 (Ljava/lang/String;I)V 
.const [165] = Utf8 start 
.const [166] = Utf8 (I)V 
.const [167] = Utf8 stop 
.const [168] = Utf8 ()V 
.const [169] = Utf8 isRunning 
.const [170] = Utf8 ()Z 
.const [171] = Utf8 addToQueue 
.const [172] = Utf8 (Ljava/lang/Object;)Z 
.const [173] = Utf8 run 
.const [174] = Utf8 ()V 
.const [175] = Utf8 handleQueuedObject 
.const [176] = Utf8 (Ljava/lang/Object;)V 
.const [177] = Utf8 queueSize 
.const [178] = Utf8 ()I 
.end class 
