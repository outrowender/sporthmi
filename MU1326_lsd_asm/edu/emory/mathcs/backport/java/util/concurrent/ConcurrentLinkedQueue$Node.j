.version 50 0 
.class super [37] 
.super [39] 
.field private volatile [40] [41] 
.field private volatile [42] [43] 

.method [45] : [46] 
    .attribute [44] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [6] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [7] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method [47] : [48] 
    .attribute [44] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [6] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [7] 
L9:     aload_0 
L10:    aload_2 
L11:    putfield [8] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method interface [49] : [50] 
    .attribute [44] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [4] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method synchronized [51] : [52] 
    .attribute [44] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [4] 
L4:     aload_1 
L5:     if_acmpne L15 
L8:     aload_0 
L9:     aload_2 
L10:    putfield [7] 
L13:    iconst_1 
L14:    areturn 
L15:    iconst_0 
L16:    areturn 
L17:    nop 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method synchronized [53] : [54] 
    .attribute [44] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [7] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method interface [55] : [56] 
    .attribute [44] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [5] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method synchronized [57] : [58] 
    .attribute [44] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [5] 
L4:     aload_1 
L5:     if_acmpne L15 
L8:     aload_0 
L9:     aload_2 
L10:    putfield [8] 
L13:    iconst_1 
L14:    areturn 
L15:    iconst_0 
L16:    areturn 
L17:    nop 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method synchronized [59] : [60] 
    .attribute [44] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [8] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [9] 
.const [3] = Class [10] 
.const [4] = Field [11] [12] 
.const [5] = Field [13] [14] 
.const [6] = Method [15] [16] 
.const [7] = Field [17] [18] 
.const [8] = Field [19] [20] 
.const [9] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/ConcurrentLinkedQueue$Node 
.const [10] = Utf8 java/lang/Object 
.const [11] = Class [21] 
.const [12] = NameAndType [22] [23] 
.const [13] = Class [24] 
.const [14] = NameAndType [25] [26] 
.const [15] = Class [27] 
.const [16] = NameAndType [28] [29] 
.const [17] = Class [30] 
.const [18] = NameAndType [31] [32] 
.const [19] = Class [33] 
.const [20] = NameAndType [34] [35] 
.const [21] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/ConcurrentLinkedQueue$Node 
.const [22] = Utf8 item 
.const [23] = Utf8 Ljava/lang/Object; 
.const [24] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/ConcurrentLinkedQueue$Node 
.const [25] = Utf8 next 
.const [26] = Utf8 Ledu/emory/mathcs/backport/java/util/concurrent/ConcurrentLinkedQueue$Node; 
.const [27] = Utf8 java/lang/Object 
.const [28] = Utf8 <init> 
.const [29] = Utf8 ()V 
.const [30] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/ConcurrentLinkedQueue$Node 
.const [31] = Utf8 item 
.const [32] = Utf8 Ljava/lang/Object; 
.const [33] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/ConcurrentLinkedQueue$Node 
.const [34] = Utf8 next 
.const [35] = Utf8 Ledu/emory/mathcs/backport/java/util/concurrent/ConcurrentLinkedQueue$Node; 
.const [36] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/ConcurrentLinkedQueue$Node 
.const [37] = Class [36] 
.const [38] = Utf8 java/lang/Object 
.const [39] = Class [38] 
.const [40] = Utf8 item 
.const [41] = Utf8 Ljava/lang/Object; 
.const [42] = Utf8 next 
.const [43] = Utf8 Ledu/emory/mathcs/backport/java/util/concurrent/ConcurrentLinkedQueue$Node; 
.const [44] = Utf8 Code 
.const [45] = Utf8 <init> 
.const [46] = Utf8 (Ljava/lang/Object;)V 
.const [47] = Utf8 <init> 
.const [48] = Utf8 (Ljava/lang/Object;Ledu/emory/mathcs/backport/java/util/concurrent/ConcurrentLinkedQueue$Node;)V 
.const [49] = Utf8 getItem 
.const [50] = Utf8 ()Ljava/lang/Object; 
.const [51] = Utf8 casItem 
.const [52] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)Z 
.const [53] = Utf8 setItem 
.const [54] = Utf8 (Ljava/lang/Object;)V 
.const [55] = Utf8 getNext 
.const [56] = Utf8 ()Ledu/emory/mathcs/backport/java/util/concurrent/ConcurrentLinkedQueue$Node; 
.const [57] = Utf8 casNext 
.const [58] = Utf8 (Ledu/emory/mathcs/backport/java/util/concurrent/ConcurrentLinkedQueue$Node;Ledu/emory/mathcs/backport/java/util/concurrent/ConcurrentLinkedQueue$Node;)Z 
.const [59] = Utf8 setNext 
.const [60] = Utf8 (Ledu/emory/mathcs/backport/java/util/concurrent/ConcurrentLinkedQueue$Node;)V 
.end class 
