public class Car {

    String name;
    int position;
    Road current_car_position;

    public Car(String name, int position, Road current_car_position) {

        this.name = name;
        this.position = position;
        this.current_car_position = current_car_position;
    }

    public void movement() {

        this.position += 1;
    }
}