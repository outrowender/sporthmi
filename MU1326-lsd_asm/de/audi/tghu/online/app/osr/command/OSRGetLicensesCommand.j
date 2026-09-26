.version 50 0 
.class public super [96] 
.super [98] 
.field protected [99] [100] 

.method public [102] : [103] 
    .attribute [101] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [21] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [22] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [104] : [105] 
    .attribute [101] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [14] 
L4:     ldc [2] 
L6:     ldc [3] 
L8:     invokevirtual [15] 
L11:    pop 
L12:    aload_0 
L13:    invokevirtual [16] 
L16:    ifnull L33 
L19:    aload_0 
L20:    invokevirtual [16] 
L23:    iconst_1 
L24:    iconst_1 
L25:    invokeinterface [23] 0 
L30:    goto L54 
L33:    aload_0 
L34:    getfield [14] 
L37:    sipush 10000 
L40:    ldc [4] 
L42:    invokevirtual [15] 
L45:    pop 
L46:    aload_0 
L47:    iconst_4 
L48:    iconst_1 
L49:    iconst_1 
L50:    aconst_null 
L51:    invokevirtual [17] 
L54:    return 
L55:    nop 
L56:    
    .end code 
.end method 

.method public [106] : [107] 
    .attribute [101] .code stack 7 locals 0 
L0:     aload_0 
L1:     getfield [14] 
L4:     ldc [2] 
L6:     ldc [5] 
L8:     aload 4 
L10:    ifnonnull L17 
L13:    lconst_0 
L14:    goto L21 
L17:    aload 4 
L19:    arraylength 
L20:    i2l 
L21:    iload_1 
L22:    i2l 
L23:    invokevirtual [18] 
L26:    pop 
L27:    aload_0 
L28:    getfield [13] 
L31:    ifnull L44 
L34:    aload_0 
L35:    getfield [13] 
L38:    iload_1 
L39:    aload 4 
L41:    invokevirtual [19] 
L44:    aload_0 
L45:    invokevirtual [20] 
L48:    invokeinterface [24] 0 
L53:    return 
L54:    nop 
L55:    nop 
L56:    
    .end code 
.end method 

.method public enum [108] : [109] 
    .attribute [101] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [110] : [111] 
    .attribute [101] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [14] 
L4:     sipush 10000 
L7:     ldc [6] 
L9:     invokevirtual [15] 
L12:    pop 
L13:    aload_0 
L14:    iconst_4 
L15:    iconst_1 
L16:    iconst_1 
L17:    aconst_null 
L18:    invokevirtual [17] 
L21:    return 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int -2137614336 
.const [3] = String [25] 
.const [4] = String [26] 
.const [5] = String [27] 
.const [6] = String [28] 
.const [7] = Class [29] 
.const [8] = Class [30] 
.const [9] = Class [31] 
.const [10] = Class [32] 
.const [11] = Class [33] 
.const [12] = Class [34] 
.const [13] = Field [35] [36] 
.const [14] = Field [37] [38] 
.const [15] = Method [39] [40] 
.const [16] = Method [41] [42] 
.const [17] = Method [43] [44] 
.const [18] = Method [45] [46] 
.const [19] = Method [47] [48] 
.const [20] = Method [49] [50] 
.const [21] = Method [51] [52] 
.const [22] = Field [53] [54] 
.const [23] = InterfaceMethod [55] [56] 
.const [24] = InterfaceMethod [57] [58] 
.const [25] = Utf8 '[ORSGetLicensesCommand#execute] enter' 
.const [26] = Utf8 '[ORSGetLicensesCommand#execute] no DSI available' 
.const [27] = Utf8 '[ORSGetLicensesCommand#getLicensesResponse] got %1 licenses, with resultCode %2' 
.const [28] = Utf8 '[ORSGetLicensesCommand#abort] command aborted. Most probably a timeout occured!' 
.const [29] = Utf8 de/audi/tghu/online/app/osr/command/OSRGetLicensesCommand 
.const [30] = Utf8 de/audi/tghu/online/app/osr/command/AbstractOSRCommand 
.const [31] = Utf8 de/audi/atip/log/LogChannel 
.const [32] = Utf8 org/dsi/ifc/online/DSIOnlineServiceRegistration 
.const [33] = Utf8 de/audi/tghu/online/app/osr/license/LicenseCollectionService 
.const [34] = Utf8 de/audi/tghu/command/ICommandList 
.const [35] = Class [59] 
.const [36] = NameAndType [60] [61] 
.const [37] = Class [62] 
.const [38] = NameAndType [63] [64] 
.const [39] = Class [65] 
.const [40] = NameAndType [66] [67] 
.const [41] = Class [68] 
.const [42] = NameAndType [69] [70] 
.const [43] = Class [71] 
.const [44] = NameAndType [72] [73] 
.const [45] = Class [74] 
.const [46] = NameAndType [75] [76] 
.const [47] = Class [77] 
.const [48] = NameAndType [78] [79] 
.const [49] = Class [80] 
.const [50] = NameAndType [81] [82] 
.const [51] = Class [83] 
.const [52] = NameAndType [84] [85] 
.const [53] = Class [86] 
.const [54] = NameAndType [87] [88] 
.const [55] = Class [89] 
.const [56] = NameAndType [90] [91] 
.const [57] = Class [92] 
.const [58] = NameAndType [93] [94] 
.const [59] = Utf8 de/audi/tghu/online/app/osr/command/OSRGetLicensesCommand 
.const [60] = Utf8 licenseCollectionService 
.const [61] = Utf8 Lde/audi/tghu/online/app/osr/license/LicenseCollectionService; 
.const [62] = Utf8 de/audi/tghu/online/app/osr/command/OSRGetLicensesCommand 
.const [63] = Utf8 logger 
.const [64] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [65] = Utf8 de/audi/atip/log/LogChannel 
.const [66] = Utf8 log 
.const [67] = Utf8 (ILjava/lang/String;)Z 
.const [68] = Utf8 de/audi/tghu/online/app/osr/command/OSRGetLicensesCommand 
.const [69] = Utf8 getDSI 
.const [70] = Utf8 ()Lorg/dsi/ifc/online/DSIOnlineServiceRegistration; 
.const [71] = Utf8 de/audi/tghu/online/app/osr/command/OSRGetLicensesCommand 
.const [72] = Utf8 getLicensesResponse 
.const [73] = Utf8 (IZZ[Lorg/dsi/ifc/online/OSRLicense;)V 
.const [74] = Utf8 de/audi/atip/log/LogChannel 
.const [75] = Utf8 log 
.const [76] = Utf8 (ILjava/lang/String;JJ)Z 
.const [77] = Utf8 de/audi/tghu/online/app/osr/license/LicenseCollectionService 
.const [78] = Utf8 setLicenseList 
.const [79] = Utf8 (I[Lorg/dsi/ifc/online/OSRLicense;)V 
.const [80] = Utf8 de/audi/tghu/online/app/osr/command/OSRGetLicensesCommand 
.const [81] = Utf8 getCommandList 
.const [82] = Utf8 ()Lde/audi/tghu/command/ICommandList; 
.const [83] = Utf8 de/audi/tghu/online/app/osr/command/AbstractOSRCommand 
.const [84] = Utf8 <init> 
.const [85] = Utf8 ()V 
.const [86] = Utf8 de/audi/tghu/online/app/osr/command/OSRGetLicensesCommand 
.const [87] = Utf8 licenseCollectionService 
.const [88] = Utf8 Lde/audi/tghu/online/app/osr/license/LicenseCollectionService; 
.const [89] = Utf8 org/dsi/ifc/online/DSIOnlineServiceRegistration 
.const [90] = Utf8 getLicenses 
.const [91] = Utf8 (ZZ)V 
.const [92] = Utf8 de/audi/tghu/command/ICommandList 
.const [93] = Utf8 commandFinished 
.const [94] = Utf8 ()V 
.const [95] = Utf8 de/audi/tghu/online/app/osr/command/OSRGetLicensesCommand 
.const [96] = Class [95] 
.const [97] = Utf8 de/audi/tghu/online/app/osr/command/AbstractOSRCommand 
.const [98] = Class [97] 
.const [99] = Utf8 licenseCollectionService 
.const [100] = Utf8 Lde/audi/tghu/online/app/osr/license/LicenseCollectionService; 
.const [101] = Utf8 Code 
.const [102] = Utf8 <init> 
.const [103] = Utf8 (Lde/audi/tghu/online/app/osr/license/LicenseCollectionService;)V 
.const [104] = Utf8 execute 
.const [105] = Utf8 ()V 
.const [106] = Utf8 getLicensesResponse 
.const [107] = Utf8 (IZZ[Lorg/dsi/ifc/online/OSRLicense;)V 
.const [108] = Utf8 updateServiceList 
.const [109] = Utf8 ([Lorg/dsi/ifc/online/OSRServiceState;I)V 
.const [110] = Utf8 abort 
.const [111] = Utf8 ()V 
.end class 
