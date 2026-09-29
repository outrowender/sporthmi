.version 50 0 
.class public super [89] 
.super [91] 
.implements [93] 
.field private final [94] [95] 
.field private final [96] [97] 
.field private [98] [99] 

.method public [101] : [102] 
    .attribute [100] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [12] 
L4:     aload_0 
L5:     iconst_0 
L6:     putfield [16] 
L9:     aload_0 
L10:    aload_1 
L11:    putfield [17] 
L14:    aload_0 
L15:    iload_2 
L16:    putfield [18] 
L19:    return 
L20:    
    .end code 
.end method 

.method public [103] : [104] 
    .attribute [100] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [7] 
L4:     aload_0 
L5:     getfield [9] 
L8:     if_icmpge L15 
L11:    iconst_1 
L12:    goto L16 
L15:    iconst_0 
L16:    areturn 
L17:    nop 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [105] : [106] 
    .attribute [100] .code stack 3 locals 1 
L0:     aload_0 
L1:     invokespecial [13] 
L4:     astore_1 
L5:     aload_0 
L6:     dup 
L7:     getfield [7] 
L10:    iconst_1 
L11:    iadd 
L12:    putfield [16] 
L15:    aload_1 
L16:    areturn 
L17:    nop 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method private [107] : [108] 
    .attribute [100] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [7] 
L4:     ifne L12 
L7:     aload_0 
L8:     getfield [8] 
L11:    areturn 
L12:    new [19] 
L15:    dup 
L16:    aload_0 
L17:    getfield [8] 
L20:    getfield [10] 
L23:    aload_0 
L24:    getfield [8] 
L27:    getfield [11] 
L30:    aload_0 
L31:    getfield [7] 
L34:    iadd 
L35:    invokespecial [14] 
L38:    areturn 
L39:    nop 
L40:    
    .end code 
.end method 

.method public [109] : [110] 
    .attribute [100] .code stack 3 locals 0 
L0:     new [20] 
L3:     dup 
L4:     ldc [4] 
L6:     invokespecial [15] 
L9:     athrow 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [21] 
.const [3] = Class [22] 
.const [4] = String [23] 
.const [5] = Class [24] 
.const [6] = Class [25] 
.const [7] = Field [26] [27] 
.const [8] = Field [28] [29] 
.const [9] = Field [30] [31] 
.const [10] = Field [32] [33] 
.const [11] = Field [34] [35] 
.const [12] = Method [36] [37] 
.const [13] = Method [38] [39] 
.const [14] = Method [40] [41] 
.const [15] = Method [42] [43] 
.const [16] = Field [44] [45] 
.const [17] = Field [46] [47] 
.const [18] = Field [48] [49] 
.const [19] = Class [50] 
.const [20] = Class [51] 
.const [21] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuItemIndex 
.const [22] = Utf8 java/lang/IllegalStateException 
.const [23] = Utf8 'Remove menu items is not supported' 
.const [24] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuIndexIteratorWithLength 
.const [25] = Utf8 java/lang/Object 
.const [26] = Class [52] 
.const [27] = NameAndType [53] [54] 
.const [28] = Class [55] 
.const [29] = NameAndType [56] [57] 
.const [30] = Class [58] 
.const [31] = NameAndType [59] [60] 
.const [32] = Class [61] 
.const [33] = NameAndType [62] [63] 
.const [34] = Class [64] 
.const [35] = NameAndType [65] [66] 
.const [36] = Class [67] 
.const [37] = NameAndType [68] [69] 
.const [38] = Class [70] 
.const [39] = NameAndType [71] [72] 
.const [40] = Class [73] 
.const [41] = NameAndType [74] [75] 
.const [42] = Class [76] 
.const [43] = NameAndType [77] [78] 
.const [44] = Class [79] 
.const [45] = NameAndType [80] [81] 
.const [46] = Class [82] 
.const [47] = NameAndType [83] [84] 
.const [48] = Class [85] 
.const [49] = NameAndType [86] [87] 
.const [50] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuItemIndex 
.const [51] = Utf8 java/lang/IllegalStateException 
.const [52] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuIndexIteratorWithLength 
.const [53] = Utf8 next 
.const [54] = Utf8 I 
.const [55] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuIndexIteratorWithLength 
.const [56] = Utf8 startIndex 
.const [57] = Utf8 Lde/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuItemIndex; 
.const [58] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuIndexIteratorWithLength 
.const [59] = Utf8 length 
.const [60] = Utf8 I 
.const [61] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuItemIndex 
.const [62] = Utf8 widget 
.const [63] = Utf8 I 
.const [64] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuItemIndex 
.const [65] = Utf8 widgetPart 
.const [66] = Utf8 I 
.const [67] = Utf8 java/lang/Object 
.const [68] = Utf8 <init> 
.const [69] = Utf8 ()V 
.const [70] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuIndexIteratorWithLength 
.const [71] = Utf8 getNextIndex 
.const [72] = Utf8 ()Lde/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuItemIndex; 
.const [73] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuItemIndex 
.const [74] = Utf8 <init> 
.const [75] = Utf8 (II)V 
.const [76] = Utf8 java/lang/IllegalStateException 
.const [77] = Utf8 <init> 
.const [78] = Utf8 (Ljava/lang/String;)V 
.const [79] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuIndexIteratorWithLength 
.const [80] = Utf8 next 
.const [81] = Utf8 I 
.const [82] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuIndexIteratorWithLength 
.const [83] = Utf8 startIndex 
.const [84] = Utf8 Lde/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuItemIndex; 
.const [85] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuIndexIteratorWithLength 
.const [86] = Utf8 length 
.const [87] = Utf8 I 
.const [88] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuIndexIteratorWithLength 
.const [89] = Class [88] 
.const [90] = Utf8 java/lang/Object 
.const [91] = Class [90] 
.const [92] = Utf8 java/util/Iterator 
.const [93] = Class [92] 
.const [94] = Utf8 startIndex 
.const [95] = Utf8 Lde/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuItemIndex; 
.const [96] = Utf8 length 
.const [97] = Utf8 I 
.const [98] = Utf8 next 
.const [99] = Utf8 I 
.const [100] = Utf8 Code 
.const [101] = Utf8 <init> 
.const [102] = Utf8 (Lde/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuItemIndex;I)V 
.const [103] = Utf8 hasNext 
.const [104] = Utf8 ()Z 
.const [105] = Utf8 next 
.const [106] = Utf8 ()Ljava/lang/Object; 
.const [107] = Utf8 getNextIndex 
.const [108] = Utf8 ()Lde/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuItemIndex; 
.const [109] = Utf8 remove 
.const [110] = Utf8 ()V 
.end class 
