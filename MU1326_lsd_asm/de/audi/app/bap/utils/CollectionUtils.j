.version 50 0 
.class public final super [41] 
.super [43] 

.method public annotation [45] : [46] 
    .attribute [44] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [6] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [47] : [48] 
    .attribute [44] .code stack 2 locals 1 
L0:     aload_0 
L1:     invokeinterface [7] 0 
L6:     ifeq L37 
L9:     aload_0 
L10:    invokeinterface [8] 0 
L15:    astore_3 
L16:    aload_2 
L17:    aload_3 
L18:    invokeinterface [9] 0 
L23:    ifeq L34 
L26:    aload_1 
L27:    aload_3 
L28:    invokeinterface [10] 0 
L33:    pop 
L34:    goto L0 
L37:    return 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [11] 
.const [3] = Class [12] 
.const [4] = Class [13] 
.const [5] = Class [14] 
.const [6] = Method [15] [16] 
.const [7] = InterfaceMethod [17] [18] 
.const [8] = InterfaceMethod [19] [20] 
.const [9] = InterfaceMethod [21] [22] 
.const [10] = InterfaceMethod [23] [24] 
.const [11] = Utf8 java/lang/Object 
.const [12] = Utf8 de/audi/app/bap/utils/CollectionUtils$Predicate 
.const [13] = Utf8 java/util/Iterator 
.const [14] = Utf8 java/util/Collection 
.const [15] = Class [25] 
.const [16] = NameAndType [26] [27] 
.const [17] = Class [28] 
.const [18] = NameAndType [29] [30] 
.const [19] = Class [31] 
.const [20] = NameAndType [32] [33] 
.const [21] = Class [34] 
.const [22] = NameAndType [35] [36] 
.const [23] = Class [37] 
.const [24] = NameAndType [38] [39] 
.const [25] = Utf8 java/lang/Object 
.const [26] = Utf8 <init> 
.const [27] = Utf8 ()V 
.const [28] = Utf8 java/util/Iterator 
.const [29] = Utf8 hasNext 
.const [30] = Utf8 ()Z 
.const [31] = Utf8 java/util/Iterator 
.const [32] = Utf8 next 
.const [33] = Utf8 ()Ljava/lang/Object; 
.const [34] = Utf8 de/audi/app/bap/utils/CollectionUtils$Predicate 
.const [35] = Utf8 evaluate 
.const [36] = Utf8 (Ljava/lang/Object;)Z 
.const [37] = Utf8 java/util/Collection 
.const [38] = Utf8 add 
.const [39] = Utf8 (Ljava/lang/Object;)Z 
.const [40] = Utf8 de/audi/app/bap/utils/CollectionUtils 
.const [41] = Class [40] 
.const [42] = Utf8 java/lang/Object 
.const [43] = Class [42] 
.const [44] = Utf8 Code 
.const [45] = Utf8 <init> 
.const [46] = Utf8 ()V 
.const [47] = Utf8 filterFromIteratorIntoCollection 
.const [48] = Utf8 (Ljava/util/Iterator;Ljava/util/Collection;Lde/audi/app/bap/utils/CollectionUtils$Predicate;)V 
.end class 
