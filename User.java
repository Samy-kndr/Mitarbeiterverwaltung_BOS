public class User {

    private String name;
    private int workingHours;
    private int overHours;
    private long clockInTime;
    private long clockOutTime;

    User(){}

    User(String name){
        this.name = name;
    }







    // getters and setters below -MF
    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setWorkingHours(int workingHours) {
        this.workingHours = workingHours;
    }

    public int getWorkingHours(){
        return workingHours;
    }

    public void setOverHours(int overHours){
        this.overHours = overHours;
    }

    public int getOverHours() {
        return overHours;
    }

    public long getClockInTime() {
        return clockInTime;
    }

    public void setClockInTime(long clockInTime) {
        this.clockInTime = clockInTime;
    }

    public long getClockOutTime() {
        return clockOutTime;
    }

    public void setClockOutTime(long clockOutTime) {
        this.clockOutTime = clockOutTime;
    }

}
