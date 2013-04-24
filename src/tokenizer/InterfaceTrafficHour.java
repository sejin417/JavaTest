package tokenizer;
/*
 * Copyright 2006 KT ALL RIGHTS RESERVED
 *
 * Copyright 2006 Korea Telecom ALL RIGHTS RESERVED
 * 파일명: InterfaceTrafficHour.java
 * 작성일자/작성자 : 2006.09.12 가주현
 *
 * UC명 : Premium-NMS 연동.
 * 내용 : InterfaceTrafficHour Attribute를 표현하는 객체이다.
 * 특징 : 
 *
 * ============================================================================
 * 수정 내역
 * NO   수정일자    수정자  수정내역
 * ============================================================================
*/
import java.sql.Timestamp;

/**
 * InterfaceTrafficHour의 Attribute를 표현하는 객체이다.
 * @author 가주현
 * @version 1.0
 */
public class InterfaceTrafficHour implements java.io.Serializable
{
    private Timestamp collectionTime; //수집 시간
    private String locationCode; //위치식별코드
    private String masterIp; //장비 IP
    private String equipAlias; //장비별칭
    private String ifName; //인터페이스명
    private String ifIp; //인터페이스 IP
    private String ifUsgCode; //포트 용도 코드
    private float inOctetsAvg; //인터페이스에서 수신된 Octet의 수. 평균값
    private float inOctetsMax; //인터페이스에서 수신된 Octet의 수. 최대값
    private float inOctetsSum; //인터페이스에서 수신된 Octet의 수. 누적값
    private float inDiscardsAvg; //패킷에 에러는 없지만 상위 층 프로토콜로 못간 패킷의 수. 평균값
    private float inDiscardsMax; //패킷에 에러는 없지만 상위 층 프로토콜로 못간 패킷의 수. 최대값
    private float inDiscardsSum; //패킷에 에러는 없지만 상위 층 프로토콜로 못간 패킷의 수. 누적값
    private float inErrorsAvg; //패킷에 에러가 있어 상위 층 프로토콜로 전달되지 못한 패킷 수. 평균값
    private float inErrorsMax; //패킷에 에러가 있어 상위 층 프로토콜로 전달되지 못한 패킷 수. 최대값
    private float inErrorsSum; //패킷에 에러가 있어 상위 층 프로토콜로 전달되지 못한 패킷 수. 누적값
    private float inUcastPktsAvg; //상위층으로 전달된 유니캐스트 패킷의 수. 평균값
    private float inUcastPktsMax; //상위층으로 전달된 유니캐스트 패킷의 수. 최대값
    private float inUcastPktsSum; //상위층으로 전달된 유니캐스트 패킷의 수. 누적값
    private float inNucastPktsAvg; //상위층으로 전달된 유니캐스트가 아닌 패킷의 수. 평균값
    private float inNucastPktsMax; //상위층으로 전달된 유니캐스트가 아닌 패킷의 수. 최대값
    private float inNucastPktsSum; //상위층으로 전달된 유니캐스트가 아닌 패킷의 수. 누적값
    private float inMulticastPktsAvg; //상위층으로 전달된 멀티캐스트 패킷의  수. 평균값
    private float inMulticastPktsMax; //상위층으로 전달된 멀티캐스트 패킷의  수. 최대값
    private float inMulticastPktssum; //상위층으로 전달된 멀티캐스트 패킷의  수. 누적값
    private float inBroadcastPktsAvg; //상위층으로 전달된 브로드캐스트 패킷의 수. 평균값
    private float inBroadcastPktsMax; //상위층으로 전달된 브로드캐스트 패킷의 수. 최대값
    private float inBroadcastPktsSum; //상위층으로 전달된 브로드캐스트 패킷의 수. 누적값
    private float inIfUsageRateAvg; //수신된 패킷 인터페이스 이용율. 평균값
    private float inIfUsageRateMax; //수신된 패킷 인터페이스 이용율. 최대값
    private float inBpsAvg; //수신된 평균 BPS(Bit Per Second) . 평균값
    private float inBpsMax; //수신된 평균 BPS(Bit Per Second) . 최대값
    private float inPpsAvg; //수신된 평균PPS(Packet Per Second) . 평균값
    private float inPpsMax; //수신된 평균PPS(Packet Per Second)
    private float inVariationRateAvg; //수신된 패킷의 이전 주기값에 대한 평균 변동발생율. 평균값
    private float inVariationRateMax; //수신된 패킷의 이전 주기값에 대한 평균 변동발생율. 최대값
    private float outOctetsAvg; //인터페이스에서 송신된 Octet의 수. 평균값
    private float outOctetsMax; //인터페이스에서 송신된 Octet의 수. 최대값
    private float outOctetsSum; //인터페이스에서 송신된 Octet의 수. 누적값
    private float outDiscardsAvg; //패킷에 에러는 없지만 버퍼가 풀난 경우와 같은 이유로 전송 되지 못한 패킷 수. 평균값
    private float outDiscardsMax; //패킷에 에러는 없지만 버퍼가 풀난 경우와 같은 이유로 전송 되지 못한 패킷 수. 최대값
    private float outDiscardsSum; //패킷에 에러는 없지만 버퍼가 풀난 경우와 같은 이유로 전송 되지 못한 패킷 수. 누적값
    private float outErrorsAvg; //패킷에 에러가 있어 전송되지 못한  패킷 수. 평균값
    private float outErrorsMax; //패킷에 에러가 있어 전송되지 못한  패킷 수. 최대값
    private float outErrorsSum; //패킷에 에러가 있어 전송되지 못한  패킷 수. 누적값
    private float outUcastPktsAvg; //상위 계층 프로토콜의 요구로 전달한  유니캐스트 패킷의 수 (버려지거나 보내지지않은 패킷 포함) . 평균값
    private float outUcastPktsMax; //상위 계층 프로토콜의 요구로 전달한  유니캐스트 패킷의 수 (버려지거나 보내지지않은 패킷 포함) . 최대값
    private float outUcastPktsSum; //상위 계층 프로토콜의 요구로 전달한  유니캐스트 패킷의 수 (버려지거나 보내지지않은 패킷 포함) . 누적값
    private float outNucastPktsAvg; //상위 계층 프로토콜의 요구로 전달한 유니캐스트가 아닌  패킷의 수  (버려지거나 보내지지않은 패킷 포함) . 평균값
    private float outNucastPktsMax; //상위 계층 프로토콜의 요구로 전달한 유니캐스트가 아닌  패킷의 수  (버려지거나 보내지지않은 패킷 포함) . 최대값
    private float outNucastPktsSum; //상위 계층 프로토콜의 요구로 전달한 유니캐스트가 아닌  패킷의 수  (버려지거나 보내지지않은 패킷 포함) . 누적값
    private float outMulticastPktsAvg; //상위 계층 포로토콜의 요구로 전달한 멀티캐스트 패킷의 수 (버려지거나 보내지지않은 패킷 포함) . 평균값
    private float outMulticastPktsMax; //상위 계층 포로토콜의 요구로 전달한 멀티캐스트 패킷의 수 (버려지거나 보내지지않은 패킷 포함) . 최대값
    private float outMulticastPktsSum; //상위 계층 포로토콜의 요구로 전달한 멀티캐스트 패킷의 수 (버려지거나 보내지지않은 패킷 포함) . 누적값
    private float outBroadcastPktsAvg; //상위 계층 포로토콜의 요구로 전달한  브로드캐스트 패킷의  수 (버려지거나 보내지지않은 패킷 포함) . 평균값
    private float outBroadcastPktsMax; //상위 계층 포로토콜의 요구로 전달한  브로드캐스트 패킷의  수 (버려지거나 보내지지않은 패킷 포함) . 최대값
    private float outBroadcastPktsSum; //상위 계층 포로토콜의 요구로 전달한  브로드캐스트 패킷의  수 (버려지거나 보내지지않은 패킷 포함) . 누적값
    private float outIfUsageRateAvg; //송신된 패킷 인터페이스  이용율. 평균값(5분단위)
    private float outIfUsageRateMax; //송신된 패킷 인터페이스  이용율. 최대값
    private float outBpsAvg; //송신된 평균 BPS(Bit Per Second) . 평균값
    private float outBpsMax; //송신된 평균 BPS(Bit Per Second) . 최대값
    private float outPpsAvg; //송신된 평균 PPS(Packet Per Second) . 평균값
    private float outPpsMax; //송신된 평균 PPS(Packet Per Second) . 최대값
    private float outVariationRateAvg; //송신된 패킷의 이전 주기값에 대한 평균 변동발생율. 평균값
    private float outVariationRateMax; //송신된 패킷의 이전 주기값에 대한 평균 변동발생율. 최대값

    /**
    * Sets the collectionTime attribute.
    * @param collectionTime Timestamp 수집 시간 
    */
    public void setCollectionTime(Timestamp collectionTime)
    {
        this.collectionTime = collectionTime;
    }

    /**
    * Returns the collectionTime.
    * @return Timestamp 수집 시간
    */
    public Timestamp getCollectionTime()
    {
        return this.collectionTime;
    }

    /**
    * Sets the locationCode attribute.
    * @param locationCode String 위치식별코드 
    */
    public void setLocationCode(String locationCode)
    {
        this.locationCode = locationCode;
    }

    /**
    * Returns the locationCode.
    * @return String 위치식별코드
    */
    public String getLocationCode()
    {
        return this.locationCode;
    }

    /**
    * Sets the masterIp attribute.
    * @param masterIp String 장비 IP 
    */
    public void setMasterIp(String masterIp)
    {
        this.masterIp = masterIp;
    }

    /**
    * Returns the masterIp.
    * @return String 장비 IP
    */
    public String getMasterIp()
    {
        return this.masterIp;
    }

    /**
    * Sets the equipAlias attribute.
    * @param equipAlias String 장비별칭 
    */
    public void setEquipAlias(String equipAlias)
    {
        this.equipAlias = equipAlias;
    }

    /**
    * Returns the equipAlias.
    * @return String 장비별칭
    */
    public String getEquipAlias()
    {
        return this.equipAlias;
    }

    /**
    * Sets the ifName attribute.
    * @param ifName String 인터페이스명 
    */
    public void setIfName(String ifName)
    {
        this.ifName = ifName;
    }

    /**
    * Returns the ifName.
    * @return String 인터페이스명
    */
    public String getIfName()
    {
        return this.ifName;
    }

    /**
    * Sets the ifIp attribute.
    * @param ifIp String 인터페이스 IP 
    */
    public void setIfIp(String ifIp)
    {
        this.ifIp = ifIp;
    }

    /**
    * Returns the ifIp.
    * @return String 인터페이스 IP
    */
    public String getIfIp()
    {
        return this.ifIp;
    }

    /**
    * Sets the ifUsgCode attribute.
    * @param ifUsgCode String 포트 용도 코드 
    */
    public void setIfUsgCode(String ifUsgCode)
    {
        this.ifUsgCode = ifUsgCode;
    }

    /**
    * Returns the ifUsgCode.
    * @return String 포트 용도 코드
    */
    public String getIfUsgCode()
    {
        return this.ifUsgCode;
    }

    /**
    * Sets the inOctetsAvg attribute.
    * @param inOctetsAvg float 인터페이스에서 수신된 Octet의 수. 평균값 
    */
    public void setInOctetsAvg(float inOctetsAvg)
    {
        this.inOctetsAvg = inOctetsAvg;
    }

    /**
    * Returns the inOctetsAvg.
    * @return float 인터페이스에서 수신된 Octet의 수. 평균값
    */
    public float getInOctetsAvg()
    {
        return this.inOctetsAvg;
    }

    /**
    * Sets the inOctetsMax attribute.
    * @param inOctetsMax float 인터페이스에서 수신된 Octet의 수. 최대값 
    */
    public void setInOctetsMax(float inOctetsMax)
    {
        this.inOctetsMax = inOctetsMax;
    }

    /**
    * Returns the inOctetsMax.
    * @return float 인터페이스에서 수신된 Octet의 수. 최대값
    */
    public float getInOctetsMax()
    {
        return this.inOctetsMax;
    }

    /**
    * Sets the inOctetsSum attribute.
    * @param inOctetsSum float 인터페이스에서 수신된 Octet의 수. 누적값 
    */
    public void setInOctetsSum(float inOctetsSum)
    {
        this.inOctetsSum = inOctetsSum;
    }

    /**
    * Returns the inOctetsSum.
    * @return float 인터페이스에서 수신된 Octet의 수. 누적값
    */
    public float getInOctetsSum()
    {
        return this.inOctetsSum;
    }

    /**
    * Sets the inDiscardsAvg attribute.
    * @param inDiscardsAvg float 패킷에 에러는 없지만 상위 층 프로토콜로 못간 패킷의 수. 평균값 
    */
    public void setInDiscardsAvg(float inDiscardsAvg)
    {
        this.inDiscardsAvg = inDiscardsAvg;
    }

    /**
    * Returns the inDiscardsAvg.
    * @return float 패킷에 에러는 없지만 상위 층 프로토콜로 못간 패킷의 수. 평균값
    */
    public float getInDiscardsAvg()
    {
        return this.inDiscardsAvg;
    }

    /**
    * Sets the inDiscardsMax attribute.
    * @param inDiscardsMax float 패킷에 에러는 없지만 상위 층 프로토콜로 못간 패킷의 수. 최대값 
    */
    public void setInDiscardsMax(float inDiscardsMax)
    {
        this.inDiscardsMax = inDiscardsMax;
    }

    /**
    * Returns the inDiscardsMax.
    * @return float 패킷에 에러는 없지만 상위 층 프로토콜로 못간 패킷의 수. 최대값
    */
    public float getInDiscardsMax()
    {
        return this.inDiscardsMax;
    }

    /**
    * Sets the inDiscardsSum attribute.
    * @param inDiscardsSum float 패킷에 에러는 없지만 상위 층 프로토콜로 못간 패킷의 수. 누적값 
    */
    public void setInDiscardsSum(float inDiscardsSum)
    {
        this.inDiscardsSum = inDiscardsSum;
    }

    /**
    * Returns the inDiscardsSum.
    * @return float 패킷에 에러는 없지만 상위 층 프로토콜로 못간 패킷의 수. 누적값
    */
    public float getInDiscardsSum()
    {
        return this.inDiscardsSum;
    }

    /**
    * Sets the inErrorsAvg attribute.
    * @param inErrorsAvg float 패킷에 에러가 있어 상위 층 프로토콜로 전달되지 못한 패킷 수. 평균값 
    */
    public void setInErrorsAvg(float inErrorsAvg)
    {
        this.inErrorsAvg = inErrorsAvg;
    }

    /**
    * Returns the inErrorsAvg.
    * @return float 패킷에 에러가 있어 상위 층 프로토콜로 전달되지 못한 패킷 수. 평균값
    */
    public float getInErrorsAvg()
    {
        return this.inErrorsAvg;
    }

    /**
    * Sets the inErrorsMax attribute.
    * @param inErrorsMax float 패킷에 에러가 있어 상위 층 프로토콜로 전달되지 못한 패킷 수. 최대값 
    */
    public void setInErrorsMax(float inErrorsMax)
    {
        this.inErrorsMax = inErrorsMax;
    }

    /**
    * Returns the inErrorsMax.
    * @return float 패킷에 에러가 있어 상위 층 프로토콜로 전달되지 못한 패킷 수. 최대값
    */
    public float getInErrorsMax()
    {
        return this.inErrorsMax;
    }

    /**
    * Sets the inErrorsSum attribute.
    * @param inErrorsSum float 패킷에 에러가 있어 상위 층 프로토콜로 전달되지 못한 패킷 수. 누적값 
    */
    public void setInErrorsSum(float inErrorsSum)
    {
        this.inErrorsSum = inErrorsSum;
    }

    /**
    * Returns the inErrorsSum.
    * @return float 패킷에 에러가 있어 상위 층 프로토콜로 전달되지 못한 패킷 수. 누적값
    */
    public float getInErrorsSum()
    {
        return this.inErrorsSum;
    }

    /**
    * Sets the inUcastPktsAvg attribute.
    * @param inUcastPktsAvg float 상위층으로 전달된 유니캐스트 패킷의 수. 평균값 
    */
    public void setInUcastPktsAvg(float inUcastPktsAvg)
    {
        this.inUcastPktsAvg = inUcastPktsAvg;
    }

    /**
    * Returns the inUcastPktsAvg.
    * @return float 상위층으로 전달된 유니캐스트 패킷의 수. 평균값
    */
    public float getInUcastPktsAvg()
    {
        return this.inUcastPktsAvg;
    }

    /**
    * Sets the inUcastPktsMax attribute.
    * @param inUcastPktsMax float 상위층으로 전달된 유니캐스트 패킷의 수. 최대값 
    */
    public void setInUcastPktsMax(float inUcastPktsMax)
    {
        this.inUcastPktsMax = inUcastPktsMax;
    }

    /**
    * Returns the inUcastPktsMax.
    * @return float 상위층으로 전달된 유니캐스트 패킷의 수. 최대값
    */
    public float getInUcastPktsMax()
    {
        return this.inUcastPktsMax;
    }

    /**
    * Sets the inUcastPktsSum attribute.
    * @param inUcastPktsSum float 상위층으로 전달된 유니캐스트 패킷의 수. 누적값 
    */
    public void setInUcastPktsSum(float inUcastPktsSum)
    {
        this.inUcastPktsSum = inUcastPktsSum;
    }

    /**
    * Returns the inUcastPktsSum.
    * @return float 상위층으로 전달된 유니캐스트 패킷의 수. 누적값
    */
    public float getInUcastPktsSum()
    {
        return this.inUcastPktsSum;
    }

    /**
    * Sets the inNucastPktsAvg attribute.
    * @param inNucastPktsAvg float 상위층으로 전달된 유니캐스트가 아닌 패킷의 수. 평균값 
    */
    public void setInNucastPktsAvg(float inNucastPktsAvg)
    {
        this.inNucastPktsAvg = inNucastPktsAvg;
    }

    /**
    * Returns the inNucastPktsAvg.
    * @return float 상위층으로 전달된 유니캐스트가 아닌 패킷의 수. 평균값
    */
    public float getInNucastPktsAvg()
    {
        return this.inNucastPktsAvg;
    }

    /**
    * Sets the inNucastPktsMax attribute.
    * @param inNucastPktsMax float 상위층으로 전달된 유니캐스트가 아닌 패킷의 수. 최대값 
    */
    public void setInNucastPktsMax(float inNucastPktsMax)
    {
        this.inNucastPktsMax = inNucastPktsMax;
    }

    /**
    * Returns the inNucastPktsMax.
    * @return float 상위층으로 전달된 유니캐스트가 아닌 패킷의 수. 최대값
    */
    public float getInNucastPktsMax()
    {
        return this.inNucastPktsMax;
    }

    /**
    * Sets the inNucastPktsSum attribute.
    * @param inNucastPktsSum float 상위층으로 전달된 유니캐스트가 아닌 패킷의 수. 누적값 
    */
    public void setInNucastPktsSum(float inNucastPktsSum)
    {
        this.inNucastPktsSum = inNucastPktsSum;
    }

    /**
    * Returns the inNucastPktsSum.
    * @return float 상위층으로 전달된 유니캐스트가 아닌 패킷의 수. 누적값
    */
    public float getInNucastPktsSum()
    {
        return this.inNucastPktsSum;
    }

    /**
    * Sets the inMulticastPktsAvg attribute.
    * @param inMulticastPktsAvg float 상위층으로 전달된 멀티캐스트 패킷의  수. 평균값 
    */
    public void setInMulticastPktsAvg(float inMulticastPktsAvg)
    {
        this.inMulticastPktsAvg = inMulticastPktsAvg;
    }

    /**
    * Returns the inMulticastPktsAvg.
    * @return float 상위층으로 전달된 멀티캐스트 패킷의  수. 평균값
    */
    public float getInMulticastPktsAvg()
    {
        return this.inMulticastPktsAvg;
    }

    /**
    * Sets the inMulticastPktsMax attribute.
    * @param inMulticastPktsMax float 상위층으로 전달된 멀티캐스트 패킷의  수. 최대값 
    */
    public void setInMulticastPktsMax(float inMulticastPktsMax)
    {
        this.inMulticastPktsMax = inMulticastPktsMax;
    }

    /**
    * Returns the inMulticastPktsMax.
    * @return float 상위층으로 전달된 멀티캐스트 패킷의  수. 최대값
    */
    public float getInMulticastPktsMax()
    {
        return this.inMulticastPktsMax;
    }

    /**
    * Sets the inMulticastPktssum attribute.
    * @param inMulticastPktssum float 상위층으로 전달된 멀티캐스트 패킷의  수. 누적값 
    */
    public void setInMulticastPktssum(float inMulticastPktssum)
    {
        this.inMulticastPktssum = inMulticastPktssum;
    }

    /**
    * Returns the inMulticastPktssum.
    * @return float 상위층으로 전달된 멀티캐스트 패킷의  수. 누적값
    */
    public float getInMulticastPktssum()
    {
        return this.inMulticastPktssum;
    }

    /**
    * Sets the inBroadcastPktsAvg attribute.
    * @param inBroadcastPktsAvg float 상위층으로 전달된 브로드캐스트 패킷의 수. 평균값 
    */
    public void setInBroadcastPktsAvg(float inBroadcastPktsAvg)
    {
        this.inBroadcastPktsAvg = inBroadcastPktsAvg;
    }

    /**
    * Returns the inBroadcastPktsAvg.
    * @return float 상위층으로 전달된 브로드캐스트 패킷의 수. 평균값
    */
    public float getInBroadcastPktsAvg()
    {
        return this.inBroadcastPktsAvg;
    }

    /**
    * Sets the inBroadcastPktsMax attribute.
    * @param inBroadcastPktsMax float 상위층으로 전달된 브로드캐스트 패킷의 수. 최대값 
    */
    public void setInBroadcastPktsMax(float inBroadcastPktsMax)
    {
        this.inBroadcastPktsMax = inBroadcastPktsMax;
    }

    /**
    * Returns the inBroadcastPktsMax.
    * @return float 상위층으로 전달된 브로드캐스트 패킷의 수. 최대값
    */
    public float getInBroadcastPktsMax()
    {
        return this.inBroadcastPktsMax;
    }

    /**
    * Sets the inBroadcastPktsSum attribute.
    * @param inBroadcastPktsSum float 상위층으로 전달된 브로드캐스트 패킷의 수. 누적값 
    */
    public void setInBroadcastPktsSum(float inBroadcastPktsSum)
    {
        this.inBroadcastPktsSum = inBroadcastPktsSum;
    }

    /**
    * Returns the inBroadcastPktsSum.
    * @return float 상위층으로 전달된 브로드캐스트 패킷의 수. 누적값
    */
    public float getInBroadcastPktsSum()
    {
        return this.inBroadcastPktsSum;
    }

    /**
    * Sets the inIfUsageRateAvg attribute.
    * @param inIfUsageRateAvg float 수신된 패킷 인터페이스 이용율. 평균값 
    */
    public void setInIfUsageRateAvg(float inIfUsageRateAvg)
    {
        this.inIfUsageRateAvg = inIfUsageRateAvg;
    }

    /**
    * Returns the inIfUsageRateAvg.
    * @return float 수신된 패킷 인터페이스 이용율. 평균값
    */
    public float getInIfUsageRateAvg()
    {
        return this.inIfUsageRateAvg;
    }

    /**
    * Sets the inIfUsageRateMax attribute.
    * @param inIfUsageRateMax float 수신된 패킷 인터페이스 이용율. 최대값 
    */
    public void setInIfUsageRateMax(float inIfUsageRateMax)
    {
        this.inIfUsageRateMax = inIfUsageRateMax;
    }

    /**
    * Returns the inIfUsageRateMax.
    * @return float 수신된 패킷 인터페이스 이용율. 최대값
    */
    public float getInIfUsageRateMax()
    {
        return this.inIfUsageRateMax;
    }

    /**
    * Sets the inBpsAvg attribute.
    * @param inBpsAvg float 수신된 평균 BPS(Bit Per Second) . 평균값 
    */
    public void setInBpsAvg(float inBpsAvg)
    {
        this.inBpsAvg = inBpsAvg;
    }

    /**
    * Returns the inBpsAvg.
    * @return float 수신된 평균 BPS(Bit Per Second) . 평균값
    */
    public float getInBpsAvg()
    {
        return this.inBpsAvg;
    }

    /**
    * Sets the inBpsMax attribute.
    * @param inBpsMax float 수신된 평균 BPS(Bit Per Second) . 최대값 
    */
    public void setInBpsMax(float inBpsMax)
    {
        this.inBpsMax = inBpsMax;
    }

    /**
    * Returns the inBpsMax.
    * @return float 수신된 평균 BPS(Bit Per Second) . 최대값
    */
    public float getInBpsMax()
    {
        return this.inBpsMax;
    }

    /**
    * Sets the inPpsAvg attribute.
    * @param inPpsAvg float 수신된 평균PPS(Packet Per Second) . 평균값 
    */
    public void setInPpsAvg(float inPpsAvg)
    {
        this.inPpsAvg = inPpsAvg;
    }

    /**
    * Returns the inPpsAvg.
    * @return float 수신된 평균PPS(Packet Per Second) . 평균값
    */
    public float getInPpsAvg()
    {
        return this.inPpsAvg;
    }

    /**
    * Sets the inPpsMax attribute.
    * @param inPpsMax float 수신된 평균PPS(Packet Per Second) 
    */
    public void setInPpsMax(float inPpsMax)
    {
        this.inPpsMax = inPpsMax;
    }

    /**
    * Returns the inPpsMax.
    * @return float 수신된 평균PPS(Packet Per Second)
    */
    public float getInPpsMax()
    {
        return this.inPpsMax;
    }

    /**
    * Sets the inVariationRateAvg attribute.
    * @param inVariationRateAvg float 수신된 패킷의 이전 주기값에 대한 평균 변동발생율. 평균값 
    */
    public void setInVariationRateAvg(float inVariationRateAvg)
    {
        this.inVariationRateAvg = inVariationRateAvg;
    }

    /**
    * Returns the inVariationRateAvg.
    * @return float 수신된 패킷의 이전 주기값에 대한 평균 변동발생율. 평균값
    */
    public float getInVariationRateAvg()
    {
        return this.inVariationRateAvg;
    }

    /**
    * Sets the inVariationRateMax attribute.
    * @param inVariationRateMax float 수신된 패킷의 이전 주기값에 대한 평균 변동발생율. 최대값 
    */
    public void setInVariationRateMax(float inVariationRateMax)
    {
        this.inVariationRateMax = inVariationRateMax;
    }

    /**
    * Returns the inVariationRateMax.
    * @return float 수신된 패킷의 이전 주기값에 대한 평균 변동발생율. 최대값
    */
    public float getInVariationRateMax()
    {
        return this.inVariationRateMax;
    }

    /**
    * Sets the outOctetsAvg attribute.
    * @param outOctetsAvg float 인터페이스에서 송신된 Octet의 수. 평균값 
    */
    public void setOutOctetsAvg(float outOctetsAvg)
    {
        this.outOctetsAvg = outOctetsAvg;
    }

    /**
    * Returns the outOctetsAvg.
    * @return float 인터페이스에서 송신된 Octet의 수. 평균값
    */
    public float getOutOctetsAvg()
    {
        return this.outOctetsAvg;
    }

    /**
    * Sets the outOctetsMax attribute.
    * @param outOctetsMax float 인터페이스에서 송신된 Octet의 수. 최대값 
    */
    public void setOutOctetsMax(float outOctetsMax)
    {
        this.outOctetsMax = outOctetsMax;
    }

    /**
    * Returns the outOctetsMax.
    * @return float 인터페이스에서 송신된 Octet의 수. 최대값
    */
    public float getOutOctetsMax()
    {
        return this.outOctetsMax;
    }

    /**
    * Sets the outOctetsSum attribute.
    * @param outOctetsSum float 인터페이스에서 송신된 Octet의 수. 누적값 
    */
    public void setOutOctetsSum(float outOctetsSum)
    {
        this.outOctetsSum = outOctetsSum;
    }

    /**
    * Returns the outOctetsSum.
    * @return float 인터페이스에서 송신된 Octet의 수. 누적값
    */
    public float getOutOctetsSum()
    {
        return this.outOctetsSum;
    }

    /**
    * Sets the outDiscardsAvg attribute.
    * @param outDiscardsAvg float 패킷에 에러는 없지만 버퍼가 풀난 경우와 같은 이유로 전송 되지 못한 패킷 수. 평균값 
    */
    public void setOutDiscardsAvg(float outDiscardsAvg)
    {
        this.outDiscardsAvg = outDiscardsAvg;
    }

    /**
    * Returns the outDiscardsAvg.
    * @return float 패킷에 에러는 없지만 버퍼가 풀난 경우와 같은 이유로 전송 되지 못한 패킷 수. 평균값
    */
    public float getOutDiscardsAvg()
    {
        return this.outDiscardsAvg;
    }

    /**
    * Sets the outDiscardsMax attribute.
    * @param outDiscardsMax float 패킷에 에러는 없지만 버퍼가 풀난 경우와 같은 이유로 전송 되지 못한 패킷 수. 최대값 
    */
    public void setOutDiscardsMax(float outDiscardsMax)
    {
        this.outDiscardsMax = outDiscardsMax;
    }

    /**
    * Returns the outDiscardsMax.
    * @return float 패킷에 에러는 없지만 버퍼가 풀난 경우와 같은 이유로 전송 되지 못한 패킷 수. 최대값
    */
    public float getOutDiscardsMax()
    {
        return this.outDiscardsMax;
    }

    /**
    * Sets the outDiscardsSum attribute.
    * @param outDiscardsSum float 패킷에 에러는 없지만 버퍼가 풀난 경우와 같은 이유로 전송 되지 못한 패킷 수. 누적값 
    */
    public void setOutDiscardsSum(float outDiscardsSum)
    {
        this.outDiscardsSum = outDiscardsSum;
    }

    /**
    * Returns the outDiscardsSum.
    * @return float 패킷에 에러는 없지만 버퍼가 풀난 경우와 같은 이유로 전송 되지 못한 패킷 수. 누적값
    */
    public float getOutDiscardsSum()
    {
        return this.outDiscardsSum;
    }

    /**
    * Sets the outErrorsAvg attribute.
    * @param outErrorsAvg float 패킷에 에러가 있어 전송되지 못한  패킷 수. 평균값 
    */
    public void setOutErrorsAvg(float outErrorsAvg)
    {
        this.outErrorsAvg = outErrorsAvg;
    }

    /**
    * Returns the outErrorsAvg.
    * @return float 패킷에 에러가 있어 전송되지 못한  패킷 수. 평균값
    */
    public float getOutErrorsAvg()
    {
        return this.outErrorsAvg;
    }

    /**
    * Sets the outErrorsMax attribute.
    * @param outErrorsMax float 패킷에 에러가 있어 전송되지 못한  패킷 수. 최대값 
    */
    public void setOutErrorsMax(float outErrorsMax)
    {
        this.outErrorsMax = outErrorsMax;
    }

    /**
    * Returns the outErrorsMax.
    * @return float 패킷에 에러가 있어 전송되지 못한  패킷 수. 최대값
    */
    public float getOutErrorsMax()
    {
        return this.outErrorsMax;
    }

    /**
    * Sets the outErrorsSum attribute.
    * @param outErrorsSum float 패킷에 에러가 있어 전송되지 못한  패킷 수. 누적값 
    */
    public void setOutErrorsSum(float outErrorsSum)
    {
        this.outErrorsSum = outErrorsSum;
    }

    /**
    * Returns the outErrorsSum.
    * @return float 패킷에 에러가 있어 전송되지 못한  패킷 수. 누적값
    */
    public float getOutErrorsSum()
    {
        return this.outErrorsSum;
    }

    /**
    * Sets the outUcastPktsAvg attribute.
    * @param outUcastPktsAvg float 상위 계층 프로토콜의 요구로 전달한  유니캐스트 패킷의 수 (버려지거나 보내지지않은 패킷 포함) . 평균값 
    */
    public void setOutUcastPktsAvg(float outUcastPktsAvg)
    {
        this.outUcastPktsAvg = outUcastPktsAvg;
    }

    /**
    * Returns the outUcastPktsAvg.
    * @return float 상위 계층 프로토콜의 요구로 전달한  유니캐스트 패킷의 수 (버려지거나 보내지지않은 패킷 포함) . 평균값
    */
    public float getOutUcastPktsAvg()
    {
        return this.outUcastPktsAvg;
    }

    /**
    * Sets the outUcastPktsMax attribute.
    * @param outUcastPktsMax float 상위 계층 프로토콜의 요구로 전달한  유니캐스트 패킷의 수 (버려지거나 보내지지않은 패킷 포함) . 최대값 
    */
    public void setOutUcastPktsMax(float outUcastPktsMax)
    {
        this.outUcastPktsMax = outUcastPktsMax;
    }

    /**
    * Returns the outUcastPktsMax.
    * @return float 상위 계층 프로토콜의 요구로 전달한  유니캐스트 패킷의 수 (버려지거나 보내지지않은 패킷 포함) . 최대값
    */
    public float getOutUcastPktsMax()
    {
        return this.outUcastPktsMax;
    }

    /**
    * Sets the outUcastPktsSum attribute.
    * @param outUcastPktsSum float 상위 계층 프로토콜의 요구로 전달한  유니캐스트 패킷의 수 (버려지거나 보내지지않은 패킷 포함) . 누적값 
    */
    public void setOutUcastPktsSum(float outUcastPktsSum)
    {
        this.outUcastPktsSum = outUcastPktsSum;
    }

    /**
    * Returns the outUcastPktsSum.
    * @return float 상위 계층 프로토콜의 요구로 전달한  유니캐스트 패킷의 수 (버려지거나 보내지지않은 패킷 포함) . 누적값
    */
    public float getOutUcastPktsSum()
    {
        return this.outUcastPktsSum;
    }

    /**
    * Sets the outNucastPktsAvg attribute.
    * @param outNucastPktsAvg float 상위 계층 프로토콜의 요구로 전달한 유니캐스트가 아닌  패킷의 수  (버려지거나 보내지지않은 패킷 포함) . 평균값 
    */
    public void setOutNucastPktsAvg(float outNucastPktsAvg)
    {
        this.outNucastPktsAvg = outNucastPktsAvg;
    }

    /**
    * Returns the outNucastPktsAvg.
    * @return float 상위 계층 프로토콜의 요구로 전달한 유니캐스트가 아닌  패킷의 수  (버려지거나 보내지지않은 패킷 포함) . 평균값
    */
    public float getOutNucastPktsAvg()
    {
        return this.outNucastPktsAvg;
    }

    /**
    * Sets the outNucastPktsMax attribute.
    * @param outNucastPktsMax float 상위 계층 프로토콜의 요구로 전달한 유니캐스트가 아닌  패킷의 수  (버려지거나 보내지지않은 패킷 포함) . 최대값 
    */
    public void setOutNucastPktsMax(float outNucastPktsMax)
    {
        this.outNucastPktsMax = outNucastPktsMax;
    }

    /**
    * Returns the outNucastPktsMax.
    * @return float 상위 계층 프로토콜의 요구로 전달한 유니캐스트가 아닌  패킷의 수  (버려지거나 보내지지않은 패킷 포함) . 최대값
    */
    public float getOutNucastPktsMax()
    {
        return this.outNucastPktsMax;
    }

    /**
    * Sets the outNucastPktsSum attribute.
    * @param outNucastPktsSum float 상위 계층 프로토콜의 요구로 전달한 유니캐스트가 아닌  패킷의 수  (버려지거나 보내지지않은 패킷 포함) . 누적값 
    */
    public void setOutNucastPktsSum(float outNucastPktsSum)
    {
        this.outNucastPktsSum = outNucastPktsSum;
    }

    /**
    * Returns the outNucastPktsSum.
    * @return float 상위 계층 프로토콜의 요구로 전달한 유니캐스트가 아닌  패킷의 수  (버려지거나 보내지지않은 패킷 포함) . 누적값
    */
    public float getOutNucastPktsSum()
    {
        return this.outNucastPktsSum;
    }

    /**
    * Sets the outMulticastPktsAvg attribute.
    * @param outMulticastPktsAvg float 상위 계층 포로토콜의 요구로 전달한 멀티캐스트 패킷의 수 (버려지거나 보내지지않은 패킷 포함) . 평균값 
    */
    public void setOutMulticastPktsAvg(float outMulticastPktsAvg)
    {
        this.outMulticastPktsAvg = outMulticastPktsAvg;
    }

    /**
    * Returns the outMulticastPktsAvg.
    * @return float 상위 계층 포로토콜의 요구로 전달한 멀티캐스트 패킷의 수 (버려지거나 보내지지않은 패킷 포함) . 평균값
    */
    public float getOutMulticastPktsAvg()
    {
        return this.outMulticastPktsAvg;
    }

    /**
    * Sets the outMulticastPktsMax attribute.
    * @param outMulticastPktsMax float 상위 계층 포로토콜의 요구로 전달한 멀티캐스트 패킷의 수 (버려지거나 보내지지않은 패킷 포함) . 최대값 
    */
    public void setOutMulticastPktsMax(float outMulticastPktsMax)
    {
        this.outMulticastPktsMax = outMulticastPktsMax;
    }

    /**
    * Returns the outMulticastPktsMax.
    * @return float 상위 계층 포로토콜의 요구로 전달한 멀티캐스트 패킷의 수 (버려지거나 보내지지않은 패킷 포함) . 최대값
    */
    public float getOutMulticastPktsMax()
    {
        return this.outMulticastPktsMax;
    }

    /**
    * Sets the outMulticastPktsSum attribute.
    * @param outMulticastPktsSum float 상위 계층 포로토콜의 요구로 전달한 멀티캐스트 패킷의 수 (버려지거나 보내지지않은 패킷 포함) . 누적값 
    */
    public void setOutMulticastPktsSum(float outMulticastPktsSum)
    {
        this.outMulticastPktsSum = outMulticastPktsSum;
    }

    /**
    * Returns the outMulticastPktsSum.
    * @return float 상위 계층 포로토콜의 요구로 전달한 멀티캐스트 패킷의 수 (버려지거나 보내지지않은 패킷 포함) . 누적값
    */
    public float getOutMulticastPktsSum()
    {
        return this.outMulticastPktsSum;
    }

    /**
    * Sets the outBroadcastPktsAvg attribute.
    * @param outBroadcastPktsAvg float 상위 계층 포로토콜의 요구로 전달한  브로드캐스트 패킷의  수 (버려지거나 보내지지않은 패킷 포함) . 평균값 
    */
    public void setOutBroadcastPktsAvg(float outBroadcastPktsAvg)
    {
        this.outBroadcastPktsAvg = outBroadcastPktsAvg;
    }

    /**
    * Returns the outBroadcastPktsAvg.
    * @return float 상위 계층 포로토콜의 요구로 전달한  브로드캐스트 패킷의  수 (버려지거나 보내지지않은 패킷 포함) . 평균값
    */
    public float getOutBroadcastPktsAvg()
    {
        return this.outBroadcastPktsAvg;
    }

    /**
    * Sets the outBroadcastPktsMax attribute.
    * @param outBroadcastPktsMax float 상위 계층 포로토콜의 요구로 전달한  브로드캐스트 패킷의  수 (버려지거나 보내지지않은 패킷 포함) . 최대값 
    */
    public void setOutBroadcastPktsMax(float outBroadcastPktsMax)
    {
        this.outBroadcastPktsMax = outBroadcastPktsMax;
    }

    /**
    * Returns the outBroadcastPktsMax.
    * @return float 상위 계층 포로토콜의 요구로 전달한  브로드캐스트 패킷의  수 (버려지거나 보내지지않은 패킷 포함) . 최대값
    */
    public float getOutBroadcastPktsMax()
    {
        return this.outBroadcastPktsMax;
    }

    /**
    * Sets the outBroadcastPktsSum attribute.
    * @param outBroadcastPktsSum float 상위 계층 포로토콜의 요구로 전달한  브로드캐스트 패킷의  수 (버려지거나 보내지지않은 패킷 포함) . 누적값 
    */
    public void setOutBroadcastPktsSum(float outBroadcastPktsSum)
    {
        this.outBroadcastPktsSum = outBroadcastPktsSum;
    }

    /**
    * Returns the outBroadcastPktsSum.
    * @return float 상위 계층 포로토콜의 요구로 전달한  브로드캐스트 패킷의  수 (버려지거나 보내지지않은 패킷 포함) . 누적값
    */
    public float getOutBroadcastPktsSum()
    {
        return this.outBroadcastPktsSum;
    }

    /**
    * Sets the outIfUsageRateAvg attribute.
    * @param outIfUsageRateAvg float 송신된 패킷 인터페이스  이용율. 평균값(5분단위) 
    */
    public void setOutIfUsageRateAvg(float outIfUsageRateAvg)
    {
        this.outIfUsageRateAvg = outIfUsageRateAvg;
    }

    /**
    * Returns the outIfUsageRateAvg.
    * @return float 송신된 패킷 인터페이스  이용율. 평균값(5분단위)
    */
    public float getOutIfUsageRateAvg()
    {
        return this.outIfUsageRateAvg;
    }

    /**
    * Sets the outIfUsageRateMax attribute.
    * @param outIfUsageRateMax float 송신된 패킷 인터페이스  이용율. 최대값 
    */
    public void setOutIfUsageRateMax(float outIfUsageRateMax)
    {
        this.outIfUsageRateMax = outIfUsageRateMax;
    }

    /**
    * Returns the outIfUsageRateMax.
    * @return float 송신된 패킷 인터페이스  이용율. 최대값
    */
    public float getOutIfUsageRateMax()
    {
        return this.outIfUsageRateMax;
    }

    /**
    * Sets the outBpsAvg attribute.
    * @param outBpsAvg float 송신된 평균 BPS(Bit Per Second) . 평균값 
    */
    public void setOutBpsAvg(float outBpsAvg)
    {
        this.outBpsAvg = outBpsAvg;
    }

    /**
    * Returns the outBpsAvg.
    * @return float 송신된 평균 BPS(Bit Per Second) . 평균값
    */
    public float getOutBpsAvg()
    {
        return this.outBpsAvg;
    }

    /**
    * Sets the outBpsMax attribute.
    * @param outBpsMax float 송신된 평균 BPS(Bit Per Second) . 최대값 
    */
    public void setOutBpsMax(float outBpsMax)
    {
        this.outBpsMax = outBpsMax;
    }

    /**
    * Returns the outBpsMax.
    * @return float 송신된 평균 BPS(Bit Per Second) . 최대값
    */
    public float getOutBpsMax()
    {
        return this.outBpsMax;
    }

    /**
    * Sets the outPpsAvg attribute.
    * @param outPpsAvg float 송신된 평균 PPS(Packet Per Second) . 평균값 
    */
    public void setOutPpsAvg(float outPpsAvg)
    {
        this.outPpsAvg = outPpsAvg;
    }

    /**
    * Returns the outPpsAvg.
    * @return float 송신된 평균 PPS(Packet Per Second) . 평균값
    */
    public float getOutPpsAvg()
    {
        return this.outPpsAvg;
    }

    /**
    * Sets the outPpsMax attribute.
    * @param outPpsMax float 송신된 평균 PPS(Packet Per Second) . 최대값 
    */
    public void setOutPpsMax(float outPpsMax)
    {
        this.outPpsMax = outPpsMax;
    }

    /**
    * Returns the outPpsMax.
    * @return float 송신된 평균 PPS(Packet Per Second) . 최대값
    */
    public float getOutPpsMax()
    {
        return this.outPpsMax;
    }

    /**
    * Sets the outVariationRateAvg attribute.
    * @param outVariationRateAvg float 송신된 패킷의 이전 주기값에 대한 평균 변동발생율. 평균값 
    */
    public void setOutVariationRateAvg(float outVariationRateAvg)
    {
        this.outVariationRateAvg = outVariationRateAvg;
    }

    /**
    * Returns the outVariationRateAvg.
    * @return float 송신된 패킷의 이전 주기값에 대한 평균 변동발생율. 평균값
    */
    public float getOutVariationRateAvg()
    {
        return this.outVariationRateAvg;
    }

    /**
    * Sets the outVariationRateMax attribute.
    * @param outVariationRateMax float 송신된 패킷의 이전 주기값에 대한 평균 변동발생율. 최대값 
    */
    public void setOutVariationRateMax(float outVariationRateMax)
    {
        this.outVariationRateMax = outVariationRateMax;
    }

    /**
    * Returns the outVariationRateMax.
    * @return float 송신된 패킷의 이전 주기값에 대한 평균 변동발생율. 최대값
    */
    public float getOutVariationRateMax()
    {
        return this.outVariationRateMax;
    }
}
