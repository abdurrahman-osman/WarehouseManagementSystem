package org.fimba.warehousemanagmentsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class WarehouseManagmentSystemApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(WarehouseManagmentSystemApiApplication.class, args);
    }

}
