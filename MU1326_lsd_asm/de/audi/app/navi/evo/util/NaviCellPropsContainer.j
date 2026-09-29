.version 50 0 
.class public super [103] 
.super [105] 
.field private [106] [107] 
.field private [108] [109] 

.method public [111] : [112] 
    .attribute [110] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [11] 
L4:     aload_0 
L5:     new [14] 
L8:     dup 
L9:     invokespecial [12] 
L12:    putfield [15] 
L15:    return 
L16:    
    .end code 
.end method 

.method public [113] : [114] 
    .attribute [110] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [8] 
L4:     new [16] 
L7:     dup 
L8:     iload_1 
L9:     invokespecial [13] 
L12:    invokeinterface [17] 0 
L17:    pop 
L18:    return 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [115] : [116] 
    .attribute [110] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [8] 
L4:     new [16] 
L7:     dup 
L8:     iload_1 
L9:     invokespecial [13] 
L12:    invokeinterface [18] 0 
L17:    pop 
L18:    return 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [117] : [118] 
    .attribute [110] .code stack 3 locals 3 
L0:     aload_0 
L1:     getfield [8] 
L4:     invokeinterface [19] 0 
L9:     newarray int 
L11:    astore_1 
L12:    aload_0 
L13:    getfield [8] 
L16:    invokeinterface [20] 0 
L21:    astore_2 
L22:    iconst_0 
L23:    istore_3 
L24:    aload_2 
L25:    invokeinterface [21] 0 
L30:    ifeq L54 
L33:    aload_1 
L34:    iload_3 
L35:    aload_2 
L36:    invokeinterface [22] 0 
L41:    checkcast [3] 
L44:    invokevirtual [9] 
L47:    iastore 
L48:    iinc 3 1 
L51:    goto L24 
L54:    aload_1 
L55:    areturn 
L56:    
    .end code 
.end method 

.method public interface [119] : [120] 
    .attribute [110] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [10] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [121] : [122] 
    .attribute [110] .code stack 2 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     putfield [23] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [24] 
.const [3] = Class [25] 
.const [4] = Class [26] 
.const [5] = Class [27] 
.const [6] = Class [28] 
.const [7] = Class [29] 
.const [8] = Field [30] [31] 
.const [9] = Method [32] [33] 
.const [10] = Field [34] [35] 
.const [11] = Method [36] [37] 
.const [12] = Method [38] [39] 
.const [13] = Method [40] [41] 
.const [14] = Class [42] 
.const [15] = Field [43] [44] 
.const [16] = Class [45] 
.const [17] = InterfaceMethod [46] [47] 
.const [18] = InterfaceMethod [48] [49] 
.const [19] = InterfaceMethod [50] [51] 
.const [20] = InterfaceMethod [52] [53] 
.const [21] = InterfaceMethod [54] [55] 
.const [22] = InterfaceMethod [56] [57] 
.const [23] = Field [58] [59] 
.const [24] = Utf8 java/util/HashSet 
.const [25] = Utf8 java/lang/Integer 
.const [26] = Utf8 de/audi/app/navi/evo/util/NaviCellPropsContainer 
.const [27] = Utf8 java/lang/Object 
.const [28] = Utf8 java/util/Set 
.const [29] = Utf8 java/util/Iterator 
.const [30] = Class [60] 
.const [31] = NameAndType [61] [62] 
.const [32] = Class [63] 
.const [33] = NameAndType [64] [65] 
.const [34] = Class [66] 
.const [35] = NameAndType [67] [68] 
.const [36] = Class [69] 
.const [37] = NameAndType [70] [71] 
.const [38] = Class [72] 
.const [39] = NameAndType [73] [74] 
.const [40] = Class [75] 
.const [41] = NameAndType [76] [77] 
.const [42] = Utf8 java/util/HashSet 
.const [43] = Class [78] 
.const [44] = NameAndType [79] [80] 
.const [45] = Utf8 java/lang/Integer 
.const [46] = Class [81] 
.const [47] = NameAndType [82] [83] 
.const [48] = Class [84] 
.const [49] = NameAndType [85] [86] 
.const [50] = Class [87] 
.const [51] = NameAndType [88] [89] 
.const [52] = Class [90] 
.const [53] = NameAndType [91] [92] 
.const [54] = Class [93] 
.const [55] = NameAndType [94] [95] 
.const [56] = Class [96] 
.const [57] = NameAndType [97] [98] 
.const [58] = Class [99] 
.const [59] = NameAndType [100] [101] 
.const [60] = Utf8 de/audi/app/navi/evo/util/NaviCellPropsContainer 
.const [61] = Utf8 properties 
.const [62] = Utf8 Ljava/util/Set; 
.const [63] = Utf8 java/lang/Integer 
.const [64] = Utf8 intValue 
.const [65] = Utf8 ()I 
.const [66] = Utf8 de/audi/app/navi/evo/util/NaviCellPropsContainer 
.const [67] = Utf8 category 
.const [68] = Utf8 I 
.const [69] = Utf8 java/lang/Object 
.const [70] = Utf8 <init> 
.const [71] = Utf8 ()V 
.const [72] = Utf8 java/util/HashSet 
.const [73] = Utf8 <init> 
.const [74] = Utf8 ()V 
.const [75] = Utf8 java/lang/Integer 
.const [76] = Utf8 <init> 
.const [77] = Utf8 (I)V 
.const [78] = Utf8 de/audi/app/navi/evo/util/NaviCellPropsContainer 
.const [79] = Utf8 properties 
.const [80] = Utf8 Ljava/util/Set; 
.const [81] = Utf8 java/util/Set 
.const [82] = Utf8 add 
.const [83] = Utf8 (Ljava/lang/Object;)Z 
.const [84] = Utf8 java/util/Set 
.const [85] = Utf8 remove 
.const [86] = Utf8 (Ljava/lang/Object;)Z 
.const [87] = Utf8 java/util/Set 
.const [88] = Utf8 size 
.const [89] = Utf8 ()I 
.const [90] = Utf8 java/util/Set 
.const [91] = Utf8 iterator 
.const [92] = Utf8 ()Ljava/util/Iterator; 
.const [93] = Utf8 java/util/Iterator 
.const [94] = Utf8 hasNext 
.const [95] = Utf8 ()Z 
.const [96] = Utf8 java/util/Iterator 
.const [97] = Utf8 next 
.const [98] = Utf8 ()Ljava/lang/Object; 
.const [99] = Utf8 de/audi/app/navi/evo/util/NaviCellPropsContainer 
.const [100] = Utf8 category 
.const [101] = Utf8 I 
.const [102] = Utf8 de/audi/app/navi/evo/util/NaviCellPropsContainer 
.const [103] = Class [102] 
.const [104] = Utf8 java/lang/Object 
.const [105] = Class [104] 
.const [106] = Utf8 category 
.const [107] = Utf8 I 
.const [108] = Utf8 properties 
.const [109] = Utf8 Ljava/util/Set; 
.const [110] = Utf8 Code 
.const [111] = Utf8 <init> 
.const [112] = Utf8 ()V 
.const [113] = Utf8 addProperty 
.const [114] = Utf8 (I)V 
.const [115] = Utf8 removeProperty 
.const [116] = Utf8 (I)V 
.const [117] = Utf8 getProperties 
.const [118] = Utf8 ()[I 
.const [119] = Utf8 getCategory 
.const [120] = Utf8 ()I 
.const [121] = Utf8 setCategory 
.const [122] = Utf8 (I)V 
.end class 
