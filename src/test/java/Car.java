import lombok.Data;

@Data
// @Builder вариант создания Audi см класс CatTest
public class Car {
    String make;
    String model;
    int acceleration;
    int weight;

}
