public class trafficLight {

    String color;
    double light_status;

    public trafficLight(String color, double light_status) {

        this.color=color;
        this.light_status =light_status;
    }

    public void lightStatus() {

        if(light_status <(Math.random()*((1.8-10.5)+2.7))+9.8)
            this.color="Red";
        else
            this.color="Green";
    }
}
