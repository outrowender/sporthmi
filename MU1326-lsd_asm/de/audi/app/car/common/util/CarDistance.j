.version 50 0 
.class public super [127] 
.super [129] 
.field protected static final [130] [131] 
.field private [132] [133] 

.method public [135] : [136] 
    .attribute [134] .code stack 3 locals 0 
L0:     aload_0 
L1:     fconst_0 
L2:     iconst_1 
L3:     invokespecial [19] 
L6:     aload_0 
L7:     iconst_0 
L8:     putfield [24] 
L11:    aload_0 
L12:    iconst_1 
L13:    putfield [24] 
L16:    return 
L17:    nop 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [137] : [138] 
    .attribute [134] .code stack 3 locals 0 
L0:     aload_0 
L1:     fload_1 
L2:     iload_2 
L3:     invokespecial [19] 
L6:     aload_0 
L7:     iconst_0 
L8:     putfield [24] 
L11:    aload_0 
L12:    fload_1 
L13:    putfield [25] 
L16:    return 
L17:    nop 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [139] : [140] 
    .attribute [134] .code stack 2 locals 1 
L0:     aload_0 
L1:     getfield [12] 
L4:     ifeq L18 
L7:     aload_0 
L8:     ldc [2] 
L10:    putfield [26] 
L13:    aload_0 
L14:    getfield [14] 
L17:    areturn 
L18:    iload_1 
L19:    iconst_2 
L20:    if_icmpne L72 
L23:    new [27] 
L26:    dup 
L27:    invokespecial [20] 
L30:    astore_2 
L31:    aload_2 
L32:    aload_0 
L33:    getfield [13] 
L36:    f2i 
L37:    invokevirtual [15] 
L40:    iconst_1 
L41:    invokestatic [4] 
L44:    invokevirtual [16] 
L47:    pop 
L48:    aload_0 
L49:    getfield [14] 
L52:    aload_2 
L53:    invokestatic [5] 
L56:    ifne L67 
L59:    aload_0 
L60:    aload_2 
L61:    invokevirtual [17] 
L64:    putfield [26] 
L67:    aload_0 
L68:    getfield [14] 
L71:    areturn 
L72:    aload_0 
L73:    iload_1 
L74:    invokespecial [21] 
L77:    areturn 
L78:    nop 
L79:    nop 
L80:    
    .end code 
.end method 

.method public [141] : [142] 
    .attribute [134] .code stack 2 locals 1 
L0:     aload_0 
L1:     getfield [12] 
L4:     ifeq L10 
L7:     ldc [6] 
L9:     areturn 
L10:    iload_1 
L11:    iconst_2 
L12:    if_icmpne L35 
L15:    iconst_1 
L16:    invokestatic [4] 
L19:    astore_2 
L20:    aconst_null 
L21:    aload_2 
L22:    if_acmpeq L32 
L25:    aload_2 
L26:    invokevirtual [18] 
L29:    goto L34 
L32:    ldc [6] 
L34:    areturn 
L35:    aload_0 
L36:    iload_1 
L37:    invokespecial [22] 
L40:    areturn 
L41:    nop 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 

.method public [143] : [144] 
    .attribute [134] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [12] 
L4:     ifeq L13 
L7:     ldc [2] 
L9:     invokevirtual [18] 
L12:    areturn 
L13:    iconst_2 
L14:    iload_1 
L15:    if_icmpne L27 
L18:    aload_0 
L19:    getfield [13] 
L22:    f2i 
L23:    invokestatic [7] 
L26:    areturn 
L27:    aload_0 
L28:    iload_1 
L29:    invokespecial [23] 
L32:    areturn 
L33:    nop 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [28] 
.const [3] = Class [29] 
.const [4] = Method [30] [31] 
.const [5] = Method [32] [33] 
.const [6] = String [34] 
.const [7] = Method [35] [36] 
.const [8] = Class [37] 
.const [9] = Class [38] 
.const [10] = Class [39] 
.const [11] = Class [40] 
.const [12] = Field [41] [42] 
.const [13] = Field [43] [44] 
.const [14] = Field [45] [46] 
.const [15] = Method [47] [48] 
.const [16] = Method [49] [50] 
.const [17] = Method [51] [52] 
.const [18] = Method [53] [54] 
.const [19] = Method [55] [56] 
.const [20] = Method [57] [58] 
.const [21] = Method [59] [60] 
.const [22] = Method [61] [62] 
.const [23] = Method [63] [64] 
.const [24] = Field [65] [66] 
.const [25] = Field [67] [68] 
.const [26] = Field [69] [70] 
.const [27] = Class [71] 
.const [28] = Utf8 '--' 
.const [29] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [30] = Class [72] 
.const [31] = NameAndType [73] [74] 
.const [32] = Class [75] 
.const [33] = NameAndType [76] [77] 
.const [34] = Utf8 '' 
.const [35] = Class [78] 
.const [36] = NameAndType [79] [80] 
.const [37] = Utf8 de/audi/app/car/common/util/CarDistance 
.const [38] = Utf8 de/audi/atip/metrics/Distance 
.const [39] = Utf8 java/lang/String 
.const [40] = Utf8 java/lang/Integer 
.const [41] = Class [81] 
.const [42] = NameAndType [82] [83] 
.const [43] = Class [84] 
.const [44] = NameAndType [85] [86] 
.const [45] = Class [87] 
.const [46] = NameAndType [88] [89] 
.const [47] = Class [90] 
.const [48] = NameAndType [91] [92] 
.const [49] = Class [93] 
.const [50] = NameAndType [94] [95] 
.const [51] = Class [96] 
.const [52] = NameAndType [97] [98] 
.const [53] = Class [99] 
.const [54] = NameAndType [100] [101] 
.const [55] = Class [102] 
.const [56] = NameAndType [103] [104] 
.const [57] = Class [105] 
.const [58] = NameAndType [106] [107] 
.const [59] = Class [108] 
.const [60] = NameAndType [109] [110] 
.const [61] = Class [111] 
.const [62] = NameAndType [112] [113] 
.const [63] = Class [114] 
.const [64] = NameAndType [115] [116] 
.const [65] = Class [117] 
.const [66] = NameAndType [118] [119] 
.const [67] = Class [120] 
.const [68] = NameAndType [121] [122] 
.const [69] = Class [123] 
.const [70] = NameAndType [124] [125] 
.const [71] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [72] = Utf8 de/audi/app/car/common/util/CarDistance 
.const [73] = Utf8 getText 
.const [74] = Utf8 (I)Ljava/lang/String; 
.const [75] = Utf8 de/audi/app/car/common/util/CarDistance 
.const [76] = Utf8 contentEquals 
.const [77] = Utf8 (Ljava/lang/String;Lde/esolutions/fw/util/commons/Buffer;)Z 
.const [78] = Utf8 java/lang/Integer 
.const [79] = Utf8 toString 
.const [80] = Utf8 (I)Ljava/lang/String; 
.const [81] = Utf8 de/audi/app/car/common/util/CarDistance 
.const [82] = Utf8 undefinedDistance 
.const [83] = Utf8 Z 
.const [84] = Utf8 de/audi/app/car/common/util/CarDistance 
.const [85] = Utf8 value 
.const [86] = Utf8 F 
.const [87] = Utf8 de/audi/app/car/common/util/CarDistance 
.const [88] = Utf8 lastFormat 
.const [89] = Utf8 Ljava/lang/String; 
.const [90] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [91] = Utf8 append 
.const [92] = Utf8 (I)Lde/esolutions/fw/util/commons/Buffer; 
.const [93] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [94] = Utf8 append 
.const [95] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/commons/Buffer; 
.const [96] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [97] = Utf8 toString 
.const [98] = Utf8 ()Ljava/lang/String; 
.const [99] = Utf8 java/lang/String 
.const [100] = Utf8 trim 
.const [101] = Utf8 ()Ljava/lang/String; 
.const [102] = Utf8 de/audi/atip/metrics/Distance 
.const [103] = Utf8 <init> 
.const [104] = Utf8 (FI)V 
.const [105] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [106] = Utf8 <init> 
.const [107] = Utf8 ()V 
.const [108] = Utf8 de/audi/atip/metrics/Distance 
.const [109] = Utf8 format 
.const [110] = Utf8 (I)Ljava/lang/String; 
.const [111] = Utf8 de/audi/atip/metrics/Distance 
.const [112] = Utf8 getFormattedUnit 
.const [113] = Utf8 (I)Ljava/lang/String; 
.const [114] = Utf8 de/audi/atip/metrics/Distance 
.const [115] = Utf8 getFormattedValue 
.const [116] = Utf8 (I)Ljava/lang/String; 
.const [117] = Utf8 de/audi/app/car/common/util/CarDistance 
.const [118] = Utf8 undefinedDistance 
.const [119] = Utf8 Z 
.const [120] = Utf8 de/audi/app/car/common/util/CarDistance 
.const [121] = Utf8 value 
.const [122] = Utf8 F 
.const [123] = Utf8 de/audi/app/car/common/util/CarDistance 
.const [124] = Utf8 lastFormat 
.const [125] = Utf8 Ljava/lang/String; 
.const [126] = Utf8 de/audi/app/car/common/util/CarDistance 
.const [127] = Class [126] 
.const [128] = Utf8 de/audi/atip/metrics/Distance 
.const [129] = Class [128] 
.const [130] = Utf8 TEXT_NO_DISTANCE 
.const [131] = Utf8 Ljava/lang/String; 
.const [132] = Utf8 undefinedDistance 
.const [133] = Utf8 Z 
.const [134] = Utf8 Code 
.const [135] = Utf8 <init> 
.const [136] = Utf8 ()V 
.const [137] = Utf8 <init> 
.const [138] = Utf8 (FI)V 
.const [139] = Utf8 format 
.const [140] = Utf8 (I)Ljava/lang/String; 
.const [141] = Utf8 getFormattedUnit 
.const [142] = Utf8 (I)Ljava/lang/String; 
.const [143] = Utf8 getFormattedValue 
.const [144] = Utf8 (I)Ljava/lang/String; 
.end class 
