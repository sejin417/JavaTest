package pm;
public class ScopeInfoBean {

	private String scopeName		= "";
	private int scopeIndex			= 0;
	private int scopeClass			= 0;
	private String locationCode		= "";
	private String stackModuleNum	= "";

	public ScopeInfoBean() {}
	public ScopeInfoBean(String scopeName, int scopeIndex, int scopeClass, String locationCode, String stackModuleNum) {
		this.scopeName = scopeName;
		this.scopeIndex = scopeIndex;
		this.scopeClass = scopeClass;
		this.locationCode = locationCode;
		this.stackModuleNum = stackModuleNum;
	}

	//setter
	public void setScopeName (String scopeName){
		this.scopeName = scopeName;
	}
    public void setScopeIndex (int scopeIndex){
		this.scopeIndex = scopeIndex;
	}
    public void setScopeClass (int scopeClass){
		this.scopeClass = scopeClass;
	}
    public void setLocationCode (String locationCode){
		this.locationCode = locationCode;
	}
    public void setStackModuleNum (String stackModuleNum){
		this.stackModuleNum = stackModuleNum;
	}

	//getter
	public String getScopeName(){
 		return scopeName; 
 	}
	public String getScopeIndex(){
 		return String.valueOf( scopeIndex );
 	}	
	public String getScopeClass(){
 		return String.valueOf( scopeClass );
 	}
	public String getLocationCode(){
 		return locationCode;
 	}
	public String getStackModuleNum(){
 		return stackModuleNum;
 	}
}