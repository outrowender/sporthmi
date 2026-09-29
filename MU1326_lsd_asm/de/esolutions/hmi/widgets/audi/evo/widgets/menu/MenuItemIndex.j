.version 50 0 
.class public super [109] 
.super [111] 
.implements [113] 
.field public static final [114] [115] 
.field public final [116] [117] 
.field public final [118] [119] 

.method public static [121] : [122] 
    .attribute [120] .code stack 2 locals 0 
L0:     aload_0 
L1:     ifnonnull L6 
L4:     aload_1 
L5:     areturn 
L6:     aload_1 
L7:     ifnonnull L12 
L10:    aload_0 
L11:    areturn 
L12:    aload_0 
L13:    aload_1 
L14:    invokevirtual [9] 
L17:    ifeq L22 
L20:    aload_0 
L21:    areturn 
L22:    aload_1 
L23:    areturn 
L24:    
    .end code 
.end method 

.method public static [123] : [124] 
    .attribute [120] .code stack 2 locals 0 
L0:     aload_0 
L1:     ifnonnull L6 
L4:     aload_1 
L5:     areturn 
L6:     aload_1 
L7:     ifnonnull L12 
L10:    aload_0 
L11:    areturn 
L12:    aload_0 
L13:    aload_1 
L14:    invokevirtual [9] 
L17:    ifeq L22 
L20:    aload_1 
L21:    areturn 
L22:    aload_0 
L23:    areturn 
L24:    
    .end code 
.end method 

.method public [125] : [126] 
    .attribute [120] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [17] 
L4:     aload_0 
L5:     iload_1 
L6:     putfield [21] 
L9:     aload_0 
L10:    iload_2 
L11:    putfield [22] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [127] : [128] 
    .attribute [120] .code stack 2 locals 1 
L0:     aload_1 
L1:     aload_0 
L2:     if_acmpne L7 
L5:     iconst_1 
L6:     areturn 
L7:     aload_1 
L8:     instanceof [2] 
L11:    ifne L16 
L14:    iconst_0 
L15:    areturn 
L16:    aload_1 
L17:    checkcast [2] 
L20:    astore_2 
L21:    aload_0 
L22:    getfield [10] 
L25:    aload_2 
L26:    getfield [10] 
L29:    if_icmpne L47 
L32:    aload_0 
L33:    getfield [11] 
L36:    aload_2 
L37:    getfield [11] 
L40:    if_icmpne L47 
L43:    iconst_1 
L44:    goto L48 
L47:    iconst_0 
L48:    areturn 
L49:    nop 
L50:    nop 
L51:    nop 
L52:    
    .end code 
.end method 

.method public [129] : [130] 
    .attribute [120] .code stack 2 locals 0 
L0:     bipush 17 
L2:     aload_0 
L3:     getfield [10] 
L6:     iadd 
L7:     bipush 31 
L9:     imul 
L10:    aload_0 
L11:    getfield [11] 
L14:    iadd 
L15:    areturn 
L16:    
    .end code 
.end method 

.method public [131] : [132] 
    .attribute [120] .code stack 2 locals 2 
L0:     aload_1 
L1:     checkcast [2] 
L4:     astore_2 
L5:     aload_0 
L6:     getfield [10] 
L9:     aload_2 
L10:    getfield [10] 
L13:    isub 
L14:    istore_3 
L15:    iload_3 
L16:    ifeq L21 
L19:    iload_3 
L20:    areturn 
L21:    aload_0 
L22:    getfield [11] 
L25:    aload_2 
L26:    getfield [11] 
L29:    isub 
L30:    areturn 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [133] : [134] 
    .attribute [120] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokevirtual [12] 
L5:     ifge L12 
L8:     iconst_1 
L9:     goto L13 
L12:    iconst_0 
L13:    areturn 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [135] : [136] 
    .attribute [120] .code stack 2 locals 0 
L0:     new [24] 
L3:     dup 
L4:     invokespecial [18] 
L7:     aload_0 
L8:     getfield [10] 
L11:    invokevirtual [13] 
L14:    ldc [4] 
L16:    invokevirtual [14] 
L19:    aload_0 
L20:    getfield [11] 
L23:    invokevirtual [13] 
L26:    ldc [5] 
L28:    invokevirtual [14] 
L31:    invokevirtual [15] 
L34:    areturn 
L35:    nop 
L36:    
    .end code 
.end method 

.method public [137] : [138] 
    .attribute [120] .code stack 4 locals 1 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [19] 
L5:     ifeq L35 
L8:     aload_1 
L9:     getfield [11] 
L12:    aload_0 
L13:    getfield [11] 
L16:    iload_2 
L17:    isub 
L18:    invokestatic [6] 
L21:    istore_3 
L22:    new [23] 
L25:    dup 
L26:    aload_0 
L27:    getfield [10] 
L30:    iload_3 
L31:    invokespecial [20] 
L34:    areturn 
L35:    aload_0 
L36:    areturn 
L37:    nop 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 

.method private [139] : [140] 
    .attribute [120] .code stack 2 locals 0 
L0:     aload_1 
L1:     getfield [10] 
L4:     aload_0 
L5:     getfield [10] 
L8:     if_icmpne L26 
L11:    aload_1 
L12:    getfield [11] 
L15:    aload_0 
L16:    getfield [11] 
L19:    if_icmpge L26 
L22:    iconst_1 
L23:    goto L27 
L26:    iconst_0 
L27:    areturn 
L28:    
    .end code 
.end method 

.method public [141] : [142] 
    .attribute [120] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [10] 
L4:     iload_1 
L5:     if_icmpne L10 
L8:     aconst_null 
L9:     areturn 
L10:    aload_0 
L11:    getfield [10] 
L14:    iload_1 
L15:    if_icmple L36 
L18:    new [23] 
L21:    dup 
L22:    aload_0 
L23:    getfield [10] 
L26:    iconst_1 
L27:    isub 
L28:    aload_0 
L29:    getfield [11] 
L32:    invokespecial [20] 
L35:    areturn 
L36:    aload_0 
L37:    areturn 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 

.method public [143] : [144] 
    .attribute [120] .code stack 5 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokevirtual [16] 
L5:     ifeq L26 
L8:     new [23] 
L11:    dup 
L12:    aload_0 
L13:    getfield [10] 
L16:    aload_0 
L17:    getfield [11] 
L20:    iload_2 
L21:    iadd 
L22:    invokespecial [20] 
L25:    areturn 
L26:    aload_0 
L27:    areturn 
L28:    
    .end code 
.end method 

.method public [145] : [146] 
    .attribute [120] .code stack 2 locals 0 
L0:     aload_1 
L1:     getfield [10] 
L4:     aload_0 
L5:     getfield [10] 
L8:     if_icmpne L26 
L11:    aload_1 
L12:    getfield [11] 
L15:    aload_0 
L16:    getfield [11] 
L19:    if_icmpgt L26 
L22:    iconst_1 
L23:    goto L27 
L26:    iconst_0 
L27:    areturn 
L28:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [25] 
.const [3] = Class [26] 
.const [4] = String [27] 
.const [5] = String [28] 
.const [6] = Method [29] [30] 
.const [7] = Class [31] 
.const [8] = Class [32] 
.const [9] = Method [33] [34] 
.const [10] = Field [35] [36] 
.const [11] = Field [37] [38] 
.const [12] = Method [39] [40] 
.const [13] = Method [41] [42] 
.const [14] = Method [43] [44] 
.const [15] = Method [45] [46] 
.const [16] = Method [47] [48] 
.const [17] = Method [49] [50] 
.const [18] = Method [51] [52] 
.const [19] = Method [53] [54] 
.const [20] = Method [55] [56] 
.const [21] = Field [57] [58] 
.const [22] = Field [59] [60] 
.const [23] = Class [61] 
.const [24] = Class [62] 
.const [25] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuItemIndex 
.const [26] = Utf8 java/lang/StringBuffer 
.const [27] = Utf8 ( 
.const [28] = Utf8 ')' 
.const [29] = Class [63] 
.const [30] = NameAndType [64] [65] 
.const [31] = Utf8 java/lang/Object 
.const [32] = Utf8 java/lang/Math 
.const [33] = Class [66] 
.const [34] = NameAndType [67] [68] 
.const [35] = Class [69] 
.const [36] = NameAndType [70] [71] 
.const [37] = Class [72] 
.const [38] = NameAndType [73] [74] 
.const [39] = Class [75] 
.const [40] = NameAndType [76] [77] 
.const [41] = Class [78] 
.const [42] = NameAndType [79] [80] 
.const [43] = Class [81] 
.const [44] = NameAndType [82] [83] 
.const [45] = Class [84] 
.const [46] = NameAndType [85] [86] 
.const [47] = Class [87] 
.const [48] = NameAndType [88] [89] 
.const [49] = Class [90] 
.const [50] = NameAndType [91] [92] 
.const [51] = Class [93] 
.const [52] = NameAndType [94] [95] 
.const [53] = Class [96] 
.const [54] = NameAndType [97] [98] 
.const [55] = Class [99] 
.const [56] = NameAndType [100] [101] 
.const [57] = Class [102] 
.const [58] = NameAndType [103] [104] 
.const [59] = Class [105] 
.const [60] = NameAndType [106] [107] 
.const [61] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuItemIndex 
.const [62] = Utf8 java/lang/StringBuffer 
.const [63] = Utf8 java/lang/Math 
.const [64] = Utf8 max 
.const [65] = Utf8 (II)I 
.const [66] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuItemIndex 
.const [67] = Utf8 isBefore 
.const [68] = Utf8 (Lde/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuItemIndex;)Z 
.const [69] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuItemIndex 
.const [70] = Utf8 widget 
.const [71] = Utf8 I 
.const [72] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuItemIndex 
.const [73] = Utf8 widgetPart 
.const [74] = Utf8 I 
.const [75] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuItemIndex 
.const [76] = Utf8 compareTo 
.const [77] = Utf8 (Ljava/lang/Object;)I 
.const [78] = Utf8 java/lang/StringBuffer 
.const [79] = Utf8 append 
.const [80] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [81] = Utf8 java/lang/StringBuffer 
.const [82] = Utf8 append 
.const [83] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [84] = Utf8 java/lang/StringBuffer 
.const [85] = Utf8 toString 
.const [86] = Utf8 ()Ljava/lang/String; 
.const [87] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuItemIndex 
.const [88] = Utf8 needsAdjustmentForAdd 
.const [89] = Utf8 (Lde/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuItemIndex;)Z 
.const [90] = Utf8 java/lang/Object 
.const [91] = Utf8 <init> 
.const [92] = Utf8 ()V 
.const [93] = Utf8 java/lang/StringBuffer 
.const [94] = Utf8 <init> 
.const [95] = Utf8 ()V 
.const [96] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuItemIndex 
.const [97] = Utf8 needsAdjustmentForRemove 
.const [98] = Utf8 (Lde/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuItemIndex;)Z 
.const [99] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuItemIndex 
.const [100] = Utf8 <init> 
.const [101] = Utf8 (II)V 
.const [102] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuItemIndex 
.const [103] = Utf8 widget 
.const [104] = Utf8 I 
.const [105] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuItemIndex 
.const [106] = Utf8 widgetPart 
.const [107] = Utf8 I 
.const [108] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuItemIndex 
.const [109] = Class [108] 
.const [110] = Utf8 java/lang/Object 
.const [111] = Class [110] 
.const [112] = Utf8 java/lang/Comparable 
.const [113] = Class [112] 
.const [114] = Utf8 SINGLE_ITEM_PART 
.const [115] = Utf8 I 
.const [116] = Utf8 widget 
.const [117] = Utf8 I 
.const [118] = Utf8 widgetPart 
.const [119] = Utf8 I 
.const [120] = Utf8 Code 
.const [121] = Utf8 min 
.const [122] = Utf8 (Lde/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuItemIndex;Lde/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuItemIndex;)Lde/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuItemIndex; 
.const [123] = Utf8 max 
.const [124] = Utf8 (Lde/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuItemIndex;Lde/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuItemIndex;)Lde/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuItemIndex; 
.const [125] = Utf8 <init> 
.const [126] = Utf8 (II)V 
.const [127] = Utf8 equals 
.const [128] = Utf8 (Ljava/lang/Object;)Z 
.const [129] = Utf8 hashCode 
.const [130] = Utf8 ()I 
.const [131] = Utf8 compareTo 
.const [132] = Utf8 (Ljava/lang/Object;)I 
.const [133] = Utf8 isBefore 
.const [134] = Utf8 (Lde/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuItemIndex;)Z 
.const [135] = Utf8 toString 
.const [136] = Utf8 ()Ljava/lang/String; 
.const [137] = Utf8 adjustForRemove 
.const [138] = Utf8 (Lde/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuItemIndex;I)Lde/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuItemIndex; 
.const [139] = Utf8 needsAdjustmentForRemove 
.const [140] = Utf8 (Lde/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuItemIndex;)Z 
.const [141] = Utf8 adjustForRemoveMenuChild 
.const [142] = Utf8 (I)Lde/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuItemIndex; 
.const [143] = Utf8 adjustForAdd 
.const [144] = Utf8 (Lde/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuItemIndex;I)Lde/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuItemIndex; 
.const [145] = Utf8 needsAdjustmentForAdd 
.const [146] = Utf8 (Lde/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuItemIndex;)Z 
.end class 
