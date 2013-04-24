package tokenizer;
/*
 * Copyright 2006 KT ALL RIGHTS RESERVED
 *
 * Copyright 2006 Korea Telecom ALL RIGHTS RESERVED
 * ���ϸ�: InterfaceTrafficHour.java
 * �ۼ�����/�ۼ��� : 2006.09.12 ������
 *
 * UC�� : Premium-NMS ����.
 * ���� : InterfaceTrafficHour Attribute�� ǥ���ϴ� ��ü�̴�.
 * Ư¡ : 
 *
 * ============================================================================
 * ���� ����
 * NO   ��������    ������  ��������
 * ============================================================================
*/
import java.sql.Timestamp;

/**
 * InterfaceTrafficHour�� Attribute�� ǥ���ϴ� ��ü�̴�.
 * @author ������
 * @version 1.0
 */
public class InterfaceTrafficHour implements java.io.Serializable
{
    private Timestamp collectionTime; //���� �ð�
    private String locationCode; //��ġ�ĺ��ڵ�
    private String masterIp; //��� IP
    private String equipAlias; //���Ī
    private String ifName; //�������̽���
    private String ifIp; //�������̽� IP
    private String ifUsgCode; //��Ʈ �뵵 �ڵ�
    private float inOctetsAvg; //�������̽����� ���ŵ� Octet�� ��. ��հ�
    private float inOctetsMax; //�������̽����� ���ŵ� Octet�� ��. �ִ밪
    private float inOctetsSum; //�������̽����� ���ŵ� Octet�� ��. ������
    private float inDiscardsAvg; //��Ŷ�� ������ ������ ���� �� �������ݷ� ���� ��Ŷ�� ��. ��հ�
    private float inDiscardsMax; //��Ŷ�� ������ ������ ���� �� �������ݷ� ���� ��Ŷ�� ��. �ִ밪
    private float inDiscardsSum; //��Ŷ�� ������ ������ ���� �� �������ݷ� ���� ��Ŷ�� ��. ������
    private float inErrorsAvg; //��Ŷ�� ������ �־� ���� �� �������ݷ� ���޵��� ���� ��Ŷ ��. ��հ�
    private float inErrorsMax; //��Ŷ�� ������ �־� ���� �� �������ݷ� ���޵��� ���� ��Ŷ ��. �ִ밪
    private float inErrorsSum; //��Ŷ�� ������ �־� ���� �� �������ݷ� ���޵��� ���� ��Ŷ ��. ������
    private float inUcastPktsAvg; //���������� ���޵� ����ĳ��Ʈ ��Ŷ�� ��. ��հ�
    private float inUcastPktsMax; //���������� ���޵� ����ĳ��Ʈ ��Ŷ�� ��. �ִ밪
    private float inUcastPktsSum; //���������� ���޵� ����ĳ��Ʈ ��Ŷ�� ��. ������
    private float inNucastPktsAvg; //���������� ���޵� ����ĳ��Ʈ�� �ƴ� ��Ŷ�� ��. ��հ�
    private float inNucastPktsMax; //���������� ���޵� ����ĳ��Ʈ�� �ƴ� ��Ŷ�� ��. �ִ밪
    private float inNucastPktsSum; //���������� ���޵� ����ĳ��Ʈ�� �ƴ� ��Ŷ�� ��. ������
    private float inMulticastPktsAvg; //���������� ���޵� ��Ƽĳ��Ʈ ��Ŷ��  ��. ��հ�
    private float inMulticastPktsMax; //���������� ���޵� ��Ƽĳ��Ʈ ��Ŷ��  ��. �ִ밪
    private float inMulticastPktssum; //���������� ���޵� ��Ƽĳ��Ʈ ��Ŷ��  ��. ������
    private float inBroadcastPktsAvg; //���������� ���޵� ��ε�ĳ��Ʈ ��Ŷ�� ��. ��հ�
    private float inBroadcastPktsMax; //���������� ���޵� ��ε�ĳ��Ʈ ��Ŷ�� ��. �ִ밪
    private float inBroadcastPktsSum; //���������� ���޵� ��ε�ĳ��Ʈ ��Ŷ�� ��. ������
    private float inIfUsageRateAvg; //���ŵ� ��Ŷ �������̽� �̿���. ��հ�
    private float inIfUsageRateMax; //���ŵ� ��Ŷ �������̽� �̿���. �ִ밪
    private float inBpsAvg; //���ŵ� ��� BPS(Bit Per Second) . ��հ�
    private float inBpsMax; //���ŵ� ��� BPS(Bit Per Second) . �ִ밪
    private float inPpsAvg; //���ŵ� ���PPS(Packet Per Second) . ��հ�
    private float inPpsMax; //���ŵ� ���PPS(Packet Per Second)
    private float inVariationRateAvg; //���ŵ� ��Ŷ�� ���� �ֱⰪ�� ���� ��� �����߻���. ��հ�
    private float inVariationRateMax; //���ŵ� ��Ŷ�� ���� �ֱⰪ�� ���� ��� �����߻���. �ִ밪
    private float outOctetsAvg; //�������̽����� �۽ŵ� Octet�� ��. ��հ�
    private float outOctetsMax; //�������̽����� �۽ŵ� Octet�� ��. �ִ밪
    private float outOctetsSum; //�������̽����� �۽ŵ� Octet�� ��. ������
    private float outDiscardsAvg; //��Ŷ�� ������ ������ ���۰� Ǯ�� ���� ���� ������ ���� ���� ���� ��Ŷ ��. ��հ�
    private float outDiscardsMax; //��Ŷ�� ������ ������ ���۰� Ǯ�� ���� ���� ������ ���� ���� ���� ��Ŷ ��. �ִ밪
    private float outDiscardsSum; //��Ŷ�� ������ ������ ���۰� Ǯ�� ���� ���� ������ ���� ���� ���� ��Ŷ ��. ������
    private float outErrorsAvg; //��Ŷ�� ������ �־� ���۵��� ����  ��Ŷ ��. ��հ�
    private float outErrorsMax; //��Ŷ�� ������ �־� ���۵��� ����  ��Ŷ ��. �ִ밪
    private float outErrorsSum; //��Ŷ�� ������ �־� ���۵��� ����  ��Ŷ ��. ������
    private float outUcastPktsAvg; //���� ���� ���������� �䱸�� ������  ����ĳ��Ʈ ��Ŷ�� �� (�������ų� ������������ ��Ŷ ����) . ��հ�
    private float outUcastPktsMax; //���� ���� ���������� �䱸�� ������  ����ĳ��Ʈ ��Ŷ�� �� (�������ų� ������������ ��Ŷ ����) . �ִ밪
    private float outUcastPktsSum; //���� ���� ���������� �䱸�� ������  ����ĳ��Ʈ ��Ŷ�� �� (�������ų� ������������ ��Ŷ ����) . ������
    private float outNucastPktsAvg; //���� ���� ���������� �䱸�� ������ ����ĳ��Ʈ�� �ƴ�  ��Ŷ�� ��  (�������ų� ������������ ��Ŷ ����) . ��հ�
    private float outNucastPktsMax; //���� ���� ���������� �䱸�� ������ ����ĳ��Ʈ�� �ƴ�  ��Ŷ�� ��  (�������ų� ������������ ��Ŷ ����) . �ִ밪
    private float outNucastPktsSum; //���� ���� ���������� �䱸�� ������ ����ĳ��Ʈ�� �ƴ�  ��Ŷ�� ��  (�������ų� ������������ ��Ŷ ����) . ������
    private float outMulticastPktsAvg; //���� ���� ���������� �䱸�� ������ ��Ƽĳ��Ʈ ��Ŷ�� �� (�������ų� ������������ ��Ŷ ����) . ��հ�
    private float outMulticastPktsMax; //���� ���� ���������� �䱸�� ������ ��Ƽĳ��Ʈ ��Ŷ�� �� (�������ų� ������������ ��Ŷ ����) . �ִ밪
    private float outMulticastPktsSum; //���� ���� ���������� �䱸�� ������ ��Ƽĳ��Ʈ ��Ŷ�� �� (�������ų� ������������ ��Ŷ ����) . ������
    private float outBroadcastPktsAvg; //���� ���� ���������� �䱸�� ������  ��ε�ĳ��Ʈ ��Ŷ��  �� (�������ų� ������������ ��Ŷ ����) . ��հ�
    private float outBroadcastPktsMax; //���� ���� ���������� �䱸�� ������  ��ε�ĳ��Ʈ ��Ŷ��  �� (�������ų� ������������ ��Ŷ ����) . �ִ밪
    private float outBroadcastPktsSum; //���� ���� ���������� �䱸�� ������  ��ε�ĳ��Ʈ ��Ŷ��  �� (�������ų� ������������ ��Ŷ ����) . ������
    private float outIfUsageRateAvg; //�۽ŵ� ��Ŷ �������̽�  �̿���. ��հ�(5�д���)
    private float outIfUsageRateMax; //�۽ŵ� ��Ŷ �������̽�  �̿���. �ִ밪
    private float outBpsAvg; //�۽ŵ� ��� BPS(Bit Per Second) . ��հ�
    private float outBpsMax; //�۽ŵ� ��� BPS(Bit Per Second) . �ִ밪
    private float outPpsAvg; //�۽ŵ� ��� PPS(Packet Per Second) . ��հ�
    private float outPpsMax; //�۽ŵ� ��� PPS(Packet Per Second) . �ִ밪
    private float outVariationRateAvg; //�۽ŵ� ��Ŷ�� ���� �ֱⰪ�� ���� ��� �����߻���. ��հ�
    private float outVariationRateMax; //�۽ŵ� ��Ŷ�� ���� �ֱⰪ�� ���� ��� �����߻���. �ִ밪

    /**
    * Sets the collectionTime attribute.
    * @param collectionTime Timestamp ���� �ð� 
    */
    public void setCollectionTime(Timestamp collectionTime)
    {
        this.collectionTime = collectionTime;
    }

    /**
    * Returns the collectionTime.
    * @return Timestamp ���� �ð�
    */
    public Timestamp getCollectionTime()
    {
        return this.collectionTime;
    }

    /**
    * Sets the locationCode attribute.
    * @param locationCode String ��ġ�ĺ��ڵ� 
    */
    public void setLocationCode(String locationCode)
    {
        this.locationCode = locationCode;
    }

    /**
    * Returns the locationCode.
    * @return String ��ġ�ĺ��ڵ�
    */
    public String getLocationCode()
    {
        return this.locationCode;
    }

    /**
    * Sets the masterIp attribute.
    * @param masterIp String ��� IP 
    */
    public void setMasterIp(String masterIp)
    {
        this.masterIp = masterIp;
    }

    /**
    * Returns the masterIp.
    * @return String ��� IP
    */
    public String getMasterIp()
    {
        return this.masterIp;
    }

    /**
    * Sets the equipAlias attribute.
    * @param equipAlias String ���Ī 
    */
    public void setEquipAlias(String equipAlias)
    {
        this.equipAlias = equipAlias;
    }

    /**
    * Returns the equipAlias.
    * @return String ���Ī
    */
    public String getEquipAlias()
    {
        return this.equipAlias;
    }

    /**
    * Sets the ifName attribute.
    * @param ifName String �������̽��� 
    */
    public void setIfName(String ifName)
    {
        this.ifName = ifName;
    }

    /**
    * Returns the ifName.
    * @return String �������̽���
    */
    public String getIfName()
    {
        return this.ifName;
    }

    /**
    * Sets the ifIp attribute.
    * @param ifIp String �������̽� IP 
    */
    public void setIfIp(String ifIp)
    {
        this.ifIp = ifIp;
    }

    /**
    * Returns the ifIp.
    * @return String �������̽� IP
    */
    public String getIfIp()
    {
        return this.ifIp;
    }

    /**
    * Sets the ifUsgCode attribute.
    * @param ifUsgCode String ��Ʈ �뵵 �ڵ� 
    */
    public void setIfUsgCode(String ifUsgCode)
    {
        this.ifUsgCode = ifUsgCode;
    }

    /**
    * Returns the ifUsgCode.
    * @return String ��Ʈ �뵵 �ڵ�
    */
    public String getIfUsgCode()
    {
        return this.ifUsgCode;
    }

    /**
    * Sets the inOctetsAvg attribute.
    * @param inOctetsAvg float �������̽����� ���ŵ� Octet�� ��. ��հ� 
    */
    public void setInOctetsAvg(float inOctetsAvg)
    {
        this.inOctetsAvg = inOctetsAvg;
    }

    /**
    * Returns the inOctetsAvg.
    * @return float �������̽����� ���ŵ� Octet�� ��. ��հ�
    */
    public float getInOctetsAvg()
    {
        return this.inOctetsAvg;
    }

    /**
    * Sets the inOctetsMax attribute.
    * @param inOctetsMax float �������̽����� ���ŵ� Octet�� ��. �ִ밪 
    */
    public void setInOctetsMax(float inOctetsMax)
    {
        this.inOctetsMax = inOctetsMax;
    }

    /**
    * Returns the inOctetsMax.
    * @return float �������̽����� ���ŵ� Octet�� ��. �ִ밪
    */
    public float getInOctetsMax()
    {
        return this.inOctetsMax;
    }

    /**
    * Sets the inOctetsSum attribute.
    * @param inOctetsSum float �������̽����� ���ŵ� Octet�� ��. ������ 
    */
    public void setInOctetsSum(float inOctetsSum)
    {
        this.inOctetsSum = inOctetsSum;
    }

    /**
    * Returns the inOctetsSum.
    * @return float �������̽����� ���ŵ� Octet�� ��. ������
    */
    public float getInOctetsSum()
    {
        return this.inOctetsSum;
    }

    /**
    * Sets the inDiscardsAvg attribute.
    * @param inDiscardsAvg float ��Ŷ�� ������ ������ ���� �� �������ݷ� ���� ��Ŷ�� ��. ��հ� 
    */
    public void setInDiscardsAvg(float inDiscardsAvg)
    {
        this.inDiscardsAvg = inDiscardsAvg;
    }

    /**
    * Returns the inDiscardsAvg.
    * @return float ��Ŷ�� ������ ������ ���� �� �������ݷ� ���� ��Ŷ�� ��. ��հ�
    */
    public float getInDiscardsAvg()
    {
        return this.inDiscardsAvg;
    }

    /**
    * Sets the inDiscardsMax attribute.
    * @param inDiscardsMax float ��Ŷ�� ������ ������ ���� �� �������ݷ� ���� ��Ŷ�� ��. �ִ밪 
    */
    public void setInDiscardsMax(float inDiscardsMax)
    {
        this.inDiscardsMax = inDiscardsMax;
    }

    /**
    * Returns the inDiscardsMax.
    * @return float ��Ŷ�� ������ ������ ���� �� �������ݷ� ���� ��Ŷ�� ��. �ִ밪
    */
    public float getInDiscardsMax()
    {
        return this.inDiscardsMax;
    }

    /**
    * Sets the inDiscardsSum attribute.
    * @param inDiscardsSum float ��Ŷ�� ������ ������ ���� �� �������ݷ� ���� ��Ŷ�� ��. ������ 
    */
    public void setInDiscardsSum(float inDiscardsSum)
    {
        this.inDiscardsSum = inDiscardsSum;
    }

    /**
    * Returns the inDiscardsSum.
    * @return float ��Ŷ�� ������ ������ ���� �� �������ݷ� ���� ��Ŷ�� ��. ������
    */
    public float getInDiscardsSum()
    {
        return this.inDiscardsSum;
    }

    /**
    * Sets the inErrorsAvg attribute.
    * @param inErrorsAvg float ��Ŷ�� ������ �־� ���� �� �������ݷ� ���޵��� ���� ��Ŷ ��. ��հ� 
    */
    public void setInErrorsAvg(float inErrorsAvg)
    {
        this.inErrorsAvg = inErrorsAvg;
    }

    /**
    * Returns the inErrorsAvg.
    * @return float ��Ŷ�� ������ �־� ���� �� �������ݷ� ���޵��� ���� ��Ŷ ��. ��հ�
    */
    public float getInErrorsAvg()
    {
        return this.inErrorsAvg;
    }

    /**
    * Sets the inErrorsMax attribute.
    * @param inErrorsMax float ��Ŷ�� ������ �־� ���� �� �������ݷ� ���޵��� ���� ��Ŷ ��. �ִ밪 
    */
    public void setInErrorsMax(float inErrorsMax)
    {
        this.inErrorsMax = inErrorsMax;
    }

    /**
    * Returns the inErrorsMax.
    * @return float ��Ŷ�� ������ �־� ���� �� �������ݷ� ���޵��� ���� ��Ŷ ��. �ִ밪
    */
    public float getInErrorsMax()
    {
        return this.inErrorsMax;
    }

    /**
    * Sets the inErrorsSum attribute.
    * @param inErrorsSum float ��Ŷ�� ������ �־� ���� �� �������ݷ� ���޵��� ���� ��Ŷ ��. ������ 
    */
    public void setInErrorsSum(float inErrorsSum)
    {
        this.inErrorsSum = inErrorsSum;
    }

    /**
    * Returns the inErrorsSum.
    * @return float ��Ŷ�� ������ �־� ���� �� �������ݷ� ���޵��� ���� ��Ŷ ��. ������
    */
    public float getInErrorsSum()
    {
        return this.inErrorsSum;
    }

    /**
    * Sets the inUcastPktsAvg attribute.
    * @param inUcastPktsAvg float ���������� ���޵� ����ĳ��Ʈ ��Ŷ�� ��. ��հ� 
    */
    public void setInUcastPktsAvg(float inUcastPktsAvg)
    {
        this.inUcastPktsAvg = inUcastPktsAvg;
    }

    /**
    * Returns the inUcastPktsAvg.
    * @return float ���������� ���޵� ����ĳ��Ʈ ��Ŷ�� ��. ��հ�
    */
    public float getInUcastPktsAvg()
    {
        return this.inUcastPktsAvg;
    }

    /**
    * Sets the inUcastPktsMax attribute.
    * @param inUcastPktsMax float ���������� ���޵� ����ĳ��Ʈ ��Ŷ�� ��. �ִ밪 
    */
    public void setInUcastPktsMax(float inUcastPktsMax)
    {
        this.inUcastPktsMax = inUcastPktsMax;
    }

    /**
    * Returns the inUcastPktsMax.
    * @return float ���������� ���޵� ����ĳ��Ʈ ��Ŷ�� ��. �ִ밪
    */
    public float getInUcastPktsMax()
    {
        return this.inUcastPktsMax;
    }

    /**
    * Sets the inUcastPktsSum attribute.
    * @param inUcastPktsSum float ���������� ���޵� ����ĳ��Ʈ ��Ŷ�� ��. ������ 
    */
    public void setInUcastPktsSum(float inUcastPktsSum)
    {
        this.inUcastPktsSum = inUcastPktsSum;
    }

    /**
    * Returns the inUcastPktsSum.
    * @return float ���������� ���޵� ����ĳ��Ʈ ��Ŷ�� ��. ������
    */
    public float getInUcastPktsSum()
    {
        return this.inUcastPktsSum;
    }

    /**
    * Sets the inNucastPktsAvg attribute.
    * @param inNucastPktsAvg float ���������� ���޵� ����ĳ��Ʈ�� �ƴ� ��Ŷ�� ��. ��հ� 
    */
    public void setInNucastPktsAvg(float inNucastPktsAvg)
    {
        this.inNucastPktsAvg = inNucastPktsAvg;
    }

    /**
    * Returns the inNucastPktsAvg.
    * @return float ���������� ���޵� ����ĳ��Ʈ�� �ƴ� ��Ŷ�� ��. ��հ�
    */
    public float getInNucastPktsAvg()
    {
        return this.inNucastPktsAvg;
    }

    /**
    * Sets the inNucastPktsMax attribute.
    * @param inNucastPktsMax float ���������� ���޵� ����ĳ��Ʈ�� �ƴ� ��Ŷ�� ��. �ִ밪 
    */
    public void setInNucastPktsMax(float inNucastPktsMax)
    {
        this.inNucastPktsMax = inNucastPktsMax;
    }

    /**
    * Returns the inNucastPktsMax.
    * @return float ���������� ���޵� ����ĳ��Ʈ�� �ƴ� ��Ŷ�� ��. �ִ밪
    */
    public float getInNucastPktsMax()
    {
        return this.inNucastPktsMax;
    }

    /**
    * Sets the inNucastPktsSum attribute.
    * @param inNucastPktsSum float ���������� ���޵� ����ĳ��Ʈ�� �ƴ� ��Ŷ�� ��. ������ 
    */
    public void setInNucastPktsSum(float inNucastPktsSum)
    {
        this.inNucastPktsSum = inNucastPktsSum;
    }

    /**
    * Returns the inNucastPktsSum.
    * @return float ���������� ���޵� ����ĳ��Ʈ�� �ƴ� ��Ŷ�� ��. ������
    */
    public float getInNucastPktsSum()
    {
        return this.inNucastPktsSum;
    }

    /**
    * Sets the inMulticastPktsAvg attribute.
    * @param inMulticastPktsAvg float ���������� ���޵� ��Ƽĳ��Ʈ ��Ŷ��  ��. ��հ� 
    */
    public void setInMulticastPktsAvg(float inMulticastPktsAvg)
    {
        this.inMulticastPktsAvg = inMulticastPktsAvg;
    }

    /**
    * Returns the inMulticastPktsAvg.
    * @return float ���������� ���޵� ��Ƽĳ��Ʈ ��Ŷ��  ��. ��հ�
    */
    public float getInMulticastPktsAvg()
    {
        return this.inMulticastPktsAvg;
    }

    /**
    * Sets the inMulticastPktsMax attribute.
    * @param inMulticastPktsMax float ���������� ���޵� ��Ƽĳ��Ʈ ��Ŷ��  ��. �ִ밪 
    */
    public void setInMulticastPktsMax(float inMulticastPktsMax)
    {
        this.inMulticastPktsMax = inMulticastPktsMax;
    }

    /**
    * Returns the inMulticastPktsMax.
    * @return float ���������� ���޵� ��Ƽĳ��Ʈ ��Ŷ��  ��. �ִ밪
    */
    public float getInMulticastPktsMax()
    {
        return this.inMulticastPktsMax;
    }

    /**
    * Sets the inMulticastPktssum attribute.
    * @param inMulticastPktssum float ���������� ���޵� ��Ƽĳ��Ʈ ��Ŷ��  ��. ������ 
    */
    public void setInMulticastPktssum(float inMulticastPktssum)
    {
        this.inMulticastPktssum = inMulticastPktssum;
    }

    /**
    * Returns the inMulticastPktssum.
    * @return float ���������� ���޵� ��Ƽĳ��Ʈ ��Ŷ��  ��. ������
    */
    public float getInMulticastPktssum()
    {
        return this.inMulticastPktssum;
    }

    /**
    * Sets the inBroadcastPktsAvg attribute.
    * @param inBroadcastPktsAvg float ���������� ���޵� ��ε�ĳ��Ʈ ��Ŷ�� ��. ��հ� 
    */
    public void setInBroadcastPktsAvg(float inBroadcastPktsAvg)
    {
        this.inBroadcastPktsAvg = inBroadcastPktsAvg;
    }

    /**
    * Returns the inBroadcastPktsAvg.
    * @return float ���������� ���޵� ��ε�ĳ��Ʈ ��Ŷ�� ��. ��հ�
    */
    public float getInBroadcastPktsAvg()
    {
        return this.inBroadcastPktsAvg;
    }

    /**
    * Sets the inBroadcastPktsMax attribute.
    * @param inBroadcastPktsMax float ���������� ���޵� ��ε�ĳ��Ʈ ��Ŷ�� ��. �ִ밪 
    */
    public void setInBroadcastPktsMax(float inBroadcastPktsMax)
    {
        this.inBroadcastPktsMax = inBroadcastPktsMax;
    }

    /**
    * Returns the inBroadcastPktsMax.
    * @return float ���������� ���޵� ��ε�ĳ��Ʈ ��Ŷ�� ��. �ִ밪
    */
    public float getInBroadcastPktsMax()
    {
        return this.inBroadcastPktsMax;
    }

    /**
    * Sets the inBroadcastPktsSum attribute.
    * @param inBroadcastPktsSum float ���������� ���޵� ��ε�ĳ��Ʈ ��Ŷ�� ��. ������ 
    */
    public void setInBroadcastPktsSum(float inBroadcastPktsSum)
    {
        this.inBroadcastPktsSum = inBroadcastPktsSum;
    }

    /**
    * Returns the inBroadcastPktsSum.
    * @return float ���������� ���޵� ��ε�ĳ��Ʈ ��Ŷ�� ��. ������
    */
    public float getInBroadcastPktsSum()
    {
        return this.inBroadcastPktsSum;
    }

    /**
    * Sets the inIfUsageRateAvg attribute.
    * @param inIfUsageRateAvg float ���ŵ� ��Ŷ �������̽� �̿���. ��հ� 
    */
    public void setInIfUsageRateAvg(float inIfUsageRateAvg)
    {
        this.inIfUsageRateAvg = inIfUsageRateAvg;
    }

    /**
    * Returns the inIfUsageRateAvg.
    * @return float ���ŵ� ��Ŷ �������̽� �̿���. ��հ�
    */
    public float getInIfUsageRateAvg()
    {
        return this.inIfUsageRateAvg;
    }

    /**
    * Sets the inIfUsageRateMax attribute.
    * @param inIfUsageRateMax float ���ŵ� ��Ŷ �������̽� �̿���. �ִ밪 
    */
    public void setInIfUsageRateMax(float inIfUsageRateMax)
    {
        this.inIfUsageRateMax = inIfUsageRateMax;
    }

    /**
    * Returns the inIfUsageRateMax.
    * @return float ���ŵ� ��Ŷ �������̽� �̿���. �ִ밪
    */
    public float getInIfUsageRateMax()
    {
        return this.inIfUsageRateMax;
    }

    /**
    * Sets the inBpsAvg attribute.
    * @param inBpsAvg float ���ŵ� ��� BPS(Bit Per Second) . ��հ� 
    */
    public void setInBpsAvg(float inBpsAvg)
    {
        this.inBpsAvg = inBpsAvg;
    }

    /**
    * Returns the inBpsAvg.
    * @return float ���ŵ� ��� BPS(Bit Per Second) . ��հ�
    */
    public float getInBpsAvg()
    {
        return this.inBpsAvg;
    }

    /**
    * Sets the inBpsMax attribute.
    * @param inBpsMax float ���ŵ� ��� BPS(Bit Per Second) . �ִ밪 
    */
    public void setInBpsMax(float inBpsMax)
    {
        this.inBpsMax = inBpsMax;
    }

    /**
    * Returns the inBpsMax.
    * @return float ���ŵ� ��� BPS(Bit Per Second) . �ִ밪
    */
    public float getInBpsMax()
    {
        return this.inBpsMax;
    }

    /**
    * Sets the inPpsAvg attribute.
    * @param inPpsAvg float ���ŵ� ���PPS(Packet Per Second) . ��հ� 
    */
    public void setInPpsAvg(float inPpsAvg)
    {
        this.inPpsAvg = inPpsAvg;
    }

    /**
    * Returns the inPpsAvg.
    * @return float ���ŵ� ���PPS(Packet Per Second) . ��հ�
    */
    public float getInPpsAvg()
    {
        return this.inPpsAvg;
    }

    /**
    * Sets the inPpsMax attribute.
    * @param inPpsMax float ���ŵ� ���PPS(Packet Per Second) 
    */
    public void setInPpsMax(float inPpsMax)
    {
        this.inPpsMax = inPpsMax;
    }

    /**
    * Returns the inPpsMax.
    * @return float ���ŵ� ���PPS(Packet Per Second)
    */
    public float getInPpsMax()
    {
        return this.inPpsMax;
    }

    /**
    * Sets the inVariationRateAvg attribute.
    * @param inVariationRateAvg float ���ŵ� ��Ŷ�� ���� �ֱⰪ�� ���� ��� �����߻���. ��հ� 
    */
    public void setInVariationRateAvg(float inVariationRateAvg)
    {
        this.inVariationRateAvg = inVariationRateAvg;
    }

    /**
    * Returns the inVariationRateAvg.
    * @return float ���ŵ� ��Ŷ�� ���� �ֱⰪ�� ���� ��� �����߻���. ��հ�
    */
    public float getInVariationRateAvg()
    {
        return this.inVariationRateAvg;
    }

    /**
    * Sets the inVariationRateMax attribute.
    * @param inVariationRateMax float ���ŵ� ��Ŷ�� ���� �ֱⰪ�� ���� ��� �����߻���. �ִ밪 
    */
    public void setInVariationRateMax(float inVariationRateMax)
    {
        this.inVariationRateMax = inVariationRateMax;
    }

    /**
    * Returns the inVariationRateMax.
    * @return float ���ŵ� ��Ŷ�� ���� �ֱⰪ�� ���� ��� �����߻���. �ִ밪
    */
    public float getInVariationRateMax()
    {
        return this.inVariationRateMax;
    }

    /**
    * Sets the outOctetsAvg attribute.
    * @param outOctetsAvg float �������̽����� �۽ŵ� Octet�� ��. ��հ� 
    */
    public void setOutOctetsAvg(float outOctetsAvg)
    {
        this.outOctetsAvg = outOctetsAvg;
    }

    /**
    * Returns the outOctetsAvg.
    * @return float �������̽����� �۽ŵ� Octet�� ��. ��հ�
    */
    public float getOutOctetsAvg()
    {
        return this.outOctetsAvg;
    }

    /**
    * Sets the outOctetsMax attribute.
    * @param outOctetsMax float �������̽����� �۽ŵ� Octet�� ��. �ִ밪 
    */
    public void setOutOctetsMax(float outOctetsMax)
    {
        this.outOctetsMax = outOctetsMax;
    }

    /**
    * Returns the outOctetsMax.
    * @return float �������̽����� �۽ŵ� Octet�� ��. �ִ밪
    */
    public float getOutOctetsMax()
    {
        return this.outOctetsMax;
    }

    /**
    * Sets the outOctetsSum attribute.
    * @param outOctetsSum float �������̽����� �۽ŵ� Octet�� ��. ������ 
    */
    public void setOutOctetsSum(float outOctetsSum)
    {
        this.outOctetsSum = outOctetsSum;
    }

    /**
    * Returns the outOctetsSum.
    * @return float �������̽����� �۽ŵ� Octet�� ��. ������
    */
    public float getOutOctetsSum()
    {
        return this.outOctetsSum;
    }

    /**
    * Sets the outDiscardsAvg attribute.
    * @param outDiscardsAvg float ��Ŷ�� ������ ������ ���۰� Ǯ�� ���� ���� ������ ���� ���� ���� ��Ŷ ��. ��հ� 
    */
    public void setOutDiscardsAvg(float outDiscardsAvg)
    {
        this.outDiscardsAvg = outDiscardsAvg;
    }

    /**
    * Returns the outDiscardsAvg.
    * @return float ��Ŷ�� ������ ������ ���۰� Ǯ�� ���� ���� ������ ���� ���� ���� ��Ŷ ��. ��հ�
    */
    public float getOutDiscardsAvg()
    {
        return this.outDiscardsAvg;
    }

    /**
    * Sets the outDiscardsMax attribute.
    * @param outDiscardsMax float ��Ŷ�� ������ ������ ���۰� Ǯ�� ���� ���� ������ ���� ���� ���� ��Ŷ ��. �ִ밪 
    */
    public void setOutDiscardsMax(float outDiscardsMax)
    {
        this.outDiscardsMax = outDiscardsMax;
    }

    /**
    * Returns the outDiscardsMax.
    * @return float ��Ŷ�� ������ ������ ���۰� Ǯ�� ���� ���� ������ ���� ���� ���� ��Ŷ ��. �ִ밪
    */
    public float getOutDiscardsMax()
    {
        return this.outDiscardsMax;
    }

    /**
    * Sets the outDiscardsSum attribute.
    * @param outDiscardsSum float ��Ŷ�� ������ ������ ���۰� Ǯ�� ���� ���� ������ ���� ���� ���� ��Ŷ ��. ������ 
    */
    public void setOutDiscardsSum(float outDiscardsSum)
    {
        this.outDiscardsSum = outDiscardsSum;
    }

    /**
    * Returns the outDiscardsSum.
    * @return float ��Ŷ�� ������ ������ ���۰� Ǯ�� ���� ���� ������ ���� ���� ���� ��Ŷ ��. ������
    */
    public float getOutDiscardsSum()
    {
        return this.outDiscardsSum;
    }

    /**
    * Sets the outErrorsAvg attribute.
    * @param outErrorsAvg float ��Ŷ�� ������ �־� ���۵��� ����  ��Ŷ ��. ��հ� 
    */
    public void setOutErrorsAvg(float outErrorsAvg)
    {
        this.outErrorsAvg = outErrorsAvg;
    }

    /**
    * Returns the outErrorsAvg.
    * @return float ��Ŷ�� ������ �־� ���۵��� ����  ��Ŷ ��. ��հ�
    */
    public float getOutErrorsAvg()
    {
        return this.outErrorsAvg;
    }

    /**
    * Sets the outErrorsMax attribute.
    * @param outErrorsMax float ��Ŷ�� ������ �־� ���۵��� ����  ��Ŷ ��. �ִ밪 
    */
    public void setOutErrorsMax(float outErrorsMax)
    {
        this.outErrorsMax = outErrorsMax;
    }

    /**
    * Returns the outErrorsMax.
    * @return float ��Ŷ�� ������ �־� ���۵��� ����  ��Ŷ ��. �ִ밪
    */
    public float getOutErrorsMax()
    {
        return this.outErrorsMax;
    }

    /**
    * Sets the outErrorsSum attribute.
    * @param outErrorsSum float ��Ŷ�� ������ �־� ���۵��� ����  ��Ŷ ��. ������ 
    */
    public void setOutErrorsSum(float outErrorsSum)
    {
        this.outErrorsSum = outErrorsSum;
    }

    /**
    * Returns the outErrorsSum.
    * @return float ��Ŷ�� ������ �־� ���۵��� ����  ��Ŷ ��. ������
    */
    public float getOutErrorsSum()
    {
        return this.outErrorsSum;
    }

    /**
    * Sets the outUcastPktsAvg attribute.
    * @param outUcastPktsAvg float ���� ���� ���������� �䱸�� ������  ����ĳ��Ʈ ��Ŷ�� �� (�������ų� ������������ ��Ŷ ����) . ��հ� 
    */
    public void setOutUcastPktsAvg(float outUcastPktsAvg)
    {
        this.outUcastPktsAvg = outUcastPktsAvg;
    }

    /**
    * Returns the outUcastPktsAvg.
    * @return float ���� ���� ���������� �䱸�� ������  ����ĳ��Ʈ ��Ŷ�� �� (�������ų� ������������ ��Ŷ ����) . ��հ�
    */
    public float getOutUcastPktsAvg()
    {
        return this.outUcastPktsAvg;
    }

    /**
    * Sets the outUcastPktsMax attribute.
    * @param outUcastPktsMax float ���� ���� ���������� �䱸�� ������  ����ĳ��Ʈ ��Ŷ�� �� (�������ų� ������������ ��Ŷ ����) . �ִ밪 
    */
    public void setOutUcastPktsMax(float outUcastPktsMax)
    {
        this.outUcastPktsMax = outUcastPktsMax;
    }

    /**
    * Returns the outUcastPktsMax.
    * @return float ���� ���� ���������� �䱸�� ������  ����ĳ��Ʈ ��Ŷ�� �� (�������ų� ������������ ��Ŷ ����) . �ִ밪
    */
    public float getOutUcastPktsMax()
    {
        return this.outUcastPktsMax;
    }

    /**
    * Sets the outUcastPktsSum attribute.
    * @param outUcastPktsSum float ���� ���� ���������� �䱸�� ������  ����ĳ��Ʈ ��Ŷ�� �� (�������ų� ������������ ��Ŷ ����) . ������ 
    */
    public void setOutUcastPktsSum(float outUcastPktsSum)
    {
        this.outUcastPktsSum = outUcastPktsSum;
    }

    /**
    * Returns the outUcastPktsSum.
    * @return float ���� ���� ���������� �䱸�� ������  ����ĳ��Ʈ ��Ŷ�� �� (�������ų� ������������ ��Ŷ ����) . ������
    */
    public float getOutUcastPktsSum()
    {
        return this.outUcastPktsSum;
    }

    /**
    * Sets the outNucastPktsAvg attribute.
    * @param outNucastPktsAvg float ���� ���� ���������� �䱸�� ������ ����ĳ��Ʈ�� �ƴ�  ��Ŷ�� ��  (�������ų� ������������ ��Ŷ ����) . ��հ� 
    */
    public void setOutNucastPktsAvg(float outNucastPktsAvg)
    {
        this.outNucastPktsAvg = outNucastPktsAvg;
    }

    /**
    * Returns the outNucastPktsAvg.
    * @return float ���� ���� ���������� �䱸�� ������ ����ĳ��Ʈ�� �ƴ�  ��Ŷ�� ��  (�������ų� ������������ ��Ŷ ����) . ��հ�
    */
    public float getOutNucastPktsAvg()
    {
        return this.outNucastPktsAvg;
    }

    /**
    * Sets the outNucastPktsMax attribute.
    * @param outNucastPktsMax float ���� ���� ���������� �䱸�� ������ ����ĳ��Ʈ�� �ƴ�  ��Ŷ�� ��  (�������ų� ������������ ��Ŷ ����) . �ִ밪 
    */
    public void setOutNucastPktsMax(float outNucastPktsMax)
    {
        this.outNucastPktsMax = outNucastPktsMax;
    }

    /**
    * Returns the outNucastPktsMax.
    * @return float ���� ���� ���������� �䱸�� ������ ����ĳ��Ʈ�� �ƴ�  ��Ŷ�� ��  (�������ų� ������������ ��Ŷ ����) . �ִ밪
    */
    public float getOutNucastPktsMax()
    {
        return this.outNucastPktsMax;
    }

    /**
    * Sets the outNucastPktsSum attribute.
    * @param outNucastPktsSum float ���� ���� ���������� �䱸�� ������ ����ĳ��Ʈ�� �ƴ�  ��Ŷ�� ��  (�������ų� ������������ ��Ŷ ����) . ������ 
    */
    public void setOutNucastPktsSum(float outNucastPktsSum)
    {
        this.outNucastPktsSum = outNucastPktsSum;
    }

    /**
    * Returns the outNucastPktsSum.
    * @return float ���� ���� ���������� �䱸�� ������ ����ĳ��Ʈ�� �ƴ�  ��Ŷ�� ��  (�������ų� ������������ ��Ŷ ����) . ������
    */
    public float getOutNucastPktsSum()
    {
        return this.outNucastPktsSum;
    }

    /**
    * Sets the outMulticastPktsAvg attribute.
    * @param outMulticastPktsAvg float ���� ���� ���������� �䱸�� ������ ��Ƽĳ��Ʈ ��Ŷ�� �� (�������ų� ������������ ��Ŷ ����) . ��հ� 
    */
    public void setOutMulticastPktsAvg(float outMulticastPktsAvg)
    {
        this.outMulticastPktsAvg = outMulticastPktsAvg;
    }

    /**
    * Returns the outMulticastPktsAvg.
    * @return float ���� ���� ���������� �䱸�� ������ ��Ƽĳ��Ʈ ��Ŷ�� �� (�������ų� ������������ ��Ŷ ����) . ��հ�
    */
    public float getOutMulticastPktsAvg()
    {
        return this.outMulticastPktsAvg;
    }

    /**
    * Sets the outMulticastPktsMax attribute.
    * @param outMulticastPktsMax float ���� ���� ���������� �䱸�� ������ ��Ƽĳ��Ʈ ��Ŷ�� �� (�������ų� ������������ ��Ŷ ����) . �ִ밪 
    */
    public void setOutMulticastPktsMax(float outMulticastPktsMax)
    {
        this.outMulticastPktsMax = outMulticastPktsMax;
    }

    /**
    * Returns the outMulticastPktsMax.
    * @return float ���� ���� ���������� �䱸�� ������ ��Ƽĳ��Ʈ ��Ŷ�� �� (�������ų� ������������ ��Ŷ ����) . �ִ밪
    */
    public float getOutMulticastPktsMax()
    {
        return this.outMulticastPktsMax;
    }

    /**
    * Sets the outMulticastPktsSum attribute.
    * @param outMulticastPktsSum float ���� ���� ���������� �䱸�� ������ ��Ƽĳ��Ʈ ��Ŷ�� �� (�������ų� ������������ ��Ŷ ����) . ������ 
    */
    public void setOutMulticastPktsSum(float outMulticastPktsSum)
    {
        this.outMulticastPktsSum = outMulticastPktsSum;
    }

    /**
    * Returns the outMulticastPktsSum.
    * @return float ���� ���� ���������� �䱸�� ������ ��Ƽĳ��Ʈ ��Ŷ�� �� (�������ų� ������������ ��Ŷ ����) . ������
    */
    public float getOutMulticastPktsSum()
    {
        return this.outMulticastPktsSum;
    }

    /**
    * Sets the outBroadcastPktsAvg attribute.
    * @param outBroadcastPktsAvg float ���� ���� ���������� �䱸�� ������  ��ε�ĳ��Ʈ ��Ŷ��  �� (�������ų� ������������ ��Ŷ ����) . ��հ� 
    */
    public void setOutBroadcastPktsAvg(float outBroadcastPktsAvg)
    {
        this.outBroadcastPktsAvg = outBroadcastPktsAvg;
    }

    /**
    * Returns the outBroadcastPktsAvg.
    * @return float ���� ���� ���������� �䱸�� ������  ��ε�ĳ��Ʈ ��Ŷ��  �� (�������ų� ������������ ��Ŷ ����) . ��հ�
    */
    public float getOutBroadcastPktsAvg()
    {
        return this.outBroadcastPktsAvg;
    }

    /**
    * Sets the outBroadcastPktsMax attribute.
    * @param outBroadcastPktsMax float ���� ���� ���������� �䱸�� ������  ��ε�ĳ��Ʈ ��Ŷ��  �� (�������ų� ������������ ��Ŷ ����) . �ִ밪 
    */
    public void setOutBroadcastPktsMax(float outBroadcastPktsMax)
    {
        this.outBroadcastPktsMax = outBroadcastPktsMax;
    }

    /**
    * Returns the outBroadcastPktsMax.
    * @return float ���� ���� ���������� �䱸�� ������  ��ε�ĳ��Ʈ ��Ŷ��  �� (�������ų� ������������ ��Ŷ ����) . �ִ밪
    */
    public float getOutBroadcastPktsMax()
    {
        return this.outBroadcastPktsMax;
    }

    /**
    * Sets the outBroadcastPktsSum attribute.
    * @param outBroadcastPktsSum float ���� ���� ���������� �䱸�� ������  ��ε�ĳ��Ʈ ��Ŷ��  �� (�������ų� ������������ ��Ŷ ����) . ������ 
    */
    public void setOutBroadcastPktsSum(float outBroadcastPktsSum)
    {
        this.outBroadcastPktsSum = outBroadcastPktsSum;
    }

    /**
    * Returns the outBroadcastPktsSum.
    * @return float ���� ���� ���������� �䱸�� ������  ��ε�ĳ��Ʈ ��Ŷ��  �� (�������ų� ������������ ��Ŷ ����) . ������
    */
    public float getOutBroadcastPktsSum()
    {
        return this.outBroadcastPktsSum;
    }

    /**
    * Sets the outIfUsageRateAvg attribute.
    * @param outIfUsageRateAvg float �۽ŵ� ��Ŷ �������̽�  �̿���. ��հ�(5�д���) 
    */
    public void setOutIfUsageRateAvg(float outIfUsageRateAvg)
    {
        this.outIfUsageRateAvg = outIfUsageRateAvg;
    }

    /**
    * Returns the outIfUsageRateAvg.
    * @return float �۽ŵ� ��Ŷ �������̽�  �̿���. ��հ�(5�д���)
    */
    public float getOutIfUsageRateAvg()
    {
        return this.outIfUsageRateAvg;
    }

    /**
    * Sets the outIfUsageRateMax attribute.
    * @param outIfUsageRateMax float �۽ŵ� ��Ŷ �������̽�  �̿���. �ִ밪 
    */
    public void setOutIfUsageRateMax(float outIfUsageRateMax)
    {
        this.outIfUsageRateMax = outIfUsageRateMax;
    }

    /**
    * Returns the outIfUsageRateMax.
    * @return float �۽ŵ� ��Ŷ �������̽�  �̿���. �ִ밪
    */
    public float getOutIfUsageRateMax()
    {
        return this.outIfUsageRateMax;
    }

    /**
    * Sets the outBpsAvg attribute.
    * @param outBpsAvg float �۽ŵ� ��� BPS(Bit Per Second) . ��հ� 
    */
    public void setOutBpsAvg(float outBpsAvg)
    {
        this.outBpsAvg = outBpsAvg;
    }

    /**
    * Returns the outBpsAvg.
    * @return float �۽ŵ� ��� BPS(Bit Per Second) . ��հ�
    */
    public float getOutBpsAvg()
    {
        return this.outBpsAvg;
    }

    /**
    * Sets the outBpsMax attribute.
    * @param outBpsMax float �۽ŵ� ��� BPS(Bit Per Second) . �ִ밪 
    */
    public void setOutBpsMax(float outBpsMax)
    {
        this.outBpsMax = outBpsMax;
    }

    /**
    * Returns the outBpsMax.
    * @return float �۽ŵ� ��� BPS(Bit Per Second) . �ִ밪
    */
    public float getOutBpsMax()
    {
        return this.outBpsMax;
    }

    /**
    * Sets the outPpsAvg attribute.
    * @param outPpsAvg float �۽ŵ� ��� PPS(Packet Per Second) . ��հ� 
    */
    public void setOutPpsAvg(float outPpsAvg)
    {
        this.outPpsAvg = outPpsAvg;
    }

    /**
    * Returns the outPpsAvg.
    * @return float �۽ŵ� ��� PPS(Packet Per Second) . ��հ�
    */
    public float getOutPpsAvg()
    {
        return this.outPpsAvg;
    }

    /**
    * Sets the outPpsMax attribute.
    * @param outPpsMax float �۽ŵ� ��� PPS(Packet Per Second) . �ִ밪 
    */
    public void setOutPpsMax(float outPpsMax)
    {
        this.outPpsMax = outPpsMax;
    }

    /**
    * Returns the outPpsMax.
    * @return float �۽ŵ� ��� PPS(Packet Per Second) . �ִ밪
    */
    public float getOutPpsMax()
    {
        return this.outPpsMax;
    }

    /**
    * Sets the outVariationRateAvg attribute.
    * @param outVariationRateAvg float �۽ŵ� ��Ŷ�� ���� �ֱⰪ�� ���� ��� �����߻���. ��հ� 
    */
    public void setOutVariationRateAvg(float outVariationRateAvg)
    {
        this.outVariationRateAvg = outVariationRateAvg;
    }

    /**
    * Returns the outVariationRateAvg.
    * @return float �۽ŵ� ��Ŷ�� ���� �ֱⰪ�� ���� ��� �����߻���. ��հ�
    */
    public float getOutVariationRateAvg()
    {
        return this.outVariationRateAvg;
    }

    /**
    * Sets the outVariationRateMax attribute.
    * @param outVariationRateMax float �۽ŵ� ��Ŷ�� ���� �ֱⰪ�� ���� ��� �����߻���. �ִ밪 
    */
    public void setOutVariationRateMax(float outVariationRateMax)
    {
        this.outVariationRateMax = outVariationRateMax;
    }

    /**
    * Returns the outVariationRateMax.
    * @return float �۽ŵ� ��Ŷ�� ���� �ֱⰪ�� ���� ��� �����߻���. �ִ밪
    */
    public float getOutVariationRateMax()
    {
        return this.outVariationRateMax;
    }
}
