.version 50 0 
.class super [41] 
.super [43] 
.implements [45] 
.field private final synthetic [46] [47] 
.field private final synthetic [48] [49] 

.method [51] : [52] 
    .attribute [50] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [9] 
L5:     aload_0 
L6:     aload_2 
L7:     putfield [10] 
L10:    aload_0 
L11:    invokespecial [8] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [53] : [54] 
    .attribute [50] .code stack 2 locals 2 
L0:     aconst_null 
L1:     astore_1 
        .catch [2] from L2 to L10 using L13 
L2:     aload_0 
L3:     getfield [6] 
L6:     invokevirtual [7] 
L9:     astore_1 
L10:    goto L14 
L13:    astore_2 
L14:    aload_1 
L15:    aload_0 
L16:    getfield [6] 
L19:    if_acmpne L26 
L22:    aconst_null 
L23:    goto L27 
L26:    aload_1 
L27:    areturn 
L28:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [11] 
.const [3] = Class [12] 
.const [4] = Class [13] 
.const [5] = Class [14] 
.const [6] = Field [15] [16] 
.const [7] = Method [17] [18] 
.const [8] = Method [19] [20] 
.const [9] = Field [21] [22] 
.const [10] = Field [23] [24] 
.const [11] = Utf8 java/lang/SecurityException 
.const [12] = Utf8 org/apache/xerces/dom/SecuritySupport$3 
.const [13] = Utf8 java/lang/Object 
.const [14] = Utf8 java/lang/ClassLoader 
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
.const [25] = Utf8 org/apache/xerces/dom/SecuritySupport$3 
.const [26] = Utf8 val$cl 
.const [27] = Utf8 Ljava/lang/ClassLoader; 
.const [28] = Utf8 java/lang/ClassLoader 
.const [29] = Utf8 getParent 
.const [30] = Utf8 ()Ljava/lang/ClassLoader; 
.const [31] = Utf8 java/lang/Object 
.const [32] = Utf8 <init> 
.const [33] = Utf8 ()V 
.const [34] = Utf8 org/apache/xerces/dom/SecuritySupport$3 
.const [35] = Utf8 this$0 
.const [36] = Utf8 Lorg/apache/xerces/dom/SecuritySupport; 
.const [37] = Utf8 org/apache/xerces/dom/SecuritySupport$3 
.const [38] = Utf8 val$cl 
.const [39] = Utf8 Ljava/lang/ClassLoader; 
.const [40] = Utf8 org/apache/xerces/dom/SecuritySupport$3 
.const [41] = Class [40] 
.const [42] = Utf8 java/lang/Object 
.const [43] = Class [42] 
.const [44] = Utf8 java/security/PrivilegedAction 
.const [45] = Class [44] 
.const [46] = Utf8 val$cl 
.const [47] = Utf8 Ljava/lang/ClassLoader; 
.const [48] = Utf8 this$0 
.const [49] = Utf8 Lorg/apache/xerces/dom/SecuritySupport; 
.const [50] = Utf8 Code 
.const [51] = Utf8 <init> 
.const [52] = Utf8 (Lorg/apache/xerces/dom/SecuritySupport;Ljava/lang/ClassLoader;)V 
.const [53] = Utf8 run 
.const [54] = Utf8 ()Ljava/lang/Object; 
.end class 
