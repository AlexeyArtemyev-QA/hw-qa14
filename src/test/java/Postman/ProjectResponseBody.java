package Postman;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProjectResponseBody <T>{

    boolean status;
    T result;
}
