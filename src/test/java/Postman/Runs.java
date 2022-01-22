package Postman;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Runs {

    int total;
    int active;
}
