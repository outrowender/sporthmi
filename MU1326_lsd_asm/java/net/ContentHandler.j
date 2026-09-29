.version 50 0 
.class public super abstract [25] 
.super [27] 

.method public annotation [29] : [30] 
    .attribute [28] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [5] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public abstract [31] : [32] 
    .attribute [28] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method public [33] : [34] 
    .attribute [28] .code stack 3 locals 3 
L0:     aload_0 
L1:     aload_1 
L2:     invokevirtual [4] 
L5:     astore_3 
L6:     aload_3 
L7:     invokespecial [6] 
L10:    astore 4 
L12:    iconst_0 
L13:    istore 5 
L15:    goto L32 
L18:    aload 4 
L20:    aload_2 
L21:    iload 5 
L23:    aaload 
L24:    if_acmpne L29 
L27:    aload_3 
L28:    areturn 
L29:    iinc 5 1 
L32:    iload 5 
L34:    aload_2 
L35:    arraylength 
L36:    if_icmplt L18 
L39:    aconst_null 
L40:    areturn 
L41:    nop 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [7] 
.const [3] = Class [8] 
.const [4] = Method [9] [10] 
.const [5] = Method [11] [12] 
.const [6] = Method [13] [14] 
.const [7] = Utf8 java/net/ContentHandler 
.const [8] = Utf8 java/lang/Object 
.const [9] = Class [15] 
.const [10] = NameAndType [16] [17] 
.const [11] = Class [18] 
.const [12] = NameAndType [19] [20] 
.const [13] = Class [21] 
.const [14] = NameAndType [22] [23] 
.const [15] = Utf8 java/net/ContentHandler 
.const [16] = Utf8 getContent 
.const [17] = Utf8 (Ljava/net/URLConnection;)Ljava/lang/Object; 
.const [18] = Utf8 java/lang/Object 
.const [19] = Utf8 <init> 
.const [20] = Utf8 ()V 
.const [21] = Utf8 java/lang/Object 
.const [22] = Utf8 getClass 
.const [23] = Utf8 ()Ljava/lang/Class; 
.const [24] = Utf8 java/net/ContentHandler 
.const [25] = Class [24] 
.const [26] = Utf8 java/lang/Object 
.const [27] = Class [26] 
.const [28] = Utf8 Code 
.const [29] = Utf8 <init> 
.const [30] = Utf8 ()V 
.const [31] = Utf8 getContent 
.const [32] = Utf8 (Ljava/net/URLConnection;)Ljava/lang/Object; 
.const [33] = Utf8 getContent 
.const [34] = Utf8 (Ljava/net/URLConnection;[Ljava/lang/Class;)Ljava/lang/Object; 
.end class 
