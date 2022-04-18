public class User {

    private String name;
    private long workingHours;
    private long workedHoursTotal;
    private long overHours;
    private long clockInTime;
    private long clockOutTime;

    User(){}

    User(String name){
        this.name = name;
    }







    // getters and setters below -m
    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setWorkingHours(long workingHours) {
        this.workingHours = workingHours;
    }

    public long getWorkingHours(){
        return workingHours;
    }

    public void setOverHours(long overHours){
        this.overHours = overHours;
    }

    public long getOverHours() {
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

    public long getWorkedHoursTotal() {
        return workedHoursTotal;
    }

    public void setWorkedHoursTotal(long workedHoursTotal) {
        this.workedHoursTotal = workedHoursTotal;
    }

}
