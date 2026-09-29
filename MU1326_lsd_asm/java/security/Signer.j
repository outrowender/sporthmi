.version 50 0 
.class public super abstract [93] 
.super [95] 
.field private static final [96] [97] 
.field [98] [99] 

.method protected annotation [101] : [102] 
    .attribute [100] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [16] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public annotation [103] : [104] 
    .attribute [100] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [17] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public annotation [105] : [106] 
    .attribute [100] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     invokespecial [18] 
L6:     return 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [107] : [108] 
    .attribute [100] .code stack 2 locals 1 
L0:     invokestatic [5] 
L3:     astore_1 
L4:     aload_1 
L5:     ifnull L14 
L8:     aload_1 
L9:     ldc [6] 
L11:    invokevirtual [11] 
L14:    aload_0 
L15:    getfield [12] 
L18:    areturn 
L19:    nop 
L20:    
    .end code 
.end method 

.method public final [109] : [110] 
    .attribute [100] .code stack 2 locals 3 
L0:     invokestatic [5] 
L3:     astore_2 
L4:     aload_2 
L5:     ifnull L14 
L8:     aload_2 
L9:     ldc [9] 
L11:    invokevirtual [11] 
L14:    aload_1 
L15:    invokevirtual [13] 
L18:    astore_3 
L19:    aload_1 
L20:    invokevirtual [14] 
L23:    astore 4 
L25:    aload 4 
L27:    ifnull L34 
L30:    aload_3 
L31:    ifnonnull L42 
L34:    new [22] 
L37:    dup 
L38:    invokespecial [19] 
L41:    athrow 
L42:    aload_0 
L43:    aload_3 
L44:    invokevirtual [15] 
L47:    aload_0 
L48:    aload 4 
L50:    putfield [21] 
L53:    return 
L54:    nop 
L55:    nop 
L56:    
    .end code 
.end method 

.method public [111] : [112] 
    .attribute [100] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [20] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [23] 
.const [3] = Class [24] 
.const [4] = Class [25] 
.const [5] = Method [26] [27] 
.const [6] = String [28] 
.const [7] = Class [29] 
.const [8] = Class [30] 
.const [9] = String [31] 
.const [10] = Class [32] 
.const [11] = Method [33] [34] 
.const [12] = Field [35] [36] 
.const [13] = Method [37] [38] 
.const [14] = Method [39] [40] 
.const [15] = Method [41] [42] 
.const [16] = Method [43] [44] 
.const [17] = Method [45] [46] 
.const [18] = Method [47] [48] 
.const [19] = Method [49] [50] 
.const [20] = Method [51] [52] 
.const [21] = Field [53] [54] 
.const [22] = Class [55] 
.const [23] = Utf8 java/security/Signer 
.const [24] = Utf8 java/security/Identity 
.const [25] = Utf8 java/lang/System 
.const [26] = Class [56] 
.const [27] = NameAndType [57] [58] 
.const [28] = Utf8 getSignerPrivateKey 
.const [29] = Utf8 java/lang/SecurityManager 
.const [30] = Utf8 java/security/InvalidParameterException 
.const [31] = Utf8 setSignerKeyPair 
.const [32] = Utf8 java/security/KeyPair 
.const [33] = Class [59] 
.const [34] = NameAndType [60] [61] 
.const [35] = Class [62] 
.const [36] = NameAndType [63] [64] 
.const [37] = Class [65] 
.const [38] = NameAndType [66] [67] 
.const [39] = Class [68] 
.const [40] = NameAndType [69] [70] 
.const [41] = Class [71] 
.const [42] = NameAndType [72] [73] 
.const [43] = Class [74] 
.const [44] = NameAndType [75] [76] 
.const [45] = Class [77] 
.const [46] = NameAndType [78] [79] 
.const [47] = Class [80] 
.const [48] = NameAndType [81] [82] 
.const [49] = Class [83] 
.const [50] = NameAndType [84] [85] 
.const [51] = Class [86] 
.const [52] = NameAndType [87] [88] 
.const [53] = Class [89] 
.const [54] = NameAndType [90] [91] 
.const [55] = Utf8 java/security/InvalidParameterException 
.const [56] = Utf8 java/lang/System 
.const [57] = Utf8 getSecurityManager 
.const [58] = Utf8 ()Ljava/lang/SecurityManager; 
.const [59] = Utf8 java/lang/SecurityManager 
.const [60] = Utf8 checkSecurityAccess 
.const [61] = Utf8 (Ljava/lang/String;)V 
.const [62] = Utf8 java/security/Signer 
.const [63] = Utf8 privateKey 
.const [64] = Utf8 Ljava/security/PrivateKey; 
.const [65] = Utf8 java/security/KeyPair 
.const [66] = Utf8 getPublic 
.const [67] = Utf8 ()Ljava/security/PublicKey; 
.const [68] = Utf8 java/security/KeyPair 
.const [69] = Utf8 getPrivate 
.const [70] = Utf8 ()Ljava/security/PrivateKey; 
.const [71] = Utf8 java/security/Signer 
.const [72] = Utf8 setPublicKey 
.const [73] = Utf8 (Ljava/security/PublicKey;)V 
.const [74] = Utf8 java/security/Identity 
.const [75] = Utf8 <init> 
.const [76] = Utf8 ()V 
.const [77] = Utf8 java/security/Identity 
.const [78] = Utf8 <init> 
.const [79] = Utf8 (Ljava/lang/String;)V 
.const [80] = Utf8 java/security/Identity 
.const [81] = Utf8 <init> 
.const [82] = Utf8 (Ljava/lang/String;Ljava/security/IdentityScope;)V 
.const [83] = Utf8 java/security/InvalidParameterException 
.const [84] = Utf8 <init> 
.const [85] = Utf8 ()V 
.const [86] = Utf8 java/security/Identity 
.const [87] = Utf8 toString 
.const [88] = Utf8 ()Ljava/lang/String; 
.const [89] = Utf8 java/security/Signer 
.const [90] = Utf8 privateKey 
.const [91] = Utf8 Ljava/security/PrivateKey; 
.const [92] = Utf8 java/security/Signer 
.const [93] = Class [92] 
.const [94] = Utf8 java/security/Identity 
.const [95] = Class [94] 
.const [96] = Utf8 serialVersionUID 
.const [97] = Utf8 J 
.const [98] = Utf8 privateKey 
.const [99] = Utf8 Ljava/security/PrivateKey; 
.const [100] = Utf8 Code 
.const [101] = Utf8 <init> 
.const [102] = Utf8 ()V 
.const [103] = Utf8 <init> 
.const [104] = Utf8 (Ljava/lang/String;)V 
.const [105] = Utf8 <init> 
.const [106] = Utf8 (Ljava/lang/String;Ljava/security/IdentityScope;)V 
.const [107] = Utf8 getPrivateKey 
.const [108] = Utf8 ()Ljava/security/PrivateKey; 
.const [109] = Utf8 setKeyPair 
.const [110] = Utf8 (Ljava/security/KeyPair;)V 
.const [111] = Utf8 toString 
.const [112] = Utf8 ()Ljava/lang/String; 
.end class 
