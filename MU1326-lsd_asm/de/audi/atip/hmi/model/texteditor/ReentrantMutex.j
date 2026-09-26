.version 50 0 
.class public super [145] 
.super [147] 
.field private [148] [149] 
.field public [150] [151] 

.method public [153] : [154] 
    .attribute [152] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [22] 
L4:     aload_0 
L5:     iconst_0 
L6:     putfield [29] 
L9:     aload_0 
L10:    aconst_null 
L11:    putfield [30] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [155] : [156] 
    .attribute [152] .code stack 3 locals 3 
L0:     invokestatic [2] 
L3:     ifeq L14 
L6:     new [31] 
L9:     dup 
L10:    invokespecial [23] 
L13:    athrow 
L14:    aload_0 
L15:    dup 
L16:    astore_1 
L17:    monitorenter 
L18:    aload_0 
L19:    getfield [16] 
L22:    invokestatic [4] 
L25:    if_acmpne L42 
L28:    aload_0 
L29:    dup 
L30:    getfield [15] 
L33:    iconst_1 
L34:    iadd 
L35:    putfield [29] 
L38:    iconst_1 
L39:    aload_1 
L40:    monitorexit 
L41:    areturn 
        .catch [3] from L42 to L68 using L71 
        .catch [0] from L18 to L41 using L82 
        .catch [0] from L42 to L81 using L82 
L42:    aload_0 
L43:    getfield [16] 
L46:    ifnull L56 
L49:    aload_0 
L50:    invokespecial [24] 
L53:    goto L42 
L56:    aload_0 
L57:    invokestatic [4] 
L60:    putfield [30] 
L63:    aload_0 
L64:    iconst_1 
L65:    putfield [29] 
L68:    goto L78 
L71:    astore_2 
L72:    aload_0 
L73:    invokespecial [25] 
L76:    aload_2 
L77:    athrow 
L78:    iconst_1 
L79:    aload_1 
L80:    monitorexit 
L81:    areturn 
        .catch [0] from L82 to L85 using L82 
L82:    astore_3 
L83:    aload_1 
L84:    monitorexit 
L85:    aload_3 
L86:    athrow 
L87:    nop 
L88:    
    .end code 
.end method 

.method public [157] : [158] 
    .attribute [152] .code stack 6 locals 7 
L0:     invokestatic [2] 
L3:     ifeq L14 
L6:     new [31] 
L9:     dup 
L10:    invokespecial [23] 
L13:    athrow 
L14:    aload_0 
L15:    dup 
L16:    astore_3 
L17:    monitorenter 
L18:    aload_0 
L19:    getfield [16] 
L22:    ifnonnull L36 
L25:    aload_0 
L26:    invokestatic [4] 
L29:    putfield [30] 
L32:    iconst_1 
L33:    aload_3 
L34:    monitorexit 
L35:    areturn 
L36:    aload_0 
L37:    getfield [16] 
L40:    invokestatic [4] 
L43:    if_acmpne L50 
L46:    iconst_1 
L47:    aload_3 
L48:    monitorexit 
L49:    areturn 
L50:    lload_1 
L51:    lconst_0 
L52:    lcmp 
L53:    ifgt L60 
L56:    iconst_0 
L57:    aload_3 
L58:    monitorexit 
L59:    areturn 
L60:    lload_1 
L61:    lstore 4 
L63:    invokestatic [5] 
L66:    lstore 6 
        .catch [3] from L68 to L89 using L113 
L68:    aload_0 
L69:    lload 4 
L71:    invokespecial [26] 
L74:    aload_0 
L75:    getfield [16] 
L78:    ifnonnull L92 
L81:    aload_0 
L82:    invokestatic [4] 
L85:    putfield [30] 
L88:    iconst_1 
L89:    aload_3 
L90:    monitorexit 
L91:    areturn 
        .catch [3] from L92 to L110 using L113 
        .catch [0] from L18 to L35 using L122 
        .catch [0] from L36 to L49 using L122 
        .catch [0] from L50 to L59 using L122 
        .catch [0] from L60 to L91 using L122 
        .catch [0] from L92 to L112 using L122 
L92:    lload_1 
L93:    invokestatic [5] 
L96:    lload 6 
L98:    lsub 
L99:    lsub 
L100:   lstore 4 
L102:   lload 4 
L104:   lconst_0 
L105:   lcmp 
L106:   ifgt L68 
L109:   iconst_0 
L110:   aload_3 
L111:   monitorexit 
L112:   areturn 
        .catch [0] from L113 to L126 using L122 
L113:   astore 8 
L115:   aload_0 
L116:   invokespecial [25] 
L119:   aload 8 
L121:   athrow 
L122:   astore 9 
L124:   aload_3 
L125:   monitorexit 
L126:   aload 9 
L128:   athrow 
L129:   nop 
L130:   nop 
L131:   nop 
L132:   
    .end code 
.end method 

.method public synchronized [159] : [160] 
    .attribute [152] .code stack 3 locals 1 
L0:     invokestatic [4] 
L3:     astore_1 
L4:     aload_0 
L5:     getfield [16] 
L8:     ifnonnull L37 
L11:    getstatic [6] 
L14:    new [32] 
L17:    dup 
L18:    invokespecial [27] 
L21:    ldc [8] 
L23:    invokevirtual [17] 
L26:    aload_1 
L27:    invokevirtual [18] 
L30:    invokevirtual [19] 
L33:    invokevirtual [20] 
L36:    return 
L37:    aload_1 
L38:    aload_0 
L39:    getfield [16] 
L42:    invokevirtual [21] 
L45:    ifeq L110 
L48:    aload_0 
L49:    dup 
L50:    getfield [15] 
L53:    iconst_1 
L54:    isub 
L55:    putfield [29] 
L58:    aload_0 
L59:    getfield [15] 
L62:    ifgt L110 
L65:    aload_0 
L66:    getfield [15] 
L69:    ifne L84 
L72:    aload_0 
L73:    aconst_null 
L74:    putfield [30] 
L77:    aload_0 
L78:    invokespecial [28] 
L81:    goto L109 
L84:    getstatic [6] 
L87:    new [32] 
L90:    dup 
L91:    invokespecial [27] 
L94:    ldc [9] 
L96:    invokevirtual [17] 
L99:    aload_1 
L100:   invokevirtual [18] 
L103:   invokevirtual [19] 
L106:   invokevirtual [20] 
L109:   return 
L110:   return 
L111:   nop 
L112:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [33] [34] 
.const [3] = Class [35] 
.const [4] = Method [36] [37] 
.const [5] = Method [38] [39] 
.const [6] = Field [40] [41] 
.const [7] = Class [42] 
.const [8] = String [43] 
.const [9] = String [44] 
.const [10] = Class [45] 
.const [11] = Class [46] 
.const [12] = Class [47] 
.const [13] = Class [48] 
.const [14] = Class [49] 
.const [15] = Field [50] [51] 
.const [16] = Field [52] [53] 
.const [17] = Method [54] [55] 
.const [18] = Method [56] [57] 
.const [19] = Method [58] [59] 
.const [20] = Method [60] [61] 
.const [21] = Method [62] [63] 
.const [22] = Method [64] [65] 
.const [23] = Method [66] [67] 
.const [24] = Method [68] [69] 
.const [25] = Method [70] [71] 
.const [26] = Method [72] [73] 
.const [27] = Method [74] [75] 
.const [28] = Method [76] [77] 
.const [29] = Field [78] [79] 
.const [30] = Field [80] [81] 
.const [31] = Class [82] 
.const [32] = Class [83] 
.const [33] = Class [84] 
.const [34] = NameAndType [85] [86] 
.const [35] = Utf8 java/lang/InterruptedException 
.const [36] = Class [87] 
.const [37] = NameAndType [88] [89] 
.const [38] = Class [90] 
.const [39] = NameAndType [91] [92] 
.const [40] = Class [93] 
.const [41] = NameAndType [94] [95] 
.const [42] = Utf8 java/lang/StringBuffer 
.const [43] = Utf8 '!!! WARNING !!! trying to release unowned mutex th ' 
.const [44] = Utf8 '!!! WARNING !!! Unmatched aq/rl pairs for th ' 
.const [45] = Utf8 de/audi/atip/hmi/model/texteditor/ReentrantMutex 
.const [46] = Utf8 java/lang/Object 
.const [47] = Utf8 java/lang/Thread 
.const [48] = Utf8 java/lang/System 
.const [49] = Utf8 java/io/PrintStream 
.const [50] = Class [96] 
.const [51] = NameAndType [97] [98] 
.const [52] = Class [99] 
.const [53] = NameAndType [100] [101] 
.const [54] = Class [102] 
.const [55] = NameAndType [103] [104] 
.const [56] = Class [105] 
.const [57] = NameAndType [106] [107] 
.const [58] = Class [108] 
.const [59] = NameAndType [109] [110] 
.const [60] = Class [111] 
.const [61] = NameAndType [112] [113] 
.const [62] = Class [114] 
.const [63] = NameAndType [115] [116] 
.const [64] = Class [117] 
.const [65] = NameAndType [118] [119] 
.const [66] = Class [120] 
.const [67] = NameAndType [121] [122] 
.const [68] = Class [123] 
.const [69] = NameAndType [124] [125] 
.const [70] = Class [126] 
.const [71] = NameAndType [127] [128] 
.const [72] = Class [129] 
.const [73] = NameAndType [130] [131] 
.const [74] = Class [132] 
.const [75] = NameAndType [133] [134] 
.const [76] = Class [135] 
.const [77] = NameAndType [136] [137] 
.const [78] = Class [138] 
.const [79] = NameAndType [139] [140] 
.const [80] = Class [141] 
.const [81] = NameAndType [142] [143] 
.const [82] = Utf8 java/lang/InterruptedException 
.const [83] = Utf8 java/lang/StringBuffer 
.const [84] = Utf8 java/lang/Thread 
.const [85] = Utf8 interrupted 
.const [86] = Utf8 ()Z 
.const [87] = Utf8 java/lang/Thread 
.const [88] = Utf8 currentThread 
.const [89] = Utf8 ()Ljava/lang/Thread; 
.const [90] = Utf8 java/lang/System 
.const [91] = Utf8 currentTimeMillis 
.const [92] = Utf8 ()J 
.const [93] = Utf8 java/lang/System 
.const [94] = Utf8 out 
.const [95] = Utf8 Ljava/io/PrintStream; 
.const [96] = Utf8 de/audi/atip/hmi/model/texteditor/ReentrantMutex 
.const [97] = Utf8 noEntries 
.const [98] = Utf8 I 
.const [99] = Utf8 de/audi/atip/hmi/model/texteditor/ReentrantMutex 
.const [100] = Utf8 owner 
.const [101] = Utf8 Ljava/lang/Thread; 
.const [102] = Utf8 java/lang/StringBuffer 
.const [103] = Utf8 append 
.const [104] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [105] = Utf8 java/lang/StringBuffer 
.const [106] = Utf8 append 
.const [107] = Utf8 (Ljava/lang/Object;)Ljava/lang/StringBuffer; 
.const [108] = Utf8 java/lang/StringBuffer 
.const [109] = Utf8 toString 
.const [110] = Utf8 ()Ljava/lang/String; 
.const [111] = Utf8 java/io/PrintStream 
.const [112] = Utf8 println 
.const [113] = Utf8 (Ljava/lang/String;)V 
.const [114] = Utf8 java/lang/Object 
.const [115] = Utf8 equals 
.const [116] = Utf8 (Ljava/lang/Object;)Z 
.const [117] = Utf8 java/lang/Object 
.const [118] = Utf8 <init> 
.const [119] = Utf8 ()V 
.const [120] = Utf8 java/lang/InterruptedException 
.const [121] = Utf8 <init> 
.const [122] = Utf8 ()V 
.const [123] = Utf8 java/lang/Object 
.const [124] = Utf8 wait 
.const [125] = Utf8 ()V 
.const [126] = Utf8 java/lang/Object 
.const [127] = Utf8 notifyAll 
.const [128] = Utf8 ()V 
.const [129] = Utf8 java/lang/Object 
.const [130] = Utf8 wait 
.const [131] = Utf8 (J)V 
.const [132] = Utf8 java/lang/StringBuffer 
.const [133] = Utf8 <init> 
.const [134] = Utf8 ()V 
.const [135] = Utf8 java/lang/Object 
.const [136] = Utf8 notify 
.const [137] = Utf8 ()V 
.const [138] = Utf8 de/audi/atip/hmi/model/texteditor/ReentrantMutex 
.const [139] = Utf8 noEntries 
.const [140] = Utf8 I 
.const [141] = Utf8 de/audi/atip/hmi/model/texteditor/ReentrantMutex 
.const [142] = Utf8 owner 
.const [143] = Utf8 Ljava/lang/Thread; 
.const [144] = Utf8 de/audi/atip/hmi/model/texteditor/ReentrantMutex 
.const [145] = Class [144] 
.const [146] = Utf8 java/lang/Object 
.const [147] = Class [146] 
.const [148] = Utf8 owner 
.const [149] = Utf8 Ljava/lang/Thread; 
.const [150] = Utf8 noEntries 
.const [151] = Utf8 I 
.const [152] = Utf8 Code 
.const [153] = Utf8 <init> 
.const [154] = Utf8 ()V 
.const [155] = Utf8 acquire 
.const [156] = Utf8 ()Z 
.const [157] = Utf8 attempt 
.const [158] = Utf8 (J)Z 
.const [159] = Utf8 release 
.const [160] = Utf8 ()V 
.end class 
