.version 50 0 
.class public super [79] 
.super [81] 
.implements [83] 
.field static final [84] [85] 
.field [86] [87] 
.field [88] [89] 

.method protected [91] : [92] 
    .attribute [90] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [13] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [16] 
L9:     aload_0 
L10:    aload_2 
L11:    putfield [17] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method protected [93] : [94] 
    .attribute [90] .code stack 4 locals 2 
        .catch [8] from L0 to L26 using L26 
L0:     aload_0 
L1:     getfield [9] 
L4:     invokestatic [5] 
L7:     astore_1 
L8:     aload_1 
L9:     new [18] 
L12:    dup 
L13:    aload_0 
L14:    getfield [10] 
L17:    invokespecial [14] 
L20:    invokevirtual [11] 
L23:    astore_2 
L24:    aload_2 
L25:    areturn 
L26:    astore_1 
L27:    new [19] 
L30:    dup 
L31:    aload_1 
L32:    invokevirtual [12] 
L35:    invokespecial [15] 
L38:    athrow 
L39:    nop 
L40:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [20] 
.const [3] = Class [21] 
.const [4] = Class [22] 
.const [5] = Method [23] [24] 
.const [6] = Class [25] 
.const [7] = Class [26] 
.const [8] = Class [27] 
.const [9] = Field [28] [29] 
.const [10] = Field [30] [31] 
.const [11] = Method [32] [33] 
.const [12] = Method [34] [35] 
.const [13] = Method [36] [37] 
.const [14] = Method [38] [39] 
.const [15] = Method [40] [41] 
.const [16] = Field [42] [43] 
.const [17] = Field [44] [45] 
.const [18] = Class [46] 
.const [19] = Class [47] 
.const [20] = Utf8 java/security/cert/Certificate$CertificateRep 
.const [21] = Utf8 java/lang/Object 
.const [22] = Utf8 java/security/cert/CertificateFactory 
.const [23] = Class [48] 
.const [24] = NameAndType [49] [50] 
.const [25] = Utf8 java/io/ByteArrayInputStream 
.const [26] = Utf8 java/io/InvalidObjectException 
.const [27] = Utf8 java/security/cert/CertificateException 
.const [28] = Class [51] 
.const [29] = NameAndType [52] [53] 
.const [30] = Class [54] 
.const [31] = NameAndType [55] [56] 
.const [32] = Class [57] 
.const [33] = NameAndType [58] [59] 
.const [34] = Class [60] 
.const [35] = NameAndType [61] [62] 
.const [36] = Class [63] 
.const [37] = NameAndType [64] [65] 
.const [38] = Class [66] 
.const [39] = NameAndType [67] [68] 
.const [40] = Class [69] 
.const [41] = NameAndType [70] [71] 
.const [42] = Class [72] 
.const [43] = NameAndType [73] [74] 
.const [44] = Class [75] 
.const [45] = NameAndType [76] [77] 
.const [46] = Utf8 java/io/ByteArrayInputStream 
.const [47] = Utf8 java/io/InvalidObjectException 
.const [48] = Utf8 java/security/cert/CertificateFactory 
.const [49] = Utf8 getInstance 
.const [50] = Utf8 (Ljava/lang/String;)Ljava/security/cert/CertificateFactory; 
.const [51] = Utf8 java/security/cert/Certificate$CertificateRep 
.const [52] = Utf8 type 
.const [53] = Utf8 Ljava/lang/String; 
.const [54] = Utf8 java/security/cert/Certificate$CertificateRep 
.const [55] = Utf8 data 
.const [56] = Utf8 [B 
.const [57] = Utf8 java/security/cert/CertificateFactory 
.const [58] = Utf8 generateCertificate 
.const [59] = Utf8 (Ljava/io/InputStream;)Ljava/security/cert/Certificate; 
.const [60] = Utf8 java/security/cert/CertificateException 
.const [61] = Utf8 toString 
.const [62] = Utf8 ()Ljava/lang/String; 
.const [63] = Utf8 java/lang/Object 
.const [64] = Utf8 <init> 
.const [65] = Utf8 ()V 
.const [66] = Utf8 java/io/ByteArrayInputStream 
.const [67] = Utf8 <init> 
.const [68] = Utf8 ([B)V 
.const [69] = Utf8 java/io/InvalidObjectException 
.const [70] = Utf8 <init> 
.const [71] = Utf8 (Ljava/lang/String;)V 
.const [72] = Utf8 java/security/cert/Certificate$CertificateRep 
.const [73] = Utf8 type 
.const [74] = Utf8 Ljava/lang/String; 
.const [75] = Utf8 java/security/cert/Certificate$CertificateRep 
.const [76] = Utf8 data 
.const [77] = Utf8 [B 
.const [78] = Utf8 java/security/cert/Certificate$CertificateRep 
.const [79] = Class [78] 
.const [80] = Utf8 java/lang/Object 
.const [81] = Class [80] 
.const [82] = Utf8 java/io/Serializable 
.const [83] = Class [82] 
.const [84] = Utf8 serialVersionUID 
.const [85] = Utf8 J 
.const [86] = Utf8 type 
.const [87] = Utf8 Ljava/lang/String; 
.const [88] = Utf8 data 
.const [89] = Utf8 [B 
.const [90] = Utf8 Code 
.const [91] = Utf8 <init> 
.const [92] = Utf8 (Ljava/lang/String;[B)V 
.const [93] = Utf8 readResolve 
.const [94] = Utf8 ()Ljava/lang/Object; 
.end class 
