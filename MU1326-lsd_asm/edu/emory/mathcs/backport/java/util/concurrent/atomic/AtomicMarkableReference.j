.version 50 0 
.class public super [87] 
.super [89] 
.field private final [90] [91] 

.method public [93] : [94] 
    .attribute [92] .code stack 7 locals 0 
L0:     aload_0 
L1:     invokespecial [13] 
L4:     aload_0 
L5:     new [17] 
L8:     dup 
L9:     new [18] 
L12:    dup 
L13:    aload_1 
L14:    iload_2 
L15:    invokespecial [14] 
L18:    invokespecial [15] 
L21:    putfield [19] 
L24:    return 
L25:    nop 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method private [95] : [96] 
    .attribute [92] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [8] 
L4:     invokevirtual [9] 
L7:     checkcast [3] 
L10:    areturn 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [97] : [98] 
    .attribute [92] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [16] 
L4:     invokestatic [4] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public [99] : [100] 
    .attribute [92] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [16] 
L4:     invokestatic [5] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public [101] : [102] 
    .attribute [92] .code stack 3 locals 1 
L0:     aload_0 
L1:     invokespecial [16] 
L4:     astore_2 
L5:     aload_1 
L6:     iconst_0 
L7:     aload_2 
L8:     invokestatic [5] 
L11:    bastore 
L12:    aload_2 
L13:    invokestatic [4] 
L16:    areturn 
L17:    nop 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [103] : [104] 
    .attribute [92] .code stack 6 locals 1 
L0:     aload_0 
L1:     invokespecial [16] 
L4:     astore 5 
L6:     aload_1 
L7:     aload 5 
L9:     invokestatic [4] 
L12:    if_acmpne L69 
L15:    iload_3 
L16:    aload 5 
L18:    invokestatic [5] 
L21:    if_icmpne L69 
L24:    aload_2 
L25:    aload 5 
L27:    invokestatic [4] 
L30:    if_acmpne L43 
L33:    iload 4 
L35:    aload 5 
L37:    invokestatic [5] 
L40:    if_icmpeq L65 
L43:    aload_0 
L44:    getfield [8] 
L47:    aload 5 
L49:    new [18] 
L52:    dup 
L53:    aload_2 
L54:    iload 4 
L56:    invokespecial [14] 
L59:    invokevirtual [10] 
L62:    ifeq L69 
L65:    iconst_1 
L66:    goto L70 
L69:    iconst_0 
L70:    areturn 
L71:    nop 
L72:    
    .end code 
.end method 

.method public [105] : [106] 
    .attribute [92] .code stack 6 locals 1 
L0:     aload_0 
L1:     invokespecial [16] 
L4:     astore 5 
L6:     aload_1 
L7:     aload 5 
L9:     invokestatic [4] 
L12:    if_acmpne L69 
L15:    iload_3 
L16:    aload 5 
L18:    invokestatic [5] 
L21:    if_icmpne L69 
L24:    aload_2 
L25:    aload 5 
L27:    invokestatic [4] 
L30:    if_acmpne L43 
L33:    iload 4 
L35:    aload 5 
L37:    invokestatic [5] 
L40:    if_icmpeq L65 
L43:    aload_0 
L44:    getfield [8] 
L47:    aload 5 
L49:    new [18] 
L52:    dup 
L53:    aload_2 
L54:    iload 4 
L56:    invokespecial [14] 
L59:    invokevirtual [11] 
L62:    ifeq L69 
L65:    iconst_1 
L66:    goto L70 
L69:    iconst_0 
L70:    areturn 
L71:    nop 
L72:    
    .end code 
.end method 

.method public [107] : [108] 
    .attribute [92] .code stack 5 locals 1 
L0:     aload_0 
L1:     invokespecial [16] 
L4:     astore_3 
L5:     aload_1 
L6:     aload_3 
L7:     invokestatic [4] 
L10:    if_acmpne L21 
L13:    iload_2 
L14:    aload_3 
L15:    invokestatic [5] 
L18:    if_icmpeq L37 
L21:    aload_0 
L22:    getfield [8] 
L25:    new [18] 
L28:    dup 
L29:    aload_1 
L30:    iload_2 
L31:    invokespecial [14] 
L34:    invokevirtual [12] 
L37:    return 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 

.method public [109] : [110] 
    .attribute [92] .code stack 6 locals 1 
L0:     aload_0 
L1:     invokespecial [16] 
L4:     astore_3 
L5:     aload_1 
L6:     aload_3 
L7:     invokestatic [4] 
L10:    if_acmpne L45 
L13:    iload_2 
L14:    aload_3 
L15:    invokestatic [5] 
L18:    if_icmpeq L41 
L21:    aload_0 
L22:    getfield [8] 
L25:    aload_3 
L26:    new [18] 
L29:    dup 
L30:    aload_1 
L31:    iload_2 
L32:    invokespecial [14] 
L35:    invokevirtual [11] 
L38:    ifeq L45 
L41:    iconst_1 
L42:    goto L46 
L45:    iconst_0 
L46:    areturn 
L47:    nop 
L48:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [20] 
.const [3] = Class [21] 
.const [4] = Method [22] [23] 
.const [5] = Method [24] [25] 
.const [6] = Class [26] 
.const [7] = Class [27] 
.const [8] = Field [28] [29] 
.const [9] = Method [30] [31] 
.const [10] = Method [32] [33] 
.const [11] = Method [34] [35] 
.const [12] = Method [36] [37] 
.const [13] = Method [38] [39] 
.const [14] = Method [40] [41] 
.const [15] = Method [42] [43] 
.const [16] = Method [44] [45] 
.const [17] = Class [46] 
.const [18] = Class [47] 
.const [19] = Field [48] [49] 
.const [20] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/atomic/AtomicReference 
.const [21] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/atomic/AtomicMarkableReference$ReferenceBooleanPair 
.const [22] = Class [50] 
.const [23] = NameAndType [51] [52] 
.const [24] = Class [53] 
.const [25] = NameAndType [54] [55] 
.const [26] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/atomic/AtomicMarkableReference 
.const [27] = Utf8 java/lang/Object 
.const [28] = Class [56] 
.const [29] = NameAndType [57] [58] 
.const [30] = Class [59] 
.const [31] = NameAndType [60] [61] 
.const [32] = Class [62] 
.const [33] = NameAndType [63] [64] 
.const [34] = Class [65] 
.const [35] = NameAndType [66] [67] 
.const [36] = Class [68] 
.const [37] = NameAndType [69] [70] 
.const [38] = Class [71] 
.const [39] = NameAndType [72] [73] 
.const [40] = Class [74] 
.const [41] = NameAndType [75] [76] 
.const [42] = Class [77] 
.const [43] = NameAndType [78] [79] 
.const [44] = Class [80] 
.const [45] = NameAndType [81] [82] 
.const [46] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/atomic/AtomicReference 
.const [47] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/atomic/AtomicMarkableReference$ReferenceBooleanPair 
.const [48] = Class [83] 
.const [49] = NameAndType [84] [85] 
.const [50] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/atomic/AtomicMarkableReference$ReferenceBooleanPair 
.const [51] = Utf8 access$000 
.const [52] = Utf8 (Ledu/emory/mathcs/backport/java/util/concurrent/atomic/AtomicMarkableReference$ReferenceBooleanPair;)Ljava/lang/Object; 
.const [53] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/atomic/AtomicMarkableReference$ReferenceBooleanPair 
.const [54] = Utf8 access$100 
.const [55] = Utf8 (Ledu/emory/mathcs/backport/java/util/concurrent/atomic/AtomicMarkableReference$ReferenceBooleanPair;)Z 
.const [56] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/atomic/AtomicMarkableReference 
.const [57] = Utf8 atomicRef 
.const [58] = Utf8 Ledu/emory/mathcs/backport/java/util/concurrent/atomic/AtomicReference; 
.const [59] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/atomic/AtomicReference 
.const [60] = Utf8 get 
.const [61] = Utf8 ()Ljava/lang/Object; 
.const [62] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/atomic/AtomicReference 
.const [63] = Utf8 weakCompareAndSet 
.const [64] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)Z 
.const [65] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/atomic/AtomicReference 
.const [66] = Utf8 compareAndSet 
.const [67] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)Z 
.const [68] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/atomic/AtomicReference 
.const [69] = Utf8 set 
.const [70] = Utf8 (Ljava/lang/Object;)V 
.const [71] = Utf8 java/lang/Object 
.const [72] = Utf8 <init> 
.const [73] = Utf8 ()V 
.const [74] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/atomic/AtomicMarkableReference$ReferenceBooleanPair 
.const [75] = Utf8 <init> 
.const [76] = Utf8 (Ljava/lang/Object;Z)V 
.const [77] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/atomic/AtomicReference 
.const [78] = Utf8 <init> 
.const [79] = Utf8 (Ljava/lang/Object;)V 
.const [80] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/atomic/AtomicMarkableReference 
.const [81] = Utf8 getPair 
.const [82] = Utf8 ()Ledu/emory/mathcs/backport/java/util/concurrent/atomic/AtomicMarkableReference$ReferenceBooleanPair; 
.const [83] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/atomic/AtomicMarkableReference 
.const [84] = Utf8 atomicRef 
.const [85] = Utf8 Ledu/emory/mathcs/backport/java/util/concurrent/atomic/AtomicReference; 
.const [86] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/atomic/AtomicMarkableReference 
.const [87] = Class [86] 
.const [88] = Utf8 java/lang/Object 
.const [89] = Class [88] 
.const [90] = Utf8 atomicRef 
.const [91] = Utf8 Ledu/emory/mathcs/backport/java/util/concurrent/atomic/AtomicReference; 
.const [92] = Utf8 Code 
.const [93] = Utf8 <init> 
.const [94] = Utf8 (Ljava/lang/Object;Z)V 
.const [95] = Utf8 getPair 
.const [96] = Utf8 ()Ledu/emory/mathcs/backport/java/util/concurrent/atomic/AtomicMarkableReference$ReferenceBooleanPair; 
.const [97] = Utf8 getReference 
.const [98] = Utf8 ()Ljava/lang/Object; 
.const [99] = Utf8 isMarked 
.const [100] = Utf8 ()Z 
.const [101] = Utf8 get 
.const [102] = Utf8 ([Z)Ljava/lang/Object; 
.const [103] = Utf8 weakCompareAndSet 
.const [104] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;ZZ)Z 
.const [105] = Utf8 compareAndSet 
.const [106] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;ZZ)Z 
.const [107] = Utf8 set 
.const [108] = Utf8 (Ljava/lang/Object;Z)V 
.const [109] = Utf8 attemptMark 
.const [110] = Utf8 (Ljava/lang/Object;Z)Z 
.end class 
