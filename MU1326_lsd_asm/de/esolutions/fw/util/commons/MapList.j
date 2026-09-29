.version 50 0 
.class public super [91] 
.super [93] 
.field private [94] [95] 

.method public [97] : [98] 
    .attribute [96] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [9] 
L4:     aload_0 
L5:     new [12] 
L8:     dup 
L9:     invokespecial [10] 
L12:    putfield [13] 
L15:    return 
L16:    
    .end code 
.end method 

.method public [99] : [100] 
    .attribute [96] .code stack 2 locals 1 
L0:     aload_0 
L1:     getfield [8] 
L4:     aload_1 
L5:     invokeinterface [14] 0 
L10:    checkcast [3] 
L13:    astore_3 
L14:    aload_3 
L15:    ifnull L30 
L18:    aload_3 
L19:    aload_2 
L20:    invokeinterface [15] 0 
L25:    ifeq L30 
L28:    iconst_1 
L29:    areturn 
L30:    iconst_0 
L31:    areturn 
L32:    
    .end code 
.end method 

.method public [101] : [102] 
    .attribute [96] .code stack 3 locals 1 
L0:     aload_0 
L1:     getfield [8] 
L4:     aload_1 
L5:     invokeinterface [14] 0 
L10:    checkcast [3] 
L13:    astore_3 
L14:    aload_3 
L15:    ifnonnull L40 
L18:    new [16] 
L21:    dup 
L22:    bipush 10 
L24:    invokespecial [11] 
L27:    astore_3 
L28:    aload_0 
L29:    getfield [8] 
L32:    aload_1 
L33:    aload_3 
L34:    invokeinterface [17] 0 
L39:    pop 
L40:    aload_3 
L41:    aload_2 
L42:    invokeinterface [18] 0 
L47:    pop 
L48:    return 
L49:    nop 
L50:    nop 
L51:    nop 
L52:    
    .end code 
.end method 

.method public [103] : [104] 
    .attribute [96] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [8] 
L4:     aload_1 
L5:     invokeinterface [14] 0 
L10:    checkcast [3] 
L13:    areturn 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [105] : [106] 
    .attribute [96] .code stack 2 locals 1 
L0:     aload_0 
L1:     getfield [8] 
L4:     aload_1 
L5:     invokeinterface [14] 0 
L10:    checkcast [3] 
L13:    astore_3 
L14:    aload_3 
L15:    ifnonnull L19 
L18:    return 
L19:    aload_3 
L20:    aload_2 
L21:    invokeinterface [19] 0 
L26:    pop 
L27:    aload_3 
L28:    invokeinterface [20] 0 
L33:    ifeq L47 
L36:    aload_0 
L37:    getfield [8] 
L40:    aload_1 
L41:    invokeinterface [21] 0 
L46:    pop 
L47:    return 
L48:    
    .end code 
.end method 

.method public [107] : [108] 
    .attribute [96] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [8] 
L4:     aload_1 
L5:     invokeinterface [21] 0 
L10:    pop 
L11:    return 
L12:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [22] 
.const [3] = Class [23] 
.const [4] = Class [24] 
.const [5] = Class [25] 
.const [6] = Class [26] 
.const [7] = Class [27] 
.const [8] = Field [28] [29] 
.const [9] = Method [30] [31] 
.const [10] = Method [32] [33] 
.const [11] = Method [34] [35] 
.const [12] = Class [36] 
.const [13] = Field [37] [38] 
.const [14] = InterfaceMethod [39] [40] 
.const [15] = InterfaceMethod [41] [42] 
.const [16] = Class [43] 
.const [17] = InterfaceMethod [44] [45] 
.const [18] = InterfaceMethod [46] [47] 
.const [19] = InterfaceMethod [48] [49] 
.const [20] = InterfaceMethod [50] [51] 
.const [21] = InterfaceMethod [52] [53] 
.const [22] = Utf8 java/util/HashMap 
.const [23] = Utf8 java/util/List 
.const [24] = Utf8 java/util/ArrayList 
.const [25] = Utf8 de/esolutions/fw/util/commons/MapList 
.const [26] = Utf8 java/lang/Object 
.const [27] = Utf8 java/util/Map 
.const [28] = Class [54] 
.const [29] = NameAndType [55] [56] 
.const [30] = Class [57] 
.const [31] = NameAndType [58] [59] 
.const [32] = Class [60] 
.const [33] = NameAndType [61] [62] 
.const [34] = Class [63] 
.const [35] = NameAndType [64] [65] 
.const [36] = Utf8 java/util/HashMap 
.const [37] = Class [66] 
.const [38] = NameAndType [67] [68] 
.const [39] = Class [69] 
.const [40] = NameAndType [70] [71] 
.const [41] = Class [72] 
.const [42] = NameAndType [73] [74] 
.const [43] = Utf8 java/util/ArrayList 
.const [44] = Class [75] 
.const [45] = NameAndType [76] [77] 
.const [46] = Class [78] 
.const [47] = NameAndType [79] [80] 
.const [48] = Class [81] 
.const [49] = NameAndType [82] [83] 
.const [50] = Class [84] 
.const [51] = NameAndType [85] [86] 
.const [52] = Class [87] 
.const [53] = NameAndType [88] [89] 
.const [54] = Utf8 de/esolutions/fw/util/commons/MapList 
.const [55] = Utf8 map 
.const [56] = Utf8 Ljava/util/Map; 
.const [57] = Utf8 java/lang/Object 
.const [58] = Utf8 <init> 
.const [59] = Utf8 ()V 
.const [60] = Utf8 java/util/HashMap 
.const [61] = Utf8 <init> 
.const [62] = Utf8 ()V 
.const [63] = Utf8 java/util/ArrayList 
.const [64] = Utf8 <init> 
.const [65] = Utf8 (I)V 
.const [66] = Utf8 de/esolutions/fw/util/commons/MapList 
.const [67] = Utf8 map 
.const [68] = Utf8 Ljava/util/Map; 
.const [69] = Utf8 java/util/Map 
.const [70] = Utf8 get 
.const [71] = Utf8 (Ljava/lang/Object;)Ljava/lang/Object; 
.const [72] = Utf8 java/util/List 
.const [73] = Utf8 contains 
.const [74] = Utf8 (Ljava/lang/Object;)Z 
.const [75] = Utf8 java/util/Map 
.const [76] = Utf8 put 
.const [77] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 
.const [78] = Utf8 java/util/List 
.const [79] = Utf8 add 
.const [80] = Utf8 (Ljava/lang/Object;)Z 
.const [81] = Utf8 java/util/List 
.const [82] = Utf8 remove 
.const [83] = Utf8 (Ljava/lang/Object;)Z 
.const [84] = Utf8 java/util/List 
.const [85] = Utf8 isEmpty 
.const [86] = Utf8 ()Z 
.const [87] = Utf8 java/util/Map 
.const [88] = Utf8 remove 
.const [89] = Utf8 (Ljava/lang/Object;)Ljava/lang/Object; 
.const [90] = Utf8 de/esolutions/fw/util/commons/MapList 
.const [91] = Class [90] 
.const [92] = Utf8 java/lang/Object 
.const [93] = Class [92] 
.const [94] = Utf8 map 
.const [95] = Utf8 Ljava/util/Map; 
.const [96] = Utf8 Code 
.const [97] = Utf8 <init> 
.const [98] = Utf8 ()V 
.const [99] = Utf8 contains 
.const [100] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)Z 
.const [101] = Utf8 add 
.const [102] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)V 
.const [103] = Utf8 get 
.const [104] = Utf8 (Ljava/lang/Object;)Ljava/util/List; 
.const [105] = Utf8 remove 
.const [106] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)V 
.const [107] = Utf8 removeAll 
.const [108] = Utf8 (Ljava/lang/Object;)V 
.end class 
