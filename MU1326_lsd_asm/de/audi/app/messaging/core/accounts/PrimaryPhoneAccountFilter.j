.version 50 0 
.class public super [109] 
.super [111] 
.implements [113] 
.field private final [114] [115] 
.field [116] [117] 

.method public [119] : [120] 
    .attribute [118] .code stack 4 locals 0 
L0:     aload_0 
L1:     invokespecial [25] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [26] 
L9:     aload_0 
L10:    aload_2 
L11:    putfield [27] 
L14:    aload_0 
L15:    getfield [16] 
L18:    ldc [2] 
L20:    ldc [3] 
L22:    aload_1 
L23:    invokevirtual [17] 
L26:    pop 
L27:    return 
L28:    
    .end code 
.end method 

.method public [121] : [122] 
    .attribute [118] .code stack 3 locals 1 
L0:     iconst_0 
L1:     istore_2 
L2:     aload_0 
L3:     getfield [15] 
L6:     ifnull L83 
L9:     aload_0 
L10:    getfield [15] 
L13:    invokevirtual [18] 
L16:    ifeq L51 
L19:    aload_1 
L20:    invokevirtual [19] 
L23:    invokestatic [4] 
L26:    ifne L95 
L29:    aload_1 
L30:    invokevirtual [19] 
L33:    aload_0 
L34:    getfield [15] 
L37:    invokevirtual [20] 
L40:    invokevirtual [21] 
L43:    ifeq L95 
L46:    iconst_1 
L47:    istore_2 
L48:    goto L95 
L51:    aload_1 
L52:    invokevirtual [22] 
L55:    invokestatic [4] 
L58:    ifne L95 
L61:    aload_1 
L62:    invokevirtual [22] 
L65:    aload_0 
L66:    getfield [15] 
L69:    invokevirtual [23] 
L72:    invokevirtual [21] 
L75:    ifeq L95 
L78:    iconst_1 
L79:    istore_2 
L80:    goto L95 
L83:    aload_0 
L84:    getfield [16] 
L87:    ldc [5] 
L89:    ldc [6] 
L91:    invokevirtual [24] 
L94:    pop 
L95:    iload_2 
L96:    areturn 
L97:    nop 
L98:    nop 
L99:    nop 
L100:   
    .end code 
.end method 

.method public [123] : [124] 
    .attribute [118] .code stack 1 locals 0 
L0:     ldc [7] 
L2:     areturn 
L3:     nop 
L4:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int 1078071040 
.const [3] = String [28] 
.const [4] = Method [29] [30] 
.const [5] = Int -1601830656 
.const [6] = String [31] 
.const [7] = String [32] 
.const [8] = Class [33] 
.const [9] = Class [34] 
.const [10] = Class [35] 
.const [11] = Class [36] 
.const [12] = Class [37] 
.const [13] = Class [38] 
.const [14] = Class [39] 
.const [15] = Field [40] [41] 
.const [16] = Field [42] [43] 
.const [17] = Method [44] [45] 
.const [18] = Method [46] [47] 
.const [19] = Method [48] [49] 
.const [20] = Method [50] [51] 
.const [21] = Method [52] [53] 
.const [22] = Method [54] [55] 
.const [23] = Method [56] [57] 
.const [24] = Method [58] [59] 
.const [25] = Method [60] [61] 
.const [26] = Field [62] [63] 
.const [27] = Field [64] [65] 
.const [28] = Utf8 '[PrimaryPhoneAccountFilter#Constructor] primaryDevice = %1' 
.const [29] = Class [66] 
.const [30] = NameAndType [67] [68] 
.const [31] = Utf8 '[PrimaryPhoneAccountFilter#accept] primaryDevice is NULL' 
.const [32] = Utf8 'AccountFilter for PrimaryDevice Accounts' 
.const [33] = Utf8 de/audi/app/messaging/core/accounts/PrimaryPhoneAccountFilter 
.const [34] = Utf8 java/lang/Object 
.const [35] = Utf8 de/audi/atip/log/LogChannel 
.const [36] = Utf8 de/audi/atip/interapp/messaging/devicerole/DeviceRoleInfo 
.const [37] = Utf8 org/dsi/ifc/messaging/MessagingAccount 
.const [38] = Utf8 de/audi/app/messaging/core/util/Strings 
.const [39] = Utf8 java/lang/String 
.const [40] = Class [69] 
.const [41] = NameAndType [70] [71] 
.const [42] = Class [72] 
.const [43] = NameAndType [73] [74] 
.const [44] = Class [75] 
.const [45] = NameAndType [76] [77] 
.const [46] = Class [78] 
.const [47] = NameAndType [79] [80] 
.const [48] = Class [81] 
.const [49] = NameAndType [82] [83] 
.const [50] = Class [84] 
.const [51] = NameAndType [85] [86] 
.const [52] = Class [87] 
.const [53] = NameAndType [88] [89] 
.const [54] = Class [90] 
.const [55] = NameAndType [91] [92] 
.const [56] = Class [93] 
.const [57] = NameAndType [94] [95] 
.const [58] = Class [96] 
.const [59] = NameAndType [97] [98] 
.const [60] = Class [99] 
.const [61] = NameAndType [100] [101] 
.const [62] = Class [102] 
.const [63] = NameAndType [103] [104] 
.const [64] = Class [105] 
.const [65] = NameAndType [106] [107] 
.const [66] = Utf8 de/audi/app/messaging/core/util/Strings 
.const [67] = Utf8 isNullOrEmpty 
.const [68] = Utf8 (Ljava/lang/String;)Z 
.const [69] = Utf8 de/audi/app/messaging/core/accounts/PrimaryPhoneAccountFilter 
.const [70] = Utf8 primaryDevice 
.const [71] = Utf8 Lde/audi/atip/interapp/messaging/devicerole/DeviceRoleInfo; 
.const [72] = Utf8 de/audi/app/messaging/core/accounts/PrimaryPhoneAccountFilter 
.const [73] = Utf8 log 
.const [74] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [75] = Utf8 de/audi/atip/log/LogChannel 
.const [76] = Utf8 log 
.const [77] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [78] = Utf8 de/audi/atip/interapp/messaging/devicerole/DeviceRoleInfo 
.const [79] = Utf8 isSimDevice 
.const [80] = Utf8 ()Z 
.const [81] = Utf8 org/dsi/ifc/messaging/MessagingAccount 
.const [82] = Utf8 getSimCardId 
.const [83] = Utf8 ()Ljava/lang/String; 
.const [84] = Utf8 de/audi/atip/interapp/messaging/devicerole/DeviceRoleInfo 
.const [85] = Utf8 getSimCardId 
.const [86] = Utf8 ()Ljava/lang/String; 
.const [87] = Utf8 java/lang/String 
.const [88] = Utf8 equalsIgnoreCase 
.const [89] = Utf8 (Ljava/lang/String;)Z 
.const [90] = Utf8 org/dsi/ifc/messaging/MessagingAccount 
.const [91] = Utf8 getBtDeviceAddress 
.const [92] = Utf8 ()Ljava/lang/String; 
.const [93] = Utf8 de/audi/atip/interapp/messaging/devicerole/DeviceRoleInfo 
.const [94] = Utf8 getBtDeviceAddress 
.const [95] = Utf8 ()Ljava/lang/String; 
.const [96] = Utf8 de/audi/atip/log/LogChannel 
.const [97] = Utf8 log 
.const [98] = Utf8 (ILjava/lang/String;)Z 
.const [99] = Utf8 java/lang/Object 
.const [100] = Utf8 <init> 
.const [101] = Utf8 ()V 
.const [102] = Utf8 de/audi/app/messaging/core/accounts/PrimaryPhoneAccountFilter 
.const [103] = Utf8 primaryDevice 
.const [104] = Utf8 Lde/audi/atip/interapp/messaging/devicerole/DeviceRoleInfo; 
.const [105] = Utf8 de/audi/app/messaging/core/accounts/PrimaryPhoneAccountFilter 
.const [106] = Utf8 log 
.const [107] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [108] = Utf8 de/audi/app/messaging/core/accounts/PrimaryPhoneAccountFilter 
.const [109] = Class [108] 
.const [110] = Utf8 java/lang/Object 
.const [111] = Class [110] 
.const [112] = Utf8 de/audi/app/messaging/core/accounts/IAccountFilter 
.const [113] = Class [112] 
.const [114] = Utf8 primaryDevice 
.const [115] = Utf8 Lde/audi/atip/interapp/messaging/devicerole/DeviceRoleInfo; 
.const [116] = Utf8 log 
.const [117] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [118] = Utf8 Code 
.const [119] = Utf8 <init> 
.const [120] = Utf8 (Lde/audi/atip/interapp/messaging/devicerole/DeviceRoleInfo;Lde/audi/atip/log/LogChannel;)V 
.const [121] = Utf8 accept 
.const [122] = Utf8 (Lorg/dsi/ifc/messaging/MessagingAccount;)Z 
.const [123] = Utf8 getDescription 
.const [124] = Utf8 ()Ljava/lang/String; 
.end class 
