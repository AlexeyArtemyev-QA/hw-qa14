import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

@Log4j2  // предоставляет объект log т.о. мы можем писаль не logger а log
public class CarTest {

    @Test
    public void carTest() {
        Logger logger1 = LogManager.getLogger("Сообщение с действием"); // создание логгера
        // уровни логирования и соответстующие им методы fatal (во встроеном логе этого типа нет), error, warn, info, debug, trace
        logger1.trace("trace Сообщение 1");
        logger1.debug("debug Сообщение 2");
        logger1.info("info Сообщение 3");
        logger1.error("error Сообщение 4");

        // c использованием аннотации @Log4j2 и у этого метода уже есть метод fatal
       log.trace("trace Сообщение 6");
       log.debug("debug Сообщение 7");
       log.info("info Сообщение 8");
       log.error("error Сообщение 9");
       log.fatal("fatal Сообщение 10");

        // по умолчанию все что выше error выводиться (error, fatal)
        // все что ниже error НЕ выводиться (trace, debug, info)

        Car car1 = new Car();
        car1.setMake("BMW"); // смотри класс Car из-за аннотации @Data (import lombok.Data;) мы можем не писать get и set меньшает кол-во кода
        car1.setModel("740");
        car1.setAcceleration(6);
        car1.setWeight(2000);

        Car car2 = new Car();
        car2.setModel("Nissan");
        car2.setMake("370z");
        car2.setAcceleration(5);
        car2.setWeight(1500);

        Assert.assertEquals(car1, car2);

        // другой вариант создания через аннотацию @Builder cм класс Car
        /* Car car3 = Car.builder()
                .make("Audi")
                .model("A4")
                .acceleration(7)
                .weight(1900)
                .build();
         */
    }
}
