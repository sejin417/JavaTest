package string;

import java.io.Serializable;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

public class DistributionDiagram implements Serializable {
	private Hashtable<String,Vector<String>> _labelData;
	private Hashtable<String,Vector<String>> _linkData;
	private Hashtable<String,BcNSystem> _systemData;

	public DistributionDiagram(){
		_labelData = new Hashtable<String, Vector<String>>();
		_linkData = new Hashtable<String, Vector<String>>();
		_systemData = new Hashtable<String, BcNSystem>();
	}

	public int labelLength(){
		return _labelData.size();
	}
	
	public String[] getEquipmentList(){
		Enumeration enumeration = _systemData.elements();
		String[] result = new String[_systemData.size()];
		int i=0;
		while (enumeration.hasMoreElements()) {
			result[i] = ((BcNSystem)enumeration.nextElement()).getEquipmentID();
			i++;
		}

		return result;
	}
	
	public boolean isEquipment( String equipmentId ){
		BcNSystem system = _systemData.get(equipmentId);
		
		if ( system == null ){
			return false;
		}else {
			return true;
		}
	}

	public String[] getLabelList( int label ){
		Vector<String> labelData = _labelData.get(String.valueOf(label));

		//해당 Label 장비가 없으면 Null 리턴
		if ( labelData == null ){
			return null;
		} 

		String[] result = new String[labelData.size()];
		labelData.copyInto( result );
		return result;
	}

	public String[] getTargetList( String equipmentId ){
		Vector linkData = _linkData.get( equipmentId );

		//해당 equipmentid 의 장비가 없으면 Null 리턴
		if ( linkData == null ){
			return null;
		} 

		String[] result = new String[linkData.size()];
		linkData.copyInto( result );
		return result;
	}
	
	public BcNSystem getSystem(String equipmentId){
		return _systemData.get(equipmentId); 
	}
	
	public void setSystem(BcNSystem system){
		_systemData.put(system.getEquipmentID(), system);
	}

	public void setLink(String sourceEquipmentId, String targetEquipmentId, int label){

		Vector<String> sourceLabelData = _labelData.get( String.valueOf(label));
		Vector<String> targetLabelData = _labelData.get( String.valueOf(label+1));

		//Label 에  소스 데이타 입력
		if ( sourceLabelData == null ){
			sourceLabelData = new Vector<String>(5,2);
			sourceLabelData.add(sourceEquipmentId);

			_labelData.put(String.valueOf(label), sourceLabelData);
		} else {
			if ( !sourceLabelData.contains( sourceEquipmentId )){
				sourceLabelData.add(sourceEquipmentId);
			}
		}

		//Label 에  타겟 데이타 입력
		if ( targetLabelData == null ){
			targetLabelData = new Vector<String>(5,2);
			targetLabelData.add(targetEquipmentId);

			_labelData.put(String.valueOf(label+1), targetLabelData);
		} else {
			if ( !targetLabelData.contains( targetEquipmentId )){
				targetLabelData.add(targetEquipmentId);
			}			
		}
		
		//Link 데이타 입력
		Vector<String> linkData = _linkData.get( sourceEquipmentId );
		if ( linkData == null ){
			linkData = new Vector<String>(5,2);
			linkData.add(targetEquipmentId);

			_linkData.put(sourceEquipmentId, linkData);
		} else {
			if ( !linkData.contains( targetEquipmentId )){
				linkData.add(targetEquipmentId);
			}
		}
	}
	
	public String toString(){
		String[] list = getEquipmentList();
		
		if ( list == null ) return "NULL";
		
		StringBuffer result = new StringBuffer();
		
		for(int i=0;i<list.length;i++){
			result.append("\n Equipment["+i+"]::"+list[i]);
		}
		return result.toString();
	}
}
