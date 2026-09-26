.version 50 0 
.class super [47] 
.super [49] 
.implements [51] 
.field private [52] [53] 
.field private [54] [55] 

.method public [57] : [58] 
    .attribute [56] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [7] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [9] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [59] : [60] 
    .attribute [56] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [6] 
L4:     aload_0 
L5:     getfield [5] 
L8:     arraylength 
L9:     if_icmpge L16 
L12:    iconst_1 
L13:    goto L17 
L16:    iconst_0 
L17:    areturn 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [61] : [62] 
    .attribute [56] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [6] 
L4:     aload_0 
L5:     getfield [5] 
L8:     arraylength 
L9:     if_icmpge L29 
L12:    aload_0 
L13:    getfield [5] 
L16:    aload_0 
L17:    dup 
L18:    getfield [6] 
L21:    dup_x1 
L22:    iconst_1 
L23:    iadd 
L24:    putfield [10] 
L27:    aaload 
L28:    areturn 
L29:    new [11] 
L32:    dup 
L33:    invokespecial [8] 
L36:    athrow 
L37:    nop 
L38:    nop 
L39:    nop 
L40:    
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
.const [9] = Field [23] [24] 
.const [10] = Field [25] [26] 
.const [11] = Class [27] 
.const [12] = Utf8 java/util/NoSuchElementException 
.const [13] = Utf8 org/apache/xerces/impl/Constants$ArrayEnumeration 
.const [14] = Utf8 java/lang/Object 
.const [15] = Class [28] 
.const [16] = NameAndType [29] [30] 
.const [17] = Class [31] 
.const [18] = NameAndType [32] [33] 
.const [19] = Class [34] 
.const [20] = NameAndType [35] [36] 
.const [21] = Class [37] 
.const [22] = NameAndType [38] [39] 
.const [23] = Class [40] 
.const [24] = NameAndType [41] [42] 
.const [25] = Class [43] 
.const [26] = NameAndType [44] [45] 
.const [27] = Utf8 java/util/NoSuchElementException 
.const [28] = Utf8 org/apache/xerces/impl/Constants$ArrayEnumeration 
.const [29] = Utf8 array 
.const [30] = Utf8 [Ljava/lang/Object; 
.const [31] = Utf8 org/apache/xerces/impl/Constants$ArrayEnumeration 
.const [32] = Utf8 index 
.const [33] = Utf8 I 
.const [34] = Utf8 java/lang/Object 
.const [35] = Utf8 <init> 
.const [36] = Utf8 ()V 
.const [37] = Utf8 java/util/NoSuchElementException 
.const [38] = Utf8 <init> 
.const [39] = Utf8 ()V 
.const [40] = Utf8 org/apache/xerces/impl/Constants$ArrayEnumeration 
.const [41] = Utf8 array 
.const [42] = Utf8 [Ljava/lang/Object; 
.const [43] = Utf8 org/apache/xerces/impl/Constants$ArrayEnumeration 
.const [44] = Utf8 index 
.const [45] = Utf8 I 
.const [46] = Utf8 org/apache/xerces/impl/Constants$ArrayEnumeration 
.const [47] = Class [46] 
.const [48] = Utf8 java/lang/Object 
.const [49] = Class [48] 
.const [50] = Utf8 java/util/Enumeration 
.const [51] = Class [50] 
.const [52] = Utf8 array 
.const [53] = Utf8 [Ljava/lang/Object; 
.const [54] = Utf8 index 
.const [55] = Utf8 I 
.const [56] = Utf8 Code 
.const [57] = Utf8 <init> 
.const [58] = Utf8 ([Ljava/lang/Object;)V 
.const [59] = Utf8 hasMoreElements 
.const [60] = Utf8 ()Z 
.const [61] = Utf8 nextElement 
.const [62] = Utf8 ()Ljava/lang/Object; 
.end class 
