.version 50 0 
.class super abstract [83] 
.super [85] 
.implements [87] 
.field [88] [89] 
.field [90] [91] 
.field private [92] [93] 
.field private final synthetic [94] [95] 

.method [97] : [98] 
    .attribute [96] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [16] 
L5:     aload_0 
L6:     invokespecial [13] 
L9:     aload_0 
L10:    invokevirtual [8] 
L13:    return 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method abstract [99] : [100] 
    .attribute [96] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method public [101] : [102] 
    .attribute [96] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [9] 
L4:     ifnull L11 
L7:     iconst_1 
L8:     goto L12 
L11:    iconst_0 
L12:    areturn 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [103] : [104] 
    .attribute [96] .code stack 2 locals 1 
L0:     aload_0 
L1:     getfield [9] 
L4:     ifnonnull L15 
L7:     new [17] 
L10:    dup 
L11:    invokespecial [14] 
L14:    athrow 
L15:    aload_0 
L16:    aload_0 
L17:    getfield [9] 
L20:    putfield [18] 
L23:    aload_0 
L24:    getfield [11] 
L27:    astore_1 
L28:    aload_0 
L29:    invokevirtual [8] 
L32:    aload_1 
L33:    areturn 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 

.method public [105] : [106] 
    .attribute [96] .code stack 2 locals 1 
L0:     aload_0 
L1:     getfield [10] 
L4:     astore_1 
L5:     aload_1 
L6:     ifnonnull L17 
L9:     new [19] 
L12:    dup 
L13:    invokespecial [15] 
L16:    athrow 
L17:    aload_0 
L18:    aconst_null 
L19:    putfield [18] 
L22:    aload_0 
L23:    getfield [7] 
L26:    aload_1 
L27:    invokevirtual [12] 
L30:    pop 
L31:    return 
L32:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [20] 
.const [3] = Class [21] 
.const [4] = Class [22] 
.const [5] = Class [23] 
.const [6] = Class [24] 
.const [7] = Field [25] [26] 
.const [8] = Method [27] [28] 
.const [9] = Field [29] [30] 
.const [10] = Field [31] [32] 
.const [11] = Field [33] [34] 
.const [12] = Method [35] [36] 
.const [13] = Method [37] [38] 
.const [14] = Method [39] [40] 
.const [15] = Method [41] [42] 
.const [16] = Field [43] [44] 
.const [17] = Class [45] 
.const [18] = Field [46] [47] 
.const [19] = Class [48] 
.const [20] = Utf8 java/util/NoSuchElementException 
.const [21] = Utf8 java/lang/IllegalStateException 
.const [22] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/LinkedBlockingDeque$AbstractItr 
.const [23] = Utf8 java/lang/Object 
.const [24] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/LinkedBlockingDeque 
.const [25] = Class [49] 
.const [26] = NameAndType [50] [51] 
.const [27] = Class [52] 
.const [28] = NameAndType [53] [54] 
.const [29] = Class [55] 
.const [30] = NameAndType [56] [57] 
.const [31] = Class [58] 
.const [32] = NameAndType [59] [60] 
.const [33] = Class [61] 
.const [34] = NameAndType [62] [63] 
.const [35] = Class [64] 
.const [36] = NameAndType [65] [66] 
.const [37] = Class [67] 
.const [38] = NameAndType [68] [69] 
.const [39] = Class [70] 
.const [40] = NameAndType [71] [72] 
.const [41] = Class [73] 
.const [42] = NameAndType [74] [75] 
.const [43] = Class [76] 
.const [44] = NameAndType [77] [78] 
.const [45] = Utf8 java/util/NoSuchElementException 
.const [46] = Class [79] 
.const [47] = NameAndType [80] [81] 
.const [48] = Utf8 java/lang/IllegalStateException 
.const [49] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/LinkedBlockingDeque$AbstractItr 
.const [50] = Utf8 this$0 
.const [51] = Utf8 Ledu/emory/mathcs/backport/java/util/concurrent/LinkedBlockingDeque; 
.const [52] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/LinkedBlockingDeque$AbstractItr 
.const [53] = Utf8 advance 
.const [54] = Utf8 ()V 
.const [55] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/LinkedBlockingDeque$AbstractItr 
.const [56] = Utf8 next 
.const [57] = Utf8 Ledu/emory/mathcs/backport/java/util/concurrent/LinkedBlockingDeque$Node; 
.const [58] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/LinkedBlockingDeque$AbstractItr 
.const [59] = Utf8 lastRet 
.const [60] = Utf8 Ledu/emory/mathcs/backport/java/util/concurrent/LinkedBlockingDeque$Node; 
.const [61] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/LinkedBlockingDeque$AbstractItr 
.const [62] = Utf8 nextItem 
.const [63] = Utf8 Ljava/lang/Object; 
.const [64] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/LinkedBlockingDeque 
.const [65] = Utf8 removeNode 
.const [66] = Utf8 (Ledu/emory/mathcs/backport/java/util/concurrent/LinkedBlockingDeque$Node;)Z 
.const [67] = Utf8 java/lang/Object 
.const [68] = Utf8 <init> 
.const [69] = Utf8 ()V 
.const [70] = Utf8 java/util/NoSuchElementException 
.const [71] = Utf8 <init> 
.const [72] = Utf8 ()V 
.const [73] = Utf8 java/lang/IllegalStateException 
.const [74] = Utf8 <init> 
.const [75] = Utf8 ()V 
.const [76] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/LinkedBlockingDeque$AbstractItr 
.const [77] = Utf8 this$0 
.const [78] = Utf8 Ledu/emory/mathcs/backport/java/util/concurrent/LinkedBlockingDeque; 
.const [79] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/LinkedBlockingDeque$AbstractItr 
.const [80] = Utf8 lastRet 
.const [81] = Utf8 Ledu/emory/mathcs/backport/java/util/concurrent/LinkedBlockingDeque$Node; 
.const [82] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/LinkedBlockingDeque$AbstractItr 
.const [83] = Class [82] 
.const [84] = Utf8 java/lang/Object 
.const [85] = Class [84] 
.const [86] = Utf8 java/util/Iterator 
.const [87] = Class [86] 
.const [88] = Utf8 next 
.const [89] = Utf8 Ledu/emory/mathcs/backport/java/util/concurrent/LinkedBlockingDeque$Node; 
.const [90] = Utf8 nextItem 
.const [91] = Utf8 Ljava/lang/Object; 
.const [92] = Utf8 lastRet 
.const [93] = Utf8 Ledu/emory/mathcs/backport/java/util/concurrent/LinkedBlockingDeque$Node; 
.const [94] = Utf8 this$0 
.const [95] = Utf8 Ledu/emory/mathcs/backport/java/util/concurrent/LinkedBlockingDeque; 
.const [96] = Utf8 Code 
.const [97] = Utf8 <init> 
.const [98] = Utf8 (Ledu/emory/mathcs/backport/java/util/concurrent/LinkedBlockingDeque;)V 
.const [99] = Utf8 advance 
.const [100] = Utf8 ()V 
.const [101] = Utf8 hasNext 
.const [102] = Utf8 ()Z 
.const [103] = Utf8 next 
.const [104] = Utf8 ()Ljava/lang/Object; 
.const [105] = Utf8 remove 
.const [106] = Utf8 ()V 
.end class 
