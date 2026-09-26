.version 50 0 
.class super [91] 
.super [93] 
.field private final synthetic [94] [95] 

.method private [97] : [98] 
    .attribute [96] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [17] 
L5:     aload_0 
L6:     aload_1 
L7:     invokespecial [16] 
L10:    return 
L11:    nop 
L12:    
    .end code 
.end method 

.method [99] : [100] 
    .attribute [96] .code stack 2 locals 2 
L0:     aload_0 
L1:     getfield [9] 
L4:     invokestatic [2] 
L7:     astore_1 
L8:     aload_1 
L9:     invokevirtual [10] 
        .catch [0] from L12 to L62 using L69 
L12:    aload_0 
L13:    aload_0 
L14:    getfield [11] 
L17:    ifnonnull L30 
L20:    aload_0 
L21:    getfield [9] 
L24:    invokestatic [3] 
L27:    goto L37 
L30:    aload_0 
L31:    getfield [11] 
L34:    getfield [12] 
L37:    putfield [18] 
L40:    aload_0 
L41:    aload_0 
L42:    getfield [11] 
L45:    ifnonnull L52 
L48:    aconst_null 
L49:    goto L59 
L52:    aload_0 
L53:    getfield [11] 
L56:    getfield [13] 
L59:    putfield [19] 
L62:    aload_1 
L63:    invokevirtual [14] 
L66:    goto L76 
        .catch [0] from L69 to L70 using L69 
L69:    astore_2 
L70:    aload_1 
L71:    invokevirtual [14] 
L74:    aload_2 
L75:    athrow 
L76:    return 
L77:    nop 
L78:    nop 
L79:    nop 
L80:    
    .end code 
.end method 

.method synthetic [101] : [102] 
    .attribute [96] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [15] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [20] [21] 
.const [3] = Method [22] [23] 
.const [4] = Class [24] 
.const [5] = Class [25] 
.const [6] = Class [26] 
.const [7] = Class [27] 
.const [8] = Class [28] 
.const [9] = Field [29] [30] 
.const [10] = Method [31] [32] 
.const [11] = Field [33] [34] 
.const [12] = Field [35] [36] 
.const [13] = Field [37] [38] 
.const [14] = Method [39] [40] 
.const [15] = Method [41] [42] 
.const [16] = Method [43] [44] 
.const [17] = Field [45] [46] 
.const [18] = Field [47] [48] 
.const [19] = Field [49] [50] 
.const [20] = Class [51] 
.const [21] = NameAndType [52] [53] 
.const [22] = Class [54] 
.const [23] = NameAndType [55] [56] 
.const [24] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/LinkedBlockingDeque$Itr 
.const [25] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/LinkedBlockingDeque$AbstractItr 
.const [26] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/LinkedBlockingDeque 
.const [27] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/locks/ReentrantLock 
.const [28] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/LinkedBlockingDeque$Node 
.const [29] = Class [57] 
.const [30] = NameAndType [58] [59] 
.const [31] = Class [60] 
.const [32] = NameAndType [61] [62] 
.const [33] = Class [63] 
.const [34] = NameAndType [64] [65] 
.const [35] = Class [66] 
.const [36] = NameAndType [67] [68] 
.const [37] = Class [69] 
.const [38] = NameAndType [70] [71] 
.const [39] = Class [72] 
.const [40] = NameAndType [73] [74] 
.const [41] = Class [75] 
.const [42] = NameAndType [76] [77] 
.const [43] = Class [78] 
.const [44] = NameAndType [79] [80] 
.const [45] = Class [81] 
.const [46] = NameAndType [82] [83] 
.const [47] = Class [84] 
.const [48] = NameAndType [85] [86] 
.const [49] = Class [87] 
.const [50] = NameAndType [88] [89] 
.const [51] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/LinkedBlockingDeque 
.const [52] = Utf8 access$200 
.const [53] = Utf8 (Ledu/emory/mathcs/backport/java/util/concurrent/LinkedBlockingDeque;)Ledu/emory/mathcs/backport/java/util/concurrent/locks/ReentrantLock; 
.const [54] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/LinkedBlockingDeque 
.const [55] = Utf8 access$300 
.const [56] = Utf8 (Ledu/emory/mathcs/backport/java/util/concurrent/LinkedBlockingDeque;)Ledu/emory/mathcs/backport/java/util/concurrent/LinkedBlockingDeque$Node; 
.const [57] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/LinkedBlockingDeque$Itr 
.const [58] = Utf8 this$0 
.const [59] = Utf8 Ledu/emory/mathcs/backport/java/util/concurrent/LinkedBlockingDeque; 
.const [60] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/locks/ReentrantLock 
.const [61] = Utf8 lock 
.const [62] = Utf8 ()V 
.const [63] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/LinkedBlockingDeque$Itr 
.const [64] = Utf8 next 
.const [65] = Utf8 Ledu/emory/mathcs/backport/java/util/concurrent/LinkedBlockingDeque$Node; 
.const [66] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/LinkedBlockingDeque$Node 
.const [67] = Utf8 next 
.const [68] = Utf8 Ledu/emory/mathcs/backport/java/util/concurrent/LinkedBlockingDeque$Node; 
.const [69] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/LinkedBlockingDeque$Node 
.const [70] = Utf8 item 
.const [71] = Utf8 Ljava/lang/Object; 
.const [72] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/locks/ReentrantLock 
.const [73] = Utf8 unlock 
.const [74] = Utf8 ()V 
.const [75] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/LinkedBlockingDeque$Itr 
.const [76] = Utf8 <init> 
.const [77] = Utf8 (Ledu/emory/mathcs/backport/java/util/concurrent/LinkedBlockingDeque;)V 
.const [78] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/LinkedBlockingDeque$AbstractItr 
.const [79] = Utf8 <init> 
.const [80] = Utf8 (Ledu/emory/mathcs/backport/java/util/concurrent/LinkedBlockingDeque;)V 
.const [81] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/LinkedBlockingDeque$Itr 
.const [82] = Utf8 this$0 
.const [83] = Utf8 Ledu/emory/mathcs/backport/java/util/concurrent/LinkedBlockingDeque; 
.const [84] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/LinkedBlockingDeque$Itr 
.const [85] = Utf8 next 
.const [86] = Utf8 Ledu/emory/mathcs/backport/java/util/concurrent/LinkedBlockingDeque$Node; 
.const [87] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/LinkedBlockingDeque$Itr 
.const [88] = Utf8 nextItem 
.const [89] = Utf8 Ljava/lang/Object; 
.const [90] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/LinkedBlockingDeque$Itr 
.const [91] = Class [90] 
.const [92] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/LinkedBlockingDeque$AbstractItr 
.const [93] = Class [92] 
.const [94] = Utf8 this$0 
.const [95] = Utf8 Ledu/emory/mathcs/backport/java/util/concurrent/LinkedBlockingDeque; 
.const [96] = Utf8 Code 
.const [97] = Utf8 <init> 
.const [98] = Utf8 (Ledu/emory/mathcs/backport/java/util/concurrent/LinkedBlockingDeque;)V 
.const [99] = Utf8 advance 
.const [100] = Utf8 ()V 
.const [101] = Utf8 <init> 
.const [102] = Utf8 (Ledu/emory/mathcs/backport/java/util/concurrent/LinkedBlockingDeque;Ledu/emory/mathcs/backport/java/util/concurrent/LinkedBlockingDeque$1;)V 
.end class 
