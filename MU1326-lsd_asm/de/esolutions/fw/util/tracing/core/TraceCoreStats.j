.version 50 0 
.class public super [173] 
.super [175] 
.field private final [176] [177] 
.field private final [178] [179] 
.field private [180] [181] 
.field public static final [182] [183] 
.field public static final [184] [185] 
.field public static final [186] [187] 
.field public static final [188] [189] 
.field public static final [190] [191] 

.method public [193] : [194] 
    .attribute [192] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [27] 
L4:     aload_0 
L5:     new [32] 
L8:     dup 
L9:     invokespecial [28] 
L12:    putfield [33] 
L15:    aload_0 
L16:    new [34] 
L19:    dup 
L20:    invokespecial [29] 
L23:    putfield [35] 
L26:    return 
L27:    nop 
L28:    
    .end code 
.end method 

.method public synchronized [195] : [196] 
    .attribute [192] .code stack 4 locals 1 
L0:     new [36] 
L3:     dup 
L4:     aload_0 
L5:     iload_2 
L6:     invokespecial [30] 
L9:     astore_3 
L10:    aload_0 
L11:    getfield [14] 
L14:    aload_1 
L15:    aload_3 
L16:    invokevirtual [16] 
L19:    pop 
L20:    aload_0 
L21:    getfield [15] 
L24:    aload_1 
L25:    invokevirtual [17] 
L28:    pop 
L29:    return 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method public synchronized [197] : [198] 
    .attribute [192] .code stack 2 locals 1 
L0:     aload_0 
L1:     getfield [14] 
L4:     aload_1 
L5:     invokevirtual [18] 
L8:     checkcast [4] 
L11:    astore_3 
L12:    aload_3 
L13:    ifnull L21 
L16:    aload_3 
L17:    iload_2 
L18:    invokevirtual [19] 
L21:    return 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public synchronized [199] : [200] 
    .attribute [192] .code stack 5 locals 5 
L0:     new [37] 
L3:     dup 
L4:     bipush 80 
L6:     invokespecial [31] 
L9:     astore_1 
L10:    aload_0 
L11:    dup 
L12:    getfield [20] 
L15:    lconst_1 
L16:    ladd 
L17:    putfield [38] 
L20:    aload_1 
L21:    ldc [6] 
L23:    invokevirtual [21] 
L26:    pop 
L27:    aload_1 
L28:    aload_0 
L29:    getfield [20] 
L32:    invokevirtual [22] 
L35:    pop 
L36:    aload_0 
L37:    getfield [15] 
L40:    invokevirtual [23] 
L43:    astore_2 
L44:    aload_2 
L45:    invokeinterface [39] 0 
L50:    ifeq L128 
L53:    aload_1 
L54:    ldc [7] 
L56:    invokevirtual [21] 
L59:    pop 
L60:    aload_2 
L61:    invokeinterface [40] 0 
L66:    checkcast [8] 
L69:    astore_3 
L70:    aload_1 
L71:    aload_3 
L72:    invokevirtual [21] 
L75:    pop 
L76:    aload_1 
L77:    ldc [9] 
L79:    invokevirtual [21] 
L82:    pop 
L83:    aload_0 
L84:    getfield [14] 
L87:    aload_3 
L88:    invokevirtual [18] 
L91:    checkcast [4] 
L94:    astore 4 
L96:    aload 4 
L98:    ifnull L118 
L101:   aload 4 
L103:   invokevirtual [24] 
L106:   istore 5 
L108:   aload_1 
L109:   iload 5 
L111:   invokevirtual [25] 
L114:   pop 
L115:   goto L125 
L118:   aload_1 
L119:   ldc [10] 
L121:   invokevirtual [21] 
L124:   pop 
L125:   goto L44 
L128:   aload_1 
L129:   ldc [7] 
L131:   invokevirtual [21] 
L134:   pop 
L135:   aload_1 
L136:   invokevirtual [26] 
L139:   areturn 
L140:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [41] 
.const [3] = Class [42] 
.const [4] = Class [43] 
.const [5] = Class [44] 
.const [6] = String [45] 
.const [7] = String [46] 
.const [8] = Class [47] 
.const [9] = String [48] 
.const [10] = String [49] 
.const [11] = Class [50] 
.const [12] = Class [51] 
.const [13] = Class [52] 
.const [14] = Field [53] [54] 
.const [15] = Field [55] [56] 
.const [16] = Method [57] [58] 
.const [17] = Method [59] [60] 
.const [18] = Method [61] [62] 
.const [19] = Method [63] [64] 
.const [20] = Field [65] [66] 
.const [21] = Method [67] [68] 
.const [22] = Method [69] [70] 
.const [23] = Method [71] [72] 
.const [24] = Method [73] [74] 
.const [25] = Method [75] [76] 
.const [26] = Method [77] [78] 
.const [27] = Method [79] [80] 
.const [28] = Method [81] [82] 
.const [29] = Method [83] [84] 
.const [30] = Method [85] [86] 
.const [31] = Method [87] [88] 
.const [32] = Class [89] 
.const [33] = Field [90] [91] 
.const [34] = Class [92] 
.const [35] = Field [93] [94] 
.const [36] = Class [95] 
.const [37] = Class [96] 
.const [38] = Field [97] [98] 
.const [39] = InterfaceMethod [99] [100] 
.const [40] = InterfaceMethod [101] [102] 
.const [41] = Utf8 java/util/HashMap 
.const [42] = Utf8 java/util/ArrayList 
.const [43] = Utf8 de/esolutions/fw/util/tracing/core/TraceCoreStats$Stats 
.const [44] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [45] = Utf8 'seq=' 
.const [46] = Utf8 ';' 
.const [47] = Utf8 java/lang/String 
.const [48] = Utf8 '=' 
.const [49] = Utf8 n/a 
.const [50] = Utf8 de/esolutions/fw/util/tracing/core/TraceCoreStats 
.const [51] = Utf8 java/lang/Object 
.const [52] = Utf8 java/util/Iterator 
.const [53] = Class [103] 
.const [54] = NameAndType [104] [105] 
.const [55] = Class [106] 
.const [56] = NameAndType [107] [108] 
.const [57] = Class [109] 
.const [58] = NameAndType [110] [111] 
.const [59] = Class [112] 
.const [60] = NameAndType [113] [114] 
.const [61] = Class [115] 
.const [62] = NameAndType [116] [117] 
.const [63] = Class [118] 
.const [64] = NameAndType [119] [120] 
.const [65] = Class [121] 
.const [66] = NameAndType [122] [123] 
.const [67] = Class [124] 
.const [68] = NameAndType [125] [126] 
.const [69] = Class [127] 
.const [70] = NameAndType [128] [129] 
.const [71] = Class [130] 
.const [72] = NameAndType [131] [132] 
.const [73] = Class [133] 
.const [74] = NameAndType [134] [135] 
.const [75] = Class [136] 
.const [76] = NameAndType [137] [138] 
.const [77] = Class [139] 
.const [78] = NameAndType [140] [141] 
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
.const [89] = Utf8 java/util/HashMap 
.const [90] = Class [157] 
.const [91] = NameAndType [158] [159] 
.const [92] = Utf8 java/util/ArrayList 
.const [93] = Class [160] 
.const [94] = NameAndType [161] [162] 
.const [95] = Utf8 de/esolutions/fw/util/tracing/core/TraceCoreStats$Stats 
.const [96] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [97] = Class [163] 
.const [98] = NameAndType [164] [165] 
.const [99] = Class [166] 
.const [100] = NameAndType [167] [168] 
.const [101] = Class [169] 
.const [102] = NameAndType [170] [171] 
.const [103] = Utf8 de/esolutions/fw/util/tracing/core/TraceCoreStats 
.const [104] = Utf8 keyStatsMap 
.const [105] = Utf8 Ljava/util/HashMap; 
.const [106] = Utf8 de/esolutions/fw/util/tracing/core/TraceCoreStats 
.const [107] = Utf8 keys 
.const [108] = Utf8 Ljava/util/ArrayList; 
.const [109] = Utf8 java/util/HashMap 
.const [110] = Utf8 put 
.const [111] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 
.const [112] = Utf8 java/util/ArrayList 
.const [113] = Utf8 add 
.const [114] = Utf8 (Ljava/lang/Object;)Z 
.const [115] = Utf8 java/util/HashMap 
.const [116] = Utf8 get 
.const [117] = Utf8 (Ljava/lang/Object;)Ljava/lang/Object; 
.const [118] = Utf8 de/esolutions/fw/util/tracing/core/TraceCoreStats$Stats 
.const [119] = Utf8 update 
.const [120] = Utf8 (I)V 
.const [121] = Utf8 de/esolutions/fw/util/tracing/core/TraceCoreStats 
.const [122] = Utf8 seqNum 
.const [123] = Utf8 J 
.const [124] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [125] = Utf8 append 
.const [126] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/commons/Buffer; 
.const [127] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [128] = Utf8 append 
.const [129] = Utf8 (J)Lde/esolutions/fw/util/commons/Buffer; 
.const [130] = Utf8 java/util/ArrayList 
.const [131] = Utf8 iterator 
.const [132] = Utf8 ()Ljava/util/Iterator; 
.const [133] = Utf8 de/esolutions/fw/util/tracing/core/TraceCoreStats$Stats 
.const [134] = Utf8 read 
.const [135] = Utf8 ()I 
.const [136] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [137] = Utf8 append 
.const [138] = Utf8 (I)Lde/esolutions/fw/util/commons/Buffer; 
.const [139] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [140] = Utf8 toString 
.const [141] = Utf8 ()Ljava/lang/String; 
.const [142] = Utf8 java/lang/Object 
.const [143] = Utf8 <init> 
.const [144] = Utf8 ()V 
.const [145] = Utf8 java/util/HashMap 
.const [146] = Utf8 <init> 
.const [147] = Utf8 ()V 
.const [148] = Utf8 java/util/ArrayList 
.const [149] = Utf8 <init> 
.const [150] = Utf8 ()V 
.const [151] = Utf8 de/esolutions/fw/util/tracing/core/TraceCoreStats$Stats 
.const [152] = Utf8 <init> 
.const [153] = Utf8 (Lde/esolutions/fw/util/tracing/core/TraceCoreStats;I)V 
.const [154] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [155] = Utf8 <init> 
.const [156] = Utf8 (I)V 
.const [157] = Utf8 de/esolutions/fw/util/tracing/core/TraceCoreStats 
.const [158] = Utf8 keyStatsMap 
.const [159] = Utf8 Ljava/util/HashMap; 
.const [160] = Utf8 de/esolutions/fw/util/tracing/core/TraceCoreStats 
.const [161] = Utf8 keys 
.const [162] = Utf8 Ljava/util/ArrayList; 
.const [163] = Utf8 de/esolutions/fw/util/tracing/core/TraceCoreStats 
.const [164] = Utf8 seqNum 
.const [165] = Utf8 J 
.const [166] = Utf8 java/util/Iterator 
.const [167] = Utf8 hasNext 
.const [168] = Utf8 ()Z 
.const [169] = Utf8 java/util/Iterator 
.const [170] = Utf8 next 
.const [171] = Utf8 ()Ljava/lang/Object; 
.const [172] = Utf8 de/esolutions/fw/util/tracing/core/TraceCoreStats 
.const [173] = Class [172] 
.const [174] = Utf8 java/lang/Object 
.const [175] = Class [174] 
.const [176] = Utf8 keyStatsMap 
.const [177] = Utf8 Ljava/util/HashMap; 
.const [178] = Utf8 keys 
.const [179] = Utf8 Ljava/util/ArrayList; 
.const [180] = Utf8 seqNum 
.const [181] = Utf8 J 
.const [182] = Utf8 FLAG_NONE 
.const [183] = Utf8 I 
.const [184] = Utf8 FLAG_AVERAGE 
.const [185] = Utf8 I 
.const [186] = Utf8 FLAG_INCREMENT 
.const [187] = Utf8 I 
.const [188] = Utf8 FLAG_RESET 
.const [189] = Utf8 I 
.const [190] = Utf8 FLAG_MAX 
.const [191] = Utf8 I 
.const [192] = Utf8 Code 
.const [193] = Utf8 <init> 
.const [194] = Utf8 ()V 
.const [195] = Utf8 registerKey 
.const [196] = Utf8 (Ljava/lang/String;I)V 
.const [197] = Utf8 updateKey 
.const [198] = Utf8 (Ljava/lang/String;I)V 
.const [199] = Utf8 readValues 
.const [200] = Utf8 ()Ljava/lang/String; 
.end class 
