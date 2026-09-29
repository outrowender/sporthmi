.version 50 0 
.class final super [25] 
.super [27] 
.implements [29] 

.method annotation [31] : [32] 
    .attribute [30] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [6] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [33] : [34] 
    .attribute [30] .code stack 4 locals 0 
L0:     aload_1 
L1:     checkcast [3] 
L4:     getfield [4] 
L7:     aload_2 
L8:     checkcast [3] 
L11:    getfield [4] 
L14:    lcmp 
L15:    ifle L20 
L18:    iconst_1 
L19:    areturn 
L20:    aload_1 
L21:    checkcast [3] 
L24:    getfield [4] 
L27:    aload_2 
L28:    checkcast [3] 
L31:    getfield [4] 
L34:    lcmp 
L35:    ifne L42 
L38:    iconst_0 
L39:    goto L43 
L42:    iconst_m1 
L43:    areturn 
L44:    
    .end code 
.end method 

.method public [35] : [36] 
    .attribute [30] .code stack 2 locals 0 
L0:     aload_1 
L1:     aload_2 
L2:     invokevirtual [5] 
L5:     areturn 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [7] 
.const [3] = Class [8] 
.const [4] = Field [9] [10] 
.const [5] = Method [11] [12] 
.const [6] = Method [13] [14] 
.const [7] = Utf8 java/lang/Object 
.const [8] = Utf8 com/ibm/oti/net/www/protocol/jar/JarURLConnection$LRUKey 
.const [9] = Class [15] 
.const [10] = NameAndType [16] [17] 
.const [11] = Class [18] 
.const [12] = NameAndType [19] [20] 
.const [13] = Class [21] 
.const [14] = NameAndType [22] [23] 
.const [15] = Utf8 com/ibm/oti/net/www/protocol/jar/JarURLConnection$LRUKey 
.const [16] = Utf8 ts 
.const [17] = Utf8 J 
.const [18] = Utf8 java/lang/Object 
.const [19] = Utf8 equals 
.const [20] = Utf8 (Ljava/lang/Object;)Z 
.const [21] = Utf8 java/lang/Object 
.const [22] = Utf8 <init> 
.const [23] = Utf8 ()V 
.const [24] = Utf8 com/ibm/oti/net/www/protocol/jar/JarURLConnection$LRUComparitor 
.const [25] = Class [24] 
.const [26] = Utf8 java/lang/Object 
.const [27] = Class [26] 
.const [28] = Utf8 java/util/Comparator 
.const [29] = Class [28] 
.const [30] = Utf8 Code 
.const [31] = Utf8 <init> 
.const [32] = Utf8 ()V 
.const [33] = Utf8 compare 
.const [34] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)I 
.const [35] = Utf8 equals 
.const [36] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)Z 
.end class 
