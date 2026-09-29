.version 50 0 
.class public super [202] 
.super [204] 
.implements [206] 
.implements [208] 
.field [209] [210] 
.field [211] [212] 

.method public [214] : [215] 
    .attribute [213] .code stack 4 locals 0 
L0:     aload_0 
L1:     invokespecial [39] 
L4:     aload_0 
L5:     new [46] 
L8:     dup 
L9:     ldc [3] 
L11:    invokespecial [40] 
L14:    putfield [47] 
L17:    return 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method private [216] : [217] 
    .attribute [213] .code stack 7 locals 2 
L0:     lload_1 
L1:     lconst_0 
L2:     lcmp 
L3:     ifne L11 
L6:     lconst_0 
L7:     lstore_3 
L8:     goto L21 
L11:    lload_1 
L12:    aload_0 
L13:    lload_1 
L14:    lconst_1 
L15:    lsub 
L16:    invokespecial [41] 
L19:    ladd 
L20:    lstore_3 
L21:    lload_3 
L22:    freturn 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [218] : [219] 
    .attribute [213] .code stack 6 locals 8 
L0:     getstatic [4] 
L3:     ldc [5] 
L5:     invokevirtual [27] 
L8:     aconst_null 
L9:     astore_1 
L10:    aload_0 
L11:    getfield [28] 
L14:    ifeq L34 
L17:    new [49] 
L20:    dup 
L21:    invokespecial [42] 
L24:    astore_1 
L25:    aload_1 
L26:    invokevirtual [29] 
L29:    ifne L34 
L32:    aconst_null 
L33:    astore_1 
L34:    iconst_1 
L35:    istore_2 
L36:    iload_2 
L37:    i2l 
L38:    ldc_w [1] 
L41:    lcmp 
L42:    ifge L130 
L45:    invokestatic [7] 
L48:    lstore 5 
L50:    aload_1 
L51:    ifnull L64 
L54:    aload_1 
L55:    iload_2 
L56:    i2l 
L57:    invokevirtual [30] 
L60:    lstore_3 
L61:    goto L71 
L64:    aload_0 
L65:    iload_2 
L66:    i2l 
L67:    invokespecial [41] 
L70:    lstore_3 
L71:    invokestatic [7] 
L74:    lstore 7 
L76:    getstatic [4] 
L79:    new [50] 
L82:    dup 
L83:    invokespecial [43] 
L86:    ldc [9] 
L88:    invokevirtual [31] 
L91:    iload_2 
L92:    invokevirtual [32] 
L95:    ldc [10] 
L97:    invokevirtual [31] 
L100:   lload_3 
L101:   invokevirtual [33] 
L104:   ldc [11] 
L106:   invokevirtual [31] 
L109:   lload 7 
L111:   lload 5 
L113:   lsub 
L114:   invokevirtual [33] 
L117:   invokevirtual [34] 
L120:   invokevirtual [27] 
L123:   iload_2 
L124:   iconst_2 
L125:   imul 
L126:   istore_2 
L127:   goto L36 
L130:   return 
L131:   nop 
L132:   
    .end code 
.end method 

.method public [220] : [221] 
    .attribute [213] .code stack 4 locals 2 
L0:     aload_0 
L1:     getfield [26] 
L4:     iconst_4 
L5:     ldc [12] 
L7:     invokevirtual [35] 
L10:    pop 
L11:    new [51] 
L14:    dup 
L15:    aload_0 
L16:    ldc [14] 
L18:    invokespecial [44] 
L21:    astore_3 
L22:    aload_2 
L23:    ifnull L90 
        .catch [21] from L26 to L85 using L88 
L26:    new [52] 
L29:    dup 
L30:    aload_2 
L31:    ldc [16] 
L33:    invokespecial [45] 
L36:    astore 4 
L38:    aload 4 
L40:    ldc [17] 
L42:    invokevirtual [36] 
L45:    ifeq L62 
L48:    aload_3 
L49:    bipush 10 
L51:    invokevirtual [37] 
L54:    getstatic [4] 
L57:    ldc [18] 
L59:    invokevirtual [27] 
L62:    aload 4 
L64:    ldc [19] 
L66:    invokevirtual [36] 
L69:    ifeq L85 
L72:    aload_0 
L73:    iconst_1 
L74:    putfield [48] 
L77:    getstatic [4] 
L80:    ldc [20] 
L82:    invokevirtual [27] 
L85:    goto L90 
L88:    astore 4 
L90:    aload_3 
L91:    invokevirtual [38] 
L94:    return 
L95:    nop 
L96:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [54] 
.const [3] = String [55] 
.const [4] = Field [56] [57] 
.const [5] = String [58] 
.const [6] = Class [59] 
.const [7] = Method [60] [61] 
.const [8] = Class [62] 
.const [9] = String [63] 
.const [10] = String [64] 
.const [11] = String [65] 
.const [12] = String [66] 
.const [13] = Class [67] 
.const [14] = String [68] 
.const [15] = Class [69] 
.const [16] = String [70] 
.const [17] = String [71] 
.const [18] = String [72] 
.const [19] = String [73] 
.const [20] = String [74] 
.const [21] = Class [75] 
.const [22] = Class [76] 
.const [23] = Class [77] 
.const [24] = Class [78] 
.const [25] = Class [79] 
.const [26] = Field [80] [81] 
.const [27] = Method [82] [83] 
.const [28] = Field [84] [85] 
.const [29] = Method [86] [87] 
.const [30] = Method [88] [89] 
.const [31] = Method [90] [91] 
.const [32] = Method [92] [93] 
.const [33] = Method [94] [95] 
.const [34] = Method [96] [97] 
.const [35] = Method [98] [99] 
.const [36] = Method [100] [101] 
.const [37] = Method [102] [103] 
.const [38] = Method [104] [105] 
.const [39] = Method [106] [107] 
.const [40] = Method [108] [109] 
.const [41] = Method [110] [111] 
.const [42] = Method [112] [113] 
.const [43] = Method [114] [115] 
.const [44] = Method [116] [117] 
.const [45] = Method [118] [119] 
.const [46] = Class [120] 
.const [47] = Field [121] [122] 
.const [48] = Field [123] [124] 
.const [49] = Class [125] 
.const [50] = Class [126] 
.const [51] = Class [127] 
.const [52] = Class [128] 
.const [53] = Int 1078071040 
.const [54] = Utf8 de/esolutions/fw/util/tracing/TraceChannel 
.const [55] = Utf8 'fw.util.test' 
.const [56] = Class [129] 
.const [57] = NameAndType [130] [131] 
.const [58] = Utf8 '---------- RECURSE ERROR TEST STARTED ----------' 
.const [59] = Utf8 de/esolutions/fw/util/commons/os/OSCalls 
.const [60] = Class [132] 
.const [61] = NameAndType [133] [134] 
.const [62] = Utf8 java/lang/StringBuffer 
.const [63] = Utf8 'sum: s(' 
.const [64] = Utf8 ')=' 
.const [65] = Utf8 ', delta=' 
.const [66] = Utf8 'Trigger endless recursion to test VM!' 
.const [67] = Utf8 java/lang/Thread 
.const [68] = Utf8 RecurseEndless 
.const [69] = Utf8 java/lang/String 
.const [70] = Utf8 UTF-8 
.const [71] = Utf8 max 
.const [72] = Utf8 '---------- RECURSE ERROR MAX PRIO ----------' 
.const [73] = Utf8 'native' 
.const [74] = Utf8 '---------- RECURSE NATIVE ----------' 
.const [75] = Utf8 java/lang/Exception 
.const [76] = Utf8 de/esolutions/fw/util/services/RecurseErrorTestCallback 
.const [77] = Utf8 java/lang/Object 
.const [78] = Utf8 java/lang/System 
.const [79] = Utf8 java/io/PrintStream 
.const [80] = Class [135] 
.const [81] = NameAndType [136] [137] 
.const [82] = Class [138] 
.const [83] = NameAndType [139] [140] 
.const [84] = Class [141] 
.const [85] = NameAndType [142] [143] 
.const [86] = Class [144] 
.const [87] = NameAndType [145] [146] 
.const [88] = Class [147] 
.const [89] = NameAndType [148] [149] 
.const [90] = Class [150] 
.const [91] = NameAndType [151] [152] 
.const [92] = Class [153] 
.const [93] = NameAndType [154] [155] 
.const [94] = Class [156] 
.const [95] = NameAndType [157] [158] 
.const [96] = Class [159] 
.const [97] = NameAndType [160] [161] 
.const [98] = Class [162] 
.const [99] = NameAndType [163] [164] 
.const [100] = Class [165] 
.const [101] = NameAndType [166] [167] 
.const [102] = Class [168] 
.const [103] = NameAndType [169] [170] 
.const [104] = Class [171] 
.const [105] = NameAndType [172] [173] 
.const [106] = Class [174] 
.const [107] = NameAndType [175] [176] 
.const [108] = Class [177] 
.const [109] = NameAndType [178] [179] 
.const [110] = Class [180] 
.const [111] = NameAndType [181] [182] 
.const [112] = Class [183] 
.const [113] = NameAndType [184] [185] 
.const [114] = Class [186] 
.const [115] = NameAndType [187] [188] 
.const [116] = Class [189] 
.const [117] = NameAndType [190] [191] 
.const [118] = Class [192] 
.const [119] = NameAndType [193] [194] 
.const [120] = Utf8 de/esolutions/fw/util/tracing/TraceChannel 
.const [121] = Class [195] 
.const [122] = NameAndType [196] [197] 
.const [123] = Class [198] 
.const [124] = NameAndType [199] [200] 
.const [125] = Utf8 de/esolutions/fw/util/commons/os/OSCalls 
.const [126] = Utf8 java/lang/StringBuffer 
.const [127] = Utf8 java/lang/Thread 
.const [128] = Utf8 java/lang/String 
.const [129] = Utf8 java/lang/System 
.const [130] = Utf8 out 
.const [131] = Utf8 Ljava/io/PrintStream; 
.const [132] = Utf8 java/lang/System 
.const [133] = Utf8 currentTimeMillis 
.const [134] = Utf8 ()J 
.const [135] = Utf8 de/esolutions/fw/util/services/RecurseErrorTestCallback 
.const [136] = Utf8 tc 
.const [137] = Utf8 Lde/esolutions/fw/util/tracing/TraceChannel; 
.const [138] = Utf8 java/io/PrintStream 
.const [139] = Utf8 println 
.const [140] = Utf8 (Ljava/lang/String;)V 
.const [141] = Utf8 de/esolutions/fw/util/services/RecurseErrorTestCallback 
.const [142] = Utf8 use_native 
.const [143] = Utf8 Z 
.const [144] = Utf8 de/esolutions/fw/util/commons/os/OSCalls 
.const [145] = Utf8 hasSum 
.const [146] = Utf8 ()Z 
.const [147] = Utf8 de/esolutions/fw/util/commons/os/OSCalls 
.const [148] = Utf8 sum 
.const [149] = Utf8 (J)J 
.const [150] = Utf8 java/lang/StringBuffer 
.const [151] = Utf8 append 
.const [152] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [153] = Utf8 java/lang/StringBuffer 
.const [154] = Utf8 append 
.const [155] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [156] = Utf8 java/lang/StringBuffer 
.const [157] = Utf8 append 
.const [158] = Utf8 (J)Ljava/lang/StringBuffer; 
.const [159] = Utf8 java/lang/StringBuffer 
.const [160] = Utf8 toString 
.const [161] = Utf8 ()Ljava/lang/String; 
.const [162] = Utf8 de/esolutions/fw/util/tracing/TraceChannel 
.const [163] = Utf8 log 
.const [164] = Utf8 (SLjava/lang/String;)Z 
.const [165] = Utf8 java/lang/String 
.const [166] = Utf8 equals 
.const [167] = Utf8 (Ljava/lang/Object;)Z 
.const [168] = Utf8 java/lang/Thread 
.const [169] = Utf8 setPriority 
.const [170] = Utf8 (I)V 
.const [171] = Utf8 java/lang/Thread 
.const [172] = Utf8 start 
.const [173] = Utf8 ()V 
.const [174] = Utf8 java/lang/Object 
.const [175] = Utf8 <init> 
.const [176] = Utf8 ()V 
.const [177] = Utf8 de/esolutions/fw/util/tracing/TraceChannel 
.const [178] = Utf8 <init> 
.const [179] = Utf8 (Ljava/lang/String;)V 
.const [180] = Utf8 de/esolutions/fw/util/services/RecurseErrorTestCallback 
.const [181] = Utf8 sum 
.const [182] = Utf8 (J)J 
.const [183] = Utf8 de/esolutions/fw/util/commons/os/OSCalls 
.const [184] = Utf8 <init> 
.const [185] = Utf8 ()V 
.const [186] = Utf8 java/lang/StringBuffer 
.const [187] = Utf8 <init> 
.const [188] = Utf8 ()V 
.const [189] = Utf8 java/lang/Thread 
.const [190] = Utf8 <init> 
.const [191] = Utf8 (Ljava/lang/Runnable;Ljava/lang/String;)V 
.const [192] = Utf8 java/lang/String 
.const [193] = Utf8 <init> 
.const [194] = Utf8 ([BLjava/lang/String;)V 
.const [195] = Utf8 de/esolutions/fw/util/services/RecurseErrorTestCallback 
.const [196] = Utf8 tc 
.const [197] = Utf8 Lde/esolutions/fw/util/tracing/TraceChannel; 
.const [198] = Utf8 de/esolutions/fw/util/services/RecurseErrorTestCallback 
.const [199] = Utf8 use_native 
.const [200] = Utf8 Z 
.const [201] = Utf8 de/esolutions/fw/util/services/RecurseErrorTestCallback 
.const [202] = Class [201] 
.const [203] = Utf8 java/lang/Object 
.const [204] = Class [203] 
.const [205] = Utf8 de/esolutions/fw/util/tracing/ITraceCallback 
.const [206] = Class [205] 
.const [207] = Utf8 java/lang/Runnable 
.const [208] = Class [207] 
.const [209] = Utf8 tc 
.const [210] = Utf8 Lde/esolutions/fw/util/tracing/TraceChannel; 
.const [211] = Utf8 use_native 
.const [212] = Utf8 Z 
.const [213] = Utf8 Code 
.const [214] = Utf8 <init> 
.const [215] = Utf8 ()V 
.const [216] = Utf8 sum 
.const [217] = Utf8 (J)J 
.const [218] = Utf8 run 
.const [219] = Utf8 ()V 
.const [220] = Utf8 executeTraceCallback 
.const [221] = Utf8 (I[B)V 
.end class 
