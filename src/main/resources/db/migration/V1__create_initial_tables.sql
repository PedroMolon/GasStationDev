CREATE TABLE gastations (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE fuels (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    price DECIMAL(10, 2) NOT NULL
);

CREATE TABLE pumps (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    gas_station_id BIGINT NOT NULL,
    fuel_id BIGINT NOT NULL,
    CONSTRAINT fk_pump_gas_station FOREIGN KEY (gas_station_id) REFERENCES gastations(id),
    CONSTRAINT fk_pump_fuel FOREIGN KEY (fuel_id) REFERENCES fuels(id)
);

CREATE TABLE supplies (
    id BIGSERIAL PRIMARY KEY,
    pump_id BIGINT NOT NULL,
    date TIMESTAMP NOT NULL,
    quantity DOUBLE PRECISION NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    CONSTRAINT fk_supply_pump FOREIGN KEY (pump_id) REFERENCES pumps(id)
);
