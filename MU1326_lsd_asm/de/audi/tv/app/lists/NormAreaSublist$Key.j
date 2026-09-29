.version 50 0 
.class super [109] 
.super [111] 
.field final [112] [113] 
.field final [114] [115] 
.field final [116] [117] 

.method [119] : [120] 
    .attribute [118] .code stack 5 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     getfield [6] 
L5:     aload_1 
L6:     getfield [7] 
L9:     aload_1 
L10:    getfield [8] 
L13:    invokespecial [16] 
L16:    return 
L17:    nop 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method [121] : [122] 
    .attribute [118] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [17] 
L4:     aload_0 
L5:     lload_1 
L6:     putfield [19] 
L9:     aload_0 
L10:    iload_3 
L11:    putfield [20] 
L14:    aload_0 
L15:    iload 4 
L17:    putfield [21] 
L20:    return 
L21:    nop 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [123] : [124] 
    .attribute [118] .code stack 6 locals 2 
L0:     iconst_1 
L1:     istore_2 
L2:     bipush 31 
L4:     iload_2 
L5:     imul 
L6:     aload_0 
L7:     getfield [9] 
L10:    aload_0 
L11:    getfield [9] 
L14:    bipush 32 
L16:    lushr 
L17:    lxor 
L18:    l2i 
L19:    iadd 
L20:    istore_2 
L21:    bipush 31 
L23:    iload_2 
L24:    imul 
L25:    aload_0 
L26:    getfield [11] 
L29:    iadd 
L30:    istore_2 
L31:    bipush 31 
L33:    iload_2 
L34:    imul 
L35:    aload_0 
L36:    getfield [10] 
L39:    iadd 
L40:    istore_2 
L41:    iload_2 
L42:    areturn 
L43:    nop 
L44:    
    .end code 
.end method 

.method public [125] : [126] 
    .attribute [118] .code stack 4 locals 1 
L0:     aload_0 
L1:     aload_1 
L2:     if_acmpne L7 
L5:     iconst_1 
L6:     areturn 
L7:     aload_1 
L8:     ifnonnull L13 
L11:    iconst_0 
L12:    areturn 
L13:    aload_1 
L14:    instanceof [2] 
L17:    ifne L22 
L20:    iconst_0 
L21:    areturn 
L22:    aload_1 
L23:    checkcast [2] 
L26:    astore_2 
L27:    aload_0 
L28:    getfield [9] 
L31:    aload_2 
L32:    getfield [9] 
L35:    lcmp 
L36:    ifeq L41 
L39:    iconst_0 
L40:    areturn 
L41:    aload_0 
L42:    getfield [11] 
L45:    aload_2 
L46:    getfield [11] 
L49:    if_icmpeq L54 
L52:    iconst_0 
L53:    areturn 
L54:    aload_0 
L55:    getfield [10] 
L58:    aload_2 
L59:    getfield [10] 
L62:    if_icmpeq L67 
L65:    iconst_0 
L66:    areturn 
L67:    iconst_1 
L68:    areturn 
L69:    nop 
L70:    nop 
L71:    nop 
L72:    
    .end code 
.end method 

.method public [127] : [128] 
    .attribute [118] .code stack 3 locals 0 
L0:     new [22] 
L3:     dup 
L4:     invokespecial [18] 
L7:     aload_0 
L8:     getfield [9] 
L11:    invokevirtual [12] 
L14:    bipush 44 
L16:    invokevirtual [13] 
L19:    aload_0 
L20:    getfield [10] 
L23:    invokevirtual [14] 
L26:    bipush 44 
L28:    invokevirtual [13] 
L31:    aload_0 
L32:    getfield [11] 
L35:    invokevirtual [14] 
L38:    invokevirtual [15] 
L41:    areturn 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [23] 
.const [3] = Class [24] 
.const [4] = Class [25] 
.const [5] = Class [26] 
.const [6] = Field [27] [28] 
.const [7] = Field [29] [30] 
.const [8] = Field [31] [32] 
.const [9] = Field [33] [34] 
.const [10] = Field [35] [36] 
.const [11] = Field [37] [38] 
.const [12] = Method [39] [40] 
.const [13] = Method [41] [42] 
.const [14] = Method [43] [44] 
.const [15] = Method [45] [46] 
.const [16] = Method [47] [48] 
.const [17] = Method [49] [50] 
.const [18] = Method [51] [52] 
.const [19] = Field [53] [54] 
.const [20] = Field [55] [56] 
.const [21] = Field [57] [58] 
.const [22] = Class [59] 
.const [23] = Utf8 de/audi/tv/app/lists/NormAreaSublist$Key 
.const [24] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [25] = Utf8 java/lang/Object 
.const [26] = Utf8 org/dsi/ifc/tvtuner/ServiceInfo 
.const [27] = Class [60] 
.const [28] = NameAndType [61] [62] 
.const [29] = Class [63] 
.const [30] = NameAndType [64] [65] 
.const [31] = Class [66] 
.const [32] = NameAndType [67] [68] 
.const [33] = Class [69] 
.const [34] = NameAndType [70] [71] 
.const [35] = Class [72] 
.const [36] = NameAndType [73] [74] 
.const [37] = Class [75] 
.const [38] = NameAndType [76] [77] 
.const [39] = Class [78] 
.const [40] = NameAndType [79] [80] 
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
.const [59] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [60] = Utf8 org/dsi/ifc/tvtuner/ServiceInfo 
.const [61] = Utf8 namePID 
.const [62] = Utf8 J 
.const [63] = Utf8 org/dsi/ifc/tvtuner/ServiceInfo 
.const [64] = Utf8 servicePID 
.const [65] = Utf8 I 
.const [66] = Utf8 org/dsi/ifc/tvtuner/ServiceInfo 
.const [67] = Utf8 sType 
.const [68] = Utf8 I 
.const [69] = Utf8 de/audi/tv/app/lists/NormAreaSublist$Key 
.const [70] = Utf8 namePID 
.const [71] = Utf8 J 
.const [72] = Utf8 de/audi/tv/app/lists/NormAreaSublist$Key 
.const [73] = Utf8 servicePID 
.const [74] = Utf8 I 
.const [75] = Utf8 de/audi/tv/app/lists/NormAreaSublist$Key 
.const [76] = Utf8 sType 
.const [77] = Utf8 I 
.const [78] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [79] = Utf8 append 
.const [80] = Utf8 (J)Lde/esolutions/fw/util/commons/Buffer; 
.const [81] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [82] = Utf8 append 
.const [83] = Utf8 (C)Lde/esolutions/fw/util/commons/Buffer; 
.const [84] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [85] = Utf8 append 
.const [86] = Utf8 (I)Lde/esolutions/fw/util/commons/Buffer; 
.const [87] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [88] = Utf8 toString 
.const [89] = Utf8 ()Ljava/lang/String; 
.const [90] = Utf8 de/audi/tv/app/lists/NormAreaSublist$Key 
.const [91] = Utf8 <init> 
.const [92] = Utf8 (JII)V 
.const [93] = Utf8 java/lang/Object 
.const [94] = Utf8 <init> 
.const [95] = Utf8 ()V 
.const [96] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [97] = Utf8 <init> 
.const [98] = Utf8 ()V 
.const [99] = Utf8 de/audi/tv/app/lists/NormAreaSublist$Key 
.const [100] = Utf8 namePID 
.const [101] = Utf8 J 
.const [102] = Utf8 de/audi/tv/app/lists/NormAreaSublist$Key 
.const [103] = Utf8 servicePID 
.const [104] = Utf8 I 
.const [105] = Utf8 de/audi/tv/app/lists/NormAreaSublist$Key 
.const [106] = Utf8 sType 
.const [107] = Utf8 I 
.const [108] = Utf8 de/audi/tv/app/lists/NormAreaSublist$Key 
.const [109] = Class [108] 
.const [110] = Utf8 java/lang/Object 
.const [111] = Class [110] 
.const [112] = Utf8 namePID 
.const [113] = Utf8 J 
.const [114] = Utf8 servicePID 
.const [115] = Utf8 I 
.const [116] = Utf8 sType 
.const [117] = Utf8 I 
.const [118] = Utf8 Code 
.const [119] = Utf8 <init> 
.const [120] = Utf8 (Lorg/dsi/ifc/tvtuner/ServiceInfo;)V 
.const [121] = Utf8 <init> 
.const [122] = Utf8 (JII)V 
.const [123] = Utf8 hashCode 
.const [124] = Utf8 ()I 
.const [125] = Utf8 equals 
.const [126] = Utf8 (Ljava/lang/Object;)Z 
.const [127] = Utf8 toString 
.const [128] = Utf8 ()Ljava/lang/String; 
.end class 
