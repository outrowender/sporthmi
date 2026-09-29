.version 50 0 
.class super [93] 
.super [95] 
.field private final [96] [97] 

.method public [99] : [100] 
    .attribute [98] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [16] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [19] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method interface [101] : [102] 
    .attribute [98] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [10] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [103] : [104] 
    .attribute [98] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [10] 
L4:     getfield [11] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public [105] : [106] 
    .attribute [98] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [10] 
L4:     invokevirtual [12] 
L7:     return 
L8:     
    .end code 
.end method 

.method public [107] : [108] 
    .attribute [98] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokevirtual [13] 
L5:     ifeq L27 
L8:     aload_0 
L9:     getfield [10] 
L12:    aload_1 
L13:    checkcast [5] 
L16:    invokeinterface [20] 0 
L21:    invokevirtual [14] 
L24:    pop 
L25:    iconst_1 
L26:    areturn 
L27:    iconst_0 
L28:    areturn 
L29:    nop 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [109] : [110] 
    .attribute [98] .code stack 2 locals 1 
L0:     aload_1 
L1:     instanceof [5] 
L4:     ifeq L40 
L7:     aload_0 
L8:     getfield [10] 
L11:    aload_1 
L12:    checkcast [5] 
L15:    invokeinterface [20] 0 
L20:    invokestatic [6] 
L23:    astore_2 
L24:    aload_2 
L25:    ifnull L38 
L28:    aload_2 
L29:    aload_1 
L30:    invokevirtual [15] 
L33:    ifeq L38 
L36:    iconst_1 
L37:    areturn 
L38:    iconst_0 
L39:    areturn 
L40:    iconst_0 
L41:    areturn 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 

.method public [111] : [112] 
    .attribute [98] .code stack 5 locals 0 
L0:     new [21] 
L3:     dup 
L4:     new [22] 
L7:     dup 
L8:     aload_0 
L9:     invokespecial [17] 
L12:    aload_0 
L13:    getfield [10] 
L16:    invokespecial [18] 
L19:    areturn 
L20:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [23] 
.const [3] = Class [24] 
.const [4] = Class [25] 
.const [5] = Class [26] 
.const [6] = Method [27] [28] 
.const [7] = Class [29] 
.const [8] = Class [30] 
.const [9] = Class [31] 
.const [10] = Field [32] [33] 
.const [11] = Field [34] [35] 
.const [12] = Method [36] [37] 
.const [13] = Method [38] [39] 
.const [14] = Method [40] [41] 
.const [15] = Method [42] [43] 
.const [16] = Method [44] [45] 
.const [17] = Method [46] [47] 
.const [18] = Method [48] [49] 
.const [19] = Field [50] [51] 
.const [20] = InterfaceMethod [52] [53] 
.const [21] = Class [54] 
.const [22] = Class [55] 
.const [23] = Utf8 java/util/IdentityHashMap$IdentityHashMapEntrySet 
.const [24] = Utf8 java/util/AbstractSet 
.const [25] = Utf8 java/util/IdentityHashMap 
.const [26] = Utf8 java/util/Map$Entry 
.const [27] = Class [56] 
.const [28] = NameAndType [57] [58] 
.const [29] = Utf8 java/util/IdentityHashMap$IdentityHashMapEntry 
.const [30] = Utf8 java/util/IdentityHashMap$IdentityHashMapIterator 
.const [31] = Utf8 java/util/IdentityHashMap$1 
.const [32] = Class [59] 
.const [33] = NameAndType [60] [61] 
.const [34] = Class [62] 
.const [35] = NameAndType [63] [64] 
.const [36] = Class [65] 
.const [37] = NameAndType [66] [67] 
.const [38] = Class [68] 
.const [39] = NameAndType [69] [70] 
.const [40] = Class [71] 
.const [41] = NameAndType [72] [73] 
.const [42] = Class [74] 
.const [43] = NameAndType [75] [76] 
.const [44] = Class [77] 
.const [45] = NameAndType [78] [79] 
.const [46] = Class [80] 
.const [47] = NameAndType [81] [82] 
.const [48] = Class [83] 
.const [49] = NameAndType [84] [85] 
.const [50] = Class [86] 
.const [51] = NameAndType [87] [88] 
.const [52] = Class [89] 
.const [53] = NameAndType [90] [91] 
.const [54] = Utf8 java/util/IdentityHashMap$IdentityHashMapIterator 
.const [55] = Utf8 java/util/IdentityHashMap$1 
.const [56] = Utf8 java/util/IdentityHashMap 
.const [57] = Utf8 access$1 
.const [58] = Utf8 (Ljava/util/IdentityHashMap;Ljava/lang/Object;)Ljava/util/IdentityHashMap$IdentityHashMapEntry; 
.const [59] = Utf8 java/util/IdentityHashMap$IdentityHashMapEntrySet 
.const [60] = Utf8 associatedMap 
.const [61] = Utf8 Ljava/util/IdentityHashMap; 
.const [62] = Utf8 java/util/IdentityHashMap 
.const [63] = Utf8 size 
.const [64] = Utf8 I 
.const [65] = Utf8 java/util/IdentityHashMap 
.const [66] = Utf8 clear 
.const [67] = Utf8 ()V 
.const [68] = Utf8 java/util/IdentityHashMap$IdentityHashMapEntrySet 
.const [69] = Utf8 contains 
.const [70] = Utf8 (Ljava/lang/Object;)Z 
.const [71] = Utf8 java/util/IdentityHashMap 
.const [72] = Utf8 remove 
.const [73] = Utf8 (Ljava/lang/Object;)Ljava/lang/Object; 
.const [74] = Utf8 java/util/IdentityHashMap$IdentityHashMapEntry 
.const [75] = Utf8 equals 
.const [76] = Utf8 (Ljava/lang/Object;)Z 
.const [77] = Utf8 java/util/AbstractSet 
.const [78] = Utf8 <init> 
.const [79] = Utf8 ()V 
.const [80] = Utf8 java/util/IdentityHashMap$1 
.const [81] = Utf8 <init> 
.const [82] = Utf8 (Ljava/util/IdentityHashMap$IdentityHashMapEntrySet;)V 
.const [83] = Utf8 java/util/IdentityHashMap$IdentityHashMapIterator 
.const [84] = Utf8 <init> 
.const [85] = Utf8 (Ljava/util/MapEntry$Type;Ljava/util/IdentityHashMap;)V 
.const [86] = Utf8 java/util/IdentityHashMap$IdentityHashMapEntrySet 
.const [87] = Utf8 associatedMap 
.const [88] = Utf8 Ljava/util/IdentityHashMap; 
.const [89] = Utf8 java/util/Map$Entry 
.const [90] = Utf8 getKey 
.const [91] = Utf8 ()Ljava/lang/Object; 
.const [92] = Utf8 java/util/IdentityHashMap$IdentityHashMapEntrySet 
.const [93] = Class [92] 
.const [94] = Utf8 java/util/AbstractSet 
.const [95] = Class [94] 
.const [96] = Utf8 associatedMap 
.const [97] = Utf8 Ljava/util/IdentityHashMap; 
.const [98] = Utf8 Code 
.const [99] = Utf8 <init> 
.const [100] = Utf8 (Ljava/util/IdentityHashMap;)V 
.const [101] = Utf8 hashMap 
.const [102] = Utf8 ()Ljava/util/IdentityHashMap; 
.const [103] = Utf8 size 
.const [104] = Utf8 ()I 
.const [105] = Utf8 clear 
.const [106] = Utf8 ()V 
.const [107] = Utf8 remove 
.const [108] = Utf8 (Ljava/lang/Object;)Z 
.const [109] = Utf8 contains 
.const [110] = Utf8 (Ljava/lang/Object;)Z 
.const [111] = Utf8 iterator 
.const [112] = Utf8 ()Ljava/util/Iterator; 
.end class 
