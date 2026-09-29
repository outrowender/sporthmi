.version 50 0 
.class public super [194] 
.super [196] 
.field private static final [197] [198] 
.field private static final [199] [200] 
.field private static final [201] [202] 
.field private static final [203] [204] 
.field private static final [205] [206] 
.field private static final [207] [208] 

.method public annotation [210] : [211] 
    .attribute [209] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [42] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method private static [212] : [213] 
    .attribute [209] .code stack 4 locals 0 
L0:     iload_0 
L1:     tableswitch -5 
            L83 
            L73 
            L63 
            L53 
            L43 
            L40 
            default : L93 

L40:    goto L120 
L43:    new [46] 
L46:    dup 
L47:    ldc [3] 
L49:    invokespecial [43] 
L52:    athrow 
L53:    new [46] 
L56:    dup 
L57:    ldc [4] 
L59:    invokespecial [43] 
L62:    athrow 
L63:    new [46] 
L66:    dup 
L67:    ldc [5] 
L69:    invokespecial [43] 
L72:    athrow 
L73:    new [46] 
L76:    dup 
L77:    ldc [6] 
L79:    invokespecial [43] 
L82:    athrow 
L83:    new [46] 
L86:    dup 
L87:    ldc [7] 
L89:    invokespecial [43] 
L92:    athrow 
L93:    new [46] 
L96:    dup 
L97:    new [47] 
L100:   dup 
L101:   invokespecial [44] 
L104:   ldc [9] 
L106:   invokevirtual [36] 
L109:   iload_0 
L110:   invokevirtual [37] 
L113:   invokevirtual [38] 
L116:   invokespecial [43] 
L119:   athrow 
L120:   return 
L121:   nop 
L122:   nop 
L123:   nop 
L124:   
    .end code 
.end method 

.method public static [214] : [215] 
    .attribute [209] .code stack 1 locals 1 
L0:     ldc [10] 
L2:     invokestatic [11] 
L5:     invokestatic [12] 
L8:     istore_0 
L9:     iload_0 
L10:    invokestatic [13] 
L13:    return 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public static [216] : [217] 
    .attribute [209] .code stack 0 locals 0 
L0:     invokestatic [14] 
L3:     return 
L4:     
    .end code 
.end method 

.method public static [218] : [219] 
    .attribute [209] .code stack 5 locals 4 
L0:     iconst_2 
L1:     newarray int 
L3:     astore 4 
L5:     lload_0 
L6:     aload 4 
L8:     invokestatic [15] 
L11:    istore 5 
L13:    iload 5 
L15:    invokestatic [13] 
L18:    aload 4 
L20:    iconst_0 
L21:    iaload 
L22:    ifne L34 
L25:    aload 4 
L27:    iconst_1 
L28:    iaload 
L29:    ifne L34 
L32:    aconst_null 
L33:    areturn 
L34:    aload 4 
L36:    iconst_0 
L37:    iaload 
L38:    aload 4 
L40:    iconst_1 
L41:    iaload 
L42:    imul 
L43:    iconst_4 
L44:    imul 
L45:    invokestatic [16] 
L48:    astore 6 
L50:    lload_0 
L51:    aload 6 
L53:    lload_2 
L54:    invokestatic [17] 
L57:    istore 5 
L59:    iload 5 
L61:    invokestatic [13] 
L64:    new [48] 
L67:    dup 
L68:    aload 4 
L70:    iconst_0 
L71:    iaload 
L72:    aload 4 
L74:    iconst_1 
L75:    iaload 
L76:    aload 6 
L78:    invokespecial [45] 
L81:    astore 7 
L83:    aload 7 
L85:    areturn 
L86:    nop 
L87:    nop 
L88:    
    .end code 
.end method 

.method public static [220] : [221] 
    .attribute [209] .code stack 4 locals 0 
L0:     lload_0 
L1:     ldc_w [1] 
L4:     invokestatic [19] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public static [222] : [223] 
    .attribute [209] .code stack 5 locals 4 
L0:     aload_0 
L1:     ifnonnull L14 
L4:     new [46] 
L7:     dup 
L8:     ldc [20] 
L10:    invokespecial [43] 
L13:    athrow 
L14:    iconst_2 
L15:    newarray int 
L17:    astore_3 
L18:    aload_0 
L19:    aload_3 
L20:    invokestatic [21] 
L23:    istore 4 
L25:    iload 4 
L27:    invokestatic [13] 
L30:    aload_3 
L31:    iconst_0 
L32:    iaload 
L33:    ifne L44 
L36:    aload_3 
L37:    iconst_1 
L38:    iaload 
L39:    ifne L44 
L42:    aconst_null 
L43:    areturn 
L44:    aload_3 
L45:    iconst_0 
L46:    iaload 
L47:    aload_3 
L48:    iconst_1 
L49:    iaload 
L50:    imul 
L51:    iconst_4 
L52:    imul 
L53:    invokestatic [16] 
L56:    astore 5 
L58:    aload_0 
L59:    aload 5 
L61:    lload_1 
L62:    invokestatic [22] 
L65:    istore 4 
L67:    iload 4 
L69:    invokestatic [13] 
L72:    new [48] 
L75:    dup 
L76:    aload_3 
L77:    iconst_0 
L78:    iaload 
L79:    aload_3 
L80:    iconst_1 
L81:    iaload 
L82:    aload 5 
L84:    invokespecial [45] 
L87:    astore 6 
L89:    aload 6 
L91:    areturn 
L92:    
    .end code 
.end method 

.method public static [224] : [225] 
    .attribute [209] .code stack 3 locals 0 
L0:     aload_0 
L1:     ldc_w [1] 
L4:     invokestatic [23] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method private static native [226] : [227] 
    .attribute [209] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method private static native [228] : [229] 
    .attribute [209] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method private static native [230] : [231] 
    .attribute [209] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method private static native [232] : [233] 
    .attribute [209] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method private static native [234] : [235] 
    .attribute [209] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method private static native [236] : [237] 
    .attribute [209] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method public static [238] : [239] 
    .attribute [209] .code stack 4 locals 1 
L0:     getstatic [24] 
L3:     ldc [25] 
L5:     invokevirtual [39] 
L8:     invokestatic [26] 
L11:    lconst_1 
L12:    ldc_w [1] 
L15:    invokestatic [19] 
L18:    astore_1 
L19:    aload_1 
L20:    ifnonnull L34 
L23:    getstatic [24] 
L26:    ldc [27] 
L28:    invokevirtual [39] 
L31:    goto L74 
L34:    getstatic [24] 
L37:    new [47] 
L40:    dup 
L41:    invokespecial [44] 
L44:    ldc [28] 
L46:    invokevirtual [36] 
L49:    aload_1 
L50:    invokevirtual [40] 
L53:    invokevirtual [37] 
L56:    ldc [29] 
L58:    invokevirtual [36] 
L61:    aload_1 
L62:    invokevirtual [41] 
L65:    invokevirtual [37] 
L68:    invokevirtual [38] 
L71:    invokevirtual [39] 
L74:    invokestatic [30] 
L77:    return 
L78:    nop 
L79:    nop 
L80:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [50] 
.const [3] = String [51] 
.const [4] = String [52] 
.const [5] = String [53] 
.const [6] = String [54] 
.const [7] = String [55] 
.const [8] = Class [56] 
.const [9] = String [57] 
.const [10] = String [58] 
.const [11] = Method [59] [60] 
.const [12] = Method [61] [62] 
.const [13] = Method [63] [64] 
.const [14] = Method [65] [66] 
.const [15] = Method [67] [68] 
.const [16] = Method [69] [70] 
.const [17] = Method [71] [72] 
.const [18] = Class [73] 
.const [19] = Method [74] [75] 
.const [20] = String [76] 
.const [21] = Method [77] [78] 
.const [22] = Method [79] [80] 
.const [23] = Method [81] [82] 
.const [24] = Field [83] [84] 
.const [25] = String [85] 
.const [26] = Method [86] [87] 
.const [27] = String [88] 
.const [28] = String [89] 
.const [29] = String [90] 
.const [30] = Method [91] [92] 
.const [31] = Class [93] 
.const [32] = Class [94] 
.const [33] = Class [95] 
.const [34] = Class [96] 
.const [35] = Class [97] 
.const [36] = Method [98] [99] 
.const [37] = Method [100] [101] 
.const [38] = Method [102] [103] 
.const [39] = Method [104] [105] 
.const [40] = Method [106] [107] 
.const [41] = Method [108] [109] 
.const [42] = Method [110] [111] 
.const [43] = Method [112] [113] 
.const [44] = Method [114] [115] 
.const [45] = Method [116] [117] 
.const [46] = Class [118] 
.const [47] = Class [119] 
.const [48] = Class [120] 
.const [49] = Int -402456576 
.const [50] = Utf8 java/lang/RuntimeException 
.const [51] = Utf8 'Native part of iconextractor could not be loaded. Check presence of libstyledbservice.so and its dependencies!' 
.const [52] = Utf8 'Native part of iconextractor was found, but methods could not be resolved. This is very unlikely to happen unless someone messed up the system or iconextracor interface was changed.' 
.const [53] = Utf8 "Framework initialization failed! Check that a valid framework.json is reachable via IPL_CONFIG_DIR, that process name 'styledbservice' is configured there and that the broker is running." 
.const [54] = Utf8 'Image with specified id not found. This can have a lot of reasons. First, please check if a COMM connection to navigation process is working. If it is, please make sure that navigation really has an image with the requested id.' 
.const [55] = Utf8 'Well, something went terribly wrong in internal JNI communication. This is either an out-of-memory situation or a mismatch between java and native parts of iconextractor.' 
.const [56] = Utf8 java/lang/StringBuffer 
.const [57] = Utf8 'WTF: unhandled exception id ' 
.const [58] = Utf8 styledbservice 
.const [59] = Class [121] 
.const [60] = NameAndType [122] [123] 
.const [61] = Class [124] 
.const [62] = NameAndType [125] [126] 
.const [63] = Class [127] 
.const [64] = NameAndType [128] [129] 
.const [65] = Class [130] 
.const [66] = NameAndType [131] [132] 
.const [67] = Class [133] 
.const [68] = NameAndType [134] [135] 
.const [69] = Class [136] 
.const [70] = NameAndType [137] [138] 
.const [71] = Class [139] 
.const [72] = NameAndType [140] [141] 
.const [73] = Utf8 de/eso/IconExtractor/IconExtractor$Bitmap 
.const [74] = Class [142] 
.const [75] = NameAndType [143] [144] 
.const [76] = Utf8 'String id is null!' 
.const [77] = Class [145] 
.const [78] = NameAndType [146] [147] 
.const [79] = Class [148] 
.const [80] = NameAndType [149] [150] 
.const [81] = Class [151] 
.const [82] = NameAndType [152] [153] 
.const [83] = Class [154] 
.const [84] = NameAndType [155] [156] 
.const [85] = Utf8 'This is a iconextractor standalone test' 
.const [86] = Class [157] 
.const [87] = NameAndType [158] [159] 
.const [88] = Utf8 'No bitmap found' 
.const [89] = Utf8 'IconExtractor got bitmap of size ' 
.const [90] = Utf8 x 
.const [91] = Class [160] 
.const [92] = NameAndType [161] [162] 
.const [93] = Utf8 de/eso/IconExtractor/IconExtractor 
.const [94] = Utf8 java/lang/Object 
.const [95] = Utf8 java/lang/System 
.const [96] = Utf8 java/nio/ByteBuffer 
.const [97] = Utf8 java/io/PrintStream 
.const [98] = Class [163] 
.const [99] = NameAndType [164] [165] 
.const [100] = Class [166] 
.const [101] = NameAndType [167] [168] 
.const [102] = Class [169] 
.const [103] = NameAndType [170] [171] 
.const [104] = Class [172] 
.const [105] = NameAndType [173] [174] 
.const [106] = Class [175] 
.const [107] = NameAndType [176] [177] 
.const [108] = Class [178] 
.const [109] = NameAndType [179] [180] 
.const [110] = Class [181] 
.const [111] = NameAndType [182] [183] 
.const [112] = Class [184] 
.const [113] = NameAndType [185] [186] 
.const [114] = Class [187] 
.const [115] = NameAndType [188] [189] 
.const [116] = Class [190] 
.const [117] = NameAndType [191] [192] 
.const [118] = Utf8 java/lang/RuntimeException 
.const [119] = Utf8 java/lang/StringBuffer 
.const [120] = Utf8 de/eso/IconExtractor/IconExtractor$Bitmap 
.const [121] = Utf8 java/lang/System 
.const [122] = Utf8 loadLibrary 
.const [123] = Utf8 (Ljava/lang/String;)V 
.const [124] = Utf8 de/eso/IconExtractor/IconExtractor 
.const [125] = Utf8 initializeIE 
.const [126] = Utf8 ()I 
.const [127] = Utf8 de/eso/IconExtractor/IconExtractor 
.const [128] = Utf8 explainError 
.const [129] = Utf8 (I)V 
.const [130] = Utf8 de/eso/IconExtractor/IconExtractor 
.const [131] = Utf8 shutdownIE 
.const [132] = Utf8 ()V 
.const [133] = Utf8 de/eso/IconExtractor/IconExtractor 
.const [134] = Utf8 getSize 
.const [135] = Utf8 (J[I)I 
.const [136] = Utf8 java/nio/ByteBuffer 
.const [137] = Utf8 allocateDirect 
.const [138] = Utf8 (I)Ljava/nio/ByteBuffer; 
.const [139] = Utf8 de/eso/IconExtractor/IconExtractor 
.const [140] = Utf8 getData 
.const [141] = Utf8 (JLjava/nio/ByteBuffer;J)I 
.const [142] = Utf8 de/eso/IconExtractor/IconExtractor 
.const [143] = Utf8 getImage 
.const [144] = Utf8 (JJ)Lde/eso/IconExtractor/IconExtractor$Bitmap; 
.const [145] = Utf8 de/eso/IconExtractor/IconExtractor 
.const [146] = Utf8 getSizeStr 
.const [147] = Utf8 (Ljava/lang/String;[I)I 
.const [148] = Utf8 de/eso/IconExtractor/IconExtractor 
.const [149] = Utf8 getDataStr 
.const [150] = Utf8 (Ljava/lang/String;Ljava/nio/ByteBuffer;J)I 
.const [151] = Utf8 de/eso/IconExtractor/IconExtractor 
.const [152] = Utf8 getImage 
.const [153] = Utf8 (Ljava/lang/String;J)Lde/eso/IconExtractor/IconExtractor$Bitmap; 
.const [154] = Utf8 java/lang/System 
.const [155] = Utf8 out 
.const [156] = Utf8 Ljava/io/PrintStream; 
.const [157] = Utf8 de/eso/IconExtractor/IconExtractor 
.const [158] = Utf8 initialize 
.const [159] = Utf8 ()V 
.const [160] = Utf8 de/eso/IconExtractor/IconExtractor 
.const [161] = Utf8 shutdown 
.const [162] = Utf8 ()V 
.const [163] = Utf8 java/lang/StringBuffer 
.const [164] = Utf8 append 
.const [165] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [166] = Utf8 java/lang/StringBuffer 
.const [167] = Utf8 append 
.const [168] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [169] = Utf8 java/lang/StringBuffer 
.const [170] = Utf8 toString 
.const [171] = Utf8 ()Ljava/lang/String; 
.const [172] = Utf8 java/io/PrintStream 
.const [173] = Utf8 println 
.const [174] = Utf8 (Ljava/lang/String;)V 
.const [175] = Utf8 de/eso/IconExtractor/IconExtractor$Bitmap 
.const [176] = Utf8 getWidth 
.const [177] = Utf8 ()I 
.const [178] = Utf8 de/eso/IconExtractor/IconExtractor$Bitmap 
.const [179] = Utf8 getHeight 
.const [180] = Utf8 ()I 
.const [181] = Utf8 java/lang/Object 
.const [182] = Utf8 <init> 
.const [183] = Utf8 ()V 
.const [184] = Utf8 java/lang/RuntimeException 
.const [185] = Utf8 <init> 
.const [186] = Utf8 (Ljava/lang/String;)V 
.const [187] = Utf8 java/lang/StringBuffer 
.const [188] = Utf8 <init> 
.const [189] = Utf8 ()V 
.const [190] = Utf8 de/eso/IconExtractor/IconExtractor$Bitmap 
.const [191] = Utf8 <init> 
.const [192] = Utf8 (IILjava/nio/ByteBuffer;)V 
.const [193] = Utf8 de/eso/IconExtractor/IconExtractor 
.const [194] = Class [193] 
.const [195] = Utf8 java/lang/Object 
.const [196] = Class [195] 
.const [197] = Utf8 NO_ERROR 
.const [198] = Utf8 I 
.const [199] = Utf8 NATIVE_ICONEXTRACTOR_NOT_FOUND 
.const [200] = Utf8 I 
.const [201] = Utf8 FUNCTION_RESOLUTION_FAILED 
.const [202] = Utf8 I 
.const [203] = Utf8 FRAMEWORK_INIT_FAILED 
.const [204] = Utf8 I 
.const [205] = Utf8 IMAGE_NOT_FOUND 
.const [206] = Utf8 I 
.const [207] = Utf8 JNI_ERROR 
.const [208] = Utf8 I 
.const [209] = Utf8 Code 
.const [210] = Utf8 <init> 
.const [211] = Utf8 ()V 
.const [212] = Utf8 explainError 
.const [213] = Utf8 (I)V 
.const [214] = Utf8 initialize 
.const [215] = Utf8 ()V 
.const [216] = Utf8 shutdown 
.const [217] = Utf8 ()V 
.const [218] = Utf8 getImage 
.const [219] = Utf8 (JJ)Lde/eso/IconExtractor/IconExtractor$Bitmap; 
.const [220] = Utf8 getImage 
.const [221] = Utf8 (J)Lde/eso/IconExtractor/IconExtractor$Bitmap; 
.const [222] = Utf8 getImage 
.const [223] = Utf8 (Ljava/lang/String;J)Lde/eso/IconExtractor/IconExtractor$Bitmap; 
.const [224] = Utf8 getImage 
.const [225] = Utf8 (Ljava/lang/String;)Lde/eso/IconExtractor/IconExtractor$Bitmap; 
.const [226] = Utf8 initializeIE 
.const [227] = Utf8 ()I 
.const [228] = Utf8 shutdownIE 
.const [229] = Utf8 ()V 
.const [230] = Utf8 getSize 
.const [231] = Utf8 (J[I)I 
.const [232] = Utf8 getData 
.const [233] = Utf8 (JLjava/nio/ByteBuffer;J)I 
.const [234] = Utf8 getSizeStr 
.const [235] = Utf8 (Ljava/lang/String;[I)I 
.const [236] = Utf8 getDataStr 
.const [237] = Utf8 (Ljava/lang/String;Ljava/nio/ByteBuffer;J)I 
.const [238] = Utf8 main 
.const [239] = Utf8 ([Ljava/lang/String;)V 
.end class 
