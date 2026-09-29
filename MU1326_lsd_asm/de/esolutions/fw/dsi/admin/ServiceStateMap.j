.version 50 0 
.class public final super [167] 
.super [169] 
.field public static final [170] [171] 
.field public static final [172] [173] 
.field public static final [174] [175] 
.field private final [176] [177] 

.method public [179] : [180] 
    .attribute [178] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [17] 
L4:     aload_0 
L5:     new [25] 
L8:     dup 
L9:     invokespecial [18] 
L12:    putfield [26] 
L15:    return 
L16:    
    .end code 
.end method 

.method public synchronized [181] : [182] 
    .attribute [178] .code stack 4 locals 2 
L0:     aload_1 
L1:     ifnonnull L6 
L4:     iconst_0 
L5:     areturn 
L6:     aload_0 
L7:     aload_1 
L8:     iload_2 
L9:     invokespecial [19] 
L12:    astore_3 
L13:    aload_0 
L14:    aload_1 
L15:    iload_2 
L16:    invokespecial [20] 
L19:    astore 4 
L21:    aload 4 
L23:    ifnull L40 
L26:    aload 4 
L28:    iconst_0 
L29:    putfield [27] 
L32:    aload 4 
L34:    iconst_1 
L35:    putfield [28] 
L38:    iconst_0 
L39:    areturn 
L40:    aload_0 
L41:    getfield [11] 
L44:    aload_3 
L45:    new [29] 
L48:    dup 
L49:    invokespecial [21] 
L52:    invokeinterface [30] 0 
L57:    pop 
L58:    iconst_1 
L59:    areturn 
L60:    
    .end code 
.end method 

.method public synchronized [183] : [184] 
    .attribute [178] .code stack 3 locals 1 
L0:     aload_1 
L1:     ifnonnull L6 
L4:     iconst_0 
L5:     areturn 
L6:     aload_0 
L7:     aload_1 
L8:     iload_2 
L9:     invokespecial [19] 
L12:    astore_3 
L13:    aload_0 
L14:    getfield [11] 
L17:    aload_3 
L18:    invokeinterface [31] 0 
L23:    ifnull L30 
L26:    iconst_1 
L27:    goto L31 
L30:    iconst_0 
L31:    areturn 
L32:    
    .end code 
.end method 

.method public synchronized [185] : [186] 
    .attribute [178] .code stack 3 locals 2 
L0:     aload_1 
L1:     ifnonnull L6 
L4:     iconst_0 
L5:     areturn 
L6:     aload_0 
L7:     aload_1 
L8:     iload_2 
L9:     invokespecial [19] 
L12:    astore_3 
L13:    aload_0 
L14:    getfield [11] 
L17:    aload_3 
L18:    invokeinterface [32] 0 
L23:    checkcast [3] 
L26:    astore 4 
L28:    aload 4 
L30:    ifnonnull L35 
L33:    iconst_0 
L34:    areturn 
L35:    aload 4 
L37:    iconst_0 
L38:    putfield [27] 
L41:    iconst_1 
L42:    areturn 
L43:    nop 
L44:    
    .end code 
.end method 

.method public synchronized [187] : [188] 
    .attribute [178] .code stack 3 locals 1 
L0:     aload_0 
L1:     aload_1 
L2:     iload_2 
L3:     invokespecial [20] 
L6:     astore 4 
L8:     aload 4 
L10:    ifnonnull L15 
L13:    iconst_0 
L14:    areturn 
L15:    aload 4 
L17:    iload_3 
L18:    putfield [33] 
L21:    iconst_1 
L22:    areturn 
L23:    nop 
L24:    
    .end code 
.end method 

.method public synchronized [189] : [190] 
    .attribute [178] .code stack 3 locals 1 
L0:     aload_0 
L1:     aload_1 
L2:     iload_2 
L3:     invokespecial [20] 
L6:     astore_3 
L7:     aload_3 
L8:     ifnonnull L13 
L11:    aconst_null 
L12:    areturn 
L13:    new [34] 
L16:    dup 
L17:    aload_3 
L18:    getfield [14] 
L21:    invokespecial [22] 
L24:    areturn 
L25:    nop 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public synchronized [191] : [192] 
    .attribute [178] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [11] 
L4:     invokeinterface [35] 0 
L9:     areturn 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public synchronized [193] : [194] 
    .attribute [178] .code stack 3 locals 1 
L0:     aload_0 
L1:     aload_1 
L2:     iload_2 
L3:     invokespecial [20] 
L6:     astore_3 
L7:     aload_3 
L8:     ifnonnull L13 
L11:    aconst_null 
L12:    areturn 
L13:    aload_3 
L14:    getfield [12] 
L17:    ifne L39 
L20:    aload_3 
L21:    iconst_1 
L22:    putfield [27] 
L25:    aload_3 
L26:    iconst_0 
L27:    putfield [28] 
L30:    new [36] 
L33:    dup 
L34:    iconst_1 
L35:    invokespecial [23] 
L38:    areturn 
L39:    new [36] 
L42:    dup 
L43:    iconst_0 
L44:    invokespecial [23] 
L47:    areturn 
L48:    
    .end code 
.end method 

.method public synchronized [195] : [196] 
    .attribute [178] .code stack 3 locals 1 
L0:     aload_0 
L1:     aload_1 
L2:     iload_2 
L3:     invokespecial [20] 
L6:     astore_3 
L7:     aload_3 
L8:     ifnonnull L13 
L11:    aconst_null 
L12:    areturn 
L13:    new [36] 
L16:    dup 
L17:    aload_3 
L18:    getfield [12] 
L21:    invokespecial [23] 
L24:    areturn 
L25:    nop 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method private [197] : [198] 
    .attribute [178] .code stack 2 locals 0 
L0:     new [37] 
L3:     dup 
L4:     invokespecial [24] 
L7:     aload_1 
L8:     invokevirtual [15] 
L11:    iload_2 
L12:    invokestatic [7] 
L15:    invokevirtual [15] 
L18:    invokevirtual [16] 
L21:    areturn 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method private [199] : [200] 
    .attribute [178] .code stack 3 locals 2 
L0:     aload_1 
L1:     ifnonnull L6 
L4:     aconst_null 
L5:     areturn 
L6:     aload_0 
L7:     aload_1 
L8:     iload_2 
L9:     invokespecial [19] 
L12:    astore_3 
L13:    aload_0 
L14:    getfield [11] 
L17:    aload_3 
L18:    invokeinterface [32] 0 
L23:    checkcast [3] 
L26:    astore 4 
L28:    aload 4 
L30:    areturn 
L31:    nop 
L32:    
    .end code 
.end method 

.method public synchronized [201] : [202] 
    .attribute [178] .code stack 3 locals 1 
L0:     aload_0 
L1:     aload_1 
L2:     iload_2 
L3:     invokespecial [20] 
L6:     astore_3 
L7:     aload_3 
L8:     ifnonnull L13 
L11:    aconst_null 
L12:    areturn 
L13:    aload_3 
L14:    getfield [12] 
L17:    ifeq L34 
L20:    aload_3 
L21:    iconst_0 
L22:    putfield [27] 
L25:    new [36] 
L28:    dup 
L29:    iconst_1 
L30:    invokespecial [23] 
L33:    areturn 
L34:    new [36] 
L37:    dup 
L38:    iconst_0 
L39:    invokespecial [23] 
L42:    areturn 
L43:    nop 
L44:    
    .end code 
.end method 

.method public synchronized [203] : [204] 
    .attribute [178] .code stack 3 locals 1 
L0:     aload_0 
L1:     aload_1 
L2:     iload_2 
L3:     invokespecial [20] 
L6:     astore_3 
L7:     aload_3 
L8:     ifnonnull L13 
L11:    aconst_null 
L12:    areturn 
L13:    aload_3 
L14:    getfield [13] 
L17:    ifeq L34 
L20:    aload_3 
L21:    iconst_0 
L22:    putfield [28] 
L25:    new [36] 
L28:    dup 
L29:    iconst_1 
L30:    invokespecial [23] 
L33:    areturn 
L34:    new [36] 
L37:    dup 
L38:    iconst_0 
L39:    invokespecial [23] 
L42:    areturn 
L43:    nop 
L44:    
    .end code 
.end method 

.method public synchronized [205] : [206] 
    .attribute [178] .code stack 3 locals 2 
L0:     aload_1 
L1:     ifnonnull L6 
L4:     iconst_0 
L5:     areturn 
L6:     aload_0 
L7:     aload_1 
L8:     iload_2 
L9:     invokespecial [19] 
L12:    astore_3 
L13:    aload_0 
L14:    getfield [11] 
L17:    aload_3 
L18:    invokeinterface [32] 0 
L23:    checkcast [3] 
L26:    astore 4 
L28:    aload 4 
L30:    ifnonnull L35 
L33:    iconst_0 
L34:    areturn 
L35:    aload 4 
L37:    iconst_0 
L38:    putfield [28] 
L41:    iconst_1 
L42:    areturn 
L43:    nop 
L44:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [38] 
.const [3] = Class [39] 
.const [4] = Class [40] 
.const [5] = Class [41] 
.const [6] = Class [42] 
.const [7] = Method [43] [44] 
.const [8] = Class [45] 
.const [9] = Class [46] 
.const [10] = Class [47] 
.const [11] = Field [48] [49] 
.const [12] = Field [50] [51] 
.const [13] = Field [52] [53] 
.const [14] = Field [54] [55] 
.const [15] = Method [56] [57] 
.const [16] = Method [58] [59] 
.const [17] = Method [60] [61] 
.const [18] = Method [62] [63] 
.const [19] = Method [64] [65] 
.const [20] = Method [66] [67] 
.const [21] = Method [68] [69] 
.const [22] = Method [70] [71] 
.const [23] = Method [72] [73] 
.const [24] = Method [74] [75] 
.const [25] = Class [76] 
.const [26] = Field [77] [78] 
.const [27] = Field [79] [80] 
.const [28] = Field [81] [82] 
.const [29] = Class [83] 
.const [30] = InterfaceMethod [84] [85] 
.const [31] = InterfaceMethod [86] [87] 
.const [32] = InterfaceMethod [88] [89] 
.const [33] = Field [90] [91] 
.const [34] = Class [92] 
.const [35] = InterfaceMethod [93] [94] 
.const [36] = Class [95] 
.const [37] = Class [96] 
.const [38] = Utf8 java/util/HashMap 
.const [39] = Utf8 de/esolutions/fw/dsi/admin/ServiceStateMap$State 
.const [40] = Utf8 java/lang/Integer 
.const [41] = Utf8 java/lang/Boolean 
.const [42] = Utf8 java/lang/StringBuffer 
.const [43] = Class [97] 
.const [44] = NameAndType [98] [99] 
.const [45] = Utf8 de/esolutions/fw/dsi/admin/ServiceStateMap 
.const [46] = Utf8 java/lang/Object 
.const [47] = Utf8 java/util/Map 
.const [48] = Class [100] 
.const [49] = NameAndType [101] [102] 
.const [50] = Class [103] 
.const [51] = NameAndType [104] [105] 
.const [52] = Class [106] 
.const [53] = NameAndType [107] [108] 
.const [54] = Class [109] 
.const [55] = NameAndType [110] [111] 
.const [56] = Class [112] 
.const [57] = NameAndType [113] [114] 
.const [58] = Class [115] 
.const [59] = NameAndType [116] [117] 
.const [60] = Class [118] 
.const [61] = NameAndType [119] [120] 
.const [62] = Class [121] 
.const [63] = NameAndType [122] [123] 
.const [64] = Class [124] 
.const [65] = NameAndType [125] [126] 
.const [66] = Class [127] 
.const [67] = NameAndType [128] [129] 
.const [68] = Class [130] 
.const [69] = NameAndType [131] [132] 
.const [70] = Class [133] 
.const [71] = NameAndType [134] [135] 
.const [72] = Class [136] 
.const [73] = NameAndType [137] [138] 
.const [74] = Class [139] 
.const [75] = NameAndType [140] [141] 
.const [76] = Utf8 java/util/HashMap 
.const [77] = Class [142] 
.const [78] = NameAndType [143] [144] 
.const [79] = Class [145] 
.const [80] = NameAndType [146] [147] 
.const [81] = Class [148] 
.const [82] = NameAndType [149] [150] 
.const [83] = Utf8 de/esolutions/fw/dsi/admin/ServiceStateMap$State 
.const [84] = Class [151] 
.const [85] = NameAndType [152] [153] 
.const [86] = Class [154] 
.const [87] = NameAndType [155] [156] 
.const [88] = Class [157] 
.const [89] = NameAndType [158] [159] 
.const [90] = Class [160] 
.const [91] = NameAndType [161] [162] 
.const [92] = Utf8 java/lang/Integer 
.const [93] = Class [163] 
.const [94] = NameAndType [164] [165] 
.const [95] = Utf8 java/lang/Boolean 
.const [96] = Utf8 java/lang/StringBuffer 
.const [97] = Utf8 java/lang/Integer 
.const [98] = Utf8 toString 
.const [99] = Utf8 (I)Ljava/lang/String; 
.const [100] = Utf8 de/esolutions/fw/dsi/admin/ServiceStateMap 
.const [101] = Utf8 svcMap 
.const [102] = Utf8 Ljava/util/Map; 
.const [103] = Utf8 de/esolutions/fw/dsi/admin/ServiceStateMap$State 
.const [104] = Utf8 stopFlag 
.const [105] = Utf8 Z 
.const [106] = Utf8 de/esolutions/fw/dsi/admin/ServiceStateMap$State 
.const [107] = Utf8 restartFlag 
.const [108] = Utf8 Z 
.const [109] = Utf8 de/esolutions/fw/dsi/admin/ServiceStateMap$State 
.const [110] = Utf8 state 
.const [111] = Utf8 I 
.const [112] = Utf8 java/lang/StringBuffer 
.const [113] = Utf8 append 
.const [114] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [115] = Utf8 java/lang/StringBuffer 
.const [116] = Utf8 toString 
.const [117] = Utf8 ()Ljava/lang/String; 
.const [118] = Utf8 java/lang/Object 
.const [119] = Utf8 <init> 
.const [120] = Utf8 ()V 
.const [121] = Utf8 java/util/HashMap 
.const [122] = Utf8 <init> 
.const [123] = Utf8 ()V 
.const [124] = Utf8 de/esolutions/fw/dsi/admin/ServiceStateMap 
.const [125] = Utf8 genKey 
.const [126] = Utf8 (Ljava/lang/String;I)Ljava/lang/String; 
.const [127] = Utf8 de/esolutions/fw/dsi/admin/ServiceStateMap 
.const [128] = Utf8 getState 
.const [129] = Utf8 (Ljava/lang/String;I)Lde/esolutions/fw/dsi/admin/ServiceStateMap$State; 
.const [130] = Utf8 de/esolutions/fw/dsi/admin/ServiceStateMap$State 
.const [131] = Utf8 <init> 
.const [132] = Utf8 ()V 
.const [133] = Utf8 java/lang/Integer 
.const [134] = Utf8 <init> 
.const [135] = Utf8 (I)V 
.const [136] = Utf8 java/lang/Boolean 
.const [137] = Utf8 <init> 
.const [138] = Utf8 (Z)V 
.const [139] = Utf8 java/lang/StringBuffer 
.const [140] = Utf8 <init> 
.const [141] = Utf8 ()V 
.const [142] = Utf8 de/esolutions/fw/dsi/admin/ServiceStateMap 
.const [143] = Utf8 svcMap 
.const [144] = Utf8 Ljava/util/Map; 
.const [145] = Utf8 de/esolutions/fw/dsi/admin/ServiceStateMap$State 
.const [146] = Utf8 stopFlag 
.const [147] = Utf8 Z 
.const [148] = Utf8 de/esolutions/fw/dsi/admin/ServiceStateMap$State 
.const [149] = Utf8 restartFlag 
.const [150] = Utf8 Z 
.const [151] = Utf8 java/util/Map 
.const [152] = Utf8 put 
.const [153] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 
.const [154] = Utf8 java/util/Map 
.const [155] = Utf8 remove 
.const [156] = Utf8 (Ljava/lang/Object;)Ljava/lang/Object; 
.const [157] = Utf8 java/util/Map 
.const [158] = Utf8 get 
.const [159] = Utf8 (Ljava/lang/Object;)Ljava/lang/Object; 
.const [160] = Utf8 de/esolutions/fw/dsi/admin/ServiceStateMap$State 
.const [161] = Utf8 state 
.const [162] = Utf8 I 
.const [163] = Utf8 java/util/Map 
.const [164] = Utf8 isEmpty 
.const [165] = Utf8 ()Z 
.const [166] = Utf8 de/esolutions/fw/dsi/admin/ServiceStateMap 
.const [167] = Class [166] 
.const [168] = Utf8 java/lang/Object 
.const [169] = Class [168] 
.const [170] = Utf8 ADDED 
.const [171] = Utf8 I 
.const [172] = Utf8 PENDING 
.const [173] = Utf8 I 
.const [174] = Utf8 REGISTERED 
.const [175] = Utf8 I 
.const [176] = Utf8 svcMap 
.const [177] = Utf8 Ljava/util/Map; 
.const [178] = Utf8 Code 
.const [179] = Utf8 <init> 
.const [180] = Utf8 ()V 
.const [181] = Utf8 checkAndAddService 
.const [182] = Utf8 (Ljava/lang/String;I)Z 
.const [183] = Utf8 removeService 
.const [184] = Utf8 (Ljava/lang/String;I)Z 
.const [185] = Utf8 removeStopFlag 
.const [186] = Utf8 (Ljava/lang/String;I)Z 
.const [187] = Utf8 setServiceState 
.const [188] = Utf8 (Ljava/lang/String;II)Z 
.const [189] = Utf8 getServiceState 
.const [190] = Utf8 (Ljava/lang/String;I)Ljava/lang/Integer; 
.const [191] = Utf8 isEmpty 
.const [192] = Utf8 ()Z 
.const [193] = Utf8 checkAndSetStopFlag 
.const [194] = Utf8 (Ljava/lang/String;I)Ljava/lang/Boolean; 
.const [195] = Utf8 getStopFlag 
.const [196] = Utf8 (Ljava/lang/String;I)Ljava/lang/Boolean; 
.const [197] = Utf8 genKey 
.const [198] = Utf8 (Ljava/lang/String;I)Ljava/lang/String; 
.const [199] = Utf8 getState 
.const [200] = Utf8 (Ljava/lang/String;I)Lde/esolutions/fw/dsi/admin/ServiceStateMap$State; 
.const [201] = Utf8 checkAndClearStopFlag 
.const [202] = Utf8 (Ljava/lang/String;I)Ljava/lang/Boolean; 
.const [203] = Utf8 checkAndClearRestartFlag 
.const [204] = Utf8 (Ljava/lang/String;I)Ljava/lang/Boolean; 
.const [205] = Utf8 removeRestartFlag 
.const [206] = Utf8 (Ljava/lang/String;I)Z 
.end class 
