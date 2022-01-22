package Postman;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AllProjects {
    int count;
    int filtered;
    int total;
    Project [] entities;
}
