/*
 * Copyright 2005 KT ALL RIGHTS RESERVED
 *
 * Copyright 2005 Korea Telecom ALL RIGHTS RESERVED
 * 파일명: BcNSystem.java
 * 작성일자/작성자 : 2005.05.20 가주현
 *
 * UC명 : BcNSystem 객체.
 * 내용 : BcNSystem의 Attribute를 표현하는 객체이다.
 * 특징 : 관리되는 시설정보 및 EMS,Adaptor 객체는 이 객체를 상속한다.
 *
 * ============================================================================
 * 수정 내역
 * NO   수정일자    수정자  수정내역
 * ============================================================================
 */ 

package string;

import java.sql.Timestamp;
/**
 * BcNSystem Attribute를 표현하는 객체이다.
 * @author 가주현
 * @version 1.0
 * @see com.kt.bcn.bid.PhysicalDevice
 */
public class BcNSystem extends com.kt.bcn.bid.PhysicalDevice
{
	// TypeOfSystem
	public final static int UNKNOWN            = 0;
	public final static int SSW                = 101;
	public final static int AGW                = 102;
	public final static int TGW                = 103;
	public final static int SGW                = 104;
	// public final static int NRS = 105; // 서버류로 통합되었음.
	public final static int ROUTER             = 106;
	public final static int SWITCH             = 107;
	public final static int STAND_ALONE_SERVER = 108;
	public final static int ADAPTOR_SYSTEM     = 109;
	public final static int EMS                = 110;
	public static final int LE                 = 111; // 로컬교환기
	public static final int TOLL               = 112; // TGW TOLL

	/*
	 * 2007.04.04 김영진 추후 추가 예정 BcNObjectType도 같이 봐야 함
	 */
	public static final int ETC                = 113; // 기타
	public static final int OTHER              = 114; // 타사
	public static final int SVC700             = 115; // 700
	public static final int INTER              = 116; // 국제
	public static final int AI                 = 117; // 지능망
	public static final int IGS                = 118; // IGS
	public static final int TANDEM100          = 119; // TANDEM100
	public static final int LINKAGE_SYSTEM     = 190; // 타시스템(타 연동 시스템)

	public static final int STP                = 130; // 신호중계교환기
	public static final int IDLC_MUX           = 140; // 신호중계교환기

	private String          equipmentID;              // 운용자가 부여하는 시스템 ID
	private Timestamp       collectionTime;           // 수집시간
	private String          officeID;                 // 지사코드
	private String          officeName;               // 지사명
	private String          headQuarterID;            // 본부코드
	private String          headQuarterName;          // 본부명
	private String          NSCID;                    // NSC코드
	private String          NSCName;                  // NSC명
	private String          OMCID;                    // OMC코드
	private String          OMCName;                  // OMC명
	private String          meID;                     // 관리요소 ID
	private String          emsID;                    // EMS ID
	private String          adaptorID;                // 어댑터 ID
	private int             typeOfSystem;             // 시스템 종류
	private String          vendorName;               // 시스템 제조업체
	private String          serialNumber;             // 시스템시리얼번호
	private int             managementMethodSupported; // 관리지원방법
	private String          managedIpAddress;         // 관리 IP
	private String          thresholdID;              // 임계치 ID
	private String          subnetID;                 // 서브넷 ID
	private String          modelName;                // 장치기종
	private String          installLocation;          // 설치위치
	private String          degree;                   // 계위
	private String          softwareVersion;          // 소프트웨어버전
	private String          hardwareVersion;          // 하드웨어버전
	private String 			snmpVersion;			  // SNMP버전

	private int             AGWCount;                 // AGW 수
	private int             TOLLCount;                // TOLL 수
	private int             LECount;                  // LE 수
	private int             STPCount;                 // STP 수

	private String          mcIP;                     //MC_IP
	private String          operationOffice;          //운용부서
	
    private String 			spc;      // 자국신호점번호
    private String 			spcAlias; // 자국신호점명

	private int             typeOfService;             // 서비스시스템의 타입


	/**
	 * @return the hardwareVersion
	 */
	public String getHardwareVersion()
	{
		return hardwareVersion;
	}

	/**
	 * @param hardwareVersion the hardwareVersion to set
	 */
	public void setHardwareVersion(String hardwareVersion)
	{
		this.hardwareVersion = hardwareVersion;
	}
	
	/**
	 * @return the hardwareVersion
	 */
	public String getSpc()
	{
		return spc;
	}

	/**
	 * @param hardwareVersion the hardwareVersion to set
	 */
	public void setSpc(String spc)
	{
		this.spc = spc;
	}
	
	/**
	 * @return the hardwareVersion
	 */
	public String getSpcAlias()
	{
		return spcAlias;
	}

	/**
	 * @param hardwareVersion the hardwareVersion to set
	 */
	public void setSpcAlias(String spcAlias)
	{
		this.spcAlias = spcAlias;
	}

	/**
	 * @return the softwareVersion
	 */
	public String getSoftwareVersion()
	{
		return softwareVersion;
	}

	/**
	 * @param softwareVersion the softwareVersion to set
	 */
	public void setSoftwareVersion(String softwareVersion)
	{
		this.softwareVersion = softwareVersion;
	}

	/**
	 * @return the aGWCount
	 */
	public int getAGWCount()
	{
		return AGWCount;
	}

	/**
	 * @param count the aGWCount to set
	 */
	public void setAGWCount(int count)
	{
		AGWCount = count;
	}

	/**
	 * @return the lECount
	 */
	public int getLECount()
	{
		return LECount;
	}

	/**
	 * @param count the lECount to set
	 */
	public void setLECount(int count)
	{
		LECount = count;
	}

	/**
	 * @return the sTPCount
	 */
	public int getSTPCount()
	{
		return STPCount;
	}

	/**
	 * @param count the sTPCount to set
	 */
	public void setSTPCount(int count)
	{
		STPCount = count;
	}

	/**
	 * @return the tOLLCount
	 */
	public int getTOLLCount()
	{
		return TOLLCount;
	}

	/**
	 * @param count the tOLLCount to set
	 */
	public void setTOLLCount(int count)
	{
		TOLLCount = count;
	}

	/**
	 * @return the headQuarterName
	 */
	public String getHeadQuarterName() {
		return headQuarterName;
	}

	/**
	 * @param headQuarterName the headQuarterName to set
	 */
	public void setHeadQuarterName(String headQuarterName) {
		this.headQuarterName = headQuarterName;
	}

	/**
	 * @return the nSCID
	 */
	public String getNSCID() {
		return NSCID;
	}

	/**
	 * @param nscid the nSCID to set
	 */
	public void setNSCID(String nscid) {
		NSCID = nscid;
	}

	/**
	 * @return the nSCName
	 */
	public String getNSCName() {
		return NSCName;
	}

	/**
	 * @param name the nSCName to set
	 */
	public void setNSCName(String name) {
		NSCName = name;
	}

	/**
	 * @return the officeName
	 */
	public String getOfficeName() {
		return officeName;
	}

	/**
	 * @param officeName the officeName to set
	 */
	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	/**
	 * @return the oMCID
	 */
	public String getOMCID() {
		return OMCID;
	}

	/**
	 * @param omcid the oMCID to set
	 */
	public void setOMCID(String omcid) {
		OMCID = omcid;
	}

	/**
	 * @return the oMCName
	 */
	public String getOMCName() {
		return OMCName;
	}

	/**
	 * @param name the oMCName to set
	 */
	public void setOMCName(String name) {
		OMCName = name;
	}

	/**
	 * Sets the equipmentID attribute(운용자가 부여하는 시스템 ID).
	 * @param equipmentID String
	 */
	public void setEquipmentID(String equipmentID)
	{
		this.equipmentID=equipmentID;
	}

	/**
	 * Returns the equipmentID(운용자가 부여하는 시스템 ID).
	 * @return String
	 */
	public String getEquipmentID()
	{
		return this.equipmentID;
	}

	/**
	 * Sets the collectionTime attribute(수집시간).
	 * @param collectionTime Timestamp
	 */
	public void setCollectionTime(Timestamp collectionTime)
	{
		this.collectionTime=collectionTime;
	}

	/**
	 * Returns the collectionTime(수집시간).
	 * @return Timestamp
	 */
	public Timestamp getCollectionTime()
	{
		return this.collectionTime;
	}

	/**
	 * Sets the officeID attribute(지사코드).
	 * @param officeID String
	 */
	public void setOfficeID(String officeID)
	{
		this.officeID=officeID;
	}

	/**
	 * Returns the officeID(지사코드).
	 * @return String
	 */
	public String getOfficeID()
	{
		return this.officeID;
	}

	/**
	 * Sets the headQuarterID attribute(본부코드).
	 * @param headQuarterID String
	 */
	public void setHeadQuarterID(String headQuarterID)
	{
		this.headQuarterID=headQuarterID;
	}

	/**
	 * Returns the headQuarterID(본부코드).
	 * @return String
	 */
	public String getHeadQuarterID()
	{
		return this.headQuarterID;
	}

	/**
	 * Sets the meID attribute(관리요소 ID).
	 * @param meID String
	 */
	public void setMeID(String meID)
	{
		this.meID=meID;
	}

	/**
	 * Returns the meID(관리요소 ID).
	 * @return String
	 */
	public String getMeID()
	{
		return this.meID;
	}

	/**
	 * Sets the emsID attribute(EMS ID).
	 * @param emsID String
	 */
	public void setEmsID(String emsID)
	{
		this.emsID=emsID;
	}

	/**
	 * Returns the emsID(EMS ID).
	 * @return String
	 */
	public String getEmsID()
	{
		return this.emsID;
	}

	/**
	 * Sets the adaptorID attribute(어댑터 ID).
	 * @param adaptorID String
	 */
	public void setAdaptorID(String adaptorID)
	{
		this.adaptorID=adaptorID;
	}

	/**
	 * Returns the adaptorID(어댑터 ID).
	 * @return String
	 */
	public String getAdaptorID()
	{
		return this.adaptorID;
	}

	/**
	 * Sets the typeOfSystem attribute(시스템 종류).
	 * @param typeOfSystem int
	 */
	public void setTypeOfSystem(int typeOfSystem)
	{
		this.typeOfSystem=typeOfSystem;
	}

	/**
	 * Returns the typeOfSystem(시스템 종류).
	 * @return int
	 */
	public int getTypeOfSystem()
	{
		return this.typeOfSystem;
	}

	/**
	 * Sets the vendorName attribute(시스템 제조업체).
	 * @param vendorName String
	 */
	public void setVendorName(String vendorName)
	{
		this.vendorName=vendorName;
	}

	/**
	 * Returns the vendorName(시스템 제조업체).
	 * @return String
	 */
	public String getVendorName()
	{
		return this.vendorName;
	}

	/**
	 * Sets the serialNumber attribute(시스템시리얼번호).
	 * @param serialNumber String
	 */
	public void setSerialNumber(String serialNumber)
	{
		this.serialNumber=serialNumber;
	}

	/**
	 * Returns the serialNumber(시스템시리얼번호).
	 * @return String
	 */
	public String getSerialNumber()
	{
		return this.serialNumber;
	}

	/**
	 * Sets the managementMethodSupported attribute(관리지원방법).
	 * @param managementMethodSupported int
	 */
	public void setManagementMethodSupported(int managementMethodSupported)
	{
		this.managementMethodSupported=managementMethodSupported;
	}

	/**
	 * Returns the managementMethodSupported(관리지원방법).
	 * @return int
	 */
	public int getManagementMethodSupported()
	{
		return this.managementMethodSupported;
	}

	/**
	 * Sets the managedIpAddress attribute(관리 IP).
	 * @param managedIpAddress String
	 */
	public void setManagedIpAddress(String managedIpAddress)
	{
		this.managedIpAddress=managedIpAddress;
	}

	/**
	 * Returns the managedIpAddress(관리 IP).
	 * @return String
	 */
	public String getManagedIpAddress()
	{
		return this.managedIpAddress;
	}

	/**
	 * Sets the thresholdID attribute(임계치 ID).
	 * @param thresholdID String
	 */
	public void setThresholdID(String thresholdID)
	{
		this.thresholdID=thresholdID;
	}

	/**
	 * Returns the thresholdID(임계치 ID).
	 * @return String
	 */
	public String getThresholdID()
	{
		return this.thresholdID;
	}

	/**
	 * Sets the subnetID attribute(임계치 ID).
	 * @param subnetID String
	 */
	public void setSubnetID(String subnetID)
	{
		this.subnetID=subnetID;
	}

	/**
	 * Returns the subnetID(임계치 ID).
	 * @return String
	 */
	public String getSubnetID()
	{
		return this.subnetID;
	}

	/**
	 * Sets the modelName attribute(장치기종).
	 * @param modelName String
	 */
	public void setModelName(String modelName)
	{
		this.modelName=modelName;
	}

	/**
	 * Returns the modelName(장치기종).
	 * @return String
	 */
	public String getModelName()
	{
		return this.modelName;
	}

	public void setInstallLocation(String installLocation)
	{
		this.installLocation=installLocation;
	}

	public String getInstallLocation()
	{
		return this.installLocation;
	}

	public void setDegree(String degree)
	{
		this.degree=degree;
	}

	public String getDegree()
	{
		return this.degree;
	}

	public void setMcIP(String mcIP)
	{
		this.mcIP=mcIP;
	}

	public String getMcIP()
	{
		return this.mcIP;
	}

	/**
	 * Returns the String Value of this Object.
	 * @return String
	 */
	public String toString()
	{
		StringBuffer buf = new StringBuffer();
		buf.append("EquipmentID       : ").append(equipmentID).append("\n");
		buf.append("UserDefinedName   : ").append(getUserDefinedName()+"\n");		 
		buf.append("CollectionTime    : ").append(collectionTime).append("\n"); 
		buf.append("OfficeID          : ").append(officeID).append("\n"); 
		buf.append("HeadQuarterID     : ").append(headQuarterID).append("\n"); 
		buf.append("EmsID             : ").append(emsID).append("\n"); 
		buf.append("AdaptorID         : ").append(adaptorID).append("\n"); 
		buf.append("TypeOfSystem      : ").append(typeOfSystem).append("\n"); 
		buf.append("VendorName        : ").append(vendorName).append("\n"); 
		buf.append("SerialNumber      : ").append(serialNumber).append("\n"); 
		buf.append("ManagedIpAddress  : ").append(managedIpAddress).append("\n"); 
		buf.append("SubnetID          : ").append(subnetID+"\n");
		buf.append("ModelName         : ").append(modelName+"\n");
		buf.append("InstallLocation   : ").append(installLocation+"\n");
		buf.append("Degree            : ").append(degree+"\n");
		buf.append("ThresholdID       : ").append(thresholdID);
		return buf.toString();
	}

	public String getInfo()
	{
		StringBuffer buf = new StringBuffer();

		buf.append("equipmentID=").append(this.getEquipmentID() ).append("&&");
		buf.append("userDefinedName=").append(this.getUserDefinedName()+"&&");
		buf.append("collectionTime=").append(this.getCollectionTime() ).append("&&");
		buf.append("officeID=").append(this.getOfficeID() ).append("&&");
		buf.append("headQuarterID=").append(this.getHeadQuarterID() ).append("&&");
		buf.append("emsID=").append(this.getEmsID() ).append("&&");
		buf.append("adaptorID=").append(this.getAdaptorID() ).append("&&");
		buf.append("typeOfSystem=").append(this.getTypeOfSystem() ).append("&&");
		buf.append("vendorName=").append(this.getVendorName() ).append("&&");
		buf.append("serialNumber=").append(this.getSerialNumber() ).append("&&");
		buf.append("managedIpAddress=").append(this.getManagedIpAddress() ).append("&&");
		buf.append("subnet="+this.getSubnetID()+"&&");
		buf.append("modelName="+this.getModelName()+"&&");
		buf.append("installLocation="+this.getInstallLocation()+"&&");
		buf.append("degree="+this.getDegree()+"&&");
		buf.append("thresholdID=").append(this.getThresholdID());
		return buf.toString();
	}

	/**
	 * @return the operationOffice
	 */
	public String getOperationOffice()
	{
		return operationOffice;
	}

	/**
	 * @param operationOffice the operationOffice to set
	 */
	public void setOperationOffice(String operationOffice)
	{
		this.operationOffice = operationOffice;
	}

	/**
	 * Sets the typeOfService attribute(서비스시스템의 타입).
	 * @param typeOfService int
	 */
	public void setTypeOfService(int typeOfService)
	{
		this.typeOfService=typeOfService;
	}

	/**
	 * Returns the typeOfService(서비스시스템의 타입).
	 * @return int
	 */
	public int getTypeOfService()
	{
		return this.typeOfService;
	}

	public String getSnmpVersion() {
		return this.snmpVersion;
	}

	public void setSnmpVersion(String snmpVersion) {
		this.snmpVersion = snmpVersion;
	}


}
