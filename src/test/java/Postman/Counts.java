package Postman;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Counts {

    int cases;
    int suites;
    int milestones;
    Runs runs;
    Defects defects;

}
