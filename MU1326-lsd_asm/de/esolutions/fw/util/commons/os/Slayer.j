.version 50 0 
.class public final super [212] 
.super [214] 
.field private [215] [216] 
.field private [217] [218] 
.field private [219] [220] 
.field private final [221] [222] 

.method public [224] : [225] 
    .attribute [223] .code stack 8 locals 2 
L0:     aload_0 
L1:     invokespecial [38] 
L4:     aload_0 
L5:     invokespecial [39] 
L8:     aload_0 
L9:     invokevirtual [24] 
L12:    lstore_2 
L13:    lload_2 
L14:    ldc2_w [49] 
L17:    lcmp 
L18:    ifne L23 
L21:    lconst_0 
L22:    lstore_2 
L23:    aload_0 
L24:    iconst_2 
L25:    anewarray [2] 
L28:    dup 
L29:    iconst_0 
L30:    new [43] 
L33:    dup 
L34:    lload_2 
L35:    invokespecial [40] 
L38:    aastore 
L39:    dup 
L40:    iconst_1 
L41:    new [44] 
L44:    dup 
L45:    iload_1 
L46:    invokespecial [41] 
L49:    aastore 
L50:    putfield [45] 
L53:    return 
L54:    nop 
L55:    nop 
L56:    
    .end code 
.end method 

.method public [226] : [227] 
    .attribute [223] .code stack 2 locals 0 
L0:     aload_0 
L1:     bipush 16 
L3:     invokespecial [42] 
L6:     return 
L7:     nop 
L8:     
    .end code 
.end method 

.method private [228] : [229] 
    .attribute [223] .code stack 4 locals 3 
        .catch [11] from L0 to L19 using L71 
L0:     invokestatic [5] 
L3:     astore_1 
L4:     aload_0 
L5:     aload_1 
L6:     invokevirtual [26] 
L9:     putfield [46] 
L12:    aload_0 
L13:    getfield [27] 
L16:    ifnonnull L20 
L19:    return 
        .catch [11] from L20 to L70 using L71 
L20:    iconst_2 
L21:    anewarray [6] 
L24:    dup 
L25:    iconst_0 
L26:    getstatic [7] 
L29:    aastore 
L30:    dup 
L31:    iconst_1 
L32:    getstatic [8] 
L35:    aastore 
L36:    astore_2 
L37:    aload_0 
L38:    aload_1 
L39:    invokevirtual [28] 
L42:    ldc [9] 
L44:    aload_2 
L45:    invokevirtual [29] 
L48:    putfield [47] 
L51:    iconst_0 
L52:    anewarray [6] 
L55:    astore_3 
L56:    aload_0 
L57:    aload_1 
L58:    invokevirtual [28] 
L61:    ldc [10] 
L63:    aload_3 
L64:    invokevirtual [29] 
L67:    putfield [48] 
L70:    return 
L71:    astore_1 
L72:    aload_1 
L73:    invokevirtual [32] 
L76:    return 
L77:    nop 
L78:    nop 
L79:    nop 
L80:    
    .end code 
.end method 

.method public [230] : [231] 
    .attribute [223] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [30] 
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

.method public [232] : [233] 
    .attribute [223] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [31] 
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

.method public [234] : [235] 
    .attribute [223] .code stack 3 locals 3 
L0:     aload_0 
L1:     getfield [31] 
L4:     ifnonnull L11 
L7:     ldc2_w [49] 
L10:    freturn 
        .catch [11] from L11 to L33 using L34 
L11:    aload_0 
L12:    getfield [31] 
L15:    aload_0 
L16:    getfield [27] 
L19:    aconst_null 
L20:    invokevirtual [33] 
L23:    astore_1 
L24:    aload_1 
L25:    checkcast [3] 
L28:    invokevirtual [34] 
L31:    lstore_2 
L32:    lload_2 
L33:    freturn 
L34:    astore_1 
L35:    ldc2_w [49] 
L38:    freturn 
L39:    nop 
L40:    
    .end code 
.end method 

.method public final [236] : [237] 
    .attribute [223] .code stack 3 locals 1 
L0:     getstatic [12] 
L3:     ldc [13] 
L5:     invokevirtual [35] 
L8:     aload_0 
L9:     getfield [30] 
L12:    ifnull L69 
L15:    getstatic [12] 
L18:    ldc [14] 
L20:    invokevirtual [36] 
L23:    getstatic [12] 
L26:    invokevirtual [37] 
        .catch [11] from L29 to L51 using L54 
L29:    aload_0 
L30:    getfield [30] 
L33:    aload_0 
L34:    getfield [27] 
L37:    aload_0 
L38:    getfield [25] 
L41:    invokevirtual [33] 
L44:    pop 
L45:    ldc_w [1] 
L48:    invokestatic [15] 
L51:    goto L29 
L54:    astore_1 
L55:    getstatic [12] 
L58:    ldc [16] 
L60:    invokevirtual [36] 
L63:    aload_1 
L64:    invokevirtual [32] 
L67:    iconst_0 
L68:    areturn 
L69:    getstatic [12] 
L72:    ldc [17] 
L74:    invokevirtual [36] 
L77:    iconst_0 
L78:    areturn 
L79:    nop 
L80:    
    .end code 
.end method 

.method public final [238] : [239] 
    .attribute [223] .code stack 3 locals 1 
L0:     aload_0 
L1:     getfield [30] 
L4:     ifnull L39 
        .catch [11] from L7 to L29 using L32 
L7:     aload_0 
L8:     getfield [30] 
L11:    aload_0 
L12:    getfield [27] 
L15:    aload_0 
L16:    getfield [25] 
L19:    invokevirtual [33] 
L22:    pop 
L23:    ldc_w [1] 
L26:    invokestatic [15] 
L29:    goto L7 
L32:    astore_1 
L33:    aload_1 
L34:    invokevirtual [32] 
L37:    iconst_0 
L38:    areturn 
L39:    iconst_0 
L40:    areturn 
L41:    nop 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [52] 
.const [3] = Class [53] 
.const [4] = Class [54] 
.const [5] = Method [55] [56] 
.const [6] = Class [57] 
.const [7] = Field [58] [59] 
.const [8] = Field [60] [61] 
.const [9] = String [62] 
.const [10] = String [63] 
.const [11] = Class [64] 
.const [12] = Field [65] [66] 
.const [13] = String [67] 
.const [14] = String [68] 
.const [15] = Method [69] [70] 
.const [16] = String [71] 
.const [17] = String [72] 
.const [18] = Class [73] 
.const [19] = Class [74] 
.const [20] = Class [75] 
.const [21] = Class [76] 
.const [22] = Class [77] 
.const [23] = Class [78] 
.const [24] = Method [79] [80] 
.const [25] = Field [81] [82] 
.const [26] = Method [83] [84] 
.const [27] = Field [85] [86] 
.const [28] = Method [87] [88] 
.const [29] = Method [89] [90] 
.const [30] = Field [91] [92] 
.const [31] = Field [93] [94] 
.const [32] = Method [95] [96] 
.const [33] = Method [97] [98] 
.const [34] = Method [99] [100] 
.const [35] = Method [101] [102] 
.const [36] = Method [103] [104] 
.const [37] = Method [105] [106] 
.const [38] = Method [107] [108] 
.const [39] = Method [109] [110] 
.const [40] = Method [111] [112] 
.const [41] = Method [113] [114] 
.const [42] = Method [115] [116] 
.const [43] = Class [117] 
.const [44] = Class [118] 
.const [45] = Field [119] [120] 
.const [46] = Field [121] [122] 
.const [47] = Field [123] [124] 
.const [48] = Field [125] [126] 
.const [49] = Long -1L 
.const [51] = Int -402456576 
.const [52] = Utf8 java/lang/Object 
.const [53] = Utf8 java/lang/Long 
.const [54] = Utf8 java/lang/Integer 
.const [55] = Class [127] 
.const [56] = NameAndType [128] [129] 
.const [57] = Utf8 java/lang/Class 
.const [58] = Class [130] 
.const [59] = NameAndType [131] [132] 
.const [60] = Class [133] 
.const [61] = NameAndType [134] [135] 
.const [62] = Utf8 kill 
.const [63] = Utf8 getpid 
.const [64] = Utf8 java/lang/Exception 
.const [65] = Class [136] 
.const [66] = NameAndType [137] [138] 
.const [67] = Utf8 '-----> J9 committing suicide <----- ' 
.const [68] = Utf8 ' with OS.kill()' 
.const [69] = Class [139] 
.const [70] = NameAndType [140] [141] 
.const [71] = Utf8 ' -> FAILED!' 
.const [72] = Utf8 ' -> ABORTED: no java_util_os (jar+jni) found!' 
.const [73] = Utf8 de/esolutions/fw/util/commons/os/Slayer 
.const [74] = Utf8 de/esolutions/fw/util/commons/os/OSFinder 
.const [75] = Utf8 java/lang/reflect/Method 
.const [76] = Utf8 java/lang/System 
.const [77] = Utf8 java/io/PrintStream 
.const [78] = Utf8 java/lang/Thread 
.const [79] = Class [142] 
.const [80] = NameAndType [143] [144] 
.const [81] = Class [145] 
.const [82] = NameAndType [146] [147] 
.const [83] = Class [148] 
.const [84] = NameAndType [149] [150] 
.const [85] = Class [151] 
.const [86] = NameAndType [152] [153] 
.const [87] = Class [154] 
.const [88] = NameAndType [155] [156] 
.const [89] = Class [157] 
.const [90] = NameAndType [158] [159] 
.const [91] = Class [160] 
.const [92] = NameAndType [161] [162] 
.const [93] = Class [163] 
.const [94] = NameAndType [164] [165] 
.const [95] = Class [166] 
.const [96] = NameAndType [167] [168] 
.const [97] = Class [169] 
.const [98] = NameAndType [170] [171] 
.const [99] = Class [172] 
.const [100] = NameAndType [173] [174] 
.const [101] = Class [175] 
.const [102] = NameAndType [176] [177] 
.const [103] = Class [178] 
.const [104] = NameAndType [179] [180] 
.const [105] = Class [181] 
.const [106] = NameAndType [182] [183] 
.const [107] = Class [184] 
.const [108] = NameAndType [185] [186] 
.const [109] = Class [187] 
.const [110] = NameAndType [188] [189] 
.const [111] = Class [190] 
.const [112] = NameAndType [191] [192] 
.const [113] = Class [193] 
.const [114] = NameAndType [194] [195] 
.const [115] = Class [196] 
.const [116] = NameAndType [197] [198] 
.const [117] = Utf8 java/lang/Long 
.const [118] = Utf8 java/lang/Integer 
.const [119] = Class [199] 
.const [120] = NameAndType [200] [201] 
.const [121] = Class [202] 
.const [122] = NameAndType [203] [204] 
.const [123] = Class [205] 
.const [124] = NameAndType [206] [207] 
.const [125] = Class [208] 
.const [126] = NameAndType [209] [210] 
.const [127] = Utf8 de/esolutions/fw/util/commons/os/OSFinder 
.const [128] = Utf8 getInstance 
.const [129] = Utf8 ()Lde/esolutions/fw/util/commons/os/OSFinder; 
.const [130] = Utf8 java/lang/Long 
.const [131] = Utf8 TYPE 
.const [132] = Utf8 Ljava/lang/Class; 
.const [133] = Utf8 java/lang/Integer 
.const [134] = Utf8 TYPE 
.const [135] = Utf8 Ljava/lang/Class; 
.const [136] = Utf8 java/lang/System 
.const [137] = Utf8 out 
.const [138] = Utf8 Ljava/io/PrintStream; 
.const [139] = Utf8 java/lang/Thread 
.const [140] = Utf8 sleep 
.const [141] = Utf8 (J)V 
.const [142] = Utf8 de/esolutions/fw/util/commons/os/Slayer 
.const [143] = Utf8 getpid 
.const [144] = Utf8 ()J 
.const [145] = Utf8 de/esolutions/fw/util/commons/os/Slayer 
.const [146] = Utf8 killArgs 
.const [147] = Utf8 [Ljava/lang/Object; 
.const [148] = Utf8 de/esolutions/fw/util/commons/os/OSFinder 
.const [149] = Utf8 getOSInstance 
.const [150] = Utf8 ()Ljava/lang/Object; 
.const [151] = Utf8 de/esolutions/fw/util/commons/os/Slayer 
.const [152] = Utf8 osInstance 
.const [153] = Utf8 Ljava/lang/Object; 
.const [154] = Utf8 de/esolutions/fw/util/commons/os/OSFinder 
.const [155] = Utf8 getOSClass 
.const [156] = Utf8 ()Ljava/lang/Class; 
.const [157] = Utf8 java/lang/Class 
.const [158] = Utf8 getDeclaredMethod 
.const [159] = Utf8 (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method; 
.const [160] = Utf8 de/esolutions/fw/util/commons/os/Slayer 
.const [161] = Utf8 killMethod 
.const [162] = Utf8 Ljava/lang/reflect/Method; 
.const [163] = Utf8 de/esolutions/fw/util/commons/os/Slayer 
.const [164] = Utf8 getpidMethod 
.const [165] = Utf8 Ljava/lang/reflect/Method; 
.const [166] = Utf8 java/lang/Exception 
.const [167] = Utf8 printStackTrace 
.const [168] = Utf8 ()V 
.const [169] = Utf8 java/lang/reflect/Method 
.const [170] = Utf8 invoke 
.const [171] = Utf8 (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object; 
.const [172] = Utf8 java/lang/Long 
.const [173] = Utf8 longValue 
.const [174] = Utf8 ()J 
.const [175] = Utf8 java/io/PrintStream 
.const [176] = Utf8 print 
.const [177] = Utf8 (Ljava/lang/String;)V 
.const [178] = Utf8 java/io/PrintStream 
.const [179] = Utf8 println 
.const [180] = Utf8 (Ljava/lang/String;)V 
.const [181] = Utf8 java/io/PrintStream 
.const [182] = Utf8 flush 
.const [183] = Utf8 ()V 
.const [184] = Utf8 java/lang/Object 
.const [185] = Utf8 <init> 
.const [186] = Utf8 ()V 
.const [187] = Utf8 de/esolutions/fw/util/commons/os/Slayer 
.const [188] = Utf8 findMethods 
.const [189] = Utf8 ()V 
.const [190] = Utf8 java/lang/Long 
.const [191] = Utf8 <init> 
.const [192] = Utf8 (J)V 
.const [193] = Utf8 java/lang/Integer 
.const [194] = Utf8 <init> 
.const [195] = Utf8 (I)V 
.const [196] = Utf8 de/esolutions/fw/util/commons/os/Slayer 
.const [197] = Utf8 <init> 
.const [198] = Utf8 (I)V 
.const [199] = Utf8 de/esolutions/fw/util/commons/os/Slayer 
.const [200] = Utf8 killArgs 
.const [201] = Utf8 [Ljava/lang/Object; 
.const [202] = Utf8 de/esolutions/fw/util/commons/os/Slayer 
.const [203] = Utf8 osInstance 
.const [204] = Utf8 Ljava/lang/Object; 
.const [205] = Utf8 de/esolutions/fw/util/commons/os/Slayer 
.const [206] = Utf8 killMethod 
.const [207] = Utf8 Ljava/lang/reflect/Method; 
.const [208] = Utf8 de/esolutions/fw/util/commons/os/Slayer 
.const [209] = Utf8 getpidMethod 
.const [210] = Utf8 Ljava/lang/reflect/Method; 
.const [211] = Utf8 de/esolutions/fw/util/commons/os/Slayer 
.const [212] = Class [211] 
.const [213] = Utf8 java/lang/Object 
.const [214] = Class [213] 
.const [215] = Utf8 killMethod 
.const [216] = Utf8 Ljava/lang/reflect/Method; 
.const [217] = Utf8 getpidMethod 
.const [218] = Utf8 Ljava/lang/reflect/Method; 
.const [219] = Utf8 osInstance 
.const [220] = Utf8 Ljava/lang/Object; 
.const [221] = Utf8 killArgs 
.const [222] = Utf8 [Ljava/lang/Object; 
.const [223] = Utf8 Code 
.const [224] = Utf8 <init> 
.const [225] = Utf8 (I)V 
.const [226] = Utf8 <init> 
.const [227] = Utf8 ()V 
.const [228] = Utf8 findMethods 
.const [229] = Utf8 ()V 
.const [230] = Utf8 haveKillMethod 
.const [231] = Utf8 ()Z 
.const [232] = Utf8 haveGetPidMethod 
.const [233] = Utf8 ()Z 
.const [234] = Utf8 getpid 
.const [235] = Utf8 ()J 
.const [236] = Utf8 suicide 
.const [237] = Utf8 ()Z 
.const [238] = Utf8 silentSuicide 
.const [239] = Utf8 ()Z 
.end class 
