.version 50 0 
.class super abstract [181] 
.super [183] 
.field private static [184] [185] 
.field private [186] [187] 
.field private static [188] [189] 

.method static [191] : [192] 
    .attribute [190] .code stack 2 locals 0 
L0:     new [38] 
L3:     dup 
L4:     invokespecial [31] 
L7:     putstatic [32] 
L10:    lconst_0 
L11:    putstatic [33] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method private static native [193] : [194] 
    .attribute [190] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method private static native [195] : [196] 
    .attribute [190] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method private static native [197] : [198] 
    .attribute [190] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method private static native [199] : [200] 
    .attribute [190] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method [201] : [202] 
    .attribute [190] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [34] 
L4:     aload_0 
L5:     aconst_null 
L6:     putfield [39] 
L9:     aload_0 
L10:    aload_1 
L11:    iload_2 
L12:    invokevirtual [25] 
L15:    return 
L16:    
    .end code 
.end method 

.method [203] : [204] 
    .attribute [190] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [34] 
L4:     aload_0 
L5:     aconst_null 
L6:     putfield [39] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method protected [205] : [206] 
    .attribute [190] .code stack 4 locals 2 
L0:     invokestatic [8] 
L3:     astore_3 
L4:     aload_3 
L5:     ifnull L15 
L8:     aload_3 
L9:     getstatic [10] 
L12:    invokevirtual [26] 
L15:    getstatic [5] 
L18:    dup 
L19:    astore 4 
L21:    monitorenter 
        .catch [0] from L22 to L91 using L94 
L22:    getstatic [5] 
L25:    aload_1 
L26:    invokevirtual [27] 
L29:    ifeq L45 
L32:    new [40] 
L35:    dup 
L36:    ldc [13] 
L38:    invokestatic [15] 
L41:    invokespecial [35] 
L44:    athrow 
L45:    getstatic [5] 
L48:    aload_1 
L49:    aload_1 
L50:    invokevirtual [28] 
L53:    pop 
L54:    aload_1 
L55:    iload_2 
L56:    invokestatic [16] 
L59:    putstatic [33] 
L62:    getstatic [6] 
L65:    lconst_0 
L66:    lcmp 
L67:    ifne L83 
L70:    new [41] 
L73:    dup 
L74:    ldc [18] 
L76:    invokestatic [15] 
L79:    invokespecial [36] 
L82:    athrow 
L83:    aload_0 
L84:    aload_1 
L85:    putfield [39] 
L88:    aload 4 
L90:    monitorexit 
L91:    goto L98 
        .catch [0] from L94 to L97 using L94 
L94:    aload 4 
L96:    monitorexit 
L97:    athrow 
L98:    return 
L99:    nop 
L100:   
    .end code 
.end method 

.method public [207] : [208] 
    .attribute [190] .code stack 4 locals 1 
L0:     invokestatic [8] 
L3:     astore_1 
L4:     aload_1 
L5:     ifnull L15 
L8:     aload_1 
L9:     getstatic [10] 
L12:    invokevirtual [26] 
L15:    getstatic [6] 
L18:    lconst_0 
L19:    lcmp 
L20:    ifeq L30 
L23:    getstatic [6] 
L26:    invokestatic [19] 
L29:    areturn 
L30:    new [42] 
L33:    dup 
L34:    ldc [21] 
L36:    invokestatic [15] 
L39:    invokespecial [37] 
L42:    athrow 
L43:    nop 
L44:    
    .end code 
.end method 

.method public [209] : [210] 
    .attribute [190] .code stack 4 locals 1 
L0:     invokestatic [8] 
L3:     astore_1 
L4:     aload_1 
L5:     ifnull L15 
L8:     aload_1 
L9:     getstatic [10] 
L12:    invokevirtual [26] 
L15:    getstatic [6] 
L18:    lconst_0 
L19:    lcmp 
L20:    ifeq L30 
L23:    getstatic [6] 
L26:    invokestatic [22] 
L29:    areturn 
L30:    new [42] 
L33:    dup 
L34:    ldc [21] 
L36:    invokestatic [15] 
L39:    invokespecial [37] 
L42:    athrow 
L43:    nop 
L44:    
    .end code 
.end method 

.method public [211] : [212] 
    .attribute [190] .code stack 4 locals 2 
L0:     invokestatic [8] 
L3:     astore_1 
L4:     aload_1 
L5:     ifnull L15 
L8:     aload_1 
L9:     getstatic [10] 
L12:    invokevirtual [26] 
L15:    getstatic [5] 
L18:    dup 
L19:    astore_2 
L20:    monitorenter 
        .catch [0] from L21 to L81 using L84 
L21:    getstatic [6] 
L24:    lconst_0 
L25:    lcmp 
L26:    ifeq L66 
L29:    getstatic [5] 
L32:    aload_0 
L33:    getfield [24] 
L36:    invokevirtual [27] 
L39:    ifeq L53 
L42:    getstatic [5] 
L45:    aload_0 
L46:    getfield [24] 
L49:    invokevirtual [29] 
L52:    pop 
L53:    getstatic [6] 
L56:    invokestatic [23] 
L59:    lconst_0 
L60:    putstatic [33] 
L63:    goto L79 
L66:    new [42] 
L69:    dup 
L70:    ldc [21] 
L72:    invokestatic [15] 
L75:    invokespecial [37] 
L78:    athrow 
L79:    aload_2 
L80:    monitorexit 
L81:    goto L87 
        .catch [0] from L84 to L86 using L84 
L84:    aload_2 
L85:    monitorexit 
L86:    athrow 
L87:    return 
L88:    
    .end code 
.end method 

.method protected [213] : [214] 
    .attribute [190] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokevirtual [30] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [43] 
.const [3] = Class [44] 
.const [4] = Class [45] 
.const [5] = Field [46] [47] 
.const [6] = Field [48] [49] 
.const [7] = Class [50] 
.const [8] = Method [51] [52] 
.const [9] = Class [53] 
.const [10] = Field [54] [55] 
.const [11] = Class [56] 
.const [12] = Class [57] 
.const [13] = String [58] 
.const [14] = Class [59] 
.const [15] = Method [60] [61] 
.const [16] = Method [62] [63] 
.const [17] = Class [64] 
.const [18] = String [65] 
.const [19] = Method [66] [67] 
.const [20] = Class [68] 
.const [21] = String [69] 
.const [22] = Method [70] [71] 
.const [23] = Method [72] [73] 
.const [24] = Field [74] [75] 
.const [25] = Method [76] [77] 
.const [26] = Method [78] [79] 
.const [27] = Method [80] [81] 
.const [28] = Method [82] [83] 
.const [29] = Method [84] [85] 
.const [30] = Method [86] [87] 
.const [31] = Method [88] [89] 
.const [32] = Field [90] [91] 
.const [33] = Field [92] [93] 
.const [34] = Method [94] [95] 
.const [35] = Method [96] [97] 
.const [36] = Method [98] [99] 
.const [37] = Method [100] [101] 
.const [38] = Class [102] 
.const [39] = Field [103] [104] 
.const [40] = Class [105] 
.const [41] = Class [106] 
.const [42] = Class [107] 
.const [43] = Utf8 com/ibm/oti/util/semaphore/Semaphore 
.const [44] = Utf8 java/lang/Object 
.const [45] = Utf8 java/util/Hashtable 
.const [46] = Class [108] 
.const [47] = NameAndType [109] [110] 
.const [48] = Class [111] 
.const [49] = NameAndType [112] [113] 
.const [50] = Utf8 java/lang/System 
.const [51] = Class [114] 
.const [52] = NameAndType [115] [116] 
.const [53] = Utf8 com/ibm/oti/util/semaphore/CreateSemaphorePermission 
.const [54] = Class [117] 
.const [55] = NameAndType [118] [119] 
.const [56] = Utf8 java/lang/SecurityManager 
.const [57] = Utf8 java/lang/IllegalArgumentException 
.const [58] = Utf8 K037c 
.const [59] = Utf8 com/ibm/oti/util/Msg 
.const [60] = Class [120] 
.const [61] = NameAndType [121] [122] 
.const [62] = Class [123] 
.const [63] = NameAndType [124] [125] 
.const [64] = Utf8 java/lang/RuntimeException 
.const [65] = Utf8 K0353 
.const [66] = Class [126] 
.const [67] = NameAndType [127] [128] 
.const [68] = Utf8 java/lang/IllegalStateException 
.const [69] = Utf8 K0352 
.const [70] = Class [129] 
.const [71] = NameAndType [130] [131] 
.const [72] = Class [132] 
.const [73] = NameAndType [133] [134] 
.const [74] = Class [135] 
.const [75] = NameAndType [136] [137] 
.const [76] = Class [138] 
.const [77] = NameAndType [139] [140] 
.const [78] = Class [141] 
.const [79] = NameAndType [142] [143] 
.const [80] = Class [144] 
.const [81] = NameAndType [145] [146] 
.const [82] = Class [147] 
.const [83] = NameAndType [148] [149] 
.const [84] = Class [150] 
.const [85] = NameAndType [151] [152] 
.const [86] = Class [153] 
.const [87] = NameAndType [154] [155] 
.const [88] = Class [156] 
.const [89] = NameAndType [157] [158] 
.const [90] = Class [159] 
.const [91] = NameAndType [160] [161] 
.const [92] = Class [162] 
.const [93] = NameAndType [163] [164] 
.const [94] = Class [165] 
.const [95] = NameAndType [166] [167] 
.const [96] = Class [168] 
.const [97] = NameAndType [169] [170] 
.const [98] = Class [171] 
.const [99] = NameAndType [172] [173] 
.const [100] = Class [174] 
.const [101] = NameAndType [175] [176] 
.const [102] = Utf8 java/util/Hashtable 
.const [103] = Class [177] 
.const [104] = NameAndType [178] [179] 
.const [105] = Utf8 java/lang/IllegalArgumentException 
.const [106] = Utf8 java/lang/RuntimeException 
.const [107] = Utf8 java/lang/IllegalStateException 
.const [108] = Utf8 com/ibm/oti/util/semaphore/Semaphore 
.const [109] = Utf8 existingSemaphores 
.const [110] = Utf8 Ljava/util/Hashtable; 
.const [111] = Utf8 com/ibm/oti/util/semaphore/Semaphore 
.const [112] = Utf8 semaphoreHandle 
.const [113] = Utf8 J 
.const [114] = Utf8 java/lang/System 
.const [115] = Utf8 getSecurityManager 
.const [116] = Utf8 ()Ljava/lang/SecurityManager; 
.const [117] = Utf8 com/ibm/oti/util/semaphore/CreateSemaphorePermission 
.const [118] = Utf8 CreateSemaphorePermission 
.const [119] = Utf8 Lcom/ibm/oti/util/semaphore/CreateSemaphorePermission; 
.const [120] = Utf8 com/ibm/oti/util/Msg 
.const [121] = Utf8 getString 
.const [122] = Utf8 (Ljava/lang/String;)Ljava/lang/String; 
.const [123] = Utf8 com/ibm/oti/util/semaphore/Semaphore 
.const [124] = Utf8 init 
.const [125] = Utf8 (Ljava/lang/String;I)J 
.const [126] = Utf8 com/ibm/oti/util/semaphore/Semaphore 
.const [127] = Utf8 waitOnSemaphore 
.const [128] = Utf8 (J)Z 
.const [129] = Utf8 com/ibm/oti/util/semaphore/Semaphore 
.const [130] = Utf8 postOnSemaphore 
.const [131] = Utf8 (J)Z 
.const [132] = Utf8 com/ibm/oti/util/semaphore/Semaphore 
.const [133] = Utf8 closeSemaphore 
.const [134] = Utf8 (J)V 
.const [135] = Utf8 com/ibm/oti/util/semaphore/Semaphore 
.const [136] = Utf8 name 
.const [137] = Utf8 Ljava/lang/String; 
.const [138] = Utf8 com/ibm/oti/util/semaphore/Semaphore 
.const [139] = Utf8 initializeSemaphore 
.const [140] = Utf8 (Ljava/lang/String;I)V 
.const [141] = Utf8 java/lang/SecurityManager 
.const [142] = Utf8 checkPermission 
.const [143] = Utf8 (Ljava/security/Permission;)V 
.const [144] = Utf8 java/util/Hashtable 
.const [145] = Utf8 containsKey 
.const [146] = Utf8 (Ljava/lang/Object;)Z 
.const [147] = Utf8 java/util/Hashtable 
.const [148] = Utf8 put 
.const [149] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 
.const [150] = Utf8 java/util/Hashtable 
.const [151] = Utf8 remove 
.const [152] = Utf8 (Ljava/lang/Object;)Ljava/lang/Object; 
.const [153] = Utf8 com/ibm/oti/util/semaphore/Semaphore 
.const [154] = Utf8 close 
.const [155] = Utf8 ()V 
.const [156] = Utf8 java/util/Hashtable 
.const [157] = Utf8 <init> 
.const [158] = Utf8 ()V 
.const [159] = Utf8 com/ibm/oti/util/semaphore/Semaphore 
.const [160] = Utf8 existingSemaphores 
.const [161] = Utf8 Ljava/util/Hashtable; 
.const [162] = Utf8 com/ibm/oti/util/semaphore/Semaphore 
.const [163] = Utf8 semaphoreHandle 
.const [164] = Utf8 J 
.const [165] = Utf8 java/lang/Object 
.const [166] = Utf8 <init> 
.const [167] = Utf8 ()V 
.const [168] = Utf8 java/lang/IllegalArgumentException 
.const [169] = Utf8 <init> 
.const [170] = Utf8 (Ljava/lang/String;)V 
.const [171] = Utf8 java/lang/RuntimeException 
.const [172] = Utf8 <init> 
.const [173] = Utf8 (Ljava/lang/String;)V 
.const [174] = Utf8 java/lang/IllegalStateException 
.const [175] = Utf8 <init> 
.const [176] = Utf8 (Ljava/lang/String;)V 
.const [177] = Utf8 com/ibm/oti/util/semaphore/Semaphore 
.const [178] = Utf8 name 
.const [179] = Utf8 Ljava/lang/String; 
.const [180] = Utf8 com/ibm/oti/util/semaphore/Semaphore 
.const [181] = Class [180] 
.const [182] = Utf8 java/lang/Object 
.const [183] = Class [182] 
.const [184] = Utf8 existingSemaphores 
.const [185] = Utf8 Ljava/util/Hashtable; 
.const [186] = Utf8 name 
.const [187] = Utf8 Ljava/lang/String; 
.const [188] = Utf8 semaphoreHandle 
.const [189] = Utf8 J 
.const [190] = Utf8 Code 
.const [191] = Utf8 <clinit> 
.const [192] = Utf8 ()V 
.const [193] = Utf8 init 
.const [194] = Utf8 (Ljava/lang/String;I)J 
.const [195] = Utf8 closeSemaphore 
.const [196] = Utf8 (J)V 
.const [197] = Utf8 waitOnSemaphore 
.const [198] = Utf8 (J)Z 
.const [199] = Utf8 postOnSemaphore 
.const [200] = Utf8 (J)Z 
.const [201] = Utf8 <init> 
.const [202] = Utf8 (Ljava/lang/String;I)V 
.const [203] = Utf8 <init> 
.const [204] = Utf8 ()V 
.const [205] = Utf8 initializeSemaphore 
.const [206] = Utf8 (Ljava/lang/String;I)V 
.const [207] = Utf8 waitSemaphore 
.const [208] = Utf8 ()Z 
.const [209] = Utf8 postSemaphore 
.const [210] = Utf8 ()Z 
.const [211] = Utf8 close 
.const [212] = Utf8 ()V 
.const [213] = Utf8 finalize 
.const [214] = Utf8 ()V 
.end class 
