import java.util.ArrayList;

public class Notebook {

	private boolean isWireless;
	private double CPUFrequency;
	private double HDMemory;
	private boolean isTurnedOn;
	private int CPUNumber;
	private int networkComps;
	//default
	public Notebook(){
		
	}
	//common usage
	public Notebook(boolean isWirelessOn,double cpuFrequency,double hdMemory,boolean isOn,int cpuNumber){
		isWireless=isWirelessOn;
		CPUFrequency=cpuFrequency;
		HDMemory=hdMemory;
		isTurnedOn=isOn;
		CPUNumber=cpuNumber;
	}
	//copy constructor
	public Notebook(Notebook notebook){
		this(notebook.isWireless,notebook.CPUFrequency,notebook.HDMemory,notebook.isTurnedOn,notebook.CPUNumber);
	}
	public double getCPUNumber(){
		return CPUNumber;
	}
	
	public void setCPUNumber(int cpuNumber){
		CPUNumber=cpuNumber;
	}
	
	public boolean getCondition() {
		return isTurnedOn;
	}
	public void setCondition(boolean condition) {
		isTurnedOn = condition;
	}
	public int getNetworkComps() {
		return networkComps;
	}
	public void setNetworkComps(ArrayList<Notebook> notebooks) {
		for (Notebook temp : notebooks) {
			if(temp.isWireless)
				networkComps++;
		}
	}
}
