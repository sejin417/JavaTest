package tokenizer;

import java.sql.Timestamp;
import java.util.StringTokenizer;

public class PremiumTest {
	String data = "20070705|13:50|SLSP02928|125.144.1.115|PSongpa-PEM115|ge-1/0/0.0|125.144.18.65|B|1441338|0|0|11238|158|158|0|0|38436|38|-.01|1494496|0|0|13148|182|182|0|0|39853|44|-.01";

	String data2 = "20070704|00:00|BSJG01308|125.144.1.49|PW.BuSI-PEM049|ge-1/0/0.0|125.144.18.85|B|14121" +
			"59|1612495|16945913|0|0|0|0|0|0|12712|14880|152547|197|212|2368|197|212|2367|0|1|1|0|" +
			"0|37657|43000|43|50|-.03|.06|425195|472155|5102339|0|0|0|0|0|0|2378|2630|28541|152|15" +
			"8|1821|152|158|1819|0|1|2|0|0|11339|12549|9|9|-.01|.15";

	public static void main(String[] args){
		PremiumTest test = new PremiumTest();
//		test.doTest2(test.data2);

		test.doTest(test.data);
	}

	public void doTest2(String readLine){
		StringTokenizer token = new java.util.StringTokenizer(readLine, "|");
		Timestamp collectionTime = makeTimestamp(token.nextToken(),token.nextToken());
		
		System.out.println(".setCollectionTime(collectionTime):" + collectionTime);
		System.out.println(".setLocationCode("+token.nextToken());
		System.out.println(".setMasterIp("+token.nextToken());
		System.out.println(".setEquipAlias("+token.nextToken());
		System.out.println(".setIfName("+token.nextToken());
		System.out.println(".setIfIp("+token.nextToken());
		System.out.println(".setIfUsgCode("+token.nextToken());
		System.out.println(".setInOctetsAvg("+Float.parseFloat(token.nextToken()));
		System.out.println(".setInOctetsMax("+Float.parseFloat(token.nextToken()));
		System.out.println(".setInOctetsSum("+Float.parseFloat(token.nextToken()));
		System.out.println(".setInDiscardsAvg("+Float.parseFloat(token.nextToken()));
		System.out.println(".setInDiscardsMax("+Float.parseFloat(token.nextToken()));
		System.out.println(".setInDiscardsSum("+Float.parseFloat(token.nextToken()));
		System.out.println(".setInErrorsAvg:"+Float.parseFloat(token.nextToken()));
		System.out.println(".setInErrorsMax:"+Float.parseFloat(token.nextToken()));
		System.out.println(".setInErrorsSum:"+Float.parseFloat(token.nextToken()));
		System.out.println(".setInUcastPktsAvg:"+Float.parseFloat(token.nextToken()));
		System.out.println(".setInUcastPktsMax:"+Float.parseFloat(token.nextToken()));
		System.out.println(".setInUcastPktsSum:"+Float.parseFloat(token.nextToken()));
		System.out.println(".setInNucastPktsAvg:"+Float.parseFloat(token.nextToken()));
		System.out.println(".setInNucastPktsMax:"+Float.parseFloat(token.nextToken()));
		System.out.println(".setInNucastPktsSum:"+Float.parseFloat(token.nextToken()));
		System.out.println(".setInMulticastPktsAvg:"+Float.parseFloat(token.nextToken()));
		System.out.println(".setInMulticastPktsMax:"+Float.parseFloat(token.nextToken()));
		System.out.println(".setInMulticastPktssum:"+Float.parseFloat(token.nextToken()));
		System.out.println(".setInBroadcastPktsAvg:"+Float.parseFloat(token.nextToken()));
		System.out.println(".setInBroadcastPktsMax:"+Float.parseFloat(token.nextToken()));
		System.out.println(".setInBroadcastPktsSum:"+Float.parseFloat(token.nextToken()));
		System.out.println(".setInIfUsageRateAvg:"+Float.parseFloat(token.nextToken()));
		System.out.println(".setInIfUsageRateMax:"+Float.parseFloat(token.nextToken()));
		System.out.println(".setInBpsAvg:"+Float.parseFloat(token.nextToken()));
		System.out.println(".setInBpsMax:"+Float.parseFloat(token.nextToken()));
		System.out.println(".setInPpsAvg:"+Float.parseFloat(token.nextToken()));
		System.out.println(".setInPpsMax:"+Float.parseFloat(token.nextToken()));
		System.out.println(".setInVariationRateAvg:"+Float.parseFloat(token.nextToken()));
		System.out.println(".setInVariationRateMax:"+Float.parseFloat(token.nextToken()));
		System.out.println(".setOutOctetsAvg:"+Float.parseFloat(token.nextToken()));
		System.out.println(".setOutOctetsMax:"+Float.parseFloat(token.nextToken()));
		System.out.println(".setOutOctetsSum:"+Float.parseFloat(token.nextToken()));
		System.out.println(".setOutDiscardsAvg:"+Float.parseFloat(token.nextToken()));
		System.out.println(".setOutDiscardsMax:"+Float.parseFloat(token.nextToken()));
		System.out.println(".setOutDiscardsSum:"+Float.parseFloat(token.nextToken()));
		System.out.println(".setOutErrorsAvg:"+Float.parseFloat(token.nextToken()));
		System.out.println(".setOutErrorsMax:"+Float.parseFloat(token.nextToken()));
		System.out.println(".setOutErrorsSum:"+Float.parseFloat(token.nextToken()));
		System.out.println(".setOutUcastPktsAvg:"+Float.parseFloat(token.nextToken()));
		System.out.println(".setOutUcastPktsMax:"+Float.parseFloat(token.nextToken()));
		System.out.println(".setOutUcastPktsSum:"+Float.parseFloat(token.nextToken()));
		System.out.println(".setOutNucastPktsAvg:"+Float.parseFloat(token.nextToken()));
		System.out.println(".setOutNucastPktsMax:"+Float.parseFloat(token.nextToken()));
		System.out.println(".setOutNucastPktsSum:"+Float.parseFloat(token.nextToken()));
		System.out.println(".setOutMulticastPktsAvg:"+Float.parseFloat(token.nextToken()));
		System.out.println(".setOutMulticastPktsMax:"+Float.parseFloat(token.nextToken()));
		System.out.println(".setOutMulticastPktsSum:"+Float.parseFloat(token.nextToken()));
		System.out.println(".setOutBroadcastPktsAvg:"+Float.parseFloat(token.nextToken()));
		System.out.println(".setOutBroadcastPktsMax:"+Float.parseFloat(token.nextToken()));
		System.out.println(".setOutBroadcastPktsSum:"+Float.parseFloat(token.nextToken()));
		System.out.println(".setOutIfUsageRateAvg:"+Float.parseFloat(token.nextToken()));
		System.out.println(".setOutIfUsageRateMax:"+Float.parseFloat(token.nextToken()));
		System.out.println(".setOutBpsAvg:"+Float.parseFloat(token.nextToken()));
		System.out.println(".setOutBpsMax:"+Float.parseFloat(token.nextToken()));
		System.out.println(".setOutPpsAvg:"+Float.parseFloat(token.nextToken()));
		System.out.println(".setOutPpsMax:"+Float.parseFloat(token.nextToken()));
		System.out.println(".setOutVariationRateAvg:"+Float.parseFloat(token.nextToken()));
		System.out.println(".setOutVariationRateMax:"+Float.parseFloat(token.nextToken()));
	}

//	public void doTest2(String readLine){
//		StringTokenizer token = new java.util.StringTokenizer(readLine, "|");
//		Timestamp collectionTime = makeTimestamp(token.nextToken(),token.nextToken());
//
//		System.out.println("(1, getCollectionTime())"+collectionTime );
//		System.out.println("(2, getLocationCode))"+token.nextToken());
//		System.out.println("(3, getMasterIp())"+token.nextToken());
//		System.out.println("(4, getEquipAlias())"+token.nextToken());
//		System.out.println("(5, getIfName())"+token.nextToken());
//		System.out.println("(6, getIfIp())"+token.nextToken());
//		System.out.println("(7, getIfUsgCode())"+token.nextToken());
//		System.out.println("(8, getInOctetsAvg())"+token.nextToken());
//		System.out.println("(9, getInOctetsMax())"+token.nextToken());
//		System.out.println("(10, getInOctetsSum())"+token.nextToken());
//		System.out.println("(11, getInDiscardsAvg())"+token.nextToken());
//		System.out.println("(12, getInDiscardsMax())"+token.nextToken());
//		System.out.println("(13, getInDiscardsSum())"+token.nextToken());
//		System.out.println("(14, getInErrorsAvg())"+token.nextToken());
//		System.out.println("(15, getInErrorsMax())"+token.nextToken());
//		System.out.println("(16, getInErrorsSum())"+token.nextToken());
//		System.out.println("(17, getInUcastPktsAvg())"+token.nextToken());
//		System.out.println("(18, getInUcastPktsMax())"+token.nextToken());
//		System.out.println("(19, getInUcastPktsSum())"+token.nextToken());
//		System.out.println("(20, getInNucastPktsAvg())"+token.nextToken());
//		System.out.println("(21, getInNucastPktsMax())"+token.nextToken());
//		System.out.println("(22, getInNucastPktsSum())"+token.nextToken());
//		System.out.println("(23, getInMulticastPktsAvg())"+token.nextToken());
//		System.out.println("(24, getInMulticastPktsMax())"+token.nextToken());
//		System.out.println("(25, getInMulticastPktssum())"+token.nextToken());
//		System.out.println("(26, getInBroadcastPktsAvg())"+token.nextToken());
//		System.out.println("(27, getInBroadcastPktsMax())"+token.nextToken());
//		System.out.println("(28, getInBroadcastPktsSum())"+token.nextToken());
//		System.out.println("(29, getInIfUsageRateAvg())"+token.nextToken());
//		System.out.println("(30, getInIfUsageRateMax())"+token.nextToken());
//		System.out.println("(31, getInBpsAvg())"+token.nextToken());
//		System.out.println("(32, getInBpsMax())"+token.nextToken());
//		System.out.println("(33, getInPpsAvg())"+token.nextToken());
//		System.out.println("(34, getInPpsMax())"+token.nextToken());
//		System.out.println("(35, getInVariationRateAvg())"+token.nextToken());
//		System.out.println("(36, getInVariationRateMax())"+token.nextToken());
//		System.out.println("(37, getOutOctetsAvg())"+token.nextToken());
//		System.out.println("(38, getOutOctetsMax())"+token.nextToken());
//		System.out.println("(39, getOutOctetsSum())"+token.nextToken());
//		System.out.println("(40, getOutDiscardsAvg())"+token.nextToken());
//		System.out.println("(41, getOutDiscardsMax())"+token.nextToken());
//		System.out.println("(42, getOutDiscardsSum())"+token.nextToken());
//		System.out.println("(43, getOutErrorsAvg())"+token.nextToken());
//		System.out.println("(44, getOutErrorsMax())"+token.nextToken());
//		System.out.println("(45, getOutErrorsSum())"+token.nextToken());
//		System.out.println("(46, getOutUcastPktsAvg())"+token.nextToken());
//		System.out.println("(47, getOutUcastPktsMax())"+token.nextToken());
//		System.out.println("(48, getOutUcastPktsSum())"+token.nextToken());
//		System.out.println("(49, getOutNucastPktsAvg())"+token.nextToken());
//		System.out.println("(50, getOutNucastPktsMax())"+token.nextToken());
//		System.out.println("(51, getOutNucastPktsSum())"+token.nextToken());
//		System.out.println("(52, getOutMulticastPktsAvg())"+token.nextToken());
//		System.out.println("(53, getOutMulticastPktsMax())"+token.nextToken());
//		System.out.println("(54, getOutMulticastPktsSum())"+token.nextToken());
//		System.out.println("(55, getOutBroadcastPktsAvg())"+token.nextToken());
//		System.out.println("(56, getOutBroadcastPktsMax())"+token.nextToken());
//		System.out.println("(57, getOutBroadcastPktsSum())"+token.nextToken());
//		System.out.println("(58, getOutIfUsageRateAvg())"+token.nextToken());
//		System.out.println("(59, getOutIfUsageRateMax())"+token.nextToken());
//		System.out.println("(60, getOutBpsAvg())"+token.nextToken());
//		System.out.println("(61, getOutBpsMax())"+token.nextToken());
//		System.out.println("(62, getOutPpsAvg())"+token.nextToken());
//		System.out.println("(63, getOutPpsMax())"+token.nextToken());
//		System.out.println("(64, getOutVariationRateAvg())"+token.nextToken());
//		System.out.println("(65, getOutVariationRateMax())"+token.nextToken());
//		System.out.println("(66, getIfName())"+token.nextToken());
//	}

	public void doTest(String readLine){
		StringTokenizer token = new java.util.StringTokenizer(readLine, "|");
		Timestamp collectionTime = makeTimestamp(token.nextToken(),token.nextToken());

		try
		{
			System.out.println("collectionTime:"+collectionTime); //1, 2
			System.out.println("setLocationCode:"+token.nextToken()); //3

			System.out.println("setMasterIp:"+token.nextToken()); //4
			System.out.println("setEquipAlias:"+token.nextToken()); //5
			System.out.println("setIfName:"+token.nextToken()); //6
			System.out.println("setIfIp:"+token.nextToken());  //7
			System.out.println("setIfUsgCode:"+token.nextToken()); //8
			System.out.println("setInOctetsAvg:"+Float.parseFloat(token.nextToken())); //9
			System.out.println("setInDiscardsAvg:"+Float.parseFloat(token.nextToken()));//10
			System.out.println("setInErrorsAvg:"+Float.parseFloat(token.nextToken()));//11
			System.out.println("setInUcastPktsAvg:"+Float.parseFloat(token.nextToken()));//12
			System.out.println("setInNucastPktsAvg:"+Float.parseFloat(token.nextToken()));//13
			System.out.println("setInMulticastPktsAvg:"+Float.parseFloat(token.nextToken()));//14
			System.out.println("setInBroadcastPktsAvg:"+Float.parseFloat(token.nextToken()));//15
			System.out.println("setInIfUsageRateAvg:"+Float.parseFloat(token.nextToken()));//16
			System.out.println("setInBpsAvg:"+Float.parseFloat(token.nextToken()));//17
			System.out.println("setInPpsAvg:"+Float.parseFloat(token.nextToken()));//18
			System.out.println("setInVariationRateAvg:"+Float.parseFloat(token.nextToken()));//19
			System.out.println("setOutOctetsAvg:"+Float.parseFloat(token.nextToken()));//20
			System.out.println("setOutDiscardsAvg:"+Float.parseFloat(token.nextToken()));//21
			System.out.println("setOutErrorsAvg:"+Float.parseFloat(token.nextToken()));//22
			System.out.println("setOutUcastPktsAvg:"+Float.parseFloat(token.nextToken()));//23
			System.out.println("setOutNucastPktsAvg:"+Float.parseFloat(token.nextToken()));//24
			System.out.println("setOutMulticastPktsAvg:"+Float.parseFloat(token.nextToken()));//25
			System.out.println("setOutBroadcastPktsAvg:"+Float.parseFloat(token.nextToken()));//26
			System.out.println("setOutIfUsageRateAvg:"+Float.parseFloat(token.nextToken()));//27
			System.out.println("setOutBpsAvg:"+Float.parseFloat(token.nextToken()));//28
			System.out.println("setOutPpsAvg:"+Float.parseFloat(token.nextToken()));//29
			System.out.println("setOutVariationRateAvg:"+Float.parseFloat(token.nextToken()));//30
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private java.sql.Timestamp makeTimestamp(String d, String t)
	{
		StringBuffer buf = new StringBuffer();
		try
		{
			buf.append(d.substring(0,4)).append("-");
			buf.append(d.substring(4,6)).append("-");
			buf.append(d.substring(6,8)).append(" ");
			buf.append(t).append(":00");
			return Timestamp.valueOf(buf.toString());
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("ERROR-날짜/시간-->Timestamp 변환중 ERROR : "+e.getMessage()+"==>DATE:"+d+",TIME:"+t);
			return null;
		}
	}
}
