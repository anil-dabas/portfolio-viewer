drop table if exists Security_Definition;
drop table if exists stock;

CREATE TABLE stock (
  id VARCHAR(255) PRIMARY KEY,
  name VARCHAR(255),
  code VARCHAR(255),
  day_start_price DOUBLE,
  expected_return DOUBLE,
  volatility DOUBLE
);


insert into stock (id, code, name, day_start_price,expected_return,volatility) values (1, 'TSLA', 'Tesla Inc.', 400.0,0.1,0.2);
insert into stock (id, code, name, day_start_price,expected_return,volatility) values (2, 'AAPL', 'Apple', 110.0,0.4,0.1);
insert into stock (id, code, name, day_start_price,expected_return,volatility) values (3, 'MSFT', 'Microsoft', 300.0,0.2,0.3);




CREATE TABLE Security_Definition (
  id VARCHAR(255) PRIMARY KEY,
  code VARCHAR(255),
  name VARCHAR(255),
  type VARCHAR(5),
  volatility DOUBLE,
  strike_price DOUBLE,
  maturity DATE
);

insert into Security_Definition (id, code, name, type,volatility,strike_price,maturity) values (3, 'TSLA-OCT-24-19-400-C', 'Tesla Options', 'CALL',0.3,400.0,'2024-10-19');
insert into Security_Definition (id, code, name, type,volatility,strike_price,maturity) values (5, 'TSLA-DEC-24-19-400-P', 'Tesla Inc Options', 'PUT',0.1,400.0,'2024-12-19');
insert into Security_Definition (id, code, name, type,volatility,strike_price,maturity) values (4, 'AAPL-DEC-24-19-110-C', 'Apple Inc Options.','CALL',0.1,110.0,'2024-12-19');
insert into Security_Definition (id, code, name, type,volatility,strike_price,maturity) values (6, 'AAPL-OCT-24-19-110-P', 'Apple Inc Options','PUT',0.3,110.0,'2024-10-19');


