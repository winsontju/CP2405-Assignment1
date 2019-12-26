public class Road {

    String name;
    int road_length;
    Car vehicle;

    trafficLight traffic_light;
    Road Road_to_Road;

    Object [] pavement;

    boolean traffic_arrive = false;

    public Road (String name, int road_length, Car vehicle, trafficLight trafficlight, Road Road_to_Road) {

        this.name=name;
        this.road_length =road_length;
        this.vehicle=vehicle;

        this.traffic_light =trafficlight;
        this.Road_to_Road = Road_to_Road;

        this.pavement =new Object[road_length];
        pavement[0]=vehicle;
        pavement[this.road_length -1]=trafficlight;
    }

    public void position_info(Car vehicle) {

        if(vehicle.position<this.road_length) {

            this.pavement[vehicle.position] = this.vehicle;
        }
        else if(vehicle.position==this.road_length){

            if(traffic_light.color.equalsIgnoreCase("Green")) {

                vehicle.position = 0;
                vehicle.current_car_position = Road_to_Road;
                traffic_arrive = true;
            }

            else {

                vehicle.position -= 1;
            }
        }
    }
}
