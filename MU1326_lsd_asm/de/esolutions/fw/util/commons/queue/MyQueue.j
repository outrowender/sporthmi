.version 50 0 
.class public super [193] 
.super [195] 
.field private [196] [197] 
.field private [198] [199] 
.field private [200] [201] 
.field private static [202] [203] 

.method public annotation [205] : [206] 
    .attribute [204] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [35] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [207] : [208] 
    .attribute [204] .code stack 3 locals 2 
L0:     getstatic [2] 
L3:     ldc [3] 
L5:     invokevirtual [24] 
L8:     getstatic [2] 
L11:    new [42] 
L14:    dup 
L15:    invokespecial [36] 
L18:    ldc [5] 
L20:    invokevirtual [25] 
L23:    aload_0 
L24:    getfield [26] 
L27:    invokevirtual [27] 
L30:    ldc [6] 
L32:    invokevirtual [25] 
L35:    aload_0 
L36:    getfield [28] 
L39:    invokevirtual [27] 
L42:    ldc [7] 
L44:    invokevirtual [25] 
L47:    aload_0 
L48:    getfield [29] 
L51:    invokevirtual [30] 
L54:    invokevirtual [31] 
L57:    invokevirtual [24] 
L60:    aload_0 
L61:    getfield [26] 
L64:    astore_1 
L65:    iconst_0 
L66:    istore_2 
L67:    aload_1 
L68:    ifnull L142 
L71:    getstatic [2] 
L74:    new [42] 
L77:    dup 
L78:    invokespecial [36] 
L81:    ldc [8] 
L83:    invokevirtual [25] 
L86:    iload_2 
L87:    invokevirtual [30] 
L90:    ldc [9] 
L92:    invokevirtual [25] 
L95:    aload_1 
L96:    getfield [32] 
L99:    invokevirtual [27] 
L102:   ldc [10] 
L104:   invokevirtual [25] 
L107:   aload_1 
L108:   getfield [32] 
L111:   invokespecial [37] 
L114:   invokevirtual [33] 
L117:   invokevirtual [25] 
L120:   ldc [11] 
L122:   invokevirtual [25] 
L125:   invokevirtual [31] 
L128:   invokevirtual [24] 
L131:   aload_1 
L132:   getfield [34] 
L135:   astore_1 
L136:   iinc 2 1 
L139:   goto L67 
L142:   getstatic [2] 
L145:   ldc [12] 
L147:   invokevirtual [24] 
L150:   return 
L151:   nop 
L152:   
    .end code 
.end method 

.method public [209] : [210] 
    .attribute [204] .code stack 3 locals 1 
L0:     new [47] 
L3:     dup 
L4:     aload_1 
L5:     invokespecial [38] 
L8:     astore_2 
L9:     aload_0 
L10:    getfield [28] 
L13:    ifnonnull L29 
L16:    aload_0 
L17:    aload_2 
L18:    putfield [43] 
L21:    aload_0 
L22:    aload_2 
L23:    putfield [44] 
L26:    goto L42 
L29:    aload_0 
L30:    getfield [28] 
L33:    aload_2 
L34:    putfield [46] 
L37:    aload_0 
L38:    aload_2 
L39:    putfield [44] 
L42:    aload_0 
L43:    dup 
L44:    getfield [29] 
L47:    iconst_1 
L48:    iadd 
L49:    putfield [45] 
L52:    return 
L53:    nop 
L54:    nop 
L55:    nop 
L56:    
    .end code 
.end method 

.method public [211] : [212] 
    .attribute [204] .code stack 3 locals 1 
L0:     aload_0 
L1:     getfield [26] 
L4:     ifnonnull L9 
L7:     aconst_null 
L8:     areturn 
L9:     aload_0 
L10:    getfield [26] 
L13:    getfield [32] 
L16:    astore_1 
L17:    aload_0 
L18:    dup 
L19:    getfield [29] 
L22:    iconst_1 
L23:    isub 
L24:    putfield [45] 
L27:    aload_0 
L28:    getfield [26] 
L31:    getfield [34] 
L34:    ifnonnull L55 
L37:    aload_0 
L38:    aconst_null 
L39:    putfield [43] 
L42:    aload_0 
L43:    aconst_null 
L44:    putfield [44] 
L47:    aload_0 
L48:    iconst_1 
L49:    invokespecial [39] 
L52:    goto L66 
L55:    aload_0 
L56:    aload_0 
L57:    getfield [26] 
L60:    getfield [34] 
L63:    putfield [43] 
L66:    aload_1 
L67:    areturn 
L68:    
    .end code 
.end method 

.method public [213] : [214] 
    .attribute [204] .code stack 2 locals 0 
L0:     aload_0 
L1:     iconst_0 
L2:     invokespecial [39] 
L5:     aload_0 
L6:     getfield [29] 
L9:     areturn 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [215] : [216] 
    .attribute [204] .code stack 2 locals 0 
L0:     aload_0 
L1:     iconst_0 
L2:     invokespecial [39] 
L5:     aload_0 
L6:     getfield [26] 
L9:     ifnonnull L16 
L12:    iconst_1 
L13:    goto L17 
L16:    iconst_0 
L17:    areturn 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method private [217] : [218] 
    .attribute [204] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [29] 
L4:     ifle L90 
L7:     aload_0 
L8:     getfield [26] 
L11:    ifnonnull L90 
L14:    getstatic [14] 
L17:    iconst_1 
L18:    iadd 
L19:    putstatic [40] 
L22:    getstatic [14] 
L25:    iconst_3 
L26:    if_icmpgt L71 
L29:    getstatic [2] 
L32:    new [42] 
L35:    dup 
L36:    invokespecial [36] 
L39:    ldc [15] 
L41:    invokevirtual [25] 
L44:    aload_0 
L45:    getfield [29] 
L48:    invokevirtual [30] 
L51:    ldc [16] 
L53:    invokevirtual [25] 
L56:    getstatic [14] 
L59:    invokevirtual [30] 
L62:    invokevirtual [31] 
L65:    invokevirtual [24] 
L68:    goto L85 
L71:    iload_1 
L72:    ifeq L85 
L75:    new [48] 
L78:    dup 
L79:    ldc [18] 
L81:    invokespecial [41] 
L84:    athrow 
L85:    aload_0 
L86:    iconst_0 
L87:    putfield [45] 
L90:    return 
L91:    nop 
L92:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Field [49] [50] 
.const [3] = String [51] 
.const [4] = Class [52] 
.const [5] = String [53] 
.const [6] = String [54] 
.const [7] = String [55] 
.const [8] = String [56] 
.const [9] = String [57] 
.const [10] = String [58] 
.const [11] = String [59] 
.const [12] = String [60] 
.const [13] = Class [61] 
.const [14] = Field [62] [63] 
.const [15] = String [64] 
.const [16] = String [65] 
.const [17] = Class [66] 
.const [18] = String [67] 
.const [19] = Class [68] 
.const [20] = Class [69] 
.const [21] = Class [70] 
.const [22] = Class [71] 
.const [23] = Class [72] 
.const [24] = Method [73] [74] 
.const [25] = Method [75] [76] 
.const [26] = Field [77] [78] 
.const [27] = Method [79] [80] 
.const [28] = Field [81] [82] 
.const [29] = Field [83] [84] 
.const [30] = Method [85] [86] 
.const [31] = Method [87] [88] 
.const [32] = Field [89] [90] 
.const [33] = Method [91] [92] 
.const [34] = Field [93] [94] 
.const [35] = Method [95] [96] 
.const [36] = Method [97] [98] 
.const [37] = Method [99] [100] 
.const [38] = Method [101] [102] 
.const [39] = Method [103] [104] 
.const [40] = Field [105] [106] 
.const [41] = Method [107] [108] 
.const [42] = Class [109] 
.const [43] = Field [110] [111] 
.const [44] = Field [112] [113] 
.const [45] = Field [114] [115] 
.const [46] = Field [116] [117] 
.const [47] = Class [118] 
.const [48] = Class [119] 
.const [49] = Class [120] 
.const [50] = NameAndType [121] [122] 
.const [51] = Utf8 '----- MyQueue Dump -----' 
.const [52] = Utf8 java/lang/StringBuffer 
.const [53] = Utf8 'first=' 
.const [54] = Utf8 ', last=' 
.const [55] = Utf8 ', size=' 
.const [56] = Utf8 '[#' 
.const [57] = Utf8 ':data=' 
.const [58] = Utf8 ',' 
.const [59] = Utf8 ']' 
.const [60] = Utf8 '----- Done Dump -----' 
.const [61] = Utf8 de/esolutions/fw/util/commons/queue/MyQueue$Node 
.const [62] = Class [123] 
.const [63] = NameAndType [124] [125] 
.const [64] = Utf8 '#### MyQueue is karpott: size=' 
.const [65] = Utf8 ' but first==null. counter=' 
.const [66] = Utf8 java/lang/RuntimeException 
.const [67] = Utf8 'MyQueue is karpott' 
.const [68] = Utf8 de/esolutions/fw/util/commons/queue/MyQueue 
.const [69] = Utf8 java/lang/Object 
.const [70] = Utf8 java/lang/System 
.const [71] = Utf8 java/io/PrintStream 
.const [72] = Utf8 java/lang/Class 
.const [73] = Class [126] 
.const [74] = NameAndType [127] [128] 
.const [75] = Class [129] 
.const [76] = NameAndType [130] [131] 
.const [77] = Class [132] 
.const [78] = NameAndType [133] [134] 
.const [79] = Class [135] 
.const [80] = NameAndType [136] [137] 
.const [81] = Class [138] 
.const [82] = NameAndType [139] [140] 
.const [83] = Class [141] 
.const [84] = NameAndType [142] [143] 
.const [85] = Class [144] 
.const [86] = NameAndType [145] [146] 
.const [87] = Class [147] 
.const [88] = NameAndType [148] [149] 
.const [89] = Class [150] 
.const [90] = NameAndType [151] [152] 
.const [91] = Class [153] 
.const [92] = NameAndType [154] [155] 
.const [93] = Class [156] 
.const [94] = NameAndType [157] [158] 
.const [95] = Class [159] 
.const [96] = NameAndType [160] [161] 
.const [97] = Class [162] 
.const [98] = NameAndType [163] [164] 
.const [99] = Class [165] 
.const [100] = NameAndType [166] [167] 
.const [101] = Class [168] 
.const [102] = NameAndType [169] [170] 
.const [103] = Class [171] 
.const [104] = NameAndType [172] [173] 
.const [105] = Class [174] 
.const [106] = NameAndType [175] [176] 
.const [107] = Class [177] 
.const [108] = NameAndType [178] [179] 
.const [109] = Utf8 java/lang/StringBuffer 
.const [110] = Class [180] 
.const [111] = NameAndType [181] [182] 
.const [112] = Class [183] 
.const [113] = NameAndType [184] [185] 
.const [114] = Class [186] 
.const [115] = NameAndType [187] [188] 
.const [116] = Class [189] 
.const [117] = NameAndType [190] [191] 
.const [118] = Utf8 de/esolutions/fw/util/commons/queue/MyQueue$Node 
.const [119] = Utf8 java/lang/RuntimeException 
.const [120] = Utf8 java/lang/System 
.const [121] = Utf8 out 
.const [122] = Utf8 Ljava/io/PrintStream; 
.const [123] = Utf8 de/esolutions/fw/util/commons/queue/MyQueue 
.const [124] = Utf8 karpottCounter 
.const [125] = Utf8 I 
.const [126] = Utf8 java/io/PrintStream 
.const [127] = Utf8 println 
.const [128] = Utf8 (Ljava/lang/String;)V 
.const [129] = Utf8 java/lang/StringBuffer 
.const [130] = Utf8 append 
.const [131] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [132] = Utf8 de/esolutions/fw/util/commons/queue/MyQueue 
.const [133] = Utf8 first 
.const [134] = Utf8 Lde/esolutions/fw/util/commons/queue/MyQueue$Node; 
.const [135] = Utf8 java/lang/StringBuffer 
.const [136] = Utf8 append 
.const [137] = Utf8 (Ljava/lang/Object;)Ljava/lang/StringBuffer; 
.const [138] = Utf8 de/esolutions/fw/util/commons/queue/MyQueue 
.const [139] = Utf8 last 
.const [140] = Utf8 Lde/esolutions/fw/util/commons/queue/MyQueue$Node; 
.const [141] = Utf8 de/esolutions/fw/util/commons/queue/MyQueue 
.const [142] = Utf8 size 
.const [143] = Utf8 I 
.const [144] = Utf8 java/lang/StringBuffer 
.const [145] = Utf8 append 
.const [146] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [147] = Utf8 java/lang/StringBuffer 
.const [148] = Utf8 toString 
.const [149] = Utf8 ()Ljava/lang/String; 
.const [150] = Utf8 de/esolutions/fw/util/commons/queue/MyQueue$Node 
.const [151] = Utf8 data 
.const [152] = Utf8 Ljava/lang/Object; 
.const [153] = Utf8 java/lang/Class 
.const [154] = Utf8 getName 
.const [155] = Utf8 ()Ljava/lang/String; 
.const [156] = Utf8 de/esolutions/fw/util/commons/queue/MyQueue$Node 
.const [157] = Utf8 next 
.const [158] = Utf8 Lde/esolutions/fw/util/commons/queue/MyQueue$Node; 
.const [159] = Utf8 java/lang/Object 
.const [160] = Utf8 <init> 
.const [161] = Utf8 ()V 
.const [162] = Utf8 java/lang/StringBuffer 
.const [163] = Utf8 <init> 
.const [164] = Utf8 ()V 
.const [165] = Utf8 java/lang/Object 
.const [166] = Utf8 getClass 
.const [167] = Utf8 ()Ljava/lang/Class; 
.const [168] = Utf8 de/esolutions/fw/util/commons/queue/MyQueue$Node 
.const [169] = Utf8 <init> 
.const [170] = Utf8 (Ljava/lang/Object;)V 
.const [171] = Utf8 de/esolutions/fw/util/commons/queue/MyQueue 
.const [172] = Utf8 sanityCheck 
.const [173] = Utf8 (Z)V 
.const [174] = Utf8 de/esolutions/fw/util/commons/queue/MyQueue 
.const [175] = Utf8 karpottCounter 
.const [176] = Utf8 I 
.const [177] = Utf8 java/lang/RuntimeException 
.const [178] = Utf8 <init> 
.const [179] = Utf8 (Ljava/lang/String;)V 
.const [180] = Utf8 de/esolutions/fw/util/commons/queue/MyQueue 
.const [181] = Utf8 first 
.const [182] = Utf8 Lde/esolutions/fw/util/commons/queue/MyQueue$Node; 
.const [183] = Utf8 de/esolutions/fw/util/commons/queue/MyQueue 
.const [184] = Utf8 last 
.const [185] = Utf8 Lde/esolutions/fw/util/commons/queue/MyQueue$Node; 
.const [186] = Utf8 de/esolutions/fw/util/commons/queue/MyQueue 
.const [187] = Utf8 size 
.const [188] = Utf8 I 
.const [189] = Utf8 de/esolutions/fw/util/commons/queue/MyQueue$Node 
.const [190] = Utf8 next 
.const [191] = Utf8 Lde/esolutions/fw/util/commons/queue/MyQueue$Node; 
.const [192] = Utf8 de/esolutions/fw/util/commons/queue/MyQueue 
.const [193] = Class [192] 
.const [194] = Utf8 java/lang/Object 
.const [195] = Class [194] 
.const [196] = Utf8 first 
.const [197] = Utf8 Lde/esolutions/fw/util/commons/queue/MyQueue$Node; 
.const [198] = Utf8 last 
.const [199] = Utf8 Lde/esolutions/fw/util/commons/queue/MyQueue$Node; 
.const [200] = Utf8 size 
.const [201] = Utf8 I 
.const [202] = Utf8 karpottCounter 
.const [203] = Utf8 I 
.const [204] = Utf8 Code 
.const [205] = Utf8 <init> 
.const [206] = Utf8 ()V 
.const [207] = Utf8 dump 
.const [208] = Utf8 ()V 
.const [209] = Utf8 push 
.const [210] = Utf8 (Ljava/lang/Object;)V 
.const [211] = Utf8 pop 
.const [212] = Utf8 ()Ljava/lang/Object; 
.const [213] = Utf8 size 
.const [214] = Utf8 ()I 
.const [215] = Utf8 isEmpty 
.const [216] = Utf8 ()Z 
.const [217] = Utf8 sanityCheck 
.const [218] = Utf8 (Z)V 
.end class 
