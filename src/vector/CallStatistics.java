package vector;

import java.sql.Timestamp;

public class CallStatistics 
{
	private String		equipmentID			= new String(); // equipmentID
	private Timestamp	colletionTime;						// colletionTime
	private String		emsID				= new String(); // emsID
	private String		adapterID			= new String(); // adapterID
	private int			callStatisticsType	= 0;			// callStatisticsType
	private int			measurementPoint	= 0;			// measurementPoint
	private String		measurementId		= "-1";		// MeasurementId // RouteNumber로 쓰인다.
	private String		headQuaterID		= new String(); // headQuaterID
	private String		officeID			= new String(); // officeID
	private String		routeID				= " ";			// routeID

	private int			attempt;							// attempt
	private int			int_att;							// int_att
	private int			oro_att;							// oro_att
	private int			ict_att;							// ict_att
	private int			trs_att;							// trs_att
	private int			fdgtrcv;							// fdgtrcv
	private int			seizure;							// seizure
	private int			int_szr;							// int_szr
	private int			oro_szr;							// oro_szr
	private int			ict_szr;							// ict_szr
	private int			trs_szr;							// trs_szr
	private int			drt_szr;							// drt_szr
	private int			art_szr;							// art_szr
	private int			ter_szr;							// ter_szr
	private int			sendcmp;							// sendcmp
	private int			alert;								// alert
	private int			int_alt;							// int_alt
	private int			oro_rng;							// oro_rng
	private int			ict_alt;							// ict_alt
	private int			trs_rng;							// trs_rng
	private int			ter_alt;							// ter_alt
	private int			answer;							// answer
	private int			int_ans;							// int_ans
	private int			oro_ans;							// oro_ans
	private int			ict_ans;							// ict_ans
	private int			trs_ans;							// trs_ans
	private int			ter_ans;							// ter_ans
	private int			featcode;							// featcode
	private int			suppsvc;							// suppsvc
	private float		f_ratio;							// f_ratio
	private float		ahdtime;							// ahdtime
	private float		traffic;							// traffic
	private int			callinh;							// callinh
	private int			fdgttout;							// fdgttout
	private int			idgttout;							// idgttout
	private int			wrg_pfx;							// wrg_pfx
	private int			wrg_tno;							// wrg_tno
	private int			inv_dgt;							// inv_dgt
	private int			sub_fail;							// sub_fail
	private int			cpa_fst;							// cpa_fst
	private int			cpa_pfx;							// cpa_pfx
	private int			cpa_eod;							// cpa_eod
	private int			next_no;							// next_no
	private int			org_rel;							// org_rel
	private int			trkcong;							// trkcong
	private int			net_blk;							// net_blk
	private int			ter_bar;							// ter_bar
	private int			ter_bsy;							// ter_bsy
	private int			ter_dna;							// ter_dna
	private int			ter_ooo;							// ter_ooo
	private int			ter_err;							// ter_err
	private int			ter_blk;							// ter_blk
	private int			no_ans;							// no_ans
	private int			sigtout;							// sigtout
	private int			ovrload;							// ovrload
	private int			mg_fail;							// mg_fail
	private int			pro_err;							// pro_err
	private int			dataerr;							// dataerr
	private int			etc_err;							// etc_err
	private int			comtout;							// comtout
	private int			net_mgm;							// net_mgm
	private int			ter_fss;							// ter_fss
	private int			trk_fail;							// trk_fail
	private int			trks_err;							// trks_err

	private int			trkoos;							// trkoos
	private int			rcv_spl;
	private int			splsucc;
	private int			rcv_mgc;
	private int			mgcsucc;
	private int			rcv_mvc;
	private int			mvcsucc;
	private int			rcv_mvl;
	private int			mvlsucc;
	private int			ianierr;
	private int			ianeerr;
	private int			splfail;
	private int			mgcfail;
	private int			mvcfail;
	private int			mvlfail;
	private int			crrfail;
	private int			rsfail;
    private double    abr = (double)0.0;
    private double    asr = (double)0.0;
	private String    tldnCode = "-1";

	/**
	 * @return the tldnCode
	 */
	public String getTldnCode()
	{
		return tldnCode;
	}

	/**
	 * @param tldnCode the tldnCode to set
	 */
	public void setTldnCode(String tldnCode)
	{
		this.tldnCode = tldnCode;
	}

	/**
	 * Sets the equipmentID attribute(equipmentID).
	 * 
	 * @param equipmentID
	 *            String
	 */
	public void setEquipmentID(String equipmentID)
	{
		this.equipmentID = equipmentID;
	}

	/**
	 * Returns the equipmentID(equipmentID).
	 * 
	 * @return String
	 */
	public String getEquipmentID()
	{
		return this.equipmentID;
	}

	/**
	 * Sets the RouteID attribute(RouteID).
	 * 
	 * @param RouteID
	 *            String
	 */
	public void setRouteID(String routeID)
	{
		this.routeID = routeID;
	}

	/**
	 * Returns the RouteID(RouteID).
	 * 
	 * @return String
	 */
	public String getRouteID()
	{
		return this.routeID;
	}

	/**
	 * Sets the colletionTime attribute(colletionTime).
	 * 
	 * @param colletionTime
	 *            Timestamp
	 */
	public void setCollectionTime(Timestamp colletionTime)
	{
		this.colletionTime = colletionTime;
	}

	/**
	 * Returns the colletionTime(colletionTime).
	 * 
	 * @return Timestamp
	 */
	public Timestamp getCollectionTime()
	{
		return this.colletionTime;
	}

	/**
	 * Sets the emsID attribute(emsID).
	 * 
	 * @param emsID
	 *            String
	 */
	public void setEmsID(String emsID)
	{
		this.emsID = emsID;
	}

	/**
	 * Returns the emsID(emsID).
	 * 
	 * @return String
	 */
	public String getEmsID()
	{
		return this.emsID;
	}

	/**
	 * Sets the adapterID attribute(adapterID).
	 * 
	 * @param adapterID
	 *            String
	 */
	public void setAdapterID(String adapterID)
	{
		this.adapterID = adapterID;
	}

	/**
	 * Returns the adapterID(adapterID).
	 * 
	 * @return String
	 */
	public String getAdapterID()
	{
		return this.adapterID;
	}

	/**
	 * Sets the callStatisticsType attribute(callStatisticsType).
	 * 
	 * @param callStatisticsType
	 *            int
	 */
	public void setCallStatisticsType(int callStatisticsType)
	{
		this.callStatisticsType = callStatisticsType;
	}

	/**
	 * Returns the callStatisticsType(callStatisticsType).
	 * 
	 * @return int
	 */
	public int getCallStatisticsType()
	{
		return this.callStatisticsType;
	}

	/**
	 * Sets the measurementPoint attribute(measurementPoint).
	 * 
	 * @param measurementPoint
	 *            int
	 */
	public void setMeasurementPoint(int measurementPoint)
	{
		this.measurementPoint = measurementPoint;
	}

	/**
	 * Returns the measurementPoint(measurementPoint).
	 * 
	 * @return int
	 */
	public int getMeasurementPoint()
	{
		return this.measurementPoint;
	}

	/**
	 * Sets the headQuaterID attribute(headQuaterID).
	 * 
	 * @param headQuaterID
	 *            String
	 */
	public void setHeadQuaterID(String headQuaterID)
	{
		this.headQuaterID = headQuaterID;
	}

	/**
	 * Returns the headQuaterID(headQuaterID).
	 * 
	 * @return String
	 */
	public String getHeadQuaterID()
	{
		return this.headQuaterID;
	}

	/**
	 * Sets the officeID attribute(officeID).
	 * 
	 * @param officeID
	 *            String
	 */
	public void setOfficeID(String officeID)
	{
		this.officeID = officeID;
	}

	/**
	 * Returns the officeID(officeID).
	 * 
	 * @return String
	 */
	public String getOfficeID()
	{
		return this.officeID;
	}

	/**
	 * Sets the attempt attribute(attempt).
	 * 
	 * @param attempt
	 *            int
	 */
	public void setAttempt(int attempt)
	{
		this.attempt = attempt;
	}

	/**
	 * Returns the attempt(attempt).
	 * 
	 * @return int
	 */
	public int getAttempt()
	{
		return this.attempt;
	}

	/**
	 * Sets the int_att attribute(int_att).
	 * 
	 * @param int_att
	 *            int
	 */
	public void setIntAtt(int int_att)
	{
		this.int_att = int_att;
	}

	/**
	 * Returns the int_att(int_att).
	 * 
	 * @return int
	 */
	public int getIntAtt()
	{
		return this.int_att;
	}

	/**
	 * Sets the oro_att attribute(oro_att).
	 * 
	 * @param oro_att
	 *            int
	 */
	public void setOroAtt(int oro_att)
	{
		this.oro_att = oro_att;
	}

	/**
	 * Returns the oro_att(oro_att).
	 * 
	 * @return int
	 */
	public int getOroAtt()
	{
		return this.oro_att;
	}

	/**
	 * Sets the ict_att attribute(ict_att).
	 * 
	 * @param ict_att
	 *            int
	 */
	public void setIctAtt(int ict_att)
	{
		this.ict_att = ict_att;
	}

	/**
	 * Returns the ict_att(ict_att).
	 * 
	 * @return int
	 */
	public int getIctAtt()
	{
		return this.ict_att;
	}

	/**
	 * Sets the trs_att attribute(trs_att).
	 * 
	 * @param trs_att
	 *            int
	 */
	public void setTrsAtt(int trs_att)
	{
		this.trs_att = trs_att;
	}

	/**
	 * Returns the trs_att(trs_att).
	 * 
	 * @return int
	 */
	public int getTrsAtt()
	{
		return this.trs_att;
	}

	/**
	 * Sets the fdgtrcv attribute(fdgtrcv).
	 * 
	 * @param fdgtrcv
	 *            int
	 */
	public void setFdgtrcv(int fdgtrcv)
	{
		this.fdgtrcv = fdgtrcv;
	}

	/**
	 * Returns the fdgtrcv(fdgtrcv).
	 * 
	 * @return int
	 */
	public int getFdgtrcv()
	{
		return this.fdgtrcv;
	}

	/**
	 * Sets the seizure attribute(seizure).
	 * 
	 * @param seizure
	 *            int
	 */
	public void setSeizure(int seizure)
	{
		this.seizure = seizure;
	}

	/**
	 * Returns the seizure(seizure).
	 * 
	 * @return int
	 */
	public int getSeizure()
	{
		if(seizure > 0)
		{
			return this.seizure;
		}

		seizure = int_szr + oro_szr + ict_szr + trs_szr + drt_szr + art_szr + ter_szr;

		return seizure;
	}

	/**
	 * Sets the int_szr attribute(int_szr).
	 * 
	 * @param int_szr
	 *            int
	 */
	public void setIntSzr(int int_szr)
	{
		this.int_szr = int_szr;
	}

	/**
	 * Returns the int_szr(int_szr).
	 * 
	 * @return int
	 */
	public int getIntSzr()
	{
		return this.int_szr;
	}

	/**
	 * Sets the oro_szr attribute(oro_szr).
	 * 
	 * @param oro_szr
	 *            int
	 */
	public void setOroSzr(int oro_szr)
	{
		this.oro_szr = oro_szr;
	}

	/**
	 * Returns the oro_szr(oro_szr).
	 * 
	 * @return int
	 */
	public int getOroSzr()
	{
		return this.oro_szr;
	}

	/**
	 * Sets the ict_szr attribute(ict_szr).
	 * 
	 * @param ict_szr
	 *            int
	 */
	public void setIctSzr(int ict_szr)
	{
		this.ict_szr = ict_szr;
	}

	/**
	 * Returns the ict_szr(ict_szr).
	 * 
	 * @return int
	 */
	public int getIctSzr()
	{
		return this.ict_szr;
	}

	/**
	 * Sets the trs_szr attribute(trs_szr).
	 * 
	 * @param trs_szr
	 *            int
	 */
	public void setTrsSzr(int trs_szr)
	{
		this.trs_szr = trs_szr;
	}

	/**
	 * Returns the trs_szr(trs_szr).
	 * 
	 * @return int
	 */
	public int getTrsSzr()
	{
		return this.trs_szr;
	}

	/**
	 * Sets the drt_szr attribute(drt_szr).
	 * 
	 * @param drt_szr
	 *            int
	 */
	public void setDrtSzr(int drt_szr)
	{
		this.drt_szr = drt_szr;
	}

	/**
	 * Returns the drt_szr(drt_szr).
	 * 
	 * @return int
	 */
	public int getDrtSzr()
	{
		return this.drt_szr;
	}

	/**
	 * Sets the art_szr attribute(art_szr).
	 * 
	 * @param art_szr
	 *            int
	 */
	public void setArtSzr(int art_szr)
	{
		this.art_szr = art_szr;
	}

	/**
	 * Returns the art_szr(art_szr).
	 * 
	 * @return int
	 */
	public int getArtSzr()
	{
		return this.art_szr;
	}

	/**
	 * Sets the ter_szr attribute(ter_szr).
	 * 
	 * @param ter_szr
	 *            int
	 */
	public void setTerSzr(int ter_szr)
	{
		this.ter_szr = ter_szr;
	}

	/**
	 * Returns the ter_szr(ter_szr).
	 * 
	 * @return int
	 */
	public int getTerSzr()
	{
		return this.ter_szr;
	}

	/**
	 * Sets the sendcmp attribute(sendcmp).
	 * 
	 * @param sendcmp
	 *            int
	 */
	public void setSendcmp(int sendcmp)
	{
		this.sendcmp = sendcmp;
	}

	/**
	 * Returns the sendcmp(sendcmp).
	 * 
	 * @return int
	 */
	public int getSendcmp()
	{
		return this.sendcmp;
	}

	/**
	 * Sets the alert attribute(alert).
	 * 
	 * @param alert
	 *            int
	 */
	public void setAlert(int alert)
	{
		this.alert = alert;
	}

	/**
	 * Returns the alert(alert).
	 * 
	 * @return int
	 */
	public int getAlert()
	{
		return this.alert;
	}

	/**
	 * Sets the int_alt attribute(int_alt).
	 * 
	 * @param int_alt
	 *            int
	 */
	public void setIntAlt(int int_alt)
	{
		this.int_alt = int_alt;
	}

	/**
	 * Returns the int_alt(int_alt).
	 * 
	 * @return int
	 */
	public int getIntAlt()
	{
		return this.int_alt;
	}

	/**
	 * Sets the oro_rng attribute(oro_rng).
	 * 
	 * @param oro_rng
	 *            int
	 */
	public void setOroRng(int oro_rng)
	{
		this.oro_rng = oro_rng;
	}

	/**
	 * Returns the oro_rng(oro_rng).
	 * 
	 * @return int
	 */
	public int getOroRng()
	{
		return this.oro_rng;
	}

	/**
	 * Sets the ict_alt attribute(ict_alt).
	 * 
	 * @param ict_alt
	 *            int
	 */
	public void setIctAlt(int ict_alt)
	{
		this.ict_alt = ict_alt;
	}

	/**
	 * Returns the ict_alt(ict_alt).
	 * 
	 * @return int
	 */
	public int getIctAlt()
	{
		return this.ict_alt;
	}

	/**
	 * Sets the trs_rng attribute(trs_rng).
	 * 
	 * @param trs_rng
	 *            int
	 */
	public void setTrsRng(int trs_rng)
	{
		this.trs_rng = trs_rng;
	}

	/**
	 * Returns the trs_rng(trs_rng).
	 * 
	 * @return int
	 */
	public int getTrsRng()
	{
		return this.trs_rng;
	}

	/**
	 * Sets the ter_alt attribute(ter_alt).
	 * 
	 * @param ter_alt
	 *            int
	 */
	public void setTerAlt(int ter_alt)
	{
		this.ter_alt = ter_alt;
	}

	/**
	 * Returns the ter_alt(ter_alt).
	 * 
	 * @return int
	 */
	public int getTerAlt()
	{
		return this.ter_alt;
	}

	/**
	 * Sets the answer attribute(answer).
	 * 
	 * @param answer
	 *            int
	 */
	public void setAnswer(int answer)
	{
		this.answer = answer;
	}

	/**
	 * Returns the answer(answer).
	 * 
	 * @return int
	 */
	public int getAnswer()
	{
		if(answer > 0)
		{
			return this.answer;
		}

		answer = int_ans + oro_ans + ict_ans + trs_ans + ter_ans;

		return answer;
	}

	/**
	 * Sets the int_ans attribute(int_ans).
	 * 
	 * @param int_ans
	 *            int
	 */
	public void setIntAns(int int_ans)
	{
		this.int_ans = int_ans;
	}

	/**
	 * Returns the int_ans(int_ans).
	 * 
	 * @return int
	 */
	public int getIntAns()
	{
		return this.int_ans;
	}

	/**
	 * Sets the oro_ans attribute(oro_ans).
	 * 
	 * @param oro_ans
	 *            int
	 */
	public void setOroAns(int oro_ans)
	{
		this.oro_ans = oro_ans;
	}

	/**
	 * Returns the oro_ans(oro_ans).
	 * 
	 * @return int
	 */
	public int getOroAns()
	{
		return this.oro_ans;
	}

	/**
	 * Sets the ict_ans attribute(ict_ans).
	 * 
	 * @param ict_ans
	 *            int
	 */
	public void setIctAns(int ict_ans)
	{
		this.ict_ans = ict_ans;
	}

	/**
	 * Returns the ict_ans(ict_ans).
	 * 
	 * @return int
	 */
	public int getIctAns()
	{
		return this.ict_ans;
	}

	/**
	 * Sets the trs_ans attribute(trs_ans).
	 * 
	 * @param trs_ans
	 *            int
	 */
	public void setTrsAns(int trs_ans)
	{
		this.trs_ans = trs_ans;
	}

	/**
	 * Returns the trs_ans(trs_ans).
	 * 
	 * @return int
	 */
	public int getTrsAns()
	{
		return this.trs_ans;
	}

	/**
	 * Sets the ter_ans attribute(ter_ans).
	 * 
	 * @param ter_ans
	 *            int
	 */
	public void setTerAns(int ter_ans)
	{
		this.ter_ans = ter_ans;
	}

	/**
	 * Returns the ter_ans(ter_ans).
	 * 
	 * @return int
	 */
	public int getTerAns()
	{
		return this.ter_ans;
	}

	/**
	 * Sets the featcode attribute(featcode).
	 * 
	 * @param featcode
	 *            int
	 */
	public void setFeatcode(int featcode)
	{
		this.featcode = featcode;
	}

	/**
	 * Returns the featcode(featcode).
	 * 
	 * @return int
	 */
	public int getFeatcode()
	{
		return this.featcode;
	}

	/**
	 * Sets the suppsvc attribute(suppsvc).
	 * 
	 * @param suppsvc
	 *            int
	 */
	public void setSuppsvc(int suppsvc)
	{
		this.suppsvc = suppsvc;
	}

	/**
	 * Returns the suppsvc(suppsvc).
	 * 
	 * @return int
	 */
	public int getSuppsvc()
	{
		return this.suppsvc;
	}

	/**
	 * Sets the f_ratio attribute(f_ratio).
	 * 
	 * @param f_ratio
	 *            double
	 */
	public void setFRatio(float f_ratio)
	{
		this.f_ratio = f_ratio;
	}

	/**
	 * Returns the f_ratio(f_ratio).
	 * 
	 * @return double
	 */
	public float getFRatio()
	{
		return this.f_ratio;
	}

	/**
	 * Sets the ahdtime attribute(ahdtime).
	 * 
	 * @param ahdtime
	 *            int
	 */
	public void setAhdtime(float ahdtime)
	{
		this.ahdtime = ahdtime;
	}

	/**
	 * Returns the ahdtime(ahdtime).
	 * 
	 * @return int
	 */
	public float getAhdtime()
	{
		return this.ahdtime;
	}

	/**
	 * Sets the traffic attribute(traffic).
	 * 
	 * @param traffic
	 *            int
	 */
	public void setTraffic(float traffic)
	{
		this.traffic = traffic;
	}

	/**
	 * Returns the traffic(traffic).
	 * 
	 * @return int
	 */
	public float getTraffic()
	{
		return this.traffic;
	}

	/**
	 * Sets the callinh attribute(callinh).
	 * 
	 * @param callinh
	 *            int
	 */
	public void setCallinh(int callinh)
	{
		this.callinh = callinh;
	}

	/**
	 * Returns the callinh(callinh).
	 * 
	 * @return int
	 */
	public int getCallinh()
	{
		return this.callinh;
	}

	/**
	 * Sets the fdgttout attribute(fdgttout).
	 * 
	 * @param fdgttout
	 *            int
	 */
	public void setFdgttout(int fdgttout)
	{
		this.fdgttout = fdgttout;
	}

	/**
	 * Returns the fdgttout(fdgttout).
	 * 
	 * @return int
	 */
	public int getFdgttout()
	{
		return this.fdgttout;
	}

	/**
	 * Sets the idgttout attribute(idgttout).
	 * 
	 * @param idgttout
	 *            int
	 */
	public void setIdgttout(int idgttout)
	{
		this.idgttout = idgttout;
	}

	/**
	 * Returns the idgttout(idgttout).
	 * 
	 * @return int
	 */
	public int getIdgttout()
	{
		return this.idgttout;
	}

	/**
	 * Sets the wrg_pfx attribute(wrg_pfx).
	 * 
	 * @param wrg_pfx
	 *            int
	 */
	public void setWrgPfx(int wrg_pfx)
	{
		this.wrg_pfx = wrg_pfx;
	}

	/**
	 * Returns the wrg_pfx(wrg_pfx).
	 * 
	 * @return int
	 */
	public int getWrgPfx()
	{
		return this.wrg_pfx;
	}

	/**
	 * Sets the wrg_tno attribute(wrg_tno).
	 * 
	 * @param wrg_tno
	 *            int
	 */
	public void setWrgTno(int wrg_tno)
	{
		this.wrg_tno = wrg_tno;
	}

	/**
	 * Returns the wrg_tno(wrg_tno).
	 * 
	 * @return int
	 */
	public int getWrgTno()
	{
		return this.wrg_tno;
	}

	/**
	 * Sets the inv_dgt attribute(inv_dgt).
	 * 
	 * @param inv_dgt
	 *            int
	 */
	public void setInvDgt(int inv_dgt)
	{
		this.inv_dgt = inv_dgt;
	}

	/**
	 * Returns the inv_dgt(inv_dgt).
	 * 
	 * @return int
	 */
	public int getInvDgt()
	{
		return this.inv_dgt;
	}

	/**
	 * Sets the sub_fail attribute(sub_fail).
	 * 
	 * @param sub_fail
	 *            int
	 */
	public void setSubFail(int sub_fail)
	{
		this.sub_fail = sub_fail;
	}

	/**
	 * Returns the sub_fail(sub_fail).
	 * 
	 * @return int
	 */
	public int getSubFail()
	{
		return this.sub_fail;
	}

	/**
	 * Sets the cpa_fst attribute(cpa_fst).
	 * 
	 * @param cpa_fst
	 *            int
	 */
	public void setCpaFst(int cpa_fst)
	{
		this.cpa_fst = cpa_fst;
	}

	/**
	 * Returns the cpa_fst(cpa_fst).
	 * 
	 * @return int
	 */
	public int getCpaFst()
	{
		return this.cpa_fst;
	}

	/**
	 * Sets the cpa_pfx attribute(cpa_pfx).
	 * 
	 * @param cpa_pfx
	 *            int
	 */
	public void setCpaPfx(int cpa_pfx)
	{
		this.cpa_pfx = cpa_pfx;
	}

	/**
	 * Returns the cpa_pfx(cpa_pfx).
	 * 
	 * @return int
	 */
	public int getCpaPfx()
	{
		return this.cpa_pfx;
	}

	/**
	 * Sets the cpa_eod attribute(cpa_eod).
	 * 
	 * @param cpa_eod
	 *            int
	 */
	public void setCpaEod(int cpa_eod)
	{
		this.cpa_eod = cpa_eod;
	}

	/**
	 * Returns the cpa_eod(cpa_eod).
	 * 
	 * @return int
	 */
	public int getCpaEod()
	{
		return this.cpa_eod;
	}

	/**
	 * Sets the relbans attribute(relbans).
	 * 
	 * @param relbans
	 *            int
	 */

	/**
	 * Sets the next_no attribute(next_no).
	 * 
	 * @param next_no
	 *            int
	 */
	public void setNextNo(int next_no)
	{
		this.next_no = next_no;
	}

	/**
	 * Returns the next_no(next_no).
	 * 
	 * @return int
	 */
	public int getNextNo()
	{
		return this.next_no;
	}

	/**
	 * Sets the org_rel attribute(org_rel).
	 * 
	 * @param org_rel
	 *            int
	 */
	public void setOrgRel(int org_rel)
	{
		this.org_rel = org_rel;
	}

	/**
	 * Returns the org_rel(org_rel).
	 * 
	 * @return int
	 */
	public int getOrgRel()
	{
		return this.org_rel;
	}

	/**
	 * Sets the trkcong attribute(trkcong).
	 * 
	 * @param trkcong
	 *            int
	 */
	public void setTrkcong(int trkcong)
	{
		this.trkcong = trkcong;
	}

	/**
	 * Returns the trkcong(trkcong).
	 * 
	 * @return int
	 */
	public int getTrkcong()
	{
		return this.trkcong;
	}

	/**
	 * Sets the net_blk attribute(net_blk).
	 * 
	 * @param net_blk
	 *            int
	 */
	public void setNetBlk(int net_blk)
	{
		this.net_blk = net_blk;
	}

	/**
	 * Returns the net_blk(net_blk).
	 * 
	 * @return int
	 */
	public int getNetBlk()
	{
		return this.net_blk;
	}

	/**
	 * Sets the ter_bar attribute(ter_bar).
	 * 
	 * @param ter_bar
	 *            int
	 */
	public void setTerBar(int ter_bar)
	{
		this.ter_bar = ter_bar;
	}

	/**
	 * Returns the ter_bar(ter_bar).
	 * 
	 * @return int
	 */
	public int getTerBar()
	{
		return this.ter_bar;
	}

	/**
	 * Sets the ter_bsy attribute(ter_bsy).
	 * 
	 * @param ter_bsy
	 *            int
	 */
	public void setTerBsy(int ter_bsy)
	{
		this.ter_bsy = ter_bsy;
	}

	/**
	 * Returns the ter_bsy(ter_bsy).
	 * 
	 * @return int
	 */
	public int getTerBsy()
	{
		return this.ter_bsy;
	}

	/**
	 * Sets the ter_dna attribute(ter_dna).
	 * 
	 * @param ter_dna
	 *            int
	 */
	public void setTerDna(int ter_dna)
	{
		this.ter_dna = ter_dna;
	}

	/**
	 * Returns the ter_dna(ter_dna).
	 * 
	 * @return int
	 */
	public int getTerDna()
	{
		return this.ter_dna;
	}

	/**
	 * Sets the ter_ooo attribute(ter_ooo).
	 * 
	 * @param ter_ooo
	 *            int
	 */
	public void setTerOoo(int ter_ooo)
	{
		this.ter_ooo = ter_ooo;
	}

	/**
	 * Returns the ter_ooo(ter_ooo).
	 * 
	 * @return int
	 */
	public int getTerOoo()
	{
		return this.ter_ooo;
	}

	/**
	 * Sets the ter_err attribute(ter_err).
	 * 
	 * @param ter_err
	 *            int
	 */
	public void setTerErr(int ter_err)
	{
		this.ter_err = ter_err;
	}

	/**
	 * Returns the ter_err(ter_err).
	 * 
	 * @return int
	 */
	public int getTerErr()
	{
		return this.ter_err;
	}

	/**
	 * Sets the ter_blk attribute(ter_blk).
	 * 
	 * @param ter_blk
	 *            int
	 */
	public void setTerBlk(int ter_blk)
	{
		this.ter_blk = ter_blk;
	}

	/**
	 * Returns the ter_blk(ter_blk).
	 * 
	 * @return int
	 */
	public int getTerBlk()
	{
		return this.ter_blk;
	}

	/**
	 * Sets the no_ans attribute(no_ans).
	 * 
	 * @param no_ans
	 *            int
	 */
	public void setNoAns(int no_ans)
	{
		this.no_ans = no_ans;
	}

	/**
	 * Returns the no_ans(no_ans).
	 * 
	 * @return int
	 */
	public int getNoAns()
	{
		return this.no_ans;
	}

	/**
	 * Sets the sigtout attribute(sigtout).
	 * 
	 * @param sigtout
	 *            int
	 */
	public void setSigtout(int sigtout)
	{
		this.sigtout = sigtout;
	}

	/**
	 * Returns the sigtout(sigtout).
	 * 
	 * @return int
	 */
	public int getSigtout()
	{
		return this.sigtout;
	}

	/**
	 * Sets the ovrload attribute(ovrload).
	 * 
	 * @param ovrload
	 *            int
	 */
	public void setOvrload(int ovrload)
	{
		this.ovrload = ovrload;
	}

	/**
	 * Returns the ovrload(ovrload).
	 * 
	 * @return int
	 */
	public int getOvrload()
	{
		return this.ovrload;
	}

	/**
	 * Sets the mg_fail attribute(mg_fail).
	 * 
	 * @param mg_fail
	 *            int
	 */
	public void setMgFail(int mg_fail)
	{
		this.mg_fail = mg_fail;
	}

	/**
	 * Returns the mg_fail(mg_fail).
	 * 
	 * @return int
	 */
	public int getMgFail()
	{
		return this.mg_fail;
	}

	/**
	 * Sets the pro_err attribute(pro_err).
	 * 
	 * @param pro_err
	 *            int
	 */
	public void setProErr(int pro_err)
	{
		this.pro_err = pro_err;
	}

	/**
	 * Returns the pro_err(pro_err).
	 * 
	 * @return int
	 */
	public int getProErr()
	{
		return this.pro_err;
	}

	/**
	 * Sets the dataerr attribute(dataerr).
	 * 
	 * @param dataerr
	 *            int
	 */
	public void setDataerr(int dataerr)
	{
		this.dataerr = dataerr;
	}

	/**
	 * Returns the dataerr(dataerr).
	 * 
	 * @return int
	 */
	public int getDataerr()
	{
		return this.dataerr;
	}

	/**
	 * Sets the etc_err attribute(etc_err).
	 * 
	 * @param etc_err
	 *            int
	 */
	public void setEtcErr(int etc_err)
	{
		this.etc_err = etc_err;
	}

	/**
	 * Returns the etc_err(etc_err).
	 * 
	 * @return int
	 */
	public int getEtcErr()
	{
		return this.etc_err;
	}

	/**
	 * Sets the comtout attribute(comtout).
	 * 
	 * @param comtout
	 *            int
	 */
	public void setComtout(int comtout)
	{
		this.comtout = comtout;
	}

	/**
	 * Returns the comtout(comtout).
	 * 
	 * @return int
	 */
	public int getComtout()
	{
		return this.comtout;
	}

	/**
	 * Sets the net_mgm attribute(net_mgm).
	 * 
	 * @param net_mgm
	 *            int
	 */
	public void setNetMgm(int net_mgm)
	{
		this.net_mgm = net_mgm;
	}

	/**
	 * Returns the net_mgm(net_mgm).
	 * 
	 * @return int
	 */
	public int getNetMgm()
	{
		return this.net_mgm;
	}

	/**
	 * Sets the ter_fss attribute(ter_fss).
	 * 
	 * @param ter_fss
	 *            int
	 */
	public void setTerFss(int ter_fss)
	{
		this.ter_fss = ter_fss;
	}

	/**
	 * Returns the ter_fss(ter_fss).
	 * 
	 * @return int
	 */
	public int getTerFss()
	{
		return this.ter_fss;
	}

	/**
	 * Sets the trk_fail attribute(trk_fail).
	 * 
	 * @param trk_fail
	 *            int
	 */
	public void setTrkFail(int trk_fail)
	{
		this.trk_fail = trk_fail;
	}

	/**
	 * Returns the trk_fail(trk_fail).
	 * 
	 * @return int
	 */
	public int getTrkFail()
	{
		return this.trk_fail;
	}

	/**
	 * Sets the trks_err attribute(trks_err).
	 * 
	 * @param trks_err
	 *            int
	 */
	public void setTrksErr(int trks_err)
	{
		this.trks_err = trks_err;
	}

	/**
	 * Returns the trks_err(trks_err).
	 * 
	 * @return int
	 */
	public int getTrksErr()
	{
		return this.trks_err;
	}

	/**
	 * Returns the String Value of this Object.
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer buf = new StringBuffer();
		buf.append("equipmentID         : " + equipmentID + "\n");
		buf.append("routeID             : " + routeID + "\n");
		buf.append("colletionTime       : " + colletionTime + "\n");
		buf.append("emsID               : " + emsID + "\n");
		buf.append("adapterID           : " + adapterID + "\n");
		buf.append("callStatisticsType  : " + callStatisticsType + "\n");
		buf.append("measurementPoint    : " + measurementPoint + "\n");
		buf.append("headQuaterID        : " + headQuaterID + "\n");
		buf.append("officeID            : " + officeID + "\n");
		buf.append("attempt             : " + attempt + "\n");
		buf.append("int_att             : " + int_att + "\n");
		buf.append("oro_att             : " + oro_att + "\n");
		buf.append("ict_att             : " + ict_att + "\n");
		buf.append("trs_att             : " + trs_att + "\n");
		buf.append("fdgtrcv             : " + fdgtrcv + "\n");
		buf.append("seizure             : " + seizure + "\n");
		buf.append("int_szr             : " + int_szr + "\n");
		buf.append("oro_szr             : " + oro_szr + "\n");
		buf.append("ict_szr             : " + ict_szr + "\n");
		buf.append("trs_szr             : " + trs_szr + "\n");
		buf.append("drt_szr             : " + drt_szr + "\n");
		buf.append("art_szr             : " + art_szr + "\n");
		buf.append("ter_szr             : " + ter_szr + "\n");
		buf.append("sendcmp             : " + sendcmp + "\n");
		buf.append("alert               : " + alert + "\n");
		buf.append("int_alt             : " + int_alt + "\n");
		buf.append("oro_rng             : " + oro_rng + "\n");
		buf.append("ict_alt             : " + ict_alt + "\n");
		buf.append("trs_rng             : " + trs_rng + "\n");
		buf.append("ter_alt             : " + ter_alt + "\n");
		buf.append("answer              : " + answer + "\n");
		buf.append("int_ans             : " + int_ans + "\n");
		buf.append("oro_ans             : " + oro_ans + "\n");
		buf.append("ict_ans             : " + ict_ans + "\n");
		buf.append("trs_ans             : " + trs_ans + "\n");
		buf.append("ter_ans             : " + ter_ans + "\n");
		buf.append("featcode            : " + featcode + "\n");
		buf.append("suppsvc             : " + suppsvc + "\n");
		buf.append("f_ratio             : " + f_ratio + "\n");
		buf.append("ahdtime             : " + ahdtime + "\n");
		buf.append("traffic             : " + traffic + "\n");
		buf.append("callinh             : " + callinh + "\n");
		buf.append("fdgttout            : " + fdgttout + "\n");
		buf.append("idgttout            : " + idgttout + "\n");
		buf.append("wrg_pfx             : " + wrg_pfx + "\n");
		buf.append("wrg_tno             : " + wrg_tno + "\n");
		buf.append("inv_dgt             : " + inv_dgt + "\n");
		buf.append("sub_fail            : " + sub_fail + "\n");
		buf.append("cpa_fst             : " + cpa_fst + "\n");
		buf.append("cpa_pfx             : " + cpa_pfx + "\n");
		buf.append("cpa_eod             : " + cpa_eod + "\n");
		buf.append("relbans             : " + org_rel + "\n");
		buf.append("next_no             : " + next_no + "\n");
		buf.append("org_rel             : " + org_rel + "\n");
		buf.append("trkcong             : " + trkcong + "\n");
		buf.append("net_blk             : " + net_blk + "\n");
		buf.append("ter_bar             : " + ter_bar + "\n");
		buf.append("ter_bsy             : " + ter_bsy + "\n");
		buf.append("ter_dna             : " + ter_dna + "\n");
		buf.append("ter_ooo             : " + ter_ooo + "\n");
		buf.append("ter_err             : " + ter_err + "\n");
		buf.append("ter_blk             : " + ter_blk + "\n");
		buf.append("no_ans              : " + no_ans + "\n");
		buf.append("sigtout             : " + sigtout + "\n");
		buf.append("ovrload             : " + ovrload + "\n");
		buf.append("mg_fail             : " + mg_fail + "\n");
		buf.append("pro_err             : " + pro_err + "\n");
		buf.append("dataerr             : " + dataerr + "\n");
		buf.append("etc_err             : " + etc_err + "\n");
		buf.append("comtout             : " + comtout + "\n");
		buf.append("net_mgm             : " + net_mgm + "\n");
		buf.append("ter_fss             : " + ter_fss + "\n");
		buf.append("trk_fail            : " + trk_fail + "\n");
		buf.append("trks_err            : " + trks_err);
		return buf.toString();
	}

	/**
	 * @return
	 */
	public String getMeasurementId()
	{
		return measurementId;
	}

	/**
	 * @param string
	 */
	public void setMeasurementId(String string)
	{
		measurementId = string;
	}

	/**
	 * @return Returns the crrfail.
	 */
	public int getCrrfail()
	{
		return crrfail;
	}

	/**
	 * @param crrfail
	 *            The crrfail to set.
	 */
	public void setCrrfail(int crrfail)
	{
		this.crrfail = crrfail;
	}

	/**
	 * @return Returns the ianeerr.
	 */
	public int getIaneerr()
	{
		return ianeerr;
	}

	/**
	 * @param ianeerr
	 *            The ianeerr to set.
	 */
	public void setIaneerr(int ianeerr)
	{
		this.ianeerr = ianeerr;
	}

	/**
	 * @return Returns the ianierr.
	 */
	public int getIanierr()
	{
		return ianierr;
	}

	/**
	 * @param ianierr
	 *            The ianierr to set.
	 */
	public void setIanierr(int ianierr)
	{
		this.ianierr = ianierr;
	}

	/**
	 * @return Returns the mgcfail.
	 */
	public int getMgcfail()
	{
		return mgcfail;
	}

	/**
	 * @param mgcfail
	 *            The mgcfail to set.
	 */
	public void setMgcfail(int mgcfail)
	{
		this.mgcfail = mgcfail;
	}

	/**
	 * @return Returns the mgcsucc.
	 */
	public int getMgcsucc()
	{
		return mgcsucc;
	}

	/**
	 * @param mgcsucc
	 *            The mgcsucc to set.
	 */
	public void setMgcsucc(int mgcsucc)
	{
		this.mgcsucc = mgcsucc;
	}

	/**
	 * @return Returns the mvcfail.
	 */
	public int getMvcfail()
	{
		return mvcfail;
	}

	/**
	 * @param mvcfail
	 *            The mvcfail to set.
	 */
	public void setMvcfail(int mvcfail)
	{
		this.mvcfail = mvcfail;
	}

	/**
	 * @return Returns the mvcsucc.
	 */
	public int getMvcsucc()
	{
		return mvcsucc;
	}

	/**
	 * @param mvcsucc
	 *            The mvcsucc to set.
	 */
	public void setMvcsucc(int mvcsucc)
	{
		this.mvcsucc = mvcsucc;
	}

	/**
	 * @return Returns the mvlfail.
	 */
	public int getMvlfail()
	{
		return mvlfail;
	}

	/**
	 * @param mvlfail
	 *            The mvlfail to set.
	 */
	public void setMvlfail(int mvlfail)
	{
		this.mvlfail = mvlfail;
	}

	/**
	 * @return Returns the rcv_mgc.
	 */
	public int getRcvmgc()
	{
		return rcv_mgc;
	}

	/**
	 * @param rcv_mgc
	 *            The rcv_mgc to set.
	 */
	public void setRcvmgc(int rcv_mgc)
	{
		this.rcv_mgc = rcv_mgc;
	}

	/**
	 * @return Returns the rcv_mvc.
	 */
	public int getRcvmvc()
	{
		return rcv_mvc;
	}

	/**
	 * @param rcv_mvc
	 *            The rcv_mvc to set.
	 */
	public void setRcvmvc(int rcv_mvc)
	{
		this.rcv_mvc = rcv_mvc;
	}

	/**
	 * @return Returns the rcv_spl.
	 */
	public int getRcvspl()
	{
		return rcv_spl;
	}

	/**
	 * @param rcv_spl
	 *            The rcv_spl to set.
	 */
	public void setRcvspl(int rcv_spl)
	{
		this.rcv_spl = rcv_spl;
	}

	/**
	 * @return Returns the rsfail.
	 */
	public int getRsfail()
	{
		return rsfail;
	}

	/**
	 * @param rsfail
	 *            The rsfail to set.
	 */
	public void setRsfail(int rsfail)
	{
		this.rsfail = rsfail;
	}

	/**
	 * @return Returns the splfail.
	 */
	public int getSplfail()
	{
		return splfail;
	}

	/**
	 * @param splfail
	 *            The splfail to set.
	 */
	public void setSplfail(int splfail)
	{
		this.splfail = splfail;
	}

	/**
	 * @return Returns the splsucc.
	 */
	public int getSplsucc()
	{
		return splsucc;
	}

	/**
	 * @param splsucc
	 *            The splsucc to set.
	 */
	public void setSplsucc(int splsucc)
	{
		this.splsucc = splsucc;
	}

	/**
	 * @return Returns the trkoos.
	 */
	public int getTrkoos()
	{
		return trkoos;
	}

	/**
	 * @param trkoos
	 *            The trkoos to set.
	 */
	public void setTrkoos(int trkoos)
	{
		this.trkoos = trkoos;
	}
	
	public void setAbr(double abr)
    {
    	this.abr = abr;
    }
    
    public double getAbr()
    {
    	return this.abr;
    }
    
    public void setAsr(double asr)
    {
    	this.asr = asr;
    }
    
    public double getAsr()
    {
    	return this.asr;
    }
}
