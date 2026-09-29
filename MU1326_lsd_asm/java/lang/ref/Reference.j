.version 50 0 
.class public super abstract [69] 
.super [71] 
.field private [72] [73] 
.field private [74] [75] 
.field private [76] [77] 

.method public [79] : [80] 
    .attribute [78] .code stack 2 locals 0 
L0:     aload_0 
L1:     aconst_null 
L2:     putfield [12] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [81] : [82] 
    .attribute [78] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokevirtual [6] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [83] : [84] 
    .attribute [78] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [5] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [85] : [86] 
    .attribute [78] .code stack 2 locals 1 
L0:     aload_0 
L1:     dup 
L2:     astore_1 
L3:     monitorenter 
        .catch [0] from L4 to L10 using L11 
L4:     aload_0 
L5:     getfield [7] 
L8:     aload_1 
L9:     monitorexit 
L10:    areturn 
        .catch [0] from L11 to L13 using L11 
L11:    aload_1 
L12:    monitorexit 
L13:    athrow 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method [87] : [88] 
    .attribute [78] .code stack 2 locals 3 
L0:     aload_0 
L1:     dup 
L2:     astore_3 
L3:     monitorenter 
        .catch [0] from L4 to L27 using L48 
L4:     aload_0 
L5:     getfield [8] 
L8:     astore_1 
L9:     aload_0 
L10:    aconst_null 
L11:    putfield [14] 
L14:    aload_0 
L15:    getfield [7] 
L18:    ifne L25 
L21:    aload_1 
L22:    ifnonnull L29 
L25:    aload_3 
L26:    monitorexit 
L27:    iconst_0 
L28:    areturn 
        .catch [0] from L29 to L47 using L48 
L29:    aload_1 
L30:    aload_0 
L31:    invokevirtual [9] 
L34:    istore_2 
L35:    iload_2 
L36:    ifeq L44 
L39:    aload_0 
L40:    iconst_1 
L41:    putfield [13] 
L44:    iload_2 
L45:    aload_3 
L46:    monitorexit 
L47:    areturn 
        .catch [0] from L48 to L50 using L48 
L48:    aload_3 
L49:    monitorexit 
L50:    athrow 
L51:    nop 
L52:    
    .end code 
.end method 

.method annotation [89] : [90] 
    .attribute [78] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [10] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method [91] : [92] 
    .attribute [78] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [11] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method [93] : [94] 
    .attribute [78] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_2 
L2:     putfield [14] 
L5:     aload_0 
L6:     iconst_0 
L7:     putfield [13] 
L10:    aload_0 
L11:    aload_1 
L12:    invokespecial [11] 
L15:    return 
L16:    
    .end code 
.end method 

.method private final native [95] : [96] 
    .attribute [78] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method [97] : [98] 
    .attribute [78] .code stack 2 locals 1 
L0:     aload_0 
L1:     dup 
L2:     astore_1 
L3:     monitorenter 
        .catch [0] from L4 to L11 using L14 
L4:     aload_0 
L5:     iconst_0 
L6:     putfield [13] 
L9:     aload_1 
L10:    monitorexit 
L11:    goto L17 
        .catch [0] from L14 to L16 using L14 
L14:    aload_1 
L15:    monitorexit 
L16:    athrow 
L17:    return 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [15] 
.const [3] = Class [16] 
.const [4] = Class [17] 
.const [5] = Field [18] [19] 
.const [6] = Method [20] [21] 
.const [7] = Field [22] [23] 
.const [8] = Field [24] [25] 
.const [9] = Method [26] [27] 
.const [10] = Method [28] [29] 
.const [11] = Method [30] [31] 
.const [12] = Field [32] [33] 
.const [13] = Field [34] [35] 
.const [14] = Field [36] [37] 
.const [15] = Utf8 java/lang/ref/Reference 
.const [16] = Utf8 java/lang/Object 
.const [17] = Utf8 java/lang/ref/ReferenceQueue 
.const [18] = Class [38] 
.const [19] = NameAndType [39] [40] 
.const [20] = Class [41] 
.const [21] = NameAndType [42] [43] 
.const [22] = Class [44] 
.const [23] = NameAndType [45] [46] 
.const [24] = Class [47] 
.const [25] = NameAndType [48] [49] 
.const [26] = Class [50] 
.const [27] = NameAndType [51] [52] 
.const [28] = Class [53] 
.const [29] = NameAndType [54] [55] 
.const [30] = Class [56] 
.const [31] = NameAndType [57] [58] 
.const [32] = Class [59] 
.const [33] = NameAndType [60] [61] 
.const [34] = Class [62] 
.const [35] = NameAndType [63] [64] 
.const [36] = Class [65] 
.const [37] = NameAndType [66] [67] 
.const [38] = Utf8 java/lang/ref/Reference 
.const [39] = Utf8 referent 
.const [40] = Utf8 Ljava/lang/Object; 
.const [41] = Utf8 java/lang/ref/Reference 
.const [42] = Utf8 enqueueImpl 
.const [43] = Utf8 ()Z 
.const [44] = Utf8 java/lang/ref/Reference 
.const [45] = Utf8 enqueued 
.const [46] = Utf8 Z 
.const [47] = Utf8 java/lang/ref/Reference 
.const [48] = Utf8 queue 
.const [49] = Utf8 Ljava/lang/ref/ReferenceQueue; 
.const [50] = Utf8 java/lang/ref/ReferenceQueue 
.const [51] = Utf8 enqueue 
.const [52] = Utf8 (Ljava/lang/ref/Reference;)Z 
.const [53] = Utf8 java/lang/Object 
.const [54] = Utf8 <init> 
.const [55] = Utf8 ()V 
.const [56] = Utf8 java/lang/ref/Reference 
.const [57] = Utf8 initReferenceImpl 
.const [58] = Utf8 (Ljava/lang/Object;)V 
.const [59] = Utf8 java/lang/ref/Reference 
.const [60] = Utf8 referent 
.const [61] = Utf8 Ljava/lang/Object; 
.const [62] = Utf8 java/lang/ref/Reference 
.const [63] = Utf8 enqueued 
.const [64] = Utf8 Z 
.const [65] = Utf8 java/lang/ref/Reference 
.const [66] = Utf8 queue 
.const [67] = Utf8 Ljava/lang/ref/ReferenceQueue; 
.const [68] = Utf8 java/lang/ref/Reference 
.const [69] = Class [68] 
.const [70] = Utf8 java/lang/Object 
.const [71] = Class [70] 
.const [72] = Utf8 referent 
.const [73] = Utf8 Ljava/lang/Object; 
.const [74] = Utf8 queue 
.const [75] = Utf8 Ljava/lang/ref/ReferenceQueue; 
.const [76] = Utf8 enqueued 
.const [77] = Utf8 Z 
.const [78] = Utf8 Code 
.const [79] = Utf8 clear 
.const [80] = Utf8 ()V 
.const [81] = Utf8 enqueue 
.const [82] = Utf8 ()Z 
.const [83] = Utf8 get 
.const [84] = Utf8 ()Ljava/lang/Object; 
.const [85] = Utf8 isEnqueued 
.const [86] = Utf8 ()Z 
.const [87] = Utf8 enqueueImpl 
.const [88] = Utf8 ()Z 
.const [89] = Utf8 <init> 
.const [90] = Utf8 ()V 
.const [91] = Utf8 initReference 
.const [92] = Utf8 (Ljava/lang/Object;)V 
.const [93] = Utf8 initReference 
.const [94] = Utf8 (Ljava/lang/Object;Ljava/lang/ref/ReferenceQueue;)V 
.const [95] = Utf8 initReferenceImpl 
.const [96] = Utf8 (Ljava/lang/Object;)V 
.const [97] = Utf8 dequeue 
.const [98] = Utf8 ()V 
.end class 
