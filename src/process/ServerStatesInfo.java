package process;

import java.sql.Timestamp;

/**
 * NMS, OMS 서버의 정보를 담는 객체
 * Table Name SERVER_STATES
 * @author Sejin
 *
 */
public class ServerStatesInfo {
	private String equipmentid;
	private Timestamp collectionTime; 
	private float cpuUser;
	private float cpuKernel; 
	private float cpuIowait; 
	private float cpuSwap;
	private float cpuTot = -1;
	private long memPhys; 
	private long memFree; 
	private long memTotSwap; 
	private long memFreeSwap;
	private long memTot = -1;
	
	public Timestamp getCollectionTime() {
		return this.collectionTime;
	}
	public void setCollectionTime(Timestamp collectionTime) {
		this.collectionTime = collectionTime;
	}
	public float getCpuIowait() {
		return this.cpuIowait;
	}
	public void setCpuIowait(float cpuIowait) {
		this.cpuIowait = cpuIowait;
	}
	public float getCpuKernel() {
		return this.cpuKernel;
	}
	public void setCpuKernel(float cpuKernel) {
		this.cpuKernel = cpuKernel;
	}
	public float getCpuSwap() {
		return this.cpuSwap;
	}
	public void setCpuSwap(float cpuSwap) {
		this.cpuSwap = cpuSwap;
	}
	public float getCpuTot() {
		if ( this.cpuTot < 0 ) 
			this.cpuTot=this.cpuUser + this.cpuKernel + this.cpuIowait + this.cpuSwap;
		return this.cpuTot;
	}
	public void setCpuTot(float cpuTot) {
		this.cpuTot = cpuTot;
	}
	public float getCpuUser() {
		return this.cpuUser;
	}
	public void setCpuUser(float cpuUser) {
		this.cpuUser = cpuUser;
	}
	public String getEquipmentid() {
		return this.equipmentid;
	}
	public void setEquipmentid(String equipmentid) {
		this.equipmentid = equipmentid;
	}
	public long getMemFree() {
		return this.memFree;
	}
	public void setMemFree(long memFree) {
		this.memFree = memFree;
	}
	public long getMemFreeSwap() {
		return this.memFreeSwap;
	}
	public void setMemFreeSwap(long memFreeSwap) {
		this.memFreeSwap = memFreeSwap;
	}
	public long getMemPhys() {
		return this.memPhys;
	}
	public void setMemPhys(long memPhys) {
		this.memPhys = memPhys;
	}
	public void setMemTot(long memTot) {
		this.memTot = memTot;
	}
	public long getMemTot() {
		if ( memTot < 0 ) memTot = this.memPhys + this.memTotSwap - this.memFree - this.memFreeSwap;
		
		return this.memTot;
	}
	public long getMemTotSwap() {
		return this.memTotSwap;
	}
	public void setMemTotSwap(long memTotSwap) {
		this.memTotSwap = memTotSwap;
	}
	
	public String toString(){
		StringBuffer msg = new StringBuffer();
		msg.append("\n-----------------------------------------");
		msg.append("\nCPU User:"+getCpuUser());
		msg.append("\nCPU Kernel:"+getCpuKernel());
		msg.append("\nCPU Iowait:"+getCpuIowait());
		msg.append("\nCPU Swap:"+getCpuSwap());
		msg.append("\nCPU Tot:"+getCpuTot());
		msg.append("\nMemory Phys:"+getMemPhys());
		msg.append("\nMemory Free:"+getMemFree());
		msg.append("\nMemory TotSwap:"+getMemTotSwap());
		msg.append("\nMemory FreeSwap:"+getMemFreeSwap());
		msg.append("\nMemory Tot:"+memTot);
		msg.append("\n-----------------------------------------");
		return msg.toString();
	}
}
