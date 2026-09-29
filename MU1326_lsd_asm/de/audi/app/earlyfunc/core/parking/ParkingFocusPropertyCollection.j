.version 50 0 
.class public super [85] 
.super [87] 
.field private final [88] [89] 

.method public [91] : [92] 
    .attribute [90] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [10] 
L4:     aload_0 
L5:     new [13] 
L8:     dup 
L9:     invokespecial [11] 
L12:    putfield [14] 
L15:    return 
L16:    
    .end code 
.end method 

.method public [93] : [94] 
    .attribute [90] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [8] 
L4:     new [15] 
L7:     dup 
L8:     iload_1 
L9:     invokespecial [12] 
L12:    invokeinterface [16] 0 
L17:    pop 
L18:    return 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [95] : [96] 
    .attribute [90] .code stack 3 locals 3 
L0:     aload_0 
L1:     getfield [8] 
L4:     invokeinterface [17] 0 
L9:     newarray int 
L11:    astore_1 
L12:    aload_0 
L13:    getfield [8] 
L16:    invokeinterface [18] 0 
L21:    astore_2 
L22:    iconst_0 
L23:    istore_3 
L24:    aload_2 
L25:    invokeinterface [19] 0 
L30:    ifeq L54 
L33:    aload_1 
L34:    iload_3 
L35:    aload_2 
L36:    invokeinterface [20] 0 
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
.const [1] = Int 0 
.const [2] = Class [21] 
.const [3] = Class [22] 
.const [4] = Class [23] 
.const [5] = Class [24] 
.const [6] = Class [25] 
.const [7] = Class [26] 
.const [8] = Field [27] [28] 
.const [9] = Method [29] [30] 
.const [10] = Method [31] [32] 
.const [11] = Method [33] [34] 
.const [12] = Method [35] [36] 
.const [13] = Class [37] 
.const [14] = Field [38] [39] 
.const [15] = Class [40] 
.const [16] = InterfaceMethod [41] [42] 
.const [17] = InterfaceMethod [43] [44] 
.const [18] = InterfaceMethod [45] [46] 
.const [19] = InterfaceMethod [47] [48] 
.const [20] = InterfaceMethod [49] [50] 
.const [21] = Utf8 java/util/HashSet 
.const [22] = Utf8 java/lang/Integer 
.const [23] = Utf8 de/audi/app/earlyfunc/core/parking/ParkingFocusPropertyCollection 
.const [24] = Utf8 java/lang/Object 
.const [25] = Utf8 java/util/Set 
.const [26] = Utf8 java/util/Iterator 
.const [27] = Class [51] 
.const [28] = NameAndType [52] [53] 
.const [29] = Class [54] 
.const [30] = NameAndType [55] [56] 
.const [31] = Class [57] 
.const [32] = NameAndType [58] [59] 
.const [33] = Class [60] 
.const [34] = NameAndType [61] [62] 
.const [35] = Class [63] 
.const [36] = NameAndType [64] [65] 
.const [37] = Utf8 java/util/HashSet 
.const [38] = Class [66] 
.const [39] = NameAndType [67] [68] 
.const [40] = Utf8 java/lang/Integer 
.const [41] = Class [69] 
.const [42] = NameAndType [70] [71] 
.const [43] = Class [72] 
.const [44] = NameAndType [73] [74] 
.const [45] = Class [75] 
.const [46] = NameAndType [76] [77] 
.const [47] = Class [78] 
.const [48] = NameAndType [79] [80] 
.const [49] = Class [81] 
.const [50] = NameAndType [82] [83] 
.const [51] = Utf8 de/audi/app/earlyfunc/core/parking/ParkingFocusPropertyCollection 
.const [52] = Utf8 focusPropertyIDs 
.const [53] = Utf8 Ljava/util/Set; 
.const [54] = Utf8 java/lang/Integer 
.const [55] = Utf8 intValue 
.const [56] = Utf8 ()I 
.const [57] = Utf8 java/lang/Object 
.const [58] = Utf8 <init> 
.const [59] = Utf8 ()V 
.const [60] = Utf8 java/util/HashSet 
.const [61] = Utf8 <init> 
.const [62] = Utf8 ()V 
.const [63] = Utf8 java/lang/Integer 
.const [64] = Utf8 <init> 
.const [65] = Utf8 (I)V 
.const [66] = Utf8 de/audi/app/earlyfunc/core/parking/ParkingFocusPropertyCollection 
.const [67] = Utf8 focusPropertyIDs 
.const [68] = Utf8 Ljava/util/Set; 
.const [69] = Utf8 java/util/Set 
.const [70] = Utf8 add 
.const [71] = Utf8 (Ljava/lang/Object;)Z 
.const [72] = Utf8 java/util/Set 
.const [73] = Utf8 size 
.const [74] = Utf8 ()I 
.const [75] = Utf8 java/util/Set 
.const [76] = Utf8 iterator 
.const [77] = Utf8 ()Ljava/util/Iterator; 
.const [78] = Utf8 java/util/Iterator 
.const [79] = Utf8 hasNext 
.const [80] = Utf8 ()Z 
.const [81] = Utf8 java/util/Iterator 
.const [82] = Utf8 next 
.const [83] = Utf8 ()Ljava/lang/Object; 
.const [84] = Utf8 de/audi/app/earlyfunc/core/parking/ParkingFocusPropertyCollection 
.const [85] = Class [84] 
.const [86] = Utf8 java/lang/Object 
.const [87] = Class [86] 
.const [88] = Utf8 focusPropertyIDs 
.const [89] = Utf8 Ljava/util/Set; 
.const [90] = Utf8 Code 
.const [91] = Utf8 <init> 
.const [92] = Utf8 ()V 
.const [93] = Utf8 addFocusProperty 
.const [94] = Utf8 (I)V 
.const [95] = Utf8 getFocusPropertyArray 
.const [96] = Utf8 ()[I 
.end class 
