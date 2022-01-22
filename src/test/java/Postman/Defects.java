package Postman;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Defects {

    int total;
    int open;
}
