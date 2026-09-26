.version 50 0 
.class final super [59] 
.super [61] 
.implements [63] 
.field private static final [64] [65] 
.field private transient [66] [67] 
.field private transient [68] [69] 

.method annotation [71] : [72] 
    .attribute [70] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [8] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method [73] : [74] 
    .attribute [70] .code stack 4 locals 1 
L0:     new [10] 
L3:     dup 
L4:     aload_1 
L5:     invokespecial [9] 
L8:     astore_2 
L9:     aload_0 
L10:    getfield [5] 
L13:    ifnonnull L29 
L16:    aload_0 
L17:    aload_0 
L18:    aload_2 
L19:    dup_x1 
L20:    putfield [12] 
L23:    putfield [11] 
L26:    goto L42 
L29:    aload_0 
L30:    aload_0 
L31:    getfield [5] 
L34:    aload_2 
L35:    dup_x1 
L36:    putfield [13] 
L39:    putfield [11] 
L42:    aload_2 
L43:    areturn 
L44:    
    .end code 
.end method 

.method [75] : [76] 
    .attribute [70] .code stack 3 locals 1 
L0:     aload_0 
L1:     getfield [6] 
L4:     astore_1 
L5:     aload_1 
L6:     ifnull L31 
L9:     aload_0 
L10:    aload_1 
L11:    getfield [7] 
L14:    dup_x1 
L15:    putfield [12] 
L18:    ifnonnull L26 
L21:    aload_0 
L22:    aconst_null 
L23:    putfield [11] 
L26:    aload_1 
L27:    aconst_null 
L28:    putfield [13] 
L31:    aload_1 
L32:    areturn 
L33:    nop 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 

.method [77] : [78] 
    .attribute [70] .code stack 2 locals 0 
L0:     aload_1 
L1:     aload_0 
L2:     getfield [5] 
L5:     if_acmpeq L15 
L8:     aload_1 
L9:     getfield [7] 
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

.method [79] : [80] 
    .attribute [70] .code stack 2 locals 3 
L0:     aload_0 
L1:     getfield [6] 
L4:     astore_2 
L5:     aconst_null 
L6:     astore_3 
L7:     aload_2 
L8:     ifnull L67 
L11:    aload_2 
L12:    aload_1 
L13:    if_acmpne L57 
L16:    aload_2 
L17:    getfield [7] 
L20:    astore 4 
L22:    aload_3 
L23:    ifnonnull L35 
L26:    aload_0 
L27:    aload 4 
L29:    putfield [12] 
L32:    goto L41 
L35:    aload_3 
L36:    aload 4 
L38:    putfield [13] 
L41:    aload_0 
L42:    getfield [5] 
L45:    aload_1 
L46:    if_acmpne L67 
L49:    aload_0 
L50:    aload_3 
L51:    putfield [11] 
L54:    goto L67 
L57:    aload_2 
L58:    astore_3 
L59:    aload_2 
L60:    getfield [7] 
L63:    astore_2 
L64:    goto L7 
L67:    return 
L68:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [14] 
.const [3] = Class [15] 
.const [4] = Class [16] 
.const [5] = Field [17] [18] 
.const [6] = Field [19] [20] 
.const [7] = Field [21] [22] 
.const [8] = Method [23] [24] 
.const [9] = Method [25] [26] 
.const [10] = Class [27] 
.const [11] = Field [28] [29] 
.const [12] = Field [30] [31] 
.const [13] = Field [32] [33] 
.const [14] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/SynchronousQueue$Node 
.const [15] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/SynchronousQueue$FifoWaitQueue 
.const [16] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/SynchronousQueue$WaitQueue 
.const [17] = Class [34] 
.const [18] = NameAndType [35] [36] 
.const [19] = Class [37] 
.const [20] = NameAndType [38] [39] 
.const [21] = Class [40] 
.const [22] = NameAndType [41] [42] 
.const [23] = Class [43] 
.const [24] = NameAndType [44] [45] 
.const [25] = Class [46] 
.const [26] = NameAndType [47] [48] 
.const [27] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/SynchronousQueue$Node 
.const [28] = Class [49] 
.const [29] = NameAndType [50] [51] 
.const [30] = Class [52] 
.const [31] = NameAndType [53] [54] 
.const [32] = Class [55] 
.const [33] = NameAndType [56] [57] 
.const [34] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/SynchronousQueue$FifoWaitQueue 
.const [35] = Utf8 last 
.const [36] = Utf8 Ledu/emory/mathcs/backport/java/util/concurrent/SynchronousQueue$Node; 
.const [37] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/SynchronousQueue$FifoWaitQueue 
.const [38] = Utf8 head 
.const [39] = Utf8 Ledu/emory/mathcs/backport/java/util/concurrent/SynchronousQueue$Node; 
.const [40] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/SynchronousQueue$Node 
.const [41] = Utf8 next 
.const [42] = Utf8 Ledu/emory/mathcs/backport/java/util/concurrent/SynchronousQueue$Node; 
.const [43] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/SynchronousQueue$WaitQueue 
.const [44] = Utf8 <init> 
.const [45] = Utf8 ()V 
.const [46] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/SynchronousQueue$Node 
.const [47] = Utf8 <init> 
.const [48] = Utf8 (Ljava/lang/Object;)V 
.const [49] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/SynchronousQueue$FifoWaitQueue 
.const [50] = Utf8 last 
.const [51] = Utf8 Ledu/emory/mathcs/backport/java/util/concurrent/SynchronousQueue$Node; 
.const [52] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/SynchronousQueue$FifoWaitQueue 
.const [53] = Utf8 head 
.const [54] = Utf8 Ledu/emory/mathcs/backport/java/util/concurrent/SynchronousQueue$Node; 
.const [55] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/SynchronousQueue$Node 
.const [56] = Utf8 next 
.const [57] = Utf8 Ledu/emory/mathcs/backport/java/util/concurrent/SynchronousQueue$Node; 
.const [58] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/SynchronousQueue$FifoWaitQueue 
.const [59] = Class [58] 
.const [60] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/SynchronousQueue$WaitQueue 
.const [61] = Class [60] 
.const [62] = Utf8 java/io/Serializable 
.const [63] = Class [62] 
.const [64] = Utf8 serialVersionUID 
.const [65] = Utf8 J 
.const [66] = Utf8 head 
.const [67] = Utf8 Ledu/emory/mathcs/backport/java/util/concurrent/SynchronousQueue$Node; 
.const [68] = Utf8 last 
.const [69] = Utf8 Ledu/emory/mathcs/backport/java/util/concurrent/SynchronousQueue$Node; 
.const [70] = Utf8 Code 
.const [71] = Utf8 <init> 
.const [72] = Utf8 ()V 
.const [73] = Utf8 enq 
.const [74] = Utf8 (Ljava/lang/Object;)Ledu/emory/mathcs/backport/java/util/concurrent/SynchronousQueue$Node; 
.const [75] = Utf8 deq 
.const [76] = Utf8 ()Ledu/emory/mathcs/backport/java/util/concurrent/SynchronousQueue$Node; 
.const [77] = Utf8 shouldUnlink 
.const [78] = Utf8 (Ledu/emory/mathcs/backport/java/util/concurrent/SynchronousQueue$Node;)Z 
.const [79] = Utf8 unlink 
.const [80] = Utf8 (Ledu/emory/mathcs/backport/java/util/concurrent/SynchronousQueue$Node;)V 
.end class 
