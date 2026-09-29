.version 50 0 
.class final super [47] 
.super [49] 
.implements [51] 
.field private static final [52] [53] 
.field private transient [54] [55] 

.method annotation [57] : [58] 
    .attribute [56] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [7] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method [59] : [60] 
    .attribute [56] .code stack 5 locals 0 
L0:     aload_0 
L1:     new [9] 
L4:     dup 
L5:     aload_1 
L6:     aload_0 
L7:     getfield [5] 
L10:    invokespecial [8] 
L13:    dup_x1 
L14:    putfield [10] 
L17:    areturn 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method [61] : [62] 
    .attribute [56] .code stack 2 locals 1 
L0:     aload_0 
L1:     getfield [5] 
L4:     astore_1 
L5:     aload_1 
L6:     ifnull L22 
L9:     aload_0 
L10:    aload_1 
L11:    getfield [6] 
L14:    putfield [10] 
L17:    aload_1 
L18:    aconst_null 
L19:    putfield [11] 
L22:    aload_1 
L23:    areturn 
L24:    
    .end code 
.end method 

.method [63] : [64] 
    .attribute [56] .code stack 2 locals 0 
L0:     aload_1 
L1:     aload_0 
L2:     getfield [5] 
L5:     if_acmpeq L15 
L8:     aload_1 
L9:     getfield [6] 
L12:    ifnull L19 
L15:    iconst_1 
L16:    goto L20 
L19:    iconst_0 
L20:    areturn 
L21:    nop 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method [65] : [66] 
    .attribute [56] .code stack 2 locals 3 
L0:     aload_0 
L1:     getfield [5] 
L4:     astore_2 
L5:     aconst_null 
L6:     astore_3 
L7:     aload_2 
L8:     ifnull L54 
L11:    aload_2 
L12:    aload_1 
L13:    if_acmpne L44 
L16:    aload_2 
L17:    getfield [6] 
L20:    astore 4 
L22:    aload_3 
L23:    ifnonnull L35 
L26:    aload_0 
L27:    aload 4 
L29:    putfield [10] 
L32:    goto L54 
L35:    aload_3 
L36:    aload 4 
L38:    putfield [11] 
L41:    goto L54 
L44:    aload_2 
L45:    astore_3 
L46:    aload_2 
L47:    getfield [6] 
L50:    astore_2 
L51:    goto L7 
L54:    return 
L55:    nop 
L56:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [12] 
.const [3] = Class [13] 
.const [4] = Class [14] 
.const [5] = Field [15] [16] 
.const [6] = Field [17] [18] 
.const [7] = Method [19] [20] 
.const [8] = Method [21] [22] 
.const [9] = Class [23] 
.const [10] = Field [24] [25] 
.const [11] = Field [26] [27] 
.const [12] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/SynchronousQueue$Node 
.const [13] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/SynchronousQueue$LifoWaitQueue 
.const [14] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/SynchronousQueue$WaitQueue 
.const [15] = Class [28] 
.const [16] = NameAndType [29] [30] 
.const [17] = Class [31] 
.const [18] = NameAndType [32] [33] 
.const [19] = Class [34] 
.const [20] = NameAndType [35] [36] 
.const [21] = Class [37] 
.const [22] = NameAndType [38] [39] 
.const [23] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/SynchronousQueue$Node 
.const [24] = Class [40] 
.const [25] = NameAndType [41] [42] 
.const [26] = Class [43] 
.const [27] = NameAndType [44] [45] 
.const [28] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/SynchronousQueue$LifoWaitQueue 
.const [29] = Utf8 head 
.const [30] = Utf8 Ledu/emory/mathcs/backport/java/util/concurrent/SynchronousQueue$Node; 
.const [31] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/SynchronousQueue$Node 
.const [32] = Utf8 next 
.const [33] = Utf8 Ledu/emory/mathcs/backport/java/util/concurrent/SynchronousQueue$Node; 
.const [34] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/SynchronousQueue$WaitQueue 
.const [35] = Utf8 <init> 
.const [36] = Utf8 ()V 
.const [37] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/SynchronousQueue$Node 
.const [38] = Utf8 <init> 
.const [39] = Utf8 (Ljava/lang/Object;Ledu/emory/mathcs/backport/java/util/concurrent/SynchronousQueue$Node;)V 
.const [40] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/SynchronousQueue$LifoWaitQueue 
.const [41] = Utf8 head 
.const [42] = Utf8 Ledu/emory/mathcs/backport/java/util/concurrent/SynchronousQueue$Node; 
.const [43] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/SynchronousQueue$Node 
.const [44] = Utf8 next 
.const [45] = Utf8 Ledu/emory/mathcs/backport/java/util/concurrent/SynchronousQueue$Node; 
.const [46] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/SynchronousQueue$LifoWaitQueue 
.const [47] = Class [46] 
.const [48] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/SynchronousQueue$WaitQueue 
.const [49] = Class [48] 
.const [50] = Utf8 java/io/Serializable 
.const [51] = Class [50] 
.const [52] = Utf8 serialVersionUID 
.const [53] = Utf8 J 
.const [54] = Utf8 head 
.const [55] = Utf8 Ledu/emory/mathcs/backport/java/util/concurrent/SynchronousQueue$Node; 
.const [56] = Utf8 Code 
.const [57] = Utf8 <init> 
.const [58] = Utf8 ()V 
.const [59] = Utf8 enq 
.const [60] = Utf8 (Ljava/lang/Object;)Ledu/emory/mathcs/backport/java/util/concurrent/SynchronousQueue$Node; 
.const [61] = Utf8 deq 
.const [62] = Utf8 ()Ledu/emory/mathcs/backport/java/util/concurrent/SynchronousQueue$Node; 
.const [63] = Utf8 shouldUnlink 
.const [64] = Utf8 (Ledu/emory/mathcs/backport/java/util/concurrent/SynchronousQueue$Node;)Z 
.const [65] = Utf8 unlink 
.const [66] = Utf8 (Ledu/emory/mathcs/backport/java/util/concurrent/SynchronousQueue$Node;)V 
.end class 
