.version 50 0 
.class public super [169] 
.super [171] 
.implements [173] 
.field private [174] [175] 
.field private static final [176] [177] 

.method public static [179] : [180] 
    .attribute [178] .code stack 1 locals 0 
L0:     getstatic [2] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method private [181] : [182] 
    .attribute [178] .code stack 4 locals 0 
L0:     aload_0 
L1:     invokespecial [27] 
L4:     aload_0 
L5:     new [32] 
L8:     dup 
L9:     iconst_5 
L10:    invokespecial [28] 
L13:    putfield [33] 
L16:    return 
L17:    nop 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public synchronized [183] : [184] 
    .attribute [178] .code stack 3 locals 5 
L0:     aload_1 
L1:     invokeinterface [34] 0 
L6:     astore_2 
L7:     iconst_0 
L8:     istore_3 
L9:     aload_2 
L10:    arraylength 
L11:    istore 4 
L13:    iload_3 
L14:    iload 4 
L16:    if_icmpge L75 
L19:    aload_2 
L20:    iload_3 
L21:    aaload 
L22:    invokevirtual [16] 
L25:    astore 5 
L27:    aload_0 
L28:    getfield [15] 
L31:    aload 5 
L33:    invokevirtual [17] 
L36:    astore 6 
L38:    aload 6 
L40:    ifnull L58 
L43:    aload_1 
L44:    aload 6 
L46:    checkcast [4] 
L49:    invokeinterface [35] 0 
L54:    ifne L58 
L57:    return 
L58:    aload_0 
L59:    getfield [15] 
L62:    aload 5 
L64:    aload_1 
L65:    invokevirtual [18] 
L68:    pop 
L69:    iinc 3 1 
L72:    goto L13 
L75:    return 
L76:    
    .end code 
.end method 

.method public synchronized [185] : [186] 
    .attribute [178] .code stack 2 locals 5 
L0:     aload_1 
L1:     invokeinterface [34] 0 
L6:     astore_2 
L7:     iconst_0 
L8:     istore_3 
L9:     aload_2 
L10:    arraylength 
L11:    istore 4 
L13:    iload_3 
L14:    iload 4 
L16:    if_icmpge L65 
L19:    aload_2 
L20:    iload_3 
L21:    aaload 
L22:    invokevirtual [16] 
L25:    astore 5 
L27:    aload_0 
L28:    getfield [15] 
L31:    aload 5 
L33:    invokevirtual [17] 
L36:    astore 6 
L38:    aload 6 
L40:    ifnull L59 
L43:    aload 6 
L45:    aload_1 
L46:    if_acmpne L59 
L49:    aload_0 
L50:    getfield [15] 
L53:    aload 5 
L55:    invokevirtual [19] 
L58:    pop 
L59:    iinc 3 1 
L62:    goto L13 
L65:    return 
L66:    nop 
L67:    nop 
L68:    
    .end code 
.end method 

.method public synchronized [187] : [188] 
    .attribute [178] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [15] 
L4:     invokevirtual [20] 
L7:     return 
L8:     
    .end code 
.end method 

.method public synchronized [189] : [190] 
    .attribute [178] .code stack 2 locals 2 
L0:     aload_0 
L1:     getfield [15] 
L4:     aload_1 
L5:     invokevirtual [16] 
L8:     invokevirtual [17] 
L11:    checkcast [4] 
L14:    astore_2 
L15:    aconst_null 
L16:    astore_3 
L17:    aload_2 
L18:    ifnull L29 
L21:    aload_2 
L22:    aload_1 
L23:    invokeinterface [36] 0 
L28:    astore_3 
L29:    aload_3 
L30:    areturn 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [191] : [192] 
    .attribute [178] .code stack 2 locals 2 
L0:     aload_1 
L1:     ifnonnull L6 
L4:     aconst_null 
L5:     areturn 
        .catch [9] from L6 to L59 using L60 
L6:     aload_1 
L7:     invokespecial [29] 
L10:    ldc [5] 
L12:    invokevirtual [21] 
L15:    astore_2 
L16:    aload_2 
L17:    iconst_1 
L18:    invokevirtual [22] 
L21:    aload_2 
L22:    aload_1 
L23:    invokevirtual [23] 
L26:    astore_3 
L27:    new [37] 
L30:    dup 
L31:    invokespecial [30] 
L34:    aload_1 
L35:    invokespecial [29] 
L38:    invokevirtual [16] 
L41:    invokevirtual [24] 
L44:    ldc [7] 
L46:    invokevirtual [24] 
L49:    aload_3 
L50:    invokestatic [8] 
L53:    invokevirtual [24] 
L56:    invokevirtual [25] 
L59:    areturn 
L60:    astore_2 
L61:    aconst_null 
L62:    areturn 
L63:    nop 
L64:    
    .end code 
.end method 

.method static [193] : [194] 
    .attribute [178] .code stack 2 locals 0 
L0:     new [38] 
L3:     dup 
L4:     invokespecial [31] 
L7:     putstatic [26] 
L10:    return 
L11:    nop 
L12:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Field [39] [40] 
.const [3] = Class [41] 
.const [4] = Class [42] 
.const [5] = String [43] 
.const [6] = Class [44] 
.const [7] = String [45] 
.const [8] = Method [46] [47] 
.const [9] = Class [48] 
.const [10] = Class [49] 
.const [11] = Class [50] 
.const [12] = Class [51] 
.const [13] = Class [52] 
.const [14] = Class [53] 
.const [15] = Field [54] [55] 
.const [16] = Method [56] [57] 
.const [17] = Method [58] [59] 
.const [18] = Method [60] [61] 
.const [19] = Method [62] [63] 
.const [20] = Method [64] [65] 
.const [21] = Method [66] [67] 
.const [22] = Method [68] [69] 
.const [23] = Method [70] [71] 
.const [24] = Method [72] [73] 
.const [25] = Method [74] [75] 
.const [26] = Field [76] [77] 
.const [27] = Method [78] [79] 
.const [28] = Method [80] [81] 
.const [29] = Method [82] [83] 
.const [30] = Method [84] [85] 
.const [31] = Method [86] [87] 
.const [32] = Class [88] 
.const [33] = Field [89] [90] 
.const [34] = InterfaceMethod [91] [92] 
.const [35] = InterfaceMethod [93] [94] 
.const [36] = InterfaceMethod [95] [96] 
.const [37] = Class [97] 
.const [38] = Class [98] 
.const [39] = Class [99] 
.const [40] = NameAndType [100] [101] 
.const [41] = Utf8 java/util/HashMap 
.const [42] = Utf8 org/dsi/ifc/base/IFactory 
.const [43] = Utf8 VERSION 
.const [44] = Utf8 java/lang/StringBuffer 
.const [45] = Utf8 '@@' 
.const [46] = Class [102] 
.const [47] = NameAndType [103] [104] 
.const [48] = Utf8 java/lang/Throwable 
.const [49] = Utf8 org/dsi/ifc/internal/AdapterManager 
.const [50] = Utf8 java/lang/Object 
.const [51] = Utf8 java/lang/Class 
.const [52] = Utf8 java/lang/reflect/Field 
.const [53] = Utf8 java/lang/String 
.const [54] = Class [105] 
.const [55] = NameAndType [106] [107] 
.const [56] = Class [108] 
.const [57] = NameAndType [109] [110] 
.const [58] = Class [111] 
.const [59] = NameAndType [112] [113] 
.const [60] = Class [114] 
.const [61] = NameAndType [115] [116] 
.const [62] = Class [117] 
.const [63] = NameAndType [118] [119] 
.const [64] = Class [120] 
.const [65] = NameAndType [121] [122] 
.const [66] = Class [123] 
.const [67] = NameAndType [124] [125] 
.const [68] = Class [126] 
.const [69] = NameAndType [127] [128] 
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
.const [88] = Utf8 java/util/HashMap 
.const [89] = Class [156] 
.const [90] = NameAndType [157] [158] 
.const [91] = Class [159] 
.const [92] = NameAndType [160] [161] 
.const [93] = Class [162] 
.const [94] = NameAndType [163] [164] 
.const [95] = Class [165] 
.const [96] = NameAndType [166] [167] 
.const [97] = Utf8 java/lang/StringBuffer 
.const [98] = Utf8 org/dsi/ifc/internal/AdapterManager 
.const [99] = Utf8 org/dsi/ifc/internal/AdapterManager 
.const [100] = Utf8 singleton 
.const [101] = Utf8 Lorg/dsi/ifc/internal/AdapterManager; 
.const [102] = Utf8 java/lang/String 
.const [103] = Utf8 valueOf 
.const [104] = Utf8 (Ljava/lang/Object;)Ljava/lang/String; 
.const [105] = Utf8 org/dsi/ifc/internal/AdapterManager 
.const [106] = Utf8 factories 
.const [107] = Utf8 Ljava/util/HashMap; 
.const [108] = Utf8 java/lang/Class 
.const [109] = Utf8 getName 
.const [110] = Utf8 ()Ljava/lang/String; 
.const [111] = Utf8 java/util/HashMap 
.const [112] = Utf8 get 
.const [113] = Utf8 (Ljava/lang/Object;)Ljava/lang/Object; 
.const [114] = Utf8 java/util/HashMap 
.const [115] = Utf8 put 
.const [116] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 
.const [117] = Utf8 java/util/HashMap 
.const [118] = Utf8 remove 
.const [119] = Utf8 (Ljava/lang/Object;)Ljava/lang/Object; 
.const [120] = Utf8 java/util/HashMap 
.const [121] = Utf8 clear 
.const [122] = Utf8 ()V 
.const [123] = Utf8 java/lang/Class 
.const [124] = Utf8 getDeclaredField 
.const [125] = Utf8 (Ljava/lang/String;)Ljava/lang/reflect/Field; 
.const [126] = Utf8 java/lang/reflect/Field 
.const [127] = Utf8 setAccessible 
.const [128] = Utf8 (Z)V 
.const [129] = Utf8 java/lang/reflect/Field 
.const [130] = Utf8 get 
.const [131] = Utf8 (Ljava/lang/Object;)Ljava/lang/Object; 
.const [132] = Utf8 java/lang/StringBuffer 
.const [133] = Utf8 append 
.const [134] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [135] = Utf8 java/lang/StringBuffer 
.const [136] = Utf8 toString 
.const [137] = Utf8 ()Ljava/lang/String; 
.const [138] = Utf8 org/dsi/ifc/internal/AdapterManager 
.const [139] = Utf8 singleton 
.const [140] = Utf8 Lorg/dsi/ifc/internal/AdapterManager; 
.const [141] = Utf8 java/lang/Object 
.const [142] = Utf8 <init> 
.const [143] = Utf8 ()V 
.const [144] = Utf8 java/util/HashMap 
.const [145] = Utf8 <init> 
.const [146] = Utf8 (I)V 
.const [147] = Utf8 java/lang/Object 
.const [148] = Utf8 getClass 
.const [149] = Utf8 ()Ljava/lang/Class; 
.const [150] = Utf8 java/lang/StringBuffer 
.const [151] = Utf8 <init> 
.const [152] = Utf8 ()V 
.const [153] = Utf8 org/dsi/ifc/internal/AdapterManager 
.const [154] = Utf8 <init> 
.const [155] = Utf8 ()V 
.const [156] = Utf8 org/dsi/ifc/internal/AdapterManager 
.const [157] = Utf8 factories 
.const [158] = Utf8 Ljava/util/HashMap; 
.const [159] = Utf8 org/dsi/ifc/base/IFactory 
.const [160] = Utf8 getFactoryList 
.const [161] = Utf8 ()[Ljava/lang/Class; 
.const [162] = Utf8 org/dsi/ifc/base/IFactory 
.const [163] = Utf8 shouldOverride 
.const [164] = Utf8 (Lorg/dsi/ifc/base/IFactory;)Z 
.const [165] = Utf8 org/dsi/ifc/base/IFactory 
.const [166] = Utf8 getFactory 
.const [167] = Utf8 (Ljava/lang/Class;)Ljava/lang/Object; 
.const [168] = Utf8 org/dsi/ifc/internal/AdapterManager 
.const [169] = Class [168] 
.const [170] = Utf8 java/lang/Object 
.const [171] = Class [170] 
.const [172] = Utf8 org/dsi/ifc/base/IAdapterManager 
.const [173] = Class [172] 
.const [174] = Utf8 factories 
.const [175] = Utf8 Ljava/util/HashMap; 
.const [176] = Utf8 singleton 
.const [177] = Utf8 Lorg/dsi/ifc/internal/AdapterManager; 
.const [178] = Utf8 Code 
.const [179] = Utf8 getDefault 
.const [180] = Utf8 ()Lorg/dsi/ifc/internal/AdapterManager; 
.const [181] = Utf8 <init> 
.const [182] = Utf8 ()V 
.const [183] = Utf8 registerFactories 
.const [184] = Utf8 (Lorg/dsi/ifc/base/IFactory;)V 
.const [185] = Utf8 unregisterFactories 
.const [186] = Utf8 (Lorg/dsi/ifc/base/IFactory;)V 
.const [187] = Utf8 unregisterAllFactories 
.const [188] = Utf8 ()V 
.const [189] = Utf8 getFactory 
.const [190] = Utf8 (Ljava/lang/Class;)Ljava/lang/Object; 
.const [191] = Utf8 getVersionInfo 
.const [192] = Utf8 (Ljava/lang/Object;)Ljava/lang/String; 
.const [193] = Utf8 <clinit> 
.const [194] = Utf8 ()V 
.end class 
