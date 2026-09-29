.version 50 0 
.class final super [83] 
.super [85] 
.field private final synthetic [86] [87] 

.method [89] : [90] 
    .attribute [88] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [16] 
L5:     aload_0 
L6:     invokespecial [14] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [91] : [92] 
    .attribute [88] .code stack 3 locals 0 
L0:     new [17] 
L3:     dup 
L4:     aload_0 
L5:     getfield [8] 
L8:     invokespecial [15] 
L11:    areturn 
L12:    
    .end code 
.end method 

.method public [93] : [94] 
    .attribute [88] .code stack 2 locals 2 
L0:     aload_1 
L1:     instanceof [3] 
L4:     ifne L9 
L7:     iconst_0 
L8:     areturn 
L9:     aload_1 
L10:    checkcast [3] 
L13:    astore_2 
L14:    aload_0 
L15:    getfield [8] 
L18:    aload_2 
L19:    invokeinterface [18] 0 
L24:    invokevirtual [9] 
L27:    astore_3 
L28:    aload_3 
L29:    ifnull L49 
L32:    aload_3 
L33:    aload_2 
L34:    invokeinterface [19] 0 
L39:    invokevirtual [10] 
L42:    ifeq L49 
L45:    iconst_1 
L46:    goto L50 
L49:    iconst_0 
L50:    areturn 
L51:    nop 
L52:    
    .end code 
.end method 

.method public [95] : [96] 
    .attribute [88] .code stack 3 locals 1 
L0:     aload_1 
L1:     instanceof [3] 
L4:     ifne L9 
L7:     iconst_0 
L8:     areturn 
L9:     aload_1 
L10:    checkcast [3] 
L13:    astore_2 
L14:    aload_0 
L15:    getfield [8] 
L18:    aload_2 
L19:    invokeinterface [18] 0 
L24:    aload_2 
L25:    invokeinterface [19] 0 
L30:    invokevirtual [11] 
L33:    areturn 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 

.method public [97] : [98] 
    .attribute [88] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [8] 
L4:     invokevirtual [12] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public [99] : [100] 
    .attribute [88] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [8] 
L4:     invokevirtual [13] 
L7:     return 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [20] 
.const [3] = Class [21] 
.const [4] = Class [22] 
.const [5] = Class [23] 
.const [6] = Class [24] 
.const [7] = Class [25] 
.const [8] = Field [26] [27] 
.const [9] = Method [28] [29] 
.const [10] = Method [30] [31] 
.const [11] = Method [32] [33] 
.const [12] = Method [34] [35] 
.const [13] = Method [36] [37] 
.const [14] = Method [38] [39] 
.const [15] = Method [40] [41] 
.const [16] = Field [42] [43] 
.const [17] = Class [44] 
.const [18] = InterfaceMethod [45] [46] 
.const [19] = InterfaceMethod [47] [48] 
.const [20] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/ConcurrentHashMap$EntryIterator 
.const [21] = Utf8 java/util/Map$Entry 
.const [22] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/ConcurrentHashMap$EntrySet 
.const [23] = Utf8 edu/emory/mathcs/backport/java/util/AbstractSet 
.const [24] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/ConcurrentHashMap 
.const [25] = Utf8 java/lang/Object 
.const [26] = Class [49] 
.const [27] = NameAndType [50] [51] 
.const [28] = Class [52] 
.const [29] = NameAndType [53] [54] 
.const [30] = Class [55] 
.const [31] = NameAndType [56] [57] 
.const [32] = Class [58] 
.const [33] = NameAndType [59] [60] 
.const [34] = Class [61] 
.const [35] = NameAndType [62] [63] 
.const [36] = Class [64] 
.const [37] = NameAndType [65] [66] 
.const [38] = Class [67] 
.const [39] = NameAndType [68] [69] 
.const [40] = Class [70] 
.const [41] = NameAndType [71] [72] 
.const [42] = Class [73] 
.const [43] = NameAndType [74] [75] 
.const [44] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/ConcurrentHashMap$EntryIterator 
.const [45] = Class [76] 
.const [46] = NameAndType [77] [78] 
.const [47] = Class [79] 
.const [48] = NameAndType [80] [81] 
.const [49] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/ConcurrentHashMap$EntrySet 
.const [50] = Utf8 this$0 
.const [51] = Utf8 Ledu/emory/mathcs/backport/java/util/concurrent/ConcurrentHashMap; 
.const [52] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/ConcurrentHashMap 
.const [53] = Utf8 get 
.const [54] = Utf8 (Ljava/lang/Object;)Ljava/lang/Object; 
.const [55] = Utf8 java/lang/Object 
.const [56] = Utf8 equals 
.const [57] = Utf8 (Ljava/lang/Object;)Z 
.const [58] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/ConcurrentHashMap 
.const [59] = Utf8 remove 
.const [60] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)Z 
.const [61] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/ConcurrentHashMap 
.const [62] = Utf8 size 
.const [63] = Utf8 ()I 
.const [64] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/ConcurrentHashMap 
.const [65] = Utf8 clear 
.const [66] = Utf8 ()V 
.const [67] = Utf8 edu/emory/mathcs/backport/java/util/AbstractSet 
.const [68] = Utf8 <init> 
.const [69] = Utf8 ()V 
.const [70] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/ConcurrentHashMap$EntryIterator 
.const [71] = Utf8 <init> 
.const [72] = Utf8 (Ledu/emory/mathcs/backport/java/util/concurrent/ConcurrentHashMap;)V 
.const [73] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/ConcurrentHashMap$EntrySet 
.const [74] = Utf8 this$0 
.const [75] = Utf8 Ledu/emory/mathcs/backport/java/util/concurrent/ConcurrentHashMap; 
.const [76] = Utf8 java/util/Map$Entry 
.const [77] = Utf8 getKey 
.const [78] = Utf8 ()Ljava/lang/Object; 
.const [79] = Utf8 java/util/Map$Entry 
.const [80] = Utf8 getValue 
.const [81] = Utf8 ()Ljava/lang/Object; 
.const [82] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/ConcurrentHashMap$EntrySet 
.const [83] = Class [82] 
.const [84] = Utf8 edu/emory/mathcs/backport/java/util/AbstractSet 
.const [85] = Class [84] 
.const [86] = Utf8 this$0 
.const [87] = Utf8 Ledu/emory/mathcs/backport/java/util/concurrent/ConcurrentHashMap; 
.const [88] = Utf8 Code 
.const [89] = Utf8 <init> 
.const [90] = Utf8 (Ledu/emory/mathcs/backport/java/util/concurrent/ConcurrentHashMap;)V 
.const [91] = Utf8 iterator 
.const [92] = Utf8 ()Ljava/util/Iterator; 
.const [93] = Utf8 contains 
.const [94] = Utf8 (Ljava/lang/Object;)Z 
.const [95] = Utf8 remove 
.const [96] = Utf8 (Ljava/lang/Object;)Z 
.const [97] = Utf8 size 
.const [98] = Utf8 ()I 
.const [99] = Utf8 clear 
.const [100] = Utf8 ()V 
.end class 
