/*
 * Copyright 2005 KT ALL RIGHTS RESERVED
 *
 * Copyright 2005 Korea Telecom ALL RIGHTS RESERVED
 * ���ϸ�: BcNSystem.java
 * �ۼ�����/�ۼ��� : 2005.05.20 ������
 *
 * UC�� : BcNSystem ��ü.
 * ���� : BcNSystem�� Attribute�� ǥ���ϴ� ��ü�̴�.
 * Ư¡ : �����Ǵ� �ü����� �� EMS,Adaptor ��ü�� �� ��ü�� ����Ѵ�.
 *
 * ============================================================================
 * ���� ����
 * NO   ��������    ������  ��������
 * ============================================================================
 */ 

package string;

import java.sql.Timestamp;
/**
 * BcNSystem Attribute�� ǥ���ϴ� ��ü�̴�.
 * @author ������
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
	// public final static int NRS = 105; // �������� ���յǾ���.
	public final static int ROUTER             = 106;
	public final static int SWITCH             = 107;
	public final static int STAND_ALONE_SERVER = 108;
	public final static int ADAPTOR_SYSTEM     = 109;
	public final static int EMS                = 110;
	public static final int LE                 = 111; // ���ñ�ȯ��
	public static final int TOLL               = 112; // TGW TOLL

	/*
	 * 2007.04.04 �迵�� ���� �߰� ���� BcNObjectType�� ���� ���� ��
	 */
	public static final int ETC                = 113; // ��Ÿ
	public static final int OTHER              = 114; // Ÿ��
	public static final int SVC700             = 115; // 700
	public static final int INTER              = 116; // ����
	public static final int AI                 = 117; // ���ɸ�
	public static final int IGS                = 118; // IGS
	public static final int TANDEM100          = 119; // TANDEM100
	public static final int LINKAGE_SYSTEM     = 190; // Ÿ�ý���(Ÿ ���� �ý���)

	public static final int STP                = 130; // ��ȣ�߰豳ȯ��
	public static final int IDLC_MUX           = 140; // ��ȣ�߰豳ȯ��

	private String          equipmentID;              // ����ڰ� �ο��ϴ� �ý��� ID
	private Timestamp       collectionTime;           // �����ð�
	private String          officeID;                 // �����ڵ�
	private String          officeName;               // �����
	private String          headQuarterID;            // �����ڵ�
	private String          headQuarterName;          // ���θ�
	private String          NSCID;                    // NSC�ڵ�
	private String          NSCName;                  // NSC��
	private String          OMCID;                    // OMC�ڵ�
	private String          OMCName;                  // OMC��
	private String          meID;                     // ������� ID
	private String          emsID;                    // EMS ID
	private String          adaptorID;                // ����� ID
	private int             typeOfSystem;             // �ý��� ����
	private String          vendorName;               // �ý��� ������ü
	private String          serialNumber;             // �ý��۽ø����ȣ
	private int             managementMethodSupported; // �����������
	private String          managedIpAddress;         // ���� IP
	private String          thresholdID;              // �Ӱ�ġ ID
	private String          subnetID;                 // ����� ID
	private String          modelName;                // ��ġ����
	private String          installLocation;          // ��ġ��ġ
	private String          degree;                   // ����
	private String          softwareVersion;          // ����Ʈ�������
	private String          hardwareVersion;          // �ϵ�������
	private String 			snmpVersion;			  // SNMP����

	private int             AGWCount;                 // AGW ��
	private int             TOLLCount;                // TOLL ��
	private int             LECount;                  // LE ��
	private int             STPCount;                 // STP ��

	private String          mcIP;                     //MC_IP
	private String          operationOffice;          //���μ�
	
    private String 			spc;      // �ڱ���ȣ����ȣ
    private String 			spcAlias; // �ڱ���ȣ����

	private int             typeOfService;             // ���񽺽ý����� Ÿ��


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
	 * Sets the equipmentID attribute(����ڰ� �ο��ϴ� �ý��� ID).
	 * @param equipmentID String
	 */
	public void setEquipmentID(String equipmentID)
	{
		this.equipmentID=equipmentID;
	}

	/**
	 * Returns the equipmentID(����ڰ� �ο��ϴ� �ý��� ID).
	 * @return String
	 */
	public String getEquipmentID()
	{
		return this.equipmentID;
	}

	/**
	 * Sets the collectionTime attribute(�����ð�).
	 * @param collectionTime Timestamp
	 */
	public void setCollectionTime(Timestamp collectionTime)
	{
		this.collectionTime=collectionTime;
	}

	/**
	 * Returns the collectionTime(�����ð�).
	 * @return Timestamp
	 */
	public Timestamp getCollectionTime()
	{
		return this.collectionTime;
	}

	/**
	 * Sets the officeID attribute(�����ڵ�).
	 * @param officeID String
	 */
	public void setOfficeID(String officeID)
	{
		this.officeID=officeID;
	}

	/**
	 * Returns the officeID(�����ڵ�).
	 * @return String
	 */
	public String getOfficeID()
	{
		return this.officeID;
	}

	/**
	 * Sets the headQuarterID attribute(�����ڵ�).
	 * @param headQuarterID String
	 */
	public void setHeadQuarterID(String headQuarterID)
	{
		this.headQuarterID=headQuarterID;
	}

	/**
	 * Returns the headQuarterID(�����ڵ�).
	 * @return String
	 */
	public String getHeadQuarterID()
	{
		return this.headQuarterID;
	}

	/**
	 * Sets the meID attribute(������� ID).
	 * @param meID String
	 */
	public void setMeID(String meID)
	{
		this.meID=meID;
	}

	/**
	 * Returns the meID(������� ID).
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
	 * Sets the adaptorID attribute(����� ID).
	 * @param adaptorID String
	 */
	public void setAdaptorID(String adaptorID)
	{
		this.adaptorID=adaptorID;
	}

	/**
	 * Returns the adaptorID(����� ID).
	 * @return String
	 */
	public String getAdaptorID()
	{
		return this.adaptorID;
	}

	/**
	 * Sets the typeOfSystem attribute(�ý��� ����).
	 * @param typeOfSystem int
	 */
	public void setTypeOfSystem(int typeOfSystem)
	{
		this.typeOfSystem=typeOfSystem;
	}

	/**
	 * Returns the typeOfSystem(�ý��� ����).
	 * @return int
	 */
	public int getTypeOfSystem()
	{
		return this.typeOfSystem;
	}

	/**
	 * Sets the vendorName attribute(�ý��� ������ü).
	 * @param vendorName String
	 */
	public void setVendorName(String vendorName)
	{
		this.vendorName=vendorName;
	}

	/**
	 * Returns the vendorName(�ý��� ������ü).
	 * @return String
	 */
	public String getVendorName()
	{
		return this.vendorName;
	}

	/**
	 * Sets the serialNumber attribute(�ý��۽ø����ȣ).
	 * @param serialNumber String
	 */
	public void setSerialNumber(String serialNumber)
	{
		this.serialNumber=serialNumber;
	}

	/**
	 * Returns the serialNumber(�ý��۽ø����ȣ).
	 * @return String
	 */
	public String getSerialNumber()
	{
		return this.serialNumber;
	}

	/**
	 * Sets the managementMethodSupported attribute(�����������).
	 * @param managementMethodSupported int
	 */
	public void setManagementMethodSupported(int managementMethodSupported)
	{
		this.managementMethodSupported=managementMethodSupported;
	}

	/**
	 * Returns the managementMethodSupported(�����������).
	 * @return int
	 */
	public int getManagementMethodSupported()
	{
		return this.managementMethodSupported;
	}

	/**
	 * Sets the managedIpAddress attribute(���� IP).
	 * @param managedIpAddress String
	 */
	public void setManagedIpAddress(String managedIpAddress)
	{
		this.managedIpAddress=managedIpAddress;
	}

	/**
	 * Returns the managedIpAddress(���� IP).
	 * @return String
	 */
	public String getManagedIpAddress()
	{
		return this.managedIpAddress;
	}

	/**
	 * Sets the thresholdID attribute(�Ӱ�ġ ID).
	 * @param thresholdID String
	 */
	public void setThresholdID(String thresholdID)
	{
		this.thresholdID=thresholdID;
	}

	/**
	 * Returns the thresholdID(�Ӱ�ġ ID).
	 * @return String
	 */
	public String getThresholdID()
	{
		return this.thresholdID;
	}

	/**
	 * Sets the subnetID attribute(�Ӱ�ġ ID).
	 * @param subnetID String
	 */
	public void setSubnetID(String subnetID)
	{
		this.subnetID=subnetID;
	}

	/**
	 * Returns the subnetID(�Ӱ�ġ ID).
	 * @return String
	 */
	public String getSubnetID()
	{
		return this.subnetID;
	}

	/**
	 * Sets the modelName attribute(��ġ����).
	 * @param modelName String
	 */
	public void setModelName(String modelName)
	{
		this.modelName=modelName;
	}

	/**
	 * Returns the modelName(��ġ����).
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
	 * Sets the typeOfService attribute(���񽺽ý����� Ÿ��).
	 * @param typeOfService int
	 */
	public void setTypeOfService(int typeOfService)
	{
		this.typeOfService=typeOfService;
	}

	/**
	 * Returns the typeOfService(���񽺽ý����� Ÿ��).
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
