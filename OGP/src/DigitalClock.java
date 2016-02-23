
public class DigitalClock {
	public int hours;
	public int minutes;
	public int maxHours;
	public int minHours;
	
	public DigitalClock(){
		this.setHours(0);
		this.setMinutes(0);
		this.setMaxHours(24);
		this.setMinHours(0);
	}
	
	public DigitalClock(int hours, int minutes, int maxHours, int minHours){
		this.setMaxHours(maxHours);
		this.setMinHours(minHours);
		this.setHours(hours);
		this.setMinutes(minutes);
	}
	
	public int getHours(){
		return this.hours;
	}
	
	public int getMinutes(){
		return this.minutes;
	}
	
	public void setMaxHours(int maxHours){
		this.maxHours = maxHours;
	}
	
	public void setMinHours(int minHours){
		this.minHours = minHours;
	}
	
	public void setHours(int hours){
		if (hours < this.minHours){
			this.hours = 0;
		}
		else if (hours >= this.maxHours){
			this.hours = hours % this.maxHours;
		}
		else this.hours = hours;
	}
	
	public void setMinutes(int minutes){
		if (minutes < 0){
			this.minutes = Math.abs(minutes) % 60;
		}
		else if (minutes >= 60){
			this.minutes = minutes % 60;
		}
		else this.minutes = minutes;
	}
}
