.version 50 0 
.class public super abstract [101] 
.super [103] 
.implements [105] 

.method protected annotation [107] : [108] 
    .attribute [106] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [15] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [109] : [110] 
    .attribute [106] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokevirtual [11] 
L5:     ifeq L10 
L8:     iconst_1 
L9:     areturn 
L10:    new [20] 
L13:    dup 
L14:    ldc [3] 
L16:    invokespecial [16] 
L19:    athrow 
L20:    
    .end code 
.end method 

.method public [111] : [112] 
    .attribute [106] .code stack 2 locals 1 
L0:     aload_0 
L1:     invokevirtual [12] 
L4:     astore_1 
L5:     aload_1 
L6:     ifnull L11 
L9:     aload_1 
L10:    areturn 
L11:    new [21] 
L14:    dup 
L15:    invokespecial [17] 
L18:    athrow 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [113] : [114] 
    .attribute [106] .code stack 2 locals 1 
L0:     aload_0 
L1:     invokevirtual [13] 
L4:     astore_1 
L5:     aload_1 
L6:     ifnull L11 
L9:     aload_1 
L10:    areturn 
L11:    new [21] 
L14:    dup 
L15:    invokespecial [17] 
L18:    athrow 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [115] : [116] 
    .attribute [106] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokevirtual [12] 
L4:     ifnull L10 
L7:     goto L0 
L10:    return 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [117] : [118] 
    .attribute [106] .code stack 2 locals 2 
L0:     aload_1 
L1:     ifnonnull L12 
L4:     new [22] 
L7:     dup 
L8:     invokespecial [18] 
L11:    athrow 
L12:    aload_1 
L13:    aload_0 
L14:    if_acmpne L25 
L17:    new [23] 
L20:    dup 
L21:    invokespecial [19] 
L24:    athrow 
L25:    iconst_0 
L26:    istore_2 
L27:    aload_1 
L28:    invokeinterface [24] 0 
L33:    astore_3 
L34:    aload_3 
L35:    invokeinterface [25] 0 
L40:    ifeq L61 
L43:    aload_0 
L44:    aload_3 
L45:    invokeinterface [26] 0 
L50:    invokevirtual [14] 
L53:    ifeq L34 
L56:    iconst_1 
L57:    istore_2 
L58:    goto L34 
L61:    iload_2 
L62:    areturn 
L63:    nop 
L64:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [27] 
.const [3] = String [28] 
.const [4] = Class [29] 
.const [5] = Class [30] 
.const [6] = Class [31] 
.const [7] = Class [32] 
.const [8] = Class [33] 
.const [9] = Class [34] 
.const [10] = Class [35] 
.const [11] = Method [36] [37] 
.const [12] = Method [38] [39] 
.const [13] = Method [40] [41] 
.const [14] = Method [42] [43] 
.const [15] = Method [44] [45] 
.const [16] = Method [46] [47] 
.const [17] = Method [48] [49] 
.const [18] = Method [50] [51] 
.const [19] = Method [52] [53] 
.const [20] = Class [54] 
.const [21] = Class [55] 
.const [22] = Class [56] 
.const [23] = Class [57] 
.const [24] = InterfaceMethod [58] [59] 
.const [25] = InterfaceMethod [60] [61] 
.const [26] = InterfaceMethod [62] [63] 
.const [27] = Utf8 java/lang/IllegalStateException 
.const [28] = Utf8 'Queue full' 
.const [29] = Utf8 java/util/NoSuchElementException 
.const [30] = Utf8 java/lang/NullPointerException 
.const [31] = Utf8 java/lang/IllegalArgumentException 
.const [32] = Utf8 edu/emory/mathcs/backport/java/util/AbstractQueue 
.const [33] = Utf8 edu/emory/mathcs/backport/java/util/AbstractCollection 
.const [34] = Utf8 java/util/Collection 
.const [35] = Utf8 java/util/Iterator 
.const [36] = Class [64] 
.const [37] = NameAndType [65] [66] 
.const [38] = Class [67] 
.const [39] = NameAndType [68] [69] 
.const [40] = Class [70] 
.const [41] = NameAndType [71] [72] 
.const [42] = Class [73] 
.const [43] = NameAndType [74] [75] 
.const [44] = Class [76] 
.const [45] = NameAndType [77] [78] 
.const [46] = Class [79] 
.const [47] = NameAndType [80] [81] 
.const [48] = Class [82] 
.const [49] = NameAndType [83] [84] 
.const [50] = Class [85] 
.const [51] = NameAndType [86] [87] 
.const [52] = Class [88] 
.const [53] = NameAndType [89] [90] 
.const [54] = Utf8 java/lang/IllegalStateException 
.const [55] = Utf8 java/util/NoSuchElementException 
.const [56] = Utf8 java/lang/NullPointerException 
.const [57] = Utf8 java/lang/IllegalArgumentException 
.const [58] = Class [91] 
.const [59] = NameAndType [92] [93] 
.const [60] = Class [94] 
.const [61] = NameAndType [95] [96] 
.const [62] = Class [97] 
.const [63] = NameAndType [98] [99] 
.const [64] = Utf8 edu/emory/mathcs/backport/java/util/AbstractQueue 
.const [65] = Utf8 offer 
.const [66] = Utf8 (Ljava/lang/Object;)Z 
.const [67] = Utf8 edu/emory/mathcs/backport/java/util/AbstractQueue 
.const [68] = Utf8 poll 
.const [69] = Utf8 ()Ljava/lang/Object; 
.const [70] = Utf8 edu/emory/mathcs/backport/java/util/AbstractQueue 
.const [71] = Utf8 peek 
.const [72] = Utf8 ()Ljava/lang/Object; 
.const [73] = Utf8 edu/emory/mathcs/backport/java/util/AbstractQueue 
.const [74] = Utf8 add 
.const [75] = Utf8 (Ljava/lang/Object;)Z 
.const [76] = Utf8 edu/emory/mathcs/backport/java/util/AbstractCollection 
.const [77] = Utf8 <init> 
.const [78] = Utf8 ()V 
.const [79] = Utf8 java/lang/IllegalStateException 
.const [80] = Utf8 <init> 
.const [81] = Utf8 (Ljava/lang/String;)V 
.const [82] = Utf8 java/util/NoSuchElementException 
.const [83] = Utf8 <init> 
.const [84] = Utf8 ()V 
.const [85] = Utf8 java/lang/NullPointerException 
.const [86] = Utf8 <init> 
.const [87] = Utf8 ()V 
.const [88] = Utf8 java/lang/IllegalArgumentException 
.const [89] = Utf8 <init> 
.const [90] = Utf8 ()V 
.const [91] = Utf8 java/util/Collection 
.const [92] = Utf8 iterator 
.const [93] = Utf8 ()Ljava/util/Iterator; 
.const [94] = Utf8 java/util/Iterator 
.const [95] = Utf8 hasNext 
.const [96] = Utf8 ()Z 
.const [97] = Utf8 java/util/Iterator 
.const [98] = Utf8 next 
.const [99] = Utf8 ()Ljava/lang/Object; 
.const [100] = Utf8 edu/emory/mathcs/backport/java/util/AbstractQueue 
.const [101] = Class [100] 
.const [102] = Utf8 edu/emory/mathcs/backport/java/util/AbstractCollection 
.const [103] = Class [102] 
.const [104] = Utf8 edu/emory/mathcs/backport/java/util/Queue 
.const [105] = Class [104] 
.const [106] = Utf8 Code 
.const [107] = Utf8 <init> 
.const [108] = Utf8 ()V 
.const [109] = Utf8 add 
.const [110] = Utf8 (Ljava/lang/Object;)Z 
.const [111] = Utf8 remove 
.const [112] = Utf8 ()Ljava/lang/Object; 
.const [113] = Utf8 element 
.const [114] = Utf8 ()Ljava/lang/Object; 
.const [115] = Utf8 clear 
.const [116] = Utf8 ()V 
.const [117] = Utf8 addAll 
.const [118] = Utf8 (Ljava/util/Collection;)Z 
.end class 
