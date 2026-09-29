.version 50 0 
.class public super [71] 
.super [73] 
.field public static final [74] [75] 
.field public static final [76] [77] 
.field private [78] [79] 

.method public [81] : [82] 
    .attribute [80] .code stack 6 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     iconst_1 
L3:     sipush 1004 
L6:     iload_3 
L7:     aload_2 
L8:     invokespecial [16] 
L11:    return 
L12:    
    .end code 
.end method 

.method public [83] : [84] 
    .attribute [80] .code stack 2 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     putfield [17] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [85] : [86] 
    .attribute [80] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [9] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method protected [87] : [88] 
    .attribute [80] .code stack 2 locals 0 
L0:     aload_0 
L1:     iconst_m1 
L2:     putfield [17] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method protected [89] : [90] 
    .attribute [80] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokevirtual [10] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method protected [91] : [92] 
    .attribute [80] .code stack 4 locals 1 
L0:     aload_0 
L1:     invokevirtual [10] 
        .catch [2] from L4 to L13 using L16 
L4:     iload_1 
L5:     ifle L13 
L8:     aload_0 
L9:     aload_3 
L10:    invokevirtual [11] 
L13:    goto L33 
L16:    astore 4 
L18:    aload_0 
L19:    invokevirtual [12] 
L22:    sipush 10000 
L25:    ldc [3] 
L27:    aload 4 
L29:    invokevirtual [13] 
L32:    pop 
L33:    return 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 

.method protected [93] : [94] 
    .attribute [80] .code stack 2 locals 0 
L0:     aload_1 
L1:     aload_0 
L2:     getfield [9] 
L5:     invokevirtual [14] 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method protected [95] : [96] 
    .attribute [80] .code stack 2 locals 1 
L0:     aload_1 
L1:     invokevirtual [15] 
L4:     istore_2 
L5:     aload_0 
L6:     iload_2 
L7:     putfield [17] 
L10:    return 
L11:    nop 
L12:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [18] 
.const [3] = String [19] 
.const [4] = Class [20] 
.const [5] = Class [21] 
.const [6] = Class [22] 
.const [7] = Class [23] 
.const [8] = Class [24] 
.const [9] = Field [25] [26] 
.const [10] = Method [27] [28] 
.const [11] = Method [29] [30] 
.const [12] = Method [31] [32] 
.const [13] = Method [33] [34] 
.const [14] = Method [35] [36] 
.const [15] = Method [37] [38] 
.const [16] = Method [39] [40] 
.const [17] = Field [41] [42] 
.const [18] = Utf8 java/io/IOException 
.const [19] = Utf8 'GoogleMapLicensePersistenceHelper#GoogleMapLicenseState#convertContainer() - error on converting the persistent state format' 
.const [20] = Utf8 de/audi/tghu/navi/app/map/handler/GoogleMapLicensePersistenceHelper$GoogleMapLicenseState 
.const [21] = Utf8 de/audi/tghu/navi/app/PersistentState 
.const [22] = Utf8 de/audi/atip/log/LogChannel 
.const [23] = Utf8 java/io/DataOutputStream 
.const [24] = Utf8 java/io/DataInputStream 
.const [25] = Class [43] 
.const [26] = NameAndType [44] [45] 
.const [27] = Class [46] 
.const [28] = NameAndType [47] [48] 
.const [29] = Class [49] 
.const [30] = NameAndType [50] [51] 
.const [31] = Class [52] 
.const [32] = NameAndType [53] [54] 
.const [33] = Class [55] 
.const [34] = NameAndType [56] [57] 
.const [35] = Class [58] 
.const [36] = NameAndType [59] [60] 
.const [37] = Class [61] 
.const [38] = NameAndType [62] [63] 
.const [39] = Class [64] 
.const [40] = NameAndType [65] [66] 
.const [41] = Class [67] 
.const [42] = NameAndType [68] [69] 
.const [43] = Utf8 de/audi/tghu/navi/app/map/handler/GoogleMapLicensePersistenceHelper$GoogleMapLicenseState 
.const [44] = Utf8 serializedState 
.const [45] = Utf8 I 
.const [46] = Utf8 de/audi/tghu/navi/app/map/handler/GoogleMapLicensePersistenceHelper$GoogleMapLicenseState 
.const [47] = Utf8 initWithDefaultValues 
.const [48] = Utf8 ()V 
.const [49] = Utf8 de/audi/tghu/navi/app/map/handler/GoogleMapLicensePersistenceHelper$GoogleMapLicenseState 
.const [50] = Utf8 deserialize 
.const [51] = Utf8 (Ljava/io/DataInputStream;)V 
.const [52] = Utf8 de/audi/tghu/navi/app/map/handler/GoogleMapLicensePersistenceHelper$GoogleMapLicenseState 
.const [53] = Utf8 getLogChannel 
.const [54] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.const [55] = Utf8 de/audi/atip/log/LogChannel 
.const [56] = Utf8 log 
.const [57] = Utf8 (ILjava/lang/String;Ljava/lang/Throwable;)Z 
.const [58] = Utf8 java/io/DataOutputStream 
.const [59] = Utf8 writeInt 
.const [60] = Utf8 (I)V 
.const [61] = Utf8 java/io/DataInputStream 
.const [62] = Utf8 readInt 
.const [63] = Utf8 ()I 
.const [64] = Utf8 de/audi/tghu/navi/app/PersistentState 
.const [65] = Utf8 <init> 
.const [66] = Utf8 (Lde/audi/atip/storage/IStorageAccess;IIILde/audi/atip/log/LogChannel;)V 
.const [67] = Utf8 de/audi/tghu/navi/app/map/handler/GoogleMapLicensePersistenceHelper$GoogleMapLicenseState 
.const [68] = Utf8 serializedState 
.const [69] = Utf8 I 
.const [70] = Utf8 de/audi/tghu/navi/app/map/handler/GoogleMapLicensePersistenceHelper$GoogleMapLicenseState 
.const [71] = Class [70] 
.const [72] = Utf8 de/audi/tghu/navi/app/PersistentState 
.const [73] = Class [72] 
.const [74] = Utf8 VERSION 
.const [75] = Utf8 I 
.const [76] = Utf8 DEFAULT_GE_LICENSE_STATE 
.const [77] = Utf8 I 
.const [78] = Utf8 serializedState 
.const [79] = Utf8 I 
.const [80] = Utf8 Code 
.const [81] = Utf8 <init> 
.const [82] = Utf8 (Lde/audi/atip/storage/IStorageAccess;Lde/audi/atip/log/LogChannel;I)V 
.const [83] = Utf8 setGoogleMapLicenseState 
.const [84] = Utf8 (I)V 
.const [85] = Utf8 getGoogleMapLicenseState 
.const [86] = Utf8 ()I 
.const [87] = Utf8 initWithDefaultValues 
.const [88] = Utf8 ()V 
.const [89] = Utf8 initFromOldKeys 
.const [90] = Utf8 (Lde/audi/atip/storage/IStorageAccess;)V 
.const [91] = Utf8 convertContainer 
.const [92] = Utf8 (IILjava/io/DataInputStream;)V 
.const [93] = Utf8 serialize 
.const [94] = Utf8 (Ljava/io/DataOutputStream;)V 
.const [95] = Utf8 deserialize 
.const [96] = Utf8 (Ljava/io/DataInputStream;)V 
.end class 
